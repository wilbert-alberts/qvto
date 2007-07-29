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
package org.eclipse.m2m.internal.qvt.oml.common.model;

/**
 * A feature that stores a single object
 * @author abreslav
 *
 * @param <T>
 *              The type of the object stored
 */
public class ObjectFeature<T> extends ValidatableFeature {
    /**
     * @param type
     *              a class of stored values (actually StoredType.class)
     * @param defaultValue
     *              a default value to use in getValue() when the fature is not set 
     */
    public ObjectFeature(Class type, T defaultValue) {
        myType = type;
        myDefaultValue = defaultValue;
    }
    
    public ObjectFeature(Class type) {
        this(type, null);
    }
    
    /**
     * @return pure field value
     */
    protected final Object getStoredValue() {
        return myValue;
    }
    
    @SuppressWarnings("unchecked")
	public T getValue() {
    	myType.cast(null);
        T result = myType.isInstance(myValue) ? (T) myValue : null;
        return isSet() ? result : getDefaultValue();
    }
    
    protected boolean equals(Object a, Object b) {
        if (a == b) {
            return true;
        }
        if (a != null) {
            return a.equals(b);
        } else {
            return b.equals(a);
        }
    }
    
    /**
     * Sets the value from object. The value can have the wrong type,
     * then the feature is considered not to be set
     * @param value
     */
    public void setUntypedValue(Object value) {
        if (!equals(value, myValue)) {
            myValue = value;
            notifyListeners();
        }
    }
    
    public void setValue(T value) {
        setUntypedValue(value);
    }
    
    /**
     * Set the value without notifying listeners
     */
    public void silentSetValue(T value) {
        setSilent(true);
        setValue(value);
        setSilent(false);
    }
    
    public void setDefaultValue(T defaultValue) {
        if (!equals(myDefaultValue, defaultValue)) {
            myDefaultValue = defaultValue;
            notifyListeners();
        }
    }

    /**
     * Set the default value without notifying listeners
     */
    public void silentSetDefaultValue(T defaultValue) {
        setSilent(true);
        setDefaultValue(defaultValue);
        setSilent(false);
    }
    
    public T getDefaultValue() {
        return myDefaultValue;
    }
    
    @Override
    public boolean isSet() {
        return myValue != null;
    }
    
    protected Class getType() {
        return myType;
    }

    private Object myValue;
    private Class myType;
    private T myDefaultValue;    
}
