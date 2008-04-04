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
package org.eclipse.m2m.internal.qvt.oml.library;

import java.util.Map;

public class QvtConfiguration implements IConfiguration {
    
    public QvtConfiguration(Map<String, String> props) {
        myProperties = props;        
    }
    
    public String getProperty(String name) {
        return myProperties.get(name);
    }
    
    private final Map<String, String> myProperties;
}
