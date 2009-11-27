package org.eclipse.m2m.qvt.oml.debug.core.vm.protocol;

import java.io.Serializable;


public class VMStackFrameRequest extends VMRequest implements Serializable {

	private static final long serialVersionUID = -870457096053189047L;
	
	public final long frameID;
	
	public final String variableURI;
	
	public VMStackFrameRequest(long frameID) {
		this(frameID, null);
	}
	
	public VMStackFrameRequest(long frameID, String variableURI) {
		this.frameID = frameID;
		this.variableURI = variableURI;
	}
	
	public boolean rootVariablesRequest() {
		return variableURI == null;
	}
}
