package org.eclipse.m2m.qvt.oml.library;

import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.qvt.oml.expressions.ResolveExp;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.QvtOperationalEvaluationVisitorImpl;

/**
 * @author aigdalov
 */

public class LateResolveTask extends AbstractLateResolveTask {
    public LateResolveTask(ResolveExp resolveExp, EObjectEStructuralFeaturePair lvalue, QvtOperationalEvaluationVisitorImpl visitor,
            QvtOperationalEvaluationEnv evalEnv) {
        super(resolveExp, lvalue, visitor, evalEnv);
    }

    public Object getResolveResult() {
        return QvtResolveUtil.resolveNow(getResolveExp(), getVisitor(), getEvalEnv());
    }
}