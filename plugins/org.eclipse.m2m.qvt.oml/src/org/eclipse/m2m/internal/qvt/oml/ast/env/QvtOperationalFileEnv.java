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
package org.eclipse.m2m.internal.qvt.oml.ast.env;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.CResourceRepositoryContext;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerKernel;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.ocl.transformations.Library;
import org.eclipse.m2m.internal.qvt.oml.ocl.transformations.LibraryCreationException;
import org.eclipse.m2m.internal.qvt.oml.stdlib.LegacyNativeLibSupport;
import org.eclipse.m2m.internal.qvt.oml.stdlib.QVTUMLReflection;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.options.ProblemOption;
import org.eclipse.ocl.utilities.UMLReflection;

public class QvtOperationalFileEnv extends QvtOperationalEnv {

    public static final String THIS_VAR_QNAME_SUFFIX = "." + THIS; //$NON-NLS-1$
	
    private final QvtCompilerKernel myKernel;
    private QVTUMLReflection myQvtUMLReflection;
	
	protected QvtOperationalFileEnv(final QvtOperationalEnv parent, final CFile file, final QvtCompilerKernel kernel) {
		super(parent, new EPackageRegistryImpl());
		myFile = file;
        myKernel = kernel;

        // Eliminate parsing warning on "" occurrences, used in model types URIs, etc.
        // TODO - solve in QVT grammar
        setOption(ProblemOption.ELEMENT_NAME_QUOTE_ESCAPE, ProblemHandler.Severity.OK);
        setOption(ProblemOption.STRING_CASE_CONVERSION, ProblemHandler.Severity.OK);
        
    	QvtOperationalStdLibrary.INSTANCE.importTo(this);        
	}
	
	@Override
	public UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> getUMLReflection() {
		if(myQvtUMLReflection == null) {
			myQvtUMLReflection = new QVTUMLReflection(super.getUMLReflection(), QvtOperationalStdLibrary.INSTANCE);
		}
		
		return myQvtUMLReflection;
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
    
    public Module createModule(MappingModuleCS mmas, QvtCompilerOptions options, CFile cFile) {
        Module module = getKernel().createModule(mmas, options, this, cFile);
        
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
	public final Module getModuleContextType() {
		if(myQualifiedThisName != null) {
			Variable<EClassifier, EParameter> var = lookup(myQualifiedThisName);			
			return var != null ? (Module)var.getType() : null;
		}
		return null;
	}
	
	    
    @Override
    public String toString() {    
    	return  "Env:" + myFile.getFullPath(); //$NON-NLS-1$
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

	private final CFile myFile;
	private String myQualifiedThisName;
	private List<Module> myLibs;
}
