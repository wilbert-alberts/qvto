/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typedef CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS#getTypespec <em>Typespec</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getTypedefCS()
 * @model
 * @generated
 */
public interface TypedefCS extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getTypedefCS_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Typespec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Typespec</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Typespec</em>' containment reference.
   * @see #setTypespec(TypedRefCS)
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getTypedefCS_Typespec()
   * @model containment="true"
   * @generated
   */
  TypedRefCS getTypespec();

  /**
   * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS#getTypespec <em>Typespec</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Typespec</em>' containment reference.
   * @see #getTypespec()
   * @generated
   */
  void setTypespec(TypedRefCS value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(ExpCS)
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getTypedefCS_Condition()
   * @model containment="true"
   * @generated
   */
  ExpCS getCondition();

  /**
   * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(ExpCS value);

} // TypedefCS
