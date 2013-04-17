/**
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveLiteralExpCS;

import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralPartCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dict Literal Part CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.DictLiteralPartCSImpl#getKeyExpCS <em>Key Exp CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.DictLiteralPartCSImpl#getValueExpCS <em>Value Exp CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DictLiteralPartCSImpl extends MinimalEObjectImpl.Container implements DictLiteralPartCS
{
  /**
   * The cached value of the '{@link #getKeyExpCS() <em>Key Exp CS</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKeyExpCS()
   * @generated
   * @ordered
   */
  protected PrimitiveLiteralExpCS keyExpCS;

  /**
   * The cached value of the '{@link #getValueExpCS() <em>Value Exp CS</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueExpCS()
   * @generated
   * @ordered
   */
  protected ExpCS valueExpCS;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DictLiteralPartCSImpl()
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
    return ImperativeoclcsPackage.Literals.DICT_LITERAL_PART_CS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimitiveLiteralExpCS getKeyExpCS()
  {
    return keyExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetKeyExpCS(PrimitiveLiteralExpCS newKeyExpCS, NotificationChain msgs)
  {
    PrimitiveLiteralExpCS oldKeyExpCS = keyExpCS;
    keyExpCS = newKeyExpCS;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeoclcsPackage.DICT_LITERAL_PART_CS__KEY_EXP_CS, oldKeyExpCS, newKeyExpCS);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKeyExpCS(PrimitiveLiteralExpCS newKeyExpCS)
  {
    if (newKeyExpCS != keyExpCS)
    {
      NotificationChain msgs = null;
      if (keyExpCS != null)
        msgs = ((InternalEObject)keyExpCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeoclcsPackage.DICT_LITERAL_PART_CS__KEY_EXP_CS, null, msgs);
      if (newKeyExpCS != null)
        msgs = ((InternalEObject)newKeyExpCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeoclcsPackage.DICT_LITERAL_PART_CS__KEY_EXP_CS, null, msgs);
      msgs = basicSetKeyExpCS(newKeyExpCS, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ImperativeoclcsPackage.DICT_LITERAL_PART_CS__KEY_EXP_CS, newKeyExpCS, newKeyExpCS));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpCS getValueExpCS()
  {
    return valueExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValueExpCS(ExpCS newValueExpCS, NotificationChain msgs)
  {
    ExpCS oldValueExpCS = valueExpCS;
    valueExpCS = newValueExpCS;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeoclcsPackage.DICT_LITERAL_PART_CS__VALUE_EXP_CS, oldValueExpCS, newValueExpCS);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValueExpCS(ExpCS newValueExpCS)
  {
    if (newValueExpCS != valueExpCS)
    {
      NotificationChain msgs = null;
      if (valueExpCS != null)
        msgs = ((InternalEObject)valueExpCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeoclcsPackage.DICT_LITERAL_PART_CS__VALUE_EXP_CS, null, msgs);
      if (newValueExpCS != null)
        msgs = ((InternalEObject)newValueExpCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeoclcsPackage.DICT_LITERAL_PART_CS__VALUE_EXP_CS, null, msgs);
      msgs = basicSetValueExpCS(newValueExpCS, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ImperativeoclcsPackage.DICT_LITERAL_PART_CS__VALUE_EXP_CS, newValueExpCS, newValueExpCS));
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
      case ImperativeoclcsPackage.DICT_LITERAL_PART_CS__KEY_EXP_CS:
        return basicSetKeyExpCS(null, msgs);
      case ImperativeoclcsPackage.DICT_LITERAL_PART_CS__VALUE_EXP_CS:
        return basicSetValueExpCS(null, msgs);
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
      case ImperativeoclcsPackage.DICT_LITERAL_PART_CS__KEY_EXP_CS:
        return getKeyExpCS();
      case ImperativeoclcsPackage.DICT_LITERAL_PART_CS__VALUE_EXP_CS:
        return getValueExpCS();
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
      case ImperativeoclcsPackage.DICT_LITERAL_PART_CS__KEY_EXP_CS:
        setKeyExpCS((PrimitiveLiteralExpCS)newValue);
        return;
      case ImperativeoclcsPackage.DICT_LITERAL_PART_CS__VALUE_EXP_CS:
        setValueExpCS((ExpCS)newValue);
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
      case ImperativeoclcsPackage.DICT_LITERAL_PART_CS__KEY_EXP_CS:
        setKeyExpCS((PrimitiveLiteralExpCS)null);
        return;
      case ImperativeoclcsPackage.DICT_LITERAL_PART_CS__VALUE_EXP_CS:
        setValueExpCS((ExpCS)null);
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
      case ImperativeoclcsPackage.DICT_LITERAL_PART_CS__KEY_EXP_CS:
        return keyExpCS != null;
      case ImperativeoclcsPackage.DICT_LITERAL_PART_CS__VALUE_EXP_CS:
        return valueExpCS != null;
    }
    return super.eIsSet(featureID);
  }

} //DictLiteralPartCSImpl
