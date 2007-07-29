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
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.qvt.oml.library.IContext;


public class FilesToFilesData extends ModelTestData {

	public FilesToFilesData(String name, List<String> fromFiles, List<String> expectedFiles) {
        this(name, fromFiles, expectedFiles, new String[][] {});
    }
    
    public FilesToFilesData(String name, List<String> fromFiles, List<String> expectedFiles, String[][] props) {
    	this(name, fromFiles, expectedFiles, makeFileContext(props));
    }
    
    public FilesToFilesData(String name, List<String> fromFiles, List<String> expectedFiles, IContext context) {
        super(name, context);
        myFromFiles = fromFiles;
        myExpectedFiles = expectedFiles;
    }
    
    @Override
	public List<URI> getIn(IProject project) { 
        File destFolder = getDestFolder(project);
        List<URI> inUris = new ArrayList<URI>(myFromFiles.size());
        for (String inFile : myFromFiles) {
        	inUris.add(URI.createFileURI(getFile(destFolder, inFile).getAbsolutePath()));
        }
        return inUris;
    }
    
    @Override
	public URI getExpected(IProject project) {
        File destFolder = getDestFolder(project);
        List<URI> outUris = new ArrayList<URI>(myExpectedFiles.size());
        for (String outFile : myExpectedFiles) {
        	outUris.add(URI.createFileURI(getFile(destFolder, outFile).getAbsolutePath()));
        }
        return outUris.get(0); 
    }
    
    public List<String> getFromFiles() {
		return myFromFiles;
	}
    
    public List<String> getExpectedFiles() {
		return myExpectedFiles;
	}
    
    private final List<String> myFromFiles;
    private final List<String> myExpectedFiles;
}
