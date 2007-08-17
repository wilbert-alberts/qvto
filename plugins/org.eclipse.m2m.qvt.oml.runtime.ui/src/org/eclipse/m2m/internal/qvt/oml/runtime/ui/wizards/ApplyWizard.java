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

import java.util.Map;

import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.common.launch.InMemoryLaunchUtils;
import org.eclipse.m2m.internal.qvt.oml.common.ui.wizards.ITransformationSelector;
import org.eclipse.m2m.internal.qvt.oml.common.ui.wizards.PersistedValuesWizard;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.InMemoryQvtLaunchConfigurationDelegate;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.QvtRuntimePluginImages;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.QvtRuntimeUIPlugin;
import org.eclipse.m2m.qvt.oml.common.Logger;
import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData.TargetType;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.qvt.oml.emf.util.ui.URIUtils;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.IMetamodelHandler;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.MetamodelHandlerManager;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPage;

public abstract class ApplyWizard extends PersistedValuesWizard {
    
	public ApplyWizard(ApplyTransformationData data) {
        super(QvtRuntimeUIPlugin.getDefault());
        myData = data;
        
        setNeedsProgressMonitor(false);
        setWindowTitle(Messages.ApplyTransformationWizard_Title);
        ImageDescriptor desc = QvtRuntimePluginImages.getInstance().getImageDescriptor(QvtRuntimePluginImages.APPLY_WIZARD);
        setDefaultPageImageDescriptor(desc);        
    }
	
	protected abstract ITransformationSelector getTransformationSelectorPage();
    
    @Override
	protected void saveValues() {
        PreferenceSection section = loadValues(
                SOURCE_URI, URIUtils.customGetUri(myData.getSource()).toString(),
                TRANSFORMATION_ID, getTransformationSelectorPage().getSelectedTransformationId()
        );
        doSaveValues(section);
        
        section.save();
    }

    protected void doSaveValues(PreferenceSection section) {
        TargetUriData targetData = myData.getTargetData(); 
        section.put(TARGET_TYPE, targetData.getTargetType().toString());
        section.put(DEST_URI, targetData.getUriString());
        section.put(FEATURE_NAME, targetData.getFeature());
        section.put(CLEAR_CONTENTS, targetData.isClearContents());
        
        String traceFileName = myData.getTraceFilePath() == null ? null : myData.getTraceFilePath().toOSString();
        section.put(TRACE_FILE_PATH, traceFileName);
        section.put(USE_TRACE_FILE, myData.isUseTraceFile());
        section.put(OPEN_IN_EDITOR, myData.isOpenEditor());
        
        section.put(CONFIGURATION_PROPERTIES, myData.getConfiguration());
    }

    public ApplyTransformationData getData() {
        return myData;
    }
    
    @Override
	public void createPageControls(Composite parent) {
        super.createPageControls(parent);
        PreferenceSection section = loadValues(SOURCE_URI, URIUtils.customGetUri(myData.getSource()).toString());
        doLoadValues(section);
    }

    protected void doLoadValues(PreferenceSection section) {
        String transId = section.get(TRANSFORMATION_ID);
        if (transId != null) {
            getTransformationSelectorPage().setSelectedTransformationId(transId);
        }
    }

    @Override
	public void addPages() {
        myFinalPage = new ApplyTransformationFinalPage("ApplyTransformationFinalPage", myData); //$NON-NLS-1$
        myFinalPage.setTitle(Messages.ApplyTransformationWizard_ApplyTransformationFinalPageTitle);
        myFinalPage.setDescription(Messages.ApplyTransformationWizard_ApplyTransformationFinalPageDesc);
        addPage(myFinalPage);
    }
    
    @Override
	public IWizardPage getNextPage(IWizardPage page) {
        IWizardPage result = super.getNextPage(page);
        if (result == myFinalPage) {
            PreferenceSection section = loadValues(
                    SOURCE_URI, URIUtils.customGetUri(myData.getSource()).toString(),
                    TRANSFORMATION_ID, getTransformationSelectorPage().getSelectedTransformationId()
            );
            
            myData.getConfiguration().clear();
            Map<String, String> map = section.getStringMap(CONFIGURATION_PROPERTIES);
            if (map != null) {
                myData.getConfiguration().putAll(map);
            }
            
            TargetType targetType;
            try {
            	targetType = TargetType.valueOf(section.get(TARGET_TYPE));
            }
            catch(Exception e) {
            	targetType = TargetType.NEW_MODEL;
            }
            
            if (!myFinalPage.isModified()) {
            	TargetUriData targetData = new TargetUriData(
            			targetType,
            			section.get(DEST_URI),
            			section.get(FEATURE_NAME),
            			section.getBoolean(CLEAR_CONTENTS, true));
                
            	myFinalPage.loadValues(
                        myData.getSourceUri().toString(),
                        targetData,
                        section.get(TRACE_FILE_PATH),
                        section.getBoolean(USE_TRACE_FILE),
                        section.getBoolean(OPEN_IN_EDITOR)
                );
            }
        }
        return result;
    }

