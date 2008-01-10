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
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.qvt.oml.expressions.AssignExp;
import org.eclipse.m2m.qvt.oml.expressions.ResolveExp;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.DeferredAssignmentListener;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.QvtOperationalEvaluationVisitor;
import org.eclipse.m2m.qvt.oml.library.QvtResolveUtil.SavedSourceObjectHolder;

/**
 * @author aigdalov
 */

public abstract class AbstractLateResolveTask implements Runnable, SavedSourceObjectHolder {
    
    private final ResolveExp myResolveExp;
    private final QvtOperationalEvaluationVisitor myVisitor;
    private final QvtOperationalEvaluationEnv myEvalEnv;
    private final EObjectEStructuralFeaturePair myLvalue;
    private Object mySourceObj;
	private final DeferredAssignmentListener myListener;    

    public AbstractLateResolveTask(ResolveExp resolveExp, EObjectEStructuralFeaturePair lvalue, QvtOperationalEvaluationVisitor visitor,
            QvtOperationalEvaluationEnv evalEnv, DeferredAssignmentListener deferredListener) {
                myResolveExp = resolveExp;
                myLvalue = lvalue;
                myVisitor = visitor;
                myEvalEnv = evalEnv.cloneEvaluationEnv();
                
                if(myResolveExp.getSource() != null) {                	
                	mySourceObj = myResolveExp.getSource().accept(visitor);
                }             
                
                myListener = deferredListener;
    }
    
    public void run() {
        QvtOperationalEvaluationEnv oldEvalEnv = 
            myVisitor.getOperationalEvaluationEnv();
        myVisitor.setOperationalEvaluationEnv(myEvalEnv);
        Object resolveResult = getResolveResult();

        try {
            AssignExp assignExp = QvtResolveUtil.getDeferredAssignmentFor(myResolveExp);
            if(assignExp != null) {
            	myEvalEnv.callSetter(myLvalue.getEObject(), myLvalue.getEStructuralFeature(), 
            			resolveResult, QvtOperationalUtil.isUndefined(resolveResult), assignExp.isIsReset());
            	
            	if(myListener != null) {
            		myListener.notifyAfterDeferredAssign(assignExp, resolveResult);
            	}
            } else {
            	// there was not appropriate assignment to receive the value  
            }
        } finally {
        	myVisitor.setOperationalEvaluationEnv(oldEvalEnv);
        }
    }
    
    public void schedule() {
        myVisitor.getContext().addDeferredTask(this);
    }
    
    protected abstract Object getResolveResult();
    
    public ResolveExp getResolveExp() {
        return myResolveExp;
    }

    public QvtOperationalEvaluationVisitor getVisitor() {
        return myVisitor;
    }

    public QvtOperationalEvaluationEnv getEvalEnv() {
        return myEvalEnv;
    }

    public EObjectEStructuralFeaturePair getLvalue() {
        return myLvalue;
    }
    
    public Object getSourceObj() {
    	return mySourceObj;
	}
    
    public boolean isInDeferredExecution() {    
    	return true;
    }    
}