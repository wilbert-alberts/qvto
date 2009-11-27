package org.eclipse.m2m.qvt.oml.debug.core.vm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.m2m.qvt.oml.debug.core.DebugOptions;
import org.eclipse.m2m.qvt.oml.debug.core.QVTODebugCore;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.BreakpointData;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.NewBreakpointData;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMBreakpointRequest;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMBreakpointResponse;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMEvent;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMRequest;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMResponse;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMStackFrameRequest;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMStackFrameResponse;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMStartEvent;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMStartRequest;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMTerminateEvent;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMVariableRequest;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMBreakpointRequest.ActionKind;

public class QVTOVirtualMachine implements IQVTOVirtualMachineShell {
		
	private final List<VMRequest> fRequests = new ArrayList<VMRequest>();
	private final BlockingQueue<VMEvent> fEvents = new ArrayBlockingQueue<VMEvent>(50);	
		
	
	private IQVTODebuggerShell fDebuggerShell;
	
	private final VMBreakpointManager fBreakpointManager;
	private QVTODebugEvaluator fInterpreter;
	private DebuggableExecutorAdapter fExecutor;

	private boolean fRunning;
	private boolean fTerminated;
		
	private Object fStateMonitor = new Object();
	private final Object fLock = new Object();
		
	
	public QVTOVirtualMachine(DebuggableExecutorAdapter executorAdapter) {
		if(executorAdapter == null) {
			throw new IllegalArgumentException();
		}
		
		fExecutor = executorAdapter;
		fDebuggerShell = new DebuggerShell();
		fBreakpointManager = new VMBreakpointManager(executorAdapter.getUnit());
		fTerminated = false;
	}

	public boolean isTerminated() {
		return fTerminated;
	}

	public VMEvent readVMEvent() throws IOException {
		try {
			return fEvents.take();
		} catch(InterruptedException e) {
			throw new IOException("Waiting for event interrupted");
		}
	}
	
	public VMResponse sendRequest(VMRequest request) throws IOException {
		if(request instanceof VMStartRequest) {
			return start();
		} else if(request instanceof VMBreakpointRequest) {
			return handleBreakPointRequest((VMBreakpointRequest) request);
		} else if(request instanceof VMStackFrameRequest) {
			return handleStackFrameRequest((VMStackFrameRequest) request);
		} else if(request instanceof VMVariableRequest) {
			return handleVariableRequest((VMVariableRequest) request);
		}
		
		synchronized (fLock) {
			fRequests.add(request);			
			fLock.notifyAll();
		}
		
		return VMResponse.createOK();
	}
	
	private VMResponse start() {
		Thread executorThread = new Thread(createVMRunnable());
		
		synchronized (fStateMonitor) {
			if(fRunning) {
				return VMResponse.createERROR();
			}

			executorThread.start();
			
			while(!(fRunning || fTerminated)) {
				try {				
					fStateMonitor.wait();
				} catch (InterruptedException e) {					
					QVTODebugCore.log(QVTODebugCore.createStatus(IStatus.ERROR,
							"VM startup process interrupted"));
				}
			}
		}
		
		return VMResponse.createOK();
	}	
	
	private VMResponse handleStackFrameRequest(VMStackFrameRequest request) {
		if(fInterpreter != null) {
			List<UnitLocation> locationStack = fInterpreter.getLocationStack();
			VMStackFrame frame = VMStackFrame.createFrame(request.frameID, locationStack);
			VMStackFrameResponse response = new VMStackFrameResponse(frame);
			if(!locationStack.isEmpty()) {
				UnitLocation topLocation = locationStack.get(0);
		    	response.isDeferredExecution = topLocation.isDeferredExecution();
			}

			return response;
		}
		
		// FIXME
		return VMResponse.createERROR(); 
	}

