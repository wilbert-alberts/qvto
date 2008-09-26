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
package org.eclipse.m2m.internal.qvt.oml.evaluator.iterators;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;

/**
 * @author aigdalov
 * Created on Sep 25, 2008
 */
public abstract class QvtImperativeIteratorTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
extends QvtIterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {

    protected QvtImperativeIteratorTemplate(EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> v) {
        super(v);
    }

    // override this method for different iterator behaviors
    protected abstract Object evaluateResult(List<Variable<C, PM>> iterators, String resultName, OCLExpression<EClassifier> conditionExp, Object bodyVal, boolean isOne);

    @Override
    protected Object evaluateResultTemplate(List<Variable<C, PM>> iterators,
            Variable<EClassifier, EParameter> target,
            String resultName, OCLExpression<C> condition,
            OCLExpression<C> body, boolean isOne) {
        // evaluate the body of the expression in this environment
        Object bodyVal = (body == null) ? null : getEvaluationVisitor().visitExpression(body);

        advanceTarget(target, bodyVal);

        // get the new result value
        @SuppressWarnings("unchecked")
        Object resultVal = evaluateResult(iterators, resultName, (OCLExpression<EClassifier>) condition, bodyVal, isOne);
        return resultVal;
    }
    
    protected Boolean isConditionOk(OCLExpression<EClassifier> conditionExp, Object bodyVal) {
        // evaluate the condition of the expression in this environment
        Object conditionVal = conditionExp.accept(getEvaluationVisitor());
        if (conditionVal instanceof Boolean) {
            return (Boolean) conditionVal;
        } else if (conditionVal instanceof EClassifier){
            QvtOperationalEvaluationEnv env = (QvtOperationalEvaluationEnv) getEvalEnvironment();
            return QvtOperationalUtil.oclIsKindOf(bodyVal, (EClassifier) conditionVal, env);
        } else {
            setDone(true);
            return null;
        }
    }
    
    
    protected Object returnCheckedEvaluationResult(Object addedElement, boolean isOne, String resultName) {
        // If the body result is invalid then the entire expression's value
        // is invalid, because OCL does not permit OclInvalid in a collection
        if (addedElement == getOclInvalid()) {
            setDone(true);
            return getOclInvalid();
        }
        if (isOne) {
            setDone(true);
            return addedElement;
        }
        @SuppressWarnings("unchecked")
        Collection<Object> resultingCollection = (Collection<Object>) getEvalEnvironment().getValueOf(resultName);
        resultingCollection.add(addedElement);
        return resultingCollection;
    }
}