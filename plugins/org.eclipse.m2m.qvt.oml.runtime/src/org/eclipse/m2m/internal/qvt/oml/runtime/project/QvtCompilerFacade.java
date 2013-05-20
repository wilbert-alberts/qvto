/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
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
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompilerUtils;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolverFactory;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
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
			UnitResolverFactory factory = UnitResolverFactory.Registry.INSTANCE.getFactory(ifile);
			UnitProxy sourceUnit = null;
			
			if(factory != null) {
				URI resourceURI = URIUtils.getResourceURI(ifile);
				if(resourceURI != null) {
					sourceUnit = factory.findUnit(resourceURI);
				}
			}
			
			if(sourceUnit == null) {
				throw new MdaException("Failed to resolve compilation unit: " + ifile); //$NON-NLS-1$
			}			

			final QVTOCompiler compiler = CompilerUtils.createCompiler(sourceUnit.getResolver());
			final CompiledUnit module = compiler.compile(sourceUnit, compilerOptions, 
					new BasicMonitor.EclipseSubProgress(monitor, 0));
			
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
