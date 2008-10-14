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

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandler;

public class ModuleInstanceAdapter extends AdapterImpl {
	
	private CallHandler fEntryHandler;
	// TODO - 
	// this adapter should reference to all instances imported by extend
	// and related to this instance

	ModuleInstanceAdapter(CallHandler entryOperationHandler) {
		fEntryHandler = entryOperationHandler;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		if(newTarget instanceof EObject == false) {
			throw new IllegalArgumentException("The target must be EObject"); //$NON-NLS-1$
		}
		super.setTarget(newTarget);
	}

	public CallHandler getEntryOperationHandler() {
		return fEntryHandler;
	}
	
	public EObject getThis() {
		return (EObject)getTarget();
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return ModuleInstanceAdapter.class == type;
	}
		
	public static ModuleInstanceAdapter getAdaper(EObject moduleInstance) {
		return (ModuleInstanceAdapter)EcoreUtil.getExistingAdapter(moduleInstance, ModuleInstanceAdapter.class); 
	}
}
