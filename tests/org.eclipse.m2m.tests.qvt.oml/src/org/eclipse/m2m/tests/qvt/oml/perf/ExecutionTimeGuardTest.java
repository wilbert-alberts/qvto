/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.perf;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;

/**
 * @author dvorak
 */
public class ExecutionTimeGuardTest extends TestCase {
	
	public ExecutionTimeGuardTest(String name) {
		super(name);
	}
	
	public void testTraceLookup_287589() throws Exception {
		assertSuccessExecutionTime(
			"org.eclipse.m2m.tests.qvt.oml/deployed/perf/traceLookup_287589.qvto", //$NON-NLS-1$
			2000);
	}
	
	private static void assertSuccessExecutionTime(String transfPath, long limitInMs) {
		URI uri = URI.createPlatformPluginURI(transfPath, false); //$NON-NLS-1$
		TransformationExecutor executor = new TransformationExecutor(uri);
		ExecutionContextImpl context = new ExecutionContextImpl();
		
		long end = System.currentTimeMillis();		
		ExecutionDiagnostic result = executor.execute(context, new BasicModelExtent());		
		long start = System.currentTimeMillis();
		
		assertTrue(result.getSeverity() == Diagnostic.OK);
		assertTrue(limitInMs > end - start);
	}
	
}
