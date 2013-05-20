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

import java.util.ArrayList;
import java.util.List;

public final class CompositeUnitResolver implements UnitResolver {
	
	private List<UnitResolver> fResolvers;
			
	public CompositeUnitResolver(UnitResolver... resolvers) {
		fResolvers = new ArrayList<UnitResolver>(resolvers.length);
		
		for (UnitResolver unitResolver : resolvers) {
			if(unitResolver == null) {
				throw new IllegalArgumentException();
			}
			
			fResolvers.add(unitResolver);
		}
	}

	public final UnitProxy resolveUnit(String qualifiedName) {
		for (UnitResolver nextResolver : fResolvers) {
			UnitProxy unit = nextResolver.resolveUnit(qualifiedName);
			if(unit != null) {
				return unit;
			}
		}

		return null;
	}
	
}
