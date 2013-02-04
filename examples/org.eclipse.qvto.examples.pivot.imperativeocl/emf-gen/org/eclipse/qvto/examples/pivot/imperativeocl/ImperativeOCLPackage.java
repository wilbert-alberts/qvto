/**
 * <copyright>
 * Copyright (c) 2013 Willink Transformations, University of York, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Adolfo Sanchez-Barbudo (University of York) - Bug397429
 * </copyright>
 */
package org.eclipse.qvto.examples.pivot.imperativeocl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.ocl.examples.pivot.PivotPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLFactory
 * @model kind="package"
 * @generated
 */
public interface ImperativeOCLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "imperativeocl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/pivot/1.0/ImperativeOCL";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "imperativeocl";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.qvto.imperativeocl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImperativeOCLPackage eINSTANCE = org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeExpressionImpl <em>Imperative Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeExpressionImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getImperativeExpression()
	 * @generated
	 */
	int IMPERATIVE_EXPRESSION = 12;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXPRESSION__OWNED_COMMENT = PivotPackage.OCL_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXPRESSION__EXTENSION = PivotPackage.OCL_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXPRESSION__NAME = PivotPackage.OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXPRESSION__OWNED_RULE = PivotPackage.OCL_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXPRESSION__IS_STATIC = PivotPackage.OCL_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXPRESSION__OWNED_ANNOTATION = PivotPackage.OCL_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXPRESSION__TYPE = PivotPackage.OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXPRESSION__IS_REQUIRED = PivotPackage.OCL_EXPRESSION__IS_REQUIRED;

	/**
	 * The number of structural features of the '<em>Imperative Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXPRESSION_FEATURE_COUNT = PivotPackage.OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXPRESSION___ALL_OWNED_ELEMENTS = PivotPackage.OCL_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXPRESSION___GET_VALUE__TYPE_STRING = PivotPackage.OCL_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXPRESSION___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = PivotPackage.OCL_EXPRESSION___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Imperative Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_EXPRESSION_OPERATION_COUNT = PivotPackage.OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.AltExpImpl <em>Alt Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.AltExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getAltExp()
	 * @generated
	 */
	int ALT_EXP = 0;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP__EXTENSION = IMPERATIVE_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP__OWNED_RULE = IMPERATIVE_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP__IS_STATIC = IMPERATIVE_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP__OWNED_ANNOTATION = IMPERATIVE_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP__IS_REQUIRED = IMPERATIVE_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP__BODY = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP__CONDITION = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Alt Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP___ALL_OWNED_ELEMENTS = IMPERATIVE_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP___GET_VALUE__TYPE_STRING = IMPERATIVE_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = IMPERATIVE_EXPRESSION___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP___ACCEPT__IMPERATIVEOCLVISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP___ACCEPT__VISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Alt Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALT_EXP_OPERATION_COUNT = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.AssertExpImpl <em>Assert Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.AssertExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getAssertExp()
	 * @generated
	 */
	int ASSERT_EXP = 1;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__EXTENSION = IMPERATIVE_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__OWNED_RULE = IMPERATIVE_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__IS_STATIC = IMPERATIVE_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__OWNED_ANNOTATION = IMPERATIVE_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__IS_REQUIRED = IMPERATIVE_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Assertion</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__ASSERTION = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Log</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__LOG = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP__SEVERITY = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Assert Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP___ALL_OWNED_ELEMENTS = IMPERATIVE_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP___GET_VALUE__TYPE_STRING = IMPERATIVE_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = IMPERATIVE_EXPRESSION___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP___ACCEPT__IMPERATIVEOCLVISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP___ACCEPT__VISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Assert Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERT_EXP_OPERATION_COUNT = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.AssignExpImpl <em>Assign Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.AssignExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getAssignExp()
	 * @generated
	 */
	int ASSIGN_EXP = 2;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__EXTENSION = IMPERATIVE_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__OWNED_RULE = IMPERATIVE_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__IS_STATIC = IMPERATIVE_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__OWNED_ANNOTATION = IMPERATIVE_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__IS_REQUIRED = IMPERATIVE_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__DEFAULT_VALUE = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Reset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__IS_RESET = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__LEFT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP__VALUE = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Assign Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP___ALL_OWNED_ELEMENTS = IMPERATIVE_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP___GET_VALUE__TYPE_STRING = IMPERATIVE_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = IMPERATIVE_EXPRESSION___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP___ACCEPT__IMPERATIVEOCLVISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP___ACCEPT__VISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Assign Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGN_EXP_OPERATION_COUNT = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.BlockExpImpl <em>Block Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.BlockExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getBlockExp()
	 * @generated
	 */
	int BLOCK_EXP = 3;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP__EXTENSION = IMPERATIVE_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP__OWNED_RULE = IMPERATIVE_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP__IS_STATIC = IMPERATIVE_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP__OWNED_ANNOTATION = IMPERATIVE_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP__IS_REQUIRED = IMPERATIVE_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP__BODY = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP___ALL_OWNED_ELEMENTS = IMPERATIVE_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP___GET_VALUE__TYPE_STRING = IMPERATIVE_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = IMPERATIVE_EXPRESSION___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP___ACCEPT__IMPERATIVEOCLVISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP___ACCEPT__VISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Block Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_EXP_OPERATION_COUNT = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.BreakExpImpl <em>Break Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.BreakExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getBreakExp()
	 * @generated
	 */
	int BREAK_EXP = 4;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP__EXTENSION = IMPERATIVE_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP__OWNED_RULE = IMPERATIVE_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP__IS_STATIC = IMPERATIVE_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP__OWNED_ANNOTATION = IMPERATIVE_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP__IS_REQUIRED = IMPERATIVE_EXPRESSION__IS_REQUIRED;

	/**
	 * The number of structural features of the '<em>Break Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP___ALL_OWNED_ELEMENTS = IMPERATIVE_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP___GET_VALUE__TYPE_STRING = IMPERATIVE_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = IMPERATIVE_EXPRESSION___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP___ACCEPT__IMPERATIVEOCLVISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP___ACCEPT__VISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Break Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_EXP_OPERATION_COUNT = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.CatchExpImpl <em>Catch Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.CatchExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getCatchExp()
	 * @generated
	 */
	int CATCH_EXP = 5;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP__EXTENSION = IMPERATIVE_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP__OWNED_RULE = IMPERATIVE_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP__IS_STATIC = IMPERATIVE_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP__OWNED_ANNOTATION = IMPERATIVE_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP__IS_REQUIRED = IMPERATIVE_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP__BODY = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP__EXCEPTION = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Catch Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP___ALL_OWNED_ELEMENTS = IMPERATIVE_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP___GET_VALUE__TYPE_STRING = IMPERATIVE_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = IMPERATIVE_EXPRESSION___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP___ACCEPT__IMPERATIVEOCLVISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP___ACCEPT__VISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Catch Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATCH_EXP_OPERATION_COUNT = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.ComputeExpImpl <em>Compute Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ComputeExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getComputeExp()
	 * @generated
	 */
	int COMPUTE_EXP = 6;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP__EXTENSION = IMPERATIVE_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP__OWNED_RULE = IMPERATIVE_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP__IS_STATIC = IMPERATIVE_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP__OWNED_ANNOTATION = IMPERATIVE_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP__IS_REQUIRED = IMPERATIVE_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP__BODY = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Returned Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP__RETURNED_ELEMENT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Compute Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP___ALL_OWNED_ELEMENTS = IMPERATIVE_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP___GET_VALUE__TYPE_STRING = IMPERATIVE_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = IMPERATIVE_EXPRESSION___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP___ACCEPT__IMPERATIVEOCLVISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP___ACCEPT__VISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Compute Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTE_EXP_OPERATION_COUNT = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.ContinueExpImpl <em>Continue Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ContinueExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getContinueExp()
	 * @generated
	 */
	int CONTINUE_EXP = 7;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP__EXTENSION = IMPERATIVE_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP__OWNED_RULE = IMPERATIVE_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP__IS_STATIC = IMPERATIVE_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP__OWNED_ANNOTATION = IMPERATIVE_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP__IS_REQUIRED = IMPERATIVE_EXPRESSION__IS_REQUIRED;

	/**
	 * The number of structural features of the '<em>Continue Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP___ALL_OWNED_ELEMENTS = IMPERATIVE_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP___GET_VALUE__TYPE_STRING = IMPERATIVE_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = IMPERATIVE_EXPRESSION___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP___ACCEPT__IMPERATIVEOCLVISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP___ACCEPT__VISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Continue Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_EXP_OPERATION_COUNT = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.DictLiteralExpImpl <em>Dict Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.DictLiteralExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getDictLiteralExp()
	 * @generated
	 */
	int DICT_LITERAL_EXP = 8;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP__OWNED_COMMENT = PivotPackage.LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP__EXTENSION = PivotPackage.LITERAL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP__NAME = PivotPackage.LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP__OWNED_RULE = PivotPackage.LITERAL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP__IS_STATIC = PivotPackage.LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP__OWNED_ANNOTATION = PivotPackage.LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP__TYPE = PivotPackage.LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP__IS_REQUIRED = PivotPackage.LITERAL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP__PART = PivotPackage.LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dict Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_FEATURE_COUNT = PivotPackage.LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP___ALL_OWNED_ELEMENTS = PivotPackage.LITERAL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP___GET_VALUE__TYPE_STRING = PivotPackage.LITERAL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = PivotPackage.LITERAL_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP___ACCEPT__IMPERATIVEOCLVISITOR = PivotPackage.LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP___ACCEPT__VISITOR = PivotPackage.LITERAL_EXP_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Dict Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_EXP_OPERATION_COUNT = PivotPackage.LITERAL_EXP_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.DictLiteralPartImpl <em>Dict Literal Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.DictLiteralPartImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getDictLiteralPart()
	 * @generated
	 */
	int DICT_LITERAL_PART = 9;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART__OWNED_COMMENT = PivotPackage.ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART__EXTENSION = PivotPackage.ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART__KEY = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART__VALUE = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dict Literal Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART___ALL_OWNED_ELEMENTS = PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART___GET_VALUE__TYPE_STRING = PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = PivotPackage.ELEMENT___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART___ACCEPT__IMPERATIVEOCLVISITOR = PivotPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART___ACCEPT__VISITOR = PivotPackage.ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Dict Literal Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICT_LITERAL_PART_OPERATION_COUNT = PivotPackage.ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.DictionaryTypeImpl <em>Dictionary Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.DictionaryTypeImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getDictionaryType()
	 * @generated
	 */
	int DICTIONARY_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__OWNED_COMMENT = PivotPackage.COLLECTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__EXTENSION = PivotPackage.COLLECTION_TYPE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__NAME = PivotPackage.COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__OWNED_RULE = PivotPackage.COLLECTION_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__IS_STATIC = PivotPackage.COLLECTION_TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__OWNED_ANNOTATION = PivotPackage.COLLECTION_TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__TEMPLATE_BINDING = PivotPackage.COLLECTION_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__OWNED_TEMPLATE_SIGNATURE = PivotPackage.COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__UNSPECIALIZED_ELEMENT = PivotPackage.COLLECTION_TYPE__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__OWNING_TEMPLATE_PARAMETER = PivotPackage.COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__TEMPLATE_PARAMETER = PivotPackage.COLLECTION_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__PACKAGE = PivotPackage.COLLECTION_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__OWNED_ATTRIBUTE = PivotPackage.COLLECTION_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__OWNED_OPERATION = PivotPackage.COLLECTION_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__SUPER_CLASS = PivotPackage.COLLECTION_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__INSTANCE_CLASS_NAME = PivotPackage.COLLECTION_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__IS_ABSTRACT = PivotPackage.COLLECTION_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__OWNED_BEHAVIOR = PivotPackage.COLLECTION_TYPE__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__IS_INTERFACE = PivotPackage.COLLECTION_TYPE__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__IS_SERIALIZABLE = PivotPackage.COLLECTION_TYPE__IS_SERIALIZABLE;

	/**
	 * The feature id for the '<em><b>Behavioral Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__BEHAVIORAL_TYPE = PivotPackage.COLLECTION_TYPE__BEHAVIORAL_TYPE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__ELEMENT_TYPE = PivotPackage.COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__LOWER = PivotPackage.COLLECTION_TYPE__LOWER;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__UPPER = PivotPackage.COLLECTION_TYPE__UPPER;

	/**
	 * The feature id for the '<em><b>Key Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE__KEY_TYPE = PivotPackage.COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dictionary Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE_FEATURE_COUNT = PivotPackage.COLLECTION_TYPE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE___ALL_OWNED_ELEMENTS = PivotPackage.COLLECTION_TYPE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE___GET_VALUE__TYPE_STRING = PivotPackage.COLLECTION_TYPE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = PivotPackage.COLLECTION_TYPE___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE___PARAMETERABLE_ELEMENTS = PivotPackage.COLLECTION_TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE___IS_TEMPLATE = PivotPackage.COLLECTION_TYPE___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE___IS_TEMPLATE_PARAMETER = PivotPackage.COLLECTION_TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = PivotPackage.COLLECTION_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Resolve Self Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE___RESOLVE_SELF_TYPE__TYPE = PivotPackage.COLLECTION_TYPE___RESOLVE_SELF_TYPE__TYPE;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE___ACCEPT__IMPERATIVEOCLVISITOR = PivotPackage.COLLECTION_TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE___ACCEPT__VISITOR = PivotPackage.COLLECTION_TYPE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Dictionary Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_TYPE_OPERATION_COUNT = PivotPackage.COLLECTION_TYPE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeLoopExpImpl <em>Imperative Loop Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeLoopExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getImperativeLoopExp()
	 * @generated
	 */
	int IMPERATIVE_LOOP_EXP = 14;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP__OWNED_COMMENT = PivotPackage.LOOP_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP__EXTENSION = PivotPackage.LOOP_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP__NAME = PivotPackage.LOOP_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP__OWNED_RULE = PivotPackage.LOOP_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP__IS_STATIC = PivotPackage.LOOP_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP__OWNED_ANNOTATION = PivotPackage.LOOP_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP__TYPE = PivotPackage.LOOP_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP__IS_REQUIRED = PivotPackage.LOOP_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP__SOURCE = PivotPackage.LOOP_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP__IMPLICIT = PivotPackage.LOOP_EXP__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP__BODY = PivotPackage.LOOP_EXP__BODY;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP__ITERATOR = PivotPackage.LOOP_EXP__ITERATOR;

	/**
	 * The feature id for the '<em><b>Referred Iteration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP__REFERRED_ITERATION = PivotPackage.LOOP_EXP__REFERRED_ITERATION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP__CONDITION = PivotPackage.LOOP_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Imperative Loop Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_FEATURE_COUNT = PivotPackage.LOOP_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP___ALL_OWNED_ELEMENTS = PivotPackage.LOOP_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP___GET_VALUE__TYPE_STRING = PivotPackage.LOOP_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = PivotPackage.LOOP_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Source Is Collection</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP___VALIDATE_SOURCE_IS_COLLECTION__DIAGNOSTICCHAIN_MAP = PivotPackage.LOOP_EXP___VALIDATE_SOURCE_IS_COLLECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate No Initializers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP___VALIDATE_NO_INITIALIZERS__DIAGNOSTICCHAIN_MAP = PivotPackage.LOOP_EXP___VALIDATE_NO_INITIALIZERS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Imperative Loop Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_LOOP_EXP_OPERATION_COUNT = PivotPackage.LOOP_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.ForExpImpl <em>For Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ForExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getForExp()
	 * @generated
	 */
	int FOR_EXP = 11;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP__OWNED_COMMENT = IMPERATIVE_LOOP_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP__EXTENSION = IMPERATIVE_LOOP_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP__NAME = IMPERATIVE_LOOP_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP__OWNED_RULE = IMPERATIVE_LOOP_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP__IS_STATIC = IMPERATIVE_LOOP_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP__OWNED_ANNOTATION = IMPERATIVE_LOOP_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP__TYPE = IMPERATIVE_LOOP_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP__IS_REQUIRED = IMPERATIVE_LOOP_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP__SOURCE = IMPERATIVE_LOOP_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP__IMPLICIT = IMPERATIVE_LOOP_EXP__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP__BODY = IMPERATIVE_LOOP_EXP__BODY;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP__ITERATOR = IMPERATIVE_LOOP_EXP__ITERATOR;

	/**
	 * The feature id for the '<em><b>Referred Iteration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP__REFERRED_ITERATION = IMPERATIVE_LOOP_EXP__REFERRED_ITERATION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP__CONDITION = IMPERATIVE_LOOP_EXP__CONDITION;

	/**
	 * The number of structural features of the '<em>For Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_FEATURE_COUNT = IMPERATIVE_LOOP_EXP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP___ALL_OWNED_ELEMENTS = IMPERATIVE_LOOP_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP___GET_VALUE__TYPE_STRING = IMPERATIVE_LOOP_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = IMPERATIVE_LOOP_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Source Is Collection</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP___VALIDATE_SOURCE_IS_COLLECTION__DIAGNOSTICCHAIN_MAP = IMPERATIVE_LOOP_EXP___VALIDATE_SOURCE_IS_COLLECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate No Initializers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP___VALIDATE_NO_INITIALIZERS__DIAGNOSTICCHAIN_MAP = IMPERATIVE_LOOP_EXP___VALIDATE_NO_INITIALIZERS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP___ACCEPT__IMPERATIVEOCLVISITOR = IMPERATIVE_LOOP_EXP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP___ACCEPT__VISITOR = IMPERATIVE_LOOP_EXP_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>For Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EXP_OPERATION_COUNT = IMPERATIVE_LOOP_EXP_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeIterateExpImpl <em>Imperative Iterate Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeIterateExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getImperativeIterateExp()
	 * @generated
	 */
	int IMPERATIVE_ITERATE_EXP = 13;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__OWNED_COMMENT = IMPERATIVE_LOOP_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__EXTENSION = IMPERATIVE_LOOP_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__NAME = IMPERATIVE_LOOP_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__OWNED_RULE = IMPERATIVE_LOOP_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__IS_STATIC = IMPERATIVE_LOOP_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__OWNED_ANNOTATION = IMPERATIVE_LOOP_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__TYPE = IMPERATIVE_LOOP_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__IS_REQUIRED = IMPERATIVE_LOOP_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__SOURCE = IMPERATIVE_LOOP_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__IMPLICIT = IMPERATIVE_LOOP_EXP__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__BODY = IMPERATIVE_LOOP_EXP__BODY;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__ITERATOR = IMPERATIVE_LOOP_EXP__ITERATOR;

	/**
	 * The feature id for the '<em><b>Referred Iteration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__REFERRED_ITERATION = IMPERATIVE_LOOP_EXP__REFERRED_ITERATION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__CONDITION = IMPERATIVE_LOOP_EXP__CONDITION;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP__TARGET = IMPERATIVE_LOOP_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Imperative Iterate Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_FEATURE_COUNT = IMPERATIVE_LOOP_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP___ALL_OWNED_ELEMENTS = IMPERATIVE_LOOP_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP___GET_VALUE__TYPE_STRING = IMPERATIVE_LOOP_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = IMPERATIVE_LOOP_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Source Is Collection</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP___VALIDATE_SOURCE_IS_COLLECTION__DIAGNOSTICCHAIN_MAP = IMPERATIVE_LOOP_EXP___VALIDATE_SOURCE_IS_COLLECTION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate No Initializers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP___VALIDATE_NO_INITIALIZERS__DIAGNOSTICCHAIN_MAP = IMPERATIVE_LOOP_EXP___VALIDATE_NO_INITIALIZERS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP___ACCEPT__IMPERATIVEOCLVISITOR = IMPERATIVE_LOOP_EXP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP___ACCEPT__VISITOR = IMPERATIVE_LOOP_EXP_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Imperative Iterate Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_ITERATE_EXP_OPERATION_COUNT = IMPERATIVE_LOOP_EXP_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.InstantiationExpImpl <em>Instantiation Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.InstantiationExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getInstantiationExp()
	 * @generated
	 */
	int INSTANTIATION_EXP = 15;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__EXTENSION = IMPERATIVE_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__OWNED_RULE = IMPERATIVE_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__IS_STATIC = IMPERATIVE_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__OWNED_ANNOTATION = IMPERATIVE_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__IS_REQUIRED = IMPERATIVE_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__ARGUMENT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__EXTENT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Instantiated Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP__INSTANTIATED_CLASS = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Instantiation Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP___ALL_OWNED_ELEMENTS = IMPERATIVE_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP___GET_VALUE__TYPE_STRING = IMPERATIVE_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = IMPERATIVE_EXPRESSION___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP___ACCEPT__IMPERATIVEOCLVISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP___ACCEPT__VISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Instantiation Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTIATION_EXP_OPERATION_COUNT = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.ListLiteralExpImpl <em>List Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ListLiteralExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getListLiteralExp()
	 * @generated
	 */
	int LIST_LITERAL_EXP = 16;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP__OWNED_COMMENT = PivotPackage.LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP__EXTENSION = PivotPackage.LITERAL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP__NAME = PivotPackage.LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP__OWNED_RULE = PivotPackage.LITERAL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP__IS_STATIC = PivotPackage.LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP__OWNED_ANNOTATION = PivotPackage.LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP__TYPE = PivotPackage.LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP__IS_REQUIRED = PivotPackage.LITERAL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP__ELEMENT = PivotPackage.LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>List Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_FEATURE_COUNT = PivotPackage.LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP___ALL_OWNED_ELEMENTS = PivotPackage.LITERAL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP___GET_VALUE__TYPE_STRING = PivotPackage.LITERAL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = PivotPackage.LITERAL_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP___ACCEPT__IMPERATIVEOCLVISITOR = PivotPackage.LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP___ACCEPT__VISITOR = PivotPackage.LITERAL_EXP_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>List Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_LITERAL_EXP_OPERATION_COUNT = PivotPackage.LITERAL_EXP_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.ListTypeImpl <em>List Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ListTypeImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getListType()
	 * @generated
	 */
	int LIST_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__OWNED_COMMENT = PivotPackage.COLLECTION_TYPE__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__EXTENSION = PivotPackage.COLLECTION_TYPE__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__NAME = PivotPackage.COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__OWNED_RULE = PivotPackage.COLLECTION_TYPE__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__IS_STATIC = PivotPackage.COLLECTION_TYPE__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__OWNED_ANNOTATION = PivotPackage.COLLECTION_TYPE__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__TEMPLATE_BINDING = PivotPackage.COLLECTION_TYPE__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__OWNED_TEMPLATE_SIGNATURE = PivotPackage.COLLECTION_TYPE__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__UNSPECIALIZED_ELEMENT = PivotPackage.COLLECTION_TYPE__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__OWNING_TEMPLATE_PARAMETER = PivotPackage.COLLECTION_TYPE__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__TEMPLATE_PARAMETER = PivotPackage.COLLECTION_TYPE__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__PACKAGE = PivotPackage.COLLECTION_TYPE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__OWNED_ATTRIBUTE = PivotPackage.COLLECTION_TYPE__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__OWNED_OPERATION = PivotPackage.COLLECTION_TYPE__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__SUPER_CLASS = PivotPackage.COLLECTION_TYPE__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__INSTANCE_CLASS_NAME = PivotPackage.COLLECTION_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__IS_ABSTRACT = PivotPackage.COLLECTION_TYPE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__OWNED_BEHAVIOR = PivotPackage.COLLECTION_TYPE__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__IS_INTERFACE = PivotPackage.COLLECTION_TYPE__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Is Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__IS_SERIALIZABLE = PivotPackage.COLLECTION_TYPE__IS_SERIALIZABLE;

	/**
	 * The feature id for the '<em><b>Behavioral Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__BEHAVIORAL_TYPE = PivotPackage.COLLECTION_TYPE__BEHAVIORAL_TYPE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__ELEMENT_TYPE = PivotPackage.COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__LOWER = PivotPackage.COLLECTION_TYPE__LOWER;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__UPPER = PivotPackage.COLLECTION_TYPE__UPPER;

	/**
	 * The number of structural features of the '<em>List Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_FEATURE_COUNT = PivotPackage.COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE___ALL_OWNED_ELEMENTS = PivotPackage.COLLECTION_TYPE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE___GET_VALUE__TYPE_STRING = PivotPackage.COLLECTION_TYPE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = PivotPackage.COLLECTION_TYPE___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE___PARAMETERABLE_ELEMENTS = PivotPackage.COLLECTION_TYPE___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE___IS_TEMPLATE = PivotPackage.COLLECTION_TYPE___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE___IS_TEMPLATE_PARAMETER = PivotPackage.COLLECTION_TYPE___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = PivotPackage.COLLECTION_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Resolve Self Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE___RESOLVE_SELF_TYPE__TYPE = PivotPackage.COLLECTION_TYPE___RESOLVE_SELF_TYPE__TYPE;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE___ACCEPT__IMPERATIVEOCLVISITOR = PivotPackage.COLLECTION_TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE___ACCEPT__VISITOR = PivotPackage.COLLECTION_TYPE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>List Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_OPERATION_COUNT = PivotPackage.COLLECTION_TYPE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.LogExpImpl <em>Log Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.LogExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getLogExp()
	 * @generated
	 */
	int LOG_EXP = 18;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__OWNED_COMMENT = PivotPackage.OPERATION_CALL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__EXTENSION = PivotPackage.OPERATION_CALL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__NAME = PivotPackage.OPERATION_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__OWNED_RULE = PivotPackage.OPERATION_CALL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__IS_STATIC = PivotPackage.OPERATION_CALL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__OWNED_ANNOTATION = PivotPackage.OPERATION_CALL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__TYPE = PivotPackage.OPERATION_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__IS_REQUIRED = PivotPackage.OPERATION_CALL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__SOURCE = PivotPackage.OPERATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__IMPLICIT = PivotPackage.OPERATION_CALL_EXP__IMPLICIT;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__IS_PRE = PivotPackage.OPERATION_CALL_EXP__IS_PRE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__ARGUMENT = PivotPackage.OPERATION_CALL_EXP__ARGUMENT;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__REFERRED_OPERATION = PivotPackage.OPERATION_CALL_EXP__REFERRED_OPERATION;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP__CONDITION = PivotPackage.OPERATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Log Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_FEATURE_COUNT = PivotPackage.OPERATION_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP___ALL_OWNED_ELEMENTS = PivotPackage.OPERATION_CALL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP___GET_VALUE__TYPE_STRING = PivotPackage.OPERATION_CALL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = PivotPackage.OPERATION_CALL_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Referred Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP___GET_REFERRED_ELEMENT = PivotPackage.OPERATION_CALL_EXP___GET_REFERRED_ELEMENT;

	/**
	 * The operation id for the '<em>Validate Argument Count</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP___VALIDATE_ARGUMENT_COUNT__DIAGNOSTICCHAIN_MAP = PivotPackage.OPERATION_CALL_EXP___VALIDATE_ARGUMENT_COUNT__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP___ACCEPT__IMPERATIVEOCLVISITOR = PivotPackage.OPERATION_CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP___ACCEPT__VISITOR = PivotPackage.OPERATION_CALL_EXP_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Log Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_EXP_OPERATION_COUNT = PivotPackage.OPERATION_CALL_EXP_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.OrderedTupleLiteralExpImpl <em>Ordered Tuple Literal Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.OrderedTupleLiteralExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getOrderedTupleLiteralExp()
	 * @generated
	 */
	int ORDERED_TUPLE_LITERAL_EXP = 19;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_EXP__OWNED_COMMENT = PivotPackage.LITERAL_EXP__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_EXP__EXTENSION = PivotPackage.LITERAL_EXP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_EXP__NAME = PivotPackage.LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_EXP__OWNED_RULE = PivotPackage.LITERAL_EXP__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_EXP__IS_STATIC = PivotPackage.LITERAL_EXP__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_EXP__OWNED_ANNOTATION = PivotPackage.LITERAL_EXP__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_EXP__TYPE = PivotPackage.LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_EXP__IS_REQUIRED = PivotPackage.LITERAL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_EXP__PART = PivotPackage.LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ordered Tuple Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_EXP_FEATURE_COUNT = PivotPackage.LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_EXP___ALL_OWNED_ELEMENTS = PivotPackage.LITERAL_EXP___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_EXP___GET_VALUE__TYPE_STRING = PivotPackage.LITERAL_EXP___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = PivotPackage.LITERAL_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_EXP___ACCEPT__IMPERATIVEOCLVISITOR = PivotPackage.LITERAL_EXP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_EXP___ACCEPT__VISITOR = PivotPackage.LITERAL_EXP_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Ordered Tuple Literal Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_EXP_OPERATION_COUNT = PivotPackage.LITERAL_EXP_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.OrderedTupleLiteralPartImpl <em>Ordered Tuple Literal Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.OrderedTupleLiteralPartImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getOrderedTupleLiteralPart()
	 * @generated
	 */
	int ORDERED_TUPLE_LITERAL_PART = 20;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_PART__OWNED_COMMENT = PivotPackage.ELEMENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_PART__EXTENSION = PivotPackage.ELEMENT__EXTENSION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_PART__VALUE = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ordered Tuple Literal Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_PART_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_PART___ALL_OWNED_ELEMENTS = PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_PART___GET_VALUE__TYPE_STRING = PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_PART___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = PivotPackage.ELEMENT___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_PART___ACCEPT__IMPERATIVEOCLVISITOR = PivotPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_PART___ACCEPT__VISITOR = PivotPackage.ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Ordered Tuple Literal Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_LITERAL_PART_OPERATION_COUNT = PivotPackage.ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.OrderedTupleTypeImpl <em>Ordered Tuple Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.OrderedTupleTypeImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getOrderedTupleType()
	 * @generated
	 */
	int ORDERED_TUPLE_TYPE = 21;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__OWNED_COMMENT = PivotPackage.CLASS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__EXTENSION = PivotPackage.CLASS__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__NAME = PivotPackage.CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__OWNED_RULE = PivotPackage.CLASS__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__IS_STATIC = PivotPackage.CLASS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__OWNED_ANNOTATION = PivotPackage.CLASS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__TEMPLATE_BINDING = PivotPackage.CLASS__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__OWNED_TEMPLATE_SIGNATURE = PivotPackage.CLASS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__UNSPECIALIZED_ELEMENT = PivotPackage.CLASS__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__OWNING_TEMPLATE_PARAMETER = PivotPackage.CLASS__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__TEMPLATE_PARAMETER = PivotPackage.CLASS__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__PACKAGE = PivotPackage.CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__OWNED_ATTRIBUTE = PivotPackage.CLASS__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__OWNED_OPERATION = PivotPackage.CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__SUPER_CLASS = PivotPackage.CLASS__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__INSTANCE_CLASS_NAME = PivotPackage.CLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__IS_ABSTRACT = PivotPackage.CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__OWNED_BEHAVIOR = PivotPackage.CLASS__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__IS_INTERFACE = PivotPackage.CLASS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE__ELEMENT_TYPE = PivotPackage.CLASS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ordered Tuple Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE_FEATURE_COUNT = PivotPackage.CLASS_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE___ALL_OWNED_ELEMENTS = PivotPackage.CLASS___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE___GET_VALUE__TYPE_STRING = PivotPackage.CLASS___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = PivotPackage.CLASS___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE___PARAMETERABLE_ELEMENTS = PivotPackage.CLASS___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE___IS_TEMPLATE = PivotPackage.CLASS___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE___IS_TEMPLATE_PARAMETER = PivotPackage.CLASS___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = PivotPackage.CLASS___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Resolve Self Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE___RESOLVE_SELF_TYPE__TYPE = PivotPackage.CLASS___RESOLVE_SELF_TYPE__TYPE;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE___ACCEPT__IMPERATIVEOCLVISITOR = PivotPackage.CLASS_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE___ACCEPT__VISITOR = PivotPackage.CLASS_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Ordered Tuple Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_TUPLE_TYPE_OPERATION_COUNT = PivotPackage.CLASS_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.RaiseExpImpl <em>Raise Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.RaiseExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getRaiseExp()
	 * @generated
	 */
	int RAISE_EXP = 22;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP__EXTENSION = IMPERATIVE_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP__OWNED_RULE = IMPERATIVE_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP__IS_STATIC = IMPERATIVE_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP__OWNED_ANNOTATION = IMPERATIVE_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP__IS_REQUIRED = IMPERATIVE_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP__ARGUMENT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP__EXCEPTION = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Raise Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP___ALL_OWNED_ELEMENTS = IMPERATIVE_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP___GET_VALUE__TYPE_STRING = IMPERATIVE_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = IMPERATIVE_EXPRESSION___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP___ACCEPT__IMPERATIVEOCLVISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP___ACCEPT__VISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Raise Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAISE_EXP_OPERATION_COUNT = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.ReturnExpImpl <em>Return Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ReturnExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getReturnExp()
	 * @generated
	 */
	int RETURN_EXP = 23;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP__EXTENSION = IMPERATIVE_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP__OWNED_RULE = IMPERATIVE_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP__IS_STATIC = IMPERATIVE_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP__OWNED_ANNOTATION = IMPERATIVE_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP__IS_REQUIRED = IMPERATIVE_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP__VALUE = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Return Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP___ALL_OWNED_ELEMENTS = IMPERATIVE_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP___GET_VALUE__TYPE_STRING = IMPERATIVE_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = IMPERATIVE_EXPRESSION___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP___ACCEPT__IMPERATIVEOCLVISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP___ACCEPT__VISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Return Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_EXP_OPERATION_COUNT = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.SwitchExpImpl <em>Switch Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.SwitchExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getSwitchExp()
	 * @generated
	 */
	int SWITCH_EXP = 24;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP__EXTENSION = IMPERATIVE_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP__OWNED_RULE = IMPERATIVE_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP__IS_STATIC = IMPERATIVE_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP__OWNED_ANNOTATION = IMPERATIVE_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP__IS_REQUIRED = IMPERATIVE_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Alternative Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP__ALTERNATIVE_PART = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Else Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP__ELSE_PART = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Switch Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP___ALL_OWNED_ELEMENTS = IMPERATIVE_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP___GET_VALUE__TYPE_STRING = IMPERATIVE_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = IMPERATIVE_EXPRESSION___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP___ACCEPT__IMPERATIVEOCLVISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP___ACCEPT__VISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Switch Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXP_OPERATION_COUNT = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.TryExpImpl <em>Try Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.TryExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getTryExp()
	 * @generated
	 */
	int TRY_EXP = 25;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP__EXTENSION = IMPERATIVE_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP__OWNED_RULE = IMPERATIVE_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP__IS_STATIC = IMPERATIVE_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP__OWNED_ANNOTATION = IMPERATIVE_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP__IS_REQUIRED = IMPERATIVE_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Except Clause</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP__EXCEPT_CLAUSE = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Try Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP__TRY_BODY = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Try Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP___ALL_OWNED_ELEMENTS = IMPERATIVE_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP___GET_VALUE__TYPE_STRING = IMPERATIVE_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = IMPERATIVE_EXPRESSION___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP___ACCEPT__IMPERATIVEOCLVISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP___ACCEPT__VISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Try Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_EXP_OPERATION_COUNT = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.TypedefImpl <em>Typedef</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.TypedefImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getTypedef()
	 * @generated
	 */
	int TYPEDEF = 26;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__OWNED_COMMENT = PivotPackage.CLASS__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__EXTENSION = PivotPackage.CLASS__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__NAME = PivotPackage.CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__OWNED_RULE = PivotPackage.CLASS__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__IS_STATIC = PivotPackage.CLASS__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__OWNED_ANNOTATION = PivotPackage.CLASS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__TEMPLATE_BINDING = PivotPackage.CLASS__TEMPLATE_BINDING;

	/**
	 * The feature id for the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__OWNED_TEMPLATE_SIGNATURE = PivotPackage.CLASS__OWNED_TEMPLATE_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__UNSPECIALIZED_ELEMENT = PivotPackage.CLASS__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owning Template Parameter</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__OWNING_TEMPLATE_PARAMETER = PivotPackage.CLASS__OWNING_TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__TEMPLATE_PARAMETER = PivotPackage.CLASS__TEMPLATE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__PACKAGE = PivotPackage.CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Owned Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__OWNED_ATTRIBUTE = PivotPackage.CLASS__OWNED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__OWNED_OPERATION = PivotPackage.CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__SUPER_CLASS = PivotPackage.CLASS__SUPER_CLASS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__INSTANCE_CLASS_NAME = PivotPackage.CLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__IS_ABSTRACT = PivotPackage.CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__OWNED_BEHAVIOR = PivotPackage.CLASS__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__IS_INTERFACE = PivotPackage.CLASS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Base</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__BASE = PivotPackage.CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF__CONDITION = PivotPackage.CLASS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Typedef</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF_FEATURE_COUNT = PivotPackage.CLASS_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF___ALL_OWNED_ELEMENTS = PivotPackage.CLASS___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF___GET_VALUE__TYPE_STRING = PivotPackage.CLASS___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = PivotPackage.CLASS___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Parameterable Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF___PARAMETERABLE_ELEMENTS = PivotPackage.CLASS___PARAMETERABLE_ELEMENTS;

	/**
	 * The operation id for the '<em>Is Template</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF___IS_TEMPLATE = PivotPackage.CLASS___IS_TEMPLATE;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF___IS_TEMPLATE_PARAMETER = PivotPackage.CLASS___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Is Compatible With</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT = PivotPackage.CLASS___IS_COMPATIBLE_WITH__PARAMETERABLEELEMENT;

	/**
	 * The operation id for the '<em>Resolve Self Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF___RESOLVE_SELF_TYPE__TYPE = PivotPackage.CLASS___RESOLVE_SELF_TYPE__TYPE;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF___ACCEPT__IMPERATIVEOCLVISITOR = PivotPackage.CLASS_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF___ACCEPT__VISITOR = PivotPackage.CLASS_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Typedef</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF_OPERATION_COUNT = PivotPackage.CLASS_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.UnlinkExpImpl <em>Unlink Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.UnlinkExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getUnlinkExp()
	 * @generated
	 */
	int UNLINK_EXP = 27;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP__EXTENSION = IMPERATIVE_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP__OWNED_RULE = IMPERATIVE_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP__IS_STATIC = IMPERATIVE_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP__OWNED_ANNOTATION = IMPERATIVE_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP__IS_REQUIRED = IMPERATIVE_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP__ITEM = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP__TARGET = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unlink Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP___ALL_OWNED_ELEMENTS = IMPERATIVE_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP___GET_VALUE__TYPE_STRING = IMPERATIVE_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = IMPERATIVE_EXPRESSION___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP___ACCEPT__IMPERATIVEOCLVISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP___ACCEPT__VISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Unlink Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLINK_EXP_OPERATION_COUNT = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.UnpackExpImpl <em>Unpack Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.UnpackExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getUnpackExp()
	 * @generated
	 */
	int UNPACK_EXP = 28;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP__EXTENSION = IMPERATIVE_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP__OWNED_RULE = IMPERATIVE_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP__IS_STATIC = IMPERATIVE_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP__OWNED_ANNOTATION = IMPERATIVE_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP__IS_REQUIRED = IMPERATIVE_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP__SOURCE = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Variable</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP__TARGET_VARIABLE = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unpack Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP___ALL_OWNED_ELEMENTS = IMPERATIVE_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP___GET_VALUE__TYPE_STRING = IMPERATIVE_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = IMPERATIVE_EXPRESSION___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP___ACCEPT__IMPERATIVEOCLVISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP___ACCEPT__VISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Unpack Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_EXP_OPERATION_COUNT = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.VariableInitExpImpl <em>Variable Init Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.VariableInitExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getVariableInitExp()
	 * @generated
	 */
	int VARIABLE_INIT_EXP = 29;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP__EXTENSION = IMPERATIVE_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP__OWNED_RULE = IMPERATIVE_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP__IS_STATIC = IMPERATIVE_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP__OWNED_ANNOTATION = IMPERATIVE_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP__IS_REQUIRED = IMPERATIVE_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Referred Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP__REFERRED_VARIABLE = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>With Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP__WITH_RESULT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable Init Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP___ALL_OWNED_ELEMENTS = IMPERATIVE_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP___GET_VALUE__TYPE_STRING = IMPERATIVE_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = IMPERATIVE_EXPRESSION___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP___ACCEPT__IMPERATIVEOCLVISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP___ACCEPT__VISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Variable Init Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INIT_EXP_OPERATION_COUNT = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.WhileExpImpl <em>While Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.WhileExpImpl
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getWhileExp()
	 * @generated
	 */
	int WHILE_EXP = 30;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP__OWNED_COMMENT = IMPERATIVE_EXPRESSION__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP__EXTENSION = IMPERATIVE_EXPRESSION__EXTENSION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP__NAME = IMPERATIVE_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP__OWNED_RULE = IMPERATIVE_EXPRESSION__OWNED_RULE;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP__IS_STATIC = IMPERATIVE_EXPRESSION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP__OWNED_ANNOTATION = IMPERATIVE_EXPRESSION__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP__TYPE = IMPERATIVE_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP__IS_REQUIRED = IMPERATIVE_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP__BODY = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP__CONDITION = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>While Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_FEATURE_COUNT = IMPERATIVE_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP___ALL_OWNED_ELEMENTS = IMPERATIVE_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP___GET_VALUE__TYPE_STRING = IMPERATIVE_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Not Own Self</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP = IMPERATIVE_EXPRESSION___VALIDATE_NOT_OWN_SELF__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP___ACCEPT__IMPERATIVEOCLVISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP___ACCEPT__VISITOR = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>While Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_EXP_OPERATION_COUNT = IMPERATIVE_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor <em>Visitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getImperativeOCLVisitor()
	 * @generated
	 */
	int IMPERATIVE_OCL_VISITOR = 31;

	/**
	 * The number of structural features of the '<em>Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OCL_VISITOR_FEATURE_COUNT = PivotPackage.VISITOR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_OCL_VISITOR_OPERATION_COUNT = PivotPackage.VISITOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.SeverityKind <em>Severity Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.SeverityKind
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getSeverityKind()
	 * @generated
	 */
	int SEVERITY_KIND = 32;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AltExp <em>Alt Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alt Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.AltExp
	 * @generated
	 */
	EClass getAltExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AltExp#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.AltExp#getBody()
	 * @see #getAltExp()
	 * @generated
	 */
	EReference getAltExp_Body();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AltExp#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.AltExp#getCondition()
	 * @see #getAltExp()
	 * @generated
	 */
	EReference getAltExp_Condition();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AltExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.AltExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getAltExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AltExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.AltExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getAltExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp <em>Assert Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assert Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp
	 * @generated
	 */
	EClass getAssertExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp#getAssertion <em>Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Assertion</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp#getAssertion()
	 * @see #getAssertExp()
	 * @generated
	 */
	EReference getAssertExp_Assertion();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp#getLog <em>Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Log</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp#getLog()
	 * @see #getAssertExp()
	 * @generated
	 */
	EReference getAssertExp_Log();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp#getSeverity()
	 * @see #getAssertExp()
	 * @generated
	 */
	EAttribute getAssertExp_Severity();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getAssertExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getAssertExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp <em>Assign Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assign Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp
	 * @generated
	 */
	EClass getAssignExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Value</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp#getDefaultValue()
	 * @see #getAssignExp()
	 * @generated
	 */
	EReference getAssignExp_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp#isIsReset <em>Is Reset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Reset</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp#isIsReset()
	 * @see #getAssignExp()
	 * @generated
	 */
	EAttribute getAssignExp_IsReset();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp#getLeft()
	 * @see #getAssignExp()
	 * @generated
	 */
	EReference getAssignExp_Left();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp#getValue()
	 * @see #getAssignExp()
	 * @generated
	 */
	EReference getAssignExp_Value();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getAssignExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getAssignExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp <em>Block Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp
	 * @generated
	 */
	EClass getBlockExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Body</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp#getBody()
	 * @see #getBlockExp()
	 * @generated
	 */
	EReference getBlockExp_Body();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getBlockExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getBlockExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp <em>Break Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Break Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp
	 * @generated
	 */
	EClass getBreakExp();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getBreakExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getBreakExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp <em>Catch Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catch Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp
	 * @generated
	 */
	EClass getCatchExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Body</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp#getBody()
	 * @see #getCatchExp()
	 * @generated
	 */
	EReference getCatchExp_Body();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Exception</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp#getException()
	 * @see #getCatchExp()
	 * @generated
	 */
	EReference getCatchExp_Exception();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getCatchExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getCatchExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp <em>Compute Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compute Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp
	 * @generated
	 */
	EClass getComputeExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp#getBody()
	 * @see #getComputeExp()
	 * @generated
	 */
	EReference getComputeExp_Body();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp#getReturnedElement <em>Returned Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Returned Element</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp#getReturnedElement()
	 * @see #getComputeExp()
	 * @generated
	 */
	EReference getComputeExp_ReturnedElement();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getComputeExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getComputeExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ContinueExp <em>Continue Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Continue Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ContinueExp
	 * @generated
	 */
	EClass getContinueExp();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ContinueExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ContinueExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getContinueExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ContinueExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ContinueExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getContinueExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp <em>Dict Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dict Literal Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp
	 * @generated
	 */
	EClass getDictLiteralExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Part</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp#getPart()
	 * @see #getDictLiteralExp()
	 * @generated
	 */
	EReference getDictLiteralExp_Part();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getDictLiteralExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getDictLiteralExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart <em>Dict Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dict Literal Part</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart
	 * @generated
	 */
	EClass getDictLiteralPart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Key</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart#getKey()
	 * @see #getDictLiteralPart()
	 * @generated
	 */
	EReference getDictLiteralPart_Key();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart#getValue()
	 * @see #getDictLiteralPart()
	 * @generated
	 */
	EReference getDictLiteralPart_Value();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getDictLiteralPart__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getDictLiteralPart__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.DictionaryType <em>Dictionary Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dictionary Type</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.DictionaryType
	 * @generated
	 */
	EClass getDictionaryType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.DictionaryType#getKeyType <em>Key Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key Type</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.DictionaryType#getKeyType()
	 * @see #getDictionaryType()
	 * @generated
	 */
	EReference getDictionaryType_KeyType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.DictionaryType#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.DictionaryType#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getDictionaryType__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.DictionaryType#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.DictionaryType#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getDictionaryType__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ForExp <em>For Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ForExp
	 * @generated
	 */
	EClass getForExp();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ForExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ForExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getForExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ForExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ForExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getForExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeExpression <em>Imperative Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Expression</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeExpression
	 * @generated
	 */
	EClass getImperativeExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp <em>Imperative Iterate Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Iterate Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp
	 * @generated
	 */
	EClass getImperativeIterateExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp#getTarget()
	 * @see #getImperativeIterateExp()
	 * @generated
	 */
	EReference getImperativeIterateExp_Target();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getImperativeIterateExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getImperativeIterateExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeLoopExp <em>Imperative Loop Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Loop Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeLoopExp
	 * @generated
	 */
	EClass getImperativeLoopExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeLoopExp#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeLoopExp#getCondition()
	 * @see #getImperativeLoopExp()
	 * @generated
	 */
	EReference getImperativeLoopExp_Condition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp <em>Instantiation Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instantiation Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp
	 * @generated
	 */
	EClass getInstantiationExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Argument</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp#getArgument()
	 * @see #getInstantiationExp()
	 * @generated
	 */
	EReference getInstantiationExp_Argument();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp#getExtent <em>Extent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extent</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp#getExtent()
	 * @see #getInstantiationExp()
	 * @generated
	 */
	EReference getInstantiationExp_Extent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp#getInstantiatedClass <em>Instantiated Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instantiated Class</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp#getInstantiatedClass()
	 * @see #getInstantiationExp()
	 * @generated
	 */
	EReference getInstantiationExp_InstantiatedClass();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getInstantiationExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getInstantiationExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ListLiteralExp <em>List Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Literal Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ListLiteralExp
	 * @generated
	 */
	EClass getListLiteralExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ListLiteralExp#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ListLiteralExp#getElement()
	 * @see #getListLiteralExp()
	 * @generated
	 */
	EReference getListLiteralExp_Element();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ListLiteralExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ListLiteralExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getListLiteralExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ListLiteralExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ListLiteralExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getListLiteralExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ListType <em>List Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Type</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ListType
	 * @generated
	 */
	EClass getListType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ListType#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ListType#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getListType__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ListType#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ListType#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getListType__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.LogExp <em>Log Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Log Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.LogExp
	 * @generated
	 */
	EClass getLogExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.LogExp#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.LogExp#getCondition()
	 * @see #getLogExp()
	 * @generated
	 */
	EReference getLogExp_Condition();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.LogExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.LogExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getLogExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.LogExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.LogExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getLogExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp <em>Ordered Tuple Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Tuple Literal Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp
	 * @generated
	 */
	EClass getOrderedTupleLiteralExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Part</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp#getPart()
	 * @see #getOrderedTupleLiteralExp()
	 * @generated
	 */
	EReference getOrderedTupleLiteralExp_Part();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getOrderedTupleLiteralExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getOrderedTupleLiteralExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart <em>Ordered Tuple Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Tuple Literal Part</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart
	 * @generated
	 */
	EClass getOrderedTupleLiteralPart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart#getValue()
	 * @see #getOrderedTupleLiteralPart()
	 * @generated
	 */
	EReference getOrderedTupleLiteralPart_Value();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getOrderedTupleLiteralPart__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getOrderedTupleLiteralPart__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType <em>Ordered Tuple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Tuple Type</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType
	 * @generated
	 */
	EClass getOrderedTupleType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Element Type</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType#getElementType()
	 * @see #getOrderedTupleType()
	 * @generated
	 */
	EReference getOrderedTupleType_ElementType();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getOrderedTupleType__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getOrderedTupleType__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp <em>Raise Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Raise Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp
	 * @generated
	 */
	EClass getRaiseExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Argument</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp#getArgument()
	 * @see #getRaiseExp()
	 * @generated
	 */
	EReference getRaiseExp_Argument();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Exception</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp#getException()
	 * @see #getRaiseExp()
	 * @generated
	 */
	EReference getRaiseExp_Exception();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getRaiseExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getRaiseExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp <em>Return Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Return Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp
	 * @generated
	 */
	EClass getReturnExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp#getValue()
	 * @see #getReturnExp()
	 * @generated
	 */
	EReference getReturnExp_Value();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getReturnExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getReturnExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp <em>Switch Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp
	 * @generated
	 */
	EClass getSwitchExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp#getAlternativePart <em>Alternative Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Alternative Part</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp#getAlternativePart()
	 * @see #getSwitchExp()
	 * @generated
	 */
	EReference getSwitchExp_AlternativePart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp#getElsePart <em>Else Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Part</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp#getElsePart()
	 * @see #getSwitchExp()
	 * @generated
	 */
	EReference getSwitchExp_ElsePart();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getSwitchExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getSwitchExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.TryExp <em>Try Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Try Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.TryExp
	 * @generated
	 */
	EClass getTryExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.pivot.imperativeocl.TryExp#getExceptClause <em>Except Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Except Clause</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.TryExp#getExceptClause()
	 * @see #getTryExp()
	 * @generated
	 */
	EReference getTryExp_ExceptClause();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvto.examples.pivot.imperativeocl.TryExp#getTryBody <em>Try Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Try Body</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.TryExp#getTryBody()
	 * @see #getTryExp()
	 * @generated
	 */
	EReference getTryExp_TryBody();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.TryExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.TryExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getTryExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.TryExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.TryExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getTryExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.Typedef <em>Typedef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typedef</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.Typedef
	 * @generated
	 */
	EClass getTypedef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.Typedef#getBase <em>Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.Typedef#getBase()
	 * @see #getTypedef()
	 * @generated
	 */
	EReference getTypedef_Base();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.Typedef#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.Typedef#getCondition()
	 * @see #getTypedef()
	 * @generated
	 */
	EReference getTypedef_Condition();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.Typedef#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.Typedef#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getTypedef__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.Typedef#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.Typedef#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getTypedef__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp <em>Unlink Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unlink Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp
	 * @generated
	 */
	EClass getUnlinkExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Item</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp#getItem()
	 * @see #getUnlinkExp()
	 * @generated
	 */
	EReference getUnlinkExp_Item();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp#getTarget()
	 * @see #getUnlinkExp()
	 * @generated
	 */
	EReference getUnlinkExp_Target();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getUnlinkExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getUnlinkExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp <em>Unpack Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unpack Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp
	 * @generated
	 */
	EClass getUnpackExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp#getSource()
	 * @see #getUnpackExp()
	 * @generated
	 */
	EReference getUnpackExp_Source();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp#getTargetVariable <em>Target Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Variable</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp#getTargetVariable()
	 * @see #getUnpackExp()
	 * @generated
	 */
	EReference getUnpackExp_TargetVariable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getUnpackExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getUnpackExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp <em>Variable Init Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Init Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp
	 * @generated
	 */
	EClass getVariableInitExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp#getReferredVariable <em>Referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Referred Variable</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp#getReferredVariable()
	 * @see #getVariableInitExp()
	 * @generated
	 */
	EReference getVariableInitExp_ReferredVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp#isWithResult <em>With Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>With Result</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp#isWithResult()
	 * @see #getVariableInitExp()
	 * @generated
	 */
	EAttribute getVariableInitExp_WithResult();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getVariableInitExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getVariableInitExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp <em>While Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While Exp</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp
	 * @generated
	 */
	EClass getWhileExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp#getBody()
	 * @see #getWhileExp()
	 * @generated
	 */
	EReference getWhileExp_Body();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp#getCondition()
	 * @see #getWhileExp()
	 * @generated
	 */
	EReference getWhileExp_Condition();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp#accept(org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor)
	 * @generated
	 */
	EOperation getWhileExp__Accept__ImperativeOCLVisitor();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp#accept(org.eclipse.ocl.examples.pivot.util.Visitor)
	 * @generated
	 */
	EOperation getWhileExp__Accept__Visitor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor <em>Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitor</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor
	 * @model instanceClass="org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor" typeParameters="R" superTypes="org.eclipse.ocl.examples.pivot.Visitor<R>"
	 * @generated
	 */
	EClass getImperativeOCLVisitor();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvto.examples.pivot.imperativeocl.SeverityKind <em>Severity Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Severity Kind</em>'.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.SeverityKind
	 * @generated
	 */
	EEnum getSeverityKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ImperativeOCLFactory getImperativeOCLFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.AltExpImpl <em>Alt Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.AltExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getAltExp()
		 * @generated
		 */
		EClass ALT_EXP = eINSTANCE.getAltExp();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALT_EXP__BODY = eINSTANCE.getAltExp_Body();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALT_EXP__CONDITION = eINSTANCE.getAltExp_Condition();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALT_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getAltExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALT_EXP___ACCEPT__VISITOR = eINSTANCE.getAltExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.AssertExpImpl <em>Assert Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.AssertExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getAssertExp()
		 * @generated
		 */
		EClass ASSERT_EXP = eINSTANCE.getAssertExp();

		/**
		 * The meta object literal for the '<em><b>Assertion</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSERT_EXP__ASSERTION = eINSTANCE.getAssertExp_Assertion();

		/**
		 * The meta object literal for the '<em><b>Log</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSERT_EXP__LOG = eINSTANCE.getAssertExp_Log();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERT_EXP__SEVERITY = eINSTANCE.getAssertExp_Severity();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ASSERT_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getAssertExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ASSERT_EXP___ACCEPT__VISITOR = eINSTANCE.getAssertExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.AssignExpImpl <em>Assign Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.AssignExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getAssignExp()
		 * @generated
		 */
		EClass ASSIGN_EXP = eINSTANCE.getAssignExp();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN_EXP__DEFAULT_VALUE = eINSTANCE.getAssignExp_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Is Reset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGN_EXP__IS_RESET = eINSTANCE.getAssignExp_IsReset();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN_EXP__LEFT = eINSTANCE.getAssignExp_Left();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGN_EXP__VALUE = eINSTANCE.getAssignExp_Value();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ASSIGN_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getAssignExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ASSIGN_EXP___ACCEPT__VISITOR = eINSTANCE.getAssignExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.BlockExpImpl <em>Block Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.BlockExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getBlockExp()
		 * @generated
		 */
		EClass BLOCK_EXP = eINSTANCE.getBlockExp();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_EXP__BODY = eINSTANCE.getBlockExp_Body();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BLOCK_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getBlockExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BLOCK_EXP___ACCEPT__VISITOR = eINSTANCE.getBlockExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.BreakExpImpl <em>Break Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.BreakExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getBreakExp()
		 * @generated
		 */
		EClass BREAK_EXP = eINSTANCE.getBreakExp();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BREAK_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getBreakExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BREAK_EXP___ACCEPT__VISITOR = eINSTANCE.getBreakExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.CatchExpImpl <em>Catch Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.CatchExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getCatchExp()
		 * @generated
		 */
		EClass CATCH_EXP = eINSTANCE.getCatchExp();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATCH_EXP__BODY = eINSTANCE.getCatchExp_Body();

		/**
		 * The meta object literal for the '<em><b>Exception</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATCH_EXP__EXCEPTION = eINSTANCE.getCatchExp_Exception();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CATCH_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getCatchExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CATCH_EXP___ACCEPT__VISITOR = eINSTANCE.getCatchExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.ComputeExpImpl <em>Compute Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ComputeExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getComputeExp()
		 * @generated
		 */
		EClass COMPUTE_EXP = eINSTANCE.getComputeExp();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTE_EXP__BODY = eINSTANCE.getComputeExp_Body();

		/**
		 * The meta object literal for the '<em><b>Returned Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTE_EXP__RETURNED_ELEMENT = eINSTANCE.getComputeExp_ReturnedElement();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPUTE_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getComputeExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMPUTE_EXP___ACCEPT__VISITOR = eINSTANCE.getComputeExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.ContinueExpImpl <em>Continue Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ContinueExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getContinueExp()
		 * @generated
		 */
		EClass CONTINUE_EXP = eINSTANCE.getContinueExp();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTINUE_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getContinueExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTINUE_EXP___ACCEPT__VISITOR = eINSTANCE.getContinueExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.DictLiteralExpImpl <em>Dict Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.DictLiteralExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getDictLiteralExp()
		 * @generated
		 */
		EClass DICT_LITERAL_EXP = eINSTANCE.getDictLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DICT_LITERAL_EXP__PART = eINSTANCE.getDictLiteralExp_Part();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DICT_LITERAL_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getDictLiteralExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DICT_LITERAL_EXP___ACCEPT__VISITOR = eINSTANCE.getDictLiteralExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.DictLiteralPartImpl <em>Dict Literal Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.DictLiteralPartImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getDictLiteralPart()
		 * @generated
		 */
		EClass DICT_LITERAL_PART = eINSTANCE.getDictLiteralPart();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DICT_LITERAL_PART__KEY = eINSTANCE.getDictLiteralPart_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DICT_LITERAL_PART__VALUE = eINSTANCE.getDictLiteralPart_Value();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DICT_LITERAL_PART___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getDictLiteralPart__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DICT_LITERAL_PART___ACCEPT__VISITOR = eINSTANCE.getDictLiteralPart__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.DictionaryTypeImpl <em>Dictionary Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.DictionaryTypeImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getDictionaryType()
		 * @generated
		 */
		EClass DICTIONARY_TYPE = eINSTANCE.getDictionaryType();

		/**
		 * The meta object literal for the '<em><b>Key Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DICTIONARY_TYPE__KEY_TYPE = eINSTANCE.getDictionaryType_KeyType();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DICTIONARY_TYPE___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getDictionaryType__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DICTIONARY_TYPE___ACCEPT__VISITOR = eINSTANCE.getDictionaryType__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.ForExpImpl <em>For Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ForExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getForExp()
		 * @generated
		 */
		EClass FOR_EXP = eINSTANCE.getForExp();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FOR_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getForExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FOR_EXP___ACCEPT__VISITOR = eINSTANCE.getForExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeExpressionImpl <em>Imperative Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeExpressionImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getImperativeExpression()
		 * @generated
		 */
		EClass IMPERATIVE_EXPRESSION = eINSTANCE.getImperativeExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeIterateExpImpl <em>Imperative Iterate Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeIterateExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getImperativeIterateExp()
		 * @generated
		 */
		EClass IMPERATIVE_ITERATE_EXP = eINSTANCE.getImperativeIterateExp();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPERATIVE_ITERATE_EXP__TARGET = eINSTANCE.getImperativeIterateExp_Target();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IMPERATIVE_ITERATE_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getImperativeIterateExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IMPERATIVE_ITERATE_EXP___ACCEPT__VISITOR = eINSTANCE.getImperativeIterateExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeLoopExpImpl <em>Imperative Loop Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeLoopExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getImperativeLoopExp()
		 * @generated
		 */
		EClass IMPERATIVE_LOOP_EXP = eINSTANCE.getImperativeLoopExp();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPERATIVE_LOOP_EXP__CONDITION = eINSTANCE.getImperativeLoopExp_Condition();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.InstantiationExpImpl <em>Instantiation Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.InstantiationExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getInstantiationExp()
		 * @generated
		 */
		EClass INSTANTIATION_EXP = eINSTANCE.getInstantiationExp();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANTIATION_EXP__ARGUMENT = eINSTANCE.getInstantiationExp_Argument();

		/**
		 * The meta object literal for the '<em><b>Extent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANTIATION_EXP__EXTENT = eINSTANCE.getInstantiationExp_Extent();

		/**
		 * The meta object literal for the '<em><b>Instantiated Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANTIATION_EXP__INSTANTIATED_CLASS = eINSTANCE.getInstantiationExp_InstantiatedClass();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INSTANTIATION_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getInstantiationExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INSTANTIATION_EXP___ACCEPT__VISITOR = eINSTANCE.getInstantiationExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.ListLiteralExpImpl <em>List Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ListLiteralExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getListLiteralExp()
		 * @generated
		 */
		EClass LIST_LITERAL_EXP = eINSTANCE.getListLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIST_LITERAL_EXP__ELEMENT = eINSTANCE.getListLiteralExp_Element();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LIST_LITERAL_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getListLiteralExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LIST_LITERAL_EXP___ACCEPT__VISITOR = eINSTANCE.getListLiteralExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.ListTypeImpl <em>List Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ListTypeImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getListType()
		 * @generated
		 */
		EClass LIST_TYPE = eINSTANCE.getListType();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LIST_TYPE___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getListType__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LIST_TYPE___ACCEPT__VISITOR = eINSTANCE.getListType__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.LogExpImpl <em>Log Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.LogExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getLogExp()
		 * @generated
		 */
		EClass LOG_EXP = eINSTANCE.getLogExp();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOG_EXP__CONDITION = eINSTANCE.getLogExp_Condition();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOG_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getLogExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOG_EXP___ACCEPT__VISITOR = eINSTANCE.getLogExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.OrderedTupleLiteralExpImpl <em>Ordered Tuple Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.OrderedTupleLiteralExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getOrderedTupleLiteralExp()
		 * @generated
		 */
		EClass ORDERED_TUPLE_LITERAL_EXP = eINSTANCE.getOrderedTupleLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDERED_TUPLE_LITERAL_EXP__PART = eINSTANCE.getOrderedTupleLiteralExp_Part();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ORDERED_TUPLE_LITERAL_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getOrderedTupleLiteralExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ORDERED_TUPLE_LITERAL_EXP___ACCEPT__VISITOR = eINSTANCE.getOrderedTupleLiteralExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.OrderedTupleLiteralPartImpl <em>Ordered Tuple Literal Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.OrderedTupleLiteralPartImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getOrderedTupleLiteralPart()
		 * @generated
		 */
		EClass ORDERED_TUPLE_LITERAL_PART = eINSTANCE.getOrderedTupleLiteralPart();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDERED_TUPLE_LITERAL_PART__VALUE = eINSTANCE.getOrderedTupleLiteralPart_Value();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ORDERED_TUPLE_LITERAL_PART___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getOrderedTupleLiteralPart__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ORDERED_TUPLE_LITERAL_PART___ACCEPT__VISITOR = eINSTANCE.getOrderedTupleLiteralPart__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.OrderedTupleTypeImpl <em>Ordered Tuple Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.OrderedTupleTypeImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getOrderedTupleType()
		 * @generated
		 */
		EClass ORDERED_TUPLE_TYPE = eINSTANCE.getOrderedTupleType();

		/**
		 * The meta object literal for the '<em><b>Element Type</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDERED_TUPLE_TYPE__ELEMENT_TYPE = eINSTANCE.getOrderedTupleType_ElementType();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ORDERED_TUPLE_TYPE___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getOrderedTupleType__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ORDERED_TUPLE_TYPE___ACCEPT__VISITOR = eINSTANCE.getOrderedTupleType__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.RaiseExpImpl <em>Raise Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.RaiseExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getRaiseExp()
		 * @generated
		 */
		EClass RAISE_EXP = eINSTANCE.getRaiseExp();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RAISE_EXP__ARGUMENT = eINSTANCE.getRaiseExp_Argument();

		/**
		 * The meta object literal for the '<em><b>Exception</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RAISE_EXP__EXCEPTION = eINSTANCE.getRaiseExp_Exception();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RAISE_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getRaiseExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RAISE_EXP___ACCEPT__VISITOR = eINSTANCE.getRaiseExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.ReturnExpImpl <em>Return Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ReturnExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getReturnExp()
		 * @generated
		 */
		EClass RETURN_EXP = eINSTANCE.getReturnExp();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RETURN_EXP__VALUE = eINSTANCE.getReturnExp_Value();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RETURN_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getReturnExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RETURN_EXP___ACCEPT__VISITOR = eINSTANCE.getReturnExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.SwitchExpImpl <em>Switch Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.SwitchExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getSwitchExp()
		 * @generated
		 */
		EClass SWITCH_EXP = eINSTANCE.getSwitchExp();

		/**
		 * The meta object literal for the '<em><b>Alternative Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_EXP__ALTERNATIVE_PART = eINSTANCE.getSwitchExp_AlternativePart();

		/**
		 * The meta object literal for the '<em><b>Else Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_EXP__ELSE_PART = eINSTANCE.getSwitchExp_ElsePart();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SWITCH_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getSwitchExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SWITCH_EXP___ACCEPT__VISITOR = eINSTANCE.getSwitchExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.TryExpImpl <em>Try Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.TryExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getTryExp()
		 * @generated
		 */
		EClass TRY_EXP = eINSTANCE.getTryExp();

		/**
		 * The meta object literal for the '<em><b>Except Clause</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRY_EXP__EXCEPT_CLAUSE = eINSTANCE.getTryExp_ExceptClause();

		/**
		 * The meta object literal for the '<em><b>Try Body</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRY_EXP__TRY_BODY = eINSTANCE.getTryExp_TryBody();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TRY_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getTryExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TRY_EXP___ACCEPT__VISITOR = eINSTANCE.getTryExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.TypedefImpl <em>Typedef</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.TypedefImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getTypedef()
		 * @generated
		 */
		EClass TYPEDEF = eINSTANCE.getTypedef();

		/**
		 * The meta object literal for the '<em><b>Base</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPEDEF__BASE = eINSTANCE.getTypedef_Base();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPEDEF__CONDITION = eINSTANCE.getTypedef_Condition();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPEDEF___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getTypedef__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPEDEF___ACCEPT__VISITOR = eINSTANCE.getTypedef__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.UnlinkExpImpl <em>Unlink Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.UnlinkExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getUnlinkExp()
		 * @generated
		 */
		EClass UNLINK_EXP = eINSTANCE.getUnlinkExp();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNLINK_EXP__ITEM = eINSTANCE.getUnlinkExp_Item();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNLINK_EXP__TARGET = eINSTANCE.getUnlinkExp_Target();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation UNLINK_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getUnlinkExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation UNLINK_EXP___ACCEPT__VISITOR = eINSTANCE.getUnlinkExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.UnpackExpImpl <em>Unpack Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.UnpackExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getUnpackExp()
		 * @generated
		 */
		EClass UNPACK_EXP = eINSTANCE.getUnpackExp();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNPACK_EXP__SOURCE = eINSTANCE.getUnpackExp_Source();

		/**
		 * The meta object literal for the '<em><b>Target Variable</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNPACK_EXP__TARGET_VARIABLE = eINSTANCE.getUnpackExp_TargetVariable();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation UNPACK_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getUnpackExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation UNPACK_EXP___ACCEPT__VISITOR = eINSTANCE.getUnpackExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.VariableInitExpImpl <em>Variable Init Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.VariableInitExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getVariableInitExp()
		 * @generated
		 */
		EClass VARIABLE_INIT_EXP = eINSTANCE.getVariableInitExp();

		/**
		 * The meta object literal for the '<em><b>Referred Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_INIT_EXP__REFERRED_VARIABLE = eINSTANCE.getVariableInitExp_ReferredVariable();

		/**
		 * The meta object literal for the '<em><b>With Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_INIT_EXP__WITH_RESULT = eINSTANCE.getVariableInitExp_WithResult();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VARIABLE_INIT_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getVariableInitExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VARIABLE_INIT_EXP___ACCEPT__VISITOR = eINSTANCE.getVariableInitExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.WhileExpImpl <em>While Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.WhileExpImpl
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getWhileExp()
		 * @generated
		 */
		EClass WHILE_EXP = eINSTANCE.getWhileExp();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE_EXP__BODY = eINSTANCE.getWhileExp_Body();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE_EXP__CONDITION = eINSTANCE.getWhileExp_Condition();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation WHILE_EXP___ACCEPT__IMPERATIVEOCLVISITOR = eINSTANCE.getWhileExp__Accept__ImperativeOCLVisitor();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation WHILE_EXP___ACCEPT__VISITOR = eINSTANCE.getWhileExp__Accept__Visitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor <em>Visitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getImperativeOCLVisitor()
		 * @generated
		 */
		EClass IMPERATIVE_OCL_VISITOR = eINSTANCE.getImperativeOCLVisitor();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.SeverityKind <em>Severity Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.SeverityKind
		 * @see org.eclipse.qvto.examples.pivot.imperativeocl.impl.ImperativeOCLPackageImpl#getSeverityKind()
		 * @generated
		 */
		EEnum SEVERITY_KIND = eINSTANCE.getSeverityKind();

	}

} //ImperativeOCLPackage
