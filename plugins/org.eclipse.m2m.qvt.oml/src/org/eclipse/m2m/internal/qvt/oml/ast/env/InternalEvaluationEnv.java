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

import org.eclipse.m2m.internal.qvt.oml.evaluator.ThisInstanceResolver;


/**
 * This interface separates the internals of QVT Evaluation Environments that 
 * are not supposed to exposed to usual clients. 
 */
public interface InternalEvaluationEnv {

	Object getInvalid();
	    	
    int setCurrentASTOffset(int currentASTOffset);
    
    int getCurrentASTOffset();
        
	void pushObjectExpOwner(Object owner);
    
	void popObjectExpOwner();

	Object peekObjectExpOwner();
	
	ThisInstanceResolver getThisResolver();

	void setThisResolver(ThisInstanceResolver myThisResolver);
}
