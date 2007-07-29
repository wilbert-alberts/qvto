/**
 * <copyright>
 * </copyright>
 *
 * $Id: PrimitiveDataTypeImpl.java,v 1.1 2007/07/29 21:25:27 radvorak Exp $
 */
package rdb.datatypes.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import rdb.Element;

import rdb.datatypes.DatatypesPackage;
import rdb.datatypes.PrimitiveDataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.datatypes.impl.PrimitiveDataTypeImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimitiveDataTypeImpl extends DataTypeImpl implements PrimitiveDataType {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
    protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
    protected String type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected PrimitiveDataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected EClass eStaticClass() {
		return DatatypesPackage.eINSTANCE.getPrimitiveDataType();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.PRIMITIVE_DATA_TYPE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__NAME:
				return getName();
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__SIZE:
				return new Integer(getSize());
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__DECIMAL_DIGITS:
				return new Integer(getDecimalDigits());
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__NULLABLE:
				return isNullable() ? Boolean.TRUE : Boolean.FALSE;
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__DEFAULT:
				return getDefault();
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__CHECK:
				return getCheck();
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__VAR:
				return getVar();
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__TYPE:
				return getType();
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
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__PARENT:
				setParent((Element)newValue);
				return;
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__NAME:
				setName((String)newValue);
				return;
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__SIZE:
				setSize(((Integer)newValue).intValue());
				return;
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__DECIMAL_DIGITS:
				setDecimalDigits(((Integer)newValue).intValue());
				return;
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__NULLABLE:
				setNullable(((Boolean)newValue).booleanValue());
				return;
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__DEFAULT:
				setDefault((String)newValue);
				return;
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__CHECK:
				setCheck((String)newValue);
				return;
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__VAR:
				setVar((String)newValue);
				return;
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__TYPE:
				setType((String)newValue);
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
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__PARENT:
				setParent((Element)null);
				return;
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__DECIMAL_DIGITS:
				setDecimalDigits(DECIMAL_DIGITS_EDEFAULT);
				return;
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__NULLABLE:
				setNullable(NULLABLE_EDEFAULT);
				return;
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__CHECK:
				setCheck(CHECK_EDEFAULT);
				return;
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__VAR:
				setVar(VAR_EDEFAULT);
				return;
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__TYPE:
				setType(TYPE_EDEFAULT);
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
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__PARENT:
				return parent != null;
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__SIZE:
				return size != SIZE_EDEFAULT;
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__DECIMAL_DIGITS:
				return decimalDigits != DECIMAL_DIGITS_EDEFAULT;
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__NULLABLE:
				return nullable != NULLABLE_EDEFAULT;
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__DEFAULT:
				return DEFAULT_EDEFAULT == null ? default_ != null : !DEFAULT_EDEFAULT.equals(default_);
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__CHECK:
				return CHECK_EDEFAULT == null ? check != null : !CHECK_EDEFAULT.equals(check);
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__VAR:
				return VAR_EDEFAULT == null ? var != null : !VAR_EDEFAULT.equals(var);
			case DatatypesPackage.PRIMITIVE_DATA_TYPE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //PrimitiveDataTypeImpl
