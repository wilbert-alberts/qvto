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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.m2m.qvt.oml.emf.util.ui.URIUtils;
import org.eclipse.m2m.internal.qvt.oml.common.ui.wizards.ITransformationSelector;

/**
 * @author vrepeshko
 */
public class ApplyCompiledTransformationWizard extends ApplyTransformationWizard {
    public ApplyCompiledTransformationWizard(final EObject source) {
        super(new ApplyTransformationData().setSourceAndUri(source, URIUtils.customGetUri(source)));
        
        mySelectTransformationPage = new SelectQvtCompiledTransformationPage(
                "ApplyTransfromationPageId", //$NON-NLS-1$
                Messages.ApplyTransformationWizard_TransfromationsListTitle, 
                getData(), source.eClass());
        mySelectTransformationPage.setTitle(Messages.ApplyCompiledTransformationWizard_Title);
        mySelectTransformationPage.setDescription(Messages.ApplyCompiledTransformationWizard_Description);
    }
    
    @Override
	public void addPages() {
/*        
    	if (!LicenseClient.isAvailable()) {
        	LicenseClient.showLimitedMessage(QvtRuntimePlugin.getResourceString("ApplyWizard.Feature")); //$NON-NLS-1$
            return;
        }
*/      
        addPage(mySelectTransformationPage);
        super.addPages();
    }
    
    @Override
	public boolean performFinishBody() {
/*
    	if(!LicenseClient.isAvailable()) {
            return true;
        }
*/      
        return super.performFinishBody();
    }
    
    @Override
	protected ITransformationSelector getTransformationSelectorPage() {
        return mySelectTransformationPage;
    }

    private final SelectQvtCompiledTransformationPage mySelectTransformationPage;
}
