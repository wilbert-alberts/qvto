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

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * A feature to hold a collection of objects
 * @author abreslav
 */
public class MapFeature<K, V> extends ObjectFeature<Map<K, V>> {

    /**
     * @param container
     *              A collection object that will actually store all the values
     *              provided as an opportunity to choose between Set and List and different 
     *              implementations
     * @param elementType
     *          <T>.class
     */
    public MapFeature(Map<K, V> container, Class<V> elementType) {
        super(Map.class, container);
        myContainer = new Implementation(container);
        myElementType = elementType;
    }

    /**
     * @return a stored collection which is modifyable and the modifications
     * cause notifications to listeners and validators
     */
    @Override
    public Map<K, V> getValue() {
        return myContainer;
    }
    
    public Class<V> getElementType() {
        return myElementType;
    }
    
    /**
     * @deprecated Never call directly
     */
    @SuppressWarnings("unchecked")
	@Override
    @Deprecated
    public void setUntypedValue(Object value) {
        if (value instanceof Collection) {
            setValue((Map<K, V>) value);
        } else {
            throw new UnsupportedOperationException();
        }
    }
    
    /**
     * Replaces the stored content with the content of a given collection
     */
    @Override
	public void setValue(Map<K, V> value) {
        setSilent(true);
        int size = myContainer.size();
        myContainer.clear();
        myContainer.putAll(value);
        setSilent(false);
        if (size > 0 || !value.isEmpty()) {
            notifyListeners();
        }
    }
    
    /**
     * Internal map adapter. Used to provide callbacks. 
     */
    protected class Implementation implements Map<K, V> {
        
        private final Map<K, V> myContainer;
        
        public Implementation(Map<K, V> container) {
            myContainer = container;
        }

        public void clear() {
            if (!isEmpty()) {
                myContainer.clear();
                notifyListeners();
            }            
        }

        public boolean containsKey(Object key) {            
            return myContainer.containsKey(key);
        }

        public boolean containsValue(Object value) {
            return myContainer.containsValue(value);
        }

        public Set<java.util.Map.Entry<K, V>> entrySet() {
            return myContainer.entrySet();
        }

        public V get(Object key) {
            return myContainer.get(key);
        }

        public boolean isEmpty() {
            return myContainer.isEmpty();
        }

        public Set<K> keySet() {
            return myContainer.keySet();
        }

        public V put(K key, V value) {
            V v = myContainer.put(key, value);
            if (v != null) {
                notifyListeners();
            }
            return v;
        }

        public void putAll(Map<? extends K, ? extends V> t) {
            myContainer.putAll(t);
            if (!t.isEmpty()) {
                notifyListeners();
            }
        }

        public V remove(Object key) {
            V remove = myContainer.remove(key);
            if (remove != null) {
                notifyListeners();
            }
            return remove;
        }

        public int size() {
            return myContainer.size();
        }

        public Collection<V> values() {
            return myContainer.values();
        }
    }

    protected Implementation myContainer;
    private final Class<V> myElementType;    
}
