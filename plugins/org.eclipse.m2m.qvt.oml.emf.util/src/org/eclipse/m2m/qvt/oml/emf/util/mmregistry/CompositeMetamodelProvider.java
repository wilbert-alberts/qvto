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
package org.eclipse.m2m.qvt.oml.emf.util.mmregistry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeMetamodelProvider implements IMetamodelProvider {
    public CompositeMetamodelProvider(IMetamodelProvider[] providers) {
        myProviders = providers;
    }
    
    public IMetamodelDesc[] getMetamodels() {
        List<IMetamodelDesc> descs = new ArrayList<IMetamodelDesc>();
        for (int i = 0; i < myProviders.length; i++) {
            IMetamodelProvider provider = myProviders[i];
            descs.addAll(Arrays.asList(provider.getMetamodels()));
        }
        
        return descs.toArray(new IMetamodelDesc[descs.size()]);
    }

    private final IMetamodelProvider[] myProviders;
}
