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

import java.util.HashSet;
import java.util.Set;



/**
 * A validator is a way for reuse validation code for several features
 *  
 * @author abreslav
 *
 */
public abstract class Validator implements ValidatableFeature.ChangeListener {
    
    /**
     * @param features
     *          the features this validator is dependent on.
     *          It's considered that it validates all these features as a single set
     */
    public Validator(ValidatableFeature... features) {
        for (ValidatableFeature feature : features) {
            if (feature != null) {
                myFeatures.add(feature);
                feature.addValidator(this);
            }
        }
    }
    
    /**
     * If the value of some feature has changed since the last validation, validation is performed
     */
    public final boolean validate() {
        if (myChangedFeatures.size() == 0) {
            return myLastResult;
        }
        setErrorMessage(null);
        boolean result = doValidate();
        myChangedFeatures.clear();
        myLastResult = result;
        return result;
    }
    
    public String getErrorMessage() {
        return myErrorMessage;
    }
    
    public void setErrorMessage(String errorMessage) {
        myErrorMessage = errorMessage;
    }
    
    public void changePerformed(ValidatableFeature feature) {
        myChangedFeatures.add(feature);
    }

    /**
     * Override this to handle validation 
     */
    protected abstract boolean doValidate();

    private Set<ValidatableFeature> myFeatures = new HashSet<ValidatableFeature>();
    private boolean myLastResult;
    private String myErrorMessage;
    private Set<ValidatableFeature> myChangedFeatures = new HashSet<ValidatableFeature>();    
}
