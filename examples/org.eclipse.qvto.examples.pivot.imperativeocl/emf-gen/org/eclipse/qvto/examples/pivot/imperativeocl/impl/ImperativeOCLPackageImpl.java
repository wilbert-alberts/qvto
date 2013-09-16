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
package org.eclipse.qvto.examples.pivot.imperativeocl.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.ocl.examples.pivot.PivotPackage;

import org.eclipse.qvto.examples.pivot.imperativeocl.AltExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ContinueExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart;
import org.eclipse.qvto.examples.pivot.imperativeocl.DictionaryType;
import org.eclipse.qvto.examples.pivot.imperativeocl.ForExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeExpression;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeLoopExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLFactory;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage;
import org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ListLiteralExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ListType;
import org.eclipse.qvto.examples.pivot.imperativeocl.LogExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart;
import org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType;
import org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.SeverityKind;
import org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.TryExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.Typedef;
import org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor;

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
	private EClass altExpEClass = null;

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
	private EClass assignExpEClass = null;

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
	private EClass breakExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass catchExpEClass = null;

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
	private EClass continueExpEClass = null;

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
	private EClass dictionaryTypeEClass = null;

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
	private EClass imperativeExpressionEClass = null;

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
	private EClass imperativeLoopExpEClass = null;

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
	private EClass listLiteralExpEClass = null;

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
	private EClass logExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orderedTupleLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orderedTupleLiteralPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orderedTupleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass raiseExpEClass = null;

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
	private EClass switchExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tryExpEClass = null;

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
	private EClass unlinkExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unpackExpEClass = null;

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
	private EClass imperativeOCLVisitorEClass = null;

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
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage#eNS_URI
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
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ImperativeOCLPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
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
		ImperativeOCLPackageImpl theImperativeOCLPackage = (ImperativeOCLPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ImperativeOCLPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ImperativeOCLPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PivotPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theImperativeOCLPackage.createPackageContents();

		// Initialize created meta-data
		theImperativeOCLPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theImperativeOCLPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ImperativeOCLPackage.eNS_URI, theImperativeOCLPackage);
		return theImperativeOCLPackage;
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
	public EReference getAltExp_Body() {
		return (EReference)altExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAltExp_Condition() {
		return (EReference)altExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAltExp__Accept__ImperativeOCLVisitor() {
		return altExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAltExp__Accept__Visitor() {
		return altExpEClass.getEOperations().get(1);
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
	public EOperation getAssertExp__Accept__ImperativeOCLVisitor() {
		return assertExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssertExp__Accept__Visitor() {
		return assertExpEClass.getEOperations().get(1);
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
	public EAttribute getAssignExp_IsReset() {
		return (EAttribute)assignExpEClass.getEStructuralFeatures().get(1);
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
	public EReference getAssignExp_Value() {
		return (EReference)assignExpEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignExp__Accept__ImperativeOCLVisitor() {
		return assignExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAssignExp__Accept__Visitor() {
		return assignExpEClass.getEOperations().get(1);
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
	public EOperation getBlockExp__Accept__ImperativeOCLVisitor() {
		return blockExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBlockExp__Accept__Visitor() {
		return blockExpEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBreakExp() {
		return breakExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBreakExp__Accept__ImperativeOCLVisitor() {
		return breakExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBreakExp__Accept__Visitor() {
		return breakExpEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCatchExp() {
		return catchExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCatchExp_Body() {
		return (EReference)catchExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCatchExp_Exception() {
		return (EReference)catchExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCatchExp__Accept__ImperativeOCLVisitor() {
		return catchExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCatchExp__Accept__Visitor() {
		return catchExpEClass.getEOperations().get(1);
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
	public EReference getComputeExp_Body() {
		return (EReference)computeExpEClass.getEStructuralFeatures().get(0);
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
	public EOperation getComputeExp__Accept__ImperativeOCLVisitor() {
		return computeExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComputeExp__Accept__Visitor() {
		return computeExpEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContinueExp() {
		return continueExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContinueExp__Accept__ImperativeOCLVisitor() {
		return continueExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContinueExp__Accept__Visitor() {
		return continueExpEClass.getEOperations().get(1);
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
	public EOperation getDictLiteralExp__Accept__ImperativeOCLVisitor() {
		return dictLiteralExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDictLiteralExp__Accept__Visitor() {
		return dictLiteralExpEClass.getEOperations().get(1);
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
	public EOperation getDictLiteralPart__Accept__ImperativeOCLVisitor() {
		return dictLiteralPartEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDictLiteralPart__Accept__Visitor() {
		return dictLiteralPartEClass.getEOperations().get(1);
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
	public EOperation getDictionaryType__Accept__ImperativeOCLVisitor() {
		return dictionaryTypeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDictionaryType__Accept__Visitor() {
		return dictionaryTypeEClass.getEOperations().get(1);
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
	public EOperation getForExp__Accept__ImperativeOCLVisitor() {
		return forExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getForExp__Accept__Visitor() {
		return forExpEClass.getEOperations().get(1);
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
	public EOperation getImperativeIterateExp__Accept__ImperativeOCLVisitor() {
		return imperativeIterateExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getImperativeIterateExp__Accept__Visitor() {
		return imperativeIterateExpEClass.getEOperations().get(1);
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
	public EOperation getInstantiationExp__Accept__ImperativeOCLVisitor() {
		return instantiationExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstantiationExp__Accept__Visitor() {
		return instantiationExpEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListLiteralExp() {
		return listLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListLiteralExp_Element() {
		return (EReference)listLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getListLiteralExp__Accept__ImperativeOCLVisitor() {
		return listLiteralExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getListLiteralExp__Accept__Visitor() {
		return listLiteralExpEClass.getEOperations().get(1);
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
	public EOperation getListType__Accept__ImperativeOCLVisitor() {
		return listTypeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getListType__Accept__Visitor() {
		return listTypeEClass.getEOperations().get(1);
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
	public EOperation getLogExp__Accept__ImperativeOCLVisitor() {
		return logExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLogExp__Accept__Visitor() {
		return logExpEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrderedTupleLiteralExp() {
		return orderedTupleLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOrderedTupleLiteralExp_Part() {
		return (EReference)orderedTupleLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOrderedTupleLiteralExp__Accept__ImperativeOCLVisitor() {
		return orderedTupleLiteralExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOrderedTupleLiteralExp__Accept__Visitor() {
		return orderedTupleLiteralExpEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrderedTupleLiteralPart() {
		return orderedTupleLiteralPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOrderedTupleLiteralPart_Value() {
		return (EReference)orderedTupleLiteralPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOrderedTupleLiteralPart__Accept__ImperativeOCLVisitor() {
		return orderedTupleLiteralPartEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOrderedTupleLiteralPart__Accept__Visitor() {
		return orderedTupleLiteralPartEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrderedTupleType() {
		return orderedTupleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOrderedTupleType_ElementType() {
		return (EReference)orderedTupleTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOrderedTupleType__Accept__ImperativeOCLVisitor() {
		return orderedTupleTypeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOrderedTupleType__Accept__Visitor() {
		return orderedTupleTypeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRaiseExp() {
		return raiseExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRaiseExp_Argument() {
		return (EReference)raiseExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRaiseExp_Exception() {
		return (EReference)raiseExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRaiseExp__Accept__ImperativeOCLVisitor() {
		return raiseExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRaiseExp__Accept__Visitor() {
		return raiseExpEClass.getEOperations().get(1);
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
	public EOperation getReturnExp__Accept__ImperativeOCLVisitor() {
		return returnExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReturnExp__Accept__Visitor() {
		return returnExpEClass.getEOperations().get(1);
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
	public EOperation getSwitchExp__Accept__ImperativeOCLVisitor() {
		return switchExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSwitchExp__Accept__Visitor() {
		return switchExpEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTryExp() {
		return tryExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTryExp_ExceptClause() {
		return (EReference)tryExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTryExp_TryBody() {
		return (EReference)tryExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTryExp__Accept__ImperativeOCLVisitor() {
		return tryExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTryExp__Accept__Visitor() {
		return tryExpEClass.getEOperations().get(1);
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
	public EOperation getTypedef__Accept__ImperativeOCLVisitor() {
		return typedefEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTypedef__Accept__Visitor() {
		return typedefEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnlinkExp() {
		return unlinkExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnlinkExp_Item() {
		return (EReference)unlinkExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnlinkExp_Target() {
		return (EReference)unlinkExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnlinkExp__Accept__ImperativeOCLVisitor() {
		return unlinkExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnlinkExp__Accept__Visitor() {
		return unlinkExpEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnpackExp() {
		return unpackExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnpackExp_Source() {
		return (EReference)unpackExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnpackExp_TargetVariable() {
		return (EReference)unpackExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnpackExp__Accept__ImperativeOCLVisitor() {
		return unpackExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnpackExp__Accept__Visitor() {
		return unpackExpEClass.getEOperations().get(1);
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
	public EOperation getVariableInitExp__Accept__ImperativeOCLVisitor() {
		return variableInitExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getVariableInitExp__Accept__Visitor() {
		return variableInitExpEClass.getEOperations().get(1);
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
	public EReference getWhileExp_Body() {
		return (EReference)whileExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileExp_Condition() {
		return (EReference)whileExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWhileExp__Accept__ImperativeOCLVisitor() {
		return whileExpEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getWhileExp__Accept__Visitor() {
		return whileExpEClass.getEOperations().get(1);
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
		createEReference(altExpEClass, ALT_EXP__BODY);
		createEReference(altExpEClass, ALT_EXP__CONDITION);
		createEOperation(altExpEClass, ALT_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(altExpEClass, ALT_EXP___ACCEPT__VISITOR);

		assertExpEClass = createEClass(ASSERT_EXP);
		createEReference(assertExpEClass, ASSERT_EXP__ASSERTION);
		createEReference(assertExpEClass, ASSERT_EXP__LOG);
		createEAttribute(assertExpEClass, ASSERT_EXP__SEVERITY);
		createEOperation(assertExpEClass, ASSERT_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(assertExpEClass, ASSERT_EXP___ACCEPT__VISITOR);

		assignExpEClass = createEClass(ASSIGN_EXP);
		createEReference(assignExpEClass, ASSIGN_EXP__DEFAULT_VALUE);
		createEAttribute(assignExpEClass, ASSIGN_EXP__IS_RESET);
		createEReference(assignExpEClass, ASSIGN_EXP__LEFT);
		createEReference(assignExpEClass, ASSIGN_EXP__VALUE);
		createEOperation(assignExpEClass, ASSIGN_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(assignExpEClass, ASSIGN_EXP___ACCEPT__VISITOR);

		blockExpEClass = createEClass(BLOCK_EXP);
		createEReference(blockExpEClass, BLOCK_EXP__BODY);
		createEOperation(blockExpEClass, BLOCK_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(blockExpEClass, BLOCK_EXP___ACCEPT__VISITOR);

		breakExpEClass = createEClass(BREAK_EXP);
		createEOperation(breakExpEClass, BREAK_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(breakExpEClass, BREAK_EXP___ACCEPT__VISITOR);

		catchExpEClass = createEClass(CATCH_EXP);
		createEReference(catchExpEClass, CATCH_EXP__BODY);
		createEReference(catchExpEClass, CATCH_EXP__EXCEPTION);
		createEOperation(catchExpEClass, CATCH_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(catchExpEClass, CATCH_EXP___ACCEPT__VISITOR);

		computeExpEClass = createEClass(COMPUTE_EXP);
		createEReference(computeExpEClass, COMPUTE_EXP__BODY);
		createEReference(computeExpEClass, COMPUTE_EXP__RETURNED_ELEMENT);
		createEOperation(computeExpEClass, COMPUTE_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(computeExpEClass, COMPUTE_EXP___ACCEPT__VISITOR);

		continueExpEClass = createEClass(CONTINUE_EXP);
		createEOperation(continueExpEClass, CONTINUE_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(continueExpEClass, CONTINUE_EXP___ACCEPT__VISITOR);

		dictLiteralExpEClass = createEClass(DICT_LITERAL_EXP);
		createEReference(dictLiteralExpEClass, DICT_LITERAL_EXP__PART);
		createEOperation(dictLiteralExpEClass, DICT_LITERAL_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(dictLiteralExpEClass, DICT_LITERAL_EXP___ACCEPT__VISITOR);

		dictLiteralPartEClass = createEClass(DICT_LITERAL_PART);
		createEReference(dictLiteralPartEClass, DICT_LITERAL_PART__KEY);
		createEReference(dictLiteralPartEClass, DICT_LITERAL_PART__VALUE);
		createEOperation(dictLiteralPartEClass, DICT_LITERAL_PART___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(dictLiteralPartEClass, DICT_LITERAL_PART___ACCEPT__VISITOR);

		dictionaryTypeEClass = createEClass(DICTIONARY_TYPE);
		createEReference(dictionaryTypeEClass, DICTIONARY_TYPE__KEY_TYPE);
		createEOperation(dictionaryTypeEClass, DICTIONARY_TYPE___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(dictionaryTypeEClass, DICTIONARY_TYPE___ACCEPT__VISITOR);

		forExpEClass = createEClass(FOR_EXP);
		createEOperation(forExpEClass, FOR_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(forExpEClass, FOR_EXP___ACCEPT__VISITOR);

		imperativeExpressionEClass = createEClass(IMPERATIVE_EXPRESSION);

		imperativeIterateExpEClass = createEClass(IMPERATIVE_ITERATE_EXP);
		createEReference(imperativeIterateExpEClass, IMPERATIVE_ITERATE_EXP__TARGET);
		createEOperation(imperativeIterateExpEClass, IMPERATIVE_ITERATE_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(imperativeIterateExpEClass, IMPERATIVE_ITERATE_EXP___ACCEPT__VISITOR);

		imperativeLoopExpEClass = createEClass(IMPERATIVE_LOOP_EXP);
		createEReference(imperativeLoopExpEClass, IMPERATIVE_LOOP_EXP__CONDITION);

		instantiationExpEClass = createEClass(INSTANTIATION_EXP);
		createEReference(instantiationExpEClass, INSTANTIATION_EXP__ARGUMENT);
		createEReference(instantiationExpEClass, INSTANTIATION_EXP__EXTENT);
		createEReference(instantiationExpEClass, INSTANTIATION_EXP__INSTANTIATED_CLASS);
		createEOperation(instantiationExpEClass, INSTANTIATION_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(instantiationExpEClass, INSTANTIATION_EXP___ACCEPT__VISITOR);

		listLiteralExpEClass = createEClass(LIST_LITERAL_EXP);
		createEReference(listLiteralExpEClass, LIST_LITERAL_EXP__ELEMENT);
		createEOperation(listLiteralExpEClass, LIST_LITERAL_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(listLiteralExpEClass, LIST_LITERAL_EXP___ACCEPT__VISITOR);

		listTypeEClass = createEClass(LIST_TYPE);
		createEOperation(listTypeEClass, LIST_TYPE___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(listTypeEClass, LIST_TYPE___ACCEPT__VISITOR);

		logExpEClass = createEClass(LOG_EXP);
		createEReference(logExpEClass, LOG_EXP__CONDITION);
		createEOperation(logExpEClass, LOG_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(logExpEClass, LOG_EXP___ACCEPT__VISITOR);

		orderedTupleLiteralExpEClass = createEClass(ORDERED_TUPLE_LITERAL_EXP);
		createEReference(orderedTupleLiteralExpEClass, ORDERED_TUPLE_LITERAL_EXP__PART);
		createEOperation(orderedTupleLiteralExpEClass, ORDERED_TUPLE_LITERAL_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(orderedTupleLiteralExpEClass, ORDERED_TUPLE_LITERAL_EXP___ACCEPT__VISITOR);

		orderedTupleLiteralPartEClass = createEClass(ORDERED_TUPLE_LITERAL_PART);
		createEReference(orderedTupleLiteralPartEClass, ORDERED_TUPLE_LITERAL_PART__VALUE);
		createEOperation(orderedTupleLiteralPartEClass, ORDERED_TUPLE_LITERAL_PART___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(orderedTupleLiteralPartEClass, ORDERED_TUPLE_LITERAL_PART___ACCEPT__VISITOR);

		orderedTupleTypeEClass = createEClass(ORDERED_TUPLE_TYPE);
		createEReference(orderedTupleTypeEClass, ORDERED_TUPLE_TYPE__ELEMENT_TYPE);
		createEOperation(orderedTupleTypeEClass, ORDERED_TUPLE_TYPE___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(orderedTupleTypeEClass, ORDERED_TUPLE_TYPE___ACCEPT__VISITOR);

		raiseExpEClass = createEClass(RAISE_EXP);
		createEReference(raiseExpEClass, RAISE_EXP__ARGUMENT);
		createEReference(raiseExpEClass, RAISE_EXP__EXCEPTION);
		createEOperation(raiseExpEClass, RAISE_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(raiseExpEClass, RAISE_EXP___ACCEPT__VISITOR);

		returnExpEClass = createEClass(RETURN_EXP);
		createEReference(returnExpEClass, RETURN_EXP__VALUE);
		createEOperation(returnExpEClass, RETURN_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(returnExpEClass, RETURN_EXP___ACCEPT__VISITOR);

		switchExpEClass = createEClass(SWITCH_EXP);
		createEReference(switchExpEClass, SWITCH_EXP__ALTERNATIVE_PART);
		createEReference(switchExpEClass, SWITCH_EXP__ELSE_PART);
		createEOperation(switchExpEClass, SWITCH_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(switchExpEClass, SWITCH_EXP___ACCEPT__VISITOR);

		tryExpEClass = createEClass(TRY_EXP);
		createEReference(tryExpEClass, TRY_EXP__EXCEPT_CLAUSE);
		createEReference(tryExpEClass, TRY_EXP__TRY_BODY);
		createEOperation(tryExpEClass, TRY_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(tryExpEClass, TRY_EXP___ACCEPT__VISITOR);

		typedefEClass = createEClass(TYPEDEF);
		createEReference(typedefEClass, TYPEDEF__BASE);
		createEReference(typedefEClass, TYPEDEF__CONDITION);
		createEOperation(typedefEClass, TYPEDEF___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(typedefEClass, TYPEDEF___ACCEPT__VISITOR);

		unlinkExpEClass = createEClass(UNLINK_EXP);
		createEReference(unlinkExpEClass, UNLINK_EXP__ITEM);
		createEReference(unlinkExpEClass, UNLINK_EXP__TARGET);
		createEOperation(unlinkExpEClass, UNLINK_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(unlinkExpEClass, UNLINK_EXP___ACCEPT__VISITOR);

		unpackExpEClass = createEClass(UNPACK_EXP);
		createEReference(unpackExpEClass, UNPACK_EXP__SOURCE);
		createEReference(unpackExpEClass, UNPACK_EXP__TARGET_VARIABLE);
		createEOperation(unpackExpEClass, UNPACK_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(unpackExpEClass, UNPACK_EXP___ACCEPT__VISITOR);

		variableInitExpEClass = createEClass(VARIABLE_INIT_EXP);
		createEReference(variableInitExpEClass, VARIABLE_INIT_EXP__REFERRED_VARIABLE);
		createEAttribute(variableInitExpEClass, VARIABLE_INIT_EXP__WITH_RESULT);
		createEOperation(variableInitExpEClass, VARIABLE_INIT_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(variableInitExpEClass, VARIABLE_INIT_EXP___ACCEPT__VISITOR);

		whileExpEClass = createEClass(WHILE_EXP);
		createEReference(whileExpEClass, WHILE_EXP__BODY);
		createEReference(whileExpEClass, WHILE_EXP__CONDITION);
		createEOperation(whileExpEClass, WHILE_EXP___ACCEPT__IMPERATIVEOCLVISITOR);
		createEOperation(whileExpEClass, WHILE_EXP___ACCEPT__VISITOR);

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
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);

		// Create type parameters
		ETypeParameter imperativeOCLVisitorEClass_R = addETypeParameter(imperativeOCLVisitorEClass, "R");

		// Set bounds for type parameters

		// Add supertypes to classes
		altExpEClass.getESuperTypes().add(this.getImperativeExpression());
		assertExpEClass.getESuperTypes().add(this.getImperativeExpression());
		assignExpEClass.getESuperTypes().add(this.getImperativeExpression());
		blockExpEClass.getESuperTypes().add(this.getImperativeExpression());
		breakExpEClass.getESuperTypes().add(this.getImperativeExpression());
		catchExpEClass.getESuperTypes().add(this.getImperativeExpression());
		computeExpEClass.getESuperTypes().add(this.getImperativeExpression());
		continueExpEClass.getESuperTypes().add(this.getImperativeExpression());
		dictLiteralExpEClass.getESuperTypes().add(thePivotPackage.getLiteralExp());
		dictLiteralPartEClass.getESuperTypes().add(thePivotPackage.getElement());
		dictionaryTypeEClass.getESuperTypes().add(thePivotPackage.getCollectionType());
		forExpEClass.getESuperTypes().add(this.getImperativeLoopExp());
		imperativeExpressionEClass.getESuperTypes().add(thePivotPackage.getOCLExpression());
		imperativeIterateExpEClass.getESuperTypes().add(this.getImperativeLoopExp());
		imperativeLoopExpEClass.getESuperTypes().add(thePivotPackage.getLoopExp());
		imperativeLoopExpEClass.getESuperTypes().add(this.getImperativeExpression());
		instantiationExpEClass.getESuperTypes().add(this.getImperativeExpression());
		listLiteralExpEClass.getESuperTypes().add(thePivotPackage.getLiteralExp());
		listTypeEClass.getESuperTypes().add(thePivotPackage.getCollectionType());
		logExpEClass.getESuperTypes().add(thePivotPackage.getOperationCallExp());
		logExpEClass.getESuperTypes().add(this.getImperativeExpression());
		orderedTupleLiteralExpEClass.getESuperTypes().add(thePivotPackage.getLiteralExp());
		orderedTupleLiteralPartEClass.getESuperTypes().add(thePivotPackage.getElement());
		orderedTupleTypeEClass.getESuperTypes().add(thePivotPackage.getClass_());
		raiseExpEClass.getESuperTypes().add(this.getImperativeExpression());
		returnExpEClass.getESuperTypes().add(this.getImperativeExpression());
		switchExpEClass.getESuperTypes().add(this.getImperativeExpression());
		tryExpEClass.getESuperTypes().add(this.getImperativeExpression());
		typedefEClass.getESuperTypes().add(thePivotPackage.getClass_());
		unlinkExpEClass.getESuperTypes().add(this.getImperativeExpression());
		unpackExpEClass.getESuperTypes().add(this.getImperativeExpression());
		variableInitExpEClass.getESuperTypes().add(this.getImperativeExpression());
		whileExpEClass.getESuperTypes().add(this.getImperativeExpression());
		EGenericType g1 = createEGenericType(thePivotPackage.getVisitor());
		EGenericType g2 = createEGenericType(imperativeOCLVisitorEClass_R);
		g1.getETypeArguments().add(g2);
		imperativeOCLVisitorEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(altExpEClass, AltExp.class, "AltExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAltExp_Body(), thePivotPackage.getOCLExpression(), null, "body", null, 1, 1, AltExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAltExp_Condition(), thePivotPackage.getOCLExpression(), null, "condition", null, 1, 1, AltExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getAltExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getAltExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(assertExpEClass, AssertExp.class, "AssertExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssertExp_Assertion(), thePivotPackage.getOCLExpression(), null, "assertion", null, 1, 1, AssertExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssertExp_Log(), this.getLogExp(), null, "log", null, 0, 1, AssertExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssertExp_Severity(), this.getSeverityKind(), "severity", "error", 0, 1, AssertExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getAssertExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getAssertExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(assignExpEClass, AssignExp.class, "AssignExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssignExp_DefaultValue(), thePivotPackage.getOCLExpression(), null, "defaultValue", null, 0, 1, AssignExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssignExp_IsReset(), thePivotPackage.getBoolean(), "isReset", null, 0, 1, AssignExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssignExp_Left(), thePivotPackage.getOCLExpression(), null, "left", null, 1, 1, AssignExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssignExp_Value(), thePivotPackage.getOCLExpression(), null, "value", null, 0, -1, AssignExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getAssignExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getAssignExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(blockExpEClass, BlockExp.class, "BlockExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlockExp_Body(), thePivotPackage.getOCLExpression(), null, "body", null, 0, -1, BlockExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getBlockExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getBlockExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(breakExpEClass, BreakExp.class, "BreakExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getBreakExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getBreakExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(catchExpEClass, CatchExp.class, "CatchExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCatchExp_Body(), thePivotPackage.getOCLExpression(), null, "body", null, 0, -1, CatchExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCatchExp_Exception(), thePivotPackage.getType(), null, "exception", null, 0, -1, CatchExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getCatchExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getCatchExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(computeExpEClass, ComputeExp.class, "ComputeExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComputeExp_Body(), thePivotPackage.getOCLExpression(), null, "body", null, 1, 1, ComputeExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputeExp_ReturnedElement(), thePivotPackage.getVariable(), null, "returnedElement", null, 1, 1, ComputeExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getComputeExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getComputeExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(continueExpEClass, ContinueExp.class, "ContinueExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getContinueExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getContinueExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(dictLiteralExpEClass, DictLiteralExp.class, "DictLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDictLiteralExp_Part(), this.getDictLiteralPart(), null, "part", null, 0, -1, DictLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getDictLiteralExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getDictLiteralExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(dictLiteralPartEClass, DictLiteralPart.class, "DictLiteralPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDictLiteralPart_Key(), thePivotPackage.getOCLExpression(), null, "key", null, 1, 1, DictLiteralPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDictLiteralPart_Value(), thePivotPackage.getOCLExpression(), null, "value", null, 1, 1, DictLiteralPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getDictLiteralPart__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getDictLiteralPart__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(dictionaryTypeEClass, DictionaryType.class, "DictionaryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDictionaryType_KeyType(), thePivotPackage.getType(), null, "keyType", null, 0, 1, DictionaryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getDictionaryType__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getDictionaryType__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(forExpEClass, ForExp.class, "ForExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getForExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getForExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(imperativeExpressionEClass, ImperativeExpression.class, "ImperativeExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(imperativeIterateExpEClass, ImperativeIterateExp.class, "ImperativeIterateExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImperativeIterateExp_Target(), thePivotPackage.getVariable(), null, "target", null, 0, 1, ImperativeIterateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getImperativeIterateExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getImperativeIterateExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(imperativeLoopExpEClass, ImperativeLoopExp.class, "ImperativeLoopExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImperativeLoopExp_Condition(), thePivotPackage.getOCLExpression(), null, "condition", null, 0, 1, ImperativeLoopExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(instantiationExpEClass, InstantiationExp.class, "InstantiationExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstantiationExp_Argument(), thePivotPackage.getOCLExpression(), null, "argument", null, 0, -1, InstantiationExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstantiationExp_Extent(), thePivotPackage.getVariable(), null, "extent", null, 0, 1, InstantiationExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstantiationExp_InstantiatedClass(), thePivotPackage.getClass_(), null, "instantiatedClass", null, 1, 1, InstantiationExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getInstantiationExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getInstantiationExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(listLiteralExpEClass, ListLiteralExp.class, "ListLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getListLiteralExp_Element(), thePivotPackage.getOCLExpression(), null, "element", null, 0, -1, ListLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getListLiteralExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getListLiteralExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(listTypeEClass, ListType.class, "ListType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getListType__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getListType__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(logExpEClass, LogExp.class, "LogExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLogExp_Condition(), thePivotPackage.getOCLExpression(), null, "condition", null, 0, 1, LogExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getLogExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getLogExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(orderedTupleLiteralExpEClass, OrderedTupleLiteralExp.class, "OrderedTupleLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOrderedTupleLiteralExp_Part(), this.getOrderedTupleLiteralPart(), null, "part", null, 0, -1, OrderedTupleLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getOrderedTupleLiteralExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getOrderedTupleLiteralExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(orderedTupleLiteralPartEClass, OrderedTupleLiteralPart.class, "OrderedTupleLiteralPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOrderedTupleLiteralPart_Value(), thePivotPackage.getOCLExpression(), null, "value", null, 1, 1, OrderedTupleLiteralPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getOrderedTupleLiteralPart__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getOrderedTupleLiteralPart__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(orderedTupleTypeEClass, OrderedTupleType.class, "OrderedTupleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOrderedTupleType_ElementType(), thePivotPackage.getType(), null, "elementType", null, 0, -1, OrderedTupleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getOrderedTupleType__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getOrderedTupleType__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(raiseExpEClass, RaiseExp.class, "RaiseExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRaiseExp_Argument(), thePivotPackage.getOCLExpression(), null, "argument", null, 0, 1, RaiseExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRaiseExp_Exception(), thePivotPackage.getType(), null, "exception", null, 1, 1, RaiseExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getRaiseExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getRaiseExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(returnExpEClass, ReturnExp.class, "ReturnExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReturnExp_Value(), thePivotPackage.getOCLExpression(), null, "value", null, 0, 1, ReturnExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getReturnExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getReturnExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(switchExpEClass, SwitchExp.class, "SwitchExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwitchExp_AlternativePart(), this.getAltExp(), null, "alternativePart", null, 0, -1, SwitchExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchExp_ElsePart(), thePivotPackage.getOCLExpression(), null, "elsePart", null, 0, 1, SwitchExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getSwitchExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getSwitchExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(tryExpEClass, TryExp.class, "TryExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTryExp_ExceptClause(), this.getCatchExp(), null, "exceptClause", null, 0, -1, TryExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTryExp_TryBody(), thePivotPackage.getOCLExpression(), null, "tryBody", null, 0, -1, TryExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getTryExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getTryExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(typedefEClass, Typedef.class, "Typedef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedef_Base(), thePivotPackage.getType(), null, "base", null, 1, 1, Typedef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypedef_Condition(), thePivotPackage.getOCLExpression(), null, "condition", null, 0, 1, Typedef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getTypedef__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getTypedef__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(unlinkExpEClass, UnlinkExp.class, "UnlinkExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnlinkExp_Item(), thePivotPackage.getOCLExpression(), null, "item", null, 1, 1, UnlinkExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnlinkExp_Target(), thePivotPackage.getOCLExpression(), null, "target", null, 1, 1, UnlinkExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getUnlinkExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getUnlinkExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(unpackExpEClass, UnpackExp.class, "UnpackExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnpackExp_Source(), thePivotPackage.getOCLExpression(), null, "source", null, 1, 1, UnpackExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnpackExp_TargetVariable(), thePivotPackage.getVariable(), null, "targetVariable", null, 1, -1, UnpackExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getUnpackExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getUnpackExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(variableInitExpEClass, VariableInitExp.class, "VariableInitExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableInitExp_ReferredVariable(), thePivotPackage.getVariable(), null, "referredVariable", null, 1, 1, VariableInitExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariableInitExp_WithResult(), thePivotPackage.getBoolean(), "withResult", "false", 0, 1, VariableInitExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getVariableInitExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getVariableInitExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(whileExpEClass, WhileExp.class, "WhileExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWhileExp_Body(), thePivotPackage.getOCLExpression(), null, "body", null, 1, 1, WhileExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWhileExp_Condition(), thePivotPackage.getOCLExpression(), null, "condition", null, 1, 1, WhileExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getWhileExp__Accept__ImperativeOCLVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(this.getImperativeOCLVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getWhileExp__Accept__Visitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "R");
		g1 = createEGenericType(thePivotPackage.getVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "v", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(imperativeOCLVisitorEClass, ImperativeOCLVisitor.class, "ImperativeOCLVisitor", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(severityKindEEnum, SeverityKind.class, "SeverityKind");
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
		String source = "http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName";				
		addAnnotation
		  (getAltExp_Body(), 
		   source, 
		   new String[] {
			 "body", "altBodyOwner"
		   });		
		addAnnotation
		  (getAltExp_Condition(), 
		   source, 
		   new String[] {
			 "body", "altCondOwner"
		   });				
		addAnnotation
		  (getAssertExp_Assertion(), 
		   source, 
		   new String[] {
			 "body", "assertOwner"
		   });				
		addAnnotation
		  (getAssignExp_DefaultValue(), 
		   source, 
		   new String[] {
			 "body", "defaultOwner"
		   });		
		addAnnotation
		  (getAssignExp_Left(), 
		   source, 
		   new String[] {
			 "body", "leftOwner"
		   });		
		addAnnotation
		  (getAssignExp_Value(), 
		   source, 
		   new String[] {
			 "body", "valueOwner"
		   });				
		addAnnotation
		  (getBlockExp_Body(), 
		   source, 
		   new String[] {
			 "body", "blockOwner"
		   });						
		addAnnotation
		  (getCatchExp_Exception(), 
		   source, 
		   new String[] {
			 "body", "tryExpression"
		   });				
		addAnnotation
		  (getComputeExp_Body(), 
		   source, 
		   new String[] {
			 "body", "computeOwner"
		   });		
		addAnnotation
		  (getComputeExp_ReturnedElement(), 
		   source, 
		   new String[] {
			 "body", "computeOwner"
		   });						
		addAnnotation
		  (getDictLiteralExp_Part(), 
		   source, 
		   new String[] {
			 "body", "partOwner"
		   });				
		addAnnotation
		  (getDictLiteralPart_Key(), 
		   source, 
		   new String[] {
			 "body", "keyOwner"
		   });		
		addAnnotation
		  (getDictLiteralPart_Value(), 
		   source, 
		   new String[] {
			 "body", "valOwner"
		   });				
		addAnnotation
		  (getDictionaryType_KeyType(), 
		   source, 
		   new String[] {
			 "body", "keyDict"
		   });						
		addAnnotation
		  (getImperativeIterateExp_Target(), 
		   source, 
		   new String[] {
			 "body", "tgtOwner"
		   });		
		addAnnotation
		  (getImperativeLoopExp_Condition(), 
		   source, 
		   new String[] {
			 "body", "loopCondOwner"
		   });				
		addAnnotation
		  (getInstantiationExp_Argument(), 
		   source, 
		   new String[] {
			 "body", "argOwner"
		   });				
		addAnnotation
		  (getListLiteralExp_Element(), 
		   source, 
		   new String[] {
			 "body", "elementOwner"
		   });						
		addAnnotation
		  (getLogExp_Condition(), 
		   source, 
		   new String[] {
			 "body", "logOwner"
		   });				
		addAnnotation
		  (getOrderedTupleLiteralExp_Part(), 
		   source, 
		   new String[] {
			 "body", "partOwner"
		   });				
		addAnnotation
		  (getOrderedTupleLiteralPart_Value(), 
		   source, 
		   new String[] {
			 "body", "tupValOwner"
		   });				
		addAnnotation
		  (getOrderedTupleType_ElementType(), 
		   source, 
		   new String[] {
			 "body", "eltTuple"
		   });				
		addAnnotation
		  (getRaiseExp_Exception(), 
		   source, 
		   new String[] {
			 "body", "raiseExpression"
		   });						
		addAnnotation
		  (getSwitchExp_AlternativePart(), 
		   source, 
		   new String[] {
			 "body", "altOwner"
		   });		
		addAnnotation
		  (getSwitchExp_ElsePart(), 
		   source, 
		   new String[] {
			 "body", "elsePartOwner"
		   });				
		addAnnotation
		  (getTryExp_ExceptClause(), 
		   source, 
		   new String[] {
			 "body", "exceptOwner"
		   });		
		addAnnotation
		  (getTryExp_TryBody(), 
		   source, 
		   new String[] {
			 "body", "tryBodyOwner"
		   });						
		addAnnotation
		  (getUnlinkExp_Item(), 
		   source, 
		   new String[] {
			 "body", "itemUnlink"
		   });		
		addAnnotation
		  (getUnlinkExp_Target(), 
		   source, 
		   new String[] {
			 "body", "tgtUnlink"
		   });						
		addAnnotation
		  (getVariableInitExp_ReferredVariable(), 
		   source, 
		   new String[] {
			 "body", "declaration"
		   });				
		addAnnotation
		  (getWhileExp_Body(), 
		   source, 
		   new String[] {
			 "body", "whileOwner"
		   });		
		addAnnotation
		  (getWhileExp_Condition(), 
		   source, 
		   new String[] {
			 "body", "whileExpression"
		   });
	}

} //ImperativeOCLPackageImpl
