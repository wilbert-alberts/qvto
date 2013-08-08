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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PathNameCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateableElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.PackageCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS;
import org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterDeclarationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationHeaderCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationRefineCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Transformation Header CS</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationHeaderCSImpl#getOwnedTemplateSignature <em>Owned Template Signature</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationHeaderCSImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationHeaderCSImpl#getInstanceClassName <em>Instance Class Name</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationHeaderCSImpl#getOwnedConstraint <em>Owned Constraint</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationHeaderCSImpl#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationHeaderCSImpl#getOwnedSuperType <em>Owned Super Type</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationHeaderCSImpl#getOwnedOperation <em>Owned Operation</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationHeaderCSImpl#getOwnedProperty <em>Owned Property</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationHeaderCSImpl#getOwnedMetaType <em>Owned Meta Type</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationHeaderCSImpl#getQualifiers <em>Qualifiers</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationHeaderCSImpl#getPathNameCS <em>Path Name CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationHeaderCSImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationHeaderCSImpl#getModuleUsages <em>Module Usages</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl.TransformationHeaderCSImpl#getTransformationRefineCS <em>Transformation Refine CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformationHeaderCSImpl
		extends PackageCSImpl
		implements TransformationHeaderCS {

	/**
	 * The cached value of the '{@link #getOwnedTemplateSignature() <em>Owned Template Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTemplateSignature()
	 * @generated
	 * @ordered
	 */
	protected TemplateSignatureCS ownedTemplateSignature;

	/**
	 * The default value of the '{@link #getInstanceClassName() <em>Instance Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTANCE_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstanceClassName() <em>Instance Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceClassName()
	 * @generated
	 * @ordered
	 */
	protected String instanceClassName = INSTANCE_CLASS_NAME_EDEFAULT;

	/**
	 * This is true if the Instance Class Name attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean instanceClassNameESet;

	/**
	 * The cached value of the '{@link #getOwnedConstraint() <em>Owned Constraint</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstraintCS> ownedConstraint;

	/**
	 * The cached value of the '{@link #getQualifier() <em>Qualifier</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifier()
	 * @generated
	 * @ordered
	 */
	protected EList<String> qualifier;

	/**
	 * The cached value of the '{@link #getOwnedSuperType() <em>Owned Super Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSuperType()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedRefCS> ownedSuperType;

	/**
	 * The cached value of the '{@link #getOwnedOperation() <em>Owned Operation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedOperation()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationCS> ownedOperation;

	/**
	 * The cached value of the '{@link #getOwnedProperty() <em>Owned Property</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<StructuralFeatureCS> ownedProperty;

	/**
	 * The cached value of the '{@link #getOwnedMetaType() <em>Owned Meta Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMetaType()
	 * @generated
	 * @ordered
	 */
	protected TypedRefCS ownedMetaType;

	/**
	 * The cached value of the '{@link #getQualifiers() <em>Qualifiers</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getQualifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<StringLiteralExpCS> qualifiers;

	/**
	 * The cached value of the '{@link #getPathNameCS() <em>Path Name CS</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPathNameCS()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS pathNameCS;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterDeclarationCS> parameters;

	/**
	 * The cached value of the '{@link #getModuleUsages() <em>Module Usages</em>}' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getModuleUsages()
	 * @generated
	 * @ordered
	 */
	protected EList<ModuleUsageCS> moduleUsages;

	/**
	 * The cached value of the '{@link #getTransformationRefineCS()
	 * <em>Transformation Refine CS</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTransformationRefineCS()
	 * @generated
	 * @ordered
	 */
	protected TransformationRefineCS transformationRefineCS;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationHeaderCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalCSPackage.Literals.TRANSFORMATION_HEADER_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateSignatureCS getOwnedTemplateSignature() {
		return ownedTemplateSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedTemplateSignature(TemplateSignatureCS newOwnedTemplateSignature, NotificationChain msgs) {
		TemplateSignatureCS oldOwnedTemplateSignature = ownedTemplateSignature;
		ownedTemplateSignature = newOwnedTemplateSignature;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_TEMPLATE_SIGNATURE, oldOwnedTemplateSignature, newOwnedTemplateSignature);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedTemplateSignature(TemplateSignatureCS newOwnedTemplateSignature) {
		if (newOwnedTemplateSignature != ownedTemplateSignature) {
			NotificationChain msgs = null;
			if (ownedTemplateSignature != null)
				msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT, TemplateSignatureCS.class, msgs);
			if (newOwnedTemplateSignature != null)
				msgs = ((InternalEObject)newOwnedTemplateSignature).eInverseAdd(this, BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT, TemplateSignatureCS.class, msgs);
			msgs = basicSetOwnedTemplateSignature(newOwnedTemplateSignature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_TEMPLATE_SIGNATURE, newOwnedTemplateSignature, newOwnedTemplateSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageCS getOwner() {
		if (eContainerFeatureID() != QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNER) return null;
		return (PackageCS)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(PackageCS newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(PackageCS newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, BaseCSTPackage.PACKAGE_CS__OWNED_TYPE, PackageCS.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstanceClassName() {
		return instanceClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceClassName(String newInstanceClassName) {
		String oldInstanceClassName = instanceClassName;
		instanceClassName = newInstanceClassName;
		boolean oldInstanceClassNameESet = instanceClassNameESet;
		instanceClassNameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__INSTANCE_CLASS_NAME, oldInstanceClassName, instanceClassName, !oldInstanceClassNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInstanceClassName() {
		String oldInstanceClassName = instanceClassName;
		boolean oldInstanceClassNameESet = instanceClassNameESet;
		instanceClassName = INSTANCE_CLASS_NAME_EDEFAULT;
		instanceClassNameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__INSTANCE_CLASS_NAME, oldInstanceClassName, INSTANCE_CLASS_NAME_EDEFAULT, oldInstanceClassNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInstanceClassName() {
		return instanceClassNameESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstraintCS> getOwnedConstraint() {
		if (ownedConstraint == null) {
			ownedConstraint = new EObjectContainmentEList<ConstraintCS>(ConstraintCS.class, this, QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_CONSTRAINT);
		}
		return ownedConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getQualifier() {
		if (qualifier == null) {
			qualifier = new EDataTypeUniqueEList<String>(String.class, this, QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__QUALIFIER);
		}
		return qualifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedRefCS> getOwnedSuperType() {
		if (ownedSuperType == null) {
			ownedSuperType = new EObjectContainmentEList.Unsettable<TypedRefCS>(TypedRefCS.class, this, QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_SUPER_TYPE);
		}
		return ownedSuperType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOwnedSuperType() {
		if (ownedSuperType != null) ((InternalEList.Unsettable<?>)ownedSuperType).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedSuperType() {
		return ownedSuperType != null && ((InternalEList.Unsettable<?>)ownedSuperType).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationCS> getOwnedOperation() {
		if (ownedOperation == null) {
			ownedOperation = new EObjectContainmentWithInverseEList<OperationCS>(OperationCS.class, this, QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_OPERATION, BaseCSTPackage.OPERATION_CS__OWNING_CLASS);
		}
		return ownedOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StructuralFeatureCS> getOwnedProperty() {
		if (ownedProperty == null) {
			ownedProperty = new EObjectContainmentWithInverseEList<StructuralFeatureCS>(StructuralFeatureCS.class, this, QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_PROPERTY, BaseCSTPackage.STRUCTURAL_FEATURE_CS__OWNER);
		}
		return ownedProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedRefCS getOwnedMetaType() {
		return ownedMetaType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedMetaType(TypedRefCS newOwnedMetaType, NotificationChain msgs) {
		TypedRefCS oldOwnedMetaType = ownedMetaType;
		ownedMetaType = newOwnedMetaType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_META_TYPE, oldOwnedMetaType, newOwnedMetaType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedMetaType(TypedRefCS newOwnedMetaType) {
		if (newOwnedMetaType != ownedMetaType) {
			NotificationChain msgs = null;
			if (ownedMetaType != null)
				msgs = ((InternalEObject)ownedMetaType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_META_TYPE, null, msgs);
			if (newOwnedMetaType != null)
				msgs = ((InternalEObject)newOwnedMetaType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_META_TYPE, null, msgs);
			msgs = basicSetOwnedMetaType(newOwnedMetaType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_META_TYPE, newOwnedMetaType, newOwnedMetaType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StringLiteralExpCS> getQualifiers() {
		if (qualifiers == null) {
			qualifiers = new EObjectContainmentEList<StringLiteralExpCS>(StringLiteralExpCS.class, this, QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__QUALIFIERS);
		}
		return qualifiers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getPathNameCS() {
		return pathNameCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPathNameCS(PathNameCS newPathNameCS,
			NotificationChain msgs) {
		PathNameCS oldPathNameCS = pathNameCS;
		pathNameCS = newPathNameCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__PATH_NAME_CS, oldPathNameCS, newPathNameCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathNameCS(PathNameCS newPathNameCS) {
		if (newPathNameCS != pathNameCS) {
			NotificationChain msgs = null;
			if (pathNameCS != null)
				msgs = ((InternalEObject)pathNameCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__PATH_NAME_CS, null, msgs);
			if (newPathNameCS != null)
				msgs = ((InternalEObject)newPathNameCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__PATH_NAME_CS, null, msgs);
			msgs = basicSetPathNameCS(newPathNameCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__PATH_NAME_CS, newPathNameCS, newPathNameCS));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterDeclarationCS> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<ParameterDeclarationCS>(ParameterDeclarationCS.class, this, QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModuleUsageCS> getModuleUsages() {
		if (moduleUsages == null) {
			moduleUsages = new EObjectContainmentEList<ModuleUsageCS>(ModuleUsageCS.class, this, QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__MODULE_USAGES);
		}
		return moduleUsages;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationRefineCS getTransformationRefineCS() {
		return transformationRefineCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransformationRefineCS(
			TransformationRefineCS newTransformationRefineCS,
			NotificationChain msgs) {
		TransformationRefineCS oldTransformationRefineCS = transformationRefineCS;
		transformationRefineCS = newTransformationRefineCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS, oldTransformationRefineCS, newTransformationRefineCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransformationRefineCS(
			TransformationRefineCS newTransformationRefineCS) {
		if (newTransformationRefineCS != transformationRefineCS) {
			NotificationChain msgs = null;
			if (transformationRefineCS != null)
				msgs = ((InternalEObject)transformationRefineCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS, null, msgs);
			if (newTransformationRefineCS != null)
				msgs = ((InternalEObject)newTransformationRefineCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS, null, msgs);
			msgs = basicSetTransformationRefineCS(newTransformationRefineCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS, newTransformationRefineCS, newTransformationRefineCS));
	}

	/**
	 * The cached invocation delegate for the '{@link #ast() <em>Ast</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ast()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate AST__EINVOCATION_DELEGATE = ((EOperation.Internal)QVTOperationalCSPackage.Literals.TRANSFORMATION_HEADER_CS.getEOperations().get(0)).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationalTransformation ast() {
		try {
			return (OperationalTransformation)AST__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return super.toString();
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
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_TEMPLATE_SIGNATURE:
				if (ownedTemplateSignature != null)
					msgs = ((InternalEObject)ownedTemplateSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_TEMPLATE_SIGNATURE, null, msgs);
				return basicSetOwnedTemplateSignature((TemplateSignatureCS)otherEnd, msgs);
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((PackageCS)otherEnd, msgs);
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_OPERATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedOperation()).basicAdd(otherEnd, msgs);
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_PROPERTY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedProperty()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final QVTOperationalCSVisitor<R> v) {
		return v.visitTransformationHeaderCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @added
	 */
	public <R> R accept(final BaseCSVisitor<R> v) {
		return ((QVTOperationalCSVisitor<R>)v).visitTransformationHeaderCS(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_TEMPLATE_SIGNATURE:
				return basicSetOwnedTemplateSignature(null, msgs);
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNER:
				return basicSetOwner(null, msgs);
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_CONSTRAINT:
				return ((InternalEList<?>)getOwnedConstraint()).basicRemove(otherEnd, msgs);
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_SUPER_TYPE:
				return ((InternalEList<?>)getOwnedSuperType()).basicRemove(otherEnd, msgs);
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_OPERATION:
				return ((InternalEList<?>)getOwnedOperation()).basicRemove(otherEnd, msgs);
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_PROPERTY:
				return ((InternalEList<?>)getOwnedProperty()).basicRemove(otherEnd, msgs);
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_META_TYPE:
				return basicSetOwnedMetaType(null, msgs);
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__QUALIFIERS:
				return ((InternalEList<?>)getQualifiers()).basicRemove(otherEnd, msgs);
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__PATH_NAME_CS:
				return basicSetPathNameCS(null, msgs);
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__MODULE_USAGES:
				return ((InternalEList<?>)getModuleUsages()).basicRemove(otherEnd, msgs);
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS:
				return basicSetTransformationRefineCS(null, msgs);
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
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNER:
				return eInternalContainer().eInverseRemove(this, BaseCSTPackage.PACKAGE_CS__OWNED_TYPE, PackageCS.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_TEMPLATE_SIGNATURE:
				return getOwnedTemplateSignature();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNER:
				return getOwner();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_CONSTRAINT:
				return getOwnedConstraint();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__QUALIFIER:
				return getQualifier();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_SUPER_TYPE:
				return getOwnedSuperType();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_OPERATION:
				return getOwnedOperation();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_PROPERTY:
				return getOwnedProperty();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_META_TYPE:
				return getOwnedMetaType();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__QUALIFIERS:
				return getQualifiers();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__PATH_NAME_CS:
				return getPathNameCS();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__PARAMETERS:
				return getParameters();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__MODULE_USAGES:
				return getModuleUsages();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS:
				return getTransformationRefineCS();
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
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignatureCS)newValue);
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNER:
				setOwner((PackageCS)newValue);
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_CONSTRAINT:
				getOwnedConstraint().clear();
				getOwnedConstraint().addAll((Collection<? extends ConstraintCS>)newValue);
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__QUALIFIER:
				getQualifier().clear();
				getQualifier().addAll((Collection<? extends String>)newValue);
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_SUPER_TYPE:
				getOwnedSuperType().clear();
				getOwnedSuperType().addAll((Collection<? extends TypedRefCS>)newValue);
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_OPERATION:
				getOwnedOperation().clear();
				getOwnedOperation().addAll((Collection<? extends OperationCS>)newValue);
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_PROPERTY:
				getOwnedProperty().clear();
				getOwnedProperty().addAll((Collection<? extends StructuralFeatureCS>)newValue);
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_META_TYPE:
				setOwnedMetaType((TypedRefCS)newValue);
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__QUALIFIERS:
				getQualifiers().clear();
				getQualifiers().addAll((Collection<? extends StringLiteralExpCS>)newValue);
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__PATH_NAME_CS:
				setPathNameCS((PathNameCS)newValue);
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends ParameterDeclarationCS>)newValue);
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__MODULE_USAGES:
				getModuleUsages().clear();
				getModuleUsages().addAll((Collection<? extends ModuleUsageCS>)newValue);
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS:
				setTransformationRefineCS((TransformationRefineCS)newValue);
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
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_TEMPLATE_SIGNATURE:
				setOwnedTemplateSignature((TemplateSignatureCS)null);
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNER:
				setOwner((PackageCS)null);
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__INSTANCE_CLASS_NAME:
				unsetInstanceClassName();
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_CONSTRAINT:
				getOwnedConstraint().clear();
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__QUALIFIER:
				getQualifier().clear();
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_SUPER_TYPE:
				unsetOwnedSuperType();
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_OPERATION:
				getOwnedOperation().clear();
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_PROPERTY:
				getOwnedProperty().clear();
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_META_TYPE:
				setOwnedMetaType((TypedRefCS)null);
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__QUALIFIERS:
				getQualifiers().clear();
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__PATH_NAME_CS:
				setPathNameCS((PathNameCS)null);
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__PARAMETERS:
				getParameters().clear();
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__MODULE_USAGES:
				getModuleUsages().clear();
				return;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS:
				setTransformationRefineCS((TransformationRefineCS)null);
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
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_TEMPLATE_SIGNATURE:
				return ownedTemplateSignature != null;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNER:
				return getOwner() != null;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__INSTANCE_CLASS_NAME:
				return isSetInstanceClassName();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_CONSTRAINT:
				return ownedConstraint != null && !ownedConstraint.isEmpty();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__QUALIFIER:
				return qualifier != null && !qualifier.isEmpty();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_SUPER_TYPE:
				return isSetOwnedSuperType();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_OPERATION:
				return ownedOperation != null && !ownedOperation.isEmpty();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_PROPERTY:
				return ownedProperty != null && !ownedProperty.isEmpty();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_META_TYPE:
				return ownedMetaType != null;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__QUALIFIERS:
				return qualifiers != null && !qualifiers.isEmpty();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__PATH_NAME_CS:
				return pathNameCS != null;
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__MODULE_USAGES:
				return moduleUsages != null && !moduleUsages.isEmpty();
			case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS:
				return transformationRefineCS != null;
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
		if (baseClass == TypeCS.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == TemplateableElementCS.class) {
			switch (derivedFeatureID) {
				case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_TEMPLATE_SIGNATURE: return BaseCSTPackage.TEMPLATEABLE_ELEMENT_CS__OWNED_TEMPLATE_SIGNATURE;
				default: return -1;
			}
		}
		if (baseClass == ClassifierCS.class) {
			switch (derivedFeatureID) {
				case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNER: return BaseCSTPackage.CLASSIFIER_CS__OWNER;
				case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__INSTANCE_CLASS_NAME: return BaseCSTPackage.CLASSIFIER_CS__INSTANCE_CLASS_NAME;
				case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_CONSTRAINT: return BaseCSTPackage.CLASSIFIER_CS__OWNED_CONSTRAINT;
				case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__QUALIFIER: return BaseCSTPackage.CLASSIFIER_CS__QUALIFIER;
				default: return -1;
			}
		}
		if (baseClass == ClassCS.class) {
			switch (derivedFeatureID) {
				case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_SUPER_TYPE: return BaseCSTPackage.CLASS_CS__OWNED_SUPER_TYPE;
				case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_OPERATION: return BaseCSTPackage.CLASS_CS__OWNED_OPERATION;
				case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_PROPERTY: return BaseCSTPackage.CLASS_CS__OWNED_PROPERTY;
				case QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_META_TYPE: return BaseCSTPackage.CLASS_CS__OWNED_META_TYPE;
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
		if (baseClass == TypeCS.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == TemplateableElementCS.class) {
			switch (baseFeatureID) {
				case BaseCSTPackage.TEMPLATEABLE_ELEMENT_CS__OWNED_TEMPLATE_SIGNATURE: return QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_TEMPLATE_SIGNATURE;
				default: return -1;
			}
		}
		if (baseClass == ClassifierCS.class) {
			switch (baseFeatureID) {
				case BaseCSTPackage.CLASSIFIER_CS__OWNER: return QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNER;
				case BaseCSTPackage.CLASSIFIER_CS__INSTANCE_CLASS_NAME: return QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__INSTANCE_CLASS_NAME;
				case BaseCSTPackage.CLASSIFIER_CS__OWNED_CONSTRAINT: return QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_CONSTRAINT;
				case BaseCSTPackage.CLASSIFIER_CS__QUALIFIER: return QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__QUALIFIER;
				default: return -1;
			}
		}
		if (baseClass == ClassCS.class) {
			switch (baseFeatureID) {
				case BaseCSTPackage.CLASS_CS__OWNED_SUPER_TYPE: return QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_SUPER_TYPE;
				case BaseCSTPackage.CLASS_CS__OWNED_OPERATION: return QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_OPERATION;
				case BaseCSTPackage.CLASS_CS__OWNED_PROPERTY: return QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_PROPERTY;
				case BaseCSTPackage.CLASS_CS__OWNED_META_TYPE: return QVTOperationalCSPackage.TRANSFORMATION_HEADER_CS__OWNED_META_TYPE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} // TransformationHeaderCSImpl
