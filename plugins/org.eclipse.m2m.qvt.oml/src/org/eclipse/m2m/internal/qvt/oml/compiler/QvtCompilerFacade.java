package org.eclipse.m2m.internal.qvt.oml.compiler;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.QvtEngine;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.qvt.oml.emf.util.WorkspaceUtils;

public class QvtCompilerFacade {
	public static interface CompilationResult {
		
		QvtCompiler getCompiler();
		
		CompiledModule getCompiledModule();
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
        if (monitor == null) {
            monitor = new NullProgressMonitor();
        }
        monitor.beginTask(CompilerMessages.QvtCompilerFacade_compilingScript, 4);

        try {
			monitor.subTask(CompilerMessages.QvtCompilerFacade_acquiringScript);
			
			IFile ifile = WorkspaceUtils.getWorkspaceFile(uriTransf);
			
			monitor.worked(1);

			QvtEngine qvtEngine = QvtEngine.getInstance(ifile);
			final CompiledModule module = qvtEngine.compile(new EclipseFile(ifile), compilerOptions,
					new SubProgressMonitor(monitor, 2)).getModule();
			final QvtCompiler compiler = qvtEngine.getCompiler();
			
			return new CompilationResult() {
				public CompiledModule getCompiledModule() {
					return module;
				}
				public QvtCompiler getCompiler() {
					return compiler;
				}				
			};
        }
        finally {
            monitor.done();
        }
	}
}
