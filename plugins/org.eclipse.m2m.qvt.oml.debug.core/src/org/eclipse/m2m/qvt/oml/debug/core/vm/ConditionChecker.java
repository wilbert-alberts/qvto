/*******************************************************************************
 * Copyright (c) 2009 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.debug.core.vm;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalVisitorCS;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.cst.completion.parser.LightweightParser;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOLexer;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtOperationalEvaluationVisitorImpl;
import org.eclipse.m2m.qvt.oml.debug.core.QVTODebugCore;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.parser.OCLLexer;
import org.eclipse.ocl.utilities.ASTNode;

public class ConditionChecker {

	private final String fConditionBody;
	private final ASTNode fTargetASTElement;
	
	private OCLExpression<EClassifier> fConditionAST;
	private String fConditionError;


	public ConditionChecker(String conditionBody, ASTNode targetASTElement) {
		if(conditionBody == null || targetASTElement == null) {
			throw new IllegalArgumentException();
		}
		
		fConditionBody = conditionBody;
		fTargetASTElement = targetASTElement;
	}
		
	public boolean checkCondition(QvtOperationalEvaluationVisitorImpl mainEvaluator) throws CoreException {
		OCLExpression<EClassifier> condition = getConditionAST();
		if (condition == null) {
			throw new CoreException(QVTODebugCore.createStatus(
					IStatus.ERROR, fConditionError));
		}
				
		QvtOperationalEvaluationEnv evalEnv = mainEvaluator.getOperationalEvaluationEnv().cloneEvaluationEnv();
		
		QvtOperationalEvaluationVisitorImpl newVisitor = new QvtOperationalEvaluationVisitorImpl(
				(QvtOperationalEnv) mainEvaluator.getEnvironment(), evalEnv);

		try {
			return Boolean.TRUE.equals(condition.accept(newVisitor));
		} catch (Exception e) {
			throw new CoreException(QVTODebugCore.createStatus(
					IStatus.ERROR, "Condition evaluation error" + e.toString(), e));
		}
	}
	
	
    private TargetContextEnv getEnvironmentForASTElement() {
		QvtOperationalEnv env = (QvtOperationalEnv) ASTBindingHelper.resolveEnvironment(fTargetASTElement);

		QvtOperationalEnvFactory factory = new QvtOperationalEnvFactory();
		// FIXME make module env available from the module
		// workaround - just empty root env
		QvtOperationalEnv rootEnv = factory.createEnvironment();
		QvtOperationalEnv contextEnv = rootEnv;

		
    	EObject context = fTargetASTElement;    	
    	while(context != null) {
    		if(context instanceof EOperation) {
    			contextEnv = factory.createOperationContext(rootEnv, (EOperation) context);
    		}
    		
    		context = context.eContainer();
    	}
    	
    	return new TargetContextEnv(contextEnv);
    }
    
	private OCLExpression<EClassifier> getConditionAST() {
		if(fConditionError != null) {
			return null;
		}

		if (fConditionAST == null) { 
			fConditionAST = analyzeCondition();
		}
		
		return fConditionAST;
	}
	    
    private OCLExpressionCS parseCondition(QvtOperationalEnv env) {    	
        try {        	
            QVTOLexer lexer = new QVTOLexer(env);
            lexer.initialize(new OCLInput(fConditionBody).getContent(), "Condition"); //$NON-NLS-1$
            
            LightweightParser parser = new LightweightParser(lexer);            
            parser.enableCSTTokens(true);
            parser.resetTokenStream();            
            lexer.lexToTokens(parser);
            CSTNode cst = parser.parseTokensToCST(null, 10);
            if(cst instanceof OCLExpressionCS) {
            	return (OCLExpressionCS) cst;
            }		
            
            env.reportError("Not an OCL expression", -1, -1); //$NON-NLS-1$
        } catch (ParserException ex) {
        	// add parser error to environment
            env.reportError(ex.toString(), -1, -1);            
        }
        
        return null;
    }

    private OCLExpression<EClassifier> analyzeCondition()  {
    	TargetContextEnv env = getEnvironmentForASTElement();
        OCLExpressionCS conditionCS = parseCondition(env);		
        OCLExpression<EClassifier> ast = null;
        
        if (conditionCS != null && !env.hasErrors()) {
            OCLLexer oclLexer = new OCLLexer(env);
            oclLexer.initialize(new char[0], "Condition"); //$NON-NLS-1$
            
            QvtCompilerOptions options = new QvtCompilerOptions(); 
            options.setReportErrors(true);
            options.setShowAnnotations(false);
            options.setSourceLineNumbersEnabled(false);
            QvtOperationalVisitorCS visitor = new QvtOperationalVisitorCS(oclLexer, env, options);
            
            ast = visitor.analyzeExpressionCS(conditionCS, env);
        }
        
        if(ast == null || env.hasErrors()) {
        	ast = null;
        	if(env.hasErrors()) {
        		fConditionError = env.getErrorTxtBuffer().toString();
        	} else {
				fConditionError = "Failed to parse condition"; //$NON-NLS-1$            		
        	}
        }
        
        return ast;
    }
        
	private class TargetContextEnv extends QvtOperationalEnv {

		private StringBuilder fErrors = new StringBuilder();
		
		protected TargetContextEnv(QvtOperationalEnv parent) {
			super(parent);
		}
		
		StringBuilder getErrorTxtBuffer() {
			return fErrors;
		}
		
		@Override
		public boolean hasErrors() {
			return fErrors.length() > 0;
		}
		
		@Override
		public void reportError(String message, int startOffset, int endOffset) {
			// do not propagate fErrors to the root environment
			fErrors.append(message).append('\n');
		}

		@Override
		public void reportWarning(String message, int startOffset, int endOffset) {
			// not important
		}
	}    
}
