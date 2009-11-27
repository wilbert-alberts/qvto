package org.eclipse.m2m.qvt.oml.debug.core.vm.protocol;

import java.io.Serializable;


public class VMVariableRequest extends VMRequest implements Serializable {

	private static final long serialVersionUID = -5791928039344216899L;

	public final String variableURI;
	public final long frameID;
	public final boolean includeChildVars;
	
	public VMVariableRequest(long frameID, String variableURI, boolean includeChildVars) {
		this.frameID = frameID;
		this.variableURI = variableURI;
		this.includeChildVars = includeChildVars;
	}
	
	public VMVariableRequest(long frameID, String variableURI) {
		this(frameID, variableURI, false);
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() +
			": frameID:=" + frameID + " variableUri=" + variableURI; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$		
	}
}
