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
package org.eclipse.m2m.qvt.oml.library;

import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.qvt.oml.expressions.ResolveExp;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.DeferredAssignmentListener;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.QvtOperationalEvaluationVisitor;

/**
 * @author aigdalov
 */

public class LateResolveTask extends AbstractLateResolveTask {
    public LateResolveTask(ResolveExp resolveExp, EObjectEStructuralFeaturePair lvalue, QvtOperationalEvaluationVisitor visitor,
            QvtOperationalEvaluationEnv evalEnv, DeferredAssignmentListener deferredListener) {
        super(resolveExp, lvalue, visitor, evalEnv, deferredListener);
    }

    @Override
	public Object getResolveResult() {
        return QvtResolveUtil.resolveNow(getResolveExp(), getVisitor(), getEvalEnv(), this);
    }
}