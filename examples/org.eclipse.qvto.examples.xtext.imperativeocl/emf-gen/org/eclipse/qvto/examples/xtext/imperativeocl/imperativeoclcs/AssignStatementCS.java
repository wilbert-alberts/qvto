/**
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Assign Statement CS</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.AssignStatementCS#getLValueCS <em>LValue CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.AssignStatementCS#getOclExpressionCS <em>Ocl Expression CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.AssignStatementCS#isIncremental <em>Incremental</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeOCLCSPackage#getAssignStatementCS()
 * @model
 * @generated
 */
public interface AssignStatementCS
		extends StatementCS {

	/**
	 * Returns the value of the '<em><b>LValue CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>LValue CS</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>LValue CS</em>' containment reference.
	 * @see #setLValueCS(ExpCS)
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeOCLCSPackage#getAssignStatementCS_LValueCS()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getLValueCS();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.AssignStatementCS#getLValueCS <em>LValue CS</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>LValue CS</em>' containment reference.
	 * @see #getLValueCS()
	 * @generated
	 */
	void setLValueCS(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Ocl Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocl Expression CS</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocl Expression CS</em>' containment reference.
	 * @see #setOclExpressionCS(ExpCS)
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeOCLCSPackage#getAssignStatementCS_OclExpressionCS()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOclExpressionCS();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.AssignStatementCS#getOclExpressionCS <em>Ocl Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl Expression CS</em>' containment reference.
	 * @see #getOclExpressionCS()
	 * @generated
	 */
	void setOclExpressionCS(ExpCS value);

	/**
	 * Returns the value of the '<em><b>Incremental</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incremental</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Incremental</em>' attribute.
	 * @see #setIncremental(boolean)
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#getAssignStatementCS_Incremental()
	 * @model
	 * @generated
	 */
	boolean isIncremental();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.AssignStatementCS#isIncremental <em>Incremental</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Incremental</em>' attribute.
	 * @see #isIncremental()
	 * @generated
	 */
	void setIncremental(boolean value);

} // AssignStatementCS
