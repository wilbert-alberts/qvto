/*******************************************************************************
 * Copyright (c) 2008, 2010 Borland Software Corporation and others.
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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.io.FileUtil;
import org.eclipse.m2m.qvt.oml.util.IContext;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;
import org.eclipse.m2m.tests.qvt.oml.transform.TestDataMapper;
import org.eclipse.m2m.tests.qvt.oml.transform.TestQvtInterpreter;

public class JavalessQvtTest extends TestQvtInterpreter {
		
	private static final String PREFIX = "javaless_"; //$NON-NLS-1$
	
	private final boolean isPatchOutput;
	 
	public JavalessQvtTest(String testName) {
		this(createJavalessData(TestDataMapper.getTestDataByTestNameWithPrefix(PREFIX, testName)), false);
	}

	public JavalessQvtTest(ModelTestData testData, boolean patchOutput) {
		super(createJavalessData(testData));
		setName(PREFIX + testData.getName());
		isPatchOutput = patchOutput;
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
	
	@Override
	protected ITransformer getTransformer() {
		return new DefaultTransformer(true, getMetamodelRegistry()) {
			@Override
			public List<URI> transform(IFile transformation, List<URI> inUris, IContext qvtContext) throws Exception {
				List<URI> outUris = super.transform(transformation, inUris, qvtContext);
				processOutputUri(outUris);
				return outUris;
			}
		};
	}

	protected void processOutputUri(List<URI> outUris) throws Exception {
		if (!isPatchOutput) {
			return;
		}
		for (URI uri : outUris) {
			String filePath = uri.toFileString();
			File file = new File(filePath);
			String contents = FileUtil.getStreamContents(new FileInputStream(file), ModelTestData.ENCODING);
			contents = JavalessUtil.patchContents(contents);
			FileUtil.setContents(file, new ByteArrayInputStream(contents.getBytes(ModelTestData.ENCODING)));
		}
	}
}
