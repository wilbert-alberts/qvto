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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ISetMessage;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.IUriGroup;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.MdaLaunchTab;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.OptionalFileGroup;
import org.eclipse.m2m.internal.qvt.oml.common.ui.launch.TransformationControls;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtValidator;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.ITransformationMaker;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.qvt.oml.QvtEngine;
import org.eclipse.m2m.qvt.oml.common.Logger;
import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

/** @author pkobiakov */
public class QvtLauncherTab extends MdaLaunchTab {
	public QvtLauncherTab(ITransformationMaker transformationMaker) {
		myTransformationMaker = transformationMaker;

        myUriListeners = new ArrayList<IUriGroup.IModifyListener>(1);
        myUriListeners.add(new IUriGroup.IModifyListener() {
			public void modified() {
				initTraceFileText();
				updateLaunchConfigurationDialog();
			}
		});
	}
	
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
	protected void createTransformationSection(Composite parent) {
        TransformationControls.createLabel(parent, Messages.QvtLauncherTab_ModuleLabel, TransformationControls.GRID);
        
        myQvtFile = TransformationControls.createText(parent, TransformationControls.TEXT_GRID);
        myQvtFile.addModifyListener(QVT_FILE_MODIFY_LISTENER);
        
        Button button = TransformationControls.createButton(parent, Messages.QvtLauncherTab_BrowseButtonLabel);
        button.addSelectionListener(new SelectionAdapter(){
            @Override
			public void widgetSelected(SelectionEvent e) {
                IFile file = null;
                try{
                    file = WorkspaceUtils.getWorkspaceFile(myQvtFile.getText());
                }catch(Exception ex){
                    
                }
                file = (IFile)TransformationControls.browseWorkspace(
                        ResourcesPlugin.getWorkspace().getRoot(),
                        file,
                        new ViewerFilter(){
                            @Override
							public boolean select(Viewer viewer, Object parentElement, Object element) {
                                if(element instanceof IFile){
                                    return MDAConstants.QVTO_FILE_EXTENSION.equals(((IFile)element).getFileExtension());
                                }
                                return true;
                            }
                        },
                        new TransformationControls.FileValidator(),
                        getShell(),
                        Messages.QvtLauncherTab_SelectTransformation,
                        MDAConstants.QVTO_TRANSFORMATION_CONTEXTID);
                
                if(file != null){
                    myQvtFile.setText(file.getFullPath().toString());
                }
            } 
        });

        myTraceFile = new OptionalFileGroup(parent, Messages.QvtLauncherTab_TraceFile);
        myTraceFile.addModifyListener(new OptionalFileGroup.IModifyListener() {
            public void modified() {
            	myTraceNameNonChanged = myTraceFile.getText().equals(getTraceFileName());
                updateLaunchConfigurationDialog();
            }});

        TransformationControls.createLabel(parent, Messages.QvtLauncherTab_ParametersLabel, TransformationControls.GRID);
        myTransfSignatureControl = new TransformationSignatureLaunchControl(parent, SWT.NONE|SWT.BORDER);

	}

    private void initTraceFileText() {
    	if (myTraceNameNonChanged || myTraceFile.getText().length() == 0) {
	        String traceFileName = getTraceFileName();
	        myTraceFile.setText(traceFileName);
	        myTraceFile.setUseFileFlag(traceFileName != null);
	        if (traceFileName != null) {
	            IPath path = Path.fromOSString(traceFileName);
	        	myTraceFile.update(path.lastSegment().replaceAll(MDAConstants.QVTO_TRACEFILE_EXTENSION_WITH_DOT, ""), //$NON-NLS-1$
	        			MDAConstants.QVTO_TRACEFILE_EXTENSION);
	        }
    	}
    }
    
    private String getTraceFileName() {
        URI targetUri = URI.createURI(myTransfSignatureControl.getTraceName());
        return QvtLaunchUtil.getTraceFileName(targetUri);
    }
	
    @Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
        IFile file = getFileContext();
        if(file == null) {
            return;
        }
        
