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

import java.util.Map;

import org.eclipse.m2m.qvt.oml.trace.Trace;


public interface IContext {
    Trace getTrace();
    IConfiguration getConfiguration();
    Object get(String name);
    void put(String name, Object value);
    void addDeferredTask(Runnable task);
    void processDeferredTasks();
    Map<String, Object> getProperties();
    void launch();
    void release();
    boolean isDebug();
    void setDebug(boolean debug);
    EObjectEStructuralFeaturePair getLastAssignmentLvalueEval();
    void setLastAssignmentLvalueEval(EObjectEStructuralFeaturePair lvalue);
}
