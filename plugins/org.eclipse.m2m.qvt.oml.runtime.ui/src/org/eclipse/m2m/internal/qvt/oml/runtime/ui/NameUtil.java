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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;

public class NameUtil {
    private NameUtil() {}
    public static String getFileNameForResult(String moduleName, EClass cls) {
        return moduleName + "." + getExtensionForResult(cls); //$NON-NLS-1$
    }
    
    public static String getExtensionForResult(final EClass cls) {
        if(cls == null) {
            return "xmi"; //$NON-NLS-1$
        }
        
        EPackage root = EmfUtil.getRootPackage(cls.getEPackage());
        return root.getName();
    }
}
