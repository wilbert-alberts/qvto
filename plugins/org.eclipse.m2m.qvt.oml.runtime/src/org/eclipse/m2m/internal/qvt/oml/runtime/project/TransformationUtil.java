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
package org.eclipse.m2m.internal.qvt.oml.runtime.project;

import java.util.Arrays;
import java.util.List;

import org.eclipse.m2m.qvt.oml.QvtMessage;
import org.eclipse.m2m.qvt.oml.compiler.CompiledModule;

public class TransformationUtil {
    private TransformationUtil() {}
    
    public static void getErrors(CompiledModule module, List<QvtMessage> errors) {
        errors.addAll(Arrays.asList(module.getErrors()));
        for (CompiledModule imp : module.getCompiledImports()) {
            getErrors(imp, errors);
        }
    }
    
    public static final String DEFAULT_RESULT_EXTENSION = "psm"; //$NON-NLS-1$
}
