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
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.eclipse.m2m.internal.qvt.oml.QvtMessage;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.FileUtil;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.EclipseImportResolver;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.tests.qvt.oml.ParserTests.TestData;
import org.eclipse.m2m.tests.qvt.oml.util.ProblemSourceAnnotationHelper;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;

/**
 * @author pkobiakov
 */
public class TestQvtParser extends TestCase {
	
	public TestQvtParser(String testName) {
		this(ParserTests.getTestData(testName));
	}
	
	public TestQvtParser(TestData data) {
        super(data.getDir());
        myData = data;        
    }
	
	protected CompiledUnit[] getCompiledResults() {
		return myCompiled;
	}
	    
	@Override
	public void setUp() throws Exception {
		TestUtil.turnOffAutoBuilding();		
		
		String name = "ParserTest"; //$NON-NLS-1$
        myProject = TestProject.getExistingProject(name);
        if(myProject == null) {
            myProject = new TestProject(name, new String[] {}, 0); 
        }
	}
	
	@Override
	public void tearDown() throws Exception {
		myCompiled = null;
        File destinationFolder = getDestinationFolder();
        if (destinationFolder.exists()) {
            delete(destinationFolder);
        }		
	}
	    
    public static void delete(File file) {
        if(file.isDirectory()) {
            File[] children = file.listFiles();
            for(int i = 0; i < children.length; i++) {
                delete(children[i]);
            }
        }
        
        file.delete();
    }	
	
    public TestProject getTestProject() {
        return myProject;
    }
    
	@Override
	public void runTest() throws Exception {
		copyData("sources/" + myData.getDir(), "parserTestData/sources/" + myData.getDir()); //$NON-NLS-1$ //$NON-NLS-2$
		
        File folder = getDestinationFolder(); //$NON-NLS-1$
		assertTrue("Invalid folder " + folder, folder.exists() && folder.isDirectory()); //$NON-NLS-1$
		
		//System.err.println("testParsing: " + folder.getName()); //$NON-NLS-1$
		myCompiled = compile(folder);
		
		assertTrue("No results", myCompiled.length > 0); //$NON-NLS-1$
		List<QvtMessage> allErrors = getAllErrors(myCompiled);
		assertEquals("Wrong error count for '" + folder.getName() + "', error(s)=" + allErrors, myData.getErrCount(), allErrors.size()); //$NON-NLS-1$ //$NON-NLS-2$
		if (myData.getWarnings() != null) {
	        List<QvtMessage> allWarnings = getAllWarnings(myCompiled);
	        expectedWarningsCycle : for (String expectedWarning : myData.getWarnings()) {
	            for (QvtMessage qvtMessage : allWarnings) {
	                if (expectedWarning.equals(qvtMessage.getMessage())) {
	                    continue expectedWarningsCycle;
	                }
	            }
	            fail(MessageFormat.format("Expected warning {0} not found!", new Object[] {expectedWarning})); //$NON-NLS-1$
	        }
		}

		// check the AST is consistent
		for (CompiledUnit compilationResult : myCompiled) {
			if(compilationResult.getErrors().size() == 0) {
				TestUtil.assertAllPersistableAST(compilationResult);
			}
		}		
		//		
		
		if(myData.usesSourceAnnotations()) {
			Set<ProblemSourceAnnotationHelper> helpers = new HashSet<ProblemSourceAnnotationHelper>();	
			for (CompiledUnit compilationResult : myCompiled) {
				doCompiledUnitCheck(compilationResult, helpers);
			}
	
			int expectedProblemCount = myData.getAllProblemsCount();
			int foundProblemCount = 0;				
			for (ProblemSourceAnnotationHelper nextHelper : helpers) {
				foundProblemCount += nextHelper.getProblemsMap().size();
			}

			if (expectedProblemCount >= 0) {
				TestCase.assertEquals(expectedProblemCount, foundProblemCount);
			}			
		}
	}

	protected File getDestinationFolder() {
		return new File(myProject.getProject().getLocation().toString() + "/sources/" + myData.getDir());
	}
	
	private void doCompiledUnitCheck(CompiledUnit module, Set<ProblemSourceAnnotationHelper> annotationCollector) {
		ProblemSourceAnnotationHelper helper = ProblemSourceAnnotationHelper
				.assertCompilationProblemMatchExpectedAnnotations(module);
		annotationCollector.add(helper);
		for (CompiledUnit importedModule : module.getCompiledImports()) {
			if (!annotationCollector.contains(importedModule)) {
				doCompiledUnitCheck(importedModule, annotationCollector);
			}
		}
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
    
    private List<QvtMessage> getAllErrors(CompiledUnit[] compiled) {
        List<QvtMessage> errors = new ArrayList<QvtMessage>();
        for (CompiledUnit compilationResult : compiled) {
            TransformationUtil.getErrors(compilationResult, errors);
        }

        return errors;
    }
    
    private List<QvtMessage> getAllWarnings(CompiledUnit[] compiled) {
        List<QvtMessage> warnings = new ArrayList<QvtMessage>();
        for (CompiledUnit compilationResult : compiled) {
            TransformationUtil.getWarnings(compilationResult, warnings);
        }

        return warnings;
    }
    
	private CompiledUnit[] compile(File folder) throws Exception {
		final String topName = folder.getName() + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT;
		File topFile = getFile(folder, topName);
		QVTOCompiler compiler = new QVTOCompiler(
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
	private CompiledUnit[] myCompiled;
}
