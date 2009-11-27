package org.eclipse.m2m.qvt.oml.debug.core.vm;

import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMEvent;


public interface VMEventListener {

	void handleEvent(VMEvent event);
	
}
