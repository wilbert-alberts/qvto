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

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalStdLibrary;
import org.eclipse.m2m.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.QvtAssertionFailed;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.QvtRuntimeException;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.QvtStackOverFlowError;
import org.eclipse.m2m.qvt.oml.library.Context;
import org.eclipse.m2m.qvt.oml.library.IContext;
import org.eclipse.m2m.qvt.oml.library.QvtConfiguration;

public class TestStackTrace extends TestTransformation {

	private boolean fEnableLineNumbers = true;
	private StringWriter fLogger = new StringWriter();
	
	public TestStackTrace() {
		super(new FileToFileData("stacktrace"));
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
	
	
	private QvtRuntimeException runQvtModuleTestCase(String testCaseName) throws Exception {
        ITransformer transformer = createTransformer();
		try {	
			Map<String, String> extProps = new HashMap<String, String>();
			extProps.put("testcase", testCaseName);				
			IContext context = new Context(new QvtConfiguration(extProps));
			
			transformer.transform(
					getIFile(getData().getTransformation(getProject())),
					getData().getIn(getProject()), context);
		} catch (QvtRuntimeException e) {
			return e;			
		}
		
		return null;
	}
	

	private String loadExpectedStackDump(String testCase) throws IOException {
		return loadExpectedDump(testCase + ".stack"); //$NON-NLS-1$
	}
	
	private void assertLogMatch(String testCase) throws Exception {
		String expectedContents = loadExpectedLogDump(testCase);
		assertFalse("Non-empty log expected", expectedContents.length() == 0); //$NON-NLS-1$
		
		String logContents = fLogger != null ? fLogger.getBuffer().toString() : ""; //$NON-NLS-1$
		assertFalse("Non-empty log expected", logContents.length() == 0); //$NON-NLS-1$
		
		assertEquals(expectedContents, logContents);
	}
	
	private String loadExpectedLogDump(String testCase) throws IOException {
		return loadExpectedDump(testCase + ".log.txt"); //$NON-NLS-1$
	}
	
	private String loadExpectedDump(String fileName) throws IOException {
		File parentFolder = getData().getTransformation(getTestProject().getProject()).getParentFile();
		FileReader freader = new FileReader(new File(parentFolder, fileName));
		
		CharBuffer buf = CharBuffer.allocate(1024);
		StringBuilder result = new StringBuilder();
		
        for (;;) {
            int read = freader.read(buf);            
            if (read < 0) {
                break;
            }
            
            buf.flip();
            result.append(buf);
        }
        
		return result.toString();
	}
	
	private ITransformer createTransformer() {
		return new ITransformer() {
	        public List<EObject> transform(IFile transformation, List<URI> inUris, IContext qvtContext) throws Exception {
	        	QvtInterpretedTransformation transf = new QvtInterpretedTransformation(transformation);
	        	
	        	QvtCompilerOptions options = new QvtCompilerOptions();
	        	options.setGenerateCompletionData(false);
	        	options.setSourceLineNumbersEnabled(fEnableLineNumbers);	        	
	        	transf.setQvtCompilerOptions(options);
	        	
	        	// avoid messy System.err printouts
	        	qvtContext.put(QvtOperationalStdLibrary.OUT_PRINT_WRITER, new PrintWriter(fLogger));
	            
	        	List<EObject> inputs = new ArrayList<EObject>(inUris.size());
	        	for (URI uri : inUris) {
	        		EObject in = EmfUtil.loadModel(uri);
	        		inputs.add(in);
	        	}
	            TransformationRunner.In input = new TransformationRunner.In(inputs.toArray(new EObject[inputs.size()]), qvtContext);
	            
	            TransformationRunner.Out output = transf.run(input);
	            
	            List<Resource> extents = output.getExtents();
	            List<EObject> result = new ArrayList<EObject>();
	            for (Resource outRes : extents) {
	            	if (!outRes.getContents().isEmpty()) {
	            		result.add(outRes.getContents().get(0));
	            	}
	                saveModel(outRes, new EclipseFile(transformation));
	            }
	            saveTraceData(output.getTrace(), new EclipseFile(transformation));
	            return result;
	        }				
		};
	}
	
	private static void assertValidQVTRuntimeException(QvtRuntimeException exception) {
		assertNotNull(exception.getQvtStackTrace());
		assertTrue(exception.getQvtStackTrace().size() > 0);
	}
}
