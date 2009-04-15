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

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.QvtMessage;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.cst.UnitCS;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;

public class CompiledUnit {
	
	private List<String> fQname;
	private URI fUri;	
	private List<QvtMessage> fAllProblems;
	private List<CompiledUnit> fImports;
	private List<QvtOperationalModuleEnv> moduleEnvs;

	// FIXME - add compilationUnit CST element
	UnitCS fUnitCST;	
	
	
	CompiledUnit(List<String> qualifiedName, URI uri, List<? extends QvtOperationalModuleEnv> modules) {
		if(qualifiedName == null || modules == null || uri == null) {
			throw new IllegalArgumentException();
		}
		
		this.fUri = uri;
		this.fQname = qualifiedName;		
		this.moduleEnvs = new ArrayList<QvtOperationalModuleEnv>(modules);
		
		ArrayList<QvtMessage> problems = new ArrayList<QvtMessage>();
		this.fAllProblems = problems;
		
		for (QvtOperationalModuleEnv next : modules) {
			fAllProblems.addAll(next.getAllProblemMessages());
		}

		if(!problems.isEmpty()) {
			problems.trimToSize();			
		}
	}
	
	void addProblem(QvtMessage problem) {
		if(problem == null) {
			throw new IllegalArgumentException();
		}
		
		fAllProblems.add(problem);
	}

				
	void setImports(List<CompiledUnit> imports) {
		this.fImports = imports; 
	}
	
	List<String> getQualifiedName() {
		return fQname;
	}	
	
	public String getName() {
		return fQname.get(fQname.size() - 1);
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
	
	public URI getURI() {
		return fUri;
	}
		
	public UnitCS getUnitCST() {
		return fUnitCST;
	}
		
	public List<QvtMessage> getProblems() {
		return fAllProblems;
	}		

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CompiledUnit) {
			CompiledUnit another = (CompiledUnit) obj;
			return fUri.equals(another.fUri);
		}
		
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {	
		return fUri.hashCode();
	}
	
	@Override
	public String toString() {		
		return fUri.toString();
	}
}