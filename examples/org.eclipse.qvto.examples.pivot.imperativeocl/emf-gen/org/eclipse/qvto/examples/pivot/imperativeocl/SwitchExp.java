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
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp#getAlternativePart <em>Alternative Part</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp#getElsePart <em>Else Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage#getSwitchExp()
 * @model
 * @generated
 */
public interface SwitchExp extends ImperativeExpression {
	/**
	 * Returns the value of the '<em><b>Alternative Part</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvto.examples.pivot.imperativeocl.AltExp}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alternative Part</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alternative Part</em>' containment reference list.
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage#getSwitchExp_AlternativePart()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='altOwner'"
	 * @generated
	 */
	EList<AltExp> getAlternativePart();

	/**
	 * Returns the value of the '<em><b>Else Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Part</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Part</em>' containment reference.
	 * @see #setElsePart(OCLExpression)
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage#getSwitchExp_ElsePart()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='elsePartOwner'"
	 * @generated
	 */
	OCLExpression getElsePart();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp#getElsePart <em>Else Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Part</em>' containment reference.
	 * @see #getElsePart()
	 * @generated
	 */
	void setElsePart(OCLExpression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model vType="org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLVisitor<R>"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return v.visitSwitchExp(this);'"
	 * @generated
	 */
	<R> R accept(ImperativeOCLVisitor<R> v);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model vType="org.eclipse.ocl.examples.pivot.Visitor<R>"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((ImperativeOCLVisitor<R>)v).visitSwitchExp(this);'"
	 * @generated
	 */
	<R> R accept(Visitor<R> v);

} // SwitchExp
