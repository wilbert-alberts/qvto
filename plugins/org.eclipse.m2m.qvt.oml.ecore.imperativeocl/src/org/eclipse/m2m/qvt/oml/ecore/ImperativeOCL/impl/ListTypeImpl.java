/**
 * <copyright>
 * Copyright (c) 2008 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     A. Sanchez-Barbudo  - initial API and implementation
 * </copyright>
 *
 * $Id: ListTypeImpl.java,v 1.1 2008/09/02 20:01:45 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.impl;

import java.util.List;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ListType;
import org.eclipse.ocl.ecore.impl.CollectionTypeImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ListTypeImpl extends CollectionTypeImpl implements ListType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ListTypeImpl() {
		super();
		setInstanceClass(List.class);
 	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeOCLPackage.Literals.LIST_TYPE;
	}

} //ListTypeImpl
