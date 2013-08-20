/**
 * <copyright>
 * 
 * Copyright (c) 2013 CEA LIST and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink(CEA LIST) - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvto.examples.build.codegen;

import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext

/**
 * A CG2JavaClassVisitor supports generation of an OCL expression as the LibraryOperation INSTANCE of a Java Class.
 */
public class ContextualizedOCLExpressionCG2JavaClassVisitor extends CG2JavaVisitor
{
	@NonNull  protected final  OCLExpression oclExp;
	@Nullable protected final  List<CGValuedElement> sortedGlobals;
	
	public new(@NonNull JavaCodeGenerator codeGenerator,
			@NonNull OCLExpression expInOcl, @Nullable List<CGValuedElement> sortedGlobals) {
		super(codeGenerator);
		this.oclExp = expInOcl;
		this.sortedGlobals = sortedGlobals;
	}

	@NonNull 
	override public Set<String> getAllImports() {
		return globalContext.getImports();
	}

	@Nullable 
	override public  Object visitCGClass(@NonNull CGClass cgClass) {		
		// Class<?> baseClass = genModelHelper.getAbstractOperationClass(expInOcl.getParameterVariable());
		// String title = cgClass.getName() + " provides the Java implementation for\n";
		// js.appendCommentWithOCL(title, oclExp);
		var String className = cgClass.getName();		
		js.append('''
			@SuppressWarnings("nls")
			public class «className»
			{
				''');
		js.pushIndentation(null);
		js.append('''public static final''');		
		js.appendIsRequired(true);
		js.append(''' «className» «globalContext.getInstanceName()» = new «className»();
				''');
		if (sortedGlobals != null) {
			generateGlobals(sortedGlobals);
		}
		js.append("\n");
		for (CGOperation cgOperation : cgClass.getOperations()) {
			cgOperation.accept(this);		
		}		
		js.popIndentation();
		js.append('''}
				''');
		return null;
	}
	

	@Nullable
	// FIXME Unfortunately CG2JavaVisitor::visitCGOperation arbitrariarly thinks I'm overriding an operation 
	// so I need to reimplement it to avoid that. This should be configurable
	override Object visitCGOperation(@NonNull CGOperation cgOperation) {
		var JavaLocalContext localContext2 = globalContext.getLocalContext(cgOperation);
		if (localContext2 != null) {
			localContext = localContext2;
			try {
//				CGValuedElement evaluatorParameter = localContext2.getEvaluatorParameter(cgOperation);
//				CGParameter typeIdParameter = localContext2.getTypeIdParameter(cgOperation);
				var List<CGParameter> cgParameters = cgOperation.getParameters();
				var CGValuedElement body = getExpression(cgOperation.getBody());
				//
				// js.append("@Override\n");
				js.append("public ");
				if (cgOperation.isNull()) {
					js.append("/*@Null*/");
				}
				else {
					js.appendIsRequired(cgOperation.isRequired());
				}
				js.append(" ");
				js.appendIsCaught(!cgOperation.isInvalid(), cgOperation.isInvalid());
				js.append(" ");
				js.appendClassReference(cgOperation);
				js.append(" ");
				js.append(cgOperation.getName());
				js.append("(");
				var boolean isFirst = true;
				for (CGParameter cgParameter : cgParameters) {
					if (!isFirst) {
						js.append(", ");
					}
					js.appendDeclaration(cgParameter);
					isFirst = false;
				}
				js.append(") {\n");
				js.pushIndentation(null);
					appendReturn(body);
				js.popIndentation();
				js.append("}\n");
			}
			finally {
				localContext = null;
			}
		}
		return null;
	}	
}