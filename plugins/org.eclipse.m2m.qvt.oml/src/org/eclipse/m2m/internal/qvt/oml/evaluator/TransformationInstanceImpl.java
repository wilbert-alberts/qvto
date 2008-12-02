/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.evaluator;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.internal.qvt.oml.evaluator.TransformationInstance.InternalTransformation;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandler;


class TransformationInstanceImpl extends ModuleInstanceImpl implements TransformationInstance, InternalTransformation {

	private final Map<ModelParameter, ModelInstance> fModelParams;	
	private CallHandler fEntryHandler;
	
	TransformationInstanceImpl(OperationalTransformation type) {
		super(type);
		fModelParams = new HashMap<ModelParameter, ModelInstance>(3);
	}
	
	public void setModel(ModelParameter parameter, ModelInstance extent) {
		if(parameter == null || extent == null) {
			throw new IllegalArgumentException();
		}

		fModelParams.put(parameter, extent);
	}

	public OperationalTransformation getTransformation() {	
		return (OperationalTransformation) eClass();
	}
	
	public ModelInstance getModel(ModelParameter modelParam) {
		return fModelParams.get(modelParam);
	}
	
	@Override
	public <T> T getAdapter(Class<T> adapterType) {
		if(InternalTransformation.class == adapterType || 
			TransformationInstance.class == adapterType ||
			ModuleInstance.class == adapterType) {
			return adapterType.cast(this);
		}

		return super.getAdapter(adapterType);
	}
		
	/* (non-Javadoc)
	 * @see org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance#getEntryOperationHandler()
	 */
	public CallHandler getEntryOperationHandler() {
		return fEntryHandler;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance#setEntryOperationHandler(org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandler)
	 */
	public void setEntryOperationHandler(CallHandler handler) {
		fEntryHandler = handler;
	}
	
	@Override
	public String toString() {
		OperationalTransformation transformation = getTransformation();
		
		StringBuilder buf = new StringBuilder();
		buf.append("transformation ").append(transformation.getName()).append("("); //$NON-NLS-1$ //$NON-NLS-2$
		
		int pos = 0;
		for (ModelParameter modelParameter : transformation.getModelParameter()) {
			if(pos++ > 0) {
				buf.append(',').append(' ');
			}
			buf.append(modelParameter.getKind()).append(' ')
				.append(modelParameter.getName())
				.append(" : "); //$NON-NLS-1$
			
			EClassifier type = modelParameter.getEType();
			if(type != null) {
				buf.append(type.getName());
			}
		}
		
		buf.append(") @").append(System.identityHashCode(transformation)); //$NON-NLS-1$
		return buf.toString();
	}
}
