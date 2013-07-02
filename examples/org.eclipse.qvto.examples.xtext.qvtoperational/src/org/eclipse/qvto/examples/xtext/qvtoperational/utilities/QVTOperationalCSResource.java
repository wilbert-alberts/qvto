package org.eclipse.qvto.examples.xtext.qvtoperational.utilities;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2Pivot;
import org.eclipse.qvto.examples.xtext.imperativeocl.utilities.ImperativeOCLCSResource;
import org.eclipse.qvto.examples.xtext.qvtoperational.cs2as.QVTOperationalCS2AS;

public class QVTOperationalCSResource
		extends ImperativeOCLCSResource {

	@Override
	public @NonNull
	CS2Pivot createCS2Pivot(@NonNull
	Map<? extends Resource, ? extends Resource> cs2pivotResourceMap, @NonNull
	MetaModelManager metaModelManager) {
		return new QVTOperationalCS2AS(cs2pivotResourceMap, metaModelManager);
	}

	@Override
	public @NonNull
	String getEditorName() {
		return "QVT Operational";
	}
}
