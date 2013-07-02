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
 * An AbstractExtendingQVTOperationalCSVisitor provides a default implementation
 * for each visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class until a
 * non-interface super-class is found). In the absence of any suitable first
 * super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingQVTOperationalCSVisitor<R, C>
		extends
		org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.AbstractExtendingImperativeOCLCSVisitor<R, C>
		implements QVTOperationalCSVisitor<R> {

	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context
	 *            my initial result value
	 */
	protected AbstractExtendingQVTOperationalCSVisitor(@NonNull
	C context) {
		super(context);
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
		return visiting(object);
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
		return visiting(object);
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
		return visiting(object);
	}

	public @Nullable
	R visitInitPartCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS object) {
		return visiting(object);
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
		return visiting(object);
	}

	public @Nullable
	R visitMultiplicityCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityCS object) {
		return visitElementCS(object);
	}

	public @Nullable
	R visitParamCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS object) {
		return visiting(object);
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
		return visiting(object);
	}

	public @Nullable
	R visitTypedefCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS object) {
		return visiting(object);
	}

	public @Nullable
	R visitUnitCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS object) {
		return visiting(object);
	}

	public @Nullable
	R visitUnitElementCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitElementCS object) {
		return visiting(object);
	}
}
