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
package org.eclipse.m2m.tests.qvt.oml.transform;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.QvtAssertionFailed;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.QvtRuntimeException;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.QvtStackOverFlowError;

public class TestStackTrace extends AbstractStackTraceTest {
	
	public TestStackTrace() {
		super(new FileToFileData("stacktrace"));
	}

	
	public void testMappingCallInProperty() throws Exception {
		String testCase = "mappingCallInProperty"; //$NON-NLS-1$
		QvtRuntimeException e = runQvtModuleTestCase(testCase);
		assertValidQVTRuntimeException(e);

		
		StringWriter strWriter = new StringWriter();
		e.printQvtStackTrace(new PrintWriter(strWriter));
				
		String dumpedContents = loadExpectedStackDump(testCase);
		assertEquals(dumpedContents.toString(), strWriter.getBuffer().toString());
	}
	
	
	public void testLogExpUsage() throws Exception {
		String testcase = "testLogExpUsage"; //$NON-NLS-1$
		runQvtModuleTestCase(testcase);
		assertLogMatch(testcase);
	}
	
	public void testAssertionFailed() throws Exception {
		String testcase = "assertionFailed"; //$NON-NLS-1$
		QvtRuntimeException e = runQvtModuleTestCase(testcase);						
		assertValidQVTRuntimeException(e);
		assertEquals(QvtAssertionFailed.class, e.getClass());
		
		StringWriter strWriter = new StringWriter();
		e.printQvtStackTrace(new PrintWriter(strWriter));

		String dumpedContents = loadExpectedStackDump(testcase);
		assertEquals(dumpedContents.toString(), strWriter.getBuffer().toString());
		
		assertLogMatch(testcase);		
	}	
	
	public void testStackOverFlow() throws Exception {
		QvtRuntimeException e = runQvtModuleTestCase("stackOverFlow");				
		
		assertValidQVTRuntimeException(e);
		assertEquals(QvtStackOverFlowError.class, e.getClass());		
		assertEquals(StackOverflowError.class, e.getCause().getClass());
		
		int elementCount = 10;	
		for (StackTraceElement element : e.getQvtStackTrace()) {
			if(--elementCount == 0) {
				break;
			}
			assertEquals("causeStackOverFlow", element.getMethodName());
			assertEquals("auxtransf", element.getClassName());			
			assertEquals("auxtransf.qvto", element.getFileName());			
			assertEquals(6, element.getLineNumber());			
		}
	}
	
	/*
	 * Just verifies a complete regular stack trace 
	 */
	public void testCreateInstaceFailure() throws Exception {
		String testCase = "createInstaceFailure";
		QvtRuntimeException e = runQvtModuleTestCase(testCase);
		assertValidQVTRuntimeException(e);

		
		StringWriter strWriter = new StringWriter();
		e.printQvtStackTrace(new PrintWriter(strWriter));
				
		String dumpedContents = loadExpectedStackDump(testCase);
		assertEquals(dumpedContents.toString(), strWriter.getBuffer().toString());		
	}

	public void testUknownSourceStackTrace() throws Exception {
		String testCase = "createInstaceFailure"; //$NON-NLS-1$
		
		fEnableLineNumbers = false;
		QvtRuntimeException e = runQvtModuleTestCase(testCase);
		assertValidQVTRuntimeException(e);

		StringWriter strWriter = new StringWriter();
		e.printQvtStackTrace(new PrintWriter(strWriter));

		String dumpedContents = loadExpectedStackDump("testUknownSourceStackTrace"); //$NON-NLS-1$
		assertEquals(dumpedContents.toString(), strWriter.getBuffer().toString());
	}
}
