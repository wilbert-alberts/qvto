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
import org.eclipse.m2m.internal.qvt.oml.emf.util.modelparam.ResourceEObject;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner.In;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner.Out;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.config.QvtConfigurationProperty;
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
	
    public EObject loadInput(URI inputObjectURI) throws MdaException {
    	return EmfUtil.loadModel(inputObjectURI, myModule.getCompiler().getResourceSet());
    }
    
    public void setQvtCompilerOptions(QvtCompilerOptions options) {
    	myModule.setQvtCompilerOptions(options);
    }
    
	public Out run(In in) throws MdaException {
        CompiledModule module = myModule.getModule();

        Iterator<TransformationParameter> itrParam = getParameters().iterator();
        List<Object> inputs = new ArrayList<Object>(in.getSources().length);
        for (EObject inObject : in.getSources()) {
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
            	EObject input = EmfUtil.resolveSource(inObject, mmClass);
            	inputs.add(input);
            }
            catch (WrappedException e) {
            	throw new MdaException(e.getCause());
            }
        }
        Object outObj = evaluate(myModule.getCompiler(), module, inputs, in.getContext());
        
        if (false == outObj instanceof QvtEvaluationResult) {
            return new Out(Collections.<ModelExtentContents>emptyList(),
            		Collections.emptyList(), in.getContext().getTrace());
        }

        return new Out(((QvtEvaluationResult) outObj).getModelExtents(),
        		((QvtEvaluationResult) outObj).getOutParamValues(), in.getContext().getTrace());
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
    
	private Object evaluate(QvtCompiler compiler, CompiledModule module, List<Object> args, IContext context) {
		QvtOperationalEnvFactory factory = getEnvironmentFactory();

		QvtOperationalEvaluationEnv evaluationEnv = factory.createEvaluationEnvironment(context, null);
		setArguments(evaluationEnv, (OperationalTransformation) module.getModule(), args);
		
		QvtOperationalFileEnv rootEnv = factory.createEnvironment(module.getSource(), compiler.getKernel());

		EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>		
			evaluator = factory.createEvaluationVisitor(rootEnv, evaluationEnv, null);
		
		return module.getModule().accept(evaluator);
	}

	private static void setArguments(QvtOperationalEvaluationEnv evalEnv, OperationalTransformation module, List<Object> args) {
		List<Object> operationArgs = evalEnv.getOperationArgs();

		int argCount = 0;
		for (ModelParameter modelParam : module.getModelParameter()) {
			ModelParameterExtent extent;			
			if(modelParam.getKind() != org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind.OUT) {
				if(argCount >= args.size()) {
					throw new IllegalArgumentException("Invalid count of input arguments"); //$NON-NLS-1$ 
				}

				Object nextArg = args.get(argCount++);
			
				if(nextArg instanceof EObject == false) {
					throw new IllegalArgumentException("EObject argument required"); //$NON-NLS-1$
				} else if(nextArg instanceof ResourceEObject) {
		    		extent = new ModelParameterExtent(((ResourceEObject) nextArg).getChildren()); 
		    	} else {
		    		extent = new ModelParameterExtent((EObject) nextArg);
		    	}
				
			} else {
				extent = new ModelParameterExtent();
			}
			
	    	operationArgs.add(extent);			
		}
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
