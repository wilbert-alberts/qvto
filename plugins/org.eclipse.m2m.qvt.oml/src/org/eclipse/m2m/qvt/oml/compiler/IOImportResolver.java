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
package org.eclipse.m2m.qvt.oml.compiler;

import java.io.File;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.m2m.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.common.io.CFile;
import org.eclipse.m2m.qvt.oml.common.io.CFolder;
import org.eclipse.m2m.qvt.oml.common.io.IOFile;
import org.eclipse.m2m.qvt.oml.common.io.eclipse.EclipseFileUtil;


public class IOImportResolver implements IImportResolver {
	public IOImportResolver(File root) {
		myRoot = root;
	}
	
	public CFile resolveImport(String importedUnitName) {
        String path = importedUnitName.replace('.', '/');
        path += MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT;
        File file = new File(myRoot, path);
        if(!file.exists()) {
            return null;
        }
        
		return new IOFile(file);
	}
    
    public String getPackageName(CFolder folder) {
        IPath relPath = EclipseFileUtil.makeRelative(new Path(folder.getFullPath()), new Path(myRoot.getAbsolutePath()));
        return relPath.toOSString().replaceAll("[/\\\\]", "."); //$NON-NLS-1$ //$NON-NLS-2$
    }

	private File myRoot;
}
