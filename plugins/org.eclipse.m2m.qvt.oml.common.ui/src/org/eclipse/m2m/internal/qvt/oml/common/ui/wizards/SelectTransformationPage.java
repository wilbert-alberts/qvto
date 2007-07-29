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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.m2m.qvt.oml.emf.util.ui.controls.SelectFileControl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;


/**
 * @author vrepeshko
 */
public abstract class SelectTransformationPage extends WizardPage implements ITransformationSelector {
    public SelectTransformationPage(String pageId, SelectFileControl.IFilter resourceFilter) {
        super(pageId);
        myResourceFilter = resourceFilter;
    }
    
    public void createControl(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new GridLayout(1, true));
        doCreateControl(composite);
        setControl(composite);
        
        setPageComplete(validatePage());
    }

    protected void doCreateControl(Composite parent) {
        myControl = new SelectFileControl(parent, true, myResourceFilter);
        myControl.addSelectionListener(new SelectFileControl.ISelectionListener() {
            public void selectionChanged(IPath path) {
                doSelectionChanged(path); 
                setPageComplete(validatePage());
            }

        });
    }
    
    protected void doSelectionChanged(IPath path) {
        
    }
    
    public IFile getSelectedResource(){
        return myControl!=null ? myControl.getSelectedFile() : null;
    }
    
    public void setSelectedTransformationId(String id) {
        myControl.selectFileByPath(id);
    }
    
    public String getSelectedTransformationId() {
        return getSelectedResource().getFullPath().toOSString();
    }

    protected abstract boolean validatePage();
    
    private final SelectFileControl.IFilter myResourceFilter;
    private SelectFileControl myControl;
}
