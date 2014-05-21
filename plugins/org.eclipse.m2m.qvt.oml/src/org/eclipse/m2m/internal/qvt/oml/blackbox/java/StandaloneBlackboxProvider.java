/*******************************************************************************
 * Copyright (c) 2008, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - bug 326871
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.blackbox.java;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.m2m.internal.qvt.oml.blackbox.AbstractCompilationUnitDescriptor;
import org.eclipse.m2m.internal.qvt.oml.blackbox.ResolutionContext;


public class StandaloneBlackboxProvider extends JavaBlackboxProvider {
	
	private final Map<String, AbstractCompilationUnitDescriptor> fDescriptorMap = new LinkedHashMap<String, AbstractCompilationUnitDescriptor>();
	
	@Override
	public AbstractCompilationUnitDescriptor getModuleDescriptor(String qualifiedName, ResolutionContext resolutionContext) { 
		try {
			AbstractCompilationUnitDescriptor d = fDescriptorMap.get(qualifiedName);
			if (d == null) {
				d = new StandaloneDescriptor(qualifiedName);
				fDescriptorMap.put(qualifiedName, d);
			}
			return d;
		} catch(ClassNotFoundException e) {
			return null;
		}
	}	

	@Override
	public Collection<AbstractCompilationUnitDescriptor> getModuleDescriptors(ResolutionContext resolutionContext) {
		// TODO not supported
		return Collections.emptyList();
	}

	
	private class StandaloneDescriptor extends JavaUnitDescriptor {		
				
		StandaloneDescriptor(String unitQualifiedName) throws ClassNotFoundException {
			super(unitQualifiedName); 
			
			addModuleHandle(new StandaloneModuleHandle(unitQualifiedName, getSimpleNameFromJavaClass(unitQualifiedName)));			
		}
						
	}

}
