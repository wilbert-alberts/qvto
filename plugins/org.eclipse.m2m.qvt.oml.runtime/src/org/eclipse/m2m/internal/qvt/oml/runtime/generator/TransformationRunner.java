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
/*
 * Created on 05.10.2004
 */
package org.eclipse.m2m.internal.qvt.oml.runtime.generator;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.qvt.oml.library.IContext;
import org.eclipse.m2m.qvt.oml.trace.Trace;


public interface TransformationRunner {
	
    public static class In {
    	
        /**
         * Create input for the transformation
         * @param sources {ordered} list of 'in' and 'inout' transformation params
         * @param context transformation context (external properties, etc.)
         */
        public In(EObject[] sources, IContext context) {
            mySources = sources.clone();
            myContext = context;
        }
        
        public EObject[] getSources() {
            return mySources;
        }
        
        public IContext getContext() {
            return myContext;
        }
        
        private final EObject[] mySources;
        private final IContext myContext;
    }
    
    public static class Out {
    	
        public Out(List<Resource> modelExtents, List<Object> outParamValues, Trace trace) {
        	myModelExtents = modelExtents;
        	myOutParamValues = outParamValues;
            myTrace = trace;
        }
        
        public List<Resource> getExtents() {
            return myModelExtents;
        }
        
        public List<Object> getOutParamValues() {
            return myOutParamValues;
        }
        
        public Trace getTrace() {
            return myTrace;
        }
        
        private final List<Resource> myModelExtents;
        private final List<Object> myOutParamValues;
        private final Trace myTrace;
    }
    
}
