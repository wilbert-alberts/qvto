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
package org.eclipse.m2m.qvt.oml.ast.environment;

import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.qvt.oml.library.IContext;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;

public class QvtOperationalEnvFactory extends EcoreEnvironmentFactory {

	public QvtOperationalFileEnv createEnvironment(final QvtOperationalEnv parent, final CFile file, final QvtCompiler compiler) {
		QvtOperationalFileEnv env = new QvtOperationalFileEnv(parent, file, compiler);
		env.setFactory(this);
		return env;
	}
	
	public QvtOperationalEnv createEnvironment(final QvtOperationalEnv parent, final QvtCompiler compiler) {
		QvtOperationalEnv env = new QvtOperationalEnv(parent, compiler);
		env.setFactory(this);
		return env;
	}
	
	public QvtOperationalEvaluationEnv createEvaluationEnvironment(IContext context, QvtOperationalEvaluationEnv parent) {
		return new QvtOperationalEvaluationEnv(context, parent);
	}
	
}
