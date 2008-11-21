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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandler;

public interface ModuleInstance extends EObject, ThisInstanceResolver {

	Module getModule();

	/**
	 * Obtains an adapter for the specified interface type.
	 * 
	 * @param <T> the requested adapter interface
	 * 
	 * @param adapterType the requested adapter interface
	 * @return an instance of the requested interface, or <code>null</code>
	 *     if this module instance does not adapt to it
	 */
	<T> T getAdapter(Class<T> adapterType);
 
	interface Internal {
		void addAdapter(Object adapter);

		void setEntryOperationHandler(CallHandler handler);
	
		CallHandler getEntryOperationHandler();
	}
}