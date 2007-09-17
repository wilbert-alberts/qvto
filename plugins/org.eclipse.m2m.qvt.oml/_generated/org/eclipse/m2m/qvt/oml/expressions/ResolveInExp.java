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
 * $Id: ResolveInExp.java,v 1.2 2007/09/17 10:17:38 aigdalov Exp $
 */
package org.eclipse.m2m.qvt.oml.expressions;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;

import org.eclipse.ocl.expressions.TypeExp;

import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resolve In Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.ResolveInExp#getInMappings <em>In Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getResolveInExp()
 * @model
 * @generated
 */
public interface ResolveInExp extends ResolveExp {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation"; //$NON-NLS-1$

    /**
     * Returns the value of the '<em><b>In Mappings</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.m2m.qvt.oml.expressions.MappingOperation}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>In Mappings</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>In Mappings</em>' reference list.
     * @see org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage#getResolveInExp_InMappings()
     * @model
     * @generated
     */
    EList<MappingOperation> getInMappings();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((<%org.eclipse.m2m.qvt.oml.expressions.ExtendedVisitor%><T, ?, ?, ?, ?>) v).visitResolveInExp(this);'"
     * @generated
     */
    <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v);

} // ResolveInExp
