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


public class RootRegistryElement extends RegistryElementImpl implements RegistryElement {
    
    private static final String ROOT_TYPE = "root"; //$NON-NLS-1$
    
    RootRegistryElement() {
        super(ROOT_TYPE);
    }

}
