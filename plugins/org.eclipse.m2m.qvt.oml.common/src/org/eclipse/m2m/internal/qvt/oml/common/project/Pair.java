/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.common.project;

class Pair<A, B> {
    
    public Pair(A a, B b) {
        myFirst = a;
        mySecond = b;
    }
            
    public A getFirst() {
        return myFirst;
    }
    
    public B getSecond() {
        return mySecond;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pair<?, ?> == false) {
            return false;
        }
        Pair<?, ?> p = (Pair<?, ?>) obj; 
        return getFirst().equals(p.getFirst()) && getSecond().equals(p.getSecond());
    }
    
    @Override
    public int hashCode() {
        int result = 13;
        if (getFirst() != null) {
            result += 37 * getFirst().hashCode();
        }
        if (getSecond() != null) {
            result += 37 * getSecond().hashCode();
        }
        return result;
    }
    
    private A myFirst;
    private B mySecond;
}