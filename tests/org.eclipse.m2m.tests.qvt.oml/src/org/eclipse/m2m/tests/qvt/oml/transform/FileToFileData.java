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

import java.io.File;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;


public class FileToFileData extends ModelTestData {
    public FileToFileData(String name) {
        this(name, "in.ecore", "expected.ecore");  //$NON-NLS-1$//$NON-NLS-2$
    }
    
    public FileToFileData(String name, String[][] props) {
        this(name, "in.ecore", "expected.ecore", props);  //$NON-NLS-1$//$NON-NLS-2$
    }
    
    public FileToFileData(String name, String fromFile, String expectedFile) {
        this(name, fromFile, expectedFile, new String[][] {});
    }
    
    public FileToFileData(String name, String fromFile, String expectedFile, String[][] props) {
    	this(name, fromFile, expectedFile, makeFileContext(props));
    }
    
    public FileToFileData(String name, String fromFile, String expectedFile, IContext context) {
        super(name, context);
        myFromFile = fromFile;
        myExpectedFile = expectedFile;
    }
    
    @Override
	public List<URI> getIn(IProject project) { 
        File destFolder = getDestFolder(project);
        return Collections.singletonList(URI.createFileURI(getFile(destFolder, myFromFile).getAbsolutePath()));
    }
    
    @Override
	public List<URI> getExpected(IProject project) {
        File destFolder = getDestFolder(project);
        return Collections.singletonList(URI.createFileURI(getFile(destFolder, myExpectedFile).getAbsolutePath())); 
    }
    
    public String getFromFile() {
		return myFromFile;
	}
    
    public String getExpectedFile() {
		return myExpectedFile;
	}
    
    private final String myFromFile;
    private final String myExpectedFile;
}
