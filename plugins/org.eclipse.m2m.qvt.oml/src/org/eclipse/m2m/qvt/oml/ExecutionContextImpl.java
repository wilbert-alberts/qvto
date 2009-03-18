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
package org.eclipse.m2m.qvt.oml;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.m2m.qvt.oml.util.EvaluationMonitor;
import org.eclipse.m2m.qvt.oml.util.Log;

/**
 * @since 2.0
 * 
 * @noextend This class is not intended to be subclassed by clients.
 */
public class ExecutionContextImpl implements ExecutionContext {
		
	private Map<String, Object> fConfigProperties = new HashMap<String, Object>(5);
	
	private EvaluationMonitor fMonitor;
	
	private Log fLog;
	

	public ExecutionContextImpl() {
		fLog = Log.NULL_LOG;
		fMonitor =  ExecutionContextImpl.createDefaultMonitor();
	}
	
	public Object getConfigProperty(String name) {
		if(name == null) {
			throw new IllegalArgumentException();
		}
		
		return fConfigProperties.get(name);
	}
	
	public void setConfigProperty(String name, Object value) {
		if(name == null) {
			throw new IllegalArgumentException("null config property name"); //$NON-NLS-1$
		}
		
		fConfigProperties.put(name, value);
	}
	
	
	public Set<String> getConfigPropertyNames() {
		return Collections.unmodifiableSet(fConfigProperties.keySet());
	}

    public void setLog(Log log) {
    	if(log == null) {
    		throw new IllegalArgumentException("Non-null logger required"); //$NON-NLS-1$
    	}
    	
		this.fLog = log;
	}
	
	public Log getLog() {
		return fLog;
	}
		
	public EvaluationMonitor getMonitor() {
		return fMonitor;
	}
	
	public void setMonitor(EvaluationMonitor monitor) {
		if(monitor == null) {
			throw new IllegalArgumentException("null monitor"); //$NON-NLS-1$
		}
		
		fMonitor = monitor;
	}
	
	private static EvaluationMonitor createDefaultMonitor() {
		return new EvaluationMonitor() {		    	
			boolean myIsCancelled;
	
			public void cancel() {
				myIsCancelled = true;
			}
	
			public boolean isCanceled() {
				return myIsCancelled;
			}
		};
	}
}