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
package org.eclipse.m2m.tests.qvt.oml.traces;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.qvt.oml.common.emf.ExtendedEmfUtil;
import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.qvt.oml.trace.Trace;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;
import org.eclipse.m2m.tests.qvt.oml.transform.TestTransformation;
import org.eclipse.m2m.tests.qvt.oml.transform.TestTransformation.ITransformer;


public class TraceUtil {
	private TraceUtil() {}
	
	
	public static Trace transform(ModelTestData data, IProject project, ITransformer transformer) throws Exception {
		IFile transformation = TestTransformation.getIFile(data.getTransformation(project));
        
        transformer.transform(transformation, data.getIn(project), data.getContext());
        
        CFile traceFile = TestTransformation.getTraceFile(new EclipseFile(transformation));
        if(!traceFile.exists()) {
        	throw new RuntimeException("Trace file not found: " + traceFile); //$NON-NLS-1$
        }
        
        return loadTraceModel(traceFile);
	}
	
	public static Trace loadTraceModel(CFile file) {
		EObject obj = ExtendedEmfUtil.loadModel(file);
	    if(obj instanceof Trace == false) {
	        throw new RuntimeException("File does not contain trace model: " + file.getFullPath()); //$NON-NLS-1$	    
	    }
	    
	    return (Trace) obj;
	}
}
