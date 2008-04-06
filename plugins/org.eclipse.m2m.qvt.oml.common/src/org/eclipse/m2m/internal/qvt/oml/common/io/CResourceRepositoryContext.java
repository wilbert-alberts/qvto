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
package org.eclipse.m2m.internal.qvt.oml.common.io;

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider.IRepositoryContext;

public class CResourceRepositoryContext implements IRepositoryContext {
	private CResource resource;
	
	public CResourceRepositoryContext(CResource resource) {
		this.resource = resource;
	}

	public URI getURI() {
		String fullPath = resource.getFullPath();
		try {
			return URI.createFileURI(fullPath);
		} catch (IllegalArgumentException e) {
			// fall-back to global context
		}
		return IMetamodelRegistryProvider.GLOBAL_CONTEXT;
	}
}
