package org.eclipse.m2m.qvt.oml.compiler;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.qvt.oml.QvtEngine;
import org.eclipse.m2m.qvt.oml.common.MdaException;
import org.eclipse.m2m.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.qvt.oml.emf.util.WorkspaceUtils;

public class QvtCompilerFacade {
	private QvtCompilerFacade() {
	}

	/**
	 * Compile transf. script without completion data generation
	 * 
	 * @param uriTransf URI of the transf. file
	 * @return
	 * @throws MdaException
	 */
	public static CompiledModule getCompiledModule(URI uriTransf) throws MdaException {
		QvtCompilerOptions compilerOptions = new QvtCompilerOptions();
		compilerOptions.setGenerateCompletionData(false);
		return getCompiledModule(uriTransf, compilerOptions, null);
	}
	
	public static CompiledModule getCompiledModule(URI uriTransf, QvtCompilerOptions compilerOptions, IProgressMonitor monitor) throws MdaException {
        if (monitor == null) {
            monitor = new NullProgressMonitor();
        }
        monitor.beginTask(CompilerMessages.QvtCompilerFacade_compilingScript, 4);

        try {
			monitor.subTask(CompilerMessages.QvtCompilerFacade_acquiringScript);
			
			String uriPath = uriTransf.isFile() ? uriTransf.toFileString() :
				(uriTransf.isPlatform() ? uriTransf.toPlatformString(true) :
						uriTransf.toString());
			IFile file = WorkspaceUtils.getWorkspaceFile(uriPath);
			
			monitor.worked(1);

			return QvtEngine.getInstance(file).compile(new EclipseFile(file), compilerOptions,
					new SubProgressMonitor(monitor, 2)).getModule();
        }
        finally {
            monitor.done();
        }
	}
}
