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
package org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.internal.qvt.oml.emf.util.Logger;


public class EmfStandaloneMetamodelProvider implements IMetamodelProvider {
    public EmfStandaloneMetamodelProvider() {
    }
    
	public IMetamodelDesc[] getMetamodels() {
        List<IMetamodelDesc> descs = new ArrayList<IMetamodelDesc>();
        List<String> uris = new ArrayList<String>(EPackage.Registry.INSTANCE.keySet());
        
        Map<String,String> uri2ns = getUriToNamespaceMap();
        
        for (String uri : uris) {
            String namespace = uri2ns.get(uri);

            try {
                Object pack = EPackage.Registry.INSTANCE.get(uri);
                if (pack instanceof EPackage.Descriptor) {
                	descs.add(new EmfMetamodelDesc((EPackage.Descriptor) pack, uri, namespace));
                } else if (pack instanceof EPackage) {
                	descs.add(new EmfMetamodelDesc((EPackage) pack, uri, namespace));
                }
            }
            catch(Exception e) {
                Logger.getLogger().log(Logger.SEVERE, "Failed to get EPackage for URI " + uri, e); //$NON-NLS-1$
            }
        }
        
        return descs.toArray(new IMetamodelDesc[descs.size()]);
    }
    
    private static final Map<String, String> getUriToNamespaceMap() {
        Map<String, String> map = new HashMap<String, String>();
        
        IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EmfPluginRegistryMetamodelProvider.POINT);
        for(int i = 0; i < configurationElements.length; i++) {
            IConfigurationElement configurationElement = configurationElements[i]; 
            map.put(configurationElement.getAttribute("uri"), configurationElement.getNamespaceIdentifier()); //$NON-NLS-1$
        }
        
        return map;
    }
}
