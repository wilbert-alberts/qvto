/*******************************************************************************
 * Copyright (c) 2009 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.qvt.oml.ExecutionContext;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;

public class TransformationRunner  {

	protected static class Executor extends InternalTransformationExecutor {
		
		Trace fTraces;
		
		public Executor(URI uri, Registry registry) {
			super(uri, registry);
		}

		public Executor(URI uri) {
			super(uri);
		}

		@Override
		protected void handleExecutionTraces(Trace traces) {				
			super.handleExecutionTraces(traces);
			fTraces = traces;
		};
	}
		
	private final Executor fExecutor;
	private final ExecutionContext fExeContext;
	private final List<URI> fModelParamURIs;
	private URI fTraceFileURI;
	private URI fTransformationURI;
	
	private BasicDiagnostic fDiagnostic;
	private List<ModelExtent> fModelParams;		
	private ModelExtentHelper fExtentHelper;
	
	
	public TransformationRunner(URI transformationURI, 
			ExecutionContext context,
			List<URI> modelParamURIs) {
		
		if (transformationURI == null || context == null
				|| modelParamURIs == null || modelParamURIs.contains(null)) {
			throw new IllegalArgumentException();
		}

		this.fExeContext = context;
		this.fExecutor = new Executor(transformationURI);
		
		this.fTransformationURI = transformationURI;
		this.fModelParamURIs = modelParamURIs;
	}
	
	protected InternalTransformationExecutor getExecutor() {
		return fExecutor;
	};
	
	public URI getTransformationURI() {
		return fTransformationURI;
	}
	
	public void setTraceFile(URI traceFileURI) {
		fTraceFileURI = traceFileURI;
	}
	
	public URI getTraceFileURI() {
		return fTraceFileURI;
	}

	public Diagnostic initialize() {
		if(fDiagnostic != null) {
			return fDiagnostic;
		}
		
		fDiagnostic = QvtPlugin.createDiagnostic("Transformation runner initiliaze");
		
		Diagnostic loadDiagnostic = fExecutor.loadTransformation();
		if(!QvtPlugin.isSuccess(loadDiagnostic)) {
			fDiagnostic.add(loadDiagnostic);
		}

		handleLoadTransformation(loadDiagnostic);
		
		OperationalTransformation transformation = fExecutor.getTransformation();
		if(transformation == null) {
			return fDiagnostic;
		}
		
		fExtentHelper = new ModelExtentHelper(transformation, fModelParamURIs);
		Diagnostic extentsDiagnostic = Diagnostic.OK_INSTANCE; 
		try {
			fModelParams = fExtentHelper.loadExtents();
		} catch (DiagnosticException e) {
			extentsDiagnostic = e.getDiagnostic();
		}
		
		handleLoadExtents(extentsDiagnostic);
		if(!QvtPlugin.isSuccess(extentsDiagnostic)) {
			fDiagnostic.add(extentsDiagnostic);
		}
		
		// FIXME - 
		// add validation for configuration properties and param count
		// into the internal executor

		// TODO - collect WARN, INFO diagnostics?
		return fDiagnostic;
	}
	
	protected QvtOperationalEnvFactory getEnvFactory() {
		return new QvtOperationalEnvFactory(); 
	}
	
	protected void handleLoadTransformation(Diagnostic diagnostic) {
		// do nothing
	}	
			
	protected void handleLoadExtents(Diagnostic diagnostic) {
		// do nothing
	}	

	protected void handleExecution(ExecutionDiagnostic execDiagnostic) {
		// do nothing
	}
	
	protected void handleSaveExtents(Diagnostic diagnostic) {
		// do nothing
	}		


	public Diagnostic execute() {
		Diagnostic diagnostic = initialize();
		
		if(!isSuccess(diagnostic)) {
			return diagnostic;
		}

		fExecutor.setEnvironmentFactory(getEnvFactory());
		try {			
			ModelExtent[] params = fModelParams.toArray(new ModelExtent[fModelParams.size()]);
			
			ExecutionDiagnostic execDiagnostic = fExecutor.execute(fExeContext, params);
			handleExecution(execDiagnostic);
			
			Trace traces = fExecutor.fTraces;
			fExecutor.fTraces = null;

			if(!isSuccess(execDiagnostic)) {
				// skip saving any output
				return execDiagnostic;
			}

			// can continue and save output
			Diagnostic saveExtentsDiagnostic = fExtentHelper.saveExtents();
			handleSaveExtents(saveExtentsDiagnostic);
			
			if(!isSuccess(saveExtentsDiagnostic)) {
				return saveExtentsDiagnostic;
			}

			Diagnostic saveTracesDiagnostic = saveTraces(traces);
			if(!isSuccess(saveTracesDiagnostic)) {
				return saveTracesDiagnostic;
			}

			return execDiagnostic;
		} finally {
			fExecutor.setEnvironmentFactory(null);
		}			
	}
	
	private Diagnostic saveTraces(Trace trace) { 
		if(fTraceFileURI != null) {
			Resource resource = new ResourceSetImpl().createResource(fTraceFileURI);
			resource.getContents().add(trace);
			try {
		        Map<String, String> options = new HashMap<String, String>();
		        options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
				resource.save(options);
			} catch (IOException e) {
				String message = NLS.bind("Failed to save trace model uri={0}", fTraceFileURI);
				return new BasicDiagnostic(Diagnostic.ERROR, QvtPlugin.ID, 0,
						message, new Object[] { e });
			}
		}
		
		return Diagnostic.OK_INSTANCE;
	}
	
	/**
	 * Successfully finished execution, no errors and user interruption 
	 */
	private static boolean isSuccess(Diagnostic diagnostic) {
		int severity = diagnostic.getSeverity();
		return severity != Diagnostic.ERROR && severity != Diagnostic.CANCEL;
	}		
}