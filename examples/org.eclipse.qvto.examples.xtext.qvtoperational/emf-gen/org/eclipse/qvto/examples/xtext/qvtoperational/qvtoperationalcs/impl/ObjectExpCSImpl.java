/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ExpressionBlockCSImpl;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ObjectExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Object Exp CS</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ObjectExpCSImpl#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ObjectExpCSImpl#isIsImplicit <em>Is Implicit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectExpCSImpl
		extends
		ExpressionBlockCSImpl
		implements ObjectExpCS {

	/**
	 * The default value of the '{@link #getSimpleNameCS() <em>Simple Name CS</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSimpleNameCS()
	 * @generated
	 * @ordered
	 */
	protected static final String SIMPLE_NAME_CS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSimpleNameCS() <em>Simple Name CS</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSimpleNameCS()
	 * @generated
	 * @ordered
	 */
	protected String simpleNameCS = SIMPLE_NAME_CS_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsImplicit() <em>Is Implicit</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isIsImplicit()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_IMPLICIT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsImplicit() <em>Is Implicit</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isIsImplicit()
	 * @generated
	 * @ordered
	 */
	protected boolean isImplicit = IS_IMPLICIT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QvtoperationalcsPackage.Literals.OBJECT_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSimpleNameCS() {
		return simpleNameCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleNameCS(String newSimpleNameCS) {
		String oldSimpleNameCS = simpleNameCS;
		simpleNameCS = newSimpleNameCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.OBJECT_EXP_CS__SIMPLE_NAME_CS, oldSimpleNameCS, simpleNameCS));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsImplicit() {
		return isImplicit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsImplicit(boolean newIsImplicit) {
		boolean oldIsImplicit = isImplicit;
		isImplicit = newIsImplicit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.OBJECT_EXP_CS__IS_IMPLICIT, oldIsImplicit, isImplicit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor<R> v) {
		return v.visitObjectExpCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final BaseCSVisitor<R> v) {
		return ((QVTOperationalCSVisitor<R>)v).visitObjectExpCS(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QvtoperationalcsPackage.OBJECT_EXP_CS__SIMPLE_NAME_CS:
				return getSimpleNameCS();
			case QvtoperationalcsPackage.OBJECT_EXP_CS__IS_IMPLICIT:
				return isIsImplicit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QvtoperationalcsPackage.OBJECT_EXP_CS__SIMPLE_NAME_CS:
				setSimpleNameCS((String)newValue);
				return;
			case QvtoperationalcsPackage.OBJECT_EXP_CS__IS_IMPLICIT:
				setIsImplicit((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case QvtoperationalcsPackage.OBJECT_EXP_CS__SIMPLE_NAME_CS:
				setSimpleNameCS(SIMPLE_NAME_CS_EDEFAULT);
				return;
			case QvtoperationalcsPackage.OBJECT_EXP_CS__IS_IMPLICIT:
				setIsImplicit(IS_IMPLICIT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case QvtoperationalcsPackage.OBJECT_EXP_CS__SIMPLE_NAME_CS:
				return SIMPLE_NAME_CS_EDEFAULT == null ? simpleNameCS != null : !SIMPLE_NAME_CS_EDEFAULT.equals(simpleNameCS);
			case QvtoperationalcsPackage.OBJECT_EXP_CS__IS_IMPLICIT:
				return isImplicit != IS_IMPLICIT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return super.toString();
	}

} // ObjectExpCSImpl
