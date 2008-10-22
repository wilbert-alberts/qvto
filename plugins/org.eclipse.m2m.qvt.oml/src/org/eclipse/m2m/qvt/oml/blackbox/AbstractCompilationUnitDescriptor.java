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
package org.eclipse.m2m.qvt.oml.blackbox;



public abstract class AbstractCompilationUnitDescriptor {

	private String fQualifiedName;
	private String fDescription;
	private AbstractBlackboxProvider fProvider;
	
	
	protected AbstractCompilationUnitDescriptor(AbstractBlackboxProvider provider, String qualifiedName) {
		if(provider == null || qualifiedName == null) {
			throw new IllegalArgumentException("null 'qualified name' or 'provider'"); //$NON-NLS-1$
		}
		
		fProvider = provider;
		fQualifiedName = qualifiedName;
	}
	
	protected AbstractBlackboxProvider getProvider() {
		return fProvider;
	}
	
	protected void setDescription(String description) {
		fDescription = description;
	}

	public String getDescription() {
		return fDescription; 
	}	
	
	public String getQualifiedName() {
		return fQualifiedName;
	}
			
	@Override
	public String toString() {
		return "Descriptor: " + fQualifiedName + " - " + getProvider().toString(); //$NON-NLS-1$ 
	}
}