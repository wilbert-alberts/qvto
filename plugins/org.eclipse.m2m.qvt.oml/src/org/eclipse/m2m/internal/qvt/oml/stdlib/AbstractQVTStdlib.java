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

package org.eclipse.m2m.internal.qvt.oml.stdlib;


import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QVTOEnvironment;
import org.eclipse.m2m.internal.qvt.oml.expressions.Library;
import org.eclipse.m2m.internal.qvt.oml.stdlib.model.StdlibFactory;
import org.eclipse.m2m.internal.qvt.oml.stdlib.model.StdlibPackage;
import org.eclipse.ocl.types.OCLStandardLibrary;

public abstract class AbstractQVTStdlib implements StdlibPackage {
	/* FIXME -  */
	static interface IFilter {
    	boolean matches(Object obj, Object type);
    }
    
    static final IFilter clsFilter = new IFilter() {
		public boolean matches(Object obj, Object type) {
	    	if (type instanceof EClassifier) {
	    		EClassifier classifier = (EClassifier) type;
	    		return classifier.isInstance(obj);
	    	}
	    	
	    	return false;	    	
		}			
	};
    
	protected AbstractQVTStdlib() {
		super();
	}	
	
	public abstract StdlibFactory getStdlibFactory();
	
	public abstract Library getStdLibModule();
	
	public abstract QVTOEnvironment getEnvironment();	
		
	public OCLStandardLibrary<EClassifier> getOCLStdLib() {
		return getEnvironment().getOCLStandardLibrary();
	}
}
