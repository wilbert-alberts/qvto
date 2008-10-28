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
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
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
	
	public void addPostCreateHandler(PostCreateHandler postCreateHandler) {
		if(postCreateHandler == null) {
			throw new IllegalArgumentException();
		}
		
		if(fPostCreateHandlers.isEmpty()) {
			fPostCreateHandlers = new LinkedList<PostCreateHandler>();
		}

		fPostCreateHandlers.add(postCreateHandler);
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
	public EObject create(EClass eClass) 
	  {
	    if (getEPackage() != eClass.getEPackage() || eClass.isAbstract())
	    {
	    	if(eClass instanceof Module == false) {
	    		// relax the constraint for Module being also a package 
	    		throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
	    	}
	    }

	    for (List<EClass> eSuperTypes = eClass.getESuperTypes(); !eSuperTypes.isEmpty(); )
	    {
	      EClass eSuperType = eSuperTypes.get(0);
	      if (eSuperType.getInstanceClass() != null)
	      {
	        EObject result = eSuperType.getEPackage().getEFactoryInstance().create(eSuperType);
	        ((InternalEObject)result).eSetClass(eClass);
	        return result;
	      }
	      eSuperTypes = eSuperType.getESuperTypes();
	    }

	    return basicCreate(eClass);
	  }	
	
	@Override
	protected EObject basicCreate(EClass eClass) {	
		if (eClass instanceof Module) {
			ModuleInstance result = new ModuleInstance((Module) eClass);
			result.eSetClass(eClass);
			initProperties(result);
			
			for (PostCreateHandler handler : fPostCreateHandlers) {
				handler.created(result);
			}
			return result;
		}
		
		return super.basicCreate(eClass);
	}
}
