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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelExtentContents;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;

public class TestQvtInterpreter extends TestTransformation {
	
	static final String PREFIX = "interpret_"; //$NON-NLS-1$
	
	public TestQvtInterpreter(String testName) {
		this(TestDataMapper.getTestDataByTestNameWithPrefix(PREFIX, testName));
	}
	
    public TestQvtInterpreter(ModelTestData data) {
        super(data);        
		setName(PREFIX + data.getName()); //$NON-NLS-1$
    }
    
    protected static String getActualTestName(String executedTestName) {
    	return TestDataMapper.getActualTestName(PREFIX, executedTestName);
    }
    
    protected ITransformer getTransformer() {
    	return TRANSFORMER;
    }
    
    @Override
    public void setUp() throws Exception {
    	super.setUp();
    }
    
    @Override
	public void tearDown() throws Exception {
		super.tearDown();
	}    
    
    @Override
	public void runTest() throws Exception {
        checkTransformation(new TransformationChecker(getTransformer()));
    }
    
    public static final ITransformer TRANSFORMER = new DefaultTransformer();
    
	public static class DefaultTransformer implements ITransformer {
		
		public DefaultTransformer() {
			super();
		}
		
		protected QvtInterpretedTransformation getTransformation(IFile transformation) {
			return new QvtInterpretedTransformation(transformation);
		}
		
		public LinkedHashMap<ModelExtentContents, URI> transform(IFile transformation, List<URI> inUris, IContext qvtContext) throws Exception {
        	QvtInterpretedTransformation trans = getTransformation(transformation);
        	
        	TestUtil.assertAllPersistableAST(trans.getModule().getModule());
            
        	List<EObject> inputs = new ArrayList<EObject>(inUris.size());
        	for (URI uri : inUris) {
        		EObject in = EmfUtil.loadModel(uri);
        		inputs.add(in);
        	}
            TransformationRunner.In input = new TransformationRunner.In(inputs.toArray(new EObject[inputs.size()]), qvtContext);
            TransformationRunner.Out output = null;
            try {
            	output = trans.run(input);
            } catch (QvtRuntimeException e) {            	
            	TestUtil.logQVTStackTrace(e);
				throw e;
			}

            List<ModelExtentContents> extents = output.getExtents();
            LinkedHashMap<ModelExtentContents, URI> result = new LinkedHashMap<ModelExtentContents, URI>(); 
            int i = 0;
            for (ModelExtentContents outExtent : extents) {
                URI extentURI = saveModel("extent" + (++i), outExtent, new EclipseFile(transformation));
                result.put(outExtent, extentURI);
            }
            
            saveTraceData(output.getTrace(), new EclipseFile(transformation));
            return result;
        }
    };
}
