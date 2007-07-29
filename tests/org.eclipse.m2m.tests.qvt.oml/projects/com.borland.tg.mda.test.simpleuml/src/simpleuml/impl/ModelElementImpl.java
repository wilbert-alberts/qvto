/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelElementImpl.java,v 1.1 2007/07/29 21:25:30 radvorak Exp $
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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import simpleuml.ModelElement;
import simpleuml.SimpleumlPackage;
import simpleuml.TaggedValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link simpleuml.impl.ModelElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link simpleuml.impl.ModelElementImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link simpleuml.impl.ModelElementImpl#getTaggedValue <em>Tagged Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ModelElementImpl extends EObjectImpl implements ModelElement {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
	protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
	protected String name = NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getStereotype() <em>Stereotype</em>}' attribute list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getStereotype()
     * @generated
     * @ordered
     */
	protected EList stereotype = null;

    /**
     * The cached value of the '{@link #getTaggedValue() <em>Tagged Value</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTaggedValue()
     * @generated
     * @ordered
     */
	protected EList taggedValue = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ModelElementImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SimpleumlPackage.eINSTANCE.getModelElement();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimpleumlPackage.MODEL_ELEMENT__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getStereotype() {
        if (stereotype == null) {
            stereotype = new EDataTypeUniqueEList(String.class, this, SimpleumlPackage.MODEL_ELEMENT__STEREOTYPE);
        }
        return stereotype;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getTaggedValue() {
        if (taggedValue == null) {
            taggedValue = new EObjectContainmentEList(TaggedValue.class, this, SimpleumlPackage.MODEL_ELEMENT__TAGGED_VALUE);
        }
        return taggedValue;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
        if (featureID >= 0) {
            switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
                case SimpleumlPackage.MODEL_ELEMENT__TAGGED_VALUE:
                    return ((InternalEList)getTaggedValue()).basicRemove(otherEnd, msgs);
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
            case SimpleumlPackage.MODEL_ELEMENT__NAME:
                return getName();
            case SimpleumlPackage.MODEL_ELEMENT__STEREOTYPE:
                return getStereotype();
            case SimpleumlPackage.MODEL_ELEMENT__TAGGED_VALUE:
                return getTaggedValue();
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
            case SimpleumlPackage.MODEL_ELEMENT__NAME:
                setName((String)newValue);
                return;
            case SimpleumlPackage.MODEL_ELEMENT__STEREOTYPE:
                getStereotype().clear();
                getStereotype().addAll((Collection)newValue);
                return;
            case SimpleumlPackage.MODEL_ELEMENT__TAGGED_VALUE:
                getTaggedValue().clear();
                getTaggedValue().addAll((Collection)newValue);
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
            case SimpleumlPackage.MODEL_ELEMENT__NAME:
                setName(NAME_EDEFAULT);
                return;
            case SimpleumlPackage.MODEL_ELEMENT__STEREOTYPE:
                getStereotype().clear();
                return;
            case SimpleumlPackage.MODEL_ELEMENT__TAGGED_VALUE:
                getTaggedValue().clear();
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
            case SimpleumlPackage.MODEL_ELEMENT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case SimpleumlPackage.MODEL_ELEMENT__STEREOTYPE:
                return stereotype != null && !stereotype.isEmpty();
            case SimpleumlPackage.MODEL_ELEMENT__TAGGED_VALUE:
                return taggedValue != null && !taggedValue.isEmpty();
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
        result.append(" (name: ");
        result.append(name);
        result.append(", stereotype: ");
        result.append(stereotype);
        result.append(')');
        return result.toString();
    }

} //ModelElementImpl
