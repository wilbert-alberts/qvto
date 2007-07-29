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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.qvt.oml.QvtEngine;
import org.eclipse.m2m.qvt.oml.QvtMessage;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.osgi.util.NLS;

public class TransformationUtil {
    private TransformationUtil() {}
    
    public static String getExtensionForResult(final CFile transformationFile) {
        CompiledModule module;
        try {
             module = compile(transformationFile);
        } 
        catch (MdaException e) {
            return DEFAULT_RESULT_EXTENSION;
        }
        
        ImperativeOperation mainMethod = (ImperativeOperation) module.getModule().getEntry();
        if (mainMethod == null) {
            return DEFAULT_RESULT_EXTENSION;
        }
        if (mainMethod.getResult().isEmpty()) {
            return DEFAULT_RESULT_EXTENSION;
        }
        
        EPackage namespace = getFirstNamespace(mainMethod.getResult().get(0).getEType());
        if(namespace != null) {
            return namespace.getName();
        }
        
        return DEFAULT_RESULT_EXTENSION;
    }
    
    private static EPackage getFirstNamespace(EClassifier type) {
        if (type == null) {
            return null;
        }
        
        EObject parent = type.eContainer();
        while (parent != null) {
        	if (parent instanceof EPackage) {
        		return (EPackage) parent;
        	}
        	parent = parent.eContainer();
        }
        return null;
    }

    public static String getFileNameForResult(final CFile transformationFile) {
        String fileName = transformationFile.getUnitName();
        return fileName + "." + getExtensionForResult(transformationFile); //$NON-NLS-1$
    }
    
    public static CompiledModule compile(CFile cfile) throws MdaException {
        CompiledModule module;
        IFile file = ((EclipseFile)cfile).getFile();
        module = QvtEngine.getInstance(file).compile(file, null);
        List<QvtMessage> errors = new ArrayList<QvtMessage>();
        getErrors(module, errors);
        if(!errors.isEmpty()) {
            throw new MdaException(NLS.bind(Messages.TransformationUtil_ParseTransformationError, file, errors.size()));
        }
        
        return module;
    }
    
    public static void getErrors(CompiledModule module, List<QvtMessage> errors) {
        errors.addAll(Arrays.asList(module.getErrors()));
        for (CompiledModule imp : module.getCompiledImports()) {
            getErrors(imp, errors);
        }
    }
    
    public static final String DEFAULT_RESULT_EXTENSION = "psm"; //$NON-NLS-1$
}
