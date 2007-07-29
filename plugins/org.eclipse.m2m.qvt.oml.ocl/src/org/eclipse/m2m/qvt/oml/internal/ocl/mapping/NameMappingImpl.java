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
 * Created on Apr 7, 2005
 */
package org.eclipse.m2m.qvt.oml.internal.ocl.mapping;

import org.eclipse.m2m.qvt.oml.ocl.mapping.NameMapping;
import org.eclipse.m2m.qvt.oml.ocl.mapping.NameMappingRegistry;
import org.eclipse.m2m.qvt.oml.ocl.preferences.RegistryElementImpl;

public class NameMappingImpl extends RegistryElementImpl implements NameMapping {

    private String myPattern;

    private String myReplaceBy;

    private boolean myWholeWords;

    private String myRegexpPattern;

    private NameMappingRegistry myRegistry;

    public NameMappingImpl(NameMappingRegistry registry) {
        super(NameMappingsFactory.NAME_MAPPING_TYPE);
        myRegistry = registry;
    }

    public String getPattern() {
        return myPattern;
    }

    public void setPattern(String pattern) {
        myPattern = pattern;
        myRegexpPattern = null;
        notifyChanges();
    }

    private String getRegexpPattern() {
        if (myRegexpPattern == null) {
            myRegexpPattern = "[" + getPattern() + "]"; //$NON-NLS-1$ //$NON-NLS-2$
        }
        return myRegexpPattern;
    }

    public String getReplaceBy() {
        return myReplaceBy;
    }

    public void setReplaceBy(String replaceBy) {
        myReplaceBy = replaceBy;
        notifyChanges();
    }

    public boolean isWholeWords() {
        return myWholeWords;
    }

    public void setWholeWords(boolean regexp) {
        myWholeWords = regexp;
        notifyChanges();
    }

    public String map(String name) {
        if (isWholeWords()) {
            if (getPattern().equals(name)) {
                return getReplaceBy();
            }
            return name;
        }
        return name.replaceAll(getRegexpPattern(), getReplaceBy());
    }

    private void notifyChanges() {
        if (myRegistry != null) {
            myRegistry.fireRegistryChanged();
        }
    }

}
