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
 * $Id: MappingMethodCS.java,v 1.1 2008/04/06 10:18:40 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.cst.CSTNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Method CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS#getQualifiers <em>Qualifiers</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS#getMappingDeclarationCS <em>Mapping Declaration CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingMethodCS()
 * @model abstract="true"
 * @generated
 */
public interface MappingMethodCS extends CSTNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Qualifiers</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.m2m.internal.qvt.oml.cst.QualifierKindCS}.
	 * The literals are from the enumeration {@link org.eclipse.m2m.internal.qvt.oml.cst.QualifierKindCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualifiers</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualifiers</em>' attribute list.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.QualifierKindCS
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingMethodCS_Qualifiers()
	 * @model unique="false"
	 * @generated
	 */
	EList<QualifierKindCS> getQualifiers();

	/**
	 * Returns the value of the '<em><b>Mapping Declaration CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Declaration CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Declaration CS</em>' containment reference.
	 * @see #setMappingDeclarationCS(MappingDeclarationCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingMethodCS_MappingDeclarationCS()
	 * @model containment="true"
	 * @generated
	 */
	MappingDeclarationCS getMappingDeclarationCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS#getMappingDeclarationCS <em>Mapping Declaration CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Declaration CS</em>' containment reference.
	 * @see #getMappingDeclarationCS()
	 * @generated
	 */
	void setMappingDeclarationCS(MappingDeclarationCS value);

} // MappingMethodCS
