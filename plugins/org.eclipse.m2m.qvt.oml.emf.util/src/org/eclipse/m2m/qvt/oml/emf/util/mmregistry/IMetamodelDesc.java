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
package org.eclipse.m2m.qvt.oml.emf.util.mmregistry;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EPackage;

/**
 * @author pkobiakov 
 */
public interface IMetamodelDesc {
	/** @return nsUri for EMF */
	String getId();
	
	/** @return null for runtime metamodels */
    String getNamespace();

    /**
     * Returns metamodel package represented by this descriptor.
     * <p>
     * If the metamodel fails to load, metamodel package object will
     * be added according to the <code>NULL object pattern</code>, having 
     * only matching <code>nsURI</code> but empty content. Corresponding error 
     * condition will be indicated by the descriptor {@link #getLoadStatus()}.
     * 
     * @return EPackage object
     * 
     * @see #getLoadStatus()  
     */
    EPackage getModel();
    
    /**
     * Indicates the loading status of model represented by this descriptor.
     * <p>
     * Note: If metamodel is not loaded already, a call to this method forces it to be loaded.
     * 
     * @return the status object, which is <code>OK</code> if metamodel package has been loaded successfully.
     * 
     * @see #getModel()
     */
    IStatus getLoadStatus();
    
    /**
     * Indicates whether the metamodel for this descriptor has already been loaded.
     * 
     * @return <true>If the metamodel was loaded by a previous call {@link #getModel()}}, <code>false</code> owtherwise.  
     */
    boolean isLoaded();
}
