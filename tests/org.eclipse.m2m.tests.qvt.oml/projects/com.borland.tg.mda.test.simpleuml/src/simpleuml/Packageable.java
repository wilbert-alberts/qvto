/**
 * <copyright>
 * </copyright>
 *
 * $Id: Packageable.java,v 1.1 2007/07/29 21:25:31 radvorak Exp $
 */
package simpleuml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Packageable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link simpleuml.Packageable#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see simpleuml.SimpleumlPackage#getPackageable()
 * @model abstract="true"
 * @generated
 */
public interface Packageable extends EObject{
    /**
     * Returns the value of the '<em><b>Owner</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link simpleuml.Package#getOwnedElements <em>Owned Elements</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Owner</em>' container reference.
     * @see #setOwner(simpleuml.Package)
     * @see simpleuml.SimpleumlPackage#getPackageable_Owner()
     * @see simpleuml.Package#getOwnedElements
     * @model opposite="ownedElements"
     * @generated
     */
	simpleuml.Package getOwner();

    /**
     * Sets the value of the '{@link simpleuml.Packageable#getOwner <em>Owner</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Owner</em>' container reference.
     * @see #getOwner()
     * @generated
     */
	void setOwner(simpleuml.Package value);

} // Packageable
