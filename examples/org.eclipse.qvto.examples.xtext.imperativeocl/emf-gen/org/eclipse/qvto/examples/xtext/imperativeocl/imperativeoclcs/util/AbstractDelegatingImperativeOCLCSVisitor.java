/**
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: model/ImperativeOCLCS.genmodel
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

	public @Nullable R visitAssertExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.AssertExpCS object) {
		return delegate.visitAssertExpCS(object);
	}

	public @Nullable R visitAssignStatementCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.AssignStatementCS object) {
		return delegate.visitAssignStatementCS(object);
	}

	public @Nullable R visitBlockExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.BlockExpCS object) {
		return delegate.visitBlockExpCS(object);
	}

	public @Nullable R visitComputeExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ComputeExpCS object) {
		return delegate.visitComputeExpCS(object);
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

	public @Nullable R visitDoExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DoExpCS object) {
		return delegate.visitDoExpCS(object);
	}

	public @Nullable R visitExceptCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ExceptCS object) {
		return delegate.visitExceptCS(object);
	}

	public @Nullable R visitExpressionBlockCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ExpressionBlockCS object) {
		return delegate.visitExpressionBlockCS(object);
	}

	public @Nullable R visitExpressionStatementCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ExpressionStatementCS object) {
		return delegate.visitExpressionStatementCS(object);
	}

	public @Nullable R visitForExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ForExpCS object) {
		return delegate.visitForExpCS(object);
	}

	public @Nullable R visitImperativeIterateExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeIterateExpCS object) {
		return delegate.visitImperativeIterateExpCS(object);
	}

	public @Nullable R visitImperativeLoopExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeLoopExpCS object) {
		return delegate.visitImperativeLoopExpCS(object);
	}

	public @Nullable R visitInstantiationExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.InstantiationExpCS object) {
		return delegate.visitInstantiationExpCS(object);
	}

	public @Nullable R visitListLiteralExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListLiteralExpCS object) {
		return delegate.visitListLiteralExpCS(object);
	}

	public @Nullable R visitListTypeCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListTypeCS object) {
		return delegate.visitListTypeCS(object);
	}

	public @Nullable R visitLogExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.LogExpCS object) {
		return delegate.visitLogExpCS(object);
	}

	public @Nullable R visitQuitExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.QuitExpCS object) {
		return delegate.visitQuitExpCS(object);
	}

	public @Nullable R visitRaiseExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.RaiseExpCS object) {
		return delegate.visitRaiseExpCS(object);
	}

	public @Nullable R visitReturnExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ReturnExpCS object) {
		return delegate.visitReturnExpCS(object);
	}

	public @Nullable R visitStatementCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.StatementCS object) {
		return delegate.visitStatementCS(object);
	}

	public @Nullable R visitSwitchAltCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.SwitchAltCS object) {
		return delegate.visitSwitchAltCS(object);
	}

	public @Nullable R visitSwitchExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.SwitchExpCS object) {
		return delegate.visitSwitchExpCS(object);
	}

	public @Nullable R visitTryExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.TryExpCS object) {
		return delegate.visitTryExpCS(object);
	}

	public @Nullable R visitVariableInitializationCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.VariableInitializationCS object) {
		return delegate.visitVariableInitializationCS(object);
	}

	public @Nullable R visitWhileExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.WhileExpCS object) {
		return delegate.visitWhileExpCS(object);
	}
}