        try {
            CompiledModule module = QvtEngine.getInstance(file).compile(file, null);
            if(module != null && module.getModule().getEntry() != null) {
                initializeName(configuration, module.getModule().getName());
                configuration.setAttribute(IQvtLaunchConstants.MODULE, file.getFullPath().toString());
            }
        }
        catch (MdaException e) {
            Logger.getLogger().log(Logger.INFO, e.getMessage(), e);
        }
    }
    
    private void initializeName(ILaunchConfigurationWorkingCopy config, String name) {
        if (name == null) {
            name = ""; //$NON-NLS-1$
        }

        if (name.length() > 0) {
            name = getLaunchConfigurationDialog().generateName(name);
            config.rename(name);
        }
    }
	
	public void initializeFrom(ILaunchConfiguration configuration) {
/*        
		if (!LicenseClient.isAvailable()) {
            return;
        }
*/
		try {
			myQvtFile.setText(configuration.getAttribute(IQvtLaunchConstants.MODULE, "")); //$NON-NLS-1$
		} catch (CoreException e) {
			myQvtFile.setText(""); //$NON-NLS-1$
		}
		
		try {
			myTransfSignatureControl.initializeFrom(configuration);
		} catch (CoreException e) {
		}

        try {
            myTraceFile.setText(configuration.getAttribute(IQvtLaunchConstants.TRACE_FILE, "")); //$NON-NLS-1$
        } catch (CoreException e) {
        }

        try {
            myTraceFile.setUseFileFlag(configuration.getAttribute(IQvtLaunchConstants.USE_TRACE_FILE, false)); 
        } catch (CoreException e) {
        }
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
/*       
		if (!LicenseClient.isAvailable()) {
            return;
        }
*/        
		configuration.setAttribute(IQvtLaunchConstants.MODULE, myQvtFile.getText());
		myTransfSignatureControl.performApply(configuration);
        configuration.setAttribute(IQvtLaunchConstants.TRACE_FILE, myTraceFile.getText());
        configuration.setAttribute(IQvtLaunchConstants.USE_TRACE_FILE, myTraceFile.getUseFileFlag());
	}
    
    @Override
	public boolean isValid(ILaunchConfiguration unused) {
/*        
    	if (!LicenseClient.isAvailable()) {
            return true;
        }
*/
        if(myTransformation == null) {
            return false;
        }
        else{
            setMessage(null);
            setErrorMessage(null);
            String moduleName;
            try {
            	moduleName = myTransformation.getModuleName();
            }
            catch (MdaException e) {
            	IStatus status = StatusUtil.makeErrorStatus(e.getMessage(), e);
            	return TransformationControls.statusToTab(status, SET_MESSAGE);
            }
            if (myTraceFile.getText().length() == 0) {
            	myTraceFile.update(moduleName, MDAConstants.QVTO_TRACEFILE_EXTENSION);
            }
            IStatus status = myTransfSignatureControl.validate(moduleName, getShell());
        	IStatus traceStatus = QvtValidator.validateTrace(myTraceFile.getText(), myTraceFile.getUseFileFlag()); 
            if (traceStatus.getSeverity() > status.getSeverity()) {
        		status = traceStatus;
        	}
            return TransformationControls.statusToTab(status, SET_MESSAGE);
        }
    }
    
    private boolean validateQvtFile() {
        myTransformation = null;

        String fileName = myQvtFile.getText();
        if(fileName == null || fileName.length() == 0) {
            setErrorMessage(Messages.QvtLauncherTab_MissingFileNameError);
            return false;
        }
        
        IFile qvtFile = WorkspaceUtils.getWorkspaceFile(fileName);
        if(qvtFile == null || !qvtFile.exists()) {
            setErrorMessage(NLS.bind(Messages.QvtLauncherTab_FileDoesNotExist, fileName));
            return false;
        }
        
        myTransformation = myTransformationMaker.makeTransformation(fileName);
        return true;
    }
    
    private final ModifyListener QVT_FILE_MODIFY_LISTENER = new ModifyListener() {
        public void modifyText(ModifyEvent e) {
            validateQvtFile();
            myTransfSignatureControl.setTransformation(myTransformation, myUriListeners);
            myTraceNameNonChanged = myTraceFile.getText().equals(getTraceFileName());
            updateLaunchConfigurationDialog();            
        }
    };
    
    private final ISetMessage SET_MESSAGE = new ISetMessage() {
        public void setErrorMessage(String message) {
            QvtLauncherTab.this.setErrorMessage(message);
        }

        public void setMessage(String message) {
            QvtLauncherTab.this.setMessage(message);
        }
    };
    
    private final ITransformationMaker myTransformationMaker; 
    private Text myQvtFile;
    private QvtTransformation myTransformation;
    private OptionalFileGroup myTraceFile;
    private boolean myTraceNameNonChanged;
    private TransformationSignatureLaunchControl myTransfSignatureControl;
    private final List<IUriGroup.IModifyListener> myUriListeners;
}
