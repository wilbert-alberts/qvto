/**
 * <copyright>
 * </copyright>
 *
 * $Id: UniqueConstraintImpl.java,v 1.1 2007/07/29 21:25:33 radvorak Exp $
 */
package rdb.constraints.impl;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import rdb.Element;

import rdb.constraints.ConstraintsPackage;
import rdb.constraints.UniqueConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unique Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class UniqueConstraintImpl extends ColumnRefConstraintImpl implements UniqueConstraint {
	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected UniqueConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected EClass eStaticClass() {
		return ConstraintsPackage.eINSTANCE.getUniqueConstraint();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ConstraintsPackage.UNIQUE_CONSTRAINT__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case ConstraintsPackage.UNIQUE_CONSTRAINT__NAME:
				return getName();
			case ConstraintsPackage.UNIQUE_CONSTRAINT__INCLUDED_COLUMNS:
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
			case ConstraintsPackage.UNIQUE_CONSTRAINT__PARENT:
				setParent((Element)newValue);
				return;
			case ConstraintsPackage.UNIQUE_CONSTRAINT__NAME:
				setName((String)newValue);
				return;
			case ConstraintsPackage.UNIQUE_CONSTRAINT__INCLUDED_COLUMNS:
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
			case ConstraintsPackage.UNIQUE_CONSTRAINT__PARENT:
				setParent((Element)null);
				return;
			case ConstraintsPackage.UNIQUE_CONSTRAINT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConstraintsPackage.UNIQUE_CONSTRAINT__INCLUDED_COLUMNS:
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
			case ConstraintsPackage.UNIQUE_CONSTRAINT__PARENT:
				return parent != null;
			case ConstraintsPackage.UNIQUE_CONSTRAINT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConstraintsPackage.UNIQUE_CONSTRAINT__INCLUDED_COLUMNS:
				return includedColumns != null && !includedColumns.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

} //UniqueConstraintImpl
