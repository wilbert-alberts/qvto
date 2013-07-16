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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.ElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ElementWithBody;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PackageRefCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Model Type CS</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModelTypeCSImpl#getBodyStartLocation <em>Body Start Location</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModelTypeCSImpl#getBodyEndLocation <em>Body End Location</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModelTypeCSImpl#getIdentifierCS <em>Identifier CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModelTypeCSImpl#getComplianceKindCS <em>Compliance Kind CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModelTypeCSImpl#getPackageRefs <em>Package Refs</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ModelTypeCSImpl#getWhereStatements <em>Where Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelTypeCSImpl
		extends ElementCSImpl
		implements ModelTypeCS {

	/**
	 * The default value of the '{@link #getBodyStartLocation() <em>Body Start Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getBodyStartLocation()
	 * @generated
	 * @ordered
	 */
	protected static final int BODY_START_LOCATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBodyStartLocation() <em>Body Start Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getBodyStartLocation()
	 * @generated
	 * @ordered
	 */
	protected int bodyStartLocation = BODY_START_LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getBodyEndLocation() <em>Body End Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getBodyEndLocation()
	 * @generated
	 * @ordered
	 */
	protected static final int BODY_END_LOCATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBodyEndLocation() <em>Body End Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getBodyEndLocation()
	 * @generated
	 * @ordered
	 */
	protected int bodyEndLocation = BODY_END_LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getIdentifierCS() <em>Identifier CS</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getIdentifierCS()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFIER_CS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdentifierCS() <em>Identifier CS</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getIdentifierCS()
	 * @generated
	 * @ordered
	 */
	protected String identifierCS = IDENTIFIER_CS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getComplianceKindCS() <em>Compliance Kind CS</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getComplianceKindCS()
	 * @generated
	 * @ordered
	 */
	protected StringLiteralExpCS complianceKindCS;

	/**
	 * The cached value of the '{@link #getPackageRefs() <em>Package Refs</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPackageRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageRefCS> packageRefs;

	/**
	 * The cached value of the '{@link #getWhereStatements()
	 * <em>Where Statements</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWhereStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<ExpCS> whereStatements;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelTypeCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QvtoperationalcsPackage.Literals.MODEL_TYPE_CS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getBodyStartLocation() {
		return bodyStartLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyStartLocation(int newBodyStartLocation) {
		int oldBodyStartLocation = bodyStartLocation;
		bodyStartLocation = newBodyStartLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.MODEL_TYPE_CS__BODY_START_LOCATION, oldBodyStartLocation, bodyStartLocation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getBodyEndLocation() {
		return bodyEndLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyEndLocation(int newBodyEndLocation) {
		int oldBodyEndLocation = bodyEndLocation;
		bodyEndLocation = newBodyEndLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.MODEL_TYPE_CS__BODY_END_LOCATION, oldBodyEndLocation, bodyEndLocation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentifierCS() {
		return identifierCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifierCS(String newIdentifierCS) {
		String oldIdentifierCS = identifierCS;
		identifierCS = newIdentifierCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.MODEL_TYPE_CS__IDENTIFIER_CS, oldIdentifierCS, identifierCS));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteralExpCS getComplianceKindCS() {
		return complianceKindCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComplianceKindCS(
			StringLiteralExpCS newComplianceKindCS, NotificationChain msgs) {
		StringLiteralExpCS oldComplianceKindCS = complianceKindCS;
		complianceKindCS = newComplianceKindCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.MODEL_TYPE_CS__COMPLIANCE_KIND_CS, oldComplianceKindCS, newComplianceKindCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setComplianceKindCS(StringLiteralExpCS newComplianceKindCS) {
		if (newComplianceKindCS != complianceKindCS) {
			NotificationChain msgs = null;
			if (complianceKindCS != null)
				msgs = ((InternalEObject)complianceKindCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.MODEL_TYPE_CS__COMPLIANCE_KIND_CS, null, msgs);
			if (newComplianceKindCS != null)
				msgs = ((InternalEObject)newComplianceKindCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.MODEL_TYPE_CS__COMPLIANCE_KIND_CS, null, msgs);
			msgs = basicSetComplianceKindCS(newComplianceKindCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.MODEL_TYPE_CS__COMPLIANCE_KIND_CS, newComplianceKindCS, newComplianceKindCS));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageRefCS> getPackageRefs() {
		if (packageRefs == null) {
			packageRefs = new EObjectContainmentEList<PackageRefCS>(PackageRefCS.class, this, QvtoperationalcsPackage.MODEL_TYPE_CS__PACKAGE_REFS);
		}
		return packageRefs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExpCS> getWhereStatements() {
		if (whereStatements == null) {
			whereStatements = new EObjectContainmentEList<ExpCS>(ExpCS.class, this, QvtoperationalcsPackage.MODEL_TYPE_CS__WHERE_STATEMENTS);
		}
		return whereStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor<R> v) {
		return v.visitModelTypeCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final BaseCSVisitor<R> v) {
		return ((QVTOperationalCSVisitor<R>)v).visitModelTypeCS(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QvtoperationalcsPackage.MODEL_TYPE_CS__COMPLIANCE_KIND_CS:
				return basicSetComplianceKindCS(null, msgs);
			case QvtoperationalcsPackage.MODEL_TYPE_CS__PACKAGE_REFS:
				return ((InternalEList<?>)getPackageRefs()).basicRemove(otherEnd, msgs);
			case QvtoperationalcsPackage.MODEL_TYPE_CS__WHERE_STATEMENTS:
				return ((InternalEList<?>)getWhereStatements()).basicRemove(otherEnd, msgs);
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
			case QvtoperationalcsPackage.MODEL_TYPE_CS__BODY_START_LOCATION:
				return getBodyStartLocation();
			case QvtoperationalcsPackage.MODEL_TYPE_CS__BODY_END_LOCATION:
				return getBodyEndLocation();
			case QvtoperationalcsPackage.MODEL_TYPE_CS__IDENTIFIER_CS:
				return getIdentifierCS();
			case QvtoperationalcsPackage.MODEL_TYPE_CS__COMPLIANCE_KIND_CS:
				return getComplianceKindCS();
			case QvtoperationalcsPackage.MODEL_TYPE_CS__PACKAGE_REFS:
				return getPackageRefs();
			case QvtoperationalcsPackage.MODEL_TYPE_CS__WHERE_STATEMENTS:
				return getWhereStatements();
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
			case QvtoperationalcsPackage.MODEL_TYPE_CS__BODY_START_LOCATION:
				setBodyStartLocation((Integer)newValue);
				return;
			case QvtoperationalcsPackage.MODEL_TYPE_CS__BODY_END_LOCATION:
				setBodyEndLocation((Integer)newValue);
				return;
			case QvtoperationalcsPackage.MODEL_TYPE_CS__IDENTIFIER_CS:
				setIdentifierCS((String)newValue);
				return;
			case QvtoperationalcsPackage.MODEL_TYPE_CS__COMPLIANCE_KIND_CS:
				setComplianceKindCS((StringLiteralExpCS)newValue);
				return;
			case QvtoperationalcsPackage.MODEL_TYPE_CS__PACKAGE_REFS:
				getPackageRefs().clear();
				getPackageRefs().addAll((Collection<? extends PackageRefCS>)newValue);
				return;
			case QvtoperationalcsPackage.MODEL_TYPE_CS__WHERE_STATEMENTS:
				getWhereStatements().clear();
				getWhereStatements().addAll((Collection<? extends ExpCS>)newValue);
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
			case QvtoperationalcsPackage.MODEL_TYPE_CS__BODY_START_LOCATION:
				setBodyStartLocation(BODY_START_LOCATION_EDEFAULT);
				return;
			case QvtoperationalcsPackage.MODEL_TYPE_CS__BODY_END_LOCATION:
				setBodyEndLocation(BODY_END_LOCATION_EDEFAULT);
				return;
			case QvtoperationalcsPackage.MODEL_TYPE_CS__IDENTIFIER_CS:
				setIdentifierCS(IDENTIFIER_CS_EDEFAULT);
				return;
			case QvtoperationalcsPackage.MODEL_TYPE_CS__COMPLIANCE_KIND_CS:
				setComplianceKindCS((StringLiteralExpCS)null);
				return;
			case QvtoperationalcsPackage.MODEL_TYPE_CS__PACKAGE_REFS:
				getPackageRefs().clear();
				return;
			case QvtoperationalcsPackage.MODEL_TYPE_CS__WHERE_STATEMENTS:
				getWhereStatements().clear();
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
			case QvtoperationalcsPackage.MODEL_TYPE_CS__BODY_START_LOCATION:
				return bodyStartLocation != BODY_START_LOCATION_EDEFAULT;
			case QvtoperationalcsPackage.MODEL_TYPE_CS__BODY_END_LOCATION:
				return bodyEndLocation != BODY_END_LOCATION_EDEFAULT;
			case QvtoperationalcsPackage.MODEL_TYPE_CS__IDENTIFIER_CS:
				return IDENTIFIER_CS_EDEFAULT == null ? identifierCS != null : !IDENTIFIER_CS_EDEFAULT.equals(identifierCS);
			case QvtoperationalcsPackage.MODEL_TYPE_CS__COMPLIANCE_KIND_CS:
				return complianceKindCS != null;
			case QvtoperationalcsPackage.MODEL_TYPE_CS__PACKAGE_REFS:
				return packageRefs != null && !packageRefs.isEmpty();
			case QvtoperationalcsPackage.MODEL_TYPE_CS__WHERE_STATEMENTS:
				return whereStatements != null && !whereStatements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ElementWithBody.class) {
			switch (derivedFeatureID) {
				case QvtoperationalcsPackage.MODEL_TYPE_CS__BODY_START_LOCATION: return QvtoperationalcsPackage.ELEMENT_WITH_BODY__BODY_START_LOCATION;
				case QvtoperationalcsPackage.MODEL_TYPE_CS__BODY_END_LOCATION: return QvtoperationalcsPackage.ELEMENT_WITH_BODY__BODY_END_LOCATION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ElementWithBody.class) {
			switch (baseFeatureID) {
				case QvtoperationalcsPackage.ELEMENT_WITH_BODY__BODY_START_LOCATION: return QvtoperationalcsPackage.MODEL_TYPE_CS__BODY_START_LOCATION;
				case QvtoperationalcsPackage.ELEMENT_WITH_BODY__BODY_END_LOCATION: return QvtoperationalcsPackage.MODEL_TYPE_CS__BODY_END_LOCATION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return super.toString();
	}

} // ModelTypeCSImpl
