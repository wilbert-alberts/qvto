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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.IModuleSourceInfo;
import org.eclipse.m2m.internal.qvt.oml.ast.env.InternalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.ocl.utilities.ASTNode;

/**
 * Helps to build QVT stack trace from a given state of QVT code execution.
 */
public class QvtStackTraceBuilder {
	
	private static final String NAME_SEPARATOR = "::"; //$NON-NLS-1$
	private static final String UNKNOWN_NAME = "<Unknown>"; //$NON-NLS-1$
	private static final String INITIALIZER_NAME = "<init>"; //$NON-NLS-1$
	private static final int UNKNOWN_LINE_NUM = -1;
	
	private QvtOperationalEvaluationEnv fEvalEnv;

	/**
	 * Constructs stack trace builder for the given evaluation environment.
	 * 
	 * @param evalEnv
	 *            the evaluation environment representing the top stack trace
	 *            
	 * @param astNodeIPOffset explicit the AST node offset representing the current instruction 
	 *		pointer of execution in a QVT module
	 */
	public QvtStackTraceBuilder(QvtOperationalEvaluationEnv evalEnv) {
		if(evalEnv == null) {
			throw new IllegalArgumentException();
		}
		
		fEvalEnv = evalEnv;
	}
	
	/**
	 * Builds the stack trace corresponding to evaluation environments hierarchy
	 * associated with this builder.
	 * 
	 * @return list of QVT stack elements
	 */
    public List<QVTStackTraceElement> buildStackTrace() {
    	LinkedList<QVTStackTraceElement> elements = new LinkedList<QVTStackTraceElement>();
    	int depth = 0;
    	for(QvtOperationalEvaluationEnv parentEnv = fEvalEnv; parentEnv != null; parentEnv = parentEnv.getParent()) {    		    		
    		elements.addLast(createStackElement(parentEnv));
    		depth++;    		
    	}
    	
    	return Collections.unmodifiableList(elements);
    }

    private QVTStackTraceElement createStackElement(QvtOperationalEvaluationEnv env) {
    	String unitName = null;
    	String moduleName = UNKNOWN_NAME;
    	String operName = UNKNOWN_NAME;
    	int lineNumber = UNKNOWN_LINE_NUM;    	
    	
    	Module module = null;
    	ImperativeOperation operation = env.getOperation();

    	InternalEvaluationEnv internEvalEnv = env.getAdapter(InternalEvaluationEnv.class);
    	int resultOffset = getCurrentASTOffset(internEvalEnv);
		boolean isRunningInTransformation = internEvalEnv.getCurrentTransformation() != null;
		
		if(isRunningInTransformation) {
	    	ModuleInstance thisInstance = internEvalEnv.getCurrentModule();
	    	assert thisInstance != null;
	    	
	    	module = thisInstance.getModule();
	    	moduleName = module.getName();
	    	
			if(operation == null) {
				// we must be executing a module instance initialization - synthetic constructor
		    	operName = INITIALIZER_NAME;
		    	
		    	if(internEvalEnv.getCurrentIP() == module || resultOffset < -1) {
			    	// FIXME - a temporary solution to get header positions until
		    		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=257527 is resolved.		    		
			    	int[] positions = QvtOperationalParserUtil.getElementPositions(module);
			    	if(positions != null) {
			    		resultOffset = positions[0];
			    	}
		    	}
			} else {
	    		operName = operation.getName();	    		
	    		EClassifier contextType = QvtOperationalParserUtil.getContextualType(operation);
	    		if(contextType != null) {
	    			operName = contextType.getName() + NAME_SEPARATOR + operName;
	    		}
			}
		} else { 
			// TODO - non-transformation execution context 
    	}

		if(module != null) {
			IModuleSourceInfo sourceInfo = ASTBindingHelper.getModuleSourceBinding(module);
			if(sourceInfo != null) {
				URI uri = sourceInfo.getSourceURI();
				unitName = uri.lastSegment();
				if(resultOffset >= 0) {
					lineNumber = sourceInfo.getLineNumberProvider().getLineNumber(resultOffset);
				}
			}
		}
    	
    	return new QVTStackTraceElement(moduleName, operName, unitName, lineNumber);
    }
    
    private static int getCurrentASTOffset(InternalEvaluationEnv evalEnv) {
    	// TODO - for cases that AST does not fill all offset
    	// traverse up to the enclosing operation scope, taking the closest 
    	// offset which has been initialized    	
    	EObject currentIPObject = evalEnv.getCurrentIP();
    	if(currentIPObject instanceof ASTNode) {
    		ASTNode astNode = (ASTNode) currentIPObject;
    		return astNode.getStartPosition();
    	}
    	
    	return -1;
    }
}
