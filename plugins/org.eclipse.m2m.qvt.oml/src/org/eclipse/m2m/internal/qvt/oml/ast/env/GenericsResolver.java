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
package org.eclipse.m2m.internal.qvt.oml.ast.env;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.DictionaryType;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.types.util.TypesSwitch;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.TypedElement;


class GenericsResolver {

	final private QVTOEnvironment fEnv;
	final private OCLStandardLibrary<EClassifier> fOCLStdLib;
	final private BindSwitch fBindSwitch;	
	final private Map<EClassifier, EClassifier> formal2ActualBinding = new HashMap<EClassifier, EClassifier>(3);

	GenericsResolver(QVTOEnvironment env) {
		if(env == null) {
			throw new IllegalArgumentException();
		}
		
		this.fEnv = env;
		this.fOCLStdLib = env.getOCLStandardLibrary();
		this.fBindSwitch = new BindSwitch();
	}
		
	public boolean resolveGenericType(EClassifier owner, EClassifier formalType, EClassifier actualType) {
		resolve(formalType, actualType);
		EClassifier resolvedType = fBindSwitch.doSwitch(formalType);
		return TypeUtil.compatibleTypeMatch(fEnv, actualType, resolvedType);
	}
	
	
	public EClassifier resolveOperationReturnType(EClassifier source, EOperation operation, List<? extends TypedElement<EClassifier>> args) {
		EClassifier owner = fEnv.getUMLReflection().getOwningClassifier(operation);		
		resolve(owner, source);
		
		int paramIndex = 0;
		for (EParameter eParameter : operation.getEParameters()) {
			EClassifier paramFormalType = eParameter.getEType();
			if(paramFormalType != null) {
				EClassifier actualArgType = args.get(paramIndex++).getType();
				resolve(paramFormalType, actualArgType);
			}
		}

		EClassifier returnType = operation.getEType();
		if(formal2ActualBinding.isEmpty()) {
			return returnType; 
		}
		
		if(returnType != null) {
			returnType = fBindSwitch.doSwitch(returnType);
			formal2ActualBinding.clear();
		}
		
		return returnType;
	}
		
	@SuppressWarnings("unchecked")
	private void resolve(EClassifier formalType, EClassifier actualType) {
		if(formalType == null || actualType == null) {
			return;
		}
			
		if(formalType instanceof CollectionType && actualType instanceof CollectionType) {
			resolveCollection((CollectionType) formalType, (CollectionType) actualType);
		} else if(formalType instanceof TypeType && actualType instanceof TypeType) {
			TypeType<EClassifier, EOperation> actualTypeType = (TypeType<EClassifier, EOperation>) actualType;			
			if(formalType == fEnv.getOCLStandardLibrary().getOclType()) {
				resolve(fOCLStdLib.getT(), actualTypeType.getReferredType());
			}
		} else {
			if(isGeneric(formalType)) {
				bind(formalType, actualType);
			}			
		}
	}
	
	void resolveCollection(CollectionType formal, CollectionType actual) {
		EClassifier formalElementType = formal.getElementType();
		EClassifier actualElementType = actual.getElementType();
		
		resolve(formalElementType, actualElementType);
		
		if(formal instanceof DictionaryType && actual instanceof DictionaryType) {
			DictionaryType formalDict = (DictionaryType) formal;
			DictionaryType actualDict = (DictionaryType) actual;
			resolve(formalDict.getKeyType(), actualDict.getKeyType());
		}
	}
	
	private boolean isGeneric(EClassifier type) {
		return type == fOCLStdLib.getT() || type == fOCLStdLib.getT2() || 
				type == fEnv.getQVTStandardLibrary().getKeyT();
	}
	
	void bind(EClassifier generic, EClassifier actualBound) {
		formal2ActualBinding.put(generic, actualBound);
	}
	
	private class BindSwitch extends TypesSwitch<EClassifier> {
		private QVTOTypeResolver typeResolver = fEnv.getTypeResolver();
		
		private EClassifier getBoundType(EClassifier type) {
			EClassifier bound = formal2ActualBinding.get(type);
			return (bound != null) ? bound : type;
		}
		
		@Override
		public <C, O> EClassifier caseCollectionType(org.eclipse.ocl.types.CollectionType<C, O> object) {			
			EClassifier boundElementType = typeResolver.resolve(getBoundType((EClassifier) object.getElementType()));
			if(object.eClass() == ImperativeOCLPackage.eINSTANCE.getListType()) {
				return (EClassifier) typeResolver.resolveListType(boundElementType);
			} else if(object.eClass() == ImperativeOCLPackage.eINSTANCE.getDictionaryType()) {
				DictionaryType dictionaryType = (DictionaryType) object;
				EClassifier boundKeyType = getBoundType(dictionaryType.getKeyType());
				QvtTypeResolverImpl qvtTypeResolve = (QvtTypeResolverImpl) typeResolver;
				qvtTypeResolve.resolveDictionaryType(boundKeyType, boundElementType);
			}
			
			return (EClassifier) typeResolver.resolveCollectionType(object.getKind(), boundElementType);
		}
		
		@Override
		public <O, P> EClassifier caseTupleType(TupleType<O, P> object) {			
			return (EClassifier) object;
		}
		
		@Override
		public <C, O> EClassifier caseTypeType(TypeType<C, O> object) {
			EClassifier referredType = getBoundType((EClassifier) object.getReferredType());
			if(referredType == null && fOCLStdLib.getOclType() == object) {
				referredType = getBoundType(fOCLStdLib.getT());
			}
			return (EClassifier) typeResolver.resolveTypeType(typeResolver.resolve(referredType));
		}
				
		@Override
        public EClassifier defaultCase(EObject object) {
			return getBoundType((EClassifier) object);
		}		
	}	
}
