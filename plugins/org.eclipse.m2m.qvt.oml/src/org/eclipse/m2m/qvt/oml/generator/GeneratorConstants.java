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
package org.eclipse.m2m.qvt.oml.generator;

import org.eclipse.m2m.qvt.oml.ocl.metainfo.OclReflectiveMetainfoConstants;


public interface GeneratorConstants {

    public static final String CLASS_NAME_SUFFIX = "_Mapping"; //$NON-NLS-1$

    public static final String INTERFACE_NAME = "Interface"; //$NON-NLS-1$

    public static final String INTERFACE_NAME_SUFFIX = "." + INTERFACE_NAME; //$NON-NLS-1$

    public static final String IMPLEMENTATION_NAME = "Implementation"; //$NON-NLS-1$

    public static final String IMPLEMENTATION_NAME_SUFFIX = "." + IMPLEMENTATION_NAME; //$NON-NLS-1$

    public static final String EXECUTABLE_NAME = OclReflectiveMetainfoConstants.EXECUTABLE_NAME;

    public static final String METAINFO_NAME = OclReflectiveMetainfoConstants.METAINFO_NAME;

    public static final String METAINFO_NAME_SUFFIX = "." + EXECUTABLE_NAME + "." + METAINFO_NAME; //$NON-NLS-1$ //$NON-NLS-2$

    public static final String PROPERTIES_NAME = "Properties"; //$NON-NLS-1$
    
    public static final String PROPERTIES_REFERENCE = INTERFACE_NAME + "." + PROPERTIES_NAME; //$NON-NLS-1$
}