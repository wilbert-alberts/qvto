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
package org.eclipse.m2m.internal.qvt.oml.ast.env;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.ocl.Environment;

/**
 * Virtual table class grouping related virtual operations to the table  owning operation.
 */
abstract class VirtualTable implements IVirtualOperationTable {
	private List<EOperation> fOperations;
	private Map<Module, List<EOperation>> fModule2OperationsMap;
	
	protected VirtualTable() {
	}
	
	protected abstract EOperation getOwningOperation();
	
	/**
	 * Adds operation that is virtual in relation to the owning operation of this table.
	 * <p>
	 * Note: No check is done for non-compatible signature, owner type. It supposed to be done 
	 * done externally.
	 * 
	 * @param operation
	 *            operation to add to this table
	 */
	public void addOperation(EOperation operation) {
		if(operation == null) {
			throw new IllegalArgumentException();
		}
		
		if(fOperations == null) {
			fOperations = new LinkedList<EOperation>();
		}
		
		if(!fOperations.contains(operation)) {
			fOperations.add(operation);
		}
	}
	
	public void addOperationInModule(EOperation operation, Module exposeToCallerFrom) {
		if(operation == null) {
			throw new IllegalArgumentException();
		}
		
		if(fModule2OperationsMap == null) {
			fModule2OperationsMap = new HashMap<Module, List<EOperation>>();
		}
		
		
		List<EOperation> operations = fModule2OperationsMap.get(exposeToCallerFrom);
		if(operations == null) {
			operations = new LinkedList<EOperation>();
			fModule2OperationsMap.put(exposeToCallerFrom, operations);
		}
		
		if(!operations.contains(operation)) {
			operations.add(operation);
		}
	}

	@SuppressWarnings("unchecked")	
	public EOperation lookupActualOperation(EClass actualContextType, Environment env) {
		return lookupActualOperation(actualContextType, env, null);
	}
	
	@SuppressWarnings("unchecked")
	public EOperation lookupActualOperation(EClass actualContextType, Environment env, Module scope) {
		if(actualContextType == null || env == null) {
			throw new IllegalArgumentException();
		}

		EOperation formalOperation = this.getOwningOperation();
		if(formalOperation == null) {
			return null;			
		}
		
		if(env.getUMLReflection().getOwningClassifier(formalOperation) == actualContextType) {
			// the closest match satisfied			
			return formalOperation;
		}
		
		// check we can lookup operation directly for the actual type
		if(scope == null) {
			for (EOperation nextOperation : getModuleScopeOperations(scope)) {
				if(env.getUMLReflection().getOwningClassifier(nextOperation) == actualContextType) {
					return nextOperation;
				}
			}
		}
		
		for (EOperation nextOperation : getOperations()) {
			if(env.getUMLReflection().getOwningClassifier(nextOperation) == actualContextType) {
				return nextOperation;
			} 
		}

		// try lookup in actual type's super-types for the closest match
		for (EClass superClass : actualContextType.getESuperTypes()) {
			EOperation superOperation = lookupActualOperation(superClass, env, scope);
			if(superOperation != null) {
				return superOperation;
			}
		}
		
		return null;
	}

	public void merge(VirtualTable another) {
		for (EOperation nextOperation : another.getOperations()) {
			this.addOperation(nextOperation);
		}
		
		if(another.fModule2OperationsMap != null) {
			for (Module nextModule : another.fModule2OperationsMap.keySet()) {
				List<EOperation> operations = another.fModule2OperationsMap.get(nextModule);
				if(operations != null) {
					for (EOperation nextOperation : operations) {
						this.addOperationInModule(nextOperation, nextModule);						
					}
				}
			}
		}
	}	
	
	private List<EOperation> getModuleScopeOperations(Module module) {
		if(module == null || fModule2OperationsMap == null || fModule2OperationsMap.containsKey(module) == false) {
			return Collections.emptyList();
		}
		return fModule2OperationsMap.get(module); 
	}
	
	private Collection<EOperation> getOperations() {
		return fOperations != null ? fOperations : Collections.<EOperation>emptySet();
	}
}
