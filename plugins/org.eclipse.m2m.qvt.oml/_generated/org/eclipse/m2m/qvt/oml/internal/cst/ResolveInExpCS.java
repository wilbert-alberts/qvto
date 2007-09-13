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
 * $Id: ResolveInExpCS.java,v 1.3 2007/09/13 11:39:51 sboyko Exp $
 */
package org.eclipse.m2m.qvt.oml.internal.cst;

import org.eclipse.ocl.internal.cst.TypeCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resolve In Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.ResolveInExpCS#getInMappingType <em>In Mapping Type</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.ResolveInExpCS#getInMappingName <em>In Mapping Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getResolveInExpCS()
 * @model
 * @generated
 */
public interface ResolveInExpCS extends ResolveExpCS {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

    /**
	 * Returns the value of the '<em><b>In Mapping Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>In Mapping Type</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>In Mapping Type</em>' containment reference.
	 * @see #setInMappingType(TypeCS)
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getResolveInExpCS_InMappingType()
	 * @model containment="true" required="true"
	 * @generated
	 */
    TypeCS getInMappingType();

    /**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.internal.cst.ResolveInExpCS#getInMappingType <em>In Mapping Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Mapping Type</em>' containment reference.
	 * @see #getInMappingType()
	 * @generated
	 */
    void setInMappingType(TypeCS value);

    /**
	 * Returns the value of the '<em><b>In Mapping Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>In Mapping Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>In Mapping Name</em>' attribute.
	 * @see #setInMappingName(String)
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getResolveInExpCS_InMappingName()
	 * @model default="" required="true"
	 * @generated
	 */
    String getInMappingName();

    /**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.internal.cst.ResolveInExpCS#getInMappingName <em>In Mapping Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Mapping Name</em>' attribute.
	 * @see #getInMappingName()
	 * @generated
	 */
    void setInMappingName(String value);

} // ResolveInExpCS
