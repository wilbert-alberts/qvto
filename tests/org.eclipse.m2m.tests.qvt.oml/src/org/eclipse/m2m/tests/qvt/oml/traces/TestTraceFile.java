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
package org.eclipse.m2m.tests.qvt.oml.traces;

import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.tests.qvt.oml.transform.FileToFileData;
import org.eclipse.m2m.tests.qvt.oml.transform.TestQvtInterpreter;
import org.eclipse.m2m.tests.qvt.oml.transform.TestTransformation;



public class TestTraceFile extends TestTransformation {
	public TestTraceFile() {
		super(new FileToFileData("multipletracerecords")); //$NON-NLS-1$
	}
	
	public void testInterpretedDuplication() throws Exception {
		checkDuplication(TestQvtInterpreter.TRANSFORMER);
	}

	private void checkDuplication(ITransformer transformer) throws Exception {
        Trace trace = TraceUtil.transform(getData(), getProject(), transformer);
        assertTrue(trace.getTraceRecords().size() == 5);
	}
}
