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
package org.eclipse.m2m.internal.qvt.oml.cst.parser;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class QvtKeywords {

	private static final List<String> excludedOCLKeywords = Arrays.asList(
		"inv", //$NON-NLS-1$
		"pre", //$NON-NLS-1$
		"post", //$NON-NLS-1$
		"endpackage", //$NON-NLS-1$
		"def" //$NON-NLS-1$		
	);
	
	private static final Set<String> tempKeywords = new HashSet<String>(); 
	static {
    	for (String string : QvtOpLPGParsersym.orderedTerminalSymbols) {
    		if (!string.equals(string.toUpperCase())) { // filter out primitive literals, operators and empty-string tokens
                tempKeywords.add(string);
    		}
		}
    	
    	tempKeywords.removeAll(excludedOCLKeywords);
	}
		
	public static final Set<String> KEYWORDS = Collections.unmodifiableSet(tempKeywords);	
	
	private QvtKeywords() {
	}

	public static boolean isKeyword(String aString) {
		return KEYWORDS.contains(aString);
	}
}