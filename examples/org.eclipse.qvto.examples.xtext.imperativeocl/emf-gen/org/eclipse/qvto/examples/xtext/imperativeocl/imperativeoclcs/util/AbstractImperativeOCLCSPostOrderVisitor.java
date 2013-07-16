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
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLPostOrderVisitor;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;

/**
 * An AbstractImperativeOCLCSPostOrderVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractImperativeOCLCSPostOrderVisitor
	extends EssentialOCLPostOrderVisitor
	implements ImperativeOCLCSVisitor<Continuation<?>>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractImperativeOCLCSPostOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	public @Nullable Continuation<?> visitAssertExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.AssertExpCS csElement) {
		return visitStatementCS(csElement);
	}

	public @Nullable Continuation<?> visitAssignStatementCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.AssignStatementCS csElement) {
		return visitStatementCS(csElement);
	}

	public @Nullable Continuation<?> visitBlockExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.BlockExpCS csElement) {
		return visitStatementCS(csElement);
	}

	public @Nullable Continuation<?> visitComputeExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ComputeExpCS csElement) {
		return visitExpressionBlockCS(csElement);
	}

	public @Nullable Continuation<?> visitDictLiteralExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Continuation<?> visitDictLiteralPartCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralPartCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitDictTypeCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS csElement) {
		return visitTypedRefCS(csElement);
	}

	public @Nullable Continuation<?> visitDoExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DoExpCS csElement) {
		return visitExpressionBlockCS(csElement);
	}

	public @Nullable Continuation<?> visitExceptCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ExceptCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitExpressionBlockCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ExpressionBlockCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Continuation<?> visitExpressionStatementCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ExpressionStatementCS csElement) {
		return visitStatementCS(csElement);
	}

	public @Nullable Continuation<?> visitForExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ForExpCS csElement) {
		return visitImperativeLoopExpCS(csElement);
	}

	public @Nullable Continuation<?> visitImperativeIterateExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeIterateExpCS csElement) {
		return visitImperativeLoopExpCS(csElement);
	}

	public @Nullable Continuation<?> visitImperativeLoopExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeLoopExpCS csElement) {
		return visitInvocationExpCS(csElement);
	}

	public @Nullable Continuation<?> visitInstantiationExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.InstantiationExpCS csElement) {
		return visitStatementCS(csElement);
	}

	public @Nullable Continuation<?> visitListLiteralExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListLiteralExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Continuation<?> visitListTypeCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListTypeCS csElement) {
		return visitTypedRefCS(csElement);
	}

	public @Nullable Continuation<?> visitLogExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.LogExpCS csElement) {
		return visitInvocationExpCS(csElement);
	}

	public @Nullable Continuation<?> visitQuitExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.QuitExpCS csElement) {
		return visitStatementCS(csElement);
	}

	public @Nullable Continuation<?> visitRaiseExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.RaiseExpCS csElement) {
		return visitStatementCS(csElement);
	}

	public @Nullable Continuation<?> visitReturnExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ReturnExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Continuation<?> visitStatementCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.StatementCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Continuation<?> visitSwitchAltCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.SwitchAltCS csElement) {
		return visitStatementCS(csElement);
	}

	public @Nullable Continuation<?> visitSwitchExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.SwitchExpCS csElement) {
		return visitStatementCS(csElement);
	}

	public @Nullable Continuation<?> visitTryExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.TryExpCS csElement) {
		return visitExpressionBlockCS(csElement);
	}

	public @Nullable Continuation<?> visitVariableInitializationCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.VariableInitializationCS csElement) {
		return visitStatementCS(csElement);
	}

	public @Nullable Continuation<?> visitWhileExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.WhileExpCS csElement) {
		return visitExpressionBlockCS(csElement);
	}
}
