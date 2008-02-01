/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.internal.cst;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.TypeCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Declaration CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getContextType <em>Context Type</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getContextTypeAndName <em>Context Type And Name</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#isBlackBox <em>Black Box</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getDirectionKindCS <em>Direction Kind CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getMappingDeclarationCS()
 * @model
 * @generated
 */
public interface MappingDeclarationCS extends CSTNode {
	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Name CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Simple Name CS</em>' containment reference.
     * @see #setSimpleNameCS(SimpleNameCS)
     * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getMappingDeclarationCS_SimpleNameCS()
     * @model containment="true"
     * @generated
     */
	SimpleNameCS getSimpleNameCS();

	/**
     * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getSimpleNameCS <em>Simple Name CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Simple Name CS</em>' containment reference.
     * @see #getSimpleNameCS()
     * @generated
     */
	void setSimpleNameCS(SimpleNameCS value);

	/**
     * Returns the value of the '<em><b>Context Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Context Type</em>' containment reference.
     * @see #setContextType(TypeCS)
     * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getMappingDeclarationCS_ContextType()
     * @model containment="true"
     * @generated
     */
	TypeCS getContextType();

	/**
     * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getContextType <em>Context Type</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Context Type</em>' containment reference.
     * @see #getContextType()
     * @generated
     */
	void setContextType(TypeCS value);

	/**
     * Returns the value of the '<em><b>Context Type And Name</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Type And Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Context Type And Name</em>' containment reference.
     * @see #setContextTypeAndName(TypeCS)
     * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getMappingDeclarationCS_ContextTypeAndName()
     * @model containment="true"
     * @generated
     */
	TypeCS getContextTypeAndName();

	/**
     * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getContextTypeAndName <em>Context Type And Name</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Context Type And Name</em>' containment reference.
     * @see #getContextTypeAndName()
     * @generated
     */
	void setContextTypeAndName(TypeCS value);

	/**
     * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.m2m.qvt.oml.internal.cst.ParameterDeclarationCS}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Parameters</em>' containment reference list.
     * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getMappingDeclarationCS_Parameters()
     * @model containment="true"
     * @generated
     */
	EList<ParameterDeclarationCS> getParameters();

	/**
     * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Return Type</em>' containment reference.
     * @see #setReturnType(TypeSpecCS)
     * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getMappingDeclarationCS_ReturnType()
     * @model containment="true"
     * @generated
     */
	TypeSpecCS getReturnType();

	/**
     * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getReturnType <em>Return Type</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Return Type</em>' containment reference.
     * @see #getReturnType()
     * @generated
     */
	void setReturnType(TypeSpecCS value);

	/**
     * Returns the value of the '<em><b>Black Box</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Black Box</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Black Box</em>' attribute.
     * @see #setBlackBox(boolean)
     * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getMappingDeclarationCS_BlackBox()
     * @model
     * @generated
     */
	boolean isBlackBox();

	/**
     * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#isBlackBox <em>Black Box</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Black Box</em>' attribute.
     * @see #isBlackBox()
     * @generated
     */
	void setBlackBox(boolean value);

	/**
     * Returns the value of the '<em><b>Direction Kind CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction Kind CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Direction Kind CS</em>' containment reference.
     * @see #setDirectionKindCS(DirectionKindCS)
     * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getMappingDeclarationCS_DirectionKindCS()
     * @model containment="true"
     * @generated
     */
	DirectionKindCS getDirectionKindCS();

	/**
     * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingDeclarationCS#getDirectionKindCS <em>Direction Kind CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Direction Kind CS</em>' containment reference.
     * @see #getDirectionKindCS()
     * @generated
     */
	void setDirectionKindCS(DirectionKindCS value);

} // MappingDeclarationCS
