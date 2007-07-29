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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;


public class JavaProjectUtil {
    private JavaProjectUtil() {}

    public static IJavaProject convertToJavaProject(IProject project, String javaSource, IProgressMonitor progressMonitor) throws CoreException {
        addJavaNature(project, progressMonitor);
        return setupFolders(project, javaSource);
    }

    public static void addJavaNature(IProject project, IProgressMonitor progressMonitor) throws CoreException {
        if(progressMonitor == null) {
            progressMonitor = new NullProgressMonitor();
        }
        
        NatureUtils.addNature(project, JavaCore.NATURE_ID);
    }
    
    private static IJavaProject setupFolders(IProject project, String javaSource) throws CoreException {
        IJavaProject javaProject = JavaCore.create(project);

        IFolder binFolder = project.getFolder("bin"); //$NON-NLS-1$
        if(!binFolder.exists()) {
            binFolder.create(true, true, null);
        }
        
        IPath outputLocation = binFolder.getFullPath();
        javaProject.setOutputLocation(outputLocation, null);
        
        IFolder sourceFolder = project.getFolder(javaSource);
        if(!sourceFolder.exists()) {
            sourceFolder.create(false, true, null);
        }
        
        IPackageFragmentRoot sourceFragment = javaProject.getPackageFragmentRoot(sourceFolder);
        addToClasspath(javaProject, JavaCore.newSourceEntry(sourceFragment.getPath()));
        
        addToClasspath(javaProject, JavaRuntime.getDefaultJREContainerEntry());
        
        return javaProject;
    }
    
    public static void addToClasspath(IJavaProject javaProject, IClasspathEntry entry) throws JavaModelException {
        List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>(Arrays.asList(javaProject.getRawClasspath()));
        for(Iterator it = entries.iterator(); it.hasNext();) {
            IClasspathEntry classpathEntry = (IClasspathEntry) it.next();
            if(classpathEntry.getPath().isPrefixOf(entry.getPath())) {
                it.remove();
            }
        }
        
        entries.add(entry);
        
        IClasspathEntry[] newEntries = entries.toArray(new IClasspathEntry[entries.size()]);
        javaProject.setRawClasspath(newEntries, null);
    }
    
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
