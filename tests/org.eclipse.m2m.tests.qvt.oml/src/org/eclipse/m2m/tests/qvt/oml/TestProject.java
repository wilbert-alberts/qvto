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
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.m2m.internal.qvt.oml.common.nature.TransformationNature;
import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.common.project.NatureUtils;
import org.eclipse.m2m.qvt.oml.common.project.PluginUtil;
import org.eclipse.m2m.qvt.oml.common.project.PluginUtil.ModelHelper;
import org.eclipse.m2m.tests.qvt.oml.util.ConvertProjectUtil;
import org.eclipse.pde.core.plugin.IPlugin;
import org.eclipse.pde.core.plugin.IPluginImport;
import org.eclipse.pde.core.plugin.IPluginModel;
import org.eclipse.pde.core.plugin.IPluginModelFactory;
import org.osgi.framework.Bundle;

/**
 * @author Contributing to Eclipse
 */
public class TestProject {
	public IProject project;
	public IJavaProject javaProject;
	private IPackageFragmentRoot sourceFolder;
    
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
		root.refreshLocal(IResource.DEPTH_INFINITE, null);
		project = root.getProject(name);
		if (project.exists()) {
			project.delete(true, true, null);
		}
		project.create(null);
		project.open(null);

		javaProject = JavaCore.create(project);
		setNatures(natures);

		IFolder binFolder = createBinFolder();
		javaProject.setRawClasspath(new IClasspathEntry[0], null);
		sourceFolder = createSourceFolder();
		createOutputFolder(binFolder);
		addSystemLibraries();
	}
    
    private TestProject(String name) {
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        
        project = root.getProject(name);
        javaProject = JavaCore.create(project);
        
        IFolder folder = project.getFolder("src"); //$NON-NLS-1$
        sourceFolder = javaProject.getPackageFragmentRoot(folder);
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
    
    public void convertToPlugin() throws CoreException {
        ConvertProjectUtil.convertToPluginProject(project, new NullProgressMonitor());
    }
    
    public void addPluginImports(String[] imports) throws Exception {
    	ModelHelper<IPluginModel> model = PluginUtil.getModel(project);
        IPluginModelFactory factory = model.model().getPluginFactory();
        
        IPlugin plugin = model.model().getPlugin();
        for (int i = 0; i < imports.length; i++) {
            String impId = imports[i];

            IPluginImport imp = factory.createImport();
            imp.setId(impId);
            imp.setOptional(false);
            plugin.add(imp);
        }
        
        model.save();
        
        RuntimeWorkspaceSetup.getInstance().updateClassPath(getProject());        
    }

	public IProject getProject() {
		return project;
	}

	public IJavaProject getJavaProject() {
		return javaProject;
	}

	public void addJar(String plugin, String jar) throws JavaModelException, IOException {
		Path result = findFileInPlugin(plugin, jar);
		addToClasspath(JavaCore.newLibraryEntry(result, null,null));
	}
    
	public void addPluginToClasspath(String plugin) throws IOException, JavaModelException {
		addToClasspath(JavaCore.newContainerEntry(findFileInPlugin(plugin, "/"))); //$NON-NLS-1$
	}
	
	public void addWorkspaceProject(final IProject project) throws CoreException {
		project.open(null);
		IPackageFragmentRoot fragment = javaProject.getPackageFragmentRoot(project);
		addToClasspath(JavaCore.newSourceEntry(fragment.getPath()));
	}
	
	public IPackageFragment createPackage(String name) throws CoreException {
		if (sourceFolder == null)
			sourceFolder = createSourceFolder();
		return sourceFolder.createPackageFragment(name, false, null);
	}

	public IType createType(IPackageFragment pack, String cuName, String source)
			throws JavaModelException {
		StringBuffer buf = new StringBuffer();
		buf.append("package " + pack.getElementName() + ";\n"); //$NON-NLS-1$ //$NON-NLS-2$
		buf.append("\n"); //$NON-NLS-1$
		buf.append(source);
		ICompilationUnit cu = pack.createCompilationUnit(cuName,
				buf.toString(), false, null);
		return cu.getTypes()[0];
	}

	public void delete() throws CoreException {
//		waitForIndexer();
		project.delete(true, true, null);
	}

	private IFolder createBinFolder() throws CoreException {
		project.refreshLocal(IResource.DEPTH_INFINITE, null);
		IFolder binFolder = project.getFolder("bin"); //$NON-NLS-1$
		if (binFolder.exists()) {
			binFolder.delete(true, null);
		}
		binFolder.create(true, true, null);
		
		return binFolder;
	}

	private void setNatures(String[] natures) throws CoreException {
		try {
			IProjectDescription description = project.getDescription();
			description.setNatureIds(new String[] { JavaCore.NATURE_ID});
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

	private void createOutputFolder(IFolder binFolder)
			throws JavaModelException {
		IPath outputLocation = binFolder.getFullPath();
		javaProject.setOutputLocation(outputLocation, null);
	}

	private IPackageFragmentRoot createSourceFolder() throws CoreException {
		IFolder folder = project.getFolder("src"); //$NON-NLS-1$
		folder.create(false, true, null);
		TransformationNature nature = (TransformationNature)project.getNature(TransformationNature.ID);
        if(nature != null) {
            //nature.setSourceFolder(project,folder);
        }
		IPackageFragmentRoot root = javaProject.getPackageFragmentRoot(folder);

		addToClasspath(JavaCore.newSourceEntry(root.getPath()));
		return root;
	}

	private void addSystemLibraries() throws JavaModelException {
		addToClasspath(JavaRuntime.getDefaultJREContainerEntry());
	}
	
	private void addToClasspath(IClasspathEntry entry) throws JavaModelException {
		IClasspathEntry[] oldEntries = javaProject.getRawClasspath();
		IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
		System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
		newEntries[oldEntries.length] = entry;
		javaProject.setRawClasspath(newEntries, null);
	}

//	private Path findFileInPlugin(String plugin, String file)
//			throws MalformedURLException, IOException {
//		IPluginRegistry registry = Platform.getPluginRegistry();
//		IPluginDescriptor descriptor = registry.getPluginDescriptor(plugin);
//		URL pluginURL = descriptor.getInstallURL();
//		URL localPluginURL = Platform.asLocalURL(pluginURL);
//		URL localJarURL = new URL(localPluginURL, file);
//		return new Path(localJarURL.getPath());
//	}
	
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
