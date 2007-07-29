package org.eclipse.m2m.qvt.oml.library;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.qvt.oml.expressions.AssignExp;
import org.eclipse.m2m.qvt.oml.expressions.ResolveExp;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.QvtOperationalEvaluationVisitorImpl;
import org.eclipse.ocl.EvaluationEnvironment;

/**
 * @author aigdalov
 */

public abstract class AbstractLateResolveTask implements Runnable {
    
    private final ResolveExp myResolveExp;
    private final QvtOperationalEvaluationVisitorImpl myVisitor;
    private final QvtOperationalEvaluationEnv myEvalEnv;
    private final EObjectEStructuralFeaturePair myLvalue;

    public AbstractLateResolveTask(ResolveExp resolveExp, EObjectEStructuralFeaturePair lvalue, QvtOperationalEvaluationVisitorImpl visitor,
            QvtOperationalEvaluationEnv evalEnv) {
                myResolveExp = resolveExp;
                myLvalue = lvalue;
                myVisitor = visitor;
                myEvalEnv = evalEnv.cloneEvaluationEnv();
    }

    public void run() {
        EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> oldEvalEnv = 
            myVisitor.getEvaluationEnvironment();
        myVisitor.setEvaluationEnvironment(myEvalEnv);
        Object resolveResult = getResolveResult();
        EObject parentExp = myResolveExp.eContainer();
        if (parentExp instanceof AssignExp) {
            AssignExp assignExp = (AssignExp) parentExp;
            myEvalEnv.callSetter(myLvalue.getEObject(), myLvalue.getEStructuralFeature()
                    , resolveResult, QvtOperationalUtil.isUndefined(resolveResult), assignExp.isIsReset());
        }
        myVisitor.setEvaluationEnvironment(oldEvalEnv);
    }
    
    public void schedule() {
        myVisitor.getContext().addDeferredTask(this);
    }
    
    protected abstract Object getResolveResult();
    
    public ResolveExp getResolveExp() {
        return myResolveExp;
    }

    public QvtOperationalEvaluationVisitorImpl getVisitor() {
        return myVisitor;
    }

    public QvtOperationalEvaluationEnv getEvalEnv() {
        return myEvalEnv;
    }

    public EObjectEStructuralFeaturePair getLvalue() {
        return myLvalue;
    }

}