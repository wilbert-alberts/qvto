/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.OperationCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationSimpleSignatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterDeclarationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Operation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingOperationCSImpl#getContextType <em>Context Type</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingOperationCSImpl#getSignature <em>Signature</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingOperationCSImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingOperationCSImpl#getDirectionKindCS <em>Direction Kind CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingOperationCSImpl#getMappingExtension <em>Mapping Extension</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingOperationCSImpl#isIsQuery <em>Is Query</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingOperationCSImpl extends OperationCSImpl implements MappingOperationCS {
	/**
	 * The cached value of the '{@link #getContextType() <em>Context Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextType()
	 * @generated
	 * @ordered
	 */
	protected TypeCS contextType;

	/**
	 * The cached value of the '{@link #getSignature() <em>Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignature()
	 * @generated
	 * @ordered
	 */
	protected OperationSimpleSignatureCS signature;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterDeclarationCS> result;

	/**
	 * The default value of the '{@link #getDirectionKindCS() <em>Direction Kind CS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectionKindCS()
	 * @generated
	 * @ordered
	 */
	protected static final DirectionKindCS DIRECTION_KIND_CS_EDEFAULT = DirectionKindCS.IN;

	/**
	 * The cached value of the '{@link #getDirectionKindCS() <em>Direction Kind CS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirectionKindCS()
	 * @generated
	 * @ordered
	 */
	protected DirectionKindCS directionKindCS = DIRECTION_KIND_CS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMappingExtension() <em>Mapping Extension</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingExtension()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingExtensionCS> mappingExtension;

	/**
	 * The default value of the '{@link #isIsQuery() <em>Is Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsQuery()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_QUERY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsQuery() <em>Is Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsQuery()
	 * @generated
	 * @ordered
	 */
	protected boolean isQuery = IS_QUERY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingOperationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalCSPackage.Literals.MAPPING_OPERATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeCS getContextType() {
		return contextType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContextType(TypeCS newContextType, NotificationChain msgs) {
		TypeCS oldContextType = contextType;
		contextType = newContextType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MAPPING_OPERATION_CS__CONTEXT_TYPE, oldContextType, newContextType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextType(TypeCS newContextType) {
		if (newContextType != contextType) {
			NotificationChain msgs = null;
			if (contextType != null)
				msgs = ((InternalEObject)contextType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.MAPPING_OPERATION_CS__CONTEXT_TYPE, null, msgs);
			if (newContextType != null)
				msgs = ((InternalEObject)newContextType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.MAPPING_OPERATION_CS__CONTEXT_TYPE, null, msgs);
			msgs = basicSetContextType(newContextType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MAPPING_OPERATION_CS__CONTEXT_TYPE, newContextType, newContextType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationSimpleSignatureCS getSignature() {
		return signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSignature(OperationSimpleSignatureCS newSignature, NotificationChain msgs) {
		OperationSimpleSignatureCS oldSignature = signature;
		signature = newSignature;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MAPPING_OPERATION_CS__SIGNATURE, oldSignature, newSignature);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignature(OperationSimpleSignatureCS newSignature) {
		if (newSignature != signature) {
			NotificationChain msgs = null;
			if (signature != null)
				msgs = ((InternalEObject)signature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.MAPPING_OPERATION_CS__SIGNATURE, null, msgs);
			if (newSignature != null)
				msgs = ((InternalEObject)newSignature).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.MAPPING_OPERATION_CS__SIGNATURE, null, msgs);
			msgs = basicSetSignature(newSignature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MAPPING_OPERATION_CS__SIGNATURE, newSignature, newSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterDeclarationCS> getResult() {
		if (result == null) {
			result = new EObjectContainmentEList<ParameterDeclarationCS>(ParameterDeclarationCS.class, this, QVTOperationalCSPackage.MAPPING_OPERATION_CS__RESULT);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionKindCS getDirectionKindCS() {
		return directionKindCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirectionKindCS(DirectionKindCS newDirectionKindCS) {
		DirectionKindCS oldDirectionKindCS = directionKindCS;
		directionKindCS = newDirectionKindCS == null ? DIRECTION_KIND_CS_EDEFAULT : newDirectionKindCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MAPPING_OPERATION_CS__DIRECTION_KIND_CS, oldDirectionKindCS, directionKindCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingExtensionCS> getMappingExtension() {
		if (mappingExtension == null) {
			mappingExtension = new EObjectContainmentEList<MappingExtensionCS>(MappingExtensionCS.class, this, QVTOperationalCSPackage.MAPPING_OPERATION_CS__MAPPING_EXTENSION);
		}
		return mappingExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsQuery() {
		return isQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsQuery(boolean newIsQuery) {
		boolean oldIsQuery = isQuery;
		isQuery = newIsQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MAPPING_OPERATION_CS__IS_QUERY, oldIsQuery, isQuery));
	}

	/**
	 * The cached invocation delegate for the '{@link #ast() <em>Ast</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ast()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate AST__EINVOCATION_DELEGATE = ((EOperation.Internal)QVTOperationalCSPackage.Literals.MAPPING_OPERATION_CS.getEOperations().get(0)).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingOperation ast() {
		try {
			return (MappingOperation)AST__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
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
		return v.visitMappingOperationCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final BaseCSVisitor<R> v) {
		return ((QVTOperationalCSVisitor<R>)v).visitMappingOperationCS(this);
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
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__CONTEXT_TYPE:
				return basicSetContextType(null, msgs);
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__SIGNATURE:
				return basicSetSignature(null, msgs);
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__RESULT:
				return ((InternalEList<?>)getResult()).basicRemove(otherEnd, msgs);
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__MAPPING_EXTENSION:
				return ((InternalEList<?>)getMappingExtension()).basicRemove(otherEnd, msgs);
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
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__CONTEXT_TYPE:
				return getContextType();
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__SIGNATURE:
				return getSignature();
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__RESULT:
				return getResult();
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__DIRECTION_KIND_CS:
				return getDirectionKindCS();
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__MAPPING_EXTENSION:
				return getMappingExtension();
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__IS_QUERY:
				return isIsQuery();
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
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__CONTEXT_TYPE:
				setContextType((TypeCS)newValue);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__SIGNATURE:
				setSignature((OperationSimpleSignatureCS)newValue);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__RESULT:
				getResult().clear();
				getResult().addAll((Collection<? extends ParameterDeclarationCS>)newValue);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__DIRECTION_KIND_CS:
				setDirectionKindCS((DirectionKindCS)newValue);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__MAPPING_EXTENSION:
				getMappingExtension().clear();
				getMappingExtension().addAll((Collection<? extends MappingExtensionCS>)newValue);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__IS_QUERY:
				setIsQuery((Boolean)newValue);
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
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__CONTEXT_TYPE:
				setContextType((TypeCS)null);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__SIGNATURE:
				setSignature((OperationSimpleSignatureCS)null);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__RESULT:
				getResult().clear();
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__DIRECTION_KIND_CS:
				setDirectionKindCS(DIRECTION_KIND_CS_EDEFAULT);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__MAPPING_EXTENSION:
				getMappingExtension().clear();
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__IS_QUERY:
				setIsQuery(IS_QUERY_EDEFAULT);
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
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__CONTEXT_TYPE:
				return contextType != null;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__SIGNATURE:
				return signature != null;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__RESULT:
				return result != null && !result.isEmpty();
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__DIRECTION_KIND_CS:
				return directionKindCS != DIRECTION_KIND_CS_EDEFAULT;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__MAPPING_EXTENSION:
				return mappingExtension != null && !mappingExtension.isEmpty();
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__IS_QUERY:
				return isQuery != IS_QUERY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}


} //MappingOperationCSImpl
