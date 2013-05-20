/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others.
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

import java.util.Iterator;
import java.util.List;

import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.emf.common.util.URI;
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
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.IMetamodelHandler;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers.MetamodelHandlerManager;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
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
		
		mySelectTransformationPage = new SelectInterpretedTransformationPage("SelectTransfromationPageId"); //$NON-NLS-1$
        mySelectTransformationPage.setTitle(Messages.SelectWorkspaceTransformationPage_Title);
        myTransformationParametersPage = new TransformationParametersPage("TransformationParametersPageId", paramUris); //$NON-NLS-1$
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
		try {
			if (myTransformation != null) {
				myTransformation.cleanup();
			}
		} catch (MdaException e) {
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
        
		if (myTransformationParametersPage.isOpenInEditor()) {
			List<TargetUriData> targetUris = QvtLaunchUtil.getTargetUris(workingCopy);
			InMemoryLaunchUtils.setAttribute(workingCopy, IQvtLaunchConstants.DONE_ACTION, createShowResultAction(targetUris));
		}
        
        workingCopy.setAttribute(IQvtLaunchConstants.CONFIGURATION_PROPERTIES, myTransformationData.getConfiguration());

        return workingCopy;
    }

	private Runnable createShowResultAction(final List<TargetUriData> targetUris) {
		if (myTransformation == null) {
			return null;
		}
		return new Runnable() {
							
			public void run() {
				IWorkbenchPage page = QvtRuntimeUIPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
				
		        Iterator<TargetUriData> itrTargetData = targetUris.iterator();
				try {
					for (TransformationParameter transfParam : myTransformation.getParameters()) {
						if (!itrTargetData.hasNext()) {
							break;
						}
						TargetUriData targetData = itrTargetData.next();
						if (transfParam.getDirectionKind() == DirectionKind.IN) {
							continue;
						}
						
						IMetamodelHandler handler = MetamodelHandlerManager.getInstance().getHandler(String.valueOf(targetData.getUri()));
					    ModelContent result = EmfUtil.loadModel(targetData.getUri());
					    if (result == null || result.getContent().isEmpty()) {
					    	return;
					    }
					    try {
							handler.getSaver().select(result.getContent().get(0), page);
						} catch (Exception e) {
					        Logger.getLogger().log(Logger.SEVERE, Messages.LaunchWorkspaceTransformationWizard_ShowResultError, e); 
						}
					}
				} catch (MdaException e) {
			        Logger.getLogger().log(Logger.SEVERE, Messages.LaunchWorkspaceTransformationWizard_ShowResultError, e); 
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
}
