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
 * 
 *
 * $Id: PatternPropertyExpCSImpl.java,v 1.1 2008/03/12 11:48:05 sboyko Exp $
 */
package org.eclipse.m2m.qvt.oml.internal.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage;
import org.eclipse.m2m.qvt.oml.internal.cst.PatternPropertyExpCS;

import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.SimpleNameCS;

import org.eclipse.ocl.cst.impl.OCLExpressionCSImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Property Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.PatternPropertyExpCSImpl#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.PatternPropertyExpCSImpl#getOclExpressionCS <em>Ocl Expression CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.PatternPropertyExpCSImpl#isIncremental <em>Incremental</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PatternPropertyExpCSImpl extends OCLExpressionCSImpl implements PatternPropertyExpCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getSimpleNameCS() <em>Simple Name CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleNameCS()
	 * @generated
	 * @ordered
	 */
	protected SimpleNameCS simpleNameCS;

	/**
	 * The cached value of the '{@link #getOclExpressionCS() <em>Ocl Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclExpressionCS()
	 * @generated
	 * @ordered
	 */
	protected OCLExpressionCS oclExpressionCS;

	/**
	 * The default value of the '{@link #isIncremental() <em>Incremental</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncremental()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INCREMENTAL_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isIncremental() <em>Incremental</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncremental()
	 * @generated
	 * @ordered
	 */
	protected static final int INCREMENTAL_EFLAG = 1 << 8;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternPropertyExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.PATTERN_PROPERTY_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleNameCS getSimpleNameCS() {
		return simpleNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimpleNameCS(SimpleNameCS newSimpleNameCS, NotificationChain msgs) {
		SimpleNameCS oldSimpleNameCS = simpleNameCS;
		simpleNameCS = newSimpleNameCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.PATTERN_PROPERTY_EXP_CS__SIMPLE_NAME_CS, oldSimpleNameCS, newSimpleNameCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleNameCS(SimpleNameCS newSimpleNameCS) {
		if (newSimpleNameCS != simpleNameCS) {
			NotificationChain msgs = null;
			if (simpleNameCS != null)
				msgs = ((InternalEObject)simpleNameCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.PATTERN_PROPERTY_EXP_CS__SIMPLE_NAME_CS, null, msgs);
			if (newSimpleNameCS != null)
				msgs = ((InternalEObject)newSimpleNameCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.PATTERN_PROPERTY_EXP_CS__SIMPLE_NAME_CS, null, msgs);
			msgs = basicSetSimpleNameCS(newSimpleNameCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.PATTERN_PROPERTY_EXP_CS__SIMPLE_NAME_CS, newSimpleNameCS, newSimpleNameCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpressionCS getOclExpressionCS() {
		return oclExpressionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOclExpressionCS(OCLExpressionCS newOclExpressionCS, NotificationChain msgs) {
		OCLExpressionCS oldOclExpressionCS = oclExpressionCS;
		oclExpressionCS = newOclExpressionCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.PATTERN_PROPERTY_EXP_CS__OCL_EXPRESSION_CS, oldOclExpressionCS, newOclExpressionCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOclExpressionCS(OCLExpressionCS newOclExpressionCS) {
		if (newOclExpressionCS != oclExpressionCS) {
			NotificationChain msgs = null;
			if (oclExpressionCS != null)
				msgs = ((InternalEObject)oclExpressionCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.PATTERN_PROPERTY_EXP_CS__OCL_EXPRESSION_CS, null, msgs);
			if (newOclExpressionCS != null)
				msgs = ((InternalEObject)newOclExpressionCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.PATTERN_PROPERTY_EXP_CS__OCL_EXPRESSION_CS, null, msgs);
			msgs = basicSetOclExpressionCS(newOclExpressionCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.PATTERN_PROPERTY_EXP_CS__OCL_EXPRESSION_CS, newOclExpressionCS, newOclExpressionCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIncremental() {
		return (eFlags & INCREMENTAL_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncremental(boolean newIncremental) {
		boolean oldIncremental = (eFlags & INCREMENTAL_EFLAG) != 0;
		if (newIncremental) eFlags |= INCREMENTAL_EFLAG; else eFlags &= ~INCREMENTAL_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.PATTERN_PROPERTY_EXP_CS__INCREMENTAL, oldIncremental, newIncremental));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.PATTERN_PROPERTY_EXP_CS__SIMPLE_NAME_CS:
				return basicSetSimpleNameCS(null, msgs);
			case CSTPackage.PATTERN_PROPERTY_EXP_CS__OCL_EXPRESSION_CS:
				return basicSetOclExpressionCS(null, msgs);
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
			case CSTPackage.PATTERN_PROPERTY_EXP_CS__SIMPLE_NAME_CS:
				return getSimpleNameCS();
			case CSTPackage.PATTERN_PROPERTY_EXP_CS__OCL_EXPRESSION_CS:
				return getOclExpressionCS();
			case CSTPackage.PATTERN_PROPERTY_EXP_CS__INCREMENTAL:
				return isIncremental() ? Boolean.TRUE : Boolean.FALSE;
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
			case CSTPackage.PATTERN_PROPERTY_EXP_CS__SIMPLE_NAME_CS:
				setSimpleNameCS((SimpleNameCS)newValue);
				return;
			case CSTPackage.PATTERN_PROPERTY_EXP_CS__OCL_EXPRESSION_CS:
				setOclExpressionCS((OCLExpressionCS)newValue);
				return;
			case CSTPackage.PATTERN_PROPERTY_EXP_CS__INCREMENTAL:
				setIncremental(((Boolean)newValue).booleanValue());
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
			case CSTPackage.PATTERN_PROPERTY_EXP_CS__SIMPLE_NAME_CS:
				setSimpleNameCS((SimpleNameCS)null);
				return;
			case CSTPackage.PATTERN_PROPERTY_EXP_CS__OCL_EXPRESSION_CS:
				setOclExpressionCS((OCLExpressionCS)null);
				return;
			case CSTPackage.PATTERN_PROPERTY_EXP_CS__INCREMENTAL:
				setIncremental(INCREMENTAL_EDEFAULT);
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
			case CSTPackage.PATTERN_PROPERTY_EXP_CS__SIMPLE_NAME_CS:
				return simpleNameCS != null;
			case CSTPackage.PATTERN_PROPERTY_EXP_CS__OCL_EXPRESSION_CS:
				return oclExpressionCS != null;
			case CSTPackage.PATTERN_PROPERTY_EXP_CS__INCREMENTAL:
				return ((eFlags & INCREMENTAL_EFLAG) != 0) != INCREMENTAL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (incremental: "); //$NON-NLS-1$
		result.append((eFlags & INCREMENTAL_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

} //PatternPropertyExpCSImpl
