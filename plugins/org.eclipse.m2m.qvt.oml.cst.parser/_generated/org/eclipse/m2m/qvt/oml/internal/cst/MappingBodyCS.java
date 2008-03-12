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
 * $Id: MappingBodyCS.java,v 1.1 2008/03/12 11:48:03 sboyko Exp $
 */
package org.eclipse.m2m.qvt.oml.internal.cst;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.cst.OCLExpressionCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Body CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingBodyCS#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingBodyCS#isHasImplicitObjectExp <em>Has Implicit Object Exp</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingBodyCS#isHasPopulationSection <em>Has Population Section</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getMappingBodyCS()
 * @model
 * @generated
 */
public interface MappingBodyCS extends OCLExpressionCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Content</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.cst.OCLExpressionCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' containment reference list.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getMappingBodyCS_Content()
	 * @model containment="true"
	 * @generated
	 */
	EList<OCLExpressionCS> getContent();

	/**
	 * Returns the value of the '<em><b>Has Implicit Object Exp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Implicit Object Exp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Implicit Object Exp</em>' attribute.
	 * @see #setHasImplicitObjectExp(boolean)
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getMappingBodyCS_HasImplicitObjectExp()
	 * @model
	 * @generated
	 */
	boolean isHasImplicitObjectExp();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingBodyCS#isHasImplicitObjectExp <em>Has Implicit Object Exp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Implicit Object Exp</em>' attribute.
	 * @see #isHasImplicitObjectExp()
	 * @generated
	 */
	void setHasImplicitObjectExp(boolean value);

	/**
	 * Returns the value of the '<em><b>Has Population Section</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Population Section</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Population Section</em>' attribute.
	 * @see #setHasPopulationSection(boolean)
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getMappingBodyCS_HasPopulationSection()
	 * @model
	 * @generated
	 */
	boolean isHasPopulationSection();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingBodyCS#isHasPopulationSection <em>Has Population Section</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Population Section</em>' attribute.
	 * @see #isHasPopulationSection()
	 * @generated
	 */
	void setHasPopulationSection(boolean value);

} // MappingBodyCS
