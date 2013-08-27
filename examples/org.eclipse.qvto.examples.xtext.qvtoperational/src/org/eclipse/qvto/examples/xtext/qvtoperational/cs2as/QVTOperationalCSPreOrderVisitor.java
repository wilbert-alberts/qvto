package org.eclipse.qvto.examples.xtext.qvtoperational.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationSimpleSignatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.AbstractQVTOperationalCSPreOrderVisitor;

public class QVTOperationalCSPreOrderVisitor
		extends AbstractQVTOperationalCSPreOrderVisitor {

	protected class TypeSpecContinuation extends TypedRefContinuation<TypeSpecCS> {

		public TypeSpecContinuation(CS2PivotConversion context,
				TypeSpecCS csElement) {
			super(context, csElement);
		}
		
		@Override
		public boolean canExecute() {
			if (!super.canExecute()) {
				return false;
			}			
			TypedRefCS ownedType = csElement.getOwnedType();
			Element pivot = ownedType.getPivot();
			if (pivot == null) {
				return false;
			}
			if (context.isInReturnTypeWithUnresolvedParameters(csElement)) {
				return false;
			}
			return true;
		}
		
		@Override
		public BasicContinuation<?> execute() {
			TypedRefCS ownedType = csElement.getOwnedType();
			Type type = PivotUtil.getPivot(Type.class, ownedType);
			context.installPivotTypeWithMultiplicity(type, csElement);
			return null;
		}
		
	}
	
	protected QVTOperationalCSPreOrderVisitor(CS2PivotConversion context) {
		super(context);
	}
	
	@Override
	public @Nullable
	Continuation<?> visitInitPartCS(@NonNull
	InitPartCS csElement) {
		// FIXME this is to temporarily avoid thrown exception
		return null;
	}
	
	@Override
	public @Nullable
	Continuation<?> visitOperationSimpleSignatureCS(@NonNull
	OperationSimpleSignatureCS csElement) {
		// FIXME this is to temporarily avoid thrown exception
		return null;
	}
	
	@Override
	public @Nullable
	Continuation<?> visitTypeSpecCS(@NonNull
	TypeSpecCS csElement) {
		return new TypeSpecContinuation(context, csElement);
	}
	
}