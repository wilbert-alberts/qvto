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
package org.eclipse.qvto.examples.pivot.qvtoperational.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage;
import org.eclipse.qvto.examples.pivot.qvtoperational.ResolveExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.ResolveInExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.util.QVTOperationalVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resolve In Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ResolveInExpImpl#getInMapping <em>In Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResolveInExpImpl extends ResolveExpImpl implements ResolveInExp {
	/**
	 * The cached value of the '{@link #getInMapping() <em>In Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInMapping()
	 * @generated
	 * @ordered
	 */
	protected MappingOperation inMapping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResolveInExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalPackage.Literals.RESOLVE_IN_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingOperation getInMapping() {
		if (inMapping != null && inMapping.eIsProxy()) {
			InternalEObject oldInMapping = (InternalEObject)inMapping;
			inMapping = (MappingOperation)eResolveProxy(oldInMapping);
			if (inMapping != oldInMapping) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTOperationalPackage.RESOLVE_IN_EXP__IN_MAPPING, oldInMapping, inMapping));
			}
		}
		return inMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingOperation basicGetInMapping() {
		return inMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInMapping(MappingOperation newInMapping) {
		MappingOperation oldInMapping = inMapping;
		inMapping = newInMapping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.RESOLVE_IN_EXP__IN_MAPPING, oldInMapping, inMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R> R accept(final QVTOperationalVisitor<R> v) {
		return v.visitResolveInExp(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R> R accept(final Visitor<R> v) {
		return ((QVTOperationalVisitor<R>)v).visitResolveInExp(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTOperationalPackage.RESOLVE_IN_EXP__IN_MAPPING:
				if (resolve) return getInMapping();
				return basicGetInMapping();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QVTOperationalPackage.RESOLVE_IN_EXP__IN_MAPPING:
				setInMapping((MappingOperation)newValue);
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
			case QVTOperationalPackage.RESOLVE_IN_EXP__IN_MAPPING:
				setInMapping((MappingOperation)null);
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
			case QVTOperationalPackage.RESOLVE_IN_EXP__IN_MAPPING:
				return inMapping != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ResolveExp.class) {
			switch (baseOperationID) {
				case QVTOperationalPackage.RESOLVE_EXP___ACCEPT__QVTOPERATIONALVISITOR: return QVTOperationalPackage.RESOLVE_IN_EXP___ACCEPT__QVTOPERATIONALVISITOR;
				case QVTOperationalPackage.RESOLVE_EXP___ACCEPT__VISITOR: return QVTOperationalPackage.RESOLVE_IN_EXP___ACCEPT__VISITOR;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
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
			case QVTOperationalPackage.RESOLVE_IN_EXP___ACCEPT__QVTOPERATIONALVISITOR:
				return accept((QVTOperationalVisitor)arguments.get(0));
			case QVTOperationalPackage.RESOLVE_IN_EXP___ACCEPT__VISITOR:
				return accept((Visitor)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ResolveInExpImpl
