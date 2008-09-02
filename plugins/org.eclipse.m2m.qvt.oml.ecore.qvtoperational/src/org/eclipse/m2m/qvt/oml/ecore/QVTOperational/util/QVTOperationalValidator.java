/**
 * <copyright>
 * Copyright (c) 2008 Open Canarias and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     A. Sanchez-Barbudo - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: QVTOperationalValidator.java,v 1.1 2008/09/02 20:02:27 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreValidator;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Constructor;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ConstructorBody;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ContextualProperty;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.DirectionKind;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.EntryOperation;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Helper;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ImperativeCallExp;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ImperativeOperation;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ImportKind;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Library;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.MappingBody;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.MappingCallExp;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.MappingOperation;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.MappingParameter;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ModelParameter;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ModelType;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.Module;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ModuleImport;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ObjectExp;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.OperationBody;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.OperationalTransformation;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveInExp;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.VarParameter;
import org.eclipse.ocl.expressions.util.ExpressionsValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.qvt.oml.ecore.QVTOperational.QVTOperationalPackage
 * @generated
 */
public class QVTOperationalValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final QVTOperationalValidator INSTANCE = new QVTOperationalValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.m2m.qvt.oml.ecore.QVTOperational";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EcoreValidator ecoreValidator;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected org.eclipse.ocl.ecore.util.EcoreValidator ecore_1Validator;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionsValidator expressionsValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTOperationalValidator() {
		super();
		ecoreValidator = EcoreValidator.INSTANCE;
		ecore_1Validator = org.eclipse.ocl.ecore.util.EcoreValidator.INSTANCE;
		expressionsValidator = ExpressionsValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return QVTOperationalPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case QVTOperationalPackage.CONSTRUCTOR:
				return validateConstructor((Constructor)value, diagnostics, context);
			case QVTOperationalPackage.CONSTRUCTOR_BODY:
				return validateConstructorBody((ConstructorBody)value, diagnostics, context);
			case QVTOperationalPackage.CONTEXTUAL_PROPERTY:
				return validateContextualProperty((ContextualProperty)value, diagnostics, context);
			case QVTOperationalPackage.ENTRY_OPERATION:
				return validateEntryOperation((EntryOperation)value, diagnostics, context);
			case QVTOperationalPackage.HELPER:
				return validateHelper((Helper)value, diagnostics, context);
			case QVTOperationalPackage.IMPERATIVE_CALL_EXP:
				return validateImperativeCallExp((ImperativeCallExp)value, diagnostics, context);
			case QVTOperationalPackage.IMPERATIVE_OPERATION:
				return validateImperativeOperation((ImperativeOperation)value, diagnostics, context);
			case QVTOperationalPackage.LIBRARY:
				return validateLibrary((Library)value, diagnostics, context);
			case QVTOperationalPackage.MAPPING_BODY:
				return validateMappingBody((MappingBody)value, diagnostics, context);
			case QVTOperationalPackage.MAPPING_CALL_EXP:
				return validateMappingCallExp((MappingCallExp)value, diagnostics, context);
			case QVTOperationalPackage.MAPPING_OPERATION:
				return validateMappingOperation((MappingOperation)value, diagnostics, context);
			case QVTOperationalPackage.MAPPING_PARAMETER:
				return validateMappingParameter((MappingParameter)value, diagnostics, context);
			case QVTOperationalPackage.MODEL_PARAMETER:
				return validateModelParameter((ModelParameter)value, diagnostics, context);
			case QVTOperationalPackage.MODEL_TYPE:
				return validateModelType((ModelType)value, diagnostics, context);
			case QVTOperationalPackage.MODULE:
				return validateModule((Module)value, diagnostics, context);
			case QVTOperationalPackage.MODULE_IMPORT:
				return validateModuleImport((ModuleImport)value, diagnostics, context);
			case QVTOperationalPackage.OBJECT_EXP:
				return validateObjectExp((ObjectExp)value, diagnostics, context);
			case QVTOperationalPackage.OPERATION_BODY:
				return validateOperationBody((OperationBody)value, diagnostics, context);
			case QVTOperationalPackage.OPERATIONAL_TRANSFORMATION:
				return validateOperationalTransformation((OperationalTransformation)value, diagnostics, context);
			case QVTOperationalPackage.RESOLVE_EXP:
				return validateResolveExp((ResolveExp)value, diagnostics, context);
			case QVTOperationalPackage.RESOLVE_IN_EXP:
				return validateResolveInExp((ResolveInExp)value, diagnostics, context);
			case QVTOperationalPackage.VAR_PARAMETER:
				return validateVarParameter((VarParameter)value, diagnostics, context);
			case QVTOperationalPackage.DIRECTION_KIND:
				return validateDirectionKind((DirectionKind)value, diagnostics, context);
			case QVTOperationalPackage.IMPORT_KIND:
				return validateImportKind((ImportKind)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstructor(Constructor constructor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(constructor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(constructor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(constructor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(constructor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(constructor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(constructor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(constructor, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(constructor, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(constructor, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(constructor, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(constructor, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(constructor, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEOperation_UniqueParameterNames(constructor, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEOperation_UniqueTypeParameterNames(constructor, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEOperation_NoRepeatingVoid(constructor, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstructorBody(ConstructorBody constructorBody, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(constructorBody, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContextualProperty(ContextualProperty contextualProperty, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(contextualProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(contextualProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(contextualProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(contextualProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(contextualProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(contextualProperty, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(contextualProperty, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(contextualProperty, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(contextualProperty, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(contextualProperty, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(contextualProperty, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(contextualProperty, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEStructuralFeature_ValidDefaultValueLiteral(contextualProperty, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntryOperation(EntryOperation entryOperation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(entryOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(entryOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(entryOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(entryOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(entryOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(entryOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(entryOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(entryOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(entryOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(entryOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(entryOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(entryOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEOperation_UniqueParameterNames(entryOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEOperation_UniqueTypeParameterNames(entryOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEOperation_NoRepeatingVoid(entryOperation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHelper(Helper helper, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(helper, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(helper, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(helper, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(helper, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(helper, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(helper, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(helper, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(helper, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(helper, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(helper, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(helper, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(helper, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEOperation_UniqueParameterNames(helper, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEOperation_UniqueTypeParameterNames(helper, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEOperation_NoRepeatingVoid(helper, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImperativeCallExp(ImperativeCallExp imperativeCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(imperativeCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(imperativeCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(imperativeCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(imperativeCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(imperativeCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(imperativeCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(imperativeCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(imperativeCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(imperativeCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(imperativeCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(imperativeCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(imperativeCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validateOperationCallExp_checkArgumentsConform(imperativeCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validateOperationCallExp_checkArgumentCount(imperativeCallExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImperativeOperation(ImperativeOperation imperativeOperation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(imperativeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(imperativeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(imperativeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(imperativeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(imperativeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(imperativeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(imperativeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(imperativeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(imperativeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(imperativeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(imperativeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(imperativeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEOperation_UniqueParameterNames(imperativeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEOperation_UniqueTypeParameterNames(imperativeOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEOperation_NoRepeatingVoid(imperativeOperation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLibrary(Library library, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(library, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(library, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(library, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(library, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(library, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(library, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(library, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(library, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_WellFormedInstanceTypeName(library, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_UniqueTypeParameterNames(library, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_InterfaceIsAbstract(library, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_AtMostOneID(library, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueFeatureNames(library, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueOperationSignatures(library, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_NoCircularSuperTypes(library, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_WellFormedMapEntryClass(library, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_ConsistentSuperTypes(library, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_DisjointFeatureAndOperationSignatures(library, diagnostics, context);
		if (result || diagnostics != null) result &= validateModule_WellFormedNsURI(library, diagnostics, context);
		if (result || diagnostics != null) result &= validateModule_WellFormedNsPrefix(library, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEPackage_UniqueSubpackageNames(library, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEPackage_UniqueClassifierNames(library, diagnostics, context);
		if (result || diagnostics != null) result &= validateModule_UniqueNsURIs(library, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingBody(MappingBody mappingBody, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingBody, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingCallExp(MappingCallExp mappingCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(mappingCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mappingCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mappingCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mappingCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mappingCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mappingCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mappingCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(mappingCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(mappingCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(mappingCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(mappingCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(mappingCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validateOperationCallExp_checkArgumentsConform(mappingCallExp, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validateOperationCallExp_checkArgumentCount(mappingCallExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingOperation(MappingOperation mappingOperation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(mappingOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mappingOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mappingOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mappingOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mappingOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mappingOperation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mappingOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(mappingOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(mappingOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(mappingOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(mappingOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(mappingOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEOperation_UniqueParameterNames(mappingOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEOperation_UniqueTypeParameterNames(mappingOperation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEOperation_NoRepeatingVoid(mappingOperation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingParameter(MappingParameter mappingParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateVariable_WellFormedName(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(mappingParameter, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validateVariable_checkInitType(mappingParameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelParameter(ModelParameter modelParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(modelParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(modelParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(modelParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(modelParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(modelParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(modelParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(modelParameter, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateVariable_WellFormedName(modelParameter, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(modelParameter, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(modelParameter, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(modelParameter, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(modelParameter, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validateVariable_checkInitType(modelParameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelType(ModelType modelType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(modelType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(modelType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(modelType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(modelType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(modelType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(modelType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(modelType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(modelType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_WellFormedInstanceTypeName(modelType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_UniqueTypeParameterNames(modelType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_InterfaceIsAbstract(modelType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_AtMostOneID(modelType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueFeatureNames(modelType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueOperationSignatures(modelType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_NoCircularSuperTypes(modelType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_WellFormedMapEntryClass(modelType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_ConsistentSuperTypes(modelType, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_DisjointFeatureAndOperationSignatures(modelType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModule(Module module, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(module, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(module, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(module, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(module, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(module, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(module, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(module, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(module, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_WellFormedInstanceTypeName(module, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_UniqueTypeParameterNames(module, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_InterfaceIsAbstract(module, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_AtMostOneID(module, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueFeatureNames(module, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueOperationSignatures(module, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_NoCircularSuperTypes(module, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_WellFormedMapEntryClass(module, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_ConsistentSuperTypes(module, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_DisjointFeatureAndOperationSignatures(module, diagnostics, context);
		if (result || diagnostics != null) result &= validateModule_WellFormedNsURI(module, diagnostics, context);
		if (result || diagnostics != null) result &= validateModule_WellFormedNsPrefix(module, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEPackage_UniqueSubpackageNames(module, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEPackage_UniqueClassifierNames(module, diagnostics, context);
		if (result || diagnostics != null) result &= validateModule_UniqueNsURIs(module, diagnostics, context);
		return result;
	}

	/**
	 * Validates the WellFormedNsURI constraint of '<em>Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateModule_WellFormedNsURI(Module module, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// EPackage's validation is not appropriate for transformation models
		return true;
	}

	/**
	 * Validates the WellFormedNsPrefix constraint of '<em>Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateModule_WellFormedNsPrefix(Module module, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// EPackage's validation is not appropriate for transformation models
		return true;
	}

	/**
	 * Validates the UniqueNsURIs constraint of '<em>Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateModule_UniqueNsURIs(Module module, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// EPackage's validation is not appropriate for transformation models
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModuleImport(ModuleImport moduleImport, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(moduleImport, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectExp(ObjectExp objectExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(objectExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(objectExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(objectExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(objectExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(objectExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(objectExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(objectExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(objectExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(objectExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(objectExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(objectExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(objectExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationBody(OperationBody operationBody, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(operationBody, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOperationalTransformation(OperationalTransformation operationalTransformation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateENamedElement_WellFormedName(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_WellFormedInstanceTypeName(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClassifier_UniqueTypeParameterNames(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_InterfaceIsAbstract(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_AtMostOneID(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueFeatureNames(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_UniqueOperationSignatures(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_NoCircularSuperTypes(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_WellFormedMapEntryClass(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_ConsistentSuperTypes(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEClass_DisjointFeatureAndOperationSignatures(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateModule_WellFormedNsURI(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateModule_WellFormedNsPrefix(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEPackage_UniqueSubpackageNames(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateEPackage_UniqueClassifierNames(operationalTransformation, diagnostics, context);
		if (result || diagnostics != null) result &= validateModule_UniqueNsURIs(operationalTransformation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResolveExp(ResolveExp resolveExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(resolveExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(resolveExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(resolveExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(resolveExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(resolveExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(resolveExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(resolveExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(resolveExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(resolveExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(resolveExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(resolveExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(resolveExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateResolveInExp(ResolveInExp resolveInExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(resolveInExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(resolveInExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(resolveInExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(resolveInExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(resolveInExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(resolveInExp, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(resolveInExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateOCLExpression_WellFormedName(resolveInExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(resolveInExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(resolveInExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(resolveInExp, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(resolveInExp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVarParameter(VarParameter varParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validate_EveryMultiplicityConforms(varParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(varParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(varParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(varParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(varParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(varParameter, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(varParameter, diagnostics, context);
		if (result || diagnostics != null) result &= ecore_1Validator.validateVariable_WellFormedName(varParameter, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidLowerBound(varParameter, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidUpperBound(varParameter, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ConsistentBounds(varParameter, diagnostics, context);
		if (result || diagnostics != null) result &= ecoreValidator.validateETypedElement_ValidType(varParameter, diagnostics, context);
		if (result || diagnostics != null) result &= expressionsValidator.validateVariable_checkInitType(varParameter, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDirectionKind(DirectionKind directionKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateImportKind(ImportKind importKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //QVTOperationalValidator
