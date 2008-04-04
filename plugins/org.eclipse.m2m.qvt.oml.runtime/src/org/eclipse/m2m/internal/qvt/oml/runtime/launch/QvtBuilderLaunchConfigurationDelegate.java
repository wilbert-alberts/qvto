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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalStdLibrary;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.MiscUtil;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.launch.BaseProcess;
import org.eclipse.m2m.qvt.oml.common.launch.ShallowProcess;
import org.eclipse.m2m.qvt.oml.common.launch.StreamsProxy;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.qvt.oml.emf.util.Logger;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.IMetamodelHandler;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.MetamodelHandlerManager;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.externaltools.internal.model.ExternalToolBuilder;
import org.eclipse.ui.externaltools.internal.model.IExternalToolConstants;

public class QvtBuilderLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

	public static final String QVTO_BUILDER_MARKER = "org.eclipse.m2m.qvt.oml.runtime.qvtBuilderMarker"; //$NON-NLS-1$
	
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
        String moduleName = configuration.getAttribute(IQvtLaunchConstants.MODULE, ""); //$NON-NLS-1$
        final QvtInterpretedTransformation transformation;
		try {
			transformation = new QvtInterpretedTransformation(TransformationUtil.getQvtModule(EmfUtil.makeUri(moduleName)));
		} catch (MdaException e) {
            createMarker(project, NLS.bind(Messages.QvtBuilderLaunchTab_TransformationNotFound, moduleName));
            return;
		}
        
        BaseProcess.IRunnable r = new BaseProcess.IRunnable() {
            public void run() throws Exception {
                IStatus status = QvtLaunchConfigurationDelegateBase.validate(transformation, configuration);
                if(status.getSeverity() > IStatus.WARNING) {
                    createMarker(project, status.getMessage());
                    return;
                }

            	IContext context = new Context(QvtLaunchUtil.getConfiguration(configuration));
                context.put(QvtOperationalStdLibrary.OUT_PRINT_WRITER, printWriter);

                QvtLaunchConfigurationDelegateBase.doLaunch(transformation, configuration, context);
            }
        };
        
        r = QvtLaunchConfigurationDelegateBase.getSafeRunnable(transformation, r);
        r.run();
    }
    
    private void clean(IProject project, ILaunchConfiguration configuration) throws Exception {
        String moduleName = configuration.getAttribute(IQvtLaunchConstants.MODULE, ""); //$NON-NLS-1$
        final QvtInterpretedTransformation transformation;
		try {
			transformation = new QvtInterpretedTransformation(TransformationUtil.getQvtModule(EmfUtil.makeUri(moduleName)));
		} catch (MdaException e) {
            createMarker(project, NLS.bind(Messages.QvtBuilderLaunchTab_TransformationNotFound, moduleName));
            return;
		}
        
        IMetamodelHandler handler = MetamodelHandlerManager.getInstance().getHandler(transformation.getOut());
        if(handler == null) {
            return;
        }
        
        List<TransformationParameter> transfParams = transformation.getParameters();
        List<TargetUriData> targetUris = QvtLaunchUtil.getTargetUris(configuration);
        for (int i = 0, n = targetUris.size(); i < n; ++i) {
        	if (transfParams.size() > i && transfParams.get(i).getDirectionKind() == DirectionKind.OUT) {
	        	URI outUri = URI.createURI(targetUris.get(i).getUriString());
	        	if (outUri != null) {
		        	handler.getSaver().clean(outUri);
	        	}
        	}
        }
        
        String traceFile = configuration.getAttribute(IQvtLaunchConstants.TRACE_FILE, ""); //$NON-NLS-1$
        if (traceFile != null) {
        	URI traceUri = URI.createPlatformResourceURI(traceFile, false);
        	if (traceUri != null) {
        		handler.getSaver().clean(traceUri);
        	}
        }
    }

	private void createMarker(IProject project, String message) {
	    if(project == null) {
	        return;
	    }
	    
	    Map<String, Object> attributes = new HashMap<String, Object>();
	    attributes.put(IMarker.MESSAGE, message);
	    attributes.put(IMarker.SEVERITY, new Integer(IMarker.SEVERITY_ERROR));
	    try {
	        IMarker marker = project.createMarker(QVTO_BUILDER_MARKER);
	        marker.setAttributes(attributes);
	    }
	    catch (CoreException e) {
	        Logger.getLogger().log(Logger.SEVERE, "Failed to create marker on " + project, e); //$NON-NLS-1$
	    }
	}
}
