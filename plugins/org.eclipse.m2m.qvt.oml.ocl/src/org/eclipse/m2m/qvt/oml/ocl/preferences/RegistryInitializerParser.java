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

import java.util.Iterator;
import java.util.Stack;

import org.eclipse.m2m.qvt.oml.ocl.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class RegistryInitializerParser extends DefaultHandler {

    private ElementsFactory myFactory;
    private RootRegistryElement myRootElement;
    private RegistryElementsStack myStack = new RegistryElementsStack();

    public RegistryInitializerParser(ElementsFactory factory, RootRegistryElement element) {
        myFactory = factory;
        myRootElement = element;
    }

    @Override
	public void startDocument() throws SAXException {
    }

    @Override
	public void endDocument() throws SAXException {
    }

    @Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
        myStack.pop();
    }

    @Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        boolean isRootElement = false;
        if (myStack.isEmpty()) {
            isRootElement = true;
            if (myRootElement.getType().equals(qName)) {
// Do not create new root element if root XML tag has the same name as root element type
                myRootElement.clear();
                myStack.push(myRootElement);
                return;
            }
        }
        RegistryElement newElement = createRegistryElement(qName, attributes);
        if (newElement != null) {
            myStack.push(isRootElement ? addRootElement(newElement) : addElement(newElement));
        } else {
            myStack.pushIncorrect();
        }
    }
    
    private RegistryElement addElement(RegistryElement newElement) {
        if (!myStack.isIncorrectOnTop()) {
            myStack.peek().addElement(newElement);
        }
        return newElement;
    }

    private RegistryElement addRootElement(RegistryElement newElement) {
        for (Iterator it = myRootElement.getSubElements(newElement.getType()).iterator(); it.hasNext();) {
            RegistryElement nextObject = (RegistryElement) it.next();
            if (newElement.equals(nextObject)) {
                nextObject.clear();
                return nextObject;
            }
        }
        myRootElement.addElement(newElement);
        return newElement;
    }

    private RegistryElement createRegistryElement(String qName, Attributes attributes) {
        if (myFactory.isTypeSupported(qName)) {
            RegistryElement newElement = myFactory.loadElement(qName, attributes);
            if (newElement == null) {
                Logger.getLogger().log(Logger.SEVERE, "Was not able to create element with type: " + qName); //$NON-NLS-1$
                myStack.pushIncorrect();
            }
            return newElement;
        } else {
            Logger.getLogger().log(Logger.SEVERE, "Skipping unsupported XML tag: " + qName); //$NON-NLS-1$
            myStack.pushIncorrect();
        }
        return null;
    }
    
    
    private static class RegistryElementsStack {
        
        private static final Object INCORRECT = new Object();
        
        private Stack<Object> myStack = new Stack<Object>();
        
        public void push(RegistryElement element) {
            myStack.push(element);
        }
        
        public Object pop() {
            return myStack.pop();
        }
        
        public RegistryElement peek() {
            Object result = myStack.peek();
            if (result instanceof RegistryElement) {
                return (RegistryElement) result;
            }
            Logger.getLogger().log(Logger.SEVERE, "Trying to peek RegistryElement while another one is on top"); //$NON-NLS-1$
            return null;
        }
        
        public void pushIncorrect() {
            myStack.push(INCORRECT);
        }
        
        public boolean isIncorrectOnTop() {
            return myStack.peek() == INCORRECT;
        }
        
        public boolean isEmpty() {
            return myStack.isEmpty();
        }
    }

}
