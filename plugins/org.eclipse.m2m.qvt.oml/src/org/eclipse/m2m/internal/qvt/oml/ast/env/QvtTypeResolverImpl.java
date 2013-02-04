/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - bugs 302594, 310991
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.ast.env;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.HiddenElementAdapter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Library;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.DictionaryType;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ListType;
import org.eclipse.ocl.TypeResolver;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.MessageType;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;
/**
 * QVT implementation of the {@link TypeResolver} interface.<p>
 * This type of resolver takes into account element resolutions with sibling environments to 
 * this owning environment. (sibling fEnv, stands for imported one)
 */
public class QvtTypeResolverImpl implements QVTOTypeResolver {

	private BasicTypeResolverImpl fDelegate;
	private QvtEnvironmentBase fOwner;
    private boolean fdefinesOclAnyFeatures;
    private Map<EClassifier, List<ImperativeOperation>> fCtx2OperationMap; 
    	
    private Set<EClassifier> fAdditionalTypes;
    private Resource fResource;
	
    QvtTypeResolverImpl(QvtEnvironmentBase owningEnv, Resource resource) {
		if(owningEnv == null) {
			throw new IllegalArgumentException();
		}

		fOwner = owningEnv;
		fdefinesOclAnyFeatures = false;
		fResource = resource;
	}

	protected BasicTypeResolverImpl getDelegate() {
		if(fDelegate == null) {
			fDelegate = createDelegate();
		}
		return fDelegate;
	}
	
	protected BasicTypeResolverImpl createDelegate() {
		return new BasicTypeResolverImpl(getOwner(), fResource);
	}
	
