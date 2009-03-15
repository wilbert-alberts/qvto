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
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.MetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.compiler.BlackboxUnitResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompilerMessages;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolver;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.osgi.util.NLS;

public class DeployedQvtModule extends QvtModule {
    
	private Module myModule;
	private CompiledUnit myUnit;
    private QVTOCompiler myCompiler;
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
	public Module getModule() throws MdaException {
        if (myModule == null) {
        	CustomDeployedImportResolver unitResolver = new CustomDeployedImportResolver();
        	UnitProxy srcUnit = unitResolver.resolveUnit(moduleID);
        	if (srcUnit == null) {
        		throw new MdaException(NLS.bind(CompilerMessages.importedModuleNotFound, moduleID));
        	}
        	unitResolver.setParent(new BlackboxUnitResolver(srcUnit.getURI()));
        	
            QVTOCompiler qvtCompiler = new QVTOCompiler(unitResolver, creatMetamodelRegistryProvider());

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
    
    private static class CustomDeployedImportResolver extends DeployedImportResolver {

		CustomDeployedImportResolver() {
			super(DeployedImportResolver.INSTANCE.getBundleModules());
		}
		
		@Override
		public UnitProxy resolveUnit(String qualifiedName) {
			UnitProxy unit = super.resolveUnit(qualifiedName);
			if (unit == null) {
				if (myParent != null) {
					unit = myParent.resolveUnit(qualifiedName);
				}
			}
			return unit;
		}
		
		void setParent(UnitResolver parent) {
			myParent = parent;
		}
    	
		private UnitResolver myParent;
    }

}
