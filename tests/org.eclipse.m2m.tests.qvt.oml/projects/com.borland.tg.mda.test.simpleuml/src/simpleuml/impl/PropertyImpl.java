/**
 * <copyright>
 * </copyright>
 *
 * $Id: PropertyImpl.java,v 1.1 2007/07/29 21:25:30 radvorak Exp $
 */
package simpleuml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import simpleuml.DataType;
import simpleuml.Property;
import simpleuml.SimpleumlPackage;
import simpleuml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link simpleuml.impl.PropertyImpl#getType <em>Type</em>}</li>
 *   <li>{@link simpleuml.impl.PropertyImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyImpl extends ModelElementImpl implements Property {
    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
	protected Type type = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PropertyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SimpleumlPackage.eINSTANCE.getProperty();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Type getType() {
        if (type != null && type.eIsProxy()) {
            Type oldType = type;
            type = (Type)eResolveProxy((InternalEObject)type);
            if (type != oldType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimpleumlPackage.PROPERTY__TYPE, oldType, type));
            }
        }
        return type;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Type basicGetType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setType(Type newType) {
        Type oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimpleumlPackage.PROPERTY__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DataType getOwner() {
        if (eContainerFeatureID != SimpleumlPackage.PROPERTY__OWNER) return null;
        return (DataType)eContainer;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOwner(DataType newOwner) {
        if (newOwner != eContainer || (eContainerFeatureID != SimpleumlPackage.PROPERTY__OWNER && newOwner != null)) {
            if (EcoreUtil.isAncestor(this, newOwner))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eContainer != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOwner != null)
                msgs = ((InternalEObject)newOwner).eInverseAdd(this, SimpleumlPackage.DATA_TYPE__ATTRIBUTES, DataType.class, msgs);
            msgs = eBasicSetContainer((InternalEObject)newOwner, SimpleumlPackage.PROPERTY__OWNER, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimpleumlPackage.PROPERTY__OWNER, newOwner, newOwner));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
        if (featureID >= 0) {
            switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
                case SimpleumlPackage.PROPERTY__OWNER:
                    if (eContainer != null)
                        msgs = eBasicRemoveFromContainer(msgs);
                    return eBasicSetContainer(otherEnd, SimpleumlPackage.PROPERTY__OWNER, msgs);
                default:
                    return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
            }
        }
        if (eContainer != null)
            msgs = eBasicRemoveFromContainer(msgs);
        return eBasicSetContainer(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
        if (featureID >= 0) {
            switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
                case SimpleumlPackage.PROPERTY__TAGGED_VALUE:
                    return ((InternalEList)getTaggedValue()).basicRemove(otherEnd, msgs);
                case SimpleumlPackage.PROPERTY__OWNER:
                    return eBasicSetContainer(null, SimpleumlPackage.PROPERTY__OWNER, msgs);
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
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
        if (eContainerFeatureID >= 0) {
            switch (eContainerFeatureID) {
                case SimpleumlPackage.PROPERTY__OWNER:
                    return eContainer.eInverseRemove(this, SimpleumlPackage.DATA_TYPE__ATTRIBUTES, DataType.class, msgs);
                default:
                    return eDynamicBasicRemoveFromContainer(msgs);
            }
        }
        return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
        switch (eDerivedStructuralFeatureID(eFeature)) {
            case SimpleumlPackage.PROPERTY__NAME:
                return getName();
            case SimpleumlPackage.PROPERTY__STEREOTYPE:
                return getStereotype();
            case SimpleumlPackage.PROPERTY__TAGGED_VALUE:
                return getTaggedValue();
            case SimpleumlPackage.PROPERTY__TYPE:
                if (resolve) return getType();
                return basicGetType();
            case SimpleumlPackage.PROPERTY__OWNER:
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
            case SimpleumlPackage.PROPERTY__NAME:
                setName((String)newValue);
                return;
            case SimpleumlPackage.PROPERTY__STEREOTYPE:
                getStereotype().clear();
                getStereotype().addAll((Collection)newValue);
                return;
            case SimpleumlPackage.PROPERTY__TAGGED_VALUE:
                getTaggedValue().clear();
                getTaggedValue().addAll((Collection)newValue);
                return;
            case SimpleumlPackage.PROPERTY__TYPE:
                setType((Type)newValue);
                return;
            case SimpleumlPackage.PROPERTY__OWNER:
                setOwner((DataType)newValue);
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
            case SimpleumlPackage.PROPERTY__NAME:
                setName(NAME_EDEFAULT);
                return;
            case SimpleumlPackage.PROPERTY__STEREOTYPE:
                getStereotype().clear();
                return;
            case SimpleumlPackage.PROPERTY__TAGGED_VALUE:
                getTaggedValue().clear();
                return;
            case SimpleumlPackage.PROPERTY__TYPE:
                setType((Type)null);
                return;
            case SimpleumlPackage.PROPERTY__OWNER:
                setOwner((DataType)null);
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
            case SimpleumlPackage.PROPERTY__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case SimpleumlPackage.PROPERTY__STEREOTYPE:
                return stereotype != null && !stereotype.isEmpty();
            case SimpleumlPackage.PROPERTY__TAGGED_VALUE:
                return taggedValue != null && !taggedValue.isEmpty();
            case SimpleumlPackage.PROPERTY__TYPE:
                return type != null;
            case SimpleumlPackage.PROPERTY__OWNER:
                return getOwner() != null;
        }
        return eDynamicIsSet(eFeature);
    }

} //PropertyImpl
