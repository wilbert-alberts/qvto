/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.debug.core.launch;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;
import org.eclipse.m2m.internal.qvt.oml.TransformationRunner;
import org.eclipse.osgi.util.NLS;

public class TransformationRunnerFactory {

	public String transformationURI;
	
	public List<String> modelParamURI;

	public String traceFileURI;
	
	public EPackage.Registry packageRegistry;
	

	public TransformationRunner createRunner() throws DiagnosticException {
		BasicDiagnostic diagnostic = QvtPlugin.createDiagnostic("Transformation runner problems");
		
		URI uri = null;
		try {
			uri = toURI(this.transformationURI, "transformation");
		} catch(DiagnosticException e) {
			diagnostic.add(e.getDiagnostic());
		}

		List<URI> paramURIs = new ArrayList<URI>();
		if(this.modelParamURI != null) {
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
		
		EPackage.Registry registry = this.packageRegistry != null ? this.packageRegistry : EPackage.Registry.INSTANCE;
		TransformationRunner runner = createRunner(uri, registry, paramURIs);
		
		if(traceFileURI != null) {
			try {
				runner.setTraceFile(toURI(this.traceFileURI, "trace file"));
			} catch(DiagnosticException e) {
				diagnostic.add(e.getDiagnostic());
			}
		}

		return runner;
	}
	
	protected TransformationRunner createRunner(URI transformationURI, EPackage.Registry packageRegistry, List<URI> modelParamURIs) {
		return new TransformationRunner(transformationURI, packageRegistry, modelParamURIs);
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
