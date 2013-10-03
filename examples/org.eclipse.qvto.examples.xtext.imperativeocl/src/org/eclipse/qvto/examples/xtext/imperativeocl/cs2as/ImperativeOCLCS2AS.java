package org.eclipse.qvto.examples.xtext.imperativeocl.cs2as;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCS2Pivot;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.ImperativeOCLCSVisitor;

public class ImperativeOCLCS2AS extends EssentialOCLCS2Pivot {
	
	public ImperativeOCLCS2AS(@NonNull Map<? extends Resource, ? extends ASResource> cs2pivotResourceMap, @NonNull MetaModelManager metaModelManager) {
		super(cs2pivotResourceMap, metaModelManager);
	}
		
	public ImperativeOCLCS2AS(ImperativeOCLCS2AS cs2pivot) {
		super(cs2pivot);
	}

	@Override
	protected @NonNull
	ImperativeOCLCSVisitor<Continuation<?>> createContainmentVisitor(
			@NonNull CS2PivotConversion converter) {
		return new NewImperativeOCLCSContainmentVisitor(converter);
	}
	
	@Override
	protected @NonNull
	ImperativeOCLCSVisitor<Continuation<?>> createPreOrderVisitor(
			@NonNull CS2PivotConversion converter) {
	
		return new ImperativeOCLCSPreOrderVisitor(converter);
	}
	
	@Override
	protected @NonNull
	ImperativeOCLCSVisitor<Continuation<?>> createPostOrderVisitor(
			@NonNull CS2PivotConversion converter) {
		return new ImperativeOCLCSPostOrderVisitor(converter);
	}

	@Override
	protected @NonNull
	ImperativeOCLCSVisitor<Element> createLeft2RightVisitor(
			@NonNull CS2PivotConversion converter) {
		return new ImperativeOCLCSLeft2RightVisitor(converter);
	}
}
