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
package org.eclipse.m2m.internal.qvt.oml.common.ui.wizards;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.m2m.internal.qvt.oml.common.ui.controls.SelectCompiledTransfomationControl;
import org.eclipse.m2m.qvt.oml.common.project.TransformationRegistry;
import org.eclipse.swt.widgets.Composite;


public abstract class SelectCompiledTransformationPage extends WizardPage implements ITransformationSelector {
    public SelectCompiledTransformationPage(String pageId, String title, ILabelProvider labelProvider, TransformationRegistry registry, TransformationRegistry.Filter filter) {
        super(pageId);
        myRegistry = registry;
        myLabelProvider = labelProvider;
        myFilter = filter;
    }
    
    private final TransformationRegistry myRegistry;
    private final ILabelProvider myLabelProvider;
    private final TransformationRegistry.Filter myFilter;

    public abstract boolean validatePage();
    
    protected IStructuredSelection getSelection() {
        return myControl!=null ? myControl.getSelection() : null;
    }
    
    public void createControl(Composite parent) {
        myControl = new SelectCompiledTransfomationControl(parent, myLabelProvider, myRegistry, "", myFilter); //$NON-NLS-1$
        myControl.getViewer().addSelectionChangedListener(new ISelectionChangedListener() {
            public void selectionChanged(SelectionChangedEvent event) {
                setPageComplete(validatePage());
                if (isCurrentPage()) {
                    getContainer().updateButtons();
                }
            }
        });
        setControl(myControl);
        setPageComplete(validatePage());
    }
    
    public void setSelectedTransformationId(String id) {
        myControl.selectTransformationById(id);
    }
    
    private SelectCompiledTransfomationControl myControl;
}
