/*******************************************************************************
 * Copyright (c) 2007, 2008 Borland Software Corporation and others.
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

import java.io.IOException;

import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.IPath;
import org.eclipse.m2m.internal.qvt.oml.common.io.CResource;


public abstract class AbstractBundleResource implements CResource {
	
	protected final IPath resourcePath;
	protected final BundleModuleRegistry resourceRegistry;	
	
	protected AbstractBundleResource(IPath path, BundleModuleRegistry bundleRegistry) {
		if(path == null || path.isEmpty() || !path.isValidPath(path.toString())) {
			throw new IllegalArgumentException("Invalid bundle resource path: " + path); //$NON-NLS-1$
		}
		
		this.resourcePath = path;
		this.resourceRegistry = bundleRegistry;
	}
	
	public String getBundleSymbolicName() {
		return resourceRegistry.getBundleSymbolicName();
	}
	
	protected IPath getPath() {
		return resourcePath;
	}	

	public String getExtension() {
		return resourcePath.getFileExtension();		
	}	

	public IFileStore getFileStore() throws IOException {
		throw new UnsupportedOperationException("IFileStore for bundle-file is not supported"); //$NON-NLS-1$		
	}

	public String getFullPath() {
		return resourcePath.toOSString(); 
	}

	public String getName() {
		String name = resourcePath.lastSegment();
		return name != null ? name : ""; //$NON-NLS-1$
	}

	public void refresh() throws IOException {
		// do nothing here as nothing can change
	}

	public void delete() throws IOException {
		throw new UnsupportedOperationException("Deleting bundle-resource is not supported"); //$NON-NLS-1$
	}	
	
	public void create() throws IOException {
		throw new UnsupportedOperationException("Creating bundle-resource is not supported"); //$NON-NLS-1$
	}
	
	@Override
	public String toString() {	
		return "platform:/plugin/" + resourceRegistry.getBundleSymbolicName() + "/" + resourcePath.toString(); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	@Override
	public boolean equals(Object another) {
		if(another instanceof AbstractBundleResource) {
			AbstractBundleResource res = (AbstractBundleResource)another;
			return resourcePath.equals(res.resourcePath) && 
					resourceRegistry.getBundleSymbolicName().equals(
							res.resourceRegistry.getBundleSymbolicName()); 
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 37 * result + resourcePath.hashCode(); 
		result = 37 * result + resourceRegistry.getBundleSymbolicName().hashCode();
		return  result;
	}	
}