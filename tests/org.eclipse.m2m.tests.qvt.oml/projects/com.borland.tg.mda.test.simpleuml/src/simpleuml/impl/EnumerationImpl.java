/**
 * <copyright>
 * </copyright>
 *
 * $Id: EnumerationImpl.java,v 1.1 2007/07/29 21:25:30 radvorak Exp $
 */
package simpleuml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import simpleuml.Enumeration;
import simpleuml.EnumerationLiteral;
import simpleuml.SimpleumlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link simpleuml.impl.EnumerationImpl#getOwnedLiteral <em>Owned Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumerationImpl extends TypeImpl implements Enumeration {
    /**
     * The cached value of the '{@link #getOwnedLiteral() <em>Owned Literal</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOwnedLiteral()
     * @generated
     * @ordered
     */
	protected EList ownedLiteral = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EnumerationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SimpleumlPackage.eINSTANCE.getEnumeration();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getOwnedLiteral() {
        if (ownedLiteral == null) {
            ownedLiteral = new EObjectContainmentEList(EnumerationLiteral.class, this, SimpleumlPackage.ENUMERATION__OWNED_LITERAL);
        }
        return ownedLiteral;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
        if (featureID >= 0) {
            switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
                case SimpleumlPackage.ENUMERATION__OWNER:
                    if (eContainer != null)
                        msgs = eBasicRemoveFromContainer(msgs);
                    return eBasicSetContainer(otherEnd, SimpleumlPackage.ENUMERATION__OWNER, msgs);
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
                case SimpleumlPackage.ENUMERATION__TAGGED_VALUE:
                    return ((InternalEList)getTaggedValue()).basicRemove(otherEnd, msgs);
                case SimpleumlPackage.ENUMERATION__OWNER:
                    return eBasicSetContainer(null, SimpleumlPackage.ENUMERATION__OWNER, msgs);
                case SimpleumlPackage.ENUMERATION__OWNED_LITERAL:
                    return ((InternalEList)getOwnedLiteral()).basicRemove(otherEnd, msgs);
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
                case SimpleumlPackage.ENUMERATION__OWNER:
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
            case SimpleumlPackage.ENUMERATION__NAME:
                return getName();
            case SimpleumlPackage.ENUMERATION__STEREOTYPE:
                return getStereotype();
            case SimpleumlPackage.ENUMERATION__TAGGED_VALUE:
                return getTaggedValue();
            case SimpleumlPackage.ENUMERATION__OWNER:
                return getOwner();
            case SimpleumlPackage.ENUMERATION__OWNED_LITERAL:
                return getOwnedLiteral();
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
            case SimpleumlPackage.ENUMERATION__NAME:
                setName((String)newValue);
                return;
            case SimpleumlPackage.ENUMERATION__STEREOTYPE:
                getStereotype().clear();
                getStereotype().addAll((Collection)newValue);
                return;
            case SimpleumlPackage.ENUMERATION__TAGGED_VALUE:
                getTaggedValue().clear();
                getTaggedValue().addAll((Collection)newValue);
                return;
            case SimpleumlPackage.ENUMERATION__OWNER:
                setOwner((simpleuml.Package)newValue);
                return;
            case SimpleumlPackage.ENUMERATION__OWNED_LITERAL:
                getOwnedLiteral().clear();
                getOwnedLiteral().addAll((Collection)newValue);
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
            case SimpleumlPackage.ENUMERATION__NAME:
                setName(NAME_EDEFAULT);
                return;
            case SimpleumlPackage.ENUMERATION__STEREOTYPE:
                getStereotype().clear();
                return;
            case SimpleumlPackage.ENUMERATION__TAGGED_VALUE:
                getTaggedValue().clear();
                return;
            case SimpleumlPackage.ENUMERATION__OWNER:
                setOwner((simpleuml.Package)null);
                return;
            case SimpleumlPackage.ENUMERATION__OWNED_LITERAL:
                getOwnedLiteral().clear();
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
            case SimpleumlPackage.ENUMERATION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case SimpleumlPackage.ENUMERATION__STEREOTYPE:
                return stereotype != null && !stereotype.isEmpty();
            case SimpleumlPackage.ENUMERATION__TAGGED_VALUE:
                return taggedValue != null && !taggedValue.isEmpty();
            case SimpleumlPackage.ENUMERATION__OWNER:
                return getOwner() != null;
            case SimpleumlPackage.ENUMERATION__OWNED_LITERAL:
                return ownedLiteral != null && !ownedLiteral.isEmpty();
        }
        return eDynamicIsSet(eFeature);
    }

} //EnumerationImpl
