/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation and others.
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

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.internal.qvt.oml.InternalTransformationExecutor;

/**
 * A utility class that enables to execute existing transformation in the
 * specified execution context.
 * 
 * @since 2.0
 */
public final class TransformationExecutor {

	private InternalTransformationExecutor fExector;
	
	/**
	 * Constructs the executor for the given transformation URI.
	 * <p>
	 * No attempt to resolve and load the transformation is done at this step
	 * 
	 * @param uri
	 *            the URI of an existing transformation
	 */
	public TransformationExecutor(URI uri) {
		fExector = new InternalTransformationExecutor(uri);
	}
	
	/**
	 * Constructs the executor for the given transformation URI.
	 * <p>
	 * No attempt to resolve and load the transformation is done at this step
	 * 
	 * @param uri
	 *            the URI of an existing transformation
	 * @param registry
	 *            a package registry of meta-models to be referenced by the
	 *            executed transformation
	 * @since 3.0
	 */
	public TransformationExecutor(URI uri, EPackage.Registry registry) {
		fExector = new InternalTransformationExecutor(uri, registry);
	}
			
	/**
	 * Attempts to load the transformation referred by this executor and checks
	 * if it is valid for execution.
	 * <p>
	 * <b>Remark:</b></br> Only the first performs the actual transformation
	 * loading, subsequent calls to this method will return the existing
	 * diagnostic.
	 * 
	 * @return the diagnostic indicating possible problems of the load action
	 */
	public Diagnostic loadTransformation() {
		return fExector.loadTransformation();
	}

	/**
	 * Executes the transformation referred by this executor using the given
	 * model parameters and execution context.
	 * 
	 * @param executionContext
	 *            the context object keeping the execution environment details
	 * @param modelParameters
	 *            the actual model arguments to the transformation
	 * 
	 * @return the diagnostic object indicating the execution result status,
	 *         also keeping the details of possible problems
	 * @throws IllegalArgumentException
	 *             if the context or any of the model parameters is
	 *             <code>null</code>
	 */
	public ExecutionDiagnostic execute(ExecutionContext executionContext,
			ModelExtent... modelParameters) {
		return fExector.execute(executionContext, modelParameters);
	}
}
