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
package org.eclipse.m2m.qvt.oml.internal.ast.evaluator;

import org.eclipse.osgi.util.NLS;

public class EvaluationMessages extends NLS {
    private static final String BUNDLE_NAME = "org.eclipse.m2m.qvt.oml.internal.ast.evaluator.messages";//$NON-NLS-1$

    private EvaluationMessages() {
    }
    
	public static String AssertFailedMessage;
	public static String ExtendedOclEvaluatorVisitorImpl_InvalidObjectExpType;
    public static String ExtendedOclEvaluatorVisitorImpl_ModuleNotExecutable;
    public static String ExtendedOclEvaluatorVisitorImpl_ReadOnlyInputModel;
    public static String FatalAssertionFailed;
	public static String TerminatingExecution;
	public static String UknownSourceLabel;  
    
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, EvaluationMessages.class);
    }

	
}
