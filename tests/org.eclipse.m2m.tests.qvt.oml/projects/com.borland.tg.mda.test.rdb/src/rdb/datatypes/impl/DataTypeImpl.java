/**
 * <copyright>
 * </copyright>
 *
 * $Id: DataTypeImpl.java,v 1.1 2007/07/29 21:25:27 radvorak Exp $
 */
package rdb.datatypes.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import rdb.Element;

import rdb.datatypes.DataType;
import rdb.datatypes.DatatypesPackage;

import rdb.impl.NamedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.datatypes.impl.DataTypeImpl#getSize <em>Size</em>}</li>
 *   <li>{@link rdb.datatypes.impl.DataTypeImpl#getDecimalDigits <em>Decimal Digits</em>}</li>
 *   <li>{@link rdb.datatypes.impl.DataTypeImpl#isNullable <em>Nullable</em>}</li>
 *   <li>{@link rdb.datatypes.impl.DataTypeImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link rdb.datatypes.impl.DataTypeImpl#getCheck <em>Check</em>}</li>
 *   <li>{@link rdb.datatypes.impl.DataTypeImpl#getVar <em>Var</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DataTypeImpl extends NamedElementImpl implements DataType {
	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
    protected static final int SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
    protected int size = SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDecimalDigits() <em>Decimal Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDecimalDigits()
	 * @generated
	 * @ordered
	 */
    protected static final int DECIMAL_DIGITS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDecimalDigits() <em>Decimal Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDecimalDigits()
	 * @generated
	 * @ordered
	 */
    protected int decimalDigits = DECIMAL_DIGITS_EDEFAULT;

	/**
	 * The default value of the '{@link #isNullable() <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #isNullable()
	 * @generated
	 * @ordered
	 */
    protected static final boolean NULLABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNullable() <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #isNullable()
	 * @generated
	 * @ordered
	 */
    protected boolean nullable = NULLABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
    protected static final String DEFAULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
    protected String default_ = DEFAULT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCheck() <em>Check</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getCheck()
	 * @generated
	 * @ordered
	 */
    protected static final String CHECK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCheck() <em>Check</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getCheck()
	 * @generated
	 * @ordered
	 */
    protected String check = CHECK_EDEFAULT;

	/**
	 * The default value of the '{@link #getVar() <em>Var</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getVar()
	 * @generated
	 * @ordered
	 */
    protected static final String VAR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVar() <em>Var</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getVar()
	 * @generated
	 * @ordered
	 */
    protected String var = VAR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected DataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected EClass eStaticClass() {
		return DatatypesPackage.eINSTANCE.getDataType();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public int getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setSize(int newSize) {
		int oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.DATA_TYPE__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public int getDecimalDigits() {
		return decimalDigits;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setDecimalDigits(int newDecimalDigits) {
		int oldDecimalDigits = decimalDigits;
		decimalDigits = newDecimalDigits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.DATA_TYPE__DECIMAL_DIGITS, oldDecimalDigits, decimalDigits));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public boolean isNullable() {
		return nullable;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setNullable(boolean newNullable) {
		boolean oldNullable = nullable;
		nullable = newNullable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.DATA_TYPE__NULLABLE, oldNullable, nullable));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setDefault(String newDefault) {
		String oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.DATA_TYPE__DEFAULT, oldDefault, default_));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getCheck() {
		return check;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setCheck(String newCheck) {
		String oldCheck = check;
		check = newCheck;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.DATA_TYPE__CHECK, oldCheck, check));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getVar() {
		return var;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setVar(String newVar) {
		String oldVar = var;
		var = newVar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.DATA_TYPE__VAR, oldVar, var));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case DatatypesPackage.DATA_TYPE__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case DatatypesPackage.DATA_TYPE__NAME:
				return getName();
			case DatatypesPackage.DATA_TYPE__SIZE:
				return new Integer(getSize());
			case DatatypesPackage.DATA_TYPE__DECIMAL_DIGITS:
				return new Integer(getDecimalDigits());
			case DatatypesPackage.DATA_TYPE__NULLABLE:
				return isNullable() ? Boolean.TRUE : Boolean.FALSE;
			case DatatypesPackage.DATA_TYPE__DEFAULT:
				return getDefault();
			case DatatypesPackage.DATA_TYPE__CHECK:
				return getCheck();
			case DatatypesPackage.DATA_TYPE__VAR:
				return getVar();
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
			case DatatypesPackage.DATA_TYPE__PARENT:
				setParent((Element)newValue);
				return;
			case DatatypesPackage.DATA_TYPE__NAME:
				setName((String)newValue);
				return;
			case DatatypesPackage.DATA_TYPE__SIZE:
				setSize(((Integer)newValue).intValue());
				return;
			case DatatypesPackage.DATA_TYPE__DECIMAL_DIGITS:
				setDecimalDigits(((Integer)newValue).intValue());
				return;
			case DatatypesPackage.DATA_TYPE__NULLABLE:
				setNullable(((Boolean)newValue).booleanValue());
				return;
			case DatatypesPackage.DATA_TYPE__DEFAULT:
				setDefault((String)newValue);
				return;
			case DatatypesPackage.DATA_TYPE__CHECK:
				setCheck((String)newValue);
				return;
			case DatatypesPackage.DATA_TYPE__VAR:
				setVar((String)newValue);
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
			case DatatypesPackage.DATA_TYPE__PARENT:
				setParent((Element)null);
				return;
			case DatatypesPackage.DATA_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DatatypesPackage.DATA_TYPE__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case DatatypesPackage.DATA_TYPE__DECIMAL_DIGITS:
				setDecimalDigits(DECIMAL_DIGITS_EDEFAULT);
				return;
			case DatatypesPackage.DATA_TYPE__NULLABLE:
				setNullable(NULLABLE_EDEFAULT);
				return;
			case DatatypesPackage.DATA_TYPE__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case DatatypesPackage.DATA_TYPE__CHECK:
				setCheck(CHECK_EDEFAULT);
				return;
			case DatatypesPackage.DATA_TYPE__VAR:
				setVar(VAR_EDEFAULT);
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
			case DatatypesPackage.DATA_TYPE__PARENT:
				return parent != null;
			case DatatypesPackage.DATA_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DatatypesPackage.DATA_TYPE__SIZE:
				return size != SIZE_EDEFAULT;
			case DatatypesPackage.DATA_TYPE__DECIMAL_DIGITS:
				return decimalDigits != DECIMAL_DIGITS_EDEFAULT;
			case DatatypesPackage.DATA_TYPE__NULLABLE:
				return nullable != NULLABLE_EDEFAULT;
			case DatatypesPackage.DATA_TYPE__DEFAULT:
				return DEFAULT_EDEFAULT == null ? default_ != null : !DEFAULT_EDEFAULT.equals(default_);
			case DatatypesPackage.DATA_TYPE__CHECK:
				return CHECK_EDEFAULT == null ? check != null : !CHECK_EDEFAULT.equals(check);
			case DatatypesPackage.DATA_TYPE__VAR:
				return VAR_EDEFAULT == null ? var != null : !VAR_EDEFAULT.equals(var);
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
		result.append(" (size: ");
		result.append(size);
		result.append(", decimalDigits: ");
		result.append(decimalDigits);
		result.append(", nullable: ");
		result.append(nullable);
		result.append(", default: ");
		result.append(default_);
		result.append(", check: ");
		result.append(check);
		result.append(", var: ");
		result.append(var);
		result.append(')');
		return result.toString();
	}

} //DataTypeImpl
