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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Platform;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.BundleFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.EclipseFile;
import org.osgi.framework.Bundle;

public class ResolutionContextImpl implements ResolutionContext {
	
	private CFile fFile;	
	
	public ResolutionContextImpl(CFile cFile) {
		if(cFile == null) {
			throw new IllegalArgumentException();
		}
		
		fFile = cFile;
	}
		
	public <T> T getAdapter(Class<T> adapterType) {
		if(fFile == null) {
			return null;
		}

		if(adapterType == Bundle.class) {
			if(fFile instanceof BundleFile) {
				BundleFile bundleFile = (BundleFile) fFile;
				String bundleId = bundleFile.getBundleSymbolicName();
				Bundle bundle = Platform.getBundle(bundleId);
				return adapterType.cast(bundle);
			}
		}
		else if(adapterType == IProject.class) {
			if(fFile instanceof EclipseFile) {
				return adapterType.cast(((EclipseFile)fFile).getFile().getProject());
			}
		} 
		return null;
	}
	
	@Override
	public String toString() {	
		return "Resolution context (" + fFile.toString() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
	}
}
