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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.m2m.internal.qvt.oml.common.project.PluginUtil;
import org.eclipse.m2m.internal.qvt.oml.common.project.PluginUtil.ModelHelper;
import org.eclipse.pde.core.build.IBuildEntry;
import org.eclipse.pde.core.build.IBuildModel;
import org.eclipse.pde.core.build.IBuildModelFactory;
import org.eclipse.pde.core.plugin.IPlugin;
import org.eclipse.pde.core.plugin.IPluginLibrary;
import org.eclipse.pde.core.plugin.IPluginModel;



public class ConvertProjectUtil {
    private ConvertProjectUtil() {}
              
    
    public static void convertToPluginProject(IProject project, IProgressMonitor progressMonitor) throws CoreException {
        org.eclipse.m2m.internal.qvt.oml.common.project.PluginUtil.addPluginNature(project);
        convertProject(project, progressMonitor);
    }

    
    private static void convertProject(IProject project, IProgressMonitor monitor) throws CoreException {
        IPath manifestPath = project.getFullPath().append("plugin.xml"); //$NON-NLS-1$
        IFile file = project.getWorkspace().getRoot().getFile(manifestPath);
        if(!file.exists()) {
            createManifestFile(file, monitor);
        }
        
        IFile buildPropertiesFile = project.getFile("build.properties"); //$NON-NLS-1$
        if(!buildPropertiesFile .exists()) {
            createBuildPropertiesFile(buildPropertiesFile);
        }
    }

    private static void createManifestFile(IFile file, IProgressMonitor monitor) throws CoreException {
        if(monitor == null) {
            monitor = new NullProgressMonitor();
        }
        
        ModelHelper<IPluginModel> model = PluginUtil.createPluginModel(file);
        model.model().load();
        
        IPlugin plugin = model.model().getPlugin();
        plugin.setSchemaVersion("3.0"); //$NON-NLS-1$
        String id = makeId(file.getProject());
        plugin.setId(id);
        plugin.setName(plugin.getId());
        plugin.setVersion("1.0.0"); //$NON-NLS-1$
        
        IPluginLibrary library = model.model().getPluginFactory().createLibrary();
        String libraryName = getLibraryName(file.getProject().getName());
        library.setName(libraryName);
        library.setExported(true);
        plugin.add(library);
        
        model.save();
    }
    	
	private static String makeId(IProject project) {
        String name = project.getName();
        return PluginUtil.makeId(name);
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
        entry.addToken("."); //$NON-NLS-1$
        
        model.model().getBuild().add(entry);
        entry = factory.createEntry(IBuildEntry.OUTPUT_PREFIX + libraryName);
        entry.addToken("."); //$NON-NLS-1$
        
        model.model().getBuild().add(entry);

        model.model().getBuild().add(binEntry);
        model.save();
    }
}