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
/*
 * Created on Mar 30, 2005
 */
package org.eclipse.m2m.qvt.oml.ocl.preferences;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RegistryElementImpl implements RegistryElement {
    
    private String myType;
    
    private Map<String, List<RegistryElement>> myCollections = new HashMap<String, List<RegistryElement>>();
    
    public RegistryElementImpl(String type) {
        myType = type;
    }

    public String getType() {
        return myType;
    }

    public Collection<RegistryElement> getSubElements(String type) {
        if (!myCollections.containsKey(type)) {
            myCollections.put(type, new LinkedList<RegistryElement>());
        }
        return myCollections.get(type);
    }

    public void addElement(RegistryElement element) {
        getSubElements(element.getType()).add(element);
    }

    public void removeElement(RegistryElement element) {
        getSubElements(element.getType()).remove(element);
    }
    
    public void clear() {
        myCollections.clear();
    }

}
