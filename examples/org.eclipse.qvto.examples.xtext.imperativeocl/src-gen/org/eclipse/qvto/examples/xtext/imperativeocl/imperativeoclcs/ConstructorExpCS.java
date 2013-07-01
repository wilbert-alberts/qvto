/**
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ConstructorPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constructor Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ConstructorExpCS#getNameExp <em>Name Exp</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ConstructorExpCS#getOwnedParts <em>Owned Parts</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ConstructorExpCS#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#getConstructorExpCS()
 * @model
 * @generated
 */
public interface ConstructorExpCS extends ExpCS
{
  /**
	 * Returns the value of the '<em><b>Name Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name Exp</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Name Exp</em>' containment reference.
	 * @see #setNameExp(NameExpCS)
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#getConstructorExpCS_NameExp()
	 * @model containment="true"
	 * @generated
	 */
  NameExpCS getNameExp();

  /**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ConstructorExpCS#getNameExp <em>Name Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Exp</em>' containment reference.
	 * @see #getNameExp()
	 * @generated
	 */
  void setNameExp(NameExpCS value);

  /**
	 * Returns the value of the '<em><b>Owned Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ConstructorPartCS}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Parts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Parts</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#getConstructorExpCS_OwnedParts()
	 * @model containment="true"
	 * @generated
	 */
  EList<ConstructorPartCS> getOwnedParts();

  /**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#getConstructorExpCS_Value()
	 * @model
	 * @generated
	 */
  String getValue();

  /**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ConstructorExpCS#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
  void setValue(String value);

} // ConstructorExpCS
