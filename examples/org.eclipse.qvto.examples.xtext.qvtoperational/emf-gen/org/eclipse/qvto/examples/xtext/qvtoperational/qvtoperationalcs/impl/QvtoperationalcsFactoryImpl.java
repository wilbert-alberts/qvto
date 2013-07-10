/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
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
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingQueryCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingRuleCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionsCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelKind;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindEnum;
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
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class QvtoperationalcsFactoryImpl
		extends EFactoryImpl
		implements QvtoperationalcsFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static QvtoperationalcsFactory init() {
		try {
			QvtoperationalcsFactory theQvtoperationalcsFactory = (QvtoperationalcsFactory)EPackage.Registry.INSTANCE.getEFactory(QvtoperationalcsPackage.eNS_URI);
			if (theQvtoperationalcsFactory != null) {
				return theQvtoperationalcsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QvtoperationalcsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public QvtoperationalcsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case QvtoperationalcsPackage.TOP_LEVEL_CS: return createTopLevelCS();
			case QvtoperationalcsPackage.PARAMETER_CS: return createParameterCS();
			case QvtoperationalcsPackage.INIT_PART_CS: return createInitPartCS();
			case QvtoperationalcsPackage.METAMODEL_CS: return createMetamodelCS();
			case QvtoperationalcsPackage.PRIMITIVE_TYPE_CS: return createPrimitiveTypeCS();
			case QvtoperationalcsPackage.CLASS_CS: return createClassCS();
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY_CS: return createClassifierPropertyCS();
			case QvtoperationalcsPackage.STEREOTYPE_QUALIFIER_CS: return createStereotypeQualifierCS();
			case QvtoperationalcsPackage.OPERATION_CS: return createOperationCS();
			case QvtoperationalcsPackage.TAG_CS: return createTagCS();
			case QvtoperationalcsPackage.EXCEPTION_CS: return createExceptionCS();
			case QvtoperationalcsPackage.CLASSIFIER_DEF_CS: return createClassifierDefCS();
			case QvtoperationalcsPackage.CLASSIFIER_PROPERTY2_CS: return createClassifierProperty2CS();
			case QvtoperationalcsPackage.COMPLETE_SIGNATURE_CS: return createCompleteSignatureCS();
			case QvtoperationalcsPackage.CONFIG_PROPERTY_CS: return createConfigPropertyCS();
			case QvtoperationalcsPackage.CONSTRUCTOR_CS: return createConstructorCS();
			case QvtoperationalcsPackage.CONTEXTUAL_PROPERTY_CS: return createContextualPropertyCS();
			case QvtoperationalcsPackage.DIRECTION_KIND_CS: return createDirectionKindCS();
			case QvtoperationalcsPackage.IMPERATIVE_OPERATION_CALL_EXP_CS: return createImperativeOperationCallExpCS();
			case QvtoperationalcsPackage.IMPORT_CS: return createImportCS();
			case QvtoperationalcsPackage.LIBRARY_CS: return createLibraryCS();
			case QvtoperationalcsPackage.LIBRARY_IMPORT_CS: return createLibraryImportCS();
			case QvtoperationalcsPackage.LOCAL_PROPERTY_CS: return createLocalPropertyCS();
			case QvtoperationalcsPackage.MAPPING_BODY_CS: return createMappingBodyCS();
			case QvtoperationalcsPackage.MAPPING_CALL_EXP_CS: return createMappingCallExpCS();
			case QvtoperationalcsPackage.MAPPING_DECLARATION_CS: return createMappingDeclarationCS();
			case QvtoperationalcsPackage.MAPPING_END_CS: return createMappingEndCS();
			case QvtoperationalcsPackage.MAPPING_EXTENSION_CS: return createMappingExtensionCS();
			case QvtoperationalcsPackage.MAPPING_INIT_CS: return createMappingInitCS();
			case QvtoperationalcsPackage.MAPPING_MODULE_CS: return createMappingModuleCS();
			case QvtoperationalcsPackage.MAPPING_QUERY_CS: return createMappingQueryCS();
			case QvtoperationalcsPackage.MAPPING_RULE_CS: return createMappingRuleCS();
			case QvtoperationalcsPackage.MAPPING_SECTIONS_CS: return createMappingSectionsCS();
			case QvtoperationalcsPackage.MODULE_KIND_CS: return createModuleKindCS();
			case QvtoperationalcsPackage.MODULE_REF_CS: return createModuleRefCS();
			case QvtoperationalcsPackage.MODEL_TYPE_CS: return createModelTypeCS();
			case QvtoperationalcsPackage.MODULE_USAGE_CS: return createModuleUsageCS();
			case QvtoperationalcsPackage.MULTIPLICITY_DEF_CS: return createMultiplicityDefCS();
			case QvtoperationalcsPackage.OBJECT_EXP_CS: return createObjectExpCS();
			case QvtoperationalcsPackage.OPPOSITE_PROPERTY_CS: return createOppositePropertyCS();
			case QvtoperationalcsPackage.PARAMETER_DECLARATION_CS: return createParameterDeclarationCS();
			case QvtoperationalcsPackage.RENAME_CS: return createRenameCS();
			case QvtoperationalcsPackage.RESOLVE_OP_ARGS_EXP_CS: return createResolveOpArgsExpCS();
			case QvtoperationalcsPackage.PACKAGE_REF_CS: return createPackageRefCS();
			case QvtoperationalcsPackage.SCOPED_NAME_CS: return createScopedNameCS();
			case QvtoperationalcsPackage.SIMPLE_SIGNATURE_CS: return createSimpleSignatureCS();
			case QvtoperationalcsPackage.TRANSFORMATION_HEADER_CS: return createTransformationHeaderCS();
			case QvtoperationalcsPackage.TRANSFORMATION_REFINE_CS: return createTransformationRefineCS();
			case QvtoperationalcsPackage.TYPE_SPEC_CS: return createTypeSpecCS();
			case QvtoperationalcsPackage.UNIT_CS: return createUnitCS();
			case QvtoperationalcsPackage.RESOLVE_EXP_CS: return createResolveExpCS();
			case QvtoperationalcsPackage.RESOLVE_IN_EXP_CS: return createResolveInExpCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case QvtoperationalcsPackage.CLASSIFIER_KIND:
				return createClassifierKindFromString(eDataType, initialValue);
			case QvtoperationalcsPackage.FEATURE_KEY:
				return createFeatureKeyFromString(eDataType, initialValue);
			case QvtoperationalcsPackage.INIT_OP:
				return createInitOpFromString(eDataType, initialValue);
			case QvtoperationalcsPackage.METAMODEL_KIND:
				return createMetamodelKindFromString(eDataType, initialValue);
			case QvtoperationalcsPackage.PARAM_DIRECTION:
				return createParamDirectionFromString(eDataType, initialValue);
			case QvtoperationalcsPackage.DIRECTION_KIND_ENUM:
				return createDirectionKindEnumFromString(eDataType, initialValue);
			case QvtoperationalcsPackage.IMPORT_KIND_ENUM:
				return createImportKindEnumFromString(eDataType, initialValue);
			case QvtoperationalcsPackage.MAPPING_EXTENSION_KIND_CS:
				return createMappingExtensionKindCSFromString(eDataType, initialValue);
			case QvtoperationalcsPackage.MODULE_KIND_ENUM:
				return createModuleKindEnumFromString(eDataType, initialValue);
			case QvtoperationalcsPackage.QUALIFIER_KIND_CS:
				return createQualifierKindCSFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case QvtoperationalcsPackage.CLASSIFIER_KIND:
				return convertClassifierKindToString(eDataType, instanceValue);
			case QvtoperationalcsPackage.FEATURE_KEY:
				return convertFeatureKeyToString(eDataType, instanceValue);
			case QvtoperationalcsPackage.INIT_OP:
				return convertInitOpToString(eDataType, instanceValue);
			case QvtoperationalcsPackage.METAMODEL_KIND:
				return convertMetamodelKindToString(eDataType, instanceValue);
			case QvtoperationalcsPackage.PARAM_DIRECTION:
				return convertParamDirectionToString(eDataType, instanceValue);
			case QvtoperationalcsPackage.DIRECTION_KIND_ENUM:
				return convertDirectionKindEnumToString(eDataType, instanceValue);
			case QvtoperationalcsPackage.IMPORT_KIND_ENUM:
				return convertImportKindEnumToString(eDataType, instanceValue);
			case QvtoperationalcsPackage.MAPPING_EXTENSION_KIND_CS:
				return convertMappingExtensionKindCSToString(eDataType, instanceValue);
			case QvtoperationalcsPackage.MODULE_KIND_ENUM:
				return convertModuleKindEnumToString(eDataType, instanceValue);
			case QvtoperationalcsPackage.QUALIFIER_KIND_CS:
				return convertQualifierKindCSToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TopLevelCS createTopLevelCS() {
		TopLevelCSImpl topLevelCS = new TopLevelCSImpl();
		return topLevelCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ImportCS createImportCS() {
		ImportCSImpl importCS = new ImportCSImpl();
		return importCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryCS createLibraryCS() {
		LibraryCSImpl libraryCS = new LibraryCSImpl();
		return libraryCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryImportCS createLibraryImportCS() {
		LibraryImportCSImpl libraryImportCS = new LibraryImportCSImpl();
		return libraryImportCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LocalPropertyCS createLocalPropertyCS() {
		LocalPropertyCSImpl localPropertyCS = new LocalPropertyCSImpl();
		return localPropertyCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MappingBodyCS createMappingBodyCS() {
		MappingBodyCSImpl mappingBodyCS = new MappingBodyCSImpl();
		return mappingBodyCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MappingCallExpCS createMappingCallExpCS() {
		MappingCallExpCSImpl mappingCallExpCS = new MappingCallExpCSImpl();
		return mappingCallExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MappingDeclarationCS createMappingDeclarationCS() {
		MappingDeclarationCSImpl mappingDeclarationCS = new MappingDeclarationCSImpl();
		return mappingDeclarationCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MappingEndCS createMappingEndCS() {
		MappingEndCSImpl mappingEndCS = new MappingEndCSImpl();
		return mappingEndCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MappingExtensionCS createMappingExtensionCS() {
		MappingExtensionCSImpl mappingExtensionCS = new MappingExtensionCSImpl();
		return mappingExtensionCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MappingInitCS createMappingInitCS() {
		MappingInitCSImpl mappingInitCS = new MappingInitCSImpl();
		return mappingInitCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MappingModuleCS createMappingModuleCS() {
		MappingModuleCSImpl mappingModuleCS = new MappingModuleCSImpl();
		return mappingModuleCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MappingQueryCS createMappingQueryCS() {
		MappingQueryCSImpl mappingQueryCS = new MappingQueryCSImpl();
		return mappingQueryCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MappingRuleCS createMappingRuleCS() {
		MappingRuleCSImpl mappingRuleCS = new MappingRuleCSImpl();
		return mappingRuleCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MappingSectionsCS createMappingSectionsCS() {
		MappingSectionsCSImpl mappingSectionsCS = new MappingSectionsCSImpl();
		return mappingSectionsCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleKindCS createModuleKindCS() {
		ModuleKindCSImpl moduleKindCS = new ModuleKindCSImpl();
		return moduleKindCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleRefCS createModuleRefCS() {
		ModuleRefCSImpl moduleRefCS = new ModuleRefCSImpl();
		return moduleRefCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelTypeCS createModelTypeCS() {
		ModelTypeCSImpl modelTypeCS = new ModelTypeCSImpl();
		return modelTypeCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleUsageCS createModuleUsageCS() {
		ModuleUsageCSImpl moduleUsageCS = new ModuleUsageCSImpl();
		return moduleUsageCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicityDefCS createMultiplicityDefCS() {
		MultiplicityDefCSImpl multiplicityDefCS = new MultiplicityDefCSImpl();
		return multiplicityDefCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectExpCS createObjectExpCS() {
		ObjectExpCSImpl objectExpCS = new ObjectExpCSImpl();
		return objectExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OppositePropertyCS createOppositePropertyCS() {
		OppositePropertyCSImpl oppositePropertyCS = new OppositePropertyCSImpl();
		return oppositePropertyCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterDeclarationCS createParameterDeclarationCS() {
		ParameterDeclarationCSImpl parameterDeclarationCS = new ParameterDeclarationCSImpl();
		return parameterDeclarationCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RenameCS createRenameCS() {
		RenameCSImpl renameCS = new RenameCSImpl();
		return renameCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ResolveOpArgsExpCS createResolveOpArgsExpCS() {
		ResolveOpArgsExpCSImpl resolveOpArgsExpCS = new ResolveOpArgsExpCSImpl();
		return resolveOpArgsExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PackageRefCS createPackageRefCS() {
		PackageRefCSImpl packageRefCS = new PackageRefCSImpl();
		return packageRefCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ScopedNameCS createScopedNameCS() {
		ScopedNameCSImpl scopedNameCS = new ScopedNameCSImpl();
		return scopedNameCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleSignatureCS createSimpleSignatureCS() {
		SimpleSignatureCSImpl simpleSignatureCS = new SimpleSignatureCSImpl();
		return simpleSignatureCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationHeaderCS createTransformationHeaderCS() {
		TransformationHeaderCSImpl transformationHeaderCS = new TransformationHeaderCSImpl();
		return transformationHeaderCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationRefineCS createTransformationRefineCS() {
		TransformationRefineCSImpl transformationRefineCS = new TransformationRefineCSImpl();
		return transformationRefineCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSpecCS createTypeSpecCS() {
		TypeSpecCSImpl typeSpecCS = new TypeSpecCSImpl();
		return typeSpecCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UnitCS createUnitCS() {
		UnitCSImpl unitCS = new UnitCSImpl();
		return unitCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ResolveExpCS createResolveExpCS() {
		ResolveExpCSImpl resolveExpCS = new ResolveExpCSImpl();
		return resolveExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ResolveInExpCS createResolveInExpCS() {
		ResolveInExpCSImpl resolveInExpCS = new ResolveInExpCSImpl();
		return resolveInExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterCS createParameterCS() {
		ParameterCSImpl parameterCS = new ParameterCSImpl();
		return parameterCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InitPartCS createInitPartCS() {
		InitPartCSImpl initPartCS = new InitPartCSImpl();
		return initPartCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelCS createMetamodelCS() {
		MetamodelCSImpl metamodelCS = new MetamodelCSImpl();
		return metamodelCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypeCS createPrimitiveTypeCS() {
		PrimitiveTypeCSImpl primitiveTypeCS = new PrimitiveTypeCSImpl();
		return primitiveTypeCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassCS createClassCS() {
		ClassCSImpl classCS = new ClassCSImpl();
		return classCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierPropertyCS createClassifierPropertyCS() {
		ClassifierPropertyCSImpl classifierPropertyCS = new ClassifierPropertyCSImpl();
		return classifierPropertyCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypeQualifierCS createStereotypeQualifierCS() {
		StereotypeQualifierCSImpl stereotypeQualifierCS = new StereotypeQualifierCSImpl();
		return stereotypeQualifierCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCS createOperationCS() {
		OperationCSImpl operationCS = new OperationCSImpl();
		return operationCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TagCS createTagCS() {
		TagCSImpl tagCS = new TagCSImpl();
		return tagCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExceptionCS createExceptionCS() {
		ExceptionCSImpl exceptionCS = new ExceptionCSImpl();
		return exceptionCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierDefCS createClassifierDefCS() {
		ClassifierDefCSImpl classifierDefCS = new ClassifierDefCSImpl();
		return classifierDefCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierProperty2CS createClassifierProperty2CS() {
		ClassifierProperty2CSImpl classifierProperty2CS = new ClassifierProperty2CSImpl();
		return classifierProperty2CS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteSignatureCS createCompleteSignatureCS() {
		CompleteSignatureCSImpl completeSignatureCS = new CompleteSignatureCSImpl();
		return completeSignatureCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigPropertyCS createConfigPropertyCS() {
		ConfigPropertyCSImpl configPropertyCS = new ConfigPropertyCSImpl();
		return configPropertyCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ConstructorCS createConstructorCS() {
		ConstructorCSImpl constructorCS = new ConstructorCSImpl();
		return constructorCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ContextualPropertyCS createContextualPropertyCS() {
		ContextualPropertyCSImpl contextualPropertyCS = new ContextualPropertyCSImpl();
		return contextualPropertyCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionKindCS createDirectionKindCS() {
		DirectionKindCSImpl directionKindCS = new DirectionKindCSImpl();
		return directionKindCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeOperationCallExpCS createImperativeOperationCallExpCS() {
		ImperativeOperationCallExpCSImpl imperativeOperationCallExpCS = new ImperativeOperationCallExpCSImpl();
		return imperativeOperationCallExpCS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierKind createClassifierKindFromString(EDataType eDataType,
			String initialValue) {
		ClassifierKind result = ClassifierKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertClassifierKindToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureKey createFeatureKeyFromString(EDataType eDataType,
			String initialValue) {
		FeatureKey result = FeatureKey.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFeatureKeyToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InitOp createInitOpFromString(EDataType eDataType,
			String initialValue) {
		InitOp result = InitOp.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInitOpToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelKind createMetamodelKindFromString(EDataType eDataType,
			String initialValue) {
		MetamodelKind result = MetamodelKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMetamodelKindToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ParamDirection createParamDirectionFromString(EDataType eDataType,
			String initialValue) {
		ParamDirection result = ParamDirection.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertParamDirectionToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionKindEnum createDirectionKindEnumFromString(
			EDataType eDataType, String initialValue) {
		DirectionKindEnum result = DirectionKindEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDirectionKindEnumToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ImportKindEnum createImportKindEnumFromString(EDataType eDataType,
			String initialValue) {
		ImportKindEnum result = ImportKindEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertImportKindEnumToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MappingExtensionKindCS createMappingExtensionKindCSFromString(
			EDataType eDataType, String initialValue) {
		MappingExtensionKindCS result = MappingExtensionKindCS.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMappingExtensionKindCSToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleKindEnum createModuleKindEnumFromString(EDataType eDataType,
			String initialValue) {
		ModuleKindEnum result = ModuleKindEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertModuleKindEnumToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public QualifierKindCS createQualifierKindCSFromString(EDataType eDataType,
			String initialValue) {
		QualifierKindCS result = QualifierKindCS.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertQualifierKindCSToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public QvtoperationalcsPackage getQvtoperationalcsPackage() {
		return (QvtoperationalcsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QvtoperationalcsPackage getPackage() {
		return QvtoperationalcsPackage.eINSTANCE;
	}

} // QvtoperationalcsFactoryImpl
