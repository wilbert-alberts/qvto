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
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
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
import org.eclipse.m2m.internal.qvt.oml.runtime.QvtRuntimePlugin;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner.In;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner.Out;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.config.QvtConfigurationProperty;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtEvaluationResult;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEnvFactory;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtOperationalFileEnv;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.launch.SafeRunner;
import org.eclipse.m2m.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.qvt.oml.library.IContext;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.osgi.util.NLS;

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
	
	public boolean isOK() {
		try {
			return myModule.getModule().getErrors().length == 0;
		} catch (MdaException e) {
			return false;
		}		
	}
	    
    public IStatus canRun (EObject input) throws MdaException {
		EClass inClass = myModule.getIn();
        if (inClass == null) {
            return new Status(IStatus.ERROR, QvtRuntimePlugin.ID, 0, Messages.QvtInterpretedTransformation_NotExecutable, null);
        }

        EObject in = null;
        try {
        	in = EmfUtil.resolveSource(input, inClass);
        }
        catch (WrappedException e) {
        	throw new MdaException(e.getCause());
        }
        
        if (inClass.isInstance(in)) {
		    return new Status(IStatus.OK, QvtRuntimePlugin.ID, 0, "", null); //$NON-NLS-1$
        } 
		return new Status(IStatus.ERROR, QvtRuntimePlugin.ID, 0, 
				NLS.bind(org.eclipse.m2m.internal.qvt.oml.runtime.launch.Messages.QvtValidator_IncompatibleInputTypes,
                        EmfUtil.getFullName(in.eClass()),
                        EmfUtil.getFullName(inClass)                        
                        ), 
                null);
    }
    
    public EObject loadInput(URI inputObjectURI) throws MdaException {
    	return EmfUtil.loadModel(inputObjectURI, myModule.getCompiler().getResourceSet());
    }
    
	public Out run(In in) throws MdaException {
        CompiledModule module = myModule.getModule();
        
        List<Object> inputs = new ArrayList<Object>(1);
        for (EObject inObject : in.getSources()) {
            try {
            	EObject input = EmfUtil.resolveSource(inObject, myModule.getIn());
            	inputs.add(input);
            }
            catch (WrappedException e) {
            	throw new MdaException(e.getCause());
            }
        }
        Object outObj = evaluate(myModule.getCompiler(), module, inputs, in.getContext());
        
        if (false == outObj instanceof QvtEvaluationResult) {
            throw new MdaException(Messages.QvtInterpreter_Transformation_failed); 
        }

        return new Out(((QvtEvaluationResult) outObj).getModelExtents(),
        		((QvtEvaluationResult) outObj).getOutParamValues(), in.getContext().getTrace());
    }
	
	public String getModuleName() throws MdaException {
		return myModule.getModuleName();
	}

	public EClass getIn() throws MdaException {
		return myModule.getIn();
	}

	public EClass getOut() throws MdaException {
		return myModule.getOut();
	}

	public List<TransformationParameter> getParameters() throws MdaException {
		return myModule.getParameters();
	}

    public Set<QvtConfigurationProperty> getConfigurationProperties() throws MdaException {
        return myModule.getConfigurationProperties();
    }
    
    public static SafeRunner.IRunner getSafeRunner(CompiledModule module) throws CoreException {
        EClass[] classes = new EClass[] {
                QvtModule.getInType(module),
                QvtModule.getReturnType(module),
        };
        
        return SafeRunner.getSafeRunner(classes);
    }
    
    protected QvtOperationalEnvFactory getEnvironmentFactory() {
    	return new QvtOperationalEnvFactory();
    }
    
	private Object evaluate(QvtCompiler compiler, CompiledModule module, List<Object> args, IContext context) {
		QvtOperationalEnvFactory factory = getEnvironmentFactory();

		QvtOperationalEvaluationEnv evaluationEnv = factory.createEvaluationEnvironment(context, null);
		evaluationEnv.getOperationArgs().addAll(args);
		
		QvtOperationalFileEnv rootEnv = factory.createEnvironment(null, module.getSource(), compiler);

		EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>		
			evaluator = factory.createEvaluationVisitor(rootEnv, evaluationEnv, null);
		
		return module.getModule().accept(evaluator);
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
