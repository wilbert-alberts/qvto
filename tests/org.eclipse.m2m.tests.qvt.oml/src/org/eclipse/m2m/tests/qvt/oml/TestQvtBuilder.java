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

import java.io.ByteArrayInputStream;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.m2m.internal.qvt.oml.common.nature.TransformationNature;
import org.eclipse.m2m.qvt.oml.builder.QvtBuilderConfig;
import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;


/**
 * @author vrepeshko
 */
public class TestQvtBuilder extends TestCase {
	
	@Override
	public void setUp() throws Exception {
        TestUtil.turnOffAutoBuilding();
        
		myProject = new TestProject("BuilderTest", new String[] {TransformationNature.ID}); //$NON-NLS-1$
        myProject.convertToPlugin();
        // set source folder explicitly to project, as the default is set to transformations folder
        QvtBuilderConfig.getConfig(myProject.getProject()).setSourceContainer(myProject.getProject());
        
		myProject.addPluginImports(new String[] {
                "org.eclipse.emf.ecore", //$NON-NLS-1$
                "org.eclipse.emf.common", //$NON-NLS-1$
                "org.eclipse.m2m.qvt.oml", //$NON-NLS-1$ 
                "org.eclipse.m2m.qvt.oml.samples", //$NON-NLS-1$
        });

		copyData();
	}
    
	@Override
	public void tearDown() throws Exception {
        myProject.delete();
	}
	
	
	public void testFullBuild() throws Exception {
        TestUtil.buildProject(myProject.project);
        IFile qvtFile = myProject.project.getFile("/Simpleuml_To_Rdb" + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT); //$NON-NLS-1$
        
        assertEquals("Expecting NO QVT compiler error markers", //$NON-NLS-1$,
        		0, qvtFile.findMarkers(QvtCompiler.PROBLEM_MARKER, true, IResource.DEPTH_INFINITE).length);
        qvtFile.setContents(new ByteArrayInputStream(new byte[0]), true, false, null);
        try {
            myProject.project.build(IncrementalProjectBuilder.FULL_BUILD, null);
        } catch (CoreException e) {
        	return; // It is ok that we are here since qvtFile contains nothing and the build fails
		}
        
        assertTrue("Expecting QVT compiler error markers", //$NON-NLS-1$
        		qvtFile.findMarkers(QvtCompiler.PROBLEM_MARKER, true, IResource.DEPTH_INFINITE).length > 0);        
    }
    
    public void testClean() throws Exception {
        TestUtil.buildProject(myProject.project);
        TestUtil.buildProject(myProject.project, IncrementalProjectBuilder.CLEAN_BUILD);
        assertFalse("Expected to delete org.eclipse.m2m.qvt.oml", myProject.project.getFolder("src/qvt/library").exists()); //$NON-NLS-1$ //$NON-NLS-2$
    }
    
	private void copyData() throws Exception {
		TestUtil.copyFolder(myProject.getProject(), "builderTestData"); //$NON-NLS-1$
	}

	private TestProject myProject;
}
