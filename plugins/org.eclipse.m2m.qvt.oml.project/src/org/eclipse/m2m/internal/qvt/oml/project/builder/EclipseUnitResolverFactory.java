/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.compiler.BlackboxUnitResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.URIUnitResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolverFactory;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.m2m.internal.qvt.oml.project.QVTOProjectPlugin;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.DeployedImportResolver;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.PlatformPluginUnitResolver;

public class EclipseUnitResolverFactory implements UnitResolverFactory {

	public EclipseUnitResolverFactory() {
	}

	public boolean isAccepted(Object source) {
		if (source instanceof IResource) {
			return true;
		}

		if (source instanceof URI) {
			return true;
		}

		return false;
	}

	public UnitProxy findUnit(URI unitURI) {
		if (unitURI.isPlatformResource()) {
			IFile file = URIUtils.getFile(unitURI);
			if (file != null) {
				return WorkspaceUnitResolver.getUnit(file);
			}
		} else if (unitURI.isPlatformPlugin()) {
			return PlatformPluginUnitResolver.getUnit(unitURI);
		} else if (BlackboxUnitResolver.isBlackboxUnitURI(unitURI)) {
			return BlackboxUnitResolver.getUnit(unitURI);
		} else if (isWorkspacePath(unitURI)) {
				URI platformResourceURI = URI.createPlatformResourceURI(unitURI
						.path(), false);
				IFile file = URIUtils.getFile(platformResourceURI);
				if (file != null) {
					return WorkspaceUnitResolver.getUnit(file);
				}
		} else if (isDeployedByID(unitURI)) {
			return DeployedImportResolver.INSTANCE
					.resolveDeployedUnitOnly(unitURI.path());
		} else {
			return URIUnitResolver.getUnit(unitURI);
		}

		return null;
	}

	public UnitResolver getResolver(URI uri) {
		IResource resource = URIUtils.getResource(uri);
		if (resource.exists()) {
			try {
				return WorkspaceUnitResolver.getResolver(resource.getProject());
			} catch (CoreException e) {
				QVTOProjectPlugin.log(e);
			}
		}

		return null;
	}

	private static boolean isWorkspacePath(URI uri) {
		return uri.scheme() == null && !uri.hasDevice() && !uri.hasAuthority()
				&& !uri.hasEmptyPath() && !uri.hasQuery() && !uri.hasFragment()
				&& uri.hasAbsolutePath();
	}

	private static boolean isDeployedByID(URI uri) {
		return uri.scheme() == null && !uri.hasDevice() && !uri.hasAuthority()
				&& !uri.hasEmptyPath() && !uri.hasQuery() && !uri.hasFragment()
				&& !uri.hasAbsolutePath();
	}
}
