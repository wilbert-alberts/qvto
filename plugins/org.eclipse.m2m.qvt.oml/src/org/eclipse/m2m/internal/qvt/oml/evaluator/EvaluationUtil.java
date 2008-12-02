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
import java.util.List;

import org.eclipse.emf.ecore.EParameter;
import org.eclipse.m2m.internal.qvt.oml.ast.env.InternalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelExtentContents;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelParameterExtent;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtEvaluationResult;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;

/**
 * @author dvorak
 */
class EvaluationUtil {
	
	private EvaluationUtil() {
		super();
	}

	/**
	 * - Creates list of output resources (model extents) for each 'inout' and 'out' parameters of
	 *   transformation. For non-changed 'inout' model parameter corresponding resource is empty.
	 * @return ordered list of model extents
	 */
	public static QvtEvaluationResult createEvaluationResult(QvtOperationalEvaluationEnv mainEvalEnv) {
		TransformationInstance transfInstance = (TransformationInstance)mainEvalEnv.getValueOf(QvtOperationalEnv.THIS);		
		
		List<ModelExtentContents> extents = new ArrayList<ModelExtentContents>();		
		OperationalTransformation transformation = transfInstance.getTransformation();
		
		for(ModelParameter modelParam : transformation.getModelParameter()) {
			if (modelParam.getKind() != DirectionKind.IN) {
				ModelInstance model = transfInstance.getModel(modelParam);  
	        	extents.add(model.getExtent().getContents());
			}			
		}
		
        List<Object> outParamValues = makeOutParamValues(mainEvalEnv);
		
		ModelParameterExtent unboundExtent = mainEvalEnv.getAdapter(InternalEvaluationEnv.class).getUnboundExtent();
		return new QvtEvaluationResult(extents, unboundExtent.getRootObjects(), outParamValues);
	}
	
	private static List<Object> makeOutParamValues(QvtOperationalEvaluationEnv mainEvalEnv) {
		ImperativeOperation entryPoint = (ImperativeOperation) mainEvalEnv.getOperation();		
		List<Object> outParamValues = new ArrayList<Object>();
		
		for (EParameter param : mainEvalEnv.getOperation().getEParameters()) {
			MappingParameter mappingParam  = (MappingParameter) param;
// originally we took all non-IN?? why?			
			if (mappingParam.getKind() != DirectionKind.OUT) {
				continue;
			}
			Object valueOf = mainEvalEnv.getValueOf(mappingParam.getName());
			if (valueOf != null) {
				outParamValues.add(valueOf);
			}
		}
		for (VarParameter param : entryPoint.getResult()) {
			MappingParameter mappingParam  = (MappingParameter) param;
			if (mappingParam.getKind() == DirectionKind.IN) {
				continue;
			}
			
			Object valueOf = mainEvalEnv.getValueOf(mappingParam.getName());
			if (valueOf != null) {
				outParamValues.add(valueOf);
			}
		}
		return outParamValues;
	}

}
