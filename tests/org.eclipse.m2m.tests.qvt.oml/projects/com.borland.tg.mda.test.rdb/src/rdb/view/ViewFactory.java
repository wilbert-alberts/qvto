/**
 * <copyright>
 * </copyright>
 *
 * $Id: ViewFactory.java,v 1.1 2007/07/29 21:25:32 radvorak Exp $
 */
package rdb.view;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see rdb.view.ViewPackage
 * @generated
 */
public interface ViewFactory extends EFactory{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    ViewFactory eINSTANCE = new rdb.view.impl.ViewFactoryImpl();

	/**
	 * Returns a new object of class '<em>View</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>View</em>'.
	 * @generated
	 */
    View createView();

	/**
	 * Returns a new object of class '<em>Alias</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Alias</em>'.
	 * @generated
	 */
    ViewAlias createViewAlias();

	/**
	 * Returns a new object of class '<em>Expression Column</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Column</em>'.
	 * @generated
	 */
    ViewExpressionColumn createViewExpressionColumn();

	/**
	 * Returns a new object of class '<em>Referenced View Column</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Referenced View Column</em>'.
	 * @generated
	 */
    ReferencedViewColumn createReferencedViewColumn();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
    ViewPackage getViewPackage();

} //ViewFactory
