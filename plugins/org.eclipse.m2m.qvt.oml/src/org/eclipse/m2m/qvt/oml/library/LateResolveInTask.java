package org.eclipse.m2m.qvt.oml.library;

import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.qvt.oml.expressions.ResolveInExp;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.QvtOperationalEvaluationVisitorImpl;

/**
 * @author aigdalov
 */

public class LateResolveInTask extends AbstractLateResolveTask {
    public LateResolveInTask(ResolveInExp resolveInExp, EObjectEStructuralFeaturePair lvalue, QvtOperationalEvaluationVisitorImpl visitor,
            QvtOperationalEvaluationEnv evalEnv) {
        super(resolveInExp, lvalue, visitor, evalEnv);
    }

    public Object getResolveResult() {
        return QvtResolveUtil.resolveInNow((ResolveInExp) getResolveExp(), getVisitor(), getEvalEnv());
    }
}