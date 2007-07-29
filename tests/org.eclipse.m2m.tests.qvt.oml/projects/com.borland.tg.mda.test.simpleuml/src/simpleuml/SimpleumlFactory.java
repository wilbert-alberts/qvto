/**
 * <copyright>
 * </copyright>
 *
 * $Id: SimpleumlFactory.java,v 1.1 2007/07/29 21:25:31 radvorak Exp $
 */
package simpleuml;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see simpleuml.SimpleumlPackage
 * @generated
 */
public interface SimpleumlFactory extends EFactory{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	SimpleumlFactory eINSTANCE = new simpleuml.impl.SimpleumlFactoryImpl();

    /**
     * Returns a new object of class '<em>Model</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Model</em>'.
     * @generated
     */
	Model createModel();

    /**
     * Returns a new object of class '<em>Package</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Package</em>'.
     * @generated
     */
	simpleuml.Package createPackage();

    /**
     * Returns a new object of class '<em>Class</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Class</em>'.
     * @generated
     */
	simpleuml.Class createClass();

    /**
     * Returns a new object of class '<em>Property</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Property</em>'.
     * @generated
     */
	Property createProperty();

    /**
     * Returns a new object of class '<em>Association</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Association</em>'.
     * @generated
     */
	Association createAssociation();

    /**
     * Returns a new object of class '<em>Primitive Type</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Primitive Type</em>'.
     * @generated
     */
	PrimitiveType createPrimitiveType();

    /**
     * Returns a new object of class '<em>Data Type</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Data Type</em>'.
     * @generated
     */
	DataType createDataType();

    /**
     * Returns a new object of class '<em>Enumeration</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Enumeration</em>'.
     * @generated
     */
	Enumeration createEnumeration();

    /**
     * Returns a new object of class '<em>Enumeration Literal</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Enumeration Literal</em>'.
     * @generated
     */
	EnumerationLiteral createEnumerationLiteral();

    /**
     * Returns a new object of class '<em>Generalization</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Generalization</em>'.
     * @generated
     */
	Generalization createGeneralization();

    /**
     * Returns a new object of class '<em>Tagged Value</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Tagged Value</em>'.
     * @generated
     */
	TaggedValue createTaggedValue();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	SimpleumlPackage getSimpleumlPackage();

} //SimpleumlFactory
