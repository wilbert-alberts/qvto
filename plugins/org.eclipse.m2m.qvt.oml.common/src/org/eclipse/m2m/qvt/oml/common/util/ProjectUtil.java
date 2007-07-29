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
package org.eclipse.m2m.qvt.oml.common.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.m2m.qvt.oml.common.Logger;


public class ProjectUtil {
    private ProjectUtil() {}
    
    public static boolean isBuilt(IJavaProject project) throws CoreException {
        if(!project.hasBuildState()) {
            return false;
        }
        
        return isBuilt(project.getProject(), null);
    }

    /**
     * @param type - null to avoid filtering
     */
    public static boolean isBuilt(IProject project, String type) throws CoreException {
        for (IMarker marker : project.getProject().findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE)) {
            Integer severity = (Integer) marker.getAttribute(IMarker.SEVERITY);
            if (severity != null && severity.intValue() >= IMarker.SEVERITY_ERROR) {
                if (type == null || type.equals(marker.getType())) {
                    return false;
                }
            }
        }        
        return true;
    }
    
    public static void createMarker(IProject project, String type, String message) {
        if(project == null) {
            return;
        }
        
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put(IMarker.MESSAGE, message);
        attributes.put(IMarker.SEVERITY, new Integer(IMarker.SEVERITY_ERROR));
        try {
            IMarker marker = project.createMarker(type);
            marker.setAttributes(attributes);
        }
        catch (CoreException e) {
            Logger.getLogger().log(Logger.SEVERE, "Failed to create marker on " + project, e); //$NON-NLS-1$
        }
    }
    
    public static void deleteMarkers(IProject project, String type) {
        try {
            project.deleteMarkers(type, false, IResource.DEPTH_ONE);
        }
        catch (CoreException e) {
            Logger.getLogger().log(Logger.SEVERE, "Failed to delete markers on " + project, e); //$NON-NLS-1$
        }
    }
}
