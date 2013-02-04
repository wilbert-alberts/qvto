/**
 * <copyright>
 * Copyright (c) 2013 Willink Transformations, University of York, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Adolfo Sanchez-Barbudo (University of York) - Bug397429
 * </copyright>
 */
package org.eclipse.qvto.examples.pivot.qvtoperational.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import org.eclipse.ocl.examples.domain.ids.PackageId;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;

import org.eclipse.ocl.examples.pivot.internal.impl.ClassImpl;

import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.qvto.examples.pivot.qvtoperational.EntryOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModelType;
import org.eclipse.qvto.examples.pivot.qvtoperational.Module;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModuleImport;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage;
import org.eclipse.qvto.examples.pivot.qvtoperational.util.QVTOperationalVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModuleImpl#getNestedPackage <em>Nested Package</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModuleImpl#getNestingPackage <em>Nesting Package</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModuleImpl#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModuleImpl#getNsURI <em>Ns URI</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModuleImpl#getImportedPackage <em>Imported Package</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModuleImpl#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModuleImpl#getConfigProperty <em>Config Property</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModuleImpl#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModuleImpl#isIsBlackbox <em>Is Blackbox</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModuleImpl#getModuleImport <em>Module Import</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModuleImpl#getOwnedTag <em>Owned Tag</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModuleImpl#getOwnedVariable <em>Owned Variable</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.pivot.qvtoperational.impl.ModuleImpl#getUsedModelType <em>Used Model Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModuleImpl extends ClassImpl implements Module {
	/**
	 * The cached value of the '{@link #getNestedPackage() <em>Nested Package</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedPackage()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.examples.pivot.Package> nestedPackage;

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
	 * The cached value of the '{@link #getImportedPackage() <em>Imported Package</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedPackage()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.ocl.examples.pivot.Package> importedPackage;

	/**
	 * The cached value of the '{@link #getOwnedType() <em>Owned Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedType()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> ownedType;

	/**
	 * The cached value of the '{@link #getConfigProperty() <em>Config Property</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> configProperty;

	/**
	 * The cached value of the '{@link #getEntry() <em>Entry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntry()
	 * @generated
	 * @ordered
	 */
	protected EntryOperation entry;

	/**
	 * The default value of the '{@link #isIsBlackbox() <em>Is Blackbox</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsBlackbox()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_BLACKBOX_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsBlackbox() <em>Is Blackbox</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsBlackbox()
	 * @generated
	 * @ordered
	 */
	protected boolean isBlackbox = IS_BLACKBOX_EDEFAULT;

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
	 * The cached value of the '{@link #getOwnedTag() <em>Owned Tag</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTag()
	 * @generated
	 * @ordered
	 */
	protected EList<TemplateableElement> ownedTag;

	/**
	 * The cached value of the '{@link #getOwnedVariable() <em>Owned Variable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedVariable()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> ownedVariable;

	/**
	 * The cached value of the '{@link #getUsedModelType() <em>Used Model Type</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedModelType()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelType> usedModelType;

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
		return QVTOperationalPackage.Literals.MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<org.eclipse.ocl.examples.pivot.Package> getNestedPackage() {
		if (nestedPackage == null) {
			nestedPackage = new EObjectContainmentWithInverseEList<org.eclipse.ocl.examples.pivot.Package>(org.eclipse.ocl.examples.pivot.Package.class, this, QVTOperationalPackage.MODULE__NESTED_PACKAGE, PivotPackage.PACKAGE__NESTING_PACKAGE);
		}
		return nestedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.examples.pivot.Package getNestingPackage() {
		if (eContainerFeatureID() != QVTOperationalPackage.MODULE__NESTING_PACKAGE) return null;
		return (org.eclipse.ocl.examples.pivot.Package)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNestingPackage(org.eclipse.ocl.examples.pivot.Package newNestingPackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newNestingPackage, QVTOperationalPackage.MODULE__NESTING_PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNestingPackage(org.eclipse.ocl.examples.pivot.Package newNestingPackage) {
		if (newNestingPackage != eInternalContainer() || (eContainerFeatureID() != QVTOperationalPackage.MODULE__NESTING_PACKAGE && newNestingPackage != null)) {
			if (EcoreUtil.isAncestor(this, (EObject)newNestingPackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newNestingPackage != null)
				msgs = ((InternalEObject)newNestingPackage).eInverseAdd(this, PivotPackage.PACKAGE__NESTED_PACKAGE, org.eclipse.ocl.examples.pivot.Package.class, msgs);
			msgs = basicSetNestingPackage(newNestingPackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MODULE__NESTING_PACKAGE, newNestingPackage, newNestingPackage));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MODULE__NS_PREFIX, oldNsPrefix, nsPrefix));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MODULE__NS_URI, oldNsURI, nsURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<org.eclipse.ocl.examples.pivot.Package> getImportedPackage() {
		if (importedPackage == null) {
			importedPackage = new EObjectResolvingEList<org.eclipse.ocl.examples.pivot.Package>(org.eclipse.ocl.examples.pivot.Package.class, this, QVTOperationalPackage.MODULE__IMPORTED_PACKAGE);
		}
		return importedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Type> getOwnedType() {
		if (ownedType == null) {
			ownedType = new EObjectContainmentWithInverseEList<Type>(Type.class, this, QVTOperationalPackage.MODULE__OWNED_TYPE, PivotPackage.TYPE__PACKAGE);
		}
		return ownedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getConfigProperty() {
		if (configProperty == null) {
			configProperty = new EObjectResolvingEList<Property>(Property.class, this, QVTOperationalPackage.MODULE__CONFIG_PROPERTY);
		}
		return configProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryOperation getEntry() {
		if (entry != null && entry.eIsProxy()) {
			InternalEObject oldEntry = (InternalEObject)entry;
			entry = (EntryOperation)eResolveProxy(oldEntry);
			if (entry != oldEntry) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTOperationalPackage.MODULE__ENTRY, oldEntry, entry));
			}
		}
		return entry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryOperation basicGetEntry() {
		return entry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntry(EntryOperation newEntry) {
		EntryOperation oldEntry = entry;
		entry = newEntry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MODULE__ENTRY, oldEntry, entry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsBlackbox() {
		return isBlackbox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsBlackbox(boolean newIsBlackbox) {
		boolean oldIsBlackbox = isBlackbox;
		isBlackbox = newIsBlackbox;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.MODULE__IS_BLACKBOX, oldIsBlackbox, isBlackbox));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModuleImport> getModuleImport() {
		if (moduleImport == null) {
			moduleImport = new EObjectContainmentWithInverseEList<ModuleImport>(ModuleImport.class, this, QVTOperationalPackage.MODULE__MODULE_IMPORT, QVTOperationalPackage.MODULE_IMPORT__MODULE);
		}
		return moduleImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TemplateableElement> getOwnedTag() {
		if (ownedTag == null) {
			ownedTag = new EObjectContainmentEList<TemplateableElement>(TemplateableElement.class, this, QVTOperationalPackage.MODULE__OWNED_TAG);
		}
		return ownedTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getOwnedVariable() {
		if (ownedVariable == null) {
			ownedVariable = new EObjectContainmentEList<Variable>(Variable.class, this, QVTOperationalPackage.MODULE__OWNED_VARIABLE);
		}
		return ownedVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelType> getUsedModelType() {
		if (usedModelType == null) {
			usedModelType = new EObjectResolvingEList<ModelType>(ModelType.class, this, QVTOperationalPackage.MODULE__USED_MODEL_TYPE);
		}
		return usedModelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R> R accept(final QVTOperationalVisitor<R> v) {
		return v.visitModule(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R> R accept(final Visitor<R> v) {
		return ((QVTOperationalVisitor<R>)v).visitModule(this);
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
			case QVTOperationalPackage.MODULE__NESTED_PACKAGE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNestedPackage()).basicAdd(otherEnd, msgs);
			case QVTOperationalPackage.MODULE__NESTING_PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetNestingPackage((org.eclipse.ocl.examples.pivot.Package)otherEnd, msgs);
			case QVTOperationalPackage.MODULE__OWNED_TYPE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedType()).basicAdd(otherEnd, msgs);
			case QVTOperationalPackage.MODULE__MODULE_IMPORT:
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
			case QVTOperationalPackage.MODULE__NESTED_PACKAGE:
				return ((InternalEList<?>)getNestedPackage()).basicRemove(otherEnd, msgs);
			case QVTOperationalPackage.MODULE__NESTING_PACKAGE:
				return basicSetNestingPackage(null, msgs);
			case QVTOperationalPackage.MODULE__OWNED_TYPE:
				return ((InternalEList<?>)getOwnedType()).basicRemove(otherEnd, msgs);
			case QVTOperationalPackage.MODULE__MODULE_IMPORT:
				return ((InternalEList<?>)getModuleImport()).basicRemove(otherEnd, msgs);
			case QVTOperationalPackage.MODULE__OWNED_TAG:
				return ((InternalEList<?>)getOwnedTag()).basicRemove(otherEnd, msgs);
			case QVTOperationalPackage.MODULE__OWNED_VARIABLE:
				return ((InternalEList<?>)getOwnedVariable()).basicRemove(otherEnd, msgs);
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
		switch (eContainerFeatureID()) {
			case QVTOperationalPackage.MODULE__NESTING_PACKAGE:
				return eInternalContainer().eInverseRemove(this, PivotPackage.PACKAGE__NESTED_PACKAGE, org.eclipse.ocl.examples.pivot.Package.class, msgs);
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
			case QVTOperationalPackage.MODULE__NESTED_PACKAGE:
				return getNestedPackage();
			case QVTOperationalPackage.MODULE__NESTING_PACKAGE:
				return getNestingPackage();
			case QVTOperationalPackage.MODULE__NS_PREFIX:
				return getNsPrefix();
			case QVTOperationalPackage.MODULE__NS_URI:
				return getNsURI();
			case QVTOperationalPackage.MODULE__IMPORTED_PACKAGE:
				return getImportedPackage();
			case QVTOperationalPackage.MODULE__OWNED_TYPE:
				return getOwnedType();
			case QVTOperationalPackage.MODULE__CONFIG_PROPERTY:
				return getConfigProperty();
			case QVTOperationalPackage.MODULE__ENTRY:
				if (resolve) return getEntry();
				return basicGetEntry();
			case QVTOperationalPackage.MODULE__IS_BLACKBOX:
				return isIsBlackbox();
			case QVTOperationalPackage.MODULE__MODULE_IMPORT:
				return getModuleImport();
			case QVTOperationalPackage.MODULE__OWNED_TAG:
				return getOwnedTag();
			case QVTOperationalPackage.MODULE__OWNED_VARIABLE:
				return getOwnedVariable();
			case QVTOperationalPackage.MODULE__USED_MODEL_TYPE:
				return getUsedModelType();
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
			case QVTOperationalPackage.MODULE__NESTED_PACKAGE:
				getNestedPackage().clear();
				getNestedPackage().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Package>)newValue);
				return;
			case QVTOperationalPackage.MODULE__NESTING_PACKAGE:
				setNestingPackage((org.eclipse.ocl.examples.pivot.Package)newValue);
				return;
			case QVTOperationalPackage.MODULE__NS_PREFIX:
				setNsPrefix((String)newValue);
				return;
			case QVTOperationalPackage.MODULE__NS_URI:
				setNsURI((String)newValue);
				return;
			case QVTOperationalPackage.MODULE__IMPORTED_PACKAGE:
				getImportedPackage().clear();
				getImportedPackage().addAll((Collection<? extends org.eclipse.ocl.examples.pivot.Package>)newValue);
				return;
			case QVTOperationalPackage.MODULE__OWNED_TYPE:
				getOwnedType().clear();
				getOwnedType().addAll((Collection<? extends Type>)newValue);
				return;
			case QVTOperationalPackage.MODULE__CONFIG_PROPERTY:
				getConfigProperty().clear();
				getConfigProperty().addAll((Collection<? extends Property>)newValue);
				return;
			case QVTOperationalPackage.MODULE__ENTRY:
				setEntry((EntryOperation)newValue);
				return;
			case QVTOperationalPackage.MODULE__IS_BLACKBOX:
				setIsBlackbox((Boolean)newValue);
				return;
			case QVTOperationalPackage.MODULE__MODULE_IMPORT:
				getModuleImport().clear();
				getModuleImport().addAll((Collection<? extends ModuleImport>)newValue);
				return;
			case QVTOperationalPackage.MODULE__OWNED_TAG:
				getOwnedTag().clear();
				getOwnedTag().addAll((Collection<? extends TemplateableElement>)newValue);
				return;
			case QVTOperationalPackage.MODULE__OWNED_VARIABLE:
				getOwnedVariable().clear();
				getOwnedVariable().addAll((Collection<? extends Variable>)newValue);
				return;
			case QVTOperationalPackage.MODULE__USED_MODEL_TYPE:
				getUsedModelType().clear();
				getUsedModelType().addAll((Collection<? extends ModelType>)newValue);
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
			case QVTOperationalPackage.MODULE__NESTED_PACKAGE:
				getNestedPackage().clear();
				return;
			case QVTOperationalPackage.MODULE__NESTING_PACKAGE:
				setNestingPackage((org.eclipse.ocl.examples.pivot.Package)null);
				return;
			case QVTOperationalPackage.MODULE__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case QVTOperationalPackage.MODULE__NS_URI:
				setNsURI(NS_URI_EDEFAULT);
				return;
			case QVTOperationalPackage.MODULE__IMPORTED_PACKAGE:
				getImportedPackage().clear();
				return;
			case QVTOperationalPackage.MODULE__OWNED_TYPE:
				getOwnedType().clear();
				return;
			case QVTOperationalPackage.MODULE__CONFIG_PROPERTY:
				getConfigProperty().clear();
				return;
			case QVTOperationalPackage.MODULE__ENTRY:
				setEntry((EntryOperation)null);
				return;
			case QVTOperationalPackage.MODULE__IS_BLACKBOX:
				setIsBlackbox(IS_BLACKBOX_EDEFAULT);
				return;
			case QVTOperationalPackage.MODULE__MODULE_IMPORT:
				getModuleImport().clear();
				return;
			case QVTOperationalPackage.MODULE__OWNED_TAG:
				getOwnedTag().clear();
				return;
			case QVTOperationalPackage.MODULE__OWNED_VARIABLE:
				getOwnedVariable().clear();
				return;
			case QVTOperationalPackage.MODULE__USED_MODEL_TYPE:
				getUsedModelType().clear();
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
			case QVTOperationalPackage.MODULE__NESTED_PACKAGE:
				return nestedPackage != null && !nestedPackage.isEmpty();
			case QVTOperationalPackage.MODULE__NESTING_PACKAGE:
				return getNestingPackage() != null;
			case QVTOperationalPackage.MODULE__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case QVTOperationalPackage.MODULE__NS_URI:
				return NS_URI_EDEFAULT == null ? nsURI != null : !NS_URI_EDEFAULT.equals(nsURI);
			case QVTOperationalPackage.MODULE__IMPORTED_PACKAGE:
				return importedPackage != null && !importedPackage.isEmpty();
			case QVTOperationalPackage.MODULE__OWNED_TYPE:
				return ownedType != null && !ownedType.isEmpty();
			case QVTOperationalPackage.MODULE__CONFIG_PROPERTY:
				return configProperty != null && !configProperty.isEmpty();
			case QVTOperationalPackage.MODULE__ENTRY:
				return entry != null;
			case QVTOperationalPackage.MODULE__IS_BLACKBOX:
				return isBlackbox != IS_BLACKBOX_EDEFAULT;
			case QVTOperationalPackage.MODULE__MODULE_IMPORT:
				return moduleImport != null && !moduleImport.isEmpty();
			case QVTOperationalPackage.MODULE__OWNED_TAG:
				return ownedTag != null && !ownedTag.isEmpty();
			case QVTOperationalPackage.MODULE__OWNED_VARIABLE:
				return ownedVariable != null && !ownedVariable.isEmpty();
			case QVTOperationalPackage.MODULE__USED_MODEL_TYPE:
				return usedModelType != null && !usedModelType.isEmpty();
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
		if (baseClass == org.eclipse.ocl.examples.pivot.Package.class) {
			switch (derivedFeatureID) {
				case QVTOperationalPackage.MODULE__NESTED_PACKAGE: return PivotPackage.PACKAGE__NESTED_PACKAGE;
				case QVTOperationalPackage.MODULE__NESTING_PACKAGE: return PivotPackage.PACKAGE__NESTING_PACKAGE;
				case QVTOperationalPackage.MODULE__NS_PREFIX: return PivotPackage.PACKAGE__NS_PREFIX;
				case QVTOperationalPackage.MODULE__NS_URI: return PivotPackage.PACKAGE__NS_URI;
				case QVTOperationalPackage.MODULE__IMPORTED_PACKAGE: return PivotPackage.PACKAGE__IMPORTED_PACKAGE;
				case QVTOperationalPackage.MODULE__OWNED_TYPE: return PivotPackage.PACKAGE__OWNED_TYPE;
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
		if (baseClass == org.eclipse.ocl.examples.pivot.Package.class) {
			switch (baseFeatureID) {
				case PivotPackage.PACKAGE__NESTED_PACKAGE: return QVTOperationalPackage.MODULE__NESTED_PACKAGE;
				case PivotPackage.PACKAGE__NESTING_PACKAGE: return QVTOperationalPackage.MODULE__NESTING_PACKAGE;
				case PivotPackage.PACKAGE__NS_PREFIX: return QVTOperationalPackage.MODULE__NS_PREFIX;
				case PivotPackage.PACKAGE__NS_URI: return QVTOperationalPackage.MODULE__NS_URI;
				case PivotPackage.PACKAGE__IMPORTED_PACKAGE: return QVTOperationalPackage.MODULE__IMPORTED_PACKAGE;
				case PivotPackage.PACKAGE__OWNED_TYPE: return QVTOperationalPackage.MODULE__OWNED_TYPE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings({"rawtypes", "unchecked" })
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case QVTOperationalPackage.MODULE___ACCEPT__QVTOPERATIONALVISITOR:
				return accept((QVTOperationalVisitor)arguments.get(0));
			case QVTOperationalPackage.MODULE___ACCEPT__VISITOR:
				return accept((Visitor)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (nsPrefix: ");
		result.append(nsPrefix);
		result.append(", nsURI: ");
		result.append(nsURI);
		result.append(", isBlackbox: ");
		result.append(isBlackbox);
		result.append(')');
		return result.toString();
	}

	public Package createNestedPackage(EClass eClass) {
		// FIXME See Bug398955
		throw new UnsupportedOperationException(); 

	}

	public Package createNestedPackage() {
		// FIXME See Bug398955
		throw new UnsupportedOperationException(); 

	}

	public Type createOwnedType(EClass eClass) {
		// FIXME See Bug398955
		throw new UnsupportedOperationException(); 

	}

	public Type createOwnedType() {
		// FIXME See Bug398955
		throw new UnsupportedOperationException(); 

	}

	@Nullable
	public EPackage getEPackage() {
		// FIXME See Bug398955
		throw new UnsupportedOperationException(); 
	}

	@NonNull
	public PackageId getPackageId() {
		// FIXME See Bug398955
		throw new UnsupportedOperationException(); 
	}

} //ModuleImpl
