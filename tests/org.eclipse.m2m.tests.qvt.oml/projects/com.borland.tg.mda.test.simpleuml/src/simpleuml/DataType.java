/**
 * <copyright>
 * </copyright>
 *
 * $Id: DataType.java,v 1.1 2007/07/29 21:25:31 radvorak Exp $
 */
package simpleuml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link simpleuml.DataType#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see simpleuml.SimpleumlPackage#getDataType()
 * @model
 * @generated
 */
public interface DataType extends Type{
    /**
     * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
     * The list contents are of type {@link simpleuml.Property}.
     * It is bidirectional and its opposite is '{@link simpleuml.Property#getOwner <em>Owner</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Attributes</em>' containment reference list.
     * @see simpleuml.SimpleumlPackage#getDataType_Attributes()
     * @see simpleuml.Property#getOwner
     * @model type="simpleuml.Property" opposite="owner" containment="true"
     * @generated
     */
	EList getAttributes();

} // DataType
