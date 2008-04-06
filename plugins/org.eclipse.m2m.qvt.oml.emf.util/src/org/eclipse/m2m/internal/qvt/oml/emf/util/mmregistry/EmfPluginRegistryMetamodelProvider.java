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
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EPackage;


/** @author pkobiakov */
public class EmfPluginRegistryMetamodelProvider implements IMetamodelProvider {
	public IMetamodelDesc[] getMetamodels() {
        return getBuiltinMetamodels();
    }
    
    private IMetamodelDesc[] getBuiltinMetamodels() {
		List<IMetamodelDesc> descs = new ArrayList<IMetamodelDesc>();
        // not via package registry, as it also might contain runtime metamodels
        IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(POINT);
        for(int i = 0; i < configurationElements.length; i++) {
        	IConfigurationElement configurationElement = configurationElements[i];
        	String uri = configurationElement.getAttribute("uri"); //$NON-NLS-1$
        	String namespace = configurationElement.getNamespaceIdentifier();
        	Object pack = EPackage.Registry.INSTANCE.get(uri);
 			if (pack instanceof EPackage.Descriptor) {
            	descs.add(new EmfMetamodelDesc((EPackage.Descriptor) pack, uri, namespace));
            } else if (pack instanceof EPackage) {
            	descs.add(new EmfMetamodelDesc((EPackage) pack, uri, namespace));
            }
        }
		return descs.toArray(new IMetamodelDesc[descs.size()]);
	}
    
    public static final String POINT = "org.eclipse.emf.ecore.generated_package"; //$NON-NLS-1$ 
}
