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
package org.eclipse.qvto.examples.pivot.qvtoperational;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.qvto.examples.pivot.qvtoperational.util.QVTOperationalVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contextual Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty#getInitExpression <em>Init Expression</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty#getOverridden <em>Overridden</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getContextualProperty()
 * @model
 * @generated
 */
public interface ContextualProperty extends EObject, Property {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(org.eclipse.ocl.examples.pivot.Class)
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getContextualProperty_Context()
	 * @model required="true"
	 * @generated
	 */
	org.eclipse.ocl.examples.pivot.Class getContext();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(org.eclipse.ocl.examples.pivot.Class value);

	/**
	 * Returns the value of the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Expression</em>' containment reference.
	 * @see #setInitExpression(OCLExpression)
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getContextualProperty_InitExpression()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='ownerProperty'"
	 * @generated
	 */
	OCLExpression getInitExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty#getInitExpression <em>Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Expression</em>' containment reference.
	 * @see #getInitExpression()
	 * @generated
	 */
	void setInitExpression(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Overridden</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overridden</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overridden</em>' reference.
	 * @see #setOverridden(Property)
	 * @see org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage#getContextualProperty_Overridden()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='overriding'"
	 * @generated
	 */
	Property getOverridden();

	/**
	 * Sets the value of the '{@link org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty#getOverridden <em>Overridden</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overridden</em>' reference.
	 * @see #getOverridden()
	 * @generated
	 */
	void setOverridden(Property value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model vType="org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalVisitor<R>"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return v.visitContextualProperty(this);'"
	 * @generated
	 */
	<R> R accept(QVTOperationalVisitor<R> v);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model vType="org.eclipse.ocl.examples.pivot.Visitor<R>"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((QVTOperationalVisitor<R>)v).visitContextualProperty(this);'"
	 * @generated
	 */
	<R> R accept(Visitor<R> v);

} // ContextualProperty
