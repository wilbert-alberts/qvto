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
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.ElementCSImpl;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToImportCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>QV To Import CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVToImportCSImpl#getUnit <em>Unit</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVToImportCSImpl#getImportedUnitElement <em>Imported Unit Element</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.QVToImportCSImpl#isAll <em>All</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QVToImportCSImpl extends ElementCSImpl implements QVToImportCS {
	/**
	 * The cached value of the '{@link #getUnit() <em>Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected UnitCS unit;

	/**
	 * The cached value of the '{@link #getImportedUnitElement() <em>Imported Unit Element</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedUnitElement()
	 * @generated
	 * @ordered
	 */
	protected EList<String> importedUnitElement;

	/**
	 * The default value of the '{@link #isAll() <em>All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAll()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAll() <em>All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAll()
	 * @generated
	 * @ordered
	 */
	protected boolean all = ALL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QVToImportCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QvtoperationalcsPackage.Literals.QV_TO_IMPORT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitCS getUnit() {
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnit(UnitCS newUnit, NotificationChain msgs) {
		UnitCS oldUnit = unit;
		unit = newUnit;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.QV_TO_IMPORT_CS__UNIT, oldUnit, newUnit);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnit(UnitCS newUnit) {
		if (newUnit != unit) {
			NotificationChain msgs = null;
			if (unit != null)
				msgs = ((InternalEObject)unit).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.QV_TO_IMPORT_CS__UNIT, null, msgs);
			if (newUnit != null)
				msgs = ((InternalEObject)newUnit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.QV_TO_IMPORT_CS__UNIT, null, msgs);
			msgs = basicSetUnit(newUnit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.QV_TO_IMPORT_CS__UNIT, newUnit, newUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getImportedUnitElement() {
		if (importedUnitElement == null) {
			importedUnitElement = new EDataTypeUniqueEList<String>(String.class, this, QvtoperationalcsPackage.QV_TO_IMPORT_CS__IMPORTED_UNIT_ELEMENT);
		}
		return importedUnitElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAll() {
		return all;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAll(boolean newAll) {
		boolean oldAll = all;
		all = newAll;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.QV_TO_IMPORT_CS__ALL, oldAll, all));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QvtoperationalcsPackage.QV_TO_IMPORT_CS__UNIT:
				return basicSetUnit(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QvtoperationalcsPackage.QV_TO_IMPORT_CS__UNIT:
				return getUnit();
			case QvtoperationalcsPackage.QV_TO_IMPORT_CS__IMPORTED_UNIT_ELEMENT:
				return getImportedUnitElement();
			case QvtoperationalcsPackage.QV_TO_IMPORT_CS__ALL:
				return isAll();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QvtoperationalcsPackage.QV_TO_IMPORT_CS__UNIT:
				setUnit((UnitCS)newValue);
				return;
			case QvtoperationalcsPackage.QV_TO_IMPORT_CS__IMPORTED_UNIT_ELEMENT:
				getImportedUnitElement().clear();
				getImportedUnitElement().addAll((Collection<? extends String>)newValue);
				return;
			case QvtoperationalcsPackage.QV_TO_IMPORT_CS__ALL:
				setAll((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case QvtoperationalcsPackage.QV_TO_IMPORT_CS__UNIT:
				setUnit((UnitCS)null);
				return;
			case QvtoperationalcsPackage.QV_TO_IMPORT_CS__IMPORTED_UNIT_ELEMENT:
				getImportedUnitElement().clear();
				return;
			case QvtoperationalcsPackage.QV_TO_IMPORT_CS__ALL:
				setAll(ALL_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case QvtoperationalcsPackage.QV_TO_IMPORT_CS__UNIT:
				return unit != null;
			case QvtoperationalcsPackage.QV_TO_IMPORT_CS__IMPORTED_UNIT_ELEMENT:
				return importedUnitElement != null && !importedUnitElement.isEmpty();
			case QvtoperationalcsPackage.QV_TO_IMPORT_CS__ALL:
				return all != ALL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}


} //QVToImportCSImpl
