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
package org.eclipse.m2m.tests.qvt.oml;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.project.NatureUtils;
import org.osgi.framework.Bundle;

/**
 * @author Contributing to Eclipse
 */
public class TestProject {
	public IProject project;
    
    public static TestProject getExistingProject(String name) throws CoreException {
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        TestProject testProject;
        IProject project = root.getProject(name); 
        if(project.exists()) {
            testProject = new TestProject(name);
        }
        else {
            testProject = null;
        }
        
        return testProject;
    }

    public TestProject(final String prefix, String[] natures) throws CoreException {
        this(prefix + "Project-" + (++ourCounter), natures, 0); //$NON-NLS-1$
    }
    
    public TestProject(String name, String[] natures, int unused) throws CoreException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		//root.refreshLocal(IResource.DEPTH_INFINITE, null);
		project = root.getProject(name);
		if (project.exists()) {
			project.delete(true, true, null);
		}
		project.create(null);
		project.open(null);
		
        setNatures(natures);
	}
    
    private TestProject(String name) {
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        project = root.getProject(name);
    }
    
    public void deleteContents() throws CoreException {
        final Set<String> included = new HashSet<String>(Arrays.asList(new String[] {
                MDAConstants.QVTO_FILE_EXTENSION,
        }));  
        
        final List<IFile> files = new ArrayList<IFile>();
        project.accept(new IResourceVisitor() {
            public boolean visit(IResource resource) throws CoreException {
                if(resource instanceof IFile) {
                    String ext = resource.getFileExtension();
                    if(included.contains(ext)) {
                        files.add((IFile)resource);
                    }
                }
                return true;
            }});
        
        for (Iterator<IFile> it = files.iterator(); it.hasNext();) {
            IFile file = it.next();
            file.delete(false, false, null);
        }
        
        project.refreshLocal(IResource.DEPTH_INFINITE, null);
    }
    
	public IProject getProject() {
		return project;
	}
	
	public void delete() throws CoreException {
		project.delete(true, true, null);
	}
	
    private void setNatures(String[] natures) throws CoreException {
        try {
            IProjectDescription description = project.getDescription();
            project.setDescription(description, null);
            
            for (int i = 0; i < natures.length; i++) {
                String nature = natures[i];
                //if(TransformationNature.ID.equals(nature)) {
                  NatureUtils.addNature(project, nature);
                //}
            }
            
        } catch(CoreException e) {
            e.printStackTrace();
            throw e;
        }
    }	

	@SuppressWarnings("unchecked")
	public static Path findFileInPlugin(final String plugin, final String file) throws IOException {
		Bundle bundle = Platform.getBundle(plugin);
        if(bundle == null) {
            throw new IllegalArgumentException("Bundle not found: " + plugin); //$NON-NLS-1$
        }
        
        URL fileUrl = bundle.getEntry(file);
        if(fileUrl == null) {
            throw new IllegalArgumentException("No " + file + " in " + plugin + " roots=" + Collections.list(bundle.getEntryPaths("/"))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        }

		return new Path(FileLocator.toFileURL(fileUrl).getPath());
	}

	private static int ourCounter = 0;
	
}
