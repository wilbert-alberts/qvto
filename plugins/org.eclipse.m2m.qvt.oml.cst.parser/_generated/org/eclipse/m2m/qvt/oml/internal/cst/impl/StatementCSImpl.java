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
 * 
 *
 * $Id: StatementCSImpl.java,v 1.1 2008/03/12 11:48:04 sboyko Exp $
 */
package org.eclipse.m2m.qvt.oml.internal.cst.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage;
import org.eclipse.m2m.qvt.oml.internal.cst.StatementCS;

import org.eclipse.ocl.cst.impl.OCLExpressionCSImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statement CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class StatementCSImpl extends OCLExpressionCSImpl implements StatementCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatementCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.STATEMENT_CS;
	}

} //StatementCSImpl
