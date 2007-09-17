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
 * $Id: ResolveInExpImpl.java,v 1.2 2007/09/17 10:17:38 aigdalov Exp $
 */
package org.eclipse.m2m.qvt.oml.expressions.impl;

import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage;
import org.eclipse.m2m.qvt.oml.expressions.ExtendedVisitor;
import org.eclipse.m2m.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.qvt.oml.expressions.ResolveInExp;

import org.eclipse.ocl.expressions.TypeExp;

import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resolve In Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.impl.ResolveInExpImpl#getInMappings <em>In Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResolveInExpImpl extends ResolveExpImpl implements ResolveInExp {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getInMappings() <em>In Mappings</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInMappings()
     * @generated
     * @ordered
     */
    protected EList<MappingOperation> inMappings;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ResolveInExpImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.RESOLVE_IN_EXP;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<MappingOperation> getInMappings() {
        if (inMappings == null) {
            inMappings = new EObjectResolvingEList<MappingOperation>(MappingOperation.class, this, ExpressionsPackage.RESOLVE_IN_EXP__IN_MAPPINGS);
        }
        return inMappings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
        return ((ExtendedVisitor<T, ?, ?, ?, ?>) v).visitResolveInExp(this);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ExpressionsPackage.RESOLVE_IN_EXP__IN_MAPPINGS:
                return getInMappings();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ExpressionsPackage.RESOLVE_IN_EXP__IN_MAPPINGS:
                getInMappings().clear();
                getInMappings().addAll((Collection<? extends MappingOperation>)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case ExpressionsPackage.RESOLVE_IN_EXP__IN_MAPPINGS:
                getInMappings().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ExpressionsPackage.RESOLVE_IN_EXP__IN_MAPPINGS:
                return inMappings != null && !inMappings.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //ResolveInExpImpl
