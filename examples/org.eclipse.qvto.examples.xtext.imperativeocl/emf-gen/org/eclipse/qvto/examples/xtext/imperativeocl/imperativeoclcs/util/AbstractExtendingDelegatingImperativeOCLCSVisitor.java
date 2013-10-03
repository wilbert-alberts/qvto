/**
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvto.examples.xtext.imperativeocl/model/ImperativeOCLCS.genmodel
 *
 * Do not edit it.
 */
package	org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.AbstractDelegatingEssentialOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialoclcs.util.EssentialOCLCSVisitor;

/**
 * An AbstractExtendingDelegatingImperativeOCLCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the supertype if the supertype is in the same package as
 * the visited type, otherwise it delegates to the delegate.
 */
public abstract class AbstractExtendingDelegatingImperativeOCLCSVisitor<R, C, D extends EssentialOCLCSVisitor<R>>
	extends AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements ImperativeOCLCSVisitor<R>
{
	protected AbstractExtendingDelegatingImperativeOCLCSVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.examples.xtext.base.basecs.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitAssertExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.AssertExpCS object) {
		return visitStatementCS(object);
	}

	public @Nullable R visitAssignStatementCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.AssignStatementCS object) {
		return visitStatementCS(object);
	}

	public @Nullable R visitBlockExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.BlockExpCS object) {
		return visitStatementCS(object);
	}

	public @Nullable R visitComputeExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ComputeExpCS object) {
		return visitExpressionBlockCS(object);
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

	public @Nullable R visitDoExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DoExpCS object) {
		return visitExpressionBlockCS(object);
	}

	public @Nullable R visitExceptCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ExceptCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable R visitExpressionBlockCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ExpressionBlockCS object) {
		return delegate.visitExpCS(object);
	}

	public @Nullable R visitExpressionStatementCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ExpressionStatementCS object) {
		return visitStatementCS(object);
	}

	public @Nullable R visitForExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ForExpCS object) {
		return visitImperativeLoopExpCS(object);
	}

	public @Nullable R visitImperativeIterateExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeIterateExpCS object) {
		return visitImperativeLoopExpCS(object);
	}

	public @Nullable R visitImperativeLoopExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeLoopExpCS object) {
		return delegate.visitInvocationExpCS(object);
	}

	public @Nullable R visitInstantiationExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.InstantiationExpCS object) {
		return visitStatementCS(object);
	}

	public @Nullable R visitListLiteralExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListLiteralExpCS object) {
		return delegate.visitExpCS(object);
	}

	public @Nullable R visitListTypeCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListTypeCS object) {
		return delegate.visitTypedRefCS(object);
	}

	public @Nullable R visitLogExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.LogExpCS object) {
		return delegate.visitInvocationExpCS(object);
	}

	public @Nullable R visitQuitExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.QuitExpCS object) {
		return visitStatementCS(object);
	}

	public @Nullable R visitRaiseExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.RaiseExpCS object) {
		return visitStatementCS(object);
	}

	public @Nullable R visitReturnExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ReturnExpCS object) {
		return delegate.visitExpCS(object);
	}

	public @Nullable R visitStatementCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.StatementCS object) {
		return delegate.visitExpCS(object);
	}

	public @Nullable R visitSwitchAltCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.SwitchAltCS object) {
		return visitStatementCS(object);
	}

	public @Nullable R visitSwitchExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.SwitchExpCS object) {
		return visitStatementCS(object);
	}

	public @Nullable R visitTryExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.TryExpCS object) {
		return visitExpressionBlockCS(object);
	}

	public @Nullable R visitVariableInitializationCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.VariableInitializationCS object) {
		return visitStatementCS(object);
	}

	public @Nullable R visitWhileExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.WhileExpCS object) {
		return visitExpressionBlockCS(object);
	}
}
