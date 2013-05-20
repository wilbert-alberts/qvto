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
package org.eclipse.m2m.internal.qvt.oml.common.io;

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider.IRepositoryContext;

public class CResourceRepositoryContext implements IRepositoryContext {
	private URI fUri;
	
	public CResourceRepositoryContext(URI uri) {
		if(uri == null) {
			throw new IllegalArgumentException();
		}
		
		this.fUri = uri;
	}

	public URI getURI() {
		return fUri;
	}
}
