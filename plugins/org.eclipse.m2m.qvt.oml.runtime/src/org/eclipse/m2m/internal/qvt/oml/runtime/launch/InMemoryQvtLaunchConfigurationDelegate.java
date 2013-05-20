/*******************************************************************************
 * Copyright (c) 2007, 2008 Borland Software Corporation and others.
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
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.launch.EmptyDebugTarget;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.common.launch.InMemoryLaunchUtils;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ShallowProcess;
import org.eclipse.m2m.internal.qvt.oml.common.launch.StreamsProxy;
import org.eclipse.m2m.internal.qvt.oml.emf.util.Logger;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.m2m.internal.qvt.oml.runtime.QvtRuntimePlugin;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.MiscUtil;
import org.eclipse.m2m.qvt.oml.util.WriterLog;


public class InMemoryQvtLaunchConfigurationDelegate extends QvtLaunchConfigurationDelegateBase {
	
    public static final String LAUNCH_CONFIGURATION_TYPE_ID = "org.eclipse.m2m.qvt.oml.InMemoryQvtTransformation"; //$NON-NLS-1$
	
    /**
     * A handler for transformation job-done-status can be registered, taking argument as 
     * array of Object[] { Job, Runnable }, where <code>Runnable</code> element is optional 
     * and may execute a UI feedback on the job done event.
     * 
     * @see IStatusHandler
     */
    public static final IStatus statusJobDone = new Status(IStatus.INFO, QvtRuntimePlugin.ID, 200, "", null); //$NON-NLS-1$
    

	public void launch(final ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {        
        Object transObj = InMemoryLaunchUtils.getAttribute(configuration, IQvtLaunchConstants.TRANSFORMATION);
        if (transObj instanceof QvtTransformation == false) {
            throw new IllegalArgumentException("Invalid transformation " + transObj); //$NON-NLS-1$
        }
        final QvtTransformation qvtTransformation = (QvtTransformation) transObj;
        final Runnable doneAction = (Runnable) InMemoryLaunchUtils.getAttribute(configuration, IQvtLaunchConstants.DONE_ACTION);
        
        final StreamsProxy streamsProxy = new StreamsProxy();
        
        ShallowProcess.IRunnable r = new ShallowProcess.IRunnable() {

            public void run() throws Exception {
                IStatus status = QvtLaunchConfigurationDelegateBase.validate(qvtTransformation, configuration);                    
                if (status.getSeverity() > IStatus.WARNING) {
                	throw new CoreException(status);
                }
            	
            	Context context = QvtLaunchUtil.createContext(configuration);
            	context.setLog(new WriterLog(streamsProxy.getOutputWriter()));

            	QvtLaunchConfigurationDelegateBase.doLaunch(qvtTransformation, configuration, context);
            	
            	qvtTransformation.cleanup();
            }
        };
        
        r = getSafeRunnable(qvtTransformation, r);
        
        ShallowProcess process = new ShallowProcess(launch, r);
        process.setStreamsProxy(streamsProxy);
        final EmptyDebugTarget debugTarget = new EmptyDebugTarget(launch, process, QvtRuntimePlugin.ID, MDAConstants.QVTO_LAUNCH_CONFIGURATION_NAME);

    	final Job job = createTransformationJob(qvtTransformation, process, debugTarget, doneAction);
    	job.addJobChangeListener(new JobChangeAdapter() {
    		
    		@Override
    		public void done(IJobChangeEvent event) {
    			try {
					debugTarget.terminate();
				} catch (DebugException e) {
					Logger.getLogger().log(Logger.SEVERE, "Debug target termination for " + qvtTransformation + " failed", e);  //$NON-NLS-1$//$NON-NLS-2$
				}
    		}
    		
    	});
    	job.schedule();        
    }

	private Job createTransformationJob(final QvtTransformation transformation, final ShallowProcess process, final EmptyDebugTarget debugTarget, final Runnable doneAction) {
		Job job = new Job(Messages.InMemoryQvtLaunchConfigurationDelegate_TransformationJobName) {
		
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask(Messages.InMemoryQvtLaunchConfigurationDelegate_RunningTaskName, IProgressMonitor.UNKNOWN);
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
					return MiscUtil.makeErrorStatus(org.eclipse.m2m.internal.qvt.oml.emf.util.StatusUtil.getExceptionMessages(e), e);
				} finally {
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
