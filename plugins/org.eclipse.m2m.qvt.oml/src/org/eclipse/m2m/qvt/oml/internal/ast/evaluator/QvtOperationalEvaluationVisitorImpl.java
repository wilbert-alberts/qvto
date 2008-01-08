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
package org.eclipse.m2m.qvt.oml.internal.ast.evaluator;

import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.qvt.oml.QvtPlugin;
import org.eclipse.m2m.qvt.oml.ast.environment.IVirtualOperationTable;
import org.eclipse.m2m.qvt.oml.ast.environment.ModelParameterExtent;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtEvaluationResult;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnv;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalFileEnv;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalStdLibrary;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.qvt.oml.emf.util.Logger;
import org.eclipse.m2m.qvt.oml.expressions.AltExp;
import org.eclipse.m2m.qvt.oml.expressions.AssertExp;
import org.eclipse.m2m.qvt.oml.expressions.AssignExp;
import org.eclipse.m2m.qvt.oml.expressions.BlockExp;
import org.eclipse.m2m.qvt.oml.expressions.ConfigProperty;
import org.eclipse.m2m.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.qvt.oml.expressions.Helper;
import org.eclipse.m2m.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.qvt.oml.expressions.Library;
import org.eclipse.m2m.qvt.oml.expressions.LocalProperty;
import org.eclipse.m2m.qvt.oml.expressions.LogExp;
import org.eclipse.m2m.qvt.oml.expressions.MappingBody;
import org.eclipse.m2m.qvt.oml.expressions.MappingCallExp;
import org.eclipse.m2m.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.qvt.oml.expressions.MappingParameter;
import org.eclipse.m2m.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.expressions.ModuleImport;
import org.eclipse.m2m.qvt.oml.expressions.ObjectExp;
import org.eclipse.m2m.qvt.oml.expressions.OperationBody;
import org.eclipse.m2m.qvt.oml.expressions.Property;
import org.eclipse.m2m.qvt.oml.expressions.Rename;
import org.eclipse.m2m.qvt.oml.expressions.ResolveExp;
import org.eclipse.m2m.qvt.oml.expressions.ResolveInExp;
import org.eclipse.m2m.qvt.oml.expressions.SeverityKind;
import org.eclipse.m2m.qvt.oml.expressions.SwitchExp;
import org.eclipse.m2m.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.qvt.oml.expressions.VariableInitExp;
import org.eclipse.m2m.qvt.oml.expressions.WhileExp;
import org.eclipse.m2m.qvt.oml.expressions.impl.ImperativeOperationImpl;
import org.eclipse.m2m.qvt.oml.expressions.impl.OperationBodyImpl;
import org.eclipse.m2m.qvt.oml.expressions.impl.PropertyImpl;
import org.eclipse.m2m.qvt.oml.expressions.impl.RenameImpl;
import org.eclipse.m2m.qvt.oml.internal.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.qvt.oml.library.EObjectEStructuralFeaturePair;
import org.eclipse.m2m.qvt.oml.library.IContext;
import org.eclipse.m2m.qvt.oml.library.LateResolveInTask;
import org.eclipse.m2m.qvt.oml.library.LateResolveTask;
import org.eclipse.m2m.qvt.oml.library.QvtResolveUtil;
import org.eclipse.m2m.qvt.oml.trace.EDirectionKind;
import org.eclipse.m2m.qvt.oml.trace.EMappingContext;
import org.eclipse.m2m.qvt.oml.trace.EMappingOperation;
import org.eclipse.m2m.qvt.oml.trace.EMappingParameters;
import org.eclipse.m2m.qvt.oml.trace.EMappingResults;
import org.eclipse.m2m.qvt.oml.trace.ETuplePartValue;
import org.eclipse.m2m.qvt.oml.trace.EValue;
import org.eclipse.m2m.qvt.oml.trace.Trace;
import org.eclipse.m2m.qvt.oml.trace.TraceFactory;
import org.eclipse.m2m.qvt.oml.trace.TraceRecord;
import org.eclipse.m2m.qvt.oml.trace.VarParameterValue;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.internal.OCLPlugin;
import org.eclipse.ocl.internal.evaluation.EvaluationVisitorImpl;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.ocl.util.Bag;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.osgi.util.NLS;

public class QvtOperationalEvaluationVisitorImpl
	extends EvaluationVisitorImpl<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter,
EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
implements QvtOperationalEvaluationVisitor {

    public QvtOperationalEvaluationVisitorImpl(QvtOperationalEnv env, QvtOperationalEvaluationEnv evalEnv) {
        super(env, evalEnv, evalEnv.createExtentMap(null));

        myEvalEnv = evalEnv;
    }    
    
    public static QvtOperationalEvaluationVisitor createVisitor(QvtOperationalEnv env, QvtOperationalEvaluationEnv evalEnv) {
    	return new QvtOperationalEvaluationVisitorImpl(env, evalEnv).createInterruptibleVisitor();
    }
            
	@Override
	public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> getEvaluationEnvironment() {
		return myEvalEnv;
	}
	
	public void setOperationalEvaluationEnv(QvtOperationalEvaluationEnv evalEnv) {
		myEvalEnv = evalEnv;
    }

    public IContext getContext() {
        return getOperationalEvaluationEnv().getContext();
    }

    public void setEntryPoint(ImperativeOperation operation) {
        myEntryPoint = operation;		
    }

    public Object visitAssignExp(final AssignExp assignExp) {
    	boolean isDeferred = false;    	
        // TODO: modify the following code for more complex l-values
        if (assignExp.getValue().size() == 1) {
        	isDeferred = QvtResolveUtil.hasDeferredRightSideValue(assignExp);
            if(isDeferred) {
            	String ownerName = assignExp.getLeft().getName();        	
                Object ownerObj = (ownerName == null ? getOperationalEvaluationEnv().peekObjectExpOwner() : getRuntimeValue(ownerName));
                if (ownerObj instanceof EObject) {
                    PropertyCallExp<EClassifier, EStructuralFeature> lvalueExp = (PropertyCallExp<EClassifier, EStructuralFeature>) assignExp.getLeft();
                    EStructuralFeature referredProperty = getRenamedProperty(lvalueExp.getReferredProperty());
                    getContext().setLastAssignmentLvalueEval(new EObjectEStructuralFeaturePair((EObject) ownerObj, referredProperty));
                }        	
            }        	
        }
                
        Object exprValue = null;
        for (OCLExpression<EClassifier> exp : assignExp.getValue()) {
            exprValue = exp.accept(getVisitor());
        }

        if(isDeferred) {
        	// the source of resolve calls has been evaluated above -> assignment of the left value is not executed now 
        	// but at deferred time in the end of the transformation
        	return null;
        }        
        
        QvtOperationalEvaluationEnv env = getOperationalEvaluationEnv();

        String ownerName = assignExp.getLeft().getName();
        if (false == assignExp.getLeft() instanceof PropertyCallExp) {
            EClassifier variableType = assignExp.getLeft().getType();
            Object oldValue = getRuntimeValue(ownerName);
            if (variableType instanceof CollectionType && !(variableType instanceof VoidType)
                    && oldValue instanceof Collection) {
                Collection<Object> oldOclCollection = (Collection<Object>) oldValue;
                Collection<Object> leftOclCollection;
                if (assignExp.isIsReset()) {
                    leftOclCollection = CollectionUtil.createNewCollectionOfSameKind(oldOclCollection);
                } else {
                    leftOclCollection = oldOclCollection;
                }

                if (exprValue instanceof Collection) {
                    leftOclCollection = CollectionUtil.union(leftOclCollection, (Collection<?>) exprValue);
                } else if (getCollectionKind(leftOclCollection) == CollectionKind.ORDERED_SET_LITERAL
                        || getCollectionKind(leftOclCollection) == CollectionKind.SEQUENCE_LITERAL) {
                    leftOclCollection = CollectionUtil.append(leftOclCollection, exprValue);
                } else {
                    leftOclCollection = CollectionUtil.including(leftOclCollection, exprValue);
                }

                replaceInEnv(ownerName, leftOclCollection, variableType);
            } else {
            	replaceInEnv(ownerName, exprValue, variableType);
            }
        } else {
            Object ownerObj = (ownerName == null ?
                    env.peekObjectExpOwner() : getRuntimeValue(ownerName));
            if (ownerObj instanceof EObject) {
                int oldIpPos = setCurrentEnvInstructionPointer(assignExp);
                final EObject owner = (EObject) ownerObj;
                //	            runSafe(new IRunnable() {
                //	                public void run() throws Exception {
                env.callSetter(
                        owner,
                        getRenamedProperty(((PropertyCallExp<EClassifier, EStructuralFeature>) assignExp.getLeft()).getReferredProperty()),
                        exprValue, isUndefined(exprValue), assignExp.isIsReset());
                //	                }
                //	            });
                setCurrentEnvInstructionPointer(oldIpPos);
            }
        }

        return exprValue;
    }

    public Object visitConfigProperty(ConfigProperty configProperty) {
        String stringValue = getOperationalEvaluationEnv().getConfigurationProperty(configProperty.getName());
        return getOperationalEvaluationEnv().createFromString(configProperty.getEType(), stringValue);
    }

    public Object visitHelper(Helper helper) {
        visitImperativeOperation(helper);

        return visitOperationBody(helper.getBody());
    }

    public Object visitImperativeOperation(ImperativeOperation imperativeOperation) {
        if (imperativeOperation.isIsBlackbox()) {
            throw new IllegalArgumentException(
                    "Blackbox rules are not supported: " + imperativeOperation.getName()); //$NON-NLS-1$
        }

        List<Object> args = getOperationalEvaluationEnv().getOperationArgs();
        Iterator<Object> argIt = args.iterator();

        QvtOperationalEvaluationEnv env = getOperationalEvaluationEnv();
        for (EParameter nextParam : imperativeOperation.getEParameters()) {
            if (!argIt.hasNext()) {
                throw new IllegalArgumentException("arguments mismatch: got" + args + ", expected " + //$NON-NLS-1$ //$NON-NLS-2$
                        imperativeOperation.getEParameters());
            }

            VarParameter param = (VarParameter) nextParam;
            Object arg = argIt.next();

            addToEnv(param.getName(), arg, param.getEType());
        }

        VarParameter context = imperativeOperation.getContext();
        if (!isNullOrVoidType(context)) {
            addToEnv(Environment.SELF_VARIABLE_NAME, env.getOperationSelf(), context.getEType());
        }


        return null;
    }

    public Object visitLibrary(Library library) {
        return null;
    }

    public Object visitLocalProperty(LocalProperty localProperty) {
        return localProperty.getExpression().accept(getVisitor());
    }

    public Object visitMappingBody(MappingBody mappingBody) {
        for (OCLExpression<EClassifier> initExp : mappingBody.getInitSection()) {
            initExp.accept(getVisitor());
        }

        Object result = createOrGetResult((MappingOperation) mappingBody.getOperation());

        Object bodyResult = visitOperationBody(mappingBody);
        if (bodyResult != null) {
            result = bodyResult;
        }

        // TODO investigate possibility to modify result
        for (OCLExpression<EClassifier> endExp : mappingBody.getEndSection()) {
            endExp.accept(getVisitor());
        }

        return result;
    }

    public Object visitMappingCallExp(MappingCallExp mappingCallExp) {
        return visitOperationCallExp(mappingCallExp);
    }

    @Override
    public Object visitOperationCallExp(OperationCallExp<EClassifier, EOperation> operationCallExp) {
    	// set IP of the current stack (represented by the top operation env)
    	// to the this operation call in order to refeflect this call position 
    	// in possible QVT stack, in case an exception is thrown 
        int oldIpPos = setCurrentEnvInstructionPointer(operationCallExp);
        Object result = doVisitOperationCallExp(operationCallExp);    	        
        setCurrentEnvInstructionPointer(oldIpPos);
        return result;
    }    
    
    protected Object doVisitOperationCallExp(OperationCallExp<EClassifier, EOperation> operationCallExp) {
        EOperation referredOperation = operationCallExp.getReferredOperation();
        if (QvtOperationalUtil.isImperativeOperation(referredOperation)) {
            Object source = operationCallExp.getSource().accept(getVisitor());
            List<Object> args = makeArgs(operationCallExp);

            ImperativeOperation method = null;
            if (QvtOperationalParserUtil.isOverloadableMapping(referredOperation, getOperationalEnv())) {
                if (isUndefined(source)) {
                    return getOclInvalid();
                }
                	
            	if(source instanceof EObject) {
            		EClass sourceEClass = ((EObject)source).eClass();
            		IVirtualOperationTable vTable = getVirtualTable(referredOperation);
            		if(vTable != null) {
            			EOperation virtualOperation = vTable.lookupActualOperation(sourceEClass, getEnvironment());
            			if(virtualOperation instanceof ImperativeOperation) {
            				method = (ImperativeOperation) virtualOperation;
            			}
            		}            		
            	}
            }
            
    		if((method instanceof ImperativeOperation == false) && referredOperation instanceof ImperativeOperation) {
    			// we can't dispatch non-imperative as we already evaluated the source 
    			method = (ImperativeOperation)referredOperation;
    		}

            if(method != null) {
            	return executeImperativeOperation(method, source, args).myResult;
            }
        }

        Object result = null;
        try {
        	result = super.visitOperationCallExp(operationCallExp);
        }
        catch (QvtRuntimeException e) {
        	throw e;
		}
        catch (RuntimeException ex) {
            Logger.getLogger().log(Logger.WARNING, "QvtEvaluator: failed to evaluate oclOperationCall", ex);//$NON-NLS-1$
        	result = getOclInvalid();
        }
        return result;
    }
    
    @Override
    public Object visitPropertyCallExp(PropertyCallExp<EClassifier, EStructuralFeature> pc) {
    	EStructuralFeature renamedProperty = getRenamedProperty(pc.getReferredProperty());
    	if (renamedProperty != pc.getReferredProperty()) {
    		// TODO possible 'pc' should be cloned in case it's readonly
	        pc.setReferredProperty(renamedProperty);
    	}
    	return super.visitPropertyCallExp(pc);
    }
    
    @Override
    public Object visitEnumLiteralExp(EnumLiteralExp<EClassifier, EEnumLiteral> el) {
        return el.getReferredEnumLiteral().getInstance();
    }

    public Object visitMappingOperation(MappingOperation mappingOperation) {
        visitImperativeOperation(mappingOperation);

        OCLExpression<EClassifier> guard = (mappingOperation.getWhen().isEmpty() ? null : mappingOperation
                .getWhen().get(0));
        if (guard != null) {
            Object guardValue = guard.accept(getVisitor());
            if (false == guardValue instanceof Boolean
                    || !Boolean.TRUE.equals(guardValue)) {
                return null;
            }
        }

        // check the traces whether the relation already holds
        TraceRecord traceRecord = getTrace(getContext().getTrace(), mappingOperation);
        if (traceRecord != null) {
            if (traceRecord.getResult().getResult().isEmpty()) {
                return null;
            }
            return traceRecord.getResult().getResult().get(0).getValue().getOclObject(); // TODO : change it in case of multiple results
        }

        return ((OperationBodyImpl) mappingOperation.getBody()).accept(getVisitor());
    }

    public Object visitModule(Module module) {
		try {
			return doVisitModule(module);
		} 
		catch (QvtRuntimeException e) {
			PrintWriter printWriter = QvtOperationalStdLibrary.getLogger(getContext());
			if(printWriter == null) {
				printWriter = new PrintWriter(System.err);
			}
			
			e.printQvtStackTrace(printWriter);
			throw e;
		}
    }
    
    public Object doVisitModule(Module module) {
    	isInTerminatingState = false;
        if (myEntryPoint == null) {
            myEntryPoint = (ImperativeOperation) module.getEntry();
        }

        if (myEntryPoint == null) {
            throw new IllegalArgumentException(NLS.bind(
                    EvaluationMessages.ExtendedOclEvaluatorVisitorImpl_ModuleNotExecutable, module.getName()));
        }

        if (myRootModule == null) {
            myRootModule = module;
            //PackageRef[] metamodels = QvtOperationalParserUtil.getRequiredMetamodelIds(myRootModule);
            //myInheritanceTree = new InheritanceTree(getOperationalEnv(), new EmfClassifierProvider(getOperationalEnv()), metamodels);
        }

        initAllModuleDefaultInstances(module, getOperationalEvaluationEnv());

        QvtOperationalEvaluationEnv evaluationEnv = getOperationalEvaluationEnv();
        QvtEvaluationResult evalResult = null;
        try {
	        evaluationEnv.createModuleParameterExtents(module);
	        // Note: called after model parameters initialized, as mapping call during property 
	        // intialisation will cause NPE
	        initModuleProperties(module);
	        setCurrentEnvInstructionPointer(myEntryPoint); // initialize IP to the main entry header

	        List<Object> entryArgs = makeEntryArgs(myEntryPoint, module);
	        OperationCallResult callResult = executeImperativeOperation(myEntryPoint, null, entryArgs);
	        	        
	        isInTerminatingState = true;
	        getContext().processDeferredTasks();	        
	
			ResourceSet outResourceSet = EmfUtil.getOutputResourceSet();
	        evalResult = callResult.myEvalEnv.createEvaluationResult(myEntryPoint, outResourceSet);
	        if (evalResult.getModelExtents().isEmpty()) {
	            if (callResult.myResult instanceof EObject) {
	                // compatibility reason
	            	ModelParameterExtent modelParameter = new ModelParameterExtent((EObject) callResult.myResult);
	                evalResult.getModelExtents().add(modelParameter.getModelExtent(outResourceSet));
	            } else {
	                return callResult.myResult;
	            }
	        }
        }
        finally {
        	evaluationEnv.dispose();
        }
        
        return evalResult;
    }

	public Object visitModuleImport(ModuleImport moduleImport) {
        return null;
    }

    public Object visitObjectExp(ObjectExp objectExp) {
        Object owner = getOutOwner(objectExp);

        getOperationalEvaluationEnv().pushObjectExpOwner(owner);
        for (OCLExpression<EClassifier> exp : objectExp.getContent()) {
            exp.accept(getVisitor());
        }
        getOperationalEvaluationEnv().popObjectExpOwner();

        return owner;
    }

    public Object visitOperationBody(OperationBody operationBody) {
        Object result = null;
        for (OCLExpression<EClassifier> exp : operationBody.getContent()) {
            result = exp.accept(getVisitor());
        }
        return result;
    }

    public Object visitProperty(Property property) {
        return null;
    }

    public Object visitRename(Rename rename) {
        EClassifier context = rename.getEType();

        // if source is undefined, result is OclInvalid
        if (isUndefined(context))
            return getOclInvalid();

        EStructuralFeature origProperty = getEnvironment().lookupProperty(rename.getEType(), rename.getName());
        return origProperty;
    }

    public Object visitVarParameter(VarParameter varParameter) {
        return null;
    }

    public Object visitVariableInitExp(VariableInitExp variableInitExp) {
        Object varValue = variableInitExp.getValue().accept(getVisitor());
        replaceInEnv(variableInitExp.getName(), varValue, variableInitExp.getType());
        return varValue;
    }

    public Object visitBlockExp(BlockExp blockExp) {
        for (OCLExpression<EClassifier> exp : blockExp.getBody()) {
            exp.accept(getVisitor());
        }
        return null;
    }
    
    public Object visitWhileExp(WhileExp whileExp) {
        while (true) {
            Object condition = whileExp.getCondition().accept(getVisitor());
            if (Boolean.TRUE.equals(condition)) {
                for (OCLExpression<EClassifier> exp : whileExp.getBody()) {
                    exp.accept(getVisitor());
                }
            } else {
                break;
            }
        }

        return whileExp.getResult().accept(getVisitor());
    }
    
    public Object visitSwitchAltExp(AltExp switchAltExp) {
       Object condition = switchAltExp.getCondition().accept(getVisitor());
       if (Boolean.TRUE.equals(condition)) {
           switchAltExp.getBody().accept(getVisitor());
       }
       return condition;
    }

    public Object visitSwitchExp(SwitchExp switchExp) {
        for (AltExp altExp : switchExp.getAlternativePart()) {
            if (Boolean.TRUE.equals(altExp.accept(getVisitor()))) {
                return null;
            }
        }
        OCLExpression<EClassifier> elsePart = switchExp.getElsePart();
        if (elsePart != null) {
            elsePart.accept(getVisitor());
            return null;
        }
        return null;
    }

    /* resolve expressions family */

    public Object visitResolveExp(ResolveExp resolveExp) {
    	if (resolveExp.isIsDeferred() && !isInTerminatingState) {    	
            LateResolveTask lateResolveTask = new LateResolveTask(resolveExp, getContext().getLastAssignmentLvalueEval(), getQVTVisitor(), getOperationalEvaluationEnv());
            lateResolveTask.schedule();
            return null;
        }
        return QvtResolveUtil.resolveNow(resolveExp, this, getOperationalEvaluationEnv());
    }
    
    public Object visitResolveInExp(ResolveInExp resolveInExp) {
        if (resolveInExp.isIsDeferred() && !isInTerminatingState) {        	
            LateResolveInTask lateResolveInTask = new LateResolveInTask(resolveInExp, getContext().getLastAssignmentLvalueEval(), getQVTVisitor(), getOperationalEvaluationEnv());
            lateResolveInTask.schedule();
            return null;
        }        
        return QvtResolveUtil.resolveInNow(resolveInExp, this, getOperationalEvaluationEnv());
    }
    
	public Object visitModelType(ModelType modelType) {
		return null;
	}
    
	public Object visitLogExp(LogExp logExp) {
		PrintWriter logger = QvtOperationalStdLibrary.getLogger(getContext());
		if(logger != null) {
			if(doVisitLogExp(logExp, logger)) {
				logger.println();
			}
		}
		return null;
	}
	
	private boolean doVisitLogExp(LogExp logExp, PrintWriter logger) {
		if(logExp.getCondition() != null && 
			!Boolean.TRUE.equals(logExp.getCondition().accept(getVisitor()))) {
			return false;
		}
		
		EList<OCLExpression<EClassifier>> args = logExp.getArgument();
		if(args.size() > 2) {
			Object level = args.get(2).accept(getVisitor());
			logger.print("Level " + level + " - "); //$NON-NLS-1$ //$NON-NLS-2$
		}
		
		Object message = args.get(0).accept(getVisitor());
		logger.print(message);

		if(args.size() > 1) {
			Object element = args.get(1).accept(getVisitor());
			logger.print(", data: "); //$NON-NLS-1$
			logger.print(String.valueOf(element));
		}
		
		return true;
	}
	
	public Object visitAssertExp(AssertExp assertExp) {
		if(assertExp.getAssertion() != null && 
				!Boolean.TRUE.equals(assertExp.getAssertion().accept(getVisitor()))) {
			setCurrentEnvInstructionPointer(assertExp);			
		
			PrintWriter logger = QvtOperationalStdLibrary.getLogger(getContext());
			if(logger != null) {
				EObject parent = assertExp;				
				while(parent != null && !(parent instanceof Module)) {
					parent = parent.eContainer();
					if(parent instanceof ImperativeOperation) {
						parent = QvtOperationalParserUtil.getOwningModule((ImperativeOperation) parent);
					}
				}
				
				String source = EvaluationMessages.UknownSourceLabel;				
				if(parent != null) {
					String moduleName = ((Module)parent).getName();
					if(moduleName != null) {
						source = moduleName;
					}
				}
				
				StringBuilder locationBuf = new StringBuilder(source);
				if(assertExp.getLine() >= 0) {
					locationBuf.append(':').append(assertExp.getLine());
				}
				String message = NLS.bind(EvaluationMessages.AssertFailedMessage, assertExp.getSeverity(), locationBuf.toString());
				logger.print(message);
				if(assertExp.getLog() != null) {
					logger.print(" : "); //$NON-NLS-1$
					doVisitLogExp(assertExp.getLog(), logger);
				}
				
				logger.println();
				if(SeverityKind.FATAL.equals(assertExp.getSeverity())) {
					logger.println(EvaluationMessages.TerminatingExecution);
				}
			}
			
			if(SeverityKind.FATAL.equals(assertExp.getSeverity())) {				
				throwQvtException(new QvtAssertionFailed(EvaluationMessages.FatalAssertionFailed));
			}
		}
		
		return null;
	}
    
    private void initModuleProperties(Module module) {
        for (ModuleImport imp : module.getModuleImport()) {
            initModuleProperties(imp.getImportedModule());
        }

        QvtOperationalEvaluationEnv env = getOperationalEvaluationEnv();
        for (Property prop : module.getConfigProperty()) {
        	setCurrentEnvInstructionPointer(prop);
        	
            Object propValue = ((PropertyImpl) prop).accept(getVisitor());
            EObject moduleInstance = getModuleDefaultInstance(module, env);
            env.callSetter(moduleInstance, module.getEStructuralFeature(prop.getName()), propValue, isUndefined(propValue), true);
            
        	setCurrentEnvInstructionPointer(null);
        }
        
        for (Rename rename : module.getOwnedRenaming()) {
            ((RenameImpl) rename).accept(getVisitor());
        }
    }
    
    private EObject getModuleDefaultInstance(Module moduleClass, QvtOperationalEvaluationEnv env) {
    	return (EObject)env.getValueOf(moduleClass.getName() + QvtOperationalFileEnv.THIS_VAR_QNAME_SUFFIX);
    }
    
    private EObject createModuleDefaultInstance(Module moduleClass, QvtOperationalEvaluationEnv env) {
    	EObject instance = ModuleInstanceFactory.eINSTANCE.create(moduleClass);
    	// use replace as multiple imports of the same module might happen
    	env.replace(moduleClass.getName() + QvtOperationalFileEnv.THIS_VAR_QNAME_SUFFIX, instance);
    	return instance;
    }    

    private void initAllModuleDefaultInstances(Module module, QvtOperationalEvaluationEnv env) {
    	createModuleDefaultInstance(module, env);
		for (ModuleImport moduleImport : module.getModuleImport()) {
			if(moduleImport.getModule() != null) {
				Module importedModule = moduleImport.getImportedModule();
				initAllModuleDefaultInstances(importedModule, getOperationalEvaluationEnv());
			}
		}
    }        
    
	private IVirtualOperationTable getVirtualTable(EOperation operation) {
		return IVirtualOperationTable.Access.INSTANCE.getVirtualTable(operation);
	}
    
    private Object createOrGetResult(MappingOperation mappingOperation) {
    	QvtOperationalEvaluationEnv env = getOperationalEvaluationEnv();
        Object result = getRuntimeValue(Environment.RESULT_VARIABLE_NAME);
        if (isUndefined(result)) { // if nothing was assigned to the result in the init section
            VarParameter type = (mappingOperation.getResult().isEmpty() ? null : mappingOperation.getResult().get(0));
            if (type != null && false == type.getEType() instanceof VoidType) {
                result = createInstance(type.getEType(), ((MappingParameter) type).getExtent());
                env.replace(Environment.RESULT_VARIABLE_NAME, result);
            }
        }
        addTraces(mappingOperation);
        return result;
    }

    private TraceRecord getTrace(Trace trace, MappingOperation mappingOperation) {
        EMap<MappingOperation, EList<TraceRecord>> allTraceRecordMap = trace.getTraceRecordMap();
        EList<TraceRecord> traceRecords = allTraceRecordMap.get(mappingOperation);
        if (traceRecords == null) {
            return null;
        }

        QvtOperationalEvaluationEnv env = getOperationalEvaluationEnv();

        traceCheckCycle:
            for (TraceRecord traceRecord : traceRecords) {
                if (!isNullOrVoidType(mappingOperation.getContext())) {
                    if (traceRecord.getContext().getContext() == null) {
                        continue;
                    }
                    Object context = env.getValueOf(Environment.SELF_VARIABLE_NAME);
                    if (!isOclEqual(context, traceRecord.getContext().getContext().getValue().getOclObject())) {
                        continue;
                    }
                }
                int candidateParamSize = mappingOperation.getEParameters().size();
                if (traceRecord.getParameters().getParameters().size() != candidateParamSize) {
                    continue;
                }
                for (int i = 0; i < candidateParamSize; i++) {
                    EParameter param = mappingOperation.getEParameters().get(i);
                    Object paramValue = env.getValueOf(param.getName());
                    VarParameterValue traceParamVal = (VarParameterValue) traceRecord.getParameters().getParameters().get(i);
                    if (!isOclEqual(paramValue, traceParamVal.getValue().getOclObject())) {
                        continue traceCheckCycle;
                    }
                }
                return traceRecord;
            }
        return null;
    }

    private static boolean isOclEqual(Object candidateObject, Object traceObject) {
        if (candidateObject == traceObject) {
            return true;
        }
        if (QvtOperationalUtil.isUndefined(candidateObject)) {
            return QvtOperationalUtil.isUndefined(traceObject);
        }
        if ((candidateObject == null) || (traceObject == null)) {
            return false;
        }
        return candidateObject.equals(traceObject); // Overridden equals() is implied
    }
    
    private static boolean isNullOrVoidType(ETypedElement eTypedElement) {
        return (eTypedElement == null) || (eTypedElement.getEType() instanceof Module);
    }

    private TraceRecord addTraces(MappingOperation mappingOperation) {
        TraceRecord traceRecord = TraceFactory.eINSTANCE.createTraceRecord();
        Trace trace = getContext().getTrace();
        EList<TraceRecord> list = createOrGetListElementFromMap(trace.getTraceRecordMap(), mappingOperation);
        list.add(traceRecord);
        trace.getTraceRecords().add(traceRecord);
        EMappingOperation eMappingOperation = TraceFactory.eINSTANCE.createEMappingOperation();
        traceRecord.setMappingOperation(eMappingOperation);
        eMappingOperation.setName(mappingOperation.getName());
        Module module = QvtOperationalParserUtil.getOwningModule(mappingOperation);
        eMappingOperation.setPackage(module.getNsPrefix());
        eMappingOperation.setModule(module.getName());
        eMappingOperation.setRuntimeMappingOperation(mappingOperation);

        EMappingContext eMappingContext = TraceFactory.eINSTANCE.createEMappingContext();
        traceRecord.setContext(eMappingContext);
        if(!isNullOrVoidType(mappingOperation.getContext())) {
            VarParameterValue contextVPV = createVarParameterValue(mappingOperation,
                    mappingOperation.getContext().getKind(), mappingOperation.getContext().getEType(), Environment.SELF_VARIABLE_NAME);
            eMappingContext.setContext(contextVPV);
            EList<TraceRecord> contextMappings = createOrGetListElementFromMap(trace.getSourceToTraceRecordMap(), contextVPV.getValue().getOclObject());
            contextMappings.add(traceRecord);
        }
        else if(!mappingOperation.getEParameters().isEmpty()) {
        	// make the first in parameter as the mapping source object
        	for (EParameter nextEParam : mappingOperation.getEParameters()) {
        		if(nextEParam instanceof VarParameter) {
        			VarParameter firstInVarParam = (VarParameter) nextEParam;
        			if((firstInVarParam.getEType() instanceof PredefinedType == false) && (firstInVarParam.getKind() == DirectionKind.IN || firstInVarParam.getKind() == DirectionKind.INOUT)) {
        				Object val = createVarParameterValue(mappingOperation, firstInVarParam.getKind() ,
        							firstInVarParam.getEType(), firstInVarParam.getName()).getValue().getOclObject();        	
        				EList<TraceRecord> sourceMappings = createOrGetListElementFromMap(trace.getSourceToTraceRecordMap(), val);
        				sourceMappings.add(traceRecord);
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
                    varParameter.getEType(), varParameter.getName());
            eMappingParameters.getParameters().add(paramVPV);
        }

        EMappingResults eMappingResults = TraceFactory.eINSTANCE.createEMappingResults();
        traceRecord.setResult(eMappingResults);

        if (!mappingOperation.getResult().isEmpty()) {
            if (mappingOperation.getResult().size() == 1) {
                VarParameter resultElement = mappingOperation.getResult().get(0);
                VarParameterValue resultVPV = createVarParameterValue(mappingOperation, DirectionKind.OUT,
                        resultElement.getEType(), Environment.RESULT_VARIABLE_NAME);
                eMappingResults.getResult().add(resultVPV);
                EList<TraceRecord> resultMappings = createOrGetListElementFromMap(trace.getTargetToTraceRecordMap(), resultVPV.getValue().getOclObject());
                resultMappings.add(traceRecord);
            } else {
                throw new UnsupportedOperationException("Multiple results unsupported yet!"); //$NON-NLS-1$
            }
        }

        return traceRecord;
    }

    private VarParameterValue createVarParameterValue(MappingOperation mappingOperation, DirectionKind kind, EClassifier type, String name) {
        VarParameterValue varParameterValue = TraceFactory.eINSTANCE.createVarParameterValue();
        varParameterValue.setKind(getDirectionKind(kind));
        varParameterValue.setName(name);
        varParameterValue.setType(type.getName());
        Object oclObject = getEvaluationEnvironment().getValueOf(name);
        varParameterValue.setValue(createEValue(oclObject));
        return varParameterValue;
    }

    @SuppressWarnings("unchecked") //$NON-NLS-1$
    private EValue createEValue(Object oclObject) {
        EValue value = TraceFactory.eINSTANCE.createEValue();
        value.setOclObject(oclObject);
        if (oclObject != null) {
            if (oclObject instanceof Collection) {
                Collection<Object> oclCollection = (Collection<Object>) oclObject;
                // TODO: Write a test for checking collections
                value.setCollectionType("OclCollection"); //$NON-NLS-1$
                for (Object collectionElement : oclCollection) {
                    value.getCollection().add(createEValue(collectionElement));
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

    private static class OperationCallResult {
    	public Object myResult;
    	public QvtOperationalEvaluationEnv myEvalEnv;
    }

    
    private OperationCallResult executeImperativeOperation(ImperativeOperation method, Object source, List<Object> args) {
        QvtOperationalEvaluationEnv oldEvalEnv = getOperationalEvaluationEnv();
        // create a nested evaluation environment for this operation call
        QvtOperationalEvaluationEnv nestedEnv = getOperationalEnv().getFactory().createEvaluationEnvironment(
        		oldEvalEnv.getContext(), oldEvalEnv);
        // No need now to pass properties as variables, as they are accessed as module features
        //addModuleProperties(nestedEnv, (Module)method.eContainer());

        nestedEnv.setOperation(method);
        
        nestedEnv.getOperationArgs().addAll(args);
        if (!isUndefined(source)) {
            nestedEnv.setOperationSelf(source);
        }
        setOperationalEvaluationEnv(nestedEnv);
        
        // set IP initially to the method header
        setCurrentEnvInstructionPointer(method); 

        OperationCallResult callResult = null;
        try {
        	Object result = ((ImperativeOperationImpl) method).accept(getVisitor());
        	callResult = new OperationCallResult();
        	callResult.myResult = result;
        	callResult.myEvalEnv = nestedEnv;
        }
        catch (StackOverflowError e) {
        	throwQvtException(new QvtStackOverFlowError(e));
        }
        catch (QvtRuntimeException e) {
       		throw e;
        }
        catch (RuntimeException e) {
        	if (e.getLocalizedMessage() != null) {
        		throwQvtException(new QvtRuntimeException(e.getLocalizedMessage()));
        	}
        	else {
        		throwQvtException(new QvtRuntimeException(e));
        	}
        }
        finally {
        	setOperationalEvaluationEnv(oldEvalEnv);
        }
        
    	return callResult;
    }

    protected final void throwQvtException(QvtRuntimeException exception) throws QvtRuntimeException {
		throwQvtException(exception, null);
    }

    protected final void throwQvtException(QvtRuntimeException exception, ASTNode causingASTNode) throws QvtRuntimeException {
		QvtRuntimeException.doThrow(exception, createStackInfoProvider(getOperationalEvaluationEnv(), causingASTNode));
    }
    
    @SuppressWarnings("unchecked") //$NON-NLS-1$
	@Override
    protected Object call(EOperation operation, OCLExpression<EClassifier> body, Object target, Object[] args) {
    	if(target instanceof EObject) {
    		EObject eTarget = (EObject) target;
    		if(OCLAnnotationSupport.isDynamicInstance(eTarget)) {
    			if(operation.eClass() != eTarget.eClass()) {
    				// check if not overriden for a sub-class 
	    			EOperation actualOperation = getOCLAnnotationSupport().resolveDynamic(operation, eTarget);
	    			if(actualOperation != null && actualOperation != operation) {
	    				OCLExpression<EClassifier> actualOperBody = getOperationBody(actualOperation);
	    				
	    				if(actualOperBody != null) {
	    					Environment myEnv = getEnvironment();
	    					EnvironmentFactory factory = myEnv.getFactory();
	    			    	// create a nested evaluation environment for this operation call
	    			    	EvaluationEnvironment nested = factory.createEvaluationEnvironment(getEvaluationEnvironment());	    			    	
	    			    	// bind "self"
	    			    	nested.add(Environment.SELF_VARIABLE_NAME, target);	    			    	
	    			    	// add the parameter bindings to the local variables
	    			    	if (args.length > 0) {
	    			    		int i = 0;
	    			    		UMLReflection<?, ?, EOperation, ?, ?, EParameter, ?, ?, ?, ?> uml = myEnv.getUMLReflection();
	    			    		for (EParameter param : uml.getParameters(operation)) { 
	    			    			nested.add(uml.getName(param), args[i]);
	    			    		}
	    			    	}
	    			    	
	    			    	EvaluationVisitor visitor = factory.createEvaluationVisitor(myEnv, nested, getExtentMap());
	    			    	if(visitor instanceof QvtOperationalEvaluationVisitorImpl) {
	    			    		// ensure shared instance of oclAnnotationSupport to avoid repeated OCL parsing	    			    		
	    			    		((QvtOperationalEvaluationVisitorImpl)visitor).oclAnnotationSupport = getOCLAnnotationSupport();
	    			    	}

	    			    	return visitor.visitExpression(actualOperBody);
	    				}
	    			}
    			}
    		}
    	}
    	
    	return super.call(operation, body, target, args);
    }
    
    @SuppressWarnings("unchecked") //$NON-NLS-1$
	@Override
	protected Object navigate(EStructuralFeature property, OCLExpression<EClassifier> derivation, Object target) {
		Environment myEnv = getEnvironment(); 
		EnvironmentFactory factory = myEnv.getFactory();
    	// create a nested evaluation environment for this property call
    	EvaluationEnvironment nested = factory.createEvaluationEnvironment(getEvaluationEnvironment());    	
    	// bind "self"
    	nested.add(Environment.SELF_VARIABLE_NAME, target);
    	
    	EvaluationVisitor visitor = factory.createEvaluationVisitor(myEnv, nested, getExtentMap());
    	if(visitor instanceof QvtOperationalEvaluationVisitorImpl) {
    		// ensure shared instance of oclAnnotationSupport to avoid repeated OCL parsing
    		((QvtOperationalEvaluationVisitorImpl)visitor).oclAnnotationSupport = getOCLAnnotationSupport();
    	}

    	return visitor.visitExpression(derivation);
    }    

    @Override
    protected OCLExpression<EClassifier> getPropertyBody(EStructuralFeature property) {    	
    	if(OCLAnnotationSupport.isDynamicClassFeature(property)) {
    		return getOCLAnnotationSupport().getDerivedProperty(property);
    	}
    	
    	return super.getPropertyBody(property);
    }
        
	@Override
	protected OCLExpression<EClassifier> getOperationBody(EOperation operation) {
		if(OCLAnnotationSupport.isDynamicClassOperation(operation)) {			
			return getOCLAnnotationSupport().getBody(operation);
		}
		
		return super.getOperationBody(operation);
	}
    
	private OCLAnnotationSupport getOCLAnnotationSupport() {
		if(oclAnnotationSupport == null) {
			oclAnnotationSupport = new OCLAnnotationSupport();		
			
			oclAnnotationSupport.setErrorHandler(new OCLAnnotationSupport.ParseErrorHandler() {
				org.eclipse.ocl.ecore.OCLExpression invalidBodyExpr = EcoreFactory.eINSTANCE.createInvalidLiteralExp();
				
				public org.eclipse.ocl.ecore.OCLExpression handleError(ParserException parserException, EModelElement contextElement) {
					QvtPlugin.log(QvtPlugin.createErrorStatus("Failed to parse OCL annotation :" +  //$NON-NLS-1$
							getUMLReflection().getQualifiedName(contextElement) , parserException));

					return invalidBodyExpr;
				}
			});
		}
		return oclAnnotationSupport;
	}
	
    protected QvtOperationalEnv getOperationalEnv() {
        return (QvtOperationalEnv) getEnvironment();
    }

    public QvtOperationalEvaluationEnv getOperationalEvaluationEnv() {
        return (QvtOperationalEvaluationEnv) getEvaluationEnvironment();
    }
    
	/**
	 * Adds the given variable value into evaluation environment.
	 * 
	 * @param varName
	 *            the name of the variable
	 * @param value
	 *            the value of the variable
	 * @param declaredType
	 *            the type of the variable (optional) or <code>null</code>
	 */    
	protected void addToEnv(String varName, Object value, EClassifier declaredType) {
		getOperationalEvaluationEnv().add(varName, value);
	}
	
	/**
	 * Replaces the given variable value in evaluation environment.
	 * 
	 * @param varName
	 *            the name of the variable to replace
	 * @param value
	 *            the new value of the variable
	 * @param declaredType
	 *            the type of the variable (optional) or <code>null</code>
	 */
	protected void replaceInEnv(String varName, Object value, EClassifier declaredType) {
		getOperationalEvaluationEnv().replace(varName, value);
	}
	
    private Object getRuntimeValue(final String name) {
        return getEvaluationEnvironment().getValueOf(name);
    }

    private Object getOutOwner(final ObjectExp objectExp) {
        Object owner = getRuntimeValue(objectExp.getName());
        if (owner != null) {
            if (!oclIsKindOf(owner, objectExp.getType())) {
                throw new RuntimeException(MessageFormat.format(
                        EvaluationMessages.ExtendedOclEvaluatorVisitorImpl_InvalidObjectExpType, new Object[] {
                                objectExp.getName(), owner, objectExp.getType() }));
            }
        } else {
            final Object instance[] = new Object[] { null };
            //            runSafe(new IRunnable() {
            //                public void run() throws Exception {
            instance[0] = createInstance(objectExp.getType(), objectExp.getReferredObject());
            //                }
            //            });

            owner = instance[0];
        }

        return owner;
    }

    private static CollectionKind getCollectionKind(Collection<?> collection) {
        if (collection instanceof HashSet) {
            return CollectionKind.SET_LITERAL;
        }
        if (collection instanceof ArrayList) {
            return CollectionKind.SEQUENCE_LITERAL;
        }
        if (collection instanceof LinkedHashSet) {
            return CollectionKind.ORDERED_SET_LITERAL;
        }
        if (collection instanceof Bag) {
            return CollectionKind.BAG_LITERAL;
        }

        String message = OCLMessages.bind(OCLMessages.OCLCollectionKindNotImpl_ERROR_,
                CollectionKind.COLLECTION_LITERAL);
        IllegalArgumentException error = new IllegalArgumentException(message);
        OCLPlugin.throwing(CollectionUtil.class, "getCollectionKind", error);//$NON-NLS-1$
        throw error;
    }

    private List<Object> makeArgs(OperationCallExp<EClassifier, EOperation> operationCallExp) {
        List<Object> argValues = new ArrayList<Object>();
        for (OCLExpression<EClassifier> arg : operationCallExp.getArgument()) {
            Object value = arg.accept(getVisitor());
            argValues.add(value);
        }

        return argValues;
    }
    
	private List<Object> makeEntryArgs(ImperativeOperation entryPoint, Module module) {
		List<Object> args = new ArrayList<Object>(entryPoint.getEParameters().size());
		
		int paramIndex = 0;
		for (EParameter param : entryPoint.getEParameters()) {
			int matchedIndex = paramIndex;

			MappingParameter mappingParam = (MappingParameter) param;
			if (mappingParam.getKind() == DirectionKind.OUT) {
				args.add(null);
				continue;
			}
			
			if (mappingParam.getExtent() != null) {
				int modelParamIndex = 0;
		        for (ModelParameter modelParam : module.getModelParameter()) {
		        	if (modelParam == mappingParam.getExtent()) {
		        		matchedIndex = modelParamIndex;
		        		break;
		        	}
		        	modelParamIndex++;
		        }
			}

	        if (matchedIndex < getOperationalEvaluationEnv().getOperationArgs().size()) {
	        	args.add(getOperationalEvaluationEnv().getOperationArgs().get(matchedIndex));
	        }
			else {
                throw new IllegalArgumentException("entry operation arguments mismatch: no argument for " + mappingParam + " parameter"); //$NON-NLS-1$ //$NON-NLS-2$
			}

	        paramIndex++;
		}
		return args;
	}

    private EStructuralFeature getRenamedProperty(EStructuralFeature property) {
    	EAnnotation annotation = property.getEAnnotation(Environment.OCL_NAMESPACE_URI);
    	if (annotation != null) {
    		for (EObject nextAnn : annotation.getContents()) {
    			if (false == nextAnn instanceof Constraint) {
    				continue;
    			}
    			Constraint cnt = (Constraint) nextAnn;
    			if (QvtOperationalEnv.RENAMED_PROPERTY_STEREOTYPE.equals(cnt.getStereotype())
    					&& !cnt.getConstrainedElements().isEmpty()
    					&& cnt.getConstrainedElements().get(0) instanceof EStructuralFeature) {
    				return (EStructuralFeature) cnt.getConstrainedElements().get(0);
    			}
    		}
    	}
    	return property;
    }
    
    private QvtRuntimeException.StackInfoProvider createStackInfoProvider(final QvtOperationalEvaluationEnv topStackEnv, final ASTNode causingASTNode) {    	    	
    	return new QvtRuntimeException.StackInfoProvider() {    		
    		private List<StackTraceElement> elements;
    		
    		public List<StackTraceElement> getStackTraceElements() {
    			if(elements == null) {
    		    	int offset = (causingASTNode != null) ? causingASTNode.getStartPosition() : topStackEnv.getCurrentASTOffset();
    		    	if(offset < 0) {
    		    		offset = -1;
    		    	}
    				
    				elements = new QvtStackTraceBuilder(topStackEnv, getOperationalEnv().getUMLReflection(), myRootModule, offset).buildStackTrace();
    				return Collections.unmodifiableList(elements);
    			}
    			
    			return Collections.emptyList();
    		}
    	};
    }

    /**
	* Wraps the environment's creatInstance() and transforms failures to QVT exception
	*/    
	private EObject createInstance(EClassifier type, ModelParameter extent) throws QvtRuntimeException {
		EObject newInstance = null;
		try {
			newInstance = getOperationalEvaluationEnv().createInstance(type, extent);
		} catch (IllegalArgumentException e) {
			throwQvtException(new QvtRuntimeException(e));
		}
		
		return newInstance;
	}    
   
    private int setCurrentEnvInstructionPointer(ASTNode node) {
    	if(node != null) {
    		return getOperationalEvaluationEnv().setCurrentASTOffset(node.getStartPosition());
    	} else {
    		return getOperationalEvaluationEnv().setCurrentASTOffset(-1);
    	}
    }

    private int setCurrentEnvInstructionPointer(int pos) {
   		return getOperationalEvaluationEnv().setCurrentASTOffset(pos);
    }
    
    private QvtOperationalEvaluationVisitor createInterruptibleVisitor() {
    	final EvaluationMonitor monitor = (EvaluationMonitor)getContext().getProperties().get(EvaluationContextProperties.MONITOR);
    	
    	return new QvtGenericEvaluationVisitor.Any(this) {

    		public QvtOperationalEvaluationEnv getOperationalEvaluationEnv() {
    			return QvtOperationalEvaluationVisitorImpl.this.getOperationalEvaluationEnv();
    		}
    		
    		public void setOperationalEvaluationEnv(QvtOperationalEvaluationEnv evalEnv) {
    			QvtOperationalEvaluationVisitorImpl.this.setOperationalEvaluationEnv(evalEnv);
    		}
    		
    		public IContext getContext() {
    			return QvtOperationalEvaluationVisitorImpl.this.getContext();
    		}
    		
    		@Override
    		protected void genericVisitAny(Object object) {
    			if(monitor != null && monitor.isCanceled()) {
    				if(object instanceof ASTNode) {
    					throwQvtException(new QvtInterruptedExecutionException(), (ASTNode)object);
    				} else {
    					throwQvtException(new QvtInterruptedExecutionException());
    				}
    			}
    		}    		
    	};
    }
    
    /**
     * Performs cast on the result of {@link #getVisitor()}; 
     * @see #getVisitor()
     */
    protected QvtOperationalEvaluationVisitor getQVTVisitor() {
    	return (QvtOperationalEvaluationVisitor)getVisitor();
    }
        
    // allow to redefine "entry" point
    private ImperativeOperation myEntryPoint;
    private Module myRootModule;
    private QvtOperationalEvaluationEnv myEvalEnv;
    
    private OCLAnnotationSupport oclAnnotationSupport;
    private boolean isInTerminatingState = false;
    
}