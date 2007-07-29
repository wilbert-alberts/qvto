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
package org.eclipse.m2m.qvt.oml.common.cp;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.m2m.internal.qvt.oml.common.Messages;
import org.eclipse.m2m.qvt.oml.common.Logger;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.project.PluginUtil;
import org.eclipse.m2m.qvt.oml.common.util.CompositeClassLoader;
import org.eclipse.m2m.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.service.resolver.BundleSpecification;
import org.eclipse.osgi.service.resolver.State;
import org.eclipse.osgi.util.ManifestElement;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPlugin;
import org.eclipse.pde.core.plugin.IPluginImport;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;


public class ClasspathUtil {
	private ClasspathUtil() {}
	
    public static URL[] getProjectClasspath(IProject project) throws MdaException {
        return getHandler(project).getClasspath(project);
    }
    
    public static ClassLoader getProjectClassLoader(IProject project, ClassLoader parent) throws MdaException {
        return getHandler(project).getClassLoader(project, parent);
    }
    
    private static URL[] getJavaProjectClasspath(IJavaProject javaProject, final boolean resolved) throws MdaException {
        class Collector {
            public void collectClasspath(IJavaProject javaProject, Set<URL> urls) throws MdaException {
                try {
			        IClasspathEntry[] cp = resolved ? javaProject.getResolvedClasspath(true) : javaProject.getRawClasspath();
			        for(int i = 0; i < cp.length; i++) {
			            if(cp[i].getEntryKind() == IClasspathEntry.CPE_PROJECT) {
			                String depProjectName = cp[i].getPath().toString().substring(1);
			                IProject depProject = ResourcesPlugin.getWorkspace().getRoot().getProject(depProjectName);
                            if(depProject != null && depProject.hasNature(JavaCore.NATURE_ID)) {
                                IJavaProject depJavaProject = JavaCore.create(depProject);
                                collectClasspath(depJavaProject, urls);
                            }
			            } 
                        else if(cp[i].getEntryKind() == IClasspathEntry.CPE_LIBRARY) {
			                urls.add(cp[i].getPath().toFile().toURI().toURL());
			            }
                        else if(cp[i].getEntryKind() == IClasspathEntry.CPE_VARIABLE) {
                            urls.add(cp[i].getPath().toFile().toURI().toURL());
                        }
			        }
                    
                    urls.add(getOutputUrl(javaProject));
                }
                catch(MdaException e) {
                	throw e;
                }
                catch(Exception e) {
                	String message = Messages.ClasspathUtil_FailedToCollectClassPath;
                    Logger.getLogger().log(Logger.WARNING, message, e);
                    throw new MdaException(message, e);
                }
            }
        }
        
        Set<URL> urls = new LinkedHashSet<URL>();
        new Collector().collectClasspath(javaProject, urls);
        return urls.toArray(new URL[urls.size()]);
    }
    
    private static ClassLoader getPluginProjectClassLoader(IProject project) throws MdaException {
        URL[] urls = getJavaProjectClasspath(JavaCore.create(project), false);
        
        IPlugin plugin = PluginUtil.getPlugin(project);
        IPluginImport[] importedPlugins = plugin.getImports();
        
        List<ClassLoader> loaders = new ArrayList<ClassLoader>();
        for (int i = 0; i < importedPlugins.length; i++) {
            IPluginImport importedPlugin = importedPlugins[i];
            try {
                loaders.add(getPluginClassLoader(importedPlugin.getId(), null));
            }
            catch(Exception e) {
            }
        }
        
        ClassLoader[] loadersArray = loaders.toArray(new ClassLoader[loaders.size()]);
        return new URLClassLoader(urls, new CompositeClassLoader(loadersArray));
    }
    
    private static URL getOutputUrl(IJavaProject javaProject) throws MdaException {
        IPath output;
		try {
			output = javaProject.getOutputLocation();
		} 
		catch (JavaModelException e) {
            throw new MdaException(NLS.bind(Messages.ClasspathUtil_FailedToGetOutputURL, javaProject), e);
		}
		
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IResource outputPathFolder = root.findMember(output);
        if(outputPathFolder == null) {
        	throw new MdaException(NLS.bind(Messages.ClasspathUtil_InvalidJavaOutputPath,
        			javaProject.getProject().getName(), output));
        }
        
        try {
			return outputPathFolder.getLocation().toFile().toURI().toURL();
		} 
        catch (MalformedURLException e) {
            throw new MdaException(NLS.bind(Messages.ClasspathUtil_FailedToGetOutputURL, javaProject), e);
		}
    }
    
