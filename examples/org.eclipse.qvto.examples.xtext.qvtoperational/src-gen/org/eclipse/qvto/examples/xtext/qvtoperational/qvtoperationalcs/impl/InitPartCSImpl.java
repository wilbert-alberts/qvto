/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;

import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitOp;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Init Part CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.InitPartCSImpl#getInitOp <em>Init Op</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.InitPartCSImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InitPartCSImpl extends MinimalEObjectImpl.Container implements InitPartCS
{
  /**
   * The default value of the '{@link #getInitOp() <em>Init Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitOp()
   * @generated
   * @ordered
   */
  protected static final InitOp INIT_OP_EDEFAULT = InitOp.EQUALS;

  /**
   * The cached value of the '{@link #getInitOp() <em>Init Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitOp()
   * @generated
   * @ordered
   */
  protected InitOp initOp = INIT_OP_EDEFAULT;

  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected ExpCS expression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InitPartCSImpl()
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
    return QvtoperationalcsPackage.Literals.INIT_PART_CS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InitOp getInitOp()
  {
    return initOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitOp(InitOp newInitOp)
  {
    InitOp oldInitOp = initOp;
    initOp = newInitOp == null ? INIT_OP_EDEFAULT : newInitOp;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.INIT_PART_CS__INIT_OP, oldInitOp, initOp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpCS getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(ExpCS newExpression, NotificationChain msgs)
  {
    ExpCS oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.INIT_PART_CS__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression(ExpCS newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.INIT_PART_CS__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.INIT_PART_CS__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.INIT_PART_CS__EXPRESSION, newExpression, newExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case QvtoperationalcsPackage.INIT_PART_CS__EXPRESSION:
        return basicSetExpression(null, msgs);
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
    switch (featureID)
    {
      case QvtoperationalcsPackage.INIT_PART_CS__INIT_OP:
        return getInitOp();
      case QvtoperationalcsPackage.INIT_PART_CS__EXPRESSION:
        return getExpression();
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
    switch (featureID)
    {
      case QvtoperationalcsPackage.INIT_PART_CS__INIT_OP:
        setInitOp((InitOp)newValue);
        return;
      case QvtoperationalcsPackage.INIT_PART_CS__EXPRESSION:
        setExpression((ExpCS)newValue);
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
    switch (featureID)
    {
      case QvtoperationalcsPackage.INIT_PART_CS__INIT_OP:
        setInitOp(INIT_OP_EDEFAULT);
        return;
      case QvtoperationalcsPackage.INIT_PART_CS__EXPRESSION:
        setExpression((ExpCS)null);
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
    switch (featureID)
    {
      case QvtoperationalcsPackage.INIT_PART_CS__INIT_OP:
        return initOp != INIT_OP_EDEFAULT;
      case QvtoperationalcsPackage.INIT_PART_CS__EXPRESSION:
        return expression != null;
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
    result.append(" (initOp: ");
    result.append(initOp);
    result.append(')');
    return result.toString();
  }

} //InitPartCSImpl
