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
package org.eclipse.m2m.internal.qvt.oml.common.model;


public abstract class ValidatableAdapter implements Validatable {
    private String myErrorMessage;
    private String myMessage; 
    
    public String getErrorMessage() {
        return myErrorMessage;
    }
    
    public void setErrorMessage(String errorMessage) {
        myErrorMessage = errorMessage;
    }
    
    public String getMessage() {
        return myMessage;
    }
    
    public void setMessage(String message) {
        myMessage = message;
    }
}
