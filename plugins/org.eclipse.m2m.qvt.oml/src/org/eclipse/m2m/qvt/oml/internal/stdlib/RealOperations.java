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
package org.eclipse.m2m.qvt.oml.internal.stdlib;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.qvt.oml.library.IContext;
import org.eclipse.ocl.types.OCLStandardLibrary;


public class RealOperations extends AbstractContextualOperations {

	public static final String TO_STRING_NAME = "toString"; //$NON-NLS-1$
	
	private static final CallHandler TO_STRING = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			return String.valueOf(source);
		}
	};	
	
		
	public RealOperations(AbstractQVTStdlib library) {
		super(library, library.getEnvironment().getOCLStandardLibrary().getReal());
	}
	
	@Override
	protected OperationProvider[] getOperations() {
		OCLStandardLibrary<EClassifier> oclStdlib = getStdlib().getEnvironment().getOCLStandardLibrary();
		return new OperationProvider[] {
			new OperationProvider(TO_STRING, TO_STRING_NAME, oclStdlib.getString())
		};
	}
}
