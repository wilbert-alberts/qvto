/*******************************************************************************
 * Copyright (c) 2007, 2010 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.transform.javaless;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.io.FileUtil;
import org.eclipse.m2m.tests.qvt.oml.TestProject;
import org.eclipse.m2m.tests.qvt.oml.transform.FileToFileData;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;

// 1 qvt and 2 ecores
public class JavalessFileToFileData extends ModelTestData {
	public JavalessFileToFileData(ModelTestData data) {
        super(data.getName(), data.getContext());
        if(!JavalessUtil.isValidJavalessData(data)) {
        	throw new IllegalArgumentException("Non-javaless data: " + data); //$NON-NLS-1$
        }
        
        myFileData = (FileToFileData) data;
        myPatchedData = null;
        
        ecoreFileMetamodels.add(URI.createURI(JavalessUtil.JAVALESS_METAMODEL));
    }
    
	@Override
	public void prepare(TestProject testProject) throws Exception {
		super.prepare(testProject);
		getExpected(testProject.getProject());
	}
	
    @Override
	public List<URI> getIn(IProject project) { 
        File destFolder = getDestFolder(project);
        return Collections.singletonList(URI.createFileURI(getFile(destFolder, getPatchedData(project).getFromFile()).getAbsolutePath()));
    }
    
    @Override
	public List<URI> getExpected(IProject project) {
        File destFolder = getDestFolder(project);
        return Collections.singletonList(URI.createFileURI(getFile(destFolder, getPatchedData(project).getExpectedFile()).getAbsolutePath())); 
    }
    
    @Override
	public File getTransformation(IProject project) {
    	File destFolder = getDestFolder(project);
        return getFile(destFolder, getPatchedData(project).getName() + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT); 
    }
    
    private FileToFileData getPatchedData(IProject project) {
    	if(myPatchedData == null) {
    		try {
				myPatchedData = createPatchedData(project);
				project.getFolder(new Path("models/" + myFileData.getName())).refreshLocal(IResource.DEPTH_INFINITE, null); //$NON-NLS-1$
			} 
    		catch (Exception e) {
				throw new RuntimeException(e);
			}
    	}
    	
    	return myPatchedData;
    }
    
    private FileToFileData createPatchedData(IProject project) throws IOException {
		File destFolder = getDestFolder(project);
		
		String patchedName = myFileData.getName() + "_javaless"; //$NON-NLS-1$
		{
			File[] allQvtSources = destFolder.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return name.endsWith(MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT);
				}
			});
			
			for (File origTransformationFile : allQvtSources) {
	    		//origTransformationFile = getFile(destFolder, myFileData.getName() + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT);
	    		String contents = FileUtil.getStreamContents(new FileInputStream(origTransformationFile), ENCODING);
	
	    		contents = JavalessUtil.changeTransformationName(contents, myFileData.getName(), patchedName);
	    		contents = JavalessUtil.patchContents(contents);
	    		
	    		String plainName = origTransformationFile.getName();
	    		plainName = plainName.substring(0, plainName.indexOf(MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT));
	    		String newQVTFileName =  plainName + "_javaless" + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT; //$NON-NLS-1$	    		
				createFile(destFolder, newQVTFileName, contents);
			}
		}
		
		String patchedFromFileName = myFileData.getFromFile() + ".javaless"; //$NON-NLS-1$
		{
			File fromEcore = getFile(destFolder, myFileData.getFromFile());
    		String contents = FileUtil.getStreamContents(new FileInputStream(fromEcore), ENCODING);
    		contents = JavalessUtil.patchContents(contents);
    		createFile(destFolder, patchedFromFileName, contents);
		}
		
		String patchedExpectedFileName = myFileData.getExpectedFile() + ".javaless"; //$NON-NLS-1$;
		{
			File expectedEcore = getFile(destFolder, myFileData.getExpectedFile());
    		String contents = FileUtil.getStreamContents(new FileInputStream(expectedEcore), ENCODING);
    		contents = JavalessUtil.patchContents(contents);
    		createFile(destFolder, patchedExpectedFileName, contents);
		}
		
		FileToFileData patchedData = new FileToFileData(patchedName, patchedFromFileName, patchedExpectedFileName, myFileData.getContext());
		return patchedData;
    }
    
    private final FileToFileData myFileData;
    private FileToFileData myPatchedData;
}
