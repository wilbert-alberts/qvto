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


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.compiler.BlackboxUnitResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitContents;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProvider;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolver;
import org.eclipse.m2m.internal.qvt.oml.project.QVTOProjectPlugin;
import org.osgi.framework.Bundle;


public class BundleUnitResolver implements UnitResolver {

	private final class BundleUnit extends UnitProxy {

		private final URL url;

		private BundleUnit(String namespace, String unitName, URI uri, URL unitURL) {
			super(namespace, unitName, uri);
			this.url = unitURL;
		}
		
		@Override
		public int getContentType() {
			return UnitProxy.TYPE_CST_STREAM;
		}

		@Override
		public UnitContents getContents() throws IOException {
			return new UnitContents.CSTContents() {
				
				public Reader getContents() throws IOException {
					return new InputStreamReader(url.openStream(), ResourcesPlugin.getEncoding());
				}
			};
		}

		@Override
		public UnitResolver getResolver() {
			return BundleUnitResolver.this;
		}
	}
	

	private Bundle bundle;
	private IPath basePath;
	
	
	public BundleUnitResolver(Bundle bundle) {
		this.bundle = bundle;
	}
	
	public BundleUnitResolver(URI baseURI) {
		if(baseURI.hasTrailingPathSeparator()) {
			baseURI = baseURI.trimSegments(1);
		}
		
		if(!baseURI.isPlatformPlugin() || baseURI.segmentCount() < 2) {
			throw new IllegalArgumentException("Requires URI: platform:/plugins/..."); //$NON-NLS-1$
		}

		String bundleID = baseURI.segment(1);
		
		this.bundle = Platform.getBundle(bundleID);		
		this.basePath = new Path(baseURI.path()).removeFirstSegments(2).makeAbsolute();
	}

	public static UnitResolver createResolver(URL[] bundleBaseURLs) {
		List<URI> platformURIs = bundleBaseURLsToPlatformURIs(bundleBaseURLs);
		final List<UnitResolver> resolvers = new ArrayList<UnitResolver>(platformURIs.size());

		for (URI uri : platformURIs) {
			resolvers.add(new BundleUnitResolver(uri));
		}

		resolvers.add(new BlackboxUnitResolver(platformURIs.get(0)));
		
		return new UnitResolver() {
			public UnitProxy resolveUnit(String qualifiedName) {
				for (UnitResolver nextResolver : resolvers) {
					UnitProxy unit = nextResolver.resolveUnit(qualifiedName);
					if(unit != null) {
						return unit;
					}
				}
				
				return null;
			}

		};
	}
	
	static List<URI> bundleBaseURLsToPlatformURIs(URL[] bundleBaseURLs) {
		Bundle knownBundle = Platform.getBundle(QVTOProjectPlugin.ID);
		Bundle[] bundles = knownBundle.getBundleContext().getBundles();

		List<URI> result = new ArrayList<URI>(5);
		
		for (URL baseURL : bundleBaseURLs) {
			for (Bundle bundle : bundles) {
				URL nextURL = bundle.getEntry("/"); //$NON-NLS-1$
				
				if(nextURL.getAuthority().equals(baseURL.getAuthority())) {
					URI platformURI = URI.createPlatformPluginURI(
							bundle.getSymbolicName(), true)
								.appendSegments(new Path(baseURL.getPath()).segments());
					result.add(platformURI);
				}
			}
		}
		
		return result;
	}
	
	// has trailing slash
	protected IPath getPrefixPath() {
		return basePath;
	}
	
	public UnitProxy resolveUnit(String qualifiedName) {
		String pathStr = qualifiedName.replace('.', '/');

		URL unitURL = bundle.getEntry(getPrefixPath().append(pathStr).addFileExtension(ResolverUtils.EXTENSION).toString());
		if(unitURL == null) {
			return null;
		}

		IPath path = new Path(pathStr);
		String name = path.lastSegment();
		String namespace = null;
		if(path.segmentCount() > 1) {
			IPath nameSpacePath = path.removeLastSegments(1);
			namespace = ResolverUtils.getNamespace(nameSpacePath);
		}
		
		URI uri = URI.createPlatformPluginURI(unitURL.getPath(), true);
		return new BundleUnit(namespace, name, uri, unitURL);		
	}
}
