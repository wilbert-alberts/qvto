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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.internal.qvt.oml.ast.env.InternalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.types.OCLStandardLibrary;

public class TransformationOperations extends AbstractContextualOperations {

    public TransformationOperations(AbstractQVTStdlib library) {
		super(library, library.getStdLibModule());
	}
	
	@Override
	protected OperationProvider[] getOperations() {
		EcoreEnvironment env = getStdlib().getEnvironment();
		OCLStandardLibrary<EClassifier> oclStdLib = env.getOCLStandardLibrary();
		return new OperationProvider[] {
				new OperationProvider(TRANSFORM, "transformation", oclStdLib.getOclVoid())//$NON-NLS-1$ 
		};
	}
	
	static final CallHandler TRANSFORM = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {			
			CallHandler mainHandler = evalEnv.getAdapter(InternalEvaluationEnv.class).getEntryOperationHandler();
			assert mainHandler != null;
		    return mainHandler.invoke(source, args, evalEnv, context);
		}
	};
}
