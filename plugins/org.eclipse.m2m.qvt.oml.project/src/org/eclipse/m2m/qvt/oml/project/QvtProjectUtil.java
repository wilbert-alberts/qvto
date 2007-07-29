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
package org.eclipse.m2m.qvt.oml.project;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.m2m.internal.qvt.oml.common.nature.TransformationNature;
import org.eclipse.m2m.internal.qvt.oml.project.model.QvtProject;
import org.eclipse.m2m.qvt.oml.QvtPlugin;
import org.eclipse.m2m.qvt.oml.builder.QvtBuilderConfig;
import org.eclipse.m2m.qvt.oml.project.model.IQvtProject;

public class QvtProjectUtil {

	private QvtProjectUtil() {
		super();
	}

	public static IQvtProject getQvtProject(IProject project) {
		if(isQvtProject(project)) {
			return new QvtProject(project);
		}
		
		return null;
	}
	
    public static boolean isQvtProject(IProject project) {
    	try {
			return project.hasNature(TransformationNature.ID);
		} catch (CoreException e) {
			QvtPlugin.log(e.getStatus());
		}
		
		return false;
    }
    
    public static boolean isNamespaceFolder(IFolder folder) {
    	if(folder.exists() && isQvtProject(folder.getProject())) {
			try {
				QvtBuilderConfig builderConfig = QvtBuilderConfig.getConfig(folder.getProject());
	    		return builderConfig.isInSourceContainer(folder);				
			} catch (CoreException e) {
				MDAProjectPlugin.log(e.getStatus());
			}
    	}
    	
    	return false;
    }
    
    
    /**
	 * Gets the container representing the default name-space.
	 * 
	 * @param project
	 *            the QVT project to question
	 * 
	 * @return existing container or <code>null</code> in case that the given
	 *         project is not a QVT project or the appropriate container failed
	 *         to be computed
	 */
    public static IContainer getDefaultNamespaceContainer(IProject project) {
		if(!QvtProjectUtil.isQvtProject(project)) {
			return null;
		}

		try {
    		IContainer container = QvtBuilderConfig.getConfig(project).getSourceContainer();
    		return container.exists() ? container : null;
		} catch (CoreException e) {
			MDAProjectPlugin.log(e.getStatus());
		}
		
		return null;
    }    
}
