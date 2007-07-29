/**
 * <copyright>
 * </copyright>
 *
 * $Id: DatatypesFactory.java,v 1.1 2007/07/29 21:25:36 radvorak Exp $
 */
package rdb.datatypes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see rdb.datatypes.DatatypesPackage
 * @generated
 */
public interface DatatypesFactory extends EFactory{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    DatatypesFactory eINSTANCE = new rdb.datatypes.impl.DatatypesFactoryImpl();

	/**
	 * Returns a new object of class '<em>Domain</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Domain</em>'.
	 * @generated
	 */
    Domain createDomain();

	/**
	 * Returns a new object of class '<em>Primitive Data Type</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Data Type</em>'.
	 * @generated
	 */
    PrimitiveDataType createPrimitiveDataType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
    DatatypesPackage getDatatypesPackage();

} //DatatypesFactory
