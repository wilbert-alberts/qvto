package org.eclipse.qvto.examples.build.utlities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;


/**
 * Simple implementation of {@link IContainmentVisitsGeneratorCtx}
 * 
 * @author adolfosbh
 *
 */
public class ContainmentVisitsGeneratorCtx implements IContainmentVisitsGeneratorCtx {

	@NonNull
	private MetaModelManager mmManager;
	
	@NonNull	
	private String outputFolder;
	
	@NonNull
	private String visitorsPackageName;
	
	/**
	 * @param mmManager The metamodel manager used during containment visitor generation
	 * @param pClass The CS class for the visit method being generated
	 */
	public ContainmentVisitsGeneratorCtx(@NonNull MetaModelManager mmManager, @NonNull String outputFolder, @NonNull String visitorsPackageName) {
		this.mmManager = mmManager;
		this.outputFolder = outputFolder;
		this.visitorsPackageName = visitorsPackageName;
	}
		
	@NonNull
	public MetaModelManager getMetamodelManager() {
		return mmManager;
	}
	
	@NonNull
	public String getOutputFolder() {
		return outputFolder;
	}

	public String getVisitorsPackageName() {
		return visitorsPackageName;
	}	
}