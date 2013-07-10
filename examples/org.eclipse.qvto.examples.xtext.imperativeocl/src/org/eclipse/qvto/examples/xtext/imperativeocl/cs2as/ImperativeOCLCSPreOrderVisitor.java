package org.eclipse.qvto.examples.xtext.imperativeocl.cs2as;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.DictTypeCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.ListTypeCS;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.AbstractImperativeOCLCSPreOrderVisitor;

public class ImperativeOCLCSPreOrderVisitor extends AbstractImperativeOCLCSPreOrderVisitor {

	public ImperativeOCLCSPreOrderVisitor(CS2PivotConversion context) {
		super(context);
	}
	
	@Override
	@Nullable
	public Continuation<?> visitDictTypeCS(DictTypeCS object) {
		// TODO	DictionaryType type =  PivotUtil.getPivot(DictionaryType.class, object);
		return null;
	}
	
	@Override
	@Nullable
	public Continuation<?> visitListTypeCS(ListTypeCS object) {
		// TODO ListType type = PivotUtil.getPivot(ListType.class, object);
		return null;
	}
}