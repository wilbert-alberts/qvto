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
package org.eclipse.m2m.qvt.oml.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.m2m.qvt.oml.trace.Trace;
import org.eclipse.m2m.qvt.oml.trace.TraceFactory;

public class Context implements IContext {
    private List<Runnable> myDeferredTasks;
    private final Trace myTrace;
    private final IConfiguration  myConfiguration;
    private final Map<String, Object> myData;
    private static ArrayList<IQvtLaunchConfigurationContextListener> ourListeners = new ArrayList<IQvtLaunchConfigurationContextListener>();
    private boolean myIsDebug = false;
    private EObjectEStructuralFeaturePair myLastAssignLvalue;

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
    	myDeferredTasks = null;
    }
    
    public synchronized static final void addListener(IQvtLaunchConfigurationContextListener listener) {
    	ourListeners.add(listener);
    }
    
    public synchronized static final boolean removeListener(IQvtLaunchConfigurationContextListener listener) {
    	return ourListeners.remove(listener);
    }
    
    public void fireLaunchStarted() {
    	for (IQvtLaunchConfigurationContextListener listener : ourListeners) {
			listener.handleConfigurationStarted(this);
		}
    }
    
    public void fireLaunchStopped() {
    	for (IQvtLaunchConfigurationContextListener listener : ourListeners) {
			listener.handleConfigurationStopped(this);
		}
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
    
    public void addDeferredTask(Runnable task) {
    	if (myDeferredTasks == null) {
    		myDeferredTasks = new ArrayList<Runnable>();
    	}
    	myDeferredTasks.add(task);
    }
    
    public void processDeferredTasks() {
    	if (myDeferredTasks != null) {
    	    for (Runnable task : myDeferredTasks) {
                task.run();
            }
    	}
    }
    
	public void launch() {
		fireLaunchStarted();
	}

	public void release() {
    	fireLaunchStopped();
	}

	public boolean isDebug() {
		return myIsDebug;
	}

	public void setDebug(boolean debug) {
		myIsDebug = debug;
	}

    public EObjectEStructuralFeaturePair getLastAssignmentLvalueEval() {
        return myLastAssignLvalue;
    }

    public void setLastAssignmentLvalueEval(EObjectEStructuralFeaturePair lvalue) {
        myLastAssignLvalue = lvalue;
    }
}