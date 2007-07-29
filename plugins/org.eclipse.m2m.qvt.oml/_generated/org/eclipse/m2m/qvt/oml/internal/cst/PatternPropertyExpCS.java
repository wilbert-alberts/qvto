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

import org.eclipse.ocl.internal.cst.OCLExpressionCS;
import org.eclipse.ocl.internal.cst.SimpleNameCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Property Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.PatternPropertyExpCS#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.PatternPropertyExpCS#getOclExpressionCS <em>Ocl Expression CS</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.PatternPropertyExpCS#isIncremental <em>Incremental</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getPatternPropertyExpCS()
 * @model
 * @generated
 */
public interface PatternPropertyExpCS extends OCLExpressionCS {
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
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getPatternPropertyExpCS_SimpleNameCS()
	 * @model containment="true"
	 * @generated
	 */
	SimpleNameCS getSimpleNameCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.internal.cst.PatternPropertyExpCS#getSimpleNameCS <em>Simple Name CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Name CS</em>' containment reference.
	 * @see #getSimpleNameCS()
	 * @generated
	 */
	void setSimpleNameCS(SimpleNameCS value);

	/**
	 * Returns the value of the '<em><b>Ocl Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocl Expression CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocl Expression CS</em>' containment reference.
	 * @see #setOclExpressionCS(OCLExpressionCS)
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getPatternPropertyExpCS_OclExpressionCS()
	 * @model containment="true"
	 * @generated
	 */
	OCLExpressionCS getOclExpressionCS();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.internal.cst.PatternPropertyExpCS#getOclExpressionCS <em>Ocl Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl Expression CS</em>' containment reference.
	 * @see #getOclExpressionCS()
	 * @generated
	 */
	void setOclExpressionCS(OCLExpressionCS value);

	/**
	 * Returns the value of the '<em><b>Incremental</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incremental</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incremental</em>' attribute.
	 * @see #setIncremental(boolean)
	 * @see org.eclipse.m2m.qvt.oml.internal.cst.CSTPackage#getPatternPropertyExpCS_Incremental()
	 * @model
	 * @generated
	 */
	boolean isIncremental();

	/**
	 * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.internal.cst.PatternPropertyExpCS#isIncremental <em>Incremental</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incremental</em>' attribute.
	 * @see #isIncremental()
	 * @generated
	 */
	void setIncremental(boolean value);

} // PatternPropertyExpCS
