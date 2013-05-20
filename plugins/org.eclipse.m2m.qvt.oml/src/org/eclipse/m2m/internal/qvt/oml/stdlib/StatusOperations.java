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

import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance;
import org.eclipse.m2m.internal.qvt.oml.stdlib.model.StatusInstance;

public class StatusOperations extends AbstractContextualOperations {
	
	
    public StatusOperations(AbstractQVTStdlib library) {
		super(library, library.getStatusClass());
	}
	
	@Override
	protected OperationProvider[] getOperations() {
		return new OwnedOperationProvider[] {
				new OwnedOperationProvider(SUCCESS, "succeeded", getStdlib().getOCLStdLib().getBoolean()),//$NON-NLS-1$ 
				new OwnedOperationProvider(FAILED, "failed", getStdlib().getOCLStdLib().getBoolean()),//$NON-NLS-1$					
				new OwnedOperationProvider(RAISED_EXCEPTION, "raisedException", getStdlib().getExceptionClass())//$NON-NLS-1$				
		};
	}
	
	private static final CallHandler SUCCESS = new CallHandler() {
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			if(source instanceof StatusInstance) {
				return ((StatusInstance) source).succeeded();
			}
			return CallHandlerAdapter.getInvalidResult(evalEnv); 
		}
	};

	private static final CallHandler FAILED = new CallHandler() {
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			if(source instanceof StatusInstance) {
				return ((StatusInstance) source).failed();
			}
			return CallHandlerAdapter.getInvalidResult(evalEnv); 
		}
	};

	private static final CallHandler RAISED_EXCEPTION = new CallHandler() {
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			if(source instanceof StatusInstance) {
				return ((StatusInstance) source).raisedException();
			}
			
			return CallHandlerAdapter.getInvalidResult(evalEnv); 
		}
	};	
}