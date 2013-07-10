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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.ElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingDeclarationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterDeclarationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QualifierKindCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Mapping Declaration CS</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingDeclarationCSImpl#getQualifiers <em>Qualifiers</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingDeclarationCSImpl#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingDeclarationCSImpl#getContextType <em>Context Type</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingDeclarationCSImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingDeclarationCSImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingDeclarationCSImpl#getDirectionKindCS <em>Direction Kind CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingDeclarationCSImpl#getMappingExtension <em>Mapping Extension</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingDeclarationCSImpl#isIsQuery <em>Is Query</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingDeclarationCSImpl
		extends ElementCSImpl
		implements MappingDeclarationCS {

	/**
	 * The cached value of the '{@link #getQualifiers() <em>Qualifiers</em>}' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getQualifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<QualifierKindCS> qualifiers;

	/**
	 * The default value of the '{@link #getSimpleNameCS() <em>Simple Name CS</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSimpleNameCS()
	 * @generated
	 * @ordered
	 */
	protected static final String SIMPLE_NAME_CS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSimpleNameCS() <em>Simple Name CS</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSimpleNameCS()
	 * @generated
	 * @ordered
	 */
	protected String simpleNameCS = SIMPLE_NAME_CS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContextType() <em>Context Type</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getContextType()
	 * @generated
	 * @ordered
	 */
	protected TypeCS contextType;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterDeclarationCS> parameters;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterDeclarationCS> result;

	/**
	 * The cached value of the '{@link #getDirectionKindCS() <em>Direction Kind CS</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getDirectionKindCS()
	 * @generated
	 * @ordered
	 */
	protected DirectionKindCS directionKindCS;

	/**
	 * The cached value of the '{@link #getMappingExtension()
	 * <em>Mapping Extension</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMappingExtension()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingExtensionCS> mappingExtension;

	/**
	 * The default value of the '{@link #isIsQuery() <em>Is Query</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isIsQuery()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_QUERY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsQuery() <em>Is Query</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isIsQuery()
	 * @generated
	 * @ordered
	 */
	protected boolean isQuery = IS_QUERY_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingDeclarationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QvtoperationalcsPackage.Literals.MAPPING_DECLARATION_CS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<QualifierKindCS> getQualifiers() {
		if (qualifiers == null) {
			qualifiers = new EDataTypeEList<QualifierKindCS>(QualifierKindCS.class, this, QvtoperationalcsPackage.MAPPING_DECLARATION_CS__QUALIFIERS);
		}
		return qualifiers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSimpleNameCS() {
		return simpleNameCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleNameCS(String newSimpleNameCS) {
		String oldSimpleNameCS = simpleNameCS;
		simpleNameCS = newSimpleNameCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.MAPPING_DECLARATION_CS__SIMPLE_NAME_CS, oldSimpleNameCS, simpleNameCS));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TypeCS getContextType() {
		return contextType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContextType(TypeCS newContextType,
			NotificationChain msgs) {
		TypeCS oldContextType = contextType;
		contextType = newContextType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE, oldContextType, newContextType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextType(TypeCS newContextType) {
		if (newContextType != contextType) {
			NotificationChain msgs = null;
			if (contextType != null)
				msgs = ((InternalEObject)contextType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE, null, msgs);
			if (newContextType != null)
				msgs = ((InternalEObject)newContextType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE, null, msgs);
			msgs = basicSetContextType(newContextType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE, newContextType, newContextType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterDeclarationCS> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<ParameterDeclarationCS>(ParameterDeclarationCS.class, this, QvtoperationalcsPackage.MAPPING_DECLARATION_CS__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterDeclarationCS> getResult() {
		if (result == null) {
			result = new EObjectContainmentEList<ParameterDeclarationCS>(ParameterDeclarationCS.class, this, QvtoperationalcsPackage.MAPPING_DECLARATION_CS__RESULT);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionKindCS getDirectionKindCS() {
		return directionKindCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDirectionKindCS(
			DirectionKindCS newDirectionKindCS, NotificationChain msgs) {
		DirectionKindCS oldDirectionKindCS = directionKindCS;
		directionKindCS = newDirectionKindCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.MAPPING_DECLARATION_CS__DIRECTION_KIND_CS, oldDirectionKindCS, newDirectionKindCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirectionKindCS(DirectionKindCS newDirectionKindCS) {
		if (newDirectionKindCS != directionKindCS) {
			NotificationChain msgs = null;
			if (directionKindCS != null)
				msgs = ((InternalEObject)directionKindCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.MAPPING_DECLARATION_CS__DIRECTION_KIND_CS, null, msgs);
			if (newDirectionKindCS != null)
				msgs = ((InternalEObject)newDirectionKindCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QvtoperationalcsPackage.MAPPING_DECLARATION_CS__DIRECTION_KIND_CS, null, msgs);
			msgs = basicSetDirectionKindCS(newDirectionKindCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.MAPPING_DECLARATION_CS__DIRECTION_KIND_CS, newDirectionKindCS, newDirectionKindCS));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingExtensionCS> getMappingExtension() {
		if (mappingExtension == null) {
			mappingExtension = new EObjectContainmentEList<MappingExtensionCS>(MappingExtensionCS.class, this, QvtoperationalcsPackage.MAPPING_DECLARATION_CS__MAPPING_EXTENSION);
		}
		return mappingExtension;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsQuery() {
		return isQuery;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsQuery(boolean newIsQuery) {
		boolean oldIsQuery = isQuery;
		isQuery = newIsQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtoperationalcsPackage.MAPPING_DECLARATION_CS__IS_QUERY, oldIsQuery, isQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor<R> v) {
		return v.visitMappingDeclarationCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final BaseCSVisitor<R> v) {
		return ((QVTOperationalCSVisitor<R>)v).visitMappingDeclarationCS(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE:
				return basicSetContextType(null, msgs);
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__RESULT:
				return ((InternalEList<?>)getResult()).basicRemove(otherEnd, msgs);
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__DIRECTION_KIND_CS:
				return basicSetDirectionKindCS(null, msgs);
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__MAPPING_EXTENSION:
				return ((InternalEList<?>)getMappingExtension()).basicRemove(otherEnd, msgs);
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
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__QUALIFIERS:
				return getQualifiers();
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__SIMPLE_NAME_CS:
				return getSimpleNameCS();
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE:
				return getContextType();
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__PARAMETERS:
				return getParameters();
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__RESULT:
				return getResult();
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__DIRECTION_KIND_CS:
				return getDirectionKindCS();
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__MAPPING_EXTENSION:
				return getMappingExtension();
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__IS_QUERY:
				return isIsQuery();
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
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__QUALIFIERS:
				getQualifiers().clear();
				getQualifiers().addAll((Collection<? extends QualifierKindCS>)newValue);
				return;
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__SIMPLE_NAME_CS:
				setSimpleNameCS((String)newValue);
				return;
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE:
				setContextType((TypeCS)newValue);
				return;
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends ParameterDeclarationCS>)newValue);
				return;
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__RESULT:
				getResult().clear();
				getResult().addAll((Collection<? extends ParameterDeclarationCS>)newValue);
				return;
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__DIRECTION_KIND_CS:
				setDirectionKindCS((DirectionKindCS)newValue);
				return;
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__MAPPING_EXTENSION:
				getMappingExtension().clear();
				getMappingExtension().addAll((Collection<? extends MappingExtensionCS>)newValue);
				return;
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__IS_QUERY:
				setIsQuery((Boolean)newValue);
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
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__QUALIFIERS:
				getQualifiers().clear();
				return;
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__SIMPLE_NAME_CS:
				setSimpleNameCS(SIMPLE_NAME_CS_EDEFAULT);
				return;
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE:
				setContextType((TypeCS)null);
				return;
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__PARAMETERS:
				getParameters().clear();
				return;
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__RESULT:
				getResult().clear();
				return;
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__DIRECTION_KIND_CS:
				setDirectionKindCS((DirectionKindCS)null);
				return;
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__MAPPING_EXTENSION:
				getMappingExtension().clear();
				return;
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__IS_QUERY:
				setIsQuery(IS_QUERY_EDEFAULT);
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
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__QUALIFIERS:
				return qualifiers != null && !qualifiers.isEmpty();
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__SIMPLE_NAME_CS:
				return SIMPLE_NAME_CS_EDEFAULT == null ? simpleNameCS != null : !SIMPLE_NAME_CS_EDEFAULT.equals(simpleNameCS);
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__CONTEXT_TYPE:
				return contextType != null;
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__RESULT:
				return result != null && !result.isEmpty();
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__DIRECTION_KIND_CS:
				return directionKindCS != null;
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__MAPPING_EXTENSION:
				return mappingExtension != null && !mappingExtension.isEmpty();
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS__IS_QUERY:
				return isQuery != IS_QUERY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (qualifiers: ");
		result.append(qualifiers);
		result.append(", simpleNameCS: ");
		result.append(simpleNameCS);
		result.append(", isQuery: ");
		result.append(isQuery);
		result.append(')');
		return result.toString();
	}

} // MappingDeclarationCSImpl
