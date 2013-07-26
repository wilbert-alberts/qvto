package org.eclipse.qvto.examples.xtext.imperativeocl.utilities;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.qvto.examples.pivot.imperativeocl.manager.ImperativeOCLMetamodelManager;
import org.eclipse.qvto.examples.xtext.imperativeocl.cs2as.ImperativeOCLCS2AS;

public class ImperativeOCLCSResource extends EssentialOCLCSResource {

	@Override
	public @NonNull CS2Pivot createCS2Pivot(
			@NonNull Map<? extends Resource, ? extends Resource> cs2pivotResourceMap,
			@NonNull MetaModelManager metaModelManager) {
		return new ImperativeOCLCS2AS(cs2pivotResourceMap, metaModelManager);
	}


	@Override
	public @NonNull String getEditorName() {
		return "Imperative OCL";
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCSResource#createMetaModelManager()
	 */
	@Override
	public final @NonNull MetaModelManager createMetaModelManager() {
		// FIXME move this to EssentialOCLCS Resource		
		ResourceSet resourceSet = getResourceSet();
		if (resourceSet != null) {
			MetaModelManagerResourceSetAdapter resourceSetAdapter = MetaModelManagerResourceSetAdapter.findAdapter(resourceSet);
			if (resourceSetAdapter != null) {
				return resourceSetAdapter.getMetaModelManager();
			}
		}
		return doCreateMetamodeManager();
	}

	protected MetaModelManager doCreateMetamodeManager() {
		return new ImperativeOCLMetamodelManager();
	}
}
