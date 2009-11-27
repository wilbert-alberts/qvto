package org.eclipse.m2m.qvt.oml.debug.core;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.m2m.qvt.oml.debug.core.vm.VMVariable;

class QVTOVariable extends QVTODebugElement implements IVariable {
	

	private final VMVariable vmVar;
	private IValue val;

	QVTOVariable(IQVTODebugTarget debugTarget, final VMVariable vmVar, long frameID) {
		super(debugTarget);
		
		this.vmVar = vmVar;			
		this.val = new QVTOValue(getQVTODebugTarget(), vmVar, frameID);
	}

	public IValue getValue() throws DebugException {
		 return val;
	}

	public String getName() throws DebugException {
		return vmVar.name;
	}
	
	public String getReferenceTypeName() throws DebugException {
		return this.vmVar.type.declaringType;
	}	

	public boolean hasValueChanged() throws DebugException {
		return false;
	}

	public boolean supportsValueModification() {
		return false;
	}

	public void setValue(String expression) throws DebugException {
	}

	public void setValue(IValue value) throws DebugException {
	}

	public boolean verifyValue(String expression) throws DebugException {
		return false;
	}

	public boolean verifyValue(IValue value) throws DebugException {
		return false;
	}	
}