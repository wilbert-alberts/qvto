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
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitClassCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassCS object) {
		return delegate.visitClassCS(object);
	}

	public @Nullable R visitClassifierPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS object) {
		return delegate.visitClassifierPropertyCS(object);
	}

	public @Nullable R visitExceptionCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ExceptionCS object) {
		return delegate.visitExceptionCS(object);
	}

	public @Nullable R visitImportCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS object) {
		return delegate.visitImportCS(object);
	}

	public @Nullable R visitInitPartCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS object) {
		return delegate.visitInitPartCS(object);
	}

	public @Nullable R visitMetamodelCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS object) {
		return delegate.visitMetamodelCS(object);
	}

	public @Nullable R visitOperationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationCS object) {
		return delegate.visitOperationCS(object);
	}

	public @Nullable R visitParameterCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterCS object) {
		return delegate.visitParameterCS(object);
	}

	public @Nullable R visitPrimitiveTypeCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PrimitiveTypeCS object) {
		return delegate.visitPrimitiveTypeCS(object);
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

	public @Nullable R visitUnitCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS object) {
		return delegate.visitUnitCS(object);
	}
}
