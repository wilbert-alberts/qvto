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

import org.eclipse.core.resources.IFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.CFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.BundleFile;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.EclipseFile;

public class ResolutionContextImpl implements ResolutionContext {
	
	private CFile fFile;	
	
	public ResolutionContextImpl(CFile cFile) {
		if(cFile == null) {
			throw new IllegalArgumentException();
		}
		
		fFile = cFile;
	}
		
	@Override
	public <T> T getAdapter(Class<T> adapterType) {
		if(fFile == null) {
			return null;
		}
		
		if(adapterType == BundleFile.class) {
			if(fFile instanceof EclipseFile) {
				return adapterType.cast(fFile);
			}
		}
		else if(adapterType == IFile.class) {
			if(fFile instanceof EclipseFile) {
				return adapterType.cast(((EclipseFile)fFile).getFile());
			}
		} 
		return null;
	}
}
