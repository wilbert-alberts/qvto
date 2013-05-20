/*******************************************************************************
 * Copyright (c) 2008, 2009 Borland Software Corporation and others.
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

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QVTOEnvironment;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance;
import org.eclipse.ocl.types.OCLStandardLibrary;


public class ObjectOperations extends AbstractContextualOperations {

	static final String REPR_NAME = "repr"; //$NON-NLS-1$
	static final String AS_ORDERED_TUPLE_NAME = "asOrderedTuple"; //$NON-NLS-1$	
	
	public ObjectOperations(AbstractQVTStdlib library) {
		super(library, library.getObject());
	}
		
	@Override
	protected OperationProvider[] getOperations() {
		QVTOEnvironment env = getStdlib().getEnvironment();
		OCLStandardLibrary<EClassifier> oclStdlib = env.getOCLStandardLibrary();
		
		return new OperationProvider[] { 
			new OwnedOperationProvider(REPR, REPR_NAME, oclStdlib.getString()),
								
			new OwnedOperationProvider(AS_ORDERED_TUPLE, AS_ORDERED_TUPLE_NAME,
				getStdlib().getOrderedTupleType())
		};
	}
	
	private static final CallHandler REPR = new CallHandler() {
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {			
		    return String.valueOf(source);
		}
	};

	private static final CallHandler AS_ORDERED_TUPLE = new CallHandler() {
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
	        Set<Object> instances = new LinkedHashSet<Object>();	        
	        for (Iterator<EObject> it = ((EObject) source).eAllContents(); it.hasNext(); ) {
	            EObject contained = it.next();
	            
	            if (AbstractQVTStdlib.clsFilter.matches(contained, args[0])) {
	                instances.add(contained);
	            }
	        }	        
	        return instances;
		}
	};	
}
