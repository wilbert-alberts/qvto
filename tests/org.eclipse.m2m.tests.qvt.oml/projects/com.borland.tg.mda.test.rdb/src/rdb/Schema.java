/**
 * <copyright>
 * </copyright>
 *
 * $Id: Schema.java,v 1.1 2007/07/29 21:25:29 radvorak Exp $
 */
package rdb;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Schema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rdb.Schema#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see rdb.RdbPackage#getSchema()
 * @model
 * @generated
 */
public interface Schema extends NamedElement{
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link rdb.SchemaElement}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see rdb.RdbPackage#getSchema_Elements()
	 * @model type="rdb.SchemaElement" containment="true"
	 * @generated
	 */
    EList getElements();

} // Schema
