/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingBodyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Mapping Body CS</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingBodyCSImpl#isHasPopulationKeyword <em>Has Population Keyword</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingBodyCSImpl
		extends MappingSectionCSImpl
		implements MappingBodyCS {

	/**
	 * The default value of the '{@link #isHasPopulationKeyword() <em>Has Population Keyword</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isHasPopulationKeyword()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_POPULATION_KEYWORD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasPopulationKeyword() <em>Has Population Keyword</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isHasPopulationKeyword()
	 * @generated
	 * @ordered
	 */
	protected boolean hasPopulationKeyword = HAS_POPULATION_KEYWORD_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingBodyCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QvtoperationalcsPackage.Literals.MAPPING_BODY_CS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasPopulationKeyword() {
		return hasPopulationKeyword;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasPopulationKeyword(boolean newHasPopulationKeyword) {
		boolean oldHasPopulationKeyword = hasPopulationKeyword;
		hasPopulationKeyword = newHasPopulationKeyword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.MAPPING_BODY_CS__HAS_POPULATION_KEYWORD, oldHasPopulationKeyword, hasPopulationKeyword));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QvtoperationalcsPackage.MAPPING_BODY_CS__HAS_POPULATION_KEYWORD:
				return isHasPopulationKeyword();
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
			case QvtoperationalcsPackage.MAPPING_BODY_CS__HAS_POPULATION_KEYWORD:
				setHasPopulationKeyword((Boolean)newValue);
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
			case QvtoperationalcsPackage.MAPPING_BODY_CS__HAS_POPULATION_KEYWORD:
				setHasPopulationKeyword(HAS_POPULATION_KEYWORD_EDEFAULT);
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
			case QvtoperationalcsPackage.MAPPING_BODY_CS__HAS_POPULATION_KEYWORD:
				return hasPopulationKeyword != HAS_POPULATION_KEYWORD_EDEFAULT;
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
		result.append(" (hasPopulationKeyword: ");
		result.append(hasPopulationKeyword);
		result.append(')');
		return result.toString();
	}

} // MappingBodyCSImpl
