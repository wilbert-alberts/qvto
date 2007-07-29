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

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/**
 * A feature to hold a collection of objects
 * @author abreslav
 *
 * @param <T>
 */
public class ManyObjectFeature<T> extends ObjectFeature<Collection<T>> {

    /**
     * @param container
     *              A collection object that will actually store all the values
     *              provided as an opportunity to choose between Set and List and different 
     *              implementations
     * @param elementType
     *          <T>.class
     */
    public ManyObjectFeature(Collection<T> container, Class<T> elementType) {
        super(Collection.class, container);
        myContainer = new Implementation(container);
        myElementType = elementType;
    }

    /**
     * @return a stored collection which is modifyable and the modifications
     * cause notifications to listeners and validators
     */
    @Override
    public Collection<T> getValue() {
        return myContainer;
    }
    
    public Class<T> getElementType() {
        return myElementType;
    }
    
    /**
     * @return stored values as an array of myElementType
     */
    @SuppressWarnings("unchecked")
	public T[] getArrayValue() {
        return getValue().toArray((T[])Array.newInstance(getElementType(), getValue().size()));
    }
    
    /**
     * @deprecated Never call directly
     */
    @SuppressWarnings("unchecked")
	@Override
    @Deprecated
    public void setUntypedValue(Object value) {
        if (value instanceof Collection) {
            setValue((Collection<T>) value);
        } else {
            throw new UnsupportedOperationException();
        }
    }
    
    /**
     * Replaces the stored content with the content of a given collection
     */
    @Override
	public void setValue(Collection<T> value) {
        setSilent(true);
        int size = myContainer.size();
        myContainer.clear();
        boolean changed = myContainer.addAll(value);
        setSilent(false);
        if (size > 0 || changed) {
            notifyListeners();
        }
    }
    
    /**
     * Internal collection adapter. Used to provide callbacks. 
     */
    protected class Implementation implements Collection<T> {
        
        private final Collection<T> myContainer;
        
        public Implementation(Collection<T> container) {
            myContainer = container;
        }
        
        public boolean add(T o) {
            boolean change = myContainer.add(o);
            if (change) {
                notifyListeners();
            }
            return change;
        }
    
        public boolean addAll(Collection<? extends T> c) {
            boolean change = myContainer.addAll(c);
            if (change) {
                notifyListeners();
            }
            return change;
        }
    
        public void clear() {
            if (!isEmpty()) {
                notifyListeners();
            }
            myContainer.clear();
        }
    
        public boolean contains(Object o) {
            return myContainer.contains(o);
        }
    
        public boolean containsAll(Collection<?> c) {
            return myContainer.containsAll(c);
        }
    
        public boolean isEmpty() {
            return myContainer.isEmpty();
        }
    
        public Iterator<T> iterator() {
            return myContainer.iterator();
        }
    
        public boolean remove(Object o) {
            boolean change = myContainer.remove(o);
            if (change) {
                notifyListeners();
            }
            return change;
        }
    
        public boolean removeAll(Collection<?> c) {
            boolean change = myContainer.removeAll(c);
            if (change) {
                notifyListeners();
            }
            return change;
        }
    
        public boolean retainAll(Collection<?> c) {
            boolean change = myContainer.retainAll(c);
            if (change) {
                notifyListeners();
            }
            return change;
        }
    
        public int size() {
            return myContainer.size();
        }
    
        public Object[] toArray() {
            return myContainer.toArray();
        }
    
        public <Tt> Tt[] toArray(Tt[] a) {
            return myContainer.toArray(a);
        }
    }

    protected Implementation myContainer;
    private final Class<T> myElementType;    
}
