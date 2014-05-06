/*******************************************************************************
 * Copyright (c) 2008, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Alex Paperno - bugs 424584
 *     Yuri Blankenstein - bug 428325
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.evaluator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.internal.qvt.oml.ast.env.InternalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.internal.qvt.oml.trace.EDirectionKind;
import org.eclipse.m2m.internal.qvt.oml.trace.EMappingContext;
import org.eclipse.m2m.internal.qvt.oml.trace.EMappingOperation;
import org.eclipse.m2m.internal.qvt.oml.trace.EMappingParameters;
import org.eclipse.m2m.internal.qvt.oml.trace.EMappingResults;
import org.eclipse.m2m.internal.qvt.oml.trace.ETuplePartValue;
import org.eclipse.m2m.internal.qvt.oml.trace.EValue;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceFactory;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;
import org.eclipse.m2m.internal.qvt.oml.trace.VarParameterValue;
import org.eclipse.m2m.qvt.oml.util.Dictionary;
import org.eclipse.m2m.qvt.oml.util.MutableList;
import org.eclipse.m2m.qvt.oml.util.Utils;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.util.Bag;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.ocl.utilities.PredefinedType;

public class TraceUtil {
	
	private TraceUtil() {
	}

	static TraceRecord getTraceRecord(QvtOperationalEvaluationEnv evalEnv, MappingOperation mappingOperation) {
		InternalEvaluationEnv internEnv = evalEnv.getAdapter(InternalEvaluationEnv.class);
		Trace trace = internEnv.getTraces();

		Object selfObj = evalEnv.getValueOf(Environment.SELF_VARIABLE_NAME);

		Object key = createKey(selfObj, evalEnv, mappingOperation);
		if (key != null) {
			TraceRecord record = trace.getRecordBySource(mappingOperation, key);
			if (record != null && Boolean.TRUE.equals(TraceUtil.checkResultMatch(record, evalEnv))) {
				return record;
			}
			// nothing found, mapping executed for the first time on the given
			// source
			return null;
		}

		// Fall back on 'original' TraceUtil
		return TraceUtil.getTraceRecordDefault(evalEnv, mappingOperation);
	}

    private static TraceRecord getTraceRecordDefault(QvtOperationalEvaluationEnv evalEnv, MappingOperation mappingOperation) {
    	InternalEvaluationEnv internEnv = evalEnv.getAdapter(InternalEvaluationEnv.class);    	
    	Trace trace = internEnv.getTraces();
        Object selfObj = evalEnv.getValueOf(Environment.SELF_VARIABLE_NAME);
    	
    	// the direct fetch by the contextual source object
    	if(selfObj != null && isParameterLessContextual(mappingOperation)) {
	    	TraceRecord record = trace.getRecordBySource(mappingOperation, selfObj);
	    	if(record != null && Boolean.TRUE.equals(checkResultMatch(record, evalEnv))) {
	    		return record;
	    	}
	    	// nothing found, mapping executed for the first time on the given source
	    	return null;
    	}

        EMap<MappingOperation, EList<TraceRecord>> allTraceRecordMap = trace.getTraceRecordMap();
        EList<TraceRecord> traceRecords = allTraceRecordMap.get(mappingOperation);
        if (traceRecords == null) {
            return null;
        }
        
        // Section [8.2.1.15]
        // After call resolution, all the parameters of the mapping are passed as a tuple. 
        // The parameters include, in this order: the context parameter (if any), the owned 
        // parameters (from Operation::ownedParameter), and the parameters declared as result.

        traceCheckCycle:
            for (TraceRecord nextRecord : traceRecords) {
            	// check context parameter
                if (QvtOperationalParserUtil.isContextual(mappingOperation)) {
                    VarParameterValue nextContext = nextRecord.getContext().getContext();
					if (nextContext == null) {
                        continue;
                    }
                    if (!isOclEqual(selfObj, nextContext.getValue().getOclObject(), mappingOperation.getContext().getKind(), evalEnv)) {
                        continue;
                    }
                }
                // check owned parameters
                int candidateParamSize = mappingOperation.getEParameters().size();
                if (nextRecord.getParameters().getParameters().size() != candidateParamSize) {
                    continue;
                }
                for (int i = 0; i < candidateParamSize; i++) {
                    EParameter param = mappingOperation.getEParameters().get(i);
                    Object paramValue = evalEnv.getValueOf(param.getName());
                    VarParameterValue traceParamVal = (VarParameterValue) nextRecord.getParameters().getParameters().get(i);
                    DirectionKind paramKind = DirectionKind.IN;
                    if (param instanceof VarParameter) {
                    	paramKind = ((VarParameter) param).getKind();
                    }
                    if (paramKind != DirectionKind.OUT
                    		&& !isOclEqual(paramValue, traceParamVal.getValue().getOclObject(), paramKind, evalEnv)) {
                        continue traceCheckCycle;
                    }
                }
                
                // check result parameters                
                Boolean checkResult = checkResultMatch(nextRecord, evalEnv);
                if(checkResult == null) {
                	continue;
                } else if(Boolean.FALSE.equals(checkResult)) {
                	continue traceCheckCycle;
                }
                
                return nextRecord;
            }
        return null;
    }
    
    static TraceRecord addTraceRecord(QvtOperationalEvaluationEnv evalEnv, MappingOperation mappingOperation) {
        TraceRecord traceRecord = TraceFactory.eINSTANCE.createTraceRecord();
        
        InternalEvaluationEnv internEnv = evalEnv.getAdapter(InternalEvaluationEnv.class);
        Trace trace = internEnv.getTraces();
        EList<TraceRecord> allRecList = createOrGetListElementFromMap(trace.getTraceRecordMap(), mappingOperation);        
        addUnique(traceRecord, allRecList);

        EMappingOperation eMappingOperation = TraceFactory.eINSTANCE.createEMappingOperation();
        traceRecord.setMappingOperation(eMappingOperation);
        eMappingOperation.setName(mappingOperation.getName());
        Module module = QvtOperationalParserUtil.getOwningModule(mappingOperation);
        eMappingOperation.setPackage(module.getNsPrefix());
        eMappingOperation.setModule(module.getName());
        eMappingOperation.setRuntimeMappingOperation(mappingOperation);

        EMappingContext eMappingContext = TraceFactory.eINSTANCE.createEMappingContext();
        traceRecord.setContext(eMappingContext);
        if(QvtOperationalParserUtil.isContextual(mappingOperation)) {
            VarParameter operContext = mappingOperation.getContext();
            VarParameterValue contextVPV = createVarParameterValue(mappingOperation,
                    operContext.getKind(), operContext.getEType(), Environment.SELF_VARIABLE_NAME, evalEnv);
            eMappingContext.setContext(contextVPV);
            EList<TraceRecord> contextMappings = createOrGetListElementFromMap(trace.getSourceToTraceRecordMap(), contextVPV.getValue().getOclObject());
            addUnique(traceRecord, contextMappings);
        }
        else if(!mappingOperation.getEParameters().isEmpty()) {
        	// make the first in parameter as the mapping source object
        	for (EParameter nextEParam : mappingOperation.getEParameters()) {
        		if(nextEParam instanceof VarParameter) {
        			VarParameter firstInVarParam = (VarParameter) nextEParam;
        			if((firstInVarParam.getEType() instanceof PredefinedType<?> == false) && (firstInVarParam.getKind() == DirectionKind.IN || firstInVarParam.getKind() == DirectionKind.INOUT)) {
        				Object val = createVarParameterValue(mappingOperation, firstInVarParam.getKind() ,
        							firstInVarParam.getEType(), firstInVarParam.getName(), evalEnv).getValue().getOclObject();        	
        				EList<TraceRecord> sourceMappings = createOrGetListElementFromMap(trace.getSourceToTraceRecordMap(), val);
        				addUnique(traceRecord, sourceMappings);
        				break;
        				
        			}
        		}
			}
        }
        
        EMappingParameters eMappingParameters = TraceFactory.eINSTANCE.createEMappingParameters();
        traceRecord.setParameters(eMappingParameters);
        for (EParameter param : mappingOperation.getEParameters()) {
            VarParameter varParameter = (VarParameter) param;
            VarParameterValue paramVPV = createVarParameterValue(mappingOperation, varParameter.getKind(),
                    varParameter.getEType(), varParameter.getName(), evalEnv);
            eMappingParameters.getParameters().add(paramVPV);
        }

        EMappingResults eMappingResults = TraceFactory.eINSTANCE.createEMappingResults();
        traceRecord.setResult(eMappingResults);

        EList<VarParameter> results = mappingOperation.getResult();
		if (!results.isEmpty()) {
            for(VarParameter resultPar : results) {
                String resultVarName = resultPar.getName();
                EClassifier resultElementType = resultPar.getEType();
            	
                VarParameterValue resultVPV = createVarParameterValue(mappingOperation, DirectionKind.OUT, resultElementType, resultVarName, evalEnv);
                eMappingResults.getResult().add(resultVPV);
                EList<TraceRecord> resultMappings = createOrGetListElementFromMap(trace.getTargetToTraceRecordMap(), resultVPV.getValue().getOclObject());
                addUnique(traceRecord, resultMappings);
            }
        }

		// Note: add it here so we ensure the record is fully initialized
        addUnique(traceRecord, trace.getTraceRecords());
        
        addTraceRecordByMapping(evalEnv, mappingOperation, traceRecord, trace);
        
        return traceRecord;
    }

	/**
	 * Improves performance a lot for mapping operations with parameters by
	 * means of (re)using the cache.
	 */
	private static void addTraceRecordByMapping(QvtOperationalEvaluationEnv evalEnv, MappingOperation mappingOperation,
			TraceRecord traceRecord, Trace trace) {
		Object selfObj = null;
		if (traceRecord.getContext() != null && traceRecord.getContext().getContext() != null) {
			EValue value = traceRecord.getContext().getContext().getValue();
			selfObj = value.getOclObject();
		}
		Object key = createKey(selfObj, evalEnv, mappingOperation);
		if (key != null) {
			trace.addRecordBySource(key, mappingOperation, traceRecord);
		}
	}

	/**
	 * Creates a key for mapping operations, based on the context (if available)
	 * and all parameters (if any).
	 */
	private static Object createKey(Object selfObj, QvtOperationalEvaluationEnv evalEnv, MappingOperation mappingOperation) {
		EList<EParameter> eParameters = mappingOperation.getEParameters();
		if (eParameters.isEmpty()) {
			// Backwards compatible for isParameterLessContextual
			return selfObj;
		}

		ArrayList<Object> key = new ArrayList<Object>(eParameters.size() + 1);
		key.add(selfObj);
		for (EParameter param : eParameters) {
			if (param instanceof VarParameter) {
				VarParameter varParam = (VarParameter) param;
				if (varParam.getKind() == DirectionKind.OUT) {
					continue;
				}
			}
			key.add(evalEnv.getValueOf(param.getName()));
		}

		return key;
	}

    static Object fetchResultFromTrace(QvtOperationalEvaluationEnv evalEnv, TraceRecord trace) {
    	MappingOperation operation = trace.getMappingOperation().getRuntimeMappingOperation();
    	EList<VarParameter> resultParams = operation.getResult();    	
    	if (resultParams.isEmpty()) {
            return null;
        }
    	
		Iterator<EParameter> itParams = operation.getEParameters().iterator();
		ListIterator<Object> itArgument = evalEnv.getOperationArgs().listIterator();
		Iterator<VarParameterValue> itValues = trace.getParameters().getParameters().iterator();
		while (itArgument.hasNext()) {
			MappingParameter mappingParam = (MappingParameter) itParams.next();
			VarParameterValue value = itValues.next();
			itArgument.next();
			if (mappingParam.getKind() != DirectionKind.OUT) {
				continue;
			}
			itArgument.set(value.getValue().getOclObject());
		}
    	
    	EList<VarParameterValue> traceResult = trace.getResult().getResult();    	
		if(resultParams.size() == 1) {
    		return traceResult.get(0).getValue().getOclObject();
    	}

		assert resultParams.size() > 1 && operation.getEType() instanceof TupleType<?, ?>;
    	@SuppressWarnings("unchecked")
    	TupleType<EClassifier, EStructuralFeature> tupleType = (TupleType<EClassifier, EStructuralFeature>)operation.getEType();
    	
    	HashMap<EStructuralFeature, Object> partValues = new HashMap<EStructuralFeature, Object>(2);		 
    	for (EStructuralFeature property : tupleType.oclProperties()) {
    		VarParameterValue paramValue = null;
    		for (VarParameterValue nextParamValue : traceResult) {
    			if(property.getName().equals(nextParamValue.getName())) {
    				paramValue = nextParamValue;
    				break;
    			}
    		}
    		
    		Object value = null;
    		if(paramValue != null && paramValue.getValue() != null) {
				value = paramValue.getValue().getOclObject();    				
    		}
    		partValues.put(property, value);
		}
    	
    	return evalEnv.createTuple(operation.getEType(), partValues);
    }
    
    
    private static VarParameterValue createVarParameterValue(MappingOperation mappingOperation, DirectionKind kind, EClassifier type, String name, QvtOperationalEvaluationEnv evalEnv) {
        VarParameterValue varParameterValue = TraceFactory.eINSTANCE.createVarParameterValue();
        varParameterValue.setKind(getDirectionKind(kind));
        varParameterValue.setName(name);
        varParameterValue.setType(type.getName());
        Object oclObject = evalEnv.getValueOf(name);
        varParameterValue.setValue(createEValue(oclObject));
        return varParameterValue;
    }

    @SuppressWarnings("unchecked")
    public static EValue createEValue(Object oclObject) {
        EValue value = TraceFactory.eINSTANCE.createEValue();
        value.setOclObject(cloneOclObject(oclObject));
        if (oclObject != null) {
            if (oclObject instanceof Dictionary) {
            	Dictionary<Object, Object> dict = (Dictionary<Object, Object>) oclObject;
                value.setCollectionType("Dictionary"); //$NON-NLS-1$
                for (Object dictKey : dict.keys()) {
                    ETuplePartValue tuplePartValue = TraceFactory.eINSTANCE.createETuplePartValue();
                    tuplePartValue.setName("key"); //$NON-NLS-1$
                    tuplePartValue.setValue(createEValue(dictKey));
                    value.getCollection().add(tuplePartValue);

                    Object dictValue = dict.get(dictKey);
                    tuplePartValue = TraceFactory.eINSTANCE.createETuplePartValue();
                    tuplePartValue.setName("value"); //$NON-NLS-1$
                    tuplePartValue.setValue(createEValue(dictValue));
                    value.getCollection().add(tuplePartValue);
                }
            } else if (oclObject instanceof Tuple) {
                Tuple<EOperation, EStructuralFeature> tuple = (Tuple<EOperation, EStructuralFeature>) oclObject;
                value.setCollectionType("Tuple"); //$NON-NLS-1$
                TupleType<EOperation, EStructuralFeature> tupleType = tuple.getTupleType();
                for (EStructuralFeature part : tupleType.oclProperties()) {
                    Object partValue = tuple.getValue(part);
                    ETuplePartValue tuplePartValue = TraceFactory.eINSTANCE.createETuplePartValue();
                    tuplePartValue.setName(part.getName());
                    EValue partEValue = createEValue(partValue);
                    tuplePartValue.setValue(partEValue);
                    value.getCollection().add(tuplePartValue);
                }
            } else if (oclObject instanceof Collection) {
                    Collection<Object> oclCollection = (Collection<Object>) oclObject;
                    // TODO: Write a test for checking collections
                    value.setCollectionType(getCollectionTypeName(oclCollection));
                    for (Object collectionElement : oclCollection) {
                        value.getCollection().add(createEValue(collectionElement));
                    }
            } else if (oclObject instanceof ModelInstance) {
                value.setCollectionType("ModelType"); //$NON-NLS-1$
                for (Object collectionElement : ((ModelInstance) oclObject).getExtent().getInitialObjects()) {
                    value.getCollection().add(createEValue(collectionElement));
                }
            } else if (oclObject instanceof EObject) {
                value.setModelElement((EObject) oclObject);
            } else {
                if (oclObject != null) {
                    value.setPrimitiveValue(oclObject.toString());
                }
            }
        }
        return value;
    }
    
    private static String getCollectionTypeName(Collection<?> c) {
    	String result = "OclCollection"; //$NON-NLS-1$
    	if (c instanceof MutableList<?>) {
    		result = "List"; //$NON-NLS-1$
    	} else if (c instanceof Dictionary<?, ?>) {
    		result = "Dictionary"; //$NON-NLS-1$
    	} else if (c instanceof Bag<?>) {
    		result = "Bag"; //$NON-NLS-1$
    	} else if (c instanceof LinkedHashSet<?>) {
    		result = "OrderedSet"; //$NON-NLS-1$
    	} else if (c instanceof Set<?>) {
    		result = "Set"; //$NON-NLS-1$
    	} else if (c instanceof ArrayList<?>) {
    		result = "Sequence"; //$NON-NLS-1$
    	}
    	return result;
    }

	private static Object cloneOclObject(Object obj) {
		return cloneOclObjectRec(obj, new IdentityHashMap<Object, Object>());
	}
	
    @SuppressWarnings("unchecked")
	private static Object cloneOclObjectRec(Object obj, Map<Object, Object> processed) {
    	if (obj instanceof MutableList<?>) {
        	if (processed.containsKey(obj)) {
        		return processed.get(obj);
        	}
        	
    		MutableList<Object> original = (MutableList<Object>) obj;
    		
    		MutableList<Object> result = Utils.createList();
    		processed.put(obj, result);

    		for (Object o : original) {
    			result.add(cloneOclObjectRec(o, processed));
    		}    		
    		return result;
    	}

    	if (obj instanceof Dictionary<?, ?>) {
        	if (processed.containsKey(obj)) {
        		return processed.get(obj);
        	}
        	
    		Dictionary<Object, Object> original = (Dictionary<Object, Object>) obj;
    		
    		Dictionary<Object, Object> result = Utils.createDictionary();
    		processed.put(obj, result);

    		for (Object k : original.keys()) {
    			result.put(cloneOclObjectRec(k, processed), cloneOclObjectRec(original.get(k), processed));
    		}    		
    		return result;
    	}
    	
    	return obj;
    }

    private static EDirectionKind getDirectionKind(DirectionKind kind) {
        if (kind == DirectionKind.IN) {
            return EDirectionKind.IN;
        } else if (kind == DirectionKind.INOUT) {
            return EDirectionKind.INOUT;
        } else if (kind == DirectionKind.OUT) {
            return EDirectionKind.OUT;
        }
        throw new RuntimeException("Wrong DirectionKind: " + kind.name()); //$NON-NLS-1$
    }
    
    private static <K, T> EList<T> createOrGetListElementFromMap(EMap<K, EList<T>> map, K key) {
        EList<T> list = map.get(key);
        if (list == null) {
            list = new BasicEList<T>();
            map.put(key, list);
            list = map.get(key);
        }
        return list;
    }

    private static boolean isOclEqual(Object candidateObject, Object traceObject, DirectionKind directionKind, QvtOperationalEvaluationEnv evalEnv) {
    	if (directionKind == DirectionKind.OUT) {
    		if (candidateObject == null) {
    			// yet not bound 'out' parameter, suit for any
    			return true;
    		}
    	}
        if (candidateObject == traceObject) {
            return true;
        }
        if (QvtOperationalUtil.isUndefined(candidateObject, evalEnv)) {
            return QvtOperationalUtil.isUndefined(traceObject, evalEnv);
        }
        if ((candidateObject == null) || (traceObject == null)) {
            return false;
        }
        return candidateObject.equals(traceObject); // Overridden equals() is implied
    }
    
    private static Boolean checkResultMatch(TraceRecord nextRecord, QvtOperationalEvaluationEnv evalEnv) {
        // check result parameters
        Object resultValue = evalEnv.getValueOf(Environment.RESULT_VARIABLE_NAME);
        if (resultValue != null) {
            List<Object> resultValues = new ArrayList<Object>(1); 
            if (resultValue instanceof Tuple<?, ?>) {
            	@SuppressWarnings("unchecked")
            	Tuple<EOperation, EStructuralFeature> tupleResult = (Tuple<EOperation, EStructuralFeature>) resultValue;
            	for (EStructuralFeature tupleFeature : tupleResult.getTupleType().oclProperties()) {
            		resultValues.add(tupleResult.getValue(tupleFeature));
            	}
            }
            else {
            	resultValues.add(resultValue);
            }
            if (nextRecord.getResult().getResult().size() != resultValues.size()) {
                return null;
            }
            for (int i = 0, n = resultValues.size(); i < n; i++) {
                Object paramValue = resultValues.get(i);
                VarParameterValue traceParamVal = (VarParameterValue) nextRecord.getResult().getResult().get(i);
                if (!isOclEqual(paramValue, traceParamVal.getValue().getOclObject(), DirectionKind.OUT, evalEnv)) {
                    return Boolean.FALSE;
                }
            }
        }    	
        
        return Boolean.TRUE;
    }
    
	private static boolean isParameterLessContextual(MappingOperation mappingOperation) {
		return QvtOperationalParserUtil.isContextual(mappingOperation) && mappingOperation.getEParameters().isEmpty();
	}
	
    private static void addUnique(TraceRecord record, EList<TraceRecord> recordList) {
        if(recordList instanceof AbstractEList<?>) {
        	// See https://bugs.eclipse.org/bugs/show_bug.cgi?id=287589 
        	AbstractEList<TraceRecord> basicRecList = (AbstractEList<TraceRecord>) recordList;
        	basicRecList.addUnique(record);
        } else {
        	// TODO - spit a trace warning
        	recordList.add(record);
        }    	
    }	
}
