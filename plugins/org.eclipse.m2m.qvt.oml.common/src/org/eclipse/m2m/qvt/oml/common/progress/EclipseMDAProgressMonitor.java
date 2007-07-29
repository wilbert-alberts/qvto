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
package org.eclipse.m2m.qvt.oml.common.progress;

import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author strizhkin
 */
public class EclipseMDAProgressMonitor implements IMDAProgressMonitor{
    public EclipseMDAProgressMonitor(IProgressMonitor progressMonitor){
        myProgressMonitor = progressMonitor;
    }
    
    public void beginTask(String name, int totalWork) {
        myProgressMonitor.beginTask(name,totalWork);
    }
    public void done() {
        myProgressMonitor.done();
    }
    public void subTask(String subtaskName) {
        myProgressMonitor.subTask(subtaskName);
    }
    public void worked(int steps) {
        myProgressMonitor.worked(steps);
    }
    
    private IProgressMonitor myProgressMonitor;
}
