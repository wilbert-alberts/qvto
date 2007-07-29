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
/**
 * 
 */
package org.eclipse.m2m.qvt.oml.common.parser;

public class VarNode extends Node {
    public VarNode(String varName) {
        myVarName = varName;
    }
    public String getVarName() { 
        return myVarName; 
    }

    @Override
	public String toString() {
        return "" + ParameterizedStringParser.DOLLAR + ParameterizedStringParser.LEFT_CURL +  //$NON-NLS-1$
            getVarName() + ParameterizedStringParser.RIGHT_CURL;
    }
    
    final String myVarName;
}