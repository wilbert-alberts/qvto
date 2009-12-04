/*******************************************************************************
 * Copyright (c) 2009 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.debug.core;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.m2m.qvt.oml.debug.core.vm.VMVariable;

public class QVTOVariable extends QVTODebugElement implements IVariable {
	
	private final VMVariable fUnderlyingVar;
	private final IValue fValue;

	
	QVTOVariable(IQVTODebugTarget debugTarget, final VMVariable vmVar, long frameID) {
		super(debugTarget);
		
		this.fUnderlyingVar = vmVar;			
		this.fValue = new QVTOValue(getQVTODebugTarget(), vmVar, frameID);
	}

	public boolean isModelParameter() {
		return fUnderlyingVar.kind == VMVariable.MODEL_PARAMETER;
	}
	
	public boolean isLocalVariable() {
		return fUnderlyingVar.kind == VMVariable.LOCAL;
	}
	
	public boolean isCollectionElement() {
		return fUnderlyingVar.kind == VMVariable.COLLECTION_ELEMENT;
	}	

	public boolean isPredefinedVariable() {
		return fUnderlyingVar.kind == VMVariable.PREDEFINED_VAR;
	}		
	
	public boolean isIntermProperty() {
		return fUnderlyingVar.kind == VMVariable.INTERM_PROPERTY;
	}	

	public boolean isAttribute() {
		return fUnderlyingVar.kind == VMVariable.ATTRIBUTE;
	}	
	
	public boolean isReference() {
		return fUnderlyingVar.kind == VMVariable.REFERENCE;
	}	
	
	public IValue getValue() throws DebugException {
		 return fValue;
	}

	public String getName() throws DebugException {
		return fUnderlyingVar.name;
	}
	
	public String getReferenceTypeName() throws DebugException {
		return this.fUnderlyingVar.type.declaringType;
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