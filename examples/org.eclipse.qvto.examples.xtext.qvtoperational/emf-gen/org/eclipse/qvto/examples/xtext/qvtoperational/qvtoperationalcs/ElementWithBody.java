/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Element With Body</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ElementWithBody#getBodyStartLocation <em>Body Start Location</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ElementWithBody#getBodyEndLocation <em>Body End Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getElementWithBody()
 * @model abstract="true"
 * @generated
 */
public interface ElementWithBody
		extends ElementCS {

	/**
	 * Returns the value of the '<em><b>Body Start Location</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Start Location</em>' attribute isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Start Location</em>' attribute.
	 * @see #setBodyStartLocation(int)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getElementWithBody_BodyStartLocation()
	 * @model default="0"
	 * @generated
	 */
	int getBodyStartLocation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ElementWithBody#getBodyStartLocation <em>Body Start Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Body Start Location</em>' attribute.
	 * @see #getBodyStartLocation()
	 * @generated
	 */
	void setBodyStartLocation(int value);

	/**
	 * Returns the value of the '<em><b>Body End Location</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body End Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body End Location</em>' attribute.
	 * @see #setBodyEndLocation(int)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getElementWithBody_BodyEndLocation()
	 * @model default="0"
	 * @generated
	 */
	int getBodyEndLocation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ElementWithBody#getBodyEndLocation <em>Body End Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Body End Location</em>' attribute.
	 * @see #getBodyEndLocation()
	 * @generated
	 */
	void setBodyEndLocation(int value);

} // ElementWithBody
