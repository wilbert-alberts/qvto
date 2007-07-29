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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner;
import org.eclipse.m2m.qvt.oml.common.MdaException;

public class QvtOnJava {
    public QvtOnJava(IClInfo clInfo) {
    	myClInfo = clInfo;
    }
    
    public static interface IClInfo {
        String getClassName() throws MdaException;
        ClassLoader getClassLoader(ClassLoader parent) throws MdaException;
    }
    
    public IStatus canRun(EObject in) throws MdaException {
    	return getTransformer(in).isRunnableTransformation(in);
    }
    
    public TransformationRunner.Out run(TransformationRunner.In in) throws MdaException {
        TransformationRunner transformer = getTransformer(in.getSource());
        return transformer.transform(in);
    }
    
    private TransformationRunner getTransformer(EObject in) throws MdaException {
        ClassLoader parent = in.getClass().getClassLoader();
        ClassLoader cl = myClInfo.getClassLoader(parent);
        TransformationRunner runner = new TransformationRunner(cl, myClInfo.getClassName());
        return runner;
    }
    
    private final IClInfo myClInfo;
}
