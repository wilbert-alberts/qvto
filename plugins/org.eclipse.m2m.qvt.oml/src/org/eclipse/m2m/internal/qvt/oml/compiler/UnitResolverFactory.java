/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.compiler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;


public interface UnitResolverFactory {

	boolean isAccepted(Object source);
	
	UnitResolver getResolver(URI uri);

	UnitProxy findUnit(URI unitURI);
	
	interface Registry {
		String POINT_ID = QvtPlugin.ID + ".unitResolverFactory"; //$NON-NLS-1$
		String CLASS_ATTR = "class"; //$NON-NLS-1$
		
		UnitResolverFactory getFactory(Object source);		
		
		UnitProxy getUnit(URI uri);
		
		Registry INSTANCE = new Registry() {
			private List<UnitResolverFactory> factories = readFactories();
			
			public UnitResolverFactory getFactory(Object source) {
				for (UnitResolverFactory nextFactory : factories) {
					if(nextFactory.isAccepted(source)) {
						return nextFactory;
					}
				}
				return null;
			}
			
			public UnitProxy getUnit(URI uri) {
				UnitResolverFactory factory = getFactory(uri);
				if(factory != null) {
					return factory.findUnit(uri);
				}
				return null;
			}		
			
			private List<UnitResolverFactory> readFactories() {
				ArrayList<UnitResolverFactory> factoryEntries = new ArrayList<UnitResolverFactory>();
				IExtensionRegistry pluginRegistry = Platform.getExtensionRegistry();
				IExtensionPoint extensionPoint = pluginRegistry.getExtensionPoint(POINT_ID);
				if(extensionPoint != null) {
					IExtension[] allExtensions = extensionPoint.getExtensions();
					for (IExtension nextExtension : allExtensions) {
						IConfigurationElement[] elements = nextExtension.getConfigurationElements();
						Object factoryObj = null;
						try {
							factoryObj = elements[0].createExecutableExtension(CLASS_ATTR);
							if(factoryObj instanceof UnitResolverFactory) {
								factoryEntries.add((UnitResolverFactory)factoryObj);
							}
						} catch (CoreException e) {
							QvtPlugin.getDefault().log(e.getStatus());
						}
					}						
				}
				return factoryEntries;
		    }
		    
		};
	}
	
}
