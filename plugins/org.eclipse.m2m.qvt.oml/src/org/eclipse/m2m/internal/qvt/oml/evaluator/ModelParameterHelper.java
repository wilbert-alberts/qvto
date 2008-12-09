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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelParameterExtent;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.internal.qvt.oml.evaluator.TransformationInstance.InternalTransformation;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;

/**
 * This class encapsulates the logic of model extent binding for imported transformation.
 * </p>
 * The QVT <code>1.0</code> model parameter binding is implemented here, taking the following strategy.
 * <ul>
 *  <li>1. Try binding model parameters that are strictly compatible by modeltype and direction kind</li>

 *  <li>2. Try binding (not yet bound) model parameters by the first available of a compatible direction kind</li>  
 *  
 *  <li>3. Create empty model extent for all unbound model parameter</li>  
 * </ul>
 * @author dvorak
 */
class ModelParameterHelper {

	private OperationalTransformation fMainTransformation;
	private List<ModelParameterExtent> fModelArguments;	

	/**
	 * Constructs model parameter helper for the given main transformation.
	 * 
	 * @param mainTransformation
	 *            the transformation of which the <code>main</code> operation is
	 *            to be executed
	 * @param modelArguments
	 *            the models that are passed to transformation execution
	 */
	// FIXME - use typed ModelParameterExtent directly, a better way how it gets to the evaluation environment
	// should be provided
	ModelParameterHelper(OperationalTransformation mainTransformation, List<Object> modelArguments) {
		if(mainTransformation == null || modelArguments == null) {
			throw new IllegalArgumentException();
		}

		List<ModelParameterExtent> modelExtentArguments = new ArrayList<ModelParameterExtent>(modelArguments.size());		
		for (Object nextArg : modelArguments) {
			if(nextArg instanceof ModelParameterExtent) {
				modelExtentArguments.add((ModelParameterExtent) nextArg);
			}
		}
		
		fMainTransformation = mainTransformation;
		fModelArguments = modelExtentArguments;
		if(fModelArguments.size() != fMainTransformation.getModelParameter().size()) {
			throw new IllegalArgumentException("Invalid number of transformation arguments"); //$NON-NLS-1$
		}
	}

	/**
	 * Binds model extents to model parameters of the given imported
	 * transformation in the context of the main transformation and its model
	 * arguments assigned to this helper.
	 * 
	 * @param importedTransformation
	 *            a transformation to be bind with its model parameters
	 */
	public void bindModelParameters(TransformationInstance importedTransformation) {
		if(importedTransformation == null) {
			throw new IllegalArgumentException();
		}
		
		boolean isMainTransformation = importedTransformation.getTransformation() == fMainTransformation;		
		OperationalTransformation transformationType = importedTransformation.getTransformation(); 				
		Collection<ModelParameterExtent> alreadyBound = new UniqueEList.FastCompare<ModelParameterExtent>();
		
		int pos = 0;
		for (ModelParameter modelParam : transformationType.getModelParameter()) {
			ModelParameterExtent extent;
			if(isMainTransformation) {
				extent = fModelArguments.get(pos);
			} else {
				extent = findAvailableStrictlyCompatibleExtent(modelParam, alreadyBound);			
			}
			
			if(extent == null) {
				continue;
			}
			
			importedTransformation.getAdapter(InternalTransformation.class)
				.setModel(modelParam, createModel(modelParam, extent));
			
			pos++;
		}
		
		if(isMainTransformation) {
			return;
		}
		
		// second pass
		for (ModelParameter modelParam : transformationType.getModelParameter()) {
			if(importedTransformation.getModel(modelParam) == null) {
				ModelParameterExtent extent = findFirstDirectionCompatibleExtent(modelParam, alreadyBound);			
				if(extent == null) {
					// can't a any proper extent, just create an empty one
					extent = new ModelParameterExtent();				
				}
								
				importedTransformation.getAdapter(InternalTransformation.class)
					.setModel(modelParam, createModel(modelParam, extent));				
			}
		}
	}
		
	private ModelParameterExtent findFirstDirectionCompatibleExtent(ModelParameter modelParam, Collection<ModelParameterExtent> alreadyBound) {
		int pos = 0;
		for (ModelParameter nextParam : fMainTransformation.getModelParameter()) {
			if(QvtOperationalUtil.isModelParamEqual(nextParam, modelParam, false)) {
				ModelParameterExtent extent = fModelArguments.get(pos);
				if(!alreadyBound.contains(extent)) {
					alreadyBound.add(extent);					
					return extent;
				}
			}
			
			pos++;
		}

		return null;
	}	
	
	private ModelParameterExtent findAvailableStrictlyCompatibleExtent(ModelParameter modelParam, Collection<ModelParameterExtent> alreadyBound) {
		int pos = 0;
		for (ModelParameter nextParam : fMainTransformation.getModelParameter()) {
			if(QvtOperationalUtil.isModelParamEqual(nextParam, modelParam, true)) {
				ModelParameterExtent extent = fModelArguments.get(pos);
				if(!alreadyBound.contains(extent)) {
					alreadyBound.add(extent);
					return extent;
				}
			}
			
			pos++;
		}
		
		return null;
	}
	
	private ModelInstance createModel(ModelParameter modelParam, ModelParameterExtent extent) {
		assert modelParam != null;
		assert extent != null;
		
		ModelType modelType = (ModelType) modelParam.getEType();
		ModelInstance model = new ModelInstanceImpl(modelType, extent);
    	return model;
	}	
}
