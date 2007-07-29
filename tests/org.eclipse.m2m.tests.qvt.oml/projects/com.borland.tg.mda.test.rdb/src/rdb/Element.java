/**
 * <copyright>
 * </copyright>
 *
 * $Id: Element.java,v 1.1 2007/07/29 21:25:29 radvorak Exp $
 */
package rdb;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rdb.Element#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see rdb.RdbPackage#getElement()
 * @model
 * @generated
 */
public interface Element extends EObject{
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(Element)
	 * @see rdb.RdbPackage#getElement_Parent()
	 * @model
	 * @generated
	 */
    Element getParent();

	/**
	 * Sets the value of the '{@link rdb.Element#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
    void setParent(Element value);

} // Element
