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

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.m2m.internal.qvt.oml.common.model.ObjectFeature;
import org.eclipse.m2m.internal.qvt.oml.common.model.ValidatableFeature;

public class ModuleIdPage extends WizardPage implements ValidatableFeature.ChangeListener {
    public ModuleIdPage(ObjectFeature<String> feature, String pageName, String label) {
        super(pageName);
        myLabel = label;
        myFeature = feature;
        myFeature.addChangeListener(this);
        changePerformed(myFeature);
    }

    public void createControl(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new GridLayout(2, false));
        composite.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        new Label(composite, SWT.CENTER).setText(myLabel);
        myIdText = new Text(composite, SWT.BORDER);
        GridData data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        data.grabExcessHorizontalSpace = true;
        data.horizontalSpan = 1;
        myIdText.setLayoutData(data);
        myIdText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                if (!isSetByUser) { 
                    myFeature.silentSetDefaultValue(myIdText.getText());
                } else {
                    myFeature.silentSetValue(myIdText.getText());
                }
                setPageComplete(validatePage());
            }
        });
        
        changePerformed(myFeature);

        setControl(composite);
        setPageComplete(validatePage());
    }
    
    @Override
	public void setVisible(boolean visible) {
        super.setVisible(visible);
        if(visible) {
            myIdText.setFocus();
        }
    }
    
    private boolean validatePage() {
        setMessage(null);
        setErrorMessage(null);        
        boolean result = myFeature.validate();
        setErrorMessage(myFeature.getErrorMessage());
        return result;
    }
    
    public void changePerformed(ValidatableFeature feature) {
        if (myIdText != null) {
            isSetByUser = false;
            myIdText.setText(myFeature.getValue() == null ? "" : myFeature.getValue()); //$NON-NLS-1$
            isSetByUser = true;            
        }
    }
    
    private final ObjectFeature<String> myFeature;
    private Text myIdText;
    private final String myLabel;
    private boolean isSetByUser = true;
}    
