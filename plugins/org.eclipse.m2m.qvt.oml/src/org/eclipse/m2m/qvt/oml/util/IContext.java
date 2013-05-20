/*******************************************************************************
 * Copyright (c) 2007, 2010 Borland Software Corporation and others.
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

import java.util.Map;


/**
 * @noimplement
 * @noextend
 * @since 3.0
 */
public interface IContext {

	/**
	 * Retrieve the logger associated with this context.
	 * <p>
	 * It is used to capture the output of QVT <code>log expression</code>
	 * or various execution diagnostic messages.
	 * 
	 * @return the log object, never <code>null</code>
	 */
	Log getLog();

	/**
	 * Retrieve the monitor associated with this context.
	 * <p>
	 * It can be used to interrupt execution from another thread then the
	 * execution thread.
	 * 
	 * @return the monitor object, never <code>null</code>
	 */
    EvaluationMonitor getMonitor();
		
    Map<String, Object> getConfigProperties();
    
    Object getConfigProperty(String name);
    
    ISessionData getSessionData();    
}
