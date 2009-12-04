/*******************************************************************************
 * Copyright (c) 2009 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.debug.ui;

import org.eclipse.osgi.util.NLS;

public class DebugUIMessages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.debug.ui.DebugUIMessages"; //$NON-NLS-1$

	public static String Activator_StatusDialog_Error;
    public static String Activator_StatusDialog_Warning;
    public static String Activator_StatusDialog_Information;

    public static String BreakpointConditionEditor_EnterCondition;
    public static String EnableDisableBreakpointRulerAction_EnableBreakpoint;
	public static String EnableDisableBreakpointRulerAction_DisableBreakpoint;
	public static String EnableDisableBreakpointRulerAction_EnableDisableBreakpoint;
	public static String EnableDisableBreakpointRulerAction_ErrorTitle;
	public static String EnableDisableBreakpointRulerAction_ErrorMessage;
	public static String ManageBreakpointRulerAction_text;	
	public static String QvtBreakpointListener_CompilationFailed;

    public static String QvtBreakpointListener_ExceptionInRuntime;

    public static String QvtBreakpointPage_CancelBreakpointCreationError;

    public static String QvtBreakpointPage_CreateBreakpointForModule;

    public static String QvtBreakpointPage_Enabled;

    public static String QvtBreakpointPage_HitCount;

    public static String QvtBreakpointPage_HitCountErrorMessage;

    public static String QvtBreakpointPage_Module;

    public static String QvtBreakpointPage_ModulePrepareBreakpoint;

    public static String QVTOToggleBreakpointAdapter_VerifyBreakpointJob;
	public static String QVTOToggleBreakpointAdapter_CannotSetBreakpoint;
	public static String QvtLineBreakpointPage_ConditionTrue;

    public static String QvtLineBreakpointPage_ConditionValueChange;

    public static String QvtLineBreakpointPage_EnableCondition;
//    public static String QvtLineBreakpointPage_EnableConditionWithCodeAssist;

//    public static String QvtLineBreakpointPage_EnableConditionWithoutCodeAssist;

    public static String QvtLineBreakpointPage_LineBreakpoint;

    public static String QvtLineBreakpointPage_LineNumber;

    public static String QvtLineBreakpointPage_SuspendCondition;

    public static String QvtRunToLineAdapter_InvalidLocation;
	public static String QvtRunToLineAdapter_NoFile;
	public static String QvtRunToLineAdapter_NoDocument;
	public static String QvtRunToLineAdapter_NoInput;
    public static String BreakpointCondErrorHandler_EditConditionButtonLabel;
    public static String BreakpointCondErrorHandler_DialogTitle;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, DebugUIMessages.class);
	}

	private DebugUIMessages() {
	}
}
