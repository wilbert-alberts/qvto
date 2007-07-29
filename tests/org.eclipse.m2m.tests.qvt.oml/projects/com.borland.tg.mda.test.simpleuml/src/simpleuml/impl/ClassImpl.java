/**
 * <copyright>
 * </copyright>
 *
 * $Id: ClassImpl.java,v 1.1 2007/07/29 21:25:30 radvorak Exp $
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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import simpleuml.Generalization;
import simpleuml.SimpleumlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link simpleuml.impl.ClassImpl#getGeneralizations <em>Generalizations</em>}</li>
 *   <li>{@link simpleuml.impl.ClassImpl#isAbstract <em>Abstract</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends DataTypeImpl implements simpleuml.Class {
    /**
     * The cached value of the '{@link #getGeneralizations() <em>Generalizations</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getGeneralizations()
     * @generated
     * @ordered
     */
	protected EList generalizations = null;

    /**
     * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isAbstract()
     * @generated
     * @ordered
     */
	protected static final boolean ABSTRACT_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isAbstract()
     * @generated
     * @ordered
     */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ClassImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SimpleumlPackage.eINSTANCE.getClass_();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getGeneralizations() {
        if (generalizations == null) {
            generalizations = new EObjectContainmentEList(Generalization.class, this, SimpleumlPackage.CLASS__GENERALIZATIONS);
        }
        return generalizations;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isAbstract() {
        return abstract_;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAbstract(boolean newAbstract) {
        boolean oldAbstract = abstract_;
        abstract_ = newAbstract;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimpleumlPackage.CLASS__ABSTRACT, oldAbstract, abstract_));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
        if (featureID >= 0) {
            switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
                case SimpleumlPackage.CLASS__OWNER:
                    if (eContainer != null)
                        msgs = eBasicRemoveFromContainer(msgs);
                    return eBasicSetContainer(otherEnd, SimpleumlPackage.CLASS__OWNER, msgs);
                case SimpleumlPackage.CLASS__ATTRIBUTES:
                    return ((InternalEList)getAttributes()).basicAdd(otherEnd, msgs);
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
                case SimpleumlPackage.CLASS__TAGGED_VALUE:
                    return ((InternalEList)getTaggedValue()).basicRemove(otherEnd, msgs);
                case SimpleumlPackage.CLASS__OWNER:
                    return eBasicSetContainer(null, SimpleumlPackage.CLASS__OWNER, msgs);
                case SimpleumlPackage.CLASS__ATTRIBUTES:
                    return ((InternalEList)getAttributes()).basicRemove(otherEnd, msgs);
                case SimpleumlPackage.CLASS__GENERALIZATIONS:
                    return ((InternalEList)getGeneralizations()).basicRemove(otherEnd, msgs);
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
                case SimpleumlPackage.CLASS__OWNER:
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
            case SimpleumlPackage.CLASS__NAME:
                return getName();
            case SimpleumlPackage.CLASS__STEREOTYPE:
                return getStereotype();
            case SimpleumlPackage.CLASS__TAGGED_VALUE:
                return getTaggedValue();
            case SimpleumlPackage.CLASS__OWNER:
                return getOwner();
            case SimpleumlPackage.CLASS__ATTRIBUTES:
                return getAttributes();
            case SimpleumlPackage.CLASS__GENERALIZATIONS:
                return getGeneralizations();
            case SimpleumlPackage.CLASS__ABSTRACT:
                return isAbstract() ? Boolean.TRUE : Boolean.FALSE;
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
            case SimpleumlPackage.CLASS__NAME:
                setName((String)newValue);
                return;
            case SimpleumlPackage.CLASS__STEREOTYPE:
                getStereotype().clear();
                getStereotype().addAll((Collection)newValue);
                return;
            case SimpleumlPackage.CLASS__TAGGED_VALUE:
                getTaggedValue().clear();
                getTaggedValue().addAll((Collection)newValue);
                return;
            case SimpleumlPackage.CLASS__OWNER:
                setOwner((simpleuml.Package)newValue);
                return;
            case SimpleumlPackage.CLASS__ATTRIBUTES:
                getAttributes().clear();
                getAttributes().addAll((Collection)newValue);
                return;
            case SimpleumlPackage.CLASS__GENERALIZATIONS:
                getGeneralizations().clear();
                getGeneralizations().addAll((Collection)newValue);
                return;
            case SimpleumlPackage.CLASS__ABSTRACT:
                setAbstract(((Boolean)newValue).booleanValue());
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
            case SimpleumlPackage.CLASS__NAME:
                setName(NAME_EDEFAULT);
                return;
            case SimpleumlPackage.CLASS__STEREOTYPE:
                getStereotype().clear();
                return;
            case SimpleumlPackage.CLASS__TAGGED_VALUE:
                getTaggedValue().clear();
                return;
            case SimpleumlPackage.CLASS__OWNER:
                setOwner((simpleuml.Package)null);
                return;
            case SimpleumlPackage.CLASS__ATTRIBUTES:
                getAttributes().clear();
                return;
            case SimpleumlPackage.CLASS__GENERALIZATIONS:
                getGeneralizations().clear();
                return;
            case SimpleumlPackage.CLASS__ABSTRACT:
                setAbstract(ABSTRACT_EDEFAULT);
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
            case SimpleumlPackage.CLASS__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case SimpleumlPackage.CLASS__STEREOTYPE:
                return stereotype != null && !stereotype.isEmpty();
            case SimpleumlPackage.CLASS__TAGGED_VALUE:
                return taggedValue != null && !taggedValue.isEmpty();
            case SimpleumlPackage.CLASS__OWNER:
                return getOwner() != null;
            case SimpleumlPackage.CLASS__ATTRIBUTES:
                return attributes != null && !attributes.isEmpty();
            case SimpleumlPackage.CLASS__GENERALIZATIONS:
                return generalizations != null && !generalizations.isEmpty();
            case SimpleumlPackage.CLASS__ABSTRACT:
                return abstract_ != ABSTRACT_EDEFAULT;
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
        result.append(" (abstract: ");
        result.append(abstract_);
        result.append(')');
        return result.toString();
    }

} //ClassImpl
