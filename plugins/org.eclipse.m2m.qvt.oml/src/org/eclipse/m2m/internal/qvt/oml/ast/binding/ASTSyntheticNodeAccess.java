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
package org.eclipse.m2m.internal.qvt.oml.ast.binding;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.cst.CSTNode;

public class ASTSyntheticNodeAccess {
	
	public static ASTSyntheticNode createASTNode(EObject element) {
		ASTSyntheticAdapter result = new ASTSyntheticAdapter();
		element.eAdapters().add(result);
		return result;
	}
	
	public static void setCST(ASTSyntheticNode astNode, CSTNode cstNode) {
		ASTSyntheticAdapter adapter = (ASTSyntheticAdapter) astNode;
		adapter.cstNode = cstNode;
	}
	
	public static <T extends CSTNode> T getCST(ASTSyntheticNode astNode, Class<T> type) {	
		ASTSyntheticAdapter adapter = (ASTSyntheticAdapter) astNode;
		if(type.isInstance(adapter.cstNode)) {
			return type.cast(adapter.cstNode);
		}
		return null;
	}
	
	public static ASTSyntheticNode getASTNode(EObject element) {
		return (ASTSyntheticNode) EcoreUtil.getExistingAdapter(element, ASTSyntheticAdapter.class);
	}
	
	private static class ASTSyntheticAdapter extends AdapterImpl implements ASTSyntheticNode {
		private CSTNode cstNode;
		private int fStartPos;		
		private int fEndOffset;
		
		@Override
		public boolean isAdapterForType(Object type) {
			return ASTSyntheticAdapter.class.equals(type);
		}
		
		public EObject getActualElement() {		
			return (EObject)getTarget();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTSyntheticNode#getStartOffset()
		 */
		public int getStartPosition() {
			return fStartPos;
		}
			
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTSyntheticNode#getEndOffset()
		 */
		public int getEndPosition() {
			return fEndOffset;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTSyntheticNode#setEndOffset(int)
		 */
		public void setEndPosition(int endOffset) {
			this.fEndOffset = endOffset;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTSyntheticNode#setStartOffset(int)
		 */
		public void setStartPosition(int startOffset) {
			this.fStartPos = startOffset;
		}
	}
}
