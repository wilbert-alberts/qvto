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
package org.eclipse.qvto.examples.pivot.imperativeocl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unpack Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp#getTargetVariable <em>Target Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage#getUnpackExp()
 * @model
 * @generated
 */
public interface UnpackExp extends ImperativeExpression {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(OCLExpression)
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage#getUnpackExp_Source()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OCLExpression getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Target Variable</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Variable</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Variable</em>' reference list.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage#getUnpackExp_TargetVariable()
	 * @model required="true"
	 * @generated
	 */
	EList<Variable> getTargetVariable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model vType="org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLVisitor<R>"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return v.visitUnpackExp(this);'"
	 * @generated
	 */
	<R> R accept(ImperativeOCLVisitor<R> v);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model vType="org.eclipse.ocl.examples.pivot.Visitor<R>"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((ImperativeOCLVisitor<R>)v).visitUnpackExp(this);'"
	 * @generated
	 */
	<R> R accept(Visitor<R> v);

} // UnpackExp
