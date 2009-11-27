package org.eclipse.m2m.qvt.oml.debug.core;


public class DebugOptions {

	private DebugOptions() {
		super();
	}

	public static final String DEBUG = QVTODebugCore.PLUGIN_ID + "/debug"; //$NON-NLS-1$

	public static final String TARGET = DEBUG + "/target"; //$NON-NLS-1$
	public static final String VM = DEBUG + "/vm"; //$NON-NLS-1$
	public static final String EVALUATOR = DEBUG + "/evaluator"; //$NON-NLS-1$

	public static final String EXCEPTIONS_CATCHING = DEBUG + "/exceptions/catching"; //$NON-NLS-1$
	public static final String EXCEPTIONS_THROWING = DEBUG + "/exceptions/throwing"; //$NON-NLS-1$

	public static final String METHODS_ENTERING = DEBUG + "/methods/entering"; //$NON-NLS-1$
	public static final String METHODS_EXITING = DEBUG + "/methods/exiting"; //$NON-NLS-1$
}
