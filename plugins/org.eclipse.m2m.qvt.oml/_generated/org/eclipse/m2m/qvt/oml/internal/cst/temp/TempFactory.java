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
 * $Id: TempFactory.java,v 1.2 2007/08/17 15:59:13 aigdalov Exp $
 */
package org.eclipse.m2m.qvt.oml.internal.cst.temp;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.qvt.oml.internal.cst.temp.TempPackage
 * @generated
 */
public interface TempFactory extends EFactory {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    TempFactory eINSTANCE = org.eclipse.m2m.qvt.oml.internal.cst.temp.impl.TempFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Error Call Exp CS</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Error Call Exp CS</em>'.
     * @generated
     */
    ErrorCallExpCS createErrorCallExpCS();

    /**
     * Returns a new object of class '<em>Resolve Op Args Exp CS</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Resolve Op Args Exp CS</em>'.
     * @generated
     */
    ResolveOpArgsExpCS createResolveOpArgsExpCS();

    /**
     * Returns a new object of class '<em>Scoped Name CS</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Scoped Name CS</em>'.
     * @generated
     */
    ScopedNameCS createScopedNameCS();

    /**
     * Returns a new object of class '<em>Error Variable Initialization CS</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Error Variable Initialization CS</em>'.
     * @generated
     */
    ErrorVariableInitializationCS createErrorVariableInitializationCS();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    TempPackage getTempPackage();

} //TempFactory
