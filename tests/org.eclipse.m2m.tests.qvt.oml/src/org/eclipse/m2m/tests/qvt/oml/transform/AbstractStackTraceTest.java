/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation
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
import java.io.StringWriter;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelExtentContents;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.m2m.internal.qvt.oml.library.QvtConfiguration;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.qvt.oml.util.WriterLog;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;

public abstract class AbstractStackTraceTest extends TestTransformation {

	protected boolean fEnableLineNumbers = true;
	protected StringWriter fLogger = new StringWriter();
	
	protected static void assertValidQVTRuntimeException(QvtRuntimeException exception) {
		assertNotNull(exception.getQvtStackTrace());
		assertTrue(exception.getQvtStackTrace().size() > 0);
	}

	protected QvtRuntimeException runQvtModuleTestCase(String testCaseName) throws Exception {
		return runQvtModuleTestCase(testCaseName, null);
	}
	
	protected QvtRuntimeException runQvtModuleTestCase(String testCaseName, Map<String, String> configProperties) throws Exception {
	    ITransformer transformer = createTransformer();
		try {
			Map<String, String> passedProps = (configProperties == null) ? Collections.<String, String>emptyMap() : configProperties;
			Map<String, String> extProps = new HashMap<String, String>(passedProps);
			extProps.put("testcase", testCaseName);		//$NON-NLS-1$		
			IContext context = new Context(new QvtConfiguration(extProps));
			
			transformer.transform(
					getIFile(getData().getTransformation(getProject())),
					getData().getIn(getProject()), context);
		} catch (QvtRuntimeException e) {
			return e;			
		}
		
		return null;
	}

	protected String loadExpectedStackDump(String testCase) throws IOException {
		return loadExpectedDump(testCase + ".stack"); //$NON-NLS-1$
	}

	protected void assertLogMatch(String testCase) throws Exception {
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
	        public LinkedHashMap<ModelExtentContents, URI> transform(IFile transformation, List<URI> inUris, IContext context) throws Exception {
	        	QvtInterpretedTransformation transf = new QvtInterpretedTransformation(transformation);
	        	
	        	QvtCompilerOptions options = new QvtCompilerOptions();
	        	options.setGenerateCompletionData(false);
	        	options.setSourceLineNumbersEnabled(fEnableLineNumbers);	        	
	        	transf.setQvtCompilerOptions(options);
	        	
	        	Context qvtContext = new Context(context.getConfiguration());
	        	qvtContext.setLog(new WriterLog(fLogger));
	            
	        	List<EObject> inputs = new ArrayList<EObject>(inUris.size());
	        	for (URI uri : inUris) {
	        		EObject in = transf.loadInput(uri);
	        		inputs.add(in);
	        	}
	            TransformationRunner.In input = new TransformationRunner.In(inputs.toArray(new EObject[inputs.size()]), qvtContext);	            
	            TransformationRunner.Out output = transf.run(input);

	            List<ModelExtentContents> extents = output.getExtents();
	            LinkedHashMap<ModelExtentContents, URI> result = new LinkedHashMap<ModelExtentContents, URI>(); 
	            int i = 0;
	            for (ModelExtentContents outExtent : extents) {
	                URI extentURI = saveModel("extent" + (++i), outExtent, new EclipseFile(transformation));
	                result.put(outExtent, extentURI);
	            }
	            
	            saveTraceData(output.getTrace(), new EclipseFile(transformation));	            
	        	TestUtil.assertAllPersistableAST(transf.getModule().getModule());	        	
	            
	            return result;
	        }
		};
	}	

	public AbstractStackTraceTest(ModelTestData data) {
		super(data);
	}

}