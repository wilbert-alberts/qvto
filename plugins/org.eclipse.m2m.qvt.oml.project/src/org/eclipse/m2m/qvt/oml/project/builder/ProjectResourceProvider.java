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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.common.io.CFolder;
import org.eclipse.m2m.qvt.oml.common.project.IResourceProvider;
import org.eclipse.m2m.qvt.oml.project.MDAProjectPlugin;


public class ProjectResourceProvider implements IResourceProvider {
    public ProjectResourceProvider() {
    }
    
    public CFile getFile(String name, boolean checkExistance) throws MdaException {
        return BuilderUtil.getWorkspaceFile(name, checkExistance);
    }
    
    public CFolder getFolder(String name, boolean checkExistance) throws MdaException {
        return BuilderUtil.getWorkspaceFolder(name, checkExistance);
    }
    
    public EObject getRootObject(URI uri) throws MdaException {
        ResourceSet resourceSet = new ResourceSetImpl();
        Resource resource = resourceSet.getResource(uri, true);
        if(resource == null) {
            throw new MdaException(MDAProjectPlugin.getResourceString("ProjectResourceProvider.0", new Object[] {uri})); //$NON-NLS-1$
        }
        
        if(resource.getContents().isEmpty()) {
            throw new MdaException(MDAProjectPlugin.getResourceString("ProjectResourceProvider.1", new Object[] {uri})); //$NON-NLS-1$
        }
        
        EObject obj = (EObject) resource.getContents().get(0);        
        return obj;
    }
    
    //private final IProject myProject;
}
