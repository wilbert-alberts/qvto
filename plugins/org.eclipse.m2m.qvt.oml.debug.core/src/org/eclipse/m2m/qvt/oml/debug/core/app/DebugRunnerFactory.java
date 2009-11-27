package org.eclipse.m2m.qvt.oml.debug.core.app;

import java.util.List;

import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.TransformationRunner;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.debug.core.launch.TransformationRunnerFactory;

public class DebugRunnerFactory extends TransformationRunnerFactory {
	
	public DebugRunnerFactory() {
		super();
	}
	
	protected TransformationRunner createRunner(URI transformationURI, List<URI> modelParamURIs, ExecutionContextImpl context) {
		return new DebugTransformationRunner(transformationURI, context, modelParamURIs);
	}

	@Override
	public DebugTransformationRunner createRunner(ExecutionContextImpl context) throws DiagnosticException {
		return (DebugTransformationRunner) super.createRunner(context);
	}
}
