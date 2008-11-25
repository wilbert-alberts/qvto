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
package org.eclipse.m2m.internal.qvt.oml.library;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceFactory;
import org.eclipse.m2m.qvt.oml.util.Log;

public class Context implements IContext {
    private final Trace myTrace;
    private final IConfiguration  myConfiguration;
    private final Map<String, Object> myData;

    private Log myLog;

    public Context() {
        this(new QvtConfiguration(Collections.<String, String>emptyMap()));
    }
    
    public Context(IConfiguration configuration) {
        this(new HashMap<String, Object>(), TraceFactory.eINSTANCE.createTrace(), configuration);
    }
    
    private Context(Map<String, Object> data, Trace trace, IConfiguration configuration) {
        myData = data;
    	myTrace = trace;    	
    	myConfiguration = configuration;
    	myLog = Log.NULL_LOG;    	
    }
    
    public void setLog(Log log) {
		this.myLog = log != null ? log : Log.NULL_LOG;
	}
    
    public Log getLog() {    	
    	return myLog;
    }
            
    public Trace getTrace() {
        return myTrace;
    }

    public IConfiguration getConfiguration() {
        return myConfiguration;
    }

    public Object get(String name) {
        return myData.get(name);
    }

    public void put(String name, Object value) {
        myData.put(name, value);
    }
    
    public Map<String, Object> getProperties() {
    	return Collections.unmodifiableMap(myData);
    }
}