package org.eclipse.qvto.examples.xtext.imperativeocl.cs2as;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLLeft2RightVisitor;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictLiteralPartCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListLiteralExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListTypeCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ReturnExpCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.ImperativeOCLCSVisitor;

public abstract class AbstractImperativeOCLLeft2RightVisitor extends EssentialOCLLeft2RightVisitor
	implements ImperativeOCLCSVisitor<Element>{

	public AbstractImperativeOCLLeft2RightVisitor(CS2PivotConversion context) {
		super(context);
	}

	@Nullable
	public Element visitDictLiteralExpCS(DictLiteralExpCS object) {
		return visitExpCS(object);
	}
	
	@Nullable
	public Element visitDictLiteralPartCS(DictLiteralPartCS object) {
		return visitElementCS(object);
	}
	
	@Nullable
	public Element visitDictTypeCS(DictTypeCS object) {
		return visitTypedRefCS(object);
	}
	
	@Nullable
	public Element visitListLiteralExpCS(ListLiteralExpCS object) {
		return visitExpCS(object);
	}
	
	@Nullable
	public Element visitListTypeCS(ListTypeCS object) {
		return visitTypedRefCS(object);
	}
	
	@Nullable
	public Element visitReturnExpCS(ReturnExpCS object) {
		return visitExpCS(object);
	}
}
