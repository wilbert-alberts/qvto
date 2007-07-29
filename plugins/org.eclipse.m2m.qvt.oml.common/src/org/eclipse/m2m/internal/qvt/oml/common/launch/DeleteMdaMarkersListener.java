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
package org.eclipse.m2m.internal.qvt.oml.common.launch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.m2m.qvt.oml.common.Logger;
import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.common.util.ProjectUtil;


public class DeleteMdaMarkersListener implements IResourceChangeListener {
    public DeleteMdaMarkersListener() {
    }
    
    public void resourceChanged(IResourceChangeEvent event) {
        if(event.getType() != IResourceChangeEvent.PRE_BUILD) {
            return;
        }
        
        IResourceDelta delta = event.getDelta();
        if(delta == null) {
            return;
        }
        
        final List<IProject> projects = new ArrayList<IProject>();
        try {
            delta.accept(new IResourceDeltaVisitor() {
                public boolean visit(IResourceDelta delta) throws CoreException {
                    if(delta.getResource() instanceof IWorkspaceRoot) {
                        return true;
                    }
                    else if(delta.getResource() instanceof IProject) {
                        projects.add((IProject)delta.getResource());
                        return false;
                    }
                    else {
                        return false;
                    }
                }
            });
        } 
        catch (CoreException e) {
            Logger.getLogger().log(Logger.SEVERE, "Failed to traverse " + delta); //$NON-NLS-1$
        }
        
        for(Iterator it = projects.iterator(); it.hasNext();) {
            IProject project = (IProject) it.next();
            if(project.isOpen()) {
                ProjectUtil.deleteMarkers(project, MDAConstants.QVTO_PROBLEM_MARKER);
            }
        }
    }
};

