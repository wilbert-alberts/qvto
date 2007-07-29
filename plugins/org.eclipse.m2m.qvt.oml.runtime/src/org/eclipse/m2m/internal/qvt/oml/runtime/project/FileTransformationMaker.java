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
package org.eclipse.m2m.internal.qvt.oml.runtime.project;

import org.eclipse.core.resources.IFile;
import org.eclipse.m2m.qvt.oml.emf.util.WorkspaceUtils;

public abstract class FileTransformationMaker implements ITransformationMaker {

    public final QvtTransformation makeTransformation(String name) {
        IFile qvtFile = WorkspaceUtils.getWorkspaceFile(name);
        if (qvtFile != null && qvtFile.exists()) {
            return doCreateTransformation(qvtFile);
        }
        return null;
    }

    protected abstract QvtTransformation doCreateTransformation(IFile qvtFile);

}
