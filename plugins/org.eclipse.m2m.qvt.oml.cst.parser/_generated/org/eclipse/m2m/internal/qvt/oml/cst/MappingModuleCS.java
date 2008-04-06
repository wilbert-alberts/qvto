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
 * $Id: MappingModuleCS.java,v 1.1 2008/04/06 10:18:40 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.cst.CSTNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Module CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getHeaderCS <em>Header CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getMetamodels <em>Metamodels</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getRenamings <em>Renamings</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getMethods <em>Methods</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingModuleCS()
 * @model
 * @generated
 */
public interface MappingModuleCS extends CSTNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Header CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header CS</em>' containment reference.
	 * @see #setHeaderCS(TransformationHeaderCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingModuleCS_HeaderCS()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TransformationHeaderCS getHeaderCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS#getHeaderCS <em>Header CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header CS</em>' containment reference.
	 * @see #getHeaderCS()
	 * @generated
	 */
	void setHeaderCS(TransformationHeaderCS value);

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.internal.qvt.oml.cst.ImportCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingModuleCS_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<ImportCS> getImports();

	/**
	 * Returns the value of the '<em><b>Metamodels</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodels</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodels</em>' containment reference list.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingModuleCS_Metamodels()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelTypeCS> getMetamodels();

	/**
	 * Returns the value of the '<em><b>Renamings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.internal.qvt.oml.cst.RenameCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Renamings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Renamings</em>' containment reference list.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingModuleCS_Renamings()
	 * @model containment="true"
	 * @generated
	 */
	EList<RenameCS> getRenamings();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.internal.qvt.oml.cst.ModulePropertyCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingModuleCS_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModulePropertyCS> getProperties();

	/**
	 * Returns the value of the '<em><b>Methods</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' containment reference list.
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingModuleCS_Methods()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingMethodCS> getMethods();

} // MappingModuleCS
