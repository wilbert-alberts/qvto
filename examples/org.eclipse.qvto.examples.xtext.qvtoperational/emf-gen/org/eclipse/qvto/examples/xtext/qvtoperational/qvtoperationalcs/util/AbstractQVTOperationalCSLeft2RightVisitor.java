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
import org.eclipse.qvto.examples.xtext.imperativeocl.cs2as.ImperativeOCLCSLeft2RightVisitor;
import org.eclipse.ocl.examples.pivot.Element;

/**
 * An AbstractQVTOperationalCSLeft2RightVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTOperationalCSLeft2RightVisitor
	extends ImperativeOCLCSLeft2RightVisitor
	implements QVTOperationalCSVisitor<Element>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTOperationalCSLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	public @Nullable Element visitClassifierDefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierDefCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitClassifierProperty2CS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS csElement) {
		return visitLocalPropertyCS(csElement);
	}

	public @Nullable Element visitClassifierPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS csElement) {
		return visitStructuralFeatureCS(csElement);
	}

	public @Nullable Element visitCompleteSignatureCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitConfigPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConfigPropertyCS csElement) {
		return visitModulePropertyCS(csElement);
	}

	public @Nullable Element visitConstructorCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConstructorCS csElement) {
		return visitMappingMethodCS(csElement);
	}

	public @Nullable Element visitContextualPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ContextualPropertyCS csElement) {
		return visitModulePropertyCS(csElement);
	}

	public @Nullable Element visitElementWithBody(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ElementWithBody csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitExceptionCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ExceptionCS csElement) {
		return visitClassCS(csElement);
	}

	public @Nullable Element visitImperativeOperationCallExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImperativeOperationCallExpCS csElement) {
		return visitInvocationExpCS(csElement);
	}

	public @Nullable Element visitInitPartCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitLibraryImportCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LibraryImportCS csElement) {
		return visitQVToImportCS(csElement);
	}

	public @Nullable Element visitLocalPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LocalPropertyCS csElement) {
		return visitModulePropertyCS(csElement);
	}

	public @Nullable Element visitMappingBodyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingBodyCS csElement) {
		return visitMappingSectionCS(csElement);
	}

	public @Nullable Element visitMappingCallExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingCallExpCS csElement) {
		return visitImperativeOperationCallExpCS(csElement);
	}

	public @Nullable Element visitMappingEndCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingEndCS csElement) {
		return visitMappingSectionCS(csElement);
	}

	public @Nullable Element visitMappingExtensionCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitMappingInitCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingInitCS csElement) {
		return visitMappingSectionCS(csElement);
	}

	public @Nullable Element visitMappingMethodCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingMethodCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitMappingModuleCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitMappingOperationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS csElement) {
		return visitOperationCS(csElement);
	}

	public @Nullable Element visitMappingQueryCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingQueryCS csElement) {
		return visitMappingMethodCS(csElement);
	}

	public @Nullable Element visitMappingRuleCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingRuleCS csElement) {
		return visitMappingMethodCS(csElement);
	}

	public @Nullable Element visitMappingSectionCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitMappingSectionsCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionsCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitMetamodelCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS csElement) {
		return visitPackageCS(csElement);
	}

	public @Nullable Element visitModelTypeCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS csElement) {
		return visitClassCS(csElement);
	}

	public @Nullable Element visitModuleKindCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitModulePropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModulePropertyCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitModuleRefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleRefCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitModuleUsageCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitMultiplicityDefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityDefCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitObjectExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ObjectExpCS csElement) {
		return visitExpressionBlockCS(csElement);
	}

	public @Nullable Element visitOperationParameterDeclarationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationParameterDeclarationCS csElement) {
		return visitParameterCS(csElement);
	}

	public @Nullable Element visitOperationSimpleSignatureCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationSimpleSignatureCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitOppositePropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OppositePropertyCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitPackageRefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PackageRefCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitParameterDeclarationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterDeclarationCS csElement) {
		return visitTypedElementCS(csElement);
	}

	public @Nullable Element visitPrimitiveTypeCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PrimitiveTypeCS csElement) {
		return visitDataTypeCS(csElement);
	}

	public @Nullable Element visitQVToClassCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToClassCS csElement) {
		return visitClassCS(csElement);
	}

	public @Nullable Element visitQVToImportCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToImportCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitQVToLibraryCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToLibraryCS csElement) {
		return visitMappingModuleCS(csElement);
	}

	public @Nullable Element visitQVToOperationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToOperationCS csElement) {
		return visitOperationCS(csElement);
	}

	public @Nullable Element visitRenameCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.RenameCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitResolveExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveExpCS csElement) {
		return visitInvocationExpCS(csElement);
	}

	public @Nullable Element visitResolveInExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveInExpCS csElement) {
		return visitResolveExpCS(csElement);
	}

	public @Nullable Element visitResolveOpArgsExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveOpArgsExpCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitScopedNameCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ScopedNameCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitSimpleSignatureCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitStereotypeQualifierCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.StereotypeQualifierCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitTagCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS csElement) {
		return visitAnnotationCS(csElement);
	}

	public @Nullable Element visitTopLevelCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS csElement) {
		return visitRootPackageCS(csElement);
	}

	public @Nullable Element visitTransformationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationCS csElement) {
		return visitPackageCS(csElement);
	}

	public @Nullable Element visitTransformationRefineCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationRefineCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitTypeSpecCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS csElement) {
		return visitTypedRefCS(csElement);
	}

	public @Nullable Element visitUnitCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS csElement) {
		return visitElementCS(csElement);
	}
}
