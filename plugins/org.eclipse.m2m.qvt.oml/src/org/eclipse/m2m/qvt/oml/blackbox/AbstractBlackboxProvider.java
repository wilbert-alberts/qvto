/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.blackbox;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstanceFactory;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.library.IContext;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandler;
import org.eclipse.m2m.internal.qvt.oml.stdlib.CallHandlerAdapter;


public abstract class AbstractBlackboxProvider {

	protected interface InstanceAdapterFactory {
		Object createAdapter(EObject moduleInstance);
	}
	
	private static class Adapter extends AdapterImpl { 
		
		final private Object fAdapterInstance;		
		
		Adapter(Object adapterInstance) {
			fAdapterInstance = adapterInstance;
		}
		
		Object getInstance() {
			return fAdapterInstance;
		}
		
		@Override
		public boolean isAdapterForType(Object type) {
			if(getClass() == type) {
				return true;
			}
			return super.isAdapterForType(type);
		}
		
		@Override
		public String toString() {		
			return super.toString() + "(" + fAdapterInstance.toString() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
	
	
	protected AbstractBlackboxProvider() {
		super();
	}
			
	protected CompilationUnit createCompilationUnit(QvtOperationalModuleEnv moduleEnv) {
		return createCompilationUnit(Collections.singletonList(moduleEnv));
	}
		
	protected CompilationUnit createCompilationUnit(final List<QvtOperationalModuleEnv> loadedModules) {
		return new CompilationUnit() {
			public List<QvtOperationalModuleEnv> getElements() {
				return Collections.unmodifiableList(loadedModules);
			}
		};
	}
	
	protected void setInstanceAdapterFactory(Module module, final InstanceAdapterFactory factory) {
		ModuleInstanceFactory moduleInstanceFactory = (ModuleInstanceFactory) module.getEFactoryInstance();
		moduleInstanceFactory.addPostCreateHandler(new ModuleInstanceFactory.PostCreateHandler() {
			public void created(ModuleInstance moduleInstance) {				
				Object adapterInstance = factory.createAdapter(moduleInstance);
				moduleInstance.eAdapters().add(new Adapter(adapterInstance));
			}
		});
	}
	
	protected void setOperationHandler(EOperation operation, final CallHandler handler, boolean adaptSource) {
		CallHandler actualHandler = handler;		
		if(adaptSource) {
			actualHandler = new CallHandler() {
				public Object invoke(Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv, IContext context) {
					if(source instanceof ModuleInstance) {
						ModuleInstance eSource = (ModuleInstance) source;
						Adapter adapter = (Adapter)EcoreUtil.getExistingAdapter(eSource, Adapter.class);
						assert adapter != null;
						
						return handler.invoke(adapter.getInstance(), args, evalEnv, context);
					}
					
					return handler.invoke(source, args, evalEnv, context);
				};
			}; 
		}

		CallHandlerAdapter.attach(operation, actualHandler);
	}
	
	public abstract List<AbstractCompilationUnitDescriptor> getModuleDescriptors(ResolutionContext resolutionContext);
	
	public abstract AbstractCompilationUnitDescriptor getModuleDescriptor(String qualifiedName, ResolutionContext resolutionContext);

	public abstract CompilationUnit loadCompilationUnit(AbstractCompilationUnitDescriptor descriptor, LoadContext loadContext) throws BlackboxException;	
}
