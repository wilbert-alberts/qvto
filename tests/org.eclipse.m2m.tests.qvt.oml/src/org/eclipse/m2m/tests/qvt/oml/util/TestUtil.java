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
package org.eclipse.m2m.tests.qvt.oml.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.FileUtil;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilationResult;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.tests.qvt.oml.RuntimeWorkspaceSetup;
import org.eclipse.m2m.tests.qvt.oml.TestProject;
import org.osgi.framework.Bundle;

/**
 * @author vrepeshko
 */
public class TestUtil extends Assert {
	
	public static final String BUNDLE = "org.eclipse.m2m.tests.qvt.oml"; //$NON-NLS-1$

	private TestUtil() {}

	static Set<CompiledModule> collectAllCompiledModules(CompiledModule compiledModule, Set<CompiledModule> result) {
		result.add(compiledModule);
		for (CompiledModule imported : compiledModule.getCompiledImports()) {
			collectAllCompiledModules(imported, result);
		}
		return result;
	}
	
	public static void assertPersistableAST(Module module, URI targetUri) {
		OutputStream os = null;
		try {
			os = new ExtensibleURIConverterImpl().createOutputStream(targetUri);
			module.eResource().save(os, Collections.emptyMap());
		} catch (Exception e) {
			TestCase.fail("Failed to serialize AST: " + e.getMessage()); //$NON-NLS-1$ 
		} finally {
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {					
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void assertAllPersistableAST(CompiledModule compiledModule) {
		Collection<CompiledModule> all = collectAllCompiledModules(compiledModule, new HashSet<CompiledModule>());
		
		HashMap<CompiledModule, Resource> resourceMap = new HashMap<CompiledModule, Resource>();
		for (CompiledModule nextModule : all) {
			resourceMap.put(nextModule, confineInResource(nextModule));
		}
		
		for (CompiledModule nextModule : all) {
			Resource res = resourceMap.get(nextModule);
			assertPersistableAST(nextModule, res);
		}
	}
	
	private static Resource confineInResource(CompiledModule module) {
		// FIXME -
		EclipseFile source = (EclipseFile)module.getSource();
		URI uri = URI.createURI(source.getFile().getLocationURI().toString()).appendFileExtension("xmi"); //$NON-NLS-1$
		Resource res = module.getModule().eResource();
		assertNotNull("A resource must be bound to AST Module: " + uri, res); //$NON-NLS-1$
		res.getContents().add(module.getModule());		
		res.setURI(uri);
		return res;
	}
	
	private static Resource assertPersistableAST(CompiledModule module, Resource res) {
		try {
			res.save(null);
		} catch (Exception e) {
			System.err.print(module.getSource().getFullPath());
			e.printStackTrace();							
			fail("Invalid module AST for serialization" + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		
		assertTrue(new ExtensibleURIConverterImpl().exists(res.getURI(), Collections.emptyMap()));
		
		return res;
	}
	
	public static Set<Module> compileModules(String srcContainer, String[] modulePaths)  {
		TestModuleResolver testResolver = TestModuleResolver.createdTestPluginResolver(srcContainer);
		
		QvtCompiler compiler = new QvtCompiler(TestModuleResolver.createdTestPluginResolver(srcContainer));				
		QvtCompilerOptions options = new QvtCompilerOptions();
		options.setGenerateCompletionData(true);
		
		
		CFile[] sourceFiles = new CFile[modulePaths.length];
		int pos = 0;
		for (String nextModulePath : modulePaths) {
			sourceFiles[pos] = testResolver.resolveImport(nextModulePath);
			pos++;
		}
		
		QvtCompilationResult[] result;
		Set<Module> modules;		
		try {
			result = compiler.compile(sourceFiles, options, null);
			modules = new LinkedHashSet<Module>();
			for (QvtCompilationResult nextResult : result) {
				assertEquals(nextResult.getModule().getSource().getFullPath()  
						+ " must not have compilation error", //$NON-NLS-1$ 
						0, nextResult.getErrors().length); //$NON-NLS-1$
				modules.add(nextResult.getModule().getModule());
			}
			
		} catch (MdaException e) {
			fail("Compilation errors: " + e.getMessage());
			return null; // never gets here			
		}

		return modules;
	}
		
	public static QvtCompiler createTestPluginQvtCompiler(String sourceContainerPath) {
		return new QvtCompiler(TestModuleResolver.createdTestPluginResolver(sourceContainerPath));
	}
	
	public static void turnOffAutoBuilding() throws CoreException {
		IWorkspaceDescription workspaceDescription = ResourcesPlugin.getWorkspace().getDescription();
        workspaceDescription.setAutoBuilding(false);
        ResourcesPlugin.getWorkspace().setDescription(workspaceDescription);
	}
	
	public static void copyFolder(final IProject project, final String folderName) throws Exception {
		File sourceFolder = getPluginRelativeFolder(folderName);
		File destFolder = new File(project.getLocation().toString());
		FileUtil.copyFolder(sourceFolder, destFolder);
//		System.out.println("source: " + sourceFolder.getAbsolutePath());
//		System.out.println("dest: " + destFolder.getAbsolutePath());
		project.refreshLocal(IResource.DEPTH_INFINITE, null);
	}
	
	public static File getPluginRelativeFolder(final String folderName) throws IOException {
        return getPluginRelativeFile(BUNDLE, folderName);
	}
	
	public static File getPluginRelativeFile(final String file) throws IOException {
        return getPluginRelativeFile(BUNDLE, file);
	}
    
    public static File getPluginRelativeFile(String plugin, String folderName) throws IOException {
        Bundle bundle = Platform.getBundle(plugin);
        
        URL url = bundle.getEntry(folderName);
        if(url == null) {
            throw new RuntimeException("File " + folderName + " not found in " + plugin); //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        File file = new File(FileLocator.toFileURL(url).getPath()).getCanonicalFile();
        return file;
    }
	
	public static void deleteJavaFiles(final IProject project) throws CoreException {
	    IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
	        public void run(IProgressMonitor monitor) throws CoreException {
                final List<IFile> filesToDelete = new ArrayList<IFile>();
                
	            project.accept(new IResourceVisitor() {
	                public boolean visit(final IResource resource) {
	                    if(resource.getType() == IResource.FILE) {
	                        String extension = resource.getFileExtension();
	                        if("java".equals(extension) || "class".equals(extension)) { //$NON-NLS-1$ //$NON-NLS-2$
	                            IFile file = (IFile) resource;
	                            filesToDelete.add(file);
	                        }
	                        return false;
	                    }
	                    return true;
	                }
	            });
                
                for (Iterator iter = filesToDelete.iterator(); iter.hasNext();) {
                    IFile file = (IFile) iter.next();
                    try {
                        file.delete(true, null);
                    }
                    catch(Exception e) {}
                }
	        }
	    };
	    
	    project.getWorkspace().run(runnable, null);
	}

	public static void buildProject(final IProject project) throws CoreException {
	    buildProject(project, IncrementalProjectBuilder.FULL_BUILD);
	}
    
    public static void buildProject(final IProject project, final int kind) throws CoreException {
		project.build(kind, null);
        List errors = getBuildErrors(project);
        assertTrue("Build failed for " + project + ": " + errors, errors.isEmpty()); //$NON-NLS-1$ //$NON-NLS-2$
    }
	
	public static List<String> getBuildErrors(final IProject project) throws CoreException {
		IMarker[] markers = project.findMarkers(
//				IJavaModelMarker.JAVA_MODEL_PROBLEM_MARKER, false,
                IMarker.PROBLEM, true,
				IResource.DEPTH_INFINITE);
		List<String> errors = new ArrayList<String>();
		for(int i = 0; i < markers.length; i++) {
			IMarker marker = markers[i];
			if(RuntimeWorkspaceSetup.getInstance().getIsDevLaunchMode() &&
				"plugin.xml".equals(marker.getResource().getName()) && //$NON-NLS-1$ 
				marker.getResource().getParent() == project) {
				continue;
			}
			if(marker.getAttribute(IMarker.SEVERITY, 0) == IMarker.SEVERITY_ERROR) {
				String message = marker.getResource().getName() + 
					" " + marker.getAttribute(IMarker.LINE_NUMBER, "") +  //$NON-NLS-1$ //$NON-NLS-2$
					": " + marker.getAttribute(IMarker.MESSAGE, "") + //$NON-NLS-1$ //$NON-NLS-2$
					" " + marker.getAttribute(IMarker.LOCATION, "");  //$NON-NLS-1$ //$NON-NLS-2$
				errors.add(message);
				System.err.println(message);
			}
		}
		
		return errors;
	}
	
	public static IProject openExistingProject(final String path) throws CoreException {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
//		IPath projectPath = new Path(path);
		IPath descriptionPath = new Path(path + File.separator + ".project"); //$NON-NLS-1$
		IProjectDescription projectDesc = workspace.loadProjectDescription(descriptionPath);
		String projectName = projectDesc == null ? null : projectDesc.getName();
		IProject project = workspace.getRoot().getProject(projectName);
		
		if (project.exists() && project.isOpen()) {
			return project;
		}
		
		if (projectDesc == null) {
			projectDesc = workspace.newProjectDescription(projectName);
			if (Platform.getLocation().isPrefixOf(descriptionPath)) {
				projectDesc.setLocation(null);
			} else {
				projectDesc.setLocation(descriptionPath);
			}
		}  else {
			projectDesc.setName(projectName);
		}
		
		try {
			project.create(projectDesc, null);
			project.open(null);
		} catch(CoreException e) {
			e.printStackTrace();
			throw e;
		}
		
		return project;
	}
    
    public static void addProject(TestProject testProject, String path) throws Exception {
        String location = TestUtil.getPluginRelativeFolder(path).getAbsolutePath();
        IProject project = TestUtil.openExistingProject(location);
        TestUtil.buildProject(project);
        testProject.addWorkspaceProject(project);
    }    
	
	public static void logQVTStackTrace(QvtRuntimeException e) {
		PrintWriter pw = new PrintWriter(System.err);
		pw.println("QVT stacktrace:"); //$NON-NLS-1$
		e.printQvtStackTrace(pw);
		pw.flush();
	}    
}
