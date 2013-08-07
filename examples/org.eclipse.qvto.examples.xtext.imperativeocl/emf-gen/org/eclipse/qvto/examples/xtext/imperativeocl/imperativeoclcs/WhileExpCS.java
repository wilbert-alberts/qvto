/**
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>While Exp CS</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.WhileExpCS#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.WhileExpCS#getResultVar <em>Result Var</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeOCLCSPackage#getWhileExpCS()
 * @model
 * @generated
 */
public interface WhileExpCS
		extends ExpressionBlockCS {

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(ExpCS)
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeOCLCSPackage#getWhileExpCS_Condition()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.WhileExpCS#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Result Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Var</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Var</em>' containment reference.
	 * @see #setResultVar(VariableCS)
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeOCLCSPackage#getWhileExpCS_ResultVar()
	 * @model containment="true"
	 * @generated
	 */
	VariableCS getResultVar();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.WhileExpCS#getResultVar <em>Result Var</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Result Var</em>' containment reference.
	 * @see #getResultVar()
	 * @generated
	 */
	void setResultVar(VariableCS value);

} // WhileExpCS
