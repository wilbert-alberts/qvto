package org.eclipse.qvto.examples.build.utlities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;


public interface IContainmentVisitsGeneratorCtx {

	@NonNull public MetaModelManager getMetamodelManager();
}
