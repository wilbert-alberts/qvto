/**
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs;

import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.NameExpCS#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.NameExpCS#isAtPre <em>At Pre</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#getNameExpCS()
 * @model
 * @generated
 */
public interface NameExpCS extends ExpCS
{
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
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#getNameExpCS_PathName()
	 * @model containment="true"
	 * @generated
	 */
  PathNameCS getPathName();

  /**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.NameExpCS#getPathName <em>Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Name</em>' containment reference.
	 * @see #getPathName()
	 * @generated
	 */
  void setPathName(PathNameCS value);

  /**
	 * Returns the value of the '<em><b>At Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>At Pre</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>At Pre</em>' attribute.
	 * @see #setAtPre(boolean)
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#getNameExpCS_AtPre()
	 * @model
	 * @generated
	 */
  boolean isAtPre();

  /**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.NameExpCS#isAtPre <em>At Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>At Pre</em>' attribute.
	 * @see #isAtPre()
	 * @generated
	 */
  void setAtPre(boolean value);

} // NameExpCS
