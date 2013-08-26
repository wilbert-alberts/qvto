/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeOCLCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierDefCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierKind;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConfigPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConstructorCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ContextualPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ElementWithBody;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ExceptionCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.FeatureKey;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImperativeOperationCallExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportKindEnum;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitOp;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LibraryImportCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LocalPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingBodyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingCallExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingEndCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionKindCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingInitCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingMethodCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingQueryCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingRuleCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionsCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelKind;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindEnum;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModulePropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleRefCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityDefCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ObjectExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationParameterDeclarationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationSimpleSignatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OppositePropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PackageRefCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterDeclarationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PrimitiveTypeCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSFactory;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToClassCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToImportCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToLibraryCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToOperationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QualifierKindCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.RenameCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveInExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveOpArgsExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ScopedNameCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.StereotypeQualifierCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationRefineCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTOperationalCSPackageImpl extends EPackageImpl implements QVTOperationalCSPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topLevelCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qvToClassCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qvToImportCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qvToLibraryCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qvToOperationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationParameterDeclarationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationSimpleSignatureCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass initPartCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metamodelCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierPropertyCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypeQualifierCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tagCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exceptionCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierDefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierProperty2CSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completeSignatureCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configPropertyCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constructorCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextualPropertyCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementWithBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeOperationCallExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryImportCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localPropertyCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingBodyCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingCallExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingOperationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEndCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingExtensionCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingInitCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingMethodCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingModuleCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingQueryCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingRuleCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingSectionCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingSectionsCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleKindCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelTypeCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modulePropertyCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleUsageCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplicityDefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oppositePropertyCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterDeclarationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass renameCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolveOpArgsExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scopedNameCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleSignatureCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationRefineCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeSpecCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolveExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolveInExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum classifierKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum featureKeyEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum initOpEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum metamodelKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum directionKindCSEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum importKindEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mappingExtensionKindCSEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum moduleKindEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum qualifierKindCSEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTOperationalCSPackageImpl() {
		super(eNS_URI, QVTOperationalCSFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link QVTOperationalCSPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTOperationalCSPackage init() {
		if (isInited) return (QVTOperationalCSPackage)EPackage.Registry.INSTANCE.getEPackage(QVTOperationalCSPackage.eNS_URI);

		// Obtain or create and register package
		QVTOperationalCSPackageImpl theQVTOperationalCSPackage = (QVTOperationalCSPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof QVTOperationalCSPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new QVTOperationalCSPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ImperativeOCLCSPackage.eINSTANCE.eClass();
		QVTOperationalPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTOperationalCSPackage.createPackageContents();

		// Initialize created meta-data
		theQVTOperationalCSPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQVTOperationalCSPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTOperationalCSPackage.eNS_URI, theQVTOperationalCSPackage);
		return theQVTOperationalCSPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopLevelCS() {
		return topLevelCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopLevelCS_Import() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopLevelCS_Unit() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQVToClassCS() {
		return qvToClassCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQVToClassCS_Intermediate() {
		return (EAttribute)qvToClassCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQVToImportCS() {
		return qvToImportCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQVToImportCS_Unit() {
		return (EReference)qvToImportCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQVToImportCS_ImportedUnitElement() {
		return (EAttribute)qvToImportCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQVToImportCS_All() {
		return (EAttribute)qvToImportCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQVToLibraryCS() {
		return qvToLibraryCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQVToOperationCS() {
		return qvToOperationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQVToOperationCS_Stereotypes() {
		return (EReference)qvToOperationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationParameterDeclarationCS() {
		return operationParameterDeclarationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationParameterDeclarationCS_Direction() {
		return (EAttribute)operationParameterDeclarationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationParameterDeclarationCS_InitPart() {
		return (EReference)operationParameterDeclarationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationSimpleSignatureCS() {
		return operationSimpleSignatureCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationSimpleSignatureCS_Parameter() {
		return (EReference)operationSimpleSignatureCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInitPartCS() {
		return initPartCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInitPartCS_InitOp() {
		return (EAttribute)initPartCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInitPartCS_Expression() {
		return (EReference)initPartCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetamodelCS() {
		return metamodelCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetamodelCS_MetamodelKind() {
		return (EAttribute)metamodelCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveTypeCS() {
		return primitiveTypeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierPropertyCS() {
		return classifierPropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierPropertyCS_Stereotypes() {
		return (EReference)classifierPropertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierPropertyCS_Opposite() {
		return (EAttribute)classifierPropertyCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStereotypeQualifierCS() {
		return stereotypeQualifierCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStereotypeQualifierCS_Stereotype() {
		return (EAttribute)stereotypeQualifierCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTagCS() {
		return tagCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTagCS_PathName() {
		return (EReference)tagCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTagCS_Expression() {
		return (EReference)tagCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExceptionCS() {
		return exceptionCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierDefCS() {
		return classifierDefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierDefCS_SimpleNameCS() {
		return (EAttribute)classifierDefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierDefCS_Extends() {
		return (EReference)classifierDefCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierDefCS_Properties() {
		return (EReference)classifierDefCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierDefCS_Tags() {
		return (EReference)classifierDefCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierProperty2CS() {
		return classifierProperty2CSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierProperty2CS_StereotypeQualifiers() {
		return (EAttribute)classifierProperty2CSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierProperty2CS_FeatureKeys() {
		return (EAttribute)classifierProperty2CSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierProperty2CS_Multiplicity() {
		return (EReference)classifierProperty2CSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierProperty2CS_Opposite() {
		return (EReference)classifierProperty2CSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierProperty2CS_IsOrdered() {
		return (EAttribute)classifierProperty2CSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompleteSignatureCS() {
		return completeSignatureCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompleteSignatureCS_SimpleSignature() {
		return (EReference)completeSignatureCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompleteSignatureCS_ResultParams() {
		return (EReference)completeSignatureCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigPropertyCS() {
		return configPropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigPropertyCS_TypeCS() {
		return (EReference)configPropertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstructorCS() {
		return constructorCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstructorCS_Expressions() {
		return (EReference)constructorCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContextualPropertyCS() {
		return contextualPropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextualPropertyCS_ScopedNameCS() {
		return (EReference)contextualPropertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextualPropertyCS_TypeCS() {
		return (EReference)contextualPropertyCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextualPropertyCS_OclExpressionCS() {
		return (EReference)contextualPropertyCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDirectionKindCS() {
		return directionKindCSEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementWithBody() {
		return elementWithBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementWithBody_BodyStartLocation() {
		return (EAttribute)elementWithBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementWithBody_BodyEndLocation() {
		return (EAttribute)elementWithBodyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImperativeOperationCallExpCS() {
		return imperativeOperationCallExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImperativeOperationCallExpCS_Module() {
		return (EAttribute)imperativeOperationCallExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibraryImportCS() {
		return libraryImportCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalPropertyCS() {
		return localPropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalPropertyCS_TypeCS() {
		return (EReference)localPropertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalPropertyCS_OclExpressionCS() {
		return (EReference)localPropertyCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingBodyCS() {
		return mappingBodyCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingBodyCS_HasPopulationKeyword() {
		return (EAttribute)mappingBodyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingCallExpCS() {
		return mappingCallExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingCallExpCS_Strict() {
		return (EAttribute)mappingCallExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingOperationCS() {
		return mappingOperationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperationCS_ContextType() {
		return (EReference)mappingOperationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperationCS_Signature() {
		return (EReference)mappingOperationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperationCS_Result() {
		return (EReference)mappingOperationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingOperationCS_DirectionKindCS() {
		return (EAttribute)mappingOperationCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperationCS_MappingExtension() {
		return (EReference)mappingOperationCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingOperationCS_IsQuery() {
		return (EAttribute)mappingOperationCSEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingEndCS() {
		return mappingEndCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingExtensionCS() {
		return mappingExtensionCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingExtensionCS_Kind() {
		return (EAttribute)mappingExtensionCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingExtensionCS_MappingIdentifiers() {
		return (EReference)mappingExtensionCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingInitCS() {
		return mappingInitCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingMethodCS() {
		return mappingMethodCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingMethodCS_BlackBox() {
		return (EAttribute)mappingMethodCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingMethodCS_MappingDeclarationCS() {
		return (EReference)mappingMethodCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingModuleCS() {
		return mappingModuleCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_HeaderCS() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_Imports() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_Metamodels() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_Renamings() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_Properties() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_Methods() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_ClassifierDefCS() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_Tags() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingQueryCS() {
		return mappingQueryCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingQueryCS_Expressions() {
		return (EReference)mappingQueryCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingQueryCS_IsSimpleDefinition() {
		return (EAttribute)mappingQueryCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingRuleCS() {
		return mappingRuleCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingRuleCS_Guard() {
		return (EReference)mappingRuleCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingRuleCS_MappingBody() {
		return (EReference)mappingRuleCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingSectionCS() {
		return mappingSectionCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingSectionCS_Statements() {
		return (EReference)mappingSectionCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingSectionCS_MappingRuleCS() {
		return (EReference)mappingSectionCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingSectionsCS() {
		return mappingSectionsCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingSectionsCS_MappingInitCS() {
		return (EReference)mappingSectionsCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingSectionsCS_MappingBodyCS() {
		return (EReference)mappingSectionsCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingSectionsCS_MappingEndCS() {
		return (EReference)mappingSectionsCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleKindCS() {
		return moduleKindCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModuleKindCS_ModuleKind() {
		return (EAttribute)moduleKindCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleRefCS() {
		return moduleRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleRefCS_PathNameCS() {
		return (EReference)moduleRefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleRefCS_Parameters() {
		return (EReference)moduleRefCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelTypeCS() {
		return modelTypeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelTypeCS_IdentifierCS() {
		return (EAttribute)modelTypeCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelTypeCS_ComplianceKindCS() {
		return (EReference)modelTypeCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelTypeCS_PackageRefs() {
		return (EReference)modelTypeCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelTypeCS_WhereStatements() {
		return (EReference)modelTypeCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModulePropertyCS() {
		return modulePropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModulePropertyCS_SimpleNameCS() {
		return (EAttribute)modulePropertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleUsageCS() {
		return moduleUsageCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModuleUsageCS_ImportKind() {
		return (EAttribute)moduleUsageCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleUsageCS_ModuleKindCS() {
		return (EReference)moduleUsageCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleUsageCS_ModuleRefs() {
		return (EReference)moduleUsageCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiplicityDefCS() {
		return multiplicityDefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiplicityDefCS_LowerBound() {
		return (EReference)multiplicityDefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiplicityDefCS_UpperBound() {
		return (EReference)multiplicityDefCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectExpCS() {
		return objectExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectExpCS_SimpleNameCS() {
		return (EAttribute)objectExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectExpCS_IsImplicit() {
		return (EAttribute)objectExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOppositePropertyCS() {
		return oppositePropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOppositePropertyCS_IsNavigable() {
		return (EAttribute)oppositePropertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOppositePropertyCS_SimpleNameCS() {
		return (EAttribute)oppositePropertyCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOppositePropertyCS_Multiplicity() {
		return (EReference)oppositePropertyCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterDeclarationCS() {
		return parameterDeclarationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterDeclarationCS_Direction() {
		return (EAttribute)parameterDeclarationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterDeclarationCS_InitPart() {
		return (EReference)parameterDeclarationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRenameCS() {
		return renameCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRenameCS_TypeCS() {
		return (EReference)renameCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRenameCS_SimpleNameCS() {
		return (EAttribute)renameCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRenameCS_OriginalName() {
		return (EReference)renameCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolveOpArgsExpCS() {
		return resolveOpArgsExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolveOpArgsExpCS_Target() {
		return (EReference)resolveOpArgsExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolveOpArgsExpCS_Condition() {
		return (EReference)resolveOpArgsExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageRefCS() {
		return packageRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageRefCS_PathNameCS() {
		return (EReference)packageRefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageRefCS_UriCS() {
		return (EReference)packageRefCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScopedNameCS() {
		return scopedNameCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScopedNameCS_TypeCS() {
		return (EReference)scopedNameCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScopedNameCS_Name() {
		return (EAttribute)scopedNameCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleSignatureCS() {
		return simpleSignatureCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleSignatureCS_Parameter() {
		return (EReference)simpleSignatureCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformationCS() {
		return transformationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationCS_Qualifiers() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationCS_PathNameCS() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationCS_Parameters() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationCS_ModuleUsages() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationCS_TransformationRefineCS() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformationRefineCS() {
		return transformationRefineCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationRefineCS_ModuleRefCS() {
		return (EReference)transformationRefineCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformationRefineCS_SimpleNameCS() {
		return (EAttribute)transformationRefineCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeSpecCS() {
		return typeSpecCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeSpecCS_OwnedType() {
		return (EReference)typeSpecCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeSpecCS_ExtentLocation() {
		return (EAttribute)typeSpecCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitCS() {
		return unitCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitCS_Segment() {
		return (EAttribute)unitCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitCS_TopLevelElements() {
		return (EReference)unitCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitCS_Modules() {
		return (EReference)unitCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitCS_ModelTypes() {
		return (EReference)unitCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitCS_Imports() {
		return (EReference)unitCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolveExpCS() {
		return resolveExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResolveExpCS_One() {
		return (EAttribute)resolveExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResolveExpCS_IsInverse() {
		return (EAttribute)resolveExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResolveExpCS_IsDeferred() {
		return (EAttribute)resolveExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolveExpCS_Target() {
		return (EReference)resolveExpCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolveExpCS_Condition() {
		return (EReference)resolveExpCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolveInExpCS() {
		return resolveInExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolveInExpCS_InMappingType() {
		return (EReference)resolveInExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResolveInExpCS_InMappingName() {
		return (EAttribute)resolveInExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getClassifierKind() {
		return classifierKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFeatureKey() {
		return featureKeyEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getInitOp() {
		return initOpEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMetamodelKind() {
		return metamodelKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getImportKindEnum() {
		return importKindEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMappingExtensionKindCS() {
		return mappingExtensionKindCSEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getModuleKindEnum() {
		return moduleKindEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getQualifierKindCS() {
		return qualifierKindCSEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTOperationalCSFactory getQVTOperationalCSFactory() {
		return (QVTOperationalCSFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		topLevelCSEClass = createEClass(TOP_LEVEL_CS);
		createEReference(topLevelCSEClass, TOP_LEVEL_CS__IMPORT);
		createEReference(topLevelCSEClass, TOP_LEVEL_CS__UNIT);

		qvToClassCSEClass = createEClass(QV_TO_CLASS_CS);
		createEAttribute(qvToClassCSEClass, QV_TO_CLASS_CS__INTERMEDIATE);

		qvToImportCSEClass = createEClass(QV_TO_IMPORT_CS);
		createEReference(qvToImportCSEClass, QV_TO_IMPORT_CS__UNIT);
		createEAttribute(qvToImportCSEClass, QV_TO_IMPORT_CS__IMPORTED_UNIT_ELEMENT);
		createEAttribute(qvToImportCSEClass, QV_TO_IMPORT_CS__ALL);

		qvToLibraryCSEClass = createEClass(QV_TO_LIBRARY_CS);

		qvToOperationCSEClass = createEClass(QV_TO_OPERATION_CS);
		createEReference(qvToOperationCSEClass, QV_TO_OPERATION_CS__STEREOTYPES);

		operationParameterDeclarationCSEClass = createEClass(OPERATION_PARAMETER_DECLARATION_CS);
		createEAttribute(operationParameterDeclarationCSEClass, OPERATION_PARAMETER_DECLARATION_CS__DIRECTION);
		createEReference(operationParameterDeclarationCSEClass, OPERATION_PARAMETER_DECLARATION_CS__INIT_PART);

		operationSimpleSignatureCSEClass = createEClass(OPERATION_SIMPLE_SIGNATURE_CS);
		createEReference(operationSimpleSignatureCSEClass, OPERATION_SIMPLE_SIGNATURE_CS__PARAMETER);

		initPartCSEClass = createEClass(INIT_PART_CS);
		createEAttribute(initPartCSEClass, INIT_PART_CS__INIT_OP);
		createEReference(initPartCSEClass, INIT_PART_CS__EXPRESSION);

		metamodelCSEClass = createEClass(METAMODEL_CS);
		createEAttribute(metamodelCSEClass, METAMODEL_CS__METAMODEL_KIND);

		primitiveTypeCSEClass = createEClass(PRIMITIVE_TYPE_CS);

		classifierPropertyCSEClass = createEClass(CLASSIFIER_PROPERTY_CS);
		createEReference(classifierPropertyCSEClass, CLASSIFIER_PROPERTY_CS__STEREOTYPES);
		createEAttribute(classifierPropertyCSEClass, CLASSIFIER_PROPERTY_CS__OPPOSITE);

		stereotypeQualifierCSEClass = createEClass(STEREOTYPE_QUALIFIER_CS);
		createEAttribute(stereotypeQualifierCSEClass, STEREOTYPE_QUALIFIER_CS__STEREOTYPE);

		tagCSEClass = createEClass(TAG_CS);
		createEReference(tagCSEClass, TAG_CS__PATH_NAME);
		createEReference(tagCSEClass, TAG_CS__EXPRESSION);

		exceptionCSEClass = createEClass(EXCEPTION_CS);

		classifierDefCSEClass = createEClass(CLASSIFIER_DEF_CS);
		createEAttribute(classifierDefCSEClass, CLASSIFIER_DEF_CS__SIMPLE_NAME_CS);
		createEReference(classifierDefCSEClass, CLASSIFIER_DEF_CS__EXTENDS);
		createEReference(classifierDefCSEClass, CLASSIFIER_DEF_CS__PROPERTIES);
		createEReference(classifierDefCSEClass, CLASSIFIER_DEF_CS__TAGS);

		classifierProperty2CSEClass = createEClass(CLASSIFIER_PROPERTY2_CS);
		createEAttribute(classifierProperty2CSEClass, CLASSIFIER_PROPERTY2_CS__STEREOTYPE_QUALIFIERS);
		createEAttribute(classifierProperty2CSEClass, CLASSIFIER_PROPERTY2_CS__FEATURE_KEYS);
		createEReference(classifierProperty2CSEClass, CLASSIFIER_PROPERTY2_CS__MULTIPLICITY);
		createEReference(classifierProperty2CSEClass, CLASSIFIER_PROPERTY2_CS__OPPOSITE);
		createEAttribute(classifierProperty2CSEClass, CLASSIFIER_PROPERTY2_CS__IS_ORDERED);

		completeSignatureCSEClass = createEClass(COMPLETE_SIGNATURE_CS);
		createEReference(completeSignatureCSEClass, COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE);
		createEReference(completeSignatureCSEClass, COMPLETE_SIGNATURE_CS__RESULT_PARAMS);

		configPropertyCSEClass = createEClass(CONFIG_PROPERTY_CS);
		createEReference(configPropertyCSEClass, CONFIG_PROPERTY_CS__TYPE_CS);

		constructorCSEClass = createEClass(CONSTRUCTOR_CS);
		createEReference(constructorCSEClass, CONSTRUCTOR_CS__EXPRESSIONS);

		contextualPropertyCSEClass = createEClass(CONTEXTUAL_PROPERTY_CS);
		createEReference(contextualPropertyCSEClass, CONTEXTUAL_PROPERTY_CS__SCOPED_NAME_CS);
		createEReference(contextualPropertyCSEClass, CONTEXTUAL_PROPERTY_CS__TYPE_CS);
		createEReference(contextualPropertyCSEClass, CONTEXTUAL_PROPERTY_CS__OCL_EXPRESSION_CS);

		elementWithBodyEClass = createEClass(ELEMENT_WITH_BODY);
		createEAttribute(elementWithBodyEClass, ELEMENT_WITH_BODY__BODY_START_LOCATION);
		createEAttribute(elementWithBodyEClass, ELEMENT_WITH_BODY__BODY_END_LOCATION);

		imperativeOperationCallExpCSEClass = createEClass(IMPERATIVE_OPERATION_CALL_EXP_CS);
		createEAttribute(imperativeOperationCallExpCSEClass, IMPERATIVE_OPERATION_CALL_EXP_CS__MODULE);

		libraryImportCSEClass = createEClass(LIBRARY_IMPORT_CS);

		localPropertyCSEClass = createEClass(LOCAL_PROPERTY_CS);
		createEReference(localPropertyCSEClass, LOCAL_PROPERTY_CS__TYPE_CS);
		createEReference(localPropertyCSEClass, LOCAL_PROPERTY_CS__OCL_EXPRESSION_CS);

		mappingBodyCSEClass = createEClass(MAPPING_BODY_CS);
		createEAttribute(mappingBodyCSEClass, MAPPING_BODY_CS__HAS_POPULATION_KEYWORD);

		mappingCallExpCSEClass = createEClass(MAPPING_CALL_EXP_CS);
		createEAttribute(mappingCallExpCSEClass, MAPPING_CALL_EXP_CS__STRICT);

		mappingOperationCSEClass = createEClass(MAPPING_OPERATION_CS);
		createEReference(mappingOperationCSEClass, MAPPING_OPERATION_CS__CONTEXT_TYPE);
		createEReference(mappingOperationCSEClass, MAPPING_OPERATION_CS__SIGNATURE);
		createEReference(mappingOperationCSEClass, MAPPING_OPERATION_CS__RESULT);
		createEAttribute(mappingOperationCSEClass, MAPPING_OPERATION_CS__DIRECTION_KIND_CS);
		createEReference(mappingOperationCSEClass, MAPPING_OPERATION_CS__MAPPING_EXTENSION);
		createEAttribute(mappingOperationCSEClass, MAPPING_OPERATION_CS__IS_QUERY);

		mappingEndCSEClass = createEClass(MAPPING_END_CS);

		mappingExtensionCSEClass = createEClass(MAPPING_EXTENSION_CS);
		createEAttribute(mappingExtensionCSEClass, MAPPING_EXTENSION_CS__KIND);
		createEReference(mappingExtensionCSEClass, MAPPING_EXTENSION_CS__MAPPING_IDENTIFIERS);

		mappingInitCSEClass = createEClass(MAPPING_INIT_CS);

		mappingMethodCSEClass = createEClass(MAPPING_METHOD_CS);
		createEAttribute(mappingMethodCSEClass, MAPPING_METHOD_CS__BLACK_BOX);
		createEReference(mappingMethodCSEClass, MAPPING_METHOD_CS__MAPPING_DECLARATION_CS);

		mappingModuleCSEClass = createEClass(MAPPING_MODULE_CS);
		createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__HEADER_CS);
		createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__IMPORTS);
		createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__METAMODELS);
		createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__RENAMINGS);
		createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__PROPERTIES);
		createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__METHODS);
		createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__CLASSIFIER_DEF_CS);
		createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__TAGS);

		mappingQueryCSEClass = createEClass(MAPPING_QUERY_CS);
		createEReference(mappingQueryCSEClass, MAPPING_QUERY_CS__EXPRESSIONS);
		createEAttribute(mappingQueryCSEClass, MAPPING_QUERY_CS__IS_SIMPLE_DEFINITION);

		mappingRuleCSEClass = createEClass(MAPPING_RULE_CS);
		createEReference(mappingRuleCSEClass, MAPPING_RULE_CS__GUARD);
		createEReference(mappingRuleCSEClass, MAPPING_RULE_CS__MAPPING_BODY);

		mappingSectionCSEClass = createEClass(MAPPING_SECTION_CS);
		createEReference(mappingSectionCSEClass, MAPPING_SECTION_CS__STATEMENTS);
		createEReference(mappingSectionCSEClass, MAPPING_SECTION_CS__MAPPING_RULE_CS);

		mappingSectionsCSEClass = createEClass(MAPPING_SECTIONS_CS);
		createEReference(mappingSectionsCSEClass, MAPPING_SECTIONS_CS__MAPPING_INIT_CS);
		createEReference(mappingSectionsCSEClass, MAPPING_SECTIONS_CS__MAPPING_BODY_CS);
		createEReference(mappingSectionsCSEClass, MAPPING_SECTIONS_CS__MAPPING_END_CS);

		moduleKindCSEClass = createEClass(MODULE_KIND_CS);
		createEAttribute(moduleKindCSEClass, MODULE_KIND_CS__MODULE_KIND);

		moduleRefCSEClass = createEClass(MODULE_REF_CS);
		createEReference(moduleRefCSEClass, MODULE_REF_CS__PATH_NAME_CS);
		createEReference(moduleRefCSEClass, MODULE_REF_CS__PARAMETERS);

		modelTypeCSEClass = createEClass(MODEL_TYPE_CS);
		createEAttribute(modelTypeCSEClass, MODEL_TYPE_CS__IDENTIFIER_CS);
		createEReference(modelTypeCSEClass, MODEL_TYPE_CS__COMPLIANCE_KIND_CS);
		createEReference(modelTypeCSEClass, MODEL_TYPE_CS__PACKAGE_REFS);
		createEReference(modelTypeCSEClass, MODEL_TYPE_CS__WHERE_STATEMENTS);

		modulePropertyCSEClass = createEClass(MODULE_PROPERTY_CS);
		createEAttribute(modulePropertyCSEClass, MODULE_PROPERTY_CS__SIMPLE_NAME_CS);

		moduleUsageCSEClass = createEClass(MODULE_USAGE_CS);
		createEAttribute(moduleUsageCSEClass, MODULE_USAGE_CS__IMPORT_KIND);
		createEReference(moduleUsageCSEClass, MODULE_USAGE_CS__MODULE_KIND_CS);
		createEReference(moduleUsageCSEClass, MODULE_USAGE_CS__MODULE_REFS);

		multiplicityDefCSEClass = createEClass(MULTIPLICITY_DEF_CS);
		createEReference(multiplicityDefCSEClass, MULTIPLICITY_DEF_CS__LOWER_BOUND);
		createEReference(multiplicityDefCSEClass, MULTIPLICITY_DEF_CS__UPPER_BOUND);

		objectExpCSEClass = createEClass(OBJECT_EXP_CS);
		createEAttribute(objectExpCSEClass, OBJECT_EXP_CS__SIMPLE_NAME_CS);
		createEAttribute(objectExpCSEClass, OBJECT_EXP_CS__IS_IMPLICIT);

		oppositePropertyCSEClass = createEClass(OPPOSITE_PROPERTY_CS);
		createEAttribute(oppositePropertyCSEClass, OPPOSITE_PROPERTY_CS__IS_NAVIGABLE);
		createEAttribute(oppositePropertyCSEClass, OPPOSITE_PROPERTY_CS__SIMPLE_NAME_CS);
		createEReference(oppositePropertyCSEClass, OPPOSITE_PROPERTY_CS__MULTIPLICITY);

		parameterDeclarationCSEClass = createEClass(PARAMETER_DECLARATION_CS);
		createEAttribute(parameterDeclarationCSEClass, PARAMETER_DECLARATION_CS__DIRECTION);
		createEReference(parameterDeclarationCSEClass, PARAMETER_DECLARATION_CS__INIT_PART);

		renameCSEClass = createEClass(RENAME_CS);
		createEReference(renameCSEClass, RENAME_CS__TYPE_CS);
		createEAttribute(renameCSEClass, RENAME_CS__SIMPLE_NAME_CS);
		createEReference(renameCSEClass, RENAME_CS__ORIGINAL_NAME);

		resolveOpArgsExpCSEClass = createEClass(RESOLVE_OP_ARGS_EXP_CS);
		createEReference(resolveOpArgsExpCSEClass, RESOLVE_OP_ARGS_EXP_CS__TARGET);
		createEReference(resolveOpArgsExpCSEClass, RESOLVE_OP_ARGS_EXP_CS__CONDITION);

		packageRefCSEClass = createEClass(PACKAGE_REF_CS);
		createEReference(packageRefCSEClass, PACKAGE_REF_CS__PATH_NAME_CS);
		createEReference(packageRefCSEClass, PACKAGE_REF_CS__URI_CS);

		scopedNameCSEClass = createEClass(SCOPED_NAME_CS);
		createEReference(scopedNameCSEClass, SCOPED_NAME_CS__TYPE_CS);
		createEAttribute(scopedNameCSEClass, SCOPED_NAME_CS__NAME);

		simpleSignatureCSEClass = createEClass(SIMPLE_SIGNATURE_CS);
		createEReference(simpleSignatureCSEClass, SIMPLE_SIGNATURE_CS__PARAMETER);

		transformationCSEClass = createEClass(TRANSFORMATION_CS);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__QUALIFIERS);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__PATH_NAME_CS);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__PARAMETERS);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__MODULE_USAGES);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__TRANSFORMATION_REFINE_CS);

		transformationRefineCSEClass = createEClass(TRANSFORMATION_REFINE_CS);
		createEReference(transformationRefineCSEClass, TRANSFORMATION_REFINE_CS__MODULE_REF_CS);
		createEAttribute(transformationRefineCSEClass, TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS);

		typeSpecCSEClass = createEClass(TYPE_SPEC_CS);
		createEReference(typeSpecCSEClass, TYPE_SPEC_CS__OWNED_TYPE);
		createEAttribute(typeSpecCSEClass, TYPE_SPEC_CS__EXTENT_LOCATION);

		unitCSEClass = createEClass(UNIT_CS);
		createEAttribute(unitCSEClass, UNIT_CS__SEGMENT);
		createEReference(unitCSEClass, UNIT_CS__TOP_LEVEL_ELEMENTS);
		createEReference(unitCSEClass, UNIT_CS__MODULES);
		createEReference(unitCSEClass, UNIT_CS__MODEL_TYPES);
		createEReference(unitCSEClass, UNIT_CS__IMPORTS);

		resolveExpCSEClass = createEClass(RESOLVE_EXP_CS);
		createEAttribute(resolveExpCSEClass, RESOLVE_EXP_CS__ONE);
		createEAttribute(resolveExpCSEClass, RESOLVE_EXP_CS__IS_INVERSE);
		createEAttribute(resolveExpCSEClass, RESOLVE_EXP_CS__IS_DEFERRED);
		createEReference(resolveExpCSEClass, RESOLVE_EXP_CS__TARGET);
		createEReference(resolveExpCSEClass, RESOLVE_EXP_CS__CONDITION);

		resolveInExpCSEClass = createEClass(RESOLVE_IN_EXP_CS);
		createEReference(resolveInExpCSEClass, RESOLVE_IN_EXP_CS__IN_MAPPING_TYPE);
		createEAttribute(resolveInExpCSEClass, RESOLVE_IN_EXP_CS__IN_MAPPING_NAME);

		// Create enums
		classifierKindEEnum = createEEnum(CLASSIFIER_KIND);
		featureKeyEEnum = createEEnum(FEATURE_KEY);
		initOpEEnum = createEEnum(INIT_OP);
		metamodelKindEEnum = createEEnum(METAMODEL_KIND);
		directionKindCSEEnum = createEEnum(DIRECTION_KIND_CS);
		importKindEnumEEnum = createEEnum(IMPORT_KIND_ENUM);
		mappingExtensionKindCSEEnum = createEEnum(MAPPING_EXTENSION_KIND_CS);
		moduleKindEnumEEnum = createEEnum(MODULE_KIND_ENUM);
		qualifierKindCSEEnum = createEEnum(QUALIFIER_KIND_CS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		BaseCSTPackage theBaseCSTPackage = (BaseCSTPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSTPackage.eNS_URI);
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);
		QVTOperationalPackage theQVTOperationalPackage = (QVTOperationalPackage)EPackage.Registry.INSTANCE.getEPackage(QVTOperationalPackage.eNS_URI);
		EssentialOCLCSTPackage theEssentialOCLCSTPackage = (EssentialOCLCSTPackage)EPackage.Registry.INSTANCE.getEPackage(EssentialOCLCSTPackage.eNS_URI);
		ImperativeOCLCSPackage theImperativeOCLCSPackage = (ImperativeOCLCSPackage)EPackage.Registry.INSTANCE.getEPackage(ImperativeOCLCSPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		topLevelCSEClass.getESuperTypes().add(theBaseCSTPackage.getRootPackageCS());
		qvToClassCSEClass.getESuperTypes().add(theBaseCSTPackage.getClassCS());
		qvToImportCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		qvToLibraryCSEClass.getESuperTypes().add(this.getMappingModuleCS());
		qvToOperationCSEClass.getESuperTypes().add(theBaseCSTPackage.getOperationCS());
		operationParameterDeclarationCSEClass.getESuperTypes().add(theBaseCSTPackage.getParameterCS());
		operationSimpleSignatureCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		initPartCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		metamodelCSEClass.getESuperTypes().add(theBaseCSTPackage.getPackageCS());
		primitiveTypeCSEClass.getESuperTypes().add(theBaseCSTPackage.getDataTypeCS());
		classifierPropertyCSEClass.getESuperTypes().add(theBaseCSTPackage.getStructuralFeatureCS());
		stereotypeQualifierCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		tagCSEClass.getESuperTypes().add(theBaseCSTPackage.getAnnotationCS());
		exceptionCSEClass.getESuperTypes().add(theBaseCSTPackage.getClassCS());
		classifierDefCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		classifierProperty2CSEClass.getESuperTypes().add(this.getLocalPropertyCS());
		completeSignatureCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		configPropertyCSEClass.getESuperTypes().add(this.getModulePropertyCS());
		constructorCSEClass.getESuperTypes().add(this.getMappingMethodCS());
		contextualPropertyCSEClass.getESuperTypes().add(this.getModulePropertyCS());
		elementWithBodyEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		imperativeOperationCallExpCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getInvocationExpCS());
		libraryImportCSEClass.getESuperTypes().add(this.getQVToImportCS());
		localPropertyCSEClass.getESuperTypes().add(this.getModulePropertyCS());
		mappingBodyCSEClass.getESuperTypes().add(this.getMappingSectionCS());
		mappingCallExpCSEClass.getESuperTypes().add(this.getImperativeOperationCallExpCS());
		mappingOperationCSEClass.getESuperTypes().add(theBaseCSTPackage.getOperationCS());
		mappingEndCSEClass.getESuperTypes().add(this.getMappingSectionCS());
		mappingExtensionCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		mappingInitCSEClass.getESuperTypes().add(this.getMappingSectionCS());
		mappingMethodCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		mappingModuleCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		mappingQueryCSEClass.getESuperTypes().add(this.getMappingMethodCS());
		mappingRuleCSEClass.getESuperTypes().add(this.getMappingMethodCS());
		mappingSectionCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		mappingSectionCSEClass.getESuperTypes().add(this.getElementWithBody());
		mappingSectionsCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		moduleKindCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		moduleRefCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		modelTypeCSEClass.getESuperTypes().add(theBaseCSTPackage.getClassCS());
		modelTypeCSEClass.getESuperTypes().add(this.getElementWithBody());
		modulePropertyCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		moduleUsageCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		multiplicityDefCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		objectExpCSEClass.getESuperTypes().add(theImperativeOCLCSPackage.getExpressionBlockCS());
		oppositePropertyCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		parameterDeclarationCSEClass.getESuperTypes().add(theBaseCSTPackage.getTypedElementCS());
		renameCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		resolveOpArgsExpCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		packageRefCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		scopedNameCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		simpleSignatureCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		transformationCSEClass.getESuperTypes().add(theBaseCSTPackage.getPackageCS());
		transformationCSEClass.getESuperTypes().add(theBaseCSTPackage.getClassCS());
		transformationRefineCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		typeSpecCSEClass.getESuperTypes().add(theBaseCSTPackage.getTypedRefCS());
		unitCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		resolveExpCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getInvocationExpCS());
		resolveInExpCSEClass.getESuperTypes().add(this.getResolveExpCS());

		// Initialize classes and features; add operations and parameters
		initEClass(topLevelCSEClass, TopLevelCS.class, "TopLevelCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTopLevelCS_Import(), theBaseCSTPackage.getElementCS(), null, "import", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopLevelCS_Unit(), theBaseCSTPackage.getElementCS(), null, "unit", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(topLevelCSEClass, thePivotPackage.getRoot(), "ast", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(qvToClassCSEClass, QVToClassCS.class, "QVToClassCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQVToClassCS_Intermediate(), ecorePackage.getEBoolean(), "intermediate", null, 1, 1, QVToClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(qvToClassCSEClass, thePivotPackage.getClass_(), "ast", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(qvToImportCSEClass, QVToImportCS.class, "QVToImportCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQVToImportCS_Unit(), this.getUnitCS(), null, "unit", null, 0, 1, QVToImportCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQVToImportCS_ImportedUnitElement(), ecorePackage.getEString(), "importedUnitElement", null, 0, -1, QVToImportCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQVToImportCS_All(), ecorePackage.getEBoolean(), "all", null, 0, 1, QVToImportCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(qvToLibraryCSEClass, QVToLibraryCS.class, "QVToLibraryCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(qvToOperationCSEClass, QVToOperationCS.class, "QVToOperationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQVToOperationCS_Stereotypes(), this.getStereotypeQualifierCS(), null, "stereotypes", null, 0, 1, QVToOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationParameterDeclarationCSEClass, OperationParameterDeclarationCS.class, "OperationParameterDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperationParameterDeclarationCS_Direction(), this.getDirectionKindCS(), "direction", null, 0, 1, OperationParameterDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationParameterDeclarationCS_InitPart(), this.getInitPartCS(), null, "initPart", null, 0, 1, OperationParameterDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(operationParameterDeclarationCSEClass, theQVTOperationalPackage.getVarParameter(), "ast", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(operationSimpleSignatureCSEClass, OperationSimpleSignatureCS.class, "OperationSimpleSignatureCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationSimpleSignatureCS_Parameter(), this.getOperationParameterDeclarationCS(), null, "parameter", null, 0, -1, OperationSimpleSignatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(initPartCSEClass, InitPartCS.class, "InitPartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInitPartCS_InitOp(), this.getInitOp(), "initOp", null, 0, 1, InitPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInitPartCS_Expression(), theEssentialOCLCSTPackage.getExpCS(), null, "expression", null, 0, 1, InitPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metamodelCSEClass, MetamodelCS.class, "MetamodelCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetamodelCS_MetamodelKind(), this.getMetamodelKind(), "metamodelKind", null, 0, 1, MetamodelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(metamodelCSEClass, thePivotPackage.getPackage(), "ast", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(primitiveTypeCSEClass, PrimitiveTypeCS.class, "PrimitiveTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classifierPropertyCSEClass, ClassifierPropertyCS.class, "ClassifierPropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassifierPropertyCS_Stereotypes(), theBaseCSTPackage.getElementCS(), null, "stereotypes", null, 0, 1, ClassifierPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassifierPropertyCS_Opposite(), ecorePackage.getEString(), "opposite", null, 0, 1, ClassifierPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(classifierPropertyCSEClass, thePivotPackage.getProperty(), "ast", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(stereotypeQualifierCSEClass, StereotypeQualifierCS.class, "StereotypeQualifierCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStereotypeQualifierCS_Stereotype(), ecorePackage.getEString(), "stereotype", null, 0, -1, StereotypeQualifierCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tagCSEClass, TagCS.class, "TagCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTagCS_PathName(), theBaseCSTPackage.getPathNameCS(), null, "pathName", null, 0, 1, TagCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTagCS_Expression(), theEssentialOCLCSTPackage.getExpCS(), null, "expression", null, 0, 1, TagCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exceptionCSEClass, ExceptionCS.class, "ExceptionCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classifierDefCSEClass, ClassifierDefCS.class, "ClassifierDefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassifierDefCS_SimpleNameCS(), ecorePackage.getEString(), "simpleNameCS", null, 1, 1, ClassifierDefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassifierDefCS_Extends(), theBaseCSTPackage.getTypeCS(), null, "extends", null, 0, -1, ClassifierDefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassifierDefCS_Properties(), this.getClassifierProperty2CS(), null, "properties", null, 0, -1, ClassifierDefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassifierDefCS_Tags(), this.getTagCS(), null, "tags", null, 0, -1, ClassifierDefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classifierProperty2CSEClass, ClassifierProperty2CS.class, "ClassifierProperty2CS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassifierProperty2CS_StereotypeQualifiers(), ecorePackage.getEString(), "stereotypeQualifiers", null, 0, -1, ClassifierProperty2CS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassifierProperty2CS_FeatureKeys(), ecorePackage.getEString(), "featureKeys", null, 0, -1, ClassifierProperty2CS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassifierProperty2CS_Multiplicity(), this.getMultiplicityDefCS(), null, "multiplicity", null, 0, 1, ClassifierProperty2CS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassifierProperty2CS_Opposite(), this.getOppositePropertyCS(), null, "opposite", null, 0, 1, ClassifierProperty2CS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassifierProperty2CS_IsOrdered(), ecorePackage.getEBoolean(), "isOrdered", "true", 0, 1, ClassifierProperty2CS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(completeSignatureCSEClass, CompleteSignatureCS.class, "CompleteSignatureCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompleteSignatureCS_SimpleSignature(), this.getSimpleSignatureCS(), null, "simpleSignature", null, 1, 1, CompleteSignatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompleteSignatureCS_ResultParams(), this.getParameterDeclarationCS(), null, "resultParams", null, 0, -1, CompleteSignatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configPropertyCSEClass, ConfigPropertyCS.class, "ConfigPropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfigPropertyCS_TypeCS(), theBaseCSTPackage.getTypeCS(), null, "typeCS", null, 0, 1, ConfigPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constructorCSEClass, ConstructorCS.class, "ConstructorCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstructorCS_Expressions(), theEssentialOCLCSTPackage.getExpCS(), null, "expressions", null, 0, -1, ConstructorCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contextualPropertyCSEClass, ContextualPropertyCS.class, "ContextualPropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContextualPropertyCS_ScopedNameCS(), this.getScopedNameCS(), null, "scopedNameCS", null, 0, 1, ContextualPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContextualPropertyCS_TypeCS(), theBaseCSTPackage.getTypeCS(), null, "typeCS", null, 0, 1, ContextualPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContextualPropertyCS_OclExpressionCS(), theEssentialOCLCSTPackage.getExpCS(), null, "oclExpressionCS", null, 0, 1, ContextualPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementWithBodyEClass, ElementWithBody.class, "ElementWithBody", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElementWithBody_BodyStartLocation(), ecorePackage.getEInt(), "bodyStartLocation", "0", 0, 1, ElementWithBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElementWithBody_BodyEndLocation(), ecorePackage.getEInt(), "bodyEndLocation", "0", 0, 1, ElementWithBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imperativeOperationCallExpCSEClass, ImperativeOperationCallExpCS.class, "ImperativeOperationCallExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImperativeOperationCallExpCS_Module(), ecorePackage.getEString(), "module", null, 0, 1, ImperativeOperationCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libraryImportCSEClass, LibraryImportCS.class, "LibraryImportCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(localPropertyCSEClass, LocalPropertyCS.class, "LocalPropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLocalPropertyCS_TypeCS(), theBaseCSTPackage.getTypeCS(), null, "typeCS", null, 0, 1, LocalPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLocalPropertyCS_OclExpressionCS(), theEssentialOCLCSTPackage.getExpCS(), null, "oclExpressionCS", null, 0, 1, LocalPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingBodyCSEClass, MappingBodyCS.class, "MappingBodyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingBodyCS_HasPopulationKeyword(), ecorePackage.getEBoolean(), "hasPopulationKeyword", null, 0, 1, MappingBodyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingCallExpCSEClass, MappingCallExpCS.class, "MappingCallExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingCallExpCS_Strict(), ecorePackage.getEBoolean(), "strict", null, 0, 1, MappingCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingOperationCSEClass, MappingOperationCS.class, "MappingOperationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingOperationCS_ContextType(), theBaseCSTPackage.getTypeCS(), null, "contextType", null, 0, 1, MappingOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingOperationCS_Signature(), this.getOperationSimpleSignatureCS(), null, "signature", null, 1, 1, MappingOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingOperationCS_Result(), this.getParameterDeclarationCS(), null, "result", null, 0, -1, MappingOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingOperationCS_DirectionKindCS(), this.getDirectionKindCS(), "directionKindCS", null, 0, 1, MappingOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingOperationCS_MappingExtension(), this.getMappingExtensionCS(), null, "mappingExtension", null, 0, -1, MappingOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingOperationCS_IsQuery(), ecorePackage.getEBoolean(), "isQuery", null, 0, 1, MappingOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(mappingOperationCSEClass, theQVTOperationalPackage.getMappingOperation(), "ast", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(mappingEndCSEClass, MappingEndCS.class, "MappingEndCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingExtensionCSEClass, MappingExtensionCS.class, "MappingExtensionCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingExtensionCS_Kind(), this.getMappingExtensionKindCS(), "kind", "disjuncts", 0, 1, MappingExtensionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingExtensionCS_MappingIdentifiers(), this.getScopedNameCS(), null, "mappingIdentifiers", null, 1, -1, MappingExtensionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingInitCSEClass, MappingInitCS.class, "MappingInitCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingMethodCSEClass, MappingMethodCS.class, "MappingMethodCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingMethodCS_BlackBox(), ecorePackage.getEBoolean(), "blackBox", null, 0, 1, MappingMethodCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingMethodCS_MappingDeclarationCS(), this.getMappingOperationCS(), null, "mappingDeclarationCS", null, 0, 1, MappingMethodCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingModuleCSEClass, MappingModuleCS.class, "MappingModuleCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingModuleCS_HeaderCS(), this.getTransformationCS(), null, "headerCS", null, 1, 1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingModuleCS_Imports(), this.getQVToImportCS(), null, "imports", null, 0, -1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingModuleCS_Metamodels(), this.getModelTypeCS(), null, "metamodels", null, 0, -1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingModuleCS_Renamings(), this.getRenameCS(), null, "renamings", null, 0, -1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingModuleCS_Properties(), this.getModulePropertyCS(), null, "properties", null, 0, -1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingModuleCS_Methods(), this.getMappingMethodCS(), null, "methods", null, 0, -1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingModuleCS_ClassifierDefCS(), this.getClassifierDefCS(), null, "classifierDefCS", null, 0, -1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingModuleCS_Tags(), this.getTagCS(), null, "tags", null, 0, -1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingQueryCSEClass, MappingQueryCS.class, "MappingQueryCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingQueryCS_Expressions(), theEssentialOCLCSTPackage.getExpCS(), null, "expressions", null, 0, -1, MappingQueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingQueryCS_IsSimpleDefinition(), ecorePackage.getEBoolean(), "isSimpleDefinition", null, 0, 1, MappingQueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingRuleCSEClass, MappingRuleCS.class, "MappingRuleCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingRuleCS_Guard(), theEssentialOCLCSTPackage.getExpCS(), null, "guard", null, 0, 1, MappingRuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingRuleCS_MappingBody(), this.getMappingSectionsCS(), null, "mappingBody", null, 0, 1, MappingRuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingSectionCSEClass, MappingSectionCS.class, "MappingSectionCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingSectionCS_Statements(), theEssentialOCLCSTPackage.getExpCS(), null, "statements", null, 0, -1, MappingSectionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingSectionCS_MappingRuleCS(), this.getMappingRuleCS(), null, "mappingRuleCS", null, 0, 1, MappingSectionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingSectionsCSEClass, MappingSectionsCS.class, "MappingSectionsCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingSectionsCS_MappingInitCS(), this.getMappingInitCS(), null, "mappingInitCS", null, 0, 1, MappingSectionsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingSectionsCS_MappingBodyCS(), this.getMappingBodyCS(), null, "mappingBodyCS", null, 0, 1, MappingSectionsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingSectionsCS_MappingEndCS(), this.getMappingEndCS(), null, "mappingEndCS", null, 0, 1, MappingSectionsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moduleKindCSEClass, ModuleKindCS.class, "ModuleKindCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModuleKindCS_ModuleKind(), this.getModuleKindEnum(), "moduleKind", null, 0, 1, ModuleKindCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moduleRefCSEClass, ModuleRefCS.class, "ModuleRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModuleRefCS_PathNameCS(), theBaseCSTPackage.getPathNameCS(), null, "pathNameCS", null, 1, 1, ModuleRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModuleRefCS_Parameters(), this.getParameterDeclarationCS(), null, "parameters", null, 0, -1, ModuleRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelTypeCSEClass, ModelTypeCS.class, "ModelTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelTypeCS_IdentifierCS(), ecorePackage.getEString(), "identifierCS", null, 1, 1, ModelTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelTypeCS_ComplianceKindCS(), theEssentialOCLCSTPackage.getStringLiteralExpCS(), null, "complianceKindCS", null, 0, 1, ModelTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelTypeCS_PackageRefs(), this.getPackageRefCS(), null, "packageRefs", null, 1, -1, ModelTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelTypeCS_WhereStatements(), theEssentialOCLCSTPackage.getExpCS(), null, "whereStatements", null, 0, -1, ModelTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modulePropertyCSEClass, ModulePropertyCS.class, "ModulePropertyCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModulePropertyCS_SimpleNameCS(), ecorePackage.getEString(), "simpleNameCS", null, 0, 1, ModulePropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moduleUsageCSEClass, ModuleUsageCS.class, "ModuleUsageCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModuleUsageCS_ImportKind(), this.getImportKindEnum(), "importKind", null, 0, 1, ModuleUsageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModuleUsageCS_ModuleKindCS(), this.getModuleKindCS(), null, "moduleKindCS", null, 0, 1, ModuleUsageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModuleUsageCS_ModuleRefs(), this.getModuleRefCS(), null, "moduleRefs", null, 1, -1, ModuleUsageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiplicityDefCSEClass, MultiplicityDefCS.class, "MultiplicityDefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiplicityDefCS_LowerBound(), theEssentialOCLCSTPackage.getPrimitiveLiteralExpCS(), null, "lowerBound", null, 1, 1, MultiplicityDefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiplicityDefCS_UpperBound(), theEssentialOCLCSTPackage.getPrimitiveLiteralExpCS(), null, "upperBound", null, 1, 1, MultiplicityDefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectExpCSEClass, ObjectExpCS.class, "ObjectExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getObjectExpCS_SimpleNameCS(), ecorePackage.getEString(), "simpleNameCS", null, 0, 1, ObjectExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObjectExpCS_IsImplicit(), ecorePackage.getEBoolean(), "isImplicit", null, 0, 1, ObjectExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oppositePropertyCSEClass, OppositePropertyCS.class, "OppositePropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOppositePropertyCS_IsNavigable(), ecorePackage.getEBoolean(), "isNavigable", "true", 0, 1, OppositePropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOppositePropertyCS_SimpleNameCS(), ecorePackage.getEString(), "simpleNameCS", null, 0, 1, OppositePropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOppositePropertyCS_Multiplicity(), this.getMultiplicityDefCS(), null, "multiplicity", null, 0, 1, OppositePropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterDeclarationCSEClass, ParameterDeclarationCS.class, "ParameterDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameterDeclarationCS_Direction(), this.getDirectionKindCS(), "direction", null, 0, 1, ParameterDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameterDeclarationCS_InitPart(), this.getInitPartCS(), null, "initPart", null, 0, 1, ParameterDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(renameCSEClass, RenameCS.class, "RenameCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRenameCS_TypeCS(), theBaseCSTPackage.getTypeCS(), null, "typeCS", null, 0, 1, RenameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRenameCS_SimpleNameCS(), ecorePackage.getEString(), "simpleNameCS", null, 0, 1, RenameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRenameCS_OriginalName(), theEssentialOCLCSTPackage.getStringLiteralExpCS(), null, "originalName", null, 0, 1, RenameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resolveOpArgsExpCSEClass, ResolveOpArgsExpCS.class, "ResolveOpArgsExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResolveOpArgsExpCS_Target(), theEssentialOCLCSTPackage.getVariableCS(), null, "target", null, 0, 1, ResolveOpArgsExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResolveOpArgsExpCS_Condition(), theEssentialOCLCSTPackage.getExpCS(), null, "condition", null, 0, 1, ResolveOpArgsExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packageRefCSEClass, PackageRefCS.class, "PackageRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPackageRefCS_PathNameCS(), theBaseCSTPackage.getPathNameCS(), null, "pathNameCS", null, 0, 1, PackageRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageRefCS_UriCS(), theEssentialOCLCSTPackage.getStringLiteralExpCS(), null, "uriCS", null, 0, 1, PackageRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scopedNameCSEClass, ScopedNameCS.class, "ScopedNameCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScopedNameCS_TypeCS(), theBaseCSTPackage.getTypeCS(), null, "typeCS", null, 0, 1, ScopedNameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScopedNameCS_Name(), ecorePackage.getEString(), "name", null, 1, 1, ScopedNameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleSignatureCSEClass, SimpleSignatureCS.class, "SimpleSignatureCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimpleSignatureCS_Parameter(), this.getParameterDeclarationCS(), null, "parameter", null, 0, -1, SimpleSignatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationCSEClass, TransformationCS.class, "TransformationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformationCS_Qualifiers(), theEssentialOCLCSTPackage.getStringLiteralExpCS(), null, "qualifiers", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_PathNameCS(), theBaseCSTPackage.getPathNameCS(), null, "pathNameCS", null, 1, 1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_Parameters(), this.getParameterDeclarationCS(), null, "parameters", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_ModuleUsages(), this.getModuleUsageCS(), null, "moduleUsages", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_TransformationRefineCS(), this.getTransformationRefineCS(), null, "transformationRefineCS", null, 0, 1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(transformationCSEClass, theQVTOperationalPackage.getOperationalTransformation(), "ast", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(transformationRefineCSEClass, TransformationRefineCS.class, "TransformationRefineCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformationRefineCS_ModuleRefCS(), this.getModuleRefCS(), null, "moduleRefCS", null, 1, 1, TransformationRefineCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformationRefineCS_SimpleNameCS(), ecorePackage.getEString(), "simpleNameCS", null, 1, 1, TransformationRefineCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeSpecCSEClass, TypeSpecCS.class, "TypeSpecCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeSpecCS_OwnedType(), theBaseCSTPackage.getTypedRefCS(), null, "ownedType", null, 1, 1, TypeSpecCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypeSpecCS_ExtentLocation(), ecorePackage.getEString(), "extentLocation", null, 0, 1, TypeSpecCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitCSEClass, UnitCS.class, "UnitCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnitCS_Segment(), ecorePackage.getEString(), "segment", null, 0, -1, UnitCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnitCS_TopLevelElements(), theBaseCSTPackage.getElementCS(), null, "topLevelElements", null, 0, -1, UnitCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnitCS_Modules(), this.getMappingModuleCS(), null, "modules", null, 0, -1, UnitCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getUnitCS_ModelTypes(), this.getModelTypeCS(), null, "modelTypes", null, 0, -1, UnitCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getUnitCS_Imports(), this.getQVToImportCS(), null, "imports", null, 0, -1, UnitCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(resolveExpCSEClass, ResolveExpCS.class, "ResolveExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResolveExpCS_One(), ecorePackage.getEBoolean(), "one", null, 1, 1, ResolveExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResolveExpCS_IsInverse(), ecorePackage.getEBoolean(), "isInverse", null, 1, 1, ResolveExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResolveExpCS_IsDeferred(), ecorePackage.getEBoolean(), "isDeferred", null, 1, 1, ResolveExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResolveExpCS_Target(), theEssentialOCLCSTPackage.getVariableCS(), null, "target", null, 0, 1, ResolveExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResolveExpCS_Condition(), theEssentialOCLCSTPackage.getExpCS(), null, "condition", null, 0, 1, ResolveExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resolveInExpCSEClass, ResolveInExpCS.class, "ResolveInExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResolveInExpCS_InMappingType(), theBaseCSTPackage.getTypeCS(), null, "inMappingType", null, 1, 1, ResolveInExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResolveInExpCS_InMappingName(), ecorePackage.getEString(), "inMappingName", null, 1, 1, ResolveInExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(classifierKindEEnum, ClassifierKind.class, "ClassifierKind");
		addEEnumLiteral(classifierKindEEnum, ClassifierKind.DATATYPE);
		addEEnumLiteral(classifierKindEEnum, ClassifierKind.PRIMITIVE);
		addEEnumLiteral(classifierKindEEnum, ClassifierKind.EXCEPTION);
		addEEnumLiteral(classifierKindEEnum, ClassifierKind.CLASS);

		initEEnum(featureKeyEEnum, FeatureKey.class, "FeatureKey");
		addEEnumLiteral(featureKeyEEnum, FeatureKey.COMPOSES);
		addEEnumLiteral(featureKeyEEnum, FeatureKey.REFERRENCES);
		addEEnumLiteral(featureKeyEEnum, FeatureKey.READONLY);
		addEEnumLiteral(featureKeyEEnum, FeatureKey.DERIVED);
		addEEnumLiteral(featureKeyEEnum, FeatureKey.STATIC);

		initEEnum(initOpEEnum, InitOp.class, "InitOp");
		addEEnumLiteral(initOpEEnum, InitOp.EQUALS);
		addEEnumLiteral(initOpEEnum, InitOp.COLON_EQUALS);
		addEEnumLiteral(initOpEEnum, InitOp.COLON_COLON_EQUALS);

		initEEnum(metamodelKindEEnum, MetamodelKind.class, "MetamodelKind");
		addEEnumLiteral(metamodelKindEEnum, MetamodelKind.METAMODEL);
		addEEnumLiteral(metamodelKindEEnum, MetamodelKind.PACKAGE);

		initEEnum(directionKindCSEEnum, DirectionKindCS.class, "DirectionKindCS");
		addEEnumLiteral(directionKindCSEEnum, DirectionKindCS.IN);
		addEEnumLiteral(directionKindCSEEnum, DirectionKindCS.OUT);
		addEEnumLiteral(directionKindCSEEnum, DirectionKindCS.INOUT);

		initEEnum(importKindEnumEEnum, ImportKindEnum.class, "ImportKindEnum");
		addEEnumLiteral(importKindEnumEEnum, ImportKindEnum.EXTENSION);
		addEEnumLiteral(importKindEnumEEnum, ImportKindEnum.ACCESS);

		initEEnum(mappingExtensionKindCSEEnum, MappingExtensionKindCS.class, "MappingExtensionKindCS");
		addEEnumLiteral(mappingExtensionKindCSEEnum, MappingExtensionKindCS.DISJUNCTS);
		addEEnumLiteral(mappingExtensionKindCSEEnum, MappingExtensionKindCS.MERGES);
		addEEnumLiteral(mappingExtensionKindCSEEnum, MappingExtensionKindCS.INHERITS);

		initEEnum(moduleKindEnumEEnum, ModuleKindEnum.class, "ModuleKindEnum");
		addEEnumLiteral(moduleKindEnumEEnum, ModuleKindEnum.TRANSFORMATION);
		addEEnumLiteral(moduleKindEnumEEnum, ModuleKindEnum.LIBRARY);

		initEEnum(qualifierKindCSEEnum, QualifierKindCS.class, "QualifierKindCS");
		addEEnumLiteral(qualifierKindCSEEnum, QualifierKindCS.ABSTRACT);
		addEEnumLiteral(qualifierKindCSEEnum, QualifierKindCS.BLACKBOX);
		addEEnumLiteral(qualifierKindCSEEnum, QualifierKindCS.STATIC);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "baseCST", "/resource/org.eclipse.ocl.examples.xtext.base/model/BaseCST.ecore#/",
			 "ecore", "http://www.eclipse.org/emf/2002/Ecore#/",
			 "essentialOCLCST", "/resource/org.eclipse.ocl.examples.xtext.essentialocl/model/EssentialOCLCST.ecore#/",
			 "imperativeocl", "/resource/org.eclipse.qvto.examples.pivot.imperativeocl/model/ImperativeOCL.ecore#ImperativeOCL",
			 "imperativeoclcs", "/resource/org.eclipse.qvto.examples.xtext.imperativeocl/model/ImperativeOCLCS.ecore#/",
			 "qvtoperational", "/resource/org.eclipse.qvto.examples.pivot.qvtoperational/model/QVTOperational.ecore#QVTOperational"
		   });								
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";			
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
		   });							
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";				
		addAnnotation
		  (topLevelCSEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "ocl::Root {\n\t\t\t\tnestedPackage = ownedNestedPackage --.ast() -- FIXME when BaseCST implemented\n\t\t\t\t \n\t\t\t\t\n\t\t\t}"
		   });		
		addAnnotation
		  (qvToClassCSEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "ocl::Class {\n\t\t\t\tname = name,\n\t\t\t\townedAttribute = ownedProperty, -- .ast() FIXME when BASECST implemented\n\t\t\t\townedOperation = ownedOperation -- .ast() FIXME when BASECST implemented\n\t\t\t}"
		   });		
		addAnnotation
		  (operationParameterDeclarationCSEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "qvtoperational::VarParameter {\n\t\t\t\tname = name\n\t\t\t\t--kind = if direction = DirectionKindCS::_in then\n\t\t\t\t--\t\t\tqvtoperational::DirectionKind::_in\n\t\t\t\t--\t   else if direction = DirectionKindCS::_in then\n\t\t\t\t--\t   \t\tqvtoperational::DirectionKind::out\n\t\t\t\t--\t   else \n\t\t\t\t--\t   \t\tqvtoperational::DirectionKind::inout\n\t\t\t\t--\t   endif endif,\n\t\t\t\t--initExpression = if (initPart.oclIsUndefined()) then\n\t\t\t\t--\t\t\t\t\tnull\n\t\t\t\t--\t\t\t\telse\n\t\t\t\t--\t\t\t\t\tinitPart.expression -- FIXME todo .ast()\n\t\t\t\t--\t\t\t\tendif\n\t\t\t}"
		   });		
		addAnnotation
		  (metamodelCSEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "ocl::Package {\n\t\t\t\tname = name,\n\t\t\t\tnsPrefix = name,\t-- QVTo spec doesn\'t provide concrete syntax for nsPrefix\n\t\t\t\tnsURI = name,\t\t-- QVTo spec doesn\'t provide concrete syntax for nsURI. Build an internal protocol\n\t\t\t\townedType = ownedType -- .ast() FIXME when BaseCST is implemented\n\t\t\t\t-- type = TODO\n\t\t\t}"
		   });		
		addAnnotation
		  (classifierPropertyCSEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "ocl::Property {\n\t\t\t\tname = name,\n\t\t\t\tisComposite = qualifier->exists(x | x = \'composite\')\n\t\t\t\t-- type = TODO\n\t\t\t}"
		   });		
		addAnnotation
		  (mappingOperationCSEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "qvtoperational::MappingOperation {\n\t\t\t\tname = name,\n\t\t\t\townedParameter = signature.parameter -- .ast()\n\t\t\t}"
		   });		
		addAnnotation
		  (transformationCSEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "qvtoperational::OperationalTransformation {\n\t\t\t\tname = name,\n\t\t\t\tnsPrefix = name,\n\t\t\t\tnsURI = name,\n\t\t\t\tnestedPackage = ownedNestedPackage, -- FIXME .ast(),\n\t\t\t\townedType = ownedType, -- FIXME .ast(),\n\t\t\t\townedOperation = ownedOperation -- FIXME .ast()\n\t\t\t}"
		   });
	}

} //QVTOperationalCSPackageImpl
