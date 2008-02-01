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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage;
import org.eclipse.m2m.qvt.oml.internal.cst.ElementWithBody;
import org.eclipse.m2m.qvt.oml.internal.cst.OutExpCS;
import org.eclipse.m2m.qvt.oml.internal.cst.TypeSpecCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.impl.OCLExpressionCSImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Out Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.OutExpCSImpl#getBodyStartLocation <em>Body Start Location</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.OutExpCSImpl#getBodyEndLocation <em>Body End Location</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.OutExpCSImpl#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.OutExpCSImpl#getTypeSpecCS <em>Type Spec CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.OutExpCSImpl#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutExpCSImpl extends OCLExpressionCSImpl implements OutExpCS {
	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

    /**
     * The default value of the '{@link #getBodyStartLocation() <em>Body Start Location</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBodyStartLocation()
     * @generated
     * @ordered
     */
	protected static final int BODY_START_LOCATION_EDEFAULT = 0;

	/**
     * The cached value of the '{@link #getBodyStartLocation() <em>Body Start Location</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBodyStartLocation()
     * @generated
     * @ordered
     */
	protected int bodyStartLocation = BODY_START_LOCATION_EDEFAULT;

	/**
     * The default value of the '{@link #getBodyEndLocation() <em>Body End Location</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBodyEndLocation()
     * @generated
     * @ordered
     */
	protected static final int BODY_END_LOCATION_EDEFAULT = 0;

	/**
     * The cached value of the '{@link #getBodyEndLocation() <em>Body End Location</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBodyEndLocation()
     * @generated
     * @ordered
     */
	protected int bodyEndLocation = BODY_END_LOCATION_EDEFAULT;

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
     * The cached value of the '{@link #getTypeSpecCS() <em>Type Spec CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeSpecCS()
     * @generated
     * @ordered
     */
	protected TypeSpecCS typeSpecCS;

	/**
     * The cached value of the '{@link #getExpressions() <em>Expressions</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getExpressions()
     * @generated
     * @ordered
     */
	protected EList<OCLExpressionCS> expressions;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected OutExpCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.OUT_EXP_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getBodyStartLocation() {
        return bodyStartLocation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBodyStartLocation(int newBodyStartLocation) {
        int oldBodyStartLocation = bodyStartLocation;
        bodyStartLocation = newBodyStartLocation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.OUT_EXP_CS__BODY_START_LOCATION, oldBodyStartLocation, bodyStartLocation));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getBodyEndLocation() {
        return bodyEndLocation;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBodyEndLocation(int newBodyEndLocation) {
        int oldBodyEndLocation = bodyEndLocation;
        bodyEndLocation = newBodyEndLocation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.OUT_EXP_CS__BODY_END_LOCATION, oldBodyEndLocation, bodyEndLocation));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.OUT_EXP_CS__SIMPLE_NAME_CS, oldSimpleNameCS, newSimpleNameCS);
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
                msgs = ((InternalEObject)simpleNameCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.OUT_EXP_CS__SIMPLE_NAME_CS, null, msgs);
            if (newSimpleNameCS != null)
                msgs = ((InternalEObject)newSimpleNameCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.OUT_EXP_CS__SIMPLE_NAME_CS, null, msgs);
            msgs = basicSetSimpleNameCS(newSimpleNameCS, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.OUT_EXP_CS__SIMPLE_NAME_CS, newSimpleNameCS, newSimpleNameCS));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeSpecCS getTypeSpecCS() {
        return typeSpecCS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetTypeSpecCS(TypeSpecCS newTypeSpecCS, NotificationChain msgs) {
        TypeSpecCS oldTypeSpecCS = typeSpecCS;
        typeSpecCS = newTypeSpecCS;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.OUT_EXP_CS__TYPE_SPEC_CS, oldTypeSpecCS, newTypeSpecCS);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTypeSpecCS(TypeSpecCS newTypeSpecCS) {
        if (newTypeSpecCS != typeSpecCS) {
            NotificationChain msgs = null;
            if (typeSpecCS != null)
                msgs = ((InternalEObject)typeSpecCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.OUT_EXP_CS__TYPE_SPEC_CS, null, msgs);
            if (newTypeSpecCS != null)
                msgs = ((InternalEObject)newTypeSpecCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.OUT_EXP_CS__TYPE_SPEC_CS, null, msgs);
            msgs = basicSetTypeSpecCS(newTypeSpecCS, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.OUT_EXP_CS__TYPE_SPEC_CS, newTypeSpecCS, newTypeSpecCS));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<OCLExpressionCS> getExpressions() {
        if (expressions == null) {
            expressions = new EObjectContainmentEList<OCLExpressionCS>(OCLExpressionCS.class, this, CSTPackage.OUT_EXP_CS__EXPRESSIONS);
        }
        return expressions;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CSTPackage.OUT_EXP_CS__SIMPLE_NAME_CS:
                return basicSetSimpleNameCS(null, msgs);
            case CSTPackage.OUT_EXP_CS__TYPE_SPEC_CS:
                return basicSetTypeSpecCS(null, msgs);
            case CSTPackage.OUT_EXP_CS__EXPRESSIONS:
                return ((InternalEList<?>)getExpressions()).basicRemove(otherEnd, msgs);
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
            case CSTPackage.OUT_EXP_CS__BODY_START_LOCATION:
                return new Integer(getBodyStartLocation());
            case CSTPackage.OUT_EXP_CS__BODY_END_LOCATION:
                return new Integer(getBodyEndLocation());
            case CSTPackage.OUT_EXP_CS__SIMPLE_NAME_CS:
                return getSimpleNameCS();
            case CSTPackage.OUT_EXP_CS__TYPE_SPEC_CS:
                return getTypeSpecCS();
            case CSTPackage.OUT_EXP_CS__EXPRESSIONS:
                return getExpressions();
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
            case CSTPackage.OUT_EXP_CS__BODY_START_LOCATION:
                setBodyStartLocation(((Integer)newValue).intValue());
                return;
            case CSTPackage.OUT_EXP_CS__BODY_END_LOCATION:
                setBodyEndLocation(((Integer)newValue).intValue());
                return;
            case CSTPackage.OUT_EXP_CS__SIMPLE_NAME_CS:
                setSimpleNameCS((SimpleNameCS)newValue);
                return;
            case CSTPackage.OUT_EXP_CS__TYPE_SPEC_CS:
                setTypeSpecCS((TypeSpecCS)newValue);
                return;
            case CSTPackage.OUT_EXP_CS__EXPRESSIONS:
                getExpressions().clear();
                getExpressions().addAll((Collection<? extends OCLExpressionCS>)newValue);
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
            case CSTPackage.OUT_EXP_CS__BODY_START_LOCATION:
                setBodyStartLocation(BODY_START_LOCATION_EDEFAULT);
                return;
            case CSTPackage.OUT_EXP_CS__BODY_END_LOCATION:
                setBodyEndLocation(BODY_END_LOCATION_EDEFAULT);
                return;
            case CSTPackage.OUT_EXP_CS__SIMPLE_NAME_CS:
                setSimpleNameCS((SimpleNameCS)null);
                return;
            case CSTPackage.OUT_EXP_CS__TYPE_SPEC_CS:
                setTypeSpecCS((TypeSpecCS)null);
                return;
            case CSTPackage.OUT_EXP_CS__EXPRESSIONS:
                getExpressions().clear();
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
            case CSTPackage.OUT_EXP_CS__BODY_START_LOCATION:
                return bodyStartLocation != BODY_START_LOCATION_EDEFAULT;
            case CSTPackage.OUT_EXP_CS__BODY_END_LOCATION:
                return bodyEndLocation != BODY_END_LOCATION_EDEFAULT;
            case CSTPackage.OUT_EXP_CS__SIMPLE_NAME_CS:
                return simpleNameCS != null;
            case CSTPackage.OUT_EXP_CS__TYPE_SPEC_CS:
                return typeSpecCS != null;
            case CSTPackage.OUT_EXP_CS__EXPRESSIONS:
                return expressions != null && !expressions.isEmpty();
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == ElementWithBody.class) {
            switch (derivedFeatureID) {
                case CSTPackage.OUT_EXP_CS__BODY_START_LOCATION: return CSTPackage.ELEMENT_WITH_BODY__BODY_START_LOCATION;
                case CSTPackage.OUT_EXP_CS__BODY_END_LOCATION: return CSTPackage.ELEMENT_WITH_BODY__BODY_END_LOCATION;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == ElementWithBody.class) {
            switch (baseFeatureID) {
                case CSTPackage.ELEMENT_WITH_BODY__BODY_START_LOCATION: return CSTPackage.OUT_EXP_CS__BODY_START_LOCATION;
                case CSTPackage.ELEMENT_WITH_BODY__BODY_END_LOCATION: return CSTPackage.OUT_EXP_CS__BODY_END_LOCATION;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
        result.append(" (bodyStartLocation: "); //$NON-NLS-1$
        result.append(bodyStartLocation);
        result.append(", bodyEndLocation: "); //$NON-NLS-1$
        result.append(bodyEndLocation);
        result.append(')');
        return result.toString();
    }

} //OutExpCSImpl
