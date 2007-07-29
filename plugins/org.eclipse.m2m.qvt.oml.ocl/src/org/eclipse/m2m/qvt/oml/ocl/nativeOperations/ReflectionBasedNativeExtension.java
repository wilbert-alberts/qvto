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
 * Created on Apr 4, 2005
 */
package org.eclipse.m2m.qvt.oml.ocl.nativeOperations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.m2m.qvt.oml.ocl.Logger;



public class ReflectionBasedNativeExtension {
    
    private static final String ATTR_NAME = "name"; //$NON-NLS-1$
    private static final String ATTR_METHOD_NAME = "methodName"; //$NON-NLS-1$
    private static final String ATTR_RETURN_TYPE = "returnType"; //$NON-NLS-1$
    private static final String ATTR_CONTEXT = "context"; //$NON-NLS-1$
    protected static final String ELEMENT_PARAMETER = "parameter"; //$NON-NLS-1$
    private static final String ELEMENT_IMPLICIT_PARAMETER = "implicitParameter"; //$NON-NLS-1$
    protected static final String ATTR_TYPE = "type"; //$NON-NLS-1$
    private static final String ATTR_CLASS = "class"; //$NON-NLS-1$
    
    private IConfigurationElement myConfig;
    private String myName;
    private String myReturnType;
    private String myContext;
    private List<String> myParameterTypes;
    private List<String> myImplicitParameterNames;
    private Object myInstance;
    private String myClassName;
    private boolean mySkipReturnTypeCheck;
    private String myMethodName;
    private Method myLastCalledMethod;

    public ReflectionBasedNativeExtension(IConfigurationElement config) {
        myConfig = config;
        myName = config.getAttribute(ATTR_NAME);
        if (myName == null) {
            Logger
                    .getLogger()
                    .log(
                            Logger.SEVERE,
                            "Native extension has no name in: " + myConfig.getNamespaceIdentifier()); //$NON-NLS-1$
        }
        myClassName = config.getAttribute(ATTR_CLASS);
        myReturnType = config.getAttribute(ATTR_RETURN_TYPE);
        myContext = config.getAttribute(ATTR_CONTEXT);
        if (myContext == null) {
            Logger
                    .getLogger()
                    .log(
                            Logger.SEVERE,
                            "Native extension " + myName + " has no context in: " + myConfig.getNamespaceIdentifier()); //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        {
            IConfigurationElement[] parameters = config
                    .getChildren(ELEMENT_PARAMETER);
            myParameterTypes = new LinkedList<String>();
            for (int i = 0; i < parameters.length; i++) {
                myParameterTypes.add(parameters[i].getAttribute(ATTR_TYPE));
            }
        }

        {
            IConfigurationElement[] implicitParameters = config
                    .getChildren(ELEMENT_IMPLICIT_PARAMETER);
            myImplicitParameterNames = new LinkedList<String>();
            for (int i = 0; i < implicitParameters.length; i++) {
                myImplicitParameterNames.add(implicitParameters[i]
                        .getAttribute(ATTR_NAME));
            }
        }
        myMethodName = config.getAttribute(ATTR_METHOD_NAME);
    }

    public String getContext() {
        return myContext;
    }

    public String getName() {
        return myName;
    }

    public String getReturnType() {
        return myReturnType;
    }

    public List<String> getParameterTypes() {
        return myParameterTypes;
    }
    
    public List<String> getImplicitParameterNames() {
        return myImplicitParameterNames;
    }

