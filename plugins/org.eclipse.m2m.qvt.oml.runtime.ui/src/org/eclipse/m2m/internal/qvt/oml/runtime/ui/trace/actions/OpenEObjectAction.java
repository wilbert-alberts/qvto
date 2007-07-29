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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.action.Action;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.presentation.EObjectNode;
import org.eclipse.m2m.qvt.oml.common.Logger;
import org.eclipse.m2m.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.IMetamodelHandler;
import org.eclipse.m2m.qvt.oml.emf.util.ui.choosers.MetamodelHandlerManager;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IWorkbenchPage;

public class OpenEObjectAction extends Action {
    private final IWorkbenchPage myPage;
    private final Tree myTree;

    public OpenEObjectAction(IWorkbenchPage page, Tree tree) {
        myPage = page;
        myTree = tree;
    }
    
    @Override
	public void run() {
        TreeItem[] selection = myTree.getSelection();
        for (TreeItem treeItem : selection) {
            Object data = treeItem.getData();
            if (data instanceof EObjectNode) {
                EObjectNode eObjectNode = (EObjectNode) data;
                EObject eObject = eObjectNode.getObject();
                EPackage ePackage = eObject.eClass().getEPackage();
                String nsURI = EmfUtil.getRootPackage(ePackage).getNsURI();
                IMetamodelHandler handler = MetamodelHandlerManager.getInstance().getHandler(nsURI);
                try {
                    handler.getSaver().select(eObject, myPage);
                } 
                catch (Exception e) {
                    Logger.getLogger().log(Logger.SEVERE, "Failed to select " + eObject + " using " + handler, e);  //$NON-NLS-1$//$NON-NLS-2$
                }
            }
        }
   }
}