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

import org.eclipse.ocl.internal.cst.CSTNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Section CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingSectionCS#getStatements <em>Statements</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingSectionCS#getMappingRuleCS <em>Mapping Rule CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getMappingSectionCS()
 * @model abstract="true"
 * @generated
 */
public interface MappingSectionCS extends CSTNode, ElementWithBody {
	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

    /**
	 * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.m2m.qvt.oml.internal.cst.StatementCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statements</em>' containment reference list.
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getMappingSectionCS_Statements()
	 * @model containment="true"
	 * @generated
	 */
	EList<StatementCS> getStatements();

	/**
	 * Returns the value of the '<em><b>Mapping Rule CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Rule CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Rule CS</em>' containment reference.
	 * @see #setMappingRuleCS(MappingRuleCS)
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getMappingSectionCS_MappingRuleCS()
	 * @model containment="true"
	 * @generated
	 */
	MappingRuleCS getMappingRuleCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.internal.cst.MappingSectionCS#getMappingRuleCS <em>Mapping Rule CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Rule CS</em>' containment reference.
	 * @see #getMappingRuleCS()
	 * @generated
	 */
	void setMappingRuleCS(MappingRuleCS value);

} // MappingSectionCS
