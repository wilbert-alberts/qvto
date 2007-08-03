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
package org.eclipse.m2m.qvt.oml;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.qvt.oml.compiler.CompiledModule;
import org.eclipse.m2m.qvt.oml.compiler.IImportResolver;
import org.eclipse.m2m.qvt.oml.compiler.IImportResolverFactory;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompilationResult;
import org.eclipse.m2m.qvt.oml.compiler.QvtCompiler;


/**
 * @author pfeldman
 */
public class QvtEngine {
	public static QvtEngine getInstance(IResource resource) {
		IProject project = resource.getProject();
		QvtEngine engine = (QvtEngine) ourEnginesMap.get(project);
		if(engine == null) {
			engine = new QvtEngine(project);
			ourEnginesMap.put(project, engine);
		}
		return engine;
	}
	
	private QvtEngine(IProject project) {
		myProject = project;
		IImportResolverFactory resolverFactory = IImportResolverFactory.Registry.INSTANCE.getFactory(myProject);		
        myImportResolver = resolverFactory.createResolver(myProject);
		reset();
	}
	

    public QvtCompilationResult compile(final CFile source, final boolean generateCompletionData, 
            final IProgressMonitor monitor) throws MdaException {
		// TODO: remove this reset as soon as timestamps are finished
		reset();
		return myCompiler.compile(source, generateCompletionData, monitor);
	}
    
	public CompiledModule compile(IFile file, IProgressMonitor monitor) throws MdaException {
		return compile(new IFile[] { file }, monitor)[0];
	}
	
    public CompiledModule[] compile(IFile[] files, IProgressMonitor monitor) throws MdaException {
		EclipseFile[] sources = new EclipseFile[files.length];
		for (int i = 0; i < sources.length; i++) {
			sources[i] = new EclipseFile(files[i]);
		}
		// TODO: remove this reset as soon as timestamps are finished
		reset();
		return myCompiler.compile(sources, monitor);
	}
	
	public QvtCompiler getCompiler() {
		return myCompiler;
	}
    
    public IImportResolver getImportResolver() {
        return myImportResolver;
    }
	
	public void reset() { // TODO: QvtException
        myCompiler = new QvtCompiler(myImportResolver);
	}
	
	private static Map<IProject, QvtEngine> ourEnginesMap = new HashMap<IProject, QvtEngine>();
	private QvtCompiler myCompiler;
	private IProject myProject;
    private final IImportResolver myImportResolver;
}