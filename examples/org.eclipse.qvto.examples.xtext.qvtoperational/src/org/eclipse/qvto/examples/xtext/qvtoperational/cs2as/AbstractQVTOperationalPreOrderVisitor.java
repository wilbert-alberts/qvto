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
package org.eclipse.qvto.examples.xtext.qvtoperational.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.qvto.examples.xtext.imperativeocl.cs2as.ImperativeOCLPreOrderVisitor;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor;

public abstract class AbstractQVTOperationalPreOrderVisitor
		extends ImperativeOCLPreOrderVisitor
		implements QVTOperationalCSVisitor<Continuation<?>> {

	//
	// This file is maintained by copying from
	// AbstractExtendingQVTOperationalCSVisitor and changing R to
	// Continuation<?>.
	//
	protected AbstractQVTOperationalPreOrderVisitor(@NonNull
	CS2PivotConversion context) {
		super(context);
	}

	public @Nullable
	Continuation<?> visitClassifierCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS object) {
		return visitMetamodelElementCS(object);
	}

	public @Nullable
	Continuation<?> visitClassifierFeatureCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierFeatureCS object) {
		return visiting(object);
	}

	public @Nullable
	Continuation<?> visitClassifierOperationCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS object) {
		return visitClassifierFeatureCS(object);
	}

	public @Nullable
	Continuation<?> visitClassifierPropertyCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS object) {
		return visitClassifierFeatureCS(object);
	}

	public @Nullable
	Continuation<?> visitCompleteSignatureCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS object) {
		return visiting(object);
	}

	public @Nullable
	Continuation<?> visitEnumerationCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.EnumerationCS object) {
		return visitMetamodelElementCS(object);
	}

	public @Nullable
	Continuation<?> visitImportCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS object) {
		return visiting(object);
	}

	public @Nullable
	Continuation<?> visitInitPartCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS object) {
		return visiting(object);
	}

	public @Nullable
	Continuation<?> visitMetamodelCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS object) {
		return visitUnitElementCS(object);
	}

	public @Nullable
	Continuation<?> visitMetamodelElementCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelElementCS object) {
		return visiting(object);
	}

	public @Nullable
	Continuation<?> visitMultiplicityCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityCS object) {
		return visitElementCS(object);
	}

	public @Nullable
	Continuation<?> visitParamCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS object) {
		return visiting(object);
	}

	public @Nullable
	Continuation<?> visitSimpleSignatureCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS object) {
		return visitCompleteSignatureCS(object);
	}

	public @Nullable
	Continuation<?> visitTagCS(@NonNull
	org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS object) {
		return visitMetamodelElementCS(object);
	}

	public @Nullable
	Continuation<?> visitTopLevelCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS object) {
		return visiting(object);
	}

	public @Nullable
	Continuation<?> visitTypedefCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS object) {
		return visiting(object);
	}

	public @Nullable
	Continuation<?> visitUnitCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS object) {
		return visiting(object);
	}

	public @Nullable
	Continuation<?> visitUnitElementCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitElementCS object) {
		return visiting(object);
	}
}
