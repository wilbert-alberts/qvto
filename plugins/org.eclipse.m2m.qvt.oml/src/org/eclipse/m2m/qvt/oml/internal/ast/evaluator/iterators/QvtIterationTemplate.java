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

/**
 * @author aigdalov
 * Created on Jan 31, 2008
 */

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.types.OCLStandardLibrary;

public abstract class QvtIterationTemplate<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {
    private EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> myEvalVisitor;
    private EvaluationEnvironment<C, O, P, CLS, E> myEvalEnv;
    private boolean done = false;

    // singleton
    protected QvtIterationTemplate(EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> v) {

        myEvalVisitor = v;
        myEvalEnv = v.getEvaluationEnvironment();
    }

    public EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getEvaluationVisitor() {
        return myEvalVisitor;
    }

    public EvaluationEnvironment<C, O, P, CLS, E> getEvalEnvironment() {
        return myEvalEnv;
    }

    public final void setDone(boolean done) {
        this.done = done;
    }

    public final boolean isDone() {
        return done;
    }

    public Object evaluate(Collection<?> coll, 
            List<Variable<C, PM>> iterators,
            Variable<EClassifier, EParameter> target,
            OCLExpression<C> condition, 
            OCLExpression<C> body, 
            String resultName,
            boolean isOne) {
        
        // if the collection is empty, then nothing to do
            if (coll.isEmpty())
                return myEvalEnv.getValueOf(resultName);

        // construct an array of java iterators, one for each
            // ocl iterator in the expression
            int numIters = iterators.size();
            Iterator<?>[] javaIters = new Iterator[numIters];
            initializeIterators(iterators, javaIters, coll);

            while (true) {
                // evaluate the body of the expression in this environment
                Object bodyVal = (body == null) ? null : myEvalVisitor.visitExpression(body);

                advanceTarget(target, bodyVal);

                // get the new result value
                @SuppressWarnings("unchecked")
                Object resultVal = evaluateResult(iterators, resultName, (OCLExpression<EClassifier>) condition, bodyVal, isOne);

                // set the result variable in the environment with the result value
                myEvalEnv.replace(resultName, resultVal);

                // find the next unfinished iterator
                int curr = getNextUnfinishedIterator(javaIters);

                if (!moreToGo(curr, numIters)) {
                    // all iterators are finished and so are we:

                    // remove the iterators from the environment
                    removeIterators(iterators);
                    
                    // remove the iterators from the environment
                    removeTarget(target);
                    
                    // return the result value
                    return myEvalEnv.getValueOf(resultName);
                }

                // more iteration to go:
                // reset all iterators up to the current unfinished one
                // and replace their assignments in the environment
                advanceIterators(iterators, javaIters, coll, curr);
            }
    }

    protected void initializeIterators(
            List<Variable<C, PM>> iterators,
            Iterator<?>[] javaIters,
            Collection<?> c) {

        for (int i = 0, n = javaIters.length; i < n; i++) {
            javaIters[i] = c.iterator();
            Variable<C, PM> iterDecl = iterators.get(i);
            String iterName = (String) iterDecl.accept(myEvalVisitor);
            Object value = javaIters[i].next();
            myEvalEnv.replace(iterName, value);
        }
    }

    protected int getNextUnfinishedIterator(Iterator<?>[] javaIters) {
        int curr;
        int numIters = javaIters.length;
        for (curr = 0; curr < numIters; curr++)
            if (javaIters[curr].hasNext())
                break;
        return curr;
    }

    protected void advanceIterators(
            List<Variable<C, PM>> iterators,
            Iterator<?>[] javaIters,
            Collection<?> c,
            int curr) {

        // assumes all the iterators have been added to the environment
        // already by initializeIterators().
        for (int i = 0, n = curr; i <= n; i++) {
            Variable<C, PM> iterDecl = iterators.get(i);
            String iterName = iterDecl.getName();
            if (i != curr)
                javaIters[i] = c.iterator();
            Object value = javaIters[i].next();
            myEvalEnv.replace(iterName, value);
        }
    }

    protected void removeIterators(List<Variable<C, PM>> iterators) {
        // remove the iterators from the environment
        for (int i = 0, n = iterators.size(); i < n; i++) {
            Variable<C, PM> iterDecl = iterators.get(i);
            String iterName = iterDecl.getName();
            myEvalEnv.remove(iterName);
        }
    }

    protected boolean moreToGo(int curr, int numIters) {
        if (done)
            return false;
        return curr < numIters;
    }
    
    protected void advanceTarget(Variable<EClassifier, EParameter> target, Object bodyVal) {
        if (target != null) {
            String varName = target.getName();
            myEvalEnv.replace(varName, bodyVal);
        }
    }

    protected void removeTarget(Variable<EClassifier, EParameter> target) {
        if (target != null) {
            String varName = target.getName();
            myEvalEnv.remove(varName);
        }
    }

    // override this method for different iterator behaviors
    protected abstract Object evaluateResult(List<Variable<C, PM>> iterators, String resultName, OCLExpression<EClassifier> conditionExp, Object bodyVal, boolean isOne);

    protected OCLStandardLibrary<C> getOCLStandardLibrary() {
        return myEvalVisitor.getEnvironment().getOCLStandardLibrary();
    }

    protected Object getOclInvalid() {
        return getOCLStandardLibrary().getOclInvalid();
    }
    
    protected Boolean isConditionOk(OCLExpression<EClassifier> conditionExp, Object bodyVal) {
        // evaluate the condition of the expression in this environment
        Object conditionVal = conditionExp.accept(myEvalVisitor);
        if (conditionVal instanceof Boolean) {
            return (Boolean) conditionVal;
        } else if (conditionVal instanceof EClassifier){
            @SuppressWarnings("unchecked")
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