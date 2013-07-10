package org.eclipse.qvto.examples.xtext.imperativeocl.cs2as;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.qvto.examples.pivot.imperativeocl.ListType;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListTypeCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.AbstractImperativeOCLCSContainmentVisitor;

public class ImperativeOCLCSContainmentVisitor extends AbstractImperativeOCLCSContainmentVisitor {

	public ImperativeOCLCSContainmentVisitor(CS2PivotConversion context) {
		super(context);
	}
	
	@Override
	@Nullable
	public Continuation<?> visitListTypeCS(ListTypeCS object) {
		ListType type = PivotUtil.getPivot(ListType.class, object);
		return null;
	}
}
