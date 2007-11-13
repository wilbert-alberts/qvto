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
package org.eclipse.m2m.qvt.oml.project.nature;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.m2m.internal.qvt.oml.common.nature.TransformationNature;
import org.eclipse.m2m.qvt.oml.builder.QvtBuilderConfig;
import org.eclipse.m2m.qvt.oml.project.QVTProjectPlugin;


/**
 * @author strizhkin
 */
public class TransformationNatureImpl implements TransformationNature {

	public static final String DEFAULT_SOURCE_FOLDER_PATH = "transformations"; //$NON-NLS-1$ 
	

	public TransformationNatureImpl() {		
	}
    
    public void configure() throws CoreException {
        IProject project = getProject();
        if (project != null) {
        	
            IProjectDescription description = project.getDescription();
            
        	TransformationNatureConfigParticipant[] configParticipants = NatureConfigParticipantManager.getParticipants();
        	for (int i = 0; i < configParticipants.length; i++) {
				TransformationNatureConfigParticipant participant = configParticipants[i];
				participant.configure(description);
			}
        	
        	project.setDescription(description, null);
        	setupDefaultSourceContainer();        	
        }
    }
    
    private void setupDefaultSourceContainer() {
    	assert getProject() != null;
    	
    	IContainer container = null;
    	IProject project = getProject();
    	if(project != null) {
    		try {
    			QvtBuilderConfig config = QvtBuilderConfig.getConfig(getProject());
				container = config.getRawSourceContainer();
				if(container == null) {
					// not set explicitly, use default
					IFolder folder = getProject().getFolder(new Path(DEFAULT_SOURCE_FOLDER_PATH));
					container = folder;					
					if(!folder.exists()) {
						folder.create(true, true, null);
					}
					
					config.setSourceContainer(container);					
				}
			} catch (CoreException e) {
				QVTProjectPlugin.log(e.getStatus());
			}
    	}
    }

    public void deconfigure() throws CoreException {
		IProject project = getProject();
		if (project != null) {
			IProjectDescription description = project.getDescription();

			TransformationNatureConfigParticipant[] configParticipants = NatureConfigParticipantManager.getParticipants();
			for (int i = 0; i < configParticipants.length; i++) {
				TransformationNatureConfigParticipant participant = configParticipants[i];
				participant.deconfigure(description);
			}

			project.setDescription(description, null);
		}
	}
    
    public IProject getProject() {
        return myProject;
    }
    
    public void setProject(IProject project) {
        myProject = project;
    }
    
    private IProject myProject;
    
}
