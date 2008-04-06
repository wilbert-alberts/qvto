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


import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.MetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompilerMessages;
import org.eclipse.m2m.internal.qvt.oml.compiler.IImportResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider;
import org.eclipse.osgi.util.NLS;

public class DeployedQvtModule extends QvtModule {
    
	private CompiledModule myModule;
    private QvtCompiler myCompiler;
	private String moduleID;
	
	public DeployedQvtModule(String qvtModuleID) {
		if(qvtModuleID == null || qvtModuleID.length() == 0) {
			throw new IllegalArgumentException("Invalid QVT module ID"); //$NON-NLS-1$
		}
		this.moduleID = qvtModuleID;
    }
	
	protected IMetamodelRegistryProvider creatMetamodelRegistryProvider() {
		return new MetamodelRegistryProvider();
	}
	
    @Override
	public CompiledModule getModule() throws MdaException {
        if (myModule == null) {           
            IImportResolver importResolver = new DeployedImportResolver();
        	CFile srcFile = importResolver.resolveImport(moduleID);
        	if (srcFile == null) {
        		throw new MdaException(NLS.bind(CompilerMessages.importedModuleNotFound, moduleID));
        	}
        	
            QvtCompiler qvtCompiler = new QvtCompiler(importResolver, creatMetamodelRegistryProvider());

            QvtCompilerOptions options = getQvtCompilerOptions();
            if (options == null) {
                options = new QvtCompilerOptions();
                options.setGenerateCompletionData(false);
            }
            CompiledModule module = qvtCompiler.compile(srcFile, options, null).getModule();
            
            checkModuleErrors(module);
            
            myModule = module;
            myCompiler = qvtCompiler;
        }
        
        return myModule;
    }
    
	@Override
	public QvtCompiler getCompiler() throws MdaException {
		getModule();
		return myCompiler;
	}    
	
    @Override
	public String toString() {
        return "deployed:/" + moduleID; //$NON-NLS-1$
    }	
}
