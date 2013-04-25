package org.eclipse.qvto.examples.xtext.imperativeocl.cs2as;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLPostOrderVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLPreOrderVisitor;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ConstructorExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralPartCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.IndexExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.InvocationExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListLiteralExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListTypeCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.NameExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ReturnExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.ImperativeOCLCSVisitor;

public abstract class AbstractImperativeOCLPostOrderVisitor extends EssentialOCLPostOrderVisitor 
	implements ImperativeOCLCSVisitor<Continuation<?>>{

	public AbstractImperativeOCLPostOrderVisitor(CS2PivotConversion context) {
		super(context);
	}

	@Nullable
	public Continuation<?> visitConstructorExpCS(ConstructorExpCS object) {
		return visitExpCS(object);
	}
	
	@Nullable
	public Continuation<?> visitDictLiteralExpCS(DictLiteralExpCS object) {
		return visitExpCS(object);
	}
	
	@Nullable
	public Continuation<?> visitDictLiteralPartCS(DictLiteralPartCS object) {
		return visitElementCS(object);
	}
	
	@Nullable
	public Continuation<?> visitDictTypeCS(DictTypeCS object) {
		return visitTypedRefCS(object);
	}
	
	@Nullable
	public Continuation<?> visitIndexExpCS(IndexExpCS object) {
		return visitExpCS(object);
	}
	
	@Nullable
	public Continuation<?> visitInvocationExpCS(InvocationExpCS object) {
		return visitExpCS(object);
	}
	
	@Nullable
	public Continuation<?> visitListLiteralExpCS(ListLiteralExpCS object) {
		return visitExpCS(object);
	}
	
	@Nullable
	public Continuation<?> visitListTypeCS(ListTypeCS object) {
		return visitTypedRefCS(object);
	}
	
	@Nullable
	public Continuation<?> visitNameExpCS(NameExpCS object) {
		return visitExpCS(object);
	}
	
	@Nullable
	public Continuation<?> visitReturnExpCS(ReturnExpCS object) {
		return visitExpCS(object);
	}
}
