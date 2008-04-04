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
package org.eclipse.m2m.internal.qvt.oml.compiler;

import org.eclipse.osgi.util.NLS;

public class CompilerMessages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.compiler.CompilerMessages"; //$NON-NLS-1$

	public static String cyclicImportError;
	public static String moduleAlreadyImported;
	public static String importedModuleNotFound;	
	public static String importHasCompilationError;
	public static String emptyImport;	
	public static String analyserExceptionLogPattern;
	public static String moduleTransformationExpected;
	
	public static String QvtCompilerFacade_compilingScript;
	public static String QvtCompilerFacade_acquiringScript;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, CompilerMessages.class);
	}

	private CompilerMessages() {
	}
}
