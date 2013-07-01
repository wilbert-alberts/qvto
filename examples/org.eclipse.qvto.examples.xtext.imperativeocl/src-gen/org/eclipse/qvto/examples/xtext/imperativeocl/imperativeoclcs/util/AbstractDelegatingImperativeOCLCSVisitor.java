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

/**
 * An AbstractDelegatingImperativeOCLCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingImperativeOCLCSVisitor<R, C, D extends ImperativeOCLCSVisitor<R>>
	extends org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements ImperativeOCLCSVisitor<R>
{
	protected AbstractDelegatingImperativeOCLCSVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitConstructorExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ConstructorExpCS object) {
		return delegate.visitConstructorExpCS(object);
	}

	public @Nullable R visitDictLiteralExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralExpCS object) {
		return delegate.visitDictLiteralExpCS(object);
	}

	public @Nullable R visitDictLiteralPartCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralPartCS object) {
		return delegate.visitDictLiteralPartCS(object);
	}

	public @Nullable R visitDictTypeCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS object) {
		return delegate.visitDictTypeCS(object);
	}

	public @Nullable R visitIndexExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.IndexExpCS object) {
		return delegate.visitIndexExpCS(object);
	}

	public @Nullable R visitInvocationExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.InvocationExpCS object) {
		return delegate.visitInvocationExpCS(object);
	}

	public @Nullable R visitListLiteralExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListLiteralExpCS object) {
		return delegate.visitListLiteralExpCS(object);
	}

	public @Nullable R visitListTypeCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListTypeCS object) {
		return delegate.visitListTypeCS(object);
	}

	public @Nullable R visitNameExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.NameExpCS object) {
		return delegate.visitNameExpCS(object);
	}

	public @Nullable R visitReturnExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ReturnExpCS object) {
		return delegate.visitReturnExpCS(object);
	}
}
