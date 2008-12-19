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
package org.eclipse.m2m.internal.qvt.oml.runtime.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.internal.qvt.oml.ast.env.InternalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelExtentContents;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelParameterExtent;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtEvaluationResult;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalFileEnv;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModelInstance;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModelParameterHelper;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner.In;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner.Out;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.config.QvtConfigurationProperty;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;

public class QvtInterpretedTransformation implements QvtTransformation {

	public QvtInterpretedTransformation(IFile transformationFile) {
    	myModule = new WorkspaceQvtModule(transformationFile);
    }
	
	public QvtInterpretedTransformation(QvtModule qvtModule) {
		if(qvtModule == null) {
			throw new IllegalArgumentException("Null QvtModule"); //$NON-NLS-1$
		}
    	myModule = qvtModule;
    }
	
	public QvtModule getModule() {
		return myModule;
	}
	
    public ModelContent loadInput(URI inputObjectURI) throws MdaException {
    	return EmfUtil.loadModel(inputObjectURI, myModule.getCompiler().getResourceSet());
    }
    
    public void setQvtCompilerOptions(QvtCompilerOptions options) {
    	myModule.setQvtCompilerOptions(options);
    }
    
	public Out run(In in) throws MdaException {
        CompiledModule module = myModule.getModule();

        Iterator<TransformationParameter> itrParam = getParameters().iterator();
        List<ModelContent> inputs = new ArrayList<ModelContent>(in.getSources().length);
        for (ModelContent inSource : in.getSources()) {
        	TransformationParameter transfParam = null;
        	while (itrParam.hasNext()) {
        		transfParam = itrParam.next();
        		if (transfParam.getDirectionKind() != DirectionKind.OUT) {
        			break;
        		}
        		transfParam = null;
        	}
        	EObject mmClass = null;
        	if (transfParam != null) {
        		if (transfParam.getEntryType() != null) {
        			mmClass = transfParam.getEntryType();
        		}
        		else if (!transfParam.getMetamodels().isEmpty()) {
        			mmClass = transfParam.getMetamodels().get(0);
        		}
        	}
            try {
            	inputs.add(inSource.getResolvedContent(mmClass));
            }
            catch (WrappedException e) {
            	throw new MdaException(e.getCause());
            }
        }
        
        return evaluate(myModule.getCompiler(), module, inputs, in.getContext());
    }
	
	public String getModuleName() throws MdaException {
		return myModule.getModule().getModule().getName();
	}

	public List<TransformationParameter> getParameters() throws MdaException {
		return myModule.getParameters();
	}

    public Set<QvtConfigurationProperty> getConfigurationProperties() throws MdaException {
        return myModule.getConfigurationProperties();
    }
    
	public ResourceSet getResourceSet() throws MdaException {
		return myModule.getCompiler().getResourceSet();
	}

	public void cleanup() throws MdaException {
		myModule.getCompiler().cleanup();
	}

	protected QvtOperationalEnvFactory getEnvironmentFactory() {
    	return new QvtOperationalEnvFactory();
    }
    
	private Out evaluate(QvtCompiler compiler, CompiledModule module, List<ModelContent> args, IContext context) {
		QvtOperationalEnvFactory factory = getEnvironmentFactory();

		QvtOperationalEvaluationEnv evaluationEnv = factory.createEvaluationEnvironment(context, null);
		setArguments(evaluationEnv, (OperationalTransformation) module.getModule(), args);
		
		QvtOperationalFileEnv rootEnv = factory.createEnvironment(module.getSource(), compiler.getKernel());

		EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>		
			evaluator = factory.createEvaluationVisitor(rootEnv, evaluationEnv, null);
		
		Trace traces = evaluationEnv.getAdapter(InternalEvaluationEnv.class).getTraces(); 
		Object outObj = module.getModule().accept(evaluator);
		
        if (false == outObj instanceof QvtEvaluationResult) {
            return new Out(Collections.<ModelExtentContents>emptyList(),
            		Collections.emptyList(), traces);
        }

        return new Out(((QvtEvaluationResult) outObj).getModelExtents(),
        		((QvtEvaluationResult) outObj).getOutParamValues(), traces);
	}

	private static void setArguments(QvtOperationalEvaluationEnv evalEnv, OperationalTransformation transformation, List<ModelContent> args) {
		List<ModelParameterExtent> tranformArgs = new ArrayList<ModelParameterExtent>(); 
		int argCount = 0;
		for (ModelParameter modelParam : transformation.getModelParameter()) {
			ModelParameterExtent extent;			
			if(modelParam.getKind() != org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind.OUT) {
				if(argCount >= args.size()) {
					throw new IllegalArgumentException("Invalid count of input arguments"); //$NON-NLS-1$ 
				}

				ModelContent nextArg = args.get(argCount++);
			
				if(nextArg == null || nextArg.getContent().isEmpty()) {
					throw new IllegalArgumentException("Non-empty model argument is required"); //$NON-NLS-1$
		    	} else {
		    		extent = new ModelParameterExtent(nextArg.getContent());
		    	}
				
			} else {
				extent = new ModelParameterExtent();
			}
			
	    	tranformArgs.add(extent);			
		}

		List<ModelInstance> modelArgs = ModelParameterHelper.createModelArguments(transformation, tranformArgs);
		evalEnv.getOperationArgs().addAll(modelArgs);		
	}
	
	@Override
	public String toString() {
		try {
			return getModuleName();
		}
		catch (MdaException e) {
		}
		return super.toString();
	}
    
    private final QvtModule myModule;

}
