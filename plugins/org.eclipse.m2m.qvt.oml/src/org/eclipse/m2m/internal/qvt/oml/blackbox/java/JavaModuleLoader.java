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
package org.eclipse.m2m.internal.qvt.oml.blackbox.java;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalStdLibrary;
import org.eclipse.m2m.internal.qvt.oml.expressions.Library;

abstract class JavaModuleLoader {
	
	private DiagnosticChain fStatus;
	private QvtOperationalModuleEnv fEnv;
	private OperationBuilder fOperBuilder;

	JavaModuleLoader() {
		fStatus = DiagnosticUtil.OK_INSTANCE;
	}
				
	public QvtOperationalModuleEnv getLoadedModule() {
		return fEnv;
	}
	
	public DiagnosticChain loadModule(ModuleHandle moduleHandle) throws ClassNotFoundException {
		Class<?> javaClass = moduleHandle.getModuleJavaClass();
		
		DiagnosticChain diagnostic = DiagnosticUtil.createRootDiagnostic(JavaBlackboxMessages.LoadingModuleDiagnostics);
		fStatus = diagnostic;
		
		Library module = QvtOperationalStdLibrary.createLibrary(javaClass.getSimpleName());		
		fEnv = QvtOperationalEnvFactory.INSTANCE.createModuleEnvironment(module);
		loadModule(fEnv, javaClass);
		
		Java2QVTTypeResolver typeResolver = new Java2QVTTypeResolver(fEnv, resolvePackages(moduleHandle.getUsedPackages()));
		fOperBuilder = new OperationBuilder(typeResolver);
		for (Method method : javaClass.getDeclaredMethods()) {
			if(!isLibraryOperation(method)) {
				continue;
			}
			
			EOperation operation = fOperBuilder.buildOperation(method);						
			loadOperation(operation, method);
		}
		
		return fStatus;
	}
		
	protected abstract void loadModule(QvtOperationalModuleEnv moduleEnv, Class<?> javaModule);
	protected abstract void loadOperation(EOperation eOperation, Method javaOperation);
	
	private boolean isLibraryOperation(Method method) {
		return Modifier.isPublic(method.getModifiers());
	}

	static List<EPackage> resolvePackages(List<String> nsURIs) {
		
		EPackage.Registry registry = EPackage.Registry.INSTANCE;
		List<EPackage> ePackages = new ArrayList<EPackage>(nsURIs.size());
		for (String nextURI : nsURIs) {
			EPackage resolvedPackage = registry.getEPackage(nextURI);
			if(resolvedPackage != null) {
				ePackages.add(resolvedPackage);				
			}
		}
		
		return ePackages;
	}	
}
