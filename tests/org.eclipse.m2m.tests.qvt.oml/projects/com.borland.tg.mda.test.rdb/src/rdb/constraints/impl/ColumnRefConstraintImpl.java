/**
 * <copyright>
 * </copyright>
 *
 * $Id: ColumnRefConstraintImpl.java,v 1.1 2007/07/29 21:25:33 radvorak Exp $
 */
package rdb.constraints.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import rdb.Element;
import rdb.TableColumn;

import rdb.constraints.ColumnRefConstraint;
import rdb.constraints.ConstraintsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Column Ref Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.constraints.impl.ColumnRefConstraintImpl#getIncludedColumns <em>Included Columns</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ColumnRefConstraintImpl extends ConstraintImpl implements ColumnRefConstraint {
	/**
	 * The cached value of the '{@link #getIncludedColumns() <em>Included Columns</em>}' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getIncludedColumns()
	 * @generated
	 * @ordered
	 */
    protected EList includedColumns = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ColumnRefConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected EClass eStaticClass() {
		return ConstraintsPackage.eINSTANCE.getColumnRefConstraint();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList getIncludedColumns() {
		if (includedColumns == null) {
			includedColumns = new EObjectResolvingEList(TableColumn.class, this, ConstraintsPackage.COLUMN_REF_CONSTRAINT__INCLUDED_COLUMNS);
		}
		return includedColumns;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ConstraintsPackage.COLUMN_REF_CONSTRAINT__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case ConstraintsPackage.COLUMN_REF_CONSTRAINT__NAME:
				return getName();
			case ConstraintsPackage.COLUMN_REF_CONSTRAINT__INCLUDED_COLUMNS:
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
			case ConstraintsPackage.COLUMN_REF_CONSTRAINT__PARENT:
				setParent((Element)newValue);
				return;
			case ConstraintsPackage.COLUMN_REF_CONSTRAINT__NAME:
				setName((String)newValue);
				return;
			case ConstraintsPackage.COLUMN_REF_CONSTRAINT__INCLUDED_COLUMNS:
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
			case ConstraintsPackage.COLUMN_REF_CONSTRAINT__PARENT:
				setParent((Element)null);
				return;
			case ConstraintsPackage.COLUMN_REF_CONSTRAINT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConstraintsPackage.COLUMN_REF_CONSTRAINT__INCLUDED_COLUMNS:
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
			case ConstraintsPackage.COLUMN_REF_CONSTRAINT__PARENT:
				return parent != null;
			case ConstraintsPackage.COLUMN_REF_CONSTRAINT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConstraintsPackage.COLUMN_REF_CONSTRAINT__INCLUDED_COLUMNS:
				return includedColumns != null && !includedColumns.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

} //ColumnRefConstraintImpl
