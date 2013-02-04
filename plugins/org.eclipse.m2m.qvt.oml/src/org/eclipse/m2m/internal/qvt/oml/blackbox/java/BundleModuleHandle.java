/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.blackbox.java;

import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

class BundleModuleHandle extends ModuleHandle {

	private final String bundleId;		
	
	BundleModuleHandle(String bundleId, String className, String moduleName, List<String> usedPackages) {
		super(className, moduleName, usedPackages);
		
		if(bundleId == null) {
			throw new IllegalArgumentException("null bundle ID"); //$NON-NLS-1$
		}

		this.bundleId = bundleId;
	}
	
	@Override
	public Class<?> getModuleJavaClass() throws ClassNotFoundException {
		Bundle bundle = Platform.getBundle(bundleId);
		if(bundle != null) {
			return bundle.loadClass(getJavaClassName());
		}
		return getClass().getClassLoader().loadClass(getJavaClassName());
	}
	
	@Override
	public String toString() {			
		return super.toString() + ", bundle: " + bundleId; //$NON-NLS-1$
	}				
}