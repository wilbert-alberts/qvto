/**
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.ImperativeOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Index Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.IndexExpCS#getNameExp <em>Name Exp</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.IndexExpCS#getFirstIndexes <em>First Indexes</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.IndexExpCS#getSecondIndexes <em>Second Indexes</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.IndexExpCS#isAtPre <em>At Pre</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#getIndexExpCS()
 * @model
 * @generated
 */
public interface IndexExpCS extends ExpCS
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
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#getIndexExpCS_NameExp()
	 * @model containment="true"
	 * @generated
	 */
  NameExpCS getNameExp();

  /**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.IndexExpCS#getNameExp <em>Name Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Exp</em>' containment reference.
	 * @see #getNameExp()
	 * @generated
	 */
  void setNameExp(NameExpCS value);

  /**
	 * Returns the value of the '<em><b>First Indexes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First Indexes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>First Indexes</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#getIndexExpCS_FirstIndexes()
	 * @model containment="true"
	 * @generated
	 */
  EList<ExpCS> getFirstIndexes();

  /**
	 * Returns the value of the '<em><b>Second Indexes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Second Indexes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Indexes</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#getIndexExpCS_SecondIndexes()
	 * @model containment="true"
	 * @generated
	 */
  EList<ExpCS> getSecondIndexes();

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
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage#getIndexExpCS_AtPre()
	 * @model
	 * @generated
	 */
  boolean isAtPre();

  /**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.IndexExpCS#isAtPre <em>At Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>At Pre</em>' attribute.
	 * @see #isAtPre()
	 * @generated
	 */
  void setAtPre(boolean value);

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model vType="org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeOCLCSVisitor<R>"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return v.visitIndexExpCS(this);'"
	 * @generated
	 */
	<R> R accept(ImperativeOCLCSVisitor<R> v);

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model vType="org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSVisitor<R>"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((ImperativeOCLCSVisitor<R>)v).visitIndexExpCS(this);'"
	 * @generated
	 */
	<R> R accept(BaseCSVisitor<R> v);

} // IndexExpCS
