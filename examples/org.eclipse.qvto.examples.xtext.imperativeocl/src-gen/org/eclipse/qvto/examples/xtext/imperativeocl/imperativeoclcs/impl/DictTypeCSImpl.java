/**
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;

import org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypedRefCSImpl;

import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dict Type CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.DictTypeCSImpl#getOwnedKeyTypeCS <em>Owned Key Type CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.DictTypeCSImpl#getOwnedElementTypeCS <em>Owned Element Type CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DictTypeCSImpl extends TypedRefCSImpl implements DictTypeCS
{
  /**
   * The cached value of the '{@link #getOwnedKeyTypeCS() <em>Owned Key Type CS</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedKeyTypeCS()
   * @generated
   * @ordered
   */
  protected TypedRefCS ownedKeyTypeCS;

  /**
   * The cached value of the '{@link #getOwnedElementTypeCS() <em>Owned Element Type CS</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedElementTypeCS()
   * @generated
   * @ordered
   */
  protected TypedRefCS ownedElementTypeCS;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DictTypeCSImpl()
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
    return ImperativeoclcsPackage.Literals.DICT_TYPE_CS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypedRefCS getOwnedKeyTypeCS()
  {
    return ownedKeyTypeCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwnedKeyTypeCS(TypedRefCS newOwnedKeyTypeCS, NotificationChain msgs)
  {
    TypedRefCS oldOwnedKeyTypeCS = ownedKeyTypeCS;
    ownedKeyTypeCS = newOwnedKeyTypeCS;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeoclcsPackage.DICT_TYPE_CS__OWNED_KEY_TYPE_CS, oldOwnedKeyTypeCS, newOwnedKeyTypeCS);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOwnedKeyTypeCS(TypedRefCS newOwnedKeyTypeCS)
  {
    if (newOwnedKeyTypeCS != ownedKeyTypeCS)
    {
      NotificationChain msgs = null;
      if (ownedKeyTypeCS != null)
        msgs = ((InternalEObject)ownedKeyTypeCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeoclcsPackage.DICT_TYPE_CS__OWNED_KEY_TYPE_CS, null, msgs);
      if (newOwnedKeyTypeCS != null)
        msgs = ((InternalEObject)newOwnedKeyTypeCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeoclcsPackage.DICT_TYPE_CS__OWNED_KEY_TYPE_CS, null, msgs);
      msgs = basicSetOwnedKeyTypeCS(newOwnedKeyTypeCS, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ImperativeoclcsPackage.DICT_TYPE_CS__OWNED_KEY_TYPE_CS, newOwnedKeyTypeCS, newOwnedKeyTypeCS));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypedRefCS getOwnedElementTypeCS()
  {
    return ownedElementTypeCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwnedElementTypeCS(TypedRefCS newOwnedElementTypeCS, NotificationChain msgs)
  {
    TypedRefCS oldOwnedElementTypeCS = ownedElementTypeCS;
    ownedElementTypeCS = newOwnedElementTypeCS;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeoclcsPackage.DICT_TYPE_CS__OWNED_ELEMENT_TYPE_CS, oldOwnedElementTypeCS, newOwnedElementTypeCS);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOwnedElementTypeCS(TypedRefCS newOwnedElementTypeCS)
  {
    if (newOwnedElementTypeCS != ownedElementTypeCS)
    {
      NotificationChain msgs = null;
      if (ownedElementTypeCS != null)
        msgs = ((InternalEObject)ownedElementTypeCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeoclcsPackage.DICT_TYPE_CS__OWNED_ELEMENT_TYPE_CS, null, msgs);
      if (newOwnedElementTypeCS != null)
        msgs = ((InternalEObject)newOwnedElementTypeCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeoclcsPackage.DICT_TYPE_CS__OWNED_ELEMENT_TYPE_CS, null, msgs);
      msgs = basicSetOwnedElementTypeCS(newOwnedElementTypeCS, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ImperativeoclcsPackage.DICT_TYPE_CS__OWNED_ELEMENT_TYPE_CS, newOwnedElementTypeCS, newOwnedElementTypeCS));
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
      case ImperativeoclcsPackage.DICT_TYPE_CS__OWNED_KEY_TYPE_CS:
        return basicSetOwnedKeyTypeCS(null, msgs);
      case ImperativeoclcsPackage.DICT_TYPE_CS__OWNED_ELEMENT_TYPE_CS:
        return basicSetOwnedElementTypeCS(null, msgs);
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
      case ImperativeoclcsPackage.DICT_TYPE_CS__OWNED_KEY_TYPE_CS:
        return getOwnedKeyTypeCS();
      case ImperativeoclcsPackage.DICT_TYPE_CS__OWNED_ELEMENT_TYPE_CS:
        return getOwnedElementTypeCS();
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
      case ImperativeoclcsPackage.DICT_TYPE_CS__OWNED_KEY_TYPE_CS:
        setOwnedKeyTypeCS((TypedRefCS)newValue);
        return;
      case ImperativeoclcsPackage.DICT_TYPE_CS__OWNED_ELEMENT_TYPE_CS:
        setOwnedElementTypeCS((TypedRefCS)newValue);
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
      case ImperativeoclcsPackage.DICT_TYPE_CS__OWNED_KEY_TYPE_CS:
        setOwnedKeyTypeCS((TypedRefCS)null);
        return;
      case ImperativeoclcsPackage.DICT_TYPE_CS__OWNED_ELEMENT_TYPE_CS:
        setOwnedElementTypeCS((TypedRefCS)null);
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
      case ImperativeoclcsPackage.DICT_TYPE_CS__OWNED_KEY_TYPE_CS:
        return ownedKeyTypeCS != null;
      case ImperativeoclcsPackage.DICT_TYPE_CS__OWNED_ELEMENT_TYPE_CS:
        return ownedElementTypeCS != null;
    }
    return super.eIsSet(featureID);
  }

} //DictTypeCSImpl
