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
package org.eclipse.m2m.internal.qvt.oml.evaluator;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalStdLibrary;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.util.CollectionUtil;

public class ModuleInstanceFactory extends EFactoryImpl {

	public interface PostCreateHandler {
		void created(ModuleInstance moduleInstance);
	}

	private List<PostCreateHandler> fPostCreateHandlers = Collections.emptyList();

	public ModuleInstanceFactory() {
		super();
	}
	
	public ThisInstanceResolver instantiateImportsByAccess(Set<Module> importedByAccess, boolean includeStdLib) {
		final HashMap<Module, ModuleInstance> instanceMap = new HashMap<Module, ModuleInstance>(3);
		if(includeStdLib) {
			basicCreateModuleInstance(QvtOperationalStdLibrary.INSTANCE.getStdLibModule(), instanceMap);
		}

		for (Module module : importedByAccess) {
			createModuleInstance(module, instanceMap);
		}
		
		return new ThisInstanceResolver() {					
			public ModuleInstance getThisInstanceOf(Module module) {			
				return instanceMap.get(module);
			}
		};
	}
	
	public void addPostCreateHandler(PostCreateHandler postCreateHandler) {
		if (postCreateHandler == null) {
			throw new IllegalArgumentException();
		}

		if (fPostCreateHandlers.isEmpty()) {
			fPostCreateHandlers = new LinkedList<PostCreateHandler>();
		}

		fPostCreateHandlers.add(postCreateHandler);
	}

	@Override
	public EObject create(EClass eClass) {
		if (getEPackage() != eClass.getEPackage() || eClass.isAbstract()) {
			if (eClass instanceof Module == false) {
				// relax the constraint for Module being also a package
				throw new IllegalArgumentException(
						"The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		return basicCreate(eClass);
	}

	@Override
	protected EObject basicCreate(EClass eClass) {
		if (eClass instanceof Module) {
			Module module = (Module) eClass;

			HashMap<Module, ModuleInstance> instanceMap = new HashMap<Module, ModuleInstance>(3);
			basicCreateModuleInstance(QvtOperationalStdLibrary.INSTANCE.getStdLibModule(), instanceMap);			
			ModuleInstance result = createModuleInstance(module, instanceMap);			

			return result;
		}

		return super.basicCreate(eClass);
	}

	private ModuleInstance createModuleInstance(Module module, Map<Module, ModuleInstance> instanceMap) {
		List<ModuleInstanceImpl> importedInstances = Collections.emptyList();
		for (ModuleImport moduleImport : module.getModuleImport()) {
			if (importedInstances.isEmpty()) {
				importedInstances = new LinkedList<ModuleInstanceImpl>();
			}
			Module importedModule = moduleImport.getImportedModule();
			createModuleInstance(importedModule, instanceMap);
		}

		ModuleInstance moduleInstance = instanceMap.get(module);
		if (moduleInstance == null) {
			moduleInstance = basicCreateModuleInstance(module, instanceMap);
		}

		return moduleInstance;
	}

	private ModuleInstanceImpl basicCreateModuleInstance(Module module, Map<Module, ModuleInstance> instanceMap) {
		ModuleInstanceImpl moduleInstance = new ModuleInstanceImpl(module);
		moduleInstance.setInstanceMap(instanceMap);
		instanceMap.put(module, moduleInstance);
		
		initProperties(moduleInstance);

		ModuleInstanceFactory factory = this; 
		if(module.getEFactoryInstance() instanceof ModuleInstanceFactory) {
			factory = (ModuleInstanceFactory) module.getEFactoryInstance();
			factory.notifyModuleCreated(moduleInstance);
		}
		
		if(factory != this) {
			this.notifyModuleCreated(moduleInstance);
		}
		
		return moduleInstance;
	}

	private void notifyModuleCreated(ModuleInstanceImpl moduleInstance) {
		if(fPostCreateHandlers != null) {
			for (PostCreateHandler handler : fPostCreateHandlers) {
				handler.created(moduleInstance);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private static void initProperties(ModuleInstanceImpl instance) {
		// initializes module properties of OCL Collection type as empty and non-null
		for (EStructuralFeature eStructuralFeature : instance.eClass().getEAllStructuralFeatures()) {
			if (eStructuralFeature.getEType() instanceof CollectionType) {
				CollectionType<EClassifier, EOperation> collectionType = (CollectionType<EClassifier, EOperation>) eStructuralFeature.getEType();
				instance.eSet(eStructuralFeature, CollectionUtil.createNewCollection(collectionType.getKind()));
			}
		}
	}
}
