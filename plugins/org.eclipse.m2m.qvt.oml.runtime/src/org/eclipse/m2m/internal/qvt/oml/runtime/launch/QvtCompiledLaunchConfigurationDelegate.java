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
package org.eclipse.m2m.internal.qvt.oml.runtime.launch;

import java.io.PrintWriter;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtCompiledTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformationRegistry;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.MiscUtil;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.externaltools.internal.model.ExternalToolBuilder;
import org.eclipse.ui.externaltools.internal.model.IExternalToolConstants;

import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.common.launch.BaseProcess;
import org.eclipse.m2m.qvt.oml.common.launch.ShallowProcess;
import org.eclipse.m2m.qvt.oml.common.launch.StreamsProxy;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData.TargetType;
import org.eclipse.m2m.qvt.oml.common.util.ProjectUtil;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.IMetamodelHandler;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.MetamodelHandlerManager;

public class QvtCompiledLaunchConfigurationDelegate extends LaunchConfigurationDelegate {
    public void launch(final ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
        
        try {
            final String buildType = ExternalToolBuilder.getBuildType();
            final IProject project = ExternalToolBuilder.getBuildProject();

            StreamsProxy streamsProxy = new StreamsProxy();
            final PrintWriter printWriter = new PrintWriter(streamsProxy.getOutputWriter());
            
            ShallowProcess.IRunnable r = new ShallowProcess.IRunnable() {
                public void run() throws Exception {
                    if(IExternalToolConstants.BUILD_TYPE_CLEAN.equals(buildType)) {
                        clean(project, configuration);
                    }
                    else {
                        build(project, configuration, printWriter);
                    }
                }
            };
            
            ShallowProcess shallowProcess = new ShallowProcess(launch, r);
            shallowProcess.setStreamsProxy(streamsProxy);
			shallowProcess.run();
        }
        catch(Exception e) {
            throw new CoreException(MiscUtil.makeErrorStatus(org.eclipse.m2m.qvt.oml.emf.util.StatusUtil.getExceptionMessages(e), e));
        }
    }

    private void build(final IProject project, final ILaunchConfiguration configuration, final PrintWriter printWriter) throws Exception {
        QvtTransformationRegistry registry = QvtTransformationRegistry.getInstance();
        String id = configuration.getAttribute(IQvtLaunchConstants.TRANSFOMATION_ID, ""); //$NON-NLS-1$
        final QvtCompiledTransformation transformation = registry.getTransformationById(id); 
        if(transformation == null) {
            ProjectUtil.createMarker(project, MDAConstants.QVTO_PROBLEM_MARKER, 
                    NLS.bind(Messages.QvtCompiledLaunchTab_TransformationNotFound,id));
            return;
        }
        
        BaseProcess.IRunnable r = new BaseProcess.IRunnable() {
            public void run() throws Exception {
                IStatus status = QvtLaunchConfigurationDelegateBase.validate(transformation, configuration);
                if(status.getSeverity() > IStatus.WARNING) {
                    ProjectUtil.createMarker(project, MDAConstants.QVTO_PROBLEM_MARKER, status.getMessage());
                    return;
                }

                QvtLaunchConfigurationDelegateBase.doLaunch(transformation, configuration, printWriter);
            }
        };
        
        r = QvtLaunchConfigurationDelegateBase.getSafeRunnable(transformation, r);
        r.run();
    }
    
    private void clean(IProject project, ILaunchConfiguration configuration) throws Exception {
        String id = configuration.getAttribute(IQvtLaunchConstants.TRANSFOMATION_ID, ""); //$NON-NLS-1$
        QvtCompiledTransformation transformation = QvtTransformationRegistry.getInstance().getTransformationById(id);
        if(transformation == null || transformation.isLibrary()) {
            ProjectUtil.createMarker(project, MDAConstants.QVTO_PROBLEM_MARKER, 
                    NLS.bind(Messages.QvtCompiledLaunchTab_TransformationNotFound, id));
            return;
        }

        IMetamodelHandler handler = MetamodelHandlerManager.getInstance().getHandler(transformation.getOut());
        if(handler == null) {
            return;
        }
        
        TargetUriData targetData = QvtLaunchUtil.getTargetUriData(configuration);
        if(targetData.getTargetType() == TargetType.NEW_MODEL) {
        	URI outUri = URI.createURI(targetData.getUriString());
        	if(outUri == null) {
        		return;
        	}
        
        	handler.getSaver().clean(outUri);
        } else {
            
        }
    }
}
