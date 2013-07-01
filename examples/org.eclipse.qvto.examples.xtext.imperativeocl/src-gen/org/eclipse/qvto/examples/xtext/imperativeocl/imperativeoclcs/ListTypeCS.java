/**
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs;

import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Type CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListTypeCS#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#getListTypeCS()
 * @model
 * @generated
 */
public interface ListTypeCS extends TypedRefCS
{
  /**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(TypedRefCS)
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#getListTypeCS_Type()
	 * @model containment="true"
	 * @generated
	 */
  TypedRefCS getType();

  /**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListTypeCS#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
  void setType(TypedRefCS value);

} // ListTypeCS
