/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;

import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamDirection;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Param CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ParamCSImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ParamCSImpl#getPathName <em>Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ParamCSImpl#getTypespec <em>Typespec</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ParamCSImpl#getInitPart <em>Init Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParamCSImpl extends MinimalEObjectImpl.Container implements ParamCS
{
  /**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
  protected static final ParamDirection DIRECTION_EDEFAULT = ParamDirection.IN;

  /**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
  protected ParamDirection direction = DIRECTION_EDEFAULT;

  /**
	 * The cached value of the '{@link #getPathName() <em>Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getPathName()
	 * @generated
	 * @ordered
	 */
  protected PathNameCS pathName;

  /**
	 * The cached value of the '{@link #getTypespec() <em>Typespec</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTypespec()
	 * @generated
	 * @ordered
	 */
  protected TypedRefCS typespec;

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
  protected ParamCSImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass()
  {
		return QvtoperationalcsPackage.Literals.PARAM_CS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ParamDirection getDirection()
  {
		return direction;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setDirection(ParamDirection newDirection)
  {
		ParamDirection oldDirection = direction;
		direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.PARAM_CS__DIRECTION, oldDirection, direction));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PathNameCS getPathName()
  {
		return pathName;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetPathName(PathNameCS newPathName, NotificationChain msgs)
  {
		PathNameCS oldPathName = pathName;
		pathName = newPathName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.PARAM_CS__PATH_NAME, oldPathName, newPathName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setPathName(PathNameCS newPathName)
  {
		if (newPathName != pathName) {
			NotificationChain msgs = null;
			if (pathName != null)
				msgs = ((InternalEObject)pathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.PARAM_CS__PATH_NAME, null, msgs);
			if (newPathName != null)
				msgs = ((InternalEObject)newPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.PARAM_CS__PATH_NAME, null, msgs);
			msgs = basicSetPathName(newPathName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.PARAM_CS__PATH_NAME, newPathName, newPathName));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TypedRefCS getTypespec()
  {
		return typespec;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetTypespec(TypedRefCS newTypespec, NotificationChain msgs)
  {
		TypedRefCS oldTypespec = typespec;
		typespec = newTypespec;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.PARAM_CS__TYPESPEC, oldTypespec, newTypespec);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTypespec(TypedRefCS newTypespec)
  {
		if (newTypespec != typespec) {
			NotificationChain msgs = null;
			if (typespec != null)
				msgs = ((InternalEObject)typespec).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.PARAM_CS__TYPESPEC, null, msgs);
			if (newTypespec != null)
				msgs = ((InternalEObject)newTypespec).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.PARAM_CS__TYPESPEC, null, msgs);
			msgs = basicSetTypespec(newTypespec, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.PARAM_CS__TYPESPEC, newTypespec, newTypespec));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public InitPartCS getInitPart()
  {
		return initPart;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetInitPart(InitPartCS newInitPart, NotificationChain msgs)
  {
		InitPartCS oldInitPart = initPart;
		initPart = newInitPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.PARAM_CS__INIT_PART, oldInitPart, newInitPart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setInitPart(InitPartCS newInitPart)
  {
		if (newInitPart != initPart) {
			NotificationChain msgs = null;
			if (initPart != null)
				msgs = ((InternalEObject)initPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.PARAM_CS__INIT_PART, null, msgs);
			if (newInitPart != null)
				msgs = ((InternalEObject)newInitPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.PARAM_CS__INIT_PART, null, msgs);
			msgs = basicSetInitPart(newInitPart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.PARAM_CS__INIT_PART, newInitPart, newInitPart));
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R> R accept(final QVTOperationalCSVisitor<R> v) {
		return v.visitParamCS(this);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R> R accept(final BaseCSVisitor<R> v) {
		return ((QVTOperationalCSVisitor<R>)v).visitParamCS(this);
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case QvtoperationalcsPackage.PARAM_CS__PATH_NAME:
				return basicSetPathName(null, msgs);
			case QvtoperationalcsPackage.PARAM_CS__TYPESPEC:
				return basicSetTypespec(null, msgs);
			case QvtoperationalcsPackage.PARAM_CS__INIT_PART:
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
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case QvtoperationalcsPackage.PARAM_CS__DIRECTION:
				return getDirection();
			case QvtoperationalcsPackage.PARAM_CS__PATH_NAME:
				return getPathName();
			case QvtoperationalcsPackage.PARAM_CS__TYPESPEC:
				return getTypespec();
			case QvtoperationalcsPackage.PARAM_CS__INIT_PART:
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
  public void eSet(int featureID, Object newValue)
  {
		switch (featureID) {
			case QvtoperationalcsPackage.PARAM_CS__DIRECTION:
				setDirection((ParamDirection)newValue);
				return;
			case QvtoperationalcsPackage.PARAM_CS__PATH_NAME:
				setPathName((PathNameCS)newValue);
				return;
			case QvtoperationalcsPackage.PARAM_CS__TYPESPEC:
				setTypespec((TypedRefCS)newValue);
				return;
			case QvtoperationalcsPackage.PARAM_CS__INIT_PART:
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
  public void eUnset(int featureID)
  {
		switch (featureID) {
			case QvtoperationalcsPackage.PARAM_CS__DIRECTION:
				setDirection(DIRECTION_EDEFAULT);
				return;
			case QvtoperationalcsPackage.PARAM_CS__PATH_NAME:
				setPathName((PathNameCS)null);
				return;
			case QvtoperationalcsPackage.PARAM_CS__TYPESPEC:
				setTypespec((TypedRefCS)null);
				return;
			case QvtoperationalcsPackage.PARAM_CS__INIT_PART:
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
  public boolean eIsSet(int featureID)
  {
		switch (featureID) {
			case QvtoperationalcsPackage.PARAM_CS__DIRECTION:
				return direction != DIRECTION_EDEFAULT;
			case QvtoperationalcsPackage.PARAM_CS__PATH_NAME:
				return pathName != null;
			case QvtoperationalcsPackage.PARAM_CS__TYPESPEC:
				return typespec != null;
			case QvtoperationalcsPackage.PARAM_CS__INIT_PART:
				return initPart != null;
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString()
  {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (direction: ");
		result.append(direction);
		result.append(')');
		return result.toString();
	}

} //ParamCSImpl
