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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.m2m.qvt.oml.common.ui.action.ObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.IDE;

public class ShowTraceViewAction extends ObjectActionDelegate {
    @Override
	public void runImpl(IAction action) throws Exception {
        IFile file = (IFile)((StructuredSelection)getSelection()).getFirstElement();
        if (file == null) {
            return;
        }
        
        IWorkbenchPage page = getPart().getSite().getPage();
        IDE.openEditor(page, file, true);
    }
}
