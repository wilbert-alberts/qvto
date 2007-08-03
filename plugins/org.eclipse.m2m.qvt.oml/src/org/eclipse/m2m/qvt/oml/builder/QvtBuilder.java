/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.m2m.qvt.oml.QvtEngine;
import org.eclipse.m2m.qvt.oml.QvtMessage;
import org.eclipse.m2m.qvt.oml.QvtPlugin;
import org.eclipse.m2m.qvt.oml.common.Logger;
import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.common.io.FileUtil;
import org.eclipse.m2m.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.qvt.oml.emf.util.urimap.MetamodelURIMappingHelper;
import org.eclipse.ui.texteditor.MarkerUtilities;



/**
 * @author pfeldman
 */
public class QvtBuilder extends IncrementalProjectBuilder {
    
	public static final String ID = "org.eclipse.m2m.qvt.oml.QvtBuilder";//$NON-NLS-1$

    public QvtBuilder() {
    }
    
    public interface BuildListener {
        void buildPerformed();
    }
    
    
    @Override
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {        
        if (kind == IncrementalProjectBuilder.FULL_BUILD) {
            fullBuild(monitor);
        } else {
            incrementalBuild(monitor);
        }
        
        fireBuildEvent();
        
        return getConfig().getProjectDependencies(true);
    }
    
    private void fullBuild(IProgressMonitor monitor) throws CoreException {
        rebuildAll(monitor);
    }
    
    @Override
	protected void clean(final IProgressMonitor monitor) throws CoreException {        
        
    	getProject().accept(new IResourceProxyVisitor() {
			public boolean visit(IResourceProxy proxy) throws CoreException {
				if (proxy.getType() == IResource.FILE) {
					if (MDAConstants.QVTO_FILE_EXTENSION.equals(proxy.requestFullPath().getFileExtension())) {
						proxy.requestResource().deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
					}
					return false;
				}
				return true;
			}
    		
    	}, IContainer.INCLUDE_TEAM_PRIVATE_MEMBERS);
    }
    
    void deleteContainersToLevel(final IContainer from, final IContainer level, final IProgressMonitor monitor) throws CoreException {
		if(!from.exists()) {
			return;
		}
		
        if (from.getParent() == level) {
            return;
        }
        if (from.getParent() != null && from.getParent().getParent() == level) {
            if (from.exists()) {
                from.delete(true, monitor);
            }
        } else {
            IContainer parent = from.getParent();
            if (parent.members().length == (from.exists() ? 1 : 0)) {  
                deleteContainersToLevel(parent, level, monitor);
            }
        }
    }
    
    
    private void incrementalBuild(IProgressMonitor monitor) throws CoreException {
    	boolean needsRebuild = hasQVTModification(getProject());
    	if(!needsRebuild) {
    		IProject[] referencedProjects = getConfig().getProjectDependencies(true);
    		for (int i = 0; i < referencedProjects.length; i++) {
				IProject refProject = referencedProjects[i];
				needsRebuild = !refProject.isAccessible() || hasQVTModification(refProject);
				if(needsRebuild) {
					break;
				}
			}    		
    	}

        if(needsRebuild) {
            rebuildAll(monitor);
        }
    }
    
    private boolean hasQVTModification(final IProject project) throws CoreException {
    	IResourceDelta delta = getDelta(project);

        final boolean[] rebuild = { false };
        if (delta != null) {
            delta.accept(new IResourceDeltaVisitor() {
                public boolean visit(IResourceDelta delta) throws CoreException {
                	if((delta.getFlags() & IResourceDelta.MOVED_FROM) != 0) {
                		if(IResource.FOLDER == delta.getResource().getType()) {
                			// update QVT source container if its folder is moved
                			IContainer srcContainer = QvtBuilderConfig.getConfig(project).getSourceContainer();
                			if(delta.getMovedFromPath().equals(srcContainer.getFullPath())) {
                				try {			
                					QvtBuilderConfig config = QvtBuilderConfig.getConfig(project);
                					config.setSourceContainer((IFolder)delta.getResource());
                					config.save();
                				} catch (CoreException e) {
									QvtPlugin.log(e.getStatus());
								}
                			}
                		}   		
                	}
                	
                	if(delta.getResource().getType() == IResource.FILE) {
	                    IPath projectRelativePath = delta.getResource().getProjectRelativePath();
	                    if(".project".equals(projectRelativePath.toString()) || //$NON-NLS-1$
	                    	"plugin.xml".equals(projectRelativePath.toString()) || //$NON-NLS-1$
	                    	"META-INF/MANIFEST.MF".equals(projectRelativePath.toString())) { //$NON-NLS-1$
	                        rebuild[0] = true;
	                        return false;                    	
	                    }
	                    if (MDAConstants.QVTO_FILE_EXTENSION.equals(projectRelativePath.getFileExtension())) {
	                        rebuild[0] = true;
	                        return false;
	                    }
	                    
	                    IFile mappingsFile = MetamodelURIMappingHelper.getMappingFileHandle(project);
	                    if(mappingsFile != null && mappingsFile.exists() && projectRelativePath.equals(mappingsFile.getProjectRelativePath())) {
	                        rebuild[0] = true;
	                        return false;                    	
	                    }
	                    
	                    String fileNameExt = delta.getResource().getProjectRelativePath().getFileExtension();
	                    if("ecore".equals(fileNameExt)) { //$NON-NLS-1$
	                        rebuild[0] = true;
	                        return false;
	                    }
                	}
                    
                    return true;
                }
            });
        }
        return rebuild[0];
    }
    
