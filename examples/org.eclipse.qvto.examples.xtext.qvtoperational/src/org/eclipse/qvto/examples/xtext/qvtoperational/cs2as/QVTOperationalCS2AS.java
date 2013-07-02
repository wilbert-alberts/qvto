package org.eclipse.qvto.examples.xtext.qvtoperational.cs2as;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.qvto.examples.xtext.imperativeocl.cs2as.ImperativeOCLCS2AS;

public class QVTOperationalCS2AS
		extends ImperativeOCLCS2AS {

	public QVTOperationalCS2AS(@NonNull
	Map<? extends Resource, ? extends Resource> cs2pivotResourceMap, @NonNull
	MetaModelManager metaModelManager) {
		super(cs2pivotResourceMap, metaModelManager);
	}

	public QVTOperationalCS2AS(QVTOperationalCS2AS cs2pivot) {
		super(cs2pivot);
	}

	@Override
	protected @NonNull
	QVTOperationalContainmentVisitor createContainmentVisitor(@NonNull
	CS2PivotConversion converter) {
		return new QVTOperationalContainmentVisitor(converter);
	}

	@Override
	protected @NonNull
	QVTOperationalPreOrderVisitor createPreOrderVisitor(@NonNull
	CS2PivotConversion converter) {
		return new QVTOperationalPreOrderVisitor(converter);
	}

	@Override
	protected @NonNull
	QVTOperationalPostOrderVisitor createPostOrderVisitor(@NonNull
	CS2PivotConversion converter) {
		return new QVTOperationalPostOrderVisitor(converter);
	}

	@Override
	protected @NonNull
	QVTOperationalLeft2RightVisitor createLeft2RightVisitor(@NonNull
	CS2PivotConversion converter) {
		return new QVTOperationalLeft2RightVisitor(converter);
	}
}
