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

package org.eclipse.m2m.internal.qvt.oml.stdlib;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstanceAdapter;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;

public class TransformationOperations extends AbstractContextualOperations {

    public TransformationOperations(AbstractQVTStdlib library) {
		super(library, library.getTransformationClass());
	}
	
	@Override
	protected OperationProvider[] getOperations() {
		return new OwnedOperationProvider[] {
				new OwnedOperationProvider(createTransformHandler(getStdlib()), "transform", getStdlib().getStatusClass())//$NON-NLS-1$ 
		};
	}
	
	private static CallHandler createTransformHandler(final AbstractQVTStdlib stdlib) {
		return new CallHandler() {
			public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
				// FIXME - add validation code!!!
				ModuleInstanceAdapter moduleAdapter = ModuleInstanceAdapter.getAdaper((EObject)source);
				CallHandler mainHandler = moduleAdapter.getEntryOperationHandler();
			    try {
			    	mainHandler.invoke(source, args, evalEnv, context);
			    } catch(QvtRuntimeException e) {
			    	// TODO - support raised exception
			    	EClass raisedException = null;
			    	return StatusOperations.createFailed(stdlib.getStatusClass(), raisedException);
			    }
			    return StatusOperations.createSuccess(stdlib.getStatusClass());
			}
		};
	}
}
