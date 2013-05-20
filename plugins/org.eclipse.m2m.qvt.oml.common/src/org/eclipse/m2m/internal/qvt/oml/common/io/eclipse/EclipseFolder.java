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
package org.eclipse.m2m.internal.qvt.oml.common.io.eclipse;

import java.io.IOException;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;


public class EclipseFolder extends EclipseContainer {
	EclipseFolder(IFolder folder) {
		super(folder);
	}
	
	public void create() throws IOException {
		try {
			if(!getParent().exists()) {
				getParent().create();
			}
			
			getFolder().create(true, false, null);
		}
		catch (CoreException e) {
			IOException io = new IOException();
			io.initCause(e);
			throw io;
		}
	}
	
	public IFolder getFolder() {
		return (IFolder)myResource;
	}
}
