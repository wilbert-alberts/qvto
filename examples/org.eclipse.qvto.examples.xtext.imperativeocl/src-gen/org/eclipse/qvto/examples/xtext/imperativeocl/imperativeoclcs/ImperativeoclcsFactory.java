/**
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage
 * @generated
 */
public interface ImperativeoclcsFactory extends EFactory
{
  /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  ImperativeoclcsFactory eINSTANCE = org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ImperativeoclcsFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>List Type CS</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Type CS</em>'.
	 * @generated
	 */
  ListTypeCS createListTypeCS();

  /**
	 * Returns a new object of class '<em>Dict Type CS</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dict Type CS</em>'.
	 * @generated
	 */
  DictTypeCS createDictTypeCS();

  /**
	 * Returns a new object of class '<em>List Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Literal Exp CS</em>'.
	 * @generated
	 */
  ListLiteralExpCS createListLiteralExpCS();

  /**
	 * Returns a new object of class '<em>Dict Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dict Literal Exp CS</em>'.
	 * @generated
	 */
  DictLiteralExpCS createDictLiteralExpCS();

  /**
	 * Returns a new object of class '<em>Dict Literal Part CS</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dict Literal Part CS</em>'.
	 * @generated
	 */
  DictLiteralPartCS createDictLiteralPartCS();

  /**
	 * Returns a new object of class '<em>Return Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Return Exp CS</em>'.
	 * @generated
	 */
  ReturnExpCS createReturnExpCS();

  /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
  ImperativeoclcsPackage getImperativeoclcsPackage();

} //ImperativeoclcsFactory
