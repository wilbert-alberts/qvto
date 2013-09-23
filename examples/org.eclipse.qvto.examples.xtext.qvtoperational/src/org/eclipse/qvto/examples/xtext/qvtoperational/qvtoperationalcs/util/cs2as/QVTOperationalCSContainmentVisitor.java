package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationSimpleSignatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypeSpecCS;


/**
 * Temporal manual implementation to write manual and testable code
 * 
 * @author asbh
 */
public class QVTOperationalCSContainmentVisitor extends AutoQVTOperationalCSContainmentVisitor {

	public QVTOperationalCSContainmentVisitor(CS2PivotConversion context) {
		super(context);
	}
	
	
	@Override
	public @Nullable
	Continuation<?> visitInitPartCS(@NonNull
	InitPartCS csElement) {
		// Intermediate CS node, which doesn't produce AST. For the time being 
		// to avoid thrown exception
		return null;
	}
	
	@Override
	public @Nullable
	Continuation<?> visitOperationSimpleSignatureCS(@NonNull
	OperationSimpleSignatureCS csElement) {
		// Intermediate CS node, which doesn't produce AST. For the time being 
		// to avoid thrown exception
		return null;
	}
	
	@Override
	public @Nullable
	Continuation<?> visitTypeSpecCS(@NonNull
	TypeSpecCS csElement) {
		// FIXME I don't know yet how to deal with type resolution,
		// so skip it so far.
		return null;
	}
}
