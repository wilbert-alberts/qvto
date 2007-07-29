/**
 * <copyright>
 * </copyright>
 *
 * $Id: ForeignKeyImpl.java,v 1.1 2007/07/29 21:25:33 radvorak Exp $
 */
package rdb.constraints.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import rdb.Element;

import rdb.constraints.ConstraintsPackage;
import rdb.constraints.ForeignKey;
import rdb.constraints.UniqueConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Foreign Key</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.constraints.impl.ForeignKeyImpl#getReferredUC <em>Referred UC</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForeignKeyImpl extends ColumnRefConstraintImpl implements ForeignKey {
	/**
	 * The cached value of the '{@link #getReferredUC() <em>Referred UC</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getReferredUC()
	 * @generated
	 * @ordered
	 */
    protected UniqueConstraint referredUC = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ForeignKeyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected EClass eStaticClass() {
		return ConstraintsPackage.eINSTANCE.getForeignKey();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public UniqueConstraint getReferredUC() {
		if (referredUC != null && referredUC.eIsProxy()) {
			UniqueConstraint oldReferredUC = referredUC;
			referredUC = (UniqueConstraint)eResolveProxy((InternalEObject)referredUC);
			if (referredUC != oldReferredUC) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConstraintsPackage.FOREIGN_KEY__REFERRED_UC, oldReferredUC, referredUC));
			}
		}
		return referredUC;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public UniqueConstraint basicGetReferredUC() {
		return referredUC;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setReferredUC(UniqueConstraint newReferredUC) {
		UniqueConstraint oldReferredUC = referredUC;
		referredUC = newReferredUC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintsPackage.FOREIGN_KEY__REFERRED_UC, oldReferredUC, referredUC));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ConstraintsPackage.FOREIGN_KEY__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case ConstraintsPackage.FOREIGN_KEY__NAME:
				return getName();
			case ConstraintsPackage.FOREIGN_KEY__INCLUDED_COLUMNS:
				return getIncludedColumns();
			case ConstraintsPackage.FOREIGN_KEY__REFERRED_UC:
				if (resolve) return getReferredUC();
				return basicGetReferredUC();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ConstraintsPackage.FOREIGN_KEY__PARENT:
				setParent((Element)newValue);
				return;
			case ConstraintsPackage.FOREIGN_KEY__NAME:
				setName((String)newValue);
				return;
			case ConstraintsPackage.FOREIGN_KEY__INCLUDED_COLUMNS:
				getIncludedColumns().clear();
				getIncludedColumns().addAll((Collection)newValue);
				return;
			case ConstraintsPackage.FOREIGN_KEY__REFERRED_UC:
				setReferredUC((UniqueConstraint)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ConstraintsPackage.FOREIGN_KEY__PARENT:
				setParent((Element)null);
				return;
			case ConstraintsPackage.FOREIGN_KEY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConstraintsPackage.FOREIGN_KEY__INCLUDED_COLUMNS:
				getIncludedColumns().clear();
				return;
			case ConstraintsPackage.FOREIGN_KEY__REFERRED_UC:
				setReferredUC((UniqueConstraint)null);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ConstraintsPackage.FOREIGN_KEY__PARENT:
				return parent != null;
			case ConstraintsPackage.FOREIGN_KEY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConstraintsPackage.FOREIGN_KEY__INCLUDED_COLUMNS:
				return includedColumns != null && !includedColumns.isEmpty();
			case ConstraintsPackage.FOREIGN_KEY__REFERRED_UC:
				return referredUC != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //ForeignKeyImpl
