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
package org.eclipse.m2m.internal.qvt.oml.blackbox.java;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;


class DiagnosticUtil {

	static final String DIAGNOSTIC_SOURCE = "org.eclipse.m2m.qvt.oml.blackbox.java"; //$NON-NLS-1$	

	static final DiagnosticChain OK_INSTANCE = createRootDiagnostic("OK"); //$NON-NLS-1$
	
	// no instances
	private DiagnosticUtil() {
		super();
	}
	
	public static DiagnosticChain createRootDiagnostic(String message) {
		return new BasicDiagnostic(DIAGNOSTIC_SOURCE, 0, message, null);
	}
	
	public static Diagnostic createErrorDiagnostic(String message) {
		return new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, message, null);
	}	
}
