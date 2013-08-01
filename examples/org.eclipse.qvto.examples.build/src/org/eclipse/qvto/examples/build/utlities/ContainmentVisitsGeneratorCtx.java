package org.eclipse.qvto.examples.build.utlities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;


/**
 * Context for the visits methods generator for the Containment visitor 
 * 
 * @author adolfosbh
 *
 */
public class ContainmentVisitsGeneratorCtx implements IContainmentVisitsGeneratorCtx {

	private MetaModelManager mmManager;
	
	public ContainmentVisitsGeneratorCtx(@NonNull MetaModelManager mmManager) {
		this.mmManager = mmManager;
	}
	
	public MetaModelManager getMetamodelManager() {
		return mmManager;
	}
}