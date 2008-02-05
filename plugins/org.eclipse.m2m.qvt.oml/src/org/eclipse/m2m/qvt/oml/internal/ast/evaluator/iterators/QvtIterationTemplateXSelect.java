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
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.expressions.Variable;

/**
 * @author aigdalov
 * Created on Jan 31, 2008
 */
public class QvtIterationTemplateXSelect<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
extends QvtIterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {
    private QvtIterationTemplateXSelect(EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> v) {
        super(v);
    }

    public static<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
    QvtIterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getInstance(
            EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> v) {
        return new QvtIterationTemplateXSelect<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(v);
    }

    @Override
    protected Object evaluateResult(List<Variable<C, PM>> iterators, String resultName, Object condition, Object body) {
        @SuppressWarnings("unchecked")
        EvaluationEnvironment<EClassifier, O, P, CLS, E> env = (EvaluationEnvironment<EClassifier, O, P, CLS, E>) getEvalEnvironment();
        
        // should be exactly one iterator
        String iterName = iterators.get(0).getName();
        Object currObj = env.getValueOf(iterName);
        
        @SuppressWarnings("unchecked")
        Collection<Object> resultVal = (Collection<Object>) env.getValueOf(resultName);
        
        if (currObj != null) {
            if (condition instanceof Boolean) {
                if ((Boolean) condition) {
                    resultVal.add(currObj);
                }
            } else if (condition instanceof EClassifier){
                if (env.isKindOf(currObj, (EClassifier) condition)) {
                    resultVal.add(currObj);
                }
            } else {
                setDone(true);
                return getOclInvalid();
            }
        }
       
        return resultVal;
    }
}