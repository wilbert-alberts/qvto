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
 * Created on May 13, 2005
 */
package org.eclipse.m2m.qvt.oml.ocl.nativeOperations;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;


public class ReflectionBasedNativeExtensionTemplate extends
        ReflectionBasedNativeExtension {

    private static final String ATTR_RETURN_TYPE_DEDUCER = "returnTypeDeducer"; //$NON-NLS-1$

    private static final String ELEMENT_TEMPLETE_PARAMETER = "templateParameter"; //$NON-NLS-1$
    
    private static final String ATTR_PARAMETER_TYPE_DEDUCER = "parameterTypeDeducer"; //$NON-NLS-1$

    public ReflectionBasedNativeExtensionTemplate(IConfigurationElement config) {
        super(config);
        getParameterTypes().clear();
        IConfigurationElement[] parameters = config
                .getChildren(ELEMENT_TEMPLETE_PARAMETER);
        for (int i = 0; i < parameters.length; i++) {
            getParameterTypes().add(parameters[i].getAttribute(ATTR_TYPE));
        }
        setReturnTypeCkeck(true);
    }

	public List getParameterTypeDeducers() {
		return Collections.emptyList();
	}


}
