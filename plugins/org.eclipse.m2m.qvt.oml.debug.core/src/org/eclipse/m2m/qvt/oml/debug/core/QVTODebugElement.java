package org.eclipse.m2m.qvt.oml.debug.core;

import org.eclipse.debug.core.model.DebugElement;

public abstract class QVTODebugElement extends DebugElement {	
	
	public QVTODebugElement(IQVTODebugTarget debugTarget) {
		super(debugTarget);
	}
	
	public String getModelIdentifier() {
		return QVTODebugCore.MODEL_ID;
	}

	public IQVTODebugTarget getQVTODebugTarget() {
		return (QVTODebugTarget) getDebugTarget(); 
	}	
}
