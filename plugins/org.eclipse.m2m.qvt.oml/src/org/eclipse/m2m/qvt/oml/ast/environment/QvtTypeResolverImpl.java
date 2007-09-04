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
package org.eclipse.m2m.qvt.oml.ast.environment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.TypeResolver;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.MessageType;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * QVT implementation of the {@link TypeResolver} interface.<p>
 * This type of resolver takes into account element resolutions with sibling environments to 
 * this owning environment. (sibling env, stands for imported one)
 */
public class QvtTypeResolverImpl implements TypeResolver<EClassifier, EOperation, EStructuralFeature> {

	private TypeResolver<EClassifier, EOperation, EStructuralFeature> fDelegate;
	private QvtEnvironmentBase fOwner;
    private boolean fdefinesOclAnyFeatures;
    private boolean isClosed;    
    	
		
	QvtTypeResolverImpl(QvtEnvironmentBase owningEnv, TypeResolver<EClassifier, EOperation, EStructuralFeature> delegate) {
		if(delegate == null || owningEnv == null) {
			throw new IllegalArgumentException();
		}

		fOwner = owningEnv;
		fDelegate = delegate;
		fdefinesOclAnyFeatures = false;		
	}
	
	QvtEnvironmentBase getOwner() {
		return fOwner;
	}
	
	public void close() {		
		isClosed = true;
	}
	
	public List<EStructuralFeature> getAdditionalAttributes(EClassifier owner) {
		List<EStructuralFeature> result = new ArrayList<EStructuralFeature>();
		result.addAll(fDelegate.getAdditionalAttributes(owner));
		
		for (QvtEnvironmentBase nextSiblingEnv : fOwner.getSiblings()) {
			nextSiblingEnv.getQVTTypeResolver().getLocalAdditionalAttributes(owner, result);
		}
		
		return result;
	}
	
	protected void getLocalAdditionalAttributes(EClassifier owner, List<EStructuralFeature> result) {
		result.addAll(fDelegate.getAdditionalAttributes(owner));
	}

	public List<EOperation> getAdditionalOperations(EClassifier owner) {
		if(isClosed && owner == fOwner.getModuleContextType()) {
			return Collections.emptyList();
		}
		List<EOperation> result = new ArrayList<EOperation>();
		result.addAll(fDelegate.getAdditionalOperations(owner));
		
		for (QvtEnvironmentBase nextSiblingEnv : fOwner.getSiblings()) {
			nextSiblingEnv.getQVTTypeResolver().getLocalAdditionalOperations(owner, result);
		}
		
		return result;
	}
	
	protected void getLocalAdditionalOperations(EClassifier owner, List<EOperation> result) {		
		result.addAll(fDelegate.getAdditionalOperations(owner));
		if(fdefinesOclAnyFeatures) {
			result.addAll(fDelegate.getAdditionalOperations(fOwner.getOCLStandardLibrary().getOclAny()));
		}
	}	

	public Resource getResource() {
		return fDelegate.getResource();
	}

	public EClassifier resolve(EClassifier type) {
		return fDelegate.resolve(type);
	}

	public EStructuralFeature resolveAdditionalAttribute(EClassifier owner, EStructuralFeature property) {
		return fDelegate.resolveAdditionalAttribute(owner, property);
	}

	public EOperation resolveAdditionalOperation(EClassifier owner, EOperation operation) {		
		EOperation resolve = fDelegate.resolveAdditionalOperation(owner, operation);
		if(resolve != null) {
			if(!fdefinesOclAnyFeatures && owner == fOwner.getOCLStandardLibrary().getOclAny()) {
				// operations defined on OclAny;
				fdefinesOclAnyFeatures = true;
			}
		}
		
		return resolve;
	}

	public CollectionType<EClassifier, EOperation> resolveCollectionType(
			CollectionKind kind, EClassifier elementType) {
		return fDelegate.resolveCollectionType(kind, elementType);
	}

	public MessageType<EClassifier, EOperation, EStructuralFeature> resolveOperationMessageType(
			EOperation operation) {
		return fDelegate.resolveOperationMessageType(operation);
	}

	public MessageType<EClassifier, EOperation, EStructuralFeature> resolveSignalMessageType(
			EClassifier signal) {
		return fDelegate.resolveSignalMessageType(signal);
	}

	public TupleType<EOperation, EStructuralFeature> resolveTupleType(
			EList<? extends TypedElement<EClassifier>> parts) {
		return fDelegate.resolveTupleType(parts);
	}

	public TypeType<EClassifier, EOperation> resolveTypeType(EClassifier type) {
		return fDelegate.resolveTypeType(type);
	}
		
	private UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> uml() {
		return fOwner.getUMLReflection();
	}
}
