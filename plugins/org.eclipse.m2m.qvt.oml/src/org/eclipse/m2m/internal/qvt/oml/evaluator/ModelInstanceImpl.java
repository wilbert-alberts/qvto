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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelParameterExtent;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;


class ModelInstanceImpl extends DynamicEObjectImpl  implements ModelInstance {

	private ModelParameterExtent fExtent;
	
	ModelInstanceImpl(ModelType modelType, ModelParameterExtent extent) {
		if(modelType == null || extent == null) {
			throw new IllegalArgumentException();
		}
		
		eSetClass(modelType);
		fExtent = extent;
	}
		
	public ModelType getModelType() {
		return (ModelType) eClass();
	}
	
	public ModelParameterExtent getExtent() {
		return fExtent;
	}
	
	public ModelInstance copy() {
		List<EObject> rootObjects = getExtent().getRootObjects();
		List<EObject> copyAll = new ArrayList<EObject>(EcoreUtil.copyAll(rootObjects));
		ModelParameterExtent extentCopy = new ModelParameterExtent(copyAll,
				getExtent().getResourceSet(), getExtent().getModelParameter());
		return new ModelInstanceImpl(getModelType(), extentCopy);
	}

	@Override
	public String toString() {
		return eClass().getName();
	}
}
