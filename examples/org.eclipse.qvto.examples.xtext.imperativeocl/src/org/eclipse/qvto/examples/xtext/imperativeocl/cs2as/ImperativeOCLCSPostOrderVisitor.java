package org.eclipse.qvto.examples.xtext.imperativeocl.cs2as;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListTypeCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.AbstractImperativeOCLCSPostOrderVisitor;

public class ImperativeOCLCSPostOrderVisitor extends AbstractImperativeOCLCSPostOrderVisitor {

	public ImperativeOCLCSPostOrderVisitor(CS2PivotConversion context) {
		super(context);
	}

	
	@Override
	@Nullable
	public Continuation<?> visitListTypeCS(ListTypeCS object) {
		return null;
	}
}
