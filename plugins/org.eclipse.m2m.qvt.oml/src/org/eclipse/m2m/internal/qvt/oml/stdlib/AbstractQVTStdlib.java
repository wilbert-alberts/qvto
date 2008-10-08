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

package org.eclipse.m2m.internal.qvt.oml.stdlib;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Library;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.types.OCLStandardLibrary;

public abstract class AbstractQVTStdlib {
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
	    	else {
	    		return false;
	    	}
		}			
	};
	
	protected AbstractQVTStdlib() {
		super();
	}	
	
	public abstract Library getStdLibModule();	
	
	public abstract EClassifier getModelClass();
	
	public abstract EClass getTransformationClass();

	public abstract EClass getModuleType();
	
	public abstract EClassifier getElementType();
	
	public abstract EcoreEnvironment getEnvironment();	
	
	
	public OCLStandardLibrary<EClassifier> getOCLStdLib() {
		return getEnvironment().getOCLStandardLibrary();
	}	
	
    public boolean isStdLibOperaton(EOperation operation) {
    	return null != CallHandlerAdapter.getDispatcher(operation);
    }
}
