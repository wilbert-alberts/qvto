package org.eclipse.m2m.qvt.oml.debug.core.vm.protocol;

public class VMStartEvent extends VMEvent {

	private static final long serialVersionUID = 4489918763664221834L;

	public final boolean suspendOnStartup;
	
	public VMStartEvent(boolean suspendOnStartup) {
		this.suspendOnStartup = suspendOnStartup;
	}		
}