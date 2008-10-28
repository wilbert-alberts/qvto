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

import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandler;

public class ModuleInstance extends DynamicEObjectImpl {
	
	private CallHandler fEntryHandler;
	
	public ModuleInstance(Module moduleType) {
		if(moduleType == null) {
			throw new IllegalArgumentException("Null module class"); //$NON-NLS-1$
		}

		eSetClass(moduleType);
	}
	
	public Module getModule() {
		return (Module)eClass();
	}
	
	public void setEntryOperationHandler(CallHandler handler) {
		fEntryHandler = handler;
	}	
	
	public CallHandler getEntryOperationHandler() {
		return fEntryHandler;
	}

	@Override
	public String toString() {
		return eClass().getName() + "@" + Integer.toHexString(System.identityHashCode(this)); //$NON-NLS-1$
	}
}
