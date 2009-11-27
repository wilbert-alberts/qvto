package org.eclipse.m2m.qvt.oml.debug.core.vm.protocol;


public class VMResumeRequest extends VMRequest {
	
	private static final long serialVersionUID = 7434621076114466548L;
	
	public final int detail;
	
	public VMResumeRequest(int detail) {
		super();
		this.detail = detail;
	}
}