/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;

import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.FeatureKey;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier Property CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierPropertyCSImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierPropertyCSImpl#getFeatureKey <em>Feature Key</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierPropertyCSImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierPropertyCSImpl#getTypespec <em>Typespec</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierPropertyCSImpl#getInitPart <em>Init Part</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierPropertyCSImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierPropertyCSImpl#isTilde <em>Tilde</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierPropertyCSImpl#getOppositeIdentifier <em>Opposite Identifier</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.ClassifierPropertyCSImpl#getOppositeMultiplicity <em>Opposite Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassifierPropertyCSImpl extends ClassifierFeatureCSImpl implements ClassifierPropertyCS
{
  /**
   * The cached value of the '{@link #getStereotype() <em>Stereotype</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStereotype()
   * @generated
   * @ordered
   */
  protected EList<String> stereotype;

  /**
   * The cached value of the '{@link #getFeatureKey() <em>Feature Key</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatureKey()
   * @generated
   * @ordered
   */
  protected EList<FeatureKey> featureKey;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

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
   * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplicity()
   * @generated
   * @ordered
   */
  protected MultiplicityCS multiplicity;

  /**
   * The default value of the '{@link #isTilde() <em>Tilde</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTilde()
   * @generated
   * @ordered
   */
  protected static final boolean TILDE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isTilde() <em>Tilde</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTilde()
   * @generated
   * @ordered
   */
  protected boolean tilde = TILDE_EDEFAULT;

  /**
   * The default value of the '{@link #getOppositeIdentifier() <em>Opposite Identifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOppositeIdentifier()
   * @generated
   * @ordered
   */
  protected static final String OPPOSITE_IDENTIFIER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOppositeIdentifier() <em>Opposite Identifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOppositeIdentifier()
   * @generated
   * @ordered
   */
  protected String oppositeIdentifier = OPPOSITE_IDENTIFIER_EDEFAULT;

  /**
   * The cached value of the '{@link #getOppositeMultiplicity() <em>Opposite Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOppositeMultiplicity()
   * @generated
   * @ordered
   */
  protected MultiplicityCS oppositeMultiplicity;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassifierPropertyCSImpl()
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
    return QvtoperationalcsPackage.Literals.CLASSIFIER_PROPERTY_CS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getStereotype()
  {
    if (stereotype == null)
    {
      stereotype = new EDataTypeEList<String>(String.class, this, QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__STEREOTYPE);
    }
    return stereotype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FeatureKey> getFeatureKey()
  {
    if (featureKey == null)
    {
      featureKey = new EDataTypeEList<FeatureKey>(FeatureKey.class, this, QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__FEATURE_KEY);
    }
    return featureKey;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__NAME, oldName, name));
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
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__TYPESPEC, oldTypespec, newTypespec);
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
    if (newTypespec != typespec)
    {
      NotificationChain msgs = null;
      if (typespec != null)
        msgs = ((InternalEObject)typespec).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__TYPESPEC, null, msgs);
      if (newTypespec != null)
        msgs = ((InternalEObject)newTypespec).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__TYPESPEC, null, msgs);
      msgs = basicSetTypespec(newTypespec, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__TYPESPEC, newTypespec, newTypespec));
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
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__INIT_PART, oldInitPart, newInitPart);
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
    if (newInitPart != initPart)
    {
      NotificationChain msgs = null;
      if (initPart != null)
        msgs = ((InternalEObject)initPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__INIT_PART, null, msgs);
      if (newInitPart != null)
        msgs = ((InternalEObject)newInitPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__INIT_PART, null, msgs);
      msgs = basicSetInitPart(newInitPart, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__INIT_PART, newInitPart, newInitPart));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicityCS getMultiplicity()
  {
    return multiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMultiplicity(MultiplicityCS newMultiplicity, NotificationChain msgs)
  {
    MultiplicityCS oldMultiplicity = multiplicity;
    multiplicity = newMultiplicity;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__MULTIPLICITY, oldMultiplicity, newMultiplicity);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMultiplicity(MultiplicityCS newMultiplicity)
  {
    if (newMultiplicity != multiplicity)
    {
      NotificationChain msgs = null;
      if (multiplicity != null)
        msgs = ((InternalEObject)multiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__MULTIPLICITY, null, msgs);
      if (newMultiplicity != null)
        msgs = ((InternalEObject)newMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__MULTIPLICITY, null, msgs);
      msgs = basicSetMultiplicity(newMultiplicity, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__MULTIPLICITY, newMultiplicity, newMultiplicity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isTilde()
  {
    return tilde;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTilde(boolean newTilde)
  {
    boolean oldTilde = tilde;
    tilde = newTilde;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__TILDE, oldTilde, tilde));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOppositeIdentifier()
  {
    return oppositeIdentifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOppositeIdentifier(String newOppositeIdentifier)
  {
    String oldOppositeIdentifier = oppositeIdentifier;
    oppositeIdentifier = newOppositeIdentifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE_IDENTIFIER, oldOppositeIdentifier, oppositeIdentifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicityCS getOppositeMultiplicity()
  {
    return oppositeMultiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOppositeMultiplicity(MultiplicityCS newOppositeMultiplicity, NotificationChain msgs)
  {
    MultiplicityCS oldOppositeMultiplicity = oppositeMultiplicity;
    oppositeMultiplicity = newOppositeMultiplicity;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE_MULTIPLICITY, oldOppositeMultiplicity, newOppositeMultiplicity);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOppositeMultiplicity(MultiplicityCS newOppositeMultiplicity)
  {
    if (newOppositeMultiplicity != oppositeMultiplicity)
    {
      NotificationChain msgs = null;
      if (oppositeMultiplicity != null)
        msgs = ((InternalEObject)oppositeMultiplicity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE_MULTIPLICITY, null, msgs);
      if (newOppositeMultiplicity != null)
        msgs = ((InternalEObject)newOppositeMultiplicity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE_MULTIPLICITY, null, msgs);
      msgs = basicSetOppositeMultiplicity(newOppositeMultiplicity, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE_MULTIPLICITY, newOppositeMultiplicity, newOppositeMultiplicity));
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
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__TYPESPEC:
        return basicSetTypespec(null, msgs);
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__INIT_PART:
        return basicSetInitPart(null, msgs);
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__MULTIPLICITY:
        return basicSetMultiplicity(null, msgs);
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE_MULTIPLICITY:
        return basicSetOppositeMultiplicity(null, msgs);
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
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__STEREOTYPE:
        return getStereotype();
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__FEATURE_KEY:
        return getFeatureKey();
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__NAME:
        return getName();
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__TYPESPEC:
        return getTypespec();
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__INIT_PART:
        return getInitPart();
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__MULTIPLICITY:
        return getMultiplicity();
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__TILDE:
        return isTilde();
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE_IDENTIFIER:
        return getOppositeIdentifier();
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE_MULTIPLICITY:
        return getOppositeMultiplicity();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__STEREOTYPE:
        getStereotype().clear();
        getStereotype().addAll((Collection<? extends String>)newValue);
        return;
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__FEATURE_KEY:
        getFeatureKey().clear();
        getFeatureKey().addAll((Collection<? extends FeatureKey>)newValue);
        return;
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__NAME:
        setName((String)newValue);
        return;
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__TYPESPEC:
        setTypespec((TypedRefCS)newValue);
        return;
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__INIT_PART:
        setInitPart((InitPartCS)newValue);
        return;
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__MULTIPLICITY:
        setMultiplicity((MultiplicityCS)newValue);
        return;
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__TILDE:
        setTilde((Boolean)newValue);
        return;
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE_IDENTIFIER:
        setOppositeIdentifier((String)newValue);
        return;
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE_MULTIPLICITY:
        setOppositeMultiplicity((MultiplicityCS)newValue);
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
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__STEREOTYPE:
        getStereotype().clear();
        return;
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__FEATURE_KEY:
        getFeatureKey().clear();
        return;
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__NAME:
        setName(NAME_EDEFAULT);
        return;
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__TYPESPEC:
        setTypespec((TypedRefCS)null);
        return;
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__INIT_PART:
        setInitPart((InitPartCS)null);
        return;
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__MULTIPLICITY:
        setMultiplicity((MultiplicityCS)null);
        return;
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__TILDE:
        setTilde(TILDE_EDEFAULT);
        return;
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE_IDENTIFIER:
        setOppositeIdentifier(OPPOSITE_IDENTIFIER_EDEFAULT);
        return;
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE_MULTIPLICITY:
        setOppositeMultiplicity((MultiplicityCS)null);
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
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__STEREOTYPE:
        return stereotype != null && !stereotype.isEmpty();
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__FEATURE_KEY:
        return featureKey != null && !featureKey.isEmpty();
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__TYPESPEC:
        return typespec != null;
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__INIT_PART:
        return initPart != null;
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__MULTIPLICITY:
        return multiplicity != null;
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__TILDE:
        return tilde != TILDE_EDEFAULT;
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE_IDENTIFIER:
        return OPPOSITE_IDENTIFIER_EDEFAULT == null ? oppositeIdentifier != null : !OPPOSITE_IDENTIFIER_EDEFAULT.equals(oppositeIdentifier);
      case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS__OPPOSITE_MULTIPLICITY:
        return oppositeMultiplicity != null;
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
    result.append(" (stereotype: ");
    result.append(stereotype);
    result.append(", featureKey: ");
    result.append(featureKey);
    result.append(", name: ");
    result.append(name);
    result.append(", tilde: ");
    result.append(tilde);
    result.append(", oppositeIdentifier: ");
    result.append(oppositeIdentifier);
    result.append(')');
    return result.toString();
  }

} //ClassifierPropertyCSImpl
