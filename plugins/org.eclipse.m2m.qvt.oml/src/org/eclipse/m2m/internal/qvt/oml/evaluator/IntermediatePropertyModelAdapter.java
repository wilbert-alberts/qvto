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

package org.eclipse.m2m.internal.qvt.oml.evaluator;

import java.util.IdentityHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.cst.adapters.AbstractGenericAdapter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty;
import org.eclipse.m2m.internal.qvt.oml.expressions.Property;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.util.CollectionUtil;

/**
 * @author sboyko
 *
 */
public class IntermediatePropertyModelAdapter extends AbstractGenericAdapter<IntermediatePropertyModelAdapter> {
	
	private IntermediatePropertyModelAdapter() {
	}
	
    public boolean isAdapterForType(Object type) {
        return type == IntermediatePropertyModelAdapter.class;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof IntermediatePropertyModelAdapter;
    }

    @Override
    public int hashCode() {
        return IntermediatePropertyModelAdapter.class.hashCode();
    }

    public static ShadowEntry getPropertyHolder(EObject moduleInstance, ContextualProperty property, Object ownerInstance) {
    	IntermediatePropertyModelAdapter adapter = (IntermediatePropertyModelAdapter) EcoreUtil.getAdapter(moduleInstance.eAdapters(),
    			IntermediatePropertyModelAdapter.class);
    	if (adapter == null) {
    		adapter = new IntermediatePropertyModelAdapter();
    		moduleInstance.eAdapters().add(adapter);
    	}
    	
    	return adapter.getPropertyHolder(property, ownerInstance);
    }
    
    private ShadowEntry getPropertyHolder(ContextualProperty property, Object ownerInstance) {
    	ShadowEntry runtimeShadow = myProp2HolderMap.get(property);
    	if(runtimeShadow == null) {
    		runtimeShadow = new ShadowEntry(myPropShadowHelper.createShadowProperty(property));
    		myProp2HolderMap.put(property, runtimeShadow);
    	}
		
		return runtimeShadow;
	}
    
    private static Object getInitialValue(EStructuralFeature feature) {
		//Object inittialValue = myInitExpression.accept(evalVisitor);

		if (feature.getEType() instanceof CollectionType) {
			@SuppressWarnings("unchecked")
			CollectionType<EClassifier, EOperation> collectionType = (CollectionType<EClassifier, EOperation>) feature.getEType();
			return CollectionUtil.createNewCollection(collectionType.getKind());
		}
    	
    	return null;
    }

	private final Map<Property, ShadowEntry> myProp2HolderMap = new IdentityHashMap<Property, ShadowEntry>(2);
	private final RuntimePropertyShadowHelper myPropShadowHelper = new RuntimePropertyShadowHelper();
	

	public static class ShadowEntry {
		private EStructuralFeature myFeature;
		private Map<Object, EObject> myOwner2ShadowMap = new IdentityHashMap<Object, EObject>();
		
		private ShadowEntry(EStructuralFeature runtimeFeature) {
			assert runtimeFeature != null;
			myFeature = runtimeFeature;
		}
		
		public EStructuralFeature getProperty() {
			return myFeature;
		}
		
		public EObject getPropertyRuntimeOwner(Object shadowedInstance) {
			EObject owner = myOwner2ShadowMap.get(shadowedInstance);
			if (owner == null) {
				EClass ownerClass = myFeature.getEContainingClass();
				EFactory eFactory = ownerClass.getEPackage().getEFactoryInstance();		
				owner = eFactory.create(ownerClass);
				myOwner2ShadowMap.put(shadowedInstance, owner);				

		    	Object initialValue = getInitialValue(myFeature);
		    	if (initialValue != null) {
		    		owner.eSet(myFeature, initialValue);
		    	}												
			}
			return owner;
		}
	}
}
