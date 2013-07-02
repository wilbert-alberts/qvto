/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Enumeration CS</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.EnumerationCS#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.EnumerationCS#getLiteral
 * <em>Literal</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getEnumerationCS()
 * @model
 * @generated
 */
public interface EnumerationCS
		extends MetamodelElementCS {

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getEnumerationCS_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.EnumerationCS#getName
	 * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Literal</b></em>' attribute list. The
	 * list contents are of type {@link java.lang.String}. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Literal</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Literal</em>' attribute list.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getEnumerationCS_Literal()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getLiteral();

} // EnumerationCS
