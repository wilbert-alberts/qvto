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

import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Break Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage#getBreakExp()
 * @model
 * @generated
 */
public interface BreakExp extends ImperativeExpression {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model vType="org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLVisitor<R>"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return v.visitBreakExp(this);'"
	 * @generated
	 */
	<R> R accept(ImperativeOCLVisitor<R> v);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model vType="org.eclipse.ocl.examples.pivot.Visitor<R>"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((ImperativeOCLVisitor<R>)v).visitBreakExp(this);'"
	 * @generated
	 */
	<R> R accept(Visitor<R> v);
} // BreakExp
