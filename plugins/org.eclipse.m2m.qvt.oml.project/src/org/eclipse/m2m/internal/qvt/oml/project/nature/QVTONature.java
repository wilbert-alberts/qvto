/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.project.nature;

import java.util.Arrays;
import java.util.LinkedHashSet;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.m2m.internal.qvt.oml.project.QVTOProjectPlugin;
import org.eclipse.m2m.internal.qvt.oml.project.builder.QVTOBuilderConfig;


public class QVTONature extends BaseNature {
	
	public static final String DEFAULT_SOURCE_FOLDER_PATH = "transformations"; //$NON-NLS-1$

	private static final String LEGACY_BUILDER_ID = "org.eclipse.m2m.qvt.oml.QvtBuilder";//$NON-NLS-1$	
	
    
	public QVTONature() {		
	}
    	
    @Override
	public void configure() throws CoreException {
        IProject project = getProject();
        if (project != null) {        	
            IProjectDescription description = project.getDescription();
            
            // might be migrating from the obsolete QVT nature
        	boolean isMigrated = migrate(description);
			if(!isMigrated) {
				// add new QVT builder command, otherwise the migration step 
				// derives it from the existing build spec
        		addQVTBuilder(description);
        	}
                    	
        	project.setDescription(description, null);
        	
        	if(!isMigrated) {
        		// we have not migrated in which case we inherit the source container from the migrated one 
        		// => setup the default folder 
        		setupDefaultSourceContainer();
        	}
        }
    }
        

    private void addQVTBuilder(IProjectDescription projectDesc) {
		NatureUtils.addBuilders(projectDesc,
				new String[] { QVTOProjectPlugin.BUILDER_ID } ,
				new String[] { } );    	
    }
    
    private void setupDefaultSourceContainer() {
    	assert getProject() != null;
    	
    	IContainer container = null;
    	IProject project = getProject();
    	if(project != null) {
    		try {
    			QVTOBuilderConfig config = QVTOBuilderConfig.getConfig(getProject());
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
				QVTOProjectPlugin.log(e.getStatus());
			}
    	}
    }

	private boolean migrate(IProjectDescription description) throws CoreException {
		boolean migrated = false;
		
		ICommand[] commands = description.getBuildSpec();
    	for (ICommand nextCommand : commands) { 
			if(LEGACY_BUILDER_ID.equals(nextCommand.getBuilderName())) {
				nextCommand.setBuilderName(QVTOProjectPlugin.BUILDER_ID);
				description.setBuildSpec(commands);
				migrated = true;
				break;
			}
		}
    	
    	LinkedHashSet<String> natures = new LinkedHashSet<String>(Arrays.asList(description.getNatureIds()));
    	natures.remove(LegacyNature.ID);
    	description.setNatureIds(natures.toArray(new String[natures.size()]));
    	
    	return migrated;
	}    
}
