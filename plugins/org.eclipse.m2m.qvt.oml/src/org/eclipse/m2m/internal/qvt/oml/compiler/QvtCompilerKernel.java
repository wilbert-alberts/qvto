package org.eclipse.m2m.internal.qvt.oml.compiler;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFolder;
import org.eclipse.m2m.internal.qvt.oml.common.io.CResourceRepositoryContext;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;

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
    
    public MetamodelRegistry getMetamodelRegistry(CFile sourceFile) {
    	return myMetamodelRegistryProvider.getRegistry(new CResourceRepositoryContext(sourceFile));    	
    }
    
    public String getExpectedPackageName(CFolder folder) {
        String packageName = myImportResolver.getPackageName(folder);
        return packageName;
    }

    public Module getModule(MappingModuleCS mmas) {
        return mySyntaxToSemanticMap.get(mmas);
    }
    
    public Module setModule(Module module, MappingModuleCS mmas) {                
        mySyntaxToSemanticMap.put(mmas, module);
        return module;
    }
    
    public ResourceSet getMetamodelResourceSet() {
        return myMetamodelResourceSet;
    }

    public void setMetamodelResourceSet(ResourceSet metamodelResourceSet) {
        myMetamodelResourceSet = metamodelResourceSet;
    }
}