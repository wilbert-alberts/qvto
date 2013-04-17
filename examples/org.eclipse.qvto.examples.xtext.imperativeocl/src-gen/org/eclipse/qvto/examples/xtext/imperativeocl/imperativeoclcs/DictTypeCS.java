/**
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs;

import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dict Type CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS#getOwnedKeyTypeCS <em>Owned Key Type CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS#getOwnedElementTypeCS <em>Owned Element Type CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#getDictTypeCS()
 * @model
 * @generated
 */
public interface DictTypeCS extends TypedRefCS
{
  /**
   * Returns the value of the '<em><b>Owned Key Type CS</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Key Type CS</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Key Type CS</em>' containment reference.
   * @see #setOwnedKeyTypeCS(TypedRefCS)
   * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#getDictTypeCS_OwnedKeyTypeCS()
   * @model containment="true"
   * @generated
   */
  TypedRefCS getOwnedKeyTypeCS();

  /**
   * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS#getOwnedKeyTypeCS <em>Owned Key Type CS</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owned Key Type CS</em>' containment reference.
   * @see #getOwnedKeyTypeCS()
   * @generated
   */
  void setOwnedKeyTypeCS(TypedRefCS value);

  /**
   * Returns the value of the '<em><b>Owned Element Type CS</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Element Type CS</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Element Type CS</em>' containment reference.
   * @see #setOwnedElementTypeCS(TypedRefCS)
   * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#getDictTypeCS_OwnedElementTypeCS()
   * @model containment="true"
   * @generated
   */
  TypedRefCS getOwnedElementTypeCS();

  /**
   * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS#getOwnedElementTypeCS <em>Owned Element Type CS</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owned Element Type CS</em>' containment reference.
   * @see #getOwnedElementTypeCS()
   * @generated
   */
  void setOwnedElementTypeCS(TypedRefCS value);

} // DictTypeCS
