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
package org.eclipse.m2m.qvt.oml.ast.environment;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.common.io.CResourceRepositoryContext;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompilerKernel;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.expressions.Property;
import org.eclipse.m2m.qvt.oml.internal.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.qvt.oml.internal.ast.parser.ValidationMessages;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS;
import org.eclipse.m2m.qvt.oml.ocl.transformations.Library;
import org.eclipse.m2m.qvt.oml.ocl.transformations.LibraryCreationException;
import org.eclipse.m2m.qvt.oml.ocl.transformations.LibraryOperation;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.options.ProblemOption;
import org.eclipse.osgi.util.NLS;

public class QvtOperationalFileEnv extends QvtOperationalEnv {

    public static final String THIS_VAR_QNAME_SUFFIX = "." + THIS; //$NON-NLS-1$
	
    private final QvtCompilerKernel myKernel;
	
	protected QvtOperationalFileEnv(final QvtOperationalEnv parent, final CFile file, final QvtCompilerKernel kernel) {
		super(parent, new EPackageRegistryImpl());
		myFile = file;
        myKernel = kernel;

        // Eliminate parsing warning on "" occurrences, used in model types URIs, etc.
        // TODO - solve in QVT grammar
        setOption(ProblemOption.ELEMENT_NAME_QUOTE_ESCAPE, ProblemHandler.Severity.OK);
	}

    public QvtCompilerKernel getKernel() {
        return myKernel;
    }

	@Override
	public MetamodelRegistry getMetamodelRegistry() {
		
		MetamodelRegistry registry = getKernel()
			.getMetamodelRegistryProvider().getRegistry(new CResourceRepositoryContext(myFile));
		
		if(registry != null) {
			return registry;
		}
		return super.getMetamodelRegistry();
	}
	
	public CFile getFile() {
        return myFile;
    }

    public String getUnitName() {
        return myFile.getUnitName();
	}

	public String getExpectedPackageName() {
		return getKernel().getExpectedPackageName(myFile.getParent());
	}
	
    public Module getModule(MappingModuleCS mmas) {
        return getKernel().getModule(mmas);
    }
    
    public Module createModule(MappingModuleCS mmas, QvtCompilerOptions options,
    		EcoreEnvironment env, CFile cFile) {
        Module module = getKernel().createModule(mmas, options, env, cFile);
        
		Variable<EClassifier, EParameter> thisVar = ExpressionsFactory.eINSTANCE.createVariable();
		String prefix = QvtOperationalParserUtil.getMappingModuleSimpleName(mmas.getHeaderCS());
		this.myQualifiedThisName = prefix + THIS_VAR_QNAME_SUFFIX;
		thisVar.setName(myQualifiedThisName);
		thisVar.setType(module);
        addElement(myQualifiedThisName, thisVar, false);
        
        return module; 
    }
    
    @Override
    public Variable<EClassifier, EParameter> lookup(String name) {
    	if(THIS.equals(name)) {
    		return super.lookup(myQualifiedThisName);
    	}
    	return super.lookup(name);
    }
    
	@Override
	public final EClass getModuleContextType() {
		if(myQualifiedThisName != null) {
			Variable<EClassifier, EParameter> var = lookup(myQualifiedThisName);			
			return var != null ? (EClass)var.getType() : null;
		}
		return null;
	}
	
    public void addModuleProperty(Property prop) {
        if (getModuleContextType().getEStructuralFeature(prop.getName()) != null) {
            reportError(NLS.bind(ValidationMessages.SemanticUtil_15,
                    new Object[] { prop.getName() }), prop.getStartPosition(), prop.getEndPosition());
        } else {
            if (prop.getName() != null && prop.getEType() != null) {
                EClassifier type = prop.getEType();
        		EStructuralFeature sFeature = null;
        		if(type instanceof EClass) { 
        			sFeature = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEReference();
        		} else {
        			sFeature = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();        			
        		}
        		
    			getModuleContextType().getEStructuralFeatures().add(sFeature);
        		sFeature.setName(prop.getName());        		
        		sFeature.setEType(prop.getEType());                
            }
        }
    }
	    
    @Override
    public String toString() {    
    	return  "Env:" + myFile.getFullPath(); //$NON-NLS-1$
    }
    
    @Override
	public List<Module> getJavaLibs() {
    	return myLibs == null ? Collections.<Module>emptyList() : Collections.unmodifiableList(myLibs);
	}
    
	public void registerLibrary(Library lib) throws LibraryCreationException {
		if(myLibs == null) {
			myLibs = new LinkedList<Module>();
		}
			 
		Module libModule = org.eclipse.m2m.qvt.oml.expressions.ExpressionsFactory.eINSTANCE.createModule();
		libModule.setName(lib.getId());
		myLibs.add(libModule);
		
		Variable<EClassifier, EParameter> var = ExpressionsFactory.eINSTANCE.createVariable();
		var.setName(libModule.getName() + ".this");
		var.setType(libModule);
		this.addElement(var.getName(), var, false);
		
		for (LibraryOperation libOp : lib.getLibraryOperations()) {
	        QvtLibraryOperation qvtLibOp = new QvtLibraryOperation(this, libOp);
	        EClassifier ctxType = qvtLibOp.getContextType();
	        
	        if(ctxType  == getOCLStandardLibrary().getOclVoid()) {
	        	ctxType = libModule;
	        }
	
	        getQVTStandardLibrary().defineOperation(this, libOp,
	        		ctxType, qvtLibOp.getReturnType(),
	        		libOp.getName(), qvtLibOp.getParamTypes());	        
		}
	}

	private final CFile myFile;
	private String myQualifiedThisName;
	private List<Module> myLibs;
}
