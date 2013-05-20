/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.common.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


public class CFileUtil {
	private CFileUtil() {}
	
	public static void copyFolder(CFolder sourceDir, CFolder destDir) throws IOException {
        CResource[] children = sourceDir.members();
        for(int i = 0;  i < children.length; i++) {
        	CResource source = children[i];
            if(source instanceof CFolder) {
				CFolder sourceFolder = (CFolder)source;
	            CFolder destFolder = destDir.getFolder(sourceFolder.getName());
            	destFolder.create();
                copyFolder(sourceFolder, destFolder);
            }
            else {
				CFile sourceFile = (CFile)source;
				CFile destFile = destDir.getFile(source.getName());
				copyFile(sourceFile, destFile);
            }
        }
    }
    
    public static void copyFile(CFile from, CFile to) throws IOException {
    	InputStream contents = null;
		try {
			contents = from.getContents();
			if(to.exists()) {
				to.setContents(contents);
			}
			else {
				to.create(contents);
			}
    	}
		finally {
			if(contents != null) {
				try { contents.close(); } catch(Exception e) {}
			}
		}
    }

    
    public static Reader getReader(CFile file) throws IOException {
    	String charset = file.getCharset();
    	
    	Reader reader;
    	if(charset == null) {
    		reader = new InputStreamReader(file.getContents());
    	}
    	else {
    		reader = new InputStreamReader(file.getContents(), charset);
    	}
    	
    	return reader;
    }
    
    public static InputStream getContentStreamForFile(CFile file, String contents) throws IOException {
    	String charset = getFileCharset(file);
    	InputStream stream;
    	if(charset == null) {
    		stream = new ByteArrayInputStream(contents.getBytes());
    	}
    	else {
    		stream = new ByteArrayInputStream(contents.getBytes(charset));
    	}
    	
    	return stream;
    }
    
    public static String getFileCharset(CFile file) throws IOException {
    	String charset;
    	if(file.exists()) {
    		charset = file.getCharset();
    	}
    	else {
    		charset = file.getParent().getDefaultCharset();
    	}
    	
    	return charset;
    }
}
