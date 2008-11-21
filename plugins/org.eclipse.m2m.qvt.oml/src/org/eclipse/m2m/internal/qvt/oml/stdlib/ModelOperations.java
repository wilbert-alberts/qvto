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
package org.eclipse.m2m.internal.qvt.oml.stdlib;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelParameterExtent;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ModuleInstance;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.util.TypeUtil;


public class ModelOperations extends AbstractContextualOperations {

	public static final String OBJECTS_NAME = "objects"; //$NON-NLS-1$
	public static final String ROOT_OBJECTS_NAME = "rootObjects"; //$NON-NLS-1$
	public static final String OBJECTS_OF_TYPE_NAME = "objectsOfType"; //$NON-NLS-1$
	public static final String REMOVE_ELEMENT_NAME = "removeElement"; //$NON-NLS-1$
	
	public ModelOperations(AbstractQVTStdlib library) {
		super(library, library.getModelClass());
	}
	
	public EOperation defineGenericObjectsOfType(EcoreEnvironment env, EClassifier actualType) {		
		return new OwnedOperationProvider(OBJECTS_OF_TYPE, OBJECTS_OF_TYPE_NAME,  
				TypeUtil.resolveSetType(env, actualType), env.getOCLStandardLibrary().getOclType()).define(env);
	}	
	
	@Override
	protected OperationProvider[] getOperations() {		
		EClassifier setOfElements = TypeUtil.resolveSetType(getStdlib().getEnvironment(), getStdlib().getElementType());
		OCLStandardLibrary<EClassifier> oclStdLib = getStdlib().getEnvironment().getOCLStandardLibrary();
		return new OwnedOperationProvider[] {
			new OwnedOperationProvider(OBJECTS, OBJECTS_NAME, setOfElements),
			new OwnedOperationProvider(ROOT_OBJECTS, ROOT_OBJECTS_NAME, setOfElements),
			new OwnedOperationProvider(OBJECTS_OF_TYPE, OBJECTS_OF_TYPE_NAME, setOfElements, oclStdLib.getOclType()),
			new OwnedOperationProvider(REMOVE_ELEMENT, REMOVE_ELEMENT_NAME, oclStdLib.getOclVoid(), getStdlib().getElementType())
		};
	}
	
	private static final  CallHandler OBJECTS = new CallHandler() {
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			Set<Object> instances = new LinkedHashSet<Object>();
			instances.addAll(((ModelParameterExtent) source).getAllObjects());
			return instances;
		}
	};

	private static final CallHandler ROOT_OBJECTS = new CallHandler() {
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			Set<Object> instances = new LinkedHashSet<Object>();
			instances.addAll(((ModelParameterExtent) source).getRootObjects());
			return instances;
		}
	};

	private static final CallHandler OBJECTS_OF_TYPE = new CallHandler() {
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
	        Set<Object> instances = new LinkedHashSet<Object>();
	        List<Object> objects = ((ModelParameterExtent) source).getAllObjects();
			for (Object obj : objects) {
	            if (AbstractQVTStdlib.clsFilter.matches(obj, args[0])) {
	                instances.add(obj);
	            }
	        }	        
	        return instances;
		}
	};
	
	private static final CallHandler REMOVE_ELEMENT = new CallHandler() {
		public Object invoke(ModuleInstance module, Object source, Object[] args, QvtOperationalEvaluationEnv evalEnv) {
			if(source instanceof ModelParameterExtent == false) {
				throw new IllegalArgumentException();
			}
			
			ModelParameterExtent modelParam = (ModelParameterExtent) source;
			Object elementObject = args[0];
			if(elementObject instanceof EObject) {
				modelParam.removeElement((EObject) elementObject);
			}
	        return null;
		}
	};
}
