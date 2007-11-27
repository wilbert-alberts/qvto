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
import org.eclipse.m2m.qvt.oml.internal.cst.WhileExpCS;

import org.eclipse.ocl.cst.OCLExpressionCS;

import org.eclipse.ocl.cst.impl.OCLExpressionCSImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>While Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.WhileExpCSImpl#getBodyExpressions <em>Body Expressions</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.WhileExpCSImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.WhileExpCSImpl#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WhileExpCSImpl extends OCLExpressionCSImpl implements WhileExpCS {
	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

    /**
	 * The cached value of the '{@link #getBodyExpressions() <em>Body Expressions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpressionCS> bodyExpressions;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected OCLExpressionCS condition;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected OCLExpressionCS result;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WhileExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.WHILE_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OCLExpressionCS> getBodyExpressions() {
		if (bodyExpressions == null) {
			bodyExpressions = new EObjectContainmentEList<OCLExpressionCS>(OCLExpressionCS.class, this, CSTPackage.WHILE_EXP_CS__BODY_EXPRESSIONS);
		}
		return bodyExpressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpressionCS getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(OCLExpressionCS newCondition, NotificationChain msgs) {
		OCLExpressionCS oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.WHILE_EXP_CS__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(OCLExpressionCS newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.WHILE_EXP_CS__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.WHILE_EXP_CS__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.WHILE_EXP_CS__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpressionCS getResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResult(OCLExpressionCS newResult, NotificationChain msgs) {
		OCLExpressionCS oldResult = result;
		result = newResult;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.WHILE_EXP_CS__RESULT, oldResult, newResult);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResult(OCLExpressionCS newResult) {
		if (newResult != result) {
			NotificationChain msgs = null;
			if (result != null)
				msgs = ((InternalEObject)result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.WHILE_EXP_CS__RESULT, null, msgs);
			if (newResult != null)
				msgs = ((InternalEObject)newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.WHILE_EXP_CS__RESULT, null, msgs);
			msgs = basicSetResult(newResult, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.WHILE_EXP_CS__RESULT, newResult, newResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.WHILE_EXP_CS__BODY_EXPRESSIONS:
				return ((InternalEList<?>)getBodyExpressions()).basicRemove(otherEnd, msgs);
			case CSTPackage.WHILE_EXP_CS__CONDITION:
				return basicSetCondition(null, msgs);
			case CSTPackage.WHILE_EXP_CS__RESULT:
				return basicSetResult(null, msgs);
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
			case CSTPackage.WHILE_EXP_CS__BODY_EXPRESSIONS:
				return getBodyExpressions();
			case CSTPackage.WHILE_EXP_CS__CONDITION:
				return getCondition();
			case CSTPackage.WHILE_EXP_CS__RESULT:
				return getResult();
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
			case CSTPackage.WHILE_EXP_CS__BODY_EXPRESSIONS:
				getBodyExpressions().clear();
				getBodyExpressions().addAll((Collection<? extends OCLExpressionCS>)newValue);
				return;
			case CSTPackage.WHILE_EXP_CS__CONDITION:
				setCondition((OCLExpressionCS)newValue);
				return;
			case CSTPackage.WHILE_EXP_CS__RESULT:
				setResult((OCLExpressionCS)newValue);
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
			case CSTPackage.WHILE_EXP_CS__BODY_EXPRESSIONS:
				getBodyExpressions().clear();
				return;
			case CSTPackage.WHILE_EXP_CS__CONDITION:
				setCondition((OCLExpressionCS)null);
				return;
			case CSTPackage.WHILE_EXP_CS__RESULT:
				setResult((OCLExpressionCS)null);
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
			case CSTPackage.WHILE_EXP_CS__BODY_EXPRESSIONS:
				return bodyExpressions != null && !bodyExpressions.isEmpty();
			case CSTPackage.WHILE_EXP_CS__CONDITION:
				return condition != null;
			case CSTPackage.WHILE_EXP_CS__RESULT:
				return result != null;
		}
		return super.eIsSet(featureID);
	}

} //WhileExpCSImpl
