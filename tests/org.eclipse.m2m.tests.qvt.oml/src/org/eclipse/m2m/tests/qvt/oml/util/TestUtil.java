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
package org.eclipse.m2m.tests.qvt.oml.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.m2m.internal.qvt.oml.common.io.FileUtil;
import org.eclipse.m2m.tests.qvt.oml.RuntimeWorkspaceSetup;
import org.eclipse.m2m.tests.qvt.oml.TestProject;
import org.osgi.framework.Bundle;

/**
 * @author vrepeshko
 */
public class TestUtil extends Assert {
	
	public static final String BUNDLE = "org.eclipse.m2m.tests.qvt.oml"; //$NON-NLS-1$

	private TestUtil() {}
	
	public static void turnOffAutoBuilding() throws CoreException {
		IWorkspaceDescription workspaceDescription = ResourcesPlugin.getWorkspace().getDescription();
        workspaceDescription.setAutoBuilding(false);
        ResourcesPlugin.getWorkspace().setDescription(workspaceDescription);
	}
	
	public static void copyFolder(final IProject project, final String folderName) throws Exception {
		File sourceFolder = getPluginRelativeFolder(folderName);
		File destFolder = new File(project.getLocation().toString());
		FileUtil.copyFolder(sourceFolder, destFolder);
//		System.out.println("source: " + sourceFolder.getAbsolutePath());
//		System.out.println("dest: " + destFolder.getAbsolutePath());
		project.refreshLocal(IResource.DEPTH_INFINITE, null);
	}
	
	public static File getPluginRelativeFolder(final String folderName) throws IOException {
        return getPluginRelativeFile(BUNDLE, folderName);
	}
	
	public static File getPluginRelativeFile(final String file) throws IOException {
        return getPluginRelativeFile(BUNDLE, file);
	}
    
    public static File getPluginRelativeFile(String plugin, String folderName) throws IOException {
        Bundle bundle = Platform.getBundle(plugin);
        
        URL url = bundle.getEntry(folderName);
        if(url == null) {
            throw new RuntimeException("File " + folderName + " not found in " + plugin); //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        File file = new File(FileLocator.toFileURL(url).getPath()).getCanonicalFile();
        return file;
    }
	
	public static void deleteJavaFiles(final IProject project) throws CoreException {
	    IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
	        public void run(IProgressMonitor monitor) throws CoreException {
                final List<IFile> filesToDelete = new ArrayList<IFile>();
                
	            project.accept(new IResourceVisitor() {
	                public boolean visit(final IResource resource) {
	                    if(resource.getType() == IResource.FILE) {
	                        String extension = resource.getFileExtension();
	                        if("java".equals(extension) || "class".equals(extension)) { //$NON-NLS-1$ //$NON-NLS-2$
	                            IFile file = (IFile) resource;
	                            filesToDelete.add(file);
	                        }
	                        return false;
	                    }
	                    return true;
	                }
	            });
                
                for (Iterator iter = filesToDelete.iterator(); iter.hasNext();) {
                    IFile file = (IFile) iter.next();
                    try {
                        file.delete(true, null);
                    }
                    catch(Exception e) {}
                }
	        }
	    };
	    
	    project.getWorkspace().run(runnable, null);
	}

	public static void buildProject(final IProject project) throws CoreException {
	    buildProject(project, IncrementalProjectBuilder.FULL_BUILD);
	}
    
    public static void buildProject(final IProject project, final int kind) throws CoreException {
		project.build(kind, null);
        List errors = getBuildErrors(project);
        assertTrue("Build failed for " + project + ": " + errors, errors.isEmpty()); //$NON-NLS-1$ //$NON-NLS-2$
    }
	
	public static List<String> getBuildErrors(final IProject project) throws CoreException {
		IMarker[] markers = project.findMarkers(
//				IJavaModelMarker.JAVA_MODEL_PROBLEM_MARKER, false,
                IMarker.PROBLEM, true,
				IResource.DEPTH_INFINITE);
		List<String> errors = new ArrayList<String>();
		for(int i = 0; i < markers.length; i++) {
			IMarker marker = markers[i];
			if(RuntimeWorkspaceSetup.getInstance().getIsDevLaunchMode() &&
				"plugin.xml".equals(marker.getResource().getName()) && //$NON-NLS-1$ 
				marker.getResource().getParent() == project) {
				continue;
			}
			if(marker.getAttribute(IMarker.SEVERITY, 0) == IMarker.SEVERITY_ERROR) {
				String message = marker.getResource().getName() + 
					" " + marker.getAttribute(IMarker.LINE_NUMBER, "") +  //$NON-NLS-1$ //$NON-NLS-2$
					": " + marker.getAttribute(IMarker.MESSAGE, "") + //$NON-NLS-1$ //$NON-NLS-2$
					" " + marker.getAttribute(IMarker.LOCATION, "");  //$NON-NLS-1$ //$NON-NLS-2$
				errors.add(message);
				System.err.println(message);
			}
		}
		
		return errors;
	}
	
	public static IProject openExistingProject(final String path) throws CoreException {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
//		IPath projectPath = new Path(path);
		IPath descriptionPath = new Path(path + File.separator + ".project"); //$NON-NLS-1$
		IProjectDescription projectDesc = workspace.loadProjectDescription(descriptionPath);
		String projectName = projectDesc == null ? null : projectDesc.getName();
		IProject project = workspace.getRoot().getProject(projectName);
		
		if (project.exists() && project.isOpen()) {
			return project;
		}
		
		if (projectDesc == null) {
			projectDesc = workspace.newProjectDescription(projectName);
			if (Platform.getLocation().isPrefixOf(descriptionPath)) {
				projectDesc.setLocation(null);
			} else {
				projectDesc.setLocation(descriptionPath);
			}
		}  else {
			projectDesc.setName(projectName);
		}
		
		try {
			project.create(projectDesc, null);
			project.open(null);
		} catch(CoreException e) {
			e.printStackTrace();
			throw e;
		}
		
		return project;
	}
    
    public static void addProject(TestProject testProject, String path) throws Exception {
        String location = TestUtil.getPluginRelativeFolder(path).getAbsolutePath();
        IProject project = TestUtil.openExistingProject(location);
        TestUtil.buildProject(project);
        testProject.addWorkspaceProject(project);
    }    
	
}
