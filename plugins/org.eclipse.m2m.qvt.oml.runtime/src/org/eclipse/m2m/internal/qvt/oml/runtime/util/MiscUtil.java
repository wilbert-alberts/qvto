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
package org.eclipse.m2m.internal.qvt.oml.runtime.util;

import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.m2m.internal.qvt.oml.runtime.QvtRuntimePlugin;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.common.io.CFileUtil;
import org.eclipse.osgi.util.NLS;

/**
 * @author pkobiakov
 */
public class MiscUtil {
	private MiscUtil() {}

    
    public static IStatus makeWarningStatus(Exception e) {
        return new Status(IStatus.WARNING, QvtRuntimePlugin.ID, IStatus.WARNING, NLS.bind(Messages.MiscUtil_WarnMessage, e.getMessage()), e);
    }
    
    public static IStatus makeWarningStatus(String message, Exception e) {
        return new Status(IStatus.WARNING, QvtRuntimePlugin.ID, IStatus.WARNING, message, e);
    }
    
    public static IStatus makeErrorStatus(Exception e) {
        return new Status(IStatus.ERROR, QvtRuntimePlugin.ID, IStatus.ERROR, NLS.bind(Messages.MiscUtil_ErrorMessage, e.getMessage()), e);
    }
    
	public static IStatus makeErrorStatus(String message, Exception e) {
		return new Status(IStatus.ERROR, QvtRuntimePlugin.ID, IStatus.ERROR, message, e);
	}

	public static IStatus makeErrorStatus(String message) {
		return new Status(IStatus.ERROR, QvtRuntimePlugin.ID, IStatus.ERROR, message, null);
	}	
		
	public static MdaException logException(Logger logger, MdaException e) {
	    logger.log(Level.SEVERE, e.getMessage(), e);
	    return e;
	}
	
	public static String readStream(CFile file) throws IOException {
	    StringBuffer contents = new StringBuffer();
	    Reader reader = CFileUtil.getReader(file);
	    try {
	        char[] buf = new char[4096];
	        int read;
	        while((read=reader.read(buf)) > 0) {
	            contents.append(buf, 0, read);
	        }
	    }
	    finally {
	        try { reader.close(); } catch(IOException e) {}
	    }
	 
	    return contents.toString();
	}
	
	public static int getLineNumber(CharSequence data, int pos) {
		int length = data.length();
		pos = Math.min(pos, length);
		int line = 1;
		for(int i = 0; i < pos; i++) {
			if(data.charAt(i) == '\n') {
				line++;
			}
		}
		
		return line;
    }
	
	public static int getLineCount(CharSequence data) {
		return getLineNumber(data, data.length());
	}

}
