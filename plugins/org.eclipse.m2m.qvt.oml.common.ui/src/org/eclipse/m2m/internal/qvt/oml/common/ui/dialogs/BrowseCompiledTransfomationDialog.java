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
package org.eclipse.m2m.internal.qvt.oml.common.ui.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.m2m.internal.qvt.oml.common.ui.controls.SelectCompiledTransfomationControl;
import org.eclipse.m2m.qvt.oml.common.project.CompiledTransformation;
import org.eclipse.m2m.qvt.oml.common.project.TransformationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;


public class BrowseCompiledTransfomationDialog extends Dialog{
    public BrowseCompiledTransfomationDialog(Shell shell, String title, ILabelProvider labelProvider, TransformationRegistry registry, String selectedTransId){
        super(shell);
        setShellStyle(getShellStyle() | SWT.RESIZE);
        myTitle = title;
        myInitialTransId = selectedTransId;
        myRegistry = registry;
        myLabelProvider = labelProvider;
    }
    
    @Override
	protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(myTitle); 
    }
    
    public CompiledTransformation getSelectedTransfomation(){
        return mySelectedTransformation;
    }
    
    @Override
	protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);        
        
        myControl = new SelectCompiledTransfomationControl(composite, myLabelProvider, myRegistry, myInitialTransId); 
        myControl.getViewer().addSelectionChangedListener(new ISelectionChangedListener(){
           public void selectionChanged(SelectionChangedEvent event){
               mySelectedTransformation = null;
               IStructuredSelection ssel = (IStructuredSelection)myControl.getViewer().getSelection();
               Object selectedObject = ssel.getFirstElement();
               if(selectedObject instanceof CompiledTransformation){
                   mySelectedTransformation = (CompiledTransformation)selectedObject;
               }
               getButton(IDialogConstants.OK_ID).setEnabled(mySelectedTransformation!=null);
           }
        });
        
        return composite;
    }   
    
    private final String myTitle;
    private final String myInitialTransId;
    private final TransformationRegistry myRegistry;
    private final ILabelProvider myLabelProvider;

    private CompiledTransformation mySelectedTransformation;
    private SelectCompiledTransfomationControl myControl;
}
