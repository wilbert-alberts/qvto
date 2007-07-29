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
package org.eclipse.m2m.qvt.oml.samples.wizards;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.m2m.qvt.oml.common.util.Pair;
import org.eclipse.m2m.qvt.oml.samples.ui.SampleProject;
import org.eclipse.m2m.qvt.oml.samples.ui.SampleProject.Action;


public class PatchFilesAction implements Action {

    private String[] myFiles;
    private Pair<String, StringResolver>[] myReplaces;
    
    public static interface StringResolver {
        public String getString(); 
    }
    
    public static class DefualtStringResolver implements StringResolver {
        private String myString;

        public DefualtStringResolver(String string) {
            myString = string;
        }
        
        public String getString() {
            return myString;
        }
    }

    public PatchFilesAction(String[] files, Pair<String, StringResolver>[] replaces) {
        myFiles = files;
        myReplaces = replaces;
    }
    
    public void perform(SampleProject sample, IProject project) throws CoreException, IOException {
        for (int i = 0; i < myFiles.length; i++) {
            IFile file = project.getFile(new Path(myFiles[i]));
            String encoding = Charset.defaultCharset().name();
            String contents = getStringContents(file, encoding);
            String fileExtension = file.getFileExtension();
            if ("htm".equalsIgnoreCase(fileExtension) || "html".equalsIgnoreCase(fileExtension)) { //$NON-NLS-1$ //$NON-NLS-2$
                String CHARSET_EQ_LITERAL = "charset="; //$NON-NLS-1$
                int charsetIndex = contents.indexOf(CHARSET_EQ_LITERAL);
                if (charsetIndex > 0) {
                    int indexOfDQ = contents.indexOf('\"', charsetIndex + CHARSET_EQ_LITERAL.length());
                    int indexOfSQ = contents.indexOf('\'', charsetIndex + CHARSET_EQ_LITERAL.length());
                    int indexOfQ = ((indexOfSQ > charsetIndex) && (indexOfDQ - indexOfSQ > 0)) ? indexOfSQ : indexOfDQ;
                    if (indexOfQ > charsetIndex) {
                        String candidateEncoding = contents.substring(charsetIndex + CHARSET_EQ_LITERAL.length(), indexOfQ);
                        if (Charset.isSupported(candidateEncoding)) {
                            encoding = candidateEncoding;
                            contents = getStringContents(file, encoding);
            }
        }
    }
        }
            for (Pair<String, StringResolver> replace : myReplaces) {
                contents = contents.replaceAll(replace.getFirst(), replace.getSecond().getString());
            }
            byte[] bytes = contents.getBytes(encoding);
            file.setContents(new ByteArrayInputStream(bytes), true, true, null);
        }
        }
        
    private static String getStringContents(IFile file, String encoding) throws CoreException, IOException {
        InputStream inputStream = file.getContents();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
        int nBytesRead;
        byte[] buffer = new byte[4092];
        while ((nBytesRead = inputStream.read(buffer)) >= 0) {
            byteArrayOutputStream.write(buffer, 0, nBytesRead);
        }
        inputStream.close();
        return new String(byteArrayOutputStream.toByteArray(), encoding);
    }
}
