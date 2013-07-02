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
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.AbstractDelegatingImperativeOCLCSVisitor;
import org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.ImperativeOCLCSVisitor;

/**
 * An AbstractExtendingDelegatingQVTOperationalCSVisitor delegates all visits.
 */
public abstract class AbstractExtendingDelegatingQVTOperationalCSVisitor<R, C, D extends ImperativeOCLCSVisitor<R>>
		extends AbstractDelegatingImperativeOCLCSVisitor<R, C, D>
		implements QVTOperationalCSVisitor<R> {

	protected AbstractExtendingDelegatingQVTOperationalCSVisitor(@NonNull
	D delegate, @NonNull
	C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable
	R visiting(@NonNull
	org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable
	R visitClassifierCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS object) {
		return visitMetamodelElementCS(object);
	}

	public @Nullable
	R visitClassifierFeatureCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierFeatureCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable
	R visitClassifierOperationCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS object) {
		return visitClassifierFeatureCS(object);
	}

	public @Nullable
	R visitClassifierPropertyCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS object) {
		return visitClassifierFeatureCS(object);
	}

	public @Nullable
	R visitCompleteSignatureCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable
	R visitEnumerationCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.EnumerationCS object) {
		return visitMetamodelElementCS(object);
	}

	public @Nullable
	R visitImportCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable
	R visitInitPartCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable
	R visitMetamodelCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS object) {
		return visitUnitElementCS(object);
	}

	public @Nullable
	R visitMetamodelElementCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelElementCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable
	R visitMultiplicityCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable
	R visitParamCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable
	R visitSimpleSignatureCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS object) {
		return visitCompleteSignatureCS(object);
	}

	public @Nullable
	R visitTagCS(@NonNull
	org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS object) {
		return visitMetamodelElementCS(object);
	}

	public @Nullable
	R visitTopLevelCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable
	R visitTypedefCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable
	R visitUnitCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS object) {
		return delegate.visitElementCS(object);
	}

	public @Nullable
	R visitUnitElementCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitElementCS object) {
		return delegate.visitElementCS(object);
	}
}
