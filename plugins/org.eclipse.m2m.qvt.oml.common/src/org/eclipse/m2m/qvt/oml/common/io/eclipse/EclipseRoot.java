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
package org.eclipse.m2m.qvt.oml.common.io.eclipse;

import java.io.IOException;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.m2m.qvt.oml.common.io.CFolder;


public class EclipseRoot extends EclipseContainer implements CFolder {
	EclipseRoot(IWorkspaceRoot root) {
		super(root);
	}
	
	public void create() throws IOException {
        throw new UnsupportedOperationException();
	}
}
