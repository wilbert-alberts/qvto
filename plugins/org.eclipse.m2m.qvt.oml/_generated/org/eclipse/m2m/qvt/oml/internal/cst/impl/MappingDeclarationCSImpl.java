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
import org.eclipse.m2m.qvt.oml.internal.cst.DirectionKindCS;
import org.eclipse.m2m.qvt.oml.internal.cst.DirectionKindEnum;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS;
import org.eclipse.m2m.qvt.oml.internal.cst.ParameterDeclarationCS;

import org.eclipse.m2m.qvt.oml.internal.cst.TypeSpecCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.TypeCS;

import org.eclipse.ocl.cst.impl.CSTNodeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Declaration CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingDeclarationCSImpl#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingDeclarationCSImpl#getContextType <em>Context Type</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingDeclarationCSImpl#getContextTypeAndName <em>Context Type And Name</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingDeclarationCSImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingDeclarationCSImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingDeclarationCSImpl#isBlackBox <em>Black Box</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingDeclarationCSImpl#getDirectionKindCS <em>Direction Kind CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingDeclarationCSImpl extends CSTNodeImpl implements MappingDeclarationCS {
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
	 * The cached value of the '{@link #getContextType() <em>Context Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextType()
	 * @generated
	 * @ordered
	 */
	protected TypeCS contextType;

	/**
	 * The cached value of the '{@link #getContextTypeAndName() <em>Context Type And Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextTypeAndName()
	 * @generated
	 * @ordered
	 */
	protected TypeCS contextTypeAndName;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterDeclarationCS> parameters;

	/**
	 * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnType()
	 * @generated
	 * @ordered
	 */
	protected TypeSpecCS returnType;

	/**
	 * The default value of the '{@link #isBlackBox() <em>Black Box</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBlackBox()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BLACK_BOX_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isBlackBox() <em>Black Box</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBlackBox()
	 * @generated
	 * @ordered
	 */
	protected static final int BLACK_BOX_EFLAG = 1 << 8;

	/**
	 * The cached value of the '{@link #getDirectionKindCS() <em>Direction Kind CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectionKindCS()
	 * @generated
	 * @ordered
	 */
	protected DirectionKindCS directionKindCS;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingDeclarationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.MAPPING_DECLARATION_CS;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_DECLARATION_CS__SIMPLE_NAME_CS, oldSimpleNameCS, newSimpleNameCS);
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
				msgs = ((InternalEObject)simpleNameCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_DECLARATION_CS__SIMPLE_NAME_CS, null, msgs);
			if (newSimpleNameCS != null)
				msgs = ((InternalEObject)newSimpleNameCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_DECLARATION_CS__SIMPLE_NAME_CS, null, msgs);
			msgs = basicSetSimpleNameCS(newSimpleNameCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_DECLARATION_CS__SIMPLE_NAME_CS, newSimpleNameCS, newSimpleNameCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeCS getContextType() {
		return contextType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContextType(TypeCS newContextType, NotificationChain msgs) {
		TypeCS oldContextType = contextType;
		contextType = newContextType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE, oldContextType, newContextType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextType(TypeCS newContextType) {
		if (newContextType != contextType) {
			NotificationChain msgs = null;
			if (contextType != null)
				msgs = ((InternalEObject)contextType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE, null, msgs);
			if (newContextType != null)
				msgs = ((InternalEObject)newContextType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE, null, msgs);
			msgs = basicSetContextType(newContextType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE, newContextType, newContextType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeCS getContextTypeAndName() {
		return contextTypeAndName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContextTypeAndName(TypeCS newContextTypeAndName, NotificationChain msgs) {
		TypeCS oldContextTypeAndName = contextTypeAndName;
		contextTypeAndName = newContextTypeAndName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE_AND_NAME, oldContextTypeAndName, newContextTypeAndName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextTypeAndName(TypeCS newContextTypeAndName) {
		if (newContextTypeAndName != contextTypeAndName) {
			NotificationChain msgs = null;
			if (contextTypeAndName != null)
				msgs = ((InternalEObject)contextTypeAndName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE_AND_NAME, null, msgs);
			if (newContextTypeAndName != null)
				msgs = ((InternalEObject)newContextTypeAndName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE_AND_NAME, null, msgs);
			msgs = basicSetContextTypeAndName(newContextTypeAndName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE_AND_NAME, newContextTypeAndName, newContextTypeAndName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterDeclarationCS> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<ParameterDeclarationCS>(ParameterDeclarationCS.class, this, CSTPackage.MAPPING_DECLARATION_CS__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSpecCS getReturnType() {
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReturnType(TypeSpecCS newReturnType, NotificationChain msgs) {
		TypeSpecCS oldReturnType = returnType;
		returnType = newReturnType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_DECLARATION_CS__RETURN_TYPE, oldReturnType, newReturnType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnType(TypeSpecCS newReturnType) {
		if (newReturnType != returnType) {
			NotificationChain msgs = null;
			if (returnType != null)
				msgs = ((InternalEObject)returnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_DECLARATION_CS__RETURN_TYPE, null, msgs);
			if (newReturnType != null)
				msgs = ((InternalEObject)newReturnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_DECLARATION_CS__RETURN_TYPE, null, msgs);
			msgs = basicSetReturnType(newReturnType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_DECLARATION_CS__RETURN_TYPE, newReturnType, newReturnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBlackBox() {
		return (eFlags & BLACK_BOX_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlackBox(boolean newBlackBox) {
		boolean oldBlackBox = (eFlags & BLACK_BOX_EFLAG) != 0;
		if (newBlackBox) eFlags |= BLACK_BOX_EFLAG; else eFlags &= ~BLACK_BOX_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_DECLARATION_CS__BLACK_BOX, oldBlackBox, newBlackBox));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionKindCS getDirectionKindCS() {
		return directionKindCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDirectionKindCS(DirectionKindCS newDirectionKindCS, NotificationChain msgs) {
		DirectionKindCS oldDirectionKindCS = directionKindCS;
		directionKindCS = newDirectionKindCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_DECLARATION_CS__DIRECTION_KIND_CS, oldDirectionKindCS, newDirectionKindCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirectionKindCS(DirectionKindCS newDirectionKindCS) {
		if (newDirectionKindCS != directionKindCS) {
			NotificationChain msgs = null;
			if (directionKindCS != null)
				msgs = ((InternalEObject)directionKindCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_DECLARATION_CS__DIRECTION_KIND_CS, null, msgs);
			if (newDirectionKindCS != null)
				msgs = ((InternalEObject)newDirectionKindCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MAPPING_DECLARATION_CS__DIRECTION_KIND_CS, null, msgs);
			msgs = basicSetDirectionKindCS(newDirectionKindCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_DECLARATION_CS__DIRECTION_KIND_CS, newDirectionKindCS, newDirectionKindCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.MAPPING_DECLARATION_CS__SIMPLE_NAME_CS:
				return basicSetSimpleNameCS(null, msgs);
			case CSTPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE:
				return basicSetContextType(null, msgs);
			case CSTPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE_AND_NAME:
				return basicSetContextTypeAndName(null, msgs);
			case CSTPackage.MAPPING_DECLARATION_CS__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case CSTPackage.MAPPING_DECLARATION_CS__RETURN_TYPE:
				return basicSetReturnType(null, msgs);
			case CSTPackage.MAPPING_DECLARATION_CS__DIRECTION_KIND_CS:
				return basicSetDirectionKindCS(null, msgs);
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
			case CSTPackage.MAPPING_DECLARATION_CS__SIMPLE_NAME_CS:
				return getSimpleNameCS();
			case CSTPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE:
				return getContextType();
			case CSTPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE_AND_NAME:
				return getContextTypeAndName();
			case CSTPackage.MAPPING_DECLARATION_CS__PARAMETERS:
				return getParameters();
			case CSTPackage.MAPPING_DECLARATION_CS__RETURN_TYPE:
				return getReturnType();
			case CSTPackage.MAPPING_DECLARATION_CS__BLACK_BOX:
				return isBlackBox() ? Boolean.TRUE : Boolean.FALSE;
			case CSTPackage.MAPPING_DECLARATION_CS__DIRECTION_KIND_CS:
				return getDirectionKindCS();
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
			case CSTPackage.MAPPING_DECLARATION_CS__SIMPLE_NAME_CS:
				setSimpleNameCS((SimpleNameCS)newValue);
				return;
			case CSTPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE:
				setContextType((TypeCS)newValue);
				return;
			case CSTPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE_AND_NAME:
				setContextTypeAndName((TypeCS)newValue);
				return;
			case CSTPackage.MAPPING_DECLARATION_CS__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends ParameterDeclarationCS>)newValue);
				return;
			case CSTPackage.MAPPING_DECLARATION_CS__RETURN_TYPE:
				setReturnType((TypeSpecCS)newValue);
				return;
			case CSTPackage.MAPPING_DECLARATION_CS__BLACK_BOX:
				setBlackBox(((Boolean)newValue).booleanValue());
				return;
			case CSTPackage.MAPPING_DECLARATION_CS__DIRECTION_KIND_CS:
				setDirectionKindCS((DirectionKindCS)newValue);
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
			case CSTPackage.MAPPING_DECLARATION_CS__SIMPLE_NAME_CS:
				setSimpleNameCS((SimpleNameCS)null);
				return;
			case CSTPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE:
				setContextType((TypeCS)null);
				return;
			case CSTPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE_AND_NAME:
				setContextTypeAndName((TypeCS)null);
				return;
			case CSTPackage.MAPPING_DECLARATION_CS__PARAMETERS:
				getParameters().clear();
				return;
			case CSTPackage.MAPPING_DECLARATION_CS__RETURN_TYPE:
				setReturnType((TypeSpecCS)null);
				return;
			case CSTPackage.MAPPING_DECLARATION_CS__BLACK_BOX:
				setBlackBox(BLACK_BOX_EDEFAULT);
				return;
			case CSTPackage.MAPPING_DECLARATION_CS__DIRECTION_KIND_CS:
				setDirectionKindCS((DirectionKindCS)null);
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
			case CSTPackage.MAPPING_DECLARATION_CS__SIMPLE_NAME_CS:
				return simpleNameCS != null;
			case CSTPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE:
				return contextType != null;
			case CSTPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE_AND_NAME:
				return contextTypeAndName != null;
			case CSTPackage.MAPPING_DECLARATION_CS__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case CSTPackage.MAPPING_DECLARATION_CS__RETURN_TYPE:
				return returnType != null;
			case CSTPackage.MAPPING_DECLARATION_CS__BLACK_BOX:
				return ((eFlags & BLACK_BOX_EFLAG) != 0) != BLACK_BOX_EDEFAULT;
			case CSTPackage.MAPPING_DECLARATION_CS__DIRECTION_KIND_CS:
				return directionKindCS != null;
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
		result.append(" (blackBox: "); //$NON-NLS-1$
		result.append((eFlags & BLACK_BOX_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

} //MappingDeclarationCSImpl
