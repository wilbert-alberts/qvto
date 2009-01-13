/**
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *
 * $Id: ImperativeOCLPackageImpl.java,v 1.2 2009/01/13 16:51:21 radvorak Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.expressions.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.m2m.internal.qvt.oml.expressions.AltExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.AssertExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.AssignExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.BlockExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ComputeExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.DictLiteralExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.DictLiteralPart;
import org.eclipse.m2m.internal.qvt.oml.expressions.DictionaryType;
import org.eclipse.m2m.internal.qvt.oml.expressions.ForExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeExpression;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeIterateExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeLoopExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOCLFactory;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOCLPackage;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOCLVisitor;
import org.eclipse.m2m.internal.qvt.oml.expressions.InstantiationExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ListType;
import org.eclipse.m2m.internal.qvt.oml.expressions.LogExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ReturnExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.SeverityKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.SwitchExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.TemplateParameterType;
import org.eclipse.m2m.internal.qvt.oml.expressions.Typedef;
import org.eclipse.m2m.internal.qvt.oml.expressions.VariableInitExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.WhileExp;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.utilities.UtilitiesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImperativeOCLPackageImpl extends EPackageImpl implements ImperativeOCLPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeOCLVisitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dictLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dictLiteralPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateParameterTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dictionaryTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableInitExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whileExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass altExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assertExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instantiationExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass returnExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeLoopExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeIterateExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computeExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum severityKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOCLPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ImperativeOCLPackageImpl() {
		super(eNS_URI, ImperativeOCLFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ImperativeOCLPackage init() {
		if (isInited) return (ImperativeOCLPackage)EPackage.Registry.INSTANCE.getEPackage(ImperativeOCLPackage.eNS_URI);

		// Obtain or create and register package
		ImperativeOCLPackageImpl theImperativeOCLPackage = (ImperativeOCLPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ImperativeOCLPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ImperativeOCLPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theImperativeOCLPackage.createPackageContents();

		// Initialize created meta-data
		theImperativeOCLPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theImperativeOCLPackage.freeze();

		return theImperativeOCLPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImperativeOCLVisitor() {
		return imperativeOCLVisitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListType() {
		return listTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDictLiteralExp() {
		return dictLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDictLiteralExp_Part() {
		return (EReference)dictLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDictLiteralPart() {
		return dictLiteralPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDictLiteralPart_Key() {
		return (EReference)dictLiteralPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDictLiteralPart_Value() {
		return (EReference)dictLiteralPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateParameterType() {
		return templateParameterTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplateParameterType_Specification() {
		return (EAttribute)templateParameterTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDictionaryType() {
		return dictionaryTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDictionaryType_KeyType() {
		return (EReference)dictionaryTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedef() {
		return typedefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedef_Base() {
		return (EReference)typedefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedef_Condition() {
		return (EReference)typedefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignExp() {
		return assignExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignExp_DefaultValue() {
		return (EReference)assignExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignExp_Value() {
		return (EReference)assignExpEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignExp_Left() {
		return (EReference)assignExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignExp_IsReset() {
		return (EAttribute)assignExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableInitExp() {
		return variableInitExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableInitExp_ReferredVariable() {
		return (EReference)variableInitExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableInitExp_WithResult() {
		return (EAttribute)variableInitExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhileExp() {
		return whileExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileExp_Condition() {
		return (EReference)whileExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileExp_Body() {
		return (EReference)whileExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchExp() {
		return switchExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchExp_AlternativePart() {
		return (EReference)switchExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchExp_ElsePart() {
		return (EReference)switchExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAltExp() {
		return altExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAltExp_Condition() {
		return (EReference)altExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAltExp_Body() {
		return (EReference)altExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogExp() {
		return logExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogExp_Condition() {
		return (EReference)logExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssertExp() {
		return assertExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssertExp_Assertion() {
		return (EReference)assertExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssertExp_Log() {
		return (EReference)assertExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertExp_Severity() {
		return (EAttribute)assertExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstantiationExp() {
		return instantiationExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstantiationExp_Argument() {
		return (EReference)instantiationExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstantiationExp_Extent() {
		return (EReference)instantiationExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstantiationExp_InstantiatedClass() {
		return (EReference)instantiationExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReturnExp() {
		return returnExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReturnExp_Value() {
		return (EReference)returnExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImperativeLoopExp() {
		return imperativeLoopExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImperativeLoopExp_Condition() {
		return (EReference)imperativeLoopExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForExp() {
		return forExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImperativeIterateExp() {
		return imperativeIterateExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImperativeIterateExp_Target() {
		return (EReference)imperativeIterateExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockExp() {
		return blockExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockExp_Body() {
		return (EReference)blockExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputeExp() {
		return computeExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputeExp_ReturnedElement() {
		return (EReference)computeExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputeExp_Body() {
		return (EReference)computeExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImperativeExpression() {
		return imperativeExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSeverityKind() {
		return severityKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeOCLFactory getImperativeOCLFactory() {
		return (ImperativeOCLFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		altExpEClass = createEClass(ALT_EXP);
		createEReference(altExpEClass, ALT_EXP__CONDITION);
		createEReference(altExpEClass, ALT_EXP__BODY);

		assertExpEClass = createEClass(ASSERT_EXP);
		createEReference(assertExpEClass, ASSERT_EXP__ASSERTION);
		createEReference(assertExpEClass, ASSERT_EXP__LOG);
		createEAttribute(assertExpEClass, ASSERT_EXP__SEVERITY);

		assignExpEClass = createEClass(ASSIGN_EXP);
		createEReference(assignExpEClass, ASSIGN_EXP__DEFAULT_VALUE);
		createEAttribute(assignExpEClass, ASSIGN_EXP__IS_RESET);
		createEReference(assignExpEClass, ASSIGN_EXP__LEFT);
		createEReference(assignExpEClass, ASSIGN_EXP__VALUE);

		blockExpEClass = createEClass(BLOCK_EXP);
		createEReference(blockExpEClass, BLOCK_EXP__BODY);

		computeExpEClass = createEClass(COMPUTE_EXP);
		createEReference(computeExpEClass, COMPUTE_EXP__BODY);
		createEReference(computeExpEClass, COMPUTE_EXP__RETURNED_ELEMENT);

		dictLiteralExpEClass = createEClass(DICT_LITERAL_EXP);
		createEReference(dictLiteralExpEClass, DICT_LITERAL_EXP__PART);

		dictLiteralPartEClass = createEClass(DICT_LITERAL_PART);
		createEReference(dictLiteralPartEClass, DICT_LITERAL_PART__KEY);
		createEReference(dictLiteralPartEClass, DICT_LITERAL_PART__VALUE);

		dictionaryTypeEClass = createEClass(DICTIONARY_TYPE);
		createEReference(dictionaryTypeEClass, DICTIONARY_TYPE__KEY_TYPE);

		forExpEClass = createEClass(FOR_EXP);

		imperativeExpressionEClass = createEClass(IMPERATIVE_EXPRESSION);

		imperativeIterateExpEClass = createEClass(IMPERATIVE_ITERATE_EXP);
		createEReference(imperativeIterateExpEClass, IMPERATIVE_ITERATE_EXP__TARGET);

		imperativeLoopExpEClass = createEClass(IMPERATIVE_LOOP_EXP);
		createEReference(imperativeLoopExpEClass, IMPERATIVE_LOOP_EXP__CONDITION);

		instantiationExpEClass = createEClass(INSTANTIATION_EXP);
		createEReference(instantiationExpEClass, INSTANTIATION_EXP__ARGUMENT);
		createEReference(instantiationExpEClass, INSTANTIATION_EXP__EXTENT);
		createEReference(instantiationExpEClass, INSTANTIATION_EXP__INSTANTIATED_CLASS);

		listTypeEClass = createEClass(LIST_TYPE);

		logExpEClass = createEClass(LOG_EXP);
		createEReference(logExpEClass, LOG_EXP__CONDITION);

		returnExpEClass = createEClass(RETURN_EXP);
		createEReference(returnExpEClass, RETURN_EXP__VALUE);

		switchExpEClass = createEClass(SWITCH_EXP);
		createEReference(switchExpEClass, SWITCH_EXP__ALTERNATIVE_PART);
		createEReference(switchExpEClass, SWITCH_EXP__ELSE_PART);

		templateParameterTypeEClass = createEClass(TEMPLATE_PARAMETER_TYPE);
		createEAttribute(templateParameterTypeEClass, TEMPLATE_PARAMETER_TYPE__SPECIFICATION);

		typedefEClass = createEClass(TYPEDEF);
		createEReference(typedefEClass, TYPEDEF__BASE);
		createEReference(typedefEClass, TYPEDEF__CONDITION);

		variableInitExpEClass = createEClass(VARIABLE_INIT_EXP);
		createEReference(variableInitExpEClass, VARIABLE_INIT_EXP__REFERRED_VARIABLE);
		createEAttribute(variableInitExpEClass, VARIABLE_INIT_EXP__WITH_RESULT);

		whileExpEClass = createEClass(WHILE_EXP);
		createEReference(whileExpEClass, WHILE_EXP__CONDITION);
		createEReference(whileExpEClass, WHILE_EXP__BODY);

		imperativeOCLVisitorEClass = createEClass(IMPERATIVE_OCL_VISITOR);

		// Create enums
		severityKindEEnum = createEEnum(SEVERITY_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		UtilitiesPackage theUtilitiesPackage = (UtilitiesPackage)EPackage.Registry.INSTANCE.getEPackage(UtilitiesPackage.eNS_URI);
		org.eclipse.emf.ecore.EcorePackage theEcorePackage_1 = (org.eclipse.emf.ecore.EcorePackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.emf.ecore.EcorePackage.eNS_URI);

		// Create type parameters
		ETypeParameter imperativeOCLVisitorEClass_T = addETypeParameter(imperativeOCLVisitorEClass, "T"); //$NON-NLS-1$

		// Set bounds for type parameters

		// Add supertypes to classes
		altExpEClass.getESuperTypes().add(this.getImperativeExpression());
		assertExpEClass.getESuperTypes().add(this.getImperativeExpression());
		assignExpEClass.getESuperTypes().add(this.getImperativeExpression());
		blockExpEClass.getESuperTypes().add(this.getImperativeExpression());
		computeExpEClass.getESuperTypes().add(this.getImperativeExpression());
		dictLiteralExpEClass.getESuperTypes().add(theEcorePackage.getLiteralExp());
		dictLiteralPartEClass.getESuperTypes().add(theEcorePackage_1.getEModelElement());
		dictionaryTypeEClass.getESuperTypes().add(theEcorePackage.getCollectionType());
		forExpEClass.getESuperTypes().add(this.getImperativeLoopExp());
		imperativeExpressionEClass.getESuperTypes().add(theEcorePackage.getOCLExpression());
		imperativeIterateExpEClass.getESuperTypes().add(this.getImperativeLoopExp());
		imperativeLoopExpEClass.getESuperTypes().add(this.getImperativeExpression());
		imperativeLoopExpEClass.getESuperTypes().add(theEcorePackage.getLoopExp());
		instantiationExpEClass.getESuperTypes().add(this.getImperativeExpression());
		listTypeEClass.getESuperTypes().add(theEcorePackage.getCollectionType());
		logExpEClass.getESuperTypes().add(theEcorePackage.getOperationCallExp());
		returnExpEClass.getESuperTypes().add(this.getImperativeExpression());
		switchExpEClass.getESuperTypes().add(this.getImperativeExpression());
		templateParameterTypeEClass.getESuperTypes().add(theEcorePackage_1.getEClassifier());
		typedefEClass.getESuperTypes().add(theEcorePackage_1.getEClass());
		variableInitExpEClass.getESuperTypes().add(this.getImperativeExpression());
		whileExpEClass.getESuperTypes().add(this.getImperativeExpression());
		EGenericType g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		EGenericType g2 = createEGenericType(imperativeOCLVisitorEClass_T);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage_1.getEClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage_1.getEOperation());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage_1.getEStructuralFeature());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage_1.getEEnumLiteral());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage_1.getEParameter());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage_1.getEObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getCallOperationAction());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getSendSignalAction());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getConstraint());
		g1.getETypeArguments().add(g2);
		imperativeOCLVisitorEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes and features; add operations and parameters
		initEClass(altExpEClass, AltExp.class, "AltExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAltExp_Condition(), theEcorePackage.getOCLExpression(), null, "condition", null, 1, 1, AltExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAltExp_Body(), theEcorePackage.getOCLExpression(), null, "body", null, 1, 1, AltExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		EOperation op = addEOperation(altExpEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		ETypeParameter t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		ETypeParameter t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(assertExpEClass, AssertExp.class, "AssertExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAssertExp_Assertion(), theEcorePackage.getOCLExpression(), null, "assertion", null, 1, 1, AssertExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAssertExp_Log(), this.getLogExp(), null, "log", null, 0, 1, AssertExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getAssertExp_Severity(), this.getSeverityKind(), "severity", "error", 1, 1, AssertExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		op = addEOperation(assertExpEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(assignExpEClass, AssignExp.class, "AssignExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAssignExp_DefaultValue(), theEcorePackage.getOCLExpression(), null, "defaultValue", null, 0, 1, AssignExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getAssignExp_IsReset(), theEcorePackage_1.getEBoolean(), "isReset", null, 0, 1, AssignExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAssignExp_Left(), theEcorePackage.getOCLExpression(), null, "left", null, 1, 1, AssignExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAssignExp_Value(), theEcorePackage.getOCLExpression(), null, "value", null, 0, -1, AssignExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(assignExpEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(blockExpEClass, BlockExp.class, "BlockExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getBlockExp_Body(), theEcorePackage.getOCLExpression(), null, "body", null, 0, -1, BlockExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(blockExpEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(computeExpEClass, ComputeExp.class, "ComputeExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getComputeExp_Body(), theEcorePackage.getOCLExpression(), null, "body", null, 1, 1, ComputeExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getComputeExp_ReturnedElement(), theEcorePackage.getVariable(), null, "returnedElement", null, 1, 1, ComputeExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(computeExpEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(dictLiteralExpEClass, DictLiteralExp.class, "DictLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getDictLiteralExp_Part(), this.getDictLiteralPart(), null, "part", null, 0, -1, DictLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$

		initEClass(dictLiteralPartEClass, DictLiteralPart.class, "DictLiteralPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getDictLiteralPart_Key(), theEcorePackage.getOCLExpression(), null, "key", null, 1, 1, DictLiteralPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDictLiteralPart_Value(), theEcorePackage.getOCLExpression(), null, "value", null, 1, 1, DictLiteralPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(dictionaryTypeEClass, DictionaryType.class, "DictionaryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getDictionaryType_KeyType(), theEcorePackage_1.getEClassifier(), null, "keyType", null, 0, 1, DictionaryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(forExpEClass, ForExp.class, "ForExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		op = addEOperation(forExpEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(imperativeExpressionEClass, ImperativeExpression.class, "ImperativeExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(imperativeIterateExpEClass, ImperativeIterateExp.class, "ImperativeIterateExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getImperativeIterateExp_Target(), theEcorePackage.getVariable(), null, "target", null, 0, 1, ImperativeIterateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(imperativeIterateExpEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(imperativeLoopExpEClass, ImperativeLoopExp.class, "ImperativeLoopExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getImperativeLoopExp_Condition(), theEcorePackage.getOCLExpression(), null, "condition", null, 0, 1, ImperativeLoopExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(imperativeLoopExpEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(instantiationExpEClass, InstantiationExp.class, "InstantiationExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getInstantiationExp_Argument(), theEcorePackage.getOCLExpression(), null, "argument", null, 0, -1, InstantiationExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getInstantiationExp_Extent(), theEcorePackage.getVariable(), null, "extent", null, 1, 1, InstantiationExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getInstantiationExp_InstantiatedClass(), theEcorePackage_1.getEClass(), null, "instantiatedClass", null, 1, 1, InstantiationExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(instantiationExpEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(listTypeEClass, ListType.class, "ListType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(logExpEClass, LogExp.class, "LogExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLogExp_Condition(), theEcorePackage.getOCLExpression(), null, "condition", null, 0, 1, LogExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(logExpEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(returnExpEClass, ReturnExp.class, "ReturnExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getReturnExp_Value(), theEcorePackage.getOCLExpression(), null, "value", null, 0, 1, ReturnExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(returnExpEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(switchExpEClass, SwitchExp.class, "SwitchExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSwitchExp_AlternativePart(), this.getAltExp(), null, "alternativePart", null, 0, -1, SwitchExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSwitchExp_ElsePart(), theEcorePackage.getOCLExpression(), null, "elsePart", null, 0, 1, SwitchExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(switchExpEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(templateParameterTypeEClass, TemplateParameterType.class, "TemplateParameterType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTemplateParameterType_Specification(), theEcorePackage_1.getEString(), "specification", null, 0, 1, TemplateParameterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(typedefEClass, Typedef.class, "Typedef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTypedef_Base(), theEcorePackage_1.getEClassifier(), null, "base", null, 1, 1, Typedef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTypedef_Condition(), theEcorePackage.getOCLExpression(), null, "condition", null, 0, 1, Typedef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(variableInitExpEClass, VariableInitExp.class, "VariableInitExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getVariableInitExp_ReferredVariable(), theEcorePackage.getVariable(), null, "referredVariable", null, 1, 1, VariableInitExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVariableInitExp_WithResult(), theEcorePackage_1.getEBoolean(), "withResult", "false", 0, 1, VariableInitExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		op = addEOperation(variableInitExpEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(whileExpEClass, WhileExp.class, "WhileExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getWhileExp_Condition(), theEcorePackage.getOCLExpression(), null, "condition", null, 1, 1, WhileExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWhileExp_Body(), theEcorePackage.getOCLExpression(), null, "body", null, 1, 1, WhileExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(whileExpEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		t1 = addETypeParameter(op, "T"); //$NON-NLS-1$
		t2 = addETypeParameter(op, "U"); //$NON-NLS-1$
		g1 = createEGenericType(theUtilitiesPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		t2.getEBounds().add(g1);
		g1 = createEGenericType(t2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(imperativeOCLVisitorEClass, ImperativeOCLVisitor.class, "ImperativeOCLVisitor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		op = addEOperation(imperativeOCLVisitorEClass, null, "visitAssignExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getAssignExp(), "assignExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(imperativeOCLVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(imperativeOCLVisitorEClass, null, "visitVariableInitExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getVariableInitExp(), "variableInitExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(imperativeOCLVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(imperativeOCLVisitorEClass, null, "visitBlockExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getBlockExp(), "blockExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(imperativeOCLVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(imperativeOCLVisitorEClass, null, "visitComputeExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getComputeExp(), "computeExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(imperativeOCLVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(imperativeOCLVisitorEClass, null, "visitInstantiationExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getInstantiationExp(), "instantiationExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(imperativeOCLVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(imperativeOCLVisitorEClass, null, "visitWhileExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getWhileExp(), "whileExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(imperativeOCLVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(imperativeOCLVisitorEClass, null, "visitSwitchExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getSwitchExp(), "switchExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(imperativeOCLVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(imperativeOCLVisitorEClass, null, "visitSwitchAltExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getAltExp(), "switchAltExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(imperativeOCLVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(imperativeOCLVisitorEClass, null, "visitLogExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getLogExp(), "logExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(imperativeOCLVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(imperativeOCLVisitorEClass, null, "visitAssertExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getAssertExp(), "assertExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(imperativeOCLVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(imperativeOCLVisitorEClass, null, "visitImperativeLoopExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getImperativeLoopExp(), "imperativeLoopExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(imperativeOCLVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(imperativeOCLVisitorEClass, null, "visitForExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getForExp(), "forExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(imperativeOCLVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(imperativeOCLVisitorEClass, null, "visitImperativeIterateExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getImperativeIterateExp(), "imperativeIterateExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(imperativeOCLVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(imperativeOCLVisitorEClass, null, "visitReturnExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getReturnExp(), "returnExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(imperativeOCLVisitorEClass_T);
		initEOperation(op, g1);

		op = addEOperation(imperativeOCLVisitorEClass, null, "visitDictLiteralExp", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getDictLiteralExp(), "dictLiteralExp", 1, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(imperativeOCLVisitorEClass_T);
		initEOperation(op, g1);

		// Initialize enums and add enum literals
		initEEnum(severityKindEEnum, SeverityKind.class, "SeverityKind"); //$NON-NLS-1$
		addEEnumLiteral(severityKindEEnum, SeverityKind.ERROR);
		addEEnumLiteral(severityKindEEnum, SeverityKind.WARNING);
		addEEnumLiteral(severityKindEEnum, SeverityKind.FATAL);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName
		createEmofAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEmofAnnotations() {
		String source = "http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName"; //$NON-NLS-1$					
		addAnnotation
		  (getAssignExp_DefaultValue(), 
		   source, 
		   new String[] {
			 "body", "defaultOwner" //$NON-NLS-1$ //$NON-NLS-2$
		   });				
		addAnnotation
		  (getDictLiteralExp_Part(), 
		   source, 
		   new String[] {
			 "body", "partOwner" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDictLiteralPart_Key(), 
		   source, 
		   new String[] {
			 "body", "keyOwner" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDictLiteralPart_Value(), 
		   source, 
		   new String[] {
			 "body", "valOwner" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDictionaryType_KeyType(), 
		   source, 
		   new String[] {
			 "body", "keyDict" //$NON-NLS-1$ //$NON-NLS-2$
		   });										
		addAnnotation
		  (getVariableInitExp_ReferredVariable(), 
		   source, 
		   new String[] {
			 "body", "declaration" //$NON-NLS-1$ //$NON-NLS-2$
		   });	
	}

} //ImperativeOCLPackageImpl
