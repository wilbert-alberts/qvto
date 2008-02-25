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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingBodyCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingEndCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingExtensionCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingInitCS;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingRuleCS;
import org.eclipse.ocl.cst.OCLExpressionCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Rule CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingRuleCSImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingRuleCSImpl#getMappingInitCS <em>Mapping Init CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingRuleCSImpl#getMappingBodyCS <em>Mapping Body CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingRuleCSImpl#getMappingEndCS <em>Mapping End CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingRuleCSImpl#getMappingExtension <em>Mapping Extension</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingRuleCSImpl extends MappingMethodCSImpl implements MappingRuleCS {
	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

    /**
	 * The cached value of the '{@link #getGuard() <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuard()
	 * @generated
	 * @ordered
	 */
	protected OCLExpressionCS guard;

	/**
	 * The cached value of the '{@link #getMappingInitCS() <em>Mapping Init CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingInitCS()
	 * @generated
	 * @ordered
	 */
	protected MappingInitCS mappingInitCS;

	/**
	 * The cached value of the '{@link #getMappingBodyCS() <em>Mapping Body CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingBodyCS()
	 * @generated
	 * @ordered
	 */
	protected MappingBodyCS mappingBodyCS;

	/**
	 * The cached value of the '{@link #getMappingEndCS() <em>Mapping End CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingEndCS()
	 * @generated
	 * @ordered
	 */
	protected MappingEndCS mappingEndCS;

	/**
	 * The cached value of the '{@link #getMappingExtension() <em>Mapping Extension</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingExtension()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingExtensionCS> mappingExtension;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingRuleCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.MAPPING_RULE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpressionCS getGuard() {
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGuard(OCLExpressionCS newGuard, NotificationChain msgs) {
		OCLExpressionCS oldGuard = guard;
		guard = newGuard;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_RULE_CS__GUARD, oldGuard, newGuard);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuard(OCLExpressionCS newGuard) {
		if (newGuard != guard) {
			NotificationChain msgs = null;
			if (guard != null)
				msgs = ((InternalEObject)guard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_RULE_CS__GUARD, null, msgs);
			if (newGuard != null)
				msgs = ((InternalEObject)newGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_RULE_CS__GUARD, null, msgs);
			msgs = basicSetGuard(newGuard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_RULE_CS__GUARD, newGuard, newGuard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingInitCS getMappingInitCS() {
		return mappingInitCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingInitCS(MappingInitCS newMappingInitCS, NotificationChain msgs) {
		MappingInitCS oldMappingInitCS = mappingInitCS;
		mappingInitCS = newMappingInitCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_RULE_CS__MAPPING_INIT_CS, oldMappingInitCS, newMappingInitCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingInitCS(MappingInitCS newMappingInitCS) {
		if (newMappingInitCS != mappingInitCS) {
			NotificationChain msgs = null;
			if (mappingInitCS != null)
				msgs = ((InternalEObject)mappingInitCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_RULE_CS__MAPPING_INIT_CS, null, msgs);
			if (newMappingInitCS != null)
				msgs = ((InternalEObject)newMappingInitCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_RULE_CS__MAPPING_INIT_CS, null, msgs);
			msgs = basicSetMappingInitCS(newMappingInitCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_RULE_CS__MAPPING_INIT_CS, newMappingInitCS, newMappingInitCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingBodyCS getMappingBodyCS() {
		return mappingBodyCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingBodyCS(MappingBodyCS newMappingBodyCS, NotificationChain msgs) {
		MappingBodyCS oldMappingBodyCS = mappingBodyCS;
		mappingBodyCS = newMappingBodyCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_RULE_CS__MAPPING_BODY_CS, oldMappingBodyCS, newMappingBodyCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingBodyCS(MappingBodyCS newMappingBodyCS) {
		if (newMappingBodyCS != mappingBodyCS) {
			NotificationChain msgs = null;
			if (mappingBodyCS != null)
				msgs = ((InternalEObject)mappingBodyCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_RULE_CS__MAPPING_BODY_CS, null, msgs);
			if (newMappingBodyCS != null)
				msgs = ((InternalEObject)newMappingBodyCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_RULE_CS__MAPPING_BODY_CS, null, msgs);
			msgs = basicSetMappingBodyCS(newMappingBodyCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_RULE_CS__MAPPING_BODY_CS, newMappingBodyCS, newMappingBodyCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingEndCS getMappingEndCS() {
		return mappingEndCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingEndCS(MappingEndCS newMappingEndCS, NotificationChain msgs) {
		MappingEndCS oldMappingEndCS = mappingEndCS;
		mappingEndCS = newMappingEndCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_RULE_CS__MAPPING_END_CS, oldMappingEndCS, newMappingEndCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingEndCS(MappingEndCS newMappingEndCS) {
		if (newMappingEndCS != mappingEndCS) {
			NotificationChain msgs = null;
			if (mappingEndCS != null)
				msgs = ((InternalEObject)mappingEndCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_RULE_CS__MAPPING_END_CS, null, msgs);
			if (newMappingEndCS != null)
				msgs = ((InternalEObject)newMappingEndCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_RULE_CS__MAPPING_END_CS, null, msgs);
			msgs = basicSetMappingEndCS(newMappingEndCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_RULE_CS__MAPPING_END_CS, newMappingEndCS, newMappingEndCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingExtensionCS> getMappingExtension() {
		if (mappingExtension == null) {
			mappingExtension = new EObjectContainmentEList<MappingExtensionCS>(MappingExtensionCS.class, this, CSTPackage.MAPPING_RULE_CS__MAPPING_EXTENSION);
		}
		return mappingExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.MAPPING_RULE_CS__GUARD:
				return basicSetGuard(null, msgs);
			case CSTPackage.MAPPING_RULE_CS__MAPPING_INIT_CS:
				return basicSetMappingInitCS(null, msgs);
			case CSTPackage.MAPPING_RULE_CS__MAPPING_BODY_CS:
				return basicSetMappingBodyCS(null, msgs);
			case CSTPackage.MAPPING_RULE_CS__MAPPING_END_CS:
				return basicSetMappingEndCS(null, msgs);
			case CSTPackage.MAPPING_RULE_CS__MAPPING_EXTENSION:
				return ((InternalEList<?>)getMappingExtension()).basicRemove(otherEnd, msgs);
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
			case CSTPackage.MAPPING_RULE_CS__GUARD:
				return getGuard();
			case CSTPackage.MAPPING_RULE_CS__MAPPING_INIT_CS:
				return getMappingInitCS();
			case CSTPackage.MAPPING_RULE_CS__MAPPING_BODY_CS:
				return getMappingBodyCS();
			case CSTPackage.MAPPING_RULE_CS__MAPPING_END_CS:
				return getMappingEndCS();
			case CSTPackage.MAPPING_RULE_CS__MAPPING_EXTENSION:
				return getMappingExtension();
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
			case CSTPackage.MAPPING_RULE_CS__GUARD:
				setGuard((OCLExpressionCS)newValue);
				return;
			case CSTPackage.MAPPING_RULE_CS__MAPPING_INIT_CS:
				setMappingInitCS((MappingInitCS)newValue);
				return;
			case CSTPackage.MAPPING_RULE_CS__MAPPING_BODY_CS:
				setMappingBodyCS((MappingBodyCS)newValue);
				return;
			case CSTPackage.MAPPING_RULE_CS__MAPPING_END_CS:
				setMappingEndCS((MappingEndCS)newValue);
				return;
			case CSTPackage.MAPPING_RULE_CS__MAPPING_EXTENSION:
				getMappingExtension().clear();
				getMappingExtension().addAll((Collection<? extends MappingExtensionCS>)newValue);
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
			case CSTPackage.MAPPING_RULE_CS__GUARD:
				setGuard((OCLExpressionCS)null);
				return;
			case CSTPackage.MAPPING_RULE_CS__MAPPING_INIT_CS:
				setMappingInitCS((MappingInitCS)null);
				return;
			case CSTPackage.MAPPING_RULE_CS__MAPPING_BODY_CS:
				setMappingBodyCS((MappingBodyCS)null);
				return;
			case CSTPackage.MAPPING_RULE_CS__MAPPING_END_CS:
				setMappingEndCS((MappingEndCS)null);
				return;
			case CSTPackage.MAPPING_RULE_CS__MAPPING_EXTENSION:
				getMappingExtension().clear();
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
			case CSTPackage.MAPPING_RULE_CS__GUARD:
				return guard != null;
			case CSTPackage.MAPPING_RULE_CS__MAPPING_INIT_CS:
				return mappingInitCS != null;
			case CSTPackage.MAPPING_RULE_CS__MAPPING_BODY_CS:
				return mappingBodyCS != null;
			case CSTPackage.MAPPING_RULE_CS__MAPPING_END_CS:
				return mappingEndCS != null;
			case CSTPackage.MAPPING_RULE_CS__MAPPING_EXTENSION:
				return mappingExtension != null && !mappingExtension.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MappingRuleCSImpl
