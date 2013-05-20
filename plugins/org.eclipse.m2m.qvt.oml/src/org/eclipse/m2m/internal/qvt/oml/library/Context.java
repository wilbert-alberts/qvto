/*******************************************************************************
 * Copyright (c) 2007, 2010 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.library;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.m2m.qvt.oml.util.EvaluationMonitor;
import org.eclipse.m2m.qvt.oml.util.IContext;
import org.eclipse.m2m.qvt.oml.util.ISessionData;
import org.eclipse.m2m.qvt.oml.util.Log;

/**
 * @noextend
 */
public class Context implements IContext {

    private final Map<String, Object>  myConfiguration;
    private SessionDataImpl myData;

    private Log myLog;
    private EvaluationMonitor myMonitor;
    
    public Context() {
    	myConfiguration = new HashMap<String, Object>();
    	myLog = Log.NULL_LOG;
		myMonitor = new DefaultMonitor();
		myData = new SessionDataImpl();
    }

    protected ISessionData createSessionData() {
    	return new SessionDataImpl(myData);
    }
    
    protected ISessionData copySessionData() {
    	return new SessionDataImpl(myData);
    }

    public void setMonitor(EvaluationMonitor monitor) {
    	if(monitor == null) {
    		throw new IllegalArgumentException("Non-null monitor required"); //$NON-NLS-1$
    	}

		this.myMonitor = monitor;
	}
    
    public EvaluationMonitor getMonitor() {    
    	return myMonitor;
    }
    
    public void setLog(Log log) {
    	if(log == null) {
    		throw new IllegalArgumentException("Non-null logger required"); //$NON-NLS-1$
    	}
		this.myLog = log;
	}
    
    public Log getLog() {    	
    	return myLog;
    }
            
    public ISessionData getSessionData() {    
    	return myData;
    }
    
    public Map<String, Object> getConfigProperties() {    
    	return Collections.unmodifiableMap(myConfiguration);
    }
    
    public Object getConfigProperty(String name) {
    	if(name == null) {
    		throw new IllegalArgumentException("null config property name"); //$NON-NLS-1$
    	}
    	return myConfiguration.get(name);
    }
    
    public void setConfigProperty(String name, Object value) {    
    	if(name == null) {
    		throw new IllegalArgumentException("null config property name"); //$NON-NLS-1$
    	}
    	myConfiguration.put(name, value);
    }
    
            
    private static class DefaultMonitor implements EvaluationMonitor {
    	
		private boolean myIsCancelled;

		public void cancel() {
			myIsCancelled = true;
		}

		public boolean isCanceled() {
			return myIsCancelled;
		}
	}
    
    private static class SessionDataImpl implements ISessionData {
    	
    	private HashMap<Object, Object> fData;
    		
    	SessionDataImpl() {
    		fData = new HashMap<Object, Object>();
    	}
    	
    	SessionDataImpl(SessionDataImpl sessionData) {
    		fData = new HashMap<Object, Object>(sessionData.fData);
    	}
    	
        @SuppressWarnings("unchecked")
    	public <T> T getValue(Entry<T> entry) {
        	if(fData.containsKey(entry)) {
        		return (T) fData.get(entry);
        	}
        	return entry.defaultValue();
        }
        
        public <T> void setValue(Entry<T> key, T value) {
        	fData.put(key, value);
        }
    }    
}