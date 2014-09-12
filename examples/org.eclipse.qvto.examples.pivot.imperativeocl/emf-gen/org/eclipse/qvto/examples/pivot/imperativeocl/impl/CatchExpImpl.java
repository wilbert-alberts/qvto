/**
 * <copyright>
 * Copyright (c) 2013 Willink Transformations, University of York, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Adolfo Sanchez-Barbudo (University of York) - Bug397429
 * </copyright>
 */
package org.eclipse.qvto.examples.pivot.imperativeocl.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;

import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage;
import org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Catch Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.CatchExpImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.CatchExpImpl#getException <em>Exception</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.imperativeocl.impl.CatchExpImpl#getExceptionVariable <em>Exception Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CatchExpImpl extends ImperativeExpressionImpl implements CatchExp {
	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected EList<OCLExpression> body;

	/**
	 * The cached value of the '{@link #getException() <em>Exception</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> exception;

	/**
	 * The cached value of the '{@link #getExceptionVariable() <em>Exception Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptionVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable exceptionVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CatchExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeOCLPackage.Literals.CATCH_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OCLExpression> getBody() {
		if (body == null) {
			body = new EObjectContainmentEList<OCLExpression>(OCLExpression.class, this, ImperativeOCLPackage.CATCH_EXP__BODY);
		}
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getException() {
		if (exception == null) {
			exception = new EObjectResolvingEList<Type>(Type.class, this, ImperativeOCLPackage.CATCH_EXP__EXCEPTION);
		}
		return exception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getExceptionVariable() {
		if (exceptionVariable != null && ((EObject)exceptionVariable).eIsProxy()) {
			InternalEObject oldExceptionVariable = (InternalEObject)exceptionVariable;
			exceptionVariable = (Variable)eResolveProxy(oldExceptionVariable);
			if (exceptionVariable != oldExceptionVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImperativeOCLPackage.CATCH_EXP__EXCEPTION_VARIABLE, oldExceptionVariable, exceptionVariable));
			}
		}
		return exceptionVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetExceptionVariable() {
		return exceptionVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExceptionVariable(Variable newExceptionVariable) {
		Variable oldExceptionVariable = exceptionVariable;
		exceptionVariable = newExceptionVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLPackage.CATCH_EXP__EXCEPTION_VARIABLE, oldExceptionVariable, exceptionVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R> R accept(final ImperativeOCLVisitor<R> v) {
		return v.visitCatchExp(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R> R accept(final Visitor<R> v) {
		return ((ImperativeOCLVisitor<R>)v).visitCatchExp(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImperativeOCLPackage.CATCH_EXP__BODY:
				return ((InternalEList<?>)getBody()).basicRemove(otherEnd, msgs);
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
			case ImperativeOCLPackage.CATCH_EXP__BODY:
				return getBody();
			case ImperativeOCLPackage.CATCH_EXP__EXCEPTION:
				return getException();
			case ImperativeOCLPackage.CATCH_EXP__EXCEPTION_VARIABLE:
				if (resolve) return getExceptionVariable();
				return basicGetExceptionVariable();
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
			case ImperativeOCLPackage.CATCH_EXP__BODY:
				getBody().clear();
				getBody().addAll((Collection<? extends OCLExpression>)newValue);
				return;
			case ImperativeOCLPackage.CATCH_EXP__EXCEPTION:
				getException().clear();
				getException().addAll((Collection<? extends Type>)newValue);
				return;
			case ImperativeOCLPackage.CATCH_EXP__EXCEPTION_VARIABLE:
				setExceptionVariable((Variable)newValue);
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
			case ImperativeOCLPackage.CATCH_EXP__BODY:
				getBody().clear();
				return;
			case ImperativeOCLPackage.CATCH_EXP__EXCEPTION:
				getException().clear();
				return;
			case ImperativeOCLPackage.CATCH_EXP__EXCEPTION_VARIABLE:
				setExceptionVariable((Variable)null);
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
			case ImperativeOCLPackage.CATCH_EXP__BODY:
				return body != null && !body.isEmpty();
			case ImperativeOCLPackage.CATCH_EXP__EXCEPTION:
				return exception != null && !exception.isEmpty();
			case ImperativeOCLPackage.CATCH_EXP__EXCEPTION_VARIABLE:
				return exceptionVariable != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings({"rawtypes", "unchecked" })
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ImperativeOCLPackage.CATCH_EXP___ACCEPT__IMPERATIVEOCLVISITOR:
				return accept((ImperativeOCLVisitor)arguments.get(0));
			case ImperativeOCLPackage.CATCH_EXP___ACCEPT__VISITOR:
				return accept((Visitor)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //CatchExpImpl
