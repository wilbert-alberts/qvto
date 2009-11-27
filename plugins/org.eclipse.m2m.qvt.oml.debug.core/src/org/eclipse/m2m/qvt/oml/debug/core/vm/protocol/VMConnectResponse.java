package org.eclipse.m2m.qvt.oml.debug.core.vm.protocol;


public class VMConnectResponse extends VMResponse {
	
	private static final long serialVersionUID = -7072530388048039990L;
	
	private final int fEventPort;
	
	public VMConnectResponse(int eventPort) {
		fEventPort = eventPort;
	}
	
	public int getEventPort() {
		return fEventPort;
	}
	

	@Override
	public String toString() {
		return getClass().getSimpleName() + " event port: " + fEventPort;  //$NON-NLS-1$
	}
}