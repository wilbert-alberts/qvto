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
package org.eclipse.m2m.internal.qvt.oml.project.builder;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProvider;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.project.QVTOProjectPlugin;
import org.eclipse.osgi.util.ManifestElement;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;


public class ResolverUtils {
	
	// FIXME - use shared constants
	static final String EXTENSION = "qvto";
	static final String EXTENSION_WITH_DOT = "." + EXTENSION;
	
	private ResolverUtils() {
		super();
	}
	
	static String getNamespace(IPath namespacePath, IPath srcContainerPath) {
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
	
	static String getNamespace(IPath srcRelativePath) {
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

	static List<String> getRequiredPlugins(Bundle bundle) {
		Dictionary<?, ?> headers = bundle.getHeaders();
		String requireBundleHeader = headers.get(Constants.REQUIRE_BUNDLE).toString();
		if(requireBundleHeader == null) {
			return Collections.emptyList();
		}
		
		ManifestElement[] parsedElements = null;		
		try {
	    	parsedElements = ManifestElement.parseHeader(Constants.REQUIRE_BUNDLE, requireBundleHeader);
		} catch (BundleException e) {
			// do nothing
		}
	
		if(parsedElements == null) {
			return Collections.emptyList();			
		}
	
		List<String> bundles = new ArrayList<String>(parsedElements.length);
		for (ManifestElement element : parsedElements) {
			String value = element.getValue();
			if(value != null) {
				bundles.add(element.getValue());
			}
		}				
	
		return bundles;
	}

	public static List<UnitProxy> findAllUnits(IProject project) {
		WorkspaceUnitResolver resolver;
		try {
			resolver = WorkspaceUnitResolver.getResolver(project);
			if(resolver != null) {
				return findAllUnits(resolver);
			}			
		} catch (CoreException e) {
			QVTOProjectPlugin.log(e.getStatus());
		}

		return Collections.emptyList();
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
