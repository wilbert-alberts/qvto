package org.eclipse.qvto.examples.xtext.imperativeocl.imperativeoclcs.util.cs2as;

import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;

/**
 * Manual ImperativeOCL Containment Visitor which will contain some specializations those bits unsupported
 * by the generator
 *  
 * @author adolfosbh
 */
public class ImperativeOCLCSContainmentVisitor extends AutoImperativeOCLCSContainmentVisitor {

	public ImperativeOCLCSContainmentVisitor(CS2PivotConversion context) {
		super(context);
	}
}
