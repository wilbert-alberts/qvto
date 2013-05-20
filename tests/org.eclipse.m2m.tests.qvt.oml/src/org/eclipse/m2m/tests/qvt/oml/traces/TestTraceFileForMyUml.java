/*******************************************************************************
 * Copyright (c) 2007, 2008 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.traces;

import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;
import org.eclipse.m2m.tests.qvt.oml.transform.TestQvtInterpreter;
import org.eclipse.m2m.tests.qvt.oml.transform.TestTransformation;



public class TestTraceFileForMyUml extends TestTransformation {
//	public TestTraceFileForMyUml() {
//		super(new MyUmlToMyUmlData("uml14to20", "uml14", "uml14exp"));  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	}
	
	public TestTraceFileForMyUml(ModelTestData data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	public void testHasTraces() throws Exception {
		ITransformer transformer = TestQvtInterpreter.TRANSFORMER;
        Trace trace = TraceUtil.transform(getData(), getProject(), transformer);
		assertTrue("No traces", !trace.getTraceRecords().isEmpty()); //$NON-NLS-1$
	}
}
