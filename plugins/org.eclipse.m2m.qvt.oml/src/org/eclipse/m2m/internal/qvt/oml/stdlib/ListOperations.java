/*******************************************************************************
 * Copyright (c) 2008, 2013 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Alex Paperno - bugs 404647
 ********************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.stdlib;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance;
import org.eclipse.m2m.qvt.oml.util.MutableList;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.ocl.util.TypeUtil;


public class ListOperations extends AbstractContextualOperations {

	public static final String ADD_NAME = "add"; //$NON-NLS-1$
	public static final String APPEND_SYNONYM = "append"; //$NON-NLS-1$	
	public static final String PREPEND_NAME = "prepend"; //$NON-NLS-1$
	public static final String INSERT_AT_NAME = "insertAt"; //$NON-NLS-1$	
	public static final String JOINFIELDS_NAME = "joinfields"; //$NON-NLS-1$	
	public static final String AS_SET_NAME = "asSet"; //$NON-NLS-1$	
	public static final String AS_ORDERED_SET_NAME = "asOrderedSet"; //$NON-NLS-1$
	public static final String AS_SEQUENCE_NAME = "asSequence"; //$NON-NLS-1$
	public static final String AS_BAG_NAME = "asBag"; //$NON-NLS-1$
	public static final String FLATTEN_NAME = "flatten"; //$NON-NLS-1$
	
	static CallHandler ADD = new CallHandlerMutator() {
		@SuppressWarnings("unchecked")
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			List<Object> list = (List<Object>) source;
			final Object element = args[0];
			if(element != CallHandlerAdapter.getInvalidResult(evalEnv)) {
				list.add(element);
			}
			return null;
		}
	};
	
	static CallHandler PREPEND = new CallHandlerMutator() {
		@SuppressWarnings("unchecked")
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			List<Object> list = (List<Object>) source;
			final Object element = args[0];
			if(element != CallHandlerAdapter.getInvalidResult(evalEnv)) {			
				list.add(0, element);
			}
			return null;
		}
	};

	static CallHandler INSERT_AT = new CallHandlerMutator() {
		@SuppressWarnings("unchecked")
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			MutableList<Object> list = (MutableList<Object>) source;
			final Object element = args[0];
			if(element != CallHandlerAdapter.getInvalidResult(evalEnv)) {				
				Integer at = (Integer)args[1];
				list.insertAt(element, at);
			}
			return null;
		}
	};
	
	static CallHandler JOINFIELDS = new CallHandler() {
		@SuppressWarnings("unchecked")
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			MutableList<Object> list = (MutableList<Object>) source;
			
			String sep = (String) args[0];
			String begin = (String) args[1];			
			String end = (String) args[2];
						
			return list.joinfields(sep, begin, end);
		}
	};
	
	static CallHandler AS_SET = new CallHandler() {
		@SuppressWarnings("unchecked")
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			MutableList<Object> list = (MutableList<Object>) source;
			return CollectionUtil.createNewSet(list);
		}
	};
	
	static CallHandler AS_ORDERED_SET = new CallHandler() {
		@SuppressWarnings("unchecked")
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			MutableList<Object> list = (MutableList<Object>) source;
			return CollectionUtil.createNewOrderedSet(list);
		}
	};
	
	static CallHandler AS_SEQUENCE = new CallHandler() {
		@SuppressWarnings("unchecked")
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			MutableList<Object> list = (MutableList<Object>) source;
			return CollectionUtil.createNewSequence(list);
		}
	};
	
	static CallHandler AS_BAG = new CallHandler() {
		@SuppressWarnings("unchecked")
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			MutableList<Object> list = (MutableList<Object>) source;
			return CollectionUtil.createNewBag(list);
		}
	};
	
	static CallHandler FLATTEN = new CallHandler() {
		@SuppressWarnings("unchecked")
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			MutableList<Object> list = (MutableList<Object>) source;
			return CollectionUtil.flatten(list);
		}
	};
	

	public ListOperations(AbstractQVTStdlib library) {
		super(library, library.getList());
	}
	
	@Override
	protected OperationProvider[] getOperations() {
		OCLStandardLibrary<EClassifier> oclStdlib = getStdlib().getEnvironment().getOCLStandardLibrary();
		return new OperationProvider[] {
			new OperationProvider(ADD, ADD_NAME, new String[] { "object"}, oclStdlib.getOclVoid(), oclStdlib.getT()), //$NON-NLS-1$
			new OperationProvider(ADD, APPEND_SYNONYM, new String[] { "object"}, oclStdlib.getOclVoid(), oclStdlib.getT()), //$NON-NLS-1$			
			new OperationProvider(PREPEND, PREPEND_NAME, new String[] { "object"}, oclStdlib.getOclVoid(), oclStdlib.getT()), //$NON-NLS-1$
			new OperationProvider(INSERT_AT, INSERT_AT_NAME, new String[] { "object", "pos"}, oclStdlib.getOclVoid(), //$NON-NLS-1$ //$NON-NLS-2$ 
					oclStdlib.getT(), oclStdlib.getInteger()),
			new OperationProvider(JOINFIELDS, JOINFIELDS_NAME, new String[] { "sep", "begin", "end" }, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$  
					oclStdlib.getString(), oclStdlib.getString(), oclStdlib.getString(), oclStdlib.getString()),			
			new OperationProvider(AS_SET, AS_SET_NAME, new String[] {}, oclStdlib.getSet()),
			new OperationProvider(AS_ORDERED_SET, AS_ORDERED_SET_NAME, new String[] {}, oclStdlib.getOrderedSet()),
			new OperationProvider(AS_SEQUENCE, AS_SEQUENCE_NAME, new String[] {}, oclStdlib.getSequence()),
			new OperationProvider(AS_BAG, AS_BAG_NAME, new String[] {}, oclStdlib.getBag()),
			new OperationProvider(FLATTEN, FLATTEN_NAME, new String[] {},
					TypeUtil.resolveSequenceType(getStdlib().getEnvironment(), oclStdlib.getT2())),
		};
	}	
}
