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
package org.eclipse.m2m.internal.qvt.oml.blackbox.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class ModuleHandle {
	
	private final String className;
	private final String simpleName;
	private final List<String> usedPackages;
	
	ModuleHandle(String className, String moduleName, List<String> usedPackages) {
		if(className == null || usedPackages == null || moduleName == null) {
			throw new IllegalArgumentException();
		}
		
		this.className = className;			
		this.simpleName = moduleName;
		this.usedPackages = Collections.unmodifiableList(new ArrayList<String>(usedPackages));
	}
	
	
	public String getModuleName() {
		return simpleName;
	}
	
	public String getJavaClassName() {
		return className;
	}
	
	public List<String> getUsedPackages() {
		return usedPackages;
	}
	
	public Class<?> getModuleJavaClass() throws ClassNotFoundException {
		return Class.forName(className);
	}
	
	@Override
	public String toString() {			
		return simpleName + ", javaClass: " + className; //$NON-NLS-1$   
	}		
}