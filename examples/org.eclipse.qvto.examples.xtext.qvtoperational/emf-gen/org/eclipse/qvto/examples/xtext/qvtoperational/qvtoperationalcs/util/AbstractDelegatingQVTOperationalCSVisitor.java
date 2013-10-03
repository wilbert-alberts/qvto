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

/**
 * An AbstractDelegatingQVTOperationalCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTOperationalCSVisitor<R, C, D extends QVTOperationalCSVisitor<R>>
	extends org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.AbstractDelegatingImperativeOCLCSVisitor<R, C, D>
	implements QVTOperationalCSVisitor<R>
{
	protected AbstractDelegatingQVTOperationalCSVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitClassifierDefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierDefCS object) {
		return delegate.visitClassifierDefCS(object);
	}

	public @Nullable R visitClassifierProperty2CS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS object) {
		return delegate.visitClassifierProperty2CS(object);
	}

	public @Nullable R visitClassifierPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS object) {
		return delegate.visitClassifierPropertyCS(object);
	}

	public @Nullable R visitCompleteSignatureCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS object) {
		return delegate.visitCompleteSignatureCS(object);
	}

	public @Nullable R visitConfigPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConfigPropertyCS object) {
		return delegate.visitConfigPropertyCS(object);
	}

	public @Nullable R visitConstructorCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConstructorCS object) {
		return delegate.visitConstructorCS(object);
	}

	public @Nullable R visitContextualPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ContextualPropertyCS object) {
		return delegate.visitContextualPropertyCS(object);
	}

	public @Nullable R visitElementWithBody(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ElementWithBody object) {
		return delegate.visitElementWithBody(object);
	}

	public @Nullable R visitExceptionCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ExceptionCS object) {
		return delegate.visitExceptionCS(object);
	}

	public @Nullable R visitImperativeOperationCallExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImperativeOperationCallExpCS object) {
		return delegate.visitImperativeOperationCallExpCS(object);
	}

	public @Nullable R visitInitPartCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS object) {
		return delegate.visitInitPartCS(object);
	}

	public @Nullable R visitLibraryImportCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LibraryImportCS object) {
		return delegate.visitLibraryImportCS(object);
	}

	public @Nullable R visitLocalPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LocalPropertyCS object) {
		return delegate.visitLocalPropertyCS(object);
	}

	public @Nullable R visitMappingBodyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingBodyCS object) {
		return delegate.visitMappingBodyCS(object);
	}

	public @Nullable R visitMappingCallExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingCallExpCS object) {
		return delegate.visitMappingCallExpCS(object);
	}

	public @Nullable R visitMappingEndCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingEndCS object) {
		return delegate.visitMappingEndCS(object);
	}

	public @Nullable R visitMappingExtensionCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionCS object) {
		return delegate.visitMappingExtensionCS(object);
	}

	public @Nullable R visitMappingInitCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingInitCS object) {
		return delegate.visitMappingInitCS(object);
	}

	public @Nullable R visitMappingMethodCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingMethodCS object) {
		return delegate.visitMappingMethodCS(object);
	}

	public @Nullable R visitMappingModuleCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS object) {
		return delegate.visitMappingModuleCS(object);
	}

	public @Nullable R visitMappingOperationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingOperationCS object) {
		return delegate.visitMappingOperationCS(object);
	}

	public @Nullable R visitMappingQueryCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingQueryCS object) {
		return delegate.visitMappingQueryCS(object);
	}

	public @Nullable R visitMappingRuleCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingRuleCS object) {
		return delegate.visitMappingRuleCS(object);
	}

	public @Nullable R visitMappingSectionCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionCS object) {
		return delegate.visitMappingSectionCS(object);
	}

	public @Nullable R visitMappingSectionsCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionsCS object) {
		return delegate.visitMappingSectionsCS(object);
	}

	public @Nullable R visitMetamodelCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS object) {
		return delegate.visitMetamodelCS(object);
	}

	public @Nullable R visitModelTypeCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS object) {
		return delegate.visitModelTypeCS(object);
	}

	public @Nullable R visitModuleKindCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindCS object) {
		return delegate.visitModuleKindCS(object);
	}

	public @Nullable R visitModulePropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModulePropertyCS object) {
		return delegate.visitModulePropertyCS(object);
	}

	public @Nullable R visitModuleRefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleRefCS object) {
		return delegate.visitModuleRefCS(object);
	}

	public @Nullable R visitModuleUsageCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS object) {
		return delegate.visitModuleUsageCS(object);
	}

	public @Nullable R visitMultiplicityDefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityDefCS object) {
		return delegate.visitMultiplicityDefCS(object);
	}

	public @Nullable R visitObjectExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ObjectExpCS object) {
		return delegate.visitObjectExpCS(object);
	}

	public @Nullable R visitOperationParameterDeclarationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationParameterDeclarationCS object) {
		return delegate.visitOperationParameterDeclarationCS(object);
	}

	public @Nullable R visitOperationSimpleSignatureCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationSimpleSignatureCS object) {
		return delegate.visitOperationSimpleSignatureCS(object);
	}

	public @Nullable R visitOppositePropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OppositePropertyCS object) {
		return delegate.visitOppositePropertyCS(object);
	}

	public @Nullable R visitPackageRefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PackageRefCS object) {
		return delegate.visitPackageRefCS(object);
	}

	public @Nullable R visitParameterDeclarationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterDeclarationCS object) {
		return delegate.visitParameterDeclarationCS(object);
	}

	public @Nullable R visitPrimitiveTypeCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PrimitiveTypeCS object) {
		return delegate.visitPrimitiveTypeCS(object);
	}

	public @Nullable R visitQVToClassCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToClassCS object) {
		return delegate.visitQVToClassCS(object);
	}

	public @Nullable R visitQVToImportCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToImportCS object) {
		return delegate.visitQVToImportCS(object);
	}

	public @Nullable R visitQVToLibraryCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToLibraryCS object) {
		return delegate.visitQVToLibraryCS(object);
	}

	public @Nullable R visitQVToOperationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.QVToOperationCS object) {
		return delegate.visitQVToOperationCS(object);
	}

	public @Nullable R visitRenameCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.RenameCS object) {
		return delegate.visitRenameCS(object);
	}

	public @Nullable R visitResolveExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveExpCS object) {
		return delegate.visitResolveExpCS(object);
	}

	public @Nullable R visitResolveInExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveInExpCS object) {
		return delegate.visitResolveInExpCS(object);
	}

	public @Nullable R visitResolveOpArgsExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveOpArgsExpCS object) {
		return delegate.visitResolveOpArgsExpCS(object);
	}

	public @Nullable R visitScopedNameCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ScopedNameCS object) {
		return delegate.visitScopedNameCS(object);
	}

	public @Nullable R visitSimpleSignatureCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS object) {
		return delegate.visitSimpleSignatureCS(object);
	}

	public @Nullable R visitStereotypeQualifierCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.StereotypeQualifierCS object) {
		return delegate.visitStereotypeQualifierCS(object);
	}

	public @Nullable R visitTagCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS object) {
		return delegate.visitTagCS(object);
	}

	public @Nullable R visitTopLevelCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS object) {
		return delegate.visitTopLevelCS(object);
	}

	public @Nullable R visitTransformationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationCS object) {
		return delegate.visitTransformationCS(object);
	}

	public @Nullable R visitTransformationRefineCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationRefineCS object) {
		return delegate.visitTransformationRefineCS(object);
	}

	public @Nullable R visitTypeSpecCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS object) {
		return delegate.visitTypeSpecCS(object);
	}

	public @Nullable R visitUnitCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS object) {
		return delegate.visitUnitCS(object);
	}
}
