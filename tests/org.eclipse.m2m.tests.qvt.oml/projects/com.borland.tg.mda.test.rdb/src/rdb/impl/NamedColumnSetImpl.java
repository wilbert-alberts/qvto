/**
 * <copyright>
 * </copyright>
 *
 * $Id: NamedColumnSetImpl.java,v 1.1 2007/07/29 21:25:34 radvorak Exp $
 */
package rdb.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import rdb.Element;
import rdb.NamedColumnSet;
import rdb.RdbPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Column Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class NamedColumnSetImpl extends SchemaElementImpl implements NamedColumnSet {
	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected NamedColumnSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected EClass eStaticClass() {
		return RdbPackage.eINSTANCE.getNamedColumnSet();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case RdbPackage.NAMED_COLUMN_SET__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case RdbPackage.NAMED_COLUMN_SET__NAME:
				return getName();
			case RdbPackage.NAMED_COLUMN_SET__OWNER:
				return getOwner();
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
			case RdbPackage.NAMED_COLUMN_SET__PARENT:
				setParent((Element)newValue);
				return;
			case RdbPackage.NAMED_COLUMN_SET__NAME:
				setName((String)newValue);
				return;
			case RdbPackage.NAMED_COLUMN_SET__OWNER:
				setOwner((String)newValue);
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
			case RdbPackage.NAMED_COLUMN_SET__PARENT:
				setParent((Element)null);
				return;
			case RdbPackage.NAMED_COLUMN_SET__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RdbPackage.NAMED_COLUMN_SET__OWNER:
				setOwner(OWNER_EDEFAULT);
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
			case RdbPackage.NAMED_COLUMN_SET__PARENT:
				return parent != null;
			case RdbPackage.NAMED_COLUMN_SET__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RdbPackage.NAMED_COLUMN_SET__OWNER:
				return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
		}
		return eDynamicIsSet(eFeature);
	}

} //NamedColumnSetImpl
