/*******************************************************************************
 * Copyright (c) 2008, 2010 Borland Software Corporation and others.
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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.internal.qvt.oml.NLS;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance;
import org.eclipse.m2m.internal.qvt.oml.evaluator.NumberConversions;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandler;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandlerAdapter;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.ocl.types.OCLStandardLibrary;

class JavaMethodHandlerFactory {
	
	private static int FAILURE_COUNT_TOLERANCE = 5;
	
	final private Object fInvalid;
	
	JavaMethodHandlerFactory(OCLStandardLibrary<EClassifier> oclStdLib) {
		fInvalid = oclStdLib.getInvalid();
	}
	
	CallHandler createHandler(Method method) {
		if(method == null) {
			throw new IllegalArgumentException();
		}
		
		Operation opAnnotation = method.getAnnotation(Operation.class);		
		return new Handler(method, opAnnotation != null && opAnnotation.contextual(),
				opAnnotation != null && opAnnotation.withExecutionContext());
	}
	
	private Object getInvalidResult() {
		return fInvalid;
	}
		
	private class Handler implements CallHandler {
				
		private Method fMethod;
		private Class<?>[] fCachedParamTypes;
		private Object[] fArgs;
		private boolean fIsContextual;
		private final boolean fWithExecutionContext;
		private boolean fRequiresNumConversion;
		private int fFatalErrorCount;		
		
		Handler(Method method, boolean isContextual, boolean isWithExecutionContext) {
			assert method != null;
			
			fMethod = method;
			fCachedParamTypes = fMethod.getParameterTypes(); 			
			fIsContextual = isContextual;
			fWithExecutionContext = isWithExecutionContext;
			fRequiresNumConversion = requiresNumberConversion(); 
			fFatalErrorCount = 0;
		}		

		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			try {
				if(isDisabled()) {
					return getInvalidResult();
				}
							
				Object[] actualArgs = prepareArguments(source, args, evalEnv);
				Object javaCallSource = null;
				
				boolean isStatic = Modifier.isStatic(fMethod.getModifiers());
				if(!isStatic) {
					Class<?> moduleJavaClass = fMethod.getDeclaringClass();					
					javaCallSource = module.getAdapter(moduleJavaClass);
					assert javaCallSource != null;
				}
								
				return fMethod.invoke(javaCallSource, actualArgs);
			}
			catch (IllegalArgumentException e) {
				fFatalErrorCount++;
				QvtPlugin.error(NLS.bind(JavaBlackboxMessages.MethodInvocationError, fMethod), e);
				return CallHandlerAdapter.getInvalidResult(evalEnv);			
			} 
			catch (IllegalAccessException e) {
				fFatalErrorCount++;				
				QvtPlugin.error(NLS.bind(JavaBlackboxMessages.MethodInvocationError, fMethod), e);				
				return CallHandlerAdapter.getInvalidResult(evalEnv);
			} 
			catch (InvocationTargetException e) {
				fFatalErrorCount++;
				QvtPlugin.error(NLS.bind(JavaBlackboxMessages.MethodInvocationError, fMethod), e);				
				// should not happen at all, as we do not support QVT exception in signature yet
				return CallHandlerAdapter.getInvalidResult(evalEnv);
			} finally {
				clearArguments();
			}
		}
		
		boolean isDisabled() {
			return fFatalErrorCount > FAILURE_COUNT_TOLERANCE;
		}
		
		private Object[] prepareArguments(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			int argCount = args.length;
			if (fIsContextual) {
				argCount++;
			}
			if (fWithExecutionContext) {
				argCount++;
			}

			if(fArgs == null) {
				fArgs = new Object[argCount];
			}
			
			int argIndex = 0;
			if (fWithExecutionContext) {
				fArgs[argIndex] = evalEnv.getContext();
				argIndex++;
			}
			if (fIsContextual) {
				fArgs[argIndex] = source;
				argIndex++;
			}
			
			// filter out possible OclInvalid argument values passed from AST based evaluation
			// source can't be this case as the call can not be made
			for (int i = 0; i < args.length; i++) {
				Object nextArg = args[i];
				if(nextArg == getInvalidResult()) {
					// convert OclInvalid to 'null' as java reflection invocation would fail
					// with the argument class incompatible to the method signature
					nextArg = null;
				}
				// number have to converted as java binary compatible
				if(fRequiresNumConversion) {
					nextArg = NumberConversions.convertNumber(nextArg, fCachedParamTypes[argIndex]);
				}
				fArgs[argIndex++] = nextArg;
			}
			
			return (fArgs != null) ? fArgs : args;
		}
		
		private void clearArguments() {
			if(fArgs != null) {
				Arrays.fill(fArgs, null);
			}
		}
		
		private boolean requiresNumberConversion() {
			assert fMethod != null;
			
			for (Class<?> paramType : fMethod.getParameterTypes()) {
				if(Number.class.isAssignableFrom(paramType)) {
					return true;
				}
			}
			return false;
		}		
	}	
}
