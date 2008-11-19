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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.io.FileUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MModelURIMapFactory;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MappingContainer;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MetamodelURIMappingHelper;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.URIMapping;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.m2m.internal.qvt.oml.library.QvtConfiguration;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.tests.qvt.oml.TestProject;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.TreeComparator;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.edit.TreeEdit;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.emf.EmfObjectComparatorTreeNode;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;

public abstract class ModelTestData {
    public ModelTestData(String name, IContext context) {
        myName = name;
        myContext = context;
    }
    
    public ModelTestData includeMetamodelFile(String relativePath) {
    	URI relativeURI = URI.createURI(relativePath);
    	ecoreFileMetamodels.add(relativeURI);
    	return this;
    }
    
    public String getName() {
        return myName;
    }
    
    public void compareWithExpected(List<EObject> out, List<EObject> expected) {
    	TestCase.assertEquals("transf output differs in size to expected result", //$NON-NLS-1$ 
    			out.size(), expected.size());
    	for(int i = 0; i < out.size(); i++) {
    		compareWithExpected(out.get(i), expected.get(i));
    	}
    }
    
    public void compareWithExpected(EObject out, EObject expected) {        
        TestCase.assertNotSame("Actual output and expected output must not be the same instances", out, expected); //$NON-NLS-1$
        TestCase.assertFalse("Actual output and expected output must be at distinct location", //$NON-NLS-1$ 
        		out.eResource().getURI().toString().equals(expected.eResource().getURI().toString())); 
        
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
    
    public void dispose() {
    	Trace trace = getContext().getTrace();
		trace.getTraceRecords().clear();
    	trace.getTraceRecordMap().clear();
    	trace.getSourceToTraceRecordMap().clear();
    	trace.getTargetToTraceRecordMap().clear();
    }
    
    abstract public List<URI> getIn(IProject project); 
    abstract public List<URI> getExpected(IProject project); 
    
    public void prepare(TestProject project) throws Exception {    	
    	Resource res = MetamodelURIMappingHelper.createMappingResource(project.getProject());
    	MappingContainer container = MetamodelURIMappingHelper.createNewMappings(res);
    	
    	for (URI ecoreFileURI : ecoreFileMetamodels) {        	        	
        	IPath ecoreFilePath = project.getProject().getFullPath().append("models").append(myName).append(ecoreFileURI.toString()); //$NON-NLS-1$
        	URI absoluteURI = URI.createPlatformResourceURI(ecoreFilePath.toString(), true);        	
        	
        	EPackage metamodelPackage = null;
        	Resource ecoreResource = null;
        	try {
        		ecoreResource = new ResourceSetImpl().getResource(absoluteURI, true);
        	} catch (WrappedException e) {
        		TestCase.fail("Failed to load metamodel EPackage. " + e.getMessage()); //$NON-NLS-1$
			}
        	
        	if(!ecoreResource.getContents().isEmpty()) {
        		EObject obj = ecoreResource.getContents().get(0);
        		if(obj instanceof EPackage) {
        			metamodelPackage = (EPackage) obj;
        		}
        	}
        	
        	if(metamodelPackage == null) {
        		TestCase.fail("No metamodel EPackage available in " + absoluteURI); //$NON-NLS-1$
        	}
        	
        	URIMapping mapping = MModelURIMapFactory.eINSTANCE.createURIMapping();        	
        	mapping.setTargetURI(absoluteURI.toString());
        	mapping.setSourceURI(metamodelPackage.getNsURI());
        	
        	container.getMapping().add(mapping);			
		}
    	
		res.save(Collections.emptyMap());
		project.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
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
    private final List<URI> ecoreFileMetamodels = new ArrayList<URI>();
    
    public static final String ENCODING = "UTF-8"; //$NON-NLS-1$
}
