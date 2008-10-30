package org.eclipse.m2m.internal.qvt.oml.blackbox.java;

import org.eclipse.osgi.util.NLS;

public class JavaBlackboxMessages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.blackbox.java.JavaBlackboxMessages"; //$NON-NLS-1$
	
	public static String BlackboxUnitLoadFailed;

	public static String InvalidJavaClassForModule;

	public static String LoadModuleDiagnostics;

	public static String LoadOperationDiagnostics;
	public static String MethodInvocationError;

	public static String ModuleJavaClassNotFound;

	public static String UnresolvedMetamodelURI;

	public static String UnresolvedOclTypeForJavaType;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, JavaBlackboxMessages.class);
	}

	private JavaBlackboxMessages() {
	}
}
