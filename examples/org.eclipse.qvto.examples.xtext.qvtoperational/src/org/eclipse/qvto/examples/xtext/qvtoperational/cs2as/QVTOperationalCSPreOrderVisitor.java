package org.eclipse.qvto.examples.xtext.qvtoperational.cs2as;

import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.AbstractQVTOperationalCSPreOrderVisitor;

public class QVTOperationalCSPreOrderVisitor
		extends AbstractQVTOperationalCSPreOrderVisitor {

	protected QVTOperationalCSPreOrderVisitor(CS2PivotConversion context) {
		super(context);
	}
}