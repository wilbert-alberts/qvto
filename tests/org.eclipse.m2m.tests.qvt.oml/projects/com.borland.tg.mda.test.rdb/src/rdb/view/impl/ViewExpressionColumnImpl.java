/**
 * <copyright>
 * </copyright>
 *
 * $Id: ViewExpressionColumnImpl.java,v 1.1 2007/07/29 21:25:32 radvorak Exp $
 */
package rdb.view.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import rdb.Element;

import rdb.view.ViewExpressionColumn;
import rdb.view.ViewPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Column</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link rdb.view.impl.ViewExpressionColumnImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewExpressionColumnImpl extends ViewColumnImpl implements ViewExpressionColumn {
	/**
	 * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
    protected static final String EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
    protected String expression = EXPRESSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ViewExpressionColumnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected EClass eStaticClass() {
		return ViewPackage.eINSTANCE.getViewExpressionColumn();
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setExpression(String newExpression) {
		String oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.VIEW_EXPRESSION_COLUMN__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ViewPackage.VIEW_EXPRESSION_COLUMN__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case ViewPackage.VIEW_EXPRESSION_COLUMN__NAME:
				return getName();
			case ViewPackage.VIEW_EXPRESSION_COLUMN__EXPRESSION:
				return getExpression();
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
			case ViewPackage.VIEW_EXPRESSION_COLUMN__PARENT:
				setParent((Element)newValue);
				return;
			case ViewPackage.VIEW_EXPRESSION_COLUMN__NAME:
				setName((String)newValue);
				return;
			case ViewPackage.VIEW_EXPRESSION_COLUMN__EXPRESSION:
				setExpression((String)newValue);
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
			case ViewPackage.VIEW_EXPRESSION_COLUMN__PARENT:
				setParent((Element)null);
				return;
			case ViewPackage.VIEW_EXPRESSION_COLUMN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ViewPackage.VIEW_EXPRESSION_COLUMN__EXPRESSION:
				setExpression(EXPRESSION_EDEFAULT);
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
			case ViewPackage.VIEW_EXPRESSION_COLUMN__PARENT:
				return parent != null;
			case ViewPackage.VIEW_EXPRESSION_COLUMN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ViewPackage.VIEW_EXPRESSION_COLUMN__EXPRESSION:
				return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
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
		result.append(" (expression: ");
		result.append(expression);
		result.append(')');
		return result.toString();
	}

} //ViewExpressionColumnImpl
