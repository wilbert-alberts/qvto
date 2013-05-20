/*******************************************************************************
 * Copyright (c) 2008, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.blackbox.java;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.internal.qvt.oml.NLS;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalStdLibrary;
import org.eclipse.m2m.internal.qvt.oml.expressions.Library;

abstract class JavaModuleLoader {
	
	private BasicDiagnostic fDiagnostics;
	private QvtOperationalModuleEnv fEnv;
	private OperationBuilder fOperBuilder;

	JavaModuleLoader() {
		fDiagnostics = null;
	}

	public QvtOperationalModuleEnv getLoadedModule() {
		return fEnv;
	}
	
	public Diagnostic getDiagnostics() {
		return (fDiagnostics != null) ? fDiagnostics : Diagnostic.OK_INSTANCE;
	}
	
	public Diagnostic loadModule(ModuleHandle moduleHandle) {
		fDiagnostics = DiagnosticUtil.createRootDiagnostic(NLS.bind(JavaBlackboxMessages.LoadModuleDiagnostics, moduleHandle));
		Class<?> javaClass;
		try {
			javaClass = moduleHandle.getModuleJavaClass();			
			if(!isModuleClassValid(javaClass)) {
				fDiagnostics.add(DiagnosticUtil.createErrorDiagnostic(NLS.bind(
					JavaBlackboxMessages.InvalidJavaClassForModule, 
					javaClass, moduleHandle)));
				// no sense to continue
				return fDiagnostics;
			}
		} catch (ClassNotFoundException e) {
			fDiagnostics.add(DiagnosticUtil.createErrorDiagnostic(NLS.bind(
				JavaBlackboxMessages.ModuleJavaClassNotFound, moduleHandle.getModuleName()), e));
			// no sense to continue
			return fDiagnostics;
		}
		
		Library module = QvtOperationalStdLibrary.createLibrary(moduleHandle.getModuleName());		
		fEnv = QvtOperationalEnvFactory.INSTANCE.createModuleEnvironment(module);
		loadModule(fEnv, javaClass);
		
		Java2QVTTypeResolver typeResolver = new Java2QVTTypeResolver(fEnv, 
				resolvePackages(moduleHandle.getUsedPackages(), fDiagnostics));
		
		fOperBuilder = new OperationBuilder(typeResolver);
		for (Method method : javaClass.getDeclaredMethods()) {
			if(!isLibraryOperation(method)) {
				continue;
			}
			
			EOperation operation = fOperBuilder.buildOperation(method);
			Diagnostic operationStatus = fOperBuilder.getDiagnostics();
			if(DiagnosticUtil.isSuccess(operationStatus)) {
				loadOperation(operation, method);
			}

			if(operationStatus.getSeverity() != Diagnostic.OK) {
				fDiagnostics.add(operationStatus);
			}
 		}

		return fDiagnostics;
	}
		
	protected abstract void loadModule(QvtOperationalModuleEnv moduleEnv, Class<?> javaModule);
	protected abstract void loadOperation(EOperation eOperation, Method javaOperation);
	
	private boolean isLibraryOperation(Method method) {
		return Modifier.isPublic(method.getModifiers());
	}
	
	private static boolean isModuleClassValid(Class<?> javaClass) {
		Class<?>[] noParams = new Class<?>[0];
		try {
			Constructor<?> constructor = javaClass.getDeclaredConstructor(noParams);
			if(!Modifier.isPublic(constructor.getModifiers())) {
				return false;
			}
		} catch (SecurityException e) {
			return false;
		} catch (NoSuchMethodException e) {
			return false;
		}
		
		return Modifier.isPublic(javaClass.getModifiers());
	}
	
	private static List<EPackage> resolvePackages(List<String> nsURIs, DiagnosticChain diagnosticChain) {
		EPackage.Registry registry = EPackage.Registry.INSTANCE;
		List<EPackage> ePackages = new ArrayList<EPackage>(nsURIs.size());
		for (String nextURI : nsURIs) {
			EPackage resolvedPackage = registry.getEPackage(nextURI);
			if(resolvedPackage != null) {
				ePackages.add(resolvedPackage);				
			} else {
				diagnosticChain.add(DiagnosticUtil.createErrorDiagnostic(
						NLS.bind(JavaBlackboxMessages.UnresolvedMetamodelURI, nextURI)));
			}
		}
		
		return ePackages;
	}
}
