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
 * $Id: ImperativeLoopExpImpl.java,v 1.3 2009/01/11 23:22:08 radvorak Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.expressions.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExtendedVisitor;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeLoopExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOCLPackage;
import org.eclipse.ocl.expressions.CallExp;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.LoopExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.util.ExpressionsValidator;
import org.eclipse.ocl.utilities.CallingASTNode;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Imperative Loop Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeLoopExpImpl#getPropertyStartPosition <em>Property Start Position</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeLoopExpImpl#getPropertyEndPosition <em>Property End Position</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeLoopExpImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeLoopExpImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeLoopExpImpl#getIterator <em>Iterator</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeLoopExpImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImperativeLoopExpImpl extends ImperativeExpressionImpl implements ImperativeLoopExp {
    /**
	 * The default value of the '{@link #getPropertyStartPosition() <em>Property Start Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyStartPosition()
	 * @generated
	 * @ordered
	 */
	protected static final int PROPERTY_START_POSITION_EDEFAULT = -1;
	/**
	 * The cached value of the '{@link #getPropertyStartPosition() <em>Property Start Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyStartPosition()
	 * @generated
	 * @ordered
	 */
	protected int propertyStartPosition = PROPERTY_START_POSITION_EDEFAULT;
	/**
	 * The default value of the '{@link #getPropertyEndPosition() <em>Property End Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyEndPosition()
	 * @generated
	 * @ordered
	 */
	protected static final int PROPERTY_END_POSITION_EDEFAULT = -1;
	/**
	 * The cached value of the '{@link #getPropertyEndPosition() <em>Property End Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyEndPosition()
	 * @generated
	 * @ordered
	 */
	protected int propertyEndPosition = PROPERTY_END_POSITION_EDEFAULT;
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression<EClassifier> source;
	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression<EClassifier> body;
	/**
	 * The cached value of the '{@link #getIterator() <em>Iterator</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterator()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable<EClassifier, EParameter>> iterator;
				/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
    protected org.eclipse.ocl.ecore.OCLExpression condition;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ImperativeLoopExpImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return ImperativeOCLPackage.Literals.IMPERATIVE_LOOP_EXP;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPropertyStartPosition() {
		return propertyStartPosition;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyStartPosition(int newPropertyStartPosition) {
		int oldPropertyStartPosition = propertyStartPosition;
		propertyStartPosition = newPropertyStartPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__PROPERTY_START_POSITION, oldPropertyStartPosition, propertyStartPosition));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPropertyEndPosition() {
		return propertyEndPosition;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyEndPosition(int newPropertyEndPosition) {
		int oldPropertyEndPosition = propertyEndPosition;
		propertyEndPosition = newPropertyEndPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__PROPERTY_END_POSITION, oldPropertyEndPosition, propertyEndPosition));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression<EClassifier> getSource() {
		return source;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(OCLExpression<EClassifier> newSource, NotificationChain msgs) {
		OCLExpression<EClassifier> oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(OCLExpression<EClassifier> newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__SOURCE, newSource, newSource));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression<EClassifier> getBody() {
		return body;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(OCLExpression<EClassifier> newBody, NotificationChain msgs) {
		OCLExpression<EClassifier> oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(OCLExpression<EClassifier> newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__BODY, newBody, newBody));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable<EClassifier, EParameter>> getIterator() {
		if (iterator == null) {
			iterator = new EObjectContainmentEList<Variable<EClassifier, EParameter>>(Variable.class, this, ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__ITERATOR);
		}
		return iterator;
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public org.eclipse.ocl.ecore.OCLExpression getCondition() {
		return condition;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(org.eclipse.ocl.ecore.OCLExpression newCondition, NotificationChain msgs) {
		org.eclipse.ocl.ecore.OCLExpression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(org.eclipse.ocl.ecore.OCLExpression newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__CONDITION, newCondition, newCondition));
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
	public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
		if(v instanceof ExtendedVisitor) {
		  @SuppressWarnings("unchecked")    		
		  ExtendedVisitor<T> visitorExt = (ExtendedVisitor) v;    	
		  return visitorExt.visitImperativeLoopExp(this);
		}
		return org.eclipse.m2m.internal.qvt.oml.expressions.util.ForeignVisitorDefaultValue.getDefaultValueForVisitor(v);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean checkSourceCollection(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 ExpressionsValidator.DIAGNOSTIC_SOURCE,
						 ExpressionsValidator.LOOP_EXP__SOURCE_COLLECTION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkSourceCollection", EObjectValidator.getObjectLabel(this, context) }), //$NON-NLS-1$ //$NON-NLS-2$
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean checkLoopVariableInit(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 ExpressionsValidator.DIAGNOSTIC_SOURCE,
						 ExpressionsValidator.LOOP_EXP__LOOP_VARIABLE_INIT,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkLoopVariableInit", EObjectValidator.getObjectLabel(this, context) }), //$NON-NLS-1$ //$NON-NLS-2$
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean checkLoopVariableType(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 ExpressionsValidator.DIAGNOSTIC_SOURCE,
						 ExpressionsValidator.LOOP_EXP__LOOP_VARIABLE_TYPE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkLoopVariableType", EObjectValidator.getObjectLabel(this, context) }), //$NON-NLS-1$ //$NON-NLS-2$
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__SOURCE:
				return basicSetSource(null, msgs);
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__BODY:
				return basicSetBody(null, msgs);
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__ITERATOR:
				return ((InternalEList<?>)getIterator()).basicRemove(otherEnd, msgs);
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__CONDITION:
				return basicSetCondition(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__PROPERTY_START_POSITION:
				return new Integer(getPropertyStartPosition());
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__PROPERTY_END_POSITION:
				return new Integer(getPropertyEndPosition());
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__SOURCE:
				return getSource();
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__BODY:
				return getBody();
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__ITERATOR:
				return getIterator();
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__CONDITION:
				return getCondition();
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
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__PROPERTY_START_POSITION:
				setPropertyStartPosition(((Integer)newValue).intValue());
				return;
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__PROPERTY_END_POSITION:
				setPropertyEndPosition(((Integer)newValue).intValue());
				return;
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__SOURCE:
				setSource((OCLExpression<EClassifier>)newValue);
				return;
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__BODY:
				setBody((OCLExpression<EClassifier>)newValue);
				return;
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__ITERATOR:
				getIterator().clear();
				getIterator().addAll((Collection<? extends Variable<EClassifier, EParameter>>)newValue);
				return;
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__CONDITION:
				setCondition((org.eclipse.ocl.ecore.OCLExpression)newValue);
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
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__PROPERTY_START_POSITION:
				setPropertyStartPosition(PROPERTY_START_POSITION_EDEFAULT);
				return;
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__PROPERTY_END_POSITION:
				setPropertyEndPosition(PROPERTY_END_POSITION_EDEFAULT);
				return;
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__SOURCE:
				setSource((OCLExpression<EClassifier>)null);
				return;
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__BODY:
				setBody((OCLExpression<EClassifier>)null);
				return;
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__ITERATOR:
				getIterator().clear();
				return;
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__CONDITION:
				setCondition((org.eclipse.ocl.ecore.OCLExpression)null);
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
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__PROPERTY_START_POSITION:
				return propertyStartPosition != PROPERTY_START_POSITION_EDEFAULT;
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__PROPERTY_END_POSITION:
				return propertyEndPosition != PROPERTY_END_POSITION_EDEFAULT;
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__SOURCE:
				return source != null;
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__BODY:
				return body != null;
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__ITERATOR:
				return iterator != null && !iterator.isEmpty();
			case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__CONDITION:
				return condition != null;
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
		if (baseClass == CallingASTNode.class) {
			switch (derivedFeatureID) {
				case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__PROPERTY_START_POSITION: return UtilitiesPackage.CALLING_AST_NODE__PROPERTY_START_POSITION;
				case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__PROPERTY_END_POSITION: return UtilitiesPackage.CALLING_AST_NODE__PROPERTY_END_POSITION;
				default: return -1;
			}
		}
		if (baseClass == CallExp.class) {
			switch (derivedFeatureID) {
				case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__SOURCE: return ExpressionsPackage.CALL_EXP__SOURCE;
				default: return -1;
			}
		}
		if (baseClass == org.eclipse.ocl.ecore.CallExp.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == LoopExp.class) {
			switch (derivedFeatureID) {
				case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__BODY: return ExpressionsPackage.LOOP_EXP__BODY;
				case ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__ITERATOR: return ExpressionsPackage.LOOP_EXP__ITERATOR;
				default: return -1;
			}
		}
		if (baseClass == org.eclipse.ocl.ecore.LoopExp.class) {
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
		if (baseClass == CallingASTNode.class) {
			switch (baseFeatureID) {
				case UtilitiesPackage.CALLING_AST_NODE__PROPERTY_START_POSITION: return ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__PROPERTY_START_POSITION;
				case UtilitiesPackage.CALLING_AST_NODE__PROPERTY_END_POSITION: return ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__PROPERTY_END_POSITION;
				default: return -1;
			}
		}
		if (baseClass == CallExp.class) {
			switch (baseFeatureID) {
				case ExpressionsPackage.CALL_EXP__SOURCE: return ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__SOURCE;
				default: return -1;
			}
		}
		if (baseClass == org.eclipse.ocl.ecore.CallExp.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == LoopExp.class) {
			switch (baseFeatureID) {
				case ExpressionsPackage.LOOP_EXP__BODY: return ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__BODY;
				case ExpressionsPackage.LOOP_EXP__ITERATOR: return ImperativeOCLPackage.IMPERATIVE_LOOP_EXP__ITERATOR;
				default: return -1;
			}
		}
		if (baseClass == org.eclipse.ocl.ecore.LoopExp.class) {
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
		result.append(" (propertyStartPosition: "); //$NON-NLS-1$
		result.append(propertyStartPosition);
		result.append(", propertyEndPosition: "); //$NON-NLS-1$
		result.append(propertyEndPosition);
		result.append(')');
		return result.toString();
	}

} //ImperativeLoopExpImpl
