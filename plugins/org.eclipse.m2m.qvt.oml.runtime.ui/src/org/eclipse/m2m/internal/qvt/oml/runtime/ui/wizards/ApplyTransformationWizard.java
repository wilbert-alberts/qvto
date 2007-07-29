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

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.m2m.qvt.oml.common.MdaException;

/**
 * @author vrepeshko
 */
public abstract class ApplyTransformationWizard extends ApplyWizard {
    public ApplyTransformationWizard(ApplyTransformationData data) {
        super(data);
        setNeedsProgressMonitor(false);
        setWindowTitle(Messages.ApplyTransformationWizard_Title);
    }
    
    @Override
    public void addPages() {
        super.addPages();
        myQvtTransformationConfigurationPage = new QvtTransformationConfigurationPage("QvtTransformationConfigurationPage", getData()); //$NON-NLS-1$
        myQvtTransformationConfigurationPage.setTitle(Messages.ApplyTransformationWizard_ConfigProperties);
        myQvtTransformationConfigurationPage.setDescription(Messages.ApplyTransformationWizard_SetupConfigProperty);
        addPage(myQvtTransformationConfigurationPage);
    }
    
    @Override
    public IWizardPage getNextPage(IWizardPage page) {        
        IWizardPage nextPage = super.getNextPage(page);
        if (nextPage == myQvtTransformationConfigurationPage) {
            try {
                if (getData().getTransformation().getConfigurationProperties().size() <= 0) {
                    nextPage = null;
                }
            } catch (MdaException e) {
                nextPage = null;
            }
        }
        return nextPage;
    }
    
    private QvtTransformationConfigurationPage myQvtTransformationConfigurationPage;
}
