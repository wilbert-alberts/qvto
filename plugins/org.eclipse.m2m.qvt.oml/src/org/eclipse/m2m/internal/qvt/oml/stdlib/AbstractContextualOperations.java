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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
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
			EOperation defOper = operation.define(env);
			if(operation.fIsStatic) {
				QvtOperationalParserUtil.markAsStaticOperation(defOper);
			}
		}
	}
	
	protected OperationProvider createStaticOperationProvider(CallHandler dispatcher, String name, EClassifier returnType, EClassifier... paramTypes) {
		OperationProvider provider = new OperationProvider(dispatcher, name, returnType, paramTypes);
		provider.fIsStatic = true;
		return provider;
	}	
	
	protected class OwnedOperationProvider extends OperationProvider {
		
		public OwnedOperationProvider(CallHandler dispatcher, String name,
				EClassifier returnType, EClassifier... paramTypes) {
			super(dispatcher, name, returnType, paramTypes);
		}

		public EOperation define(EcoreEnvironment env) {
			EOperation eOperation = EcoreFactory.eINSTANCE.createEOperation();
			eOperation.setName(fName);
						
			for (EClassifier cls : fParamTypes) {
				EParameter eParam = EcoreFactory.eINSTANCE.createEParameter();
				eParam.setName(cls.getName());
				eParam.setEType(cls);
				eOperation.getEParameters().add(eParam);
			}
						 
			eOperation.setEType(fReturnType);
			
			assert fContextType instanceof EClass;
			((EClass)fContextType).getEOperations().add(eOperation);
			
			CallHandlerAdapter.attach(eOperation, fDispatcher);
			return eOperation;
		}		
	}
	
	protected class OperationProvider {
		protected final String fName;
		protected final EClassifier fReturnType;
		protected final EClassifier[] fParamTypes;
		protected final CallHandler fDispatcher;
		protected boolean fIsStatic; 
				
		protected OperationProvider(CallHandler dispatcher, String name, EClassifier returnType, EClassifier... paramTypes) {
			this.fName = name;
			this.fReturnType = returnType;
			this.fParamTypes = paramTypes;
			this.fDispatcher = dispatcher;
			this.fIsStatic = false;
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