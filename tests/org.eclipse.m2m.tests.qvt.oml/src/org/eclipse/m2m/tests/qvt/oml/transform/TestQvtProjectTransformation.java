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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner.Out;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.EclipseImportResolver;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.qvt.oml.QvtMessage;
import org.eclipse.m2m.qvt.oml.QvtPlugin;
import org.eclipse.m2m.qvt.oml.common.cp.ClasspathUtil;
import org.eclipse.m2m.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.qvt.oml.common.util.CompositeClassLoader;
import org.eclipse.m2m.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.qvt.oml.library.IContext;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;


public class TestQvtProjectTransformation extends TestTransformation {
    public TestQvtProjectTransformation(ModelTestData data) {
        super(data);
        setName("project_" + data.getName()); //$NON-NLS-1$
    }
    
    @Override
    public void setUp() throws Exception {
    	super.setUp();
//        getTestProject().deleteContents();
    }

    @Override
	public void runTest() throws Exception {
        checkTransformation(new TransformationChecker(new ProjectTransformer(getProject())));
    }
    
    private static class ProjectTransformer implements ITransformer {
    	public ProjectTransformer(IProject project) {
    		myProject = project;
    	}
    	
        public List<EObject> transform(IFile transformation, List<URI> inUris, IContext context) throws Exception {
            try {
                QvtCompiler compiler = new QvtCompiler(
                		new EclipseImportResolver(new IContainer[] {getProject()}));
                QvtCompilerOptions options = new QvtCompilerOptions();
                options.setGenerateCompletionData(false);
                CompiledModule rootModule = compiler.compile(new EclipseFile(transformation), options, null).getModule();
                List<QvtMessage> errors = new ArrayList<QvtMessage>();
                TransformationUtil.getErrors(rootModule, errors);
                assertEquals("QVT compilation failed: " + errors, 0, errors.size()); //$NON-NLS-1$
                
                TestUtil.buildProject(getProject());
                
            	List<EObject> inputs = new ArrayList<EObject>(inUris.size());
            	for (URI uri : inUris) {
            		EObject in = EmfUtil.loadModel(uri);
            		inputs.add(in);
            	}
                ClassLoader cl = new CompositeClassLoader(new ClassLoader[] {
                        EPackage.class.getClassLoader(),
                        QvtPlugin.class.getClassLoader(),
                        ClasspathUtil.getProjectClassLoader(getProject(), null),
                });
                
                String className = "";
                Out ret = new TransformationRunner(cl, className).transform(
                		new TransformationRunner.In(inputs.toArray(new EObject[inputs.size()]), context));

                List<EObject> transfResult = new ArrayList<EObject>();
                for (Resource out : ret.getExtents()) {
                	if (!out.getContents().isEmpty()) {
                		transfResult.add(out.getContents().get(0));
                	}
                    saveModel(out, new EclipseFile(transformation));
                }
                saveTraceData(ret.getTrace(), new EclipseFile(transformation));                    
                return transfResult;
            }
            finally {
                TestUtil.deleteJavaFiles(getProject());
            }
        }
        
        private IProject getProject() {
        	return myProject;
        }
        
        private final IProject myProject;
    }
}
