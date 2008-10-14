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
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;

public class StatusOperations extends AbstractContextualOperations {
	
	static class Status extends EObjectImpl {
		private boolean fIsSuccess = true;
		private EClass fException;
		
		private Status(boolean isSuccess, EClass exception) {
			fException = exception;
			fIsSuccess = isSuccess;
		}
		
		
		@Override
		public String toString() {
			StringBuilder buf = new StringBuilder(); 
			buf.append(fIsSuccess ? "SUCCESS" : "FAILED"); //$NON-NLS-1$ //$NON-NLS-1$
			if(fException != null) {
				buf.append(fException.getName());
			}
			return buf.toString();
		}
	}
	
	static EObject createSuccess(EClass statusClass) {
		Status status = new Status(true, null);
		status.eSetClass(statusClass);
		return status;
	}
	
	static EObject createFailed(EClass statusClass, EClass raisedException) {
		Status status = new Status(false, raisedException);
		status.eSetClass(statusClass);
		return status;
	}
	
    public StatusOperations(AbstractQVTStdlib library) {
		super(library, library.getStatusClass());
	}
	
	@Override
	protected OperationProvider[] getOperations() {
		return new OwnedOperationProvider[] {
				new OwnedOperationProvider(SUCCESS, "success", getStdlib().getOCLStdLib().getBoolean()),//$NON-NLS-1$ 
				new OwnedOperationProvider(FAILED, "failed", getStdlib().getOCLStdLib().getBoolean()),//$NON-NLS-1$					
				new OwnedOperationProvider(RAISED_EXCEPTION, "raisedException", getStdlib().getExceptionClass())//$NON-NLS-1$				
		};
	}
	
	private static final CallHandler SUCCESS = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			if(source instanceof Status) {
				return Boolean.valueOf(((Status)source).fIsSuccess);
			}
			return Boolean.FALSE; 
		}
	};

	private static final CallHandler FAILED = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			if(source instanceof Status) {
				return Boolean.valueOf(((Status)source).fIsSuccess == false);
			}
			return Boolean.TRUE; 
		}
	};

	private static final CallHandler RAISED_EXCEPTION = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			if(source instanceof Status) {
				return ((Status)source).fException;
			}
			return null; 
		}
	};	
}