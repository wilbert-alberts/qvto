package org.eclipse.m2m.internal.qvt.oml.compiler;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.CResourceRepositoryContext;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.MetamodelRegistry;

/**
 * @author aigdalov
 * Created on Nov 6, 2007
 */
public class QvtCompilerKernel {
    private final IMetamodelRegistryProvider myMetamodelRegistryProvider;
    private ResourceSet myMetamodelResourceSet;
    
    public QvtCompilerKernel(IMetamodelRegistryProvider metamodelRegistryProvider) {
        myMetamodelRegistryProvider = metamodelRegistryProvider;
    }
    
    public MetamodelRegistry getMetamodelRegistry(CFile sourceFile) {
    	return myMetamodelRegistryProvider.getRegistry(new CResourceRepositoryContext(sourceFile));    	
    }
        
    public ResourceSet getMetamodelResourceSet() {
        return myMetamodelResourceSet;
    }

    public void setMetamodelResourceSet(ResourceSet metamodelResourceSet) {
        myMetamodelResourceSet = metamodelResourceSet;
    }
}