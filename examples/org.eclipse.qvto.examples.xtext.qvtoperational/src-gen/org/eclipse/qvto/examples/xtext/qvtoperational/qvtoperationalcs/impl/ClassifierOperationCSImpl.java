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
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.FeatureKey;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Classifier Operation CS</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierOperationCSImpl#getStereotype
 * <em>Stereotype</em>}</li>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierOperationCSImpl#getFeatureKey
 * <em>Feature Key</em>}</li>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierOperationCSImpl#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierOperationCSImpl#getTypespec
 * <em>Typespec</em>}</li>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierOperationCSImpl#getSignature
 * <em>Signature</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ClassifierOperationCSImpl
		extends ClassifierFeatureCSImpl
		implements ClassifierOperationCS {

	/**
	 * The cached value of the '{@link #getStereotype() <em>Stereotype</em>}'
	 * attribute list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getStereotype()
	 * @generated
	 * @ordered
	 */
	protected EList<String> stereotype;

	/**
	 * The cached value of the '{@link #getFeatureKey() <em>Feature Key</em>}'
	 * attribute list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFeatureKey()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureKey> featureKey;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTypespec() <em>Typespec</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTypespec()
	 * @generated
	 * @ordered
	 */
	protected TypedRefCS typespec;

	/**
	 * The cached value of the '{@link #getSignature() <em>Signature</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSignature()
	 * @generated
	 * @ordered
	 */
	protected CompleteSignatureCS signature;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ClassifierOperationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QvtoperationalcsPackage.Literals.CLASSIFIER_OPERATION_CS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<String> getStereotype() {
		if (stereotype == null) {
			stereotype = new EDataTypeEList<String>(String.class, this,
				QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__STEREOTYPE);
		}
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<FeatureKey> getFeatureKey() {
		if (featureKey == null) {
			featureKey = new EDataTypeEList<FeatureKey>(FeatureKey.class, this,
				QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__FEATURE_KEY);
		}
		return featureKey;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__NAME, oldName,
				name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TypedRefCS getTypespec() {
		return typespec;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetTypespec(TypedRefCS newTypespec,
			NotificationChain msgs) {
		TypedRefCS oldTypespec = typespec;
		typespec = newTypespec;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET,
				QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__TYPESPEC,
				oldTypespec, newTypespec);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTypespec(TypedRefCS newTypespec) {
		if (newTypespec != typespec) {
			NotificationChain msgs = null;
			if (typespec != null)
				msgs = ((InternalEObject) typespec)
					.eInverseRemove(
						this,
						EOPPOSITE_FEATURE_BASE
							- QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__TYPESPEC,
						null, msgs);
			if (newTypespec != null)
				msgs = ((InternalEObject) newTypespec)
					.eInverseAdd(
						this,
						EOPPOSITE_FEATURE_BASE
							- QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__TYPESPEC,
						null, msgs);
			msgs = basicSetTypespec(newTypespec, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__TYPESPEC,
				newTypespec, newTypespec));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CompleteSignatureCS getSignature() {
		return signature;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetSignature(
			CompleteSignatureCS newSignature, NotificationChain msgs) {
		CompleteSignatureCS oldSignature = signature;
		signature = newSignature;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET,
				QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__SIGNATURE,
				oldSignature, newSignature);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSignature(CompleteSignatureCS newSignature) {
		if (newSignature != signature) {
			NotificationChain msgs = null;
			if (signature != null)
				msgs = ((InternalEObject) signature)
					.eInverseRemove(
						this,
						EOPPOSITE_FEATURE_BASE
							- QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__SIGNATURE,
						null, msgs);
			if (newSignature != null)
				msgs = ((InternalEObject) newSignature)
					.eInverseAdd(
						this,
						EOPPOSITE_FEATURE_BASE
							- QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__SIGNATURE,
						null, msgs);
			msgs = basicSetSignature(newSignature, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__SIGNATURE,
				newSignature, newSignature));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final QVTOperationalCSVisitor<R> v) {
		return v.visitClassifierOperationCS(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final BaseCSVisitor<R> v) {
		return ((QVTOperationalCSVisitor<R>) v)
			.visitClassifierOperationCS(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__TYPESPEC :
				return basicSetTypespec(null, msgs);
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__SIGNATURE :
				return basicSetSignature(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__STEREOTYPE :
				return getStereotype();
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__FEATURE_KEY :
				return getFeatureKey();
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__NAME :
				return getName();
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__TYPESPEC :
				return getTypespec();
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__SIGNATURE :
				return getSignature();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__STEREOTYPE :
				getStereotype().clear();
				getStereotype().addAll((Collection<? extends String>) newValue);
				return;
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__FEATURE_KEY :
				getFeatureKey().clear();
				getFeatureKey().addAll(
					(Collection<? extends FeatureKey>) newValue);
				return;
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__NAME :
				setName((String) newValue);
				return;
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__TYPESPEC :
				setTypespec((TypedRefCS) newValue);
				return;
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__SIGNATURE :
				setSignature((CompleteSignatureCS) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__STEREOTYPE :
				getStereotype().clear();
				return;
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__FEATURE_KEY :
				getFeatureKey().clear();
				return;
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__NAME :
				setName(NAME_EDEFAULT);
				return;
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__TYPESPEC :
				setTypespec((TypedRefCS) null);
				return;
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__SIGNATURE :
				setSignature((CompleteSignatureCS) null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__STEREOTYPE :
				return stereotype != null && !stereotype.isEmpty();
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__FEATURE_KEY :
				return featureKey != null && !featureKey.isEmpty();
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__NAME :
				return NAME_EDEFAULT == null
					? name != null
					: !NAME_EDEFAULT.equals(name);
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__TYPESPEC :
				return typespec != null;
			case QvtoperationalcsPackage.CLASSIFIER_OPERATION_CS__SIGNATURE :
				return signature != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (stereotype: ");
		result.append(stereotype);
		result.append(", featureKey: ");
		result.append(featureKey);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} // ClassifierOperationCSImpl
