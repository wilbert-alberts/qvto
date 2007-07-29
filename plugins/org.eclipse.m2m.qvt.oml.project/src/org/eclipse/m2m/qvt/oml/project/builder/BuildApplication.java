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
package org.eclipse.m2m.qvt.oml.project.builder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IPlatformRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.m2m.qvt.oml.project.MDAProjectPlugin;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.testing.ITestHarness;
import org.eclipse.ui.testing.TestableObject;


public class BuildApplication implements IPlatformRunnable, ITestHarness {
    public Object run(final Object args) throws Exception {
        myArgs = (String[])args;

        IPlatformRunnable application = getApplication();
        myTestableObject = PlatformUI.getTestableObject();
        myTestableObject.setTestHarness(this);
        
        application.run(args);
        return new Integer(myExitCode);
    }

    private IPlatformRunnable getApplication() throws CoreException {
        IExtension extension =
            Platform.getExtensionRegistry().getExtension(
                Platform.PI_RUNTIME,
                Platform.PT_APPLICATIONS,
                WORKBENCH_APPLICATION);
        
        
        if(extension != null) {
            IConfigurationElement[] elements = extension.getConfigurationElements();
            if (elements.length > 0) {
                IConfigurationElement[] runs = elements[0].getChildren("run"); //$NON-NLS-1$
                if (runs.length > 0) {
                    Object runnable = runs[0].createExecutableExtension("class"); //$NON-NLS-1$
                    if (runnable instanceof IPlatformRunnable)
                        return (IPlatformRunnable) runnable;
                }
            }
        }

        throw new RuntimeException("No application: " + WORKBENCH_APPLICATION); //$NON-NLS-1$
    }
    
    public void runTests() {
        myTestableObject.testingStarting();
        try {
            myTestableObject.runTest(new Runnable() {
                public void run() {
                    try {
                        myExitCode = execute(myArgs);
                    } 
                    catch (CoreException e) {
                        e.printStackTrace();
                        myExitCode = ERROR;
                    }
                }
            });
        }
        finally {
            myTestableObject.testingFinished();
        }
    }
    
    private int execute(String[] commandLineArgs) throws CoreException {
        if(commandLineArgs.length == 0) {
            help();
            return ERROR;
        }

        ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
        ResourcesPlugin.getWorkspace().getRoot().deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
        
        for (int i = 0; i < commandLineArgs.length; i++) {
            String cmd = commandLineArgs[i];
            if(BUILD.equals(cmd)) {
                ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.FULL_BUILD, null);
                if(hasErrors()) {
                    return ERROR;
                }
            }
            else if(CLEAN.equals(cmd)) {
                ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.CLEAN_BUILD, null);
                if(hasErrors()) {
                    return ERROR;
                }
            }
            else {
                System.err.println(MDAProjectPlugin.getResourceString("BuildApplication.UnknownCommand", new Object[] {cmd})); //$NON-NLS-1$
                help();
                return ERROR;
            }
        }
        
        return OK;
    }
    
    private boolean hasErrors() throws CoreException {
        IMarker[] markers = ResourcesPlugin.getWorkspace().getRoot().findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
        List<IMarker> errors = new ArrayList<IMarker>();
        for (int i = 0; i < markers.length; i++) {
            IMarker marker = markers[i];
            Integer severity = (Integer)marker.getAttribute(IMarker.SEVERITY);
            if (severity != null && severity.intValue() >= IMarker.SEVERITY_ERROR) {
                errors.add(marker);
            } 
        }
        
        for (Iterator it = errors.iterator(); it.hasNext();) {
            IMarker errorMarker = (IMarker) it.next();
            String message = (String) errorMarker.getAttribute(IMarker.MESSAGE);
            
            String location;
            if(errorMarker.getResource() == null) {
                location = ""; //$NON-NLS-1$
            }
            else {
                location = errorMarker.getResource().getFullPath().toOSString();
                Object line = errorMarker.getAttribute(IMarker.LINE_NUMBER);
                if(line instanceof Integer) {
                    location += "(" + line + ")"; //$NON-NLS-1$ //$NON-NLS-2$
                }
                
                location += ": ";  //$NON-NLS-1$
            }

            System.err.println(location + message);
        }
        
        return !errors.isEmpty();
    }

    private void help() {
        System.out.println(MDAProjectPlugin.getResourceString("BuildApplication.Usage")); //$NON-NLS-1$
    }

    private TestableObject myTestableObject;
    private String[] myArgs;
    private int myExitCode = OK;

    private static final int OK = 0;
    private static final int ERROR = 127; 
    
    private static final String WORKBENCH_APPLICATION = "org.eclipse.ui.ide.workbench"; //$NON-NLS-1$
    
    private static final String BUILD = "build"; //$NON-NLS-1$
    private static final String CLEAN = "clean"; //$NON-NLS-1$
}
