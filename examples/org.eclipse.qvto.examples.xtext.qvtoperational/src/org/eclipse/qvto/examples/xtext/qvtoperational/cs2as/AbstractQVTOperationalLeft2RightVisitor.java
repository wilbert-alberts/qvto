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
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.qvto.examples.xtext.imperativeocl.cs2as.ImperativeOCLLeft2RightVisitor;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSVisitor;

public abstract class AbstractQVTOperationalLeft2RightVisitor
		extends ImperativeOCLLeft2RightVisitor
		implements QVTOperationalCSVisitor<Element> {

	//
	// This file is maintained by copying from
	// AbstractExtendingQVTOperationalCSVisitor and changing R to Element.
	//
	protected AbstractQVTOperationalLeft2RightVisitor(@NonNull
	CS2PivotConversion context) {
		super(context);
	}

	public @Nullable
	Element visitClassifierCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierCS object) {
		return visitMetamodelElementCS(object);
	}

	public @Nullable
	Element visitClassifierFeatureCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierFeatureCS object) {
		return visiting(object);
	}

	public @Nullable
	Element visitClassifierOperationCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierOperationCS object) {
		return visitClassifierFeatureCS(object);
	}

	public @Nullable
	Element visitClassifierPropertyCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS object) {
		return visitClassifierFeatureCS(object);
	}

	public @Nullable
	Element visitCompleteSignatureCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.CompleteSignatureCS object) {
		return visiting(object);
	}

	public @Nullable
	Element visitEnumerationCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.EnumerationCS object) {
		return visitMetamodelElementCS(object);
	}

	public @Nullable
	Element visitImportCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS object) {
		return visiting(object);
	}

	public @Nullable
	Element visitInitPartCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS object) {
		return visiting(object);
	}

	public @Nullable
	Element visitMetamodelCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS object) {
		return visitUnitElementCS(object);
	}

	public @Nullable
	Element visitMetamodelElementCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelElementCS object) {
		return visiting(object);
	}

	public @Nullable
	Element visitMultiplicityCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MultiplicityCS object) {
		return visitElementCS(object);
	}

	public @Nullable
	Element visitParamCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParamCS object) {
		return visiting(object);
	}

	public @Nullable
	Element visitSimpleSignatureCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.SimpleSignatureCS object) {
		return visitCompleteSignatureCS(object);
	}

	public @Nullable
	Element visitTagCS(@NonNull
	org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS object) {
		return visitMetamodelElementCS(object);
	}

	public @Nullable
	Element visitTopLevelCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS object) {
		return visiting(object);
	}

	public @Nullable
	Element visitTypedefCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TypedefCS object) {
		return visiting(object);
	}

	public @Nullable
	Element visitUnitCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS object) {
		return visiting(object);
	}

	public @Nullable
	Element visitUnitElementCS(
			@NonNull
			org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitElementCS object) {
		return visiting(object);
	}
}
