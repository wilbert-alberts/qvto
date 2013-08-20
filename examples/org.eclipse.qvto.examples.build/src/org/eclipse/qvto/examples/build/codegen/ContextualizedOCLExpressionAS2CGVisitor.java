package org.eclipse.qvto.examples.build.codegen;

import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.qvto.examples.build.xtend.ContainmentVisitsGenerator;


/**
 * This visitor will be used in the aim of generating JAVA code from OCL expressions.
 * 
 * {@link ContainmentVisitsGenerator} needs to analyze the initiatlization OCL expression (right hand side) of 
 * the {@link ConstructorPart} in order to produce the corresponding java code for that OCL expressions. An specialized
 * OCL CodeGen will be used.  
 *  
 * @author adolfosbh
 *
 */
public class ContextualizedOCLExpressionAS2CGVisitor extends AS2CGVisitor {

	public ContextualizedOCLExpressionAS2CGVisitor(CodeGenAnalyzer analyzer) {
		super(analyzer);
	}
}