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
package org.eclipse.m2m.qvt.oml.project;

import java.net.URL;

import org.eclipse.m2m.qvt.oml.common.ui.PluginImages;


public class QVTProjectPluginImages extends PluginImages {
    private QVTProjectPluginImages() {
        super(BASE_URL);
    }
    
    public static QVTProjectPluginImages getInstance() {
        return ourInstance;
    }
    
    public static final String NEW_WIZARD = "new_wizard";     //$NON-NLS-1$
    public static final String COMPOSITE_COMPILED_TRANSFORMATION = "composite_compiled_transformation";     //$NON-NLS-1$

    public static final String CU_NAMESPACE = "cu_namespace";     //$NON-NLS-1$    
    public static final String SRC_CONTAINER = "src_container";     //$NON-NLS-1$    
    public static final String UNB0UND_QVT_CU = "unbound_qvt_cu";     //$NON-NLS-1$    

    @Override
	protected void declareImages() {
        declareRegistryImage(NEW_WIZARD, "icons/pr-MDA_wizard.gif"); //$NON-NLS-1$
        declareRegistryImage(COMPOSITE_COMPILED_TRANSFORMATION, "icons/composite-compiled-transformation.gif"); //$NON-NLS-1$
        declareRegistryImage(CU_NAMESPACE, "icons/cu_namespace.gif"); //$NON-NLS-1$        
        declareRegistryImage(UNB0UND_QVT_CU, "icons/unbound_qvt_cu.gif"); //$NON-NLS-1$        
        declareRegistryImage(SRC_CONTAINER, "icons/src_container.gif"); //$NON-NLS-1$        
    }

    private final static URL BASE_URL = QVTProjectPlugin.getDefault().getBundle().getEntry("/"); //$NON-NLS-1$
    private final static QVTProjectPluginImages ourInstance = new QVTProjectPluginImages(); 
}
