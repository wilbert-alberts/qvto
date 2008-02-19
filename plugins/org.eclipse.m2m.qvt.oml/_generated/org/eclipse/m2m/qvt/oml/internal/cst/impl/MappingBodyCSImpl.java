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
import org.eclipse.m2m.qvt.oml.internal.cst.MappingBodyCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.impl.OCLExpressionCSImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Body CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingBodyCSImpl#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingBodyCSImpl#isHasImplicitObjectExp <em>Has Implicit Object Exp</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.impl.MappingBodyCSImpl#isHasPopulationSection <em>Has Population Section</em>}</li>
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
	 * The cached value of the '{@link #getContent() <em>Content</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpressionCS> content;

	/**
	 * The default value of the '{@link #isHasImplicitObjectExp() <em>Has Implicit Object Exp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasImplicitObjectExp()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_IMPLICIT_OBJECT_EXP_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isHasImplicitObjectExp() <em>Has Implicit Object Exp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasImplicitObjectExp()
	 * @generated
	 * @ordered
	 */
	protected static final int HAS_IMPLICIT_OBJECT_EXP_EFLAG = 1 << 8;

	/**
	 * The default value of the '{@link #isHasPopulationSection() <em>Has Population Section</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasPopulationSection()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_POPULATION_SECTION_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isHasPopulationSection() <em>Has Population Section</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasPopulationSection()
	 * @generated
	 * @ordered
	 */
	protected static final int HAS_POPULATION_SECTION_EFLAG = 1 << 9;

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
	public EList<OCLExpressionCS> getContent() {
		if (content == null) {
			content = new EObjectContainmentEList<OCLExpressionCS>(OCLExpressionCS.class, this, CSTPackage.MAPPING_BODY_CS__CONTENT);
		}
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasImplicitObjectExp() {
		return (eFlags & HAS_IMPLICIT_OBJECT_EXP_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasImplicitObjectExp(boolean newHasImplicitObjectExp) {
		boolean oldHasImplicitObjectExp = (eFlags & HAS_IMPLICIT_OBJECT_EXP_EFLAG) != 0;
		if (newHasImplicitObjectExp) eFlags |= HAS_IMPLICIT_OBJECT_EXP_EFLAG; else eFlags &= ~HAS_IMPLICIT_OBJECT_EXP_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_BODY_CS__HAS_IMPLICIT_OBJECT_EXP, oldHasImplicitObjectExp, newHasImplicitObjectExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasPopulationSection() {
		return (eFlags & HAS_POPULATION_SECTION_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasPopulationSection(boolean newHasPopulationSection) {
		boolean oldHasPopulationSection = (eFlags & HAS_POPULATION_SECTION_EFLAG) != 0;
		if (newHasPopulationSection) eFlags |= HAS_POPULATION_SECTION_EFLAG; else eFlags &= ~HAS_POPULATION_SECTION_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MAPPING_BODY_CS__HAS_POPULATION_SECTION, oldHasPopulationSection, newHasPopulationSection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.MAPPING_BODY_CS__CONTENT:
				return ((InternalEList<?>)getContent()).basicRemove(otherEnd, msgs);
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
			case CSTPackage.MAPPING_BODY_CS__CONTENT:
				return getContent();
			case CSTPackage.MAPPING_BODY_CS__HAS_IMPLICIT_OBJECT_EXP:
				return isHasImplicitObjectExp() ? Boolean.TRUE : Boolean.FALSE;
			case CSTPackage.MAPPING_BODY_CS__HAS_POPULATION_SECTION:
				return isHasPopulationSection() ? Boolean.TRUE : Boolean.FALSE;
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
			case CSTPackage.MAPPING_BODY_CS__CONTENT:
				getContent().clear();
				getContent().addAll((Collection<? extends OCLExpressionCS>)newValue);
				return;
			case CSTPackage.MAPPING_BODY_CS__HAS_IMPLICIT_OBJECT_EXP:
				setHasImplicitObjectExp(((Boolean)newValue).booleanValue());
				return;
			case CSTPackage.MAPPING_BODY_CS__HAS_POPULATION_SECTION:
				setHasPopulationSection(((Boolean)newValue).booleanValue());
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
			case CSTPackage.MAPPING_BODY_CS__CONTENT:
				getContent().clear();
				return;
			case CSTPackage.MAPPING_BODY_CS__HAS_IMPLICIT_OBJECT_EXP:
				setHasImplicitObjectExp(HAS_IMPLICIT_OBJECT_EXP_EDEFAULT);
				return;
			case CSTPackage.MAPPING_BODY_CS__HAS_POPULATION_SECTION:
				setHasPopulationSection(HAS_POPULATION_SECTION_EDEFAULT);
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
			case CSTPackage.MAPPING_BODY_CS__CONTENT:
				return content != null && !content.isEmpty();
			case CSTPackage.MAPPING_BODY_CS__HAS_IMPLICIT_OBJECT_EXP:
				return ((eFlags & HAS_IMPLICIT_OBJECT_EXP_EFLAG) != 0) != HAS_IMPLICIT_OBJECT_EXP_EDEFAULT;
			case CSTPackage.MAPPING_BODY_CS__HAS_POPULATION_SECTION:
				return ((eFlags & HAS_POPULATION_SECTION_EFLAG) != 0) != HAS_POPULATION_SECTION_EDEFAULT;
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
		result.append(" (hasImplicitObjectExp: "); //$NON-NLS-1$
		result.append((eFlags & HAS_IMPLICIT_OBJECT_EXP_EFLAG) != 0);
		result.append(", hasPopulationSection: "); //$NON-NLS-1$
		result.append((eFlags & HAS_POPULATION_SECTION_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

} //MappingBodyCSImpl
