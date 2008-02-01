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
 * $Id: ErrorCSTNode.java,v 1.5 2008/02/01 10:56:01 aigdalov Exp $
 */
package org.eclipse.m2m.qvt.oml.internal.cst.temp;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error CST Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.temp.ErrorCSTNode#getFullStartOffset <em>Full Start Offset</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.internal.cst.temp.ErrorCSTNode#getFullEndOffset <em>Full End Offset</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.internal.cst.temp.TempPackage#getErrorCSTNode()
 * @model
 * @generated
 */
public interface ErrorCSTNode extends EObject {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>Full Start Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Full Start Offset</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Full Start Offset</em>' attribute.
     * @see #setFullStartOffset(int)
     * @see org.eclipse.m2m.qvt.oml.internal.cst.temp.TempPackage#getErrorCSTNode_FullStartOffset()
     * @model
     * @generated
     */
    int getFullStartOffset();

    /**
     * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.internal.cst.temp.ErrorCSTNode#getFullStartOffset <em>Full Start Offset</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Full Start Offset</em>' attribute.
     * @see #getFullStartOffset()
     * @generated
     */
    void setFullStartOffset(int value);

    /**
     * Returns the value of the '<em><b>Full End Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Full End Offset</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Full End Offset</em>' attribute.
     * @see #setFullEndOffset(int)
     * @see org.eclipse.m2m.qvt.oml.internal.cst.temp.TempPackage#getErrorCSTNode_FullEndOffset()
     * @model
     * @generated
     */
    int getFullEndOffset();

    /**
     * Sets the value of the '{@link org.eclipse.m2m.qvt.oml.internal.cst.temp.ErrorCSTNode#getFullEndOffset <em>Full End Offset</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Full End Offset</em>' attribute.
     * @see #getFullEndOffset()
     * @generated
     */
    void setFullEndOffset(int value);

} // ErrorCSTNode
