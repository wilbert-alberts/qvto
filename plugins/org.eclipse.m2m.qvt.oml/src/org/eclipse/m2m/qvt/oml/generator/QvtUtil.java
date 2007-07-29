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


public class QvtUtil {
	private QvtUtil() {
	}

	public static String getPackageName(final CompiledModule module) {
	    return module.getModule().getNsPrefix();
	}

	public static String getQualifiedModuleName(final CompiledModule module) {
	    String packageName = getPackageName(module);
	    return QvtUtil.getQualifiedName(packageName, module.getModule().getName());
	}

	public static String getQualifiedName(String packageName, String name) {
	    String qName;
	    if(packageName == null || packageName.length() == 0) {
	        qName = name;
	    }
	    else {
	        qName = packageName + "." + name; //$NON-NLS-1$
	    }
	    
	    return qName;
	}

}
