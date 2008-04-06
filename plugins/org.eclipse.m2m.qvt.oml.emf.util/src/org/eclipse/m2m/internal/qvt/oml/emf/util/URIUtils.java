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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

public class URIUtils {
	private URIUtils() {
	}

	public static IFile getFile(URI uri){
	    String scheme = uri.scheme();
	    
	    if("platform".equals(scheme) && uri.segmentCount() > 1 &&  //$NON-NLS-1$
	        "resource".equals(uri.segment(0))) { //$NON-NLS-1$
	        StringBuffer platformResourcePath = new StringBuffer();
	        for (int j = 1, size = uri.segmentCount(); j < size; ++j) {
	            platformResourcePath.append('/');
	            platformResourcePath.append(uri.segment(j));
	        }
	        try {
	        return ResourcesPlugin.getWorkspace().getRoot().getFile(
	                new Path(platformResourcePath.toString()));
	        } catch (IllegalArgumentException e) {
	            return null;
	        }
	    }
	    else if("file".equals(scheme)) { //$NON-NLS-1$
	        return WorkspaceUtils.getIFile(uri.toFileString().toString());
	    }
	    else {
	        return null;
	    }
	}

	public static void refresh(URI uri) {
	    IFile file = URIUtils.getFile(uri);
	    if(file != null) {
	        try {
	            file.getParent().refreshLocal(IResource.DEPTH_ONE, null);
	        } 
	        catch (CoreException e) {
	        }
	    }
	}
	
		
}
