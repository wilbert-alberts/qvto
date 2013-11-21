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
package org.eclipse.m2m.internal.qvt.oml.common.launch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;

public class InMemoryLaunchUtils {
    private InMemoryLaunchUtils() {}
    
    public static Object getAttribute(ILaunchConfiguration config, String name) throws CoreException {
        Object value = config.getAttributes().get(name);
        if(value instanceof Collection<?> == false) {
        	return value;
        }
        
        Collection<?> listValue = (Collection<?>) value;
        if(listValue.isEmpty()) {
            return null;
        }
        
        if(listValue.size() != 1) {
            throw new IllegalArgumentException("Invalid value for " + name + ": " + value); //$NON-NLS-1$ //$NON-NLS-2$
        }
        
        return listValue.iterator().next();
    }
    
    public static void setAttribute(ILaunchConfigurationWorkingCopy config, String name, String value) {
        List<String> list;
        if(value == null) {
            list = Collections.<String>emptyList(); 
        }
        else {
            list = new ArrayList<String>();
            list.add(String.valueOf(value));
        }
        
        config.setAttribute(name, list);
    }
}
