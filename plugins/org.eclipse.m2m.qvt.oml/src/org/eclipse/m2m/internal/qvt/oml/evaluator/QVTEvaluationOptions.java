/*******************************************************************************
 * Copyright (c) 2008, 2014 Borland Software Corporation and others.
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

import org.eclipse.m2m.qvt.oml.util.ISessionData;

public class QVTEvaluationOptions {

	public static final ISessionData.SimpleEntry<Boolean> FLAG_READONLY_GUARD_ENABLED = new ISessionData.SimpleEntry<Boolean>();

	/**
	 * QVTo evaluator's maximum stack depth. Default maximum depth is 1000.
	 */
	public static final ISessionData.SimpleEntry<Integer> EVALUATION_MAX_STACK_DEPTH = new ISessionData.SimpleEntry<Integer>(1000);
	
}
