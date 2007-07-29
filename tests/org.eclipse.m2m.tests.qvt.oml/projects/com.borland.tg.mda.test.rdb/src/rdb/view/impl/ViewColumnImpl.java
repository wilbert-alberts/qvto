/**
 * <copyright>
 * </copyright>
 *
 * $Id: ViewColumnImpl.java,v 1.1 2007/07/29 21:25:32 radvorak Exp $
 */
package rdb.view.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import rdb.Element;

import rdb.impl.ColumnImpl;

import rdb.view.ViewColumn;
import rdb.view.ViewPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ViewColumnImpl extends ColumnImpl implements ViewColumn {
	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ViewColumnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected EClass eStaticClass() {
		return ViewPackage.eINSTANCE.getViewColumn();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ViewPackage.VIEW_COLUMN__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case ViewPackage.VIEW_COLUMN__NAME:
				return getName();
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
			case ViewPackage.VIEW_COLUMN__PARENT:
				setParent((Element)newValue);
				return;
			case ViewPackage.VIEW_COLUMN__NAME:
				setName((String)newValue);
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
			case ViewPackage.VIEW_COLUMN__PARENT:
				setParent((Element)null);
				return;
			case ViewPackage.VIEW_COLUMN__NAME:
				setName(NAME_EDEFAULT);
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
			case ViewPackage.VIEW_COLUMN__PARENT:
				return parent != null;
			case ViewPackage.VIEW_COLUMN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return eDynamicIsSet(eFeature);
	}

} //ViewColumnImpl
