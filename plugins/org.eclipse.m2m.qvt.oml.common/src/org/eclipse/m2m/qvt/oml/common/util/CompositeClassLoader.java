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
package org.eclipse.m2m.qvt.oml.common.util;

/**
 * @author strizhkin
 */
public class CompositeClassLoader extends ClassLoader {
    private ClassLoader[] myClassLoaders;
    public CompositeClassLoader(ClassLoader[] classLoaders) {
        myClassLoaders = classLoaders; 
    }
    
    public CompositeClassLoader(ClassLoader[] classLoaders, ClassLoader parent) {
        super(parent);
        myClassLoaders = classLoaders; 
    }
    
    @Override
	public Class<?> findClass(String className) throws ClassNotFoundException {
        ClassLoader parent = getParent();
        if(parent != null) {
            try {
                Class c = parent.loadClass(className);
            	return c;
            } catch (ClassNotFoundException e) {
            }
        }
        
        for(int i = 0; i < myClassLoaders.length; i++) {
            ClassLoader loader = myClassLoaders[i];
            try {
                Class c = loader.loadClass(className);
            	return c;
            } catch (ClassNotFoundException e) {
            }
        }
            
        throw new ClassNotFoundException(className);
    }
}
