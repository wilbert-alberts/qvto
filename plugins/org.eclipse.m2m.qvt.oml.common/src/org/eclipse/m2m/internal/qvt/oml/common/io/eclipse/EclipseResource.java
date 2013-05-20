/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.common.io.eclipse;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFolder;
import org.eclipse.m2m.internal.qvt.oml.common.io.CResource;


public class EclipseResource implements CResource {
	public EclipseResource(IResource resource) {
		myResource = resource;
	}
	
	public IFileStore getFileStore() throws IOException {
		try {
			URI locationURI = myResource.getLocationURI();
			if(locationURI == null) {
				throw new IOException(myResource + " not found"); //$NON-NLS-1$
			}
			return EFS.getStore(locationURI);
		} catch (CoreException e) {
			IOException io = new IOException();
			io.initCause(e);
			throw io;
		}
	}
	
	public String getName() {
		return myResource.getName();
	}
    
    public String getExtension() {
        return myResource.getFileExtension();
    }
	
	public String getFullPath() {
        IPath location = myResource.getLocation();
        if(location != null) {
            return location.toOSString();
        }
        
        String fullName = getParent() == null ? getName() : getParent().getFullPath() + File.separator + getName();
        return fullName; 
	}
	
	public boolean exists() {
		return myResource.exists();
	}

	public CFolder getParent() {
		IContainer parent = myResource.getParent();
        if(parent == null) {
            return null;
        }
        
		return EclipseContainer.makeFolder(parent);
	}

	public void delete() throws IOException {
		try {
			myResource.delete(true, null);
		} 
		catch(CoreException e) {
			IOException io = new IOException();
			io.initCause(e);
			throw io;
		}
	}
	
    public void refresh() throws IOException {
        try {
            myResource.refreshLocal(IResource.DEPTH_INFINITE, null);
        } 
        catch (CoreException e) {
            IOException io = new IOException();
            io.initCause(e);
            throw io;
        }
    }
    
	@Override
	public boolean equals(Object other) {
		return other instanceof EclipseResource && 
			((EclipseResource)other).myResource.equals(myResource);
	}
	
	@Override
	public int hashCode() {
		return myResource.hashCode(); 
	}
	
	@Override
	public String toString() {
		return String.valueOf(myResource);
	}
	
	public IResource getResource() {
		return myResource;
	}
    
	protected final IResource  myResource;
}
