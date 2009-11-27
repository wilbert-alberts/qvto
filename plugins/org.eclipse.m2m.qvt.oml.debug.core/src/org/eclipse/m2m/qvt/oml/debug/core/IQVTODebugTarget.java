package org.eclipse.m2m.qvt.oml.debug.core;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.m2m.qvt.oml.debug.core.vm.VMEventListener;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMRequest;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMResponse;



interface IQVTODebugTarget extends IDebugTarget {

	VMResponse sendRequest(VMRequest request) throws DebugException;
	
	void addVMEventListener(VMEventListener listener);
	
	boolean removeVMEventListener(VMEventListener listener);

}