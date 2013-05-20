/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
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


public class QvtTransitionReachedException extends QvtRuntimeException {

	private static final long serialVersionUID = 460249893891473965L;

	public static final int REASON_BREAK = 1;
	
	public static final int REASON_CONTINUE = 2;

	public QvtTransitionReachedException(int reason) {
		myReason = reason;
	}
	
	public int getReason() {
		return myReason;
	}
	
	private final int myReason;
	
}
