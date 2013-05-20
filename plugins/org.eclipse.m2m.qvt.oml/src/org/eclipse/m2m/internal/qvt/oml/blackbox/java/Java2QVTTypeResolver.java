/*******************************************************************************
 * Copyright (c) 2008, 2009 Borland Software Corporation and others.
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
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalStdLibrary;
import org.eclipse.m2m.qvt.oml.util.Dictionary;
import org.eclipse.m2m.qvt.oml.util.MutableList;
import org.eclipse.ocl.TypeResolver;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.util.Bag;

class Java2QVTTypeResolver {

	private QvtOperationalModuleEnv fEnv;
	private List<EPackage> fPackages;
	// used to delegate the OCL type determination to MDOT OCL UMLReflection 
	private EClassifier fHelperEClassiferAdapter;
	
	Java2QVTTypeResolver(QvtOperationalModuleEnv env, List<EPackage> packages) {	
		fEnv = env;
		fPackages = packages;
	}
	
	QvtOperationalModuleEnv getEnvironment() {
		return fEnv;
	}
	
	EClassifier toEClassifier(Type type) {
		EClassifier result = type2EClassifier(type);
		if(result == null) {
			if(type instanceof Class<?>) {
				EClassifier eWrapper = asEClassifier((Class<?>) type);
				EClassifier asOCLType = fEnv.getUMLReflection().asOCLType(eWrapper);
				if(asOCLType != eWrapper) {
					return asOCLType;
				}
			}
		} else {
			return fEnv.getUMLReflection().asOCLType(result);
		}
		
		return result;
	}
	
	private EClassifier type2EClassifier(Type type) {
		if(type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) type;
			return (EClassifier)handleParameterizedType(parameterizedType);			
		} 
		else if(type instanceof Class<?>) {
			return handleType((Class<?>)type);
		} else if(type instanceof TypeVariable<?>) {
			TypeVariable<?> typeVariable = (TypeVariable<?>) type;
			OCLStandardLibrary<EClassifier> stdLib = fEnv.getOCLStandardLibrary();
			if(stdLib.getT().getName().equals(typeVariable.getName())) {
				return getEnvironment().getOCLStandardLibrary().getT();
				//return paramType;
			} else if(stdLib.getT2().getName().equals(typeVariable.getName())) {
				return getEnvironment().getOCLStandardLibrary().getT();			
			} else if(QvtOperationalStdLibrary.INSTANCE.getKeyT().getName().equals(typeVariable.getName())) {
				return QvtOperationalStdLibrary.INSTANCE.getKeyT();
			}
		}
		
		return null;
	}
	
	private CollectionType<EClassifier, EOperation> handleParameterizedType(ParameterizedType parameterizedType) {	
		Type rawType = parameterizedType.getRawType();
		Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
		
		if(actualTypeArguments.length == 0) {
			return null;
		}

		Type actualElementType = actualTypeArguments[0];
		if(rawType instanceof Class<?> == false) {
			return null;
		}
		
		Type actualElementType2 = actualTypeArguments.length > 1 ? actualTypeArguments[1] : null;
		Class<?> rawClass = (Class<?>) rawType;
		if(rawClass == Dictionary.class) {
			EClassifier keyType = toEClassifier(actualElementType);
			if(keyType != null && actualElementType2 != null) {
				EClassifier elementType = toEClassifier(actualElementType2);
				if(elementType != null) {
					return fEnv.getTypeResolver().resolveDictionaryType(keyType, elementType);
				}
			}
		} else if(rawClass == MutableList.class) {
			EClassifier listElementType = toEClassifier(actualElementType);
			if(listElementType != null) {
				return fEnv.getTypeResolver().resolveListType(listElementType);
			}
		} else if(rawClass == LinkedHashSet.class) {
			return resolveCollectionType(CollectionKind.ORDERED_SET_LITERAL, actualElementType);			
		}
		else if(Set.class.isAssignableFrom(rawClass)) {
			return resolveCollectionType(CollectionKind.SET_LITERAL, actualElementType);			
		}		
		else if(rawClass == Bag.class) {
			return resolveCollectionType(CollectionKind.BAG_LITERAL, actualElementType);
		}
		else if(List.class.isAssignableFrom(rawClass)) {
			return resolveCollectionType(CollectionKind.SEQUENCE_LITERAL, actualElementType);
		}
		else if(rawType == List.class) {
			return resolveCollectionType(CollectionKind.SEQUENCE_LITERAL, actualElementType);			
		}
		else if(rawType == Collection.class) {			
			return resolveCollectionType(CollectionKind.COLLECTION_LITERAL, actualElementType);
		}
		
		return null;
	}
	
	
	private CollectionType<EClassifier, EOperation> resolveCollectionType(CollectionKind kind, Type elementType) {
		TypeResolver<EClassifier, EOperation, EStructuralFeature> typeResolver = fEnv.getTypeResolver();

		EClassifier actualElementClassifier = null;
		
		if(elementType instanceof TypeVariable<?>) {			
			TypeVariable<?> typeVariable = (TypeVariable<?>)elementType;
			String genericJavaTypeName = typeVariable.getName();
			
			OCLStandardLibrary<EClassifier> oclStdLibrary = fEnv.getOCLStandardLibrary();
			EClassifier typeT = oclStdLibrary.getT();
			if(typeT.getName().equals(genericJavaTypeName)) {
				actualElementClassifier = typeT;
			} else {
				EClassifier typeT2 = oclStdLibrary.getT2();
				if(typeT2.getName().equals(genericJavaTypeName)) {
					actualElementClassifier = typeT2;
				}
			}
		} 
		else if(elementType != null) {
			actualElementClassifier = toEClassifier(elementType);
		}
		
		if(actualElementClassifier != null) {
			return typeResolver.resolveCollectionType(kind, actualElementClassifier);
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
		else if(type == Boolean.class || type == boolean.class) {
			return stdLibrary.getBoolean();
		} 
		else if(type == Integer.class || type == int.class) {
			return stdLibrary.getInteger();
		} 
		else if(type == Double.class || type == double.class) {
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
	
	private EClassifier asEClassifier(Class<?> javaClass) { 		
		if(fHelperEClassiferAdapter == null) {
			EPackage ownerPackage = EcoreFactory.eINSTANCE.createEPackage();
			ownerPackage.setName("helper"); //$NON-NLS-1$
			ownerPackage.setNsURI(javaClass.getName());
			fHelperEClassiferAdapter = EcoreFactory.eINSTANCE.createEDataType();			
			ownerPackage.getEClassifiers().add(fHelperEClassiferAdapter);
		}
		
		fHelperEClassiferAdapter.setName(javaClass.getSimpleName());
		fHelperEClassiferAdapter.setInstanceClass(javaClass);
		
		return fHelperEClassiferAdapter;		
	}
}
