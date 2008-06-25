/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation
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
import java.util.Set;

import org.eclipse.emf.ecore.ENamedElement;

public class TestBlackboxLibrary {
	
	public Set<ENamedElement> asRenamedSetSingleton(Object arg, String newName) {
		if(arg instanceof ENamedElement) {
			ENamedElement namedElement = (ENamedElement) arg;
			namedElement.setName(newName);
			return Collections.singleton(namedElement);			
		}
			
		return Collections.emptySet(); 
	}
	
    /**
     * Metainfo for the native methods should be accessible throu the static
     * methods of inner class <code>Metainfo</code> with the same signature
     * ant <code>String[]</code> return type. Returned array should contains
     * string representation of OCL classifiers:
     * 
     * array[0]     - Context classifier
     * array[n]     - Classifier corresponds to the n-th operation parameter 
     * array[n+1]   - Return type classifier
     */
    public static class Metainfo {
        /**
         * array[0]     - Context classifier
         * array[n]     - Classifier corresponds to the n-th operation parameter
         * array[n+1]   - Return type classifier
         */    	    	
        private static final String[] RENAMED_SET_SINGLETON = new String[] {
        	"oclstdlib::OclVoid", // Void context -> module owned (context-less) operation
                                  // imported library module is the implicit source object of the call
            "oclstdlib::OclAny",  // your argument1
            "oclstdlib::String",  // your argument2            
            "Set(ecore::ENamedElement)"  // return type
        };
    	
    	public static final String[] asRenamedSetSingleton(Object arg, String newName) {
    		return RENAMED_SET_SINGLETON;
    	}
    }
}
