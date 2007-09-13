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
package org.eclipse.m2m.qvt.oml;

import org.eclipse.osgi.util.NLS;

class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.qvt.oml.messages"; //$NON-NLS-1$
	
	public static String QvtNamesChecker_blankIdentifierError;
	public static String QvtNamesChecker_illegalCharInIdentifierError;

	public static String QvtNamesChecker_InvalidCUnitName;
	public static String QvtNamesChecker_invalidQualifiedIdentifierError;
	public static String QvtNamesChecker_moduleIndentifierKindName;
	public static String QvtNamesChecker_namespaceIndentifierKindName;

	public static String QvtNamesChecker_reservedQVTWord;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
