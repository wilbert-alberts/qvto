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
 * $Id: MappingRuleCS.java,v 1.4 2010/01/29 15:23:42 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst;

import org.eclipse.ocl.cst.OCLExpressionCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Rule CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS#getMappingBody <em>Mapping Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingRuleCS()
 * @model
 * @generated
 */
public interface MappingRuleCS extends MappingMethodCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard</em>' containment reference.
	 * @see #setGuard(OCLExpressionCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingRuleCS_Guard()
	 * @model containment="true"
	 * @generated
	 */
	OCLExpressionCS getGuard();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS#getGuard <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' containment reference.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(OCLExpressionCS value);

	/**
	 * Returns the value of the '<em><b>Mapping Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Body</em>' containment reference.
	 * @see #setMappingBody(MappingSectionsCS)
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#getMappingRuleCS_MappingBody()
	 * @model containment="true"
	 * @generated
	 */
	MappingSectionsCS getMappingBody();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS#getMappingBody <em>Mapping Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping Body</em>' containment reference.
	 * @see #getMappingBody()
	 * @generated
	 */
	void setMappingBody(MappingSectionsCS value);

} // MappingRuleCS
