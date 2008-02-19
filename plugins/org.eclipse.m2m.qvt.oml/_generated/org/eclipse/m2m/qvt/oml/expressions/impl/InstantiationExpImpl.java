/**
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *
 * $Id: InstantiationExpImpl.java,v 1.2 2008/02/19 00:01:23 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.expressions.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage;
import org.eclipse.m2m.qvt.oml.expressions.InstantiationExp;
import org.eclipse.m2m.qvt.oml.expressions.ModelParameter;
import org.eclipse.ocl.expressions.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instantiation Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.impl.InstantiationExpImpl#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.impl.InstantiationExpImpl#getExtent <em>Extent</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.impl.InstantiationExpImpl#getInstantiatedClass <em>Instantiated Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstantiationExpImpl extends ImperativeExpressionImpl implements InstantiationExp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getArgument() <em>Argument</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgument()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpression<EClassifier>> argument;

	/**
	 * The cached value of the '{@link #getExtent() <em>Extent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtent()
	 * @generated
	 * @ordered
	 */
	protected ModelParameter extent;

	/**
	 * The cached value of the '{@link #getInstantiatedClass() <em>Instantiated Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstantiatedClass()
	 * @generated
	 * @ordered
	 */
	protected EClass instantiatedClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstantiationExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.INSTANTIATION_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OCLExpression<EClassifier>> getArgument() {
		if (argument == null) {
			argument = new EObjectResolvingEList<OCLExpression<EClassifier>>(OCLExpression.class, this, ExpressionsPackage.INSTANTIATION_EXP__ARGUMENT);
		}
		return argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelParameter getExtent() {
		if (extent != null && extent.eIsProxy()) {
			InternalEObject oldExtent = (InternalEObject)extent;
			extent = (ModelParameter)eResolveProxy(oldExtent);
			if (extent != oldExtent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.INSTANTIATION_EXP__EXTENT, oldExtent, extent));
			}
		}
		return extent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelParameter basicGetExtent() {
		return extent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtent(ModelParameter newExtent) {
		ModelParameter oldExtent = extent;
		extent = newExtent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.INSTANTIATION_EXP__EXTENT, oldExtent, extent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstantiatedClass() {
		if (instantiatedClass != null && instantiatedClass.eIsProxy()) {
			InternalEObject oldInstantiatedClass = (InternalEObject)instantiatedClass;
			instantiatedClass = (EClass)eResolveProxy(oldInstantiatedClass);
			if (instantiatedClass != oldInstantiatedClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.INSTANTIATION_EXP__INSTANTIATED_CLASS, oldInstantiatedClass, instantiatedClass));
			}
		}
		return instantiatedClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetInstantiatedClass() {
		return instantiatedClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstantiatedClass(EClass newInstantiatedClass) {
		EClass oldInstantiatedClass = instantiatedClass;
		instantiatedClass = newInstantiatedClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.INSTANTIATION_EXP__INSTANTIATED_CLASS, oldInstantiatedClass, instantiatedClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionsPackage.INSTANTIATION_EXP__ARGUMENT:
				return getArgument();
			case ExpressionsPackage.INSTANTIATION_EXP__EXTENT:
				if (resolve) return getExtent();
				return basicGetExtent();
			case ExpressionsPackage.INSTANTIATION_EXP__INSTANTIATED_CLASS:
				if (resolve) return getInstantiatedClass();
				return basicGetInstantiatedClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExpressionsPackage.INSTANTIATION_EXP__ARGUMENT:
				getArgument().clear();
				getArgument().addAll((Collection<? extends OCLExpression<EClassifier>>)newValue);
				return;
			case ExpressionsPackage.INSTANTIATION_EXP__EXTENT:
				setExtent((ModelParameter)newValue);
				return;
			case ExpressionsPackage.INSTANTIATION_EXP__INSTANTIATED_CLASS:
				setInstantiatedClass((EClass)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExpressionsPackage.INSTANTIATION_EXP__ARGUMENT:
				getArgument().clear();
				return;
			case ExpressionsPackage.INSTANTIATION_EXP__EXTENT:
				setExtent((ModelParameter)null);
				return;
			case ExpressionsPackage.INSTANTIATION_EXP__INSTANTIATED_CLASS:
				setInstantiatedClass((EClass)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExpressionsPackage.INSTANTIATION_EXP__ARGUMENT:
				return argument != null && !argument.isEmpty();
			case ExpressionsPackage.INSTANTIATION_EXP__EXTENT:
				return extent != null;
			case ExpressionsPackage.INSTANTIATION_EXP__INSTANTIATED_CLASS:
				return instantiatedClass != null;
		}
		return super.eIsSet(featureID);
	}

} //InstantiationExpImpl
