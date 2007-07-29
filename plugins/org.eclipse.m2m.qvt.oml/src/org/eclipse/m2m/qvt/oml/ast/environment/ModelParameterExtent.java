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
	
	public ModelParameterExtent() {
		this(null);
	}

	public ModelParameterExtent(EPackage pack) {
		myMetamodel = pack;
	}
	
	public void addObject(EObject eObject) {
		myEObjects.add(eObject);
	}

	public List<Object> getAllObjects() {
		List<Object> objects = new ArrayList<Object>();
		if (myMetamodel != null) {
			objects.add(myMetamodel);
			TreeIterator<Object> iterContents = EcoreUtil.getAllProperContents(myMetamodel, false);
			while (iterContents.hasNext()) {
				objects.add(iterContents.next());
			}
		}
		objects.addAll(myEObjects);
		return objects;
	}

	public Resource getModelExtent(ResourceSet outResourceSet) {
		Resource extent = null;
		if (myMetamodel != null) {
			extent = myMetamodel.eResource();
		}
		if (extent == null) {
			extent = outResourceSet.createResource(URI.createURI("/")); //$NON-NLS-1$
			if (myMetamodel != null) {
				extent.getContents().add(myMetamodel);
			}
		}
		for (EObject eObj : myEObjects) {
			extent.getContents().add(eObj);
		}
		return extent;
	}
	
	private final EPackage myMetamodel;
	private final List<EObject> myEObjects = new ArrayList<EObject>(1);
	
}
