/**
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveLiteralExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dict Literal Part CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralPartCS#getKeyExpCS <em>Key Exp CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralPartCS#getValueExpCS <em>Value Exp CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#getDictLiteralPartCS()
 * @model
 * @generated
 */
public interface DictLiteralPartCS extends EObject
{
  /**
   * Returns the value of the '<em><b>Key Exp CS</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Key Exp CS</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Key Exp CS</em>' containment reference.
   * @see #setKeyExpCS(PrimitiveLiteralExpCS)
   * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#getDictLiteralPartCS_KeyExpCS()
   * @model containment="true"
   * @generated
   */
  PrimitiveLiteralExpCS getKeyExpCS();

  /**
   * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralPartCS#getKeyExpCS <em>Key Exp CS</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Key Exp CS</em>' containment reference.
   * @see #getKeyExpCS()
   * @generated
   */
  void setKeyExpCS(PrimitiveLiteralExpCS value);

  /**
   * Returns the value of the '<em><b>Value Exp CS</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value Exp CS</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value Exp CS</em>' containment reference.
   * @see #setValueExpCS(ExpCS)
   * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#getDictLiteralPartCS_ValueExpCS()
   * @model containment="true"
   * @generated
   */
  ExpCS getValueExpCS();

  /**
   * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralPartCS#getValueExpCS <em>Value Exp CS</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value Exp CS</em>' containment reference.
   * @see #getValueExpCS()
   * @generated
   */
  void setValueExpCS(ExpCS value);

} // DictLiteralPartCS
