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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IPath;

public class BundleModuleRegistry {
	private Set<IPath> filePaths;
	private Set<IPath> folderPaths;
	private Set<IPath> defaultFolderItems;	
	private String bundleID;
	
	public BundleModuleRegistry(String bundleSymbolicName, Collection<IPath> paths) {
		if(bundleSymbolicName == null || bundleSymbolicName.length() == 0) {
			throw new IllegalArgumentException("Invalid bundle symbolic name"); //$NON-NLS-1$
		}
		
		for (IPath nextPath : paths) {
			if(nextPath == null || nextPath.isEmpty() || !nextPath.isValidPath(nextPath.toString())) {
				throw new IllegalArgumentException("Invalid resource path:" + nextPath); //$NON-NLS-1$
			}
		}
		
		this.bundleID = bundleSymbolicName;
		this.defaultFolderItems = Collections.emptySet();
		this.filePaths = new HashSet<IPath>();
		this.folderPaths = new HashSet<IPath>();
		
		for(IPath filePath : paths) {
			if(filePath.segmentCount() > 1) {
				extractFolderPaths(folderPaths, filePath);
				filePaths.add(filePath);
			} else {
				if(defaultFolderItems.isEmpty()) {
					defaultFolderItems = new HashSet<IPath>();
				}
				defaultFolderItems.add(filePath);
			}
		}
	}
	
	public String getBundleSymbolicName() {
		return bundleID;
	}
		
	/** 
	 * @return the root folderPaths of registered file. Can be empty 
	 * 	in case all file are in the default, non-existing folder.
	 *  (similarly as in Java)
	 */
	public List<IPath> getRootFolders() {			
		List<IPath> rootFolders = new ArrayList<IPath>();
		for (IPath path : folderPaths) {
			if(path.segmentCount() == 1) {
				rootFolders.add(path);
			}
		}
		return Collections.unmodifiableList(rootFolders);
	}
	
	public Collection<IPath> getRootFiles() {
		return defaultFolderItems;
	}
	
	public boolean fileExists(IPath filePath) {
		return defaultFolderItems.contains(filePath) || filePaths.contains(filePath);
	}
				
	public Collection<IPath> getChildFiles(IPath parentPath) {
		Collection<IPath> children = new ArrayList<IPath>();
		for (IPath file : filePaths) {
			if(parentPath.isPrefixOf(file)) {
				if(file.segmentCount() - 1 == parentPath.segmentCount()) {
					children.add(file);
				}
			}
		}
		return children;			
	}
	
	public Collection<IPath> getChildFolders(IPath parentPath) {
		Collection<IPath> children = new ArrayList<IPath>();
		for (IPath folderPath : folderPaths) {
			if(parentPath.isPrefixOf(folderPath)) {
				if(folderPath.segmentCount() + 1 == parentPath.segmentCount()) {
					children.add(folderPath);
				}
			}
		}		
		return children;
	}
	
	@Override
	public String toString() {	
		return getClass().getSimpleName() + " : ID = " + bundleID; //$NON-NLS-1$
	}

	private static void extractFolderPaths(Set<IPath> paths, IPath filePath) {
		if(filePath.segmentCount() == 1) {
			return;
		}
		IPath parent = filePath.removeLastSegments(1);
		paths.add(parent);
		extractFolderPaths(paths, parent);
	}	
}