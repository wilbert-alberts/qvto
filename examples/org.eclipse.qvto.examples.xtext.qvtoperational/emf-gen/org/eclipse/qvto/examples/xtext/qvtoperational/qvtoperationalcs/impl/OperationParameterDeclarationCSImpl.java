/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.xtext.base.basecs.impl.ParameterCSImpl;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationParameterDeclarationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Parameter Declaration CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.OperationParameterDeclarationCSImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.OperationParameterDeclarationCSImpl#getInitPart <em>Init Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationParameterDeclarationCSImpl extends ParameterCSImpl implements OperationParameterDeclarationCS {
	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final DirectionKindCS DIRECTION_EDEFAULT = DirectionKindCS.IN;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected DirectionKindCS direction = DIRECTION_EDEFAULT;

	/**
	 * This is true if the Direction attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean directionESet;

	/**
	 * The cached value of the '{@link #getInitPart() <em>Init Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitPart()
	 * @generated
	 * @ordered
	 */
	protected InitPartCS initPart;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationParameterDeclarationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalCSPackage.Literals.OPERATION_PARAMETER_DECLARATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionKindCS getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(DirectionKindCS newDirection) {
		DirectionKindCS oldDirection = direction;
		direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
		boolean oldDirectionESet = directionESet;
		directionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.OPERATION_PARAMETER_DECLARATION_CS__DIRECTION, oldDirection, direction, !oldDirectionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDirection() {
		DirectionKindCS oldDirection = direction;
		boolean oldDirectionESet = directionESet;
		direction = DIRECTION_EDEFAULT;
		directionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, QVTOperationalCSPackage.OPERATION_PARAMETER_DECLARATION_CS__DIRECTION, oldDirection, DIRECTION_EDEFAULT, oldDirectionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDirection() {
		return directionESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitPartCS getInitPart() {
		return initPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitPart(InitPartCS newInitPart, NotificationChain msgs) {
		InitPartCS oldInitPart = initPart;
		initPart = newInitPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.OPERATION_PARAMETER_DECLARATION_CS__INIT_PART, oldInitPart, newInitPart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitPart(InitPartCS newInitPart) {
		if (newInitPart != initPart) {
			NotificationChain msgs = null;
			if (initPart != null)
				msgs = ((InternalEObject)initPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.OPERATION_PARAMETER_DECLARATION_CS__INIT_PART, null, msgs);
			if (newInitPart != null)
				msgs = ((InternalEObject)newInitPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.OPERATION_PARAMETER_DECLARATION_CS__INIT_PART, null, msgs);
			msgs = basicSetInitPart(newInitPart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.OPERATION_PARAMETER_DECLARATION_CS__INIT_PART, newInitPart, newInitPart));
	}

	/**
	 * The cached invocation delegate for the '{@link #ast() <em>Ast</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ast()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate AST__EINVOCATION_DELEGATE = ((EOperation.Internal)QVTOperationalCSPackage.Literals.OPERATION_PARAMETER_DECLARATION_CS.getEOperations().get(0)).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VarParameter ast() {
		try {
			return (VarParameter)AST__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final QVTOperationalCSVisitor<R> v) {
		return v.visitOperationParameterDeclarationCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final BaseCSVisitor<R> v) {
		return ((QVTOperationalCSVisitor<R>)v).visitOperationParameterDeclarationCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalCSPackage.OPERATION_PARAMETER_DECLARATION_CS__INIT_PART:
				return basicSetInitPart(null, msgs);
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
			case QVTOperationalCSPackage.OPERATION_PARAMETER_DECLARATION_CS__DIRECTION:
				return getDirection();
			case QVTOperationalCSPackage.OPERATION_PARAMETER_DECLARATION_CS__INIT_PART:
				return getInitPart();
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
			case QVTOperationalCSPackage.OPERATION_PARAMETER_DECLARATION_CS__DIRECTION:
				setDirection((DirectionKindCS)newValue);
				return;
			case QVTOperationalCSPackage.OPERATION_PARAMETER_DECLARATION_CS__INIT_PART:
				setInitPart((InitPartCS)newValue);
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
			case QVTOperationalCSPackage.OPERATION_PARAMETER_DECLARATION_CS__DIRECTION:
				unsetDirection();
				return;
			case QVTOperationalCSPackage.OPERATION_PARAMETER_DECLARATION_CS__INIT_PART:
				setInitPart((InitPartCS)null);
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
			case QVTOperationalCSPackage.OPERATION_PARAMETER_DECLARATION_CS__DIRECTION:
				return isSetDirection();
			case QVTOperationalCSPackage.OPERATION_PARAMETER_DECLARATION_CS__INIT_PART:
				return initPart != null;
		}
		return super.eIsSet(featureID);
	}


} //OperationParameterDeclarationCSImpl
