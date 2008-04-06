/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelparamPackage.java,v 1.1 2008/04/06 10:17:53 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.emf.util.modelparam;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.modelparam.ModelparamFactory
 * @model kind="package"
 * @generated
 */
public interface ModelparamPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "modelparam";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/1.0.0/Operational/modelparam";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "modelparam";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelparamPackage eINSTANCE = org.eclipse.m2m.internal.qvt.oml.emf.util.modelparam.impl.ModelparamPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.emf.util.modelparam.impl.ResourceEObjectImpl <em>Resource EObject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.modelparam.impl.ResourceEObjectImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.modelparam.impl.ModelparamPackageImpl#getResourceEObject()
	 * @generated
	 */
	int RESOURCE_EOBJECT = 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_EOBJECT__CHILDREN = EcorePackage.EOBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource EObject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_EOBJECT_FEATURE_COUNT = EcorePackage.EOBJECT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.emf.util.modelparam.ResourceEObject <em>Resource EObject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource EObject</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.modelparam.ResourceEObject
	 * @generated
	 */
	EClass getResourceEObject();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.m2m.internal.qvt.oml.emf.util.modelparam.ResourceEObject#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.modelparam.ResourceEObject#getChildren()
	 * @see #getResourceEObject()
	 * @generated
	 */
	EReference getResourceEObject_Children();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelparamFactory getModelparamFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.emf.util.modelparam.impl.ResourceEObjectImpl <em>Resource EObject</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.modelparam.impl.ResourceEObjectImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.modelparam.impl.ModelparamPackageImpl#getResourceEObject()
		 * @generated
		 */
		EClass RESOURCE_EOBJECT = eINSTANCE.getResourceEObject();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_EOBJECT__CHILDREN = eINSTANCE.getResourceEObject_Children();

	}

} //ModelparamPackage
