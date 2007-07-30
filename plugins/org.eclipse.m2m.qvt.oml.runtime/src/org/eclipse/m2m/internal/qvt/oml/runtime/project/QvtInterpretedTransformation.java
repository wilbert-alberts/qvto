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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.runtime.QvtRuntimePlugin;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner.In;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner.Out;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.config.QvtConfigurationProperty;
import org.eclipse.m2m.qvt.oml.ast.environment.QvtEvaluationResult;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalParser;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.launch.SafeRunner;
import org.eclipse.m2m.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
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
        SafeRunner.IRunner runner;
        CompiledModule module = myModule.getModule();
        try {
            runner = getSafeRunner(module);
        }
        catch (CoreException e) {
            throw new MdaException(e.getMessage(), e);
        }
        
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
        Object outObj = new QvtOperationalParser().evaluate(myModule.getCompiler(), module,
        		inputs, in.getContext(), runner);
        if (false == outObj instanceof QvtEvaluationResult) {
            throw new MdaException(Messages.QvtInterpreter_Transformation_failed); 
        }

        return new Out(((QvtEvaluationResult) outObj).getModelExtents(), in.getContext().getTrace());
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
    
    private final QvtModule myModule;
}
