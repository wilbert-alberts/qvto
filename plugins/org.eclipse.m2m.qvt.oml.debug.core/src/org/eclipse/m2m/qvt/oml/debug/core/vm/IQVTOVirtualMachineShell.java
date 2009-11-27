package org.eclipse.m2m.qvt.oml.debug.core.vm;

import java.io.IOException;

import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMEvent;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMRequest;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMResponse;


public interface IQVTOVirtualMachineShell {
	
	VMResponse sendRequest(VMRequest request) throws IOException;
	
	VMEvent readVMEvent() throws IOException;

	boolean isTerminated();
}
