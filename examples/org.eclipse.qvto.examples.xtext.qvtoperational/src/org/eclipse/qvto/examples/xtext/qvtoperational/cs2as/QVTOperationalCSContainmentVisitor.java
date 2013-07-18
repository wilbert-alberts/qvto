package org.eclipse.qvto.examples.xtext.qvtoperational.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.AbstractQVTOperationalCSContainmentVisitor;

public class QVTOperationalCSContainmentVisitor
		extends AbstractQVTOperationalCSContainmentVisitor {

	protected QVTOperationalCSContainmentVisitor(CS2PivotConversion context) {
		super(context);
	}
	
	
	@Override
	public @Nullable
	Continuation<?> visitTopLevelCS(@NonNull
	TopLevelCS csElement) {
		// TODO
		return super.visitTopLevelCS(csElement);
	}
}