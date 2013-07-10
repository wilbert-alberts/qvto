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
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLLeft2RightVisitor;
/**
 * An AbstractImperativeOCLCSLeft2RightVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractImperativeOCLCSLeft2RightVisitor
	extends EssentialOCLLeft2RightVisitor
	implements ImperativeOCLCSVisitor<Element>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractImperativeOCLCSLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}	

	public @Nullable Element visitAssertExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.AssertExpCS csElement) {
		return visitStatementCS(csElement);
	}

	public @Nullable Element visitAssignStatementCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.AssignStatementCS csElement) {
		return visitStatementCS(csElement);
	}

	public @Nullable Element visitBlockExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.BlockExpCS csElement) {
		return visitStatementCS(csElement);
	}

	public @Nullable Element visitComputeExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ComputeExpCS csElement) {
		return visitExpressionBlockCS(csElement);
	}

	public @Nullable Element visitDictLiteralExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Element visitDictLiteralPartCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralPartCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitDictTypeCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS csElement) {
		return visitTypedRefCS(csElement);
	}

	public @Nullable Element visitDoExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DoExpCS csElement) {
		return visitExpressionBlockCS(csElement);
	}

	public @Nullable Element visitExceptCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ExceptCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Element visitExpressionBlockCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ExpressionBlockCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Element visitExpressionStatementCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ExpressionStatementCS csElement) {
		return visitStatementCS(csElement);
	}

	public @Nullable Element visitForExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ForExpCS csElement) {
		return visitImperativeLoopExpCS(csElement);
	}

	public @Nullable Element visitImperativeIterateExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeIterateExpCS csElement) {
		return visitImperativeLoopExpCS(csElement);
	}

	public @Nullable Element visitImperativeLoopExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ImperativeLoopExpCS csElement) {
		return visitInvocationExpCS(csElement);
	}

	public @Nullable Element visitInstantiationExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.InstantiationExpCS csElement) {
		return visitStatementCS(csElement);
	}

	public @Nullable Element visitListLiteralExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListLiteralExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Element visitListTypeCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListTypeCS csElement) {
		return visitTypedRefCS(csElement);
	}

	public @Nullable Element visitLogExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.LogExpCS csElement) {
		return visitInvocationExpCS(csElement);
	}

	public @Nullable Element visitQuitExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.QuitExpCS csElement) {
		return visitStatementCS(csElement);
	}

	public @Nullable Element visitRaiseExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.RaiseExpCS csElement) {
		return visitStatementCS(csElement);
	}

	public @Nullable Element visitReturnExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ReturnExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Element visitStatementCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.StatementCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Element visitSwitchAltCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.SwitchAltCS csElement) {
		return visitStatementCS(csElement);
	}

	public @Nullable Element visitSwitchExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.SwitchExpCS csElement) {
		return visitStatementCS(csElement);
	}

	public @Nullable Element visitTryExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.TryExpCS csElement) {
		return visitExpressionBlockCS(csElement);
	}

	public @Nullable Element visitVariableInitializationCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.VariableInitializationCS csElement) {
		return visitStatementCS(csElement);
	}

	public @Nullable Element visitWhileExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.WhileExpCS csElement) {
		return visitExpressionBlockCS(csElement);
	}
}
