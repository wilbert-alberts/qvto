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
package org.eclipse.m2m.tests.qvt.oml;

import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtOperationalEvaluationVisitorImpl;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.EcoreEvaluationEnvironment;
import org.eclipse.ocl.ecore.OCL.Query;

public class ExtOCLEnvironmentWithQVTAccessTest extends OCLEnvironmentWithQVTAccessTest {

	public ExtOCLEnvironmentWithQVTAccessTest() {
		super();
	}

	@Override
	protected EcoreEvaluationEnvironment getEvaluationEnv(Query query) {
		return QvtOperationalEnvFactory.INSTANCE.createEvaluationEnvironment(new Context(), null);
	}
	
	@Override
	protected Object evaluate(EcoreEvaluationEnvironment evalEnv, Query query) {	
		QvtOperationalEvaluationVisitorImpl visitor = QvtOperationalEvaluationVisitorImpl
				.createNonTransformationExecutionContextVisitor(
						QvtOperationalEnvFactory.INSTANCE.createEnvironment(), 
						(QvtOperationalEvaluationEnv)evalEnv, getImportedModules());
		
		return visitor.visitExpression(query.getExpression());		
	}
	
	@Override
	protected Object evaluate(EcoreEvaluationEnvironment evalEnv, Query query, Object self) {
		evalEnv.add(Environment.SELF_VARIABLE_NAME, self);		
		return evaluate(evalEnv, query);
	}		
}
