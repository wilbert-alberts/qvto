package org.eclipse.m2m.qvt.oml.common.io.eclipse;

import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider;
import org.eclipse.m2m.qvt.oml.emf.util.mmregistry.MetamodelRegistry;

/**
 * @author aigdalov
 * Created on Oct 10, 2007
 */
public class MetamodelRegistryProvider implements IMetamodelRegistryProvider {
    public MetamodelRegistry getRegistry(IRepositoryContext context) {
        return MetamodelRegistry.getInstance();
    }
}