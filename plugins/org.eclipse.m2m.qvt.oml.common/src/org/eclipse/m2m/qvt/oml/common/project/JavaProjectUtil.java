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
package org.eclipse.m2m.qvt.oml.common.project;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;


public class JavaProjectUtil {
    private JavaProjectUtil() {}

    public static IPath getSourceFolderName(IJavaProject javaProject) throws JavaModelException {
        IClasspathEntry[] classpath = javaProject.getRawClasspath();
        for (int i = 0; i < classpath.length; i++) {
            IClasspathEntry entry = classpath[i];
            if(entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
                IPath path = entry.getPath().removeFirstSegments(1);
                return path;
            }
        }
        
        return null;
    }
    
    public static IPath getOutputFolderName(IJavaProject javaProject) throws JavaModelException {
        IPath path = javaProject.getOutputLocation().removeFirstSegments(1);
        return path;
    }
}
