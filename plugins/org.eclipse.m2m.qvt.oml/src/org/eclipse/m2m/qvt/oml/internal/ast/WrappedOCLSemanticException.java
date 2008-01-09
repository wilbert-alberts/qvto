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
package org.eclipse.m2m.qvt.oml.internal.ast;

import org.eclipse.ocl.SemanticException;

/**
 * This exception allows to bind problem location info to SemanticException received from MDT OCL.
 * The caller of failing MDT functionality can catch the original exception and assign location info
 * based in its calling context. Note: This is not done in MDT OCL itself.
 * <p>
 * Remark: Do not propagate to HEAD, running against OCL 1.2
 */
public class WrappedOCLSemanticException extends SemanticException {

	private static final long serialVersionUID = 4258334273449856053L;

	private int fOffset;
	private int fLength;
	
	
	public WrappedOCLSemanticException(SemanticException cause, int offset, int length) {
		super(cause.getMessage(), cause);
		
		fOffset = offset;
		fLength = length;
	}

	public int getLocationOffset() {
		return fOffset;
	}
		
	public int getLocationLength() {
		return fLength;
	}
	
}
