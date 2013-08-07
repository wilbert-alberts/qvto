/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.ElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveLiteralExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityDefCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Multiplicity Def CS</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MultiplicityDefCSImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MultiplicityDefCSImpl#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiplicityDefCSImpl
		extends ElementCSImpl
		implements MultiplicityDefCS {

	/**
	 * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected PrimitiveLiteralExpCS lowerBound;

	/**
	 * The cached value of the '{@link #getUpperBound() <em>Upper Bound</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUpperBound()
	 * @generated
	 * @ordered
	 */
	protected PrimitiveLiteralExpCS upperBound;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiplicityDefCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalCSPackage.Literals.MULTIPLICITY_DEF_CS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveLiteralExpCS getLowerBound() {
		if (lowerBound != null && lowerBound.eIsProxy()) {
			InternalEObject oldLowerBound = (InternalEObject)lowerBound;
			lowerBound = (PrimitiveLiteralExpCS)eResolveProxy(oldLowerBound);
			if (lowerBound != oldLowerBound) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTOperationalCSPackage.MULTIPLICITY_DEF_CS__LOWER_BOUND, oldLowerBound, lowerBound));
			}
		}
		return lowerBound;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveLiteralExpCS basicGetLowerBound() {
		return lowerBound;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBound(PrimitiveLiteralExpCS newLowerBound) {
		PrimitiveLiteralExpCS oldLowerBound = lowerBound;
		lowerBound = newLowerBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MULTIPLICITY_DEF_CS__LOWER_BOUND, oldLowerBound, lowerBound));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveLiteralExpCS getUpperBound() {
		if (upperBound != null && upperBound.eIsProxy()) {
			InternalEObject oldUpperBound = (InternalEObject)upperBound;
			upperBound = (PrimitiveLiteralExpCS)eResolveProxy(oldUpperBound);
			if (upperBound != oldUpperBound) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTOperationalCSPackage.MULTIPLICITY_DEF_CS__UPPER_BOUND, oldUpperBound, upperBound));
			}
		}
		return upperBound;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveLiteralExpCS basicGetUpperBound() {
		return upperBound;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperBound(PrimitiveLiteralExpCS newUpperBound) {
		PrimitiveLiteralExpCS oldUpperBound = upperBound;
		upperBound = newUpperBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MULTIPLICITY_DEF_CS__UPPER_BOUND, oldUpperBound, upperBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor<R> v) {
		return v.visitMultiplicityDefCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final BaseCSVisitor<R> v) {
		return ((QVTOperationalCSVisitor<R>)v).visitMultiplicityDefCS(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTOperationalCSPackage.MULTIPLICITY_DEF_CS__LOWER_BOUND:
				if (resolve) return getLowerBound();
				return basicGetLowerBound();
			case QVTOperationalCSPackage.MULTIPLICITY_DEF_CS__UPPER_BOUND:
				if (resolve) return getUpperBound();
				return basicGetUpperBound();
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
			case QVTOperationalCSPackage.MULTIPLICITY_DEF_CS__LOWER_BOUND:
				setLowerBound((PrimitiveLiteralExpCS)newValue);
				return;
			case QVTOperationalCSPackage.MULTIPLICITY_DEF_CS__UPPER_BOUND:
				setUpperBound((PrimitiveLiteralExpCS)newValue);
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
			case QVTOperationalCSPackage.MULTIPLICITY_DEF_CS__LOWER_BOUND:
				setLowerBound((PrimitiveLiteralExpCS)null);
				return;
			case QVTOperationalCSPackage.MULTIPLICITY_DEF_CS__UPPER_BOUND:
				setUpperBound((PrimitiveLiteralExpCS)null);
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
			case QVTOperationalCSPackage.MULTIPLICITY_DEF_CS__LOWER_BOUND:
				return lowerBound != null;
			case QVTOperationalCSPackage.MULTIPLICITY_DEF_CS__UPPER_BOUND:
				return upperBound != null;
		}
		return super.eIsSet(featureID);
	}

} // MultiplicityDefCSImpl
