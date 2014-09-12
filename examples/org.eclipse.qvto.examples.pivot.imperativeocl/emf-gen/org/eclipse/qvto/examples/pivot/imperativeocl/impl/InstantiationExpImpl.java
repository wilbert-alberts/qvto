/**
 * <copyright>
 * Copyright (c) 2013 Willink Transformations, University of York, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Adolfo Sanchez-Barbudo (University of York) - Bug397429
 * </copyright>
 */
package org.eclipse.qvto.examples.pivot.imperativeocl.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Variable;

import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage;
import org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instantiation Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.InstantiationExpImpl#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.InstantiationExpImpl#getExtent <em>Extent</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.InstantiationExpImpl#getInstantiatedClass <em>Instantiated Class</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.InstantiationExpImpl#getInitializationOperation <em>Initialization Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstantiationExpImpl extends ImperativeExpressionImpl implements InstantiationExp {
	/**
	 * The cached value of the '{@link #getArgument() <em>Argument</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgument()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpression> argument;

	/**
	 * The cached value of the '{@link #getExtent() <em>Extent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtent()
	 * @generated
	 * @ordered
	 */
	protected Variable extent;

	/**
	 * The cached value of the '{@link #getInstantiatedClass() <em>Instantiated Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstantiatedClass()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.examples.pivot.Class instantiatedClass;

	/**
	 * The cached value of the '{@link #getInitializationOperation() <em>Initialization Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializationOperation()
	 * @generated
	 * @ordered
	 */
	protected Operation initializationOperation;

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
		return ImperativeOCLPackage.Literals.INSTANTIATION_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OCLExpression> getArgument() {
		if (argument == null) {
			argument = new EObjectContainmentEList<OCLExpression>(OCLExpression.class, this, ImperativeOCLPackage.INSTANTIATION_EXP__ARGUMENT);
		}
		return argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getExtent() {
		if (extent != null && ((EObject)extent).eIsProxy()) {
			InternalEObject oldExtent = (InternalEObject)extent;
			extent = (Variable)eResolveProxy(oldExtent);
			if (extent != oldExtent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImperativeOCLPackage.INSTANTIATION_EXP__EXTENT, oldExtent, extent));
			}
		}
		return extent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetExtent() {
		return extent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtent(Variable newExtent) {
		Variable oldExtent = extent;
		extent = newExtent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLPackage.INSTANTIATION_EXP__EXTENT, oldExtent, extent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.examples.pivot.Class getInstantiatedClass() {
		if (instantiatedClass != null && ((EObject)instantiatedClass).eIsProxy()) {
			InternalEObject oldInstantiatedClass = (InternalEObject)instantiatedClass;
			instantiatedClass = (org.eclipse.ocl.examples.pivot.Class)eResolveProxy(oldInstantiatedClass);
			if (instantiatedClass != oldInstantiatedClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImperativeOCLPackage.INSTANTIATION_EXP__INSTANTIATED_CLASS, oldInstantiatedClass, instantiatedClass));
			}
		}
		return instantiatedClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.examples.pivot.Class basicGetInstantiatedClass() {
		return instantiatedClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstantiatedClass(org.eclipse.ocl.examples.pivot.Class newInstantiatedClass) {
		org.eclipse.ocl.examples.pivot.Class oldInstantiatedClass = instantiatedClass;
		instantiatedClass = newInstantiatedClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLPackage.INSTANTIATION_EXP__INSTANTIATED_CLASS, oldInstantiatedClass, instantiatedClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getInitializationOperation() {
		if (initializationOperation != null && ((EObject)initializationOperation).eIsProxy()) {
			InternalEObject oldInitializationOperation = (InternalEObject)initializationOperation;
			initializationOperation = (Operation)eResolveProxy(oldInitializationOperation);
			if (initializationOperation != oldInitializationOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImperativeOCLPackage.INSTANTIATION_EXP__INITIALIZATION_OPERATION, oldInitializationOperation, initializationOperation));
			}
		}
		return initializationOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetInitializationOperation() {
		return initializationOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializationOperation(Operation newInitializationOperation) {
		Operation oldInitializationOperation = initializationOperation;
		initializationOperation = newInitializationOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLPackage.INSTANTIATION_EXP__INITIALIZATION_OPERATION, oldInitializationOperation, initializationOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R> R accept(final ImperativeOCLVisitor<R> v) {
		return v.visitInstantiationExp(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R> R accept(final Visitor<R> v) {
		return ((ImperativeOCLVisitor<R>)v).visitInstantiationExp(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImperativeOCLPackage.INSTANTIATION_EXP__ARGUMENT:
				return ((InternalEList<?>)getArgument()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImperativeOCLPackage.INSTANTIATION_EXP__ARGUMENT:
				return getArgument();
			case ImperativeOCLPackage.INSTANTIATION_EXP__EXTENT:
				if (resolve) return getExtent();
				return basicGetExtent();
			case ImperativeOCLPackage.INSTANTIATION_EXP__INSTANTIATED_CLASS:
				if (resolve) return getInstantiatedClass();
				return basicGetInstantiatedClass();
			case ImperativeOCLPackage.INSTANTIATION_EXP__INITIALIZATION_OPERATION:
				if (resolve) return getInitializationOperation();
				return basicGetInitializationOperation();
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
			case ImperativeOCLPackage.INSTANTIATION_EXP__ARGUMENT:
				getArgument().clear();
				getArgument().addAll((Collection<? extends OCLExpression>)newValue);
				return;
			case ImperativeOCLPackage.INSTANTIATION_EXP__EXTENT:
				setExtent((Variable)newValue);
				return;
			case ImperativeOCLPackage.INSTANTIATION_EXP__INSTANTIATED_CLASS:
				setInstantiatedClass((org.eclipse.ocl.examples.pivot.Class)newValue);
				return;
			case ImperativeOCLPackage.INSTANTIATION_EXP__INITIALIZATION_OPERATION:
				setInitializationOperation((Operation)newValue);
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
			case ImperativeOCLPackage.INSTANTIATION_EXP__ARGUMENT:
				getArgument().clear();
				return;
			case ImperativeOCLPackage.INSTANTIATION_EXP__EXTENT:
				setExtent((Variable)null);
				return;
			case ImperativeOCLPackage.INSTANTIATION_EXP__INSTANTIATED_CLASS:
				setInstantiatedClass((org.eclipse.ocl.examples.pivot.Class)null);
				return;
			case ImperativeOCLPackage.INSTANTIATION_EXP__INITIALIZATION_OPERATION:
				setInitializationOperation((Operation)null);
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
			case ImperativeOCLPackage.INSTANTIATION_EXP__ARGUMENT:
				return argument != null && !argument.isEmpty();
			case ImperativeOCLPackage.INSTANTIATION_EXP__EXTENT:
				return extent != null;
			case ImperativeOCLPackage.INSTANTIATION_EXP__INSTANTIATED_CLASS:
				return instantiatedClass != null;
			case ImperativeOCLPackage.INSTANTIATION_EXP__INITIALIZATION_OPERATION:
				return initializationOperation != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings({"rawtypes", "unchecked" })
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ImperativeOCLPackage.INSTANTIATION_EXP___ACCEPT__IMPERATIVEOCLVISITOR:
				return accept((ImperativeOCLVisitor)arguments.get(0));
			case ImperativeOCLPackage.INSTANTIATION_EXP___ACCEPT__VISITOR:
				return accept((Visitor)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //InstantiationExpImpl
