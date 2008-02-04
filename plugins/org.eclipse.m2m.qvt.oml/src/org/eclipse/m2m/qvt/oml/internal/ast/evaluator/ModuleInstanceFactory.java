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
package org.eclipse.m2m.qvt.oml.internal.ast.evaluator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.util.CollectionUtil;
	

class ModuleInstanceFactory extends EFactoryImpl {
	
	public static final EFactory eINSTANCE = new ModuleInstanceFactory(); 
	
	private ModuleInstanceFactory() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	private void initProperties(EObject instance) {
		// initializes module properties of OCL Collection type as empty and non-null
		for(EStructuralFeature eStructuralFeature : instance.eClass().getEAllStructuralFeatures()) {
			if(eStructuralFeature.getEType() instanceof CollectionType) {
				CollectionType<EClassifier, EOperation> collectionType = (CollectionType<EClassifier, EOperation>)eStructuralFeature.getEType();
				instance.eSet(eStructuralFeature, CollectionUtil.createNewCollection(collectionType.getKind()));
			}
		}
	}	
	
	@Override
	protected EObject basicCreate(EClass eClass) {
		ModuleInstance result = new ModuleInstance();
		result.eSetClass(eClass);
		initProperties(result);
		return result;
	}
	
	private static final class ModuleInstance extends DynamicEObjectImpl {

		ModuleInstance() {
			super();
		}
				
		@Override
		public String toString() {
			return eClass().getName() + " @" + this.hashCode(); //$NON-NLS-1$
		}
	}
}
