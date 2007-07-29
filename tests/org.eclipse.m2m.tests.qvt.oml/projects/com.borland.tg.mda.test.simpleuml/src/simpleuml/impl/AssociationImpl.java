/**
 * <copyright>
 * </copyright>
 *
 * $Id: AssociationImpl.java,v 1.1 2007/07/29 21:25:30 radvorak Exp $
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

import simpleuml.Association;
import simpleuml.Packageable;
import simpleuml.SimpleumlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link simpleuml.impl.AssociationImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link simpleuml.impl.AssociationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link simpleuml.impl.AssociationImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationImpl extends ModelElementImpl implements Association {
    /**
     * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSource()
     * @generated
     * @ordered
     */
	protected simpleuml.Class source = null;

    /**
     * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTarget()
     * @generated
     * @ordered
     */
	protected simpleuml.Class target = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected AssociationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SimpleumlPackage.eINSTANCE.getAssociation();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public simpleuml.Package getOwner() {
        if (eContainerFeatureID != SimpleumlPackage.ASSOCIATION__OWNER) return null;
        return (simpleuml.Package)eContainer;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOwner(simpleuml.Package newOwner) {
        if (newOwner != eContainer || (eContainerFeatureID != SimpleumlPackage.ASSOCIATION__OWNER && newOwner != null)) {
            if (EcoreUtil.isAncestor(this, newOwner))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eContainer != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOwner != null)
                msgs = ((InternalEObject)newOwner).eInverseAdd(this, SimpleumlPackage.PACKAGE__OWNED_ELEMENTS, simpleuml.Package.class, msgs);
            msgs = eBasicSetContainer((InternalEObject)newOwner, SimpleumlPackage.ASSOCIATION__OWNER, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimpleumlPackage.ASSOCIATION__OWNER, newOwner, newOwner));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public simpleuml.Class getSource() {
        if (source != null && source.eIsProxy()) {
            simpleuml.Class oldSource = source;
            source = (simpleuml.Class)eResolveProxy((InternalEObject)source);
            if (source != oldSource) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimpleumlPackage.ASSOCIATION__SOURCE, oldSource, source));
            }
        }
        return source;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public simpleuml.Class basicGetSource() {
        return source;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSource(simpleuml.Class newSource) {
        simpleuml.Class oldSource = source;
        source = newSource;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimpleumlPackage.ASSOCIATION__SOURCE, oldSource, source));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public simpleuml.Class getTarget() {
        if (target != null && target.eIsProxy()) {
            simpleuml.Class oldTarget = target;
            target = (simpleuml.Class)eResolveProxy((InternalEObject)target);
            if (target != oldTarget) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimpleumlPackage.ASSOCIATION__TARGET, oldTarget, target));
            }
        }
        return target;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public simpleuml.Class basicGetTarget() {
        return target;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTarget(simpleuml.Class newTarget) {
        simpleuml.Class oldTarget = target;
        target = newTarget;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimpleumlPackage.ASSOCIATION__TARGET, oldTarget, target));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
        if (featureID >= 0) {
            switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
                case SimpleumlPackage.ASSOCIATION__OWNER:
                    if (eContainer != null)
                        msgs = eBasicRemoveFromContainer(msgs);
                    return eBasicSetContainer(otherEnd, SimpleumlPackage.ASSOCIATION__OWNER, msgs);
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
                case SimpleumlPackage.ASSOCIATION__TAGGED_VALUE:
                    return ((InternalEList)getTaggedValue()).basicRemove(otherEnd, msgs);
                case SimpleumlPackage.ASSOCIATION__OWNER:
                    return eBasicSetContainer(null, SimpleumlPackage.ASSOCIATION__OWNER, msgs);
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
                case SimpleumlPackage.ASSOCIATION__OWNER:
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
            case SimpleumlPackage.ASSOCIATION__NAME:
                return getName();
            case SimpleumlPackage.ASSOCIATION__STEREOTYPE:
                return getStereotype();
            case SimpleumlPackage.ASSOCIATION__TAGGED_VALUE:
                return getTaggedValue();
            case SimpleumlPackage.ASSOCIATION__OWNER:
                return getOwner();
            case SimpleumlPackage.ASSOCIATION__SOURCE:
                if (resolve) return getSource();
                return basicGetSource();
            case SimpleumlPackage.ASSOCIATION__TARGET:
                if (resolve) return getTarget();
                return basicGetTarget();
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
            case SimpleumlPackage.ASSOCIATION__NAME:
                setName((String)newValue);
                return;
            case SimpleumlPackage.ASSOCIATION__STEREOTYPE:
                getStereotype().clear();
                getStereotype().addAll((Collection)newValue);
                return;
            case SimpleumlPackage.ASSOCIATION__TAGGED_VALUE:
                getTaggedValue().clear();
                getTaggedValue().addAll((Collection)newValue);
                return;
            case SimpleumlPackage.ASSOCIATION__OWNER:
                setOwner((simpleuml.Package)newValue);
                return;
            case SimpleumlPackage.ASSOCIATION__SOURCE:
                setSource((simpleuml.Class)newValue);
                return;
            case SimpleumlPackage.ASSOCIATION__TARGET:
                setTarget((simpleuml.Class)newValue);
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
            case SimpleumlPackage.ASSOCIATION__NAME:
                setName(NAME_EDEFAULT);
                return;
            case SimpleumlPackage.ASSOCIATION__STEREOTYPE:
                getStereotype().clear();
                return;
            case SimpleumlPackage.ASSOCIATION__TAGGED_VALUE:
                getTaggedValue().clear();
                return;
            case SimpleumlPackage.ASSOCIATION__OWNER:
                setOwner((simpleuml.Package)null);
                return;
            case SimpleumlPackage.ASSOCIATION__SOURCE:
                setSource((simpleuml.Class)null);
                return;
            case SimpleumlPackage.ASSOCIATION__TARGET:
                setTarget((simpleuml.Class)null);
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
            case SimpleumlPackage.ASSOCIATION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case SimpleumlPackage.ASSOCIATION__STEREOTYPE:
                return stereotype != null && !stereotype.isEmpty();
            case SimpleumlPackage.ASSOCIATION__TAGGED_VALUE:
                return taggedValue != null && !taggedValue.isEmpty();
            case SimpleumlPackage.ASSOCIATION__OWNER:
                return getOwner() != null;
            case SimpleumlPackage.ASSOCIATION__SOURCE:
                return source != null;
            case SimpleumlPackage.ASSOCIATION__TARGET:
                return target != null;
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
                case SimpleumlPackage.ASSOCIATION__OWNER: return SimpleumlPackage.PACKAGEABLE__OWNER;
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
                case SimpleumlPackage.PACKAGEABLE__OWNER: return SimpleumlPackage.ASSOCIATION__OWNER;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} //AssociationImpl
