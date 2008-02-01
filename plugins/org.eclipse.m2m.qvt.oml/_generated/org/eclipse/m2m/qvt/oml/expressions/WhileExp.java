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
package org.eclipse.m2m.qvt.oml.expressions;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>While Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.WhileExp#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.WhileExp#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.WhileExp#getResult <em>Result</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.WhileExp#getResultVar <em>Result Var</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getWhileExp()
 * @model
 * @generated
 */
public interface WhileExp extends ImperativeExpression {
	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Condition</em>' containment reference.
     * @see #setCondition(OCLExpression)
     * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getWhileExp_Condition()
     * @model containment="true" required="true"
     * @generated
     */
	OCLExpression<EClassifier> getCondition();

	/**
     * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.expressions.WhileExp#getCondition <em>Condition</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Condition</em>' containment reference.
     * @see #getCondition()
     * @generated
     */
	void setCondition(OCLExpression<EClassifier> value);

	/**
     * Returns the value of the '<em><b>Body</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Body</em>' containment reference.
     * @see #setBody(OCLExpression)
     * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getWhileExp_Body()
     * @model containment="true" required="true"
     * @generated
     */
	OCLExpression<EClassifier> getBody();

	/**
     * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.expressions.WhileExp#getBody <em>Body</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Body</em>' containment reference.
     * @see #getBody()
     * @generated
     */
	void setBody(OCLExpression<EClassifier> value);

	/**
     * Returns the value of the '<em><b>Result</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Result</em>' containment reference.
     * @see #setResult(OCLExpression)
     * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getWhileExp_Result()
     * @model containment="true"
     * @generated
     */
	OCLExpression<EClassifier> getResult();

	/**
     * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.expressions.WhileExp#getResult <em>Result</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Result</em>' containment reference.
     * @see #getResult()
     * @generated
     */
	void setResult(OCLExpression<EClassifier> value);

	/**
     * Returns the value of the '<em><b>Result Var</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Var</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Result Var</em>' containment reference.
     * @see #setResultVar(Variable)
     * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getWhileExp_ResultVar()
     * @model containment="true"
     * @generated
     */
	Variable<EClassifier, EParameter> getResultVar();

	/**
     * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.expressions.WhileExp#getResultVar <em>Result Var</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Result Var</em>' containment reference.
     * @see #getResultVar()
     * @generated
     */
	void setResultVar(Variable<EClassifier, EParameter> value);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((<%org.eclipse.m2m.qvt.oml.expressions.ExtendedVisitor%><T, ?, ?, ?, ?>) v).visitWhileExp(this);'"
     * @generated
     */
	<T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v);

} // WhileExp
