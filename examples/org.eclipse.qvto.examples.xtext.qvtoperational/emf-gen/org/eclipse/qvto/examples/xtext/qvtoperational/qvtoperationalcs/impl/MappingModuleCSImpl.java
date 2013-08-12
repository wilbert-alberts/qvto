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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.ElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierDefCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingMethodCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModulePropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToImportCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.RenameCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Mapping Module CS</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingModuleCSImpl#getHeaderCS <em>Header CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingModuleCSImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingModuleCSImpl#getMetamodels <em>Metamodels</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingModuleCSImpl#getRenamings <em>Renamings</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingModuleCSImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingModuleCSImpl#getMethods <em>Methods</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingModuleCSImpl#getClassifierDefCS <em>Classifier Def CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.MappingModuleCSImpl#getTags <em>Tags</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingModuleCSImpl
		extends ElementCSImpl
		implements MappingModuleCS {

	/**
	 * The cached value of the '{@link #getHeaderCS() <em>Header CS</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getHeaderCS()
	 * @generated
	 * @ordered
	 */
	protected TransformationCS headerCS;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<QVToImportCS> imports;

	/**
	 * The cached value of the '{@link #getMetamodels() <em>Metamodels</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMetamodels()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelTypeCS> metamodels;

	/**
	 * The cached value of the '{@link #getRenamings() <em>Renamings</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRenamings()
	 * @generated
	 * @ordered
	 */
	protected EList<RenameCS> renamings;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<ModulePropertyCS> properties;

	/**
	 * The cached value of the '{@link #getMethods() <em>Methods</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingMethodCS> methods;

	/**
	 * The cached value of the '{@link #getClassifierDefCS()
	 * <em>Classifier Def CS</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClassifierDefCS()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassifierDefCS> classifierDefCS;

	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected EList<TagCS> tags;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingModuleCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalCSPackage.Literals.MAPPING_MODULE_CS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationCS getHeaderCS() {
		return headerCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeaderCS(TransformationCS newHeaderCS, NotificationChain msgs) {
		TransformationCS oldHeaderCS = headerCS;
		headerCS = newHeaderCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MAPPING_MODULE_CS__HEADER_CS, oldHeaderCS, newHeaderCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeaderCS(TransformationCS newHeaderCS) {
		if (newHeaderCS != headerCS) {
			NotificationChain msgs = null;
			if (headerCS != null)
				msgs = ((InternalEObject)headerCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.MAPPING_MODULE_CS__HEADER_CS, null, msgs);
			if (newHeaderCS != null)
				msgs = ((InternalEObject)newHeaderCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.MAPPING_MODULE_CS__HEADER_CS, null, msgs);
			msgs = basicSetHeaderCS(newHeaderCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MAPPING_MODULE_CS__HEADER_CS, newHeaderCS, newHeaderCS));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<QVToImportCS> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<QVToImportCS>(QVToImportCS.class, this, QVTOperationalCSPackage.MAPPING_MODULE_CS__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelTypeCS> getMetamodels() {
		if (metamodels == null) {
			metamodels = new EObjectContainmentEList<ModelTypeCS>(ModelTypeCS.class, this, QVTOperationalCSPackage.MAPPING_MODULE_CS__METAMODELS);
		}
		return metamodels;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RenameCS> getRenamings() {
		if (renamings == null) {
			renamings = new EObjectContainmentEList<RenameCS>(RenameCS.class, this, QVTOperationalCSPackage.MAPPING_MODULE_CS__RENAMINGS);
		}
		return renamings;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModulePropertyCS> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<ModulePropertyCS>(ModulePropertyCS.class, this, QVTOperationalCSPackage.MAPPING_MODULE_CS__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingMethodCS> getMethods() {
		if (methods == null) {
			methods = new EObjectContainmentEList<MappingMethodCS>(MappingMethodCS.class, this, QVTOperationalCSPackage.MAPPING_MODULE_CS__METHODS);
		}
		return methods;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassifierDefCS> getClassifierDefCS() {
		if (classifierDefCS == null) {
			classifierDefCS = new EObjectContainmentEList<ClassifierDefCS>(ClassifierDefCS.class, this, QVTOperationalCSPackage.MAPPING_MODULE_CS__CLASSIFIER_DEF_CS);
		}
		return classifierDefCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TagCS> getTags() {
		if (tags == null) {
			tags = new EObjectContainmentEList<TagCS>(TagCS.class, this, QVTOperationalCSPackage.MAPPING_MODULE_CS__TAGS);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final QVTOperationalCSVisitor<R> v) {
		return v.visitMappingModuleCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final BaseCSVisitor<R> v) {
		return ((QVTOperationalCSVisitor<R>)v).visitMappingModuleCS(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__HEADER_CS:
				return basicSetHeaderCS(null, msgs);
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__METAMODELS:
				return ((InternalEList<?>)getMetamodels()).basicRemove(otherEnd, msgs);
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__RENAMINGS:
				return ((InternalEList<?>)getRenamings()).basicRemove(otherEnd, msgs);
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__METHODS:
				return ((InternalEList<?>)getMethods()).basicRemove(otherEnd, msgs);
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__CLASSIFIER_DEF_CS:
				return ((InternalEList<?>)getClassifierDefCS()).basicRemove(otherEnd, msgs);
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__TAGS:
				return ((InternalEList<?>)getTags()).basicRemove(otherEnd, msgs);
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
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__HEADER_CS:
				return getHeaderCS();
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__IMPORTS:
				return getImports();
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__METAMODELS:
				return getMetamodels();
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__RENAMINGS:
				return getRenamings();
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__PROPERTIES:
				return getProperties();
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__METHODS:
				return getMethods();
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__CLASSIFIER_DEF_CS:
				return getClassifierDefCS();
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__TAGS:
				return getTags();
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
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__HEADER_CS:
				setHeaderCS((TransformationCS)newValue);
				return;
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends QVToImportCS>)newValue);
				return;
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__METAMODELS:
				getMetamodels().clear();
				getMetamodels().addAll((Collection<? extends ModelTypeCS>)newValue);
				return;
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__RENAMINGS:
				getRenamings().clear();
				getRenamings().addAll((Collection<? extends RenameCS>)newValue);
				return;
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends ModulePropertyCS>)newValue);
				return;
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__METHODS:
				getMethods().clear();
				getMethods().addAll((Collection<? extends MappingMethodCS>)newValue);
				return;
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__CLASSIFIER_DEF_CS:
				getClassifierDefCS().clear();
				getClassifierDefCS().addAll((Collection<? extends ClassifierDefCS>)newValue);
				return;
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends TagCS>)newValue);
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
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__HEADER_CS:
				setHeaderCS((TransformationCS)null);
				return;
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__IMPORTS:
				getImports().clear();
				return;
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__METAMODELS:
				getMetamodels().clear();
				return;
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__RENAMINGS:
				getRenamings().clear();
				return;
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__PROPERTIES:
				getProperties().clear();
				return;
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__METHODS:
				getMethods().clear();
				return;
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__CLASSIFIER_DEF_CS:
				getClassifierDefCS().clear();
				return;
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__TAGS:
				getTags().clear();
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
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__HEADER_CS:
				return headerCS != null;
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__IMPORTS:
				return imports != null && !imports.isEmpty();
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__METAMODELS:
				return metamodels != null && !metamodels.isEmpty();
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__RENAMINGS:
				return renamings != null && !renamings.isEmpty();
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__METHODS:
				return methods != null && !methods.isEmpty();
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__CLASSIFIER_DEF_CS:
				return classifierDefCS != null && !classifierDefCS.isEmpty();
			case QVTOperationalCSPackage.MAPPING_MODULE_CS__TAGS:
				return tags != null && !tags.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // MappingModuleCSImpl
