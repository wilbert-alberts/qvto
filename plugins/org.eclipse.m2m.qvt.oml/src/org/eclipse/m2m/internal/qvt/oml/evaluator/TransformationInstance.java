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

import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandler;

public interface TransformationInstance extends ModuleInstance, ThisInstanceResolver {

	OperationalTransformation getTransformation();
	
	ModelInstance getModel(ModelParameter modelParam);
	
	/**
	 * Binds a model extent with a model parameter of this transformation.
	 * 
	 * @param parameter
	 *            the model parameter to be bound with the given extent
	 * @param model
	 *            the model instance to be associated with the given
	 *            model parameter
	 * 
	 * @throws IllegalArgumentException
	 *             in any argument is <code>null</code> or the given parameter
	 *             is not a model parameter of this transformation
	 */
	void setModel(ModelParameter parameter, ModelInstance model);
 
	
	interface InternalTransformation extends Internal {

		void setEntryOperationHandler(CallHandler handler);
	
		CallHandler getEntryOperationHandler();
	}
}