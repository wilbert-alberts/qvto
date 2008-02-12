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
package org.eclipse.m2m.qvt.oml.internal.ast.evaluator.iterators;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.expressions.Variable;

/**
 * @author aigdalov
 * Created on Jan 31, 2008
 */
public class QvtIterationTemplateCollectSelect<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
extends QvtIterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {
    private QvtIterationTemplateCollectSelect(EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> v) {
        super(v);
    }

    public static<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
    QvtIterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getInstance(
            EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> v) {
        return new QvtIterationTemplateCollectSelect<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(v);
    }

    @Override
    protected Object evaluateResult(List<Variable<C, PM>> iterators, String resultName, Object condition, Object bodyVal) {
        @SuppressWarnings("unchecked")
        QvtOperationalEvaluationEnv env = (QvtOperationalEvaluationEnv) getEvalEnvironment();

        @SuppressWarnings("unchecked")
        Collection<Object> currVal = (Collection<Object>) env.getValueOf(resultName);

        if (condition instanceof Boolean) {
            if (!(Boolean) condition) {
                return currVal;
            }
        } else if (condition instanceof EClassifier){
            if (!QvtOperationalUtil.oclIsKindOf(bodyVal, (EClassifier) condition, env)) {
                return currVal;
            }
        } else {
            setDone(true);
            return getOclInvalid();
        }
        
        // If the body result is invalid then the entire expression's value
        // is invalid, because OCL does not permit OclInvalid in a collection
        if (bodyVal == getOclInvalid()) {
            setDone(true);
            return bodyVal;
        }

        if (bodyVal != null) { // nulls are not added to the collection
            currVal.add(bodyVal);
        }
        return currVal;
    }
}