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

import java.util.List;

import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.common.launch.InMemoryLaunchUtils;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.common.ui.wizards.PersistedValuesWizard;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.Logger;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.IMetamodelHandler;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.MetamodelHandlerManager;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.QvtRuntimePluginImages;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.QvtRuntimeUIPlugin;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IWorkbenchPage;

/**
 * @author sboyko
 */
public class RunInterpretedTransformationWizard extends PersistedValuesWizard {
	
	public RunInterpretedTransformationWizard(URI uriTransf, List<URI> paramUris) {
		super(QvtRuntimeUIPlugin.getDefault());
		myTransfUri = uriTransf;

        setNeedsProgressMonitor(false);
        setWindowTitle(Messages.LaunchWorkspaceTransformationWizard_Title);
        ImageDescriptor desc = QvtRuntimePluginImages.getInstance().getImageDescriptor(QvtRuntimePluginImages.APPLY_WIZARD);
        setDefaultPageImageDescriptor(desc);
        
        myTransformationData = new ApplyTransformationData();
        myValidationRS = new ResourceSetImpl();
		
		mySelectTransformationPage = new SelectInterpretedTransformationPage("SelectTransfromationPageId"); //$NON-NLS-1$
        mySelectTransformationPage.setTitle(Messages.SelectWorkspaceTransformationPage_Title);
        myTransformationParametersPage = new TransformationParametersPage("TransformationParametersPageId", paramUris, myValidationRS); //$NON-NLS-1$
        myTransformationParametersPage.setTitle(Messages.TransformationParametersPage_Title);
        myQvtTransformationConfigurationPage = new QvtTransformationConfigurationPage("QvtTransformationConfigurationPage", myTransformationData); //$NON-NLS-1$
        myQvtTransformationConfigurationPage.setTitle(org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards.Messages.ApplyTransformationWizard_ConfigProperties);
        myQvtTransformationConfigurationPage.setDescription(org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards.Messages.ApplyTransformationWizard_SetupConfigProperty);
	}

	@Override
	public void addPages() {
		QvtTransformation transformation = null;
		if (myTransfUri != null) {
	        try {
	            transformation = new QvtInterpretedTransformation(TransformationUtil.getQvtModule(myTransfUri));
	            
	            List<TransformationParameter> parameters = transformation.getParameters();
	            if (parameters.isEmpty()) {
	            	transformation = null;
	            }
	        }
	        catch (Exception e) {
	        	transformation = null;
	        }
		}
		
		if (transformation == null) {
			addPage(mySelectTransformationPage);
		}
		else {
	        setQvtTransformation(transformation);
		}
        addPage(myTransformationParametersPage);
        addPage(myQvtTransformationConfigurationPage);
		super.addPages();
	}

	@Override
	protected void saveValues() {
	}
	
	@Override
	public void dispose() {
		super.dispose();
		for (Resource res : myValidationRS.getResources()) {
			res.unload();
		}
	}
	
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page == mySelectTransformationPage) {
			setQvtTransformation(mySelectTransformationPage.getTransformation());
		}
        if (page == myTransformationParametersPage) {
            try {
                if (myTransformation.getConfigurationProperties().size() <= 0) {
                    return null;
                }
            } catch (MdaException e) {
                return null;
            }
        }
		return super.getNextPage(page);
	}
	
	@Override
	protected boolean performFinishBody() {
        try {
            ILaunchConfigurationWorkingCopy workingCopy = createLaunchConfiguration();
            DebugUITools.launch(workingCopy, ILaunchManager.RUN_MODE);
        } catch (Exception e) {
            String message = NLS.bind(Messages.LaunchWorkspaceTransformationWizard_FailedToLaunch, myTransformation);
            Logger.getLogger().log(Logger.SEVERE, message, e); 
            MessageDialog.openError(getShell(), Messages.LaunchWorkspaceTransformationWizard_Error, message);
        }
        return true;
	}

    private ILaunchConfigurationWorkingCopy createLaunchConfiguration() throws Exception {
        ILaunchConfigurationWorkingCopy workingCopy = QvtLaunchUtil.getInMemoryLaunchConfigurationType().newInstance(null, MDAConstants.QVTO_LAUNCH_CONFIGURATION_NAME); 
        
        workingCopy.setAttribute(IDebugUIConstants.ATTR_LAUNCH_IN_BACKGROUND, false); 
        
        InMemoryLaunchUtils.setAttribute(workingCopy, IQvtLaunchConstants.TRANSFORMATION, myTransformation);

        myTransformationParametersPage.applyConfiguration(workingCopy);
        
		//InMemoryLaunchUtils.setAttribute(workingCopy, IQvtLaunchConstants.DONE_ACTION, createShowResultAction(data));
        
        workingCopy.setAttribute(IQvtLaunchConstants.CONFIGURATION_PROPERTIES, myTransformationData.getConfiguration());

        return workingCopy;
    }

	@SuppressWarnings("unused")
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
					String message = Messages.LaunchWorkspaceTransformationWizard_ShowResultError;
		            Logger.getLogger().log(Logger.SEVERE, message, e); 
				}
			}
			
		};
	}
	
	private void setQvtTransformation(QvtTransformation transformation) {
		myTransformation = transformation;
		myTransformationParametersPage.setTransformation(myTransformation);
		myTransformationData.setTransformation(myTransformation);
	}

	private final SelectInterpretedTransformationPage mySelectTransformationPage;
	private final TransformationParametersPage myTransformationParametersPage;
    private final QvtTransformationConfigurationPage myQvtTransformationConfigurationPage;
    private final ApplyTransformationData myTransformationData;
    private final URI myTransfUri;
    private QvtTransformation myTransformation;
    private final ResourceSet myValidationRS;
}
