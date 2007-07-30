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

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ISetMessage;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TransformationControls;
import org.eclipse.m2m.internal.qvt.oml.common.ui.wizards.SelectCompiledTransformationPage;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtCompiledTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformationRegistry;
import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.project.CompiledTransformation;
import org.eclipse.m2m.qvt.oml.common.project.TransformationRegistry;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;

public class SelectQvtCompiledTransformationPage extends SelectCompiledTransformationPage {
    public SelectQvtCompiledTransformationPage(String pageId, String title, ApplyTransformationData data, EClass input) {
        super(pageId, title, new QvtCompiledTransformationLabelProvider(), 
                QvtTransformationRegistry.getInstance(), 
                new TransformationRegistry.InputFilter(input));
        myData = data;
    }

    @Override
	public void createControl(Composite parent) {
    	super.createControl(parent);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, MDAConstants.QVTO_TRANSFORMATION_CONTEXTID);
    }
    
    @Override
	public boolean validatePage() {
        setMessage(null);
        setErrorMessage(null);
        
        QvtTransformation transformation = getSelectedTransformation();
        if(transformation == null) {
            setMessage(Messages.ApplyTransformationWizard_ApplyTransformationSelectPageTitle);
            return false;
        }
        
        try {
        	IStatus status = transformation.canRun(myData.getSource());
        	boolean isOk = TransformationControls.statusToTab(status, SET_MESSAGE);
            if(!isOk) {
                return false;
            }
        }
        catch(MdaException e) {
            setErrorMessage(e.getMessage());
            return false;
        }
        
        myData.setTransformation(transformation);
        return true;
    }
    
    public QvtTransformation getSelectedTransformation() {
        IStructuredSelection selection = getSelection();
        if(selection == null) {
            return null;
        }
        
        Object obj = selection.getFirstElement();
        if(obj instanceof CompiledTransformation == false) {
            return null;
        }
        
        return (QvtCompiledTransformation)obj;
    }
    
    public IContainer getResultContainer() {
        return null;
    }
    
    public String getSelectedTransformationId() {
        QvtCompiledTransformation trans = (QvtCompiledTransformation) getSelectedTransformation();
        return trans.getId();
    }

    private final ISetMessage SET_MESSAGE = new ISetMessage() {
        public void setErrorMessage(String message){
        	SelectQvtCompiledTransformationPage.this.setErrorMessage(message);
        }

        public void setMessage(String message) {
        	SelectQvtCompiledTransformationPage.this.setMessage(message, WARNING);
        }
    };
    
    private final ApplyTransformationData myData;
}
