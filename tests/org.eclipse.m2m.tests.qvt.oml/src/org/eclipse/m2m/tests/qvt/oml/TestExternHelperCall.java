/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFolder;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.BundleFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.BundleModuleRegistry;
import org.eclipse.m2m.internal.qvt.oml.compiler.IImportResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilationResult;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtAssertionFailed;
import org.eclipse.m2m.internal.qvt.oml.expressions.Helper;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.DeployedImportResolver;
import org.eclipse.m2m.qvt.oml.runtime.util.HelperOperationCall;
import org.eclipse.m2m.qvt.oml.runtime.util.NonTransformationExecutionContext;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;
import org.osgi.framework.Bundle;


public class TestExternHelperCall extends TestCase {

	private static String fLibraryName = "FooLib";
	private NonTransformationExecutionContext fExecContext;
	private HelperOperationCall fCall;
	
	private String srcContainer = "parserTestData/externlib"; //$NON-NLS-1$

	public TestExternHelperCall(String name) {
		super(name);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		setupLibrary(fLibraryName);
	}

	protected void setupLibrary(String libraryName) throws MdaException {
		Resolver importResolver = new Resolver(TestUtil.BUNDLE, srcContainer);
		QvtCompiler compiler = new QvtCompiler(importResolver);		
		CFile file = importResolver.resolveImport(libraryName);
		
		QvtCompilationResult result = compiler.compile(file, new QvtCompilerOptions(), null);
		assertTrue("Library must no have compilation errors", result.getErrors().length == 0);
		
		Module module = result.getModule().getModule();
		Helper operation = findOperationByName(module, getName());
		assertNotNull("Library operation for the "+ getName() +"testcase not found", operation);

		HashSet<Module> importedModules = new HashSet<Module>();
		importedModules.add(module);
		QvtOperationalParserUtil.collectAllImports(module, importedModules);
		
		fExecContext = new NonTransformationExecutionContext(importedModules);
		fCall = fExecContext.createHelperCall(operation);
	}
	
	@Override
	protected void tearDown() throws Exception {
		fExecContext.dispose();
	}

	public void testEchoContextual() throws Exception {		
		Object callResult = fCall.invoke("self", new Object[] { "aStringArg", true });
		assertEquals("self" + "ASTRINGARG" + "_suffix", callResult);
		
		callResult = fCall.invoke("self", new Object[] { "aStringArg", false });
		assertEquals("self" + "aStringArg" + "_suffix", callResult);		
	}
	
	public void testEchoContextless() throws Exception {
		Object callResult = fCall.invoke(new Object[] { "aStringArg", true });		
		assertEquals("ASTRINGARG" + "_suffix", callResult);
		
		callResult = fCall.invoke(new Object[] { "aStringArg", false });
		assertEquals("aStringArg" + "_suffix", callResult);
		
	}	
	
	public void testHelperWithAssertFailed() throws Exception {
		try {
			Object callResult = fCall.invoke(null);		
			assertNotNull(callResult);
		} catch (InvocationTargetException e) {
			// OK, expected
			assertTrue(e.getCause() instanceof QvtAssertionFailed);
		} catch(Exception e1) {
			fail("InvocationTargetException expected");  
		}
	}
	
	
	public void testNoArgsHelper() throws Exception {
		final String expectedResult = "testNoArgsHelper";
		assertEquals(expectedResult, fCall.invoke(null));
		assertEquals(expectedResult, fCall.invoke(new Object[0]));
	}
	
	public void testHelperWithResolve() throws Exception {
		final String expectedResult = "testHelperWithResolve";
		assertEquals(expectedResult, fCall.invoke(EcoreFactory.eINSTANCE.createEClass(), new Object[0]));
		
		// test imported operation call
		Module mainModule = fCall.getLibrary();
		assertFalse("Need imported lib to test", mainModule.getModuleImport().isEmpty());
		Module imported = mainModule.getModuleImport().get(0).getImportedModule();
		assertNotNull(imported);
		HelperOperationCall call = fExecContext.createHelperCall(findOperationByName(imported, "testImportedFooLibImport"));
		assertEquals("EClass", call.invoke(EcoreFactory.eINSTANCE.createEClass(), new Object[0]));
	}
	
	public void testQueryNonContextual() throws Exception {
		assertNotNull("Call must refer to operation", fCall.getOperation());
		assertNotNull("Call must be imported from a library", fCall.getLibrary());
		assertSame(QvtOperationalParserUtil.getOwningModule(fCall.getOperation()), fCall.getLibrary());
		assertFalse(fCall.isContextual());
		assertNull("Non-contextual operation must not have context type", fCall.getContextType());		
	}
	
	public void testQueryContextual()  throws Exception {
		assertNotNull("Call must refer to operation", fCall.getOperation());
		assertNotNull("Call must be imported from a library", fCall.getLibrary());
		assertSame(QvtOperationalParserUtil.getOwningModule(fCall.getOperation()), fCall.getLibrary());
		assertTrue(fCall.isContextual());
		assertSame(EcorePackage.eINSTANCE.getEClass(), fCall.getContextType());		
	}
	
	private static Helper findOperationByName(Module module, String operationName) {		
		for (EOperation eOperation : module.getEOperations()) {
			if(operationName.equals(eOperation.getName()) && eOperation instanceof Helper) {
				return (Helper) eOperation;
			}
		}

		return null;
	}	
	
	private static class Resolver implements IImportResolver {

		private DeployedImportResolver fResolver;
		private IPath fBasePath;
				
		public Resolver(String bundleSymbolicName, String sourceContainerPath) {
			if(bundleSymbolicName == null || sourceContainerPath == null) {
				throw new IllegalArgumentException();
			}
			
			Bundle bundle =  Platform.getBundle(bundleSymbolicName);
			if(bundle == null) {
				throw new IllegalArgumentException("Not existinging bundle" + bundleSymbolicName); //$NON-NLS-1$
			}

			@SuppressWarnings("unchecked")
			Enumeration<java.net.URL> qvtFiles = bundle.findEntries(sourceContainerPath, "*" + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT, true); //$NON-NLS-1$
			
			List<IPath> pathList = new ArrayList<IPath>();
			while(qvtFiles.hasMoreElements()) {
				pathList.add(new Path(qvtFiles.nextElement().getPath()));
			}
			
			BundleModuleRegistry registry = new BundleModuleRegistry(bundleSymbolicName, pathList);
			fResolver = new DeployedImportResolver(Arrays.asList(registry)) {
				@Override
				public CFile resolveImport(String importedUnitName) {
					IPath fullPath = fBasePath.append(importedUnitName.replace('.', '/') + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT);
					for (BundleModuleRegistry nextRegistry : getBundleModules()) {
						if (nextRegistry.fileExists(fullPath)) {
							return new BundleFile(fullPath, nextRegistry);
						}
					}
					
					return null;
				}
			};
			fBasePath = new Path(sourceContainerPath).makeAbsolute();
		}
		
		public String getPackageName(CFolder folder) {
			return fResolver.getPackageName(folder);
		}

		public CFile resolveImport(String importedUnitName) {
			return fResolver.resolveImport(importedUnitName);
		}
		
		public CFile resolveImport(CFile parentFile, String importedUnitName) {		
			return fResolver.resolveImport(parentFile, importedUnitName);
		}
	}
}
