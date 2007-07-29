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
package org.eclipse.m2m.qvt.oml.emf.util.ui.choosers;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public abstract class ChooserPageAdapter extends WizardPage {
    public ChooserPageAdapter(IChooser chooser){
        super("ComponentPageAdapter"); //$NON-NLS-1$
        
        chooser.addChangeListener(new IChooser.IChangeListener() {
            public void changed() {
                setPageComplete(validatePage());
            }
        });
        
        myChooser = chooser;
    }
    
    public IChooser getChooser(){
        return myChooser;
    }
    
    public void createControl(Composite parent) {
        Control control = myChooser.createControl(parent);
        setControl(control);
        
        setPageComplete(validatePage());
    }
    
    protected abstract boolean validatePage();
    
    private IChooser myChooser;
}
