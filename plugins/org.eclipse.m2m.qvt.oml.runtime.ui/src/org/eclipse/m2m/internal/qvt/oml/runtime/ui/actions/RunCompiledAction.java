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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards.ApplyCompiledTransformationWizard;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards.ApplyTransformationWizard;
import org.eclipse.m2m.qvt.oml.common.ui.action.ApplyTransformationWindowActionDelegate;

public class RunCompiledAction extends ApplyTransformationWindowActionDelegate {
	@Override
	protected void invokeWizard(EObject source) {
		ApplyTransformationWizard wizard = new ApplyCompiledTransformationWizard(source);
        WizardDialog wizardDialog = new WizardDialog(getShell(), wizard);
        wizardDialog.open();
	}
}
