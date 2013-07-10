/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.ElementCSImpl;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingDeclarationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingMethodCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Mapping Method CS</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingMethodCSImpl#isBlackBox <em>Black Box</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingMethodCSImpl#getMappingDeclarationCS <em>Mapping Declaration CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MappingMethodCSImpl
		extends ElementCSImpl
		implements MappingMethodCS {

	/**
	 * The default value of the '{@link #isBlackBox() <em>Black Box</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isBlackBox()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BLACK_BOX_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBlackBox() <em>Black Box</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isBlackBox()
	 * @generated
	 * @ordered
	 */
	protected boolean blackBox = BLACK_BOX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMappingDeclarationCS()
	 * <em>Mapping Declaration CS</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMappingDeclarationCS()
	 * @generated
	 * @ordered
	 */
	protected MappingDeclarationCS mappingDeclarationCS;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingMethodCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QvtoperationalcsPackage.Literals.MAPPING_METHOD_CS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBlackBox() {
		return blackBox;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlackBox(boolean newBlackBox) {
		boolean oldBlackBox = blackBox;
		blackBox = newBlackBox;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.MAPPING_METHOD_CS__BLACK_BOX, oldBlackBox, blackBox));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MappingDeclarationCS getMappingDeclarationCS() {
		return mappingDeclarationCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingDeclarationCS(
			MappingDeclarationCS newMappingDeclarationCS, NotificationChain msgs) {
		MappingDeclarationCS oldMappingDeclarationCS = mappingDeclarationCS;
		mappingDeclarationCS = newMappingDeclarationCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.MAPPING_METHOD_CS__MAPPING_DECLARATION_CS, oldMappingDeclarationCS, newMappingDeclarationCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingDeclarationCS(
			MappingDeclarationCS newMappingDeclarationCS) {
		if (newMappingDeclarationCS != mappingDeclarationCS) {
			NotificationChain msgs = null;
			if (mappingDeclarationCS != null)
				msgs = ((InternalEObject)mappingDeclarationCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.MAPPING_METHOD_CS__MAPPING_DECLARATION_CS, null, msgs);
			if (newMappingDeclarationCS != null)
				msgs = ((InternalEObject)newMappingDeclarationCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.MAPPING_METHOD_CS__MAPPING_DECLARATION_CS, null, msgs);
			msgs = basicSetMappingDeclarationCS(newMappingDeclarationCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.MAPPING_METHOD_CS__MAPPING_DECLARATION_CS, newMappingDeclarationCS, newMappingDeclarationCS));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QvtoperationalcsPackage.MAPPING_METHOD_CS__MAPPING_DECLARATION_CS:
				return basicSetMappingDeclarationCS(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QvtoperationalcsPackage.MAPPING_METHOD_CS__BLACK_BOX:
				return isBlackBox();
			case QvtoperationalcsPackage.MAPPING_METHOD_CS__MAPPING_DECLARATION_CS:
				return getMappingDeclarationCS();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QvtoperationalcsPackage.MAPPING_METHOD_CS__BLACK_BOX:
				setBlackBox((Boolean)newValue);
				return;
			case QvtoperationalcsPackage.MAPPING_METHOD_CS__MAPPING_DECLARATION_CS:
				setMappingDeclarationCS((MappingDeclarationCS)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case QvtoperationalcsPackage.MAPPING_METHOD_CS__BLACK_BOX:
				setBlackBox(BLACK_BOX_EDEFAULT);
				return;
			case QvtoperationalcsPackage.MAPPING_METHOD_CS__MAPPING_DECLARATION_CS:
				setMappingDeclarationCS((MappingDeclarationCS)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case QvtoperationalcsPackage.MAPPING_METHOD_CS__BLACK_BOX:
				return blackBox != BLACK_BOX_EDEFAULT;
			case QvtoperationalcsPackage.MAPPING_METHOD_CS__MAPPING_DECLARATION_CS:
				return mappingDeclarationCS != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (blackBox: ");
		result.append(blackBox);
		result.append(')');
		return result.toString();
	}

} // MappingMethodCSImpl
