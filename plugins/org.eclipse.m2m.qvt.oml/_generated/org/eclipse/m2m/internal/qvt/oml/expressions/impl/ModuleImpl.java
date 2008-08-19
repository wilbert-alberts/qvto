/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.expressions.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsPackage;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExtendedVisitor;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport;
import org.eclipse.m2m.internal.qvt.oml.expressions.Property;
import org.eclipse.m2m.internal.qvt.oml.expressions.Rename;
import org.eclipse.m2m.internal.qvt.oml.expressions.VisitableASTNode;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.eclipse.ocl.utilities.Visitable;
import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImpl#getNsURI <em>Ns URI</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImpl#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImpl#getEFactoryInstance <em>EFactory Instance</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImpl#getEClassifiers <em>EClassifiers</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImpl#getESubpackages <em>ESubpackages</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImpl#getESuperPackage <em>ESuper Package</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImpl#getStartPosition <em>Start Position</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImpl#getEndPosition <em>End Position</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImpl#getModuleImport <em>Module Import</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImpl#getUsedModelType <em>Used Model Type</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImpl#getConfigProperty <em>Config Property</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImpl#getOwnedRenaming <em>Owned Renaming</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImpl#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.eclipse.m2m.internal.qvt.oml.expressions.impl.ModuleImpl#getIntermediateProperty <em>Intermediate Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModuleImpl extends EClassImpl implements Module {
	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation"; //$NON-NLS-1$

    /**
	 * The default value of the '{@link #getNsURI() <em>Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsURI()
	 * @generated
	 * @ordered
	 */
	protected static final String NS_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNsURI() <em>Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsURI()
	 * @generated
	 * @ordered
	 */
	protected String nsURI = NS_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String NS_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected String nsPrefix = NS_PREFIX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEFactoryInstance() <em>EFactory Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEFactoryInstance()
	 * @generated
	 * @ordered
	 */
	protected EFactory eFactoryInstance;

	/**
	 * The cached value of the '{@link #getEClassifiers() <em>EClassifiers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClassifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<EClassifier> eClassifiers;

	/**
	 * The cached value of the '{@link #getESubpackages() <em>ESubpackages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getESubpackages()
	 * @generated
	 * @ordered
	 */
	protected EList<EPackage> eSubpackages;

	/**
	 * The default value of the '{@link #getStartPosition() <em>Start Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartPosition()
	 * @generated
	 * @ordered
	 */
	protected static final int START_POSITION_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getStartPosition() <em>Start Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartPosition()
	 * @generated
	 * @ordered
	 */
	protected int startPosition = START_POSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndPosition() <em>End Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndPosition()
	 * @generated
	 * @ordered
	 */
	protected static final int END_POSITION_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getEndPosition() <em>End Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndPosition()
	 * @generated
	 * @ordered
	 */
	protected int endPosition = END_POSITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModuleImport() <em>Module Import</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModuleImport()
	 * @generated
	 * @ordered
	 */
	protected EList<ModuleImport> moduleImport;

	/**
	 * The cached value of the '{@link #getUsedModelType() <em>Used Model Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedModelType()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelType> usedModelType;

	/**
	 * The cached value of the '{@link #getConfigProperty() <em>Config Property</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<EStructuralFeature> configProperty;

	/**
	 * The cached value of the '{@link #getOwnedRenaming() <em>Owned Renaming</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRenaming()
	 * @generated
	 * @ordered
	 */
	protected EList<Rename> ownedRenaming;

	/**
	 * The cached value of the '{@link #getEntry() <em>Entry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntry()
	 * @generated
	 * @ordered
	 */
	protected EOperation entry;

	/**
	 * The cached value of the '{@link #getIntermediateProperty() <em>Intermediate Property</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediateProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> intermediateProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNsURI() {
		return nsURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNsURI(String newNsURI) {
		String oldNsURI = nsURI;
		nsURI = newNsURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.MODULE__NS_URI, oldNsURI, nsURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNsPrefix() {
		return nsPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNsPrefix(String newNsPrefix) {
		String oldNsPrefix = nsPrefix;
		nsPrefix = newNsPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.MODULE__NS_PREFIX, oldNsPrefix, nsPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFactory getEFactoryInstance() {
		return eFactoryInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEFactoryInstance(EFactory newEFactoryInstance, NotificationChain msgs) {
		EFactory oldEFactoryInstance = eFactoryInstance;
		eFactoryInstance = newEFactoryInstance;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.MODULE__EFACTORY_INSTANCE, oldEFactoryInstance, newEFactoryInstance);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEFactoryInstance(EFactory newEFactoryInstance) {
		if (newEFactoryInstance != eFactoryInstance) {
			NotificationChain msgs = null;
			if (eFactoryInstance != null)
				msgs = ((InternalEObject)eFactoryInstance).eInverseRemove(this, EcorePackage.EFACTORY__EPACKAGE, EFactory.class, msgs);
			if (newEFactoryInstance != null)
				msgs = ((InternalEObject)newEFactoryInstance).eInverseAdd(this, EcorePackage.EFACTORY__EPACKAGE, EFactory.class, msgs);
			msgs = basicSetEFactoryInstance(newEFactoryInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.MODULE__EFACTORY_INSTANCE, newEFactoryInstance, newEFactoryInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClassifier> getEClassifiers() {
		if (eClassifiers == null) {
			eClassifiers = new EObjectContainmentWithInverseEList.Resolving<EClassifier>(EClassifier.class, this, ExpressionsPackage.MODULE__ECLASSIFIERS, EcorePackage.ECLASSIFIER__EPACKAGE);
		}
		return eClassifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EPackage> getESubpackages() {
		if (eSubpackages == null) {
			eSubpackages = new EObjectContainmentWithInverseEList.Resolving<EPackage>(EPackage.class, this, ExpressionsPackage.MODULE__ESUBPACKAGES, EcorePackage.EPACKAGE__ESUPER_PACKAGE);
		}
		return eSubpackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getESuperPackage() {
		if (eContainerFeatureID != ExpressionsPackage.MODULE__ESUPER_PACKAGE) return null;
		return (EPackage)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetESuperPackage() {
		if (eContainerFeatureID != ExpressionsPackage.MODULE__ESUPER_PACKAGE) return null;
		return (EPackage)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartPosition() {
		return startPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartPosition(int newStartPosition) {
		int oldStartPosition = startPosition;
		startPosition = newStartPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.MODULE__START_POSITION, oldStartPosition, startPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndPosition() {
		return endPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndPosition(int newEndPosition) {
		int oldEndPosition = endPosition;
		endPosition = newEndPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.MODULE__END_POSITION, oldEndPosition, endPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rename> getOwnedRenaming() {
		if (ownedRenaming == null) {
			ownedRenaming = new EObjectContainmentEList<Rename>(Rename.class, this, ExpressionsPackage.MODULE__OWNED_RENAMING);
		}
		return ownedRenaming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEntry() {
		if (entry != null && entry.eIsProxy()) {
			InternalEObject oldEntry = (InternalEObject)entry;
			entry = (EOperation)eResolveProxy(oldEntry);
			if (entry != oldEntry) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.MODULE__ENTRY, oldEntry, entry));
			}
		}
		return entry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation basicGetEntry() {
		return entry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntry(EOperation newEntry) {
		EOperation oldEntry = entry;
		entry = newEntry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.MODULE__ENTRY, oldEntry, entry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getIntermediateProperty() {
		if (intermediateProperty == null) {
			intermediateProperty = new EObjectResolvingEList<Property>(Property.class, this, ExpressionsPackage.MODULE__INTERMEDIATE_PROPERTY);
		}
		return intermediateProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EStructuralFeature> getConfigProperty() {
		if (configProperty == null) {
			configProperty = new EObjectResolvingEList<EStructuralFeature>(EStructuralFeature.class, this, ExpressionsPackage.MODULE__CONFIG_PROPERTY);
		}
		return configProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModuleImport> getModuleImport() {
		if (moduleImport == null) {
			moduleImport = new EObjectContainmentWithInverseEList<ModuleImport>(ModuleImport.class, this, ExpressionsPackage.MODULE__MODULE_IMPORT, ExpressionsPackage.MODULE_IMPORT__MODULE);
		}
		return moduleImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelType> getUsedModelType() {
		if (usedModelType == null) {
			usedModelType = new EObjectContainmentEList<ModelType>(ModelType.class, this, ExpressionsPackage.MODULE__USED_MODEL_TYPE);
		}
		return usedModelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
		return ((ExtendedVisitor<T, ?, ?, ?, ?>) v).visitModule(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EClassifier getEClassifier(String name) {
		for (EClassifier nextClassifier : getEClassifiers()) {
			String nextName = nextClassifier.getName();
			if(name != null ? name.equals(nextName) : name == nextName) {
				return nextClassifier;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.MODULE__EFACTORY_INSTANCE:
				if (eFactoryInstance != null)
					msgs = ((InternalEObject)eFactoryInstance).eInverseRemove(this, EcorePackage.EFACTORY__EPACKAGE, EFactory.class, msgs);
				return basicSetEFactoryInstance((EFactory)otherEnd, msgs);
			case ExpressionsPackage.MODULE__ECLASSIFIERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEClassifiers()).basicAdd(otherEnd, msgs);
			case ExpressionsPackage.MODULE__ESUBPACKAGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getESubpackages()).basicAdd(otherEnd, msgs);
			case ExpressionsPackage.MODULE__ESUPER_PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, ExpressionsPackage.MODULE__ESUPER_PACKAGE, msgs);
			case ExpressionsPackage.MODULE__MODULE_IMPORT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getModuleImport()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.MODULE__EFACTORY_INSTANCE:
				return basicSetEFactoryInstance(null, msgs);
			case ExpressionsPackage.MODULE__ECLASSIFIERS:
				return ((InternalEList<?>)getEClassifiers()).basicRemove(otherEnd, msgs);
			case ExpressionsPackage.MODULE__ESUBPACKAGES:
				return ((InternalEList<?>)getESubpackages()).basicRemove(otherEnd, msgs);
			case ExpressionsPackage.MODULE__ESUPER_PACKAGE:
				return eBasicSetContainer(null, ExpressionsPackage.MODULE__ESUPER_PACKAGE, msgs);
			case ExpressionsPackage.MODULE__MODULE_IMPORT:
				return ((InternalEList<?>)getModuleImport()).basicRemove(otherEnd, msgs);
			case ExpressionsPackage.MODULE__USED_MODEL_TYPE:
				return ((InternalEList<?>)getUsedModelType()).basicRemove(otherEnd, msgs);
			case ExpressionsPackage.MODULE__OWNED_RENAMING:
				return ((InternalEList<?>)getOwnedRenaming()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case ExpressionsPackage.MODULE__ESUPER_PACKAGE:
				return eInternalContainer().eInverseRemove(this, EcorePackage.EPACKAGE__ESUBPACKAGES, EPackage.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionsPackage.MODULE__NS_URI:
				return getNsURI();
			case ExpressionsPackage.MODULE__NS_PREFIX:
				return getNsPrefix();
			case ExpressionsPackage.MODULE__EFACTORY_INSTANCE:
				return getEFactoryInstance();
			case ExpressionsPackage.MODULE__ECLASSIFIERS:
				return getEClassifiers();
			case ExpressionsPackage.MODULE__ESUBPACKAGES:
				return getESubpackages();
			case ExpressionsPackage.MODULE__ESUPER_PACKAGE:
				if (resolve) return getESuperPackage();
				return basicGetESuperPackage();
			case ExpressionsPackage.MODULE__START_POSITION:
				return new Integer(getStartPosition());
			case ExpressionsPackage.MODULE__END_POSITION:
				return new Integer(getEndPosition());
			case ExpressionsPackage.MODULE__MODULE_IMPORT:
				return getModuleImport();
			case ExpressionsPackage.MODULE__USED_MODEL_TYPE:
				return getUsedModelType();
			case ExpressionsPackage.MODULE__CONFIG_PROPERTY:
				return getConfigProperty();
			case ExpressionsPackage.MODULE__OWNED_RENAMING:
				return getOwnedRenaming();
			case ExpressionsPackage.MODULE__ENTRY:
				if (resolve) return getEntry();
				return basicGetEntry();
			case ExpressionsPackage.MODULE__INTERMEDIATE_PROPERTY:
				return getIntermediateProperty();
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
			case ExpressionsPackage.MODULE__NS_URI:
				setNsURI((String)newValue);
				return;
			case ExpressionsPackage.MODULE__NS_PREFIX:
				setNsPrefix((String)newValue);
				return;
			case ExpressionsPackage.MODULE__EFACTORY_INSTANCE:
				setEFactoryInstance((EFactory)newValue);
				return;
			case ExpressionsPackage.MODULE__ECLASSIFIERS:
				getEClassifiers().clear();
				getEClassifiers().addAll((Collection<? extends EClassifier>)newValue);
				return;
			case ExpressionsPackage.MODULE__ESUBPACKAGES:
				getESubpackages().clear();
				getESubpackages().addAll((Collection<? extends EPackage>)newValue);
				return;
			case ExpressionsPackage.MODULE__START_POSITION:
				setStartPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.MODULE__END_POSITION:
				setEndPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.MODULE__MODULE_IMPORT:
				getModuleImport().clear();
				getModuleImport().addAll((Collection<? extends ModuleImport>)newValue);
				return;
			case ExpressionsPackage.MODULE__USED_MODEL_TYPE:
				getUsedModelType().clear();
				getUsedModelType().addAll((Collection<? extends ModelType>)newValue);
				return;
			case ExpressionsPackage.MODULE__CONFIG_PROPERTY:
				getConfigProperty().clear();
				getConfigProperty().addAll((Collection<? extends EStructuralFeature>)newValue);
				return;
			case ExpressionsPackage.MODULE__OWNED_RENAMING:
				getOwnedRenaming().clear();
				getOwnedRenaming().addAll((Collection<? extends Rename>)newValue);
				return;
			case ExpressionsPackage.MODULE__ENTRY:
				setEntry((EOperation)newValue);
				return;
			case ExpressionsPackage.MODULE__INTERMEDIATE_PROPERTY:
				getIntermediateProperty().clear();
				getIntermediateProperty().addAll((Collection<? extends Property>)newValue);
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
			case ExpressionsPackage.MODULE__NS_URI:
				setNsURI(NS_URI_EDEFAULT);
				return;
			case ExpressionsPackage.MODULE__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case ExpressionsPackage.MODULE__EFACTORY_INSTANCE:
				setEFactoryInstance((EFactory)null);
				return;
			case ExpressionsPackage.MODULE__ECLASSIFIERS:
				getEClassifiers().clear();
				return;
			case ExpressionsPackage.MODULE__ESUBPACKAGES:
				getESubpackages().clear();
				return;
			case ExpressionsPackage.MODULE__START_POSITION:
				setStartPosition(START_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.MODULE__END_POSITION:
				setEndPosition(END_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.MODULE__MODULE_IMPORT:
				getModuleImport().clear();
				return;
			case ExpressionsPackage.MODULE__USED_MODEL_TYPE:
				getUsedModelType().clear();
				return;
			case ExpressionsPackage.MODULE__CONFIG_PROPERTY:
				getConfigProperty().clear();
				return;
			case ExpressionsPackage.MODULE__OWNED_RENAMING:
				getOwnedRenaming().clear();
				return;
			case ExpressionsPackage.MODULE__ENTRY:
				setEntry((EOperation)null);
				return;
			case ExpressionsPackage.MODULE__INTERMEDIATE_PROPERTY:
				getIntermediateProperty().clear();
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
			case ExpressionsPackage.MODULE__NS_URI:
				return NS_URI_EDEFAULT == null ? nsURI != null : !NS_URI_EDEFAULT.equals(nsURI);
			case ExpressionsPackage.MODULE__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case ExpressionsPackage.MODULE__EFACTORY_INSTANCE:
				return eFactoryInstance != null;
			case ExpressionsPackage.MODULE__ECLASSIFIERS:
				return eClassifiers != null && !eClassifiers.isEmpty();
			case ExpressionsPackage.MODULE__ESUBPACKAGES:
				return eSubpackages != null && !eSubpackages.isEmpty();
			case ExpressionsPackage.MODULE__ESUPER_PACKAGE:
				return basicGetESuperPackage() != null;
			case ExpressionsPackage.MODULE__START_POSITION:
				return startPosition != START_POSITION_EDEFAULT;
			case ExpressionsPackage.MODULE__END_POSITION:
				return endPosition != END_POSITION_EDEFAULT;
			case ExpressionsPackage.MODULE__MODULE_IMPORT:
				return moduleImport != null && !moduleImport.isEmpty();
			case ExpressionsPackage.MODULE__USED_MODEL_TYPE:
				return usedModelType != null && !usedModelType.isEmpty();
			case ExpressionsPackage.MODULE__CONFIG_PROPERTY:
				return configProperty != null && !configProperty.isEmpty();
			case ExpressionsPackage.MODULE__OWNED_RENAMING:
				return ownedRenaming != null && !ownedRenaming.isEmpty();
			case ExpressionsPackage.MODULE__ENTRY:
				return entry != null;
			case ExpressionsPackage.MODULE__INTERMEDIATE_PROPERTY:
				return intermediateProperty != null && !intermediateProperty.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EPackage.class) {
			switch (derivedFeatureID) {
				case ExpressionsPackage.MODULE__NS_URI: return EcorePackage.EPACKAGE__NS_URI;
				case ExpressionsPackage.MODULE__NS_PREFIX: return EcorePackage.EPACKAGE__NS_PREFIX;
				case ExpressionsPackage.MODULE__EFACTORY_INSTANCE: return EcorePackage.EPACKAGE__EFACTORY_INSTANCE;
				case ExpressionsPackage.MODULE__ECLASSIFIERS: return EcorePackage.EPACKAGE__ECLASSIFIERS;
				case ExpressionsPackage.MODULE__ESUBPACKAGES: return EcorePackage.EPACKAGE__ESUBPACKAGES;
				case ExpressionsPackage.MODULE__ESUPER_PACKAGE: return EcorePackage.EPACKAGE__ESUPER_PACKAGE;
				default: return -1;
			}
		}
		if (baseClass == Visitable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ASTNode.class) {
			switch (derivedFeatureID) {
				case ExpressionsPackage.MODULE__START_POSITION: return UtilitiesPackage.AST_NODE__START_POSITION;
				case ExpressionsPackage.MODULE__END_POSITION: return UtilitiesPackage.AST_NODE__END_POSITION;
				default: return -1;
			}
		}
		if (baseClass == VisitableASTNode.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == EPackage.class) {
			switch (baseFeatureID) {
				case EcorePackage.EPACKAGE__NS_URI: return ExpressionsPackage.MODULE__NS_URI;
				case EcorePackage.EPACKAGE__NS_PREFIX: return ExpressionsPackage.MODULE__NS_PREFIX;
				case EcorePackage.EPACKAGE__EFACTORY_INSTANCE: return ExpressionsPackage.MODULE__EFACTORY_INSTANCE;
				case EcorePackage.EPACKAGE__ECLASSIFIERS: return ExpressionsPackage.MODULE__ECLASSIFIERS;
				case EcorePackage.EPACKAGE__ESUBPACKAGES: return ExpressionsPackage.MODULE__ESUBPACKAGES;
				case EcorePackage.EPACKAGE__ESUPER_PACKAGE: return ExpressionsPackage.MODULE__ESUPER_PACKAGE;
				default: return -1;
			}
		}
		if (baseClass == Visitable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ASTNode.class) {
			switch (baseFeatureID) {
				case UtilitiesPackage.AST_NODE__START_POSITION: return ExpressionsPackage.MODULE__START_POSITION;
				case UtilitiesPackage.AST_NODE__END_POSITION: return ExpressionsPackage.MODULE__END_POSITION;
				default: return -1;
			}
		}
		if (baseClass == VisitableASTNode.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public void freeze() {		
		super.freeze();
		
	    if (eClassifiers != null)
	    {
	      for (int i = 0, size = eClassifiers.size(); i < size; ++i)
	      {
	        freeze(eClassifiers.get(i));
	      }
	    }
	    if (eSubpackages != null)
	    {
	      for (int i = 0, size = eSubpackages.size(); i < size; ++i)
	      {
	        freeze(eSubpackages.get(i));
	      }
	    }		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (nsURI: "); //$NON-NLS-1$
		result.append(nsURI);
		result.append(", nsPrefix: "); //$NON-NLS-1$
		result.append(nsPrefix);
		result.append(", startPosition: "); //$NON-NLS-1$
		result.append(startPosition);
		result.append(", endPosition: "); //$NON-NLS-1$
		result.append(endPosition);
		result.append(')');
		return result.toString();
	}

} //ModuleImpl
