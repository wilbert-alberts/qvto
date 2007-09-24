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

package org.eclipse.m2m.qvt.oml.ast.environment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author sboyko
 *
 */
public class ModelParameterExtent {
	
	public ModelParameterExtent(List<EPackage> metamodels) {
		this(null, metamodels);
	}

	public ModelParameterExtent(EObject initialEObj, List<EPackage> metamodels) {
		myInitialEObject = initialEObj;
		myMetamodels = metamodels;
	}
	
	public void addObject(EObject eObject) {
		myAdditionalEObjects.add(eObject);
	}
	
	public EObject getInitialObject() {
		return myInitialEObject;
	}
	
	public List<EPackage> getMetamodels() {
		return myMetamodels;
	}

	public List<Object> getAllObjects() {
		List<Object> objects = new ArrayList<Object>();
		if (myInitialEObject != null) {
			objects.add(myInitialEObject);
			TreeIterator<Object> iterContents = EcoreUtil.getAllProperContents(myInitialEObject, false);
			while (iterContents.hasNext()) {
				objects.add(iterContents.next());
			}
		}
		objects.addAll(myAdditionalEObjects);
		return objects;
	}

	public Resource getModelExtent(ResourceSet outResourceSet) {
		Resource extent = null;
		if (myInitialEObject != null) {
			extent = myInitialEObject.eResource();
		}
		if (extent == null) {
			extent = outResourceSet.createResource(URI.createURI("/")); //$NON-NLS-1$
			if (myInitialEObject != null) {
				extent.getContents().add(myInitialEObject);
			}
		}
		for (EObject eObj : myAdditionalEObjects) {
			if(eObj.eContainer() == null) {
				extent.getContents().add(eObj);
			}
		}
		return extent;
	}

	public List<EObject> getEObjectsInExtent() {
		return Collections.unmodifiableList(myAdditionalEObjects);
	}
	
	@Override
	public String toString() {
		return myInitialEObject != null ? myInitialEObject.toString() : super.toString();
	}
	
	private final EObject myInitialEObject;
	private final List<EPackage> myMetamodels;
	private final List<EObject> myAdditionalEObjects = new ArrayList<EObject>(1);
	
}
