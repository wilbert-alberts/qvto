package org.eclipse.m2m.internal.qvt.oml.compiler;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFolder;
import org.eclipse.m2m.internal.qvt.oml.cst.LibraryCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsFactory;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.impl.ExpressionsFactoryImpl;
import org.eclipse.ocl.ecore.EcoreEnvironment;

/**
 * @author aigdalov
 * Created on Nov 6, 2007
 */
public class QvtCompilerKernel {
    private final IImportResolver myImportResolver;
    private final IMetamodelRegistryProvider myMetamodelRegistryProvider;
    private final Map<MappingModuleCS, Module> mySyntaxToSemanticMap = new HashMap<MappingModuleCS, Module>();
    private ResourceSet myMetamodelResourceSet;
    
    public QvtCompilerKernel(IImportResolver importResolver, IMetamodelRegistryProvider metamodelRegistryProvider) {
        myImportResolver = importResolver;
        myMetamodelRegistryProvider = metamodelRegistryProvider;
    }

    public IImportResolver getImportResolver() {
        return myImportResolver;
    }

    public IMetamodelRegistryProvider getMetamodelRegistryProvider() {
        return myMetamodelRegistryProvider;
    }
    
    public String getExpectedPackageName(CFolder folder) {
        String packageName = myImportResolver.getPackageName(folder);
        return packageName;
    }

    public Module getModule(MappingModuleCS mmas) {
        return mySyntaxToSemanticMap.get(mmas);
    }
    
    public Module createModule(MappingModuleCS mmas, QvtCompilerOptions options, 
            EcoreEnvironment env, CFile cFile) {
        Module module = null;
        if(mmas instanceof LibraryCS) {
        	module = ExpressionsFactory.eINSTANCE.createLibrary();
        } else {
        	module = ExpressionsFactory.eINSTANCE.createOperationalTransformation();
        }
        
        if(mmas.getHeaderCS() != null && mmas.getHeaderCS().getPathNameCS() != null) {
        	EList<String> sequenceOfNames = mmas.getHeaderCS().getPathNameCS().getSequenceOfNames();
        	if(!sequenceOfNames.isEmpty()) {
        		module.setName(sequenceOfNames.get(0));
        	}
        }
        
        module.setEFactoryInstance(new ExpressionsFactoryImpl());
        mySyntaxToSemanticMap.put(mmas, module);

        // AST binding
        if(options.isGenerateCompletionData()) {
            ASTBindingHelper.createModuleBinding(mmas, module, env, cFile);
        }
        //      
        
        return module;
    }
    
    public ResourceSet getMetamodelResourceSet() {
        return myMetamodelResourceSet;
    }

    public void setMetamodelResourceSet(ResourceSet metamodelResourceSet) {
        myMetamodelResourceSet = metamodelResourceSet;
    }
}