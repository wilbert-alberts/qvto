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
 * Created on Apr 7, 2005
 */
package org.eclipse.m2m.qvt.oml.ocl.mapping;

import java.util.Collection;

import org.eclipse.m2m.qvt.oml.ocl.preferences.Registry;


public interface NameMappingRegistry extends Registry {
    
    Collection getNameMappings();
    
    NameMapping createNameMapping();
    
    void removeNameMapping(NameMapping mapping);
    
    String map(String name);
    
    void addListener(NameMappingRegistryListener listener);
    
    void removeListener(NameMappingRegistryListener listener);
    
    void fireRegistryChanged();

}
