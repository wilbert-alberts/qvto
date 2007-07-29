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
package org.eclipse.m2m.qvt.oml.compiler;

import org.eclipse.m2m.qvt.oml.QvtMessage;
import org.eclipse.m2m.qvt.oml.ocl.completion.CompletionData;


public class QvtCompilationResult {
    QvtCompilationResult(final CompiledModule module, final CompletionData data) {
        myModule = module;
        myData = data;
    }
    
    public CompiledModule getModule() {
        return myModule;
    }
    
    public CompletionData getCompletionData() {
        return myData;
    }

    public QvtMessage[] getErrors() {
        return myModule.getErrors();
    }
    
    public QvtMessage[] getWarnings() {
    	return myModule.getWarnings();
    }
    
    public QvtMessage[] getMessages() {
    	return myModule.getMessages();
    }
    
    private final CompiledModule myModule;
    private final CompletionData myData;
}
