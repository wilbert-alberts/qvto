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
package org.eclipse.m2m.internal.qvt.oml.stdlib;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.PredefinedType;


public class OclAnyOperations extends AbstractContextualOperations {

	public static final String REPR_NAME = "repr"; //$NON-NLS-1$
	
	public OclAnyOperations(AbstractQVTStdlib library) {
		super(library, library.getEnvironment().getOCLStandardLibrary().getOclAny());
	}
	
	public EOperation defineNonStdAllInstances(EcoreEnvironment env, EClassifier actualType) {		
		return new OperationProvider(ALL_INSTANCES, PredefinedType.ALL_INSTANCES_NAME,
				TypeUtil.resolveSetType(env, actualType), env.getOCLStandardLibrary().getOclType()).define(env);
	}
	
	@Override
	protected OperationProvider[] getOperations() {
		EcoreEnvironment env = getStdlib().getEnvironment();
		OCLStandardLibrary<EClassifier> oclStdlib = env.getOCLStandardLibrary();
		
		return new OperationProvider[] {
			new OperationProvider(REPR, REPR_NAME, oclStdlib.getString()),				
			new OperationProvider(StdlibModuleOperations.DUMP, 
					StdlibModuleOperations.DUMP_NAME, oclStdlib.getOclVoid())
		};
	}
	
	private static final CallHandler REPR = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {			
		    return String.valueOf(source);
		}
	};


	// non-std - legacy
	private static final CallHandler ALL_INSTANCES = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
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
