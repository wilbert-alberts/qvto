/**
 * <copyright>
 * </copyright>
 *
 * $Id: ReferencedViewColumnImpl.java,v 1.1 2007/07/29 21:25:32 radvorak Exp $
 */
package rdb.view.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import rdb.Column;
import rdb.Element;

import rdb.view.ReferencedViewColumn;
import rdb.view.ViewPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Referenced View Column</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.view.impl.ReferencedViewColumnImpl#getRefColumn <em>Ref Column</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferencedViewColumnImpl extends ViewColumnImpl implements ReferencedViewColumn {
	/**
	 * The cached value of the '{@link #getRefColumn() <em>Ref Column</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getRefColumn()
	 * @generated
	 * @ordered
	 */
    protected Column refColumn = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ReferencedViewColumnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected EClass eStaticClass() {
		return ViewPackage.eINSTANCE.getReferencedViewColumn();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Column getRefColumn() {
		if (refColumn != null && refColumn.eIsProxy()) {
			Column oldRefColumn = refColumn;
			refColumn = (Column)eResolveProxy((InternalEObject)refColumn);
			if (refColumn != oldRefColumn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ViewPackage.REFERENCED_VIEW_COLUMN__REF_COLUMN, oldRefColumn, refColumn));
			}
		}
		return refColumn;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Column basicGetRefColumn() {
		return refColumn;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setRefColumn(Column newRefColumn) {
		Column oldRefColumn = refColumn;
		refColumn = newRefColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.REFERENCED_VIEW_COLUMN__REF_COLUMN, oldRefColumn, refColumn));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ViewPackage.REFERENCED_VIEW_COLUMN__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case ViewPackage.REFERENCED_VIEW_COLUMN__NAME:
				return getName();
			case ViewPackage.REFERENCED_VIEW_COLUMN__REF_COLUMN:
				if (resolve) return getRefColumn();
				return basicGetRefColumn();
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
			case ViewPackage.REFERENCED_VIEW_COLUMN__PARENT:
				setParent((Element)newValue);
				return;
			case ViewPackage.REFERENCED_VIEW_COLUMN__NAME:
				setName((String)newValue);
				return;
			case ViewPackage.REFERENCED_VIEW_COLUMN__REF_COLUMN:
				setRefColumn((Column)newValue);
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
			case ViewPackage.REFERENCED_VIEW_COLUMN__PARENT:
				setParent((Element)null);
				return;
			case ViewPackage.REFERENCED_VIEW_COLUMN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ViewPackage.REFERENCED_VIEW_COLUMN__REF_COLUMN:
				setRefColumn((Column)null);
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
			case ViewPackage.REFERENCED_VIEW_COLUMN__PARENT:
				return parent != null;
			case ViewPackage.REFERENCED_VIEW_COLUMN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ViewPackage.REFERENCED_VIEW_COLUMN__REF_COLUMN:
				return refColumn != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //ReferencedViewColumnImpl
