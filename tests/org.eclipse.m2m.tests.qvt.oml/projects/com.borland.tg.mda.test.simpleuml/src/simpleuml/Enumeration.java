/**
 * <copyright>
 * </copyright>
 *
 * $Id: Enumeration.java,v 1.1 2007/07/29 21:25:31 radvorak Exp $
 */
package simpleuml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link simpleuml.Enumeration#getOwnedLiteral <em>Owned Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see simpleuml.SimpleumlPackage#getEnumeration()
 * @model
 * @generated
 */
public interface Enumeration extends Type{
    /**
     * Returns the value of the '<em><b>Owned Literal</b></em>' containment reference list.
     * The list contents are of type {@link simpleuml.EnumerationLiteral}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Literal</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Owned Literal</em>' containment reference list.
     * @see simpleuml.SimpleumlPackage#getEnumeration_OwnedLiteral()
     * @model type="simpleuml.EnumerationLiteral" containment="true"
     * @generated
     */
	EList getOwnedLiteral();

} // Enumeration
