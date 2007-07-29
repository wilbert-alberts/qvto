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
package org.eclipse.m2m.tests.qvt.oml.transform;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.AssertionFailedError;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.qvt.oml.library.Context;
import org.eclipse.m2m.qvt.oml.library.IContext;
import org.eclipse.m2m.qvt.oml.library.QvtConfiguration;
import org.eclipse.m2m.tests.qvt.oml.TestProject;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.TreeComparator;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.edit.TreeEdit;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.emf.EmfObjectComparatorTreeNode;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;


import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.common.io.FileUtil;

public abstract class ModelTestData {
    public ModelTestData(String name, IContext context) {
        myName = name;
        myContext = context;
    }
    
    public String getName() {
        return myName;
    }
    
    public void compareWithExpected(EObject out, IProject project) {
        EObject expected = EmfUtil.loadModel(getExpected(project));
        assertEquals(myName + ":", expected, out); //$NON-NLS-1$
    }
    
    public static void assertEquals(String message, EObject left, EObject right) {
        TreeEdit edit = compare(left, right);
        if(edit.getCost() != 0) {
            throw new AssertionFailedError(message + " expected " + left + ", got " + right + " \nedit=" + edit); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }
    }
    
    public static TreeEdit compare(EObject left, EObject right) {
        TreeEdit edit = new TreeComparator().compare(
                new EmfObjectComparatorTreeNode(null, left), 
                new EmfObjectComparatorTreeNode(null, right));
        //System.err.println("MiscUtils.compare(): edit=" + edit);
        return edit;
    }

    public File getTransformation(IProject project) { 
        File destFolder;
        try {
            destFolder = getDestFolder(myName, project);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        return getFile(destFolder, myName + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT); 
    }
    
    public IContext getContext() { 
        return myContext; 
    }
    
    abstract public List<URI> getIn(IProject project); 
    abstract public URI getExpected(IProject project); 
    
    public void prepare(TestProject project) throws Exception {
    }
    
    protected File getDestFolder(IProject project) {
        try {
            return getDestFolder(myName, project);
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static File getDestFolder(String name, IProject project) throws IOException {
        File srcRootFolder = TestUtil.getPluginRelativeFolder("parserTestData/models"); //$NON-NLS-1$
        File srcFolder = getFolder(srcRootFolder, name);
        File destFolder = getFolder(new File(project.getLocation().toString() + "/models/"), srcFolder.getName()); //$NON-NLS-1$
        return destFolder;
    }
    
    private static File getFolder(File folder, final String expectedName) {
        File dir = new File(folder, expectedName);
        if(!dir.exists() || !dir.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory: " + dir); //$NON-NLS-1$
        }
        
        return dir;
    }
    
    protected static File getFile(File folder, final String expectedName) {
        File file = new File(folder, expectedName);
        if(!file.exists() || !file.isFile()) {
            throw new IllegalArgumentException("No such file: " + file); //$NON-NLS-1$
        }
        
        return file;
    }
    
    protected static File createFile(File folder, String fname, String contents) throws IOException {
    	File file = new File(folder, fname);
    	FileUtil.setContents(file, new ByteArrayInputStream(contents.getBytes(ENCODING)));
        return file;
    }
    
    protected static IContext makeFileContext(String[][] props) {
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < props.length; i++) {
            map.put(props[i][0], props[i][1]);
        }
        IContext context = new Context(new QvtConfiguration(map));
        return context;
    }
    
    protected static IContext makeMyUmlContext(String destProjectName) {
        IContext context = new Context();
        final IProject toProject = ResourcesPlugin.getWorkspace().getRoot().getProject(destProjectName);
        if(toProject == null) {
            throw new IllegalArgumentException("Project not found: " + destProjectName); //$NON-NLS-1$
        }
        
        context.put("project", toProject); //$NON-NLS-1$
        return context;
    }
    
    
    private final String myName;
    private final IContext myContext;
    
    
    public static final String ENCODING = "UTF-8"; //$NON-NLS-1$
}