    private void rebuildAll(IProgressMonitor monitor) throws CoreException {
        IFile[] files = collectFiles();
        CompiledModule[] modules;
		try {
			modules = QvtEngine.getInstance(getProject()).compile(files, null);
            QvtEngine.getInstance(getProject()).getCompiler(); // TODO
		} 
		catch (Exception e) {
			throw new CoreException(QvtPlugin.createErrorStatus(e));
		}
		
        List<CompiledModule> cleanModules = new ArrayList<CompiledModule>();
        for (int i = 0; i < modules.length; i++) {
            CompiledModule module = modules[i];
            QvtMessage[] messages = module.getMessages();
            EclipseFile source = (EclipseFile) module.getSource();
            IFile curFile = source.getFile();
            
            curFile.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
            if (module.getErrors().length == 0) {
                cleanModules.add(module);
            }
            for (int j = 0; j < messages.length; j++) {
                QvtMessage e = messages[j];
                createQvtMarker(curFile, e);
            }
        }
    }
        
    private void createQvtMarker(IFile curFile, QvtMessage e) {
        Map<String, Integer> attributes = new HashMap<String, Integer>();
        MarkerUtilities.setCharStart(attributes, e.getOffset());
        MarkerUtilities.setCharEnd(attributes, e.getOffset() + e.getLength());
        MarkerUtilities.setMessage(attributes, e.getMessage());
        attributes.put(IMarker.SEVERITY, new Integer(e.getSeverity()));
        try {
            IMarker marker = curFile.createMarker(QvtCompiler.PROBLEM_MARKER);
            marker.setAttributes(attributes);
        }
        catch (CoreException e1) {
            Logger.getLogger().log(Logger.WARNING, "QvtBuilder: failed to create marker", e1);//$NON-NLS-1$
        }                   
    }


    private QvtBuilderConfig getConfig() throws CoreException {
        if (myConfig == null) {
            myConfig = QvtBuilderConfig.getConfig(getProject());            
        }
        return myConfig;
    }
    
    private IFile[] collectFiles() throws CoreException {
        final ArrayList<IFile> result = new ArrayList<IFile>();
        getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
        
        IContainer srcContainer = null;
        try {
        	srcContainer = QvtBuilderConfig.getConfig(getProject()).getSourceContainer();
        } catch (CoreException e) {
        	QvtPlugin.log(e.getStatus());
		}
        
        if(srcContainer == null || !srcContainer.exists()) {
        	return new IFile[0];
        }
        
        srcContainer.accept(new IResourceProxyVisitor() {
            public boolean visit(IResourceProxy proxy) throws CoreException {
                if(proxy.getType() == IResource.FILE) {
                    if(!MDAConstants.QVTO_FILE_EXTENSION.equals(proxy.requestFullPath().getFileExtension())) {
                        return false;
                    }
                    IFile file = (IFile) proxy.requestResource();
                    result.add(file);
                    return false;
                }
                return true;
            }
        }, IContainer.INCLUDE_TEAM_PRIVATE_MEMBERS);
        
        return (IFile[]) result.toArray(new IFile[result.size()]);
    }
    
    public static String getFileContents(IFile file) {
    	try {
    		return FileUtil.getStreamContents(file.getContents(), file.getCharset());
    	}
    	catch(Exception e) {
    		return ""; //$NON-NLS-1$
    	}
    }
    
    public static void addBuildListener(final BuildListener l) {
        ourListeners.add(l);
    }
    
    public static void removeBuildListener(final BuildListener l) {
        ourListeners.remove(l);
    }
    
    
    private static void fireBuildEvent() {
        for (Iterator it = ourListeners.iterator(); it.hasNext(); ) {
            BuildListener l = (BuildListener)it.next();
            l.buildPerformed();
        }
    }
    
    
    private static final List<BuildListener> ourListeners = new Vector<BuildListener>();
    private QvtBuilderConfig myConfig;
    private IJavaProject myJavaProject;
    
}
