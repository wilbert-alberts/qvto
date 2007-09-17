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
 * $Id: BlockExp.java,v 1.2 2007/09/17 10:17:38 aigdalov Exp $
 */
package org.eclipse.m2m.qvt.oml.expressions;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClassifier;

import org.eclipse.ocl.expressions.OCLExpression;

import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.BlockExp#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getBlockExp()
 * @model
 * @generated
 */
public interface BlockExp extends ImperativeExpression {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation"; //$NON-NLS-1$

	/**
     * Returns the value of the '<em><b>Body</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.ocl.expressions.OCLExpression}&lt;org.eclipse.emf.ecore.EClassifier>.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Body</em>' containment reference list.
     * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getBlockExp_Body()
     * @model containment="true"
     * @generated
     */
	EList<OCLExpression<EClassifier>> getBody();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((<%org.eclipse.m2m.qvt.oml.expressions.ExtendedVisitor%><T, ?, ?, ?, ?>) v).visitBlockExp(this);'"
     * @generated
     */
	<T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v);

} // BlockExp
