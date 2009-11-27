/*******************************************************************************
 * Copyright (c) 2009 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.debug.core.vm;

import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;

public class DebugEvaluationEnvironment extends QvtOperationalEvaluationEnv implements QVTODebugEvalEnvironment {
	
	private final long fID;
	
	public DebugEvaluationEnvironment(IContext context, QvtOperationalEvaluationEnv parent, long id) {
		super(context, parent);
		fID = id;
	}
	
	public long getID() {
		return fID;
	}
}