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


public class TestDataMapper {

    public static ModelTestData getTestDataByTestName(String testName) {
    	final ModelTestData[] testData = TransformTests.createTestData();
    	for (ModelTestData modelTestData : testData) {
			if(testName.equals(modelTestData.getName())) {
				return modelTestData; 
			}
		}
    	throw new IllegalArgumentException("No such test exists"); //$NON-NLS-1$
    }
    
    public static ModelTestData getTestDataByTestNameWithPrefix(String prefix, String testName) {
    	String actualName = testName.substring(prefix.length());
    	return getTestDataByTestName(actualName);
    }
}
