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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;

public class ShallowMarker implements IMarker {
    public ShallowMarker(String type) {
        myType = type;
        myAttributes = new HashMap<String, Object>();
        myCreationTime = System.currentTimeMillis();
    }
    
    public void delete() {
    }

    public boolean exists() {
        return true;
    }

    public Object getAttribute(String attributeName) {
        return myAttributes.get(attributeName);
    }

    public int getAttribute(String attributeName, int defaultValue) {
        Object attr = getAttribute(attributeName);
        if(attr instanceof Integer == false) {
            return defaultValue;
        }
        
        return ((Integer)attr).intValue();
    }

    public String getAttribute(String attributeName, String defaultValue) {
        Object attr = getAttribute(attributeName);
        if(attr instanceof String == false) {
            return defaultValue;
        }
        
        return (String)attr;
    }

    public boolean getAttribute(String attributeName, boolean defaultValue) {
        Object attr = getAttribute(attributeName);
        if(attr instanceof Boolean == false) {
            return defaultValue;
        }
        
        return ((Boolean)attr).booleanValue();
    }

    @SuppressWarnings("unchecked")
	public Map getAttributes() {
        return myAttributes;
    }

    public Object[] getAttributes(String[] attributeNames) {
        List<Object> attributes = new ArrayList<Object>();
        for (int i = 0; i < attributeNames.length; i++) {
            String attributeName = attributeNames[i];
            attributes.add(getAttribute(attributeName));
        }
        
        return attributes.toArray();
    }

    public long getCreationTime() {
        return myCreationTime;
    }

    public long getId() {
        return myCreationTime;
    }

    public IResource getResource() {
        return null;
    }

    public String getType() {
        return myType;
    }

    public boolean isSubtypeOf(String superType) {
        return false;
    }

    public void setAttribute(String attributeName, int value) {
        myAttributes.put(attributeName, new Integer(value));
        
    }

    public void setAttribute(String attributeName, Object value) {
        myAttributes.put(attributeName, value);
    }

    public void setAttribute(String attributeName, boolean value) {
        myAttributes.put(attributeName, Boolean.valueOf(value));
    }

    public void setAttributes(String[] attributeNames, Object[] values) {
        for (int i = 0; i < attributeNames.length; i++) {
            String attributeName = attributeNames[i];
            Object value = values[i];
            setAttribute(attributeName, value);
        }
    }

    @SuppressWarnings("unchecked")
	public void setAttributes(Map attributes) {
        myAttributes.clear();
        myAttributes.putAll(attributes);
    }

    @SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
        return null;
    }
    
    private final String myType;
    private final Map<String, Object> myAttributes;
    private final long myCreationTime;
}
