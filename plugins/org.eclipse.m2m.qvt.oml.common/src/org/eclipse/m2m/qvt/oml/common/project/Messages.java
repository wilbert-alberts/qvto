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
package org.eclipse.m2m.qvt.oml.common.project;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "org.eclipse.m2m.qvt.oml.common.project.messages"; //$NON-NLS-1$

    public static String TransformationProject_CreateExtensionError;
    public static String TransformationProject_AddImportFailed;
    public static String TransformationProject_CreateImportFailed;
    
    public static String TransformationRegistry_MissingMetamodelAttr;
    public static String TransformationRegistry_MissingMetaclassAttr;
    public static String TransformationRegistry_UnknownMetamodel;
    public static String TransformationRegistry_NoElements;

    public static String PluginUtil_PluginModelLoadError;
    
	static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
