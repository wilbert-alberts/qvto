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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.common.io.CResourceRepositoryContext;
import org.eclipse.m2m.qvt.oml.compiler.ParsedModuleCS;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.m2m.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.internal.ast.parser.ValidationMessages;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.osgi.util.NLS;

public class QvtOperationalFileEnv extends QvtOperationalEnv {

	protected QvtOperationalFileEnv(final QvtOperationalEnv parent, final CFile file, final QvtCompiler compiler) {
		super(parent, compiler);
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
    
    public Module createModule(MappingModuleCS mmas, boolean createASTBinding,
    		EcoreEnvironment env, ParsedModuleCS parsedModuleCS) {
        return getCompiler().createModule(mmas, createASTBinding, env, parsedModuleCS);
    }
    

	private final CFile myFile;

}
