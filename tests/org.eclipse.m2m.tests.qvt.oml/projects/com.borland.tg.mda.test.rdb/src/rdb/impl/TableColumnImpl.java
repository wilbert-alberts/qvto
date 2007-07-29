/**
 * <copyright>
 * </copyright>
 *
 * $Id: TableColumnImpl.java,v 1.1 2007/07/29 21:25:34 radvorak Exp $
 */
package rdb.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import rdb.Element;
import rdb.RdbPackage;
import rdb.TableColumn;

import rdb.datatypes.Domain;
import rdb.datatypes.PrimitiveDataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table Column</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.impl.TableColumnImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link rdb.impl.TableColumnImpl#getType <em>Type</em>}</li>
 *   <li>{@link rdb.impl.TableColumnImpl#getIsPrimaryKey <em>Is Primary Key</em>}</li>
 *   <li>{@link rdb.impl.TableColumnImpl#getIsForeignKey <em>Is Foreign Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TableColumnImpl extends ColumnImpl implements TableColumn {
	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
    protected Domain domain = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
    protected PrimitiveDataType type = null;

	/**
	 * The default value of the '{@link #getIsPrimaryKey() <em>Is Primary Key</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getIsPrimaryKey()
	 * @generated
	 * @ordered
	 */
    protected static final Boolean IS_PRIMARY_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsPrimaryKey() <em>Is Primary Key</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getIsPrimaryKey()
	 * @generated
	 * @ordered
	 */
    protected Boolean isPrimaryKey = IS_PRIMARY_KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getIsForeignKey() <em>Is Foreign Key</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getIsForeignKey()
	 * @generated
	 * @ordered
	 */
    protected static final Boolean IS_FOREIGN_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsForeignKey() <em>Is Foreign Key</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getIsForeignKey()
	 * @generated
	 * @ordered
	 */
    protected Boolean isForeignKey = IS_FOREIGN_KEY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected TableColumnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected EClass eStaticClass() {
		return RdbPackage.eINSTANCE.getTableColumn();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Domain getDomain() {
		if (domain != null && domain.eIsProxy()) {
			Domain oldDomain = domain;
			domain = (Domain)eResolveProxy((InternalEObject)domain);
			if (domain != oldDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RdbPackage.TABLE_COLUMN__DOMAIN, oldDomain, domain));
			}
		}
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Domain basicGetDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setDomain(Domain newDomain) {
		Domain oldDomain = domain;
		domain = newDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RdbPackage.TABLE_COLUMN__DOMAIN, oldDomain, domain));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public PrimitiveDataType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetType(PrimitiveDataType newType, NotificationChain msgs) {
		PrimitiveDataType oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RdbPackage.TABLE_COLUMN__TYPE, oldType, newType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setType(PrimitiveDataType newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RdbPackage.TABLE_COLUMN__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RdbPackage.TABLE_COLUMN__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RdbPackage.TABLE_COLUMN__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Boolean getIsPrimaryKey() {
		return isPrimaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setIsPrimaryKey(Boolean newIsPrimaryKey) {
		Boolean oldIsPrimaryKey = isPrimaryKey;
		isPrimaryKey = newIsPrimaryKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RdbPackage.TABLE_COLUMN__IS_PRIMARY_KEY, oldIsPrimaryKey, isPrimaryKey));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Boolean getIsForeignKey() {
		return isForeignKey;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setIsForeignKey(Boolean newIsForeignKey) {
		Boolean oldIsForeignKey = isForeignKey;
		isForeignKey = newIsForeignKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RdbPackage.TABLE_COLUMN__IS_FOREIGN_KEY, oldIsForeignKey, isForeignKey));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case RdbPackage.TABLE_COLUMN__TYPE:
					return basicSetType(null, msgs);
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
			case RdbPackage.TABLE_COLUMN__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case RdbPackage.TABLE_COLUMN__NAME:
				return getName();
			case RdbPackage.TABLE_COLUMN__DOMAIN:
				if (resolve) return getDomain();
				return basicGetDomain();
			case RdbPackage.TABLE_COLUMN__TYPE:
				return getType();
			case RdbPackage.TABLE_COLUMN__IS_PRIMARY_KEY:
				return getIsPrimaryKey();
			case RdbPackage.TABLE_COLUMN__IS_FOREIGN_KEY:
				return getIsForeignKey();
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
			case RdbPackage.TABLE_COLUMN__PARENT:
				setParent((Element)newValue);
				return;
			case RdbPackage.TABLE_COLUMN__NAME:
				setName((String)newValue);
				return;
			case RdbPackage.TABLE_COLUMN__DOMAIN:
				setDomain((Domain)newValue);
				return;
			case RdbPackage.TABLE_COLUMN__TYPE:
				setType((PrimitiveDataType)newValue);
				return;
			case RdbPackage.TABLE_COLUMN__IS_PRIMARY_KEY:
				setIsPrimaryKey((Boolean)newValue);
				return;
			case RdbPackage.TABLE_COLUMN__IS_FOREIGN_KEY:
				setIsForeignKey((Boolean)newValue);
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
			case RdbPackage.TABLE_COLUMN__PARENT:
				setParent((Element)null);
				return;
			case RdbPackage.TABLE_COLUMN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RdbPackage.TABLE_COLUMN__DOMAIN:
				setDomain((Domain)null);
				return;
			case RdbPackage.TABLE_COLUMN__TYPE:
				setType((PrimitiveDataType)null);
				return;
			case RdbPackage.TABLE_COLUMN__IS_PRIMARY_KEY:
				setIsPrimaryKey(IS_PRIMARY_KEY_EDEFAULT);
				return;
			case RdbPackage.TABLE_COLUMN__IS_FOREIGN_KEY:
				setIsForeignKey(IS_FOREIGN_KEY_EDEFAULT);
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
			case RdbPackage.TABLE_COLUMN__PARENT:
				return parent != null;
			case RdbPackage.TABLE_COLUMN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RdbPackage.TABLE_COLUMN__DOMAIN:
				return domain != null;
			case RdbPackage.TABLE_COLUMN__TYPE:
				return type != null;
			case RdbPackage.TABLE_COLUMN__IS_PRIMARY_KEY:
				return IS_PRIMARY_KEY_EDEFAULT == null ? isPrimaryKey != null : !IS_PRIMARY_KEY_EDEFAULT.equals(isPrimaryKey);
			case RdbPackage.TABLE_COLUMN__IS_FOREIGN_KEY:
				return IS_FOREIGN_KEY_EDEFAULT == null ? isForeignKey != null : !IS_FOREIGN_KEY_EDEFAULT.equals(isForeignKey);
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
		result.append(" (isPrimaryKey: ");
		result.append(isPrimaryKey);
		result.append(", isForeignKey: ");
		result.append(isForeignKey);
		result.append(')');
		return result.toString();
	}

} //TableColumnImpl
