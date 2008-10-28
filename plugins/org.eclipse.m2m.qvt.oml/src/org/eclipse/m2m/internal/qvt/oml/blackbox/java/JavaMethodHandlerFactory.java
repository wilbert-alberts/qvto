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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandler;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandlerAdapter;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.osgi.util.NLS;

class JavaMethodHandlerFactory {
	
	private static int FAILURE_COUNT_TOLERANCE = 5;
	
	final private Object fOclInvalid;
	
	JavaMethodHandlerFactory(OCLStandardLibrary<EClassifier> oclStdLib) {
		fOclInvalid = oclStdLib.getOclInvalid();
	}
	
	CallHandler createHandler(Method method) {
		if(method == null) {
			throw new IllegalArgumentException();
		}
		
		return new Handler(method);
	}
	
	private Object getInvalidResult() {
		return fOclInvalid;
	}
	
	private class Handler implements CallHandler {
				
		private int fFatalErrorCount;
		private Method fMethod;
		private Object[] fArgs;
		private boolean fIsContextual;
		
		Handler(Method method) {
			assert method != null;
			
			fMethod = method;
			fIsContextual = Modifier.isStatic(method.getModifiers());
			fFatalErrorCount = 0;
		}		

		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			try {
				if(isDisabled()) {
					return getInvalidResult();
				}
							
				Object[] actualArgs = prepareArguments(source, args, evalEnv);
				Object actualSource;
				if(actualArgs.length == args.length) {
					actualSource = source; 
				} else {
					// a static call with actual source moved to arguments				
					actualSource = null;
				}
				
				return fMethod.invoke(actualSource, actualArgs);
			}
			catch (IllegalArgumentException e) {
				fFatalErrorCount++;
				QvtPlugin.logError(NLS.bind(JavaBlackboxMessages.MethodInvocationError, fMethod), e);
				return CallHandlerAdapter.getInvalidResult(evalEnv);			
			} 
			catch (IllegalAccessException e) {
				fFatalErrorCount++;				
				QvtPlugin.logError(NLS.bind(JavaBlackboxMessages.MethodInvocationError, fMethod), e);				
				return CallHandlerAdapter.getInvalidResult(evalEnv);
			} 
			catch (InvocationTargetException e) {
				fFatalErrorCount++;
				QvtPlugin.logError(NLS.bind(JavaBlackboxMessages.MethodInvocationError, fMethod), e);				
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
			if(fIsContextual) {
				if(fArgs == null) {
					fArgs = new Object[args.length + 1];
				}
				
				fArgs[0] = source;
			} else {			
				if(fArgs == null) {
					fArgs = new Object[args.length];
				}
			}

			// filter out possible OclInvalid argument values passed from AST based evaluation
			// source can't be this case as the call can not be made
			int destPos = fIsContextual ? 1 : 0;
			for (int i = 0; i < args.length; i++) {
				Object nextArg = args[i];
				if(nextArg == getInvalidResult()) {
					// convert OclInvalid to 'null' as java reflection invocation would fail
					// with the argument class incompatible to the method signature
					nextArg = null;
				}
				fArgs[destPos++] = nextArg;
			}
			
			return (fArgs != null) ? fArgs : args;
		}
		
		private void clearArguments() {
			if(fArgs != null) {
				Arrays.fill(fArgs, null);
			}
		}	
	}	
}
