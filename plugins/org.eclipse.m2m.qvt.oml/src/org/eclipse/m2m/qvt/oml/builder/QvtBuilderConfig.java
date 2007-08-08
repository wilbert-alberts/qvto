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
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.m2m.internal.qvt.oml.common.nature.TransformationNature;
import org.eclipse.m2m.qvt.oml.QvtPlugin;
import org.eclipse.m2m.qvt.oml.common.Logger;
import org.eclipse.m2m.qvt.oml.common.project.NatureUtils;
import org.eclipse.m2m.qvt.oml.common.project.ProjectDependencyHelper;
import org.eclipse.osgi.util.NLS;


public class QvtBuilderConfig {

    private static final String SRC_CONTAINER = "src_container"; //$NON-NLS-1$
    private static final String PROJECT_ROOT = "/"; //$NON-NLS-1$	
	
    private final IProject myProject;    
    private ICommand myCommand;
    private static final Map<IProject, QvtBuilderConfig> ourCache = new HashMap<IProject, QvtBuilderConfig>();
    	
    
	private QvtBuilderConfig(IProject project) throws CoreException {
        myProject = project;
        myCommand = NatureUtils.findCommand(myProject, QvtBuilder.ID);
    }

    public static QvtBuilderConfig getConfig(IProject project) throws CoreException {
        QvtBuilderConfig config = ourCache.get(project);
        if (config != null) {
            return config;
        }
        config = new QvtBuilderConfig(project);
        ourCache.put(project, config);
        return config;
    }

	public boolean isInSourceContainer(IResource resource) {		
		IContainer container = null;
		if(resource.exists()) {
			if(myProject.equals(resource.getProject())) {
				container = getSourceContainer();
			}
		}
		
		if(container != null && container.exists()) {
			return container.getProjectRelativePath().isPrefixOf(resource.getProjectRelativePath());
		}
		return false;
	}
    
    public void save() throws CoreException {
        NatureUtils.updateCommand(myProject, myCommand);
    }
    
    public boolean getGenerateJava() {
    	return false;
    }
    
    public IContainer getDefaultSourceContainer() {
    	return myProject;
    }
    
    public IContainer getSourceContainer() {
        String containerPath = getArgument(SRC_CONTAINER);
        
        if(PROJECT_ROOT.equals(containerPath)) {
            return myProject;
        }
        
        if(containerPath != null) {
        	return myProject.getFolder(new Path(containerPath));
        }
        return myProject;
    }
    
    public void setSourceContainer(IContainer container) {
        if(container.getProject() != myProject) {
            throw new IllegalArgumentException(NLS.bind(Messages.QvtBuilderConfig_InvalidContainer, container.getFullPath()));
        }

        if(myCommand == null) {
        	try { 
        		IProjectDescription pd = myProject.getProject().getDescription();
				NatureUtils.addBuilders(pd, new String[] { QvtBuilder.ID }, new String[0]);
				myCommand = NatureUtils.findCommand(pd.getBuildSpec(), QvtBuilder.ID); 
			} catch (CoreException e) {
				QvtPlugin.log(e.getStatus());
			}
        }
        
        if(myCommand != null) {
        	setBuildCommandArgument(SRC_CONTAINER, getPathString(container));
        }
    }
    
    public IContainer[] getQvtContainers() {
        List<IContainer> containers = new ArrayList<IContainer>();        
        //containers.add(myProject);
		containers.add(getSourceContainer());
        
        try {
        	IProject[] referencedProjects = ProjectDependencyHelper.getQvtProjectDependencies(myProject, true); 
			for (int i = 0; i < referencedProjects.length; i++) {
				IProject nextProject = referencedProjects[i];
				if(nextProject.isOpen() && nextProject.hasNature(TransformationNature.ID)) {
					containers.add(nextProject);
				}
			}
		} catch (CoreException e) {
			Logger.getLogger().log(Logger.SEVERE, "Can't get QVT source containers", e); //$NON-NLS-1$
		}
        
        return containers.toArray(new IContainer[containers.size()]);
    }
    
    public IProject[] getProjectDependencies(boolean recursive) {
    	return ProjectDependencyHelper.getQvtProjectDependencies(myProject, recursive);
    }
    
    private String getPathString(IContainer container) {
        String containerPath;
        if(container == myProject) {
            containerPath = PROJECT_ROOT;
        }
        else {
            containerPath = container.getProjectRelativePath().toString();
        }
        
        return containerPath;
    }
    
    
    private String getArgument(String name) {
        if (myCommand == null) {
            return null;
        }
        Map<?,?> arguments = myCommand.getArguments();
        if(arguments == null) {
            return null;
        }
        else {
            return (String) myCommand.getArguments().get(name);
        }
    }
    
    @SuppressWarnings("unchecked")
	private void setBuildCommandArgument(String name, String value) {
    	assert myCommand != null;
    	
    	if(myCommand == null) return;
    	
        Map arguments = myCommand.getArguments();
        if(arguments == null) {
            arguments = new HashMap();
        }
        
        arguments.put(name, value);
        myCommand.setArguments(arguments);
    }        
}
