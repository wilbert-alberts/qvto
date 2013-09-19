package org.eclipse.qvto.examples.xtext.qvtoperational.cs2as;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.qvto.examples.xtext.imperativeocl.cs2as.ImperativeOCLCS2AS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor;

public class QVTOperationalCS2AS
		extends ImperativeOCLCS2AS {

	public QVTOperationalCS2AS(@NonNull
	Map<? extends Resource, ? extends ASResource> cs2pivotResourceMap, @NonNull
	MetaModelManager metaModelManager) {
		super(cs2pivotResourceMap, metaModelManager);
	}

	public QVTOperationalCS2AS(QVTOperationalCS2AS cs2pivot) {
		super(cs2pivot);
	}

	@Override
	protected @NonNull
	QVTOperationalCSVisitor<Continuation<?>> createContainmentVisitor(@NonNull
	CS2PivotConversion converter) {
		return new QVTOperationalCSContainmentVisitor(converter);
	}

	@Override
	protected @NonNull
	QVTOperationalCSVisitor<Continuation<?>> createPreOrderVisitor(@NonNull
	CS2PivotConversion converter) {
		return new QVTOperationalCSPreOrderVisitor(converter);
	}

	@Override
	protected @NonNull
	QVTOperationalCSVisitor<Continuation<?>> createPostOrderVisitor(@NonNull
	CS2PivotConversion converter) {
		return new QVTOperationalCSPostOrderVisitor(converter);
	}

	@Override
	protected @NonNull
	QVTOperationalCSVisitor<Element> createLeft2RightVisitor(@NonNull
	CS2PivotConversion converter) {
		return new QVTOperationalCSLeft2RightVisitor(converter);
	}
}
