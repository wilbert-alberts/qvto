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
package org.eclipse.m2m.qvt.oml.ui;

import java.net.URL;

import org.eclipse.m2m.qvt.oml.common.ui.PluginImages;

public class QvtPluginImages extends PluginImages {
    private QvtPluginImages() {
        super(BASE_URL);
        declareImages();
    }
    
    public static final String NEW_WIZARD = "new_wizard"; //$NON-NLS-1$
    public static final String SIMPLE_VARIABLE = "simple_variable"; //$NON-NLS-1$
    public static final String ATTRIBUTE_VARIABLE = "attribute_variable"; //$NON-NLS-1$
    public static final String REFERENCE_VARIABLE = "reference_variable"; //$NON-NLS-1$
    public static final String COLLECTION_ENTRY_VARIABLE = "collection_entry_variable"; //$NON-NLS-1$
    public static final String QVT_LIBRARY = "qvt_library"; //$NON-NLS-1$
    public static final String METAMODEL = "metamodel"; //$NON-NLS-1$
    public static final String METHOD = "cat-method"; //$NON-NLS-1$
    public static final String TEMPLATE = "cat-template"; //$NON-NLS-1$
    public static final String MAPPING = "qvt-mapping"; //$NON-NLS-1$
    public static final String QUERY = "qvt-query"; //$NON-NLS-1$

    public static QvtPluginImages getInstance() {
        return ourInstance;
    }
    
    @Override
	protected void declareImages() {
        declareRegistryImage(NEW_WIZARD, "icons/pr-Model_to_model_wizard.gif"); //$NON-NLS-1$
        declareRegistryImage(SIMPLE_VARIABLE, "icons/cat-variable.gif"); //$NON-NLS-1$
        declareRegistryImage(ATTRIBUTE_VARIABLE, "icons/EAttribute.gif"); //$NON-NLS-1$
        declareRegistryImage(REFERENCE_VARIABLE, "icons/EReference.gif"); //$NON-NLS-1$        
        declareRegistryImage(COLLECTION_ENTRY_VARIABLE, "icons/cat-coll-entry.gif"); //$NON-NLS-1$
        declareRegistryImage(QVT_LIBRARY, "icons/qvt-library.gif"); //$NON-NLS-1$
        declareRegistryImage(METAMODEL, "icons/metamodel.gif"); //$NON-NLS-1$
        declareRegistryImage(METHOD, "icons/cat-method.gif"); //$NON-NLS-1$   
        declareRegistryImage(TEMPLATE, "icons/template_obj.gif"); //$NON-NLS-1$
        declareRegistryImage(MAPPING, "icons/qvt-mapping.gif"); //$NON-NLS-1$
        declareRegistryImage(QUERY, "icons/qvt-query.gif"); //$NON-NLS-1$
    }
    
    private final static URL BASE_URL = QVTUIPlugin.getDefault().getBundle().getEntry("/"); //$NON-NLS-1$
    
    private static final QvtPluginImages ourInstance = new QvtPluginImages();
}
