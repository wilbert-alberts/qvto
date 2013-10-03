/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.ocl.examples.xtext.base.basecs.ClassCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>QV To Class CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToClassCS#isIntermediate <em>Intermediate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getQVToClassCS()
 * @model
 * @generated
 */
public interface QVToClassCS extends ClassCS {
	/**
	 * Returns the value of the '<em><b>Intermediate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intermediate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate</em>' attribute.
	 * @see #setIntermediate(boolean)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getQVToClassCS_Intermediate()
	 * @model required="true"
	 * @generated
	 */
	boolean isIntermediate();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToClassCS#isIntermediate <em>Intermediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intermediate</em>' attribute.
	 * @see #isIntermediate()
	 * @generated
	 */
	void setIntermediate(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='ocl::Class {\n\t\t\t\tname = name,\n\t\t\t\townedAttribute = ownedProperty.ast(),\n\t\t\t\townedOperation = ownedOperation.ast()\n\t\t\t}'"
	 * @generated
	 */
	org.eclipse.ocl.examples.pivot.Class ast();

} // QVToClassCS
