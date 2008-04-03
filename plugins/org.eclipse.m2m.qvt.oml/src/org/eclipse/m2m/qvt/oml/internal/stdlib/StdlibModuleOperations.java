/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation
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

import java.io.PrintWriter;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalStdLibrary;
import org.eclipse.m2m.qvt.oml.library.IContext;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.util.TypeUtil;

public class StdlibModuleOperations extends AbstractContextualOperations {
    static final String DUMP_NAME = "dump"; //$NON-NLS-1$

    public StdlibModuleOperations(AbstractQVTStdlib library) {
		super(library, library.getLibaryModule());
	}
	
	@Override
	protected OperationProvider[] getOperations() {
		EcoreEnvironment env = getStdlib().getEnvironment();
		OCLStandardLibrary<EClassifier> oclStdLib = env.getOCLStandardLibrary();
		EClassifier genericCollectionType = TypeUtil.resolveType(env,
				(EClassifier)env.getOCLFactory().createCollectionType(oclStdLib.getT2()));

		return new OperationProvider[] {
				new OperationProvider(DUMP, DUMP_NAME, 
								oclStdLib.getOclVoid(), oclStdLib.getOclAny()),
				new OperationProvider(DUMP, DUMP_NAME, 
						oclStdLib.getOclVoid(), genericCollectionType)
		};
	}
	
	static final CallHandler DUMP = new CallHandler() {
		public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
			PrintWriter printWriter = (PrintWriter) context.get(QvtOperationalStdLibrary.OUT_PRINT_WRITER);
			Object toPrint = source;
			if (args.length == 1) {
				toPrint = args[0];
			}
			
		    if (printWriter != null) {
		    	printWriter.println(toPrint);
		    } else {
		    	System.out.println(toPrint);
		    	System.out.flush();
		    }
		    return null;
		}
	};
}
