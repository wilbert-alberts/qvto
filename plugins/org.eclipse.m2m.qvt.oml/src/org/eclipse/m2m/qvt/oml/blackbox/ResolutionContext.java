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
package org.eclipse.m2m.qvt.oml.blackbox;


public interface ResolutionContext {
	
	/**
	 * Obtains an adapter for the specified type.
	 * Supported adapted types: {@link org.eclipse.core.resources.IProject}, {@link org.osgi.framework.Bundle}
	 * 
	 * @param <T> the requested adapter type
	 * 
	 * @param adapterType
	 *            the requested adapter type
	 * @return an instance of the requested type, or <code>null</code> if this
	 *         context does not adapt to it
	 */
	<T> T getAdapter(Class<T> adapterType);
}
