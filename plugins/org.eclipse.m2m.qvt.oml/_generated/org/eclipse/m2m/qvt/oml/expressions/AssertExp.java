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
 * $Id: AssertExp.java,v 1.3 2008/02/15 11:56:27 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.expressions;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.expressions.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assert Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.AssertExp#getAssertion <em>Assertion</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.AssertExp#getLog <em>Log</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.AssertExp#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.AssertExp#getLine <em>Line</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getAssertExp()
 * @model
 * @generated
 */
public interface AssertExp extends ImperativeExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Assertion</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assertion</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assertion</em>' containment reference.
	 * @see #setAssertion(OCLExpression)
	 * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getAssertExp_Assertion()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OCLExpression<EClassifier> getAssertion();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.expressions.AssertExp#getAssertion <em>Assertion</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assertion</em>' containment reference.
	 * @see #getAssertion()
	 * @generated
	 */
	void setAssertion(OCLExpression<EClassifier> value);

	/**
	 * Returns the value of the '<em><b>Log</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log</em>' containment reference.
	 * @see #setLog(LogExp)
	 * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getAssertExp_Log()
	 * @model containment="true"
	 * @generated
	 */
	LogExp getLog();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.expressions.AssertExp#getLog <em>Log</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log</em>' containment reference.
	 * @see #getLog()
	 * @generated
	 */
	void setLog(LogExp value);

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * The default value is <code>"error"</code>.
	 * The literals are from the enumeration {@link org.eclipse.m2m.qvt.oml.expressions.SeverityKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see org.eclipse.m2m.qvt.oml.expressions.SeverityKind
	 * @see #setSeverity(SeverityKind)
	 * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getAssertExp_Severity()
	 * @model default="error" required="true"
	 * @generated
	 */
	SeverityKind getSeverity();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.expressions.AssertExp#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see org.eclipse.m2m.qvt.oml.expressions.SeverityKind
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(SeverityKind value);

	/**
	 * Returns the value of the '<em><b>Line</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line</em>' attribute.
	 * @see #setLine(int)
	 * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getAssertExp_Line()
	 * @model default="-1"
	 * @generated
	 */
	int getLine();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.expressions.AssertExp#getLine <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line</em>' attribute.
	 * @see #getLine()
	 * @generated
	 */
	void setLine(int value);

} // AssertExp
