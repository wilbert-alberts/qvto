/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Typedef CS</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TypedefCSImpl#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TypedefCSImpl#getTypespec
 * <em>Typespec</em>}</li>
 * <li>
 * {@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TypedefCSImpl#getCondition
 * <em>Condition</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TypedefCSImpl
		extends MinimalEObjectImpl.Container
		implements TypedefCS {

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
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected ExpCS condition;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TypedefCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QvtoperationalcsPackage.Literals.TYPEDEF_CS;
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
				QvtoperationalcsPackage.TYPEDEF_CS__NAME, oldName, name));
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
				Notification.SET, QvtoperationalcsPackage.TYPEDEF_CS__TYPESPEC,
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
				msgs = ((InternalEObject) typespec).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- QvtoperationalcsPackage.TYPEDEF_CS__TYPESPEC, null,
					msgs);
			if (newTypespec != null)
				msgs = ((InternalEObject) newTypespec).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- QvtoperationalcsPackage.TYPEDEF_CS__TYPESPEC, null,
					msgs);
			msgs = basicSetTypespec(newTypespec, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				QvtoperationalcsPackage.TYPEDEF_CS__TYPESPEC, newTypespec,
				newTypespec));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExpCS getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetCondition(ExpCS newCondition,
			NotificationChain msgs) {
		ExpCS oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET,
				QvtoperationalcsPackage.TYPEDEF_CS__CONDITION, oldCondition,
				newCondition);
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
	public void setCondition(ExpCS newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject) condition).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- QvtoperationalcsPackage.TYPEDEF_CS__CONDITION, null,
					msgs);
			if (newCondition != null)
				msgs = ((InternalEObject) newCondition).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- QvtoperationalcsPackage.TYPEDEF_CS__CONDITION, null,
					msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				QvtoperationalcsPackage.TYPEDEF_CS__CONDITION, newCondition,
				newCondition));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final QVTOperationalCSVisitor<R> v) {
		return v.visitTypedefCS(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final BaseCSVisitor<R> v) {
		return ((QVTOperationalCSVisitor<R>) v).visitTypedefCS(this);
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
			case QvtoperationalcsPackage.TYPEDEF_CS__TYPESPEC :
				return basicSetTypespec(null, msgs);
			case QvtoperationalcsPackage.TYPEDEF_CS__CONDITION :
				return basicSetCondition(null, msgs);
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
			case QvtoperationalcsPackage.TYPEDEF_CS__NAME :
				return getName();
			case QvtoperationalcsPackage.TYPEDEF_CS__TYPESPEC :
				return getTypespec();
			case QvtoperationalcsPackage.TYPEDEF_CS__CONDITION :
				return getCondition();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QvtoperationalcsPackage.TYPEDEF_CS__NAME :
				setName((String) newValue);
				return;
			case QvtoperationalcsPackage.TYPEDEF_CS__TYPESPEC :
				setTypespec((TypedRefCS) newValue);
				return;
			case QvtoperationalcsPackage.TYPEDEF_CS__CONDITION :
				setCondition((ExpCS) newValue);
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
			case QvtoperationalcsPackage.TYPEDEF_CS__NAME :
				setName(NAME_EDEFAULT);
				return;
			case QvtoperationalcsPackage.TYPEDEF_CS__TYPESPEC :
				setTypespec((TypedRefCS) null);
				return;
			case QvtoperationalcsPackage.TYPEDEF_CS__CONDITION :
				setCondition((ExpCS) null);
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
			case QvtoperationalcsPackage.TYPEDEF_CS__NAME :
				return NAME_EDEFAULT == null
					? name != null
					: !NAME_EDEFAULT.equals(name);
			case QvtoperationalcsPackage.TYPEDEF_CS__TYPESPEC :
				return typespec != null;
			case QvtoperationalcsPackage.TYPEDEF_CS__CONDITION :
				return condition != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} // TypedefCSImpl
