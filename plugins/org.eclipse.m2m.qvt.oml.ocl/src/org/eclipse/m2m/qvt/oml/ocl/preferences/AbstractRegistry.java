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
 * Created on Mar 30, 2005
 */
package org.eclipse.m2m.qvt.oml.ocl.preferences;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IExportedPreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.m2m.qvt.oml.ocl.Logger;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public abstract class AbstractRegistry implements Registry {
    
    private static final String PREF_NUMBER_OF_TYPE_PREFIX = "numberOf_"; //$NON-NLS-1$
    
    private Preferences myPreferences;
    private ElementsFactory myFactory;
    private RootRegistryElement myRootElement = new RootRegistryElement();
    private String myPresetFileName;
    private String myPreferencesPath;
    
    /**
     * use: bundleName+"/"+registryName
     */
    public AbstractRegistry(String preferencesPath, ElementsFactory factory, String presetFileName) {
        myFactory = factory;
        myFactory.setRegistry(this);
        myPresetFileName = presetFileName;
        myPreferencesPath = preferencesPath;
        IEclipsePreferences rootNode = Platform.getPreferencesService().getRootNode();
        boolean initialized = false;
        try {
            initialized = rootNode.node(InstanceScope.SCOPE).nodeExists(preferencesPath);
        } catch (BackingStoreException e) {
            Logger.getLogger().log(Logger.SEVERE, 
                    "Unable to determine initialized state for registry due to BackingStoreException", e); //$NON-NLS-1$
        }
        myPreferences = rootNode.node(InstanceScope.SCOPE).node(myPreferencesPath);
        if (!initialized) {
            Logger.getLogger().log(Logger.INFO, "Loading predefined audits into the preferences"); //$NON-NLS-1$
            loadDefaults();
            internalStore();
        } else {
            load();
        }
    }
    
    public String getPreferencesPath() {
    	return myPreferencesPath;
    }
    
    public void exportPreferences(OutputStream out) {
        if (myPreferences instanceof IEclipsePreferences) {
            try {
                Platform.getPreferencesService().exportPreferences(
                        (IEclipsePreferences) myPreferences, out, null);
            } catch (CoreException e) {
                Logger.getLogger().log(Logger.SEVERE,
                        "Error on exporting preferences", e); //$NON-NLS-1$
            }
        } else {
            Logger.getLogger().log(
                    Logger.SEVERE,
                    "Preferences will not be exported - " //$NON-NLS-1$
                            + "no instance of IEclipsePreferences received"); //$NON-NLS-1$
        }
    }
    
    public void exportPreferences(Document document) {
        Element rootElement = document.createElement("root"); //$NON-NLS-1$
        document.appendChild(rootElement);
        storeSupportedElements(rootElement, myRootElement);
    }
    
    public void importPreferences(InputStream is) {
        try {
//        	if it fails nothing will be removed
        	IExportedPreferences preferences = Platform.getPreferencesService().readPreferences(is);
			
            myPreferences.removeNode();
            Platform.getPreferencesService().applyPreferences(preferences);
            IEclipsePreferences rootNode = Platform.getPreferencesService().getRootNode();
            myPreferences = rootNode.node(InstanceScope.SCOPE).node(myPreferencesPath);
        } catch (CoreException e) {
            Logger.getLogger().log(Logger.SEVERE,
                    "Preferences was not imported due to exception", e); //$NON-NLS-1$
        } catch (BackingStoreException e) {
            Logger.getLogger().log(Logger.SEVERE,
                    "Unable to remove existing preference node", e); //$NON-NLS-1$
        }
        load();
    }
    
    public final void load() {
        myRootElement.clear();
        loadSupportedElements(myPreferences, myRootElement);
    }
    
    private void loadSupportedElements(Preferences node, RegistryElement parentElement) {
        String[] supportedTypes = myFactory.getSupportedTypes();
        for (int i = 0; i < supportedTypes.length; i++) {
            Collection<RegistryElement> elementsOfNextType = loadElementType(node, supportedTypes[i]);
            parentElement.getSubElements(supportedTypes[i]).addAll(elementsOfNextType);
        }
    }

    private Collection<RegistryElement> loadElementType(Preferences prefrences, String type) {
        int elementsNumber = prefrences.getInt(getNumberOfProperty(type), 0);
        Collection<RegistryElement> elements = new LinkedList<RegistryElement>();
        for (int i = 0; i < elementsNumber; i++) {
            Preferences nextNode = prefrences.node(getNodeName(type, i));
            RegistryElement nextElement = myFactory.loadElement(type, nextNode, i);
            if (nextElement != null) {
                elements.add(nextElement);
                loadSupportedElements(nextNode, nextElement);
            } else {
                Logger.getLogger().log(Logger.SEVERE, "Was not able to load elements with type: " + type); //$NON-NLS-1$
            }
        }
        return elements;
    }

    public void store() {
        internalStore();
    }
    
    private void internalStore() {
        String absolutePath = myPreferences.absolutePath();
        try {
            myPreferences.removeNode();
        } catch (BackingStoreException e) {
            Logger.getLogger().log(Logger.SEVERE, 
                    "Unable to store registry contents due to the storage error", e); //$NON-NLS-1$
            myPreferences = Platform.getPreferencesService().getRootNode().node(absolutePath);
            return;
        }
        myPreferences = Platform.getPreferencesService().getRootNode().node(absolutePath);
        storeSupportedElements(myPreferences, myRootElement);
        try {
            myPreferences.flush();
        } catch (BackingStoreException e) {
            Logger.getLogger().log(Logger.SEVERE, "Exception on flushing preferences: ", e); //$NON-NLS-1$
        }
    }
    
    private void storeSupportedElements(Preferences node, RegistryElement parentElement) {
        String[] supportedTypes = myFactory.getSupportedTypes();
        for (int i = 0; i < supportedTypes.length; i++) {
            storeElementType(node, parentElement.getSubElements(supportedTypes[i]), supportedTypes[i]);
        }
    }

    private void storeElementType(Preferences preferences, Collection subElements, String type) {
        if(!subElements.isEmpty()) {
	    	preferences.putInt(getNumberOfProperty(type), subElements.size());
	        int index = 0;
	        for (Iterator it = subElements.iterator(); it.hasNext(); index++) {
	            Preferences nextNode = preferences.node(getNodeName(type, index));
	            RegistryElement nextElement = (RegistryElement) it.next();
	            myFactory.saveElement(nextElement, nextNode, index);
	            storeSupportedElements(nextNode, nextElement);
	        }
        }
    }
    
    private void storeSupportedElements(Node parent, RegistryElement parentElement) {
        String[] supportedTypes = myFactory.getSupportedTypes();
        for (int i = 0; i < supportedTypes.length; i++) {
            storeElementType(parent, parentElement.getSubElements(supportedTypes[i]), supportedTypes[i]);
        }
    }
    
    private void storeElementType(Node parent, Collection subElements, String type) {
        for (Iterator it = subElements.iterator(); it.hasNext();) {
            RegistryElement nextElement = (RegistryElement) it.next();
            Element element = myFactory.saveElement(parent, nextElement);
            storeSupportedElements(element, nextElement);
        }
    }


    public final void loadDefaults() {
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            DefaultHandler parser = createDefaultsHandler();
            saxParser.parse(createDefaultsXmlInputStream(), parser);
        } catch (ParserConfigurationException e) {
            Logger.getLogger().log(Logger.SEVERE, 
                    "Unable to parse defaults XML file " + //$NON-NLS-1$
                    " due to XML parser configuration exception", e); //$NON-NLS-1$
        } catch (SAXException e) {
            Logger.getLogger().log(Logger.SEVERE, 
                    "Unable to parse defaults XML file " + //$NON-NLS-1$
                    " due to SAX exception", e); //$NON-NLS-1$
        } catch (IOException e) {
            Logger.getLogger().log(Logger.SEVERE, 
                    "Unable to parse defaults XML file " + //$NON-NLS-1$
                    " due to IO exception", e); //$NON-NLS-1$
        }
    }
    
    public RegistryElement createElement(String type) {
        if (!myFactory.isTypeSupported(type)) {
            Logger.getLogger().log(Logger.SEVERE, "Specified type is not supported: " + type); //$NON-NLS-1$
            return null;
        }
        RegistryElement result = myFactory.createElement(type);
        if (result == null) {
            Logger.getLogger().log(Logger.SEVERE, "Unable to create element of type: " + type); //$NON-NLS-1$
            return null;
        }
        return result;
    }
    
    public void addElement(RegistryElement element) {
        if (element == null) {
            Logger.getLogger().log(Logger.SEVERE, "Unable to add element - null specified instead"); //$NON-NLS-1$
            return;
        }
        if (element.getType() == null) {
            Logger.getLogger().log(Logger.SEVERE, "Unable to add element with null type"); //$NON-NLS-1$
            return;
        }
        if (!myFactory.isTypeSupported(element.getType())) {
            Logger.getLogger().log(Logger.SEVERE, "Unable to add element of unsupported type: " + element.getType()); //$NON-NLS-1$
            return;
        }
        myRootElement.addElement(element);
    }
    
    public void removeElement(RegistryElement element) {
        if (element == null) {
            Logger.getLogger().log(Logger.SEVERE, "Unable to remove element - null specified instead"); //$NON-NLS-1$
            return;
        }
        if (element.getType() == null) {
            Logger.getLogger().log(Logger.SEVERE, "Unable to remove element with null type"); //$NON-NLS-1$
            return;
        }
        if (!myFactory.isTypeSupported(element.getType())) {
            Logger.getLogger().log(Logger.SEVERE, "Unable to remove element of unsupported type: " + element.getType()); //$NON-NLS-1$
            return;
        }
        myRootElement.removeElement(element);
    }
    
    public Collection getElements(String type) {
        if (type == null) {
            Logger.getLogger().log(Logger.SEVERE, "Unable to get elements by type - null specified"); //$NON-NLS-1$
            return Collections.EMPTY_LIST;
        }
        if (!myFactory.isTypeSupported(type)) {
            Logger.getLogger().log(Logger.SEVERE, "Unable to get elements of unsupported type:" + type); //$NON-NLS-1$
            return Collections.EMPTY_LIST;
        }
        return myRootElement.getSubElements(type);
    }
    
    private InputStream createDefaultsXmlInputStream() {
        return getClass().getResourceAsStream(myPresetFileName);
    }
    
    protected DefaultHandler createDefaultsHandler() {
        return new RegistryInitializerParser(myFactory, myRootElement);
    }
    
    private static String getNumberOfProperty(String type) {
        return PREF_NUMBER_OF_TYPE_PREFIX + type;
    }
    
    private static String getNodeName(String type, int number) {
        return type + number;
    }
    
}
