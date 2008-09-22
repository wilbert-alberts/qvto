/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.ast.env;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.cst.adapters.ModelTypeMetamodelsAdapter;
import org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.ocl.transformations.Library;
import org.eclipse.m2m.internal.qvt.oml.ocl.transformations.LibraryCreationException;
import org.eclipse.m2m.internal.qvt.oml.stdlib.LegacyNativeLibSupport;
import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.options.ProblemOption;

public class QvtOperationalModuleEnv extends QvtOperationalEnv {

    public static final String THIS_VAR_QNAME_SUFFIX = "." + THIS; //$NON-NLS-1$

	private String myQualifiedThisName;
	private Module myContextModule;	
	private List<Module> myLibs;
	private List<Variable<EClassifier, EParameter>> myModelParameters = Collections.emptyList();    
	
	public QvtOperationalModuleEnv(EPackage.Registry registry) {
		super(registry);

        // Eliminate parsing warning on "" occurrences, used in model types URIs, etc.
        // TODO - solve in QVT grammar
        setOption(ProblemOption.ELEMENT_NAME_QUOTE_ESCAPE, ProblemHandler.Severity.OK);
        setOption(ProblemOption.STRING_CASE_CONVERSION, ProblemHandler.Severity.OK);        
	}
			    
    public void setContextModule(Module module) {
    	if(myQualifiedThisName != null) {
    		deleteElement(myQualifiedThisName);    	
    	}
    	
    	myQualifiedThisName = null;
		myContextModule = null;    	

    	if(module != null) {
    		myContextModule = module;
    		myQualifiedThisName = getThisVariableName(module);
    		
    		Variable<EClassifier, EParameter> thisVar = ExpressionsFactory.eINSTANCE.createVariable();
    		thisVar.setName(myQualifiedThisName);
    		thisVar.setType(module);    		
            addElement(myQualifiedThisName, thisVar, false);    		
    	}
    	
    	if(module instanceof OperationalTransformation) {
    		registerModelParameters((OperationalTransformation)module);
    	}
    }
    
    public ModelParameter lookupModelParameter(String name, DirectionKind directionKind) {
		if(name == null) {
			return null;
		}
		
		for (Variable<EClassifier, EParameter> var : myModelParameters) {
			ModelParameter modelParam = (ModelParameter) var.getRepresentedParameter();
			if (directionKind == DirectionKind.OUT) {
				if (modelParam.getKind() == DirectionKind.IN) {
					continue;
				}
			}

			String nextParamName = modelParam.getName();
			if (nextParamName != null) {
				if (nextParamName.equals(name)) {
					return modelParam;
				}
			}
		}
		
		return null;
	}
    
	/**
	 * Get names of all available extents of given direction kind in this
	 * environments.
	 * 
	 * @param directionKind
	 *            filtering condition to be satisfied by returned extents or
	 *            <code>null</code> if all kinds are acceptable
	 * @return list of corresponding model parameter names
	 */
	public List<String> getAllExtentNames(DirectionKind directionKind) {
		List<String> result = new ArrayList<String>(myModelParameters.size());
		for (Variable<EClassifier, EParameter> var : myModelParameters) {
			ModelParameter modelParam = (ModelParameter) var.getRepresentedParameter();
			if (directionKind == DirectionKind.OUT) {
				if (modelParam.getKind() == DirectionKind.IN) {
					continue;
				}
			}

			String nextParam = modelParam.getName();
			if(nextParam != null && nextParam.length() > 0) {
				result.add(nextParam);
			}
		}
		
		return Collections.unmodifiableList(result);
	}
	
	private List<ModelParameter> getModelParameters() {
		List<ModelParameter> result = new ArrayList<ModelParameter>(myModelParameters.size());
		for (Variable<EClassifier, EParameter> modelParamVar : myModelParameters) {
			result.add((ModelParameter)modelParamVar.getRepresentedParameter());
		}
		return result;
	}
	
	public ModelParameter resolveModelParameter(EClassifier type, DirectionKind directionKind) {
		if (!isMayBelongToExtent(type)) {
			return null;
		}
		return findModelParameter(type, directionKind, getModelParameters());
	}
	
	static ModelParameter findModelParameter(EClassifier type, DirectionKind directionKind, 
			Collection<ModelParameter> modelParameters) {
		EObject rootContainer = EcoreUtil.getRootContainer(type);
		
		// lookup explicit extent 
		for (ModelParameter modelParam : modelParameters) {
			if (directionKind == DirectionKind.OUT) {
				if (modelParam.getKind() == DirectionKind.IN) {
					continue;
				}
			}
			List<EPackage> metamodels = ModelTypeMetamodelsAdapter.getMetamodels(modelParam.getEType());
			if (!metamodels.isEmpty() && rootContainer == metamodels.get(0)) {
				return modelParam;
			}
		}
		
		// lookup implicit extent 
		for (ModelParameter modelParam : modelParameters) {
			if (directionKind == DirectionKind.OUT) {
				if (modelParam.getKind() == DirectionKind.IN) {
					continue;
				}
			}
			return modelParam;
		}
		
		return null;
	}    
    
    private static String getThisVariableName(Module module) {
    	String prefix = module.getName() != null ? module.getName() : ""; //$NON-NLS-1$    	
    	return prefix + THIS_VAR_QNAME_SUFFIX;    	
    }

    @Override
    public Variable<EClassifier, EParameter> lookup(String name) {
    	if(THIS.equals(name)) {
    		return super.lookup(myQualifiedThisName);
    	}
    	return super.lookup(name);
    }
    
	@Override
	public final Module getModuleContextType() {
		return myContextModule;
	}
	    
    @Override
	public List<Module> getNativeLibs() {
    	return myLibs == null ? Collections.<Module>emptyList() : Collections.unmodifiableList(myLibs);
	} 
    
	public Module defineNativeLibrary(Library lib) throws LibraryCreationException {
		if(myLibs == null) {
			myLibs = new LinkedList<Module>();
		}
			 
		Module libModule = LegacyNativeLibSupport.INSTANCE.defineLibrary(this, lib);
		myLibs.add(libModule);
		
		Variable<EClassifier, EParameter> var = ExpressionsFactory.eINSTANCE.createVariable();
		var.setName(libModule.getName() + THIS_VAR_QNAME_SUFFIX);
		var.setType(libModule);
		this.addElement(var.getName(), var, false);
		
		return libModule;
	}

	private boolean isMayBelongToExtent(EClassifier myType) {
		return myType != null 
			&& getOCLStandardLibrary().getOclVoid() != myType
			&& getOCLStandardLibrary().getOclInvalid() != myType;
	}
	
    
	private void registerModelParameters(OperationalTransformation module) {
		List<Variable<EClassifier, EParameter>> modelParameters = new ArrayList<Variable<EClassifier,EParameter>>(module.getModelParameter().size());
		for (ModelParameter modelParam : module.getModelParameter()) {
            Variable<EClassifier, EParameter> var = ExpressionsFactory.eINSTANCE.createVariable();
            var.setName(modelParam.getName());
            var.setType(modelParam.getEType());
            var.setRepresentedParameter(modelParam);
            modelParameters.add(var);
		}
		registerModelParametersImpl(modelParameters);
	}
	
	private void registerModelParametersImpl(List<Variable<EClassifier, EParameter>> modelParameters) {
		myModelParameters = modelParameters;
		for (Variable<EClassifier, EParameter> var : modelParameters) {
            addElement(var.getName(), var, true);
		}
	}	
}
