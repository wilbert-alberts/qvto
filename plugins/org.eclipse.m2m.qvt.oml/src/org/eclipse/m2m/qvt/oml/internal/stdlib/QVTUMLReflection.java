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
package org.eclipse.m2m.qvt.oml.internal.stdlib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalStdLibrary;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;

public class QVTUMLReflection 
		implements UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, 
								EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> 
{
	private QvtOperationalStdLibrary fStdLibrary;
	private UMLReflection<EPackage, EClassifier, EOperation, 
					EStructuralFeature, EEnumLiteral, EParameter, EObject, 
					CallOperationAction, SendSignalAction, Constraint> fUmlReflection;
			
	public QVTUMLReflection(UMLReflection<EPackage, EClassifier, EOperation, 
			EStructuralFeature, EEnumLiteral, EParameter, EObject, 
			CallOperationAction, SendSignalAction, Constraint> umlReflection, 
			QvtOperationalStdLibrary stdLibrary) {
		
		if(umlReflection == null || stdLibrary == null) {
			throw new IllegalArgumentException();
		}
		
		fStdLibrary = stdLibrary;
		fUmlReflection = umlReflection;
	}

	public EClassifier getCommonSuperType(EClassifier type1, EClassifier type2) {		
		EClassifier result = fUmlReflection.getCommonSuperType(type1, type2);
		if(result == null) {		
			if(type1 == fStdLibrary.getElementType() && type2 instanceof EClass) {
				return type1;
			} else if(type2 == fStdLibrary.getElementType() && type1 instanceof EClass) {
				return type2;
			}
		}
		return result;
	}
	
	public Collection<? extends EClassifier> getAllSupertypes(EClassifier classifier) {
		Collection<? extends EClassifier> result = fUmlReflection.getAllSupertypes(classifier);
		if(classifier instanceof EClass) {
			// considered to be a model element
			ArrayList<EClassifier> allSuperTupes = new ArrayList<EClassifier>(result.size() + 1);
			allSuperTupes.addAll(result);
			allSuperTupes.add(QvtOperationalStdLibrary.INSTANCE.getElementType());
		}
		return result;
	}
	
	public int getRelationship(EClassifier type1, EClassifier type2) {
		int result = fUmlReflection.getRelationship(type1, type2);
		EClassifier element = fStdLibrary.getElementType();
		if(type1 != type2) {
			if(type1 == element && type2 instanceof EClass) {
				return UMLReflection.STRICT_SUPERTYPE;
			}
			if(type2 == element && type1 instanceof EClass) {
				return UMLReflection.STRICT_SUBTYPE;
			}			
		}
		
		return result; 
	}
	
	public List<EOperation> getOperations(EClassifier classifier) {
		List<EOperation> result = fUmlReflection.getOperations(classifier);
		if(classifier instanceof EClass) {
			QvtOperationalStdLibrary stdlib = QvtOperationalStdLibrary.INSTANCE;
			List<EOperation> elementOpers = stdlib.getOperations(stdlib.getElementType());			
			List<EOperation> tmp = result;
			result = new ArrayList<EOperation>(result.size() + elementOpers.size());
			result.addAll(tmp);
			result.addAll(elementOpers);
		}
		return result;
	}	

	public EClassifier asOCLType(EClassifier modelType) {
		return fUmlReflection.asOCLType(modelType);
	}

	public CallOperationAction createCallOperationAction(EOperation operation) {
		return fUmlReflection.createCallOperationAction(operation);
	}

	public Constraint createConstraint() {
		return fUmlReflection.createConstraint();
	}

	public ExpressionInOCL<EClassifier, EParameter> createExpressionInOCL() {
		return fUmlReflection.createExpressionInOCL();
	}

	public EOperation createOperation(String name, EClassifier resultType, List<String> paramNames, List<EClassifier> paramTypes) {
		return fUmlReflection.createOperation(name, resultType, paramNames, paramTypes);
	}

	public EStructuralFeature createProperty(String name, EClassifier resultType) {
		return fUmlReflection.createProperty(name, resultType);
	}

	public SendSignalAction createSendSignalAction(EClassifier signal) {
		return fUmlReflection.createSendSignalAction(signal);
	}

	public EClassifier getAssociationClass(EStructuralFeature property) {
		return fUmlReflection.getAssociationClass(property);
	}

	public List<EStructuralFeature> getAttributes(EClassifier classifier) {
		return fUmlReflection.getAttributes(classifier);
	}

	public List<EClassifier> getClassifiers(EPackage pkg) {
		return fUmlReflection.getClassifiers(pkg);
	}

	public List<EObject> getConstrainedElements(Constraint constraint) {
		return fUmlReflection.getConstrainedElements(constraint);
	}

	public Constraint getConstraint(ExpressionInOCL<EClassifier, EParameter> specification) {
		return fUmlReflection.getConstraint(specification);
	}

	public String getConstraintName(Constraint constraint) {
		return fUmlReflection.getConstraintName(constraint);
	}

	public String getDescription(Object namedElement) {
		return fUmlReflection.getDescription(namedElement);
	}

	public EClassifier getEnumeration(EEnumLiteral enumerationLiteral) {
		return fUmlReflection.getEnumeration(enumerationLiteral);
	}

	public EEnumLiteral getEnumerationLiteral(EClassifier enumerationType, String literalName) {
		return fUmlReflection.getEnumerationLiteral(enumerationType, literalName);
	}

	public List<EEnumLiteral> getEnumerationLiterals(EClassifier enumerationType) {
		return fUmlReflection.getEnumerationLiterals(enumerationType);
	}

	public List<EStructuralFeature> getMemberEnds(EClassifier associationClass) {
		return fUmlReflection.getMemberEnds(associationClass);
	}

	public String getName(Object namedElement) {
		return fUmlReflection.getName(namedElement);
	}

	public List<EPackage> getNestedPackages(EPackage pkg) {
		return fUmlReflection.getNestedPackages(pkg);
	}

	public EPackage getNestingPackage(EPackage pkg) {
		return fUmlReflection.getNestingPackage(pkg);
	}

	public EClassifier getOCLType(Object metaElement) {
		return fUmlReflection.getOCLType(metaElement);
	}

	public EOperation getOperation(CallOperationAction callOperationAction) {
		return fUmlReflection.getOperation(callOperationAction);
	}

	public EClassifier getOwningClassifier(Object feature) {
		return fUmlReflection.getOwningClassifier(feature);
	}

	public EPackage getPackage(EClassifier classifier) {
		return fUmlReflection.getPackage(classifier);
	}

	public List<EParameter> getParameters(EOperation operation) {
		return fUmlReflection.getParameters(operation);
	}

	public String getQualifiedName(Object namedElement) {
		return fUmlReflection.getQualifiedName(namedElement);
	}

	public List<EStructuralFeature> getQualifiers(EStructuralFeature property) {
		return fUmlReflection.getQualifiers(property);
	}

	public EClassifier getSignal(SendSignalAction sendSignalAction) {
		return fUmlReflection.getSignal(sendSignalAction);
	}

	public List<EClassifier> getSignals(EClassifier owner) {
		return fUmlReflection.getSignals(owner);
	}

	public ExpressionInOCL<EClassifier, EParameter> getSpecification(Constraint constraint) {
		return fUmlReflection.getSpecification(constraint);
	}

	public String getStereotype(Constraint constraint) {
		return fUmlReflection.getStereotype(constraint);
	}

	public Object getStereotypeApplication(Object baseElement, EClassifier stereotype) {
		return fUmlReflection.getStereotypeApplication(baseElement, stereotype);
	}

	public boolean isAssociationClass(EClassifier type) {
		return fUmlReflection.isAssociationClass(type);
	}

	public boolean isClass(Object metaElement) {
		return fUmlReflection.isClass(metaElement);
	}

	public boolean isClassifier(Object metaElement) {
		return fUmlReflection.isClassifier(metaElement);
	}

	public boolean isComparable(EClassifier type) {
		return fUmlReflection.isComparable(type);
	}

	public boolean isDataType(Object metaElement) {
		return fUmlReflection.isDataType(metaElement);
	}

	public boolean isEnumeration(EClassifier type) {
		return fUmlReflection.isEnumeration(type);
	}

	public boolean isMany(Object metaElement) {
		return fUmlReflection.isMany(metaElement);
	}

	public boolean isOperation(Object metaElement) {
		return fUmlReflection.isOperation(metaElement);
	}

	public boolean isProperty(Object metaElement) {
		return fUmlReflection.isProperty(metaElement);
	}

	public boolean isQuery(EOperation operation) {
		return fUmlReflection.isQuery(operation);
	}

	public boolean isStatic(Object feature) {
		return fUmlReflection.isStatic(feature);
	}

	public boolean isStereotype(EClassifier type) {
		return fUmlReflection.isStereotype(type);
	}

	public void setConstraintName(Constraint constraint, String name) {
		fUmlReflection.setConstraintName(constraint, name);
	}

	public void setName(TypedElement<EClassifier> element, String name) {
		fUmlReflection.setName(element, name);
	}

	public void setSpecification(Constraint constraint, ExpressionInOCL<EClassifier, EParameter> specification) {
		fUmlReflection.setSpecification(constraint, specification);
	}

	public void setStereotype(Constraint constraint, String stereotype) {
		fUmlReflection.setStereotype(constraint, stereotype);
	}

	public void setType(TypedElement<EClassifier> element, EClassifier type) {
		fUmlReflection.setType(element, type);
	}
	
}
