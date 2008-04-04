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
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.utilities.PredefinedType;


public class StringOperations extends AbstractContextualOperations {
	
	public StringOperations(AbstractQVTStdlib library) {
		super(library, library.getEnvironment().getOCLStandardLibrary().getString());
	}
	
	@Override
	protected OperationProvider[] getOperations() {
		OCLStandardLibrary<EClassifier> oclStdLib = getStdlib().getEnvironment().getOCLStandardLibrary();		
		return new OperationProvider[] {
			new OperationProvider(STRING_CONCAT, PredefinedType.PLUS_NAME, oclStdLib.getString(), oclStdLib.getString())			
		};
	}
	
	static CallHandler STRING_CONCAT = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			return ((String) source).concat(String.valueOf(args[0]));
		}
	};
}
