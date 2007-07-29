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
 * 
 * NOTE (abreslav): This wizard supports Interpreted (not project) transformations too
 */
public class ApplyProjectTransformationWizard extends ApplyTransformationWizard {
    public ApplyProjectTransformationWizard(final EObject source) {
        super(new ApplyTransformationData().setSourceAndUri(source, URIUtils.customGetUri(source)));
        mySelectTransformationPage = new SelectQvtProjectTransformationPage(
                "ApplyTransfromationPageId", //$NON-NLS-1$
                getData());
        mySelectTransformationPage.setTitle(Messages.SelectQvtProjectTransformationPage_Title); 
        mySelectTransformationPage.setDescription(Messages.SelectQvtProjectTransformationPage_Description);
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
    
    @Override
    protected void doLoadValues(PreferenceSection section) {
        String intMode = section.get(INTERPRETED_MODE, "true"); //$NON-NLS-1$
        mySelectTransformationPage.setInterpretedMode(Boolean.valueOf(intMode));
        super.doLoadValues(section);
    }
    
    @Override
    protected void doSaveValues(PreferenceSection section) {
        super.doSaveValues(section);
        section.put(INTERPRETED_MODE, mySelectTransformationPage.isInterpretedMode());
    }

   private final SelectQvtProjectTransformationPage mySelectTransformationPage;
   public static final String INTERPRETED_MODE = "org.eclipse.m2m.qvt.oml.runtime.wizards.ApplyWizard.interpretedMode";   //$NON-NLS-1$    
}
