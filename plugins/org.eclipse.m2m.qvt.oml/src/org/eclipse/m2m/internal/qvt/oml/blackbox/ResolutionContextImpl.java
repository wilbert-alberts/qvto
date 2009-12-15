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
package org.eclipse.m2m.internal.qvt.oml.blackbox;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.osgi.framework.Bundle;

/**
 * FIXME - temp solution due to #264335, mixing CFile, URI based context 
 */
public class ResolutionContextImpl implements ResolutionContext {
	
	private URI fURI;	
	
	public ResolutionContextImpl(URI contextURI) {
		if(contextURI == null) {
			throw new IllegalArgumentException();
		}
		
		fURI = contextURI;
	}
	

	public <T> T getAdapter(Class<T> adapterType) {
		// FIXME - revisit this class, we do not need this dependency in this plugin
		if(EMFPlugin.IS_ECLIPSE_RUNNING) {
			return Eclipse.getAdapter(fURI, adapterType);
		}
			
		return null;
	}
	
	@Override
	public String toString() {	
		return "Resolution context (" + fURI.toString() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	private static class Eclipse {		
		
		static <T> T getAdapter(URI contextURI, Class<T> adapterType) {		
			if (adapterType == IProject.class) {
				if (contextURI.isPlatformResource()) {
					String wsFullPath = contextURI.toPlatformString(true);
					IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(wsFullPath);
					if (resource != null) {
						return adapterType.cast(resource.getProject());
					}
				}
			} else if (adapterType == Bundle.class) {
				if (contextURI.isPlatformPlugin()) {
					if (contextURI.segmentCount() > 1) {
						String bundleID = contextURI.segment(1);
						Bundle bundle = Platform.getBundle(bundleID);
						return (bundle != null) ? adapterType.cast(bundle) : null;
					}
				}
			}
			return null;
		}
	}
}
