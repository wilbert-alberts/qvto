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
    	//TODO: more accurate
    	return content.replaceFirst(
    			"\\s*transformation\\s+(.*?)\\s*;",  //$NON-NLS-1$
    			"\ntransformation " + newName + ";\n"); //$NON-NLS-1$ //$NON-NLS-2$ 
    }
    
    private static boolean isEcoreFile(String fname) {
    	return fname.endsWith(".ecore"); //$NON-NLS-1$
    }
    
    private final static Map<String, String> REPLACEMENTS = new HashMap<String, String>();
    static {
    	REPLACEMENTS.put(EcorePackage.eNS_URI, JavalessMetamodelProvider.JAVALESS_METAMODEL_ID);
    	REPLACEMENTS.put("ecore\\(", "javaless("); //$NON-NLS-1$ //$NON-NLS-2$
    	REPLACEMENTS.put("ecore:", "javaless:"); //$NON-NLS-1$ //$NON-NLS-2$
    	REPLACEMENTS.put(":ecore", ":javaless"); //$NON-NLS-1$ //$NON-NLS-2$
    }
}