	private VMBreakpointResponse handleBreakPointRequest(VMBreakpointRequest request) {
		ActionKind actionKind = request.getActionKind();
		
		if(actionKind == VMBreakpointRequest.ActionKind.ADD) {
			List<BreakpointData> allBpData = request.getBreakpointData();
			if(allBpData != null) {
				for (BreakpointData bpData : allBpData) {
					if(bpData instanceof NewBreakpointData == false) {
						continue;
					}
					
					NewBreakpointData newBreakpoint = (NewBreakpointData) bpData;
					VMBreakpoint breakpoint = fBreakpointManager.createBreakpoint(newBreakpoint);
					
					if(breakpoint != null) {
						QVTODebugCore.TRACE.trace(DebugOptions.VM,
								"Installing breakpoing: " + " line:" //$NON-NLS-1$ //$NON-NLS-2$
										+ newBreakpoint.line + " " //$NON-NLS-1$
										+ newBreakpoint.targetURI);
					} else {
						QVTODebugCore.TRACE.trace(DebugOptions.VM,
								"Failed to create breakpoing: " + " line:" //$NON-NLS-1$ //$NON-NLS-2$
										+ newBreakpoint.line + " " //$NON-NLS-1$
										+ newBreakpoint.targetURI);
							
					}
				}
			}
		} else if(actionKind == VMBreakpointRequest.ActionKind.REMOVE) {
			fBreakpointManager.removeBreakpoint(request.getBreakpointID());
		} else if(actionKind == VMBreakpointRequest.ActionKind.CHANGE) {
			fBreakpointManager.changeBreakpoint(request.getBreakpointID(), request.getFirstBreakpointData());
		}
		
		// TODO
		return new VMBreakpointResponse();
	}
	
	private VMResponse handleVariableRequest(VMVariableRequest request) {
		// FIXME - ensure VM is in SUSPEND state, otherwise report fError
		UnitLocationExecutionContext context = new UnitLocationExecutionContext(
				fInterpreter, fInterpreter.getCurrentLocation());
		return VariableFinder.process(request, fInterpreter.getLocationStack(),
				context);
	}
	
	private Runnable createVMRunnable() {
		return new Runnable() {
			public void run() {
				int exitCode = -1;
				try {
					fExecutor.connect(fDebuggerShell);
					exitCode = execute(fExecutor);
				} catch(Throwable e) {
					QVTODebugCore.log(e);
				} finally {
					fDebuggerShell.handleVMEvent(new VMTerminateEvent(exitCode));
				}
			}
		};
	}
		
	private static int execute(DebuggableExecutorAdapter executorAdapter) {
		int exitCode = 0;
		try {
			Diagnostic diagnostic = executorAdapter.execute();
			int severity = diagnostic.getSeverity();
			if(severity == Diagnostic.ERROR || severity == Diagnostic.CANCEL) {
				exitCode = -1;
			}
		} catch (Throwable e) {
			exitCode = -2;
			// FIXME Auto-generated catch block
			e.printStackTrace();
		}	
		
		return exitCode;
	}	
	
	
	private class DebuggerShell implements IQVTODebuggerShell {
		
		public VMBreakpointManager getBreakPointManager() {
			return QVTOVirtualMachine.this.fBreakpointManager;
		}
		
		public void sessionStarted(QVTODebugEvaluator evaluator) {
			fInterpreter = evaluator;
		}
		
		public void handleVMEvent(VMEvent event) {
			if(event instanceof VMStartEvent) {
				// first start event
				synchronized (fStateMonitor) {
					fRunning = true;
					fStateMonitor.notify();
				}
			} else if(event instanceof VMTerminateEvent) {
				synchronized (fStateMonitor) {
					fRunning = false;
					fTerminated = true;
					fStateMonitor.notify();
				}				
			}

			try {
				fEvents.add(event);				
			} catch(IllegalStateException e) {
				// FIXME
				System.err.println("Event queue full!!!!");
			}
		}	
		
		public VMRequest popRequest() {
			synchronized (fLock) {
				return fRequests.isEmpty() ? null : fRequests.remove(0);
			}
		}
		
		public VMRequest waitAndPopRequest(VMEvent suspend) throws InterruptedException {
			// FIXME - should be locked to ensure noone can really send a request until
			// we deliver the event
			handleVMEvent(suspend);
			
			synchronized (fLock) {			
				while(fRequests.isEmpty()) {
					fLock.wait();
				}
				return fRequests.remove(0);
			}		
		}

		public VMRequest peekRequest() {
			synchronized (fLock) {
				return fRequests.isEmpty() ? null : fRequests.get(0);
			}
		}
	}
}