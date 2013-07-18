/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeoclcsPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierDefCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierKind;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConfigPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConstructorCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ContextualPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindEnum;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ElementWithBody;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ExceptionCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.FeatureKey;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImperativeOperationCallExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportKindEnum;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitOp;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LibraryCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LibraryImportCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LocalPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingBodyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingCallExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingDeclarationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingEndCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionKindCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingInitCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingMethodCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS;
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
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OppositePropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PackageRefCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamDirection;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterDeclarationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PrimitiveTypeCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QualifierKindCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsFactory;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.RenameCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveInExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveOpArgsExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ScopedNameCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.StereotypeQualifierCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationHeaderCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationRefineCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class QvtoperationalcsPackageImpl
		extends EPackageImpl
		implements QvtoperationalcsPackage {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topLevelCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryImportCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localPropertyCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingBodyCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingCallExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingDeclarationCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEndCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingExtensionCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingInitCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingMethodCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingModuleCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingQueryCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingRuleCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingSectionCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingSectionsCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleKindCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleRefCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelTypeCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modulePropertyCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleUsageCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplicityDefCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oppositePropertyCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterDeclarationCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass renameCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolveOpArgsExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageRefCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scopedNameCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleSignatureCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationHeaderCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationRefineCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeSpecCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolveExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolveInExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass initPartCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metamodelCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierPropertyCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypeQualifierCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tagCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exceptionCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierDefCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierProperty2CSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completeSignatureCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configPropertyCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constructorCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextualPropertyCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directionKindCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementWithBodyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeOperationCallExpCSEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum classifierKindEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum featureKeyEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum initOpEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum metamodelKindEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum paramDirectionEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum directionKindEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum importKindEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mappingExtensionKindCSEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum moduleKindEnumEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum qualifierKindCSEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QvtoperationalcsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QvtoperationalcsPackageImpl() {
		super(eNS_URI, QvtoperationalcsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link QvtoperationalcsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QvtoperationalcsPackage init() {
		if (isInited) return (QvtoperationalcsPackage)EPackage.Registry.INSTANCE.getEPackage(QvtoperationalcsPackage.eNS_URI);

		// Obtain or create and register package
		QvtoperationalcsPackageImpl theQvtoperationalcsPackage = (QvtoperationalcsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof QvtoperationalcsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new QvtoperationalcsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ImperativeoclcsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQvtoperationalcsPackage.createPackageContents();

		// Initialize created meta-data
		theQvtoperationalcsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQvtoperationalcsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QvtoperationalcsPackage.eNS_URI, theQvtoperationalcsPackage);
		return theQvtoperationalcsPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopLevelCS() {
		return topLevelCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopLevelCS_Import() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopLevelCS_Unit() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImportCS() {
		return importCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImportCS_Unit() {
		return (EReference)importCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImportCS_ImportedUnitElement() {
		return (EAttribute)importCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImportCS_All() {
		return (EAttribute)importCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibraryCS() {
		return libraryCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibraryImportCS() {
		return libraryImportCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalPropertyCS() {
		return localPropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalPropertyCS_TypeCS() {
		return (EReference)localPropertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalPropertyCS_OclExpressionCS() {
		return (EReference)localPropertyCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingBodyCS() {
		return mappingBodyCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingBodyCS_HasPopulationKeyword() {
		return (EAttribute)mappingBodyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingCallExpCS() {
		return mappingCallExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingCallExpCS_Strict() {
		return (EAttribute)mappingCallExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingDeclarationCS() {
		return mappingDeclarationCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingDeclarationCS_Qualifiers() {
		return (EAttribute)mappingDeclarationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingDeclarationCS_SimpleNameCS() {
		return (EAttribute)mappingDeclarationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingDeclarationCS_ContextType() {
		return (EReference)mappingDeclarationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingDeclarationCS_Parameters() {
		return (EReference)mappingDeclarationCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingDeclarationCS_Result() {
		return (EReference)mappingDeclarationCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingDeclarationCS_DirectionKindCS() {
		return (EReference)mappingDeclarationCSEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingDeclarationCS_MappingExtension() {
		return (EReference)mappingDeclarationCSEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingDeclarationCS_IsQuery() {
		return (EAttribute)mappingDeclarationCSEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingEndCS() {
		return mappingEndCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingExtensionCS() {
		return mappingExtensionCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingExtensionCS_Kind() {
		return (EAttribute)mappingExtensionCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingExtensionCS_MappingIdentifiers() {
		return (EReference)mappingExtensionCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingInitCS() {
		return mappingInitCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingMethodCS() {
		return mappingMethodCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingMethodCS_BlackBox() {
		return (EAttribute)mappingMethodCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingMethodCS_MappingDeclarationCS() {
		return (EReference)mappingMethodCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingModuleCS() {
		return mappingModuleCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_HeaderCS() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_Imports() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_Metamodels() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_Renamings() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_Properties() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_Methods() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_ClassifierDefCS() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_Tags() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingQueryCS() {
		return mappingQueryCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingQueryCS_Expressions() {
		return (EReference)mappingQueryCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingQueryCS_IsSimpleDefinition() {
		return (EAttribute)mappingQueryCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingRuleCS() {
		return mappingRuleCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingRuleCS_Guard() {
		return (EReference)mappingRuleCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingRuleCS_MappingBody() {
		return (EReference)mappingRuleCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingSectionCS() {
		return mappingSectionCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingSectionCS_Statements() {
		return (EReference)mappingSectionCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingSectionCS_MappingRuleCS() {
		return (EReference)mappingSectionCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingSectionsCS() {
		return mappingSectionsCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingSectionsCS_MappingInitCS() {
		return (EReference)mappingSectionsCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingSectionsCS_MappingBodyCS() {
		return (EReference)mappingSectionsCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingSectionsCS_MappingEndCS() {
		return (EReference)mappingSectionsCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleKindCS() {
		return moduleKindCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModuleKindCS_ModuleKind() {
		return (EAttribute)moduleKindCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleRefCS() {
		return moduleRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleRefCS_PathNameCS() {
		return (EReference)moduleRefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleRefCS_Parameters() {
		return (EReference)moduleRefCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelTypeCS() {
		return modelTypeCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelTypeCS_IdentifierCS() {
		return (EAttribute)modelTypeCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelTypeCS_ComplianceKindCS() {
		return (EReference)modelTypeCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelTypeCS_PackageRefs() {
		return (EReference)modelTypeCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelTypeCS_WhereStatements() {
		return (EReference)modelTypeCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModulePropertyCS() {
		return modulePropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModulePropertyCS_SimpleNameCS() {
		return (EAttribute)modulePropertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleUsageCS() {
		return moduleUsageCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModuleUsageCS_ImportKind() {
		return (EAttribute)moduleUsageCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleUsageCS_ModuleKindCS() {
		return (EReference)moduleUsageCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleUsageCS_ModuleRefs() {
		return (EReference)moduleUsageCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiplicityDefCS() {
		return multiplicityDefCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiplicityDefCS_LowerBound() {
		return (EReference)multiplicityDefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiplicityDefCS_UpperBound() {
		return (EReference)multiplicityDefCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectExpCS() {
		return objectExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectExpCS_SimpleNameCS() {
		return (EAttribute)objectExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectExpCS_IsImplicit() {
		return (EAttribute)objectExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOppositePropertyCS() {
		return oppositePropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOppositePropertyCS_IsNavigable() {
		return (EAttribute)oppositePropertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOppositePropertyCS_SimpleNameCS() {
		return (EAttribute)oppositePropertyCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOppositePropertyCS_Multiplicity() {
		return (EReference)oppositePropertyCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterDeclarationCS() {
		return parameterDeclarationCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterDeclarationCS_SimpleNameCS() {
		return (EAttribute)parameterDeclarationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterDeclarationCS_TypeSpecCS() {
		return (EReference)parameterDeclarationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterDeclarationCS_DirectionKind() {
		return (EAttribute)parameterDeclarationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRenameCS() {
		return renameCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRenameCS_TypeCS() {
		return (EReference)renameCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRenameCS_SimpleNameCS() {
		return (EAttribute)renameCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRenameCS_OriginalName() {
		return (EReference)renameCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolveOpArgsExpCS() {
		return resolveOpArgsExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolveOpArgsExpCS_Target() {
		return (EReference)resolveOpArgsExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolveOpArgsExpCS_Condition() {
		return (EReference)resolveOpArgsExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageRefCS() {
		return packageRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageRefCS_PathNameCS() {
		return (EReference)packageRefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageRefCS_UriCS() {
		return (EReference)packageRefCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScopedNameCS() {
		return scopedNameCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScopedNameCS_TypeCS() {
		return (EReference)scopedNameCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScopedNameCS_Name() {
		return (EAttribute)scopedNameCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleSignatureCS() {
		return simpleSignatureCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleSignatureCS_Params() {
		return (EReference)simpleSignatureCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformationHeaderCS() {
		return transformationHeaderCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationHeaderCS_Qualifiers() {
		return (EReference)transformationHeaderCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationHeaderCS_PathNameCS() {
		return (EReference)transformationHeaderCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationHeaderCS_Parameters() {
		return (EReference)transformationHeaderCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationHeaderCS_ModuleUsages() {
		return (EReference)transformationHeaderCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationHeaderCS_TransformationRefineCS() {
		return (EReference)transformationHeaderCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformationRefineCS() {
		return transformationRefineCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationRefineCS_ModuleRefCS() {
		return (EReference)transformationRefineCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformationRefineCS_SimpleNameCS() {
		return (EAttribute)transformationRefineCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeSpecCS() {
		return typeSpecCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeSpecCS_TypeCS() {
		return (EReference)typeSpecCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeSpecCS_SimpleNameCS() {
		return (EAttribute)typeSpecCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitCS() {
		return unitCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitCS_Segment() {
		return (EAttribute)unitCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitCS_TopLevelElements() {
		return (EReference)unitCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitCS_Modules() {
		return (EReference)unitCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitCS_ModelTypes() {
		return (EReference)unitCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitCS_Imports() {
		return (EReference)unitCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolveExpCS() {
		return resolveExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResolveExpCS_One() {
		return (EAttribute)resolveExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResolveExpCS_IsInverse() {
		return (EAttribute)resolveExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResolveExpCS_IsDeferred() {
		return (EAttribute)resolveExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolveExpCS_Target() {
		return (EReference)resolveExpCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolveExpCS_Condition() {
		return (EReference)resolveExpCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolveInExpCS() {
		return resolveInExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolveInExpCS_InMappingType() {
		return (EReference)resolveInExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResolveInExpCS_InMappingName() {
		return (EAttribute)resolveInExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterCS() {
		return parameterCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterCS_Direction() {
		return (EAttribute)parameterCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterCS_InitPart() {
		return (EReference)parameterCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInitPartCS() {
		return initPartCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInitPartCS_InitOp() {
		return (EAttribute)initPartCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInitPartCS_Expression() {
		return (EReference)initPartCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetamodelCS() {
		return metamodelCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetamodelCS_MetamodelKind() {
		return (EAttribute)metamodelCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetamodelCS_Element() {
		return (EReference)metamodelCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveTypeCS() {
		return primitiveTypeCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassCS() {
		return classCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassCS_Intermediate() {
		return (EAttribute)classCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierPropertyCS() {
		return classifierPropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierPropertyCS_Stereotypes() {
		return (EReference)classifierPropertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierPropertyCS_Opposite() {
		return (EAttribute)classifierPropertyCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStereotypeQualifierCS() {
		return stereotypeQualifierCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStereotypeQualifierCS_Stereotype() {
		return (EAttribute)stereotypeQualifierCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationCS() {
		return operationCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCS_Stereotypes() {
		return (EReference)operationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTagCS() {
		return tagCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTagCS_PathName() {
		return (EReference)tagCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTagCS_Expression() {
		return (EReference)tagCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExceptionCS() {
		return exceptionCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierDefCS() {
		return classifierDefCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierDefCS_SimpleNameCS() {
		return (EAttribute)classifierDefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierDefCS_Extends() {
		return (EReference)classifierDefCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierDefCS_Properties() {
		return (EReference)classifierDefCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierDefCS_Tags() {
		return (EReference)classifierDefCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierProperty2CS() {
		return classifierProperty2CSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierProperty2CS_StereotypeQualifiers() {
		return (EAttribute)classifierProperty2CSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierProperty2CS_FeatureKeys() {
		return (EAttribute)classifierProperty2CSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierProperty2CS_Multiplicity() {
		return (EReference)classifierProperty2CSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierProperty2CS_Opposite() {
		return (EReference)classifierProperty2CSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierProperty2CS_IsOrdered() {
		return (EAttribute)classifierProperty2CSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompleteSignatureCS() {
		return completeSignatureCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompleteSignatureCS_SimpleSignature() {
		return (EReference)completeSignatureCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompleteSignatureCS_ResultParams() {
		return (EReference)completeSignatureCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigPropertyCS() {
		return configPropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigPropertyCS_TypeCS() {
		return (EReference)configPropertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstructorCS() {
		return constructorCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstructorCS_Expressions() {
		return (EReference)constructorCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContextualPropertyCS() {
		return contextualPropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextualPropertyCS_ScopedNameCS() {
		return (EReference)contextualPropertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextualPropertyCS_TypeCS() {
		return (EReference)contextualPropertyCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextualPropertyCS_OclExpressionCS() {
		return (EReference)contextualPropertyCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirectionKindCS() {
		return directionKindCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDirectionKindCS_DirectionKind() {
		return (EAttribute)directionKindCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementWithBody() {
		return elementWithBodyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementWithBody_BodyStartLocation() {
		return (EAttribute)elementWithBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementWithBody_BodyEndLocation() {
		return (EAttribute)elementWithBodyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImperativeOperationCallExpCS() {
		return imperativeOperationCallExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImperativeOperationCallExpCS_Module() {
		return (EAttribute)imperativeOperationCallExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getClassifierKind() {
		return classifierKindEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFeatureKey() {
		return featureKeyEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getInitOp() {
		return initOpEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMetamodelKind() {
		return metamodelKindEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getParamDirection() {
		return paramDirectionEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDirectionKindEnum() {
		return directionKindEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getImportKindEnum() {
		return importKindEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMappingExtensionKindCS() {
		return mappingExtensionKindCSEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getModuleKindEnum() {
		return moduleKindEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getQualifierKindCS() {
		return qualifierKindCSEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public QvtoperationalcsFactory getQvtoperationalcsFactory() {
		return (QvtoperationalcsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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

		parameterCSEClass = createEClass(PARAMETER_CS);
		createEAttribute(parameterCSEClass, PARAMETER_CS__DIRECTION);
		createEReference(parameterCSEClass, PARAMETER_CS__INIT_PART);

		initPartCSEClass = createEClass(INIT_PART_CS);
		createEAttribute(initPartCSEClass, INIT_PART_CS__INIT_OP);
		createEReference(initPartCSEClass, INIT_PART_CS__EXPRESSION);

		metamodelCSEClass = createEClass(METAMODEL_CS);
		createEAttribute(metamodelCSEClass, METAMODEL_CS__METAMODEL_KIND);
		createEReference(metamodelCSEClass, METAMODEL_CS__ELEMENT);

		primitiveTypeCSEClass = createEClass(PRIMITIVE_TYPE_CS);

		classCSEClass = createEClass(CLASS_CS);
		createEAttribute(classCSEClass, CLASS_CS__INTERMEDIATE);

		classifierPropertyCSEClass = createEClass(CLASSIFIER_PROPERTY_CS);
		createEReference(classifierPropertyCSEClass, CLASSIFIER_PROPERTY_CS__STEREOTYPES);
		createEAttribute(classifierPropertyCSEClass, CLASSIFIER_PROPERTY_CS__OPPOSITE);

		stereotypeQualifierCSEClass = createEClass(STEREOTYPE_QUALIFIER_CS);
		createEAttribute(stereotypeQualifierCSEClass, STEREOTYPE_QUALIFIER_CS__STEREOTYPE);

		operationCSEClass = createEClass(OPERATION_CS);
		createEReference(operationCSEClass, OPERATION_CS__STEREOTYPES);

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

		directionKindCSEClass = createEClass(DIRECTION_KIND_CS);
		createEAttribute(directionKindCSEClass, DIRECTION_KIND_CS__DIRECTION_KIND);

		elementWithBodyEClass = createEClass(ELEMENT_WITH_BODY);
		createEAttribute(elementWithBodyEClass, ELEMENT_WITH_BODY__BODY_START_LOCATION);
		createEAttribute(elementWithBodyEClass, ELEMENT_WITH_BODY__BODY_END_LOCATION);

		imperativeOperationCallExpCSEClass = createEClass(IMPERATIVE_OPERATION_CALL_EXP_CS);
		createEAttribute(imperativeOperationCallExpCSEClass, IMPERATIVE_OPERATION_CALL_EXP_CS__MODULE);

		importCSEClass = createEClass(IMPORT_CS);
		createEReference(importCSEClass, IMPORT_CS__UNIT);
		createEAttribute(importCSEClass, IMPORT_CS__IMPORTED_UNIT_ELEMENT);
		createEAttribute(importCSEClass, IMPORT_CS__ALL);

		libraryCSEClass = createEClass(LIBRARY_CS);

		libraryImportCSEClass = createEClass(LIBRARY_IMPORT_CS);

		localPropertyCSEClass = createEClass(LOCAL_PROPERTY_CS);
		createEReference(localPropertyCSEClass, LOCAL_PROPERTY_CS__TYPE_CS);
		createEReference(localPropertyCSEClass, LOCAL_PROPERTY_CS__OCL_EXPRESSION_CS);

		mappingBodyCSEClass = createEClass(MAPPING_BODY_CS);
		createEAttribute(mappingBodyCSEClass, MAPPING_BODY_CS__HAS_POPULATION_KEYWORD);

		mappingCallExpCSEClass = createEClass(MAPPING_CALL_EXP_CS);
		createEAttribute(mappingCallExpCSEClass, MAPPING_CALL_EXP_CS__STRICT);

		mappingDeclarationCSEClass = createEClass(MAPPING_DECLARATION_CS);
		createEAttribute(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__QUALIFIERS);
		createEAttribute(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__SIMPLE_NAME_CS);
		createEReference(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__CONTEXT_TYPE);
		createEReference(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__PARAMETERS);
		createEReference(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__RESULT);
		createEReference(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__DIRECTION_KIND_CS);
		createEReference(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__MAPPING_EXTENSION);
		createEAttribute(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__IS_QUERY);

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
		createEAttribute(parameterDeclarationCSEClass, PARAMETER_DECLARATION_CS__SIMPLE_NAME_CS);
		createEReference(parameterDeclarationCSEClass, PARAMETER_DECLARATION_CS__TYPE_SPEC_CS);
		createEAttribute(parameterDeclarationCSEClass, PARAMETER_DECLARATION_CS__DIRECTION_KIND);

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
		createEReference(simpleSignatureCSEClass, SIMPLE_SIGNATURE_CS__PARAMS);

		transformationHeaderCSEClass = createEClass(TRANSFORMATION_HEADER_CS);
		createEReference(transformationHeaderCSEClass, TRANSFORMATION_HEADER_CS__QUALIFIERS);
		createEReference(transformationHeaderCSEClass, TRANSFORMATION_HEADER_CS__PATH_NAME_CS);
		createEReference(transformationHeaderCSEClass, TRANSFORMATION_HEADER_CS__PARAMETERS);
		createEReference(transformationHeaderCSEClass, TRANSFORMATION_HEADER_CS__MODULE_USAGES);
		createEReference(transformationHeaderCSEClass, TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS);

		transformationRefineCSEClass = createEClass(TRANSFORMATION_REFINE_CS);
		createEReference(transformationRefineCSEClass, TRANSFORMATION_REFINE_CS__MODULE_REF_CS);
		createEAttribute(transformationRefineCSEClass, TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS);

		typeSpecCSEClass = createEClass(TYPE_SPEC_CS);
		createEReference(typeSpecCSEClass, TYPE_SPEC_CS__TYPE_CS);
		createEAttribute(typeSpecCSEClass, TYPE_SPEC_CS__SIMPLE_NAME_CS);

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
		paramDirectionEEnum = createEEnum(PARAM_DIRECTION);
		directionKindEnumEEnum = createEEnum(DIRECTION_KIND_ENUM);
		importKindEnumEEnum = createEEnum(IMPORT_KIND_ENUM);
		mappingExtensionKindCSEEnum = createEEnum(MAPPING_EXTENSION_KIND_CS);
		moduleKindEnumEEnum = createEEnum(MODULE_KIND_ENUM);
		qualifierKindCSEEnum = createEEnum(QUALIFIER_KIND_CS);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
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
		EssentialOCLCSTPackage theEssentialOCLCSTPackage = (EssentialOCLCSTPackage)EPackage.Registry.INSTANCE.getEPackage(EssentialOCLCSTPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		ImperativeoclcsPackage theImperativeoclcsPackage = (ImperativeoclcsPackage)EPackage.Registry.INSTANCE.getEPackage(ImperativeoclcsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		topLevelCSEClass.getESuperTypes().add(theBaseCSTPackage.getModelElementCS());
		parameterCSEClass.getESuperTypes().add(theBaseCSTPackage.getParameterCS());
		initPartCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		metamodelCSEClass.getESuperTypes().add(theBaseCSTPackage.getPackageCS());
		primitiveTypeCSEClass.getESuperTypes().add(theBaseCSTPackage.getDataTypeCS());
		classCSEClass.getESuperTypes().add(theBaseCSTPackage.getClassCS());
		classifierPropertyCSEClass.getESuperTypes().add(theBaseCSTPackage.getStructuralFeatureCS());
		stereotypeQualifierCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		operationCSEClass.getESuperTypes().add(theBaseCSTPackage.getOperationCS());
		tagCSEClass.getESuperTypes().add(theBaseCSTPackage.getAnnotationCS());
		exceptionCSEClass.getESuperTypes().add(theBaseCSTPackage.getClassCS());
		classifierDefCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		classifierProperty2CSEClass.getESuperTypes().add(this.getLocalPropertyCS());
		completeSignatureCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		configPropertyCSEClass.getESuperTypes().add(this.getModulePropertyCS());
		constructorCSEClass.getESuperTypes().add(this.getMappingMethodCS());
		contextualPropertyCSEClass.getESuperTypes().add(this.getModulePropertyCS());
		directionKindCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		elementWithBodyEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		imperativeOperationCallExpCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getInvocationExpCS());
		importCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		libraryCSEClass.getESuperTypes().add(this.getMappingModuleCS());
		libraryImportCSEClass.getESuperTypes().add(this.getImportCS());
		localPropertyCSEClass.getESuperTypes().add(this.getModulePropertyCS());
		mappingBodyCSEClass.getESuperTypes().add(this.getMappingSectionCS());
		mappingCallExpCSEClass.getESuperTypes().add(this.getImperativeOperationCallExpCS());
		mappingDeclarationCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
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
		modelTypeCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		modelTypeCSEClass.getESuperTypes().add(this.getElementWithBody());
		modulePropertyCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		moduleUsageCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		multiplicityDefCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		objectExpCSEClass.getESuperTypes().add(theImperativeoclcsPackage.getExpressionBlockCS());
		oppositePropertyCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		parameterDeclarationCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		renameCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		resolveOpArgsExpCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		packageRefCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		scopedNameCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		simpleSignatureCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		transformationHeaderCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		transformationRefineCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		typeSpecCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		unitCSEClass.getESuperTypes().add(theBaseCSTPackage.getElementCS());
		resolveExpCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getInvocationExpCS());
		resolveInExpCSEClass.getESuperTypes().add(this.getResolveExpCS());

		// Initialize classes and features; add operations and parameters
		initEClass(topLevelCSEClass, TopLevelCS.class, "TopLevelCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTopLevelCS_Import(), theBaseCSTPackage.getElementCS(), null, "import", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopLevelCS_Unit(), theBaseCSTPackage.getElementCS(), null, "unit", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterCSEClass, ParameterCS.class, "ParameterCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameterCS_Direction(), this.getParamDirection(), "direction", null, 0, 1, ParameterCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameterCS_InitPart(), theBaseCSTPackage.getElementCS(), null, "initPart", null, 0, 1, ParameterCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(initPartCSEClass, InitPartCS.class, "InitPartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInitPartCS_InitOp(), this.getInitOp(), "initOp", null, 0, 1, InitPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInitPartCS_Expression(), theEssentialOCLCSTPackage.getExpCS(), null, "expression", null, 0, 1, InitPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metamodelCSEClass, MetamodelCS.class, "MetamodelCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetamodelCS_MetamodelKind(), this.getMetamodelKind(), "metamodelKind", null, 0, 1, MetamodelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetamodelCS_Element(), theBaseCSTPackage.getElementCS(), null, "element", null, 0, -1, MetamodelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveTypeCSEClass, PrimitiveTypeCS.class, "PrimitiveTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classCSEClass, ClassCS.class, "ClassCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassCS_Intermediate(), ecorePackage.getEBoolean(), "intermediate", null, 0, 1, ClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classifierPropertyCSEClass, ClassifierPropertyCS.class, "ClassifierPropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassifierPropertyCS_Stereotypes(), theBaseCSTPackage.getElementCS(), null, "stereotypes", null, 0, 1, ClassifierPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassifierPropertyCS_Opposite(), ecorePackage.getEString(), "opposite", null, 0, 1, ClassifierPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stereotypeQualifierCSEClass, StereotypeQualifierCS.class, "StereotypeQualifierCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStereotypeQualifierCS_Stereotype(), ecorePackage.getEString(), "stereotype", null, 0, -1, StereotypeQualifierCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationCSEClass, OperationCS.class, "OperationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationCS_Stereotypes(), theBaseCSTPackage.getElementCS(), null, "stereotypes", null, 0, 1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		initEClass(directionKindCSEClass, DirectionKindCS.class, "DirectionKindCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDirectionKindCS_DirectionKind(), this.getDirectionKindEnum(), "directionKind", null, 0, 1, DirectionKindCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementWithBodyEClass, ElementWithBody.class, "ElementWithBody", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElementWithBody_BodyStartLocation(), ecorePackage.getEInt(), "bodyStartLocation", "0", 0, 1, ElementWithBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElementWithBody_BodyEndLocation(), ecorePackage.getEInt(), "bodyEndLocation", "0", 0, 1, ElementWithBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imperativeOperationCallExpCSEClass, ImperativeOperationCallExpCS.class, "ImperativeOperationCallExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImperativeOperationCallExpCS_Module(), ecorePackage.getEString(), "module", null, 0, 1, ImperativeOperationCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(importCSEClass, ImportCS.class, "ImportCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImportCS_Unit(), this.getUnitCS(), null, "unit", null, 0, 1, ImportCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImportCS_ImportedUnitElement(), theEcorePackage.getEString(), "importedUnitElement", null, 0, -1, ImportCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImportCS_All(), theEcorePackage.getEBoolean(), "all", null, 0, 1, ImportCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libraryCSEClass, LibraryCS.class, "LibraryCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(libraryImportCSEClass, LibraryImportCS.class, "LibraryImportCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(localPropertyCSEClass, LocalPropertyCS.class, "LocalPropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLocalPropertyCS_TypeCS(), theBaseCSTPackage.getTypeCS(), null, "typeCS", null, 0, 1, LocalPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLocalPropertyCS_OclExpressionCS(), theEssentialOCLCSTPackage.getExpCS(), null, "oclExpressionCS", null, 0, 1, LocalPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingBodyCSEClass, MappingBodyCS.class, "MappingBodyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingBodyCS_HasPopulationKeyword(), ecorePackage.getEBoolean(), "hasPopulationKeyword", null, 0, 1, MappingBodyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingCallExpCSEClass, MappingCallExpCS.class, "MappingCallExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingCallExpCS_Strict(), ecorePackage.getEBoolean(), "strict", null, 0, 1, MappingCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingDeclarationCSEClass, MappingDeclarationCS.class, "MappingDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingDeclarationCS_Qualifiers(), this.getQualifierKindCS(), "qualifiers", null, 0, -1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingDeclarationCS_SimpleNameCS(), ecorePackage.getEString(), "simpleNameCS", null, 0, 1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingDeclarationCS_ContextType(), theBaseCSTPackage.getTypeCS(), null, "contextType", null, 0, 1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingDeclarationCS_Parameters(), this.getParameterDeclarationCS(), null, "parameters", null, 0, -1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingDeclarationCS_Result(), this.getParameterDeclarationCS(), null, "result", null, 0, -1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingDeclarationCS_DirectionKindCS(), this.getDirectionKindCS(), null, "directionKindCS", null, 0, 1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingDeclarationCS_MappingExtension(), this.getMappingExtensionCS(), null, "mappingExtension", null, 0, -1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingDeclarationCS_IsQuery(), ecorePackage.getEBoolean(), "isQuery", null, 0, 1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingEndCSEClass, MappingEndCS.class, "MappingEndCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingExtensionCSEClass, MappingExtensionCS.class, "MappingExtensionCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingExtensionCS_Kind(), this.getMappingExtensionKindCS(), "kind", "disjuncts", 0, 1, MappingExtensionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingExtensionCS_MappingIdentifiers(), this.getScopedNameCS(), null, "mappingIdentifiers", null, 1, -1, MappingExtensionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingInitCSEClass, MappingInitCS.class, "MappingInitCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingMethodCSEClass, MappingMethodCS.class, "MappingMethodCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingMethodCS_BlackBox(), ecorePackage.getEBoolean(), "blackBox", null, 0, 1, MappingMethodCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingMethodCS_MappingDeclarationCS(), this.getMappingDeclarationCS(), null, "mappingDeclarationCS", null, 0, 1, MappingMethodCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingModuleCSEClass, MappingModuleCS.class, "MappingModuleCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingModuleCS_HeaderCS(), this.getTransformationHeaderCS(), null, "headerCS", null, 1, 1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingModuleCS_Imports(), this.getImportCS(), null, "imports", null, 0, -1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
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
		initEAttribute(getParameterDeclarationCS_SimpleNameCS(), ecorePackage.getEString(), "simpleNameCS", null, 0, 1, ParameterDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameterDeclarationCS_TypeSpecCS(), this.getTypeSpecCS(), null, "typeSpecCS", null, 0, 1, ParameterDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameterDeclarationCS_DirectionKind(), this.getDirectionKindEnum(), "directionKind", null, 0, 1, ParameterDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		initEReference(getSimpleSignatureCS_Params(), this.getParameterDeclarationCS(), null, "params", null, 0, -1, SimpleSignatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationHeaderCSEClass, TransformationHeaderCS.class, "TransformationHeaderCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformationHeaderCS_Qualifiers(), theEssentialOCLCSTPackage.getStringLiteralExpCS(), null, "qualifiers", null, 0, -1, TransformationHeaderCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationHeaderCS_PathNameCS(), theBaseCSTPackage.getPathNameCS(), null, "pathNameCS", null, 1, 1, TransformationHeaderCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationHeaderCS_Parameters(), this.getParameterDeclarationCS(), null, "parameters", null, 0, -1, TransformationHeaderCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationHeaderCS_ModuleUsages(), this.getModuleUsageCS(), null, "moduleUsages", null, 0, -1, TransformationHeaderCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationHeaderCS_TransformationRefineCS(), this.getTransformationRefineCS(), null, "transformationRefineCS", null, 0, 1, TransformationHeaderCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationRefineCSEClass, TransformationRefineCS.class, "TransformationRefineCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformationRefineCS_ModuleRefCS(), this.getModuleRefCS(), null, "moduleRefCS", null, 1, 1, TransformationRefineCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformationRefineCS_SimpleNameCS(), ecorePackage.getEString(), "simpleNameCS", null, 1, 1, TransformationRefineCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeSpecCSEClass, TypeSpecCS.class, "TypeSpecCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeSpecCS_TypeCS(), theBaseCSTPackage.getTypeCS(), null, "typeCS", null, 1, 1, TypeSpecCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypeSpecCS_SimpleNameCS(), ecorePackage.getEString(), "simpleNameCS", null, 0, 1, TypeSpecCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitCSEClass, UnitCS.class, "UnitCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnitCS_Segment(), ecorePackage.getEString(), "segment", null, 0, -1, UnitCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnitCS_TopLevelElements(), theBaseCSTPackage.getElementCS(), null, "topLevelElements", null, 0, -1, UnitCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnitCS_Modules(), this.getMappingModuleCS(), null, "modules", null, 0, -1, UnitCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getUnitCS_ModelTypes(), this.getModelTypeCS(), null, "modelTypes", null, 0, -1, UnitCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getUnitCS_Imports(), this.getImportCS(), null, "imports", null, 0, -1, UnitCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

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

		initEEnum(paramDirectionEEnum, ParamDirection.class, "ParamDirection");
		addEEnumLiteral(paramDirectionEEnum, ParamDirection.IN);
		addEEnumLiteral(paramDirectionEEnum, ParamDirection.INOUT);
		addEEnumLiteral(paramDirectionEEnum, ParamDirection.OUT);

		initEEnum(directionKindEnumEEnum, DirectionKindEnum.class, "DirectionKindEnum");
		addEEnumLiteral(directionKindEnumEEnum, DirectionKindEnum.DEFAULT);
		addEEnumLiteral(directionKindEnumEEnum, DirectionKindEnum.IN);
		addEEnumLiteral(directionKindEnumEEnum, DirectionKindEnum.OUT);
		addEEnumLiteral(directionKindEnumEEnum, DirectionKindEnum.INOUT);

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
	}

} // QvtoperationalcsPackageImpl
