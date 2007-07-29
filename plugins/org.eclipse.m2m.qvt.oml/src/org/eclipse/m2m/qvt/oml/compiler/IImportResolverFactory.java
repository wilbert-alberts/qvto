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
package org.eclipse.m2m.qvt.oml.compiler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.m2m.qvt.oml.QvtPlugin;


public interface IImportResolverFactory {
	boolean isAccepted(Object source);
	
	IImportResolver createResolver(Object source);
	
	interface Registry {
		String POINT_ID = QvtPlugin.ID + ".importResolverFactory"; //$NON-NLS-1$
		String CLASS_ATTR = "class"; //$NON-NLS-1$
		
		IImportResolverFactory getFactory(Object source);
		
		
		
		Registry INSTANCE = new Registry() {
			private List<IImportResolverFactory> factories = readFactories();
			
			public IImportResolverFactory getFactory(Object source) {
				for (IImportResolverFactory nextFactory : factories) {
					if(nextFactory.isAccepted(source)) {
						return nextFactory;
					}
				}
				throw new IllegalStateException("No import resolver factory available for: " + source); //$NON-NLS-1$
			}
			
			private List<IImportResolverFactory> readFactories() {
				ArrayList<IImportResolverFactory> factoryEntries = new ArrayList<IImportResolverFactory>();
				IExtensionRegistry pluginRegistry = Platform.getExtensionRegistry();
				IExtensionPoint extensionPoint = pluginRegistry.getExtensionPoint(POINT_ID);
				if(extensionPoint != null) {
					IExtension[] allExtensions = extensionPoint.getExtensions();
					for (IExtension nextExtension : allExtensions) {
						IConfigurationElement[] elements = nextExtension.getConfigurationElements();
						Object factoryObj = null;
						try {
							factoryObj = elements[0].createExecutableExtension(CLASS_ATTR);
							if(factoryObj instanceof IImportResolverFactory) {
								factoryEntries.add((IImportResolverFactory)factoryObj);
							}
						} catch (CoreException e) {
							QvtPlugin.log(e);
						}
					}						
				}
				return factoryEntries;
		    }
		    
		};
	}
	
}