    @Override
	public boolean performFinishBody() {
        try {
            ILaunchConfigurationWorkingCopy workingCopy = createLaunchConfiguration(myData);
            DebugUITools.launch(workingCopy, ILaunchManager.RUN_MODE);
        } catch (Exception e) {
            String message = NLS.bind(Messages.ApplyWizard_FailedToApply, myData.getTransformation());
            Logger.getLogger().log(Logger.SEVERE, message, e); 
            MessageDialog.openError(getShell(), Messages.ApplyWizard_Error, message);//$NON-NLS-1$
        }
        return true;
    }
    
    private static ILaunchConfigurationWorkingCopy createLaunchConfiguration(ApplyTransformationData data) throws Exception {
        ILaunchConfigurationWorkingCopy workingCopy = getLaunchConfigurationType().newInstance(null, MDAConstants.QVTO_LAUNCH_CONFIGURATION_NAME); 
        
        workingCopy.setAttribute(IDebugUIConstants.ATTR_LAUNCH_IN_BACKGROUND, false); 
        
        InMemoryLaunchUtils.setAttribute(workingCopy, IQvtLaunchConstants.TRANSFOMATION_ID, data.getTransformation());
        InMemoryLaunchUtils.setAttribute(workingCopy, IQvtLaunchConstants.SOURCE_MODEL, data.getSource());

		QvtLaunchUtil.saveTargetUriData(workingCopy, data.getTargetData());
        
		String traceFileName = data.getTraceFilePath() == null ? null : data.getTraceFilePath().toOSString();
		workingCopy.setAttribute(IQvtLaunchConstants.TRACE_FILE, traceFileName);
		
		InMemoryLaunchUtils.setAttribute(workingCopy, IQvtLaunchConstants.DONE_ACTION, createShowResultAction(data));
        
        InMemoryLaunchUtils.setAttribute(workingCopy, IQvtLaunchConstants.CONFIGURATION_PROPERTIES, data.getConfiguration());

        return workingCopy;
    }

	private static ILaunchConfigurationType getLaunchConfigurationType() {
		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
        ILaunchConfigurationType type = manager.getLaunchConfigurationType(InMemoryQvtLaunchConfigurationDelegate.LAUNCH_CONFIGURATION_TYPE_ID);
        if (type == null) {
            throw new RuntimeException("No launch configuration for id " + InMemoryQvtLaunchConfigurationDelegate.LAUNCH_CONFIGURATION_TYPE_ID); //$NON-NLS-1$
        }
		return type;
	}

	private static Runnable createShowResultAction(final ApplyTransformationData data) {
		if (!data.isOpenEditor()) {
			return null;
		}
		return new Runnable() {
							
			public void run() {
				IWorkbenchPage page = QvtRuntimeUIPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
                TargetUriData targetData = data.getTargetData();
				IMetamodelHandler handler = MetamodelHandlerManager.getInstance().getHandler(String.valueOf(targetData.getUri()));
                EObject result = EmfUtil.loadModel(targetData.getUri());
                if (result == null) {
                	return;
                }
                try {
					handler.getSaver().select(result, page);
				} catch (Exception e) {
					String message = Messages.ApplyWizard_ShowResultError;
		            Logger.getLogger().log(Logger.SEVERE, message, e); 
				}
			}
			
		};
	}
	
    private final ApplyTransformationData myData;
    
    private ApplyTransformationFinalPage myFinalPage;
    
    public static final String SOURCE_URI = "org.eclipse.m2m.qvt.oml.internal.runtime.wizards.ApplyWizard.sourceUri";   //$NON-NLS-1$
    public static final String TRANSFORMATION_ID = "org.eclipse.m2m.qvt.oml.internal.runtime.wizards.ApplyWizard.transformationId";   //$NON-NLS-1$
    public static final String DEST_URI = "org.eclipse.m2m.qvt.oml.internal.runtime.wizards.ApplyWizard.destUri";   //$NON-NLS-1$ 
    public static final String TRACE_FILE_PATH = "org.eclipse.m2m.qvt.oml.internal.runtime.wizards.ApplyWizard.traceFileName";   //$NON-NLS-1$
    public static final String USE_TRACE_FILE = "org.eclipse.m2m.qvt.oml.internal.runtime.wizards.ApplyWizard.useTraceFile";   //$NON-NLS-1$
    public static final String OPEN_IN_EDITOR = "org.eclipse.m2m.qvt.oml.internal.runtime.wizards.ApplyWizard.openInEditor";   //$NON-NLS-1$
    public static final String TARGET_TYPE = "org.eclipse.m2m.qvt.oml.internal.runtime.wizards.ApplyWizard.targetType";   //$NON-NLS-1$    
    public static final String FEATURE_NAME = "org.eclipse.m2m.qvt.oml.internal.runtime.wizards.ApplyWizard.featureName";   //$NON-NLS-1$
    public static final String CLEAR_CONTENTS = "org.eclipse.m2m.qvt.oml.internal.runtime.wizards.ApplyWizard.clearContents";   //$NON-NLS-1$    
    public static final String CONFIGURATION_PROPERTIES = "org.eclipse.m2m.qvt.oml.internal.runtime.wizards.ApplyWizard.configurationProperties";   //$NON-NLS-1$    
}
