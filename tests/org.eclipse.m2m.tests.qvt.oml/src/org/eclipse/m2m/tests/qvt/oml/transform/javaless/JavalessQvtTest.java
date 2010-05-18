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
package org.eclipse.m2m.tests.qvt.oml.transform.javaless;

import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;
import org.eclipse.m2m.tests.qvt.oml.transform.TestDataMapper;
import org.eclipse.m2m.tests.qvt.oml.transform.TestQvtInterpreter;

public class JavalessQvtTest extends TestQvtInterpreter {
		
	private static final String PREFIX = "javaless_"; //$NON-NLS-1$
	 
	public JavalessQvtTest(String testName) {
		this(createJavalessData(TestDataMapper.getTestDataByTestNameWithPrefix(PREFIX, testName)));
	}

	public JavalessQvtTest(ModelTestData testData) {
		super(createJavalessData(testData));		
		setName(PREFIX + testData.getName());
	}
	
	public static JavalessFileToFileData createJavalessData(ModelTestData testData) {
		if(testData instanceof JavalessFileToFileData) {
			return (JavalessFileToFileData) testData;
		}
		
		if(!JavalessUtil.isValidJavalessData(testData)) {
			throw new IllegalArgumentException("Not a valid javaless test"); //$NON-NLS-1$
		}
		
		return new JavalessFileToFileData(testData);
	}
	
}
