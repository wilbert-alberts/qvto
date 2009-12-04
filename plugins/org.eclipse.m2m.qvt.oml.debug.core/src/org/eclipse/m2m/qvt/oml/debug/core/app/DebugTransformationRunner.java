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
package org.eclipse.m2m.qvt.oml.debug.core.app;

import java.io.PrintWriter;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.internal.qvt.oml.TransformationRunner;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.qvt.oml.ExecutionContext;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ExecutionStackTraceElement;
import org.eclipse.m2m.qvt.oml.debug.core.vm.DebugEnvironmentFactory;
import org.eclipse.m2m.qvt.oml.debug.core.vm.DebuggableExecutorAdapter;
import org.eclipse.m2m.qvt.oml.debug.core.vm.IQVTODebuggerShell;

public class DebugTransformationRunner extends TransformationRunner {

	private IQVTODebuggerShell fDebugShell;
	private PrintWriter fErrorLog;
	
	public DebugTransformationRunner(URI transformationURI, 
			EPackage.Registry packageRegistry, 
			List<URI> modelParamURIs) {
		super(transformationURI, packageRegistry, modelParamURIs);
	}
	
	public void setErrorLog(PrintWriter fErrorLog) {
		this.fErrorLog = fErrorLog;
	}
	
	@Override
	protected QvtOperationalEnvFactory getEnvFactory() {
		if(fDebugShell != null) {
			return new DebugEnvironmentFactory(fDebugShell);
		}
		return super.getEnvFactory();
	}
	
	@Override
	protected void handleLoadExtents(Diagnostic diagnostic) {
		if(fErrorLog != null) {
			fErrorLog.println("loaded models...");
			fErrorLog.flush();
		}
	}
	
	@Override
	protected void handleLoadTransformation(Diagnostic diagnostic) {
		if(fErrorLog != null) {
			fErrorLog.println("loaded transformation ...");
			fErrorLog.flush();
		}
	}
	
	protected void handleExecution(org.eclipse.m2m.qvt.oml.ExecutionDiagnostic execDiagnostic) {
		if(fErrorLog != null) {
			List<ExecutionStackTraceElement> stackTrace = execDiagnostic.getStackTrace();
			if(stackTrace != null && execDiagnostic.getCode() != ExecutionDiagnostic.USER_INTERRUPTED) {
				fErrorLog.println(execDiagnostic);
				
				fErrorLog.println("[QVTO Stack trace:]");				
				execDiagnostic.printStackTrace(fErrorLog);
				fErrorLog.println();				
			}
			
			if(execDiagnostic.getException() != null) {
				fErrorLog.println("[Java cause:]");
				execDiagnostic.getException().printStackTrace(fErrorLog);
			}
			
			fErrorLog.flush();
		}
	}	
	
	@Override
	protected void handleSaveExtents(Diagnostic diagnostic) {
		
	}

	public DebuggableExecutorAdapter createDebugableAdapter(final ExecutionContext context) {
		return new DebuggableExecutorAdapter() {
			public Diagnostic execute() throws IllegalStateException {
				if(fDebugShell == null) {
					throw new IllegalStateException("Executor not connected to debugger"); //$NON-NLS-1$
				}
				return DebugTransformationRunner.this.execute(context);
			}

			public CompiledUnit getUnit() {
				return getExecutor().getUnit();
			}
			
			public void connect(IQVTODebuggerShell debugShell) {
				fDebugShell = debugShell;			
			}			
		};
	}
}
