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

import java.util.IdentityHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.cst.adapters.AbstractGenericAdapter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.util.CollectionUtil;

/**
 * @author sboyko
 *
 */
public class IntermediatePropertyModelAdapter extends AbstractGenericAdapter<IntermediatePropertyModelAdapter> {
	
	private IntermediatePropertyModelAdapter(EStructuralFeature feature) {
		myIntermediateFeature = feature;
		myPropertyHolder = new IdentityHashMap<Object, EObject>(2);
		
		EStructuralFeature overridenFeature = getOverridenFeature(feature);
		if (overridenFeature instanceof ContextualProperty) {
			myInitExpression = ((ContextualProperty) overridenFeature).getInitExpression();
		}
		else {
			myInitExpression = null;
		}
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

    public static EObject getPropertyHolder(EObject modelClass, Object ownerInstance, EStructuralFeature feature) {
    	IntermediatePropertyModelAdapter adapter = (IntermediatePropertyModelAdapter) EcoreUtil.getAdapter(modelClass.eAdapters(),
    			IntermediatePropertyModelAdapter.class);
    	if (adapter == null) {
    		adapter = new IntermediatePropertyModelAdapter(feature);
    		modelClass.eAdapters().add(adapter);
    	}
    	
    	return adapter.getPropertyHolder(ownerInstance);
    }
    
    private EObject getPropertyHolder(Object ownerInstance) {
    	EObject target = myPropertyHolder.get(ownerInstance);
    	if (target == null) {
    		target = myIntermediateFeature.getEContainingClass().getEPackage().getEFactoryInstance().create(myIntermediateFeature.getEContainingClass());
    		myPropertyHolder.put(ownerInstance, target);
    		
    		Object initialValue = getInitialValue();
    		if (initialValue != null) {
    			target.eSet(myIntermediateFeature, initialValue);
    		}
    	}
		return target;
	}
    
    private Object getInitialValue() {
		//Object inittialValue = myInitExpression.accept(evalVisitor);

		if (myIntermediateFeature.getEType() instanceof CollectionType) {
			CollectionType<EClassifier, EOperation> collectionType = (CollectionType<EClassifier, EOperation>) myIntermediateFeature.getEType();
			return CollectionUtil.createNewCollection(collectionType.getKind());
		}
    	
    	return null;
    }

	public static EStructuralFeature getOverridenFeature(EStructuralFeature feature) {
		if (feature == null) {
			return null;
		}
    	EAnnotation annotation = feature.getEAnnotation(Environment.OCL_NAMESPACE_URI);
    	if (annotation != null) {
    		for (EObject nextAnn : annotation.getContents()) {
    			if (false == nextAnn instanceof Constraint) {
    				continue;
    			}
    			Constraint cnt = (Constraint) nextAnn;
    			if (QvtOperationalEnv.INTERMEDIATE_PROPERTY_STEREOTYPE.equals(cnt.getStereotype())
    					&& !cnt.getConstrainedElements().isEmpty()
    					&& cnt.getConstrainedElements().get(0) instanceof EStructuralFeature) {
    				return (EStructuralFeature) cnt.getConstrainedElements().get(0);
    			}
    		}
    	}
    	return feature;
    }

	private final EStructuralFeature myIntermediateFeature;
    private final Map<Object, EObject> myPropertyHolder;
    private final OCLExpression<EClassifier> myInitExpression;
    
}
