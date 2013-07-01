/**
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ConstructorPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ExpCSImpl;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ConstructorExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.NameExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.ImperativeOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constructor Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ConstructorExpCSImpl#getNameExp <em>Name Exp</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ConstructorExpCSImpl#getOwnedParts <em>Owned Parts</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.ConstructorExpCSImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstructorExpCSImpl extends ExpCSImpl implements ConstructorExpCS
{
  /**
	 * The cached value of the '{@link #getNameExp() <em>Name Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getNameExp()
	 * @generated
	 * @ordered
	 */
  protected NameExpCS nameExp;

  /**
	 * The cached value of the '{@link #getOwnedParts() <em>Owned Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getOwnedParts()
	 * @generated
	 * @ordered
	 */
  protected EList<ConstructorPartCS> ownedParts;

  /**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
  protected static final String VALUE_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
  protected String value = VALUE_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ConstructorExpCSImpl()
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
		return ImperativeoclcsPackage.Literals.CONSTRUCTOR_EXP_CS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NameExpCS getNameExp()
  {
		return nameExp;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetNameExp(NameExpCS newNameExp, NotificationChain msgs)
  {
		NameExpCS oldNameExp = nameExp;
		nameExp = newNameExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS__NAME_EXP, oldNameExp, newNameExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setNameExp(NameExpCS newNameExp)
  {
		if (newNameExp != nameExp) {
			NotificationChain msgs = null;
			if (nameExp != null)
				msgs = ((InternalEObject)nameExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS__NAME_EXP, null, msgs);
			if (newNameExp != null)
				msgs = ((InternalEObject)newNameExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS__NAME_EXP, null, msgs);
			msgs = basicSetNameExp(newNameExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS__NAME_EXP, newNameExp, newNameExp));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<ConstructorPartCS> getOwnedParts()
  {
		if (ownedParts == null) {
			ownedParts = new EObjectContainmentEList<ConstructorPartCS>(ConstructorPartCS.class, this, ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS__OWNED_PARTS);
		}
		return ownedParts;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getValue()
  {
		return value;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setValue(String newValue)
  {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS__VALUE, oldValue, value));
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
     * @added
	 */
	public <R> R accept(final ImperativeOCLCSVisitor<R> v) {
		return v.visitConstructorExpCS(this);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
     * @added
	 */
	public <R> R accept(final BaseCSVisitor<R> v) {
		return ((ImperativeOCLCSVisitor<R>)v).visitConstructorExpCS(this);
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
			case ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS__NAME_EXP:
				return basicSetNameExp(null, msgs);
			case ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS__OWNED_PARTS:
				return ((InternalEList<?>)getOwnedParts()).basicRemove(otherEnd, msgs);
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
			case ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS__NAME_EXP:
				return getNameExp();
			case ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS__OWNED_PARTS:
				return getOwnedParts();
			case ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS__VALUE:
				return getValue();
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
		switch (featureID) {
			case ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS__NAME_EXP:
				setNameExp((NameExpCS)newValue);
				return;
			case ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS__OWNED_PARTS:
				getOwnedParts().clear();
				getOwnedParts().addAll((Collection<? extends ConstructorPartCS>)newValue);
				return;
			case ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS__VALUE:
				setValue((String)newValue);
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
			case ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS__NAME_EXP:
				setNameExp((NameExpCS)null);
				return;
			case ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS__OWNED_PARTS:
				getOwnedParts().clear();
				return;
			case ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS__NAME_EXP:
				return nameExp != null;
			case ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS__OWNED_PARTS:
				return ownedParts != null && !ownedParts.isEmpty();
			case ImperativeoclcsPackage.CONSTRUCTOR_EXP_CS__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
		result.append(" (value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //ConstructorExpCSImpl
