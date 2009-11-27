package org.eclipse.m2m.qvt.oml.debug.core.vm.protocol;

import org.eclipse.m2m.qvt.oml.debug.core.vm.VMVariable;


public class VMVariableResponse extends VMResponse {
	
	private static final long serialVersionUID = 4349537265414257787L;

	public final VMVariable variable;
	public final VMVariable[] childVariables;
	
	public VMVariableResponse(VMVariable variable, VMVariable[] childVariables) {
		this.variable = variable;
		this.childVariables = childVariables;
	}
	
	public VMVariableResponse(VMVariable variable) {
		this(variable, null);
	}
}