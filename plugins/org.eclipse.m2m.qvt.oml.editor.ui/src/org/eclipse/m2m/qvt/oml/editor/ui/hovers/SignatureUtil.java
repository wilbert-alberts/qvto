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
package org.eclipse.m2m.qvt.oml.editor.ui.hovers;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.utilities.PredefinedType;

public class SignatureUtil {

	private SignatureUtil() {
		super();
	}
		
	
	public static String getOperationSignature(EcoreEnvironment env, EOperation operation) {
		StringBuilder result = new StringBuilder();
		
		EClassifier owner = env.getUMLReflection().getOwningClassifier(operation);
		if(owner != null) {
			result.append(env.getUMLReflection().getQualifiedName(owner));
			result.append("::"); //$NON-NLS-1$
		}
		
		result.append(env.getUMLReflection().getName(operation));
		result.append('(');
		
		for (Iterator<EParameter> iter = env.getUMLReflection().getParameters(operation).iterator(); iter.hasNext();) {
			EParameter next = iter.next();
			
			if (env.getUMLReflection().getOCLType(next) != null) {
				result.append(getTypedElementSignature(env, next));
			}
			
			if (iter.hasNext()) {
				result.append(", "); //$NON-NLS-1$
			}
		}
		
		EClassifier returnType = env.getUMLReflection().getOCLType(operation); 
		if (returnType == null) {
			result.append(')');
		} else {
			result.append(") : "); //$NON-NLS-1$
			result.append(env.getUMLReflection().getQualifiedName(returnType));
		}
		
		return result.toString();
	}	
	
	public static String getTypedElementSignature(EcoreEnvironment env, ETypedElement typedElement) {
		StringBuilder result = new StringBuilder();
		
		result.append(env.getUMLReflection().getName(typedElement));
		result.append(" : "); //$NON-NLS-1$
		
		EClassifier eType = env.getUMLReflection().getOCLType(typedElement);
		if(eType != null) {
			if(isStdLibType(env, eType)) {
				result.append(env.getUMLReflection().getName(eType));
			} else {
				result.append(env.getUMLReflection().getQualifiedName(eType));
			}
		}
		
		return result.toString();
	}	
	
	public static String getVariableSignature(EcoreEnvironment env, Variable<EClassifier, EParameter> typedElement) {
		StringBuilder result = new StringBuilder();
		
		result.append(typedElement.getName());
		result.append(" : "); //$NON-NLS-1$
		
		EClassifier eType = env.getUMLReflection().getOCLType(typedElement.getType());
		if(eType != null) {
			if(isStdLibType(env, eType)) {
				result.append(env.getUMLReflection().getName(eType));
			} else {
				result.append(env.getUMLReflection().getQualifiedName(eType));
			}
		}
		
		return result.toString();
	}
	
	public static boolean isStdLibType(EcoreEnvironment env, EClassifier type) {
		return type instanceof PredefinedType;
	}
}
