/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.evaluator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.IModuleSourceInfo;
import org.eclipse.m2m.internal.qvt.oml.ast.env.InternalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * Helps to build QVT stack trace from a given state of QVT code execution.
 */
public class QvtStackTraceBuilder {
	
	private static final String UNKNOWN_NAME = "<Unknown>"; //$NON-NLS-1$
	private static final String INITIALIZER_NAME = "<init>"; //$NON-NLS-1$
	private static final int UNKNOWN_LINE_NUM = -1;
	
	private QvtOperationalEvaluationEnv fEnv;
	private Module fMainModule;
	private int fOffset;
	private UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
		EObject, CallOperationAction, SendSignalAction, Constraint> fUML;

	/**
	 * Constructs stack trace builder for the given evaluation environment.
	 * 
	 * @param env
	 *            the evaluation environment representing the top stack trace
	 * @param uml
	 *            UML reflection instance, used for constructing model elements
	 *            names
	 * @param mainModule
	 *            the module containing the main entry point or
	 *            <code>null</code> if no entry point is available.
	 *            
	 * @param astNodeIPOffset explicit the AST node offset representing the current instruction 
	 *		pointer of execution in a QVT module
	 */
	public QvtStackTraceBuilder(QvtOperationalEvaluationEnv env, UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, 
			EObject, CallOperationAction, SendSignalAction, Constraint> uml, 
			Module mainModule, int astNodeIPOffset) {
		if(env == null || uml == null) {
			throw new IllegalArgumentException();
		}
		
		fEnv = env;
		fUML = uml;
		fOffset = astNodeIPOffset;
		fMainModule = mainModule;
	}
	
	/**
	 * Builds the stack trace corresponding to evaluation environmnets hierarchy associated 
	 * with this builder.
	 * @return 
	 */
    public List<StackTraceElement> buildStackTrace() {
    	List<StackTraceElement> elements = new LinkedList<StackTraceElement>();
    	int pos = 0;
    	for(QvtOperationalEvaluationEnv nextEnv = fEnv; nextEnv != null; nextEnv = nextEnv.getParent()) { 
    		elements.add(createStackElement(nextEnv, pos++));
    	}
    	    	
    	return Collections.unmodifiableList(elements);
    }
    
    private StackTraceElement createStackElement(QvtOperationalEvaluationEnv env, int stackPos) {
    	
    	String fileName = null;    	
    	String declClassName = UNKNOWN_NAME;    	
    	String operName = UNKNOWN_NAME;
    	int lineNumber = UNKNOWN_LINE_NUM;    	
    	
    	Module module = null;
    	int resultOffset = fOffset;
    	EOperation operation = env.getOperation();
    	    	
    	InternalEvaluationEnv internEvalEnv = env.getAdapter(InternalEvaluationEnv.class);
		if(operation == null) {
	    	operName = INITIALIZER_NAME;

	    	ModuleInstance thisInstance = (ModuleInstance) env.getValueOf("this");
	    	module = thisInstance.getModule();
	    	
	    	if(module != null && module.getName() != null) {
	    		declClassName = module.getName(); 
	    	}
	    	resultOffset = internEvalEnv.getCurrentASTOffset();
	    	ImperativeOperation mainMethod = QvtOperationalParserUtil.getMainOperation(fMainModule);
			if(resultOffset < 0 && mainMethod != null) {
	    		resultOffset = mainMethod.getStartPosition();
	    	}
    	}
    	else {
    		if(operation.getName() != null) {
    			operName = operation.getName();
    		}

    		if(operation instanceof ImperativeOperation) {
    			module = QvtOperationalParserUtil.getOwningModule((ImperativeOperation)operation);
    		}

    		EClassifier owner = fUML.getOwningClassifier(operation);
    		if(owner == null && operation.getEContainingClass() != null) {
    			owner = operation.getEContainingClass();
    		}
    		
			if(owner != null) {
	    		declClassName = fUML.getName(owner);
			}
    		
    		resultOffset = (stackPos == 0) ? fOffset : internEvalEnv.getCurrentASTOffset();
    	}   


    	if(module != null) {
			IModuleSourceInfo sourceInfo = ASTBindingHelper.getModuleSourceBinding(module);
			if(sourceInfo != null) {
				fileName = sourceInfo.getFileName();
				
				if(resultOffset >= 0) {
					lineNumber = sourceInfo.getLineNumberProvider().getLineNumber(resultOffset);
				}
			}
    	}
    	
    	return new StackTraceElement(declClassName, operName, fileName, lineNumber);
    }	
}
