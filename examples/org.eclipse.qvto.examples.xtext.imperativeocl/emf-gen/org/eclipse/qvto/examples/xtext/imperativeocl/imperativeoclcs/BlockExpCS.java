/**
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Block Exp CS</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.BlockExpCS#getBodyExpressions <em>Body Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeOCLCSPackage#getBlockExpCS()
 * @model
 * @generated
 */
public interface BlockExpCS
		extends StatementCS {

	/**
	 * Returns the value of the '<em><b>Body Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Expressions</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Expressions</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeOCLCSPackage#getBlockExpCS_BodyExpressions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExpCS> getBodyExpressions();

} // BlockExpCS
