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
package org.eclipse.m2m.tests.qvt.oml;

import junit.framework.TestCase;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.qvt.oml.common.launch.TargetUriData.TargetType;

public class TestLaunchConfiguration extends TestCase {
    
    private static final String IN_ECORE = "platform:/resource/porject/in.ecore"; //$NON-NLS-1$
    private static final String OUT_ECORE_NEW = "platform:/resource/porject/out.ecore"; //$NON-NLS-1$
    private static final String OUT_ECORE_EXISTING = "platform:/resource/project/out.ecore#//@eClassifiers.0"; //$NON-NLS-1$
    
    public static final TestLaunchConfiguration TEST = new TestLaunchConfiguration();
    
    public TestLaunchConfiguration() {
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testEmptyEmpty() throws Throwable {
        performTest("", "", TargetType.NEW_MODEL);  //$NON-NLS-1$//$NON-NLS-2$
    }

    public void testEcoreNew() throws Throwable {
        performTest(IN_ECORE, OUT_ECORE_NEW, TargetType.NEW_MODEL);
    }

    public void testEcoreInplace() throws CoreException {
        performTest(IN_ECORE, IN_ECORE, TargetType.INPLACE);
    }

    public void testEcoreExsisting() throws CoreException {
        performTest(IN_ECORE, OUT_ECORE_EXISTING, TargetType.EXISTING_CONTAINER);
    }

    private void performTest(String in, String out, TargetType targetType) throws CoreException {
        ILaunchConfigurationType type = DebugPlugin.getDefault().getLaunchManager().getLaunchConfigurationType("org.eclipse.m2m.qvt.oml.QvtTransformation"); //$NON-NLS-1$
        ILaunchConfigurationWorkingCopy copy = type.newInstance(null, "testOne"); //$NON-NLS-1$
        copy.setAttribute(IQvtLaunchConstants.SOURCE_MODEL, in);
        copy.setAttribute(IQvtLaunchConstants.TARGET_MODEL, out);
        TargetUriData targetUriData = QvtLaunchUtil.getTargetUriData(copy.doSave());
        assertEquals(targetUriData.getTargetType().toString(), targetUriData.getTargetType(), targetType);
    }
}
