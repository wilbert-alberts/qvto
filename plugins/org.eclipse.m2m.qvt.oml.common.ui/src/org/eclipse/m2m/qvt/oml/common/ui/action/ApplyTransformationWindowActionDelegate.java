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
package org.eclipse.m2m.qvt.oml.common.ui.action;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;

/**
 * @author dtrofimov
 */
abstract public class ApplyTransformationWindowActionDelegate extends
		EObjectWindowActionDelegate {

	@Override
	protected void runImpl(IAction action) throws Exception {
		EObject source = getSelectedEObject();
		
		if (source == null) {
			String title = Messages.ApplyTransformationWindowActionDelegate_title;
	        String message = Messages.ApplyTransformationWindowActionDelegate_message;
	        
	        //if it is not an eobject then it must be a file
	        IFile file = (IFile) getSelectedElement(); 
	        
	        	
			MessageDialog.openInformation(getShell(), title, NLS.bind(message, file.getName()));
		} else {
			invokeWizard(source);
		}
	}
	
	/**
	 * Runs transformation wizard on source model
	 * @param source source can't be null
	 */
	abstract protected void invokeWizard(EObject source);
}
