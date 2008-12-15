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

import org.eclipse.m2m.internal.qvt.oml.ast.env.InternalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalStdLibrary;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtInterruptedExecutionException;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;
import org.eclipse.m2m.internal.qvt.oml.evaluator.TransformationInstance.InternalTransformation;
import org.eclipse.m2m.internal.qvt.oml.stdlib.model.ExceptionInstance;
import org.eclipse.m2m.internal.qvt.oml.stdlib.model.StatusInstance;
import org.eclipse.m2m.internal.qvt.oml.stdlib.model.StdlibFactory;

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
			public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
				ModuleInstance moduleInstance = (ModuleInstance) source;
				CallHandler mainHandler = moduleInstance.getAdapter(InternalTransformation.class).getEntryOperationHandler();
				if(mainHandler == null) {
					// module has no main operation => return invalid
					return CallHandlerAdapter.getInvalidResult(evalEnv);
				}

		    	StdlibFactory stdlibFactory = new StdlibFactory(QvtOperationalStdLibrary.INSTANCE);
		    	// Note: !!!! exception throw from here is captured by MDT OCL and turned into OCLInvalid
			    try {
			    	mainHandler.invoke(moduleInstance, source, args, evalEnv);
			    } catch(QvtInterruptedExecutionException e) {
			    	// ensure the stop exception gets propagated
			    	evalEnv.getAdapter(InternalEvaluationEnv.class).setException(e);
			    	throw e;
			    } catch(QvtRuntimeException e) {
					ExceptionInstance raisedException = stdlibFactory.createException(e.getLocalizedMessage(), e.getQvtStackTrace());					
			    	StatusInstance status = stdlibFactory.createFailure(raisedException);
			    	return status;
			    }
			    
			    return stdlibFactory.createSuccess();
			}
		};
	}
}
