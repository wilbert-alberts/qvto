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
package org.eclipse.m2m.tests.qvt.oml.callapi;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllCallAPITests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.m2m.tests.qvt.oml.callapi"); //$NON-NLS-1$
		//$JUnit-BEGIN$
		suite.addTestSuite(BasicModelExtentTest.class);
		suite.addTestSuite(InvocationTest.class);
		suite.addTestSuite(InvocationExtTest.class);
		suite.addTestSuite(DynamicModelInvocationTest.class);
		suite.addTestSuite(DynamicRegisteredModelInvocationTest.class);
		suite.addTestSuite(ChildInTreeInputInvocationTest.class);
		
		//$JUnit-END$
		return suite;
	}

}
