/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelparamFactoryImpl.java,v 1.1 2008/01/30 10:31:35 sboyko Exp $
 */
package org.eclipse.m2m.qvt.oml.emf.util.modelparam.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.m2m.qvt.oml.emf.util.modelparam.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelparamFactoryImpl extends EFactoryImpl implements ModelparamFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModelparamFactory init() {
		try {
			ModelparamFactory theModelparamFactory = (ModelparamFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/qvt/1.0.0/Operational/modelparam"); 
			if (theModelparamFactory != null) {
				return theModelparamFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelparamFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelparamFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ModelparamPackage.RESOURCE_EOBJECT: return createResourceEObject();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceEObject createResourceEObject() {
		ResourceEObjectImpl resourceEObject = new ResourceEObjectImpl();
		return resourceEObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelparamPackage getModelparamPackage() {
		return (ModelparamPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModelparamPackage getPackage() {
		return ModelparamPackage.eINSTANCE;
	}

} //ModelparamFactoryImpl
