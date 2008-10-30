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

import org.eclipse.emf.common.util.Diagnostic;

public class BlackboxException extends Exception {

	private static final long serialVersionUID = -4825358108795928298L;

	private Diagnostic fDiagnostic;
	
	public BlackboxException(Diagnostic diagnostic) {
		super();
		fDiagnostic = diagnostic;
	}

	public BlackboxException(String message) {
		super(message);
	}

	public BlackboxException(Throwable throwable) {
		super(throwable);
	}

	public BlackboxException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	@Override
	public String getMessage() {
		String message = super.getMessage();
		return (message != null) ? message : fDiagnostic.getMessage();
	}
	
	/** 
	 * @return the diagnostic object or <code>null</code>
	 */
	public Diagnostic getDiagnostic() {
		return fDiagnostic;
	}	
}
