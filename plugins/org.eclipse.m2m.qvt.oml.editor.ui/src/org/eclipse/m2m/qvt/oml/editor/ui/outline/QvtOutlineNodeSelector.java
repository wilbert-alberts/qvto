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
package org.eclipse.m2m.qvt.oml.editor.ui.outline;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.m2m.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.ocl.internal.cst.CSTNode;



public class QvtOutlineNodeSelector {
	public QvtOutlineNodeSelector(final TreeViewer viewer) {
		myViewer = viewer;
		myContentProvider = (QvtOutlineContentProvider)myViewer.getContentProvider();
	}
	
    public void selectCorrespondingNode(final TextSelection selection) {
    	OutlineNode nodeToSelect = null;
    	Object[] roots = ((QvtOutlineInput) myViewer.getInput()).getChildren();
    	for (int i = 0; i < roots.length; i++) {
    		nodeToSelect = findCorrespondingNode((OutlineNode)roots[i], selection);
    		if (nodeToSelect != null) {
    			break;
    		}
    	}
    	
    	select(nodeToSelect);
    }
    
	private void select(OutlineNode node) {
		ISelection currentSelection = myViewer.getSelection();
		if (currentSelection instanceof IStructuredSelection) {
			IStructuredSelection ss = (IStructuredSelection)currentSelection;
			List<?> elements = ss.toList();
			if (!elements.contains(node)) {
                //if(node == null) {
                //    node = getRulesNode(myViewer.getInput());
                //}

                if(node != null) {
                    myViewer.setSelection(new StructuredSelection(node), false);
                }
			}
		}
	}
    
    private OutlineNode findCorrespondingNode(final OutlineNode root, final TextSelection selection) {
    	Object[] children = myContentProvider.getChildren(root);
    	for (int i = 0; i < children.length; i++) {
    		OutlineNode node = (OutlineNode)children[i];
    		CSTNode elem = node.getSyntaxElement();
    		if (elem != null) {
    			CSTNode pos = (CSTNode) EcoreUtil.create(elem.eClass());
    			pos.setStartOffset(elem.getStartOffset());
    			pos.setEndOffset(elem.getEndOffset());
    			if (isInside(selection, pos)) {
    				return node;
    			}
    		}

    		OutlineNode subResult = findCorrespondingNode(node, selection);
    		if (subResult != null) {
    			return subResult;
    		}
    	}
    	
    	return null;
    }
    
    private boolean isInside(final TextSelection selection, final CSTNode elementPositions) {
    	return elementPositions.getStartOffset() <= selection.getOffset() && elementPositions.getStartOffset() + elementPositions.getEndOffset() >= selection.getOffset();
    }
    
	private final TreeViewer myViewer;
	private final QvtOutlineContentProvider myContentProvider;
}
