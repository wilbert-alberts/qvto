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
package org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.emf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree.ComparatorTreeNode;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree.ContentChange;
import org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree.NodeClassContentChange;


/** @author pkobiakov */
@SuppressWarnings("unchecked")
public class EmfFeatureMapReferenceComparatorTreeNode extends ComparatorTreeNode {
	public EmfFeatureMapReferenceComparatorTreeNode(ComparatorTreeNode parent, EAttribute attr, FeatureMap map) {
		super(parent);
        myAttr = attr;
        myMap = map;
	}

    @Override
	public List getChildrenImpl() {
        return getValues();
    }
    
    @Override
	public List getNoncontainmentRefsImpl() {
        return Collections.EMPTY_LIST;
    }
	

	public List getValues() {
		List emfChildren = new ArrayList();
		
		for(Iterator it = myMap.iterator(); it.hasNext(); ) {
            FeatureMap.Entry entry = (Entry) it.next();
            if(entry.getEStructuralFeature() instanceof EReference == false) {
                continue;
            }
            
		    Object value = entry.getValue();
            if(value instanceof Collection) {
                emfChildren.addAll((Collection)value);
            }
            else {
                emfChildren.add(value);
            }
        }
		
		List children = new ArrayList();
		for(Iterator childIt = emfChildren.iterator(); childIt.hasNext(); ) {
			EObject child = (EObject)childIt.next();
			children.add(new EmfObjectComparatorTreeNode(this, child));
		}
		
		return children;
	}
	
	@Override
	public ContentChange compareClassesImpl(ComparatorTreeNode to) {
		if(to instanceof EmfFeatureMapReferenceComparatorTreeNode == false) {
			return new NodeClassContentChange(this, to);
		}
		
		EmfFeatureMapReferenceComparatorTreeNode emfTo = (EmfFeatureMapReferenceComparatorTreeNode)to;

		if(!myAttr.equals(emfTo.myAttr)) {
			return new AttrContentChange(myAttr.eContainer(), myAttr, this, to, 1);
		}
		
		return ContentChange.NULL_CHANGE;
	}

	@Override
	public ContentChange compareAttributesImpl(ComparatorTreeNode to) {
		return ContentChange.NULL_CHANGE;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof EmfFeatureMapReferenceComparatorTreeNode == false) {
			return false;
		}
		
		EmfFeatureMapReferenceComparatorTreeNode node = (EmfFeatureMapReferenceComparatorTreeNode)o;
		boolean eq = myAttr.equals(node.myAttr);
		return eq;
		
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	
	@Override
	public String toString() {
		return "fm-ref:" + myAttr.getName(); //$NON-NLS-1$ 
	}
    
    private final EAttribute myAttr;
    private final FeatureMap myMap;
}
