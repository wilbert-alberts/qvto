/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelImpl.java,v 1.1 2007/07/29 21:25:34 radvorak Exp $
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
import rdb.Model;
import rdb.RdbPackage;
import rdb.Schema;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.impl.ModelImpl#getSchemas <em>Schemas</em>}</li>
 *   <li>{@link rdb.impl.ModelImpl#getServer_id <em>Server id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends NamedElementImpl implements Model {
	/**
	 * The cached value of the '{@link #getSchemas() <em>Schemas</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSchemas()
	 * @generated
	 * @ordered
	 */
    protected EList schemas = null;

	/**
	 * The default value of the '{@link #getServer_id() <em>Server id</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getServer_id()
	 * @generated
	 * @ordered
	 */
    protected static final String SERVER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServer_id() <em>Server id</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getServer_id()
	 * @generated
	 * @ordered
	 */
    protected String server_id = SERVER_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected EClass eStaticClass() {
		return RdbPackage.eINSTANCE.getModel();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList getSchemas() {
		if (schemas == null) {
			schemas = new EObjectContainmentEList(Schema.class, this, RdbPackage.MODEL__SCHEMAS);
		}
		return schemas;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getServer_id() {
		return server_id;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setServer_id(String newServer_id) {
		String oldServer_id = server_id;
		server_id = newServer_id;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RdbPackage.MODEL__SERVER_ID, oldServer_id, server_id));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case RdbPackage.MODEL__SCHEMAS:
					return ((InternalEList)getSchemas()).basicRemove(otherEnd, msgs);
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
			case RdbPackage.MODEL__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case RdbPackage.MODEL__NAME:
				return getName();
			case RdbPackage.MODEL__SCHEMAS:
				return getSchemas();
			case RdbPackage.MODEL__SERVER_ID:
				return getServer_id();
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
			case RdbPackage.MODEL__PARENT:
				setParent((Element)newValue);
				return;
			case RdbPackage.MODEL__NAME:
				setName((String)newValue);
				return;
			case RdbPackage.MODEL__SCHEMAS:
				getSchemas().clear();
				getSchemas().addAll((Collection)newValue);
				return;
			case RdbPackage.MODEL__SERVER_ID:
				setServer_id((String)newValue);
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
			case RdbPackage.MODEL__PARENT:
				setParent((Element)null);
				return;
			case RdbPackage.MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RdbPackage.MODEL__SCHEMAS:
				getSchemas().clear();
				return;
			case RdbPackage.MODEL__SERVER_ID:
				setServer_id(SERVER_ID_EDEFAULT);
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
			case RdbPackage.MODEL__PARENT:
				return parent != null;
			case RdbPackage.MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RdbPackage.MODEL__SCHEMAS:
				return schemas != null && !schemas.isEmpty();
			case RdbPackage.MODEL__SERVER_ID:
				return SERVER_ID_EDEFAULT == null ? server_id != null : !SERVER_ID_EDEFAULT.equals(server_id);
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
		result.append(" (server_id: ");
		result.append(server_id);
		result.append(')');
		return result.toString();
	}

} //ModelImpl
