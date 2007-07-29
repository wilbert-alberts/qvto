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

import java.text.MessageFormat;
import java.util.Collection;

import org.eclipse.m2m.internal.qvt.oml.common.Messages;
import org.eclipse.m2m.internal.qvt.oml.common.model.ManyObjectFeature;



public class MultiplicityValidator extends Validator {

    public static final int UNBOUND = -1;
    
    public enum Bound {
        UPPER,
        LOWER;
    }
    
    private int myLowerBound;
    private int myUpperBound;
    private ManyObjectFeature<Collection<?>> myFeature;
    private String myLowerBoundMessage = Messages.MultiplicityValidator_0;
    private String myUpperBoundMessage = Messages.MultiplicityValidator_1;

    public MultiplicityValidator(ManyObjectFeature<Collection<?>> feature, int lowerBound, int upperBound) {
        super(feature);
        myFeature = feature;
        myLowerBound = lowerBound;
        myUpperBound = upperBound;
    }
    
    public MultiplicityValidator(ManyObjectFeature<Collection<?>> feature, int lowerBound, int upperBound, String lowerBoundMessage, String upperBoundMessage) {
        this(feature, lowerBound, upperBound);
        myLowerBoundMessage = lowerBoundMessage;
        myUpperBoundMessage = upperBoundMessage;
    }
    
    @Override
    protected boolean doValidate() {
        int size = myFeature.getValue().size();
        if (getLowerBound() > size) {
            setErrorMessage(MessageFormat.format(myLowerBoundMessage, getLowerBound(), size));
            return false;
        }
        if (getUpperBound() != UNBOUND) {
            if (getUpperBound() < size) {
                setErrorMessage(MessageFormat.format(myUpperBoundMessage, getUpperBound(), size));
                return false;
            }
        }
        return true;
    }

    public int getLowerBound() {
        return myLowerBound;
    }
    
    public int getUpperBound() {
        return myUpperBound;
    }

    public String getLowerBoundMessage() {
        return myLowerBoundMessage;
    }

    public String getUpperBoundMessage() {
        return myUpperBoundMessage;
    }

    public void setLowerBoundMessage(String lowerBoundMessage) {
        myLowerBoundMessage = lowerBoundMessage;
    }

    public void setUpperBoundMessage(String upperBoundMessage) {
        myUpperBoundMessage = upperBoundMessage;
    }

}
