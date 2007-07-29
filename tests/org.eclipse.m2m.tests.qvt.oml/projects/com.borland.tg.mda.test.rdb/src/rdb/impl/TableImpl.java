/**
 * <copyright>
 * </copyright>
 *
 * $Id: TableImpl.java,v 1.1 2007/07/29 21:25:34 radvorak Exp $
 */
package rdb.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import rdb.Element;
import rdb.RdbPackage;
import rdb.Table;
import rdb.TableColumn;

import rdb.constraints.CheckConstraint;
import rdb.constraints.ForeignKey;
import rdb.constraints.Index;
import rdb.constraints.PrimaryKey;
import rdb.constraints.UniqueConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.impl.TableImpl#getColumns <em>Columns</em>}</li>
 *   <li>{@link rdb.impl.TableImpl#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link rdb.impl.TableImpl#getUniqueConstraints <em>Unique Constraints</em>}</li>
 *   <li>{@link rdb.impl.TableImpl#getForeignKeys <em>Foreign Keys</em>}</li>
 *   <li>{@link rdb.impl.TableImpl#getIndices <em>Indices</em>}</li>
 *   <li>{@link rdb.impl.TableImpl#getChecks <em>Checks</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TableImpl extends NamedColumnSetImpl implements Table {
	/**
	 * The cached value of the '{@link #getColumns() <em>Columns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getColumns()
	 * @generated
	 * @ordered
	 */
    protected EList columns = null;

	/**
	 * The cached value of the '{@link #getPrimaryKey() <em>Primary Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getPrimaryKey()
	 * @generated
	 * @ordered
	 */
    protected PrimaryKey primaryKey = null;

	/**
	 * The cached value of the '{@link #getUniqueConstraints() <em>Unique Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getUniqueConstraints()
	 * @generated
	 * @ordered
	 */
    protected EList uniqueConstraints = null;

	/**
	 * The cached value of the '{@link #getForeignKeys() <em>Foreign Keys</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getForeignKeys()
	 * @generated
	 * @ordered
	 */
    protected EList foreignKeys = null;

	/**
	 * The cached value of the '{@link #getIndices() <em>Indices</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getIndices()
	 * @generated
	 * @ordered
	 */
    protected EList indices = null;

	/**
	 * The cached value of the '{@link #getChecks() <em>Checks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getChecks()
	 * @generated
	 * @ordered
	 */
    protected EList checks = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected TableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected EClass eStaticClass() {
		return RdbPackage.eINSTANCE.getTable();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList getColumns() {
		if (columns == null) {
			columns = new EObjectContainmentEList(TableColumn.class, this, RdbPackage.TABLE__COLUMNS);
		}
		return columns;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public PrimaryKey getPrimaryKey() {
		return primaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetPrimaryKey(PrimaryKey newPrimaryKey, NotificationChain msgs) {
		PrimaryKey oldPrimaryKey = primaryKey;
		primaryKey = newPrimaryKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RdbPackage.TABLE__PRIMARY_KEY, oldPrimaryKey, newPrimaryKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setPrimaryKey(PrimaryKey newPrimaryKey) {
		if (newPrimaryKey != primaryKey) {
			NotificationChain msgs = null;
			if (primaryKey != null)
				msgs = ((InternalEObject)primaryKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RdbPackage.TABLE__PRIMARY_KEY, null, msgs);
			if (newPrimaryKey != null)
				msgs = ((InternalEObject)newPrimaryKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RdbPackage.TABLE__PRIMARY_KEY, null, msgs);
			msgs = basicSetPrimaryKey(newPrimaryKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RdbPackage.TABLE__PRIMARY_KEY, newPrimaryKey, newPrimaryKey));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList getUniqueConstraints() {
		if (uniqueConstraints == null) {
			uniqueConstraints = new EObjectContainmentEList(UniqueConstraint.class, this, RdbPackage.TABLE__UNIQUE_CONSTRAINTS);
		}
		return uniqueConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new EObjectContainmentEList(ForeignKey.class, this, RdbPackage.TABLE__FOREIGN_KEYS);
		}
		return foreignKeys;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList getIndices() {
		if (indices == null) {
			indices = new EObjectContainmentEList(Index.class, this, RdbPackage.TABLE__INDICES);
		}
		return indices;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList getChecks() {
		if (checks == null) {
			checks = new EObjectContainmentEList(CheckConstraint.class, this, RdbPackage.TABLE__CHECKS);
		}
		return checks;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case RdbPackage.TABLE__COLUMNS:
					return ((InternalEList)getColumns()).basicRemove(otherEnd, msgs);
				case RdbPackage.TABLE__PRIMARY_KEY:
					return basicSetPrimaryKey(null, msgs);
				case RdbPackage.TABLE__UNIQUE_CONSTRAINTS:
					return ((InternalEList)getUniqueConstraints()).basicRemove(otherEnd, msgs);
				case RdbPackage.TABLE__FOREIGN_KEYS:
					return ((InternalEList)getForeignKeys()).basicRemove(otherEnd, msgs);
				case RdbPackage.TABLE__INDICES:
					return ((InternalEList)getIndices()).basicRemove(otherEnd, msgs);
				case RdbPackage.TABLE__CHECKS:
					return ((InternalEList)getChecks()).basicRemove(otherEnd, msgs);
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
			case RdbPackage.TABLE__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case RdbPackage.TABLE__NAME:
				return getName();
			case RdbPackage.TABLE__OWNER:
				return getOwner();
			case RdbPackage.TABLE__COLUMNS:
				return getColumns();
			case RdbPackage.TABLE__PRIMARY_KEY:
				return getPrimaryKey();
			case RdbPackage.TABLE__UNIQUE_CONSTRAINTS:
				return getUniqueConstraints();
			case RdbPackage.TABLE__FOREIGN_KEYS:
				return getForeignKeys();
			case RdbPackage.TABLE__INDICES:
				return getIndices();
			case RdbPackage.TABLE__CHECKS:
				return getChecks();
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
			case RdbPackage.TABLE__PARENT:
				setParent((Element)newValue);
				return;
			case RdbPackage.TABLE__NAME:
				setName((String)newValue);
				return;
			case RdbPackage.TABLE__OWNER:
				setOwner((String)newValue);
				return;
			case RdbPackage.TABLE__COLUMNS:
				getColumns().clear();
				getColumns().addAll((Collection)newValue);
				return;
			case RdbPackage.TABLE__PRIMARY_KEY:
				setPrimaryKey((PrimaryKey)newValue);
				return;
			case RdbPackage.TABLE__UNIQUE_CONSTRAINTS:
				getUniqueConstraints().clear();
				getUniqueConstraints().addAll((Collection)newValue);
				return;
			case RdbPackage.TABLE__FOREIGN_KEYS:
				getForeignKeys().clear();
				getForeignKeys().addAll((Collection)newValue);
				return;
			case RdbPackage.TABLE__INDICES:
				getIndices().clear();
				getIndices().addAll((Collection)newValue);
				return;
			case RdbPackage.TABLE__CHECKS:
				getChecks().clear();
				getChecks().addAll((Collection)newValue);
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
			case RdbPackage.TABLE__PARENT:
				setParent((Element)null);
				return;
			case RdbPackage.TABLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RdbPackage.TABLE__OWNER:
				setOwner(OWNER_EDEFAULT);
				return;
			case RdbPackage.TABLE__COLUMNS:
				getColumns().clear();
				return;
			case RdbPackage.TABLE__PRIMARY_KEY:
				setPrimaryKey((PrimaryKey)null);
				return;
			case RdbPackage.TABLE__UNIQUE_CONSTRAINTS:
				getUniqueConstraints().clear();
				return;
			case RdbPackage.TABLE__FOREIGN_KEYS:
				getForeignKeys().clear();
				return;
			case RdbPackage.TABLE__INDICES:
				getIndices().clear();
				return;
			case RdbPackage.TABLE__CHECKS:
				getChecks().clear();
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
			case RdbPackage.TABLE__PARENT:
				return parent != null;
			case RdbPackage.TABLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RdbPackage.TABLE__OWNER:
				return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
			case RdbPackage.TABLE__COLUMNS:
				return columns != null && !columns.isEmpty();
			case RdbPackage.TABLE__PRIMARY_KEY:
				return primaryKey != null;
			case RdbPackage.TABLE__UNIQUE_CONSTRAINTS:
				return uniqueConstraints != null && !uniqueConstraints.isEmpty();
			case RdbPackage.TABLE__FOREIGN_KEYS:
				return foreignKeys != null && !foreignKeys.isEmpty();
			case RdbPackage.TABLE__INDICES:
				return indices != null && !indices.isEmpty();
			case RdbPackage.TABLE__CHECKS:
				return checks != null && !checks.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

} //TableImpl
