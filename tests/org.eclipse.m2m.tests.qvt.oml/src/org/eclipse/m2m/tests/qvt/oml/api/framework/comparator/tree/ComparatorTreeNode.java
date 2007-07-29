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
package org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.edit.CompositeEdit;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.edit.DeleteNodeEdit;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.edit.InsertNodeEdit;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.edit.TreeEdit;


/** @author pkobiakov */
@SuppressWarnings("unchecked")
public abstract class ComparatorTreeNode {
	public ComparatorTreeNode(ComparatorTreeNode parent) {
		myParent = parent;
		
		myChildren = null;
		myNoncontainmentRefs = null;
		
		myCumulativeInsertEdits = null;
		myCumulativeDeleteEdits = null;
	}
	
	public ComparatorTreeNode getParent() { return myParent; }
	
	public abstract List getChildrenImpl();
	public abstract List getNoncontainmentRefsImpl();
	
	public abstract ContentChange compareClassesImpl(ComparatorTreeNode to);
	public abstract ContentChange compareAttributesImpl(ComparatorTreeNode to);
	
	public List getChildren() {
		if(myChildren == null) {
			myChildren = makeSortedList(getChildrenImpl());
		}
		
		return myChildren;
	}
	
	public List getNoncontainmentReferences() {
		if(myNoncontainmentRefs == null) {
			myNoncontainmentRefs = makeSortedList(getNoncontainmentRefsImpl());
		}
		
		return myNoncontainmentRefs;
	}
	
	private static List makeSortedList(List refs) {
		if(refs == null) {
			return Collections.EMPTY_LIST;
		}
		
		Collections.sort(refs, new ContentChangeComparator());
		return refs;
	}
	
	public ContentChange getChange(ComparatorTreeNode to) {
		if(!getClass().equals(to.getClass())) {
			return new NodeClassContentChange(this, to);
		}
		
		ContentChange change = compareClassesImpl(to);
		if(change.getCost() != 0) {
			return change;
		}
		
		change = compareAttributesImpl(to);
		if(change.getCost() != 0) {
			return change;
		}
		
		return ContentChange.NULL_CHANGE;
	}
	
	public TreeEdit getInsertEdit() {
		return new InsertNodeEdit(this, myParent); 
	}
	
	public TreeEdit getDeleteEdit() {
		return new DeleteNodeEdit(this, myParent);
	}
	
	public TreeEdit getCumulativeInsertEdit() {
		if(myCumulativeInsertEdits == null) {
			List edits = new ArrayList();
			edits.add(getInsertEdit());
			for(Iterator childIt = getChildren().iterator(); childIt.hasNext(); ) {
				ComparatorTreeNode child = (ComparatorTreeNode)childIt.next();
				edits.add(child.getCumulativeInsertEdit());
			}
			myCumulativeInsertEdits = new CompositeEdit(edits);
		}		
		return myCumulativeInsertEdits;
	}
	
	public TreeEdit getCumulativeDeleteEdit() {
		if(myCumulativeDeleteEdits == null) {
			List edits = new ArrayList();
			for(Iterator childIt = getChildren().iterator(); childIt.hasNext(); ) {
				ComparatorTreeNode child = (ComparatorTreeNode)childIt.next();
				edits.add(child.getCumulativeDeleteEdit());
			}
			edits.add(getDeleteEdit());
			myCumulativeDeleteEdits = new CompositeEdit(edits);
		}		
		return myCumulativeDeleteEdits;
	}
	
	static class ContentChangeComparator implements Comparator {
		public int compare(Object l, Object r) {
			ComparatorTreeNode left = (ComparatorTreeNode)l;
			ComparatorTreeNode right = (ComparatorTreeNode)r;
			
			ContentChange change = left.getChange(right);
			return change.getCmp();
		}
	}
	
	private final ComparatorTreeNode  myParent;
	private List myChildren;  
	private List myNoncontainmentRefs;
	private TreeEdit  myCumulativeInsertEdits;
	private TreeEdit  myCumulativeDeleteEdits;
}
