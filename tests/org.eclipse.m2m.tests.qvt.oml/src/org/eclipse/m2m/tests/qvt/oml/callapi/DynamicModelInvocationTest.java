/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.callapi;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.TransformationExecutorExt;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;

/**
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=279251  
 * 
 * @author dvorak
 */
public class DynamicModelInvocationTest extends TestCase {

	private TransformationExecutorExt fExecutor;
	private BasicModelExtent fInput;	
	private BasicModelExtent fOutput;	
	private ExecutionContextImpl fContext;

	
	public DynamicModelInvocationTest(String name) {
		super(name);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		URI metamodelUri = URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/models/nonregistered.ecore", false);
		URI instanceUri = URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/models/DynClass.xmi", false);
		
		ResourceSet rs = new ResourceSetImpl();
		Resource ecoreFile = rs.getResource(metamodelUri, true);
		Resource instanceFile = rs.getResource(instanceUri, true);
		
		URI uri = URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/deployed/dynamicmodel/dynamic.qvto", false); //$NON-NLS-1$
		EPackage.Registry registry = new EPackageRegistryImpl();
		EPackage dynPackage = (EPackage)ecoreFile.getContents().get(0);
		registry.put(dynPackage.getNsURI(), dynPackage);
		assertNull(EPackage.Registry.INSTANCE.get(dynPackage.getNsURI()));
		
		fExecutor = new TransformationExecutorExt(uri, registry);

		fInput = new BasicModelExtent();
		EObject inObject = instanceFile.getContents().get(0);
		fInput.add(inObject);
		
		fOutput = new BasicModelExtent();		
		fContext = new ExecutionContextImpl();
		
		assertFalse(fInput.getContents().isEmpty());
		assertTrue(fOutput.getContents().isEmpty());		
	}
		
	public void testIntermPropCleanup() throws Exception {
		final ExecutionDiagnostic  diagnostic = fExecutor.execute(fContext, fInput);		
		assertEquals(Diagnostic.OK, diagnostic.getSeverity());
		assertEquals(0, diagnostic.getCode());		
		
		List<?> outContents = fOutput.getContents();
		assertTrue(outContents.isEmpty());		

		// test re-execution and all interm-property data cleanup
		BasicModelExtent nextOut = new BasicModelExtent();
		fContext = new ExecutionContextImpl();
		ExecutionDiagnostic nextDiagnostic = fExecutor.execute(fContext, fInput, nextOut);
		
		//assertEquals(Diagnostic.OK, nextDiagnostic.getSeverity());
	}	
}
