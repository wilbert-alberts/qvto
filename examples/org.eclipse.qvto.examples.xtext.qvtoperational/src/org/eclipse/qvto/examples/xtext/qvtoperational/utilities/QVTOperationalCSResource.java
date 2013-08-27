package org.eclipse.qvto.examples.xtext.qvtoperational.utilities;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage;
import org.eclipse.qvto.examples.xtext.imperativeocl.utilities.ImperativeOCLCSResource;
import org.eclipse.qvto.examples.xtext.qvtoperational.cs2as.QVTOperationalCS2AS;

public class QVTOperationalCSResource
		extends ImperativeOCLCSResource {

	@Override
	public @NonNull
	CS2Pivot createCS2Pivot(@NonNull
	Map<? extends Resource, ? extends ASResource> cs2asResourceMap, @NonNull
	MetaModelManager metaModelManager) {
		return new QVTOperationalCS2AS(cs2asResourceMap, metaModelManager);
	}

	@Override
	public @NonNull String getASContentType() {
		return QVTOperationalPackage.eCONTENT_TYPE;
	}

	@Override
	public @NonNull URI getASURI(@NonNull URI csURI) {
		return csURI.trimFileExtension().appendFileExtension("qvtoas");
	}

	@Override
	public @NonNull
	String getEditorName() {
		return "QVT Operational";
	}
}
