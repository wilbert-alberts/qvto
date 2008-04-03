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

package org.eclipse.m2m.qvt.oml.internal.stdlib;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.util.EcoreUtil;


class CallHandlerAdapter extends AdapterImpl {
	
	private CallHandler fHandler;

	CallHandlerAdapter(CallHandler dispatch) {
		assert dispatch != null;
		fHandler = dispatch;
	}
		
	public CallHandler getDispatch() {
		return fHandler;
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		if(CallHandlerAdapter.class.equals(type)) {
			return true;
		}
		return super.isAdapterForType(type);
	}
	
	public static void attach(EOperation operation, CallHandler callDispatch) {
		operation.eAdapters().add(new CallHandlerAdapter(callDispatch));
	}
	
	public static CallHandler getDispatcher(EOperation operation) {
		CallHandlerAdapter adapter = (CallHandlerAdapter)EcoreUtil.getExistingAdapter(operation, CallHandlerAdapter.class);
		return (adapter != null) ? adapter.getDispatch() : null;
	}	
}
