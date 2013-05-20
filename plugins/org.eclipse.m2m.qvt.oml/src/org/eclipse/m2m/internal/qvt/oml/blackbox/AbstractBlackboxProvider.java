/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.blackbox;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstanceFactory;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandler;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandlerAdapter;

public abstract class AbstractBlackboxProvider {

	public interface InstanceAdapterFactory {
		Object createAdapter(EObject moduleInstance);
	}

	protected AbstractBlackboxProvider() {
		super();
	}

	protected String getProviderID() {
		// FIXME - avoid compilation breakage =>
		// make it abstract ensure all concrete subclasses provide concrete
		// operation
		return "unknown"; //$NON-NLS-1$
	}

	protected CompilationUnit createCompilationUnit(
			QvtOperationalModuleEnv moduleEnv) {
		return createCompilationUnit(Collections.singletonList(moduleEnv));
	}

	protected CompilationUnit createCompilationUnit(
			final List<QvtOperationalModuleEnv> loadedModules) {
		return new CompilationUnit() {
			public List<QvtOperationalModuleEnv> getElements() {
				return Collections.unmodifiableList(loadedModules);
			}
		};
	}

	public static void setInstanceAdapterFactory(Module module, final InstanceAdapterFactory factory) {
		ModuleInstanceFactory moduleInstanceFactory = (ModuleInstanceFactory) module
				.getEFactoryInstance();
		moduleInstanceFactory
				.addPostCreateHandler(new ModuleInstanceFactory.PostCreateHandler() {
					public void created(ModuleInstance moduleInstance) {
						Object adapterInstance = factory
								.createAdapter(moduleInstance);
						moduleInstance
								.getAdapter(ModuleInstance.Internal.class)
								.addAdapter(adapterInstance);
					}
				});
	}

	protected void setOperationHandler(EOperation operation,
			final CallHandler handler, boolean adaptSource) {
		CallHandler actualHandler = handler;
		if (adaptSource) {
			actualHandler = new CallHandler() {
				public Object invoke(ModuleInstance module, Object source,
						Object[] args, QvtOperationalEvaluationEnv evalEnv) {
					return handler.invoke(module, source, args, evalEnv);
				}
			};
		}

		CallHandlerAdapter.attach(operation, actualHandler);
	}

	public abstract List<AbstractCompilationUnitDescriptor> getModuleDescriptors(
			ResolutionContext resolutionContext);

	public abstract AbstractCompilationUnitDescriptor getModuleDescriptor(
			String qualifiedName, ResolutionContext resolutionContext);

	public abstract CompilationUnit loadCompilationUnit(
			AbstractCompilationUnitDescriptor descriptor,
			LoadContext loadContext) throws BlackboxException;
}
