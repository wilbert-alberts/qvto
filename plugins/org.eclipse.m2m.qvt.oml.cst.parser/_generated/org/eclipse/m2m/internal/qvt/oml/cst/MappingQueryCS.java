/**
 * Copyright (c) 2007, 2010 Borland Software Corporation and others.
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
 * $Id: MappingQueryCS.java,v 1.4 2010/01/29 15:23:42 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.cst.OCLExpressionCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Query CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS#getExpressions <em>Expressions</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS#isIsSimpleDefinition <em>Is Simple Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingQueryCS()
 * @model
 * @generated
 */
public interface MappingQueryCS extends MappingMethodCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.cst.OCLExpressionCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions</em>' containment reference list.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingQueryCS_Expressions()
	 * @model containment="true"
	 * @generated
	 */
	EList<OCLExpressionCS> getExpressions();

	/**
	 * Returns the value of the '<em><b>Is Simple Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Simple Definition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Simple Definition</em>' attribute.
	 * @see #setIsSimpleDefinition(boolean)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingQueryCS_IsSimpleDefinition()
	 * @model
	 * @generated
	 */
	boolean isIsSimpleDefinition();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS#isIsSimpleDefinition <em>Is Simple Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Simple Definition</em>' attribute.
	 * @see #isIsSimpleDefinition()
	 * @generated
	 */
	void setIsSimpleDefinition(boolean value);

} // MappingQueryCS