    public static ClassLoader getPluginClassLoader(String namespace, ClassLoader parent) throws MdaException {
        final Bundle bundle = Platform.getBundle(namespace);
        if(bundle == null) {
            throw new MdaException(NLS.bind(Messages.ClasspathUtil_NoBundle, namespace));
        }
        
        return new ClassLoader(parent) {
            @Override
			public Class<?> loadClass(String className) throws ClassNotFoundException {
                return bundle.loadClass(className);
            }
        };
    }
    
    // see CodeGen
    public static URL[] getPluginClasspath(String pluginID) {
        Bundle bundle = Platform.getBundle(pluginID);

        List<URL> result = new ArrayList<URL>();
        try {
            String requires = (String) bundle.getHeaders().get(Constants.BUNDLE_CLASSPATH);
            if (requires == null) {
                requires = "."; //$NON-NLS-1$
            }
            
            ManifestElement[] elements = ManifestElement.parseHeader(Constants.BUNDLE_CLASSPATH, requires);
            if (elements != null) {
                for (int i = 0; i < elements.length; ++i) {
                    ManifestElement element = elements[i];
                    String value = element.getValue();
                    if (".".equals(value)) { //$NON-NLS-1$
                        value = "/"; //$NON-NLS-1$
                    }
                    
                    try {
                        URL url = bundle.getEntry(value);
                        if (url != null) {
                            URL resolvedURL = FileLocator.resolve(url);
                            String resolvedURLString = resolvedURL.toString();
                            if (resolvedURLString.endsWith("!/")) { //$NON-NLS-1$
                                resolvedURLString = resolvedURL.getFile();
                                resolvedURLString = resolvedURLString.substring(0, resolvedURLString.length() - "!/".length()); //$NON-NLS-1$
                            }

                            if (resolvedURLString.startsWith("file:")) { //$NON-NLS-1$
                                result.add(new URL(resolvedURLString));
                            } 
                            else {
                                result.add(FileLocator.toFileURL(url));
                            }
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } catch (BundleException e) {
            throw new RuntimeException(e);
        }

        if(result.isEmpty()) {
            try {
                URL bundleUrl = bundle.getEntry("/"); //$NON-NLS-1$
                bundleUrl = FileLocator.toFileURL(bundleUrl);
                // TODO: all dirs currently added
                for(Enumeration it = bundle.getEntryPaths("/"); it.hasMoreElements(); ) { //$NON-NLS-1$
                    String entry = (String)it.nextElement();
                    File file = new File(bundleUrl.getFile(), entry);
                    if(file.isDirectory()) {
                        URL localUrl = file.toURI().toURL();
                        result.add(localUrl);
                    }
                }
            }
            catch(Exception e) {
            }
        }

        return result.toArray(new URL[result.size()]);
    }
    
    public static URL[] getFullPluginClasspath(String pluginName) {
        final Set<String> visited = new HashSet<String>();
        class Traverser {
            void getClasspath(String pluginName, LinkedHashSet<URL> cp) {
                List<URL> pluginCp = Arrays.asList(getPluginClasspath(pluginName));
                cp.addAll(pluginCp);
                
                visited.add(pluginName);
                
                String[] importedPlugins = getImportedPlugins(pluginName);
                for (int i = 0; i < importedPlugins.length; i++) {
                    String id = importedPlugins[i];
                    if(!visited.contains(id)) {
                        getClasspath(id, cp);
                    }
                }
            }
        }
        
        LinkedHashSet<URL> cp = new LinkedHashSet<URL>();
        new Traverser().getClasspath(pluginName, cp);
        return cp.toArray(new URL[cp.size()]); 
    }
    
    public static String[] getImportedPlugins(String pluginName){
        State state = Platform.getPlatformAdmin().getState(false);
        BundleDescription[] descriptions = state.getBundles(pluginName);
        if(descriptions == null || descriptions.length == 0) {
            return new String[0];
        }
        
        BundleDescription description = descriptions[0]; // TODO
        BundleSpecification[] requiredBundles = description.getRequiredBundles();
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < requiredBundles.length; i++) {
            result.add(requiredBundles[i].getName());
        }

        return result.toArray(new String[result.size()]);
    }
	
	public static IPath[] urlsToIPaths(URL[] urls) {
		List<Path> paths = new ArrayList<Path>();
		for(int i=0, len=urls.length; i < len; i++) {
			try {
				paths.add(new Path(new File(urls[i].getFile()).getCanonicalPath()));
			} 
			catch (IOException e) {
			}
		}

		return paths.toArray(new IPath[paths.size()]);
	}
    
    public static ClassLoader makeClassLoader(URL[] classpath, String[] metamodelIds, ClassLoader[] pluginLoaders) throws MdaException {
        Set<ClassLoader> mmLoaders = new LinkedHashSet<ClassLoader>();
        mmLoaders.add(EPackage.class.getClassLoader());
        mmLoaders.addAll(Arrays.asList(pluginLoaders));
        mmLoaders.addAll(Arrays.asList(getMetamodelClassLoaders(metamodelIds)));
        
        ClassLoader cl = new URLClassLoader(classpath, 
                new CompositeClassLoader(mmLoaders.toArray(new ClassLoader[mmLoaders.size()])));
        
        return cl;
    }
    
    public static ClassLoader[] getMetamodelClassLoaders(String[] metamodelIds) throws MdaException {
        Set<ClassLoader> classLoaders = new LinkedHashSet<ClassLoader>();
        classLoaders.add(EPackage.class.getClassLoader());
        for (int i = 0; i < metamodelIds.length; i++) {
            String meta = metamodelIds[i];
            EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(meta); // TODO: via IMetamodelDesc
            if(ePackage != null) {
                classLoaders.add(ePackage.getClass().getClassLoader());
            }
        }
        return classLoaders.toArray(new ClassLoader[classLoaders.size()]);
    }
    
    public static IContainer[] getSourceContainers(IJavaProject javaProject) throws JavaModelException {
        IClasspathEntry[] classpath = javaProject.getRawClasspath();
        List<IContainer> containers = new ArrayList<IContainer>();
        for (int i = 0; i < classpath.length; i++) {
            IClasspathEntry entry = classpath[i];
            if(entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
                IContainer sourceContainer = WorkspaceUtils.getWorkspaceContainer(entry.getPath().toString());
                if(sourceContainer != null) {
                    containers.add(sourceContainer);
                }
            }
        }
        
        return containers.toArray(new IContainer[containers.size()]);
    }
    
    public static boolean isJavaSourceContainer(IJavaProject javaProject, IContainer container) throws JavaModelException {
        IContainer[] containers = getSourceContainers(javaProject);
        for (int i = 0; i < containers.length; i++) {
            IContainer sourceContainer = containers[i];
            if(container.equals(sourceContainer)) {
                return true;
            }
        }
        
        return false;
    }
    
    static interface IProjectHandler {
        String getNature();
        URL[] getClasspath(IProject project) throws MdaException;
        ClassLoader getClassLoader(IProject project, ClassLoader parent) throws MdaException;
    }
    
    static class JavaProjectHandler implements IProjectHandler {
        public String getNature() {
            return JavaCore.NATURE_ID;
        }
        
        public URL[] getClasspath(IProject project) throws MdaException {
            IJavaProject javaProject = JavaCore.create(project);
            return getJavaProjectClasspath(javaProject, true);
        }

        public ClassLoader getClassLoader(IProject project, ClassLoader parent) throws MdaException {
            return new URLClassLoader(getClasspath(project), parent);
        }
    }
    
    static class PluginProjectHandler implements IProjectHandler {
        public String getNature() {
            return "org.eclipse.pde.PluginNature"; //$NON-NLS-1$
        }        
        
        public URL[] getClasspath(IProject project) throws MdaException {
            IPlugin plugin = PluginUtil.getPlugin(project);
            return getFullPluginClasspath(plugin.getId());
        }

        public ClassLoader getClassLoader(IProject project, ClassLoader parent) throws MdaException {
            return getPluginProjectClassLoader(project);
        }
    }
    
    private static IProjectHandler getHandler(IProject project) throws MdaException {
        try {
            for(int i = 0; i < ourProjectHandlers.length; i++) {
                IProjectHandler handler = ourProjectHandlers[i];
                if(project.hasNature(handler.getNature())) {
                    return handler;
                }
            }
        }
        catch(CoreException e) {
            throw new MdaException(e.getMessage(), e);
        }
        
        throw new RuntimeException("Unknown project: " + project); //$NON-NLS-1$
    }
    
    private static final IProjectHandler[] ourProjectHandlers = new IProjectHandler[] {
        new PluginProjectHandler(),
        new JavaProjectHandler(),
    };
}
