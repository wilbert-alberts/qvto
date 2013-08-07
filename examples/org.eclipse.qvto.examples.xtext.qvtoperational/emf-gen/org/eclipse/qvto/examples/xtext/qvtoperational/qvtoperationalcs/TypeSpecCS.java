/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Type Spec CS</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS#getTypeCS <em>Type CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS#getSimpleNameCS <em>Simple Name CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getTypeSpecCS()
 * @model
 * @generated
 */
public interface TypeSpecCS
		extends ElementCS {

	/**
	 * Returns the value of the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type CS</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type CS</em>' containment reference.
	 * @see #setTypeCS(TypeCS)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getTypeSpecCS_TypeCS()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TypeCS getTypeCS();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS#getTypeCS <em>Type CS</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Type CS</em>' containment reference.
	 * @see #getTypeCS()
	 * @generated
	 */
	void setTypeCS(TypeCS value);

	/**
	 * Returns the value of the '<em><b>Simple Name CS</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Name CS</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Simple Name CS</em>' attribute.
	 * @see #setSimpleNameCS(String)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getTypeSpecCS_SimpleNameCS()
	 * @model
	 * @generated
	 */
	String getSimpleNameCS();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS#getSimpleNameCS <em>Simple Name CS</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Simple Name CS</em>' attribute.
	 * @see #getSimpleNameCS()
	 * @generated
	 */
	void setSimpleNameCS(String value);

} // TypeSpecCS
