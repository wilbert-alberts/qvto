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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ISetMessage;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.MdaCompiledLaunchTab;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.OptionalFileGroup;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.SourceUriGroup;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TargetUriGroup;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TransformationControls;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.ITransformationMaker;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtCompiledTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformationRegistry;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.QvtUIValidator;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards.QvtCompiledTransformationLabelProvider;
import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.qvt.oml.common.project.TransformationRegistry;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.externaltools.internal.model.IExternalToolConstants;

public class QvtCompiledLaunchTab extends MdaCompiledLaunchTab {
    @Override
	public void createControl(Composite parent) {
/*
    	if (!LicenseClient.isAvailable()) {
            Composite composite = new Composite(parent, SWT.NONE);
            composite.setLayout(new GridLayout());
            LicenseClient.createLimitedPane(composite, QvtRuntimePlugin.getResourceString("QvtLaunch.Feature")); //$NON-NLS-1$
            setControl(composite);
            return;
        }
*/        
        super.createControl(parent);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, MDAConstants.QVTO_TRANSFORMATION_CONTEXTID);
    }
    
    @Override
	protected void createTransformationSection(final Composite parent) {
        myTransformationId = createTransfomationGroup(parent);
        myTransformationId.addModifyListener(MODIFY_LISTENER);
        
        mySourceModelUri = TransformationControls.createUriGroup(parent, Messages.QvtCompiledLaunchTab_SourceModelURI);
        mySourceModelUri.addModifyListener(SOURCE_URI_LISTENER);

        myTargetModelUri = TransformationControls.createTargetUriGroup(parent, mySourceModelUri); 
        myTargetModelUri.addModifyListener(new TargetUriGroup.IModifyListener() {
            public void modified() {
                if((myTraceFile.getText().length() == 0) || (myTraceFile.getText().equals(QvtLaunchUtil.getTraceFileName(URI.createURI(oldURI))))) {
                    initTraceFileText();
                }
                oldURI = myTargetModelUri.getUriText().getText();
            }
        });
        myTargetModelUri.addModifyListener(new TargetUriGroup.IModifyListener(){
			public void modified() {
				updateLaunchConfigurationDialog();
			}
        });

        myTraceFile = new OptionalFileGroup(parent, Messages.QvtLauncherTab_TraceFile);
        myTraceFile.addModifyListener(new OptionalFileGroup.IModifyListener() {
            public void modified() {
                updateLaunchConfigurationDialog();
            }});
    }
    
    private void initTraceFileText() {
        URI targetUri = URI.createURI(myTargetModelUri.getText());
        myTraceFile.setText(QvtLaunchUtil.getTraceFileName(targetUri));
    }
    
    @Override
	protected TransformationRegistry getRegistry() {
        return QvtTransformationRegistry.getInstance();
    }
    
    @Override
	protected ILabelProvider getLabelProvider() {
        return new QvtCompiledTransformationLabelProvider();
    }
    
    @Override
	protected String getBrowseDialogTitle() {
        return Messages.QvtCompiledLaunchTab_BrowseTitle;
    }

    public void initializeFrom(ILaunchConfiguration configuration) {
/*    	
        if (!LicenseClient.isAvailable()) {
            return;
        }
*/
        try {
            myTransformationId.setText(configuration.getAttribute(IQvtLaunchConstants.TRANSFOMATION_ID, "")); //$NON-NLS-1$
        } catch (CoreException e) {
            myTransformationId.setText(""); //$NON-NLS-1$
        }
        
        try {
            mySourceModelUri.initializeFrom(configuration.getAttribute(IQvtLaunchConstants.SOURCE_MODEL, "")); //$NON-NLS-1$
        } catch (CoreException e) {
            mySourceModelUri.initializeFrom(""); //$NON-NLS-1$
        }
        
        try {
        	TargetUriData targetData = QvtLaunchUtil.getTargetUriData(configuration);
        	myTargetModelUri.initializeFrom(targetData);
        } catch (CoreException e) {
        }
        
        try {
            myTraceFile.setUseFileFlag(configuration.getAttribute(IQvtLaunchConstants.USE_TRACE_FILE, false));
            myTraceFile.setText(configuration.getAttribute(IQvtLaunchConstants.TRACE_FILE, "")); //$NON-NLS-1$
        } catch (CoreException e) {
        }
    }

    @Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
/*        
    	if (!LicenseClient.isAvailable()) {
            return;
        }
*/      
        setBuildTypes(configuration, new String[] {
                IExternalToolConstants.BUILD_TYPE_FULL,
                IExternalToolConstants.BUILD_TYPE_INCREMENTAL,
                IExternalToolConstants.BUILD_TYPE_AUTO,
                IExternalToolConstants.BUILD_TYPE_CLEAN,
        });

        configuration.setAttribute(IQvtLaunchConstants.TRANSFOMATION_ID, myTransformationId.getText());
        configuration.setAttribute(IQvtLaunchConstants.SOURCE_MODEL, mySourceModelUri.getText());
        QvtLaunchUtil.saveTargetUriData(configuration, myTargetModelUri.getData());
        configuration.setAttribute(IQvtLaunchConstants.TRACE_FILE, myTraceFile.getText());
        configuration.setAttribute(IQvtLaunchConstants.USE_TRACE_FILE, myTraceFile.getUseFileFlag());
    }
    
    @Override
	public boolean isValid(ILaunchConfiguration unused) {
        setMessage(null);
        setErrorMessage(null);
/*        
        if (!LicenseClient.isAvailable()) {
            return true;
        }
*/      
        QvtCompiledTransformation transformation = getTransformation();
        if(transformation == null) {
            setErrorMessage(NLS.bind(org.eclipse.m2m.internal.qvt.oml.runtime.launch.Messages.QvtCompiledLaunchTab_TransformationNotFound, myTransformationId.getText()));
            return false;
        }
        
        return QvtUIValidator.validateTransformation(SET_MESSAGE, transformation, mySourceModelUri, myTargetModelUri, myTraceFile, getShell());
    }

    private QvtCompiledTransformation getTransformation() {
    	String transformationId = myTransformationId.getText();
    	if(transformationId == null || transformationId.length() == 0) {
    		// do not spent time in lookup, no transformation ID set yet
    		return null;
    	}
    	QvtCompiledTransformation qvtTransformation = QvtTransformationRegistry.getInstance().getTransformationById(transformationId);
    	return qvtTransformation != null && !qvtTransformation.isLibrary() ? qvtTransformation : null;
    }
    
    private final ISetMessage SET_MESSAGE = new ISetMessage() {
        public void setErrorMessage(String message) {
            QvtCompiledLaunchTab.this.setErrorMessage(message);
        }

        public void setMessage(String message) {
            QvtCompiledLaunchTab.this.setMessage(message);
        }
    };
    
    public final ITransformationMaker TRANSFORMATION_MAKER = new ITransformationMaker() {
        public QvtTransformation makeTransformation(String name) {
            return getTransformation();
        }
    };
    
    private Text myTransformationId;
    private SourceUriGroup mySourceModelUri;
    private TargetUriGroup myTargetModelUri;
    private OptionalFileGroup myTraceFile;
    private String oldURI = ""; //$NON-NLS-1$
}
