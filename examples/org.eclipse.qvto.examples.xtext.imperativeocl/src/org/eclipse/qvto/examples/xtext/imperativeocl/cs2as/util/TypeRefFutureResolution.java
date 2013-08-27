package org.eclipse.qvto.examples.xtext.imperativeocl.cs2as.util;

import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;


public abstract class TypeRefFutureResolution<CS extends TypeRefCS, AS extends Type> extends FutureReferenceResolution<CS, AS> {

	public TypeRefFutureResolution(CS csElement, Class<AS> asJavaClass) {
		super(csElement, asJavaClass);
	}

}