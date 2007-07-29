/**
 * <copyright>
 * </copyright>
 *
 * $Id: PrimitiveTypeImpl.java,v 1.1 2007/07/29 21:25:30 radvorak Exp $
 */
package simpleuml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import simpleuml.PrimitiveType;
import simpleuml.SimpleumlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PrimitiveTypeImpl extends TypeImpl implements PrimitiveType {
    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PrimitiveTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SimpleumlPackage.eINSTANCE.getPrimitiveType();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
        if (featureID >= 0) {
            switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
                case SimpleumlPackage.PRIMITIVE_TYPE__OWNER:
                    if (eContainer != null)
                        msgs = eBasicRemoveFromContainer(msgs);
                    return eBasicSetContainer(otherEnd, SimpleumlPackage.PRIMITIVE_TYPE__OWNER, msgs);
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
                case SimpleumlPackage.PRIMITIVE_TYPE__TAGGED_VALUE:
                    return ((InternalEList)getTaggedValue()).basicRemove(otherEnd, msgs);
                case SimpleumlPackage.PRIMITIVE_TYPE__OWNER:
                    return eBasicSetContainer(null, SimpleumlPackage.PRIMITIVE_TYPE__OWNER, msgs);
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
                case SimpleumlPackage.PRIMITIVE_TYPE__OWNER:
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
            case SimpleumlPackage.PRIMITIVE_TYPE__NAME:
                return getName();
            case SimpleumlPackage.PRIMITIVE_TYPE__STEREOTYPE:
                return getStereotype();
            case SimpleumlPackage.PRIMITIVE_TYPE__TAGGED_VALUE:
                return getTaggedValue();
            case SimpleumlPackage.PRIMITIVE_TYPE__OWNER:
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
            case SimpleumlPackage.PRIMITIVE_TYPE__NAME:
                setName((String)newValue);
                return;
            case SimpleumlPackage.PRIMITIVE_TYPE__STEREOTYPE:
                getStereotype().clear();
                getStereotype().addAll((Collection)newValue);
                return;
            case SimpleumlPackage.PRIMITIVE_TYPE__TAGGED_VALUE:
                getTaggedValue().clear();
                getTaggedValue().addAll((Collection)newValue);
                return;
            case SimpleumlPackage.PRIMITIVE_TYPE__OWNER:
                setOwner((simpleuml.Package)newValue);
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
            case SimpleumlPackage.PRIMITIVE_TYPE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case SimpleumlPackage.PRIMITIVE_TYPE__STEREOTYPE:
                getStereotype().clear();
                return;
            case SimpleumlPackage.PRIMITIVE_TYPE__TAGGED_VALUE:
                getTaggedValue().clear();
                return;
            case SimpleumlPackage.PRIMITIVE_TYPE__OWNER:
                setOwner((simpleuml.Package)null);
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
            case SimpleumlPackage.PRIMITIVE_TYPE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case SimpleumlPackage.PRIMITIVE_TYPE__STEREOTYPE:
                return stereotype != null && !stereotype.isEmpty();
            case SimpleumlPackage.PRIMITIVE_TYPE__TAGGED_VALUE:
                return taggedValue != null && !taggedValue.isEmpty();
            case SimpleumlPackage.PRIMITIVE_TYPE__OWNER:
                return getOwner() != null;
        }
        return eDynamicIsSet(eFeature);
    }

} //PrimitiveTypeImpl
