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
package org.eclipse.m2m.qvt.oml.util;

public interface EvaluationMonitor {
	/**
	 * The caller signals the request for cancel execution. 
	 */
	void cancel();
	
	/**
	 * Indicates whether QVT evaluation associated with this monitor has been 
	 * canceled by calling {@link #cancel()}.
	 */
	boolean isCanceled();
}
