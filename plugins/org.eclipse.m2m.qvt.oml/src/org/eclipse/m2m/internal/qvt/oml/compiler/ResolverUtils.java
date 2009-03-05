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

import org.eclipse.core.runtime.IPath;


public class ResolverUtils {
	
	private ResolverUtils() {
		super();
	}
	
	public static String getNamespace(IPath namespacePath, IPath srcContainerPath) {
		if(namespacePath == null || srcContainerPath == null) {
			throw new IllegalArgumentException();
		}
		
		if(namespacePath.equals(srcContainerPath)) {
			// default namespace
			return null;
		}

		int srcContainerDepth = srcContainerPath.segmentCount();
		IPath srcRelativePath = namespacePath.removeFirstSegments(srcContainerDepth);
		
		return getNamespace(srcRelativePath);
	}
	
	public static String getNamespace(IPath srcRelativePath) {
		StringBuilder buf = new StringBuilder();			
		String[] segments = srcRelativePath.segments();
		
		for (int i = 0; i < segments.length; i++) {
			if(i > 0) {
				buf.append('.');
			}
			
			buf.append(segments[i]);	
		}
		
		return buf.toString();
	}

		
	public static List<UnitProxy> findAllUnits(UnitProvider unitProvider) {
		final List<UnitProxy> result = new ArrayList<UnitProxy>();
		
		UnitProvider.UnitVisitor visitor = new UnitProvider.UnitVisitor() {
			
			public boolean visitUnit(UnitProxy unit) {
				result.add(unit);
				return true;
			}
		};

		unitProvider.accept(visitor, null, UnitProvider.UnitVisitor.DEPTH_INFINITE, true);		
		return result;
	}
}
