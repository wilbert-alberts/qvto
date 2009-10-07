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
package org.eclipse.m2m.internal.qvt.oml.blackbox.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

class ModuleHandle {

	private final String bundleId;
	private final String className;
	private final String simpleName;
	private final List<String> usedPackages;
	
	ModuleHandle(String bundleId, String className, String moduleName, List<String> usedPackages) {
		if(bundleId == null || className == null || usedPackages == null) {
			throw new IllegalArgumentException();
		}
		
		this.bundleId = bundleId;
		this.className = className;			
		this.simpleName = moduleName;
		this.usedPackages = Collections.unmodifiableList(new ArrayList<String>(usedPackages));
	}
	
	public String getSimpleName() {
		return simpleName;
	}
	
	public String getJavaClassName() {
		return className;
	}
	
	public List<String> getUsedPackages() {
		return usedPackages;
	}
	
	public Class<?> getModuleJavaClass() throws ClassNotFoundException {
		Bundle bundle = Platform.getBundle(bundleId);
		if(bundle != null) {
			return bundle.loadClass(className);
		}
		return null;
	}
	
	@Override
	public String toString() {			
		return simpleName + " - " + className + "(bundle=" + bundleId + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$   
	}		
}