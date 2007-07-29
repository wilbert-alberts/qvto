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

import org.osgi.service.prefs.Preferences;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;

public interface ElementsFactory {
    
    String[] getSupportedTypes();
    
    boolean isTypeSupported(String type);
    
    RegistryElement createElement(String type);
    
    RegistryElement loadElement(String type, Preferences preferences, int storageIndex);
    
    void saveElement(RegistryElement nextElement, Preferences preferences, int storageIndex);
    
    Element saveElement(Node parent, RegistryElement nextElement);
    
    RegistryElement loadElement(String type, Attributes attributes);
    
    void setRegistry(Registry registry);
    
}
