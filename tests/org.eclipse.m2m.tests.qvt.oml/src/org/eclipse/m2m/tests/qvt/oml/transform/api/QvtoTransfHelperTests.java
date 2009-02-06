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
package org.eclipse.m2m.tests.qvt.oml.transform.api;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.core.resources.IProject;
import org.eclipse.m2m.tests.qvt.oml.transform.FilesToFilesData;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;

/**
 * @author sboyko
 */
public class QvtoTransfHelperTests {
	public static Test suite() {
		return interpreterSuite();
	}
	
    public static TestSuite interpreterSuite() {
		TestSuite suite = new TestSuite("QVT transformation api tests"); //$NON-NLS-1$
		
		suite.addTest(new InputExtensionsTestCase(
				new ApiTestData("twoInputs", Arrays.asList("in.uml", "in.rdb"), Arrays.asList("out.ecore")))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		suite.addTest(new ImportedTransfTestCase(
				new ApiTestData("imports", Collections.<String>emptyList(), Arrays.asList("imports.qvto", "q1.qvto", "q2.qvto", "nested2/q4.qvto", "nested/q3.qvto")))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$

		suite.addTest(new ExecTransformationTestCase(
				new ApiTestData("exec1", Arrays.asList("in1.ecore", "in2.ecore"), Arrays.asList("expected.simpleuml", "expected.rdb")))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
		suite.addTest(new ExecTransformationTestCase(
				new ApiTestData("exec2", Arrays.asList("in1.ecore", "in2.ecore"), Arrays.asList("expected.simpleuml", "expected.rdb")))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
		suite.addTest(new ExecTransformationTestCase(
				new ApiTestData("exec3", Collections.<String>emptyList(), Collections.<String>emptyList()))); //$NON-NLS-1$

		suite.addTest(new ExecDeployedTransformationTestCase(false,
				new ApiTestData("exec1", Arrays.asList("in1.ecore", "in2.ecore"), Arrays.asList("expected.simpleuml", "expected.rdb")))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
		suite.addTest(new ExecDeployedTransformationTestCase(false,
				new ApiTestData("exec3", Collections.<String>emptyList(), Collections.<String>emptyList()))); //$NON-NLS-1$
		suite.addTest(new ExecDeployedTransformationTestCase(false,
				new ApiTestData("exec3_withImport", Collections.<String>emptyList(), Collections.<String>emptyList()))); //$NON-NLS-1$
		
		suite.addTest(new ExecDeployedTransformationTestCase(true,
				new ApiTestData("exec1", Arrays.asList("in1.ecore", "in2.ecore"), Arrays.asList("expected.simpleuml", "expected.rdb")))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
		suite.addTest(new ExecDeployedTransformationTestCase(true,
				new ApiTestData("exec2", Arrays.asList("in1.ecore", "in2.ecore"), Arrays.asList("expected.simpleuml", "expected.rdb")))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
		suite.addTest(new ExecDeployedTransformationTestCase(true,
				new ApiTestData("exec3", Collections.<String>emptyList(), Collections.<String>emptyList()))); //$NON-NLS-1$
		suite.addTest(new ExecDeployedTransformationTestCase(true,
				new ApiTestData("exec3_withImport", Collections.<String>emptyList(), Collections.<String>emptyList()))); //$NON-NLS-1$
		suite.addTest(new WrappedExecTransformationTestCase(true,
				new ApiTestData("exec_erroneous", Collections.<String>emptyList(), Collections.<String>emptyList()))); //$NON-NLS-1$
		
		return suite;
    }
    
    private static class ApiTestData extends FilesToFilesData {
    	public ApiTestData(String name, List<String> fromFiles, List<String> expectedFiles) {
            super(name, fromFiles, expectedFiles);
        }

        @Override
		protected File getDestFolder(IProject project) {
            try {
                return ApiTestData.getDestFolder(getName(), project);
            }
            catch(IOException e) {
                throw new RuntimeException(e);
            }
        }
        
        private static File getDestFolder(String name, IProject project) throws IOException {
            File srcRootFolder = TestUtil.getPluginRelativeFile(TestUtil.BUNDLE, ApiTestCase.ROOT_DIR_NAME);
            File srcFolder = ApiTestData.getFolder(srcRootFolder, name);
            File destFolder = ApiTestData.getFolder(new File(project.getLocation().toString() + "/models/"), srcFolder.getName()); //$NON-NLS-1$
            return destFolder;
        }
        
        private static File getFolder(File folder, final String expectedName) {
            File dir = new File(folder, expectedName);
            if(!dir.exists() || !dir.isDirectory()) {
                throw new IllegalArgumentException("Invalid directory: " + dir); //$NON-NLS-1$
            }
            
            return dir;
        }
    }
}
