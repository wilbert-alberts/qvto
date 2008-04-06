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
package org.eclipse.m2m.internal.qvt.oml.compiler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.m2m.internal.qvt.oml.QvtMessage;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.expressions.Module;

public class CompiledModule {
	
	public CompiledModule(final Module module, final ParsedModuleCS moduleCS,
			final CFile source, final List<QvtMessage> messages) {
		myModule = module;
		mySource = source;  
        myWarnings = new ArrayList<QvtMessage>(2);
        myErrors = new ArrayList<QvtMessage>(2);
        for (QvtMessage m : messages) {
        	addMessage(m);
        }
        myCompiledImports = new ArrayList<CompiledModule>(2);
        mySyntaxElement = moduleCS;
	}
	
	public Module getModule() {
		return myModule;
	}
	
	public CFile getSource() {
		return mySource;
	}
	
	public List<CompiledModule> getCompiledImports() {
		return myCompiledImports;
	}

	public ParsedModuleCS getSyntaxElement() {
		return mySyntaxElement;
	}
	
	public QvtMessage[] getErrors() {
		return (QvtMessage[])myErrors.toArray(new QvtMessage[myErrors.size()]);
    }
    
    public QvtMessage[] getWarnings() {
		return (QvtMessage[])myWarnings.toArray(new QvtMessage[myWarnings.size()]);
    }
    
    public QvtMessage[] getMessages() {
    	List<QvtMessage> allMessages = new ArrayList<QvtMessage>(myWarnings);
    	allMessages.addAll(myErrors);
    	return (QvtMessage[])allMessages.toArray(new QvtMessage[allMessages.size()]);
    }
    
	public void addMessage(QvtMessage m) {
		if (m.getSeverity() == QvtMessage.SEVERITY_WARNING) {
			myWarnings.add(m);
		}
		else {
			myErrors.add(m);
		}
	}
	
	private final Module myModule;
	private final CFile mySource;
    private final List<QvtMessage> myWarnings;
    private final List<QvtMessage> myErrors;
    private final List<CompiledModule> myCompiledImports;
    private final ParsedModuleCS mySyntaxElement;

}
