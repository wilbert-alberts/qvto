/**
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: model/QVTOperationalCS.genmodel
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.qvto.examples.xtext.imperativeocl.cs2as.ImperativeOCLCSPreOrderVisitor;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
/**
 * An AbstractQVTOperationalCSPreOrderVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTOperationalCSPreOrderVisitor
	extends ImperativeOCLCSPreOrderVisitor
	implements QVTOperationalCSVisitor<Continuation<?>>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTOperationalCSPreOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}	

	public @Nullable Continuation<?> visitClassCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassCS csElement) {
		return visitClassCS(csElement);
	}

	public @Nullable Continuation<?> visitClassifierPropertyCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ClassifierPropertyCS csElement) {
		return visitStructuralFeatureCS(csElement);
	}

	public @Nullable Continuation<?> visitExceptionCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ExceptionCS csElement) {
		return visitClassCS(csElement);
	}

	public @Nullable Continuation<?> visitImportCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ImportCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitInitPartCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.InitPartCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitMetamodelCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.MetamodelCS csElement) {
		return visitPackageCS(csElement);
	}

	public @Nullable Continuation<?> visitOperationCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.OperationCS csElement) {
		return visitOperationCS(csElement);
	}

	public @Nullable Continuation<?> visitParameterCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.ParameterCS csElement) {
		return visitParameterCS(csElement);
	}

	public @Nullable Continuation<?> visitPrimitiveTypeCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.PrimitiveTypeCS csElement) {
		return visitDataTypeCS(csElement);
	}

	public @Nullable Continuation<?> visitStereotypeQualifierCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.StereotypeQualifierCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitTagCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TagCS csElement) {
		return visitAnnotationCS(csElement);
	}

	public @Nullable Continuation<?> visitTopLevelCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TopLevelCS csElement) {
		return visitElementCS(csElement);
	}

	public @Nullable Continuation<?> visitUnitCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.UnitCS csElement) {
		return visitElementCS(csElement);
	}
}
