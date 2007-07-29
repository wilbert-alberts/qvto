/**
 * <copyright>
 * </copyright>
 *
 * $Id: PackageImpl.java,v 1.1 2007/07/29 21:25:30 radvorak Exp $
 */
package simpleuml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import simpleuml.Packageable;
import simpleuml.SimpleumlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link simpleuml.impl.PackageImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link simpleuml.impl.PackageImpl#getOwnedElements <em>Owned Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageImpl extends ClassifierImpl implements simpleuml.Package {
    /**
     * The cached value of the '{@link #getOwnedElements() <em>Owned Elements</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOwnedElements()
     * @generated
     * @ordered
     */
	protected EList ownedElements = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PackageImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SimpleumlPackage.eINSTANCE.getPackage();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public simpleuml.Package getOwner() {
        if (eContainerFeatureID != SimpleumlPackage.PACKAGE__OWNER) return null;
        return (simpleuml.Package)eContainer;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOwner(simpleuml.Package newOwner) {
        if (newOwner != eContainer || (eContainerFeatureID != SimpleumlPackage.PACKAGE__OWNER && newOwner != null)) {
            if (EcoreUtil.isAncestor(this, newOwner))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eContainer != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOwner != null)
                msgs = ((InternalEObject)newOwner).eInverseAdd(this, SimpleumlPackage.PACKAGE__OWNED_ELEMENTS, simpleuml.Package.class, msgs);
            msgs = eBasicSetContainer((InternalEObject)newOwner, SimpleumlPackage.PACKAGE__OWNER, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimpleumlPackage.PACKAGE__OWNER, newOwner, newOwner));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getOwnedElements() {
        if (ownedElements == null) {
            ownedElements = new EObjectContainmentWithInverseEList(Packageable.class, this, SimpleumlPackage.PACKAGE__OWNED_ELEMENTS, SimpleumlPackage.PACKAGEABLE__OWNER);
        }
        return ownedElements;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
        if (featureID >= 0) {
            switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
                case SimpleumlPackage.PACKAGE__OWNER:
                    if (eContainer != null)
                        msgs = eBasicRemoveFromContainer(msgs);
                    return eBasicSetContainer(otherEnd, SimpleumlPackage.PACKAGE__OWNER, msgs);
                case SimpleumlPackage.PACKAGE__OWNED_ELEMENTS:
                    return ((InternalEList)getOwnedElements()).basicAdd(otherEnd, msgs);
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
                case SimpleumlPackage.PACKAGE__TAGGED_VALUE:
                    return ((InternalEList)getTaggedValue()).basicRemove(otherEnd, msgs);
                case SimpleumlPackage.PACKAGE__OWNER:
                    return eBasicSetContainer(null, SimpleumlPackage.PACKAGE__OWNER, msgs);
                case SimpleumlPackage.PACKAGE__OWNED_ELEMENTS:
                    return ((InternalEList)getOwnedElements()).basicRemove(otherEnd, msgs);
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
                case SimpleumlPackage.PACKAGE__OWNER:
                    return eContainer.eInverseRemove(this, SimpleumlPackage.PACKAGE__OWNED_ELEMENTS, simpleuml.Package.class, msgs);
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
            case SimpleumlPackage.PACKAGE__NAME:
                return getName();
            case SimpleumlPackage.PACKAGE__STEREOTYPE:
                return getStereotype();
            case SimpleumlPackage.PACKAGE__TAGGED_VALUE:
                return getTaggedValue();
            case SimpleumlPackage.PACKAGE__OWNER:
                return getOwner();
            case SimpleumlPackage.PACKAGE__OWNED_ELEMENTS:
                return getOwnedElements();
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
            case SimpleumlPackage.PACKAGE__NAME:
                setName((String)newValue);
                return;
            case SimpleumlPackage.PACKAGE__STEREOTYPE:
                getStereotype().clear();
                getStereotype().addAll((Collection)newValue);
                return;
            case SimpleumlPackage.PACKAGE__TAGGED_VALUE:
                getTaggedValue().clear();
                getTaggedValue().addAll((Collection)newValue);
                return;
            case SimpleumlPackage.PACKAGE__OWNER:
                setOwner((simpleuml.Package)newValue);
                return;
            case SimpleumlPackage.PACKAGE__OWNED_ELEMENTS:
                getOwnedElements().clear();
                getOwnedElements().addAll((Collection)newValue);
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
            case SimpleumlPackage.PACKAGE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case SimpleumlPackage.PACKAGE__STEREOTYPE:
                getStereotype().clear();
                return;
            case SimpleumlPackage.PACKAGE__TAGGED_VALUE:
                getTaggedValue().clear();
                return;
            case SimpleumlPackage.PACKAGE__OWNER:
                setOwner((simpleuml.Package)null);
                return;
            case SimpleumlPackage.PACKAGE__OWNED_ELEMENTS:
                getOwnedElements().clear();
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
            case SimpleumlPackage.PACKAGE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case SimpleumlPackage.PACKAGE__STEREOTYPE:
                return stereotype != null && !stereotype.isEmpty();
            case SimpleumlPackage.PACKAGE__TAGGED_VALUE:
                return taggedValue != null && !taggedValue.isEmpty();
            case SimpleumlPackage.PACKAGE__OWNER:
                return getOwner() != null;
            case SimpleumlPackage.PACKAGE__OWNED_ELEMENTS:
                return ownedElements != null && !ownedElements.isEmpty();
        }
        return eDynamicIsSet(eFeature);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
        if (baseClass == Packageable.class) {
            switch (derivedFeatureID) {
                case SimpleumlPackage.PACKAGE__OWNER: return SimpleumlPackage.PACKAGEABLE__OWNER;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
        if (baseClass == Packageable.class) {
            switch (baseFeatureID) {
                case SimpleumlPackage.PACKAGEABLE__OWNER: return SimpleumlPackage.PACKAGE__OWNER;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} //PackageImpl
