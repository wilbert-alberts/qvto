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
 * Created on May 12, 2005
 */
package org.eclipse.m2m.qvt.oml.ocl.nativeOperations;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.m2m.qvt.oml.ocl.Logger;


public class NativeExtensionConfigurationReader {
    private static final String OPERATION_TAG_NAME = "operation"; //$NON-NLS-1$
    private static final String OPERATION_TEMPLATE_TAG_NAME = "operationTemplate"; //$NON-NLS-1$

    private final Collection<ReflectionBasedNativeExtension> myNativeExtensions;
    private final Collection<ReflectionBasedNativeExtensionTemplate> myOperationTemplates;

    public NativeExtensionConfigurationReader(IConfigurationElement[] configurations) {
        OperationsAndTemplates pair = loadConfigurations(configurations);
        myNativeExtensions = pair.extensions;
        myOperationTemplates = pair.temaplates;
    }

    public void defineNativeOperations() {
    }

    private static class OperationsAndTemplates {
    	Collection<ReflectionBasedNativeExtension> extensions;
    	Collection<ReflectionBasedNativeExtensionTemplate> temaplates;
    	
    	public OperationsAndTemplates(Collection<ReflectionBasedNativeExtension> extensions, Collection<ReflectionBasedNativeExtensionTemplate> templates) {
    		this.extensions = extensions;
    		this.temaplates = templates;
    	}
    }
    
    private static OperationsAndTemplates loadConfigurations(IConfigurationElement[] configurations) {
    	OperationsAndTemplates pair = new OperationsAndTemplates(new LinkedList<ReflectionBasedNativeExtension>(), new LinkedList<ReflectionBasedNativeExtensionTemplate>());
        for (int i = 0; i < configurations.length; i++) {
            if (OPERATION_TAG_NAME.equals(configurations[i].getName())) {
                pair.extensions.add(new ReflectionBasedNativeExtension(configurations[i]));
            } 
            else if (OPERATION_TEMPLATE_TAG_NAME.equals(configurations[i].getName())) {
                pair.temaplates.add(new ReflectionBasedNativeExtensionTemplate(configurations[i]));
            } 
            else {
                Logger.getLogger().log(Logger.WARNING,
                        "Incorrect configuration specified as a native extension: only " //$NON-NLS-1$
                                + OPERATION_TAG_NAME + " and " //$NON-NLS-1$
                                + OPERATION_TEMPLATE_TAG_NAME + " supported"); //$NON-NLS-1$
            }
        }
        
        return pair;
    }

    private Collection getNativeExtensions() {
        return myNativeExtensions;
    }

    private Collection getOperationTemplates() {
        return myOperationTemplates;
    }
}
