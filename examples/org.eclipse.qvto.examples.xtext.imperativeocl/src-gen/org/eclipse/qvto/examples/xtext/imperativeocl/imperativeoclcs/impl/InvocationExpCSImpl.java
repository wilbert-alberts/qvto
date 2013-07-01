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
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ExpCSImpl;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.InvocationExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.NameExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.ImperativeOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invocation Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.InvocationExpCSImpl#getNameExp <em>Name Exp</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.InvocationExpCSImpl#getArgument <em>Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InvocationExpCSImpl extends ExpCSImpl implements InvocationExpCS
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
	 * The cached value of the '{@link #getArgument() <em>Argument</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getArgument()
	 * @generated
	 * @ordered
	 */
  protected EList<NavigatingArgCS> argument;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected InvocationExpCSImpl()
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
		return ImperativeoclcsPackage.Literals.INVOCATION_EXP_CS;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeoclcsPackage.INVOCATION_EXP_CS__NAME_EXP, oldNameExp, newNameExp);
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
				msgs = ((InternalEObject)nameExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeoclcsPackage.INVOCATION_EXP_CS__NAME_EXP, null, msgs);
			if (newNameExp != null)
				msgs = ((InternalEObject)newNameExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeoclcsPackage.INVOCATION_EXP_CS__NAME_EXP, null, msgs);
			msgs = basicSetNameExp(newNameExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeoclcsPackage.INVOCATION_EXP_CS__NAME_EXP, newNameExp, newNameExp));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<NavigatingArgCS> getArgument()
  {
		if (argument == null) {
			argument = new EObjectContainmentEList<NavigatingArgCS>(NavigatingArgCS.class, this, ImperativeoclcsPackage.INVOCATION_EXP_CS__ARGUMENT);
		}
		return argument;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
     * @added
	 */
	public <R> R accept(final ImperativeOCLCSVisitor<R> v) {
		return v.visitInvocationExpCS(this);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
     * @added
	 */
	public <R> R accept(final BaseCSVisitor<R> v) {
		return ((ImperativeOCLCSVisitor<R>)v).visitInvocationExpCS(this);
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
			case ImperativeoclcsPackage.INVOCATION_EXP_CS__NAME_EXP:
				return basicSetNameExp(null, msgs);
			case ImperativeoclcsPackage.INVOCATION_EXP_CS__ARGUMENT:
				return ((InternalEList<?>)getArgument()).basicRemove(otherEnd, msgs);
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
			case ImperativeoclcsPackage.INVOCATION_EXP_CS__NAME_EXP:
				return getNameExp();
			case ImperativeoclcsPackage.INVOCATION_EXP_CS__ARGUMENT:
				return getArgument();
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
			case ImperativeoclcsPackage.INVOCATION_EXP_CS__NAME_EXP:
				setNameExp((NameExpCS)newValue);
				return;
			case ImperativeoclcsPackage.INVOCATION_EXP_CS__ARGUMENT:
				getArgument().clear();
				getArgument().addAll((Collection<? extends NavigatingArgCS>)newValue);
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
			case ImperativeoclcsPackage.INVOCATION_EXP_CS__NAME_EXP:
				setNameExp((NameExpCS)null);
				return;
			case ImperativeoclcsPackage.INVOCATION_EXP_CS__ARGUMENT:
				getArgument().clear();
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
			case ImperativeoclcsPackage.INVOCATION_EXP_CS__NAME_EXP:
				return nameExp != null;
			case ImperativeoclcsPackage.INVOCATION_EXP_CS__ARGUMENT:
				return argument != null && !argument.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InvocationExpCSImpl
