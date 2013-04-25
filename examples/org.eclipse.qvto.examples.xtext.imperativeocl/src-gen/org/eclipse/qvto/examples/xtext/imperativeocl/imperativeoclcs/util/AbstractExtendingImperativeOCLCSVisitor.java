/**
 * 
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
 * An AbstractExtendingImperativeOCLCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingImperativeOCLCSVisitor<R, C>
	extends org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractExtendingEssentialOCLCSVisitor<R, C>
	implements ImperativeOCLCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingImperativeOCLCSVisitor(@NonNull C context) {
	    super(context);
	}	

	public @Nullable R visitConstructorExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ConstructorExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitDictLiteralExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitDictLiteralPartCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralPartCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitDictTypeCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS object) {
		return visitTypedRefCS(object);
	}

	public @Nullable R visitIndexExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.IndexExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitInvocationExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.InvocationExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitListLiteralExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListLiteralExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitListTypeCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListTypeCS object) {
		return visitTypedRefCS(object);
	}

	public @Nullable R visitNameExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.NameExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitReturnExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ReturnExpCS object) {
		return visitExpCS(object);
	}
}
