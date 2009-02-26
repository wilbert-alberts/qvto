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
package org.eclipse.m2m.internal.qvt.oml.runtime.project;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.IImportResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.IImportResolverFactory;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.emf.util.WorkspaceUtils;

public class QvtCompilerFacade {
	
	public static interface CompilationResult {
		
		QVTOCompiler getCompiler();
		
		CompiledUnit getCompiledModule();
	}
	
	private QvtCompilerFacade() {
	}

	/**
	 * Compile transf. script without completion data generation
	 * 
	 * @param uriTransf URI of the transf. file
	 * @return
	 * @throws MdaException
	 */
	public static CompilationResult getCompiledModule(URI uriTransf) throws MdaException {
		QvtCompilerOptions compilerOptions = new QvtCompilerOptions();
		compilerOptions.setGenerateCompletionData(false);
		return getCompiledModule(uriTransf, compilerOptions, null);
	}
	
	public static CompilationResult getCompiledModule(URI uriTransf, QvtCompilerOptions compilerOptions, IProgressMonitor monitor) throws MdaException {
		// FIXME - why is that relied on being it an IFile?
		IFile ifile = WorkspaceUtils.getWorkspaceFile(uriTransf);
		return getCompiledModule(ifile, compilerOptions, monitor);
	}
	
	static CompilationResult getCompiledModule(IFile ifile, QvtCompilerOptions compilerOptions, IProgressMonitor monitor) throws MdaException {
        if (monitor == null) {
            monitor = new NullProgressMonitor();
        }

        try {
			IImportResolverFactory factory = IImportResolverFactory.Registry.INSTANCE.getFactory(ifile);
			IImportResolver importResolver = null;
			if(factory != null) {
				importResolver = factory.createResolver(ifile);				
			} else {
				throw new MdaException("No import resolver available for: " + ifile); //$NON-NLS-1$
			}
			

			//QvtEngine qvtEngine = QvtEngine.getInstance(ifile);
			final QVTOCompiler compiler = QVTOCompiler.createCompiler(importResolver);
			final CompiledUnit module = compiler.compile(new EclipseFile(ifile), compilerOptions, new SubProgressMonitor(monitor, 0));
			//final CompiledUnit module = qvtEngine.compileUnit(new EclipseFile(ifile), compilerOptions, new SubProgressMonitor(monitor, 2));
			//final QVTOCompiler compiler = qvtEngine.getQVTOCompiler();
			
			return new CompilationResult() {
				public CompiledUnit getCompiledModule() {
					return module;
				}
				public QVTOCompiler getCompiler() {
					return compiler;
				}				
			};
        }
        finally {
            monitor.done();
        }
	}
}
