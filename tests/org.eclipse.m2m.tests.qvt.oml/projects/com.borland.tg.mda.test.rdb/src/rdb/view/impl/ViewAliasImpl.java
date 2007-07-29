/**
 * <copyright>
 * </copyright>
 *
 * $Id: ViewAliasImpl.java,v 1.1 2007/07/29 21:25:32 radvorak Exp $
 */
package rdb.view.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import rdb.Element;
import rdb.NamedColumnSet;

import rdb.impl.NamedElementImpl;

import rdb.view.ViewAlias;
import rdb.view.ViewPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alias</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.view.impl.ViewAliasImpl#getReferencedTableOrView <em>Referenced Table Or View</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewAliasImpl extends NamedElementImpl implements ViewAlias {
	/**
	 * The cached value of the '{@link #getReferencedTableOrView() <em>Referenced Table Or View</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getReferencedTableOrView()
	 * @generated
	 * @ordered
	 */
    protected NamedColumnSet referencedTableOrView = null;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ViewAliasImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected EClass eStaticClass() {
		return ViewPackage.eINSTANCE.getViewAlias();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NamedColumnSet getReferencedTableOrView() {
		if (referencedTableOrView != null && referencedTableOrView.eIsProxy()) {
			NamedColumnSet oldReferencedTableOrView = referencedTableOrView;
			referencedTableOrView = (NamedColumnSet)eResolveProxy((InternalEObject)referencedTableOrView);
			if (referencedTableOrView != oldReferencedTableOrView) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ViewPackage.VIEW_ALIAS__REFERENCED_TABLE_OR_VIEW, oldReferencedTableOrView, referencedTableOrView));
			}
		}
		return referencedTableOrView;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NamedColumnSet basicGetReferencedTableOrView() {
		return referencedTableOrView;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setReferencedTableOrView(NamedColumnSet newReferencedTableOrView) {
		NamedColumnSet oldReferencedTableOrView = referencedTableOrView;
		referencedTableOrView = newReferencedTableOrView;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.VIEW_ALIAS__REFERENCED_TABLE_OR_VIEW, oldReferencedTableOrView, referencedTableOrView));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ViewPackage.VIEW_ALIAS__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case ViewPackage.VIEW_ALIAS__NAME:
				return getName();
			case ViewPackage.VIEW_ALIAS__REFERENCED_TABLE_OR_VIEW:
				if (resolve) return getReferencedTableOrView();
				return basicGetReferencedTableOrView();
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
			case ViewPackage.VIEW_ALIAS__PARENT:
				setParent((Element)newValue);
				return;
			case ViewPackage.VIEW_ALIAS__NAME:
				setName((String)newValue);
				return;
			case ViewPackage.VIEW_ALIAS__REFERENCED_TABLE_OR_VIEW:
				setReferencedTableOrView((NamedColumnSet)newValue);
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
			case ViewPackage.VIEW_ALIAS__PARENT:
				setParent((Element)null);
				return;
			case ViewPackage.VIEW_ALIAS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ViewPackage.VIEW_ALIAS__REFERENCED_TABLE_OR_VIEW:
				setReferencedTableOrView((NamedColumnSet)null);
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
			case ViewPackage.VIEW_ALIAS__PARENT:
				return parent != null;
			case ViewPackage.VIEW_ALIAS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ViewPackage.VIEW_ALIAS__REFERENCED_TABLE_OR_VIEW:
				return referencedTableOrView != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //ViewAliasImpl
