/**
 * <copyright>
 * </copyright>
 *
 * $Id: GeneralizationImpl.java,v 1.1 2007/07/29 21:25:30 radvorak Exp $
 */
package simpleuml.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import simpleuml.Generalization;
import simpleuml.SimpleumlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generalization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link simpleuml.impl.GeneralizationImpl#getGeneral <em>General</em>}</li>
 *   <li>{@link simpleuml.impl.GeneralizationImpl#isIsSubstitutable <em>Is Substitutable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeneralizationImpl extends EObjectImpl implements Generalization {
    /**
     * The cached value of the '{@link #getGeneral() <em>General</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getGeneral()
     * @generated
     * @ordered
     */
	protected simpleuml.Class general = null;

    /**
     * The default value of the '{@link #isIsSubstitutable() <em>Is Substitutable</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isIsSubstitutable()
     * @generated
     * @ordered
     */
	protected static final boolean IS_SUBSTITUTABLE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIsSubstitutable() <em>Is Substitutable</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isIsSubstitutable()
     * @generated
     * @ordered
     */
	protected boolean isSubstitutable = IS_SUBSTITUTABLE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected GeneralizationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return SimpleumlPackage.eINSTANCE.getGeneralization();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public simpleuml.Class getGeneral() {
        if (general != null && general.eIsProxy()) {
            simpleuml.Class oldGeneral = general;
            general = (simpleuml.Class)eResolveProxy((InternalEObject)general);
            if (general != oldGeneral) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimpleumlPackage.GENERALIZATION__GENERAL, oldGeneral, general));
            }
        }
        return general;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public simpleuml.Class basicGetGeneral() {
        return general;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setGeneral(simpleuml.Class newGeneral) {
        simpleuml.Class oldGeneral = general;
        general = newGeneral;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimpleumlPackage.GENERALIZATION__GENERAL, oldGeneral, general));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isIsSubstitutable() {
        return isSubstitutable;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIsSubstitutable(boolean newIsSubstitutable) {
        boolean oldIsSubstitutable = isSubstitutable;
        isSubstitutable = newIsSubstitutable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SimpleumlPackage.GENERALIZATION__IS_SUBSTITUTABLE, oldIsSubstitutable, isSubstitutable));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
        switch (eDerivedStructuralFeatureID(eFeature)) {
            case SimpleumlPackage.GENERALIZATION__GENERAL:
                if (resolve) return getGeneral();
                return basicGetGeneral();
            case SimpleumlPackage.GENERALIZATION__IS_SUBSTITUTABLE:
                return isIsSubstitutable() ? Boolean.TRUE : Boolean.FALSE;
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
            case SimpleumlPackage.GENERALIZATION__GENERAL:
                setGeneral((simpleuml.Class)newValue);
                return;
            case SimpleumlPackage.GENERALIZATION__IS_SUBSTITUTABLE:
                setIsSubstitutable(((Boolean)newValue).booleanValue());
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
            case SimpleumlPackage.GENERALIZATION__GENERAL:
                setGeneral((simpleuml.Class)null);
                return;
            case SimpleumlPackage.GENERALIZATION__IS_SUBSTITUTABLE:
                setIsSubstitutable(IS_SUBSTITUTABLE_EDEFAULT);
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
            case SimpleumlPackage.GENERALIZATION__GENERAL:
                return general != null;
            case SimpleumlPackage.GENERALIZATION__IS_SUBSTITUTABLE:
                return isSubstitutable != IS_SUBSTITUTABLE_EDEFAULT;
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
        result.append(" (isSubstitutable: ");
        result.append(isSubstitutable);
        result.append(')');
        return result.toString();
    }

} //GeneralizationImpl
