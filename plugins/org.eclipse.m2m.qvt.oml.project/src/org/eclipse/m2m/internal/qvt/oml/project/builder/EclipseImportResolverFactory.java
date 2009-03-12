/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation
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
import org.eclipse.m2m.internal.qvt.oml.compiler.IImportResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.IImportResolverFactory;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolver;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.m2m.internal.qvt.oml.project.QVTOProjectPlugin;


public class EclipseImportResolverFactory implements IImportResolverFactory {
	
	public EclipseImportResolverFactory() {	
	}
	
	public boolean isAccepted(Object source) {
		if(source instanceof IResource) {
			return true;
		}
		
		if(source instanceof URI) {
			URI uri = (URI) source;
			return uri.isPlatformPlugin();
		}
		
		return false;
	}

	public UnitProxy findUnit(URI unitURI) {
		if(unitURI.isPlatformResource()) {
			IFile file = URIUtils.getFile(unitURI);
			if(file != null) {
				return WorkspaceUnitResolver.getUnit(file);
			}
		} else if(unitURI.isPlatformPlugin()) {
			//return PlatformPluginUnitResolver.createUnit(unitURI);
		}
		
		return null;
	}
	
	public UnitResolver getResolver(URI uri) {
		IResource resource = URIUtils.getResource(uri);
		if(resource.exists()) {
			try {
				return WorkspaceUnitResolver.getResolver(resource.getProject());
			} catch (CoreException e) {
				QVTOProjectPlugin.log(e);
			}
		}
		
		return null; 
	}
	
	public IImportResolver createResolver(Object source) {
		if(isAccepted(source)) {
			IResource resource = (IResource) source;
			return new EclipseImportResolver(resource.getProject());
		}
		throw new IllegalArgumentException("Invalid source object for import resolver:" + source); //$NON-NLS-1$
	}
}
