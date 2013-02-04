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

import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alt Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.imperativeocl.AltExp#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.imperativeocl.AltExp#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage#getAltExp()
 * @model
 * @generated
 */
public interface AltExp extends ImperativeExpression {
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
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage#getAltExp_Body()
	 * @model containment="true" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='altBodyOwner'"
	 * @generated
	 */
	OCLExpression getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AltExp#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(OCLExpression value);

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
	 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage#getAltExp_Condition()
	 * @model containment="true" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='altCondOwner'"
	 * @generated
	 */
	OCLExpression getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.imperativeocl.AltExp#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(OCLExpression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model vType="org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLVisitor<R>"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return v.visitAltExp(this);'"
	 * @generated
	 */
	<R> R accept(ImperativeOCLVisitor<R> v);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model vType="org.eclipse.ocl.examples.pivot.Visitor<R>"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((ImperativeOCLVisitor<R>)v).visitAltExp(this);'"
	 * @generated
	 */
	<R> R accept(Visitor<R> v);

} // AltExp
