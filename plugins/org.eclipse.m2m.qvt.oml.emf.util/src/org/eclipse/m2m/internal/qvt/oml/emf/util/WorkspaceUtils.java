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
package org.eclipse.m2m.internal.qvt.oml.emf.util;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

/** @author pkobiakov */
public class WorkspaceUtils {
	private WorkspaceUtils() {}
	
    public static IFile getIFile(String fileUnderWorkspace) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IPath location = new Path(fileUnderWorkspace);
		IFile ifile = workspace.getRoot().getFileForLocation(location);
		return ifile;
	}
    
    public static IFile getWorkspaceFile(String name) {
        try {
            IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(name));
            return file;
        }
        catch(Exception e) {
            return null;
        }
    }
    
    public static IFile getWorkspaceFile(URI uri) {
		String uriPath = uri.isFile() ? uri.toFileString() :
			(uri.isPlatform() ? uri.toPlatformString(true) :
					uri.toString());
		return getWorkspaceFile(uriPath);
    }
    
    public static IContainer getIContainer(String folderUnderWorkspace) {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IPath location = new Path(folderUnderWorkspace);
        IContainer cont = workspace.getRoot().getContainerForLocation(location);
        return cont;
    }
    
    public static IFolder getWorkspaceFolder(String name) {
        try {
            IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(name));
            return folder;
        }
        catch(Exception e) {
            return null;
        }
    }
    
    public static IProject getWorkspaceProject(String name) {
        try {
            IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(name);
            return project;
        }
        catch(Exception e) {
            return null;
        }
    }
    
    public static IContainer getWorkspaceContainer(String name) {
        IPath path = new Path(name);
        if(path.segmentCount() > 1) {
            return getWorkspaceFolder(name);
        }
        else {
            return getWorkspaceProject(name);
        }
    }
    
    public static String getPathString(IResource resource) {
        String path = resource.getFullPath().toString();
        if(path.startsWith("/")) { //$NON-NLS-1$
            path = path.substring(1);
        }
        
        return path;
    }
}
