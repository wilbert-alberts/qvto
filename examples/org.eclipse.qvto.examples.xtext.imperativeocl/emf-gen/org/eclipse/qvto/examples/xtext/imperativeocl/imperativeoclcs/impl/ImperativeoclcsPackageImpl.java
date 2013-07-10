/**
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.AssertExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.AssignStatementCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.BlockExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ComputeExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralPartCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DoExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ExceptCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ExpressionBlockCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ExpressionStatementCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ForExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeIterateExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeLoopExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsFactory;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.InstantiationExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListLiteralExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListTypeCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.LogExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.QuitExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.RaiseExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ReturnExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.StatementCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.SwitchAltCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.SwitchExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.TryExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.VariableInitializationCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.WhileExpCS;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class ImperativeoclcsPackageImpl
		extends EPackageImpl
		implements ImperativeoclcsPackage {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assertExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignStatementCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listTypeCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dictTypeCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computeExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeIterateExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeLoopExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instantiationExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exceptCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionBlockCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionStatementCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass quitExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass raiseExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dictLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dictLiteralPartCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass returnExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchAltCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tryExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableInitializationCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whileExpCSEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ImperativeoclcsPackageImpl() {
		super(eNS_URI, ImperativeoclcsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ImperativeoclcsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ImperativeoclcsPackage init() {
		if (isInited) return (ImperativeoclcsPackage)EPackage.Registry.INSTANCE.getEPackage(ImperativeoclcsPackage.eNS_URI);

		// Obtain or create and register package
		ImperativeoclcsPackageImpl theImperativeoclcsPackage = (ImperativeoclcsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ImperativeoclcsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ImperativeoclcsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EssentialOCLCSTPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theImperativeoclcsPackage.createPackageContents();

		// Initialize created meta-data
		theImperativeoclcsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theImperativeoclcsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ImperativeoclcsPackage.eNS_URI, theImperativeoclcsPackage);
		return theImperativeoclcsPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssertExpCS() {
		return assertExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssertExpCS_Assertion() {
		return (EReference)assertExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssertExpCS_Log() {
		return (EReference)assertExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertExpCS_Severity() {
		return (EAttribute)assertExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignStatementCS() {
		return assignStatementCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignStatementCS_LValueCS() {
		return (EReference)assignStatementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignStatementCS_OclExpressionCS() {
		return (EReference)assignStatementCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignStatementCS_Incremental() {
		return (EAttribute)assignStatementCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockExpCS() {
		return blockExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockExpCS_BodyExpressions() {
		return (EReference)blockExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListTypeCS() {
		return listTypeCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListTypeCS_Type() {
		return (EReference)listTypeCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDictTypeCS() {
		return dictTypeCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDictTypeCS_KeyType() {
		return (EReference)dictTypeCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDictTypeCS_ValueType() {
		return (EReference)dictTypeCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputeExpCS() {
		return computeExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputeExpCS_ReturnedElement() {
		return (EReference)computeExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImperativeIterateExpCS() {
		return imperativeIterateExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImperativeIterateExpCS_Target() {
		return (EReference)imperativeIterateExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImperativeLoopExpCS() {
		return imperativeLoopExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImperativeLoopExpCS_Condition() {
		return (EReference)imperativeLoopExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstantiationExpCS() {
		return instantiationExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstantiationExpCS_TypeSpecCS() {
		return (EReference)instantiationExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstantiationExpCS_Arguments() {
		return (EReference)instantiationExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoExpCS() {
		return doExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDoExpCS_Condition() {
		return (EReference)doExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExceptCS() {
		return exceptCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExceptCS_Except() {
		return (EReference)exceptCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExceptCS_Body() {
		return (EReference)exceptCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionBlockCS() {
		return expressionBlockCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionBlockCS_Body() {
		return (EReference)expressionBlockCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionStatementCS() {
		return expressionStatementCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionStatementCS_OclExpressionCS() {
		return (EReference)expressionStatementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForExpCS() {
		return forExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListLiteralExpCS() {
		return listLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListLiteralExpCS_OwnedParts() {
		return (EReference)listLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogExpCS() {
		return logExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogExpCS_Condition() {
		return (EReference)logExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuitExpCS() {
		return quitExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuitExpCS_Keyword() {
		return (EAttribute)quitExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQuitExpCS_Value() {
		return (EReference)quitExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRaiseExpCS() {
		return raiseExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDictLiteralExpCS() {
		return dictLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDictLiteralExpCS_OwnedParts() {
		return (EReference)dictLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDictLiteralPartCS() {
		return dictLiteralPartCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDictLiteralPartCS_Key() {
		return (EReference)dictLiteralPartCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDictLiteralPartCS_Value() {
		return (EReference)dictLiteralPartCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReturnExpCS() {
		return returnExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReturnExpCS_Value() {
		return (EReference)returnExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatementCS() {
		return statementCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchAltCS() {
		return switchAltCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchAltCS_Condition() {
		return (EReference)switchAltCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchAltCS_Body() {
		return (EReference)switchAltCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSwitchAltCS_Keyword() {
		return (EAttribute)switchAltCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchExpCS() {
		return switchExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchExpCS_AlternativePart() {
		return (EReference)switchExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchExpCS_ElsePart() {
		return (EReference)switchExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTryExpCS() {
		return tryExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTryExpCS_Catch() {
		return (EReference)tryExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableInitializationCS() {
		return variableInitializationCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableInitializationCS_OclExpressionCS() {
		return (EReference)variableInitializationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableInitializationCS_SimpleNameCS() {
		return (EAttribute)variableInitializationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableInitializationCS_TypeCS() {
		return (EReference)variableInitializationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableInitializationCS_WithResult() {
		return (EAttribute)variableInitializationCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhileExpCS() {
		return whileExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileExpCS_Condition() {
		return (EReference)whileExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileExpCS_ResultVar() {
		return (EReference)whileExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeoclcsFactory getImperativeoclcsFactory() {
		return (ImperativeoclcsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
		assertExpCSEClass = createEClass(ASSERT_EXP_CS);
		createEReference(assertExpCSEClass, ASSERT_EXP_CS__ASSERTION);
		createEReference(assertExpCSEClass, ASSERT_EXP_CS__LOG);
		createEAttribute(assertExpCSEClass, ASSERT_EXP_CS__SEVERITY);

		assignStatementCSEClass = createEClass(ASSIGN_STATEMENT_CS);
		createEReference(assignStatementCSEClass, ASSIGN_STATEMENT_CS__LVALUE_CS);
		createEReference(assignStatementCSEClass, ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS);
		createEAttribute(assignStatementCSEClass, ASSIGN_STATEMENT_CS__INCREMENTAL);

		blockExpCSEClass = createEClass(BLOCK_EXP_CS);
		createEReference(blockExpCSEClass, BLOCK_EXP_CS__BODY_EXPRESSIONS);

		dictLiteralExpCSEClass = createEClass(DICT_LITERAL_EXP_CS);
		createEReference(dictLiteralExpCSEClass, DICT_LITERAL_EXP_CS__OWNED_PARTS);

		dictLiteralPartCSEClass = createEClass(DICT_LITERAL_PART_CS);
		createEReference(dictLiteralPartCSEClass, DICT_LITERAL_PART_CS__KEY);
		createEReference(dictLiteralPartCSEClass, DICT_LITERAL_PART_CS__VALUE);

		dictTypeCSEClass = createEClass(DICT_TYPE_CS);
		createEReference(dictTypeCSEClass, DICT_TYPE_CS__KEY_TYPE);
		createEReference(dictTypeCSEClass, DICT_TYPE_CS__VALUE_TYPE);

		computeExpCSEClass = createEClass(COMPUTE_EXP_CS);
		createEReference(computeExpCSEClass, COMPUTE_EXP_CS__RETURNED_ELEMENT);

		imperativeIterateExpCSEClass = createEClass(IMPERATIVE_ITERATE_EXP_CS);
		createEReference(imperativeIterateExpCSEClass, IMPERATIVE_ITERATE_EXP_CS__TARGET);

		imperativeLoopExpCSEClass = createEClass(IMPERATIVE_LOOP_EXP_CS);
		createEReference(imperativeLoopExpCSEClass, IMPERATIVE_LOOP_EXP_CS__CONDITION);

		instantiationExpCSEClass = createEClass(INSTANTIATION_EXP_CS);
		createEReference(instantiationExpCSEClass, INSTANTIATION_EXP_CS__TYPE_SPEC_CS);
		createEReference(instantiationExpCSEClass, INSTANTIATION_EXP_CS__ARGUMENTS);

		doExpCSEClass = createEClass(DO_EXP_CS);
		createEReference(doExpCSEClass, DO_EXP_CS__CONDITION);

		exceptCSEClass = createEClass(EXCEPT_CS);
		createEReference(exceptCSEClass, EXCEPT_CS__EXCEPT);
		createEReference(exceptCSEClass, EXCEPT_CS__BODY);

		expressionBlockCSEClass = createEClass(EXPRESSION_BLOCK_CS);
		createEReference(expressionBlockCSEClass, EXPRESSION_BLOCK_CS__BODY);

		expressionStatementCSEClass = createEClass(EXPRESSION_STATEMENT_CS);
		createEReference(expressionStatementCSEClass, EXPRESSION_STATEMENT_CS__OCL_EXPRESSION_CS);

		forExpCSEClass = createEClass(FOR_EXP_CS);

		listTypeCSEClass = createEClass(LIST_TYPE_CS);
		createEReference(listTypeCSEClass, LIST_TYPE_CS__TYPE);

		listLiteralExpCSEClass = createEClass(LIST_LITERAL_EXP_CS);
		createEReference(listLiteralExpCSEClass, LIST_LITERAL_EXP_CS__OWNED_PARTS);

		logExpCSEClass = createEClass(LOG_EXP_CS);
		createEReference(logExpCSEClass, LOG_EXP_CS__CONDITION);

		quitExpCSEClass = createEClass(QUIT_EXP_CS);
		createEAttribute(quitExpCSEClass, QUIT_EXP_CS__KEYWORD);
		createEReference(quitExpCSEClass, QUIT_EXP_CS__VALUE);

		raiseExpCSEClass = createEClass(RAISE_EXP_CS);

		returnExpCSEClass = createEClass(RETURN_EXP_CS);
		createEReference(returnExpCSEClass, RETURN_EXP_CS__VALUE);

		statementCSEClass = createEClass(STATEMENT_CS);

		switchAltCSEClass = createEClass(SWITCH_ALT_CS);
		createEReference(switchAltCSEClass, SWITCH_ALT_CS__CONDITION);
		createEReference(switchAltCSEClass, SWITCH_ALT_CS__BODY);
		createEAttribute(switchAltCSEClass, SWITCH_ALT_CS__KEYWORD);

		switchExpCSEClass = createEClass(SWITCH_EXP_CS);
		createEReference(switchExpCSEClass, SWITCH_EXP_CS__ALTERNATIVE_PART);
		createEReference(switchExpCSEClass, SWITCH_EXP_CS__ELSE_PART);

		tryExpCSEClass = createEClass(TRY_EXP_CS);
		createEReference(tryExpCSEClass, TRY_EXP_CS__CATCH);

		variableInitializationCSEClass = createEClass(VARIABLE_INITIALIZATION_CS);
		createEReference(variableInitializationCSEClass, VARIABLE_INITIALIZATION_CS__OCL_EXPRESSION_CS);
		createEAttribute(variableInitializationCSEClass, VARIABLE_INITIALIZATION_CS__SIMPLE_NAME_CS);
		createEReference(variableInitializationCSEClass, VARIABLE_INITIALIZATION_CS__TYPE_CS);
		createEAttribute(variableInitializationCSEClass, VARIABLE_INITIALIZATION_CS__WITH_RESULT);

		whileExpCSEClass = createEClass(WHILE_EXP_CS);
		createEReference(whileExpCSEClass, WHILE_EXP_CS__CONDITION);
		createEReference(whileExpCSEClass, WHILE_EXP_CS__RESULT_VAR);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
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
		EssentialOCLCSTPackage theEssentialOCLCSTPackage = (EssentialOCLCSTPackage)EPackage.Registry.INSTANCE.getEPackage(EssentialOCLCSTPackage.eNS_URI);
		BaseCSTPackage theBaseCSTPackage = (BaseCSTPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSTPackage.eNS_URI);
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		assertExpCSEClass.getESuperTypes().add(this.getStatementCS());
		assignStatementCSEClass.getESuperTypes().add(this.getStatementCS());
		blockExpCSEClass.getESuperTypes().add(this.getStatementCS());
		dictLiteralExpCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getExpCS());
		dictLiteralPartCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		dictTypeCSEClass.getESuperTypes().add(theBaseCSTPackage.getTypedRefCS());
		computeExpCSEClass.getESuperTypes().add(this.getExpressionBlockCS());
		imperativeIterateExpCSEClass.getESuperTypes().add(this.getImperativeLoopExpCS());
		imperativeLoopExpCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getInvocationExpCS());
		imperativeLoopExpCSEClass.getESuperTypes().add(this.getStatementCS());
		instantiationExpCSEClass.getESuperTypes().add(this.getStatementCS());
		doExpCSEClass.getESuperTypes().add(this.getExpressionBlockCS());
		exceptCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		expressionBlockCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getExpCS());
		expressionStatementCSEClass.getESuperTypes().add(this.getStatementCS());
		forExpCSEClass.getESuperTypes().add(this.getImperativeLoopExpCS());
		listTypeCSEClass.getESuperTypes().add(theBaseCSTPackage.getTypedRefCS());
		listLiteralExpCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getExpCS());
		logExpCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getInvocationExpCS());
		quitExpCSEClass.getESuperTypes().add(this.getStatementCS());
		raiseExpCSEClass.getESuperTypes().add(this.getStatementCS());
		returnExpCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getExpCS());
		statementCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getExpCS());
		switchAltCSEClass.getESuperTypes().add(this.getStatementCS());
		switchExpCSEClass.getESuperTypes().add(this.getStatementCS());
		tryExpCSEClass.getESuperTypes().add(this.getExpressionBlockCS());
		variableInitializationCSEClass.getESuperTypes().add(this.getStatementCS());
		whileExpCSEClass.getESuperTypes().add(this.getExpressionBlockCS());

		// Initialize classes and features; add operations and parameters
		initEClass(assertExpCSEClass, AssertExpCS.class, "AssertExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssertExpCS_Assertion(), theEssentialOCLCSTPackage.getExpCS(), null, "assertion", null, 1, 1, AssertExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssertExpCS_Log(), this.getLogExpCS(), null, "log", null, 0, 1, AssertExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssertExpCS_Severity(), ecorePackage.getEString(), "severity", null, 0, 1, AssertExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assignStatementCSEClass, AssignStatementCS.class, "AssignStatementCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssignStatementCS_LValueCS(), theEssentialOCLCSTPackage.getExpCS(), null, "lValueCS", null, 0, 1, AssignStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssignStatementCS_OclExpressionCS(), theEssentialOCLCSTPackage.getExpCS(), null, "oclExpressionCS", null, 0, 1, AssignStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssignStatementCS_Incremental(), ecorePackage.getEBoolean(), "incremental", null, 0, 1, AssignStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(blockExpCSEClass, BlockExpCS.class, "BlockExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlockExpCS_BodyExpressions(), theEssentialOCLCSTPackage.getExpCS(), null, "bodyExpressions", null, 0, -1, BlockExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dictLiteralExpCSEClass, DictLiteralExpCS.class, "DictLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDictLiteralExpCS_OwnedParts(), this.getDictLiteralPartCS(), null, "ownedParts", null, 0, -1, DictLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dictLiteralPartCSEClass, DictLiteralPartCS.class, "DictLiteralPartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDictLiteralPartCS_Key(), theEssentialOCLCSTPackage.getPrimitiveLiteralExpCS(), null, "key", null, 0, 1, DictLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDictLiteralPartCS_Value(), theEssentialOCLCSTPackage.getExpCS(), null, "value", null, 0, 1, DictLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dictTypeCSEClass, DictTypeCS.class, "DictTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDictTypeCS_KeyType(), theBaseCSTPackage.getTypedRefCS(), null, "keyType", null, 0, 1, DictTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDictTypeCS_ValueType(), theBaseCSTPackage.getTypedRefCS(), null, "valueType", null, 0, 1, DictTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(computeExpCSEClass, ComputeExpCS.class, "ComputeExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComputeExpCS_ReturnedElement(), theEssentialOCLCSTPackage.getVariableCS(), null, "returnedElement", null, 1, 1, ComputeExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imperativeIterateExpCSEClass, ImperativeIterateExpCS.class, "ImperativeIterateExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImperativeIterateExpCS_Target(), theEssentialOCLCSTPackage.getVariableCS(), null, "target", null, 0, 1, ImperativeIterateExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imperativeLoopExpCSEClass, ImperativeLoopExpCS.class, "ImperativeLoopExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImperativeLoopExpCS_Condition(), theEssentialOCLCSTPackage.getExpCS(), null, "condition", null, 1, 1, ImperativeLoopExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(instantiationExpCSEClass, InstantiationExpCS.class, "InstantiationExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstantiationExpCS_TypeSpecCS(), theBaseCSTPackage.getTypeCS(), null, "typeSpecCS", null, 1, 1, InstantiationExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstantiationExpCS_Arguments(), theEssentialOCLCSTPackage.getExpCS(), null, "arguments", null, 0, -1, InstantiationExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(doExpCSEClass, DoExpCS.class, "DoExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDoExpCS_Condition(), theEssentialOCLCSTPackage.getExpCS(), null, "condition", null, 0, 1, DoExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exceptCSEClass, ExceptCS.class, "ExceptCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExceptCS_Except(), thePivotPackage.getType(), null, "except", null, 0, -1, ExceptCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExceptCS_Body(), theEssentialOCLCSTPackage.getExpCS(), null, "body", null, 0, 1, ExceptCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionBlockCSEClass, ExpressionBlockCS.class, "ExpressionBlockCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionBlockCS_Body(), theEssentialOCLCSTPackage.getExpCS(), null, "body", null, 0, -1, ExpressionBlockCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionStatementCSEClass, ExpressionStatementCS.class, "ExpressionStatementCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionStatementCS_OclExpressionCS(), theEssentialOCLCSTPackage.getExpCS(), null, "oclExpressionCS", null, 0, 1, ExpressionStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forExpCSEClass, ForExpCS.class, "ForExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(listTypeCSEClass, ListTypeCS.class, "ListTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getListTypeCS_Type(), theBaseCSTPackage.getTypedRefCS(), null, "type", null, 0, 1, ListTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listLiteralExpCSEClass, ListLiteralExpCS.class, "ListLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getListLiteralExpCS_OwnedParts(), theEssentialOCLCSTPackage.getCollectionLiteralPartCS(), null, "ownedParts", null, 0, -1, ListLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(logExpCSEClass, LogExpCS.class, "LogExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLogExpCS_Condition(), theEssentialOCLCSTPackage.getExpCS(), null, "condition", null, 0, 1, LogExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(quitExpCSEClass, QuitExpCS.class, "QuitExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQuitExpCS_Keyword(), ecorePackage.getEString(), "keyword", null, 0, 1, QuitExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQuitExpCS_Value(), theEssentialOCLCSTPackage.getExpCS(), null, "value", null, 0, 1, QuitExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(raiseExpCSEClass, RaiseExpCS.class, "RaiseExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(returnExpCSEClass, ReturnExpCS.class, "ReturnExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReturnExpCS_Value(), theEssentialOCLCSTPackage.getExpCS(), null, "value", null, 0, 1, ReturnExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statementCSEClass, StatementCS.class, "StatementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(switchAltCSEClass, SwitchAltCS.class, "SwitchAltCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwitchAltCS_Condition(), theEssentialOCLCSTPackage.getExpCS(), null, "condition", null, 1, 1, SwitchAltCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchAltCS_Body(), theEssentialOCLCSTPackage.getExpCS(), null, "body", null, 1, 1, SwitchAltCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSwitchAltCS_Keyword(), ecorePackage.getEString(), "keyword", null, 0, 1, SwitchAltCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchExpCSEClass, SwitchExpCS.class, "SwitchExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwitchExpCS_AlternativePart(), this.getSwitchAltCS(), null, "alternativePart", null, 1, -1, SwitchExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchExpCS_ElsePart(), theEssentialOCLCSTPackage.getExpCS(), null, "elsePart", null, 0, 1, SwitchExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tryExpCSEClass, TryExpCS.class, "TryExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTryExpCS_Catch(), this.getExceptCS(), null, "catch", null, 0, -1, TryExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableInitializationCSEClass, VariableInitializationCS.class, "VariableInitializationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableInitializationCS_OclExpressionCS(), theEssentialOCLCSTPackage.getExpCS(), null, "oclExpressionCS", null, 0, 1, VariableInitializationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariableInitializationCS_SimpleNameCS(), ecorePackage.getEString(), "simpleNameCS", null, 0, 1, VariableInitializationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableInitializationCS_TypeCS(), theBaseCSTPackage.getTypeCS(), null, "typeCS", null, 0, 1, VariableInitializationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariableInitializationCS_WithResult(), ecorePackage.getEBoolean(), "withResult", "false", 1, 1, VariableInitializationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(whileExpCSEClass, WhileExpCS.class, "WhileExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWhileExpCS_Condition(), theEssentialOCLCSTPackage.getExpCS(), null, "condition", null, 0, 1, WhileExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWhileExpCS_ResultVar(), theEssentialOCLCSTPackage.getVariableCS(), null, "resultVar", null, 0, 1, WhileExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // ImperativeoclcsPackageImpl
