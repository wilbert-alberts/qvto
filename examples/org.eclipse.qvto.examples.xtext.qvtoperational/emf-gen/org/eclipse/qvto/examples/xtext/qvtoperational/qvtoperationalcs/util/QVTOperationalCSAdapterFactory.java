/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.domain.elements.Nameable;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ClassCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.basecs.DataTypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.FeatureCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.NamespaceCS;
import org.eclipse.ocl.examples.xtext.base.basecs.OperationCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PackageCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PackageOwnerCS;
import org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.basecs.PivotableElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.RootCS;
import org.eclipse.ocl.examples.xtext.base.basecs.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TemplateableElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypeCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AbstractNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvocationExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NamedExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ExpressionBlockCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierDefCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConfigPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConstructorCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ContextualPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ElementWithBody;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ExceptionCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImperativeOperationCallExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LibraryImportCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LocalPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingBodyCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingCallExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingEndCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingInitCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingMethodCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingQueryCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingRuleCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionsCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindCS;
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
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToClassCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToImportCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToLibraryCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToOperationCS;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVTOperationalCSPackage
 * @generated
 */
public class QVTOperationalCSAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QVTOperationalCSPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTOperationalCSAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = QVTOperationalCSPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QVTOperationalCSSwitch<Adapter> modelSwitch =
		new QVTOperationalCSSwitch<Adapter>() {
			@Override
			public Adapter caseTopLevelCS(TopLevelCS object) {
				return createTopLevelCSAdapter();
			}
			@Override
			public Adapter caseQVToClassCS(QVToClassCS object) {
				return createQVToClassCSAdapter();
			}
			@Override
			public Adapter caseQVToImportCS(QVToImportCS object) {
				return createQVToImportCSAdapter();
			}
			@Override
			public Adapter caseQVToLibraryCS(QVToLibraryCS object) {
				return createQVToLibraryCSAdapter();
			}
			@Override
			public Adapter caseQVToOperationCS(QVToOperationCS object) {
				return createQVToOperationCSAdapter();
			}
			@Override
			public Adapter caseOperationParameterDeclarationCS(OperationParameterDeclarationCS object) {
				return createOperationParameterDeclarationCSAdapter();
			}
			@Override
			public Adapter caseOperationSimpleSignatureCS(OperationSimpleSignatureCS object) {
				return createOperationSimpleSignatureCSAdapter();
			}
			@Override
			public Adapter caseInitPartCS(InitPartCS object) {
				return createInitPartCSAdapter();
			}
			@Override
			public Adapter caseMetamodelCS(MetamodelCS object) {
				return createMetamodelCSAdapter();
			}
			@Override
			public Adapter casePrimitiveTypeCS(PrimitiveTypeCS object) {
				return createPrimitiveTypeCSAdapter();
			}
			@Override
			public Adapter caseClassifierPropertyCS(ClassifierPropertyCS object) {
				return createClassifierPropertyCSAdapter();
			}
			@Override
			public Adapter caseStereotypeQualifierCS(StereotypeQualifierCS object) {
				return createStereotypeQualifierCSAdapter();
			}
			@Override
			public Adapter caseTagCS(TagCS object) {
				return createTagCSAdapter();
			}
			@Override
			public Adapter caseExceptionCS(ExceptionCS object) {
				return createExceptionCSAdapter();
			}
			@Override
			public Adapter caseClassifierDefCS(ClassifierDefCS object) {
				return createClassifierDefCSAdapter();
			}
			@Override
			public Adapter caseClassifierProperty2CS(ClassifierProperty2CS object) {
				return createClassifierProperty2CSAdapter();
			}
			@Override
			public Adapter caseCompleteSignatureCS(CompleteSignatureCS object) {
				return createCompleteSignatureCSAdapter();
			}
			@Override
			public Adapter caseConfigPropertyCS(ConfigPropertyCS object) {
				return createConfigPropertyCSAdapter();
			}
			@Override
			public Adapter caseConstructorCS(ConstructorCS object) {
				return createConstructorCSAdapter();
			}
			@Override
			public Adapter caseContextualPropertyCS(ContextualPropertyCS object) {
				return createContextualPropertyCSAdapter();
			}
			@Override
			public Adapter caseElementWithBody(ElementWithBody object) {
				return createElementWithBodyAdapter();
			}
			@Override
			public Adapter caseImperativeOperationCallExpCS(ImperativeOperationCallExpCS object) {
				return createImperativeOperationCallExpCSAdapter();
			}
			@Override
			public Adapter caseLibraryImportCS(LibraryImportCS object) {
				return createLibraryImportCSAdapter();
			}
			@Override
			public Adapter caseLocalPropertyCS(LocalPropertyCS object) {
				return createLocalPropertyCSAdapter();
			}
			@Override
			public Adapter caseMappingBodyCS(MappingBodyCS object) {
				return createMappingBodyCSAdapter();
			}
			@Override
			public Adapter caseMappingCallExpCS(MappingCallExpCS object) {
				return createMappingCallExpCSAdapter();
			}
			@Override
			public Adapter caseMappingOperationCS(MappingOperationCS object) {
				return createMappingOperationCSAdapter();
			}
			@Override
			public Adapter caseMappingEndCS(MappingEndCS object) {
				return createMappingEndCSAdapter();
			}
			@Override
			public Adapter caseMappingExtensionCS(MappingExtensionCS object) {
				return createMappingExtensionCSAdapter();
			}
			@Override
			public Adapter caseMappingInitCS(MappingInitCS object) {
				return createMappingInitCSAdapter();
			}
			@Override
			public Adapter caseMappingMethodCS(MappingMethodCS object) {
				return createMappingMethodCSAdapter();
			}
			@Override
			public Adapter caseMappingModuleCS(MappingModuleCS object) {
				return createMappingModuleCSAdapter();
			}
			@Override
			public Adapter caseMappingQueryCS(MappingQueryCS object) {
				return createMappingQueryCSAdapter();
			}
			@Override
			public Adapter caseMappingRuleCS(MappingRuleCS object) {
				return createMappingRuleCSAdapter();
			}
			@Override
			public Adapter caseMappingSectionCS(MappingSectionCS object) {
				return createMappingSectionCSAdapter();
			}
			@Override
			public Adapter caseMappingSectionsCS(MappingSectionsCS object) {
				return createMappingSectionsCSAdapter();
			}
			@Override
			public Adapter caseModuleKindCS(ModuleKindCS object) {
				return createModuleKindCSAdapter();
			}
			@Override
			public Adapter caseModuleRefCS(ModuleRefCS object) {
				return createModuleRefCSAdapter();
			}
			@Override
			public Adapter caseModelTypeCS(ModelTypeCS object) {
				return createModelTypeCSAdapter();
			}
			@Override
			public Adapter caseModulePropertyCS(ModulePropertyCS object) {
				return createModulePropertyCSAdapter();
			}
			@Override
			public Adapter caseModuleUsageCS(ModuleUsageCS object) {
				return createModuleUsageCSAdapter();
			}
			@Override
			public Adapter caseMultiplicityDefCS(MultiplicityDefCS object) {
				return createMultiplicityDefCSAdapter();
			}
			@Override
			public Adapter caseObjectExpCS(ObjectExpCS object) {
				return createObjectExpCSAdapter();
			}
			@Override
			public Adapter caseOppositePropertyCS(OppositePropertyCS object) {
				return createOppositePropertyCSAdapter();
			}
			@Override
			public Adapter caseParameterDeclarationCS(ParameterDeclarationCS object) {
				return createParameterDeclarationCSAdapter();
			}
			@Override
			public Adapter caseRenameCS(RenameCS object) {
				return createRenameCSAdapter();
			}
			@Override
			public Adapter caseResolveOpArgsExpCS(ResolveOpArgsExpCS object) {
				return createResolveOpArgsExpCSAdapter();
			}
			@Override
			public Adapter casePackageRefCS(PackageRefCS object) {
				return createPackageRefCSAdapter();
			}
			@Override
			public Adapter caseScopedNameCS(ScopedNameCS object) {
				return createScopedNameCSAdapter();
			}
			@Override
			public Adapter caseSimpleSignatureCS(SimpleSignatureCS object) {
				return createSimpleSignatureCSAdapter();
			}
			@Override
			public Adapter caseTransformationCS(TransformationCS object) {
				return createTransformationCSAdapter();
			}
			@Override
			public Adapter caseTransformationRefineCS(TransformationRefineCS object) {
				return createTransformationRefineCSAdapter();
			}
			@Override
			public Adapter caseTypeSpecCS(TypeSpecCS object) {
				return createTypeSpecCSAdapter();
			}
			@Override
			public Adapter caseUnitCS(UnitCS object) {
				return createUnitCSAdapter();
			}
			@Override
			public Adapter caseResolveExpCS(ResolveExpCS object) {
				return createResolveExpCSAdapter();
			}
			@Override
			public Adapter caseResolveInExpCS(ResolveInExpCS object) {
				return createResolveInExpCSAdapter();
			}
			@Override
			public Adapter caseVisitableCS(VisitableCS object) {
				return createVisitableCSAdapter();
			}
			@Override
			public Adapter caseElementCS(ElementCS object) {
				return createElementCSAdapter();
			}
			@Override
			public Adapter casePivotable(Pivotable object) {
				return createPivotableAdapter();
			}
			@Override
			public Adapter casePivotableElementCS(PivotableElementCS object) {
				return createPivotableElementCSAdapter();
			}
			@Override
			public Adapter caseModelElementCS(ModelElementCS object) {
				return createModelElementCSAdapter();
			}
			@Override
			public Adapter casePackageOwnerCS(PackageOwnerCS object) {
				return createPackageOwnerCSAdapter();
			}
			@Override
			public Adapter caseRootCS(RootCS object) {
				return createRootCSAdapter();
			}
			@Override
			public Adapter caseRootPackageCS(RootPackageCS object) {
				return createRootPackageCSAdapter();
			}
			@Override
			public Adapter caseNameable(Nameable object) {
				return createNameableAdapter();
			}
			@Override
			public Adapter caseNamedElementCS(NamedElementCS object) {
				return createNamedElementCSAdapter();
			}
			@Override
			public Adapter caseTypeCS(TypeCS object) {
				return createTypeCSAdapter();
			}
			@Override
			public Adapter caseTemplateableElementCS(TemplateableElementCS object) {
				return createTemplateableElementCSAdapter();
			}
			@Override
			public Adapter caseClassifierCS(ClassifierCS object) {
				return createClassifierCSAdapter();
			}
			@Override
			public Adapter caseNamespaceCS(NamespaceCS object) {
				return createNamespaceCSAdapter();
			}
			@Override
			public Adapter caseClassCS(ClassCS object) {
				return createClassCSAdapter();
			}
			@Override
			public Adapter caseTypedElementCS(TypedElementCS object) {
				return createTypedElementCSAdapter();
			}
			@Override
			public Adapter caseFeatureCS(FeatureCS object) {
				return createFeatureCSAdapter();
			}
			@Override
			public Adapter caseOperationCS(OperationCS object) {
				return createOperationCSAdapter();
			}
			@Override
			public Adapter caseParameterCS(ParameterCS object) {
				return createParameterCSAdapter();
			}
			@Override
			public Adapter casePackageCS(PackageCS object) {
				return createPackageCSAdapter();
			}
			@Override
			public Adapter caseDataTypeCS(DataTypeCS object) {
				return createDataTypeCSAdapter();
			}
			@Override
			public Adapter caseStructuralFeatureCS(StructuralFeatureCS object) {
				return createStructuralFeatureCSAdapter();
			}
			@Override
			public Adapter caseAnnotationElementCS(AnnotationElementCS object) {
				return createAnnotationElementCSAdapter();
			}
			@Override
			public Adapter caseAnnotationCS(AnnotationCS object) {
				return createAnnotationCSAdapter();
			}
			@Override
			public Adapter caseExpCS(ExpCS object) {
				return createExpCSAdapter();
			}
			@Override
			public Adapter caseAbstractNameExpCS(AbstractNameExpCS object) {
				return createAbstractNameExpCSAdapter();
			}
			@Override
			public Adapter caseNamedExpCS(NamedExpCS object) {
				return createNamedExpCSAdapter();
			}
			@Override
			public Adapter caseInvocationExpCS(InvocationExpCS object) {
				return createInvocationExpCSAdapter();
			}
			@Override
			public Adapter caseElementRefCS(ElementRefCS object) {
				return createElementRefCSAdapter();
			}
			@Override
			public Adapter caseExpressionBlockCS(ExpressionBlockCS object) {
				return createExpressionBlockCSAdapter();
			}
			@Override
			public Adapter caseTypeRefCS(TypeRefCS object) {
				return createTypeRefCSAdapter();
			}
			@Override
			public Adapter caseTypedRefCS(TypedRefCS object) {
				return createTypedRefCSAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS <em>Top Level CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS
	 * @generated
	 */
	public Adapter createTopLevelCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToClassCS <em>QV To Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToClassCS
	 * @generated
	 */
	public Adapter createQVToClassCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToImportCS <em>QV To Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToImportCS
	 * @generated
	 */
	public Adapter createQVToImportCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToLibraryCS <em>QV To Library CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToLibraryCS
	 * @generated
	 */
	public Adapter createQVToLibraryCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToOperationCS <em>QV To Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToOperationCS
	 * @generated
	 */
	public Adapter createQVToOperationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationParameterDeclarationCS <em>Operation Parameter Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationParameterDeclarationCS
	 * @generated
	 */
	public Adapter createOperationParameterDeclarationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationSimpleSignatureCS <em>Operation Simple Signature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationSimpleSignatureCS
	 * @generated
	 */
	public Adapter createOperationSimpleSignatureCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS <em>Init Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS
	 * @generated
	 */
	public Adapter createInitPartCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS <em>Metamodel CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS
	 * @generated
	 */
	public Adapter createMetamodelCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PrimitiveTypeCS <em>Primitive Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PrimitiveTypeCS
	 * @generated
	 */
	public Adapter createPrimitiveTypeCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS <em>Classifier Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS
	 * @generated
	 */
	public Adapter createClassifierPropertyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.StereotypeQualifierCS <em>Stereotype Qualifier CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.StereotypeQualifierCS
	 * @generated
	 */
	public Adapter createStereotypeQualifierCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS <em>Tag CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS
	 * @generated
	 */
	public Adapter createTagCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ExceptionCS <em>Exception CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ExceptionCS
	 * @generated
	 */
	public Adapter createExceptionCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierDefCS <em>Classifier Def CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierDefCS
	 * @generated
	 */
	public Adapter createClassifierDefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS <em>Classifier Property2 CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS
	 * @generated
	 */
	public Adapter createClassifierProperty2CSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS <em>Complete Signature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS
	 * @generated
	 */
	public Adapter createCompleteSignatureCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConfigPropertyCS <em>Config Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConfigPropertyCS
	 * @generated
	 */
	public Adapter createConfigPropertyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConstructorCS <em>Constructor CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConstructorCS
	 * @generated
	 */
	public Adapter createConstructorCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ContextualPropertyCS <em>Contextual Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ContextualPropertyCS
	 * @generated
	 */
	public Adapter createContextualPropertyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ElementWithBody <em>Element With Body</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ElementWithBody
	 * @generated
	 */
	public Adapter createElementWithBodyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImperativeOperationCallExpCS <em>Imperative Operation Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImperativeOperationCallExpCS
	 * @generated
	 */
	public Adapter createImperativeOperationCallExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LibraryImportCS <em>Library Import CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LibraryImportCS
	 * @generated
	 */
	public Adapter createLibraryImportCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LocalPropertyCS <em>Local Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LocalPropertyCS
	 * @generated
	 */
	public Adapter createLocalPropertyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingBodyCS <em>Mapping Body CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingBodyCS
	 * @generated
	 */
	public Adapter createMappingBodyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingCallExpCS <em>Mapping Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingCallExpCS
	 * @generated
	 */
	public Adapter createMappingCallExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS <em>Mapping Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS
	 * @generated
	 */
	public Adapter createMappingOperationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingEndCS <em>Mapping End CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingEndCS
	 * @generated
	 */
	public Adapter createMappingEndCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionCS <em>Mapping Extension CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionCS
	 * @generated
	 */
	public Adapter createMappingExtensionCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingInitCS <em>Mapping Init CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingInitCS
	 * @generated
	 */
	public Adapter createMappingInitCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingMethodCS <em>Mapping Method CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingMethodCS
	 * @generated
	 */
	public Adapter createMappingMethodCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS <em>Mapping Module CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS
	 * @generated
	 */
	public Adapter createMappingModuleCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingQueryCS <em>Mapping Query CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingQueryCS
	 * @generated
	 */
	public Adapter createMappingQueryCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingRuleCS <em>Mapping Rule CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingRuleCS
	 * @generated
	 */
	public Adapter createMappingRuleCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionCS <em>Mapping Section CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionCS
	 * @generated
	 */
	public Adapter createMappingSectionCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionsCS <em>Mapping Sections CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionsCS
	 * @generated
	 */
	public Adapter createMappingSectionsCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindCS <em>Module Kind CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindCS
	 * @generated
	 */
	public Adapter createModuleKindCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleRefCS <em>Module Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleRefCS
	 * @generated
	 */
	public Adapter createModuleRefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS <em>Model Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS
	 * @generated
	 */
	public Adapter createModelTypeCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModulePropertyCS <em>Module Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModulePropertyCS
	 * @generated
	 */
	public Adapter createModulePropertyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS <em>Module Usage CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS
	 * @generated
	 */
	public Adapter createModuleUsageCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityDefCS <em>Multiplicity Def CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityDefCS
	 * @generated
	 */
	public Adapter createMultiplicityDefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ObjectExpCS <em>Object Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ObjectExpCS
	 * @generated
	 */
	public Adapter createObjectExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OppositePropertyCS <em>Opposite Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OppositePropertyCS
	 * @generated
	 */
	public Adapter createOppositePropertyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterDeclarationCS <em>Parameter Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterDeclarationCS
	 * @generated
	 */
	public Adapter createParameterDeclarationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.RenameCS <em>Rename CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.RenameCS
	 * @generated
	 */
	public Adapter createRenameCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveOpArgsExpCS <em>Resolve Op Args Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveOpArgsExpCS
	 * @generated
	 */
	public Adapter createResolveOpArgsExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PackageRefCS <em>Package Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PackageRefCS
	 * @generated
	 */
	public Adapter createPackageRefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ScopedNameCS <em>Scoped Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ScopedNameCS
	 * @generated
	 */
	public Adapter createScopedNameCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS <em>Simple Signature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS
	 * @generated
	 */
	public Adapter createSimpleSignatureCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationCS <em>Transformation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationCS
	 * @generated
	 */
	public Adapter createTransformationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationRefineCS <em>Transformation Refine CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationRefineCS
	 * @generated
	 */
	public Adapter createTransformationRefineCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS <em>Type Spec CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS
	 * @generated
	 */
	public Adapter createTypeSpecCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS <em>Unit CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS
	 * @generated
	 */
	public Adapter createUnitCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveExpCS <em>Resolve Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveExpCS
	 * @generated
	 */
	public Adapter createResolveExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveInExpCS <em>Resolve In Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveInExpCS
	 * @generated
	 */
	public Adapter createResolveInExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS <em>Visitable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS
	 * @generated
	 */
	public Adapter createVisitableCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.ElementCS <em>Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ElementCS
	 * @generated
	 */
	public Adapter createElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.pivot.util.Pivotable <em>Pivotable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.pivot.util.Pivotable
	 * @generated
	 */
	public Adapter createPivotableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.PivotableElementCS <em>Pivotable Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PivotableElementCS
	 * @generated
	 */
	public Adapter createPivotableElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS <em>Model Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ModelElementCS
	 * @generated
	 */
	public Adapter createModelElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.PackageOwnerCS <em>Package Owner CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PackageOwnerCS
	 * @generated
	 */
	public Adapter createPackageOwnerCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.domain.elements.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.domain.elements.Nameable
	 * @generated
	 */
	public Adapter createNameableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.NamedElementCS <em>Named Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.NamedElementCS
	 * @generated
	 */
	public Adapter createNamedElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.NamespaceCS <em>Namespace CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.NamespaceCS
	 * @generated
	 */
	public Adapter createNamespaceCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.PackageCS <em>Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.PackageCS
	 * @generated
	 */
	public Adapter createPackageCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.RootCS <em>Root CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.RootCS
	 * @generated
	 */
	public Adapter createRootCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.RootPackageCS <em>Root Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.RootPackageCS
	 * @generated
	 */
	public Adapter createRootPackageCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypeCS
	 * @generated
	 */
	public Adapter createTypeCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.TemplateableElementCS <em>Templateable Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TemplateableElementCS
	 * @generated
	 */
	public Adapter createTemplateableElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS <em>Classifier CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ClassifierCS
	 * @generated
	 */
	public Adapter createClassifierCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.ClassCS <em>Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ClassCS
	 * @generated
	 */
	public Adapter createClassCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypedElementCS <em>Typed Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypedElementCS
	 * @generated
	 */
	public Adapter createTypedElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.FeatureCS <em>Feature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.FeatureCS
	 * @generated
	 */
	public Adapter createFeatureCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.OperationCS <em>Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.OperationCS
	 * @generated
	 */
	public Adapter createOperationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS <em>Parameter CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ParameterCS
	 * @generated
	 */
	public Adapter createParameterCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.DataTypeCS <em>Data Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.DataTypeCS
	 * @generated
	 */
	public Adapter createDataTypeCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS <em>Structural Feature CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.StructuralFeatureCS
	 * @generated
	 */
	public Adapter createStructuralFeatureCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.AnnotationElementCS <em>Annotation Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.AnnotationElementCS
	 * @generated
	 */
	public Adapter createAnnotationElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS <em>Annotation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.AnnotationCS
	 * @generated
	 */
	public Adapter createAnnotationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS <em>Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.ExpCS
	 * @generated
	 */
	public Adapter createExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AbstractNameExpCS <em>Abstract Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.AbstractNameExpCS
	 * @generated
	 */
	public Adapter createAbstractNameExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NamedExpCS <em>Named Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.NamedExpCS
	 * @generated
	 */
	public Adapter createNamedExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvocationExpCS <em>Invocation Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.InvocationExpCS
	 * @generated
	 */
	public Adapter createInvocationExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ExpressionBlockCS <em>Expression Block CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ExpressionBlockCS
	 * @generated
	 */
	public Adapter createExpressionBlockCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.ElementRefCS <em>Element Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.ElementRefCS
	 * @generated
	 */
	public Adapter createElementRefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypeRefCS <em>Type Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypeRefCS
	 * @generated
	 */
	public Adapter createTypeRefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS <em>Typed Ref CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.xtext.base.basecs.TypedRefCS
	 * @generated
	 */
	public Adapter createTypedRefCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //QVTOperationalCSAdapterFactory
