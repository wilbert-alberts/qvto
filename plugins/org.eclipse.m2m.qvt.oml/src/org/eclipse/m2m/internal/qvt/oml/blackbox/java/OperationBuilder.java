/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.blackbox.java;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory;
import org.eclipse.m2m.internal.qvt.oml.expressions.Helper;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Parameter;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.ocl.Environment;
import org.eclipse.osgi.util.NLS;

class OperationBuilder {
	
	private Java2QVTTypeResolver fTypeResolver;
	private BasicDiagnostic fProblems;
	
	OperationBuilder(Java2QVTTypeResolver typeResolver) {
		fTypeResolver = typeResolver;
	}
	
	public EOperation buildOperation(Method javaMethod) {
    	resetErrors();		
		return createOperation(javaMethod);
	}	
	
	public Diagnostic getDiagnostics() {
		return fProblems != null ? fProblems : Diagnostic.OK_INSTANCE;
	}
		
    private EOperation createOperation(Method method) {    	
    	EClassifier contextType = null;
    	String name = method.getName();
    	Type resultType = method.getGenericReturnType();
    	Type[] paramTypes = method.getGenericParameterTypes();
    	Annotation[][] annotations = method.getParameterAnnotations();

    	Operation operAnnotation = method.getAnnotation(Operation.class);
    	boolean isContextual = operAnnotation != null && operAnnotation.contextual();    	
    	Operation.Kind operKind = (operAnnotation != null) ? operAnnotation.kind() : Operation.Kind.OPERATION;
    	if(operKind == Kind.OPERATION) {
    		operKind = Kind.HELPER;
    	}
    	
        EOperation operation;
        if(operKind == Kind.OPERATION) { 
        	operation = EcoreFactory.eINSTANCE.createEOperation();
        } else if(operKind == Kind.QUERY || operKind == Kind.HELPER) {
        	Helper helper = ExpressionsFactory.eINSTANCE.createHelper();
        	helper.setIsQuery(operKind == Kind.QUERY);
        	operation = helper;
        } else {
        	assert false : "unsupported operation kind"; //$NON-NLS-1$
        	operation = EcoreFactory.eINSTANCE.createEOperation();
        }
        
        operation.setName(name);
        operation.setEType(fTypeResolver.toEClassifier(resultType));
        if(operation.getEType() == null) {
        	reportError(NLS.bind(JavaBlackboxMessages.UnresolvedOclTypeForJavaType, method.getReturnType(), method), method);
        }
        
        int i = 0;
        final QvtOperationalModuleEnv environment = fTypeResolver.getEnvironment();
		for (Type paramType : paramTypes) {
            VarParameter varParam = (operKind != Kind.OPERATION) ? 
            		ExpressionsFactory.eINSTANCE.createVarParameter() : null;
            EParameter eParameter = varParam != null ? varParam : EcoreFactory.eINSTANCE.createEParameter();
            
            if(varParam != null) {
            	varParam.setKind(DirectionKind.IN);
            }
            
            eParameter.setEType(fTypeResolver.toEClassifier(paramType));
            if(eParameter.getEType() == null) {
            	reportError(NLS.bind(JavaBlackboxMessages.UnresolvedOclTypeForJavaType, paramType, method), method);
            }
                      
            Parameter paramAnno = getParameterAnnotation(annotations[i]);
            String paramName;            
            if(paramAnno != null && paramAnno.name() != null) {
                paramName = paramAnno.name();            	
            } else {
            	paramName = "arg" + i; //$NON-NLS-1$;            	
            }
            
            eParameter.setName(paramName);
                    	
			if(isContextual && i == 0) {
        		if(operKind != Kind.OPERATION) {
        			assert operation instanceof ImperativeOperation;
        			assert varParam != null;
        			varParam.setName(Environment.SELF_VARIABLE_NAME);
        			((ImperativeOperation)operation).setContext(varParam);
        		}
        		
    			contextType = eParameter.getEType();        		
        	} else {
        		operation.getEParameters().add(eParameter);        		
        	}
        	
            i++;
        } // iterate parameters
        		
		if(operation instanceof ImperativeOperation) {
			ImperativeOperation imperativeOperation = (ImperativeOperation) operation;
			environment.defineImperativeOperation(imperativeOperation, false, true);
		} else if(contextType != null) {
			environment.getTypeResolver().resolveAdditionalOperation(contextType, operation);			
		}

		if(isContextual && !Modifier.isStatic(method.getModifiers())) {
			// FIXME - support non-static contextual operations, useful to access the library shared
			// state, but currently the instance of the module associated with the 'self' contextual
			// instance is not easy to retrieve =>
			// For now, we pass null as the source object, and 'self' as the first argument
			reportError(NLS.bind("Contextual operation must be defined ''static'', method=''{0}''", method), method);
		}
		
        return operation;
    }	
    
    private static Parameter getParameterAnnotation(Annotation[] allAnnotations) {
    	for (Annotation annotation : allAnnotations) {
			if(annotation.annotationType() == Parameter.class) {
				return (Parameter)annotation;
			}
		}
    	
    	return null;
    }
    
    private void resetErrors() {
    	fProblems = null;
    }
    
    private void reportError(String message, Method problemMethod) {
    	if(fProblems == null) {
    		fProblems = DiagnosticUtil.createRootDiagnostic(NLS.bind(JavaBlackboxMessages.LoadOperationDiagnostics, problemMethod));
    	}
    	
    	fProblems.add(DiagnosticUtil.createErrorDiagnostic(message));
    }
}
