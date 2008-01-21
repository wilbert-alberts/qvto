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
package org.eclipse.m2m.qvt.oml.runtime.util;

import java.text.MessageFormat;

import org.eclipse.osgi.util.NLS;

public class Messages {
	
    private static final String BUNDLE_NAME = "com.borland.m2m.qvt.util.dsl.messages"; //$NON-NLS-1$		
	
    private Messages() {
    }

    public static String moduleDiagnosticChain;
    public static String ImportedTransformation_NoWsFileForModule;
    public static String ImportedTransformation_NoWsFileForLocation;
    
    public static String format(String pattern, Object ... args) {
    	try {
    		return MessageFormat.format(pattern, args);
    	}
    	catch(Exception e) {
    		return "!" + pattern + "!"; //$NON-NLS-1$ //$NON-NLS-2$
    	}
    }

    static {
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }
}
