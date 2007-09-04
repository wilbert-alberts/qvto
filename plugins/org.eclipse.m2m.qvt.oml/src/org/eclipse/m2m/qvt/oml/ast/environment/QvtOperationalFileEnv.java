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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.common.io.CResourceRepositoryContext;
import org.eclipse.m2m.qvt.oml.compiler.ParsedModuleCS;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.m2m.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.expressions.Property;
import org.eclipse.m2m.qvt.oml.internal.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.qvt.oml.internal.ast.parser.ValidationMessages;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.osgi.util.NLS;

public class QvtOperationalFileEnv extends QvtOperationalEnv {

    public static final String THIS_VAR_QNAME_SUFFIX = "." + THIS; //$NON-NLS-1$
	
	
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
    
	private final CFile myFile;
	private String myQualifiedThisName;
}
