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
import java.util.List;
import java.util.ListIterator;

public class OrderedManyObjectFeature<T> extends ManyObjectFeature<T> {

    public OrderedManyObjectFeature(List<T> container, Class<T> elementType) {
        super(container, elementType);
        myContainer = new OrderedImplementation(container);
    }
    
    @Override
    public List<T> getValue() {
        return (List<T>) super.getValue();
    }
    
    protected class OrderedImplementation extends Implementation implements List<T> {

        private List<T> myContainer;

        public OrderedImplementation(List<T> container) {
            super(container);
            myContainer = container;
        }

        public void add(int index, T element) {
            myContainer.add(index, element);
            notifyListeners();
        }

        public boolean addAll(int index, Collection<? extends T> c) {
            boolean changed = myContainer.addAll(index, c);
            if (changed) {
                notifyListeners();
            }
            return changed;
        }

        public T get(int index) {
            return myContainer.get(index);
        }

        public int indexOf(Object o) {
            return myContainer.indexOf(o);
        }

        public int lastIndexOf(Object o) {
            return myContainer.lastIndexOf(o);
        }

        public ListIterator<T> listIterator() {
            return myContainer.listIterator();
        }

        public ListIterator<T> listIterator(int index) {
            return myContainer.listIterator(index);
        }

        public T remove(int index) {
            T t = myContainer.remove(index);
            notifyListeners();
            return t;
        }

        public T set(int index, T element) {
            T t = myContainer.set(index, element);
            notifyListeners();
            return t;
        }

        public List<T> subList(int fromIndex, int toIndex) {
            return myContainer.subList(fromIndex, toIndex);
        }
        
    }

}
