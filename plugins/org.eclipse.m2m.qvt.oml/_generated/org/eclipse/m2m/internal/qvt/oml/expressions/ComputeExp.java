/**
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *
 * $Id: ComputeExp.java,v 1.5 2009/01/13 16:51:21 radvorak Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.expressions;

import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compute Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.ComputeExp#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.ComputeExp#getReturnedElement <em>Returned Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOCLPackage#getComputeExp()
 * @model
 * @generated
 */
public interface ComputeExp extends ImperativeExpression {
	/**
	 * Returns the value of the '<em><b>Returned Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Returned Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Returned Element</em>' containment reference.
	 * @see #setReturnedElement(Variable)
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOCLPackage#getComputeExp_ReturnedElement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Variable getReturnedElement();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ComputeExp#getReturnedElement <em>Returned Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Returned Element</em>' containment reference.
	 * @see #getReturnedElement()
	 * @generated
	 */
	void setReturnedElement(Variable value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(OCLExpression)
	 * @see org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOCLPackage#getComputeExp_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OCLExpression getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.expressions.ComputeExp#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(OCLExpression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(v instanceof ExtendedVisitor) {\r\n  @SuppressWarnings(\"unchecked\")    \t\t\r\n  ExtendedVisitor<T> visitorExt = (ExtendedVisitor) v;    \t\r\n  return visitorExt.visitComputeExp(this);\r\n}\r\nreturn org.eclipse.m2m.internal.qvt.oml.expressions.util.ForeignVisitorDefaultValue.getDefaultValueForVisitor(v);'"
	 * @generated
	 */
	<T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v);

} // ComputeExp
