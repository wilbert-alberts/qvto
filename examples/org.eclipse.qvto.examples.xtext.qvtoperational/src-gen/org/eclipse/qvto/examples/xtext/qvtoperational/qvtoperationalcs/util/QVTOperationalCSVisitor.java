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
 */
public interface QVTOperationalCSVisitor<R>
		extends
		org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.ImperativeOCLCSVisitor<R> {

	@Nullable
	R visitClassifierCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS object);

	@Nullable
	R visitClassifierFeatureCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierFeatureCS object);

	@Nullable
	R visitClassifierOperationCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS object);

	@Nullable
	R visitClassifierPropertyCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS object);

	@Nullable
	R visitCompleteSignatureCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS object);

	@Nullable
	R visitEnumerationCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.EnumerationCS object);

	@Nullable
	R visitImportCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS object);

	@Nullable
	R visitInitPartCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS object);

	@Nullable
	R visitMetamodelCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS object);

	@Nullable
	R visitMetamodelElementCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelElementCS object);

	@Nullable
	R visitMultiplicityCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityCS object);

	@Nullable
	R visitParamCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS object);

	@Nullable
	R visitSimpleSignatureCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS object);

	@Nullable
	R visitTagCS(@NonNull
	org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS object);

	@Nullable
	R visitTopLevelCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS object);

	@Nullable
	R visitTypedefCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS object);

	@Nullable
	R visitUnitCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS object);

	@Nullable
	R visitUnitElementCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitElementCS object);
}
