package org.eclipse.m2m.qvt.oml.debug.core.vm;


import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMEvent;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMRequest;

public interface IQVTODebuggerShell {

	void sessionStarted(QVTODebugEvaluator evaluator);
	
	VMRequest popRequest();

	VMRequest waitAndPopRequest(VMEvent suspend) throws InterruptedException;
	
	VMRequest peekRequest();
	
	void handleVMEvent(VMEvent event);	

	VMBreakpointManager getBreakPointManager();
}
