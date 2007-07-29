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
package org.eclipse.m2m.qvt.oml.internal.ocl.mapping;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.m2m.qvt.oml.ocl.OclPlugin;
import org.eclipse.m2m.qvt.oml.ocl.mapping.NameMapping;
import org.eclipse.m2m.qvt.oml.ocl.mapping.NameMappingRegistry;
import org.eclipse.m2m.qvt.oml.ocl.mapping.NameMappingRegistryListener;
import org.eclipse.m2m.qvt.oml.ocl.preferences.AbstractRegistry;


public class NameMappingRegistryImpl extends AbstractRegistry implements NameMappingRegistry {
    
    private static final String PRESET_FILE_NAME = "nameMappingsInitializer.xml"; //$NON-NLS-1$
    private static final String PREFERENCES_PATH = "/NameMappingRegistry"; //$NON-NLS-1$
    private Set<NameMappingRegistryListener> myListeners = new HashSet<NameMappingRegistryListener>();

    public NameMappingRegistryImpl() {
        super(OclPlugin.getDefault().getBundle().getSymbolicName()
                + PREFERENCES_PATH, new NameMappingsFactory(), PRESET_FILE_NAME);
    }
    
    public Collection getNameMappings() {
        return getElements(NameMappingsFactory.NAME_MAPPING_TYPE);
    }
    
    public NameMapping createNameMapping() {
        NameMappingImpl mapping = (NameMappingImpl) createElement(NameMappingsFactory.NAME_MAPPING_TYPE);
        addElement(mapping);
        fireRegistryChanged();
        return mapping;
    }

    public void removeNameMapping(NameMapping mapping) {
        removeElement(mapping);
        fireRegistryChanged();
    }

    public String map(String name) {
        for (Iterator it = getNameMappings().iterator(); it.hasNext();) {
            NameMapping mapping = (NameMapping) it.next();
            if (mapping.isWholeWords() && mapping.getPattern().equals(name)) {
                    return mapping.getReplaceBy();
            }
        }
        for (Iterator it = getNameMappings().iterator(); it.hasNext();) {
            NameMapping mapping = (NameMapping) it.next();
            if (!mapping.isWholeWords()) {
                final String newName = mapping.map(name);
                if (!name.equals(newName)) {
                	return newName;
                }
            }
        }
        return name;
    }

    public synchronized void addListener(NameMappingRegistryListener listener) {
        if (listener != null) {
            myListeners.add(listener);
        }
    }

    public synchronized void removeListener(NameMappingRegistryListener listener) {
        if (listener != null) {
            myListeners.remove(listener);
        }
    }
    
    public void fireRegistryChanged() {
// Suppressing the calls during filling this registry on a construction time        
        if (myListeners == null) {
            return;
        }
        NameMappingRegistryListener[] listeners;
        synchronized (this) {
            listeners = (NameMappingRegistryListener[]) myListeners
                    .toArray(new NameMappingRegistryListener[myListeners
                            .size()]);
        }
        for (int i = 0; i < listeners.length; i++) {
            listeners[i].registryChanged();
        }
    }

}
