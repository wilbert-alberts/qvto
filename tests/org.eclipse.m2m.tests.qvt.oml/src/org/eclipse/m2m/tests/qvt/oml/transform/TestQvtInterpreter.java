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
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.qvt.oml.ast.environment.ModelExtentContents;
import org.eclipse.m2m.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.qvt.oml.library.IContext;

public class TestQvtInterpreter extends TestTransformation {
    public TestQvtInterpreter(ModelTestData data) {
        super(data);
        setName("interpret_" + data.getName()); //$NON-NLS-1$
    }
    
    @Override
	public void runTest() throws Exception {
        checkTransformation(new TransformationChecker(TRANSFORMER));
    }
    
    public static final ITransformer TRANSFORMER = new ITransformer() {
        public List<EObject> transform(IFile transformation, List<URI> inUris, IContext qvtContext) throws Exception {
        	QvtTransformation trans = new QvtInterpretedTransformation(transformation);
            
        	List<EObject> inputs = new ArrayList<EObject>(inUris.size());
        	for (URI uri : inUris) {
        		EObject in = EmfUtil.loadModel(uri);
        		inputs.add(in);
        	}
            TransformationRunner.In input = new TransformationRunner.In(inputs.toArray(new EObject[inputs.size()]), qvtContext);
            
            TransformationRunner.Out output = trans.run(input);
            
            List<ModelExtentContents> extents = output.getExtents();
            List<EObject> result = new ArrayList<EObject>();
            for (ModelExtentContents outExtent : extents) {
            	if (!outExtent.getAllRootElements().isEmpty()) {
                    saveModel(outExtent, new EclipseFile(transformation));            		
            	}
            }
            saveTraceData(output.getTrace(), new EclipseFile(transformation));
            return result;
        }
    };
}
