/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.ocl.examples.xtext.base.basecs.TypeCS;


/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Resolve In Exp CS</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveInExpCS#getInMappingType <em>In Mapping Type</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveInExpCS#getInMappingName <em>In Mapping Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getResolveInExpCS()
 * @model
 * @generated
 */
public interface ResolveInExpCS
		extends ResolveExpCS {

	/**
	 * Returns the value of the '<em><b>In Mapping Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Mapping Type</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Mapping Type</em>' containment reference.
	 * @see #setInMappingType(TypeCS)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getResolveInExpCS_InMappingType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TypeCS getInMappingType();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveInExpCS#getInMappingType <em>In Mapping Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Mapping Type</em>' containment reference.
	 * @see #getInMappingType()
	 * @generated
	 */
	void setInMappingType(TypeCS value);

	/**
	 * Returns the value of the '<em><b>In Mapping Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Mapping Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Mapping Name</em>' attribute.
	 * @see #setInMappingName(String)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getResolveInExpCS_InMappingName()
	 * @model required="true"
	 * @generated
	 */
	String getInMappingName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveInExpCS#getInMappingName <em>In Mapping Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>In Mapping Name</em>' attribute.
	 * @see #getInMappingName()
	 * @generated
	 */
	void setInMappingName(String value);

} // ResolveInExpCS