	QvtEnvironmentBase getOwner() {
		return fOwner;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.m2m.internal.qvt.oml.ast.env.QVTOTypeResolver#resolveListType(org.eclipse.emf.ecore.EClassifier)
	 */
	public ListType resolveListType(EClassifier elementType) {
		return getDelegate().resolveListType(elementType);
	}
	
	public DictionaryType resolveDictionaryType(EClassifier keyType, EClassifier elementType) {
		return getDelegate().resolveDictionaryType(keyType, elementType);
	}	
	
	public void collectAdditionalOperationsInTypeHierarchy(EClassifier type, boolean subTypesOnly, Collection<EOperation> result) {
		if(fAdditionalTypes != null) {
			for (EClassifier nextType : fAdditionalTypes) {					
				boolean isPartOfHierarchy = TypeUtil.getRelationship(fOwner, type, nextType) == UMLReflection.STRICT_SUPERTYPE;					  
				if(type != nextType && isPartOfHierarchy) {
					getLocalAdditionalOperations(nextType, result);
				}				
			}
		}
		// continue in imported environments
		for (QvtEnvironmentBase nextImportEnv : fOwner.getImportsByExtends()) {
			nextImportEnv.getQVTTypeResolver().collectAdditionalOperationsInTypeHierarchy(type, subTypesOnly, result);
		}
		
		for (QvtEnvironmentBase nextImportEnv : fOwner.getImportsByAccess()) {
			// FIXME - continue only one level in case of access imports
			nextImportEnv.getQVTTypeResolver().collectAdditionalOperationsInTypeHierarchy(type, subTypesOnly, result);
		}
	}
	
	public List<EStructuralFeature> getAdditionalAttributes(EClassifier owner) {
		List<EStructuralFeature> result = new ArrayList<EStructuralFeature>();
		getLocalAdditionalAttributes(owner, result);
		
		// recurse up the extension hierarchy
		for (QvtEnvironmentBase nextSiblingEnv : fOwner.getAllExtendedModules()) {
			nextSiblingEnv.getQVTTypeResolver().getLocalAdditionalAttributes(owner, result);
			result.addAll(nextSiblingEnv.getAdditionalAttributes(owner));
		}
		
		for (QvtEnvironmentBase nextSiblingEnv : fOwner.getImportsByAccess()) {
			Module importedModule = nextSiblingEnv.getModuleContextType();
			if(importedModule instanceof Library) {
				nextSiblingEnv.getQVTTypeResolver().getLocalAdditionalAttributes(owner, result);				
			}
		}				
		
		return result;
	}
	
	protected void getLocalAdditionalAttributes(EClassifier owner, List<EStructuralFeature> result) {
		extractIntermediateProperties(owner, result);
		result.addAll(getDelegate().getAdditionalAttributes(owner));
	}

	public List<EOperation> getAdditionalOperations(EClassifier owner) {
		List<EOperation> result = new ArrayList<EOperation>();
		getLocalAdditionalOperations(owner, result);
		
		for (QvtEnvironmentBase nextSiblingEnv : fOwner.getAllExtendedModules()) {
			nextSiblingEnv.getQVTTypeResolver().getLocalAdditionalOperations(owner, result);
		}
		
		for (QvtEnvironmentBase nextSiblingEnv : fOwner.getImportsByAccess()) {
			Module importedModule = nextSiblingEnv.getModuleContextType();
			if(importedModule instanceof Library) {
				nextSiblingEnv.getQVTTypeResolver().getLocalAdditionalOperations(owner, result);				
			}
		}		
		
		return result;
	}
	
	private void extractContextualOperations(EClassifier context, Collection<EOperation> result) {
		if(fCtx2OperationMap == null) {
			return;
		}
		List<ImperativeOperation> operList = fCtx2OperationMap.get(context);
		if(operList != null) {
			result.addAll(operList);
			return;
		}
		for (EClassifier ctx : fCtx2OperationMap.keySet()) {
			if (TypeUtil.exactTypeMatch(fOwner, ctx, context)) {
				operList = fCtx2OperationMap.get(ctx);
				if(operList != null) {
					result.addAll(operList);
					return;
				}
			}
		}
	}

	private void extractIntermediateProperties(EClassifier context, Collection<EStructuralFeature> result) {
		if(context instanceof EClass) {
			Module moduleType = fOwner.getModuleContextType();
			if(moduleType == null) {
				return;
			}
			for(EStructuralFeature property : moduleType.getEStructuralFeatures()) {				
				if(property instanceof ContextualProperty) {
					if(HiddenElementAdapter.isMarkedAsHidden(property)) {
						continue;
					}
					
					ContextualProperty ctxProperty = (ContextualProperty) property;
					EClass nextContext = ctxProperty.getContext();
					if(nextContext != null && nextContext == context) {
						result.add(ctxProperty);
					}
				}
			}
		}
	}
		
	protected void getLocalAdditionalOperations(EClassifier owner, Collection<EOperation> result) {
		extractContextualOperations(owner, result);
		final boolean isCollectionTypeOwner = owner instanceof CollectionType<?,?>;
		
		if(fdefinesOclAnyFeatures && (isCollectionTypeOwner == false) && (owner instanceof TupleType<?, ?> == false)) {
			extractContextualOperations(fOwner.getOCLStandardLibrary().getOclAny(), result);
		}
		
		result.addAll(getDelegate().getAdditionalOperations(owner));
		if(fdefinesOclAnyFeatures && (isCollectionTypeOwner == false) && (owner instanceof TupleType<?, ?> == false)) {
			result.addAll(getDelegate().getAdditionalOperations(fOwner.getOCLStandardLibrary().getOclAny()));
		}
		
		if(owner == fOwner.getOCLStandardLibrary().getInteger()) {
			EClassifier oclReal = fOwner.getOCLStandardLibrary().getReal();
			this.getLocalAdditionalOperations(oclReal, result);
		} else if(isCollectionTypeOwner) {
			getLocalCollectionAdditionalOperations((org.eclipse.ocl.ecore.CollectionType)owner, result, false);
		}		
	}	

	public Resource getResource() {
		if(fResource != null) {
			return fResource;
		}
		return getDelegate().getResource();
	}

	public EClassifier resolve(EClassifier type) {
		return getDelegate().resolve(type);
	}

	public EStructuralFeature resolveAdditionalAttribute(EClassifier owner, EStructuralFeature property) {
		return getDelegate().resolveAdditionalAttribute(owner, property);
	}

	public EOperation resolveAdditionalOperation(EClassifier owner, EOperation operation) {
		if(!fdefinesOclAnyFeatures && owner == fOwner.getOCLStandardLibrary().getOclAny()) {
			// operations defined on OclAny;
			fdefinesOclAnyFeatures = true;
		}
		
		if(operation instanceof ImperativeOperation) {
			if(fCtx2OperationMap == null) {
				fCtx2OperationMap = new LinkedHashMap<EClassifier, List<ImperativeOperation>>();
			}
			List<ImperativeOperation> operList = fCtx2OperationMap.get(owner);
			if(operList == null) {
				operList = new ArrayList<ImperativeOperation>();
				fCtx2OperationMap.put(owner, operList);
			}
			
			addAdditionalType(owner);
			operList.add((ImperativeOperation)operation);
			return operation;
		}
		
		EOperation resolve = getDelegate().resolveAdditionalOperation(owner, operation);
		if(resolve != null) {
			addAdditionalType(owner);			
		}
		
		return resolve;
	}

	public CollectionType<EClassifier, EOperation> resolveCollectionType(
			CollectionKind kind, EClassifier elementType) {
		return getDelegate().resolveCollectionType(kind, elementType);
	}

	public MessageType<EClassifier, EOperation, EStructuralFeature> resolveOperationMessageType(
			EOperation operation) {
		return getDelegate().resolveOperationMessageType(operation);
	}

	public MessageType<EClassifier, EOperation, EStructuralFeature> resolveSignalMessageType(
			EClassifier signal) {
		return getDelegate().resolveSignalMessageType(signal);
	}

	public TupleType<EOperation, EStructuralFeature> resolveTupleType(
			EList<? extends TypedElement<EClassifier>> parts) {
		return getDelegate().resolveTupleType(parts);
	}

	public TypeType<EClassifier, EOperation> resolveTypeType(EClassifier type) {
		return getDelegate().resolveTypeType(type);
	}
		
	UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> uml() {
		return fOwner.getUMLReflection();
	}
	
	private void addAdditionalType(EClassifier type) {
		if(fAdditionalTypes == null) {
			fAdditionalTypes = new LinkedHashSet<EClassifier>();
		}

		fAdditionalTypes.add(type);
	}
		
	void getLocalCollectionAdditionalOperations(org.eclipse.ocl.ecore.CollectionType collectionType, Collection<EOperation> result, boolean includeSuperTypes) {		
		if(fAdditionalTypes == null) {
			return;
		}
		
		for (EClassifier nextType : fAdditionalTypes) {
			if(nextType instanceof org.eclipse.ocl.ecore.CollectionType) {
				boolean isMatchingType = (includeSuperTypes) ?
						TypeUtil.compatibleTypeMatch(fOwner, collectionType, nextType) :
						TypeUtil.exactTypeMatch(fOwner, collectionType, nextType);
				
				if(isMatchingType) {
					extractContextualOperations(nextType, result);
					result.addAll(fDelegate.getAllCompatibleAdditionalOperations(
							(org.eclipse.ocl.ecore.CollectionType)nextType));
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " : " + fOwner.toString(); //$NON-NLS-1$
	}
}