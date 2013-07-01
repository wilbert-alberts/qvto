/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS#getUnit <em>Unit</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS#isAll <em>All</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getImportCS()
 * @model
 * @generated
 */
public interface ImportCS extends EObject
{
  /**
   * Returns the value of the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unit</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unit</em>' containment reference.
   * @see #setUnit(UnitCS)
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getImportCS_Unit()
   * @model containment="true"
   * @generated
   */
  UnitCS getUnit();

  /**
   * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS#getUnit <em>Unit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit</em>' containment reference.
   * @see #getUnit()
   * @generated
   */
  void setUnit(UnitCS value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute list.
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getImportCS_Name()
   * @model unique="false"
   * @generated
   */
  EList<String> getName();

  /**
   * Returns the value of the '<em><b>All</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>All</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>All</em>' attribute.
   * @see #setAll(boolean)
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getImportCS_All()
   * @model
   * @generated
   */
  boolean isAll();

  /**
   * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS#isAll <em>All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>All</em>' attribute.
   * @see #isAll()
   * @generated
   */
  void setAll(boolean value);

} // ImportCS
