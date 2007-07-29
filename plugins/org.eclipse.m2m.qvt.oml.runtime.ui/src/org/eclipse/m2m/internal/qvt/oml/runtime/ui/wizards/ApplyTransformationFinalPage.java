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
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.NameUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.QvtUIValidator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.m2m.qvt.oml.common.Logger;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ISetMessage;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.ISourceUriGroup;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.OptionalFileGroup;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TargetUriGroup;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TransformationControls;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.OptionalFileGroup.IModifyListener;

/**
 * @author vrepeshko
 */
public class ApplyTransformationFinalPage extends WizardPage {
    public ApplyTransformationFinalPage(String pageName, ApplyTransformationData data) {
        super(pageName);
        myData = data;
    }
    
    public void createControl(final Composite parent) {
        Composite composite = new Composite(parent, SWT.NULL);
        composite.setLayout(new GridLayout(TransformationControls.GRID, false));
        
        mySourceUriGroup = new ISourceUriGroup() {
            public String getText() {
                URI sourceUri = myData.getSourceUri();
                String sourceUriString = sourceUri == null ? "" : sourceUri.toString(); //$NON-NLS-1$
                return sourceUriString;
            }

			public void update(String uri, Shell shell) {}
			public void addModifyListener(org.eclipse.m2m.internal.qvt.oml.common.ui.launch.ISourceUriGroup.IModifyListener listener) {}
			public void removeModifyListener(org.eclipse.m2m.internal.qvt.oml.common.ui.launch.ISourceUriGroup.IModifyListener listener) {}
        };
        
        myTargetModelUriGroup = TransformationControls.createTargetUriGroup(composite, mySourceUriGroup);
        myTargetModelUriGroup.addModifyListener(new TargetUriGroup.IModifyListener() {
            public void modified() {
            	myOpenEditor.setVisible(true);
            	
            	setPageComplete(validatePage());

                if((myTraceFile.getText().length() == 0) || (myTraceFile.getText().equals(QvtLaunchUtil.getTraceFileName(URI.createURI(oldURI))))) {
                    initTraceFileText();
                }
                oldURI = myTargetModelUriGroup.getText();
                setModified(true);
            }
        });
        
        myTraceFile = new OptionalFileGroup(composite, org.eclipse.m2m.internal.qvt.oml.runtime.ui.launch.Messages.QvtLauncherTab_TraceFile);
        myTraceFile.addModifyListener(new IModifyListener() {
            public void modified() {
                setPageComplete(validatePage());
                setModified(true);
            }
        });
        
        Composite spacer = new Composite(composite, SWT.NULL);
        GridData data = new GridData(GridData.FILL_HORIZONTAL);
        data.minimumHeight = 20;
        data.heightHint = 20;
        data.horizontalSpan = TransformationControls.GRID;
        spacer.setLayoutData(data);
        
        myOpenEditor = new Button(composite, SWT.CHECK);
        myOpenEditor.setText(Messages.ApplyTransformationFinalPage_OpenEditor);
        myOpenEditor.setSelection(false);
        myOpenEditor.setVisible(false);
        myOpenEditor.addSelectionListener(new SelectionAdapter() {
            @Override
			public void widgetSelected(SelectionEvent e) {
                setPageComplete(validatePage());
                setModified(true);
            }
        });
        myOpenEditor.setLayoutData(new GridData());
        
        setControl(composite);

        setPageComplete(validatePage());
    }
    
    private void initTraceFileText() {
        if (myData.getTargetData() == null || myData.getTargetData().getUri() == null) {
            return;
        }
        
        String traceFileName = QvtLaunchUtil.getTraceFileName(myData.getTargetData().getUri());
        myTraceFile.setUseFileFlag(traceFileName != null);
        myTraceFile.setText(traceFileName);
    }
    
