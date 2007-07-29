/**
 * <copyright>
 * </copyright>
 *
 * $Id: PrimaryKeyImpl.java,v 1.1 2007/07/29 21:25:33 radvorak Exp $
 */
package rdb.constraints.impl;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import rdb.Element;

import rdb.constraints.ConstraintsPackage;
import rdb.constraints.PrimaryKey;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primary Key</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PrimaryKeyImpl extends UniqueConstraintImpl implements PrimaryKey {
	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected PrimaryKeyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected EClass eStaticClass() {
		return ConstraintsPackage.eINSTANCE.getPrimaryKey();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ConstraintsPackage.PRIMARY_KEY__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case ConstraintsPackage.PRIMARY_KEY__NAME:
				return getName();
			case ConstraintsPackage.PRIMARY_KEY__INCLUDED_COLUMNS:
				return getIncludedColumns();
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
			case ConstraintsPackage.PRIMARY_KEY__PARENT:
				setParent((Element)newValue);
				return;
			case ConstraintsPackage.PRIMARY_KEY__NAME:
				setName((String)newValue);
				return;
			case ConstraintsPackage.PRIMARY_KEY__INCLUDED_COLUMNS:
				getIncludedColumns().clear();
				getIncludedColumns().addAll((Collection)newValue);
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
			case ConstraintsPackage.PRIMARY_KEY__PARENT:
				setParent((Element)null);
				return;
			case ConstraintsPackage.PRIMARY_KEY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConstraintsPackage.PRIMARY_KEY__INCLUDED_COLUMNS:
				getIncludedColumns().clear();
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
			case ConstraintsPackage.PRIMARY_KEY__PARENT:
				return parent != null;
			case ConstraintsPackage.PRIMARY_KEY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConstraintsPackage.PRIMARY_KEY__INCLUDED_COLUMNS:
				return includedColumns != null && !includedColumns.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

} //PrimaryKeyImpl
