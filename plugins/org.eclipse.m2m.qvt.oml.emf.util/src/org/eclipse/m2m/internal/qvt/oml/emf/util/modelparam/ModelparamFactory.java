/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelparamFactory.java,v 1.1 2008/04/06 10:17:53 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.emf.util.modelparam;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.modelparam.ModelparamPackage
 * @generated
 */
public interface ModelparamFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelparamFactory eINSTANCE = org.eclipse.m2m.internal.qvt.oml.emf.util.modelparam.impl.ModelparamFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Resource EObject</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource EObject</em>'.
	 * @generated
	 */
	ResourceEObject createResourceEObject();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelparamPackage getModelparamPackage();

} //ModelparamFactory
