/*******************************************************************************
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.keywordhandler.scopedvariablesextraction;

import lpg.lpgjavaruntime.IToken;

/**
* @author aigdalov
* Created on Nov 21, 2007
*/
class Result {
    private IToken myStartToken;
    private IToken myEndToken;
    private String myString;
    private Scope myScope;
    
    public Result(IToken startToken, IToken endToken, String string, Scope scope) {
        myStartToken = startToken;
        myEndToken = endToken;
        myString = string;
        myScope = scope;
    }

    public IToken getStartToken() {
        return myStartToken;
    }
    
    public void setStartToken(IToken startToken) {
        myStartToken = startToken;
    }
    
    public IToken getEndToken() {
        return myEndToken;
    }
    
    public void setEndToken(IToken endToken) {
        myEndToken = endToken;
    }
    
    public String getString() {
        return myString;
    }
    
    public void setString(String string) {
        myString = string;
    }
    
    public Scope getScope() {
        return myScope;
    }
    
    public void setScope(Scope scope) {
        myScope = scope;
    }
}