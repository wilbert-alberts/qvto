package org.eclipse.m2m.qvt.oml.debug.core.vm.protocol;

import org.eclipse.m2m.qvt.oml.debug.core.vm.VMStackFrame;
import org.eclipse.m2m.qvt.oml.debug.core.vm.VMVariable;



public class VMStackFrameResponse extends VMResponse {

	private static final long serialVersionUID = 5164097654623010310L;

	public final VMStackFrame[] frames;
	public final VMVariable[] variables;
	public boolean isDeferredExecution;
	
	public VMStackFrameResponse(VMStackFrame frame) {
		this(new VMStackFrame[] { frame });
	}

	public VMStackFrameResponse(VMStackFrame[] frames) {
		this.frames = frames; 
		this.variables = null;
	}
	
	public VMStackFrameResponse(VMVariable[] variables) {
		this.variables = variables;
		this.frames = null;
	}
	
	public boolean isDeferredExecution() {
		return isDeferredExecution;
	}
	
	public VMStackFrame getFrame() {
		return frames != null && frames.length > 0 ? frames[0] : null;
	}
	
}