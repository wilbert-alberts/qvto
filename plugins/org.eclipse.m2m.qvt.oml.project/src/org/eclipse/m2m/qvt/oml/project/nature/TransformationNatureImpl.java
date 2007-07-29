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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.m2m.internal.qvt.oml.common.nature.NatureConfigParticipantManager;
import org.eclipse.m2m.internal.qvt.oml.common.nature.TransformationNature;
import org.eclipse.m2m.internal.qvt.oml.common.nature.TransformationNatureConfigParticipant;


/**
 * @author strizhkin
 */
public class TransformationNatureImpl implements TransformationNature {

	public TransformationNatureImpl() {		
	}
    
    public void configure() throws CoreException {
        IProject project = getProject();
        if(project!=null) {
            IProjectDescription description = project.getDescription();
            
        	TransformationNatureConfigParticipant[] configParticipants = NatureConfigParticipantManager.getParticipants();
        	for (int i = 0; i < configParticipants.length; i++) {
				TransformationNatureConfigParticipant participant = configParticipants[i];
				participant.configure(description);
			}
        	
        	project.setDescription(description, null);
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
