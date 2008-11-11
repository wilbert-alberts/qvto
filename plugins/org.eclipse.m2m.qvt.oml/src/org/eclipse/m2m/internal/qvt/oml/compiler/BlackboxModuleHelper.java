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
package org.eclipse.m2m.internal.qvt.oml.compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.ValidationMessages;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.qvt.oml.blackbox.AbstractCompilationUnitDescriptor;
import org.eclipse.m2m.qvt.oml.blackbox.BlackboxException;
import org.eclipse.m2m.qvt.oml.blackbox.BlackboxRegistry;
import org.eclipse.m2m.qvt.oml.blackbox.CompilationUnit;
import org.eclipse.m2m.qvt.oml.blackbox.LoadContext;
import org.eclipse.m2m.qvt.oml.blackbox.ResolutionContext;
import org.eclipse.osgi.util.NLS;


public class BlackboxModuleHelper {
	
	final int STATUS_NOT_FOUND = 100;
	final int STATUS_LOAD_FAILED = 110;	
	final int STATUS_COMPILATION_ERRORS = 120;	
	
	private ResolutionContext fResolutionContext;
	private LoadContext fLoadContext;
    private final Map<String, Entry> fModuleEntries = new HashMap<String, Entry>();
	
	public BlackboxModuleHelper() {
		super();
	}
	
	public void setContext(ResolutionContext resolutionContext, LoadContext loadContext) {
		fResolutionContext = resolutionContext;
		fLoadContext = loadContext;
	}

    public List<Module> getModules(List<String> compilationUnitQName) {
    	if(compilationUnitQName == null) {
    		throw new IllegalArgumentException();
    	}

    	Entry entry = load(compilationUnitQName);
    	CompilationUnit compilationUnit = entry.compilationUnit;
		if(compilationUnit == null) {
    		return null;
    	}

    	List<Module> modules = new ArrayList<Module>(compilationUnit.getElements().size());
    	for (QvtOperationalModuleEnv nextEnv : compilationUnit.getElements()) {
    		modules.add(nextEnv.getModuleContextType());
		}
    	
    	return modules;
    }
    
    public QvtOperationalModuleEnv getModuleEnvironment(Module module) {
    	if(module == null) {
    		throw new IllegalArgumentException();
    	}
    	
    	for (Entry moduleEntry : fModuleEntries.values()) {
    		CompilationUnit compilationUnit = moduleEntry.compilationUnit;
    		if(compilationUnit != null) {
				for (QvtOperationalModuleEnv nextEnv : compilationUnit.getElements()) {
		    		if(nextEnv.getModuleContextType() == module) {
		    			return nextEnv;
		    		}
				}
    		}
		}
    	
    	return null;
    }
    
    public boolean isOK(List<String> compilationUnitQName) {
    	Diagnostic status = getStatus(compilationUnitQName);
		return status.getSeverity() == Diagnostic.OK;
    }
    
    public boolean notFound(List<String> compilationUnitQName) {
    	Diagnostic status = getStatus(compilationUnitQName);
		return status.getSeverity() != Diagnostic.OK && status.getCode() == STATUS_NOT_FOUND;
    }

    public boolean loadFailed(List<String> compilationUnitQName) {
    	Diagnostic status = getStatus(compilationUnitQName);
		return status.getSeverity() != Diagnostic.OK && status.getCode() == STATUS_LOAD_FAILED;
    }
    
    Diagnostic getStatus(List<String> compilationUnitQName) {
    	return load(compilationUnitQName).getDiagnostic();
    }
    
    private Entry load(List<String> compilationUnitQName) {
    	if(fLoadContext == null || fResolutionContext == null) {
    		throw new IllegalStateException("Not context is assigned"); //$NON-NLS-1$
    	}
    	String qname = QvtOperationalParserUtil.getStringRepresentation(compilationUnitQName, ".");	    	
    	Entry result = fModuleEntries.get(qname);			
    	if(result == null) {
			AbstractCompilationUnitDescriptor descriptor = BlackboxRegistry.INSTANCE.getCompilationUnitDescriptor(qname, fResolutionContext);
			if (descriptor != null) {
				try {
					CompilationUnit cunit = BlackboxRegistry.INSTANCE.loadCompilationUnit(descriptor, fLoadContext);
					result = new Entry(cunit);
					fModuleEntries.put(qname, result);					
					// Note: Still might be null in case of empty compilation unit  
				} catch (BlackboxException e) {
					if(e.getDiagnostic() != null) {
						QvtPlugin.log(BasicDiagnostic.toIStatus(e.getDiagnostic()));
					} else {
						QvtPlugin.logError(NLS.bind(ValidationMessages.FailedToLoadLibrary, new Object[] { qname }), e);
					}
					
					// set error status to indicate the module load failure
					result = new Entry(createErrorStatus(STATUS_LOAD_FAILED, e.getMessage()));						
					fModuleEntries.put(qname, result);
				}
			} else {
				result = new Entry(createErrorStatus(STATUS_NOT_FOUND, "Not found")); //$NON-NLS-1$
				fModuleEntries.put(qname, result);					
			}
		}
		
		return result;
    }

    private static Diagnostic createErrorStatus(int code, String message) {
    	return new BasicDiagnostic(Diagnostic.ERROR, BlackboxModuleHelper.class.getName(), code, message, null);
    }
    
    private static class Entry {
		final Diagnostic status;
    	final CompilationUnit compilationUnit;
    	
    	Entry(CompilationUnit compilationUnit) {
			this.compilationUnit = compilationUnit;
			this.status = Diagnostic.OK_INSTANCE;
		}
    	
    	Entry(Diagnostic problem) {
    		this.status = problem;
    		this.compilationUnit = null;
		}
    	
    	Diagnostic getDiagnostic() {
    		return status;
    	}
    }	    
}
