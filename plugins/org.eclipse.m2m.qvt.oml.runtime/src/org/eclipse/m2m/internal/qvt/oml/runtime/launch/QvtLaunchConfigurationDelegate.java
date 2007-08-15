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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalStdLibrary;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompiler;

import org.eclipse.m2m.qvt.oml.common.launch.ShallowProcess;
import org.eclipse.m2m.qvt.oml.common.launch.StreamsProxy;
import org.eclipse.m2m.qvt.oml.library.Context;
import org.eclipse.m2m.qvt.oml.library.IContext;

public class QvtLaunchConfigurationDelegate extends QvtLaunchConfigurationDelegateBase {
	
	public QvtLaunchConfigurationDelegate() {
	}
	
	public void launch(final ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
        
		try {
            final IFile moduleFile = getModuleFile(configuration);            
            final QvtTransformation qvtTransformation = new QvtInterpretedTransformation(moduleFile);
                        
            
            StreamsProxy streamsProxy = new StreamsProxy();
            final PrintWriter printWriter = new PrintWriter(streamsProxy.getOutputWriter());   
            ShallowProcess.IRunnable r = new ShallowProcess.IRunnable() {
                @SuppressWarnings("unchecked")
                public void run() throws Exception { 
                    IStatus status = QvtLaunchConfigurationDelegateBase.validate(qvtTransformation, configuration);                    
                    if(status.getSeverity() > IStatus.WARNING) {
                    	throw new CoreException(status);
                    }                	
                	
                	IContext context = new Context(QvtLaunchUtil.getConfiguration(configuration));
                    context.put(QvtOperationalStdLibrary.OUT_PRINT_WRITER, printWriter);

                	QvtLaunchConfigurationDelegateBase.doLaunch(qvtTransformation, configuration, context);
                }
            };
            
            r = getSafeRunnable(qvtTransformation, r);                        
            ShallowProcess process = new ShallowProcess(launch, r);
            process.setStreamsProxy(streamsProxy);
            process.run();        
		}
		catch(Exception e) {
			throw new CoreException(org.eclipse.m2m.internal.qvt.oml.runtime.util.MiscUtil.makeErrorStatus(e));
		}
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
