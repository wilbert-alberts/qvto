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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.m2m.internal.qvt.oml.runtime.QvtRuntimePlugin;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtProjectTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.MiscUtil;
import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.common.launch.EmptyDebugTarget;
import org.eclipse.m2m.qvt.oml.common.launch.ShallowProcess;
import org.eclipse.m2m.qvt.oml.common.launch.StreamsProxy;

public class NonInterpretedQvtLaunchConfigurationDelegate extends QvtLaunchConfigurationDelegateBase {
	public void launch(final ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
        
        IFile moduleFile = getModuleFile(configuration);
        final QvtTransformation transformation = new QvtProjectTransformation(moduleFile);

        final StreamsProxy streamsProxy = new StreamsProxy();
        
        ShallowProcess.IRunnable r = new ShallowProcess.IRunnable() {
            public void run() throws Exception {
                doLaunch(transformation, configuration, new PrintWriter(streamsProxy.getOutputWriter()));
            }
        };
        
        r = getSafeRunnable(transformation, r);
        
        ShallowProcess process = new ShallowProcess(launch, r);
        process.setStreamsProxy(streamsProxy);
        EmptyDebugTarget debugTarget = new EmptyDebugTarget(launch, process, QvtRuntimePlugin.ID, MDAConstants.QVTO_LAUNCH_CONFIGURATION_NAME);

        try {
            process.run(debugTarget);
        }
        catch(Exception e) {
            throw new CoreException(MiscUtil.makeErrorStatus(org.eclipse.m2m.qvt.oml.emf.util.StatusUtil.getExceptionMessages(e), e));
        }
        finally {
            debugTarget.terminate();
        }
    }
}
