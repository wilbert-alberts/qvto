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
package org.eclipse.m2m.qvt.oml.editor.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.qvt.oml.editor.ui.messages"; //$NON-NLS-1$

	//public static String QvtEditor_title;
	
	public static String QvtCompilerFacade_compilingDoc;
	
	public static String QvtCompilerFacade_acquiringDoc;
	
	public static String QvtAnnotationHover_multipleMarkers;

	public static String OpenDeclarationAction_selectionDoesNotResolveToElement;	
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
