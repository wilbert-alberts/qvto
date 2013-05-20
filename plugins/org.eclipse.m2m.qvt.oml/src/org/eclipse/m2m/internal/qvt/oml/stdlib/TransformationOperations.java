/*******************************************************************************
 * Copyright (c) 2008, 2009 Borland Software Corporation and others.
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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.internal.qvt.oml.ast.env.InternalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QVTOEnvironment;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalStdLibrary;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtInterruptedExecutionException;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;
import org.eclipse.m2m.internal.qvt.oml.evaluator.TransformationInstance.InternalTransformation;
import org.eclipse.m2m.internal.qvt.oml.stdlib.model.ExceptionInstance;
import org.eclipse.m2m.internal.qvt.oml.stdlib.model.StatusInstance;
import org.eclipse.m2m.internal.qvt.oml.stdlib.model.StdlibFactory;
import org.eclipse.ocl.types.OCLStandardLibrary;

public class TransformationOperations extends AbstractContextualOperations {

	static final String TRANSFORM_NAME = "transform"; //$NON-NLS-1$	
	static final String PARALLEL_TRANSFORM_NAME = "parallelTransform"; //$NON-NLS-1$	
	static final String WAIT_NAME = "wait"; //$NON-NLS-1$	
	
	
    public TransformationOperations(AbstractQVTStdlib library) {
		super(library, library.getTransformationClass());
	}
	
	@Override
	protected OperationProvider[] getOperations() {
		QVTOEnvironment environment = getStdlib().getEnvironment();
		OCLStandardLibrary<EClassifier> oclStdLibrary = environment.getOCLStandardLibrary();
		EClassifier statusList = environment.getTypeResolver().resolveListType(oclStdLibrary.getT());
		
		return new OwnedOperationProvider[] {				
			new OwnedOperationProvider(createTransformHandler(getStdlib()), TRANSFORM_NAME, getStdlib().getStatusClass()),
			
			new OwnedOperationProvider(UNSUPPORTED_OPER, PARALLEL_TRANSFORM_NAME, getStdlib().getStatusClass()),
			new OwnedOperationProvider(UNSUPPORTED_OPER, WAIT_NAME, new String[] { "statusList" }, //$NON-NLS-1$
					oclStdLibrary.getOclVoid(), statusList)
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

		    	StdlibFactory stdlibFactory = QvtOperationalStdLibrary.INSTANCE.getStdlibFactory();
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
