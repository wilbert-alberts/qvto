/*******************************************************************************
 * Copyright (c) 2008, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.blackbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;

/*
 * TODO - handle collisions of multiple descriptors of the same qualified name
 */
public class BlackboxRegistry {
	
	private static final String CLASS_ATTR = "class"; //$NON-NLS-1$

	private static final String PROVIDER_ELEMENT = "provider"; //$NON-NLS-1$

	private static final String BLACKBOX_PROVIDER_EXTENSION = "blackboxProvider"; //$NON-NLS-1$

	public static BlackboxRegistry INSTANCE = new BlackboxRegistry();

	// instance fields
	private List<AbstractBlackboxProvider> fProviders;
		
	private BlackboxRegistry() {
		try {
			if(EMFPlugin.IS_ECLIPSE_RUNNING) {
				fProviders = Eclipse.readProviders();
			} else {
				fProviders = Collections.emptyList();
			}
		} catch (RuntimeException e) {
			fProviders = Collections.emptyList();
			QvtPlugin.error(e);
		}
	}
	
	public AbstractCompilationUnitDescriptor getCompilationUnitDescriptor(String qualifiedName, ResolutionContext context) {
		for (AbstractBlackboxProvider provider : fProviders) {
			AbstractCompilationUnitDescriptor descriptor = provider.getModuleDescriptor(qualifiedName, context);
			if(descriptor != null) {
				return descriptor;
			}
		}
		
		return null;
	}
	
	public CompilationUnit loadCompilationUnit(AbstractCompilationUnitDescriptor descriptor, LoadContext loadContext) throws BlackboxException {
		if(descriptor == null) {
			throw new IllegalArgumentException("Null blackbox descriptor"); //$NON-NLS-1$
		}
		
		AbstractBlackboxProvider provider = descriptor.getProvider();
		return provider.loadCompilationUnit(descriptor, loadContext);
	}
		
	public List<AbstractCompilationUnitDescriptor> getCompilationUnitDescriptors(ResolutionContext loadContext) {
		ArrayList<AbstractCompilationUnitDescriptor> result = new ArrayList<AbstractCompilationUnitDescriptor>();
		
		for (AbstractBlackboxProvider provider : fProviders) {
			for (AbstractCompilationUnitDescriptor abstractCompilationUnitDescriptor : provider.getModuleDescriptors(loadContext)) {
				result.add(abstractCompilationUnitDescriptor);
			}
		}
		
		return result;
	}

	private static class Eclipse {
	    private static List<AbstractBlackboxProvider> readProviders() {
	        List<AbstractBlackboxProvider> providers = new LinkedList<AbstractBlackboxProvider>();
	        
	        IConfigurationElement[] configs =
	            Platform.getExtensionRegistry().getConfigurationElementsFor(
	                QvtPlugin.ID, BLACKBOX_PROVIDER_EXTENSION);
	
	        for (IConfigurationElement element : configs) {
	            if (element.getName().equals(PROVIDER_ELEMENT)) {
	                try {
	                	Object extension = element.createExecutableExtension(CLASS_ATTR);
	                	if(extension instanceof AbstractBlackboxProvider == false) {
	                		QvtPlugin.error("Provider must implement AbstractBlackboxProvider interace: " + extension); //$NON-NLS-1$
	                		continue;
	                	}
	
	                	providers.add((AbstractBlackboxProvider)extension);
	                } catch (CoreException e) {
	                    QvtPlugin.getDefault().log(e.getStatus());
	                }
	            }
	        }
	        
	        return providers;
	    }
	}
}
