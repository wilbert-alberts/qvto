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

import java.io.File;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.qvt.oml.common.emf.ExtendedEmfUtil;
import org.eclipse.m2m.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.m2m.qvt.oml.library.IContext;
import org.eclipse.m2m.tests.qvt.oml.transform.FileToFileData;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;
import org.eclipse.m2m.tests.qvt.oml.transform.TestQvtInterpreter;
import org.eclipse.m2m.tests.qvt.oml.transform.TestTransformation.IChecker;
import org.eclipse.m2m.tests.qvt.oml.transform.TestTransformation.ITransformer;
import org.eclipse.m2m.tests.qvt.oml.transform.TestTransformation.TransformationChecker;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;


public class TestMdaBuilder extends TestCase {
	public TestMdaBuilder() {
		myTest = new TestQvtInterpreter(new FileToFileData("addclass")); //$NON-NLS-1$ // TODO
	}
	
	@Override
	public void setUp() throws Exception {
		myTest.setUp();
        //-MDANatureImpl.addBuilder(getTestProject().getProject());
	}
	
    @Override
	public void tearDown() throws Exception {
        myTest.tearDown();
    }

	public void testMdaBuilder() throws Throwable {
        ITransformer transformer = new ITransformer() {
            public EObject transform(IFile transformation, List<URI> inUris, IContext context) throws Exception {
                try {
                    String baseName = transformation.getName();
                    baseName = baseName.substring(0, baseName.length() - transformation.getFileExtension().length());
                    IFile outFile = WorkspaceUtils.getIFile(transformation.getParent().getLocation().toOSString() + File.separator + baseName + "ecore"); //$NON-NLS-1$
                    
                    String transformationId = "models.addclass.addclass"; //$NON-NLS-1$
                    String inUriString = inUris.get(0).toString();
                    String outUriString = getUriString(outFile);
                    launch(transformationId, inUriString, outUriString);

                    EObject out = ExtendedEmfUtil.loadModel(new EclipseFile(outFile));
                    return out;
                }
                finally {
                    TestUtil.deleteJavaFiles(myTest.getProject());
                }
            }
        };
        
        IChecker checker = new TransformationChecker(transformer);
        ModelTestData data = new FileToFileData("addclass"); //$NON-NLS-1$
        checker.check(data, myTest.getProject());
	}
    
    private static final String getUriString(IFile file) {
        URI uri = URI.createFileURI(file.getLocation().toOSString());
        return uri.toString();
    }
    
    private static void launch(String transformationId, String inUriString, String outUriString) throws Exception {
        ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
        ILaunchConfigurationType type = manager.getLaunchConfigurationType("org.eclipse.m2m.qvt.oml.QvtCompiledTransfomation"); //$NON-NLS-1$
        
        ILaunchConfigurationWorkingCopy workingCopy = type.newInstance(null, "_qvt_"); //$NON-NLS-1$
        workingCopy.setAttribute("org.eclipse.debug.ui.ATTR_LAUNCH_IN_BACKGROUND", false); //$NON-NLS-1$
        
        workingCopy.setAttribute(IQvtLaunchConstants.TRANSFOMATION_ID, transformationId);
        workingCopy.setAttribute(IQvtLaunchConstants.SOURCE_MODEL, inUriString);
        workingCopy.setAttribute(IQvtLaunchConstants.TARGET_MODEL, outUriString);
        
        DebugUITools.launch(workingCopy, ILaunchManager.RUN_MODE);        
    }
	
	private final TestQvtInterpreter myTest;
}
