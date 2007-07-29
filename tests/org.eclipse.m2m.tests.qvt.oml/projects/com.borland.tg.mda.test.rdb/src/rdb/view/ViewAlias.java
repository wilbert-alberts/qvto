/**
 * <copyright>
 * </copyright>
 *
 * $Id: ViewAlias.java,v 1.1 2007/07/29 21:25:33 radvorak Exp $
 */
package rdb.view;

import rdb.NamedColumnSet;
import rdb.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alias</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rdb.view.ViewAlias#getReferencedTableOrView <em>Referenced Table Or View</em>}</li>
 * </ul>
 * </p>
 *
 * @see rdb.view.ViewPackage#getViewAlias()
 * @model
 * @generated
 */
public interface ViewAlias extends NamedElement{
	/**
	 * Returns the value of the '<em><b>Referenced Table Or View</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Referenced Table Or View</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Table Or View</em>' reference.
	 * @see #setReferencedTableOrView(NamedColumnSet)
	 * @see rdb.view.ViewPackage#getViewAlias_ReferencedTableOrView()
	 * @model required="true"
	 * @generated
	 */
    NamedColumnSet getReferencedTableOrView();

	/**
	 * Sets the value of the '{@link rdb.view.ViewAlias#getReferencedTableOrView <em>Referenced Table Or View</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Table Or View</em>' reference.
	 * @see #getReferencedTableOrView()
	 * @generated
	 */
    void setReferencedTableOrView(NamedColumnSet value);

} // ViewAlias
