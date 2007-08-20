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

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.EclipseImportResolver;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.qvt.oml.QvtMessage;
import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.common.io.FileUtil;
import org.eclipse.m2m.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompilationResult;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.tests.qvt.oml.ParserTests.TestData;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;

/**
 * @author pkobiakov
 */
public class TestQvtParser extends TestCase {
	public TestQvtParser(TestData data) {
        super(data.getDir());
        myData = data;
        
    }
    
	@Override
	public void setUp() throws Exception {
		TestUtil.turnOffAutoBuilding();		
		
		String name = "ParserTest"; //$NON-NLS-1$
        myProject = TestProject.getExistingProject(name);
        if(myProject != null) {
            myProject.deleteContents();
        }
        else {
            myProject = new TestProject(name, new String[] {}, 0); 
            myProject.convertToPlugin();

            myProject.addPluginImports(new String[] {
                    "org.eclipse.emf.ecore", //$NON-NLS-1$
                    "org.eclipse.emf.common", //$NON-NLS-1$
                    "org.eclipse.core.runtime", //$NON-NLS-1$
                    "org.eclipse.core.resources", //$NON-NLS-1$
                    
                    "org.eclipse.m2m.qvt.oml", //$NON-NLS-1$
                    "org.eclipse.m2m.qvt.oml.samples", //$NON-NLS-1$
                    "org.eclipse.m2m.qvt.oml.ocl.emf.libraries", //$NON-NLS-1$
            });
        }
	}
	
	@Override
	public void tearDown() throws Exception {
	}
	
    public TestProject getTestProject() {
        return myProject;
    }
    
	@Override
	public void runTest() throws Exception {
		copyData("sources/" + myData.getDir(), "parserTestData/sources/" + myData.getDir()); //$NON-NLS-1$ //$NON-NLS-2$
		
        File folder = new File(myProject.getProject().getLocation().toString() + "/sources/" + myData.getDir()); //$NON-NLS-1$
		assertTrue("Invalid folder " + folder, folder.exists() && folder.isDirectory()); //$NON-NLS-1$
		
		//System.err.println("testParsing: " + folder.getName()); //$NON-NLS-1$
		QvtCompilationResult[] compiled = compile(folder);
		
		assertTrue("No results", compiled.length > 0); //$NON-NLS-1$
		List<QvtMessage> allErrors = getAllErrors(compiled);
		assertEquals("Wrong error count for '" + folder.getName() + "', error(s)=" + allErrors, myData.getErrCount(), allErrors.size()); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
    static class CompositeException extends Exception {
		private static final long serialVersionUID = -1045874581781288741L;

		public CompositeException(String message, List<Throwable> exceptions) {
            super(message);
            myExceptions = exceptions;
        }
        
        @Override
		public String toString() {
            StringBuffer s = new StringBuffer();
            s.append(super.toString());
            for(Throwable t : myExceptions) {
                StringWriter trace = new StringWriter();
                t.printStackTrace(new PrintWriter(trace));
                s.append("\n" + trace.toString()); //$NON-NLS-1$
            }
            
            return s.toString();
        }
        
        private final List<Throwable> myExceptions;
    }
    
	private List<QvtMessage> getAllErrors(QvtCompilationResult[] compiled) {
		List<QvtMessage> errors = new ArrayList<QvtMessage>();
		for (QvtCompilationResult compilationResult : compiled) {
			TransformationUtil.getErrors(compilationResult.getModule(), errors);
		}

		return errors;
	}
    
	private QvtCompilationResult[] compile(File folder) throws Exception {
		final String topName = folder.getName() + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT;
		File topFile = getFile(folder, topName);
		QvtCompiler compiler = new QvtCompiler(
				new EclipseImportResolver(new IContainer[] {getIFolder(folder)}));
		IFile topIFile = getIFile(topFile);
        QvtCompilerOptions options = new QvtCompilerOptions();
        options.setGenerateCompletionData(false);
		return compiler.compile(new CFile[] {new EclipseFile(topIFile)}, options, new NullProgressMonitor());
	}
	
	private static File getFile(File folder, final String expectedName) {
		File file = new File(folder, expectedName);
        assertTrue("Invalid file: " + file, file.exists() && file.isFile()); //$NON-NLS-1$
        return file;
	}
    
	private static IFile getIFile(File fileUnderWorkspace) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IPath location = new Path(fileUnderWorkspace.getAbsolutePath());
		IFile ifile = workspace.getRoot().getFileForLocation(location);
		if(ifile == null) {
			throw new RuntimeException("File not found: " + fileUnderWorkspace); //$NON-NLS-1$
		}
		
		return ifile;
	}
	
	private IFolder getIFolder(File folderUnderWorkspace) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IPath location = new Path(folderUnderWorkspace.getAbsolutePath());
		IContainer[] containers = workspace.getRoot().findContainersForLocation(location);
		if(containers == null || containers.length != 1 || containers[0] instanceof IFolder == false) {
			throw new RuntimeException("Folder not found: " + folderUnderWorkspace); //$NON-NLS-1$
		}
		
		return (IFolder)containers[0];
	}
	
	private void copyData(String destPath, String srcPath) throws Exception {
		File sourceFolder = TestUtil.getPluginRelativeFolder(srcPath);
		File destFolder = new File(myProject.getProject().getLocation().toString() + "/" + destPath); //$NON-NLS-1$
		destFolder.mkdirs();
		FileUtil.copyFolder(sourceFolder, destFolder);
		myProject.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
	}
    
    private final TestData myData;
	private TestProject myProject;
}
