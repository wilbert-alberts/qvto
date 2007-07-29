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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.m2m.internal.qvt.oml.common.model.validators.Validator;


/**
 * A model is considered to be a set of features with validators for their values.
 * @author abreslav
 *
 */
public abstract class ValidatableModel implements Validatable, ValidatableFeature.ChangeListener {
    
    /**
     * Call this in constructor to add features to model
     */
    protected final void addFeatures(ValidatableFeature... features) {
        myFeatures.addAll(Arrays.asList(features));
        for (ValidatableFeature feature : features) {
            feature.addChangeListener(this);
        }
    }
    
    /**
     * Call this in constructor to add validators
     */
    protected final void addValidators(Validator... valuidators) {
        for (Validator validator : valuidators) {
            myValidators.add(validator);
        }
    }
    
    public List<ValidatableFeature> getFeatures() {
        return Collections.<ValidatableFeature>unmodifiableList(myFeatures);
    }
    
    /**
     * Validates the whole model
     */
    public boolean validate() {
        for (ValidatableFeature f : myFeatures) {
            if (!f.validate()) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * First erroneous feature's message
     */
    public String getErrorMessage() {
        for (ValidatableFeature f : myFeatures) {
            String errorMessage = f.getErrorMessage();
            if (errorMessage != null) {
                return errorMessage;
            }
        }
        return null;
    }
    
    public final void changePerformed(ValidatableFeature feature) {
        handleFeatureChanged(feature);          
    }
    
    /**
     * Behave like all the features have been changed
     */
    public void allFeaturesChanged() {
        for (ValidatableFeature feature : myFeatures) {
            feature.notifyListeners();
        }
    }

    /**
     * Override this to update values of some features when some other features change
     * @return true if change is handled and false otherwise
     */
    protected boolean handleFeatureChanged(ValidatableFeature feature) {
        return false;
    }

    private List<ValidatableFeature> myFeatures = new ArrayList<ValidatableFeature>();
    private List<Validator> myValidators = new ArrayList<Validator>();    
}
