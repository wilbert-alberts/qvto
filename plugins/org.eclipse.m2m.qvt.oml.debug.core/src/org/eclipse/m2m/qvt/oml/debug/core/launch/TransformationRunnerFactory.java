package org.eclipse.m2m.qvt.oml.debug.core.launch;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;
import org.eclipse.m2m.internal.qvt.oml.TransformationRunner;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.osgi.util.NLS;

public class TransformationRunnerFactory {

	public String transformationURI;
	
	public List<String> modelParamURI;

	public String traceFileURI;
	

	public TransformationRunner createRunner(ExecutionContextImpl context) throws DiagnosticException {
		BasicDiagnostic diagnostic = QvtPlugin.createDiagnostic("Transformation runner problems");
		
		URI uri = null;
		try {
			uri = toURI(this.transformationURI, "transformation");
		} catch(DiagnosticException e) {
			diagnostic.add(e.getDiagnostic());
		}

		List<URI> paramURIs = new ArrayList<URI>();
		if(this.modelParamURI != null && !this.modelParamURI.isEmpty()) {
			for (String paramURIStr : this.modelParamURI) {
				try {
					paramURIs.add(toURI(paramURIStr, "model parameter"));
				} catch(DiagnosticException e) {
					diagnostic.add(e.getDiagnostic());
				}
			}
		} else {
			diagnostic.add(QvtPlugin.createErrorDiagnostic("No model parameters passed to transformation", null));
		}

		if(diagnostic.getSeverity() == Diagnostic.ERROR) {
			throw new DiagnosticException(diagnostic);
		}
		
		assert uri != null && paramURIs != null && !paramURIs.isEmpty();

		TransformationRunner runner = createRunner(uri, paramURIs, context);
		
		URI traceURI;
		if(traceFileURI != null) {
			try {
				runner.setTraceFile(toURI(this.traceFileURI, "trace file"));
			} catch(DiagnosticException e) {
				diagnostic.add(e.getDiagnostic());
			}
		}

		return runner;
	}
	
	protected TransformationRunner createRunner(URI transformationURI, List<URI> modelParamURIs, ExecutionContextImpl context) {
		return new TransformationRunner(transformationURI, context, modelParamURIs);
	}
	
	private URI toURI(String uriStr, String uriType) throws DiagnosticException {
		IllegalArgumentException exc = null;
		if(uriStr != null) {
			try {
				return URI.createURI(uriStr);
			} catch(IllegalArgumentException e) {
				exc = e; 
			}
		}

		String message = NLS.bind("Invalid {0} URI : ''{1}''", uriType, uriStr);
		throw new DiagnosticException(QvtPlugin.createErrorDiagnostic(message, exc));
	}
}
