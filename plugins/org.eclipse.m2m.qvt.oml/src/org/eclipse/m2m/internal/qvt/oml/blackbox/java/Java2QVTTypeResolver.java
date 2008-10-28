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

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.util.Bag;
import org.eclipse.ocl.utilities.OCLFactory;

class Java2QVTTypeResolver {

	private QvtOperationalModuleEnv fEnv;
	private List<EPackage> fPackages;	
	
	Java2QVTTypeResolver(QvtOperationalModuleEnv env, List<EPackage> packages) {	
		fEnv = env;
		fPackages = packages;
	}
	
	QvtOperationalModuleEnv getEnvironment() {
		return fEnv;
	}
	
	EClassifier toEClassifier(Type type) {
		EClassifier result = type2EClassifier(type);
		return fEnv.getTypeResolver().resolve(result);
	}
	
	private EClassifier type2EClassifier(Type type) {
		if(type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) type;
			return (EClassifier)handleParameterizedType(parameterizedType);			
		} 
		else if(type instanceof Class) {
			return handleType((Class<?>)type);
		}
		
		return null;
	}
	
	private CollectionType<EClassifier, EOperation> handleParameterizedType(ParameterizedType parameterizedType) {
		OCLFactory oclFactory = fEnv.getOCLFactory();		
		Type rawType = parameterizedType.getRawType();
		Type actualType = parameterizedType.getActualTypeArguments()[0];
		
		if(rawType == Set.class) {
			return oclFactory.createSetType(toEClassifier(actualType));
		}
		else if(rawType == LinkedHashSet.class) {
			return oclFactory.createOrderedSetType(toEClassifier(actualType));			
		}
		else if(rawType == Bag.class) {
			return oclFactory.createBagType(toEClassifier(actualType));
		}
		else if(rawType == ArrayList.class) {
			return oclFactory.createSequenceType(toEClassifier(actualType));			
		}
		else if(rawType == List.class) {
			return oclFactory.createSequenceType(toEClassifier(actualType));			
		}		
		else if(rawType == Collection.class) {
			return oclFactory.createCollectionType(toEClassifier(actualType));
		}
		
		return null;
	}
	
	private EClassifier handleType(Class<?> type) {
		OCLStandardLibrary<EClassifier> stdLibrary = fEnv.getOCLStandardLibrary();
		
		if(type == Object.class) {
			return stdLibrary.getOclAny();
		} 
		else if(type == String.class) {
			return stdLibrary.getString();
		} 
		else if(type == Boolean.class) {
			return stdLibrary.getBoolean();
		} 
		else if(type == Integer.class) {
			return stdLibrary.getInteger();
		} 
		else if(type == Double.class) {
			return stdLibrary.getReal();
		}
		else if(type == void.class) {
			return stdLibrary.getOclVoid();
		}		
		
		return lookupByInstanceClass(type);
	}
	
	private EClassifier lookupByInstanceClass(Class<?> type) {
		assert type != null;
		
		for (EPackage ePackage : fPackages) {
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				if(type == eClassifier.getInstanceClass()) {
					return eClassifier;
				}
			}
		}
		
		return null;
	}	
}
