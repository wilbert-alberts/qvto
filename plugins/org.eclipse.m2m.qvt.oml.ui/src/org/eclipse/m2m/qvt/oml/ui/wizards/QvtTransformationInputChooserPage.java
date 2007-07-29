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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.m2m.internal.qvt.oml.common.model.ObjectFeature;
import org.eclipse.m2m.internal.qvt.oml.common.model.ValidatableFeature;
import org.eclipse.m2m.internal.qvt.oml.common.model.ValidatableFeature.ChangeListener;
import org.eclipse.m2m.internal.qvt.oml.common.ui.wizards.choosers.EClassChooserPage;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class QvtTransformationInputChooserPage extends EClassChooserPage implements ChangeListener {

    public QvtTransformationInputChooserPage(ObjectFeature<EClass> feature, ObjectFeature<Boolean> inplace, String pageId, 
    		String title, String helpId, MetamodelRegistry metamodelRegistry) {
        super(feature, pageId, title, helpId, metamodelRegistry);
        myInplace = inplace;
        myInplace.addChangeListener(this);
    }

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);
        Composite composite = (Composite) getControl();
        myInplaceCheckbox = new Button(composite, SWT.CHECK);
        myInplaceCheckbox.setText(Messages.Create_inplace_transformation);
        myInplaceCheckbox.setSelection(myInplace.getValue());
        myInplaceCheckbox.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                myInplace.setValue(myInplaceCheckbox.getSelection());
            }
        });
    }
        
    public void changePerformed(ValidatableFeature feature) {
        if (myInplaceCheckbox != null) {
            myInplaceCheckbox.setSelection(myInplace.getValue());
        }
    }

    private final ObjectFeature<Boolean> myInplace;
    private Button myInplaceCheckbox;
}
