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
import org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;

class ModelParameterHelper {

	private OperationalTransformation fTransformation;
	private List<ModelParameterExtent> fModelArguments;	

	
	ModelParameterHelper(OperationalTransformation transformation, List<Object> arguments) {
		if(transformation == null || arguments == null) {
			throw new IllegalArgumentException();
		}

		List<ModelParameterExtent> modelArguments = new ArrayList<ModelParameterExtent>(arguments.size());		
		for (Object nextArg : arguments) {
			if(nextArg instanceof ModelParameterExtent) {
				modelArguments.add((ModelParameterExtent) nextArg);
			}
		}
		
		fTransformation = transformation;
		fModelArguments = modelArguments;
		if(fModelArguments.size() != fTransformation.getModelParameter().size()) {
			throw new IllegalArgumentException("Invalid number of transformation arguments"); //$NON-NLS-1$
		}
	}
	
	private ModelParameterExtent findCompatibleExtent(ModelParameter modelParam, Collection<ModelParameterExtent> alreadyBound) {
		int pos = 0;
		for (ModelParameter nextParam : fTransformation.getModelParameter()) {
			if(QvtOperationalUtil.isModelParamEqual(nextParam, modelParam, true)) {
				ModelParameterExtent extent = fModelArguments.get(pos);
				if(!alreadyBound.contains(extent)) {				
					return extent;
				}
			}
			
			pos++;			
		}
		
		return null;
	}

	public void initModelParameters(TransformationInstance transformation) {		
		OperationalTransformation transformationType = transformation.getTransformation(); 				
		Collection<ModelParameterExtent> alreadyBound = new UniqueEList.FastCompare<ModelParameterExtent>();
		int pos = 0;
		for (ModelParameter modelParam : transformationType.getModelParameter()) {
			ModelParameterExtent extent;
			
			if(transformation.getTransformation() == fTransformation) {
				extent = fModelArguments.get(pos);
			} else {
				extent = findCompatibleExtent(modelParam, alreadyBound);			
				if(extent == null) {
					extent = new ModelParameterExtent();				
				}
			}
			
			ModelType modelType = (ModelType) modelParam.getEType();
			ModelInstance model = new ModelInstanceImpl(modelType, extent);			
	    	if (modelParam.getKind() == DirectionKind.IN) {
	    		// TODO - make this optional ?	    		
	    		QvtChangeRecorder qvtChangeRecorder = new QvtChangeRecorder(modelParam);
	    		qvtChangeRecorder.beginRecording(extent.getInitialObjects());
	    	}
			
			transformation.setModel(modelParam, model);
			pos++;
		}
	}		
}
