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
package org.eclipse.m2m.qvt.oml.library;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.m2m.qvt.oml.ocl.emf.transformations.Library;


/*
 * TODO - remove this class and use shared registry instance
 * for both QVT modules, libraries
 */
public class QvtLibraryRegistry {
    private QvtLibraryRegistry() {
    }
    
    public static QvtLibraryRegistry getInstance() {
        return ourInstance;
    }
    
    public Library getQvtLibrary(String id) {
/*
    	QvtCompiledTransformation transformation = QvtTransformationRegistry.getInstance().getTransformationById(id);
        if(transformation == null) {
            return null;
        }
*/        
        return null; //new QvtLibraryImpl(transformation);
    }
    
    public Collection<Library> getLibraries() {
        return Collections.emptyList();
    }
    
    private static final QvtLibraryRegistry ourInstance = new QvtLibraryRegistry();
}
