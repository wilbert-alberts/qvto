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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2m.qvt.oml.project.wizards.MDAProjectFieldData;
import org.eclipse.pde.ui.IPluginContentWizard;
import org.eclipse.ui.INewWizard;


public interface INewTransformationWizard extends IPluginContentWizard, INewWizard {
	
	public void setProjectFieldData(MDAProjectFieldData projectData);
	
	public boolean performSoftFinish(IProgressMonitor monitor);

    public boolean isContentCreated();
    
    /**
     * Indicates whether Java plugin project is required for this wizard
     */
    public boolean isJavaRequired();
}
