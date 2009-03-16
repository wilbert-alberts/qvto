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
package org.eclipse.m2m.internal.qvt.oml.runtime.project;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.compiler.BlackboxUnitResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompositeUnitResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.DelegatingUnitResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.ResolverUtils;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitContents;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolver;
import org.osgi.framework.Bundle;

/**
 * @author dvorak
 */
public class PlatformPluginUnitResolver extends DelegatingUnitResolver {

	private Bundle fBundle;
	private List<IPath> fSrcContainers;

	public PlatformPluginUnitResolver(Bundle bundle) {
		this(bundle, new Path("/")); //$NON-NLS-1$
	}
	
	public PlatformPluginUnitResolver(Bundle bundle, IPath... sourceContainers) {
		if (bundle == null) {
			throw new IllegalArgumentException("null bundle"); //$NON-NLS-1$
		}
		
		if(sourceContainers == null) {
			throw new IllegalArgumentException("null source containter"); //$NON-NLS-1$
		}		
		
		List<IPath> containers = Arrays.asList(sourceContainers);
		if(containers.contains(null)) {
			throw new IllegalArgumentException("null source containter"); //$NON-NLS-1$
		}
		
		fBundle = bundle;
		fSrcContainers = new ArrayList<IPath>(containers);		
	}	

	@Override
	public UnitProxy doResolveUnit(String qualifiedName) {
		IPath unitNsRelativePath = ResolverUtils.toNamespaceRelativePath(qualifiedName).addFileExtension(MDAConstants.QVTO_FILE_EXTENSION);
		
		for (IPath nextContainer : fSrcContainers) {
			IPath unitBundleRelativePath = nextContainer.append(unitNsRelativePath);
			
			URL unitURL = fBundle.getEntry(unitBundleRelativePath.toString());
			if (unitURL == null) {
				return null;
			}
		
			IPath unitAbsolutePath = new Path(fBundle.getSymbolicName()).append(unitBundleRelativePath);
			URI unitURI = URI.createPlatformPluginURI(unitAbsolutePath.toString(), false);
			String[] segments = ResolverUtils.getNameSegments(qualifiedName);
			String namespace = null;
			if (segments.length > 1) {
				namespace = ResolverUtils.toQualifiedName(segments, 0, segments.length - 2);
			}

			String name = segments[segments.length - 1];
			return new BundleUnit(namespace, name, unitURI, unitURL);			
		}
		
		return null;
	}

	public static void setupResolver(PlatformPluginUnitResolver resolver, boolean useBlackbox, boolean useDeployed) {
		if(useBlackbox && !useDeployed) {
			resolver.setParent(BlackboxUnitResolver.DEFAULT);
		} else if(useBlackbox && useDeployed) {
			resolver.setParent(new CompositeUnitResolver(
					DeployedImportResolver.INSTANCE, 
					BlackboxUnitResolver.DEFAULT));
		}		
	}
	
	public static UnitProxy getUnit(URI uri) {
		if (!uri.isPlatformPlugin() || uri.segmentCount() < 2) {
			return null;
		}

		String bundleId = uri.segment(1);
		Bundle bundle = Platform.getBundle(bundleId);
		if (bundle == null) {
			return null;
		}

		IPath path = new Path(uri.toPlatformString(true));
		IPath pluginRelativePath = path.removeFirstSegments(1).removeFileExtension();
		
		PlatformPluginUnitResolver resolver = new PlatformPluginUnitResolver(bundle);
		PlatformPluginUnitResolver.setupResolver(resolver, true, true);
		
		return resolver.resolveUnit(ResolverUtils.toQualifiedName(pluginRelativePath));
	}

	// FIXME - make shared unit class with BundleUnitResolver.BundleUnit
	private final class BundleUnit extends UnitProxy {

		private final URL url;

		private BundleUnit(String namespace, String unitName, URI unitURI,
				URL unitURL) {
			super(namespace, unitName, unitURI);
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
					URLConnection connection = url.openConnection();

					String charset = connection.getContentEncoding();
					if (charset == null) {
						charset = "UTF-8"; //$NON-NLS-1$
					}

					return new InputStreamReader(connection.getInputStream(),
							charset);
				}
			};
		}

		@Override
		public UnitResolver getResolver() {
			return PlatformPluginUnitResolver.this;
		}
	}
}
