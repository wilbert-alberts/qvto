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
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.m2m.internal.qvt.oml.common.io.CResource;


public class EclipseFileUtil {
	private EclipseFileUtil() {}

	public static CResource[] members(IResource[] resources) {
		List<CResource> members = new ArrayList<CResource>();
		for(int i = 0; i < resources.length; i++) {
			IResource resource = resources[i];
			members.add(makeEclipseResource(resource));
		}
		
		return members.toArray(new CResource[members.size()]);
	}

	private static CResource makeEclipseResource(IResource resource) {
		if(resource instanceof IFile) {
			return new EclipseFile((IFile)resource);
		}
		else if(resource instanceof IContainer) {
			return EclipseContainer.makeFolder((IContainer)resource);
		}
		else {
			throw new IllegalArgumentException("Unknown resource type: " + resource); //$NON-NLS-1$
		}
	}
    
    public static IPath makeRelative(IPath location, IPath base) {
        if (location.getDevice() != null && !location.getDevice().equalsIgnoreCase(base.getDevice())) {
                return location;
        }
        
        int baseCount = base.segmentCount();
        int count = base.matchingFirstSegments(location);
        String temp = ""; //$NON-NLS-1$
        for (int j = 0; j < baseCount - count; j++) {
                temp += "../"; //$NON-NLS-1$
        }
        
        return new Path(temp).append(location.removeFirstSegments(count));
    }
}
