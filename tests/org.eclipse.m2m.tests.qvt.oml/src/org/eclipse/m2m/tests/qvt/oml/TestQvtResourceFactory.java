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

package org.eclipse.m2m.tests.qvt.oml;

import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.m2m.tests.qvt.oml.transform.FileToFileData;
import org.eclipse.m2m.tests.qvt.oml.transform.TestTransformation;

/**
 * @author sboyko
 *
 */
public class TestQvtResourceFactory extends TestTransformation {
	public TestQvtResourceFactory() {
		super(new FileToFileData(TEST_MODEL_NAME));
	}
	
	public void testResourceLoad() throws Exception {
		IFile testFile = getProject().getFile(
				"models/" + TEST_MODEL_NAME + "/" + TEST_MODEL_NAME + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT); //$NON-NLS-1$
		URI fileUri = URI.createFileURI(testFile.getFullPath().toOSString());
		Resource resource = Resource.Factory.Registry.INSTANCE.getFactory(fileUri).createResource(fileUri);
		resource.load(Collections.emptyMap());
		assertTrue(resource.getContents().get(0) instanceof Module);
	}
	
	private static final String TEST_MODEL_NAME = "abstractresult"; //$NON-NLS-1$

}
