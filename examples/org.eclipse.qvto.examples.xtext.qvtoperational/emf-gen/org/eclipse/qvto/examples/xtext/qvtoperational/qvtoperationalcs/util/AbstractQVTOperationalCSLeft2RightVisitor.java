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
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.qvto.examples.xtext.imperativeocl.cs2as.ImperativeOCLCSLeft2RightVisitor;

public abstract class AbstractQVTOperationalCSLeft2RightVisitor
		extends ImperativeOCLCSLeft2RightVisitor
		implements QVTOperationalCSVisitor<Element> {

	//
	// This file is maintained by copying from
	// AbstractExtendingQVTOperationalCSVisitor and changing R to Element.
	//
	protected AbstractQVTOperationalCSLeft2RightVisitor(@NonNull
	CS2PivotConversion context) {
		super(context);
	}

	public @Nullable Element visitClassCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassCS object) {
		return visitClassCS(object);
	}

	public @Nullable Element visitClassifierPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS object) {
		return visitStructuralFeatureCS(object);
	}

	public @Nullable Element visitExceptionCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ExceptionCS object) {
		return visitClassCS(object);
	}

	public @Nullable Element visitImportCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS object) {
		return visitElementCS(object);
	}

	public @Nullable Element visitInitPartCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS object) {
		return visitElementCS(object);
	}

	public @Nullable Element visitMetamodelCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS object) {
		return visitPackageCS(object);
	}

	public @Nullable Element visitOperationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationCS object) {
		return visitOperationCS(object);
	}

	public @Nullable Element visitParameterCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterCS object) {
		return visitParameterCS(object);
	}

	public @Nullable Element visitPrimitiveTypeCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PrimitiveTypeCS object) {
		return visitDataTypeCS(object);
	}

	public @Nullable Element visitStereotypeQualifierCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.StereotypeQualifierCS object) {
		return visitElementCS(object);
	}

	public @Nullable Element visitTagCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS object) {
		return visitAnnotationCS(object);
	}

	public @Nullable Element visitTopLevelCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS object) {
		return visitElementCS(object);
	}

	public @Nullable Element visitUnitCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS object) {
		return visitElementCS(object);
	}
}
