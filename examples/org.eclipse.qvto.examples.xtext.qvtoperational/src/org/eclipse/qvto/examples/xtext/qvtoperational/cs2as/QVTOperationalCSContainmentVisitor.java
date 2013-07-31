package org.eclipse.qvto.examples.xtext.qvtoperational.cs2as;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;
import org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalFactory;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage;
import org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.TransformationHeaderCS;


/**
 * Temporal manual implementation to write manual and testable code
 * 
 * @author asbh
 */
public class QVTOperationalCSContainmentVisitor extends org.eclipse.qvto.examples.xtext.qvtoperational.qvtoperationalcs.util.QVTOperationalCSContainmentVisitor {

	public QVTOperationalCSContainmentVisitor(CS2PivotConversion context) {
		super(context);
	}
	
	@Override
	public @Nullable
	Continuation<?> visitTransformationHeaderCS(@NonNull
	TransformationHeaderCS csElement) {

		EClass pivotEClass = QVTOperationalPackage.Literals.OPERATIONAL_TRANSFORMATION;
		CS2Pivot converter = context.getConverter();
		// AS element creation
		OperationalTransformation pivotElement = csElement != null ? (OperationalTransformation)  converter.getPivotElement(csElement) : null;		
		if (pivotElement == null || pivotEClass != pivotElement.eClass()) {
			pivotElement = QVTOperationalFactory.eINSTANCE.createOperationalTransformation();
			converter.installPivotDefinition(csElement, pivotElement);
		}
		
		// Name attribute mapping
		String name = csElement.getName();
		if (name != null) {
			context.refreshName(pivotElement, name);
			context.refreshComments(pivotElement, csElement);
		}
		return null;
	}
}