    private void initTargetUriText() {
        if(myData.getSourceUri() == null || myData.getTransformation() == null) {
            return;
        }
        
        IFile file = org.eclipse.m2m.qvt.oml.emf.util.URIUtils.getFile(myData.getSourceUri());
        if(file == null) {
            return;
        }
        
        try {
            String fileName = myData.getTransformation().getModuleName() + "." + NameUtil.getExtensionForResult(myData.getTransformation().getOut()); //$NON-NLS-1$
            IPath targetPath = new Path(file.getParent().getFullPath() + "/" + fileName);  //$NON-NLS-1$
            URI targetUri = URI.createPlatformResourceURI(targetPath.toString(), false);
            myTargetModelUriGroup.getUriText().setText(targetUri == null ? "" : targetUri.toString()); //$NON-NLS-1$
            myTargetModelUriGroup.getUriText().setSelection(myTargetModelUriGroup.getUriText().getCharCount());
        }
        catch(MdaException e) {
            Logger.getLogger().log(Logger.SEVERE, "Failed to get outClass for " + myData.getTransformation(), e); //$NON-NLS-1$
        }
        setModified(false);
    }
    
    @Override
	public void setVisible(boolean visible) {
        super.setVisible(visible);
        if(visible) {
            setPageComplete(validatePage());
            
            if(myTargetModelUriGroup.getText() == null || myTargetModelUriGroup.getText().length() == 0) {
                initTargetUriText();
            }
            
            myTargetModelUriGroup.getUriText().setFocus();
        }
    }
    
    protected boolean validatePage() {
        setMessage(null);
        setErrorMessage(null);
        
        myData.setTargetData(null);
        myData.setTraceFilePath(null);
        myData.setOpenEditor(false);
        myData.setUseTraceFile(false);

        QvtTransformation transformation = myData.getTransformation(); 
        if(transformation == null) {
            setErrorMessage(Messages.ApplyTransformationFinalPage_NoTransformation);
            
            return false;
        }
        
        boolean ok = QvtUIValidator.validateTransformation(SET_MESSAGE, transformation, mySourceUriGroup, myTargetModelUriGroup, myTraceFile, getShell());
        if(ok) {
            myData.setTargetData(myTargetModelUriGroup.getData());
            myData.setUseTraceFile(myTraceFile.getUseFileFlag());
            if(myTraceFile.getUseFileFlag()) {
                IFile traceFile = WorkspaceUtils.getWorkspaceFile(myTraceFile.getText());
                myData.setTraceFilePath(traceFile == null ? null : traceFile.getFullPath());
            }
            myData.setOpenEditor(myOpenEditor.getSelection());
        }
            
        return ok;
    }
    
    private final ISetMessage SET_MESSAGE = new ISetMessage() {
        public void setErrorMessage(String message) {
            ApplyTransformationFinalPage.this.setErrorMessage(message);
        }

        public void setMessage(String message) {
            ApplyTransformationFinalPage.this.setMessage(message, WARNING);
        }
    };
    
    public void loadValues(String sourceUri, TargetUriData targetData, String traceFilePath, boolean useTraceFile, boolean openEditor) {
        myTargetModelUriGroup.initializeFrom(targetData);
        myOpenEditor.setSelection(openEditor);
        myTraceFile.setText(""); //$NON-NLS-1$
        if (traceFilePath != null) {
            myTraceFile.setText(traceFilePath);
        }
        myTraceFile.setUseFileFlag(useTraceFile);
        setPageComplete(validatePage());
        setModified(false);
    }
    
    public boolean isModified() {
        return myModified;
    }

    public void setModified(boolean modified) {
        this.myModified = modified;
    }
    
    private final ApplyTransformationData myData;
    
    private boolean myModified;
    private ISourceUriGroup mySourceUriGroup;
    private TargetUriGroup myTargetModelUriGroup;
    private OptionalFileGroup myTraceFile;
    private Button myOpenEditor;
    private String oldURI = ""; //$NON-NLS-1$

}
