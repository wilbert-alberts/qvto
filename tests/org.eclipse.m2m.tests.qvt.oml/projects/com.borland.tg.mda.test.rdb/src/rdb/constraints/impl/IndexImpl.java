/**
 * <copyright>
 * </copyright>
 *
 * $Id: IndexImpl.java,v 1.1 2007/07/29 21:25:33 radvorak Exp $
 */
package rdb.constraints.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import rdb.Element;

import rdb.constraints.ConstraintsPackage;
import rdb.constraints.Index;
import rdb.constraints.IndexedColumn;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Index</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.constraints.impl.IndexImpl#getIndexedColumns <em>Indexed Columns</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IndexImpl extends ConstraintImpl implements Index {
	/**
	 * The cached value of the '{@link #getIndexedColumns() <em>Indexed Columns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getIndexedColumns()
	 * @generated
	 * @ordered
	 */
    protected EList indexedColumns = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected IndexImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected EClass eStaticClass() {
		return ConstraintsPackage.eINSTANCE.getIndex();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList getIndexedColumns() {
		if (indexedColumns == null) {
			indexedColumns = new EObjectContainmentEList(IndexedColumn.class, this, ConstraintsPackage.INDEX__INDEXED_COLUMNS);
		}
		return indexedColumns;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ConstraintsPackage.INDEX__INDEXED_COLUMNS:
					return ((InternalEList)getIndexedColumns()).basicRemove(otherEnd, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ConstraintsPackage.INDEX__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case ConstraintsPackage.INDEX__NAME:
				return getName();
			case ConstraintsPackage.INDEX__INDEXED_COLUMNS:
				return getIndexedColumns();
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
			case ConstraintsPackage.INDEX__PARENT:
				setParent((Element)newValue);
				return;
			case ConstraintsPackage.INDEX__NAME:
				setName((String)newValue);
				return;
			case ConstraintsPackage.INDEX__INDEXED_COLUMNS:
				getIndexedColumns().clear();
				getIndexedColumns().addAll((Collection)newValue);
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
			case ConstraintsPackage.INDEX__PARENT:
				setParent((Element)null);
				return;
			case ConstraintsPackage.INDEX__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConstraintsPackage.INDEX__INDEXED_COLUMNS:
				getIndexedColumns().clear();
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
			case ConstraintsPackage.INDEX__PARENT:
				return parent != null;
			case ConstraintsPackage.INDEX__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConstraintsPackage.INDEX__INDEXED_COLUMNS:
				return indexedColumns != null && !indexedColumns.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

} //IndexImpl
