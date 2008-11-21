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
package org.eclipse.m2m.internal.qvt.oml.evaluator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandler;

final class ModuleInstanceImpl extends DynamicEObjectImpl implements ModuleInstance, ModuleInstance.Internal {
	
	private CallHandler fEntryHandler;
	private Map<Module, ModuleInstance> fInstanceMap;
	private List<Object> fAdapters = Collections.emptyList();	
	
	ModuleInstanceImpl(Module moduleType) {
		if(moduleType == null) {
			throw new IllegalArgumentException("Null module class"); //$NON-NLS-1$
		}
		
		eSetClass(moduleType);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.m2m.internal.qvt.oml.evaluator.ThisInstanceResolver#getThisInstanceOf(org.eclipse.m2m.internal.qvt.oml.expressions.Module)
	 */
	/* (non-Javadoc)
	 * @see org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance#getThisInstanceOf(org.eclipse.m2m.internal.qvt.oml.expressions.Module)
	 */
	public ModuleInstance getThisInstanceOf(Module module) {
		if(module == eClass()) {
			return this;
		}

		return (fInstanceMap != null) ? fInstanceMap.get(module) : null;
	}	
	
	/* (non-Javadoc)
	 * @see org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance#getModule()
	 */
	public Module getModule() {
		return (Module)eClass();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance#setEntryOperationHandler(org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandler)
	 */
	public void setEntryOperationHandler(CallHandler handler) {
		fEntryHandler = handler;
	}	
	
	/* (non-Javadoc)
	 * @see org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance#getEntryOperationHandler()
	 */
	public CallHandler getEntryOperationHandler() {
		return fEntryHandler;
	}
	
	void setInstanceMap(Map<Module, ModuleInstance> instanceMap) {
		fInstanceMap = instanceMap;
	}	
	
	public <T> T getAdapter(Class<T> adapterType) {
		if(adapterType == ModuleInstance.Internal.class) {
			@SuppressWarnings("unchecked")
			T result = (T)this;
			return result;
		}
		
		for (Object nextAdapter : fAdapters) {
			Class<?> nextAdapterType = nextAdapter.getClass();
			if(adapterType == nextAdapterType || adapterType.isAssignableFrom(nextAdapterType)) {
				return adapterType.cast(nextAdapter);
			}
		}
		
		return null;
	}
	
	public void addAdapter(Object adapter) {
		if(adapter == null) {
			throw new IllegalArgumentException();
		}
		
		if(fAdapters.isEmpty()) {
			fAdapters = new LinkedList<Object>();
		}
		
		fAdapters.add(adapter);
	}
	
	@Override
	public String toString() {
		return eClass().getName() + "@" + Integer.toHexString(System.identityHashCode(this)); //$NON-NLS-1$
	}
}
