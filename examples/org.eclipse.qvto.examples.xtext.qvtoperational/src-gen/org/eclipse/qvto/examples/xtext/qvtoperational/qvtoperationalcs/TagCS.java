/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs;

import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tag CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getTagCS()
 * @model
 * @generated
 */
public interface TagCS extends MetamodelElementCS, ClassifierFeatureCS
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getTagCS_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Path Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Path Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Path Name</em>' containment reference.
   * @see #setPathName(PathNameCS)
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getTagCS_PathName()
   * @model containment="true"
   * @generated
   */
  PathNameCS getPathName();

  /**
   * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS#getPathName <em>Path Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Path Name</em>' containment reference.
   * @see #getPathName()
   * @generated
   */
  void setPathName(PathNameCS value);

  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(ExpCS)
   * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#getTagCS_Expression()
   * @model containment="true"
   * @generated
   */
  ExpCS getExpression();

  /**
   * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(ExpCS value);

} // TagCS
