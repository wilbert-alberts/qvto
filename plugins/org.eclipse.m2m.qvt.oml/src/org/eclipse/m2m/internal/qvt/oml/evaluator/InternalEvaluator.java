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

import java.util.List;

import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtOperationalEvaluationVisitorImpl.OperationCallResult;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;

interface InternalEvaluator extends QvtOperationalEvaluationVisitor {
	
	ModuleInstance callTransformationImplicitConstructor(OperationalTransformation transformation, List<ModelInstance> args);
	
	OperationCallResult runMainEntry(OperationalTransformation transformation, List<Object> args);
}