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

import org.eclipse.m2m.qvt.oml.compiler.CompiledModule;


/**
 * @author pfeldman
 */
public class QvtGeneratorUtil {

	public static String getQualifiedClassName(final CompiledModule module) {
        String packageName = QvtUtil.getPackageName(module);
        return QvtUtil.getQualifiedName(packageName, getClassName(module));
    }
    
    private static String getClassName(final String mappingModuleName) {
        return mappingModuleName + CLASS_NAME_SUFFIX;
    }
	
	private static String getClassName(final CompiledModule module) {
	    return getClassName(module.getModule().getName());
	}
    
    private static final String CLASS_NAME_SUFFIX = "_Mapping"; //$NON-NLS-1$

}
