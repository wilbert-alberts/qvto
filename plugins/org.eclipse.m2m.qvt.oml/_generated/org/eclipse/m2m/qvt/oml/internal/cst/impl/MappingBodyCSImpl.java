/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.internal.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingBodyCS;
import org.eclipse.m2m.qvt.oml.internal.cst.OutExpCS;

import org.eclipse.ocl.internal.cst.impl.OCLExpressionCSImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Body CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingBodyCSImpl#getOutExpCS <em>Out Exp CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingBodyCSImpl#isShort <em>Short</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingBodyCSImpl extends OCLExpressionCSImpl implements MappingBodyCS {
	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

    /**
	 * The cached value of the '{@link #getOutExpCS() <em>Out Exp CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutExpCS()
	 * @generated
	 * @ordered
	 */
	protected OutExpCS outExpCS;

	/**
	 * The default value of the '{@link #isShort() <em>Short</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShort()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SHORT_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isShort() <em>Short</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShort()
	 * @generated
	 * @ordered
	 */
	protected static final int SHORT_EFLAG = 1 << 8;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingBodyCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.MAPPING_BODY_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutExpCS getOutExpCS() {
		return outExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutExpCS(OutExpCS newOutExpCS, NotificationChain msgs) {
		OutExpCS oldOutExpCS = outExpCS;
		outExpCS = newOutExpCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_BODY_CS__OUT_EXP_CS, oldOutExpCS, newOutExpCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutExpCS(OutExpCS newOutExpCS) {
		if (newOutExpCS != outExpCS) {
			NotificationChain msgs = null;
			if (outExpCS != null)
				msgs = ((InternalEObject)outExpCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_BODY_CS__OUT_EXP_CS, null, msgs);
			if (newOutExpCS != null)
				msgs = ((InternalEObject)newOutExpCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_BODY_CS__OUT_EXP_CS, null, msgs);
			msgs = basicSetOutExpCS(newOutExpCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_BODY_CS__OUT_EXP_CS, newOutExpCS, newOutExpCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isShort() {
		return (eFlags & SHORT_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShort(boolean newShort) {
		boolean oldShort = (eFlags & SHORT_EFLAG) != 0;
		if (newShort) eFlags |= SHORT_EFLAG; else eFlags &= ~SHORT_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_BODY_CS__SHORT, oldShort, newShort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.MAPPING_BODY_CS__OUT_EXP_CS:
				return basicSetOutExpCS(null, msgs);
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
			case CSTPackage.MAPPING_BODY_CS__OUT_EXP_CS:
				return getOutExpCS();
			case CSTPackage.MAPPING_BODY_CS__SHORT:
				return isShort() ? Boolean.TRUE : Boolean.FALSE;
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
			case CSTPackage.MAPPING_BODY_CS__OUT_EXP_CS:
				setOutExpCS((OutExpCS)newValue);
				return;
			case CSTPackage.MAPPING_BODY_CS__SHORT:
				setShort(((Boolean)newValue).booleanValue());
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
			case CSTPackage.MAPPING_BODY_CS__OUT_EXP_CS:
				setOutExpCS((OutExpCS)null);
				return;
			case CSTPackage.MAPPING_BODY_CS__SHORT:
				setShort(SHORT_EDEFAULT);
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
			case CSTPackage.MAPPING_BODY_CS__OUT_EXP_CS:
				return outExpCS != null;
			case CSTPackage.MAPPING_BODY_CS__SHORT:
				return ((eFlags & SHORT_EFLAG) != 0) != SHORT_EDEFAULT;
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
		result.append(" (short: "); //$NON-NLS-1$
		result.append((eFlags & SHORT_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

} //MappingBodyCSImpl
