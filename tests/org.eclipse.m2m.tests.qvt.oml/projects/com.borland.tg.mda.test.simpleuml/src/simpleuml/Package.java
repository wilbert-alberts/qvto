/**
 * <copyright>
 * </copyright>
 *
 * $Id: Package.java,v 1.1 2007/07/29 21:25:31 radvorak Exp $
 */
package simpleuml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link simpleuml.Package#getOwnedElements <em>Owned Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see simpleuml.SimpleumlPackage#getPackage()
 * @model
 * @generated
 */
public interface Package extends Classifier, Packageable{
    /**
     * Returns the value of the '<em><b>Owned Elements</b></em>' containment reference list.
     * The list contents are of type {@link simpleuml.Packageable}.
     * It is bidirectional and its opposite is '{@link simpleuml.Packageable#getOwner <em>Owner</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Owned Elements</em>' containment reference list.
     * @see simpleuml.SimpleumlPackage#getPackage_OwnedElements()
     * @see simpleuml.Packageable#getOwner
     * @model type="simpleuml.Packageable" opposite="owner" containment="true"
     * @generated
     */
	EList getOwnedElements();

} // Package
