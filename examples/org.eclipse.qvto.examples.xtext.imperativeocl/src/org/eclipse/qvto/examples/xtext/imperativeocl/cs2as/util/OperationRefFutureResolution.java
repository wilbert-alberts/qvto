package org.eclipse.qvto.examples.xtext.imperativeocl.cs2as.util;

import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementRefCS;


public abstract class OperationRefFutureResolution<CS extends ElementRefCS, AS extends Operation> extends FutureReferenceResolution<CS, AS> {

	public OperationRefFutureResolution(CS csElement, Class<AS> asJavaClass) {
		super(csElement, asJavaClass);
	}

}