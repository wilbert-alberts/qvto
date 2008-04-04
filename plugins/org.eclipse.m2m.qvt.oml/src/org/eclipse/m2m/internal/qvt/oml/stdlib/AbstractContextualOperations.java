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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.Variable;

public abstract class AbstractContextualOperations {
	private final EClassifier fContextType;		
	private final AbstractQVTStdlib fLib;
			
	protected AbstractContextualOperations(AbstractQVTStdlib lib, EClassifier contextType) {
		if(lib == null || contextType == null) {
			throw new IllegalArgumentException();
		}
		
		fContextType = contextType;
		fLib = lib;
	}
	
	protected abstract OperationProvider[] getOperations();
			
	public AbstractQVTStdlib getStdlib() {
		return fLib;
	}
			
	public void define(EcoreEnvironment env) {
		for (OperationProvider operation : getOperations()) {
			operation.define(env);
		}
	}
	
	protected class OperationProvider {
		private String fName;
		private EClassifier fReturnType;
		private EClassifier[] fParamTypes;
		private CallHandler fDispatcher;
		
		protected OperationProvider(CallHandler dispatcher, String name, EClassifier returnType, EClassifier... paramTypes) {
			this.fName = name;
			this.fReturnType = returnType;
			this.fParamTypes = paramTypes;
			this.fDispatcher = dispatcher;
		}
		
		public CallHandler callDispatcher() {
			return fDispatcher;
		}
		
		public OperationProvider implentBy(CallHandler dispatch) {
			return this;
		}
		
		public EOperation define(EcoreEnvironment env) {
			List<Variable<EClassifier, EParameter>> argList = new ArrayList<Variable<EClassifier, EParameter>>();
			for (EClassifier cls : fParamTypes) {
				Variable<EClassifier, EParameter> stringVariable = ExpressionsFactory.eINSTANCE.createVariable();
				stringVariable.setName(cls.getName());
				stringVariable.setType(cls);
				argList.add(stringVariable);
			}

			EOperation result = env.defineOperation(fContextType, fName, fReturnType, argList,
						org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createConstraint());

			CallHandlerAdapter.attach(result, fDispatcher);
			return result;
		}	
	}
}