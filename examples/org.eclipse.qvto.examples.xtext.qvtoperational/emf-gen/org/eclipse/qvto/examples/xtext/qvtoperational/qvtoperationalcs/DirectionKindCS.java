/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Direction Kind CS</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindCS#getDirectionKind <em>Direction Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getDirectionKindCS()
 * @model
 * @generated
 */
public interface DirectionKindCS
		extends ElementCS {

	/**
	 * Returns the value of the '<em><b>Direction Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction Kind</em>' attribute.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindEnum
	 * @see #setDirectionKind(DirectionKindEnum)
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#getDirectionKindCS_DirectionKind()
	 * @model
	 * @generated
	 */
	DirectionKindEnum getDirectionKind();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindCS#getDirectionKind <em>Direction Kind</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Direction Kind</em>' attribute.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindEnum
	 * @see #getDirectionKind()
	 * @generated
	 */
	void setDirectionKind(DirectionKindEnum value);

} // DirectionKindCS
