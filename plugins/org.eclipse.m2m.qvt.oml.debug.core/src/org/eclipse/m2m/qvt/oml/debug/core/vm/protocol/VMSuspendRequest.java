package org.eclipse.m2m.qvt.oml.debug.core.vm.protocol;


public class VMSuspendRequest extends VMRequest {
	
	private static final long serialVersionUID = -5297559608628409741L;

	public final int detail;
	
	public VMSuspendRequest(int detail) {
		this.detail = detail;
	}
}