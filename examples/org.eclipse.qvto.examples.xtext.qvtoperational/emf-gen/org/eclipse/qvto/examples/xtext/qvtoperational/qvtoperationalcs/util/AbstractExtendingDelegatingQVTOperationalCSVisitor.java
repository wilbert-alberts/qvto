/**
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: model/QVTOperationalCS.genmodel
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.AbstractDelegatingImperativeOCLCSVisitor;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.ImperativeOCLCSVisitor;

/**
 * An AbstractExtendingDelegatingQVTOperationalCSVisitor delegates all visits.
 */
public abstract class AbstractExtendingDelegatingQVTOperationalCSVisitor<R, C, D extends ImperativeOCLCSVisitor<R>>
	extends AbstractDelegatingImperativeOCLCSVisitor<R, C, D>
	implements QVTOperationalCSVisitor<R>
{
	protected AbstractExtendingDelegatingQVTOperationalCSVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitClassCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassCS object) {
		return delegate.visitClassCS(object);
	}

	public @Nullable R visitClassifierDefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierDefCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitClassifierProperty2CS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierProperty2CS object) {
		return visitLocalPropertyCS(object);
	}

	public @Nullable R visitClassifierPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS object) {
		return delegate.visitStructuralFeatureCS(object);
	}

	public @Nullable R visitCompleteSignatureCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitConfigPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConfigPropertyCS object) {
		return visitModulePropertyCS(object);
	}

	public @Nullable R visitConstructorCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ConstructorCS object) {
		return visitMappingMethodCS(object);
	}

	public @Nullable R visitContextualPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ContextualPropertyCS object) {
		return visitModulePropertyCS(object);
	}

	public @Nullable R visitDirectionKindCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.DirectionKindCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitElementWithBody(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ElementWithBody object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitExceptionCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ExceptionCS object) {
		return delegate.visitClassCS(object);
	}

	public @Nullable R visitImperativeOperationCallExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImperativeOperationCallExpCS object) {
		return delegate.visitInvocationExpCS(object);
	}

	public @Nullable R visitImportCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitInitPartCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitLibraryCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LibraryCS object) {
		return visitMappingModuleCS(object);
	}

	public @Nullable R visitLibraryImportCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LibraryImportCS object) {
		return visitImportCS(object);
	}

	public @Nullable R visitLocalPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.LocalPropertyCS object) {
		return visitModulePropertyCS(object);
	}

	public @Nullable R visitMappingBodyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingBodyCS object) {
		return visitMappingSectionCS(object);
	}

	public @Nullable R visitMappingCallExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingCallExpCS object) {
		return visitImperativeOperationCallExpCS(object);
	}

	public @Nullable R visitMappingDeclarationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingDeclarationCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitMappingEndCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingEndCS object) {
		return visitMappingSectionCS(object);
	}

	public @Nullable R visitMappingExtensionCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingExtensionCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitMappingInitCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingInitCS object) {
		return visitMappingSectionCS(object);
	}

	public @Nullable R visitMappingMethodCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingMethodCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitMappingModuleCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingModuleCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitMappingQueryCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingQueryCS object) {
		return visitMappingMethodCS(object);
	}

	public @Nullable R visitMappingRuleCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingRuleCS object) {
		return visitMappingMethodCS(object);
	}

	public @Nullable R visitMappingSectionCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitMappingSectionsCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MappingSectionsCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitMetamodelCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS object) {
		return delegate.visitPackageCS(object);
	}

	public @Nullable R visitModelTypeCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModelTypeCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitModuleKindCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleKindCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitModulePropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModulePropertyCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitModuleRefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleRefCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitModuleUsageCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ModuleUsageCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitMultiplicityDefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityDefCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitObjectExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ObjectExpCS object) {
		return delegate.visitExpressionBlockCS(object);
	}

	public @Nullable R visitOperationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationCS object) {
		return delegate.visitOperationCS(object);
	}

	public @Nullable R visitOppositePropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OppositePropertyCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitPackageRefCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PackageRefCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitParameterCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterCS object) {
		return delegate.visitParameterCS(object);
	}

	public @Nullable R visitParameterDeclarationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterDeclarationCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitPrimitiveTypeCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PrimitiveTypeCS object) {
		return delegate.visitDataTypeCS(object);
	}

	public @Nullable R visitRenameCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.RenameCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitResolveExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveExpCS object) {
		return delegate.visitInvocationExpCS(object);
	}

	public @Nullable R visitResolveInExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveInExpCS object) {
		return visitResolveExpCS(object);
	}

	public @Nullable R visitResolveOpArgsExpCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ResolveOpArgsExpCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitScopedNameCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ScopedNameCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitSimpleSignatureCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitStereotypeQualifierCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.StereotypeQualifierCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitTagCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS object) {
		return delegate.visitAnnotationCS(object);
	}

	public @Nullable R visitTopLevelCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitTransformationHeaderCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationHeaderCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitTransformationRefineCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationRefineCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitTypeSpecCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitUnitCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS object) {
		return delegate.visitElementCS(object);
	}
}
