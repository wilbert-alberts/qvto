package org.eclipse.qvto.examples.xtext.imperativeocl.cs2as.util;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.basecs.ElementRefCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.BasicContinuation;



/**
 * FutureResolution created when solving the constructor part during the containment pass 
 * 
 * @author asbh
 *
 * @param <CS>
 * @param <AS>
 */
public abstract class FutureReferenceResolution<CS extends ElementRefCS, AS extends Element> implements IFutureResolution {

	private @NonNull CS csElement;
	private @NonNull Class<AS> asJavaClass;
	
	public FutureReferenceResolution(@NonNull CS csElement, @NonNull Class<AS> asJavaClass) { // FIXME additional context (environment, mmManager, etc).
		this.csElement = csElement;
	}
	
	public void addTo(List<BasicContinuation<?>> simpleContinuations) {
		// DO NOTHING
		// FIXME  Remove this when continuations disappear
	}

	@NonNull
	protected CS getCS() {
		return csElement;
	}

	@Nullable 
	protected AS getReferredAS() {
		return PivotUtil.getPivot(asJavaClass, csElement);
	}
	
	public boolean isResolved() {
		return getReferredAS() != null;
	}
}