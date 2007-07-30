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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtProjectTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.QvtRuntimeUIPlugin;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.MiscUtil;
import org.eclipse.m2m.qvt.oml.builder.QvtBuilderConfig;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompiler;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;

import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.common.util.ProjectUtil;
import org.eclipse.m2m.qvt.oml.emf.util.ui.controls.SelectFileControl;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ISetMessage;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TransformationControls;
import org.eclipse.m2m.internal.qvt.oml.common.ui.wizards.SelectTransformationPage;

public class SelectQvtProjectTransformationPage extends SelectTransformationPage {
    public SelectQvtProjectTransformationPage(String pageId, ApplyTransformationData data) {
        super(pageId, new MyResourceFilter());
        myData = data;
    }

    @Override
	public void createControl(Composite parent) {
    	super.createControl(parent);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, MDAConstants.QVTO_TRANSFORMATION_CONTEXTID);
    }
    
    @Override
    protected void doCreateControl(Composite parent) {
        super.doCreateControl(parent);
        myInterpretedModeCheckbox = new Button(parent, SWT.CHECK);
        myInterpretedModeCheckbox.setText(Messages.SelectQvtProjectTransformationPage_RunInterpretedMode);
        myInterpretedModeCheckbox.addSelectionListener(new SelectionAdapter() {
           @Override
            public void widgetSelected(SelectionEvent e) {
               validatePage();
            } 
        });
        myInterpretedModeCheckbox.setSelection(true);
    }
    
    @Override
    protected void doSelectionChanged(IPath path) {
        IFile file = getSelectedResource();
        if(file == null) {
        	return;
        }
        
        try {
            if (QvtBuilderConfig.getConfig(file.getProject()).getGenerateJava()) {
                myInterpretedModeCheckbox.setEnabled(true);
            } else {
                myInterpretedModeCheckbox.setSelection(true);
                myInterpretedModeCheckbox.setEnabled(false);
            }
        } catch (CoreException e) {
            QvtRuntimeUIPlugin.getDefault().getLog().log(MiscUtil.makeErrorStatus(e));
        }
        // Hack workaround for 
        // #33113 ApplyTransformationWizard: Finish sh be disabled for first-applied transformation
        for (IWizardPage p : getWizard().getPages()) {
            if (p instanceof ApplyTransformationFinalPage) {
                ((ApplyTransformationFinalPage) p).setPageComplete(false);
            }
        }
    }
    
    private static class MyResourceFilter implements SelectFileControl.IFilter{
        public boolean accept(IResource resource) {
            return resource instanceof IFile && MDAConstants.QVTO_FILE_EXTENSION.equalsIgnoreCase(resource.getFileExtension());
        }
    }
    
    @Override
	protected boolean validatePage() {
        setMessage(null);
        setErrorMessage(null);
        
        IResource resource = getSelectedResource();
        if(resource instanceof IFile == false) {
            return false;
        }
        
        try {
            IProject project = resource.getProject();
            if (myInterpretedModeCheckbox.getSelection()) {
                if (!ProjectUtil.isBuilt(project, QvtCompiler.PROBLEM_MARKER)) {
                    setErrorMessage(NLS.bind(Messages.ApplyTransformationWizard_QVTErrors, resource.getProject().getName()));
                    return false;
                }
            } else {
                if (!ProjectUtil.isBuilt(project, QvtCompiler.PROBLEM_MARKER)) {
                    setErrorMessage(NLS.bind(Messages.ApplyTransformationWizard_ProjectNotBuilt, resource.getProject().getName()));
                    return false;
                }
            }
            
            IFile file = (IFile)resource;            
            QvtTransformation transformation;
            if (isInterpretedMode()) {
                transformation = new QvtInterpretedTransformation(file);
            } else {
                transformation = new QvtProjectTransformation(file);
            }
            
            IStatus status = transformation.canRun(myData.getSource());
        	boolean isOk = TransformationControls.statusToTab(status, SET_MESSAGE);
            if(!isOk) {
                return false;
            }

            myData.setTransformation(transformation);
        }
        catch(Exception e) {
            setErrorMessage(e.getMessage());
            return false;
        }
        
        return true;
    }
        
    private final ApplyTransformationData myData;
    
    private final ISetMessage SET_MESSAGE = new ISetMessage() {
        public void setErrorMessage(String message){
        	SelectQvtProjectTransformationPage.this.setErrorMessage(message);
        }

        public void setMessage(String message) {
        	SelectQvtProjectTransformationPage.this.setMessage(message, WARNING);
        }
    };

    public boolean isInterpretedMode() {
        return myInterpretedModeCheckbox.getSelection();
    }

    public void setInterpretedMode(boolean intMode) {
        myInterpretedModeCheckbox.setSelection(intMode);        
    }

    private Button myInterpretedModeCheckbox;
}
