/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.ElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindEnum;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterDeclarationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Parameter Declaration CS</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ParameterDeclarationCSImpl#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ParameterDeclarationCSImpl#getTypeSpecCS <em>Type Spec CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ParameterDeclarationCSImpl#getDirectionKind <em>Direction Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterDeclarationCSImpl
		extends ElementCSImpl
		implements ParameterDeclarationCS {

	/**
	 * The default value of the '{@link #getSimpleNameCS() <em>Simple Name CS</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSimpleNameCS()
	 * @generated
	 * @ordered
	 */
	protected static final String SIMPLE_NAME_CS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSimpleNameCS() <em>Simple Name CS</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSimpleNameCS()
	 * @generated
	 * @ordered
	 */
	protected String simpleNameCS = SIMPLE_NAME_CS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTypeSpecCS() <em>Type Spec CS</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTypeSpecCS()
	 * @generated
	 * @ordered
	 */
	protected TypeSpecCS typeSpecCS;

	/**
	 * The default value of the '{@link #getDirectionKind() <em>Direction Kind</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDirectionKind()
	 * @generated
	 * @ordered
	 */
	protected static final DirectionKindEnum DIRECTION_KIND_EDEFAULT = DirectionKindEnum.DEFAULT;

	/**
	 * The cached value of the '{@link #getDirectionKind() <em>Direction Kind</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDirectionKind()
	 * @generated
	 * @ordered
	 */
	protected DirectionKindEnum directionKind = DIRECTION_KIND_EDEFAULT;

	/**
	 * This is true if the Direction Kind attribute has been set. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean directionKindESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterDeclarationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QvtoperationalcsPackage.Literals.PARAMETER_DECLARATION_CS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSimpleNameCS() {
		return simpleNameCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleNameCS(String newSimpleNameCS) {
		String oldSimpleNameCS = simpleNameCS;
		simpleNameCS = newSimpleNameCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.PARAMETER_DECLARATION_CS__SIMPLE_NAME_CS, oldSimpleNameCS, simpleNameCS));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSpecCS getTypeSpecCS() {
		return typeSpecCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeSpecCS(TypeSpecCS newTypeSpecCS,
			NotificationChain msgs) {
		TypeSpecCS oldTypeSpecCS = typeSpecCS;
		typeSpecCS = newTypeSpecCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.PARAMETER_DECLARATION_CS__TYPE_SPEC_CS, oldTypeSpecCS, newTypeSpecCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeSpecCS(TypeSpecCS newTypeSpecCS) {
		if (newTypeSpecCS != typeSpecCS) {
			NotificationChain msgs = null;
			if (typeSpecCS != null)
				msgs = ((InternalEObject)typeSpecCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.PARAMETER_DECLARATION_CS__TYPE_SPEC_CS, null, msgs);
			if (newTypeSpecCS != null)
				msgs = ((InternalEObject)newTypeSpecCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.PARAMETER_DECLARATION_CS__TYPE_SPEC_CS, null, msgs);
			msgs = basicSetTypeSpecCS(newTypeSpecCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.PARAMETER_DECLARATION_CS__TYPE_SPEC_CS, newTypeSpecCS, newTypeSpecCS));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionKindEnum getDirectionKind() {
		return directionKind;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirectionKind(DirectionKindEnum newDirectionKind) {
		DirectionKindEnum oldDirectionKind = directionKind;
		directionKind = newDirectionKind == null ? DIRECTION_KIND_EDEFAULT : newDirectionKind;
		boolean oldDirectionKindESet = directionKindESet;
		directionKindESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.PARAMETER_DECLARATION_CS__DIRECTION_KIND, oldDirectionKind, directionKind, !oldDirectionKindESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDirectionKind() {
		DirectionKindEnum oldDirectionKind = directionKind;
		boolean oldDirectionKindESet = directionKindESet;
		directionKind = DIRECTION_KIND_EDEFAULT;
		directionKindESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, QvtoperationalcsPackage.PARAMETER_DECLARATION_CS__DIRECTION_KIND, oldDirectionKind, DIRECTION_KIND_EDEFAULT, oldDirectionKindESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDirectionKind() {
		return directionKindESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final QVTOperationalCSVisitor<R> v) {
		return v.visitParameterDeclarationCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final BaseCSVisitor<R> v) {
		return ((QVTOperationalCSVisitor<R>)v).visitParameterDeclarationCS(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QvtoperationalcsPackage.PARAMETER_DECLARATION_CS__TYPE_SPEC_CS:
				return basicSetTypeSpecCS(null, msgs);
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
			case QvtoperationalcsPackage.PARAMETER_DECLARATION_CS__SIMPLE_NAME_CS:
				return getSimpleNameCS();
			case QvtoperationalcsPackage.PARAMETER_DECLARATION_CS__TYPE_SPEC_CS:
				return getTypeSpecCS();
			case QvtoperationalcsPackage.PARAMETER_DECLARATION_CS__DIRECTION_KIND:
				return getDirectionKind();
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
			case QvtoperationalcsPackage.PARAMETER_DECLARATION_CS__SIMPLE_NAME_CS:
				setSimpleNameCS((String)newValue);
				return;
			case QvtoperationalcsPackage.PARAMETER_DECLARATION_CS__TYPE_SPEC_CS:
				setTypeSpecCS((TypeSpecCS)newValue);
				return;
			case QvtoperationalcsPackage.PARAMETER_DECLARATION_CS__DIRECTION_KIND:
				setDirectionKind((DirectionKindEnum)newValue);
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
			case QvtoperationalcsPackage.PARAMETER_DECLARATION_CS__SIMPLE_NAME_CS:
				setSimpleNameCS(SIMPLE_NAME_CS_EDEFAULT);
				return;
			case QvtoperationalcsPackage.PARAMETER_DECLARATION_CS__TYPE_SPEC_CS:
				setTypeSpecCS((TypeSpecCS)null);
				return;
			case QvtoperationalcsPackage.PARAMETER_DECLARATION_CS__DIRECTION_KIND:
				unsetDirectionKind();
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
			case QvtoperationalcsPackage.PARAMETER_DECLARATION_CS__SIMPLE_NAME_CS:
				return SIMPLE_NAME_CS_EDEFAULT == null ? simpleNameCS != null : !SIMPLE_NAME_CS_EDEFAULT.equals(simpleNameCS);
			case QvtoperationalcsPackage.PARAMETER_DECLARATION_CS__TYPE_SPEC_CS:
				return typeSpecCS != null;
			case QvtoperationalcsPackage.PARAMETER_DECLARATION_CS__DIRECTION_KIND:
				return isSetDirectionKind();
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

} // ParameterDeclarationCSImpl
