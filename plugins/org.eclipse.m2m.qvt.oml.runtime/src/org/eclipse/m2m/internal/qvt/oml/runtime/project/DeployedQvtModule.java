/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation
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


import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.MetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompilerMessages;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolverFactory;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.osgi.util.NLS;

public class DeployedQvtModule extends QvtModule {
    
	private Module myModule;
	private CompiledUnit myUnit;
    private QVTOCompiler myCompiler;
	private URI moduleID;
	
	public DeployedQvtModule(URI qvtModuleID) throws MdaException {
		if(qvtModuleID == null || qvtModuleID.segmentCount() == 0) {
			throw new MdaException(NLS.bind(Messages.TransformationUtil_InvalidUri, 
					qvtModuleID == null ? String.valueOf(null) : qvtModuleID.toString()));
		}
		this.moduleID = qvtModuleID;
    }
	
	protected IMetamodelRegistryProvider creatMetamodelRegistryProvider() {
		return new MetamodelRegistryProvider();
	}
	
    @Override
	public Module getModule() throws MdaException {
        if (myModule == null) {
        	UnitProxy srcUnit = UnitResolverFactory.Registry.INSTANCE.getUnit(moduleID);
        	if (srcUnit == null) {
        		throw new MdaException(NLS.bind(CompilerMessages.importedModuleNotFound, moduleID));
        	}
        	
            QVTOCompiler qvtCompiler = new QVTOCompiler(srcUnit.getResolver(), creatMetamodelRegistryProvider());

            QvtCompilerOptions options = getQvtCompilerOptions();
            if (options == null) {
                options = new QvtCompilerOptions();
                options.setGenerateCompletionData(false);
            }
           
            myUnit = qvtCompiler.compile(srcUnit, options, null);
            
            if (!options.isModuleWithErrorAllowed()) {
            	checkModuleErrors(myUnit);
            }
            
            // FIXME - we should add support of uri fragment, being the name of the refered module
            myModule = myUnit.getModules().get(0);
            myCompiler = qvtCompiler;
        }
        
        return myModule;
    }
    
	@Override
	public QVTOCompiler getCompiler() throws MdaException {
		getModule();
		return myCompiler;
	}
	
    @Override
	public CompiledUnit getUnit() throws MdaException {
    	getModule();    	
    	return myUnit;
    }
	
    @Override
	public String toString() {
        return "deployed:/" + moduleID; //$NON-NLS-1$
    }
}
