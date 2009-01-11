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
 * $Id: ListTypeImpl.java,v 1.2 2009/01/11 23:22:09 radvorak Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.expressions.impl;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOCLPackage;
import org.eclipse.m2m.internal.qvt.oml.expressions.ListType;
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
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getName() {
		if (name == null) {
			StringBuffer nameBuf = new StringBuffer();
			nameBuf.append("List("); //$NON-NLS-1$

			EClassifier elementType = getElementType();
			String elementTypeName;
			if (elementType != null) {
				elementTypeName = elementType.getName();
			} else {
				elementTypeName = ""; //$NON-NLS-1$
			}

			nameBuf.append(elementTypeName);
			nameBuf.append(')');

			name = nameBuf.toString();
		}

		return name;
	}	

} //ListTypeImpl
