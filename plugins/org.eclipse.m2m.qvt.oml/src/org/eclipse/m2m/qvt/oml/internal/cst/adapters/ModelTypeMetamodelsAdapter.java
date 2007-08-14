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

package org.eclipse.m2m.qvt.oml.internal.cst.adapters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author sboyko
 *
 */
public class ModelTypeMetamodelsAdapter extends AbstractGenericAdapter<ModelTypeMetamodelsAdapter> {
    public boolean isAdapterForType(Object type) {
        return type == ModelTypeMetamodelsAdapter.class;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ModelTypeMetamodelsAdapter;
    }

    @Override
    public int hashCode() {
        return ModelTypeMetamodelsAdapter.class.hashCode();
    }

    public static void addMetamodel(EObject modelType, EPackage metamodel) {
    	ModelTypeMetamodelsAdapter adapter = (ModelTypeMetamodelsAdapter) EcoreUtil.getAdapter(modelType.eAdapters(),
    			ModelTypeMetamodelsAdapter.class);
    	if (adapter == null) {
    		adapter = new ModelTypeMetamodelsAdapter();
    		modelType.eAdapters().add(adapter);
    	}
    	adapter.myMetamodels.add(metamodel);
    }

    public static List<EPackage> getMetamodels(EObject modelType) {
    	if (modelType == null) {
    		return Collections.emptyList();
    	}
    	ModelTypeMetamodelsAdapter adapter = (ModelTypeMetamodelsAdapter) EcoreUtil.getAdapter(modelType.eAdapters(),
    			ModelTypeMetamodelsAdapter.class);
    	if (adapter == null) {
    		return Collections.emptyList();
    	}
    	return Collections.unmodifiableList(adapter.myMetamodels);
    }


    private final List<EPackage> myMetamodels = new ArrayList<EPackage>(1);
    
}
