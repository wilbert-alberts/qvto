/**
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvto.examples.xtext.qvtoperational/model/QVTOperationalCS.genmodel
 *
 * Do not edit it.
 */
package	org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.qvto.examples.xtext.imperativeocl.cs2as.ImperativeOCLCSPreOrderVisitor;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;

/**
 * An AbstractQVTOperationalCSPreOrderVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTOperationalCSPreOrderVisitor
	extends ImperativeOCLCSPreOrderVisitor
	implements QVTOperationalCSVisitor<Continuation<?>>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTOperationalCSPreOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	public @Nullable Continuation<?> visitClassCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassCS csElement) {
		return super.visitClassCS(csElement);
	}

	public @Nullable Continuation<?> visitClassifierDefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierDefCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitClassifierProperty2CS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS csElement) {
		return visitLocalPropertyCS(csElement);
	}

	public @Nullable Continuation<?> visitClassifierPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS csElement) {
		return visitStructuralFeatureCS(csElement);
	}

	public @Nullable Continuation<?> visitCompleteSignatureCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitConfigPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConfigPropertyCS csElement) {
		return visitModulePropertyCS(csElement);
	}

	public @Nullable Continuation<?> visitConstructorCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConstructorCS csElement) {
		return visitMappingMethodCS(csElement);
	}

	public @Nullable Continuation<?> visitContextualPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ContextualPropertyCS csElement) {
		return visitModulePropertyCS(csElement);
	}

	public @Nullable Continuation<?> visitDirectionKindCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitElementWithBody(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ElementWithBody csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitExceptionCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ExceptionCS csElement) {
		return visitClassCS(csElement);
	}

	public @Nullable Continuation<?> visitImperativeOperationCallExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImperativeOperationCallExpCS csElement) {
		return visitInvocationExpCS(csElement);
	}

	public @Nullable Continuation<?> visitImportCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitInitPartCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitLibraryCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LibraryCS csElement) {
		return visitMappingModuleCS(csElement);
	}

	public @Nullable Continuation<?> visitLibraryImportCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LibraryImportCS csElement) {
		return visitImportCS(csElement);
	}

	public @Nullable Continuation<?> visitLocalPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LocalPropertyCS csElement) {
		return visitModulePropertyCS(csElement);
	}

	public @Nullable Continuation<?> visitMappingBodyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingBodyCS csElement) {
		return visitMappingSectionCS(csElement);
	}

	public @Nullable Continuation<?> visitMappingCallExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingCallExpCS csElement) {
		return visitImperativeOperationCallExpCS(csElement);
	}

	public @Nullable Continuation<?> visitMappingDeclarationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingDeclarationCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitMappingEndCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingEndCS csElement) {
		return visitMappingSectionCS(csElement);
	}

	public @Nullable Continuation<?> visitMappingExtensionCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitMappingInitCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingInitCS csElement) {
		return visitMappingSectionCS(csElement);
	}

	public @Nullable Continuation<?> visitMappingMethodCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingMethodCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitMappingModuleCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitMappingQueryCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingQueryCS csElement) {
		return visitMappingMethodCS(csElement);
	}

	public @Nullable Continuation<?> visitMappingRuleCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingRuleCS csElement) {
		return visitMappingMethodCS(csElement);
	}

	public @Nullable Continuation<?> visitMappingSectionCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitMappingSectionsCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionsCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitMetamodelCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS csElement) {
		return visitPackageCS(csElement);
	}

	public @Nullable Continuation<?> visitModelTypeCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitModuleKindCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitModulePropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModulePropertyCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitModuleRefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleRefCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitModuleUsageCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitMultiplicityDefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityDefCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitObjectExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ObjectExpCS csElement) {
		return visitExpressionBlockCS(csElement);
	}

	public @Nullable Continuation<?> visitOperationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationCS csElement) {
		return visitOperationCS(csElement);
	}

	public @Nullable Continuation<?> visitOppositePropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OppositePropertyCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitPackageRefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PackageRefCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitParameterCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterCS csElement) {
		return visitParameterCS(csElement);
	}

	public @Nullable Continuation<?> visitParameterDeclarationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterDeclarationCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitPrimitiveTypeCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PrimitiveTypeCS csElement) {
		return visitDataTypeCS(csElement);
	}

	public @Nullable Continuation<?> visitRenameCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.RenameCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitResolveExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveExpCS csElement) {
		return visitInvocationExpCS(csElement);
	}

	public @Nullable Continuation<?> visitResolveInExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveInExpCS csElement) {
		return visitResolveExpCS(csElement);
	}

	public @Nullable Continuation<?> visitResolveOpArgsExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveOpArgsExpCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitScopedNameCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ScopedNameCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitSimpleSignatureCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitStereotypeQualifierCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.StereotypeQualifierCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitTagCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS csElement) {
		return visitAnnotationCS(csElement);
	}

	public @Nullable Continuation<?> visitTopLevelCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitTransformationHeaderCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationHeaderCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitTransformationRefineCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationRefineCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitTypeSpecCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitUnitCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS csElement) {
		return visitElementCS(csElement);
	}
}
