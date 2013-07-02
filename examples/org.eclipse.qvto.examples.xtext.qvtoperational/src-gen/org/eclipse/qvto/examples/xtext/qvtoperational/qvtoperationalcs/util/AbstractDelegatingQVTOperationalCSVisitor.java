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

/**
 * An AbstractDelegatingQVTOperationalCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTOperationalCSVisitor<R, C, D extends QVTOperationalCSVisitor<R>>
		extends
		org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.AbstractDelegatingImperativeOCLCSVisitor<R, C, D>
		implements QVTOperationalCSVisitor<R> {

	protected AbstractDelegatingQVTOperationalCSVisitor(@NonNull
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
		return delegate.visitClassifierCS(object);
	}

	public @Nullable
	R visitClassifierFeatureCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierFeatureCS object) {
		return delegate.visitClassifierFeatureCS(object);
	}

	public @Nullable
	R visitClassifierOperationCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS object) {
		return delegate.visitClassifierOperationCS(object);
	}

	public @Nullable
	R visitClassifierPropertyCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS object) {
		return delegate.visitClassifierPropertyCS(object);
	}

	public @Nullable
	R visitCompleteSignatureCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS object) {
		return delegate.visitCompleteSignatureCS(object);
	}

	public @Nullable
	R visitEnumerationCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.EnumerationCS object) {
		return delegate.visitEnumerationCS(object);
	}

	public @Nullable
	R visitImportCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS object) {
		return delegate.visitImportCS(object);
	}

	public @Nullable
	R visitInitPartCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS object) {
		return delegate.visitInitPartCS(object);
	}

	public @Nullable
	R visitMetamodelCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS object) {
		return delegate.visitMetamodelCS(object);
	}

	public @Nullable
	R visitMetamodelElementCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelElementCS object) {
		return delegate.visitMetamodelElementCS(object);
	}

	public @Nullable
	R visitMultiplicityCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityCS object) {
		return delegate.visitMultiplicityCS(object);
	}

	public @Nullable
	R visitParamCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS object) {
		return delegate.visitParamCS(object);
	}

	public @Nullable
	R visitSimpleSignatureCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS object) {
		return delegate.visitSimpleSignatureCS(object);
	}

	public @Nullable
	R visitTagCS(@NonNull
	org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS object) {
		return delegate.visitTagCS(object);
	}

	public @Nullable
	R visitTopLevelCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS object) {
		return delegate.visitTopLevelCS(object);
	}

	public @Nullable
	R visitTypedefCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS object) {
		return delegate.visitTypedefCS(object);
	}

	public @Nullable
	R visitUnitCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS object) {
		return delegate.visitUnitCS(object);
	}

	public @Nullable
	R visitUnitElementCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitElementCS object) {
		return delegate.visitUnitElementCS(object);
	}
}
