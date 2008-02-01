/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage;
import org.eclipse.m2m.qvt.oml.expressions.ExtendedVisitor;
import org.eclipse.m2m.qvt.oml.expressions.WhileExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>While Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.impl.WhileExpImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.impl.WhileExpImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.impl.WhileExpImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.impl.WhileExpImpl#getResultVar <em>Result Var</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WhileExpImpl extends ImperativeExpressionImpl implements WhileExp {
	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCondition()
     * @generated
     * @ordered
     */
	protected OCLExpression<EClassifier> condition;

	/**
     * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBody()
     * @generated
     * @ordered
     */
	protected OCLExpression<EClassifier> body;

	/**
     * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getResult()
     * @generated
     * @ordered
     */
	protected OCLExpression<EClassifier> result;

	/**
     * The cached value of the '{@link #getResultVar() <em>Result Var</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getResultVar()
     * @generated
     * @ordered
     */
	protected Variable<EClassifier, EParameter> resultVar;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected WhileExpImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.WHILE_EXP;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpression<EClassifier> getCondition() {
        return condition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetCondition(OCLExpression<EClassifier> newCondition, NotificationChain msgs) {
        OCLExpression<EClassifier> oldCondition = condition;
        condition = newCondition;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.WHILE_EXP__CONDITION, oldCondition, newCondition);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCondition(OCLExpression<EClassifier> newCondition) {
        if (newCondition != condition) {
            NotificationChain msgs = null;
            if (condition != null)
                msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.WHILE_EXP__CONDITION, null, msgs);
            if (newCondition != null)
                msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.WHILE_EXP__CONDITION, null, msgs);
            msgs = basicSetCondition(newCondition, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.WHILE_EXP__CONDITION, newCondition, newCondition));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpression<EClassifier> getBody() {
        return body;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetBody(OCLExpression<EClassifier> newBody, NotificationChain msgs) {
        OCLExpression<EClassifier> oldBody = body;
        body = newBody;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.WHILE_EXP__BODY, oldBody, newBody);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBody(OCLExpression<EClassifier> newBody) {
        if (newBody != body) {
            NotificationChain msgs = null;
            if (body != null)
                msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.WHILE_EXP__BODY, null, msgs);
            if (newBody != null)
                msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.WHILE_EXP__BODY, null, msgs);
            msgs = basicSetBody(newBody, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.WHILE_EXP__BODY, newBody, newBody));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpression<EClassifier> getResult() {
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetResult(OCLExpression<EClassifier> newResult, NotificationChain msgs) {
        OCLExpression<EClassifier> oldResult = result;
        result = newResult;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.WHILE_EXP__RESULT, oldResult, newResult);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setResult(OCLExpression<EClassifier> newResult) {
        if (newResult != result) {
            NotificationChain msgs = null;
            if (result != null)
                msgs = ((InternalEObject)result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.WHILE_EXP__RESULT, null, msgs);
            if (newResult != null)
                msgs = ((InternalEObject)newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.WHILE_EXP__RESULT, null, msgs);
            msgs = basicSetResult(newResult, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.WHILE_EXP__RESULT, newResult, newResult));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Variable<EClassifier, EParameter> getResultVar() {
        return resultVar;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetResultVar(Variable<EClassifier, EParameter> newResultVar, NotificationChain msgs) {
        Variable<EClassifier, EParameter> oldResultVar = resultVar;
        resultVar = newResultVar;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.WHILE_EXP__RESULT_VAR, oldResultVar, newResultVar);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setResultVar(Variable<EClassifier, EParameter> newResultVar) {
        if (newResultVar != resultVar) {
            NotificationChain msgs = null;
            if (resultVar != null)
                msgs = ((InternalEObject)resultVar).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.WHILE_EXP__RESULT_VAR, null, msgs);
            if (newResultVar != null)
                msgs = ((InternalEObject)newResultVar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.WHILE_EXP__RESULT_VAR, null, msgs);
            msgs = basicSetResultVar(newResultVar, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.WHILE_EXP__RESULT_VAR, newResultVar, newResultVar));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
        return ((ExtendedVisitor<T, ?, ?, ?, ?>) v).visitWhileExp(this);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.WHILE_EXP__CONDITION:
                return basicSetCondition(null, msgs);
            case ExpressionsPackage.WHILE_EXP__BODY:
                return basicSetBody(null, msgs);
            case ExpressionsPackage.WHILE_EXP__RESULT:
                return basicSetResult(null, msgs);
            case ExpressionsPackage.WHILE_EXP__RESULT_VAR:
                return basicSetResultVar(null, msgs);
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
            case ExpressionsPackage.WHILE_EXP__CONDITION:
                return getCondition();
            case ExpressionsPackage.WHILE_EXP__BODY:
                return getBody();
            case ExpressionsPackage.WHILE_EXP__RESULT:
                return getResult();
            case ExpressionsPackage.WHILE_EXP__RESULT_VAR:
                return getResultVar();
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
            case ExpressionsPackage.WHILE_EXP__CONDITION:
                setCondition((OCLExpression<EClassifier>)newValue);
                return;
            case ExpressionsPackage.WHILE_EXP__BODY:
                setBody((OCLExpression<EClassifier>)newValue);
                return;
            case ExpressionsPackage.WHILE_EXP__RESULT:
                setResult((OCLExpression<EClassifier>)newValue);
                return;
            case ExpressionsPackage.WHILE_EXP__RESULT_VAR:
                setResultVar((Variable<EClassifier, EParameter>)newValue);
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
            case ExpressionsPackage.WHILE_EXP__CONDITION:
                setCondition((OCLExpression<EClassifier>)null);
                return;
            case ExpressionsPackage.WHILE_EXP__BODY:
                setBody((OCLExpression<EClassifier>)null);
                return;
            case ExpressionsPackage.WHILE_EXP__RESULT:
                setResult((OCLExpression<EClassifier>)null);
                return;
            case ExpressionsPackage.WHILE_EXP__RESULT_VAR:
                setResultVar((Variable<EClassifier, EParameter>)null);
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
            case ExpressionsPackage.WHILE_EXP__CONDITION:
                return condition != null;
            case ExpressionsPackage.WHILE_EXP__BODY:
                return body != null;
            case ExpressionsPackage.WHILE_EXP__RESULT:
                return result != null;
            case ExpressionsPackage.WHILE_EXP__RESULT_VAR:
                return resultVar != null;
        }
        return super.eIsSet(featureID);
    }

} //WhileExpImpl
