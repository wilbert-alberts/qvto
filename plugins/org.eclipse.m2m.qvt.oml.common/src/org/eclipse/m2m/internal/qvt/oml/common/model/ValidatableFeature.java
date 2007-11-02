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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



/**
 * A feature is an object that contains a value and serves to validate it 
 * @author abreslav
 *
 */
public abstract class ValidatableFeature extends ValidatableAdapter {

    public interface ChangeListener {
        void changePerformed(ValidatableFeature feature);
    }

    public void addValidator(Validator v) {
        myValidators.add(v);
    }
    
    /**
     * Call all the validators on this feature sequentially
     */
    public boolean validate() {
        setErrorMessage(null);
        for (Validator validator : myValidators) {
            if (!validator.validate()) {
                setErrorMessage(validator.getErrorMessage());
                return false;
            }
        }
        return true;
    }

    public void addChangeListener(ChangeListener listener) {
        myListeners.add(listener);
    }

    public void removeChangeListener(ChangeListener listener) {
        myListeners.remove(listener);
    }
    
    /**
     * Silent flag is used to switch off change notifications.
     * If it's true, notifyListeners() will notify validators only. 
     */
    public boolean isSilent() {
        return mySilent;
    }
    
    public void setSilent(boolean silent) {
        mySilent = silent;
    }
    
    protected void notifyListeners() {
        for (Validator validator : myValidators) {
            validator.changePerformed(this);
        }
        
        if (!isSilent()) {
            for (ChangeListener listener : myListeners) {
                listener.changePerformed(this);
            }
        }
    }

   /**
    * @return whether the feature is considered to be set or not
    */
   public abstract boolean isSet();

    private final List<Validator> myValidators = new ArrayList<Validator>();
    private boolean mySilent;
    private final Set<ChangeListener> myListeners = new LinkedHashSet<ChangeListener>(); 
    
}
