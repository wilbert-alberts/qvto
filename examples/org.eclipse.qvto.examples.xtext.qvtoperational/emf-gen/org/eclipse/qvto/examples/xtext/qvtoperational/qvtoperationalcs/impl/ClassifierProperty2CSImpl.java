/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityDefCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OppositePropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Classifier Property2 CS</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierProperty2CSImpl#getStereotypeQualifiers <em>Stereotype Qualifiers</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierProperty2CSImpl#getFeatureKeys <em>Feature Keys</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierProperty2CSImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierProperty2CSImpl#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierProperty2CSImpl#isIsOrdered <em>Is Ordered</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassifierProperty2CSImpl
		extends LocalPropertyCSImpl
		implements ClassifierProperty2CS {

	/**
	 * The cached value of the '{@link #getStereotypeQualifiers() <em>Stereotype Qualifiers</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypeQualifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<String> stereotypeQualifiers;

	/**
	 * The cached value of the '{@link #getFeatureKeys() <em>Feature Keys</em>}' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFeatureKeys()
	 * @generated
	 * @ordered
	 */
	protected EList<String> featureKeys;

	/**
	 * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected MultiplicityDefCS multiplicity;

	/**
	 * The cached value of the '{@link #getOpposite() <em>Opposite</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOpposite()
	 * @generated
	 * @ordered
	 */
	protected OppositePropertyCS opposite;

	/**
	 * The default value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ORDERED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected boolean isOrdered = IS_ORDERED_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassifierProperty2CSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QvtoperationalcsPackage.Literals.CLASSIFIER_PROPERTY2_CS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getStereotypeQualifiers() {
		if (stereotypeQualifiers == null) {
			stereotypeQualifiers = new EDataTypeUniqueEList<String>(String.class, this, QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__STEREOTYPE_QUALIFIERS);
		}
		return stereotypeQualifiers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getFeatureKeys() {
		if (featureKeys == null) {
			featureKeys = new EDataTypeUniqueEList<String>(String.class, this, QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__FEATURE_KEYS);
		}
		return featureKeys;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityDefCS getMultiplicity() {
		return multiplicity;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMultiplicity(
			MultiplicityDefCS newMultiplicity, NotificationChain msgs) {
		MultiplicityDefCS oldMultiplicity = multiplicity;
		multiplicity = newMultiplicity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__MULTIPLICITY, oldMultiplicity, newMultiplicity);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiplicity(MultiplicityDefCS newMultiplicity) {
		if (newMultiplicity != multiplicity) {
			NotificationChain msgs = null;
			if (multiplicity != null)
				msgs = ((InternalEObject)multiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__MULTIPLICITY, null, msgs);
			if (newMultiplicity != null)
				msgs = ((InternalEObject)newMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__MULTIPLICITY, null, msgs);
			msgs = basicSetMultiplicity(newMultiplicity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__MULTIPLICITY, newMultiplicity, newMultiplicity));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OppositePropertyCS getOpposite() {
		return opposite;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOpposite(OppositePropertyCS newOpposite,
			NotificationChain msgs) {
		OppositePropertyCS oldOpposite = opposite;
		opposite = newOpposite;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__OPPOSITE, oldOpposite, newOpposite);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpposite(OppositePropertyCS newOpposite) {
		if (newOpposite != opposite) {
			NotificationChain msgs = null;
			if (opposite != null)
				msgs = ((InternalEObject)opposite).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__OPPOSITE, null, msgs);
			if (newOpposite != null)
				msgs = ((InternalEObject)newOpposite).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__OPPOSITE, null, msgs);
			msgs = basicSetOpposite(newOpposite, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__OPPOSITE, newOpposite, newOpposite));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsOrdered() {
		return isOrdered;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsOrdered(boolean newIsOrdered) {
		boolean oldIsOrdered = isOrdered;
		isOrdered = newIsOrdered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__IS_ORDERED, oldIsOrdered, isOrdered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final QVTOperationalCSVisitor<R> v) {
		return v.visitClassifierProperty2CS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final BaseCSVisitor<R> v) {
		return ((QVTOperationalCSVisitor<R>)v).visitClassifierProperty2CS(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__MULTIPLICITY:
				return basicSetMultiplicity(null, msgs);
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__OPPOSITE:
				return basicSetOpposite(null, msgs);
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
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__STEREOTYPE_QUALIFIERS:
				return getStereotypeQualifiers();
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__FEATURE_KEYS:
				return getFeatureKeys();
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__MULTIPLICITY:
				return getMultiplicity();
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__OPPOSITE:
				return getOpposite();
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__IS_ORDERED:
				return isIsOrdered();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__STEREOTYPE_QUALIFIERS:
				getStereotypeQualifiers().clear();
				getStereotypeQualifiers().addAll((Collection<? extends String>)newValue);
				return;
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__FEATURE_KEYS:
				getFeatureKeys().clear();
				getFeatureKeys().addAll((Collection<? extends String>)newValue);
				return;
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__MULTIPLICITY:
				setMultiplicity((MultiplicityDefCS)newValue);
				return;
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__OPPOSITE:
				setOpposite((OppositePropertyCS)newValue);
				return;
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__IS_ORDERED:
				setIsOrdered((Boolean)newValue);
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
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__STEREOTYPE_QUALIFIERS:
				getStereotypeQualifiers().clear();
				return;
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__FEATURE_KEYS:
				getFeatureKeys().clear();
				return;
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__MULTIPLICITY:
				setMultiplicity((MultiplicityDefCS)null);
				return;
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__OPPOSITE:
				setOpposite((OppositePropertyCS)null);
				return;
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__IS_ORDERED:
				setIsOrdered(IS_ORDERED_EDEFAULT);
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
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__STEREOTYPE_QUALIFIERS:
				return stereotypeQualifiers != null && !stereotypeQualifiers.isEmpty();
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__FEATURE_KEYS:
				return featureKeys != null && !featureKeys.isEmpty();
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__MULTIPLICITY:
				return multiplicity != null;
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__OPPOSITE:
				return opposite != null;
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS__IS_ORDERED:
				return isOrdered != IS_ORDERED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return super.toString();
	}

} // ClassifierProperty2CSImpl
