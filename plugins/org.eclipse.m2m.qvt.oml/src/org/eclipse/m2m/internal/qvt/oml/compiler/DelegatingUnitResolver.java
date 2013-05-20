/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation and others.
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

public abstract class DelegatingUnitResolver implements UnitResolver {
	
	private UnitResolver fParent;
	
		
	protected DelegatingUnitResolver() {
		super();		
	}

	protected abstract UnitProxy doResolveUnit(String qualifiedName);
	
	protected UnitResolver getParent() {
		return fParent;
	}
	
	protected void setParent(UnitResolver resolver) {
		fParent = resolver;
	}
		
	public final UnitProxy resolveUnit(String qualifiedName) {	
		UnitProxy unit = doResolveUnit(qualifiedName);
		if(unit == null) {
			UnitResolver parent = getParent();
			if(parent != null) {
				return parent.resolveUnit(qualifiedName);
			}
		}
		
		return unit;
	}
		
}
