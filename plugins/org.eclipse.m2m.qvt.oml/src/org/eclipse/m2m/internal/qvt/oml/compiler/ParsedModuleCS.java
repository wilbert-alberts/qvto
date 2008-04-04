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

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.internal.cst.MappingModuleCS;
import org.eclipse.m2m.qvt.oml.internal.cst.parser.AbstractQVTParser;
import org.eclipse.ocl.cst.PathNameCS;


public class ParsedModuleCS {

	private final AbstractQVTParser myParser;	
    private final CFile mySource;
    private final MappingModuleCS myModuleCS; 
    private final Map<PathNameCS, ParsedModuleCS> myResolvedImports;

	public ParsedModuleCS(MappingModuleCS moduleCS, CFile source, AbstractQVTParser parser) {
		if(moduleCS == null || source == null || parser == null) {
			throw new IllegalArgumentException();
		}
		
		if(false == parser.getEnvironment() instanceof QvtOperationalEnv) {
			throw new IllegalArgumentException("Parser without environment"); //$NON-NLS-1$
		}
		
		mySource = source;
		myModuleCS = moduleCS;
        myParser = parser;
        
		myResolvedImports = new LinkedHashMap<PathNameCS, ParsedModuleCS>();
	}

	public CFile getSource() {
		return mySource;
	}
	
	public MappingModuleCS getModuleCS() {
		return myModuleCS;
	}
	
	public QvtOperationalEnv getEnvironment() {
		return (QvtOperationalEnv) myParser.getEnvironment();
	}
	
	public AbstractQVTParser getParser() {
		return myParser;
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
	
	@Override
	public String toString() {	
		return "Parsed module: " + mySource.getName(); //$NON-NLS-1$
	}
}