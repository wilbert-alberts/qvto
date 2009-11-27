package org.eclipse.m2m.qvt.oml.debug.core.vm.protocol;

import java.io.Serializable;

public class VMResponse implements Serializable {
	
	private static final long serialVersionUID = -5622330458726111494L;

	public static final int STATUS_OK = 0;
	public static final int STATUS_ERROR = 1;
	
	public final int status;
	
	protected VMResponse() {
		this(STATUS_OK);
	}
	
	protected VMResponse(int status) {
		this.status = status;
	}
		
	public boolean isOK() {
		return status == STATUS_OK;
	}
	
	public static VMResponse createOK() {
		return new VMResponse();
	}
	
	public static VMResponse createERROR() {
		return new VMResponse(STATUS_ERROR);
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " status: " + status;
	}
}