package org.eclipse.qvto.examples.xtext.imperativeocl.cs2as;

import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;

/**
 * Manual ImperativeOCL Containment Visitor which will contain some specializations those bits unsupported
 * by the generator
 *  
 * @author adolfosbh
 */
public class ImperativeOCLCSContainmentVisitor extends org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.ImperativeOCLCSContainmentVisitor {

	public ImperativeOCLCSContainmentVisitor(CS2PivotConversion context) {
		super(context);
	}
}
