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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage;
import org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Break Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class BreakExpImpl extends ImperativeExpressionImpl implements BreakExp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BreakExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeOCLPackage.Literals.BREAK_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R> R accept(final ImperativeOCLVisitor<R> v) {
		return v.visitBreakExp(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R> R accept(final Visitor<R> v) {
		return ((ImperativeOCLVisitor<R>)v).visitBreakExp(this);
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
			case ImperativeOCLPackage.BREAK_EXP___ACCEPT__IMPERATIVEOCLVISITOR:
				return accept((ImperativeOCLVisitor)arguments.get(0));
			case ImperativeOCLPackage.BREAK_EXP___ACCEPT__VISITOR:
				return accept((Visitor)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //BreakExpImpl
