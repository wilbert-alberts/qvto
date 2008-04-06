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
package org.eclipse.m2m.internal.qvt.oml.common.project;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.IEditableModel;
import org.eclipse.pde.core.IModel;
import org.eclipse.pde.core.build.IBuildEntry;
import org.eclipse.pde.core.build.IBuildModel;
import org.eclipse.pde.core.build.IBuildModelFactory;
import org.eclipse.pde.core.plugin.IPlugin;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginModel;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.TargetPlatformHelper;


public class PluginUtil {
    private PluginUtil() {}
    
    public static ModelHelper<IPluginModel> getModel(IProject project) throws MdaException {
        IFile pluginXmlFile = getModelFile(project);
        if(!pluginXmlFile.exists()) {
        	createModelFile(pluginXmlFile);
        }
        
        ModelHelper<IPluginModel> model = createPluginModel(pluginXmlFile);
        try {
			model.model().load();
		} catch (CoreException e) {
			throw new MdaException(e);
		}
        if(!model.model().isLoaded()) {
            throw new MdaException(NLS.bind(Messages.PluginUtil_PluginModelLoadError, pluginXmlFile));
        }

        return model;
    }
    
    public static IPlugin getPlugin(IProject project) throws MdaException {
        return getModel(project).model().getPlugin();
    }
    
    private static void createModelFile(IFile file) {
    	ModelHelper<IPluginModel> model = createPluginModel(file);
		
        IPluginBase pluginBase = model.model().getPluginBase(true);
		try {
			pluginBase.setSchemaVersion(TargetPlatformHelper.getTargetVersion() < 3.2 ? "3.0" : "3.2"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		catch (CoreException ignore) {
		}
		
		model.save();
    }
    
    private static IFile getModelFile(IProject project) {
        IPath manifestPath = project.getFullPath().append("plugin.xml"); //$NON-NLS-1$
        IFile file = project.getWorkspace().getRoot().getFile(manifestPath);
        return file;
    }
    
    public static void addPluginNature(IProject project) throws CoreException {
        NatureUtils.addNature(project, PDE_NATURE);
    }     

	public static ModelHelper<IPluginModel> createPluginModel(IFile file) {
		return new ModelHelper<IPluginModel>(new org.eclipse.pde.internal.core.plugin.WorkspacePluginModel(file, false));
	}
    	
    public static IPluginModelBase findPluginModelByProject(IProject project) {
		return PDECore.getDefault().getModelManager().findModel(project);
	}

	public static IPluginModelBase findPluginModelByID(String importID) {
		return PDECore.getDefault().getModelManager().findModel(importID);
	}
      
    
    public static String makeId(String name) {
        StringBuffer id = new StringBuffer();
        for(int i = 0, len=name.length(); i < len; i++) {
            char ch = name.charAt(i);
            
            if ((ch < 'A' || 'Z' < ch) && (ch < 'a' || 'z' < ch)
                    && (ch < '0' || '9' < ch) && ch != '_') {
                if (i == 0 || i == name.length() - 1 || ch != '.') {
                    ch = '_';
                }
            }
            
            id.append(ch);
        }
        return id.toString();
    }
    
    private static String getLibraryName(String projectName) {
        int lastDot = projectName.lastIndexOf("."); //$NON-NLS-1$
        String libraryName;
        if(lastDot != -1) {
            libraryName = projectName.substring(lastDot+1);
        }
        else {
            libraryName = projectName;
        }
        
        return libraryName + ".jar"; //$NON-NLS-1$
    }
    
    private static void createBuildPropertiesFile(IFile file) throws CoreException {
        ModelHelper<IBuildModel> model = new ModelHelper<IBuildModel>(new org.eclipse.pde.internal.core.build.WorkspaceBuildModel(file));
        IBuildModelFactory factory = model.model().getFactory();
        IBuildEntry binEntry = factory.createEntry(IBuildEntry.BIN_INCLUDES);
        binEntry.addToken("plugin.xml"); //$NON-NLS-1$
        String libraryName = getLibraryName(file.getProject().getName());
        binEntry.addToken(libraryName);

        IBuildEntry entry = factory.createEntry(IBuildEntry.JAR_PREFIX + libraryName);
        IJavaProject javaProject = JavaCore.create(file.getProject());
        String srcFolder = getSourceFolderName(javaProject);
        if (srcFolder.length() > 0) {
            entry.addToken(new Path(srcFolder).addTrailingSeparator() .toString());
        }
        else {
            entry.addToken("."); //$NON-NLS-1$
        }
        
        model.model().getBuild().add(entry);
        entry = factory.createEntry(IBuildEntry.OUTPUT_PREFIX + libraryName);
        String outputFolder = getOutputFolderName(javaProject);
        if (outputFolder.length() > 0) {
            entry.addToken(new Path(outputFolder).addTrailingSeparator().toString());
        }
        else {
            entry.addToken("."); //$NON-NLS-1$
        }
        
        model.model().getBuild().add(entry);

        model.model().getBuild().add(binEntry);
        model.save();
    }
    
    private static String getSourceFolderName(IJavaProject javaProject) {
        try {
            return JavaProjectUtil.getSourceFolderName(javaProject).toOSString();
        }
        catch(Exception e) {
            return ""; //$NON-NLS-1$
        }
    }
    
    private static String getOutputFolderName(IJavaProject javaProject) {
        try {
            return JavaProjectUtil.getOutputFolderName(javaProject).toOSString();
        }
        catch(Exception e) {
            return ""; //$NON-NLS-1$
        }
    }

    public static final String PDE_NATURE = "org.eclipse.pde.PluginNature"; //$NON-NLS-1$
    
    
    public static class ModelHelper<T extends IModel> {
    	private T model;
    	
    	public ModelHelper(T wrappedModel) {
    		assert wrappedModel != null;
    		this.model = wrappedModel;
    	}
    	
    	public T model() {
    		return model;
    	}
    	
    	public void save() {
    		if(model instanceof IEditableModel) {
    			IEditableModel em = (IEditableModel)model;
    			em.save();    			
    		}
    	}
    }    
}
