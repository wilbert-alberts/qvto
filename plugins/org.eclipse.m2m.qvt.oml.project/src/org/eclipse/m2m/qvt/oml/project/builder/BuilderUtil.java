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
package org.eclipse.m2m.qvt.oml.project.builder;

import java.io.File;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.common.io.CFolder;
import org.eclipse.m2m.qvt.oml.common.io.CResource;
import org.eclipse.m2m.qvt.oml.common.io.IOFile;
import org.eclipse.m2m.qvt.oml.common.io.IOFolder;
import org.eclipse.m2m.qvt.oml.common.io.eclipse.EclipseContainer;
import org.eclipse.m2m.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.qvt.oml.project.MDAProjectPlugin;

import org.eclipse.m2m.qvt.oml.emf.util.WorkspaceUtils;

public class BuilderUtil {
    private BuilderUtil() {}
    
    public static CFile getFile(IProject project, String name, boolean checkExistance) throws MdaException {
        return (CFile)getResource(project, name, checkExistance, FILE_HELPER);
    }
    
    public static CFolder getFolder(IProject project, String name, boolean checkExistance) throws MdaException {
        return (CFolder)getResource(project, name, checkExistance, FOLDER_HELPER);
    }
    
    public static CFile getWorkspaceFile(String name, boolean checkExistance) throws MdaException {
        return (CFile)getWorkspaceResource(name, checkExistance, FILE_HELPER);
    }
    
    public static CFolder getWorkspaceFolder(String name, boolean checkExistance) throws MdaException {
        return (CFolder)getWorkspaceResource(name, checkExistance, FOLDER_HELPER);
    }
    
    private static interface IResourceHelper {
        IResource getProjectResource(IProject project, String name);
        IResource getWorkspaceResource(String name);
        CResource makeEclipseResource(IResource eclipseResource);
        CResource makeIOResource(File file);
    }
    
    private static CResource getResource(IProject project, String name, boolean checkExistance, IResourceHelper helper) throws MdaException {
        boolean isRelative = !new File(name).isAbsolute();
        if(isRelative) {
            IResource resource = helper.getProjectResource(project, name);
            if(resource != null && (!checkExistance || resource.exists())) {
                return helper.makeEclipseResource(resource);
            }
        }
        else {
            CResource resource = getWorkspaceResource(name, checkExistance, helper);
            if(resource != null) {
                return resource;
            }
        }

        throw new MdaException(MDAProjectPlugin.getResourceString("BuilderUtil.0", new Object[] {name, project})); //$NON-NLS-1$
    }

    private static CResource getWorkspaceResource(String name, boolean checkExistance, IResourceHelper helper) throws MdaException {
        IResource resource = helper.getWorkspaceResource(name);
        if(resource != null && (!checkExistance || resource.exists())) {
            return helper.makeEclipseResource(resource);
        }

        
        File file = new File(name);
        if(!checkExistance || file.exists()) {
            return helper.makeIOResource(file);
        }

        throw new MdaException(MDAProjectPlugin.getResourceString("BuilderUtil.2", new Object[] {name})); //$NON-NLS-1$
    }
    
    private static final IResourceHelper FILE_HELPER = new IResourceHelper() {
        public IResource getProjectResource(IProject project, String name) {
            return project.getFile(name);
        }
        public IResource getWorkspaceResource(String name) {
            return WorkspaceUtils.getIFile(name);
        }
        public CResource makeEclipseResource(IResource eclipseResource) {
            return new EclipseFile((IFile)eclipseResource);
        }
        public CResource makeIOResource(File file) {
            return new IOFile(file);
        }
    };

    private static final IResourceHelper FOLDER_HELPER = new IResourceHelper() {
        public IResource getProjectResource(IProject project, String name) {
            return project.getFolder(name);
        }
        public IResource getWorkspaceResource(String name) {
            return WorkspaceUtils.getIContainer(name);
        }
        public CResource makeEclipseResource(IResource eclipseResource) {
            return EclipseContainer.makeFolder((IContainer)eclipseResource);
        }
        public CResource makeIOResource(File file) {
            return new IOFolder(file);
        }
    };
}
