/**
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvto.examples.xtext.qvtoperational/model/QVTOperationalCS.genmodel
 *
 * Do not edit it.
 */
package	org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;

/**
 *
 */
public class QVTOperationalCSContainmentVisitor
	extends AbstractQVTOperationalCSContainmentVisitor
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	public QVTOperationalCSContainmentVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}
	
	public @Nullable Continuation<?> visitTransformationHeaderCS(@NonNull org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationHeaderCS csElement) {
		CS2Pivot converter = context.getConverter();
		// AS element creation
		org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation asElement = csElement != null ? (org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation) converter.getPivotElement(csElement) : null;
		if (asElement == null) {
			asElement = org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalFactory.eINSTANCE.createOperationalTransformation();
			converter.installPivotDefinition(csElement, asElement);
		}
		
		return null;
	}
}
