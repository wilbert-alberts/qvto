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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.qvt.oml.common.Logger;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.emf.util.StatusUtil;
import org.eclipse.m2m.qvt.oml.library.IContext;
import org.eclipse.m2m.qvt.oml.trace.Trace;
import org.eclipse.osgi.util.NLS;


/**
 * @author feldman
 */
public class TransformationRunner {
	public TransformationRunner(ClassLoader cl, String className) {
		myCl = cl;
        myClassName = className;
	}
    
    public static class In {
    	
        /**
         * @deprecated use In(EObject[] sources, IContext context) instead
         */
        public In(EObject source, IContext context) {
            mySources = new EObject[] {source};
            myContext = context;
        }

        /**
         * Create input for the transformation
         * @param sources {ordered} list of 'in' and 'inout' transformation params
         * @param context transformation context (external properties, etc.)
         */
        public In(EObject[] sources, IContext context) {
            mySources = sources.clone();
            myContext = context;
        }
        
        /**
         * @deprecated use getSources() instead
         */
        public EObject getSource() {
            return mySources[0];
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
    	
        /**
         * @deprecated use Out(ResourceSet modelExtents, Trace trace) instead
         */
        public Out(EObject result, Trace trace) {
        	myModelExtents = new ArrayList<Resource>(1);
            myResult = result;
            myTrace = trace;

            if (result.eResource() != null) {
            	myModelExtents.add(result.eResource());
            }
            else {
	            Resource resource = new ResourceSetImpl().createResource(EcoreUtil.getURI(result));
	        	resource.getContents().add(result);
	        	myModelExtents.add(resource);
            }
        }
        
        public Out(List<Resource> modelExtents, Trace trace) {
        	myModelExtents = modelExtents;
            myResult = null;
            myTrace = trace;
        }
        
        /**
         * @deprecated use getExtents() instead
         */
        public EObject getResult() {
        	if (myResult == null) {
        		if (!myModelExtents.isEmpty() && !myModelExtents.get(0).getContents().isEmpty()) {
        			return myModelExtents.get(0).getContents().get(0);
        		}
        	}
            return myResult;
        }
        
        public List<Resource> getExtents() {
            return myModelExtents;
        }
        
        public Trace getTrace() {
            return myTrace;
        }
        
        private final List<Resource> myModelExtents;
        private final EObject myResult;
        private final Trace myTrace;
    }
    
    public static class NoMainMethodException extends MdaException {
		private static final long serialVersionUID = -3817998405792343727L;

		public NoMainMethodException(String message) { super(message); }
    }
    
    public Out transform(In in) throws MdaException {
        Class tClass = loadTransformationClass();
        Method main = getMainMethod(tClass, in.getSource());
        if (main == null) {
            throw new NoMainMethodException(NLS.bind(Messages.TransformationRunner_NotRunnableOnSource, tClass, in.getSource()));
        }
        
        EObject out;
        try {
            Object tInstance = createInstance(tClass);
            out = (EObject)main.invoke(tInstance, new Object[] { in.getContext(), in.getSource()});
        }
        catch(Exception e) {
            throw new MdaException(NLS.bind(Messages.TransformationRunner_FailedForInput, tClass.getName(), EcoreUtil.getURI(in.getSource())), e); 
        }
        
        return new Out(out, in.getContext().getTrace());
    }
	
    private Object createInstance(Class tClass) throws Exception {
        //Constructor ctor = tClass.getConstructor(new Class[] {IContext.class});
        //tInstance = ctor.newInstance(new Object[] { ctx });
        Object tInstance = tClass.newInstance();
        return tInstance;
    }

    public IStatus isRunnableTransformation(EObject source) {
        try {
	        Class tClass = loadTransformationClass();
	        if (tClass == null) {
	        	return StatusUtil.makeErrorStatus(NLS.bind(Messages.TransformationRunner_FailedToLoadClass, myClassName));
	        }
	        Method main = getMainMethod(tClass, source);
	        if (main == null) {
	        	return StatusUtil.makeErrorStatus(NLS.bind(Messages.TransformationRunner_NotRunnableOnSource, tClass, source));
	        }
	        return StatusUtil.makeOkStatus();
        }
        catch(MdaException e) {
            Logger.getLogger().log(Logger.WARNING, "Failed to check runnability for " + myClassName, e); //$NON-NLS-1$
            return StatusUtil.makeErrorStatus(e.getMessage());
        }
    }

    private Class loadTransformationClass() throws MdaException {
        try {
            Class tClass = myCl.loadClass(myClassName);
            return tClass;
        }
        catch(Exception e) {
        	throw new MdaException(NLS.bind(Messages.TransformationRunner_FailedToLoadTransformation, myClassName), e);
        }
        catch(NoClassDefFoundError e) {
            throw new MdaException(NLS.bind(Messages.TransformationRunner_FailedToLoadTransformation, myClassName), e);
        }
    }
    
    private Method getMainMethod(Class tClass, EObject source) {
        Method[] methods = tClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            if(!QvtOperationalUtil.MAIN_METHOD_NAME.equals(method.getName())) {
                continue;
            }
            
            if(method.getParameterTypes().length != 2) {
                continue;
            }
            
            {
                Class actualType = method.getParameterTypes()[0];
                Class expectedType = IContext.class;
                if(!actualType.equals(expectedType)) {
                    Logger.getLogger().warning("Actual parameter type " + actualType + " (cl=" + actualType.getClassLoader() + ")" +   //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                            " is not a " + expectedType + " (cl=" + expectedType.getClassLoader() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    continue;
                }
            }
            
            {
                Class actualType = method.getParameterTypes()[1];
                if(!actualType.isInstance(source)) {
                    Logger.getLogger().warning("Actual parameter " + source + " (cl=" + source.getClass().getClassLoader() + ")" +  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                            " is not an instance of formal parameter " + actualType + " (cl=" + actualType.getClassLoader() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    continue;
                }
            }
                
            if(!EObject.class.isAssignableFrom(method.getReturnType())) {
                Logger.getLogger().warning("EObject (cl=" + EObject.class.getClassLoader() + ")" +  //$NON-NLS-1$ //$NON-NLS-2$
                        " is not assignable from method return type " + method.getReturnType() + " (cl=" + method.getReturnType().getClassLoader() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                continue;
            }
            
            return method;
        }
        
        return null;
    }
    
	private final ClassLoader myCl;
    private final String myClassName;
    
}
