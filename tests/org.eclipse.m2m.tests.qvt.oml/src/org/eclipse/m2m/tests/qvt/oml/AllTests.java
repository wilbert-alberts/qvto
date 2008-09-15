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
/*
 * Created on Feb 7, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.eclipse.m2m.tests.qvt.oml;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.m2m.tests.qvt.oml.ant.QvtAntScriptTests;
import org.eclipse.m2m.tests.qvt.oml.emf.AllEmfTests;
import org.eclipse.m2m.tests.qvt.oml.traces.TestTraceFile;
import org.eclipse.m2m.tests.qvt.oml.transform.TransformManyModelTests;
import org.eclipse.m2m.tests.qvt.oml.transform.TransformTests;
import org.eclipse.m2m.tests.qvt.oml.transform.api.QvtoTransfHelperTests;


/**
 * @author vrepeshko
 * 
 */
public class AllTests {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(AllTests.suite());
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("Tests for org.eclipse.m2m.tests.qvt.oml"); //$NON-NLS-1$
		//$JUnit-BEGIN$
		suite.addTestSuite(OCLEnvironmentWithQVTAccessTest.class);
		suite.addTestSuite(TestExternHelperCall.class);
// FIXME - commented out to test I-build with the common builder
//suite.addTest(AllEditorTests.suite());
		suite.addTest(AllEmfTests.suite());
		suite.addTestSuite(TestMetamodelRegistry.class);
        suite.addTestSuite(TestLaunchConfiguration.class);
        suite.addTest(ParserTests.suite());

//        suite.addTest(TransformTests.projectSuite());
        suite.addTest(TransformTests.interpreterSuite());
        suite.addTest(TransformTests.javalessSuite());
        suite.addTest(TransformTests.walkerSuite());
        suite.addTest(TransformManyModelTests.interpreterSuite());
        suite.addTest(QvtoTransfHelperTests.suite());
        
        suite.addTestSuite(TestQvtBuilder.class);        
        suite.addTestSuite(TestSamples.class);
        suite.addTestSuite(TestGraphWalker.class);
        suite.addTestSuite(TestLaunchConfigs.class);
//        suite.addTestSuite(TestModelElementSaver.class);
        suite.addTestSuite(TestTraceFile.class);
        suite.addTestSuite(TestQvtResourceFactory.class);
//        suite.addTestSuite(TestTraceFileForMyUml.class);
//        suite.addTestSuite(TestTreeContentProvider.class);
        
        suite.addTestSuite(TestOCLSemantics.class);
        suite.addTestSuite(TestOCLAnnotationSupport.class);     
                
        suite.addTest(QvtAntScriptTests.suite());
		//$JUnit-END$
		return suite;
	}
}
