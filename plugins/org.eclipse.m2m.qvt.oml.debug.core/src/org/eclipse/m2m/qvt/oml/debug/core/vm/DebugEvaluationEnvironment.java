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