    public Object run(Object context, Object[] parameterValues,
            Object[] implicitParameterValues, Class returnTypeClass) {
        if (getInstance() == null) {
            Logger
                    .getLogger()
                    .log(Logger.SEVERE,
                            "Native method execution stopped - no extension class instance available"); //$NON-NLS-1$
            return null;
        }

        parameterValues = getJointParametersArray(parameterValues,
                implicitParameterValues);
        Object[] parameters = new Object[parameterValues.length + 1];
        parameters[0] = context;
        System.arraycopy(parameterValues, 0, parameters, 1,
                parameterValues.length);
        Method method = null;

        if (myLastCalledMethod != null) {
            Class[] parameterClasses = getParameterClasses(parameters);
            if (conforms(myLastCalledMethod, getMethodName(), parameterClasses,
                    returnTypeClass)) {
                method = myLastCalledMethod;
            } else {
                parameterClasses = getParameterClasses(parameterValues);
                if (conforms(myLastCalledMethod, getMethodName(),
                        parameterClasses, returnTypeClass)) {
                    parameters = parameterValues;
                    method = myLastCalledMethod;
                }
            }
        }
        
        if (method == null) {
            method = getApplicableMethod(parameters, returnTypeClass);
            if (method == null) {
                parameters = parameterValues;
                method = getApplicableMethod(parameters, returnTypeClass);
            }
        }
        
        if (method == null) {
        	String parameterString = getParameterString(getParameterClasses(parameterValues)); 
            throw new RuntimeException("No suitable operation found in " + getInstance().getClass().getName() +  //$NON-NLS-1$
                    " required operation: " + getMethodName() + "(" + parameterString + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }
        
        myLastCalledMethod = method;
        try {
            Object result = method.invoke(getInstance(), parameters);
            if (mySkipReturnTypeCheck) {
                if (result != null && !returnTypeClass.isInstance(result)) {
                	throw new RuntimeException("Native operation produced result which has different type then declared: " //$NON-NLS-1$
                                    + result + " could not be casted to " //$NON-NLS-1$
                                    + returnTypeClass);
                }
            }
            return result;
        } 
        catch (IllegalAccessException e) {
        	throw new RuntimeException(e);
        }
        catch (InvocationTargetException e) {
        	throw new RuntimeException(e.getTargetException());
        }
    }
    
    private Object[] getJointParametersArray(Object[] parameterValues,
            Object[] implicitParameterValues) {
        Object[] result = new Object[parameterValues.length
                + implicitParameterValues.length];
        System.arraycopy(parameterValues, 0, result, 0, parameterValues.length);
        System.arraycopy(implicitParameterValues, 0, result,
                parameterValues.length, implicitParameterValues.length);
        return result;
    }

    public String getOperationReference(String[] parameterNames) {
        String className = getClassName();

        StringBuffer paramString = new StringBuffer();
        for(int i = 0, len=parameterNames.length; i < len; i++) {
            paramString.append(parameterNames[i]);
            if(i < len-1) {
                paramString.append(", "); //$NON-NLS-1$
            }
        }
        
        String call = "new " + className + "()." + getMethodName() + "(" + paramString + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        return call;
    }
    
    @Override
    public String toString() {
    	return myName + myParameterTypes + "/" + myClassName; //$NON-NLS-1$
    }
    
    private Method getApplicableMethod(Object[] parameterValues, Class returnType) {
        Class[] parameterClasses = getParameterClasses(parameterValues);
        Object instance = getInstance();
        Class instanceClass = instance.getClass();
        Method[] methods = instanceClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (conforms(methods[i], getMethodName(), parameterClasses, returnType)) {
                return methods[i];
            }
        }

        return null;
    }

	private static String getParameterString(Class[] parameterClasses) {
		String parameterString = ""; //$NON-NLS-1$
        for (int i = 0; i < parameterClasses.length; i++) {
            if (!"".equals(parameterString)) { //$NON-NLS-1$
                parameterString += ", "; //$NON-NLS-1$
            }
            parameterString += (parameterClasses[i] == null ? "null" : parameterClasses[i].getName()); //$NON-NLS-1$
        }
        
        return parameterString;
	}
    
    protected IConfigurationElement getConfigurationElement() {
        return myConfig;
    }
    
    protected void setReturnTypeCkeck(boolean onRuntime) {
        mySkipReturnTypeCheck = onRuntime;
    }
    
    private Class[] getParameterClasses(Object[] parameters) {
        Collection<Class> parameterClasses = new ArrayList<Class>();
        for (int i = 0; i < parameters.length; i++) {
//          null parameters are conformed to any classes
            parameterClasses.add(parameters[i] == null ? null : parameters[i].getClass());
        }
        return parameterClasses.toArray(new Class[parameterClasses.size()]);
    }
    
    private boolean conforms(Method method, String name, Class[] parameters, Class<?> returnType) {
        if (method.getName().equals(name)) {
            if (conforms(parameters, method.getParameterTypes())) {
                if (mySkipReturnTypeCheck) {
                    return true;
                }
                if (returnType.isAssignableFrom(method.getReturnType())) {
                    return true;
                } else {
                    Logger.getLogger().log(Logger.SEVERE, "Class " + method.getDeclaringClass().getName() +  //$NON-NLS-1$
                            " declares method " + method.toString() +  //$NON-NLS-1$
                            " with incorrect return type: " + returnType.getName() + " required"); //$NON-NLS-1$ //$NON-NLS-2$
                }
            }
        }
        return false;
    }
    
    private boolean conforms(Class[] actualClasses, Class[] requiredClasses) {
        if (requiredClasses.length != actualClasses.length) {
            return false;
        }
        for (int i = 0; i < requiredClasses.length; i++) {
            // null parameters are conformed to any classes
            Class<?> required = requiredClasses[i];
            Class actual = actualClasses[i];
            if (actual != null && !required.isAssignableFrom(actual)) {
                Logger
                        .getLogger()
                        .log(
                                Logger.WARNING,
                                "Type " + required + " is not assignable from " + actual); //$NON-NLS-1$ //$NON-NLS-2$
                return false;
            }
        }
        return true;
    }
    
    private Object getInstance() {
        if (myInstance == null) {
            try {
                myInstance = myConfig.createExecutableExtension(ATTR_CLASS);
            } catch (CoreException e) {
                Logger.getLogger().log(Logger.SEVERE,
                        "Unable to instantiate class with native operation", e); //$NON-NLS-1$
            }
        }
        return myInstance;
    }

    private String getClassName() {
        return myClassName;
    }
    
    private String getMethodName() {
        if (myMethodName == null) {
            myMethodName = getName();
        }
        return myMethodName;
    }
    
}
