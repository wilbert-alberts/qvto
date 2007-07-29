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

public interface RegistryElement {
    
    String getType();
    
    Collection<RegistryElement> getSubElements(String type);
    
    void addElement(RegistryElement element);
    
    void removeElement(RegistryElement element);
    
    void clear();

}
