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

import org.eclipse.m2m.qvt.oml.ocl.Logger;
import org.eclipse.m2m.qvt.oml.ocl.mapping.NameMapping;
import org.eclipse.m2m.qvt.oml.ocl.mapping.NameMappingRegistry;
import org.eclipse.m2m.qvt.oml.ocl.preferences.ElementsFactory;
import org.eclipse.m2m.qvt.oml.ocl.preferences.Registry;
import org.eclipse.m2m.qvt.oml.ocl.preferences.RegistryElement;
import org.osgi.service.prefs.Preferences;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;


public class NameMappingsFactory implements ElementsFactory {
    
    public static final String NAME_MAPPING_TYPE = "nameMapping"; //$NON-NLS-1$
    public static final String[] SUPPORTED_TYPES = new String[] {NAME_MAPPING_TYPE};
    public static final String DEFAULT_PREFIX = "_"; //$NON-NLS-1$
    
    private static final String KEY_PATTERN = "pattern"; //$NON-NLS-1$
    private static final String KEY_REPLACEBY = "replaceBy"; //$NON-NLS-1$
    private static final String KEY_WHOLE_WORDS = "wholeWords"; //$NON-NLS-1$
    private NameMappingRegistry myRegistry;

    public String[] getSupportedTypes() {
        return SUPPORTED_TYPES;
    }

    public boolean isTypeSupported(String type) {
        return NAME_MAPPING_TYPE.equals(type);
    }

    public RegistryElement createElement(String type) {
        return new NameMappingImpl(myRegistry);
    }

    public RegistryElement loadElement(String type, Preferences preferences,
            int storageIndex) {
        String pattern = preferences.get(KEY_PATTERN, null);
        String replaceBy = preferences.get(KEY_REPLACEBY, null);
        if (pattern == null || replaceBy == null) {
            Logger.getLogger().log(
                    Logger.SEVERE,
                    "Storage error: " + KEY_PATTERN + " or " + KEY_REPLACEBY //$NON-NLS-1$ //$NON-NLS-2$
                            + " was not stored: " + KEY_PATTERN + " = " + pattern //$NON-NLS-1$ //$NON-NLS-2$
                            + ", " + KEY_REPLACEBY + " = " + replaceBy); //$NON-NLS-1$ //$NON-NLS-2$
            return null;
        }
        boolean wholeWords = preferences.getBoolean(KEY_WHOLE_WORDS, false);
        NameMapping mapping = new NameMappingImpl(myRegistry);
        mapping.setPattern(pattern);
        mapping.setReplaceBy(replaceBy);
        mapping.setWholeWords(wholeWords);
        return mapping;
    }

    public void saveElement(RegistryElement nextElement,
            Preferences preferences, int storageIndex) {
        NameMapping mapping = (NameMapping) nextElement;
        preferences.put(KEY_PATTERN, mapping.getPattern());
        preferences.put(KEY_REPLACEBY, mapping.getReplaceBy());
        preferences.putBoolean(KEY_WHOLE_WORDS, mapping.isWholeWords());
    }

    public RegistryElement loadElement(String type, Attributes attributes) {
        String pattern = attributes.getValue(KEY_PATTERN);
        if (pattern == null) {
            Logger.getLogger().log(Logger.SEVERE,
                    "Unable to load " + KEY_PATTERN + " = " + pattern); //$NON-NLS-1$ //$NON-NLS-2$
        }
        String replaceBy = attributes.getValue(KEY_REPLACEBY);
        if (replaceBy == null) {
            replaceBy = DEFAULT_PREFIX + pattern;
        }
        String wholeWords = attributes.getValue(KEY_WHOLE_WORDS);
        NameMapping namedElement = new NameMappingImpl(myRegistry);
        namedElement.setPattern(pattern);
        namedElement.setReplaceBy(replaceBy);
        namedElement.setWholeWords(wholeWords == null ? false : !Boolean.FALSE.toString().equals(wholeWords));
        return namedElement;
    }

    public Element saveElement(Node parent, RegistryElement nextElement) {
        NameMapping mapping = (NameMapping) nextElement;
        Element element = parent.getOwnerDocument().createElement(
                nextElement.getType());
        parent.appendChild(element);
        element.setAttribute(KEY_PATTERN, mapping.getPattern());
        element.setAttribute(KEY_REPLACEBY, mapping.getReplaceBy());
        element.setAttribute(KEY_WHOLE_WORDS, Boolean.valueOf(
                mapping.isWholeWords()).toString());
        return element;
    }

    public void setRegistry(Registry registry) {
        if (registry instanceof NameMappingRegistry) {
            myRegistry = (NameMappingRegistry) registry;
        }
    }

}
