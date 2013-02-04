/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.emf.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class ModelContent {
	
	public ModelContent(List<EObject> content) {
		myContent = new ArrayList<EObject>(content);
	}
	
	public List<EObject> getContent() {
		return Collections.unmodifiableList(myContent);
	}
	
	public ModelContent getResolvedContent(EObject metamodel) {
		List<EObject> resolvedObjs = new ArrayList<EObject>(myContent.size());
		for (EObject obj : myContent) {
			resolvedObjs.add(EmfUtil.resolveSource(obj, metamodel));
		}
		return new ModelContent(resolvedObjs);
	}
	
	public ResourceSet getResourceSet() {
		for (EObject obj : myContent) {
			if (obj.eResource() != null && obj.eResource().getResourceSet() != null) {
				return obj.eResource().getResourceSet();
			}
		}
		return null;
	}

	private final List<EObject> myContent;
}
