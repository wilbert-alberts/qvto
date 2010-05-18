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
package org.eclipse.m2m.tests.qvt.oml.transform.javaless;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.m2m.tests.qvt.oml.transform.FileToFileData;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;


public class JavalessUtil {
	private JavalessUtil() {}
	
    public static boolean isValidJavalessData(ModelTestData data) {
    	if(data instanceof FileToFileData == false) {
    		return false;
    	}
    	
    	FileToFileData fileData = (FileToFileData) data;
    	if(!isEcoreFile(fileData.getFromFile())) {
    		return false;
    	}
    	
    	if(!isEcoreFile(fileData.getExpectedFile())) {
    		return false;
    	}
    	
    	return true;
    }

    public static String patchContents(String content) {
    	for(Map.Entry<String, String> replacment: REPLACEMENTS.entrySet()) {
    		content = content.replaceAll(replacment.getKey(), replacment.getValue());
    	}
    	
    	return content;
    }
    
    public static String changeTransformationName(String content, String oldName, String newName) {
    	// update local imports
    	//
		Pattern p = Pattern.compile("(import\\s*models\\." + oldName + "\\..*);"); //$NON-NLS-1$ //$NON-NLS-2$
		Matcher m = p.matcher(content);
		if (m.find()) {
			content = m.replaceAll(m.group(1) + "_javaless;"); //$NON-NLS-1$
		}

		// update transformation name
		//
    	return content.replaceFirst(
    			"\\s*transformation\\s+" + oldName,  //$NON-NLS-1$
    			"\ntransformation " + newName); //$NON-NLS-1$ 
    }
    
    private static boolean isEcoreFile(String fname) {
    	return fname.endsWith(".ecore"); //$NON-NLS-1$
    }
    
    public static final String JAVALESS_METAMODEL = "platform:/plugin/org.eclipse.m2m.tests.qvt.oml/models/javaless.ecore";  //$NON-NLS-1$
    private static final String JAVALESS_METAMODEL_ID = "http://www.example.com/javaless/2006";  //$NON-NLS-1$

    private final static Map<String, String> REPLACEMENTS = new HashMap<String, String>();
    static {
    	REPLACEMENTS.put(EcorePackage.eNS_URI, JAVALESS_METAMODEL_ID);
    	REPLACEMENTS.put("ecore\\(", "javaless("); //$NON-NLS-1$ //$NON-NLS-2$
    	REPLACEMENTS.put("ecore:", "javaless:"); //$NON-NLS-1$ //$NON-NLS-2$
    	REPLACEMENTS.put(":ecore", ":javaless"); //$NON-NLS-1$ //$NON-NLS-2$
    }
}
