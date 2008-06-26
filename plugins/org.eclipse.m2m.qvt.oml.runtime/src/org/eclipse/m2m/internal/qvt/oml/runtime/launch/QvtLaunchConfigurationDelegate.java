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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalStdLibrary;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ShallowProcess;
import org.eclipse.m2m.internal.qvt.oml.common.launch.StreamsProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.internal.qvt.oml.evaluator.EvaluationContextProperties;
import org.eclipse.m2m.internal.qvt.oml.evaluator.EvaluationMonitor;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;

public class QvtLaunchConfigurationDelegate extends QvtLaunchConfigurationDelegateBase {
	
	public QvtLaunchConfigurationDelegate() {
	}
	
	// FIXME - do refactoring of this area 
	public void launch(final ILaunchConfiguration configuration, String mode, final ILaunch launch, IProgressMonitor monitor) throws CoreException {
        
		try {
            final QvtTransformation qvtTransformation = new QvtInterpretedTransformation(getQvtModule(configuration));
            final EvaluationMonitor execMonitor = createMonitor();
                                    
            StreamsProxy streamsProxy = new StreamsProxy();
            final PrintWriter printWriter = new PrintWriter(streamsProxy.getOutputWriter());   
            ShallowProcess.IRunnable r = new ShallowProcess.IRunnable() {
                
                public void run() throws Exception { 
                    IStatus status = QvtLaunchConfigurationDelegateBase.validate(qvtTransformation, configuration);                    
                    if(status.getSeverity() > IStatus.WARNING) {
                    	throw new CoreException(status);
                    }      	
                	
                	IContext context = new Context(QvtLaunchUtil.getConfiguration(configuration));
                    context.put(QvtOperationalStdLibrary.OUT_PRINT_WRITER, printWriter);
                    context.put(EvaluationContextProperties.MONITOR, execMonitor);
                    
                	QvtLaunchConfigurationDelegateBase.doLaunch(qvtTransformation, configuration, context);
                	
                	qvtTransformation.cleanup();
                }
            };
            
            
            r = getSafeRunnable(qvtTransformation, r);       
            final ShallowProcess process = new ShallowProcess(launch, r) {
            	boolean isTerminated = false;
            	@Override
            	public void terminate() throws DebugException {            		
            		execMonitor.cancel();
            		isTerminated = true;	            		
            		super.terminate();            		
            	}

            	@Override
            	public boolean isTerminated() {            	
            		return isTerminated;
            	}
            	
            	@Override
            	public boolean canTerminate() {
            		return !isTerminated();
            	}
            };
            
            process.setStreamsProxy(streamsProxy);
            
            Thread processThread = new Thread(new Runnable() {
            	public void run() {
                    try {
						process.run();
					} catch (Exception e) {
						if(e instanceof QvtRuntimeException == false) {
							// QVT runtime exception are legal QVT transformation level errors
							QvtPlugin.log(e);							
						}
					}
					
					try {
						launch.terminate();
					} catch (DebugException e) {
						QvtPlugin.log(e);
					}
            	}
            }, "QVT Run");
            
            processThread.start();
		}
		catch(Exception e) {
			throw new CoreException(org.eclipse.m2m.internal.qvt.oml.runtime.util.MiscUtil.makeErrorStatus(e));
		}
	}

	private EvaluationMonitor createMonitor() {
		return new EvaluationMonitor() {
			boolean fIsCanceled = false;
			
			public void cancel() {
				fIsCanceled = true;
			}
			
			public boolean isCanceled() {
				return fIsCanceled;
			}
		};
	}
    
    
    @Override
	protected boolean existsProblems(IProject proj) throws CoreException {
        IMarker[] markers = proj.findMarkers(QvtCompiler.PROBLEM_MARKER, true, IResource.DEPTH_INFINITE);
        for (int i = 0; i < markers.length; i++) {
            if (isLaunchProblem(markers[i])) {
                return true;
            }
        }

        return false;
    }

}
