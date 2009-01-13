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
 * $Id: NewRuleCallExpCSImpl.java,v 1.2 2009/01/13 20:23:44 radvorak Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage;
import org.eclipse.m2m.internal.qvt.oml.cst.NewRuleCallExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.impl.OCLExpressionCSImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>New Rule Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.NewRuleCallExpCSImpl#getScopedIdentifier <em>Scoped Identifier</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.NewRuleCallExpCSImpl#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NewRuleCallExpCSImpl extends OCLExpressionCSImpl implements NewRuleCallExpCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getScopedIdentifier() <em>Scoped Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScopedIdentifier()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS scopedIdentifier;

	/**
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpressionCS> arguments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NewRuleCallExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.NEW_RULE_CALL_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getScopedIdentifier() {
		return scopedIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScopedIdentifier(PathNameCS newScopedIdentifier, NotificationChain msgs) {
		PathNameCS oldScopedIdentifier = scopedIdentifier;
		scopedIdentifier = newScopedIdentifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.NEW_RULE_CALL_EXP_CS__SCOPED_IDENTIFIER, oldScopedIdentifier, newScopedIdentifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScopedIdentifier(PathNameCS newScopedIdentifier) {
		if (newScopedIdentifier != scopedIdentifier) {
			NotificationChain msgs = null;
			if (scopedIdentifier != null)
				msgs = ((InternalEObject)scopedIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.NEW_RULE_CALL_EXP_CS__SCOPED_IDENTIFIER, null, msgs);
			if (newScopedIdentifier != null)
				msgs = ((InternalEObject)newScopedIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.NEW_RULE_CALL_EXP_CS__SCOPED_IDENTIFIER, null, msgs);
			msgs = basicSetScopedIdentifier(newScopedIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.NEW_RULE_CALL_EXP_CS__SCOPED_IDENTIFIER, newScopedIdentifier, newScopedIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OCLExpressionCS> getArguments() {
		if (arguments == null) {
			arguments = new EObjectContainmentEList<OCLExpressionCS>(OCLExpressionCS.class, this, CSTPackage.NEW_RULE_CALL_EXP_CS__ARGUMENTS);
		}
		return arguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.NEW_RULE_CALL_EXP_CS__SCOPED_IDENTIFIER:
				return basicSetScopedIdentifier(null, msgs);
			case CSTPackage.NEW_RULE_CALL_EXP_CS__ARGUMENTS:
				return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
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
			case CSTPackage.NEW_RULE_CALL_EXP_CS__SCOPED_IDENTIFIER:
				return getScopedIdentifier();
			case CSTPackage.NEW_RULE_CALL_EXP_CS__ARGUMENTS:
				return getArguments();
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
			case CSTPackage.NEW_RULE_CALL_EXP_CS__SCOPED_IDENTIFIER:
				setScopedIdentifier((PathNameCS)newValue);
				return;
			case CSTPackage.NEW_RULE_CALL_EXP_CS__ARGUMENTS:
				getArguments().clear();
				getArguments().addAll((Collection<? extends OCLExpressionCS>)newValue);
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
			case CSTPackage.NEW_RULE_CALL_EXP_CS__SCOPED_IDENTIFIER:
				setScopedIdentifier((PathNameCS)null);
				return;
			case CSTPackage.NEW_RULE_CALL_EXP_CS__ARGUMENTS:
				getArguments().clear();
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
			case CSTPackage.NEW_RULE_CALL_EXP_CS__SCOPED_IDENTIFIER:
				return scopedIdentifier != null;
			case CSTPackage.NEW_RULE_CALL_EXP_CS__ARGUMENTS:
				return arguments != null && !arguments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NewRuleCallExpCSImpl
