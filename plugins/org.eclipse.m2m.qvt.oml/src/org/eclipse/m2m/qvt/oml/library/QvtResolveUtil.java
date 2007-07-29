package org.eclipse.m2m.qvt.oml.library;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.qvt.oml.expressions.ResolveExp;
import org.eclipse.m2m.qvt.oml.expressions.ResolveInExp;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.QvtOperationalEvaluationVisitorImpl;
import org.eclipse.m2m.qvt.oml.trace.EMappingResults;
import org.eclipse.m2m.qvt.oml.trace.Trace;
import org.eclipse.m2m.qvt.oml.trace.TraceRecord;
import org.eclipse.m2m.qvt.oml.trace.VarParameterValue;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.util.CollectionUtil;

/**
 * @author aigdalov
 */

public class QvtResolveUtil {
    public static final Object resolveNow(ResolveExp resolveExp, QvtOperationalEvaluationVisitorImpl visitor, QvtOperationalEvaluationEnv env) {
        OCLExpression<EClassifier> source = resolveExp.getSource();
        if (source != null) {
            Trace trace = visitor.getContext().getTrace();
            EMap<Object, EList<TraceRecord>> map = chooseKeyToTraceRecordMap(resolveExp, trace);
            Object sourceEval = source.accept(visitor);
            EList<TraceRecord> traceRecords = map.get(sourceEval);
            if (traceRecords == null) {
                return createEmptyCollectionOrNull(resolveExp);
            }
            return searchByTypeAndCondition(resolveExp, traceRecords, visitor, env);
        }
        return null;
    }

    public static final Object resolveInNow(ResolveInExp resolveInExp, QvtOperationalEvaluationVisitorImpl visitor, QvtOperationalEvaluationEnv env) {
        OCLExpression<EClassifier> source = resolveInExp.getSource();
        List<TraceRecord> selectedTraceRecords = new ArrayList<TraceRecord>();
        Trace trace = visitor.getContext().getTrace();
        if (source == null) {
            EList<TraceRecord> traceRecords = trace.getTraceRecordMap().get(resolveInExp.getInMapping());
            if (traceRecords == null) {
                return createEmptyCollectionOrNull(resolveInExp);
            }
            selectedTraceRecords.addAll(traceRecords);
        } else {
            EMap<Object, EList<TraceRecord>> map = chooseKeyToTraceRecordMap(resolveInExp, trace);
            Object sourceEval = source.accept(visitor);
            EList<TraceRecord> traceRecords = map.get(sourceEval);
            if (traceRecords == null) {
                return createEmptyCollectionOrNull(resolveInExp);
            }
            for (TraceRecord traceRecord : traceRecords) {
                if (traceRecord.getMappingOperation().getRuntimeMappingOperation().equals(resolveInExp.getInMapping())) {
                    selectedTraceRecords.add(traceRecord);
                }
            }
        }
        return searchByTypeAndCondition(resolveInExp, selectedTraceRecords, visitor, env);
    }
    
    private static Object searchByTypeAndCondition(ResolveExp resolveExp, List<TraceRecord> traceRecords, QvtOperationalEvaluationVisitorImpl visitor, QvtOperationalEvaluationEnv env) {
        if (resolveExp.isOne()) {
            for (TraceRecord traceRecord : traceRecords) {
                EMappingResults results = traceRecord.getResult();
                if (resolveExp.isIsInverse()) {
                    if (traceRecord.getContext().getContext() != null) {
                        Object target = traceRecord.getContext().getContext().getValue().getOclObject();
                        if (!checkTypeAndCondition(resolveExp, target, visitor, env)) {
                            continue;
                        }
                        return target;
                    }
                } else {
                    for (VarParameterValue varParameterValue : results.getResult()) {
                        Object target = varParameterValue.getValue().getOclObject();
                        if (!checkTypeAndCondition(resolveExp, target, visitor, env)) {
                            continue;
                        }
                        return target;
                    }
                }
            }
            return null;
        } else {
            List<Object> sequence = CollectionUtil.createNewSequence();
            for (TraceRecord traceRecord : traceRecords) {
                EMappingResults results = traceRecord.getResult();
                if (resolveExp.isIsInverse()) {
                    if (traceRecord.getContext().getContext() != null) {
                        Object target = traceRecord.getContext().getContext().getValue().getOclObject();
                        if (!checkTypeAndCondition(resolveExp, target, visitor, env)) {
                            continue;
                        }
                        sequence.add(target);
                    }
                } else {
                    for (VarParameterValue varParameterValue : results.getResult()) {
                        Object target = varParameterValue.getValue().getOclObject();
                        if (!checkTypeAndCondition(resolveExp, target, visitor, env)) {
                            continue;
                        }
                        sequence.add(target);
                    }
                }
            }
            return sequence;
        }
    }
    
    private static EMap<Object, EList<TraceRecord>> chooseKeyToTraceRecordMap(ResolveExp resolveExp, Trace trace) {
        return resolveExp.isIsInverse() ? trace.getTargetToTraceRecordMap() : trace.getSourceToTraceRecordMap();
    }
    
    private static boolean checkTypeAndCondition(ResolveExp resolveExp, Object resolveCandidate, QvtOperationalEvaluationVisitorImpl visitor,
            QvtOperationalEvaluationEnv env) {
        if ((resolveExp.getTarget() != null) && (resolveExp.getTarget().getType() != null)) {
            EClassifier type = resolveExp.getTarget().getType();
            if (!type.isInstance(resolveCandidate)) { // TODO : Perhaps, this won't work on primitive datatypes
                return false;
            }
        }
        
        if (resolveExp.getCondition() != null) {
            if ((resolveExp.getTarget() != null) && (resolveExp.getTarget().getName() != null)) {
                env.add(resolveExp.getTarget().getName(), resolveCandidate);
            }
            Object conditionEval = resolveExp.getCondition().accept(visitor);
            if ((resolveExp.getTarget() != null) && (resolveExp.getTarget().getName() != null)) {
                env.remove(resolveExp.getTarget().getName());
            }
            return Boolean.TRUE.equals(conditionEval);
        }
        return true;
    }
    
    private static Object createEmptyCollectionOrNull(ResolveExp resolveExp) {
        if (resolveExp.isOne()) {
            return null;
        }
        return CollectionUtil.createNewSequence();
    }
}