/**
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: src-gen/org/eclipse/qvto/examples/xtext/qvtoperational/QVTOperational.genmodel
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.qvto.examples.xtext.imperativeocl.cs2as.ImperativeOCLCSPostOrderVisitor;

public abstract class AbstractQVTOperationalCSPostOrderVisitor
		extends ImperativeOCLCSPostOrderVisitor
		implements QVTOperationalCSVisitor<Continuation<?>> {

	//
	// This file is maintained by copying from
	// AbstractExtendingQVTOperationalCSVisitor and changing R to
	// Continuation<?>.
	//
	protected AbstractQVTOperationalCSPostOrderVisitor(@NonNull
	CS2PivotConversion context) {
		super(context);
	}

	public @Nullable Continuation<?> visitClassCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassCS object) {
		return visitClassCS(object);
	}

	public @Nullable Continuation<?> visitClassifierPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS object) {
		return visitStructuralFeatureCS(object);
	}

	public @Nullable Continuation<?> visitExceptionCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ExceptionCS object) {
		return visitClassCS(object);
	}

	public @Nullable Continuation<?> visitImportCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS object) {
		return visitElementCS(object);
	}

	public @Nullable Continuation<?> visitInitPartCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS object) {
		return visitElementCS(object);
	}

	public @Nullable Continuation<?> visitMetamodelCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS object) {
		return visitPackageCS(object);
	}

	public @Nullable Continuation<?> visitOperationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationCS object) {
		return visitOperationCS(object);
	}

	public @Nullable Continuation<?> visitParameterCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterCS object) {
		return visitParameterCS(object);
	}

	public @Nullable Continuation<?> visitPrimitiveTypeCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PrimitiveTypeCS object) {
		return visitDataTypeCS(object);
	}

	public @Nullable Continuation<?> visitStereotypeQualifierCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.StereotypeQualifierCS object) {
		return visitElementCS(object);
	}

	public @Nullable Continuation<?> visitTagCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS object) {
		return visitAnnotationCS(object);
	}

	public @Nullable Continuation<?> visitTopLevelCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS object) {
		return visitElementCS(object);
	}

	public @Nullable Continuation<?> visitUnitCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS object) {
		return visitElementCS(object);
	}
}
