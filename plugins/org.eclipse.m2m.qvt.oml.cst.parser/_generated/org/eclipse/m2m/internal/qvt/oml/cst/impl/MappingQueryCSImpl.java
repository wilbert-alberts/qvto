/**
 * Copyright (c) 2007, 2010 Borland Software Corporation and others.
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
 * $Id: MappingQueryCSImpl.java,v 1.5 2010/01/29 15:23:41 sboyko Exp $
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
import org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS;

import org.eclipse.ocl.cst.OCLExpressionCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Query CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingQueryCSImpl#getExpressions <em>Expressions</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.impl.MappingQueryCSImpl#isIsSimpleDefinition <em>Is Simple Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingQueryCSImpl extends MappingMethodCSImpl implements MappingQueryCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

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
	 * The default value of the '{@link #isIsSimpleDefinition() <em>Is Simple Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSimpleDefinition()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_SIMPLE_DEFINITION_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isIsSimpleDefinition() <em>Is Simple Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSimpleDefinition()
	 * @generated
	 * @ordered
	 */
	protected static final int IS_SIMPLE_DEFINITION_EFLAG = 1 << 9;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingQueryCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.MAPPING_QUERY_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OCLExpressionCS> getExpressions() {
		if (expressions == null) {
			expressions = new EObjectContainmentEList<OCLExpressionCS>(OCLExpressionCS.class, this, CSTPackage.MAPPING_QUERY_CS__EXPRESSIONS);
		}
		return expressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsSimpleDefinition() {
		return (eFlags & IS_SIMPLE_DEFINITION_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSimpleDefinition(boolean newIsSimpleDefinition) {
		boolean oldIsSimpleDefinition = (eFlags & IS_SIMPLE_DEFINITION_EFLAG) != 0;
		if (newIsSimpleDefinition) eFlags |= IS_SIMPLE_DEFINITION_EFLAG; else eFlags &= ~IS_SIMPLE_DEFINITION_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_QUERY_CS__IS_SIMPLE_DEFINITION, oldIsSimpleDefinition, newIsSimpleDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.MAPPING_QUERY_CS__EXPRESSIONS:
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
			case CSTPackage.MAPPING_QUERY_CS__EXPRESSIONS:
				return getExpressions();
			case CSTPackage.MAPPING_QUERY_CS__IS_SIMPLE_DEFINITION:
				return isIsSimpleDefinition();
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
			case CSTPackage.MAPPING_QUERY_CS__EXPRESSIONS:
				getExpressions().clear();
				getExpressions().addAll((Collection<? extends OCLExpressionCS>)newValue);
				return;
			case CSTPackage.MAPPING_QUERY_CS__IS_SIMPLE_DEFINITION:
				setIsSimpleDefinition((Boolean)newValue);
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
			case CSTPackage.MAPPING_QUERY_CS__EXPRESSIONS:
				getExpressions().clear();
				return;
			case CSTPackage.MAPPING_QUERY_CS__IS_SIMPLE_DEFINITION:
				setIsSimpleDefinition(IS_SIMPLE_DEFINITION_EDEFAULT);
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
			case CSTPackage.MAPPING_QUERY_CS__EXPRESSIONS:
				return expressions != null && !expressions.isEmpty();
			case CSTPackage.MAPPING_QUERY_CS__IS_SIMPLE_DEFINITION:
				return ((eFlags & IS_SIMPLE_DEFINITION_EFLAG) != 0) != IS_SIMPLE_DEFINITION_EDEFAULT;
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
		result.append(" (isSimpleDefinition: "); //$NON-NLS-1$
		result.append((eFlags & IS_SIMPLE_DEFINITION_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

} //MappingQueryCSImpl
