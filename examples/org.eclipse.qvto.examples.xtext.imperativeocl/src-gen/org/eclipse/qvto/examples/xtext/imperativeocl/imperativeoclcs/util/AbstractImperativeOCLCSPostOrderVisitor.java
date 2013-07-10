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

	public @Nullable Continuation<?> visitDictLiteralExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Continuation<?> visitDictLiteralPartCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralPartCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitDictTypeCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS csElement) {
		return visitTypedRefCS(csElement);
	}

	public @Nullable Continuation<?> visitListLiteralExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListLiteralExpCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Continuation<?> visitListTypeCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListTypeCS csElement) {
		return visitTypedRefCS(csElement);
	}

	public @Nullable Continuation<?> visitReturnExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ReturnExpCS csElement) {
		return visitExpCS(csElement);
	}
}
