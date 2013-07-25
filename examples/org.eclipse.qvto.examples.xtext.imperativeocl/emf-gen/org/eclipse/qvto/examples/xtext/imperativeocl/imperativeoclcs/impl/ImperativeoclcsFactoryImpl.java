/**
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.*;
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
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.SwitchAltCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.SwitchExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.TryExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.VariableInitializationCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.WhileExpCS;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class ImperativeoclcsFactoryImpl
		extends EFactoryImpl
		implements ImperativeoclcsFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static ImperativeoclcsFactory init() {
		try {
			ImperativeoclcsFactory theImperativeoclcsFactory = (ImperativeoclcsFactory)EPackage.Registry.INSTANCE.getEFactory(ImperativeoclcsPackage.eNS_URI);
			if (theImperativeoclcsFactory != null) {
				return theImperativeoclcsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ImperativeoclcsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public ImperativeoclcsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ImperativeoclcsPackage.ASSERT_EXP_CS: return createAssertExpCS();
			case ImperativeoclcsPackage.ASSIGN_STATEMENT_CS: return createAssignStatementCS();
			case ImperativeoclcsPackage.BLOCK_EXP_CS: return createBlockExpCS();
			case ImperativeoclcsPackage.DICT_LITERAL_EXP_CS: return createDictLiteralExpCS();
			case ImperativeoclcsPackage.DICT_LITERAL_PART_CS: return createDictLiteralPartCS();
			case ImperativeoclcsPackage.DICT_TYPE_CS: return createDictTypeCS();
			case ImperativeoclcsPackage.COMPUTE_EXP_CS: return createComputeExpCS();
			case ImperativeoclcsPackage.IMPERATIVE_ITERATE_EXP_CS: return createImperativeIterateExpCS();
			case ImperativeoclcsPackage.IMPERATIVE_LOOP_EXP_CS: return createImperativeLoopExpCS();
			case ImperativeoclcsPackage.INSTANTIATION_EXP_CS: return createInstantiationExpCS();
			case ImperativeoclcsPackage.DO_EXP_CS: return createDoExpCS();
			case ImperativeoclcsPackage.EXCEPT_CS: return createExceptCS();
			case ImperativeoclcsPackage.EXPRESSION_BLOCK_CS: return createExpressionBlockCS();
			case ImperativeoclcsPackage.EXPRESSION_STATEMENT_CS: return createExpressionStatementCS();
			case ImperativeoclcsPackage.FOR_EXP_CS: return createForExpCS();
			case ImperativeoclcsPackage.LIST_TYPE_CS: return createListTypeCS();
			case ImperativeoclcsPackage.LIST_LITERAL_EXP_CS: return createListLiteralExpCS();
			case ImperativeoclcsPackage.LOG_EXP_CS: return createLogExpCS();
			case ImperativeoclcsPackage.QUIT_EXP_CS: return createQuitExpCS();
			case ImperativeoclcsPackage.RAISE_EXP_CS: return createRaiseExpCS();
			case ImperativeoclcsPackage.RETURN_EXP_CS: return createReturnExpCS();
			case ImperativeoclcsPackage.SWITCH_ALT_CS: return createSwitchAltCS();
			case ImperativeoclcsPackage.SWITCH_EXP_CS: return createSwitchExpCS();
			case ImperativeoclcsPackage.TRY_EXP_CS: return createTryExpCS();
			case ImperativeoclcsPackage.VARIABLE_INITIALIZATION_CS: return createVariableInitializationCS();
			case ImperativeoclcsPackage.WHILE_EXP_CS: return createWhileExpCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AssertExpCS createAssertExpCS() {
		AssertExpCSImpl assertExpCS = new AssertExpCSImpl();
		return assertExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AssignStatementCS createAssignStatementCS() {
		AssignStatementCSImpl assignStatementCS = new AssignStatementCSImpl();
		return assignStatementCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BlockExpCS createBlockExpCS() {
		BlockExpCSImpl blockExpCS = new BlockExpCSImpl();
		return blockExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ListTypeCS createListTypeCS() {
		ListTypeCSImpl listTypeCS = new ListTypeCSImpl();
		return listTypeCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DictTypeCS createDictTypeCS() {
		DictTypeCSImpl dictTypeCS = new DictTypeCSImpl();
		return dictTypeCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ComputeExpCS createComputeExpCS() {
		ComputeExpCSImpl computeExpCS = new ComputeExpCSImpl();
		return computeExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeIterateExpCS createImperativeIterateExpCS() {
		ImperativeIterateExpCSImpl imperativeIterateExpCS = new ImperativeIterateExpCSImpl();
		return imperativeIterateExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeLoopExpCS createImperativeLoopExpCS() {
		ImperativeLoopExpCSImpl imperativeLoopExpCS = new ImperativeLoopExpCSImpl();
		return imperativeLoopExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InstantiationExpCS createInstantiationExpCS() {
		InstantiationExpCSImpl instantiationExpCS = new InstantiationExpCSImpl();
		return instantiationExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DoExpCS createDoExpCS() {
		DoExpCSImpl doExpCS = new DoExpCSImpl();
		return doExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExceptCS createExceptCS() {
		ExceptCSImpl exceptCS = new ExceptCSImpl();
		return exceptCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionBlockCS createExpressionBlockCS() {
		ExpressionBlockCSImpl expressionBlockCS = new ExpressionBlockCSImpl();
		return expressionBlockCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionStatementCS createExpressionStatementCS() {
		ExpressionStatementCSImpl expressionStatementCS = new ExpressionStatementCSImpl();
		return expressionStatementCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ForExpCS createForExpCS() {
		ForExpCSImpl forExpCS = new ForExpCSImpl();
		return forExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ListLiteralExpCS createListLiteralExpCS() {
		ListLiteralExpCSImpl listLiteralExpCS = new ListLiteralExpCSImpl();
		return listLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LogExpCS createLogExpCS() {
		LogExpCSImpl logExpCS = new LogExpCSImpl();
		return logExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public QuitExpCS createQuitExpCS() {
		QuitExpCSImpl quitExpCS = new QuitExpCSImpl();
		return quitExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RaiseExpCS createRaiseExpCS() {
		RaiseExpCSImpl raiseExpCS = new RaiseExpCSImpl();
		return raiseExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DictLiteralExpCS createDictLiteralExpCS() {
		DictLiteralExpCSImpl dictLiteralExpCS = new DictLiteralExpCSImpl();
		return dictLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DictLiteralPartCS createDictLiteralPartCS() {
		DictLiteralPartCSImpl dictLiteralPartCS = new DictLiteralPartCSImpl();
		return dictLiteralPartCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReturnExpCS createReturnExpCS() {
		ReturnExpCSImpl returnExpCS = new ReturnExpCSImpl();
		return returnExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchAltCS createSwitchAltCS() {
		SwitchAltCSImpl switchAltCS = new SwitchAltCSImpl();
		return switchAltCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchExpCS createSwitchExpCS() {
		SwitchExpCSImpl switchExpCS = new SwitchExpCSImpl();
		return switchExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TryExpCS createTryExpCS() {
		TryExpCSImpl tryExpCS = new TryExpCSImpl();
		return tryExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VariableInitializationCS createVariableInitializationCS() {
		VariableInitializationCSImpl variableInitializationCS = new VariableInitializationCSImpl();
		return variableInitializationCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WhileExpCS createWhileExpCS() {
		WhileExpCSImpl whileExpCS = new WhileExpCSImpl();
		return whileExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeoclcsPackage getImperativeoclcsPackage() {
		return (ImperativeoclcsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ImperativeoclcsPackage getPackage() {
		return ImperativeoclcsPackage.eINSTANCE;
	}

} // ImperativeoclcsFactoryImpl
