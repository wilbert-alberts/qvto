/**
 * <copyright>
 * </copyright>
 *
 * $Id: Domain.java,v 1.1 2007/07/29 21:25:36 radvorak Exp $
 */
package rdb.datatypes;

import rdb.SchemaElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rdb.datatypes.Domain#getParentDomain <em>Parent Domain</em>}</li>
 * </ul>
 * </p>
 *
 * @see rdb.datatypes.DatatypesPackage#getDomain()
 * @model
 * @generated
 */
public interface Domain extends SchemaElement, PrimitiveDataType{
	/**
	 * Returns the value of the '<em><b>Parent Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent Domain</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Domain</em>' reference.
	 * @see #setParentDomain(Domain)
	 * @see rdb.datatypes.DatatypesPackage#getDomain_ParentDomain()
	 * @model
	 * @generated
	 */
    Domain getParentDomain();

	/**
	 * Sets the value of the '{@link rdb.datatypes.Domain#getParentDomain <em>Parent Domain</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Domain</em>' reference.
	 * @see #getParentDomain()
	 * @generated
	 */
    void setParentDomain(Domain value);

} // Domain
