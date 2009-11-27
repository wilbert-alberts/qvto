package org.eclipse.m2m.qvt.oml.debug.core.vm.protocol;

import java.io.Serializable;

public class BreakpointData implements Serializable {
	
	private static final long serialVersionUID = -2199623960858987773L;
	
	public String condition;
	public boolean conditionEnabled;
	public boolean conditionSuspendOnTrue;
	public int hitCount;
	
	public BreakpointData() {
		super();
	}
	
	public BreakpointData(BreakpointData data) {
		this.condition = data.condition;
		this.conditionEnabled = data.conditionEnabled;
		this.conditionSuspendOnTrue = data.conditionSuspendOnTrue;
		this.hitCount = data.hitCount;
	}
	
}