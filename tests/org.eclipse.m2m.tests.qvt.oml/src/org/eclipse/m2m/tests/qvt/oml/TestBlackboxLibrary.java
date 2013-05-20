/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation and others.
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
	
	public Set<ENamedElement> asRenamedSetSingleton(Object self, String newName) {
		if(self instanceof ENamedElement) {
			ENamedElement namedElement = (ENamedElement) self;
			namedElement.setName(newName);
			return Collections.singleton(namedElement);			
		}
			
		return Collections.emptySet(); 
	}
	
	public final Set<Object> oclAnyMyOperation(Object self) {
		return Collections.singleton(self);
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

    	private static final String[] RENAMED_SET_SINGLETON = new String[] {
        	"oclstdlib::OclVoid", // Void context -> module owned (context-less) operation
                                  // imported library module is the implicit source object of the call
            "oclstdlib::OclAny",  // your argument1
            "oclstdlib::String",  // your argument2            
            "Set(ecore::ENamedElement)"  // return type
        };

        private static final String[] OCLANY_MYOPERATION = new String[] {
        	"oclstdlib::OclAny",
            "Set(oclstdlib::OclAny)"
        };        
        
    	public static final String[] asRenamedSetSingleton(Object arg, String newName) {
    		return RENAMED_SET_SINGLETON;
    	}
    	
    	public static final String[] oclAnyMyOperation(Object arg) {
    		return OCLANY_MYOPERATION;
    	}
    }
}
