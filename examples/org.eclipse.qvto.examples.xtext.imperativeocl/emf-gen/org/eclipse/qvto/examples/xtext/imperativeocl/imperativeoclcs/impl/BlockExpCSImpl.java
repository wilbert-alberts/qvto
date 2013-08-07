/**
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.BlockExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeOCLCSPackage;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.ImperativeOCLCSVisitor;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Block Exp CS</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.impl.BlockExpCSImpl#getBodyExpressions <em>Body Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockExpCSImpl
		extends StatementCSImpl
		implements BlockExpCS {

	/**
	 * The cached value of the '{@link #getBodyExpressions()
	 * <em>Body Expressions</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBodyExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<ExpCS> bodyExpressions;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeOCLCSPackage.Literals.BLOCK_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExpCS> getBodyExpressions() {
		if (bodyExpressions == null) {
			bodyExpressions = new EObjectContainmentEList<ExpCS>(ExpCS.class, this, ImperativeOCLCSPackage.BLOCK_EXP_CS__BODY_EXPRESSIONS);
		}
		return bodyExpressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.ImperativeOCLCSVisitor<R> v) {
		return v.visitBlockExpCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final BaseCSVisitor<R> v) {
		return ((ImperativeOCLCSVisitor<R>)v).visitBlockExpCS(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImperativeOCLCSPackage.BLOCK_EXP_CS__BODY_EXPRESSIONS:
				return ((InternalEList<?>)getBodyExpressions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImperativeOCLCSPackage.BLOCK_EXP_CS__BODY_EXPRESSIONS:
				return getBodyExpressions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ImperativeOCLCSPackage.BLOCK_EXP_CS__BODY_EXPRESSIONS:
				getBodyExpressions().clear();
				getBodyExpressions().addAll((Collection<? extends ExpCS>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ImperativeOCLCSPackage.BLOCK_EXP_CS__BODY_EXPRESSIONS:
				getBodyExpressions().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ImperativeOCLCSPackage.BLOCK_EXP_CS__BODY_EXPRESSIONS:
				return bodyExpressions != null && !bodyExpressions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // BlockExpCSImpl
