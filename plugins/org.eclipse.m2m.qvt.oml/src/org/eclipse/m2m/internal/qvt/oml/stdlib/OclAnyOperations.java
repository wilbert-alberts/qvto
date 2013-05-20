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
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QVTOEnvironment;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.PredefinedType;


public class OclAnyOperations extends AbstractContextualOperations {

	public static final String REPR_NAME = "repr"; //$NON-NLS-1$
	
	public OclAnyOperations(AbstractQVTStdlib library) {
		super(library, library.getEnvironment().getOCLStandardLibrary().getOclAny());
	}
		
	@Override
	protected OperationProvider[] getOperations() {
		QVTOEnvironment env = getStdlib().getEnvironment();
		OCLStandardLibrary<EClassifier> oclStdlib = env.getOCLStandardLibrary();
		
		EClassifier createTypeType = getStdlib().getOCLStdLib().getOclType();
		return new OperationProvider[] {
			// FIXME - repr() should be available on Object type 
			new OperationProvider(REPR, REPR_NAME, oclStdlib.getString()),
				
			new OperationProvider(StdlibModuleOperations.DUMP, 
					StdlibModuleOperations.DUMP_NAME, oclStdlib.getOclVoid())
					.deprecate(),
					
			new OperationProvider(ALL_INSTANCES, PredefinedType.ALL_INSTANCES_NAME,
					TypeUtil.resolveSetType(env, getStdlib().getOCLStdLib().getT()), 
					TypeUtil.resolveType(env, createTypeType))
					.deprecateBy("Element::objectsOfKind(OclType)") //$NON-NLS-1$
		};
	}
	
	private static final CallHandler REPR = new CallHandler() {
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			try {
				return String.valueOf(source);
			} catch(RuntimeException e) {
				QvtPlugin.error("Object::repr()", e); //$NON-NLS-1$
				return CallHandlerAdapter.getInvalidResult(evalEnv);
			}
		}
	};


	// non-std - legacy
	private static final CallHandler ALL_INSTANCES = new CallHandler() {
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
