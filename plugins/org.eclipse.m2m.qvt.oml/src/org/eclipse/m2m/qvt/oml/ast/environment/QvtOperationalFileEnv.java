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

import java.util.LinkedHashMap;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.common.io.CResourceRepositoryContext;
import org.eclipse.m2m.qvt.oml.compiler.ParsedModuleCS;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.m2m.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.Variable;

public class QvtOperationalFileEnv extends QvtOperationalEnv {

	protected QvtOperationalFileEnv(final QvtOperationalEnv parent, final CFile file, final QvtCompiler compiler) {
		super(parent, compiler, new EPackageRegistryImpl());
		myFile = file;		
	}

	@Override
	public MetamodelRegistry getMetamodelRegistry() {
		
		MetamodelRegistry registry = getCompiler()
			.getMetamodelRegistryProvider().getRegistry(new CResourceRepositoryContext(myFile));
		
		if(registry != null) {
			return registry;
		}
		return super.getMetamodelRegistry();
	}
	
	public String getUnitName() {
        return myFile.getUnitName();
	}

	public String getExpectedPackageName() {
		return getCompiler().getExpectedPackageName(myFile.getParent());
	}
	
    public Module getModule(MappingModuleCS mmas) {
        return getCompiler().getModule(mmas);
    }
    
    public Module createModule(MappingModuleCS mmas, QvtCompilerOptions options,
    		EcoreEnvironment env, ParsedModuleCS parsedModuleCS) {
        Module module = getCompiler().createModule(mmas, options, env, parsedModuleCS);
        
		Variable<EClassifier, EParameter> thisVar = ExpressionsFactory.eINSTANCE.createVariable();
		thisVar.setName(THIS);
		thisVar.setType(module);
        addElement(THIS, thisVar, false);
        
        return module; 
    }
    
    @Override
    public String toString() {    
    	return  "Env:" + myFile.getFullPath(); //$NON-NLS-1$
    }
    

	private final CFile myFile;

}
