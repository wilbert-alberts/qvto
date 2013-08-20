package org.eclipse.qvto.examples.build.utlities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;


/**
 * Context for the visits methods generator for the ContainmentCS2AS visitor 
 * 
 * @author adolfosbh
 *
 */
public interface IContainmentVisitsGeneratorCtx {

	/**
	 * @return The metamodel manager used during containment visitor generation
	 */
	@NonNull public MetaModelManager getMetamodelManager();
	
	/**
	 * @return The output folder where the generated visitors code is created
	 */
	@NonNull public String getOutputFolder();

	/**
	 * The name of the visitors java package where the generated code is created
	 * 
	 * @return The output folder where generated visitors code is produced
	 */
	public String getVisitorsPackageName();
}
