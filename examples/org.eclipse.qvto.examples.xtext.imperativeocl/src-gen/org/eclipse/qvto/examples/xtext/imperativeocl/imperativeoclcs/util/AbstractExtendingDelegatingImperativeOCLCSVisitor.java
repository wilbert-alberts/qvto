/**
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/ImperativeOCL.genmodel
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractDelegatingEssentialOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor;

/**
 * An AbstractExtendingDelegatingImperativeOCLCSVisitor delegates all visits.
 */
public abstract class AbstractExtendingDelegatingImperativeOCLCSVisitor<R, C, D extends EssentialOCLCSVisitor<R>>
	extends AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements ImperativeOCLCSVisitor<R>
{
	protected AbstractExtendingDelegatingImperativeOCLCSVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitConstructorExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ConstructorExpCS object) {
		return delegate.visitExpCS(object);
	}

	public @Nullable R visitDictLiteralExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralExpCS object) {
		return delegate.visitExpCS(object);
	}

	public @Nullable R visitDictLiteralPartCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralPartCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitDictTypeCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS object) {
		return delegate.visitTypedRefCS(object);
	}

	public @Nullable R visitIndexExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.IndexExpCS object) {
		return delegate.visitExpCS(object);
	}

	public @Nullable R visitInvocationExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.InvocationExpCS object) {
		return delegate.visitExpCS(object);
	}

	public @Nullable R visitListLiteralExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListLiteralExpCS object) {
		return delegate.visitExpCS(object);
	}

	public @Nullable R visitListTypeCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListTypeCS object) {
		return delegate.visitTypedRefCS(object);
	}

	public @Nullable R visitNameExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.NameExpCS object) {
		return delegate.visitExpCS(object);
	}

	public @Nullable R visitReturnExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ReturnExpCS object) {
		return delegate.visitExpCS(object);
	}
}
