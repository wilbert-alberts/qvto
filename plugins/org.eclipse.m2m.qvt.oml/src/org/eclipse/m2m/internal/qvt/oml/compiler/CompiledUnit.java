/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation
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
import java.util.Collections;
import java.util.List;

import org.eclipse.m2m.internal.qvt.oml.QvtMessage;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.cst.UnitCS;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;

public class CompiledUnit {
	
	private List<String> fQname;
	private CFile fSource;	
	private List<QvtMessage> fAllProblems;
	private List<CompiledUnit> fImports;
	private List<QvtOperationalModuleEnv> moduleEnvs;

	// FIXME - add compilationUnit CST element
	UnitCS fUnitCST;	
	
	
	CompiledUnit(List<String> qualifiedName, CFile source, QvtOperationalModuleEnv modules) {
		if(qualifiedName == null || source == null || modules == null) {
			throw new IllegalArgumentException();
		}
		
		this.fQname = qualifiedName;
		this.fSource = source;
		this.moduleEnvs = Collections.singletonList(modules);
		this.fAllProblems = modules.getAllProblemMessages();
	}

	CompiledUnit(List<String> qualifiedName, List<QvtOperationalModuleEnv> modules) {
		if(qualifiedName == null || modules == null) {
			throw new IllegalArgumentException();
		}
		
		this.fQname = qualifiedName;		
		this.moduleEnvs = modules;			
		this.fAllProblems = new ArrayList<QvtMessage>();
		for (QvtOperationalModuleEnv next : modules) {
			fAllProblems.addAll(next.getAllProblemMessages());
		}
	}
				
	void setImports(List<CompiledUnit> imports) {
		this.fImports = imports; 
	}
	
	List<String> getQualifiedName() {
		return fQname;
	}	
	
	public String getName() {
		return fSource.getUnitName();
	}
	
	public List<QvtOperationalModuleEnv> getModuleEnvironments() {
		return moduleEnvs;
	}
	
	public List<QvtMessage> getErrors() {
		List<QvtMessage> errors = new ArrayList<QvtMessage>();			
		for (QvtMessage nextMessage : fAllProblems) {
			if(nextMessage.getSeverity() == QvtMessage.SEVERITY_ERROR) {
				errors.add(nextMessage);
			}
		}			
		return errors;
	}
	
	public List<QvtMessage> getWarnings() {
		List<QvtMessage> warnings = new ArrayList<QvtMessage>();			
		for (QvtMessage nextMessage : fAllProblems) {
			if(nextMessage.getSeverity() == QvtMessage.SEVERITY_WARNING) {
				warnings.add(nextMessage);
			}
		}			
		return warnings;
	}
	
	
	public List<CompiledUnit> getCompiledImports() { 
		return fImports != null ? fImports : Collections.<CompiledUnit>emptyList();
	}
	
	public List<Module> getModules() {
		List<Module> modules = new ArrayList<Module>(moduleEnvs.size());
		for (QvtOperationalModuleEnv next : moduleEnvs) {
			if(next.getModuleContextType() != null) {
				modules.add(next.getModuleContextType());
			}
		}
		
		return modules;
	}
	
	public CFile getSource() {
		return fSource;
	}
	
	public UnitCS getUnitCST() {
		return fUnitCST;
	}
		
	public List<QvtMessage> getProblems() {
		return fAllProblems;
	}		
	
	@Override
	public String toString() {		
		return fSource.getFullPath();
	}
}