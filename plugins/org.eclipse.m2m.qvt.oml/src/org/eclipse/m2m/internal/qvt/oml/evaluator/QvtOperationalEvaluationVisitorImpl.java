/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - bugs 302594, 309762, 310991, 325192, 377882, 388325, 392080, 392153, 394498, 397215, 397218
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.evaluator;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.NLS;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.IModuleSourceInfo;
import org.eclipse.m2m.internal.qvt.oml.ast.env.IVirtualOperationTable;
import org.eclipse.m2m.internal.qvt.oml.ast.env.InternalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelParameterExtent;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtEvaluationResult;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.ConstructorOperationAdapter;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.IntermediateClassFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.internal.qvt.oml.evaluator.TransformationInstance.InternalTransformation;
import org.eclipse.m2m.internal.qvt.oml.evaluator.iterators.QvtIterationTemplateCollectSelect;
import org.eclipse.m2m.internal.qvt.oml.evaluator.iterators.QvtIterationTemplateForExp;
import org.eclipse.m2m.internal.qvt.oml.evaluator.iterators.QvtIterationTemplateXCollect;
import org.eclipse.m2m.internal.qvt.oml.evaluator.iterators.QvtIterationTemplateXSelect;
import org.eclipse.m2m.internal.qvt.oml.expressions.Constructor;
import org.eclipse.m2m.internal.qvt.oml.expressions.ConstructorBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty;
import org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.EntryOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsPackage;
import org.eclipse.m2m.internal.qvt.oml.expressions.Helper;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeCallExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Library;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingCallExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport;
import org.eclipse.m2m.internal.qvt.oml.expressions.ObjectExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.expressions.ResolveExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ResolveInExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.impl.ImperativeOperationImpl;
import org.eclipse.m2m.internal.qvt.oml.expressions.impl.OperationBodyImpl;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.m2m.internal.qvt.oml.library.EObjectEStructuralFeaturePair;
import org.eclipse.m2m.internal.qvt.oml.library.LateResolveInTask;
import org.eclipse.m2m.internal.qvt.oml.library.LateResolveTask;
import org.eclipse.m2m.internal.qvt.oml.library.QvtResolveUtil;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandler;
import org.eclipse.m2m.internal.qvt.oml.stdlib.DictionaryImpl;
import org.eclipse.m2m.internal.qvt.oml.stdlib.MutableListImpl;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AltExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssertExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssignExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.BlockExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.BreakExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.CatchExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ComputeExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ContinueExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.DictLiteralExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.DictLiteralPart;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ForExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeIterateExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeLoopExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.InstantiationExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ListType;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.LogExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.OrderedTupleLiteralExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.OrderedTupleLiteralPart;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.RaiseExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ReturnExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.SeverityKind;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.SwitchExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.TryExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.UnlinkExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.UnpackExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.VariableInitExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.WhileExp;
import org.eclipse.m2m.qvt.oml.util.Dictionary;
import org.eclipse.m2m.qvt.oml.util.EvaluationMonitor;
import org.eclipse.m2m.qvt.oml.util.IContext;
import org.eclipse.m2m.qvt.oml.util.Log;
import org.eclipse.m2m.qvt.oml.util.MutableList;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.EvaluationVisitorImpl;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionLiteralPart;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.types.BagType;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.types.SetType;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.ocl.util.Bag;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.UMLReflection;

public class QvtOperationalEvaluationVisitorImpl
	extends EvaluationVisitorImpl<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter,
EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
implements QvtOperationalEvaluationVisitor, InternalEvaluator, DeferredAssignmentListener {	

	private static int tempCounter = 0;
	
    private QvtOperationalEvaluationEnv myEvalEnv;
    // FIXME - move me to the root environment?
    private OCLAnnotationSupport oclAnnotationSupport;

    public QvtOperationalEvaluationVisitorImpl(QvtOperationalEnv env, QvtOperationalEvaluationEnv evalEnv) {
        super(env, evalEnv, evalEnv.createExtentMap(null));

        myEvalEnv = evalEnv;
    }
    
	protected QvtOperationalEvaluationVisitorImpl(QvtOperationalEvaluationVisitorImpl parent, QvtOperationalEvaluationEnv nestedEvalEnv) {
		this(parent.getOperationalEnv(), nestedEvalEnv);
		
		oclAnnotationSupport = parent.getOCLAnnotationSupport();
	}    
    
	protected QvtOperationalEvaluationVisitorImpl createNestedEvaluationVisitor(QvtOperationalEvaluationVisitorImpl parent, QvtOperationalEvaluationEnv nestedEvalEnv) {
		return new QvtOperationalEvaluationVisitorImpl(parent, nestedEvalEnv); 
	}
	
	public Object visitDictLiteralExp(DictLiteralExp dictLiteralExp) {
		Dictionary<Object, Object> result = new DictionaryImpl<Object, Object>();
		for (DictLiteralPart part : dictLiteralExp.getPart()) {
			Object key = part.getKey().accept(getVisitor());
			Object value = part.getValue().accept(getVisitor());
			if(key != getInvalid() && value != getInvalid())
			result.put(key, value);
		}
		
		return result;
	}
	
	@Override
    public Object visitVariableExp(VariableExp<EClassifier, EParameter> v) {
		QvtOperationalEvaluationEnv evalEnv = getOperationalEvaluationEnv();		
		Variable<EClassifier, EParameter> vd = v.getReferredVariable();
		String varName = vd.getName();		
		Object value = evalEnv.getValueOf(varName);
		
		if(QvtOperationalEnv.THIS.equals(varName)) {
			EClassifier varType = v.getType();
			if(varType instanceof Module) {
				Module referredThisModule = (Module)varType;
				ModuleInstance thisObj = evalEnv.getThisOfType(referredThisModule);
				// only if not null, the variables is part of the QVT type system.
				// otherwise, it may be a custom variable in non-QVT execution context, like ImperativeOCL 
				if(thisObj != null) {
					return thisObj;
				}
			}
		} else if(vd instanceof ModelParameter) {
			OperationalTransformation transformation = (OperationalTransformation) vd.eContainer();
			TransformationInstance transformationInstance = (TransformationInstance)evalEnv.getThisOfType(transformation);
			assert transformationInstance != null;
			
			ModelInstance model = transformationInstance.getModel((ModelParameter)vd);
			assert model != null;			
			return model;
		}
		
		return value;
	}
	
    /**
	 * Creates evaluation visitor for an non-transformation execution client.
	 * <p>
	 * No main entry operation is available, the execution flow is undefined and
	 * it is the responsibility of the executor client.
	 * </p>
	 * <code>Note:</code>Only helper operation can be executed on the resulting
	 * visitor by an external clients.
	 * 
	 * @see #executeHelperOperation(Helper, Object, List)
	 */
    public static QvtOperationalEvaluationVisitorImpl createNonTransformationExecutionContextVisitor(Context context, ImportToNonTransformCtxHelper importProvider) {    	
		QvtOperationalEnv env = (QvtOperationalEnv)QvtOperationalEnvFactory.INSTANCE.createEnvironment();
		QvtOperationalEvaluationEnv evalEnv = QvtOperationalEnvFactory.INSTANCE.createEvaluationEnvironment(context, null);
    	return createNonTransformationExecutionContextVisitor(env, evalEnv, importProvider);
    }
    
    public static QvtOperationalEvaluationVisitorImpl createNonTransformationExecutionContextVisitor(
    		QvtOperationalEnv env, QvtOperationalEvaluationEnv evalEnv, ImportToNonTransformCtxHelper importsProvider) {
    	
    	QvtOperationalEvaluationVisitorImpl visitor = new QvtOperationalEvaluationVisitorImpl(env, evalEnv);    	
    	InternalEvaluationEnv internalEvalEnv = evalEnv.getAdapter(InternalEvaluationEnv.class);
		
    	ThisInstanceResolver importsByAccess = importsProvider.createImportedInstanceResolver();
		internalEvalEnv.setThisResolver(importsByAccess);
		
		// initialize those module only	newly instantiated, therefore uninitialized yet
		for (ModuleInstance nextModuleToInit : importsProvider.getModuleInstances(false)) {
			// the call bellow makes sure that all of its imported modules gets initialized 
			// if not done already due to other dependent modules
			ModuleInstance.Internal internalModule = nextModuleToInit.getAdapter(ModuleInstance.Internal.class);
			// check if initialized as the module we iterate through might cross-refence, so 
			// get initialized in the meantime
			if(!internalModule.isInitialized()) {			
				visitor.initModule(nextModuleToInit, null);
			}
		}
		
		return visitor;
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
	
	protected void pushedStack(QvtOperationalEvaluationEnv env) {
	}	
	
	protected void poppedStack() {
	}
	

    public IContext getContext() {
        return getOperationalEvaluationEnv().getContext();
    }
    
    public void notifyAfterDeferredAssign(final AssignExp assignExp, Object leftValue) {
    	// do nothing special here, subclasses may customize
    }
    
	@Override
    public Object visitIfExp(IfExp<EClassifier> ie) {
		// get condition
		OCLExpression<EClassifier> condition = ie.getCondition();

		// evaluate condition`
		Object condRawVal = condition.accept(getVisitor());
		Boolean condVal = (condRawVal != getInvalid()) ? (Boolean) condRawVal : Boolean.FALSE;

		if (condVal != null && condVal.booleanValue()) {
            return ie.getThenExpression().accept(getVisitor());
        }
		if (ie.getElseExpression() != null) {
			return ie.getElseExpression().accept(getVisitor());
		}
		return null;
	}

	@Override
	public Object visitExpression(OCLExpression<EClassifier> expression) {
		// Override the super implementation as we need our supported exception to be propagated
		// but super type catches it
		// TODO - needs to be secured in a general contract from MDT OCL as any place at OCL might
		// decide to perform the catch
		return expression.accept(getVisitor());
	}
    
    @SuppressWarnings("unchecked")
	public Object visitAssignExp(final AssignExp assignExp) {
        QvtOperationalEvaluationEnv env = getOperationalEvaluationEnv();
		InternalEvaluationEnv internEnv = env.getAdapter(InternalEvaluationEnv.class);
        
    	boolean isDeferred = false;    	
        // TODO: modify the following code for more complex l-values
        OCLExpression<EClassifier> lValue = assignExp.getLeft();
        if (assignExp.getValue().size() == 1) {
        	isDeferred = QvtResolveUtil.hasDeferredRightSideValue(assignExp);
            if(isDeferred) {
                Object ownerObj = getAssignExpLValueOwner(lValue);
                if (ownerObj instanceof EObject) {
                    PropertyCallExp<EClassifier, EStructuralFeature> lvalueExp = (PropertyCallExp<EClassifier, EStructuralFeature>) assignExp.getLeft();
                    EStructuralFeature referredProperty = lvalueExp.getReferredProperty();
                    internEnv.setLastAssignmentLvalueEval(new EObjectEStructuralFeaturePair((EObject) ownerObj, referredProperty));
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
        
        if (lValue instanceof VariableExp<?, ?>) {
            VariableExp<EClassifier, EParameter> varExp = (VariableExp<EClassifier, EParameter>) lValue;
            Variable<EClassifier, EParameter> referredVariable = varExp.getReferredVariable();
            if (referredVariable != null) {
                String varName = referredVariable.getName();
                Object oldValue = getRuntimeValue(varName);
                EClassifier variableType = lValue.getType();
                if (variableType instanceof CollectionType) {
                    Collection<Object> leftOclCollection = null;
                	if (oldValue instanceof Collection) {
	                    Collection<Object> oldOclCollection = (Collection<Object>) oldValue;
	                    if (assignExp.isIsReset()) {
	                        leftOclCollection = EvaluationUtil.createNewCollectionOfSameKind(oldOclCollection);
	                    } else {
	                        leftOclCollection = oldOclCollection;
	                    }
                	}
                	else {
                		leftOclCollection = EvaluationUtil.createNewCollection((CollectionType<EClassifier, EOperation>) variableType);
                	}
                	
                    final CollectionKind leftCollectionKind = getCollectionKind(leftOclCollection);
					if (exprValue instanceof Collection) {
                        if(leftCollectionKind == CollectionKind.ORDERED_SET_LITERAL) {
                            // can't use CollectionUtil.union(), the result type is not OrderedSet              
                            LinkedHashSet<Object> values = new LinkedHashSet<Object>();
                            values.addAll(leftOclCollection);
                            values.addAll((Collection<?>)exprValue);
                            leftOclCollection = CollectionUtil.createNewCollection(((CollectionType<?, ?>)variableType).getKind(), values);
                        } else if(leftCollectionKind != null){
                        	leftOclCollection = CollectionUtil.union(leftOclCollection, (Collection<?>) exprValue);                        	
                        } else {
                        	// QVT mutable types
                        	leftOclCollection.addAll((Collection<?>)exprValue);
                        }
                    } else if (leftCollectionKind == CollectionKind.ORDERED_SET_LITERAL
                            || leftCollectionKind == CollectionKind.SEQUENCE_LITERAL) {
                        leftOclCollection = CollectionUtil.append(leftOclCollection, exprValue);
                    } else if(leftCollectionKind != null) {
                        leftOclCollection = CollectionUtil.including(leftOclCollection, exprValue);
                    } else {
                    	// QVT mutable types
                    	leftOclCollection.add(exprValue);
                    }

                    replaceInEnv(varName, leftOclCollection, variableType);
                } else {
                    replaceInEnv(varName, exprValue, variableType);
                }
            }
        } else if (lValue instanceof PropertyCallExp<?, ?>) {
            Object ownerObj = getAssignExpLValueOwner(lValue);
            if (ownerObj instanceof EObject) {
                EObject oldIP = setCurrentEnvInstructionPointer(assignExp);
                env.callSetter(
                        (EObject) ownerObj,
                        ((PropertyCallExp<EClassifier, EStructuralFeature>) lValue).getReferredProperty(),
                        exprValue, isUndefined(exprValue), assignExp.isIsReset());
                setCurrentEnvInstructionPointer(oldIP);
            }
        } else {
            throw new UnsupportedOperationException("Unsupported LValue type: " + ((lValue == null) ? null : lValue.getType())); //$NON-NLS-1$
        }

        return exprValue;
    }
    
    private Object getAssignExpLValueOwner(OCLExpression<EClassifier> lValue) {
        if (lValue instanceof PropertyCallExp<?, ?>) {
            @SuppressWarnings("unchecked")
            PropertyCallExp<EClassifier, EParameter> propertyCallExp = (PropertyCallExp<EClassifier, EParameter>) lValue;
            OCLExpression<EClassifier> sourceExp = propertyCallExp.getSource();
            Object owner = sourceExp.accept(getVisitor());
                        
            // obtain correct owner for features of modules, which are possibly defined in an extended module that is not an explicit supertype (fixed by bug 302594/310991)
            if (owner instanceof ModuleInstance) {
            	
            	ModuleInstance moduleInstance = (ModuleInstance) owner;
            	
            	Object property = ((PropertyCallExp<?,?>) lValue).getReferredProperty();
            	
            	EClassifier containingClassifier = getUMLReflection().getOwningClassifier(property);
            	if (containingClassifier instanceof Module) {
            		owner = moduleInstance.getThisInstanceOf((Module) containingClassifier);
            	}	
            	
            }
           
            return owner;
        }
               
        return null;
    }

    private Object visitConfigProperty(EStructuralFeature configProperty) {
		setCurrentEnvInstructionPointer(configProperty);
		
    	IContext context = getOperationalEvaluationEnv().getContext();

        Object rawValue = context.getConfigProperty(configProperty.getName());
        EClassifier propertyType = configProperty.getEType();
        
        Object value = rawValue;        
        if(rawValue instanceof String && propertyType != getEnvironment().getOCLStandardLibrary().getString()) {
			value = createFromString(propertyType, (String) rawValue);
        }

        if(value == getInvalid()) {
        	// we failed to parse the value
        	throwQVTException(new QvtRuntimeException(NLS.bind(EvaluationMessages.QvtOperationalEvaluationVisitorImpl_invalidConfigPropertyValue, configProperty.getName(), rawValue)));
        }
        
        return value;
    }

    public Object visitEntryOperation(EntryOperation entryOperation) {    
        visitImperativeOperation(entryOperation);
        return new OperationCallResult(visitOperationBody(entryOperation.getBody()), getOperationalEvaluationEnv());
    }
    
    public Object visitHelper(Helper helper) {
        visitImperativeOperation(helper);
        return new OperationCallResult(visitOperationBody(helper.getBody()), getOperationalEvaluationEnv());
    }

    public Object visitImperativeOperation(ImperativeOperation imperativeOperation) {

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

        EClassifier contextType = QvtOperationalParserUtil.getContextualType(imperativeOperation);
        if (contextType != null) {
            addToEnv(Environment.SELF_VARIABLE_NAME, env.getOperationSelf(), contextType);
        }

		pushedStack(getOperationalEvaluationEnv());
        return null;
    }

    public Object visitLibrary(Library library) {
        return null;
    }

    public Object visitLocalProperty(EStructuralFeature property) {
    	OCLExpression<EClassifier> initExp = QvtOperationalParserUtil.getInitExpression(property);
    	if(initExp != null) {
    		return initExp.accept(getVisitor());
    	}
    	
    	return null;
    }
    
	public Object visitContextualProperty(ContextualProperty contextualProperty) {
		if(contextualProperty.getInitExpression() != null) {
			return contextualProperty.getInitExpression().accept(getVisitor());
		}
		return null;
	}
    
    protected boolean isWhenPreconditionSatisfied(MappingOperation mappingOperation) {
    	if(mappingOperation.getWhen().isEmpty()) {
    		return true;
    	}
    	for (OCLExpression<EClassifier> nextCond : mappingOperation.getWhen()) {
    		if(!Boolean.TRUE.equals(nextCond.accept(getVisitor()))) {
    			return false;
    		}
		}
    	return true;
    }
    
    private void setupInitialResultVariables(MappingBody mappingBody) {
    	ImperativeOperation operation = mappingBody.getOperation();
    	QvtOperationalEvaluationEnv evalEnv = getOperationalEvaluationEnv();
		// Note: the variables for result parameters may not be set or existing yet
		// define variables if not done already by the reusing mapping caller so
    	// avoid overriding values    	
    	for (VarParameter resultParam : operation.getResult()) {    		
    		if(evalEnv.getValueOf(resultParam.getName()) == null) {
    			replaceInEnv(resultParam.getName(), null, resultParam.getEType());    			
    		}
		}

    	if(operation.getResult().size() > 1) {
    		if(evalEnv.getValueOf(Environment.RESULT_VARIABLE_NAME) == null) {
    			replaceInEnv(Environment.RESULT_VARIABLE_NAME, null, operation.getEType());
    		}
    	}    	
    }
    
    public Object visitMappingBody(MappingBody mappingBody) {
		QvtOperationalEvaluationEnv evalEnv = getOperationalEvaluationEnv();
        MappingOperation currentMappingCalled = (MappingOperation) mappingBody.getOperation();
		
		setupInitialResultVariables(mappingBody);
    	
        for (OCLExpression<EClassifier> initExp : mappingBody.getInitSection()) {
            initExp.accept(getVisitor());
        }
                
        if(!mappingBody.getInitSection().isEmpty()) {
        	// setup a meaningful IP after init section to avoid pointing to the last expression of init 
        	// section, so in case of error a proper error location can be computed        	
        	setCurrentEnvInstructionPointer(currentMappingCalled);
        }
        
		Object result = createOrGetResult(currentMappingCalled);
		
		// call inherited mappings
		if(!currentMappingCalled.getInherited().isEmpty()) {
			for (MappingOperation extendedMapping : currentMappingCalled.getInherited()) {
				
				// consider overriding mapping
	    		ImperativeOperation overridingOper = EvaluationUtil.getOverridingOperation(getOperationalEvaluationEnv(), extendedMapping);
	    		if (overridingOper instanceof MappingOperation) {
	    			extendedMapping = (MappingOperation) overridingOper;
	    		}
				
				executeImperativeOperation(extendedMapping, evalEnv.getOperationSelf(), evalEnv.getOperationArgs(), true);				
			}
		}

        visitOperationBody(mappingBody);

        // TODO investigate possibility to modify result
        for (OCLExpression<EClassifier> endExp : mappingBody.getEndSection()) {
            endExp.accept(getVisitor());
        }
        
		// call merged mappings
		if(!currentMappingCalled.getMerged().isEmpty()) {
			for (MappingOperation extendedMapping : currentMappingCalled.getMerged()) {
				
				// consider overriding mapping
	    		ImperativeOperation overridingOper = EvaluationUtil.getOverridingOperation(getOperationalEvaluationEnv(), extendedMapping);
	    		if (overridingOper instanceof MappingOperation) {
	    			extendedMapping = (MappingOperation) overridingOper;
	    		}
				
				executeImperativeOperation(extendedMapping, evalEnv.getOperationSelf(), evalEnv.getOperationArgs(), true);				
			}
		}
		
		// result may have changed in body, end section, or merged mappings, so retrieve it again (fixed by bug 388325)
		result = getRuntimeValue(Environment.RESULT_VARIABLE_NAME);

        return result;
    }

    public Object visitMappingCallExp(MappingCallExp mappingCallExp) {
        return visitOperationCallExp(mappingCallExp);
    }

    @Override
    public Object visitOperationCallExp(OperationCallExp<EClassifier, EOperation> operationCallExp) {
    	// TODO - review the note bellow
    	// set IP of the current stack (represented by the top operation fEnv)
    	// to the this operation call in order to refeflect this call position 
    	// in possible QVT stack, in case an exception is thrown 
        EObject oldIP = setCurrentEnvInstructionPointer(operationCallExp);
        Object result = doVisitOperationCallExp(operationCallExp);    	        
        setCurrentEnvInstructionPointer(oldIP);
        return result;
    }    
    
    protected Object doVisitOperationCallExp(OperationCallExp<EClassifier, EOperation> operationCallExp) {
        EOperation referredOperation = operationCallExp.getReferredOperation();
                
        boolean isImperative = QvtOperationalUtil.isImperativeOperation(referredOperation);
		if (isImperative && !CallHandler.Access.hasHandler(referredOperation)) {
            Object source = operationCallExp.getSource().accept(getVisitor());
            List<Object> args = makeArgs(operationCallExp);
            // does not make sense continue at all, call on null or invalid results in invalid 
        	if(isUndefined(source)) {
        		return getInvalid();
        	}

            ImperativeOperation method = null;
            if (QvtOperationalParserUtil.isOverloadableMapping(referredOperation, getOperationalEnv())) {                
        		EOperation actualOperation = findOperationByActualSourceType(source, referredOperation);
				if(actualOperation instanceof ImperativeOperation) { 
					method = (ImperativeOperation) actualOperation;
				}
            }
            
    		if((method == null) && referredOperation instanceof ImperativeOperation) {
    			// we can't dispatch non-imperative as we already evaluated the source 
    			method = (ImperativeOperation)referredOperation;
    		}

            if(method != null) {          
            	if(operationCallExp instanceof ImperativeCallExp) {
            		ImperativeCallExp imperativeCall = (ImperativeCallExp) operationCallExp;
            		if(imperativeCall.isIsVirtual()) {
            			ImperativeOperation overridingOper = EvaluationUtil.getOverridingOperation(getOperationalEvaluationEnv(), method);
            			if(overridingOper != null) {
            				method = overridingOper;
            			}
            		}
            	}

            	return executeImperativeOperation(method, source, args, false).myResult;
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
        	if(canBePropagated(ex)) {
        		throw ex;
        	}
            //Logger.getLogger().log(Logger.WARNING, "QvtEvaluator: failed to evaluate oclOperationCall", ex);//$NON-NLS-1$
        	result = getInvalid();
        }
        
        // Note: we have to check for QVT exception caught by MDT OCL, those turned into invalid result, resolved
        // as failed operation calls, but QVT need some exceptions to propagate to the main running transformation,
        // for instance QVTInterruptedExecutionException        
    	if(result == getInvalid()) {
    		// check whether we have got exception from explicit call to 'Transformation::transform()'
    		QvtRuntimeException e = getOperationalEvaluationEnv().getAdapter(InternalEvaluationEnv.class).getException();
    		if(e != null) {
        		// propagate upward the stack in the current transformation    			
        		throw e;
    		}    		
    	}
        
        return result;
    }

    /**
	 * Finds operation based on the actual type of the source object as per
	 * virtual call semantics.
	 * 
	 * @param source
	 *            the self instance of the contextual type
	 * @param referredOperation
	 *            the operation referred by the call expresion in the AST
	 * @return the actual operation to call, which is either the passed referred
	 *         operation or another one defined in the bottom-most class in the
	 *         type hierarchy of the source object
	 */
	private EOperation findOperationByActualSourceType(Object source, EOperation referredOperation) {
		EOperation actualOperation = referredOperation;
		IVirtualOperationTable vTable = getVirtualTable(referredOperation);
		if(vTable != null) {
			EClassifier sourceEClass = getEvaluationEnvironment().getType(source);
			if(sourceEClass != null) {
				InternalEvaluationEnv internEnv = getOperationalEvaluationEnv().getAdapter(InternalEvaluationEnv.class);
				EOperation oper = vTable.lookupActualOperation(sourceEClass, getEnvironment(), internEnv);
				if(oper != null) {
					actualOperation = oper;
				}
			}
		}
		return actualOperation;
	}
        
    @Override
    public Object visitEnumLiteralExp(EnumLiteralExp<EClassifier, EEnumLiteral> el) {
        return el.getReferredEnumLiteral().getInstance();
    }

    /**
	 * @return result object or <code>null</code> in case that no result
	 *         variable is declared and <code>OclInvalid</code> in case the
	 *         precondition failed and the body was not executed.
	 */
    public Object visitMappingOperation(MappingOperation mappingOperation) {
        visitImperativeOperation(mappingOperation);

        QvtOperationalEvaluationEnv evalEnv = getOperationalEvaluationEnv();
		if (!isWhenPreconditionSatisfied(mappingOperation)) {
        	// return Invalid, to indicate precondition failure to the caller. It is used instead of
        	// of 'null' as it is a legal value for no result inout mapping, even
        	// the precondition holds
 
        	return new MappingCallResult(null, evalEnv, MappingCallResult.PRECOND_FAILED);
        }
				
        // check the traces whether the relation already holds
        TraceRecord traceRecord = TraceUtil.getTraceRecord(evalEnv, mappingOperation);
        if (traceRecord != null) {
        	return new MappingCallResult(TraceUtil.fetchResultFromTrace(evalEnv, traceRecord), evalEnv, MappingCallResult.FETCHED_FROM_TRACE);
        }
        
        if(!mappingOperation.getDisjunct().isEmpty()) {
			return dispatchDisjunctMapping(mappingOperation);
		}
                        		
        return new MappingCallResult(((OperationBodyImpl) mappingOperation.getBody()).accept(getVisitor()),
        				evalEnv, MappingCallResult.BODY_EXECUTED);
    }

    public Object execute(OperationalTransformation transformation) throws QvtRuntimeException {
    	try {
    		return doVisitTransformation(transformation);
    	} finally {
    		IntermediatePropertyModelAdapter.cleanup(transformation);
		}    		
    }
    
    public Object visitModule(Module module) {
        if (module instanceof OperationalTransformation == false) {
            throw new IllegalArgumentException(NLS.bind(EvaluationMessages.ExtendedOclEvaluatorVisitorImpl_ModuleNotExecutable, module.getName()));
        }
    	        
		try {
			return doVisitTransformation((OperationalTransformation) module);
		} 
		catch (QvtRuntimeException e) {
			StringWriter strWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(strWriter);
			e.printQvtStackTrace(printWriter);
			getContext().getLog().log(strWriter.getBuffer().toString());
			throw e;
		} finally {
			IntermediatePropertyModelAdapter.cleanup(module);
		}
    }        
        
    /**
	 * Executes the given helper operation with actual arguments passed.
	 * 
	 * @param method
	 *            the helper operation to execute
	 * @param self
	 *            the contextual instance in case of contextual operation,
	 *            otherwise the default instance of the module which defines the
	 *            called operation
	 * @param args
	 *            the actual parameter values
	 * @return return the value directly returned by the operation
	 */
	public Object executeHelperOperation(Helper method, Object self, List<Object> args) {
		Helper actualHelper = method;
		EOperation actualOperation = findOperationByActualSourceType(self, method);
		if(actualOperation instanceof Helper) { 
			actualHelper = (Helper) actualOperation;			
		} else {
			// Remark - the case when the actual operation is not imperative but 
			// a meta-model operation the virtual call will be dispatched by using 			
			// a normal operation call
			return getEvaluationEnvironment().callOperation(method, -1, self, args.toArray(new Object[args.size()]));
		}
		
		OperationCallResult result = executeImperativeOperation(actualHelper, self, args, false);
		return result.myResult;
	}
    
	public Object visitInstantiationExp(InstantiationExp objectExp) { 
		// should instantiate the module transformation
		EClass _class = objectExp.getInstantiatedClass();
		if (_class instanceof OperationalTransformation) {
				
			EList<org.eclipse.ocl.ecore.OCLExpression> formalArguments = objectExp.getArgument();		
			List<ModelInstance> actualArguments = new ArrayList<ModelInstance>(formalArguments.size());
	
			for (OCLExpression<EClassifier> nextArg : formalArguments) {
				Object argVal = nextArg.accept(getVisitor());
				if(argVal instanceof ModelInstance == false) {
					throwQVTException(new QvtRuntimeException(EvaluationMessages.QvtOperationalEvaluationVisitorImpl_UndefModelParamInTransf));
				}
				ModelInstance modelInstance = (ModelInstance) argVal;
				actualArguments.add(modelInstance); 
			}
	
			OperationalTransformation targetTransf = (OperationalTransformation)_class;
			QvtOperationalEvaluationEnv currentEnv = getOperationalEvaluationEnv();		
			// create a nested environment for constructor invocation representing 
			// the root environment of explicitly called transformation		
			// Empty default context, no configuration property is available
			// Remark: Can we set configuration property in the concrete syntax on the explicit transf object.
			Context nestedContext = EvaluationUtil.createAggregatedContext(currentEnv);
			
			QvtOperationalEnvFactory envFactory = getOperationalEnv().getFactory();
			QvtOperationalEvaluationEnv nestedEvalEnv = envFactory.createEvaluationEnvironment(nestedContext, null);
			
			//bug 392153: reuse existing trace for nested environment
			Trace trace = currentEnv.getAdapter(InternalEvaluationEnv.class).getTraces();
			nestedEvalEnv.getAdapter(InternalEvaluationEnv.class).setTraces(trace);
			
			// send arguments into the entry operation
			nestedEvalEnv.getOperationArgs().addAll(actualArguments);
			// Use per transformation instance visitor 
			InternalEvaluator nestedVisitor = createNestedEvaluationVisitor(this, nestedEvalEnv).createInterruptibleVisitor();
			try {
				setOperationalEvaluationEnv(nestedEvalEnv);
				
				ModuleInstance moduleInstance = nestedVisitor.callTransformationImplicitConstructor(targetTransf, actualArguments);
				//nestedEvalEnv.add(QvtOperationalEnv.THIS, moduleInstance);
				moduleInstance.getAdapter(InternalTransformation.class).setEntryOperationHandler(createEntryOperationHandler(nestedVisitor));
				return moduleInstance;
			} finally {
				setOperationalEvaluationEnv(currentEnv);
			}
		}
		else {
	        Object owner = createInstance(objectExp.getType(), (ModelParameter) objectExp.getExtent());

			Adapter adapter = EcoreUtil.getAdapter(objectExp.eAdapters(), ConstructorOperationAdapter.class);
			if (adapter != null) {
				Constructor constructorOp = ((ConstructorOperationAdapter) adapter).getReferredConstructor();

				EList<org.eclipse.ocl.ecore.OCLExpression> formalArguments = objectExp.getArgument();		
				List<Object> actualArguments = new ArrayList<Object>(formalArguments.size());
		
				for (OCLExpression<EClassifier> nextArg : formalArguments) {
					Object argVal = nextArg.accept(getVisitor());
					actualArguments.add(argVal); 
				}

				executeImperativeOperation(constructorOp, owner, actualArguments, false);
			}
			else {
				if (objectExp.getArgument().isEmpty()) {
					// it's OK since default constructor is called
				}
				else {
					throwQVTException(new QvtRuntimeException("Undefined constructor is called")); //$NON-NLS-1$
				}
			}
			
	        return owner;
		}
	}
	
	public TransformationInstance callTransformationImplicitConstructor(OperationalTransformation transformation, List<ModelInstance> transfArgs) {
    	ModuleInstanceFactory eFactory = (ModuleInstanceFactory)transformation.getEFactoryInstance();
		assert eFactory != null : "Module class must have factory"; //$NON-NLS-1$
		
		TransformationInstance instance = (TransformationInstance) eFactory.create(transformation);
		// Note: need to make the main executed transf available via this
		// so all super module have access to env::getCurrentTransformation()
		getEvaluationEnvironment().add(QvtOperationalEnv.THIS, instance);
		
		ModelParameterHelper modelParameters = new ModelParameterHelper(transformation, transfArgs);
		initModule(instance, modelParameters);
		// we are initialized set back the pointer to the module 
		setCurrentEnvInstructionPointer(transformation);		
		return instance;
	}	
	
	// FIXME - review the strange case of having various return types
	private Object doVisitTransformation(OperationalTransformation transformation) {
        ImperativeOperation entryPoint = QvtOperationalParserUtil.getMainOperation(transformation);        
        if (entryPoint == null) {
            throw new IllegalArgumentException(NLS.bind(EvaluationMessages.ExtendedOclEvaluatorVisitorImpl_ModuleNotExecutable, transformation.getName()));
        }

        QvtOperationalEvaluationEnv evaluationEnv = getOperationalEvaluationEnv();        
		List<ModelInstance> modelArgs = EvaluationUtil.getTransfromationModelArguments(evaluationEnv, transformation);		

		TransformationInstance moduleInstance = callTransformationImplicitConstructor(transformation, modelArgs);    	
		CallHandler entryOperationHandler = createEntryOperationHandler(this);
		InternalTransformation internTransf = moduleInstance.getAdapter(InternalTransformation.class);		
		internTransf.setEntryOperationHandler(entryOperationHandler);
        			
        // call main entry operation
        OperationCallResult callResult = (OperationCallResult) entryOperationHandler.invoke(
        		null, moduleInstance,
        		makeEntryOperationArgs(entryPoint, 
        		transformation).toArray(), evaluationEnv);
        
        QvtEvaluationResult evalResult = EvaluationUtil.createEvaluationResult(callResult.myEvalEnv);
        
        if (evalResult.getModelExtents().isEmpty()) {
            if (callResult.myResult instanceof EObject) {
                // compatibility reason, make the main() operation return value available in an extent
            	ModelParameterExtent modelParameter = new ModelParameterExtent(
            			Collections.singletonList((EObject) callResult.myResult), null, null);
                evalResult.getModelExtents().add(modelParameter.getContents());
            } else {
                return callResult.myResult;
            }
        }
        
        return evalResult;
    }

	private static CallHandler createEntryOperationHandler(final InternalEvaluator evaluator) {
		return new CallHandler() {
			public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
				TransformationInstance transformation = (TransformationInstance) source;				
				try {
					return evaluator.runMainEntry(transformation.getTransformation(), Arrays.asList(args));
				} finally {
					transformation.getAdapter(InternalTransformation.class).dispose();
				}
			}
		};
	}

	protected void processDeferredTasks() {
		InternalEvaluationEnv internalEvalEnv = getOperationalEvaluationEnv().getAdapter(InternalEvaluationEnv.class);
		internalEvalEnv.processDeferredTasks();
	}

	public Object visitModuleImport(ModuleImport moduleImport) {
        return null;
    }

    public Object visitObjectExp(ObjectExp objectExp) {
        InternalEvaluationEnv internEnv = getOperationalEvaluationEnv().getAdapter(InternalEvaluationEnv.class);
        internEnv.setCurrentIP(objectExp);
    	
        Object owner = getOutOwner(objectExp);

    	if(objectExp.getBody() != null) {
    		EList<org.eclipse.ocl.ecore.OCLExpression> contents = objectExp.getBody().getContent();        
	        for (OCLExpression<EClassifier> exp : contents) {
	            exp.accept(getVisitor());
	        }
    	}
    	
    	// owner may have changed in body content, so retrieve it again (fixed by bug 388325)
    	owner = getOutOwner(objectExp);
    	
        if (getOperationalEnv().isTemporaryElement(objectExp.getName())) {
            getOperationalEvaluationEnv().remove(objectExp.getName());
        }

        return owner;
    }

    public Object visitReturnExp(ReturnExp returnExp) {
    	Object value = null;
    	OCLExpression<EClassifier> valueExp = returnExp.getValue();
    	if(valueExp != null) {
    		value = valueExp.accept(getVisitor());    		
    	}
    	
		OperationBody body = QvtOperationalParserUtil.findParentElement(returnExp, OperationBody.class);
		if(body != null) {
			EList<org.eclipse.ocl.ecore.OCLExpression> content = body.getContent(); 
			if(!content.isEmpty() && content.get(content.size() - 1) == returnExp) {
				// return is the last expression in the body, simply return the value
				return value;
			}
		}    	

		// TODO - analyze more complex structured execution flow and
		// avoid the cost of exception throwing 
		throw new ReturnExpEvent(value, getOperationalEvaluationEnv());
    }
    
    public Object visitOperationBody(OperationBody operationBody) {
        Object result = null;
        for (OCLExpression<EClassifier> exp : operationBody.getContent()) {
            result = exp.accept(getVisitor());
        }
        
        ImperativeOperation operation = operationBody.getOperation();
        if(operation.getResult().size() > 1) {
        	return createTupleResult(operation);
        }
        return result;
    }

    public Object visitVarParameter(VarParameter varParameter) {
        return null;
    }

    public Object visitVariableInitExp(VariableInitExp variableInitExp) {
        org.eclipse.ocl.ecore.Variable referredVariable = variableInitExp.getReferredVariable();
        OCLExpression<EClassifier> initExpression = referredVariable.getInitExpression();
        Object value = null;
		if(initExpression != null) {
			value = initExpression.accept(getVisitor());
			// check that collection is initialized to empty collection in case of 'null' 
			if(value == null && referredVariable.getType() instanceof CollectionType<?, ?>) {
				value = EvaluationUtil.createInitialValue(referredVariable.getType(), getQVTVisitor().getEnvironment().getOCLStandardLibrary());
			}
		} else { 
			value = EvaluationUtil.createInitialValue(referredVariable.getType(), getQVTVisitor().getEnvironment().getOCLStandardLibrary());
		}
		
        replaceInEnv(referredVariable.getName(), value, variableInitExp.getType());
        
        return variableInitExp.isWithResult() ? value : null;
    }

    public Object visitBlockExp(BlockExp blockExp) {
    	List<String> scopeVars = null;
    	boolean isInImperativeOper = blockExp.eContainer() instanceof ImperativeOperation;
    	
        for (OCLExpression<EClassifier> exp : blockExp.getBody()) {
        	if((exp instanceof VariableInitExp) && !isInImperativeOper) {
        		if(scopeVars == null) {
        			scopeVars = new LinkedList<String>();
        		}
        		VariableInitExp varInitExp = (VariableInitExp) exp;
        		scopeVars.add(varInitExp.getName());
        	}
        	
            exp.accept(getVisitor());
        }
        
        if(scopeVars != null) {
			EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv = getEvaluationEnvironment();        	
        	for (String varName : scopeVars) {        		
				evalEnv.remove(varName);
			}
        }
        
        return null;
    }
    
    public Object visitComputeExp(ComputeExp computeExp) {
        Variable<EClassifier, EParameter> returnedElement = computeExp.getReturnedElement();
        Object initExpressionValue = null;
        OCLExpression<EClassifier> initExpression = returnedElement.getInitExpression();
        if (initExpression != null) {
            initExpressionValue = initExpression.accept(getVisitor());
        }
        replaceInEnv(returnedElement.getName(), initExpressionValue, returnedElement.getType());
        
        computeExp.getBody().accept(getVisitor());

        return getEvaluationEnvironment().remove(returnedElement.getName());
    }

    public Object visitWhileExp(WhileExp whileExp) {
        while (true) {
            Object condition = whileExp.getCondition().accept(getVisitor());
            if (Boolean.TRUE.equals(condition)) {
            	try {
            		whileExp.getBody().accept(getVisitor());
            	}
            	catch (QvtTransitionReachedException ex) {
            		if (ex.getReason() == QvtTransitionReachedException.REASON_BREAK) {
            			break;
            		}
            		if (ex.getReason() == QvtTransitionReachedException.REASON_CONTINUE) {
            			continue;
            		}
            	}
            } else {
                break;
            }
        }
        
        return null;
    }
    
    private static class SwitchAltExpResult {
    	public Object myCondition;
    	public Object myResult;
    }
    
    public Object visitAltExp(AltExp switchAltExp) {
		SwitchAltExpResult result = new SwitchAltExpResult();
		result.myCondition = switchAltExp.getCondition().accept(getVisitor());
		if (Boolean.TRUE.equals(result.myCondition)) {
			result.myResult = switchAltExp.getBody().accept(getVisitor());
		}
		return result;
    }

    public Object visitSwitchExp(SwitchExp switchExp) {
        for (AltExp altExp : switchExp.getAlternativePart()) {
        	Object altResult = altExp.accept(getVisitor());
        	if (altResult instanceof SwitchAltExpResult) {
            	if (Boolean.TRUE.equals(((SwitchAltExpResult) altResult).myCondition)) {
                    return ((SwitchAltExpResult) altResult).myResult;
                }
        	}
        	else if (Boolean.TRUE.equals(altResult)) {
                return null;
            }
        }
        OCLExpression<EClassifier> elsePart = switchExp.getElsePart();
        if (elsePart != null) {
            return elsePart.accept(getVisitor());
        }
        return null;
    }

    /* resolve expressions family */

    public Object visitResolveExp(ResolveExp resolveExp) {
    	if (resolveExp.isIsDeferred()) {
    		InternalEvaluationEnv internalEvalEnv = getOperationalEvaluationEnv().getAdapter(InternalEvaluationEnv.class);
    		if(!internalEvalEnv.isDeferredExecution()) {	        	
	            LateResolveTask lateResolveTask = new LateResolveTask(resolveExp, internalEvalEnv.getLastAssignmentLvalueEval(), getQVTVisitor(), getOperationalEvaluationEnv(), this);
	            internalEvalEnv.addDeferredTask(lateResolveTask);
	            return null;
    		}
        }
        return QvtResolveUtil.resolveNow(resolveExp, this, getOperationalEvaluationEnv());
    }
    
    public Object visitResolveInExp(ResolveInExp resolveInExp) {
        if (resolveInExp.isIsDeferred()) {
        	InternalEvaluationEnv internalEvalEnv = getOperationalEvaluationEnv().getAdapter(InternalEvaluationEnv.class);        	
        	if(!internalEvalEnv.isDeferredExecution()) {
	            LateResolveInTask lateResolveInTask = new LateResolveInTask(resolveInExp, internalEvalEnv.getLastAssignmentLvalueEval(), getQVTVisitor(), getOperationalEvaluationEnv(), this);
	            internalEvalEnv.addDeferredTask(lateResolveInTask);            
	            return null;
        	}
        }        
        return QvtResolveUtil.resolveInNow(resolveInExp, this, getOperationalEvaluationEnv());
    }
    
	public Object visitModelType(ModelType modelType) {
		return null;
	}
    
	public Object visitLogExp(LogExp logExp) {
		doVisitLogExp(logExp, getContext().getLog(), null);
		return null;
	}
	
	private boolean doVisitLogExp(LogExp logExp, Log logger, String messagePrefix) {
		if(logExp.getCondition() != null && !Boolean.TRUE.equals(logExp.getCondition().accept(getVisitor()))) {
			return false;
		}
		InternalEvaluationEnv internalEnv = getOperationalEvaluationEnv().getAdapter(InternalEvaluationEnv.class);		
		Object invalid = internalEnv.getInvalid();
		String invalidRepr = "<Invalid>"; //$NON-NLS-1$
		// process logging level
		Integer level = null;
		EList<OCLExpression<EClassifier>> args = logExp.getArgument();
		if(args.size() > 2) {
			Object levelObj = args.get(2).accept(getVisitor());
			level = NumberConversions.strictConvertNumber(levelObj, Integer.class);
		}

		Object message = args.get(0).accept(getVisitor());
		if(message == null) {
			message = "<null>"; //$NON-NLS-1$
		} else if(message == invalid) {
			message = invalidRepr;
		}
		
		if(messagePrefix != null) {
			message = messagePrefix + " : " + message; //$NON-NLS-1$
		}

		Object element = null;
		Object formatedElement = null;
		if(args.size() > 1) {
			element = args.get(1).accept(getVisitor());
			if(element == invalid) {
				formatedElement = invalidRepr;
			} else {
				formatedElement = EvaluationUtil.formatLoggedElement(element);
			}
		}

		if(level == null) {
			if(element == null) {
				logger.log(String.valueOf(message));
			} else {		
				logger.log(String.valueOf(message), formatedElement);
			}
		} else {
			if(element == null) {
				logger.log(level, String.valueOf(message));
			} else {		
				logger.log(level, String.valueOf(message), formatedElement);
			}			
		}
		
		return true;
	}
	
	public Object visitAssertExp(AssertExp assertExp) {		
		Object assertionValue = assertExp.getAssertion().accept(getVisitor());		
		
		if(Boolean.FALSE.equals(assertionValue) || assertionValue == getInvalid()) {	
			InternalEvaluationEnv internEvalEnv = getOperationalEvaluationEnv().getAdapter(InternalEvaluationEnv.class);
			Module currentModule = internEvalEnv.getCurrentModule().getModule();
			IModuleSourceInfo moduleSource = ASTBindingHelper.getModuleSourceBinding(currentModule);
			
			String source;
			if(moduleSource != null) {
				source = moduleSource.getSourceURI().lastSegment();
			} else {
				source = EvaluationMessages.UknownSourceLabel;				
			}

			StringBuilder locationBuf = new StringBuilder(source);
			if(assertExp.getStartPosition() >= 0 && moduleSource != null) {
				int lineNum = moduleSource.getLineNumberProvider().getLineNumber(assertExp.getStartPosition());
				locationBuf.append(':').append(lineNum);
			}
							
			String message = NLS.bind(EvaluationMessages.AssertFailedMessage, assertExp.getSeverity(), locationBuf.toString());				
			Log logger = getContext().getLog();
			
			if(assertExp.getLog() != null) {
				doVisitLogExp(assertExp.getLog(), logger, message);
			} else {
				logger.log(message);				
			}
			
			if(SeverityKind.FATAL.equals(assertExp.getSeverity())) {
				logger.log(EvaluationMessages.TerminatingExecution);
			}
				
			if(SeverityKind.FATAL.equals(assertExp.getSeverity())) {
				throwQVTException(new QvtAssertionFailed(EvaluationMessages.FatalAssertionFailed));
			}		
				
		}			
		
		return null;
	}
	
    public Object visitImperativeLoopExp(ImperativeLoopExp imperativeLoopExp) {
        throw new UnsupportedOperationException();
    }
    
    public Object visitForExp(ForExp forExp) {
        Object sourceValue = forExp.getSource().accept(getVisitor());
        
        if (!isUndefined(sourceValue)) {
            // generate a name for the result variable and add it to the environment
            String resultName = generateName();
            getEvaluationEnvironment().add(resultName, null);
            
            Collection<?> sourceCollection = (Collection<?>) sourceValue;
            // get the list of ocl iterators
            List<Variable<EClassifier, EParameter>> iterators = forExp.getIterator();
            // get the condition expression
            OCLExpression<EClassifier> condition = forExp.getCondition();
            // get the body expression
            OCLExpression<EClassifier> body = forExp.getBody();
            
            // evaluate
            QvtIterationTemplateForExp.getInstance(getVisitor()).evaluate(
                    sourceCollection, iterators, null, condition, body, resultName, "forOne".equals(forExp.getName())); //$NON-NLS-1$

            // remove result name from environment
            getEvaluationEnvironment().remove(resultName);
            
        }
        
        return null;
    }

    public Object visitImperativeIterateExp(ImperativeIterateExp imperativeIterateExp) {
        EClassifier sourceType = imperativeIterateExp.getSource().getType();
        
        if (sourceType instanceof PredefinedType<?>) {
            Object sourceValue = imperativeIterateExp.getSource().accept(getVisitor());
            
            // value of iteration expression is undefined if the source is
            //   null or OclInvalid
            if (isUndefined(sourceValue)) {
                return getInvalid();
            }
            
            // get initial result value based on the source type
            @SuppressWarnings("unchecked")
            CollectionType<EClassifier, EOperation> collType = (CollectionType<EClassifier, EOperation>) imperativeIterateExp.getSource().getType();
            
            Object initResultVal = null;
            if (imperativeIterateExp.getName().equals("xselect")) { //$NON-NLS-1$
                initResultVal = EvaluationUtil.createNewCollection(collType);
            } else if (imperativeIterateExp.getName().equals("xcollect")  //$NON-NLS-1$
                    || imperativeIterateExp.getName().equals("collectselect")) { //$NON-NLS-1$
                initResultVal = ((collType instanceof SetType<?,?>) || (collType instanceof BagType<?,?>)) ?
                        CollectionUtil.createNewBag() : CollectionUtil.createNewSequence();
            }

            // generate a name for the result variable and add it to the environment
            String resultName = generateName();
            getEvaluationEnvironment().add(resultName, initResultVal);

            Collection<?> sourceCollection = (Collection<?>) sourceValue;
            // get the list of ocl iterators
            List<Variable<EClassifier, EParameter>> iterators = imperativeIterateExp.getIterator();
            // get the target expression
            Variable<EClassifier, EParameter> target = imperativeIterateExp.getTarget();
            // get the condition expression
            OCLExpression<EClassifier> condition = imperativeIterateExp.getCondition();
            // get the body expression
            OCLExpression<EClassifier> body = imperativeIterateExp.getBody();

            // evaluate
            Object result = null;
            if ("xcollect".equals(imperativeIterateExp.getName())) { //$NON-NLS-1$
                result = QvtIterationTemplateXCollect.getInstance(getVisitor()).evaluate(
                        sourceCollection, iterators, target, condition, body, resultName, false);
            } else if ("xselect".equals(imperativeIterateExp.getName())) { //$NON-NLS-1$
                result = QvtIterationTemplateXSelect.getInstance(getVisitor()).evaluate(
                        sourceCollection, iterators, target, condition, body, resultName, false);
            } else if ("collectselect".equals(imperativeIterateExp.getName())) { //$NON-NLS-1$
                result = QvtIterationTemplateCollectSelect.getInstance(getVisitor()).evaluate(
                        sourceCollection, iterators, target, condition, body, resultName, false);
            } else if ("collectOne".equals(imperativeIterateExp.getName())) { //$NON-NLS-1$
                result = QvtIterationTemplateXCollect.getInstance(getVisitor()).evaluate(
                        sourceCollection, iterators, target, condition, body, resultName, true);
            } else if ("selectOne".equals(imperativeIterateExp.getName())) { //$NON-NLS-1$
                result = QvtIterationTemplateXSelect.getInstance(getVisitor()).evaluate(
                        sourceCollection, iterators, target, condition, body, resultName, true);
            } else if ("collectselectOne".equals(imperativeIterateExp.getName())) { //$NON-NLS-1$
                result = QvtIterationTemplateCollectSelect.getInstance(getVisitor()).evaluate(
                        sourceCollection, iterators, target, condition, body, resultName, true);
            }

            // remove result name from environment
            getEvaluationEnvironment().remove(resultName);

            return result;
        }
        
        String message = NLS.bind(EvaluationMessages.IteratorNotImpl, imperativeIterateExp.getName());
        throw new UnsupportedOperationException(message);
    }
    
	public Object visitConstructor(Constructor constructor) {
        visitImperativeOperation(constructor);
        QvtOperationalEvaluationEnv env = getOperationalEvaluationEnv();
        env.add(Environment.RESULT_VARIABLE_NAME, env.remove(Environment.SELF_VARIABLE_NAME));
        return new OperationCallResult(visitOperationBody(constructor.getBody()), getOperationalEvaluationEnv());
	}

	public Object visitConstructorBody(ConstructorBody constructorBody) {
		return visitOperationBody(constructorBody);
	}

	public Object visitBreakExp(BreakExp astNode) {
		throw new QvtTransitionReachedException(QvtTransitionReachedException.REASON_BREAK);
	}

	public Object visitCatchtExp(CatchExp astNode) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitContinueExp(ContinueExp astNode) {
		throw new QvtTransitionReachedException(QvtTransitionReachedException.REASON_CONTINUE);
	}

	public Object visitDictLiteralPart(DictLiteralPart astNode) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitOrderedTupleLiteralExp(OrderedTupleLiteralExp astNode) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitOrderedTupleLiteralPart(OrderedTupleLiteralPart astNode) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitRaiseExp(RaiseExp astNode) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitTryExp(TryExp astNode) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitUnlinkExp(UnlinkExp astNode) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitUnpackExp(UnpackExp astNode) {
		// TODO Auto-generated method stub
		return null;
	}
    
    private static synchronized String generateName() {
        return "__qvtresult__" + tempCounter++;//$NON-NLS-1$
    }

	/**
	 * Initializes the model parameters and properties of the given module
	 * instance and all instances associated via import.
	 * 
	 * @param moduleInstance
	 *            the instance to initialize
	 * @param modelParameters
	 *            helper for binding transformation parameters
	 */
    private void initModule(ModuleInstance moduleInstance, ModelParameterHelper modelParameters) {
    	Module type = moduleInstance.getModule();
		QvtOperationalEnv env = (QvtOperationalEnv) getEnvironment();
		QvtOperationalEvaluationEnv currentEvalEnv = getOperationalEvaluationEnv();	

		QvtOperationalEvaluationEnv nestedEvalEnv = (QvtOperationalEvaluationEnv) env.getFactory().createEvaluationEnvironment(getOperationalEvaluationEnv());
		// ensure 'this' instance available in the initialization code
		nestedEvalEnv.add(QvtOperationalEnv.THIS, moduleInstance);
		// propagate arguments, provided it is a transformation module
		nestedEvalEnv.getOperationArgs().addAll(currentEvalEnv.getOperationArgs());
		// point to the module we are initializing
		nestedEvalEnv.getAdapter(InternalEvaluationEnv.class).setCurrentIP(type);
		try {
			setOperationalEvaluationEnv(nestedEvalEnv);
			// push stack before a chance for exception, to have push/pop in balance 
			pushedStack(nestedEvalEnv);
	        // eventually cause STO exception
	        EvaluationUtil.checkCurrentStackDepth(currentEvalEnv);			
	       
	        // do initialization of model params here to ensure existing out extent for objects created during initialization of imported modules (fixed by bug 392080)
	        doInitModelParams(moduleInstance, modelParameters);
	        
	    	for (ModuleImport moduleImport : type.getModuleImport()) {
	    		Module importedModule = moduleImport.getImportedModule();	    		
				ModuleInstance importedInstance = moduleInstance.getThisInstanceOf(importedModule);
		    	if(importedInstance != null) { 
					ModuleInstance.Internal importedInternal = importedInstance.getAdapter(ModuleInstance.Internal.class);
					if(!importedInternal.isInitialized()) {
						initModule(importedInstance, modelParameters);
					}
	    		}
			}
	    	
	        doInitModule(moduleInstance);
	    		    	
	    	moduleInstance.getAdapter(ModuleInstance.Internal.class).setInitialized();   				
	    	
		} finally {
			setOperationalEvaluationEnv(getOperationalEvaluationEnv().getParent());
			poppedStack();
		}
    }
    
    private void doInitModelParams(ModuleInstance moduleInstance, ModelParameterHelper modelParameters) {
    	
    	if(modelParameters != null && moduleInstance.getModule().eClass() == ExpressionsPackage.eINSTANCE.getOperationalTransformation()) {
			modelParameters.initModelParameters((TransformationInstance) moduleInstance);
		}
    	
    }
    
    private void doInitModule(ModuleInstance moduleInstance) {
    	Module module = moduleInstance.getModule();
    	
        QvtOperationalEvaluationEnv env = getOperationalEvaluationEnv();
                
		for (EStructuralFeature feature : module.getConfigProperty()) {			
			Object propValue = visitConfigProperty(feature);
			env.callSetter(moduleInstance, feature, propValue, isUndefined(propValue), true);			
		}
		
        for (EStructuralFeature feature : module.getEStructuralFeatures()) {
        	if(feature instanceof ContextualProperty || module.getConfigProperty().contains(feature)) {
        		continue;
        	}

        	setCurrentEnvInstructionPointer(feature);
        	
        	OCLExpression<EClassifier> initExp = QvtOperationalParserUtil.getInitExpression(feature);
			Object propValue = null;
            if(initExp != null) {
            	propValue = initExp.accept(getVisitor());                
            }
			// FIXME - should not be set if no init expression is defined
			env.callSetter(moduleInstance, feature, propValue, isUndefined(propValue), true);        
        }
        
//        for (Rename rename : module.getOwnedRenaming()) {
//            ((RenameImpl) rename).accept(getVisitor());
//        }
    }
            
	private IVirtualOperationTable getVirtualTable(EOperation operation) {
		return IVirtualOperationTable.Access.INSTANCE.getVirtualTable(operation);
	}
    
    private Object createOrGetResult(MappingOperation mappingOperation) {
        Object result = null;
        
        if (!mappingOperation.getResult().isEmpty()) {
        	result = getRuntimeValue(Environment.RESULT_VARIABLE_NAME);
            if (isUndefined(result)) { // if nothing was assigned to the result in the init section
                EList<VarParameter> resultParams = mappingOperation.getResult();
                if(resultParams.size() > 1) {
                	result = createTupleResult(mappingOperation);
                } 
                else {
        			VarParameter type = (resultParams.isEmpty() ? null : resultParams.get(0));
                    if (type != null && false == type.getEType() instanceof VoidType<?>) {
                        result = createInstance(type.getEType(), ((MappingParameter) type).getExtent());
                    }    			
                }
                
                replaceInEnv(Environment.RESULT_VARIABLE_NAME, result, mappingOperation.getEType());
            }
        }
        
        TraceUtil.addTraceRecord(getOperationalEvaluationEnv(), mappingOperation);
        return result;
    }

    protected static class OperationCallResult {
    	public Object myResult;
    	public QvtOperationalEvaluationEnv myEvalEnv;
    	
		OperationCallResult(Object myResult, QvtOperationalEvaluationEnv myEvalEnv) {
			this.myResult = myResult;
			this.myEvalEnv = myEvalEnv;
		}
    }
    
    private static class MappingCallResult extends OperationCallResult {
		static final int BODY_EXECUTED = 0;
		static final int PRECOND_FAILED = 2;
		static final int FETCHED_FROM_TRACE = 4;
		static final int NO_DISJUNCT_SELECTED = 8;		
		
		int myStatus;
    	
    	private MappingCallResult(Object myResult, QvtOperationalEvaluationEnv myEvalEnv, int status) {
			super(myResult, myEvalEnv);
			myStatus = status;
		}
    	boolean isBodyExecuted() { return myStatus == BODY_EXECUTED; }
    	boolean isPreconditionFailed() { return (myStatus & PRECOND_FAILED) != 0; };
    	//boolean isFetchedFromTrace() { return (myStatus & FETCHED_FROM_TRACE) != 0; };
    	//boolean isNoDisjunctSelected() { return (myStatus & NO_DISJUCT_SELECTED) != 0; };    	
    }
    
    private OperationCallResult executeImperativeOperation(ImperativeOperation method, Object source, List<Object> args, boolean isReusingMappingCall) {    	
        if (method.isIsBlackbox() && method.getBody() == null) {
            throw new IllegalArgumentException(
                    "Can't execute blackbox operation" + method.getName()); //$NON-NLS-1$
        }

        QvtOperationalEvaluationEnv oldEvalEnv = getOperationalEvaluationEnv();
        
    	boolean isMapping = method instanceof MappingOperation;    	
        // eventually cause STO exception
        EvaluationUtil.checkCurrentStackDepth(oldEvalEnv);
        
        // create a nested evaluation environment for this operation call
        QvtOperationalEvaluationEnv nestedEnv = getOperationalEnv().getFactory().createEvaluationEnvironment(
        		oldEvalEnv.getContext(), oldEvalEnv);
        nestedEnv.setOperation(method);
        
        nestedEnv.getOperationArgs().addAll(args);
        if (!isUndefined(source)) {
            nestedEnv.setOperationSelf(source);
        }
        
        if(isReusingMappingCall) {
        	// let the reused mapping see the reusing caller's out/result parameters
        	EvaluationUtil.mapOperationOutAndResultParams(oldEvalEnv, nestedEnv);
        }
                        
        // setup 'this' module variable  
        Module targetModule = QvtOperationalParserUtil.getOwningModule(method);
        assert targetModule != null;
        // Resolves the target module instance to call from the currently executed module 'this'
        ModuleInstance calledThisInstance = oldEvalEnv.getThisOfType(targetModule);        
        assert calledThisInstance != null;
        
        setOperationalEvaluationEnv(nestedEnv);
        // add 'this' to the nested environment
        addToEnv(QvtOperationalEnv.THIS, calledThisInstance, targetModule);        
        
        // set IP initially to the method header
        setCurrentEnvInstructionPointer(method); 

        OperationCallResult callResult = null;
        try {
        	Object result = ((ImperativeOperationImpl) method).accept(getVisitor());    	
        	assert result instanceof OperationCallResult;
        	assert !isMapping || result instanceof MappingCallResult;        	
        	
        	callResult = (OperationCallResult)result;
        }
        catch (ReturnExpEvent e) {
        	callResult = e.getResult();
        }
        catch (StackOverflowError e) {
        	throwQVTException(new QvtStackOverFlowError(e));
        }
        catch (QvtRuntimeException e) {
       		throw e;
        }
        catch (RuntimeException e) {
        	if(canBePropagated(e)) {
        		throw e;
        	} 
        	
        	String errorMessage = EvaluationMessages.QvtOperationalEvaluationVisitorImpl_unexpectedRuntimeExc;
			QvtPlugin.error(errorMessage, e);
			
        	throwQVTException(new QvtRuntimeException(errorMessage, e));
        }
        finally {
            if(isMapping && isReusingMappingCall && callResult != null) {
            	// reflect our output in the reusing mapping caller
            	if(((MappingCallResult)callResult).isBodyExecuted()) {
            		EvaluationUtil.mapOperationOutAndResultParams(nestedEnv, oldEvalEnv);
            	}
            }        	

        	setOperationalEvaluationEnv(oldEvalEnv);
        	poppedStack();
        }
        
    	return callResult;
    }
                
    private MappingCallResult dispatchDisjunctMapping(MappingOperation method) {
    	QvtOperationalEvaluationEnv evalEnv = getOperationalEvaluationEnv();
    	Object source = evalEnv.getOperationSelf();
    	List<Object> args = evalEnv.getOperationArgs();
    	
    	for (MappingOperation nextDisjunct : method.getDisjunct()) {
    		
    		// consider overriding mapping (fixed by bug 309762)
    		ImperativeOperation overridingOper = EvaluationUtil.getOverridingOperation(getOperationalEvaluationEnv(), nextDisjunct);
    		if (overridingOper instanceof MappingOperation) {
    			nextDisjunct = (MappingOperation) overridingOper;
    		}
    		
    		EClassifier ctxType = QvtOperationalParserUtil.getContextualType(nextDisjunct);
    		if(ctxType != null) {
    			if(!evalEnv.isKindOf(source, nextDisjunct.getContext().getEType())) {
    				continue;
    			}
    		}
    		
    		if(!dispatchDisjunctMappingArgumentsMatch(nextDisjunct)) {
    			continue;
    		}

    		MappingCallResult result = (MappingCallResult)executeImperativeOperation(nextDisjunct, source, args, false);
    		if(!result.isPreconditionFailed()) {
    			// precondition holds, mapping either executed, fetched from trace, or disjuncted
    			result.myStatus = MappingCallResult.BODY_EXECUTED; // from disjuncting mapping consider as executed
    			
    			// add trace record for disjuncting mapping (fixed by bug 377882) 
    			replaceInEnv(Environment.RESULT_VARIABLE_NAME, result.myResult, method.getEType());
    			TraceUtil.addTraceRecord(evalEnv, method);
    			
    			return result;
    		}
		}
    	
    	return new MappingCallResult(null, myEvalEnv, MappingCallResult.NO_DISJUNCT_SELECTED);
    }
    
    private boolean dispatchDisjunctMappingArgumentsMatch(MappingOperation disjunct) {
    	
    	List<EParameter> params = disjunct.getEParameters();
    	QvtOperationalEvaluationEnv evalEnv = getOperationalEvaluationEnv();
    	List<Object> args = evalEnv.getOperationArgs();
    	    	
    	if(params.size() != args.size()) {
    		return false;
    	}
    	
    	for (int i = 0; i < args.size(); i++) {
			Object nextArg = args.get(i);
			EClassifier nextParamType = params.get(i).getEType();    			
			if(nextArg != null && !evalEnv.isKindOf(nextArg, nextParamType)) {
				return false;
			}
		}
    	
    	return true;
    	
    }
    

    /**
     * Subclasses may indicate whether the given runtime exception caught is known and 
     * should be propagated. 
     */
    protected boolean canBePropagated(RuntimeException exception) {
    	// Allow the return event to be propagated from Essential OCL expressions
    	// The current m2m QVT concrete syntax does not allow this but in principal, 
    	// the QVT specification does not prohibit this
    	return exception instanceof ReturnExpEvent;
    }
    
    protected final void throwQVTException(QvtRuntimeException exception) throws QvtRuntimeException {
		getOperationalEvaluationEnv().getAdapter(InternalEvaluationEnv.class)
				.throwQVTException(exception);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    protected Object call(EOperation operation, OCLExpression<EClassifier> body, Object target, Object[] args) {
    	if(target instanceof EObject) {
    		EObject eTarget = (EObject) target;
    		if(OCLAnnotationSupport.isDynamicInstance(eTarget)) {
    			if(operation.eClass() != eTarget.eClass()) {
    				// check if not overridden for a sub-class 
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
    
    @Override
	public Object visitCollectionLiteralExp(CollectionLiteralExp<EClassifier> cl) {
		if (cl.getType() instanceof ListType) {
			Collection<Object> result = new MutableListImpl<Object>();
			for (CollectionLiteralPart<EClassifier> part : cl.getPart()) {
				if (part instanceof CollectionItem<?>) {
					// CollectionItem part
					CollectionItem<EClassifier> item = (CollectionItem<EClassifier>) part;
					OCLExpression<EClassifier> itemExp = item.getItem();
					Object itemVal = itemExp.accept(getVisitor());
					if (itemVal != null) {
						// add it to the result set
						result.add(itemVal);
					}
				} else {
					// Collection range
					CollectionRange<EClassifier> range = (CollectionRange<EClassifier>) part;
					OCLExpression<EClassifier> first = range.getFirst();
					OCLExpression<EClassifier> last = range.getLast();

					// evaluate first value
					Integer firstVal = (Integer) first.accept(getVisitor());
					Integer lastVal = (Integer) last.accept(getVisitor());
					if (!((firstVal == null) || (lastVal == null))) {
						// TODO: enhance IntegerRangeList to support multiple ranges
						// add values between first and last inclusive
						int firstInt = firstVal.intValue();
						int lastInt = lastVal.intValue();
						for (int i = firstInt; i <= lastInt; i++) {
                            result.add(new Integer(i));
                        }
					}
				} // end of collection range
			} // end of parts iterator
			return result;
		}
		return super.visitCollectionLiteralExp(cl);
	}

	@SuppressWarnings("unchecked")
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
		if(operation == null) {
			return null;
		}
		
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
					QvtPlugin.error("Failed to parse OCL annotation :" +  //$NON-NLS-1$
							getUMLReflection().getQualifiedName(contextElement) , parserException);

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
        	if (objectExp.getType() instanceof CollectionType<?, ?> == false) {
	            if (!oclIsKindOf(owner, objectExp.getType())) {
	                throw new RuntimeException(MessageFormat.format(
	                        EvaluationMessages.ExtendedOclEvaluatorVisitorImpl_InvalidObjectExpType, new Object[] {
	                                objectExp.getName(), owner, objectExp.getType() }));
	            }
        	}
        } else {
        	owner = createInstance(objectExp.getType(), (ModelParameter) objectExp.getExtent());
        	if(objectExp.getName() != null) {
        		getOperationalEvaluationEnv().replace(objectExp.getName(), owner);
        	}
        }

        return owner;
    }
    
    /**
	 * Creates tuple value representing the result of the given operation.
	 * 
	 * @param operation
	 *          the operation currently executed by this environment
	 *          
	 * @return the tuple value collecting all result parameters, never <code>null</code>
	 */
    private Tuple<EOperation, EStructuralFeature> createTupleResult(ImperativeOperation operation) {
    	boolean isMapping = operation.eClass() == ExpressionsPackage.eINSTANCE.getMappingOperation();
    	QvtOperationalEvaluationEnv evalEnv = getOperationalEvaluationEnv();
    	EList<VarParameter> resultParams = operation.getResult();
    	
    	HashMap<EStructuralFeature, Object> values = new HashMap<EStructuralFeature, Object>(2);
    	@SuppressWarnings("unchecked")
    	TupleType<EClassifier, EStructuralFeature> tupleType = (TupleType<EClassifier, EStructuralFeature>)operation.getEType();
		
    	for (EStructuralFeature tupleProp : tupleType.oclProperties()) {
			Object propVal = evalEnv.getValueOf(tupleProp.getName());
			if(propVal == null) {
				ModelParameter extent = null;
				for (VarParameter resultParam : resultParams) {
					if(tupleProp.getName().equals(resultParam.getName())) {
						MappingParameter mappingParameter = (MappingParameter) resultParam;
						extent = mappingParameter.getExtent();
						break;
					}
				}
				
				if(isMapping) {
					propVal = createInstance(tupleProp.getEType(), extent);
				}
			}
			values.put(tupleProp, propVal);
			evalEnv.replace(tupleProp.getName(), propVal, tupleProp.getEType());
		}
    	
    	return evalEnv.createTuple(operation.getEType(), values);
    }
    
    private static CollectionKind getCollectionKind(Collection<?> collection) {
    	if (collection instanceof MutableList<?>) {
    		return null;
    	}
    	if (collection instanceof Dictionary<?,?>) {
    		return null;
    	}
        if (collection instanceof ArrayList<?>) {
            return CollectionKind.SEQUENCE_LITERAL;
        }
        if (collection instanceof LinkedHashSet<?>) {
            return CollectionKind.ORDERED_SET_LITERAL;
        }
        // Remark: check Set after Ordered set
        if (collection instanceof HashSet<?>) {
            return CollectionKind.SET_LITERAL;
        }        
        if (collection instanceof Bag<?>) {
            return CollectionKind.BAG_LITERAL;
        }
        return null;
    }

    private List<Object> makeArgs(OperationCallExp<EClassifier, EOperation> operationCallExp) {
        List<Object> argValues = new ArrayList<Object>();
        for (OCLExpression<EClassifier> arg : operationCallExp.getArgument()) {
            Object value = arg.accept(getVisitor());
            argValues.add(value);
        }

        return argValues;
    }
    
	private List<Object> makeEntryOperationArgs(ImperativeOperation entryPoint, OperationalTransformation module) {
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
	        	Object envArg = getOperationalEvaluationEnv().getOperationArgs().get(matchedIndex);
	        	ModelInstance argModel = (ModelInstance) envArg;
	        	ModelParameterExtent argExtent = argModel.getExtent();
				List<EObject> initialObjects = argExtent.getInitialObjects();
				if(!initialObjects.isEmpty()) {
					args.add(initialObjects.get(0));
				}
	        }
			else {
                throw new IllegalArgumentException("entry operation arguments mismatch: no argument for " + mappingParam + " parameter"); //$NON-NLS-1$ //$NON-NLS-2$
			}

	        paramIndex++;
		}
		return args;
	}

//    private EStructuralFeature getRenamedProperty(EStructuralFeature property) {
//    	EAnnotation annotation = property.getEAnnotation(Environment.OCL_NAMESPACE_URI);
//    	if (annotation != null) {
//    		for (EObject nextAnn : annotation.getContents()) {
//    			if (false == nextAnn instanceof Constraint) {
//    				continue;
//    			}
//    			Constraint cnt = (Constraint) nextAnn;
//    			if (QvtOperationalEnv.RENAMED_PROPERTY_STEREOTYPE.equals(cnt.getStereotype())
//    					&& !cnt.getConstrainedElements().isEmpty()
//    					&& cnt.getConstrainedElements().get(0) instanceof EStructuralFeature) {
//    				return (EStructuralFeature) cnt.getConstrainedElements().get(0);
//    			}
//    		}
//    	}
//    	return property;
//    }
    
    /**
	* Wraps the environment's creatInstance() and transforms failures to QVT exception
	*/    
	protected Object createInstance(EClassifier type, ModelParameter extent) throws QvtRuntimeException {
		Object newInstance = null;
		try {			
			if(type instanceof CollectionType<?, ?>) {
				@SuppressWarnings("unchecked")
				CollectionType<EClassifier, EOperation> collectionType = (CollectionType<EClassifier, EOperation>)type;
				newInstance = EvaluationUtil.createNewCollection(collectionType);
			} else {
				newInstance = getOperationalEvaluationEnv().createInstance(type, extent);

				EFactory eFactory = type.getEPackage().getEFactoryInstance();
				if(eFactory instanceof IntermediateClassFactory) {
					IntermediateClassFactory intermFactory = (IntermediateClassFactory) eFactory;
					intermFactory.doInstancePropertyInit(newInstance, getQVTVisitor());
				}
			}

		} catch (IllegalArgumentException e) {
			throwQVTException(new QvtRuntimeException(e));
		}
		
		return newInstance;
	}
   
    protected EObject setCurrentEnvInstructionPointer(EObject node) {
    	InternalEvaluationEnv internEnv = getOperationalEvaluationEnv().getAdapter(InternalEvaluationEnv.class);
    	if(node != null) {
    		return internEnv.setCurrentIP(node);
    	}
    	return internEnv.getCurrentIP();
    }
    
    protected InternalEvaluator createInterruptibleVisitor() {
    	final EvaluationMonitor monitor = getContext().getMonitor();
    	    
    	class InterruptVisitor extends QvtGenericEvaluationVisitor.Any implements InternalEvaluator {
    		public InterruptVisitor() {
    			super(QvtOperationalEvaluationVisitorImpl.this);
			}
    		
    		public Object execute(OperationalTransformation transformation) throws QvtRuntimeException {
    			return QvtOperationalEvaluationVisitorImpl.this.execute(transformation);
    		}
    		
    		public QvtOperationalEvaluationEnv getOperationalEvaluationEnv() {
    			return QvtOperationalEvaluationVisitorImpl.this.getOperationalEvaluationEnv();
    		}
    		
    		public void setOperationalEvaluationEnv(QvtOperationalEvaluationEnv evalEnv) {
    			QvtOperationalEvaluationVisitorImpl.this.setOperationalEvaluationEnv(evalEnv);
    		}
    		
    		public IContext getContext() {
    			return QvtOperationalEvaluationVisitorImpl.this.getContext();
    		}

    		public ModuleInstance callTransformationImplicitConstructor(OperationalTransformation transformation, List<ModelInstance> args) {
    			return QvtOperationalEvaluationVisitorImpl.this.callTransformationImplicitConstructor(transformation, args);
    		}
    		
    		public OperationCallResult runMainEntry(OperationalTransformation transformation, List<Object> args) {
				return QvtOperationalEvaluationVisitorImpl.this.runMainEntry(transformation, args);
			}
    		
    		@Override
    		protected Object genericVisitAny(Object object) {
    			if(monitor != null && monitor.isCanceled()) {    				
    				throwQVTException(new QvtInterruptedExecutionException());    				
    			}
    			
    			// set the current instruction pointer
    			if(object instanceof EObject) {
    				InternalEvaluationEnv evalEnv = getOperationalEvaluationEnv().getAdapter(InternalEvaluationEnv.class);
    				evalEnv.setCurrentIP((EObject)object);
    			}
    			
    			return null;
    		}    		
    	};
    	
    	return new InterruptVisitor();
    }

	public OperationCallResult runMainEntry(OperationalTransformation transformation, List<Object> args) {
		ImperativeOperation entryOperation = QvtOperationalParserUtil.getMainOperation(transformation);				
		
		OperationCallResult result = executeImperativeOperation(entryOperation, null, args, false);        	        					
		processDeferredTasks();
		return result;
	}    
    
    /**
     * Performs cast on the result of {@link #getVisitor()}; 
     * @see #getVisitor()
     */
    protected QvtOperationalEvaluationVisitor getQVTVisitor() {
    	return (QvtOperationalEvaluationVisitor)getVisitor();
    }
    
	private Object createFromString(final EClassifier type, final String stringValue) {
		if(stringValue == null) {
			return null;
		}
		
        if (!QvtOperationalUtil.isCreateFromStringSupported(type)) {
            return getInvalid();
        }
        
        // QVT primitive type
        // FIXME - should rather used primitive type singletons from the Standard library
        try {
	        if (type instanceof org.eclipse.ocl.ecore.PrimitiveType && PrimitiveType.INTEGER_NAME.equals(((org.eclipse.ocl.ecore.PrimitiveType) type).getName())) {
	            return new Integer(stringValue);
	        } 
	        if (type instanceof org.eclipse.ocl.ecore.PrimitiveType && PrimitiveType.REAL_NAME.equals(((org.eclipse.ocl.ecore.PrimitiveType) type).getName())) {
	            return new Double(stringValue);
	        }
        } catch (NumberFormatException e) {
        	return getInvalid();
		}
        
        if (type instanceof org.eclipse.ocl.ecore.PrimitiveType && PrimitiveType.STRING_NAME.equals(((org.eclipse.ocl.ecore.PrimitiveType) type).getName())) {
            return new String(stringValue);
        } 
        
        if (type instanceof org.eclipse.ocl.ecore.PrimitiveType && PrimitiveType.BOOLEAN_NAME.equals(((org.eclipse.ocl.ecore.PrimitiveType) type).getName())) {
            return Boolean.valueOf(stringValue);
        } 
        // Enumeration
        if (type instanceof EDataType) {
        	if(type.getEPackage() != null && type.getEPackage().getEFactoryInstance() != null) {
	            Object value = type.getEPackage().getEFactoryInstance().createFromString((EDataType) type, stringValue);
	            if (value != null) {
	            	return value;
	            }
			}
        }
        
        return getInvalid();
	}
    
	/**
	 * TODO - Avoid using this exception return expression to interrupt execution flow for 
	 * immediate return from an operation.
	 * Though, if the last statement in a body is return expression, no exception is thrown, we
	 * should try to avoid this cost to be paid in general
	 */
	private static class ReturnExpEvent extends RuntimeException {
		private static final long serialVersionUID = 2971434369853642555L;		
		private final OperationCallResult fResult;
		
		ReturnExpEvent(Object returnValue, QvtOperationalEvaluationEnv evalEnv) {
			fResult = new OperationCallResult(returnValue, evalEnv);
		}
		
		public OperationCallResult getResult() {
			return fResult;
		}
	}

}