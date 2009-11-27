package org.eclipse.m2m.qvt.oml.debug.core.vm.protocol;

public class VMTerminateEvent extends VMEvent {

	private static final long serialVersionUID = 8606236775842913079L;

	private int fExitCode;
	

	public VMTerminateEvent(int exitCode) {
		fExitCode = exitCode;
	}
	
	public int getExitCode() {
		return fExitCode;
	}

}