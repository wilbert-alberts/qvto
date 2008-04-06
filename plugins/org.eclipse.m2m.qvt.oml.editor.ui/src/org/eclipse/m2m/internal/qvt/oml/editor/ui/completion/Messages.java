package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion;

import org.eclipse.osgi.util.NLS;

/**
 * @author Aleksandr Igdalov
 * Created on Jul 4, 2007
 */

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.messages"; //$NON-NLS-1$
	public static String QvtCompletionData_ErrorPerformingCodeCompletion;
	public static String QvtCompletionProcessor_ErrorMessage;
	public static String QvtCompletionProcessor_PressCtrlSpace;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
