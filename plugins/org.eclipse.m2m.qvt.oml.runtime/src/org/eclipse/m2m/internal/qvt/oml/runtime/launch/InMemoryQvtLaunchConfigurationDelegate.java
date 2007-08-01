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
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.common.launch.InMemoryLaunchUtils;
import org.eclipse.m2m.internal.qvt.oml.runtime.QvtRuntimePlugin;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.MiscUtil;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalStdLibrary;
import org.eclipse.m2m.qvt.oml.common.Logger;
import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.common.launch.EmptyDebugTarget;
import org.eclipse.m2m.qvt.oml.common.launch.ShallowProcess;
import org.eclipse.m2m.qvt.oml.common.launch.StreamsProxy;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.qvt.oml.library.Context;
import org.eclipse.m2m.qvt.oml.library.IConfiguration;
import org.eclipse.m2m.qvt.oml.library.IContext;
import org.eclipse.m2m.qvt.oml.library.QvtConfiguration;


public class InMemoryQvtLaunchConfigurationDelegate extends QvtLaunchConfigurationDelegateBase {
    public static final String LAUNCH_CONFIGURATION_TYPE_ID = "org.eclipse.m2m.qvt.oml.InMemoryQvtTransfomation"; //$NON-NLS-1$
	
    /**
     * A handler for transformation job-done-status can be registered, taking argument as 
     * array of Object[] { Job, Runnable }, where <code>Runnable</code> element is optional 
     * and may execute a UI feedback on the job done event.
     * 
     * @see IStatusHandler
     */
    public static final IStatus statusJobDone = new Status(IStatus.INFO, QvtRuntimePlugin.ID, 200, "", null); //$NON-NLS-1$
    

	public void launch(final ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {        
        Object transObj = InMemoryLaunchUtils.getAttribute(configuration, IQvtLaunchConstants.TRANSFOMATION_ID);
        if(transObj instanceof QvtTransformation == false) {
            throw new IllegalArgumentException("Invalid transformation " + transObj); //$NON-NLS-1$
        }
        final QvtTransformation transformation = (QvtTransformation) transObj;
        
        final URI targetModelURI = URI.createURI(configuration.getAttribute(IQvtLaunchConstants.TARGET_MODEL, "")); //$NON-NLS-1$
        
        final Runnable doneAction = (Runnable) InMemoryLaunchUtils.getAttribute(configuration, IQvtLaunchConstants.DONE_ACTION);
        
        StreamsProxy streamsProxy = new StreamsProxy();
        final PrintWriter printWriter = new PrintWriter(streamsProxy.getOutputWriter());
        
        ShallowProcess.IRunnable r = new ShallowProcess.IRunnable() {
            @SuppressWarnings("unchecked")
            public void run() throws Exception {
                Object inObj = InMemoryLaunchUtils.getAttribute(configuration, IQvtLaunchConstants.SOURCE_MODEL);
                if(inObj instanceof EObject == false) {
                    throw new IllegalArgumentException("Invalid input object " + inObj); //$NON-NLS-1$
                }
                EObject in = (EObject) inObj;
                
                TargetUriData targetData = QvtLaunchUtil.getTargetUriData(configuration);
                if(targetData.getUriString() == null) {
                    throw new IllegalArgumentException("Invalid out URI"); //$NON-NLS-1$
                }
                
                // Work around storing lists in InMemoryLC (QvtLaunchUtils.getConfiguration(configuration) 
                // doesn't work)
                IConfiguration qvtConfiguration = new QvtConfiguration(
                        (Map<String, String>) InMemoryLaunchUtils.getAttribute(
                                configuration,
                                IQvtLaunchConstants.CONFIGURATION_PROPERTIES));                

                String traceFileName = configuration.getAttribute(IQvtLaunchConstants.TRACE_FILE, ""); //$NON-NLS-1$
                
            	IContext context = new Context(QvtLaunchUtil.getConfiguration(configuration));
                context.put(QvtOperationalStdLibrary.OUT_PRINT_WRITER, printWriter);
                
                doLaunch(transformation, configuration, context);
            }
        };
        
        r = getSafeRunnable(transformation, r);
        
        ShallowProcess process = new ShallowProcess(launch, r);
        process.setStreamsProxy(streamsProxy);
        final EmptyDebugTarget debugTarget = new EmptyDebugTarget(launch, process, QvtRuntimePlugin.ID, MDAConstants.QVTO_LAUNCH_CONFIGURATION_NAME);

    	final Job job = createTransformationJob(transformation, process, debugTarget, targetModelURI, doneAction);
    	job.addJobChangeListener(new JobChangeAdapter() {
    		
    		@Override
    		public void done(IJobChangeEvent event) {
    			try {
					debugTarget.terminate();
				} catch (DebugException e) {
					Logger.getLogger().log(Logger.SEVERE, "Debug target termination for " + transformation + " failed", e);  //$NON-NLS-1$//$NON-NLS-2$
				}
    		}
    		
    	});
    	job.schedule();
        
    }

	private Job createTransformationJob(final QvtTransformation transformation, final ShallowProcess process, final EmptyDebugTarget debugTarget, final URI targetModelURI, final Runnable doneAction) {
		Job job = new Job(Messages.InMemoryQvtLaunchConfigurationDelegate_TransformationJobName) {
		
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask(Messages.InMemoryQvtLaunchConfigurationDelegate_RunningTaskName, IProgressMonitor.UNKNOWN); //$NON-NLS-1$
				try {
					process.run(debugTarget);
					
					IStatusHandler statusHandler = DebugPlugin.getDefault().getStatusHandler(statusJobDone);
					if(statusHandler != null) {
						Object[] handlerArgs = new Object[] { this, doneAction };
						Object resolution = statusHandler.handleStatus(statusJobDone, handlerArgs);
						assert resolution != null : "Invalid job done status resolution"; //$NON-NLS-1$
					}
				} catch (Exception e) {
					Logger.getLogger().log(Logger.SEVERE, "Transformation " + transformation + " failed", e); //$NON-NLS-1$ //$NON-NLS-2$
					return MiscUtil.makeErrorStatus(org.eclipse.m2m.qvt.oml.emf.util.StatusUtil.getExceptionMessages(e), e);
				} finally {
					org.eclipse.m2m.qvt.oml.emf.util.URIUtils.refresh(targetModelURI);
					monitor.done();
				}
				return Status.OK_STATUS;
			}			
		};
		job.setUser(true);
		return job;
	}
    
    @Override
	protected IProject[] getProjectsForProblemSearch(ILaunchConfiguration configuration, String mode) throws CoreException {
        return new IProject[0];
    }
}
