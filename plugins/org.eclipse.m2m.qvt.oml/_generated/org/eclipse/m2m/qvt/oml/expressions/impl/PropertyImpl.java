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
package org.eclipse.m2m.qvt.oml.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EParameterImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.m2m.qvt.oml.expressions.ExpressionsPackage;
import org.eclipse.m2m.qvt.oml.expressions.ExtendedVisitor;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.expressions.Property;
import org.eclipse.m2m.qvt.oml.expressions.VisitableASTNode;

import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.eclipse.ocl.utilities.Visitable;
import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.impl.PropertyImpl#getStartPosition <em>Start Position</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.impl.PropertyImpl#getEndPosition <em>End Position</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.expressions.impl.PropertyImpl#getModule <em>Module</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyImpl extends EParameterImpl implements Property {
	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation"; //$NON-NLS-1$

    /**
     * The default value of the '{@link #getStartPosition() <em>Start Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getStartPosition()
     * @generated
     * @ordered
     */
	protected static final int START_POSITION_EDEFAULT = -1;

	/**
     * The cached value of the '{@link #getStartPosition() <em>Start Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getStartPosition()
     * @generated
     * @ordered
     */
	protected int startPosition = START_POSITION_EDEFAULT;

	/**
     * The default value of the '{@link #getEndPosition() <em>End Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEndPosition()
     * @generated
     * @ordered
     */
	protected static final int END_POSITION_EDEFAULT = -1;

	/**
     * The cached value of the '{@link #getEndPosition() <em>End Position</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEndPosition()
     * @generated
     * @ordered
     */
	protected int endPosition = END_POSITION_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PropertyImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.PROPERTY;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getStartPosition() {
        return startPosition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setStartPosition(int newStartPosition) {
        int oldStartPosition = startPosition;
        startPosition = newStartPosition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.PROPERTY__START_POSITION, oldStartPosition, startPosition));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getEndPosition() {
        return endPosition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setEndPosition(int newEndPosition) {
        int oldEndPosition = endPosition;
        endPosition = newEndPosition;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.PROPERTY__END_POSITION, oldEndPosition, endPosition));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Module getModule() {
        if (eContainerFeatureID != ExpressionsPackage.PROPERTY__MODULE) return null;
        return (Module)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetModule(Module newModule, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newModule, ExpressionsPackage.PROPERTY__MODULE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setModule(Module newModule) {
        if (newModule != eInternalContainer() || (eContainerFeatureID != ExpressionsPackage.PROPERTY__MODULE && newModule != null)) {
            if (EcoreUtil.isAncestor(this, newModule))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newModule != null)
                msgs = ((InternalEObject)newModule).eInverseAdd(this, ExpressionsPackage.MODULE__CONFIG_PROPERTY, Module.class, msgs);
            msgs = basicSetModule(newModule, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.PROPERTY__MODULE, newModule, newModule));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
        return ((ExtendedVisitor<T, ?, ?, ?, ?>) v).visitProperty(this);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.PROPERTY__MODULE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetModule((Module)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.PROPERTY__MODULE:
                return basicSetModule(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID) {
            case ExpressionsPackage.PROPERTY__MODULE:
                return eInternalContainer().eInverseRemove(this, ExpressionsPackage.MODULE__CONFIG_PROPERTY, Module.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ExpressionsPackage.PROPERTY__START_POSITION:
                return new Integer(getStartPosition());
            case ExpressionsPackage.PROPERTY__END_POSITION:
                return new Integer(getEndPosition());
            case ExpressionsPackage.PROPERTY__MODULE:
                return getModule();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ExpressionsPackage.PROPERTY__START_POSITION:
                setStartPosition(((Integer)newValue).intValue());
                return;
            case ExpressionsPackage.PROPERTY__END_POSITION:
                setEndPosition(((Integer)newValue).intValue());
                return;
            case ExpressionsPackage.PROPERTY__MODULE:
                setModule((Module)newValue);
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
            case ExpressionsPackage.PROPERTY__START_POSITION:
                setStartPosition(START_POSITION_EDEFAULT);
                return;
            case ExpressionsPackage.PROPERTY__END_POSITION:
                setEndPosition(END_POSITION_EDEFAULT);
                return;
            case ExpressionsPackage.PROPERTY__MODULE:
                setModule((Module)null);
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
            case ExpressionsPackage.PROPERTY__START_POSITION:
                return startPosition != START_POSITION_EDEFAULT;
            case ExpressionsPackage.PROPERTY__END_POSITION:
                return endPosition != END_POSITION_EDEFAULT;
            case ExpressionsPackage.PROPERTY__MODULE:
                return getModule() != null;
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == Visitable.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == ASTNode.class) {
            switch (derivedFeatureID) {
                case ExpressionsPackage.PROPERTY__START_POSITION: return UtilitiesPackage.AST_NODE__START_POSITION;
                case ExpressionsPackage.PROPERTY__END_POSITION: return UtilitiesPackage.AST_NODE__END_POSITION;
                default: return -1;
            }
        }
        if (baseClass == VisitableASTNode.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == Visitable.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == ASTNode.class) {
            switch (baseFeatureID) {
                case UtilitiesPackage.AST_NODE__START_POSITION: return ExpressionsPackage.PROPERTY__START_POSITION;
                case UtilitiesPackage.AST_NODE__END_POSITION: return ExpressionsPackage.PROPERTY__END_POSITION;
                default: return -1;
            }
        }
        if (baseClass == VisitableASTNode.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (startPosition: "); //$NON-NLS-1$
        result.append(startPosition);
        result.append(", endPosition: "); //$NON-NLS-1$
        result.append(endPosition);
        result.append(')');
        return result.toString();
    }

} //PropertyImpl
