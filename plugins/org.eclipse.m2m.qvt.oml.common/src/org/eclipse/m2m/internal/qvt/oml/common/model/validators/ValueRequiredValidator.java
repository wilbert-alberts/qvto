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
package org.eclipse.m2m.internal.qvt.oml.common.model.validators;

import org.eclipse.m2m.internal.qvt.oml.common.Messages;
import org.eclipse.m2m.internal.qvt.oml.common.model.ValidatableFeature;

public class ValueRequiredValidator extends Validator {

    private ValidatableFeature myFeature;
    private String myNoValueMessage = Messages.ValueRequiredValidator_Value_is_to_be_set;

    public ValueRequiredValidator(ValidatableFeature feature, String noValueMessage) {
        this(feature);
        myNoValueMessage = noValueMessage;
    }
    
    public ValueRequiredValidator(ValidatableFeature feature) {
        super(feature);
        myFeature = feature;
    }
    
    @Override
    protected boolean doValidate() {
        if (!myFeature.isSet()) {
            setErrorMessage(myNoValueMessage);
            return false;
        }
        return true;
    }
    
}
