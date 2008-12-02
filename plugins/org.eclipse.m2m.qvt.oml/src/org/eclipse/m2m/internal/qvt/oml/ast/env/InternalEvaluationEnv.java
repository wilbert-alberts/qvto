/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.ast.env;

import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ThisInstanceResolver;
import org.eclipse.m2m.internal.qvt.oml.evaluator.TransformationInstance;
import org.eclipse.m2m.internal.qvt.oml.library.EObjectEStructuralFeaturePair;


/**
 * This interface separates the internals of QVT Evaluation Environments that 
 * are not supposed to exposed to usual clients. 
 */
public interface InternalEvaluationEnv {

	/**
	 * Retrieves the currently executed transformation, if one is available.
	 * 
	 * @return the transformation object or <code>null</code>, if the current
	 *         evaluation environment is not part of a transformation execution,
	 *         but for instance Imperative OCL. 
	 */
	TransformationInstance getCurrentTransformation();

	/**
	 * Retrieves the module in which the current evaluation occurs, if one is available.
	 * Note: The current module may be transformation or library
	 * 
	 * @return the module instance or <code>null</code>, if the current
	 *         evaluation environment is not part of a transformation execution,
	 *         but for instance Imperative OCL. 
	 */	
	ModuleInstance getCurrentModule();	
	
	Object getInvalid();
	    	
    int setCurrentASTOffset(int currentASTOffset);
    
    int getCurrentASTOffset();
        
	void pushObjectExpOwner(Object owner);
    
	void popObjectExpOwner();

    // FIXME - never called, only push/popObjectExpOwner(...) is used, 
	// -> review this
	Object peekObjectExpOwner();
	
	ThisInstanceResolver getThisResolver();

	void setThisResolver(ThisInstanceResolver myThisResolver);
	    
    void addDeferredTask(Runnable task);
    
    void processDeferredTasks();
    
    EObjectEStructuralFeaturePair getLastAssignmentLvalueEval();
    
    void setLastAssignmentLvalueEval(EObjectEStructuralFeaturePair lvalue);
    
    ModelParameterExtent getUnboundExtent();
}
