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
		this(Collections.<EObject>emptyList(), metamodels);
	}

	public ModelParameterExtent(List<EObject> initialEObjs, List<EPackage> metamodels) {
		myInitialEObjects.addAll(initialEObjs);
		myMetamodels = metamodels;
	}
	
	public ModelParameterExtent(EObject initialEObj) {
		myInitialEObjects.add(initialEObj);
    	EObject rootContainer = initialEObj != null ? EcoreUtil.getRootContainer(initialEObj.eClass()) : null;
		myMetamodels = rootContainer instanceof EPackage ?
				Collections.singletonList((EPackage) rootContainer) : Collections.<EPackage>emptyList();
	}
	
	public void addObject(EObject eObject) {
		if (eObject != null) {
			myAdditionalEObjects.add(eObject);
		}
	}
	
	public List<EObject> getInitialObjects() {
		return myInitialEObjects;
	}
	
	public List<EPackage> getMetamodels() {
		return myMetamodels;
	}

	public List<EObject> getRootObjects() {
		List<EObject> objects = new ArrayList<EObject>();
		objects.addAll(myInitialEObjects);
		for (EObject eObj : myAdditionalEObjects) {
			if (eObj.eContainer() == null) {
				objects.add(eObj);
			}
		}
		return objects;
	}

	public List<Object> getAllObjects() {
		List<Object> objects = new ArrayList<Object>();
		objects.addAll(myInitialEObjects);
		for (EObject rootEobj : myInitialEObjects) {
			TreeIterator<Object> iterContents = EcoreUtil.getAllProperContents(rootEobj, false);
			while (iterContents.hasNext()) {
				objects.add(iterContents.next());
			}
		}
		objects.addAll(myAdditionalEObjects);
		return objects;
	}

	public Resource getModelExtent(ResourceSet outResourceSet) {
		Resource extent = null;
		if (!myInitialEObjects.isEmpty()) {
			extent = myInitialEObjects.get(0).eResource();
		}
		if (extent == null) {
			extent = createResource(outResourceSet);
			extent.getContents().addAll(myInitialEObjects);
		}
		for (EObject eObj : myAdditionalEObjects) {
			if (eObj.eContainer() == null) {
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
		return myInitialEObjects.isEmpty() ? super.toString() : myInitialEObjects.toString();
	}
	
	private Resource createResource(ResourceSet outResourceSet) {
		if (myMetamodels.isEmpty()) {
			return outResourceSet.createResource(URI.createURI("/")); //$NON-NLS-1$;
		}
		
		String mmName = myMetamodels.get(0).getName();
		URI extentURI = URI.createURI("extent." + mmName); //$NON-NLS-1$;
		Object possibleFactory = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(mmName);
		Resource.Factory factory = null;
		if (possibleFactory instanceof Resource.Factory) {
			factory = (Resource.Factory) possibleFactory;
		}
		if (possibleFactory instanceof Resource.Factory.Descriptor) {
			factory = ((Resource.Factory.Descriptor) possibleFactory).createFactory();
		}
		if (factory == null) {
			return outResourceSet.createResource(extentURI);
		}
		return factory.createResource(extentURI);
	}

	private final List<EObject> myInitialEObjects = new ArrayList<EObject>(1);
	private final List<EObject> myAdditionalEObjects = new ArrayList<EObject>(1);
	private final List<EPackage> myMetamodels;
	
}
