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

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.m2m.qvt.oml.QvtMessage;
import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.internal.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS;
import org.eclipse.m2m.qvt.oml.internal.cst.parser.QvtOpLexer;
import org.eclipse.ocl.cst.PathNameCS;

public class ParsedModuleCS {
	private final QvtOpLexer myLexer;
    private final List<QvtMessage> myMessages;
    private final CFile mySource;
    private final MappingModuleCS myModuleCS; 
    private final Map<PathNameCS, ParsedModuleCS> myResolvedImports;

	public ParsedModuleCS(MappingModuleCS moduleCS, CFile source, QvtOpLexer lexer) {
		mySource = source;
		myModuleCS = moduleCS;
        myLexer = lexer;
        
		myMessages = new ArrayList<QvtMessage>();
		myResolvedImports = new LinkedHashMap<PathNameCS, ParsedModuleCS>();
	}

	public CFile getSource() {
		return mySource;
	}
	
	public MappingModuleCS getModuleCS() {
		return myModuleCS;
	}
	
	public QvtOpLexer getLexer() {
        return myLexer;
    }

    public Collection<ParsedModuleCS> getParsedImports() {
		return myResolvedImports.values();
	}

	public ParsedModuleCS getParsedImport(PathNameCS importPath) {
		return myResolvedImports.get(importPath);
	}

	public void addParsedImport(ParsedModuleCS parsedModule, PathNameCS importPath) {
		myResolvedImports.put(importPath, parsedModule);
	}

	public String getStringName() {
		if (myModuleCS.getHeaderCS() == null || myModuleCS.getHeaderCS().getPathNameCS() == null) {
			return null;
		}
		return QvtOperationalParserUtil.getStringRepresentation(
				myModuleCS.getHeaderCS().getPathNameCS(), "."); //$NON-NLS-1$
	}
	
	public void addMessage(QvtMessage m) {
		myMessages.add(m);
	}
	
	public void addMessages(List<QvtMessage> messages) {
		myMessages.addAll(messages);
	}
	
	public QvtMessage[] getMessages() {
		return (QvtMessage[])myMessages.toArray(new QvtMessage[myMessages.size()]);
	}
}