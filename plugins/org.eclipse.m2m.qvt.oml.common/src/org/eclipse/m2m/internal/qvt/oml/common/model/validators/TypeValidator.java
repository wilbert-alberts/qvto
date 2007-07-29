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

import org.eclipse.m2m.internal.qvt.oml.common.model.ObjectFeature;

public class TypeValidator extends Validator {

    private ObjectFeature<?> myFeature;
    private String myWrongTypeMessage;
    private Class<?> myType;

    public TypeValidator(ObjectFeature<?> feature, Class<?> type, String wrongTypeMessage) {
        super(feature);
        myFeature = feature;
        myWrongTypeMessage = wrongTypeMessage;
        myType = type;
    }
    
    @Override
    protected boolean doValidate() {
        if (!myType.isInstance(myFeature.getValue())) {
            setErrorMessage(myWrongTypeMessage);
            return false;
        }
        return true;
    }

}
