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
package org.eclipse.m2m.qvt.oml.ui.wizards;

import org.eclipse.core.runtime.IPath;

/**
 * @author dvorak
 */
public class NewQvtTransformationCreationPage extends NewQvtModuleCreationPage {
	
	protected NewQvtTransformationCreationPage() {
		super();
	}

	/**
	 * @param containerPath the path to be the destination where the new transformation is to be placed.
	 */
	protected NewQvtTransformationCreationPage(IPath containerPath) {
		super(containerPath);
	}
    
    @Override
    protected String getNewModuleNameProposal() {    
    	return "NewTransformation";
    }
}
