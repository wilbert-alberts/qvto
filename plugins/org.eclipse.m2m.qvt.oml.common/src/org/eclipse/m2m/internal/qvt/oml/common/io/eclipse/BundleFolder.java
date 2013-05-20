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
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFolder;
import org.eclipse.m2m.internal.qvt.oml.common.io.CResource;


public class BundleFolder extends AbstractBundleResource implements CFolder {
	
	public BundleFolder(IPath dirPath, BundleModuleRegistry resourceRegistry) {
		super(dirPath, resourceRegistry);
	}
	
	public CFolder getParent() {
		if(resourcePath.segmentCount() <= 1) {
			return null;
		}
		return new BundleFolder(resourcePath.removeLastSegments(1), resourceRegistry);
	}
	

	public CFile getFile(String name) {
		Collection<IPath> files = resourceRegistry.getChildFiles(resourcePath);
		for (IPath path : files) {
			if(name.equals(path.lastSegment())) {
				return new BundleFile(path, resourceRegistry);
			}
		}
		return null;
	}

	public CFolder getFolder(String name) {
		Collection<IPath> folders = resourceRegistry.getChildFolders(resourcePath);
		for (IPath path : folders) {
			if(name.equals(path.lastSegment())) {
				return new BundleFolder(path, resourceRegistry);
			}
		}
		return null;
	}

	public CResource[] members() throws IOException {
		Collection<IPath> files = resourceRegistry.getChildFiles(resourcePath); 
		Collection<IPath> folders = resourceRegistry.getChildFolders(resourcePath);		
		ArrayList<CResource> result = new ArrayList<CResource>(files.size() + folders.size());
		
		for (IPath path : files) {
			result.add(new BundleFile(path, resourceRegistry));
		}
		for (IPath path : folders) {
			result.add(new BundleFolder(path, resourceRegistry));
		}
		
		return null;
	}

	public boolean exists() {
		return true;
	}
	
	public String getDefaultCharset() throws IOException {		
		return ResourcesPlugin.getEncoding();
	}
}
