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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtProjectTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards.ApplyToWizard;
import org.eclipse.m2m.qvt.oml.common.ui.action.ObjectActionDelegate;

public class ApplyToAction extends ObjectActionDelegate{
    @Override
	protected void runImpl(IAction action) throws Exception {
        IFile qvtFile = (IFile)((IStructuredSelection)getSelection()).getFirstElement();
        
        QvtTransformation qvtTransformation = new QvtProjectTransformation(qvtFile);
        ApplyToWizard wizard = new ApplyToWizard(qvtTransformation);
        WizardDialog wizardDialog = new WizardDialog(getShell(), wizard);
        wizardDialog.open();
    }
}
