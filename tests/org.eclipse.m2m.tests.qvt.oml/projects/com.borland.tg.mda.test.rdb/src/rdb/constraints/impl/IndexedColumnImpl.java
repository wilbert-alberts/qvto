/**
 * <copyright>
 * </copyright>
 *
 * $Id: IndexedColumnImpl.java,v 1.1 2007/07/29 21:25:33 radvorak Exp $
 */
package rdb.constraints.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import rdb.Element;
import rdb.TableColumn;

import rdb.constraints.ConstraintsPackage;
import rdb.constraints.IndexedColumn;

import rdb.impl.NamedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Indexed Column</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.constraints.impl.IndexedColumnImpl#isAscending <em>Ascending</em>}</li>
 *   <li>{@link rdb.constraints.impl.IndexedColumnImpl#getRefColumn <em>Ref Column</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IndexedColumnImpl extends NamedElementImpl implements IndexedColumn {
	/**
	 * The default value of the '{@link #isAscending() <em>Ascending</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #isAscending()
	 * @generated
	 * @ordered
	 */
    protected static final boolean ASCENDING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAscending() <em>Ascending</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #isAscending()
	 * @generated
	 * @ordered
	 */
    protected boolean ascending = ASCENDING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRefColumn() <em>Ref Column</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getRefColumn()
	 * @generated
	 * @ordered
	 */
    protected TableColumn refColumn = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected IndexedColumnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected EClass eStaticClass() {
		return ConstraintsPackage.eINSTANCE.getIndexedColumn();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public boolean isAscending() {
		return ascending;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setAscending(boolean newAscending) {
		boolean oldAscending = ascending;
		ascending = newAscending;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintsPackage.INDEXED_COLUMN__ASCENDING, oldAscending, ascending));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public TableColumn getRefColumn() {
		if (refColumn != null && refColumn.eIsProxy()) {
			TableColumn oldRefColumn = refColumn;
			refColumn = (TableColumn)eResolveProxy((InternalEObject)refColumn);
			if (refColumn != oldRefColumn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConstraintsPackage.INDEXED_COLUMN__REF_COLUMN, oldRefColumn, refColumn));
			}
		}
		return refColumn;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public TableColumn basicGetRefColumn() {
		return refColumn;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setRefColumn(TableColumn newRefColumn) {
		TableColumn oldRefColumn = refColumn;
		refColumn = newRefColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConstraintsPackage.INDEXED_COLUMN__REF_COLUMN, oldRefColumn, refColumn));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ConstraintsPackage.INDEXED_COLUMN__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case ConstraintsPackage.INDEXED_COLUMN__NAME:
				return getName();
			case ConstraintsPackage.INDEXED_COLUMN__ASCENDING:
				return isAscending() ? Boolean.TRUE : Boolean.FALSE;
			case ConstraintsPackage.INDEXED_COLUMN__REF_COLUMN:
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
			case ConstraintsPackage.INDEXED_COLUMN__PARENT:
				setParent((Element)newValue);
				return;
			case ConstraintsPackage.INDEXED_COLUMN__NAME:
				setName((String)newValue);
				return;
			case ConstraintsPackage.INDEXED_COLUMN__ASCENDING:
				setAscending(((Boolean)newValue).booleanValue());
				return;
			case ConstraintsPackage.INDEXED_COLUMN__REF_COLUMN:
				setRefColumn((TableColumn)newValue);
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
			case ConstraintsPackage.INDEXED_COLUMN__PARENT:
				setParent((Element)null);
				return;
			case ConstraintsPackage.INDEXED_COLUMN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConstraintsPackage.INDEXED_COLUMN__ASCENDING:
				setAscending(ASCENDING_EDEFAULT);
				return;
			case ConstraintsPackage.INDEXED_COLUMN__REF_COLUMN:
				setRefColumn((TableColumn)null);
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
			case ConstraintsPackage.INDEXED_COLUMN__PARENT:
				return parent != null;
			case ConstraintsPackage.INDEXED_COLUMN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConstraintsPackage.INDEXED_COLUMN__ASCENDING:
				return ascending != ASCENDING_EDEFAULT;
			case ConstraintsPackage.INDEXED_COLUMN__REF_COLUMN:
				return refColumn != null;
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (ascending: ");
		result.append(ascending);
		result.append(')');
		return result.toString();
	}

} //IndexedColumnImpl
