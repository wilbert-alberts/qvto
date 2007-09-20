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
 * $Id: TempFactoryImpl.java,v 1.5 2007/09/20 10:14:06 aigdalov Exp $
 */
package org.eclipse.m2m.qvt.oml.internal.cst.temp.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.m2m.qvt.oml.internal.cst.temp.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TempFactoryImpl extends EFactoryImpl implements TempFactory {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static TempFactory init() {
        try {
            TempFactory theTempFactory = (TempFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/QVT2/1.0.0/Operational/cst/temp"); //$NON-NLS-1$ 
            if (theTempFactory != null) {
                return theTempFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new TempFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TempFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case TempPackage.ERROR_CALL_EXP_CS: return createErrorCallExpCS();
            case TempPackage.RESOLVE_OP_ARGS_EXP_CS: return createResolveOpArgsExpCS();
            case TempPackage.SCOPED_NAME_CS: return createScopedNameCS();
            case TempPackage.ERROR_VARIABLE_INITIALIZATION_CS: return createErrorVariableInitializationCS();
            case TempPackage.ERROR_OUT_EXP_CS: return createErrorOutExpCS();
            case TempPackage.ERROR_CST_NODE: return createErrorCSTNode();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ErrorCallExpCS createErrorCallExpCS() {
        ErrorCallExpCSImpl errorCallExpCS = new ErrorCallExpCSImpl();
        return errorCallExpCS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResolveOpArgsExpCS createResolveOpArgsExpCS() {
        ResolveOpArgsExpCSImpl resolveOpArgsExpCS = new ResolveOpArgsExpCSImpl();
        return resolveOpArgsExpCS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ScopedNameCS createScopedNameCS() {
        ScopedNameCSImpl scopedNameCS = new ScopedNameCSImpl();
        return scopedNameCS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ErrorVariableInitializationCS createErrorVariableInitializationCS() {
        ErrorVariableInitializationCSImpl errorVariableInitializationCS = new ErrorVariableInitializationCSImpl();
        return errorVariableInitializationCS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ErrorOutExpCS createErrorOutExpCS() {
        ErrorOutExpCSImpl errorOutExpCS = new ErrorOutExpCSImpl();
        return errorOutExpCS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ErrorCSTNode createErrorCSTNode() {
        ErrorCSTNodeImpl errorCSTNode = new ErrorCSTNodeImpl();
        return errorCSTNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TempPackage getTempPackage() {
        return (TempPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static TempPackage getPackage() {
        return TempPackage.eINSTANCE;
    }

} //TempFactoryImpl
