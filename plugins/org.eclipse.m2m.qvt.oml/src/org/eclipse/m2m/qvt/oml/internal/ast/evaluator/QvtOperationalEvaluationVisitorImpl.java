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

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtEvaluationResult;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnv;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalFileEnv;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalTypesUtil;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.qvt.oml.common.Logger;
import org.eclipse.m2m.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.DependencyHelper;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.IMetamodelDesc;
import org.eclipse.m2m.qvt.oml.expressions.AssignExp;
import org.eclipse.m2m.qvt.oml.expressions.ConfigProperty;
import org.eclipse.m2m.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.qvt.oml.expressions.ExtendedVisitor;
import org.eclipse.m2m.qvt.oml.expressions.Helper;
import org.eclipse.m2m.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.qvt.oml.expressions.Library;
import org.eclipse.m2m.qvt.oml.expressions.LocalProperty;
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
import org.eclipse.m2m.qvt.oml.expressions.PackageRef;
import org.eclipse.m2m.qvt.oml.expressions.Property;
import org.eclipse.m2m.qvt.oml.expressions.Rename;
import org.eclipse.m2m.qvt.oml.expressions.ResolveExp;
import org.eclipse.m2m.qvt.oml.expressions.ResolveInExp;
import org.eclipse.m2m.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.qvt.oml.expressions.VariableInitExp;
import org.eclipse.m2m.qvt.oml.expressions.WhileExp;
import org.eclipse.m2m.qvt.oml.expressions.impl.ImperativeOperationImpl;
import org.eclipse.m2m.qvt.oml.expressions.impl.OperationBodyImpl;
import org.eclipse.m2m.qvt.oml.expressions.impl.PropertyImpl;
import org.eclipse.m2m.qvt.oml.expressions.impl.RenameImpl;
import org.eclipse.m2m.qvt.oml.internal.ast.evaluator.InheritanceTree.IClassifierProvider;
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
import org.eclipse.m2m.qvt.oml.trace.EValue;
import org.eclipse.m2m.qvt.oml.trace.Trace;
import org.eclipse.m2m.qvt.oml.trace.TraceFactory;
import org.eclipse.m2m.qvt.oml.trace.TraceRecord;
import org.eclipse.m2m.qvt.oml.trace.VarParameterValue;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
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
import org.eclipse.ocl.types.VoidType;
import org.eclipse.ocl.util.Bag;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.osgi.util.NLS;

public class QvtOperationalEvaluationVisitorImpl
	extends EvaluationVisitorImpl<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter,
EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
implements ExtendedVisitor<Object, EObject, CallOperationAction, SendSignalAction, Constraint> {

    public QvtOperationalEvaluationVisitorImpl(QvtOperationalEnv env,
            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv) {
        super(env, evalEnv, evalEnv.createExtentMap(null));

        myEvalEnv = evalEnv;
    }

	@Override
	public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> getEvaluationEnvironment() {
		return myEvalEnv;
	}
	
	public void setEvaluationEnvironment(EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv) {
		myEvalEnv = evalEnv;
    }

    public IContext getContext() {
        return getOperationalEvaluationEnv().getContext();
    }

    public void setEntryPoint(ImperativeOperation operation) {
        myEntryPoint = operation;		
    }

    public Object visitAssignExp(final AssignExp assignExp) {
        // TODO: modify the following code for more complex lvalues
        if (assignExp.getValue().size() == 1) {
            OCLExpression<EClassifier> expression = assignExp.getValue().get(0);
            if (expression instanceof ResolveExp) {
                ResolveExp resolveExp = (ResolveExp) expression;
                if (resolveExp.isIsDeferred()) {
                    String ownerName = assignExp.getLeft().getName();
                    if (assignExp.getLeft() instanceof PropertyCallExp) {
                        Object ownerObj = (ownerName == null ?
                                getOperationalEvaluationEnv().peekObjectExpOwner() : getRuntimeValue(ownerName));
                        if (ownerObj instanceof EObject) {
                            PropertyCallExp<EClassifier, EStructuralFeature> lvalueExp = (PropertyCallExp<EClassifier, EStructuralFeature>) assignExp.getLeft();
                            EStructuralFeature referredProperty = getRenamedProperty(lvalueExp.getReferredProperty());
                            getContext().setLastAssignmentLvalueEval(new EObjectEStructuralFeaturePair((EObject) ownerObj, referredProperty));
                        }
                    }
                }
            }
        }
        
        Object exprValue = null;
        for (OCLExpression<EClassifier> exp : assignExp.getValue()) {
            exprValue = exp.accept(this);
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

                env.replace(ownerName, leftOclCollection);
            } else {
                env.replace(ownerName, exprValue);
            }
        } else {
            Object ownerObj = (ownerName == null ?
                    env.peekObjectExpOwner() : getRuntimeValue(ownerName));
            if (ownerObj instanceof EObject) {
                final EObject owner = (EObject) ownerObj;
                //	            runSafe(new IRunnable() {
                //	                public void run() throws Exception {
                env.callSetter(
                        owner,
                        getRenamedProperty(((PropertyCallExp<EClassifier, EStructuralFeature>) assignExp.getLeft()).getReferredProperty()),
                        exprValue, isUndefined(exprValue), assignExp.isIsReset());
                //	                }
                //	            });
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

            env.add(param.getName(), arg);
        }

        if (!isNullOrVoidType(imperativeOperation.getContext())) {
            env.add(Environment.SELF_VARIABLE_NAME, env.getOperationSelf());
        }


        return null;
    }

    public Object visitLibrary(Library library) {
        return null;
    }

    public Object visitLocalProperty(LocalProperty localProperty) {
        return localProperty.getExpression().accept(this);
    }

    public Object visitMappingBody(MappingBody mappingBody) {
        for (OCLExpression<EClassifier> initExp : mappingBody.getInitSection()) {
            initExp.accept(this);
        }

        Object result = createOrGetResult((MappingOperation) mappingBody.getOperation());

        Object bodyResult = visitOperationBody(mappingBody);
        if (bodyResult != null) {
            result = bodyResult;
        }

        // TODO investigate possibility to modify result
        for (OCLExpression<EClassifier> endExp : mappingBody.getEndSection()) {
            endExp.accept(this);
        }

        return result;
    }

    public Object visitMappingCallExp(MappingCallExp mappingCallExp) {
        return visitOperationCallExp(mappingCallExp);
    }

    @Override
    public Object visitOperationCallExp(OperationCallExp<EClassifier, EOperation> operationCallExp) {
        EOperation referredOperation = operationCallExp.getReferredOperation();
        if (QvtOperationalUtil.isImperativeOperation(referredOperation)) {
            Object source = operationCallExp.getSource().accept(this);
            List<Object> args = makeArgs(operationCallExp);

            ImperativeOperation method;
            if (QvtOperationalParserUtil.isOverloadableMapping(referredOperation, getOperationalEnv())) {
                if (isUndefined(source)) {
                    return getOclInvalid();
                }
                method = getVirtualMethod(referredOperation, source, args);
            } else {
            	EClassifier context = getOperationalEnv().getUMLReflection().getOwningClassifier(referredOperation);
				if(referredOperation instanceof ImperativeOperation) {
					method = (ImperativeOperation)referredOperation;
				} else {
                	Module owningModule = QvtOperationalParserUtil.getInnermostDefiningModule(myRootModule,
                        referredOperation, context, getOperationalEnv());
                	method = QvtOperationalParserUtil.findMappingMethod(owningModule, referredOperation, context, getOperationalEnv());
                }
            }

            return executeImperativeOperation(method, source, args).myResult;
        }

        Object result = null;
        try {
        	result = super.visitOperationCallExp(operationCallExp);
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
            Object guardValue = guard.accept(this);
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

        return ((OperationBodyImpl) mappingOperation.getBody()).accept(this);
    }

    public Object visitModule(Module module) {
        if (myEntryPoint == null) {
            myEntryPoint = (ImperativeOperation) module.getEntry();
        }

        if (myEntryPoint == null) {
            throw new IllegalArgumentException(NLS.bind(
                    EvaluationMessages.ExtendedOclEvaluatorVisitorImpl_ModuleNotExecutable, module.getName()));
        }

        if (myRootModule == null) {
            myRootModule = module;
            PackageRef[] metamodels = QvtOperationalParserUtil.getRequiredMetamodelIds(myRootModule);
            myInheritanceTree = new InheritanceTree(getOperationalEnv(), new EmfClassifierProvider(getOperationalEnv()), metamodels);
        }

        createModuleDefaultInstance(module, getOperationalEvaluationEnv());
        
        for (ModuleImport moduleImport : module.getModuleImport()) {
			if(moduleImport.getModule() != null) {
				Module importedModule = moduleImport.getImportedModule();
				createModuleDefaultInstance(importedModule, getOperationalEvaluationEnv());
			}
		}        
        
        initModuleProperties(module);
        getOperationalEvaluationEnv().createModuleParameterExtents(module);
        
        List<Object> entryArgs = makeEntryArgs(myEntryPoint, module);
        OperationCallResult callResult = executeImperativeOperation(myEntryPoint, null, entryArgs);
        
        getContext().processDeferredTasks();

		ResourceSet outResourceSet = new ResourceSetImpl();
        QvtEvaluationResult evalResult = callResult.myEvalEnv.createEvaluationResult(myEntryPoint, outResourceSet);
        if (evalResult.getModelExtents().isEmpty()) {
            if (callResult.myResult instanceof EObject) {
                // compatibility reason
                if (((EObject) callResult.myResult).eResource() != null) {
                	evalResult.getModelExtents().add(((EObject) callResult.myResult).eResource());
                }
                else {
                    Resource resource = outResourceSet.createResource(URI.createURI("/")); //$NON-NLS-1$
                    resource.getContents().add((EObject) callResult.myResult);
                    evalResult.getModelExtents().add(resource);
                }
            } else {
                return callResult.myResult;
            }
        }
        else if (!evalResult.getUnboundedObjects().isEmpty()) {
        	throw new RuntimeException(NLS.bind(
                    EvaluationMessages.ExtendedOclEvaluatorVisitorImpl_UnboundedObjects, evalResult.getUnboundedObjects().size()));
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
            exp.accept(this);
        }
        getOperationalEvaluationEnv().popObjectExpOwner();

        return owner;
    }

    public Object visitOperationBody(OperationBody operationBody) {
        Object result = null;
        for (OCLExpression<EClassifier> exp : operationBody.getContent()) {
            result = exp.accept(this);
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
        Object varValue = variableInitExp.getValue().accept(this);
        getEvaluationEnvironment().add(variableInitExp.getName(), varValue);
        return varValue;
    }

    public Object visitWhileExp(WhileExp whileExp) {
        while (true) {
            Object condition = whileExp.getCondition().accept(this);
            if (Boolean.TRUE.equals(condition)) {
                for (OCLExpression<EClassifier> exp : whileExp.getBody()) {
                    exp.accept(this);
                }
            } else {
                break;
            }
        }

        return whileExp.getResult().accept(this);
    }
    
    /* resolve expressions family */

    public Object visitResolveExp(ResolveExp resolveExp) {
        if (resolveExp.isIsDeferred()) {
            LateResolveTask lateResolveTask = new LateResolveTask(resolveExp, getContext().getLastAssignmentLvalueEval(), this, getOperationalEvaluationEnv());
            lateResolveTask.schedule();
            return null;
        }
        return QvtResolveUtil.resolveNow(resolveExp, this, getOperationalEvaluationEnv());
    }
    
    public Object visitResolveInExp(ResolveInExp resolveInExp) {
        if (resolveInExp.isIsDeferred()) {
            LateResolveInTask lateResolveInTask = new LateResolveInTask(resolveInExp, getContext().getLastAssignmentLvalueEval(), this, getOperationalEvaluationEnv());
            lateResolveInTask.schedule();
            return null;
        }
        return QvtResolveUtil.resolveInNow(resolveInExp, this, getOperationalEvaluationEnv());
    }
    
	public Object visitModelType(ModelType modelType) {
		return null;
	}
    
    
    private static class EmfClassifierProvider implements IClassifierProvider {

    	public EmfClassifierProvider(QvtOperationalEnv env) {
    		myEnv = env;
        }

        public EClassifier[] getAllClasses(PackageRef packageRef) throws EmfException {
            Set<EClassifier> classes = new HashSet<EClassifier>();

            EPackage pack;
            if (packageRef.getUri() != null) {
            	IMetamodelDesc desc = myEnv.getMetamodelRegistry().getMetamodelDesc(packageRef.getUri());
            	pack = (EPackage) desc.getModels()[0];
            }
            else {
            	ArrayList<String> packageName = new ArrayList<String>();
            	Collections.addAll(packageName, packageRef.getName().split(QvtOperationalTypesUtil.TYPE_NAME_SEPARATOR));
            	pack = myEnv.lookupPackage(packageName);
            }

            List<EPackage> packs = new ArrayList<EPackage>();
            packs.add(pack);
            packs.addAll(Arrays.asList(DependencyHelper.getReferencedPackages(pack)));

            for (Iterator<EPackage> packIt = packs.iterator(); packIt.hasNext();) {
                EPackage p = (EPackage) packIt.next();
                for (Iterator<EObject> contIt = p.eAllContents(); contIt.hasNext();) {
                    Object obj = contIt.next();
                    if (obj instanceof EClassifier == false) {
                        continue;
                    }
                    classes.add((EClassifier) obj);
                }
            }

            return classes.toArray(new EClassifier[classes.size()]);
        }

    	private final QvtOperationalEnv myEnv;
    	
    }

    private void initModuleProperties(Module module) {
        for (ModuleImport imp : module.getModuleImport()) {
            initModuleProperties(imp.getImportedModule());
        }

        QvtOperationalEvaluationEnv env = getOperationalEvaluationEnv();
        for (Property prop : module.getConfigProperty()) {
            Object propValue = ((PropertyImpl) prop).accept(this);
            EObject moduleInstance = getModuleDefaultInstance(module, env);
            env.callSetter(moduleInstance, module.getEStructuralFeature(prop.getName()), propValue, isUndefined(propValue), true);            
        }
        
        for (Rename rename : module.getOwnedRenaming()) {
            Object value = ((RenameImpl) rename).accept(this);
        }
    }
    
    private EObject getModuleDefaultInstance(Module moduleClass, QvtOperationalEvaluationEnv env) {
    	return (EObject)env.getValueOf(moduleClass.getName() + QvtOperationalFileEnv.THIS_VAR_QNAME_SUFFIX);
    }
    
    private EObject createModuleDefaultInstance(Module moduleClass, QvtOperationalEvaluationEnv env) {
    	EObject instance = ModuleInstanceFactory.eINSTANCE.create(moduleClass);
    	env.add(moduleClass.getName() + QvtOperationalFileEnv.THIS_VAR_QNAME_SUFFIX, instance);
    	return instance;
    }    

    private Object createOrGetResult(MappingOperation mappingOperation) {
    	QvtOperationalEvaluationEnv env = getOperationalEvaluationEnv();
        Object result = getRuntimeValue(Environment.RESULT_VARIABLE_NAME);
        if (isUndefined(result)) { // if nothing was assigned to the result in the init section
            VarParameter type = (mappingOperation.getResult().isEmpty() ? null : mappingOperation.getResult().get(0));
            if (type != null && false == type.getEType() instanceof VoidType) {
                result = env.createInstance(type.getEType(), ((MappingParameter) type).getExtent());
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

    @SuppressWarnings("unchecked")
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

        nestedEnv.getOperationArgs().addAll(args);
        if (!isUndefined(source)) {
            nestedEnv.setOperationSelf(source);
        }
        setEvaluationEnvironment(nestedEnv);

        try {
        	Object result = ((ImperativeOperationImpl) method).accept(this);
        	OperationCallResult callResult = new OperationCallResult();
        	callResult.myResult = result;
        	callResult.myEvalEnv = nestedEnv;
        	return callResult;
        } finally {
        	setEvaluationEnvironment(oldEvalEnv);
        }
    }

    protected QvtOperationalEnv getOperationalEnv() {
        return (QvtOperationalEnv) getEnvironment();
    }

    protected QvtOperationalEvaluationEnv getOperationalEvaluationEnv() {
        return (QvtOperationalEvaluationEnv) getEvaluationEnvironment();
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
            instance[0] = getOperationalEvaluationEnv().createInstance(objectExp.getType(), objectExp.getReferredObject());
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
            Object value = arg.accept(this);
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

    private ImperativeOperation getVirtualMethod(EOperation ctxOp, Object context, List<Object> args) {
        List<EClassifier> assignableClasses = new ArrayList<EClassifier>();
        try {
        	EClassifier ctxOwner = getOperationalEnv().getUMLReflection().getOwningClassifier(ctxOp);
            EClassifier[] derivedClasses = myInheritanceTree.getSortedDerivedClasses(ctxOwner);
            assignableClasses.addAll(Arrays.asList(derivedClasses));
            //assignableClasses.add(ctxOwner);
        } catch (EmfException e) {
            throw new RuntimeException(e);
        }

        for (EClassifier cls : assignableClasses) {
            EClassifier derived = cls;
//          if (!QvtOperationalParserUtil.isAssignableElementToFrom(dynamicType, derived)) {
//              continue;
//          }
            if (!derived.isInstance(context) && derived != getOperationalEnv().getOCLStandardLibrary().getOclAny()) {
                continue;
            }

            Module specificModule = QvtOperationalParserUtil.getOutermostDefiningModule(myRootModule, ctxOp, derived, getOperationalEnv());
            if (specificModule == null) {
                continue;
            }

            if (!isApplicable(getOperationalEnv(), ctxOp, context, args)) {
                continue;
            }

    		ImperativeOperation method = QvtOperationalParserUtil.findMappingMethod(specificModule, ctxOp, derived, getOperationalEnv());
            if (method == null) {
                throw new RuntimeException("Failed to find " + ctxOp + " in " + specificModule); //$NON-NLS-1$ //$NON-NLS-2$
            }

            return method;
        }

        throw new RuntimeException("Failed to find virtual method " + ctxOp); //$NON-NLS-1$
    }

    private boolean isApplicable(QvtOperationalEnv env, EOperation op, Object context, List<Object> args) {
    	EClassifier formalType = env.getUMLReflection().getOwningClassifier(op);
        if (getOperationalEnv().getOCLStandardLibrary().getOclAny() != formalType && !oclIsKindOf(context, formalType)) {
            return false;
        }

        if (args.size() != op.getEParameters().size()) {
            return false;
        }

        Iterator<Object> argIt = args.iterator();
        for (EParameter param : op.getEParameters()) {
            Object arg = argIt.next();
            EClassifier type = getUMLReflection().getOCLType(param.getEType());

            if (arg == getOclInvalid()) {
                return true;
            }
            if (!oclIsKindOf(arg, type)) {
                return false;
            }
        }

        return true;
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
    
    // allow to redefine "entry" point
    private ImperativeOperation myEntryPoint;
    private Module myRootModule;
    private InheritanceTree myInheritanceTree;
    private EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> myEvalEnv;

}